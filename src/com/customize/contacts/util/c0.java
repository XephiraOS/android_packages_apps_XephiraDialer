package com.customize.contacts.util;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.Account;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import java.util.ArrayList;
import m1.AbstractC1316l;

/* compiled from: SimContactsSupport.java */
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f22054a = ContactsContract.Contacts.CONTENT_URI.buildUpon().appendPath(com.android.contacts.compat.data.f.c("contacts_and_raw")).build();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f22055b = false;

    /* renamed from: c, reason: collision with root package name */
    public static long f22056c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static String f22057d;

    /* renamed from: e, reason: collision with root package name */
    public static String f22058e;

    public static boolean a(Context context, long j10, Account account, Account account2, boolean z10, int[] iArr, boolean z11) {
        ArrayList<SimContactInfo> l10;
        int i10;
        int i11;
        Account account3 = account2;
        if (account3 == null || account3.f16941a == null) {
            if (H7.a.b()) {
                H7.b.b("SimContactsSupport", "copyPhoneContactToSimCard simAccount unavailable");
            }
            String j11 = j(context);
            if (j11 == null) {
                return false;
            }
            account3 = new Account(j11, "com.oplus.contacts.sim");
        }
        if (z11) {
            l10 = m(context, j10);
        } else {
            l10 = l(context, j10);
        }
        ArrayList<SimContactInfo> arrayList = l10;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            iArr[0] = 1;
            int K10 = b0.K(context, account3.f16941a);
            int i12 = 0;
            boolean z12 = true;
            while (true) {
                if (i12 == size) {
                    break;
                }
                SimContactInfo simContactInfo = arrayList.get(i12);
                String str = simContactInfo.f15824d;
                String str2 = simContactInfo.f15825e;
                String str3 = simContactInfo.f15827g;
                String str4 = simContactInfo.f15828h;
                if (!PhoneNumberUtils.c(str2)) {
                    i10 = i12;
                    i11 = size;
                } else {
                    i10 = i12;
                    i11 = size;
                    z12 = t(context, str, str2, str3, str4, K10, z11).f1295a.booleanValue();
                    if (!z12) {
                        H7.b.e("SimContactsSupport", "Insert Contact (number: " + H7.a.d(str2) + ") To SimCard Failed!");
                        break;
                    }
                    if (iArr.length >= 2) {
                        iArr[1] = i10 + 1;
                    }
                }
                i12 = i10 + 1;
                size = i11;
            }
            if (z12 && z10) {
                if ("com.oplus.contacts.sim".equals(account.f16942b)) {
                    h(context, j10);
                } else {
                    z12 = g(context, j10, false);
                }
                if (H7.a.b()) {
                    H7.b.b("SimContactsSupport", "Delete RawContact : " + j10 + ", result : " + z12);
                }
            }
            return z12;
        }
        if (H7.a.b()) {
            H7.b.b("SimContactsSupport", "Copy a NULL PhoneContact ToSimById.");
        }
        iArr[0] = 3;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0211, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.customize.contacts.util.C0812x b(android.content.Context r26, long r27, java.lang.String r29, int[] r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.c0.b(android.content.Context, long, java.lang.String, int[], boolean):com.customize.contacts.util.x");
    }

    public static boolean c(Context context, long j10, String str) {
        H7.b.e("SimContactsSupport", "deleteAutoSyncSimContact, contactId = " + j10);
        Cursor e10 = G7.c.e(context.getContentResolver(), ContactsContract.RawContacts.CONTENT_URI, new String[]{"account_name", "account_type", com.customize.contacts.simcontacts.b.f21805a}, "contact_id = ?", new String[]{String.valueOf(j10)}, null);
        boolean z10 = false;
        if (e10 != null && e10.moveToFirst()) {
            String string = e10.getString(0);
            String string2 = e10.getString(1);
            int i10 = e10.getInt(2);
            if (TextUtils.equals("com.android.oplus.sim", string2) && FeatureOption.k()) {
                z10 = com.customize.contacts.simcontacts.b.b(context, string, i10, j10, str);
            }
        }
        com.oplus.foundation.util.io.e.a(e10);
        return z10;
    }

    public static boolean d(Context context, long j10, boolean z10, String str) {
        return e(context, j10, z10, str);
    }

    public static boolean e(Context context, long j10, boolean z10, String str) {
        ContactListFilter e10 = AbstractC1316l.f(context).e();
        ContentResolver contentResolver = context.getContentResolver();
        if (z10 && e10.f16738b == 0) {
            int c10 = G7.c.c(contentResolver, I3.c.e(ContactsContract.RawContacts.CONTENT_URI, e10.f16740d, e10.f16739c, false, str), "contact_id = ?", new String[]{String.valueOf(j10)});
            h0.m(context, str, c10);
            if (H7.a.b()) {
                H7.b.b("SimContactsSupport", "deleteContactByAccount containsFilterAccountName count = " + c10);
            }
            if (c10 >= 1) {
                return true;
            }
            return false;
        }
        int c11 = G7.c.c(contentResolver, I3.c.e(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10), null, null, false, str), null, null);
        h0.m(context, str, c11);
        if (H7.a.b()) {
            H7.b.b("SimContactsSupport", "deleteContactByAccount count = " + c11);
        }
        if (c11 == 1) {
            return true;
        }
        return false;
    }

    public static int f(Context context, String str, String str2, boolean z10, String str3) {
        Uri e10;
        ContactListFilter e11 = AbstractC1316l.f(context).e();
        if (!z10 && e11.f16738b == 0) {
            e10 = I3.c.e(f22054a, e11.f16740d, e11.f16739c, false, str3);
        } else {
            e10 = I3.c.e(f22054a, null, null, false, str3);
        }
        try {
            int delete = context.getContentResolver().delete(e10, null, new String[]{str, str2});
            h0.m(context, str3, delete);
            return delete;
        } catch (Exception e12) {
            H7.b.b("SimContactsSupport", "delete database fail " + e12);
            return -1;
        }
    }

    public static boolean g(Context context, long j10, boolean z10) {
        Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, j10);
        if (z10) {
            withAppendedId = withAppendedId.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
        }
        if (G7.c.c(context.getContentResolver(), withAppendedId, null, null) == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047 A[Catch: Exception -> 0x0042, TRY_LEAVE, TryCatch #4 {Exception -> 0x0042, blocks: (B:9:0x0047, B:31:0x003e, B:28:0x0041, B:27:0x0039), top: B:5:0x001b, inners: #3 }] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean h(android.content.Context r9, long r10) {
        /*
            android.net.Uri r0 = R0.d.f3214a
            android.net.Uri r2 = android.content.ContentUris.withAppendedId(r0, r10)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Exception -> L4c
            java.lang.String r3 = "account_name"
            java.lang.String r4 = "account_type"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Exception -> L4c
            r5 = 0
            r6 = 0
            r4 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L4c
            if (r1 == 0) goto L44
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L44
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L37
            java.lang.String r3 = "com.oplus.contacts.sim"
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L37
            if (r2 == 0) goto L45
            java.lang.String r7 = r1.getString(r0)     // Catch: java.lang.Throwable -> L35
            goto L45
        L35:
            r3 = move-exception
            goto L39
        L37:
            r3 = move-exception
            r2 = r0
        L39:
            r1.close()     // Catch: java.lang.Throwable -> L3d
            goto L41
        L3d:
            r1 = move-exception
            r3.addSuppressed(r1)     // Catch: java.lang.Exception -> L42
        L41:
            throw r3     // Catch: java.lang.Exception -> L42
        L42:
            r1 = move-exception
            goto L4e
        L44:
            r2 = r0
        L45:
            if (r1 == 0) goto L4a
            r1.close()     // Catch: java.lang.Exception -> L42
        L4a:
            r8 = r7
            goto L65
        L4c:
            r1 = move-exception
            r2 = r0
        L4e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = ""
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "SimContactsSupport"
            H7.b.c(r3, r1)
            goto L4a
        L65:
            if (r2 == 0) goto L70
            r0 = -1
            long r6 = (long) r0
            r3 = r9
            r4 = r10
            boolean r9 = i(r3, r4, r6, r8)
            return r9
        L70:
            boolean r9 = g(r9, r10, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.c0.h(android.content.Context, long):boolean");
    }

    public static boolean i(Context context, long j10, long j11, String str) {
        if (H7.a.b()) {
            H7.b.b("SimContactsSupport", "deleteSimContact, Sim id = " + j11 + " rawId:" + j10);
        }
        if (j11 > 0) {
            if (b0.f(context, j11, str) && j10 > 0) {
                return g(context, j10, true);
            }
            H7.b.c("SimContactsSupport", "Delete A SimCard Contact Failed, Sim id = " + j11);
            return false;
        }
        if (j10 > 0) {
            return g(context, j10, true);
        }
        H7.b.c("SimContactsSupport", "Delete A SimCard Contact Failed, Sim id = " + j11);
        return false;
    }

    public static String j(Context context) {
        String r10 = r(context, 0);
        if (r10 == null) {
            return r(context, 1);
        }
        return r10;
    }

    public static long k() {
        return f22056c;
    }

    public static ArrayList<SimContactInfo> l(Context context, long j10) {
        C0804o b10 = C0804o.b(context, j10);
        ArrayList<SimContactInfo> arrayList = new ArrayList<>();
        long l10 = b10.l();
        String f10 = b10.f();
        ArrayList<String> i10 = b10.i();
        if (i10 != null && !i10.isEmpty()) {
            int size = i10.size();
            for (int i11 = 0; i11 != size; i11++) {
                String stripSeparators = android.telephony.PhoneNumberUtils.stripSeparators(i10.get(i11));
                SimContactInfo simContactInfo = new SimContactInfo();
                simContactInfo.h(f10);
                simContactInfo.i(stripSeparators);
                simContactInfo.k(l10);
                arrayList.add(simContactInfo);
            }
            return arrayList;
        }
        return null;
    }

    public static ArrayList<SimContactInfo> m(Context context, long j10) {
        int i10;
        int i11;
        C0804o b10 = C0804o.b(context, j10);
        ArrayList<SimContactInfo> arrayList = new ArrayList<>();
        long l10 = b10.l();
        String f10 = b10.f();
        ArrayList<String> i12 = b10.i();
        ArrayList<String> d10 = b10.d();
        if ((i12 != null && !i12.isEmpty()) || (d10 != null && !d10.isEmpty())) {
            if (d10 != null) {
                i10 = d10.size();
            } else {
                i10 = 0;
            }
            if (i12 != null) {
                i11 = i12.size();
            } else {
                i11 = 0;
            }
            int i13 = (i11 & 1) + (i11 / 2);
            if (i10 > i13) {
                i13 = i10;
            }
            boolean z10 = true;
            int i14 = 0;
            for (int i15 = 0; i15 != i13; i15++) {
                String str = "";
                boolean z11 = true;
                String str2 = "";
                String str3 = str2;
                while (i14 < i11 && z11) {
                    if (z10) {
                        str2 = i12.get(i14);
                    } else {
                        str3 = i12.get(i14);
                    }
                    z10 = !z10;
                    i14++;
                    if ((i14 & 1) == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                }
                if (i15 < i10) {
                    str = d10.get(i15);
                }
                SimContactInfo simContactInfo = new SimContactInfo();
                simContactInfo.h(f10);
                simContactInfo.i(str2);
                simContactInfo.k(l10);
                simContactInfo.f15827g = str3;
                simContactInfo.f15828h = str;
                arrayList.add(simContactInfo);
            }
            return arrayList;
        }
        return null;
    }

    public static ArrayList<SimContactInfo> n(Context context, int i10, long j10) {
        int i11;
        C0804o a10 = C0804o.a(context, j10);
        ArrayList<SimContactInfo> arrayList = new ArrayList<>();
        long l10 = a10.l();
        String x10 = b0.x(context, a10.f(), i10);
        ArrayList<String> i12 = a10.i();
        if (i12 != null) {
            i11 = i12.size();
        } else {
            i11 = 0;
        }
        if (i11 == 0) {
            if (TextUtils.isEmpty(x10)) {
                return null;
            }
            SimContactInfo simContactInfo = new SimContactInfo();
            simContactInfo.h(x10);
            simContactInfo.i("");
            simContactInfo.k(l10);
            arrayList.add(simContactInfo);
            return arrayList;
        }
        for (int i13 = 0; i13 != i11; i13++) {
            String stripSeparators = android.telephony.PhoneNumberUtils.stripSeparators(i12.get(i13));
            if (stripSeparators.length() > 20) {
                stripSeparators = stripSeparators.substring(0, 20);
            }
            SimContactInfo simContactInfo2 = new SimContactInfo();
            simContactInfo2.h(x10);
            simContactInfo2.i(stripSeparators);
            simContactInfo2.k(l10);
            arrayList.add(simContactInfo2);
        }
        return arrayList;
    }

    public static ArrayList<SimContactInfo> o(Context context, int i10, long j10, boolean z10, boolean z11) {
        ArrayList<String> arrayList;
        String str;
        int i11;
        int i12;
        int i13;
        String str2;
        int i14;
        ArrayList<String> arrayList2;
        C0804o a10 = C0804o.a(context, j10);
        ArrayList<SimContactInfo> arrayList3 = new ArrayList<>();
        long l10 = a10.l();
        String x10 = b0.x(context, a10.f(), i10);
        ArrayList<String> i15 = a10.i();
        ArrayList<String> d10 = a10.d();
        int size = d10 != null ? d10.size() : 0;
        int size2 = i15 != null ? i15.size() : 0;
        if (!z10) {
            ArrayList<String> arrayList4 = i15;
            int i16 = size2;
            ArrayList<String> arrayList5 = d10;
            if (z11) {
                int i17 = size > i16 ? size : i16;
                if (i17 == 0) {
                    if (TextUtils.isEmpty(x10)) {
                        return null;
                    }
                    SimContactInfo simContactInfo = new SimContactInfo();
                    simContactInfo.h(x10);
                    simContactInfo.i("");
                    simContactInfo.k(l10);
                    simContactInfo.f15828h = "";
                    arrayList3.add(simContactInfo);
                    return arrayList3;
                }
                int i18 = 0;
                while (i18 != i17) {
                    ArrayList<String> arrayList6 = arrayList4;
                    String stripSeparators = i18 < i16 ? android.telephony.PhoneNumberUtils.stripSeparators(arrayList6.get(i18)) : "";
                    int i19 = i17;
                    if (stripSeparators.length() > 20) {
                        stripSeparators = stripSeparators.substring(0, 20);
                    }
                    if (TextUtils.isEmpty(stripSeparators + x10)) {
                        break;
                    }
                    if (i18 < size) {
                        str = arrayList5.get(i18);
                        arrayList = arrayList5;
                        if (str.length() > 38) {
                            str = b0.y(38, 20, str);
                        }
                    } else {
                        arrayList = arrayList5;
                        str = "";
                    }
                    SimContactInfo simContactInfo2 = new SimContactInfo();
                    simContactInfo2.h(x10);
                    simContactInfo2.i(stripSeparators);
                    simContactInfo2.k(l10);
                    simContactInfo2.f15828h = str;
                    arrayList3.add(simContactInfo2);
                    H7.b.b("SimContactsSupport", "getPhoneContactMappedListByContactIdForExp, The number is " + H7.a.d(stripSeparators) + ", the starred is " + l10);
                    i18++;
                    i17 = i19;
                    arrayList4 = arrayList6;
                    arrayList5 = arrayList;
                }
            } else {
                if (i16 == 0) {
                    if (TextUtils.isEmpty(x10)) {
                        return null;
                    }
                    SimContactInfo simContactInfo3 = new SimContactInfo();
                    simContactInfo3.h(x10);
                    simContactInfo3.i("");
                    simContactInfo3.k(l10);
                    arrayList3.add(simContactInfo3);
                    H7.b.b("SimContactsSupport", "getPhoneContactMappedListByContactIdForExp!!!, The number is " + H7.a.d("") + ", the starred is " + l10);
                }
                int i20 = 0;
                while (i20 != i16) {
                    String stripSeparators2 = i20 < i16 ? android.telephony.PhoneNumberUtils.stripSeparators(arrayList4.get(i20)) : "";
                    if (stripSeparators2.length() > 20) {
                        stripSeparators2 = stripSeparators2.substring(0, 20);
                    }
                    SimContactInfo simContactInfo4 = new SimContactInfo();
                    simContactInfo4.h(x10);
                    simContactInfo4.i(stripSeparators2);
                    simContactInfo4.k(l10);
                    arrayList3.add(simContactInfo4);
                    H7.b.b("SimContactsSupport", "getPhoneContactMappedListByContactIdForExp, The number is " + H7.a.d(stripSeparators2) + ", the starred is " + l10);
                    i20++;
                }
            }
        } else if (z11) {
            int i21 = (size2 & 1) + (size2 / 2);
            ArrayList<String> arrayList7 = d10;
            int i22 = size > i21 ? size : i21;
            H7.b.b("SimContactsSupport", "getPhoneContactMappedListByContactIdForExp, THE eSize IS " + size + ", the pSize is " + size2 + ", pCal is " + i21 + ",the size is " + i22);
            if (i22 == 0) {
                if (TextUtils.isEmpty(x10)) {
                    return null;
                }
                SimContactInfo simContactInfo5 = new SimContactInfo();
                simContactInfo5.h(x10);
                simContactInfo5.i("");
                simContactInfo5.k(l10);
                simContactInfo5.f15827g = "";
                simContactInfo5.f15828h = "";
                arrayList3.add(simContactInfo5);
                return arrayList3;
            }
            int i23 = 0;
            int i24 = 0;
            boolean z12 = true;
            while (i23 != i22) {
                String str3 = "";
                String str4 = str3;
                boolean z13 = true;
                while (i24 < size2 && z13) {
                    if (z12) {
                        str3 = android.telephony.PhoneNumberUtils.stripSeparators(i15.get(i24));
                        i14 = i22;
                        if (str3.length() > 20) {
                            str3 = str3.substring(0, 20);
                        }
                        arrayList2 = i15;
                    } else {
                        i14 = i22;
                        str4 = android.telephony.PhoneNumberUtils.stripSeparators(i15.get(i24));
                        arrayList2 = i15;
                        if (str4.length() > 20) {
                            str4 = str4.substring(0, 20);
                        }
                    }
                    z12 = !z12;
                    i24++;
                    z13 = (i24 & 1) == 1;
                    i22 = i14;
                    i15 = arrayList2;
                }
                ArrayList<String> arrayList8 = i15;
                int i25 = i22;
                if (TextUtils.isEmpty(str3 + str4 + x10)) {
                    break;
                }
                ArrayList<String> arrayList9 = arrayList7;
                if (i23 < size) {
                    str2 = arrayList9.get(i23);
                    i13 = i24;
                    if (str2.length() > 38) {
                        str2 = b0.y(38, 20, str2);
                    }
                } else {
                    i13 = i24;
                    str2 = "";
                }
                SimContactInfo simContactInfo6 = new SimContactInfo();
                simContactInfo6.h(x10);
                simContactInfo6.i(str3);
                simContactInfo6.k(l10);
                simContactInfo6.f15827g = str4;
                simContactInfo6.f15828h = str2;
                arrayList3.add(simContactInfo6);
                H7.b.b("SimContactsSupport", "getPhoneContactMappedListByContactIdForExp, The number is " + H7.a.d(str3) + ", the starred is " + l10 + ", the addNum is " + H7.a.d(str4));
                i23++;
                i24 = i13;
                i22 = i25;
                arrayList7 = arrayList9;
                i15 = arrayList8;
            }
        } else {
            ArrayList<String> arrayList10 = i15;
            if (size2 == 0) {
                if (TextUtils.isEmpty(x10)) {
                    return null;
                }
                SimContactInfo simContactInfo7 = new SimContactInfo();
                simContactInfo7.h(x10);
                simContactInfo7.i("");
                simContactInfo7.k(l10);
                simContactInfo7.f15827g = "";
                arrayList3.add(simContactInfo7);
                return arrayList3;
            }
            int i26 = (size2 & 1) + (size2 / 2);
            H7.b.b("SimContactsSupport", "getPhoneContactMappedListByContactIdForExp, THE eSize IS " + size + ", the pSize is " + size2 + ", pCal is " + i26 + ",the size is " + i26);
            int i27 = 0;
            int i28 = 0;
            boolean z14 = true;
            while (i27 != i26) {
                boolean z15 = z14;
                String str5 = "";
                String str6 = str5;
                boolean z16 = true;
                while (i28 < size2 && z16) {
                    if (z15) {
                        ArrayList<String> arrayList11 = arrayList10;
                        str5 = android.telephony.PhoneNumberUtils.stripSeparators(arrayList11.get(i28));
                        i11 = i26;
                        i12 = size2;
                        if (str5.length() > 20) {
                            str5 = str5.substring(0, 20);
                        }
                        arrayList10 = arrayList11;
                    } else {
                        i11 = i26;
                        i12 = size2;
                        str6 = android.telephony.PhoneNumberUtils.stripSeparators(arrayList10.get(i28));
                        if (str6.length() > 20) {
                            str6 = str6.substring(0, 20);
                        }
                    }
                    z15 = !z15;
                    i28++;
                    z16 = (i28 & 1) == 1;
                    i26 = i11;
                    size2 = i12;
                }
                int i29 = i26;
                int i30 = size2;
                if (TextUtils.isEmpty(str5 + str6 + x10)) {
                    break;
                }
                SimContactInfo simContactInfo8 = new SimContactInfo();
                simContactInfo8.h(x10);
                simContactInfo8.i(str5);
                simContactInfo8.k(l10);
                simContactInfo8.f15827g = str6;
                arrayList3.add(simContactInfo8);
                H7.b.b("SimContactsSupport", "getPhoneContactMappedListByContactIdForExp, The number is " + H7.a.d(str5) + ", the starred is " + l10 + ", the addNum is " + H7.a.d(str6));
                i27++;
                i26 = i29;
                z14 = z15;
                size2 = i30;
            }
        }
        return arrayList3;
    }

    public static ArrayList<SimContactInfo> p(Context context, int i10, long j10) {
        int i11;
        int i12;
        ArrayList<String> arrayList;
        String str;
        int i13;
        int i14;
        C0804o a10 = C0804o.a(context, j10);
        ArrayList<SimContactInfo> arrayList2 = new ArrayList<>();
        long l10 = a10.l();
        String x10 = b0.x(context, a10.f(), i10);
        ArrayList<String> i15 = a10.i();
        ArrayList<String> d10 = a10.d();
        int i16 = 0;
        if (d10 != null) {
            i11 = d10.size();
        } else {
            i11 = 0;
        }
        if (i15 != null) {
            i12 = i15.size();
        } else {
            i12 = 0;
        }
        int i17 = (i12 & 1) + (i12 / 2);
        if (i11 > i17) {
            i17 = i11;
        }
        if (i17 == 0) {
            if (TextUtils.isEmpty(x10)) {
                return null;
            }
            SimContactInfo simContactInfo = new SimContactInfo();
            simContactInfo.h(x10);
            simContactInfo.i("");
            simContactInfo.k(l10);
            simContactInfo.f15827g = "";
            simContactInfo.f15828h = "";
            arrayList2.add(simContactInfo);
            return arrayList2;
        }
        int i18 = 0;
        int i19 = 0;
        boolean z10 = true;
        while (i18 != i17) {
            String str2 = "";
            String str3 = str2;
            int i20 = 1;
            while (i19 < i12 && i20 != 0) {
                if (z10) {
                    String stripSeparators = android.telephony.PhoneNumberUtils.stripSeparators(i15.get(i19));
                    i13 = i12;
                    if (stripSeparators.length() > 20) {
                        str2 = stripSeparators.substring(i16, 20);
                    } else {
                        str2 = stripSeparators;
                    }
                } else {
                    i13 = i12;
                    String stripSeparators2 = android.telephony.PhoneNumberUtils.stripSeparators(i15.get(i19));
                    if (stripSeparators2.length() > 20) {
                        str3 = stripSeparators2.substring(i16, 20);
                    } else {
                        str3 = stripSeparators2;
                    }
                }
                z10 = !z10;
                i19++;
                if ((i19 & 1) == 1) {
                    i14 = 1;
                } else {
                    i14 = i16;
                }
                i20 = i14;
                i12 = i13;
            }
            int i21 = i12;
            StringBuilder sb = new StringBuilder();
            String str4 = str2;
            sb.append(str4);
            String str5 = str3;
            sb.append(str5);
            sb.append(x10);
            if (TextUtils.isEmpty(sb.toString())) {
                break;
            }
            if (i18 < i11) {
                str = d10.get(i18);
                arrayList = d10;
                if (str.length() > 38) {
                    str = b0.y(38, 20, str);
                }
            } else {
                arrayList = d10;
                str = "";
            }
            SimContactInfo simContactInfo2 = new SimContactInfo();
            simContactInfo2.h(x10);
            simContactInfo2.i(str4);
            simContactInfo2.k(l10);
            simContactInfo2.f15827g = str5;
            simContactInfo2.f15828h = str;
            arrayList2.add(simContactInfo2);
            i18++;
            i12 = i21;
            d10 = arrayList;
            i16 = 0;
        }
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a5, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        if (r3 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.customize.contacts.model.IdRecord> q(android.content.Context r10, com.android.contacts.model.Account r11) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "account_type='"
            r0.append(r1)
            java.lang.String r1 = r11.f16942b
            r0.append(r1)
            java.lang.String r1 = "'"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.net.Uri r1 = R0.d.f3214a
            boolean r2 = M3.c.p(r10, r11)
            r3 = 0
            if (r2 == 0) goto L24
            r5 = r1
            r7 = r3
            goto L57
        L24:
            android.net.Uri r1 = android.provider.ContactsContract.RawContacts.CONTENT_URI
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " AND "
            r2.append(r0)
            java.lang.String r0 = "account_name"
            r2.append(r0)
            java.lang.String r0 = "='"
            r2.append(r0)
            java.lang.String r11 = r11.f16941a
            r2.append(r11)
            java.lang.String r11 = "' AND "
            r2.append(r11)
            java.lang.String r11 = "deleted"
            r2.append(r11)
            java.lang.String r11 = "=0"
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            r7 = r11
            r5 = r1
        L57:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            android.content.ContentResolver r4 = r10.getContentResolver()
            java.lang.String r10 = "_id"
            java.lang.String[] r6 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r8 = 0
            r9 = 0
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            if (r3 == 0) goto L86
        L6e:
            boolean r10 = r3.moveToNext()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            if (r10 == 0) goto L86
            com.customize.contacts.model.IdRecord r10 = new com.customize.contacts.model.IdRecord     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r0 = 0
            long r0 = r3.getLong(r0)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r11.add(r10)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            goto L6e
        L82:
            r10 = move-exception
            goto La6
        L84:
            r10 = move-exception
            goto L8c
        L86:
            if (r3 == 0) goto La5
        L88:
            r3.close()
            goto La5
        L8c:
            java.lang.String r0 = "SimContactsSupport"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r1.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = ""
            r1.append(r2)     // Catch: java.lang.Throwable -> L82
            r1.append(r10)     // Catch: java.lang.Throwable -> L82
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L82
            H7.b.c(r0, r10)     // Catch: java.lang.Throwable -> L82
            if (r3 == 0) goto La5
            goto L88
        La5:
            return r11
        La6:
            if (r3 == 0) goto Lab
            r3.close()
        Lab:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.c0.q(android.content.Context, com.android.contacts.model.Account):java.util.ArrayList");
    }

    public static String r(Context context, int i10) {
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            return com.android.contacts.framework.api.appstore.simcard.a.c(context, i10);
        }
        return s(context, i10);
    }

    public static String s(Context context, int i10) {
        String str = null;
        try {
            if (B3.a.i()) {
                if (1 == i10) {
                    if (f22058e == null) {
                        f22058e = O7.a.b(context, i10);
                    }
                    str = f22058e;
                } else if (i10 == 0) {
                    if (f22057d == null) {
                        f22057d = O7.a.b(context, i10);
                    }
                    str = f22057d;
                } else {
                    H7.b.c("SimContactsSupport", "getSimCardImsi invalid slotId(" + i10 + ")");
                }
            } else if (B3.a.o()) {
                str = O7.a.b(context, i10);
            } else {
                str = O7.a.b(context, 0);
            }
            if (H7.a.b()) {
                H7.b.b("SimContactsSupport", "getSimCardImsi slotId:" + i10);
            }
        } catch (Exception e10) {
            H7.b.c("SimContactsSupport", "Exception when getSimCardImsi " + e10);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static I.d<java.lang.Boolean, java.lang.Long> t(android.content.Context r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, int r34, boolean r35) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.c0.t(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, boolean):I.d");
    }

    public static boolean u(Context context, long j10) {
        boolean z10;
        H7.b.e("SimContactsSupport", "isAutoSyncSimContact, contactId = " + j10);
        Cursor e10 = G7.c.e(context.getContentResolver(), ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "contact_id = ? AND account_type = 'com.android.oplus.sim'", new String[]{String.valueOf(j10)}, null);
        if (e10 != null && e10.moveToFirst()) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.oplus.foundation.util.io.e.a(e10);
        return z10;
    }

    public static void v() {
        f22057d = null;
        f22058e = null;
    }

    public static void w(long j10) {
        f22056c = j10;
    }

    public static void x(long j10, SimContactInfo simContactInfo, SimContactInfo simContactInfo2, ArrayList<ContentProviderOperation> arrayList) {
        Integer num;
        String str;
        Integer num2;
        String str2;
        int i10;
        int z10 = z(simContactInfo.f15825e, simContactInfo2.f15825e);
        int z11 = z(simContactInfo.f15827g, simContactInfo2.f15827g);
        int z12 = z(simContactInfo.f15828h, simContactInfo2.f15828h);
        H7.b.b("SimContactsSupport", "the numberCompare is : " + z10 + " addNumberCompare : " + z11 + " emailCompare : " + z12);
        if (z10 == 2) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert.withValue("raw_contact_id", Long.valueOf(j10));
            newInsert.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
            newInsert.withValue("data2", 2);
            newInsert.withValue("data1", simContactInfo2.f15825e);
            newInsert.withValue("data3", 1);
            arrayList.add(newInsert.build());
            str = "data2";
            num2 = 2;
            num = 1;
            i10 = z11;
            str2 = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
        } else {
            num = 1;
            if (z10 != 1) {
                str = "data2";
                num2 = 2;
                str2 = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
                if (z10 == 3) {
                    ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
                    newDelete.withSelection("raw_contact_id = ? and mimetype = ? and data1 = ? and data2 = ? and data3 = ?", new String[]{j10 + "", "vnd.android.cursor.item/phone_v2", simContactInfo.f15825e, "2", str2});
                    arrayList.add(newDelete.build());
                }
            } else {
                ContentProviderOperation.Builder newUpdate = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI);
                str = "data2";
                String str3 = simContactInfo.f15825e;
                num2 = 2;
                str2 = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
                newUpdate.withSelection("raw_contact_id = ? and mimetype = ? and data1 = ? and data2 = ? and data3 = ?", new String[]{j10 + "", "vnd.android.cursor.item/phone_v2", str3, "2", str2});
                newUpdate.withValue("data1", simContactInfo2.f15825e);
                arrayList.add(newUpdate.build());
            }
            i10 = z11;
        }
        if (i10 == 2) {
            ContentProviderOperation.Builder newInsert2 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert2.withValue("raw_contact_id", Long.valueOf(j10));
            newInsert2.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
            newInsert2.withValue(str, num2);
            newInsert2.withValue("data1", simContactInfo2.f15827g);
            arrayList.add(newInsert2.build());
        } else {
            String str4 = str;
            if (i10 == 1) {
                ContentProviderOperation.Builder newUpdate2 = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI);
                str = str4;
                newUpdate2.withSelection("raw_contact_id = ? and mimetype = ? and data1 = ? and data2 = ? and data3 <> ?", new String[]{j10 + "", "vnd.android.cursor.item/phone_v2", simContactInfo.f15827g, "2", str2});
                newUpdate2.withValue("data1", simContactInfo2.f15827g);
                arrayList.add(newUpdate2.build());
            } else {
                str = str4;
                if (i10 == 3) {
                    ContentProviderOperation.Builder newDelete2 = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
                    newDelete2.withSelection("raw_contact_id = ? and mimetype = ? and data1 = ? and data2 = ? and data3 <> ?", new String[]{j10 + "", "vnd.android.cursor.item/phone_v2", simContactInfo.f15827g, "2", str2});
                    arrayList.add(newDelete2.build());
                }
            }
        }
        if (z12 == 2) {
            ContentProviderOperation.Builder newInsert3 = ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI);
            newInsert3.withValue("raw_contact_id", Long.valueOf(j10));
            newInsert3.withValue("mimetype", "vnd.android.cursor.item/email_v2");
            newInsert3.withValue(str, num);
            newInsert3.withValue("data1", simContactInfo2.f15828h);
            arrayList.add(newInsert3.build());
            return;
        }
        if (z12 == 1) {
            ContentProviderOperation.Builder newUpdate3 = ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI);
            newUpdate3.withSelection("raw_contact_id = ? and mimetype = ? and data1 = ?", new String[]{j10 + "", "vnd.android.cursor.item/email_v2", simContactInfo.f15828h});
            newUpdate3.withValue("data1", simContactInfo2.f15828h);
            arrayList.add(newUpdate3.build());
            return;
        }
        if (z12 == 3) {
            ContentProviderOperation.Builder newDelete3 = ContentProviderOperation.newDelete(ContactsContract.Data.CONTENT_URI);
            newDelete3.withSelection("raw_contact_id = ? and mimetype = ? and data1 = ?", new String[]{j10 + "", "vnd.android.cursor.item/email_v2", simContactInfo.f15828h});
            arrayList.add(newDelete3.build());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a A[Catch: all -> 0x0075, TRY_LEAVE, TryCatch #0 {all -> 0x0075, blocks: (B:28:0x0069, B:30:0x006f, B:14:0x007a, B:20:0x009c, B:22:0x00ab), top: B:27:0x0069, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c A[Catch: all -> 0x0075, TRY_ENTER, TryCatch #0 {all -> 0x0075, blocks: (B:28:0x0069, B:30:0x006f, B:14:0x007a, B:20:0x009c, B:22:0x00ab), top: B:27:0x0069, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void y(android.content.Context r8, long r9, com.android.contacts.framework.baseui.sim.SimContactInfo r11, com.android.contacts.framework.baseui.sim.SimContactInfo r12, int r13) {
        /*
            java.lang.String r0 = "SimContactsSupport"
            if (r11 == 0) goto Ld5
            if (r12 != 0) goto L8
            goto Ld5
        L8:
            boolean r1 = B3.a.o()
            if (r1 == 0) goto L11
            r1 = 1
            long r9 = r9 + r1
        L11:
            android.content.ContentResolver r8 = r8.getContentResolver()
            android.net.Uri r2 = android.provider.ContactsContract.RawContacts.CONTENT_URI     // Catch: java.lang.Exception -> L99
            java.lang.String r1 = "_id"
            java.lang.String[] r3 = new java.lang.String[]{r1}     // Catch: java.lang.Exception -> L99
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99
            r1.<init>()     // Catch: java.lang.Exception -> L99
            java.lang.String r4 = com.customize.contacts.simcontacts.b.f21805a     // Catch: java.lang.Exception -> L99
            r1.append(r4)     // Catch: java.lang.Exception -> L99
            java.lang.String r4 = " = ? and deleted = 0 and "
            r1.append(r4)     // Catch: java.lang.Exception -> L99
            java.lang.String r4 = "account_type"
            r1.append(r4)     // Catch: java.lang.Exception -> L99
            java.lang.String r4 = "=? AND "
            r1.append(r4)     // Catch: java.lang.Exception -> L99
            java.lang.String r4 = "account_name"
            r1.append(r4)     // Catch: java.lang.Exception -> L99
            java.lang.String r4 = "=?"
            r1.append(r4)     // Catch: java.lang.Exception -> L99
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Exception -> L99
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99
            r1.<init>()     // Catch: java.lang.Exception -> L99
            java.lang.String r5 = ""
            r1.append(r5)     // Catch: java.lang.Exception -> L99
            r1.append(r9)     // Catch: java.lang.Exception -> L99
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L99
            java.lang.String r5 = "com.android.oplus.sim"
            java.lang.String r13 = com.customize.contacts.simcontacts.b.g(r13)     // Catch: java.lang.Exception -> L99
            java.lang.String[] r5 = new java.lang.String[]{r1, r5, r13}     // Catch: java.lang.Exception -> L99
            r6 = 0
            r7 = 0
            r1 = r8
            android.database.Cursor r13 = r1.query(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L99
            r1 = -1
            if (r13 == 0) goto L77
            boolean r2 = r13.moveToFirst()     // Catch: java.lang.Throwable -> L75
            if (r2 == 0) goto L77
            r2 = 0
            int r2 = r13.getInt(r2)     // Catch: java.lang.Throwable -> L75
            goto L78
        L75:
            r8 = move-exception
            goto Lb6
        L77:
            r2 = r1
        L78:
            if (r2 != r1) goto L9c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r8.<init>()     // Catch: java.lang.Throwable -> L75
            java.lang.String r11 = "the contact which sim index "
            r8.append(r11)     // Catch: java.lang.Throwable -> L75
            r8.append(r9)     // Catch: java.lang.Throwable -> L75
            java.lang.String r9 = " 's raw id is -1, return"
            r8.append(r9)     // Catch: java.lang.Throwable -> L75
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L75
            H7.b.b(r0, r8)     // Catch: java.lang.Throwable -> L75
            if (r13 == 0) goto L9b
            r13.close()     // Catch: java.lang.Exception -> L99
            goto L9b
        L99:
            r8 = move-exception
            goto Lc1
        L9b:
            return
        L9c:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L75
            r9.<init>()     // Catch: java.lang.Throwable -> L75
            long r1 = (long) r2     // Catch: java.lang.Throwable -> L75
            x(r1, r11, r12, r9)     // Catch: java.lang.Throwable -> L75
            boolean r10 = r9.isEmpty()     // Catch: java.lang.Throwable -> L75
            if (r10 != 0) goto Lb0
            java.lang.String r10 = "com.android.contacts"
            r8.applyBatch(r10, r9)     // Catch: java.lang.Throwable -> L75
        Lb0:
            if (r13 == 0) goto Ld5
            r13.close()     // Catch: java.lang.Exception -> L99
            goto Ld5
        Lb6:
            if (r13 == 0) goto Lc0
            r13.close()     // Catch: java.lang.Throwable -> Lbc
            goto Lc0
        Lbc:
            r9 = move-exception
            r8.addSuppressed(r9)     // Catch: java.lang.Exception -> L99
        Lc0:
            throw r8     // Catch: java.lang.Exception -> L99
        Lc1:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Exception in updateExistedSimContact "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            H7.b.c(r0, r8)
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.c0.y(android.content.Context, long, com.android.contacts.framework.baseui.sim.SimContactInfo, com.android.contacts.framework.baseui.sim.SimContactInfo, int):void");
    }

    public static int z(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return 2;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.equals(str, str2)) {
            return 1;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            return 0;
        }
        return 3;
    }
}
