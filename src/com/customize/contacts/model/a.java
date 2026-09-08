package com.customize.contacts.model;

import android.content.ContentProviderOperation;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.model.Account;
import com.android.contacts.model.EntityDelta;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ContactsEntity.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f21730a;

    /* renamed from: b, reason: collision with root package name */
    public static ArrayList<ContentProviderOperation> f21731b = new ArrayList<>();

    public static boolean a(Context context, ArrayList<ContentProviderOperation> arrayList) {
        try {
            context.getContentResolver().applyBatch("com.android.contacts", arrayList);
            return true;
        } catch (OperationApplicationException e10) {
            H7.b.c("ContactsEntity", "OperationApplicationException e = " + e10);
            return false;
        } catch (RemoteException e11) {
            H7.b.c("ContactsEntity", "RemoteException e = " + e11);
            return false;
        } catch (Exception e12) {
            H7.b.c("ContactsEntity", "Exception e = " + e12);
            return false;
        }
    }

    public static ArrayList<ContentProviderOperation> b(String str, ArrayList<EntityDelta.ValuesDelta> arrayList, int i10) {
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        ContentValues contentValues = new ContentValues();
        int size = arrayList.size();
        for (int i11 = 0; i11 != size; i11++) {
            contentValues.clear();
            contentValues = arrayList.get(i11).A();
            if (contentValues.containsKey("mimetype_id")) {
                contentValues.remove("mimetype_id");
            }
            if (contentValues.containsKey("raw_contact_id")) {
                contentValues.remove("raw_contact_id");
            }
            if (contentValues.containsKey("data_version")) {
                contentValues.remove("data_version");
            }
            if (contentValues.containsKey("data1")) {
                contentValues.remove("group_sourceid");
            }
            if (contentValues.containsKey("account_writable")) {
                contentValues.remove("account_writable");
            }
            if (contentValues.containsKey("account_name")) {
                contentValues.remove("account_name");
            }
            contentValues.put("mimetype", str);
            ContentProviderOperation.Builder i12 = EntityDelta.ValuesDelta.m(contentValues).i(ContactsContract.Data.CONTENT_URI);
            if (i12 != null) {
                i12.withValueBackReference("raw_contact_id", i10);
                arrayList2.add(i12.build());
            }
        }
        return arrayList2;
    }

    public static boolean c(Account account, ArrayList<ContentProviderOperation> arrayList, int i10, String str, String str2, String str3, String str4) {
        arrayList.add(ContentProviderOperation.newInsert(R0.d.a(ContactsContract.RawContacts.CONTENT_URI)).withValue("account_name", account.f16941a).withValue("account_type", account.f16942b).build());
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI)).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/name").withValue("data1", str).build());
        }
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI)).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", str2).withValue("data2", 2).build());
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI)).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", str3).withValue("data2", 3).build());
        }
        if (!TextUtils.isEmpty(str4)) {
            arrayList.add(ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI)).withValueBackReference("raw_contact_id", i10).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", str4).withValue("data2", 1).build());
        }
        return true;
    }

    public static boolean d(Context context, EntityDelta entityDelta, Account account, ArrayList<ContentProviderOperation> arrayList, int i10, long j10) {
        ContentValues contentValues;
        long j11;
        if (entityDelta == null) {
            return false;
        }
        EntityDelta.ValuesDelta N10 = entityDelta.N();
        if (N10 != null) {
            contentValues = N10.A();
        } else {
            contentValues = null;
        }
        if (contentValues != null && contentValues.containsKey("starred")) {
            j11 = contentValues.getAsLong("starred").longValue();
            if (H7.a.b()) {
                H7.b.b("ContactsEntity", "before.containsKey starred " + j11);
            }
        } else {
            j11 = 0;
        }
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.RawContacts.CONTENT_URI));
        newInsert.withValue("account_name", account.f16941a);
        newInsert.withValue("account_type", account.f16942b);
        String str = entityDelta.f16975c;
        if (str != null) {
            newInsert.withValue("custom_ringtone", str);
        }
        String str2 = entityDelta.f16976d;
        if (str2 != null) {
            newInsert.withValue("custom_vibration", str2);
        }
        if (TextUtils.equals(account.f16942b, "com.android.oplus.sim")) {
            if (H7.a.b()) {
                H7.b.b("ContactsEntity", "buildRawContactInsertOperationList: simIndex = " + j10);
            }
            newInsert.withValue(com.customize.contacts.simcontacts.b.f21805a, Long.valueOf(j10));
            newInsert.withValue("aggregation_mode", 3);
        }
        newInsert.withValue("starred", Long.valueOf(j11));
        arrayList.add(newInsert.build());
        for (Map.Entry<String, ArrayList<EntityDelta.ValuesDelta>> entry : entityDelta.x().entrySet()) {
            ArrayList<ContentProviderOperation> b10 = b(entry.getKey(), entry.getValue(), i10);
            if (b10 != null && b10.size() > 0) {
                arrayList.addAll(b10);
            }
        }
        return true;
    }

    public static void e(Context context) {
        if (f21731b.size() > 0) {
            if (H7.a.b()) {
                H7.b.b("ContactsEntity", "ContactsEntity->checkRecordsUnwrite: some records unwrite to db, we write it now!");
            }
            a(context, f21731b);
            f();
        }
    }

    public static void f() {
        f21731b.clear();
        f21730a = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0021, code lost:
    
        if (com.customize.contacts.model.a.f21731b.size() > 470) goto L6;
     */
    /* JADX WARN: Type inference failed for: r8v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean g(android.content.Context r7, com.android.contacts.model.Account r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int[] r13) {
        /*
            java.util.ArrayList<android.content.ContentProviderOperation> r1 = com.customize.contacts.model.a.f21731b
            int r2 = r1.size()
            r0 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            boolean r8 = c(r0, r1, r2, r3, r4, r5, r6)
            int r9 = com.customize.contacts.model.a.f21730a
            r10 = 1
            int r9 = r9 + r10
            com.customize.contacts.model.a.f21730a = r9
            r11 = 80
            if (r9 == r11) goto L23
            java.util.ArrayList<android.content.ContentProviderOperation> r9 = com.customize.contacts.model.a.f21731b
            int r9 = r9.size()
            r11 = 470(0x1d6, float:6.59E-43)
            if (r9 <= r11) goto L4e
        L23:
            boolean r8 = H7.a.b()
            if (r8 == 0) goto L45
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "applyBatchWithOperations: sOperationList size="
            r8.append(r9)
            java.util.ArrayList<android.content.ContentProviderOperation> r9 = com.customize.contacts.model.a.f21731b
            int r9 = r9.size()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "ContactsEntity"
            H7.b.b(r9, r8)
        L45:
            java.util.ArrayList<android.content.ContentProviderOperation> r8 = com.customize.contacts.model.a.f21731b
            boolean r8 = a(r7, r8)
            f()
        L4e:
            if (r8 == 0) goto L52
            r7 = r10
            goto L53
        L52:
            r7 = -1
        L53:
            r9 = 0
            r13[r9] = r7
            int r7 = r13.length
            r9 = 2
            if (r7 < r9) goto L5c
            r13[r10] = r8
        L5c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.model.a.g(android.content.Context, com.android.contacts.model.Account, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int[]):boolean");
    }

    public static boolean h(Context context, long j10, Account account, Account account2, boolean z10, int[] iArr) {
        return i(context, j10, account, account2, z10, iArr, -1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static boolean i(Context context, long j10, Account account, Account account2, boolean z10, int[] iArr, long j11) {
        char c10;
        EntityDelta k10 = k(context, j10);
        if (k10 == null) {
            H7.b.b("ContactsEntity", "buildRawContactInsertOperationList entity is null, rawId = " + j10);
            return true;
        }
        j(k10, account, account2, context, j10);
        ArrayList<ContentProviderOperation> arrayList = f21731b;
        boolean d10 = d(context, k10, account2, arrayList, arrayList.size(), j11);
        if (d10 && z10) {
            f21731b.add(ContentProviderOperation.newDelete(ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, j10)).build());
        }
        int i10 = f21730a + 1;
        f21730a = i10;
        ?? r12 = d10;
        if (i10 == 5) {
            boolean a10 = a(context, f21731b);
            f();
            r12 = a10;
        }
        if (r12 != 0) {
            c10 = 1;
        } else {
            c10 = 65535;
        }
        iArr[0] = c10;
        if (iArr.length >= 2) {
            iArr[1] = r12;
        }
        if (H7.a.b()) {
            H7.b.b("ContactsEntity", "copyRawContact success: " + ((boolean) r12));
        }
        return r12;
    }

    public static void j(EntityDelta entityDelta, Account account, Account account2, Context context, long j10) {
        if (entityDelta == null) {
            return;
        }
        if (!l(account, account2)) {
            entityDelta.x().remove("vnd.android.cursor.item/group_membership");
        }
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"custom_ringtone", "custom_vibration"}, "_id = " + j10, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        entityDelta.f16975c = string;
                        entityDelta.f16976d = string2;
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("ContactsEntity", "dealEntityDelta e: " + e10);
        }
    }

    public static EntityDelta k(Context context, long j10) {
        EntitySet h10 = EntitySet.h(context.getContentResolver(), "_id = " + j10, null, null);
        if (h10 == null || h10.size() == 0) {
            return null;
        }
        return h10.get(0);
    }

    public static boolean l(Account account, Account account2) {
        if ((account != null && account.equals(account2) && ((M3.c.t(account) && M3.c.s(account2)) || (M3.c.s(account) && M3.c.t(account2)))) || (account != null && M3.c.s(account) && M3.c.r(account2))) {
            return true;
        }
        return false;
    }
}
