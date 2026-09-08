package N3;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.ArraySet;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.model.Account;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0811w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: GroupHelper.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static ArraySet<String> f2302a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f2303b = {BreenoCallContract.BaseColumns._ID, "title"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f2304c = {BreenoCallContract.BaseColumns._ID, "account_name", "account_type"};

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<Account, Long> f2305d = null;

    public static ContentProviderResult[] a(Context context, Collection<Long> collection, long j10) {
        if (context == null || collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        for (Long l10 : collection) {
            if (l10 != null) {
                ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
                newInsert.withValue("data1", Long.valueOf(j10));
                newInsert.withValue("mimetype", "vnd.android.cursor.item/group_membership");
                newInsert.withValue("raw_contact_id", l10);
                arrayList.add(newInsert.build());
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        try {
            return context.getContentResolver().applyBatch("com.android.contacts", arrayList);
        } catch (OperationApplicationException e10) {
            H7.b.c("GroupHelper", "Exception e: " + e10);
            return null;
        } catch (RemoteException e11) {
            H7.b.c("GroupHelper", "Exception e: " + e11);
            return null;
        } catch (Exception e12) {
            H7.b.c("GroupHelper", "Exception e: " + e12);
            return null;
        }
    }

    public static void b(Context context, long j10, boolean z10, ArrayList<String> arrayList) {
        ArraySet<String> k10;
        long j11;
        if (context == null) {
            return;
        }
        HashMap<Long, ArrayList<IdRecord>> o10 = o(context.getContentResolver(), Long.toString(j10), M3.c.f(context, false, false, false), 1);
        if (o10 != null && !o10.isEmpty()) {
            ArrayList<IdRecord> arrayList2 = o10.get(Long.valueOf(j10));
            if (C0811w.g(arrayList2)) {
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>();
            Iterator<IdRecord> it = arrayList2.iterator();
            while (it.hasNext()) {
                IdRecord next = it.next();
                if (next != null) {
                    ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
                    Account d10 = next.d();
                    if (!hashMap.isEmpty() && hashMap.containsKey(d10)) {
                        j11 = ((Long) hashMap.get(d10)).longValue();
                    } else {
                        j11 = j(context, "Vip in ColorOS", d10);
                    }
                    if (j11 == -1) {
                        j11 = h(context, d10);
                    }
                    HashMap<Account, Long> hashMap2 = f2305d;
                    if (hashMap2 != null) {
                        hashMap2.put(d10, Long.valueOf(j11));
                    }
                    hashMap.put(d10, Long.valueOf(j11));
                    newInsert.withValue("data1", Long.valueOf(j11));
                    newInsert.withValue("mimetype", "vnd.android.cursor.item/group_membership");
                    newInsert.withValue("raw_contact_id", Long.valueOf(next.i()));
                    arrayList3.add(newInsert.build());
                }
            }
            if (!C0811w.g(arrayList3)) {
                try {
                    context.getContentResolver().applyBatch("com.android.contacts", arrayList3);
                } catch (RemoteException e10) {
                    H7.b.c("GroupHelper", "addToVipGroupByContactId(), exception happen " + e10);
                } catch (Exception e11) {
                    H7.b.c("GroupHelper", "addToVipGroupByContactId(), exception happen " + e11);
                }
            }
            Intent intent = new Intent("com.oplus.contacts.HANDLE_VIP_FINISHED");
            intent.putStringArrayListExtra("number_list_key", arrayList);
            if (z10 && (k10 = k()) != null && k10.size() > 0 && BlackListUtils.l(context, k10)) {
                intent.putExtra("vip_remove_blacklist_tips", true);
            }
            X.a.b(context).d(intent);
        }
    }

    public static ArrayList<ContentProviderOperation> c(Context context, List<Long> list, long j10) {
        if (j10 < 0 || list == null || C0811w.g(list)) {
            return null;
        }
        ArrayList<ContentProviderOperation> arrayList = null;
        for (Long l10 : list) {
            if (l10 != null) {
                String format = String.format(Locale.US, "mimetype='vnd.android.cursor.item/group_membership' AND raw_contact_id= %d  AND data1= %d", l10, Long.valueOf(j10));
                if (H7.a.b()) {
                    H7.b.b("GroupHelper", "buildMoveoutGroupOperation(), where = " + format);
                }
                ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
                newDelete.withSelection(format, null);
                ContentProviderOperation build = newDelete.build();
                if (build != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>(list.size());
                    }
                    arrayList.add(build);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<ContentProviderOperation> d(Context context, ArrayList<IdRecord> arrayList, HashMap<Account, Long> hashMap) {
        long j10;
        if (hashMap == null || hashMap.isEmpty() || C0811w.g(arrayList)) {
            return null;
        }
        Iterator<IdRecord> it = arrayList.iterator();
        ArrayList<ContentProviderOperation> arrayList2 = null;
        while (it.hasNext()) {
            IdRecord next = it.next();
            if (next != null) {
                long i10 = next.i();
                Account d10 = next.d();
                if (d10 != null && hashMap.get(d10) != null) {
                    j10 = hashMap.get(d10).longValue();
                } else {
                    j10 = -1;
                }
                if (i10 != -1 && j10 != -1) {
                    String format = String.format(Locale.US, "mimetype='vnd.android.cursor.item/group_membership' AND raw_contact_id= %d  AND data1= %d", Long.valueOf(i10), Long.valueOf(j10));
                    ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
                    newDelete.withSelection(format, null);
                    ContentProviderOperation build = newDelete.build();
                    if (H7.a.b()) {
                        H7.b.b("GroupHelper", "buildMoveoutGroupOperation(), where = " + format);
                    }
                    if (build != null) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>(arrayList.size());
                        }
                        arrayList2.add(build);
                    }
                }
            }
        }
        return arrayList2;
    }

    public static ArrayList<ContentProviderOperation> e(Activity activity, String str, String str2) {
        Cursor query;
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        Cursor cursor = null;
        try {
            try {
                query = activity.getContentResolver().query(ContactsContract.Data.CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID, "data1", "data4"}, "mimetype='vnd.android.cursor.item/organization' AND contact_id in (" + str + ")", null, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
        }
        try {
            int columnIndex = query.getColumnIndex(BreenoCallContract.BaseColumns._ID);
            int columnIndex2 = query.getColumnIndex("data4");
            query.moveToPosition(-1);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            while (query.moveToNext()) {
                if (TextUtils.isEmpty(query.getString(columnIndex2))) {
                    sb2.append(",");
                    sb2.append(query.getString(columnIndex));
                } else {
                    sb.append(",");
                    sb.append(query.getString(columnIndex));
                }
            }
            if (sb.length() > 0) {
                ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI);
                newUpdate.withValue("data1", null).withSelection("_id IN (" + sb.substring(1).toString() + ")", null);
                arrayList.add(newUpdate.build());
            }
            if (sb2.length() > 0) {
                ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
                newDelete.withSelection("_id IN (" + sb2.substring(1).toString() + ")", null);
                arrayList.add(newDelete.build());
            }
            query.close();
        } catch (Exception e11) {
            e = e11;
            cursor = query;
            H7.b.c("GroupHelper", "doRemoveCompany error" + e);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList;
    }

    public static void f() {
        ArraySet<String> arraySet = f2302a;
        if (arraySet != null) {
            arraySet.clear();
            f2302a = null;
        }
    }

    public static int g(Context context, Account account) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", "Business Card in ColorOS");
        contentValues.put("account_name", account.f16941a);
        contentValues.put("account_type", account.f16942b);
        Uri d10 = G7.c.d(context.getContentResolver(), R0.d.a(ContactsContract.Groups.CONTENT_URI), contentValues);
        if (d10 == null) {
            return -1;
        }
        return (int) ContentUris.parseId(d10);
    }

    public static int h(Context context, Account account) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", "Vip in ColorOS");
        contentValues.put("account_name", account.f16941a);
        contentValues.put("account_type", account.f16942b);
        Uri d10 = G7.c.d(context.getContentResolver(), R0.d.a(ContactsContract.Groups.CONTENT_URI), contentValues);
        if (d10 == null) {
            return -1;
        }
        return (int) ContentUris.parseId(d10);
    }

    public static boolean i(Context context, long j10, long j11) {
        if (j10 >= 0 && j11 >= 0) {
            ArrayList<Long> n10 = n(context.getContentResolver(), j10);
            if (C0811w.g(n10)) {
                return false;
            }
            ArrayList<ContentProviderOperation> arrayList = null;
            for (Long l10 : n10) {
                if (l10 != null) {
                    ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
                    newDelete.withSelection(String.format(Locale.US, "mimetype='vnd.android.cursor.item/group_membership' AND raw_contact_id= %d  AND data1= %d", l10, Long.valueOf(j11)), null);
                    if (arrayList == null) {
                        arrayList = new ArrayList<>(n10.size());
                    }
                    ContentProviderOperation build = newDelete.build();
                    if (build != null) {
                        arrayList.add(build);
                    }
                }
            }
            if (C0811w.g(arrayList)) {
                return false;
            }
            try {
                context.getContentResolver().applyBatch("com.android.contacts", arrayList);
                if (arrayList.size() > 0) {
                    B3.c.d().h();
                    return true;
                }
            } catch (OperationApplicationException e10) {
                H7.b.c("GroupHelper", "Exception e: " + e10);
            } catch (RemoteException e11) {
                H7.b.c("GroupHelper", "Exception e: " + e11);
            } catch (Exception e12) {
                H7.b.c("GroupHelper", "Exception e: " + e12);
            }
        }
        return false;
    }

    public static long j(Context context, String str, Account account) {
        String str2;
        if (str != null && account != null) {
            String replace = str.replace("'", "''");
            if (account.d()) {
                str2 = "title='" + replace + "' AND account_name IS NULL AND account_type IS NULL AND deleted=0";
            } else {
                str2 = "title='" + replace + "' AND account_name='" + account.f16941a + "' AND account_type='" + account.f16942b + "' AND deleted=0";
            }
            try {
                Cursor query = context.getContentResolver().query(ContactsContract.Groups.CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID}, str2, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            long j10 = query.getLong(0);
                            query.close();
                            return j10;
                        }
                    } finally {
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e10) {
                H7.b.c("GroupHelper", "Exception e: " + e10);
            }
        }
        return -1L;
    }

    public static ArraySet<String> k() {
        return f2302a;
    }

    public static String[] l() {
        return f2303b;
    }

    public static boolean m(Context context, String str, Account account) {
        if (j(context, str, account) > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        if (r1 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<java.lang.Long> n(android.content.ContentResolver r8, long r9) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.net.Uri r3 = android.provider.ContactsContract.RawContacts.CONTENT_URI     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r2 = "_id"
            java.lang.String[] r4 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r2.<init>()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r5 = "contact_id="
            r2.append(r5)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r2.append(r9)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r6 = 0
            r7 = 0
            r2 = r8
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r1 == 0) goto L3f
        L28:
            boolean r8 = r1.moveToNext()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            if (r8 == 0) goto L3f
            r8 = 0
            long r8 = r1.getLong(r8)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r0.add(r8)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            goto L28
        L3b:
            r8 = move-exception
            goto L5f
        L3d:
            r8 = move-exception
            goto L45
        L3f:
            if (r1 == 0) goto L5e
        L41:
            r1.close()
            goto L5e
        L45:
            java.lang.String r9 = "GroupHelper"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3b
            r10.<init>()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r2 = ""
            r10.append(r2)     // Catch: java.lang.Throwable -> L3b
            r10.append(r8)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> L3b
            H7.b.c(r9, r8)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L5e
            goto L41
        L5e:
            return r0
        L5f:
            if (r1 == 0) goto L64
            r1.close()
        L64:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.b.n(android.content.ContentResolver, long):java.util.ArrayList");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0138, code lost:
    
        if (r13 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013a, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0157, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0154, code lost:
    
        if (r13 == null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.HashMap<java.lang.Long, java.util.ArrayList<com.customize.contacts.model.IdRecord>> o(android.content.ContentResolver r10, java.lang.String r11, java.util.ArrayList<com.android.contacts.model.Account> r12, int r13) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.b.o(android.content.ContentResolver, java.lang.String, java.util.ArrayList, int):java.util.HashMap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00dd, code lost:
    
        if (r11 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00df, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00fc, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f9, code lost:
    
        if (r11 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.HashMap<java.lang.Long, java.util.ArrayList<java.lang.Long>> p(android.content.ContentResolver r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.b.p(android.content.ContentResolver, java.lang.String, java.lang.String, java.lang.String, int):java.util.HashMap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0088, code lost:
    
        if (r3.moveToFirst() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008a, code lost:
    
        N3.b.f2305d.put(new com.android.contacts.model.Account(r3.getString(1), r3.getString(2)), java.lang.Long.valueOf(r3.getLong(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a9, code lost:
    
        if (r3.moveToNext() != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d0, code lost:
    
        if (r3 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void q(android.content.Context r12, long r13, java.util.ArrayList<java.lang.String> r15) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N3.b.q(android.content.Context, long, java.util.ArrayList):void");
    }

    public static boolean r(Context context, Collection<Long> collection, long j10) {
        if (context != null && collection != null && !collection.isEmpty()) {
            ArrayList<ContentProviderOperation> arrayList = null;
            for (Long l10 : collection) {
                if (l10 != null) {
                    ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
                    newDelete.withSelection(String.format(Locale.US, "mimetype='vnd.android.cursor.item/group_membership' AND raw_contact_id= %d  AND data1= %d", l10, Long.valueOf(j10)), null);
                    ContentProviderOperation build = newDelete.build();
                    if (arrayList == null) {
                        arrayList = new ArrayList<>(collection.size());
                    }
                    if (build != null) {
                        arrayList.add(build);
                    }
                }
            }
            if (C0811w.g(arrayList)) {
                return false;
            }
            try {
                context.getContentResolver().applyBatch("com.android.contacts", arrayList);
                if (arrayList.size() <= 0) {
                    return false;
                }
                return true;
            } catch (OperationApplicationException e10) {
                H7.b.c("GroupHelper", "Exception e: " + e10);
            } catch (RemoteException e11) {
                H7.b.c("GroupHelper", "Exception e: " + e11);
            } catch (Exception e12) {
                H7.b.c("GroupHelper", "Exception e: " + e12);
            }
        }
        return false;
    }
}
