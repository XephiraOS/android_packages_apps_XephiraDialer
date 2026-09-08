package com.customize.contacts.cleaner;

import G7.c;
import H7.b;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.vcard.VCardEntry;
import com.android.contacts.model.Account;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.customize.contacts.backupandrestore.plugin.helper.VCardEntryCreator;
import com.customize.contacts.util.E;
import com.google.common.collect.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: RawDataVerifier.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Account f20877a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f20878b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f20879c;

    static {
        Account account = new Account(R0.a.f3165a, R0.a.f3166b);
        f20877a = account;
        f20878b = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", account.f16941a).appendQueryParameter("account_type", account.f16942b).build();
        f20879c = ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter("operator_reason", "raw_error_data_items_clean").build();
    }

    public static void a(List<Long> list, List<Long> list2) {
        if (list2 != null && !list2.isEmpty()) {
            list.addAll(list2);
        }
    }

    public static boolean b(Context context, boolean z10) {
        E.d(context);
        List<Long> d10 = d(context, z10);
        boolean z11 = false;
        if (d10.isEmpty()) {
            b.b("RawDataVerifier", "deleteDuplicatedDataItems: no raw contacts, ignore.");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = n.j(d10, 50).iterator();
        while (it.hasNext()) {
            List<Long> e10 = e(context, "_id IN " + G7.a.d((List) it.next()));
            if (!e10.isEmpty()) {
                arrayList.addAll(e10);
            }
        }
        boolean z12 = true;
        if (!arrayList.isEmpty()) {
            List<List> j10 = n.j(arrayList, VibrateUtils.STRENGTH_OFFSET);
            ArrayList arrayList2 = new ArrayList();
            for (List list : j10) {
                ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(f20879c);
                newDelete.withSelection("_id IN " + G7.a.d(list), null);
                arrayList2.add(newDelete.build());
            }
            if (arrayList2.size() > 400) {
                for (List list2 : n.j(arrayList2, VibrateUtils.STRENGTH_OFFSET)) {
                    if (c.a(context.getContentResolver(), "com.android.contacts", new ArrayList(list2)) == null) {
                        z12 = false;
                    }
                    b.b("RawDataVerifier", "deleteDuplicatedDataItems: batch: " + list2.size() + ", success: " + z12);
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException unused) {
                        b.c("RawDataVerifier", "deleteDuplicatedDataItems sleep Interrupted.");
                    }
                }
            } else {
                if (c.a(context.getContentResolver(), "com.android.contacts", arrayList2) != null) {
                    z11 = true;
                }
                z12 = z11;
            }
            b.b("RawDataVerifier", "deleteDuplicatedDataItems: size: " + arrayList.size() + ", allOps size: " + arrayList2.size() + ", success: " + z12);
            A.i("raw_error_data_items_clean", String.valueOf(arrayList.size()));
        }
        return z12;
    }

    public static List<Long> c(List<? extends VCardEntry.a> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            for (VCardEntry.a aVar : list) {
                if (aVar.e() || !hashSet.add(aVar)) {
                    arrayList.add(Long.valueOf(aVar.d()));
                }
            }
            return arrayList;
        }
        return null;
    }

    public static List<Long> d(Context context, boolean z10) {
        String str;
        if (z10) {
            str = "deleted=0 AND sourceid IS NOT NULL AND dirty=0";
        } else {
            str = "deleted=0 AND sourceid IS NULL";
        }
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = context.getContentResolver().query(f20878b, new String[]{BreenoCallContract.BaseColumns._ID}, str2, null, BreenoCallContract.BaseColumns._ID);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        arrayList.add(Long.valueOf(query.getLong(0)));
                    } finally {
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            b.c("RawDataVerifier", "getRawIds: Exception: " + e10);
        }
        return arrayList;
    }

    public static List<Long> e(Context context, String str) {
        return f(VCardEntryCreator.getVCardEntries(context, f20877a, str, "_id ASC"));
    }

    public static List<Long> f(List<VCardEntry> list) {
        ArrayList arrayList = new ArrayList();
        for (VCardEntry vCardEntry : list) {
            a(arrayList, c(vCardEntry.W()));
            a(arrayList, c(vCardEntry.O()));
            a(arrayList, c(vCardEntry.V()));
            a(arrayList, c(vCardEntry.Q()));
            a(arrayList, c(vCardEntry.T()));
            a(arrayList, c(vCardEntry.U()));
            a(arrayList, c(vCardEntry.Y()));
            a(arrayList, c(vCardEntry.c0()));
            a(arrayList, c(vCardEntry.L()));
            a(arrayList, c(vCardEntry.b0()));
            a(arrayList, c(vCardEntry.a0()));
        }
        return arrayList;
    }
}
