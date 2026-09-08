package com.customize.contacts.util;

import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: FixNumberUtils.java */
/* loaded from: classes3.dex */
public class E {

    /* compiled from: FixNumberUtils.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Long f21876a;

        /* renamed from: b, reason: collision with root package name */
        public String f21877b;

        public a(Long l10, String str) {
            this.f21876a = l10;
            this.f21877b = str;
        }
    }

    public static ArrayList<com.customize.contacts.model.c> a(Context context) {
        ArrayList<com.customize.contacts.model.c> arrayList = new ArrayList<>();
        try {
            Cursor query = context.getContentResolver().query(ContentUris.withAppendedId(R0.d.f3228o, 4L), null, null, null, null);
            if (query != null) {
                try {
                    H7.b.e("FixNumberUtils", "cursor.count = " + query.getCount());
                } finally {
                }
            }
            b(query, arrayList);
            if (query != null) {
                query.close();
            }
        } catch (Throwable th) {
            H7.b.c("FixNumberUtils", " th = " + th);
        }
        return arrayList;
    }

    public static void b(Cursor cursor, ArrayList<com.customize.contacts.model.c> arrayList) {
        if (cursor != null && cursor.getCount() > 0) {
            arrayList.clear();
            cursor.moveToPosition(-1);
            HashMap hashMap = new HashMap();
            while (cursor.moveToNext()) {
                long j10 = cursor.getLong(0);
                long j11 = cursor.getLong(1);
                long j12 = cursor.getLong(2);
                String string = cursor.getString(3);
                com.customize.contacts.model.c cVar = new com.customize.contacts.model.c(j12, j11, j10, cursor.getString(4), string, true);
                if (!TextUtils.isEmpty(string) && R0.b.f3173g.matcher(string).find()) {
                    if (!hashMap.containsKey(Long.valueOf(j10))) {
                        hashMap.put(Long.valueOf(j10), cVar);
                    }
                    com.customize.contacts.model.c cVar2 = (com.customize.contacts.model.c) hashMap.get(Long.valueOf(j10));
                    if (cVar2 != null) {
                        cVar.e(cVar2.d());
                    }
                    arrayList.add(cVar);
                }
            }
            H7.b.e("FixNumberUtils", "infoList.size = " + arrayList.size());
        }
    }

    public static ArrayList<com.customize.contacts.model.c> c(Context context, ArrayList<com.customize.contacts.model.c> arrayList) {
        ContentProviderOperation.Builder newUpdate;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<com.customize.contacts.model.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.customize.contacts.model.c next = it.next();
                String b10 = next.b();
                if (b10 != null && !Pattern.matches("([0-9*#+;,N])+", b10)) {
                    Long valueOf = Long.valueOf(next.c());
                    Long valueOf2 = Long.valueOf(next.a());
                    String replaceAll = b10.replaceAll("([^0-9*#+;,N])+", "");
                    next.f(replaceAll);
                    hashMap.put(valueOf2, new a(valueOf, replaceAll));
                }
            }
            H7.b.b("FixNumberUtils", "time : " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e10) {
            H7.b.c("FixNumberUtils", "FixContactsThread query error" + e10);
        }
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        for (Map.Entry entry : hashMap.entrySet()) {
            Long l10 = (Long) entry.getKey();
            a aVar = (a) entry.getValue();
            if (TextUtils.isEmpty(aVar.f21877b)) {
                newUpdate = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
                newUpdate.withSelection("_id=" + l10, null);
                hashSet.add(aVar.f21876a);
            } else {
                newUpdate = ContentProviderOperation.newUpdate(R0.d.a(ContactsContract.Data.CONTENT_URI));
                newUpdate.withValue("data1", aVar.f21877b);
                newUpdate.withSelection("_id=" + l10, null);
                hashSet.remove(aVar.f21876a);
            }
            arrayList2.add(newUpdate.build());
            if (arrayList2.size() >= 50) {
                try {
                    context.getContentResolver().applyBatch("com.android.contacts", arrayList2);
                    arrayList2.clear();
                } catch (Exception e11) {
                    H7.b.c("FixNumberUtils", "removeInvalidChar error" + e11);
                    return null;
                }
            }
        }
        if (arrayList2.size() > 0) {
            try {
                context.getContentResolver().applyBatch("com.android.contacts", arrayList2);
            } catch (Exception e12) {
                H7.b.c("FixNumberUtils", "removeInvalidChar error" + e12);
                return null;
            }
        }
        com.android.contacts.framework.baseui.util.A.a(context, 2000313, 200030275, null, false);
        e(context, hashSet);
        return arrayList;
    }

    public static void d(Context context) {
        H7.b.e("FixNumberUtils", "removeInvalidChar -------- ");
        ArrayList<com.customize.contacts.model.c> a10 = a(context);
        if (a10.isEmpty()) {
            H7.b.e("FixNumberUtils", "removeInvalidChar: no Invalid Char ");
        } else {
            c(context, a10);
        }
    }

    public static void e(Context context, HashSet<Long> hashSet) {
        String str;
        if (hashSet.size() > 0) {
            Iterator<Long> it = hashSet.iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append(",");
                sb.append(it.next());
            }
            if (sb.length() > 1) {
                str = sb.substring(1);
            } else {
                str = "";
            }
            String str2 = " deleted=0 AND _id NOT IN (  SELECT raw_contact_id FROM data WHERE raw_contact_id IN (" + str + ") GROUP BY raw_contact_id  ) AND  _id IN (" + str + ") ";
            H7.b.b("FixNumberUtils", "delete selection : " + str2);
            try {
                context.getContentResolver().delete(ContactsContract.RawContacts.CONTENT_URI, str2, null);
            } catch (Exception e10) {
                H7.b.c("FixNumberUtils", "delete empty raw_contacts error" + e10);
            }
        }
    }
}
