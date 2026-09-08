package M3;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.contacts.model.Account;
import com.android.contacts.model.AccountWithDataSet;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.b0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.util.ArrayList;
import java.util.List;
import n1.AbstractC1362a;

/* compiled from: AccountsUtils.java */
/* loaded from: classes3.dex */
public class c {

    /* compiled from: AccountsUtils.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f1750a;

        /* renamed from: b, reason: collision with root package name */
        public String f1751b;

        /* renamed from: c, reason: collision with root package name */
        public int f1752c = 0;

        public a(String str, String str2) {
            this.f1750a = str;
            this.f1751b = str2;
        }
    }

    public static void b(Context context, ArrayList<Account> arrayList) {
        if (!FeatureOption.k()) {
            return;
        }
        for (SubscriptionInfo subscriptionInfo : b0.e(context)) {
            H7.b.e("AccountsUtils", "simInfo.mSlot is " + subscriptionInfo.getSimSlotIndex());
            if (subscriptionInfo.getSimSlotIndex() == 0 || subscriptionInfo.getSimSlotIndex() == 1) {
                if (b0.m0(context, subscriptionInfo.getSimSlotIndex())) {
                    arrayList.add(com.customize.contacts.simcontacts.c.f(context, subscriptionInfo.getSimSlotIndex(), false));
                }
            }
        }
    }

    public static String c(Context context, Account account, int i10, boolean z10) {
        String str;
        boolean z11;
        String str2;
        int j10;
        if (i10 > 0) {
            str = context.getString(i10);
        } else {
            str = null;
        }
        boolean z12 = false;
        if (str != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (account == null || account.f16941a == null) {
            return null;
        }
        if (s(account)) {
            if (z10 || z11) {
                z12 = true;
            }
            str2 = context.getString(R.string.contact_editor_account_storage_phone);
        } else if (t(account)) {
            if (z10 || z11) {
                z12 = true;
            }
            String string = context.getString(R.string.oplus_storage_sim);
            if ((b0.O() <= 1 && !B3.a.i()) || ((j10 = com.customize.contacts.simcontacts.b.j(account.f16941a)) != 0 && j10 != 1)) {
                str2 = string;
            } else {
                str2 = b0.I(context, j10);
            }
        } else {
            if (!z10 && z11) {
                z12 = true;
            }
            str2 = account.f16941a;
        }
        if (z11 && z12) {
            return String.format(str, str2);
        }
        return str2;
    }

    public static CharSequence[] d(Context context, ArrayList<Account> arrayList, int i10, boolean z10) {
        String str;
        boolean z11;
        boolean z12;
        String str2;
        boolean z13;
        boolean z14;
        String str3;
        String str4;
        String str5;
        if (i10 > 0) {
            str = context.getString(i10);
        } else {
            str = null;
        }
        if (str != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        int size = arrayList.size();
        CharSequence[] charSequenceArr = new CharSequence[size];
        String[] J10 = b0.J(context);
        for (int i11 = 0; i11 != size; i11++) {
            Account account = arrayList.get(i11);
            if (s(account)) {
                if (!z10 && !z11) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                str2 = context.getString(R.string.contact_editor_account_storage_phone);
                if (ContactsApplication.f13094j) {
                    str2 = "\u200e" + str2 + "\u200e";
                }
            } else if (t(account)) {
                if (!z10 && !z11) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                String string = context.getString(R.string.oplus_storage_sim);
                if (B3.a.i()) {
                    int j10 = com.customize.contacts.simcontacts.b.j(account.f16941a);
                    if (H7.a.b()) {
                        H7.b.b("AccountsUtils", "getAccountsSequence slotId = " + j10);
                    }
                    if ((j10 == 0 || j10 == 1) && (str5 = J10[j10]) != null && str5.length() > 0) {
                        str4 = J10[j10];
                        string = str4;
                    }
                    z13 = z14;
                    str2 = string;
                } else {
                    if (b0.O() > 1) {
                        int K10 = b0.K(context, account.f16941a);
                        if (H7.a.b()) {
                            H7.b.b("AccountsUtils", "getAccountsSequence slotId = " + K10);
                        }
                        if ((K10 == 0 || K10 == 1) && (str3 = J10[K10]) != null && str3.length() > 0) {
                            str4 = J10[K10];
                            string = str4;
                        }
                    }
                    z13 = z14;
                    str2 = string;
                }
            } else {
                if (!z10 && z11) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z15 = z12;
                str2 = account.f16941a;
                z13 = z15;
            }
            if (z11 && z13) {
                str2 = String.format(str, str2);
            }
            charSequenceArr[i11] = str2;
        }
        return charSequenceArr;
    }

    public static ArrayList<Account> e(Context context) {
        return f(context, false, false, true);
    }

    public static ArrayList<Account> f(Context context, boolean z10, boolean z11, boolean z12) {
        ArrayList<Account> arrayList = new ArrayList<>();
        List<AccountWithDataSet> g10 = AbstractC1362a.h(context).g(!z12);
        if (g10 != null) {
            for (AccountWithDataSet accountWithDataSet : g10) {
                arrayList.add(new Account(accountWithDataSet.f16941a, accountWithDataSet.f16942b));
            }
        }
        if (z10 && PrimaryUserUtils.a()) {
            b(context, arrayList);
        }
        if (H7.a.b()) {
            H7.b.b("AccountsUtils", "getAllAccounts(), accounts = " + arrayList + ", accounts.size = " + arrayList.size());
        }
        return arrayList;
    }

    public static Account g(Context context) {
        return new Account(context.getString(R.string.oplus_account_name_as_all), "com.oplus.contacts.all");
    }

    public static String h(Context context, long j10) {
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"account_type"}, "_id=" + j10, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        query.close();
                        return string;
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Exception e10) {
            H7.b.c("AccountsUtils", "" + e10);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006a, code lost:
    
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0089, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        if (r1 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int i(android.content.Context r10, com.android.contacts.model.Account r11) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = p(r10, r11)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String r3 = "_id"
            if (r2 != 0) goto L4d
            boolean r2 = r11.d()     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            if (r2 == 0) goto L19
            java.lang.String r11 = "_id IN (SELECT contact_id FROM raw_contacts WHERE  account_id=(SELECT _id FROM accounts WHERE (account_name IS NULL AND account_type IS NULL)))"
        L12:
            r7 = r11
            goto L3c
        L14:
            r10 = move-exception
            goto L8a
        L17:
            r10 = move-exception
            goto L70
        L19:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String r4 = "_id IN (SELECT contact_id FROM raw_contacts WHERE  account_id=(SELECT _id FROM accounts WHERE (account_name='"
            r2.append(r4)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String r4 = r11.f16941a     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            r2.append(r4)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String r4 = "' AND account_type='"
            r2.append(r4)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String r11 = r11.f16942b     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            r2.append(r11)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String r11 = "')))"
            r2.append(r11)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String r11 = r2.toString()     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            goto L12
        L3c:
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            goto L64
        L4d:
            boolean r11 = p(r10, r11)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            if (r11 == 0) goto L64
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            android.net.Uri r5 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            java.lang.String[] r6 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
        L64:
            if (r1 == 0) goto L6a
            int r0 = r1.getCount()     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L17
        L6a:
            if (r1 == 0) goto L89
        L6c:
            r1.close()
            goto L89
        L70:
            java.lang.String r11 = "AccountsUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L14
            r2.<init>()     // Catch: java.lang.Throwable -> L14
            java.lang.String r3 = ""
            r2.append(r3)     // Catch: java.lang.Throwable -> L14
            r2.append(r10)     // Catch: java.lang.Throwable -> L14
            java.lang.String r10 = r2.toString()     // Catch: java.lang.Throwable -> L14
            H7.b.c(r11, r10)     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L89
            goto L6c
        L89:
            return r0
        L8a:
            if (r1 == 0) goto L8f
            r1.close()
        L8f:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: M3.c.i(android.content.Context, com.android.contacts.model.Account):int");
    }

    public static Cursor j(Context context) {
        try {
            return context.getContentResolver().query(ContactsContract.AUTHORITY_URI.buildUpon().appendPath(com.android.contacts.compat.data.f.c("query_contacts_count")).build(), null, null, null, null);
        } catch (Exception e10) {
            H7.b.c("AccountsUtils", "getContactsCount error: " + e10);
            return null;
        }
    }

    public static int k(Context context, Account account) {
        return i(context, account);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.android.contacts.model.Account l(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: M3.c.l(android.content.Context):com.android.contacts.model.Account");
    }

    public static ArrayList<Account> m(Context context) {
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            return com.android.contacts.framework.api.appstore.simcard.a.a(context);
        }
        return n(context);
    }

    public static ArrayList<Account> n(Context context) {
        ArrayList<Account> arrayList = new ArrayList<>();
        int i10 = 1;
        if (B3.a.i()) {
            try {
                if (!D7.c.k()) {
                    i10 = 2;
                }
            } catch (Throwable th) {
                H7.b.c("AccountsUtils", "getSimAccounts, the e is " + th);
                i10 = 0;
            }
        }
        for (int i11 = 0; i11 < i10; i11++) {
            String b10 = O7.a.b(context, i11);
            if (b0.m0(context, i11) && b10 != null && !TextUtils.isEmpty(b10.trim()) && !b0.v0(context, i11) && !b0.k0(context, i11)) {
                arrayList.add(new Account(b10, "com.oplus.contacts.sim"));
            }
        }
        b0.L0(arrayList.size());
        if (H7.a.b()) {
            H7.b.b("AccountsUtils", "count = " + i10 + ", getSimAccounts(), accounts = " + arrayList + ", accounts.size = " + arrayList.size());
        }
        return arrayList;
    }

    public static boolean o(Context context, String str) {
        return AbstractC1362a.h(context).c(str, null).b();
    }

    public static boolean p(Context context, Account account) {
        if (context.getString(R.string.oplus_account_name_as_all).equals(account.f16941a) && "com.oplus.contacts.all".equals(account.f16942b)) {
            return true;
        }
        return false;
    }

    public static boolean q(String str, String str2) {
        if (TextUtils.equals(R0.a.f3165a, str) && TextUtils.equals(R0.a.f3166b, str2)) {
            return true;
        }
        return false;
    }

    public static boolean r(Account account) {
        if (account == null) {
            return false;
        }
        return "com.google".equals(account.f16942b);
    }

    public static boolean s(Account account) {
        if (TextUtils.equals(R0.a.f3165a, account.f16941a) && TextUtils.equals(R0.a.f3166b, account.f16942b)) {
            return true;
        }
        return false;
    }

    public static boolean t(Account account) {
        if (account == null) {
            return false;
        }
        return u(account.f16942b);
    }

    public static boolean u(String str) {
        if (!"com.oplus.contacts.sim".equals(str) && !"com.android.oplus.sim".equals(str)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void v(String str, String str2, ContentResolver contentResolver) {
        try {
            if (str != null && str2 != null) {
                M3.a.b(contentResolver, new android.accounts.Account(str, str2));
            } else {
                M3.a.b(contentResolver, null);
            }
        } catch (Exception e10) {
            H7.b.b("AccountsUtils", "setDefaultAccount, e: " + e10);
        }
    }

    public static void w(Context context, final String str, final String str2) {
        if (H7.a.b()) {
            H7.b.b("AccountsUtils", "writeDefaultAccount, type: " + str + " name: " + str2);
        }
        if (OsUtils.k() && !com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            final ContentResolver contentResolver = context.getContentResolver();
            N7.a.b().execute(new Runnable() { // from class: M3.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.v(str2, str, contentResolver);
                }
            });
        } else {
            SharedPreferences.Editor edit = androidx.preference.j.b(context).edit();
            edit.putString("key_default_accounttype", str);
            edit.putString("key_default_accountname", str2);
            edit.apply();
        }
    }
}
