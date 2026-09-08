package com.oplus.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber$PhoneNumber;
import com.oplus.backup.sdk.common.utils.Constants;
import com.oplus.utils.C0847h;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: BlacklistUtils.java */
/* renamed from: com.oplus.utils.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0848i {

    /* renamed from: a, reason: collision with root package name */
    public static PhoneNumberUtil f29156a;

    /* compiled from: BlacklistUtils.java */
    /* renamed from: com.oplus.utils.i$a */
    /* loaded from: classes3.dex */
    public class a implements Callable<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f29157a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29158b;

        public a(Context context, String str) {
            this.f29157a = context;
            this.f29158b = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            ApplicationInfo applicationInfo;
            boolean z10 = false;
            try {
                applicationInfo = this.f29157a.getPackageManager().getApplicationInfo(this.f29158b, 0);
            } catch (Exception e10) {
                Log.d("BlacklistUtils", "isAppInstalled : e = " + e10);
                applicationInfo = null;
            }
            if (applicationInfo != null && applicationInfo.enabled) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    public static int a(Context context) {
        return G.a(context);
    }

    public static Uri b(Context context, int i10) {
        if (L.h(context, "android.permission.READ_CALL_LOG")) {
            if (i10 > 1) {
                return Uri.parse("content://call_log/" + F6.d.d());
            }
            return Uri.parse("content://call_log/" + F6.d.c());
        }
        if (i10 > 1) {
            return C0847h.a.f29144b;
        }
        return C0847h.a.f29145c;
    }

    public static String c(String str, String str2) {
        int i10 = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                Phonenumber$PhoneNumber r02 = PhoneNumberUtil.C().r0(str, str2);
                if (r02 != null) {
                    if (r02.g() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD) {
                        i10 = r02.f();
                    }
                    if (i10 == 0 && str.startsWith("00")) {
                        String l10 = r02.l();
                        if (!TextUtils.isEmpty(l10)) {
                            if (l10.startsWith("00" + r02.f())) {
                                i10 = r02.f();
                            }
                        }
                    }
                }
            } catch (NumberParseException unused) {
            }
        }
        if (i10 == 0) {
            return null;
        }
        return String.valueOf(i10);
    }

    public static String d(Context context, int i10, int i11, boolean z10) {
        String quantityString;
        int i12;
        int i13;
        try {
            if (i10 <= 1) {
                if (z10) {
                    i13 = com.oplus.blacklistapp.u.f27531K;
                } else {
                    i13 = com.oplus.blacklistapp.u.f27539M;
                }
                return context.getString(i13);
            }
            if (i10 == i11) {
                if (z10) {
                    i12 = com.oplus.blacklistapp.u.f27511F;
                } else {
                    i12 = com.oplus.blacklistapp.u.f27519H;
                }
                return context.getString(i12);
            }
            if (z10) {
                quantityString = context.getResources().getQuantityString(com.oplus.blacklistapp.t.f27480b, i10);
            } else {
                quantityString = context.getResources().getQuantityString(com.oplus.blacklistapp.t.f27482d, i10);
            }
            return String.format(quantityString, Integer.valueOf(i10));
        } catch (Exception e10) {
            Log.e("BlacklistUtils", "getDeleteMessage error " + e10);
            return "";
        }
    }

    public static String e(Context context, int i10, int i11, boolean z10) {
        String quantityString;
        int i12;
        int i13;
        try {
            if (i10 <= 1) {
                if (z10) {
                    i13 = com.oplus.blacklistapp.u.f27527J;
                } else {
                    i13 = com.oplus.blacklistapp.u.f27535L;
                }
                return context.getString(i13);
            }
            if (i10 == i11) {
                if (z10) {
                    i12 = com.oplus.blacklistapp.u.f27515G;
                } else {
                    i12 = com.oplus.blacklistapp.u.f27523I;
                }
                return context.getString(i12);
            }
            if (z10) {
                quantityString = context.getResources().getQuantityString(com.oplus.blacklistapp.t.f27481c, i10);
            } else {
                quantityString = context.getResources().getQuantityString(com.oplus.blacklistapp.t.f27483e, i10);
            }
            return String.format(quantityString, Integer.valueOf(i10));
        } catch (Exception e10) {
            Log.e("BlacklistUtils", "getDeleteMessageBody error " + e10);
            return "";
        }
    }

    public static String f(Context context, String str, String str2, String str3) {
        if (str != null && str.contains("@")) {
            return str;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str3 == null) {
            str3 = I6.a.b(context).a();
        }
        String formatNumberToE164 = PhoneNumberUtils.formatNumberToE164(str, str3);
        if (formatNumberToE164 == null) {
            return "";
        }
        return formatNumberToE164;
    }

    public static Uri g(Context context) {
        if (L.h(context, "android.permission.READ_CALL_LOG")) {
            return CallLog.Calls.CONTENT_URI;
        }
        return C0847h.a.f29146d;
    }

    public static int h(Context context) {
        return G.b(context);
    }

    public static Uri i(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            int length = str.length();
            if (length > 1 && (str.endsWith(Constants.DataMigration.SPLIT_TAG) || str.endsWith(","))) {
                str = str.substring(0, length - 1);
            }
            if (L.h(context, "android.permission.READ_CONTACTS")) {
                return Uri.withAppendedPath(ContactsContract.PhoneLookup.ENTERPRISE_CONTENT_FILTER_URI, Uri.encode(str));
            }
            return Uri.withAppendedPath(C0847h.b.f29149c, Uri.encode(str));
        }
        return ContactsContract.PhoneLookup.ENTERPRISE_CONTENT_FILTER_URI;
    }

    public static Uri j(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            int length = str.length();
            if (length > 1 && (str.endsWith(Constants.DataMigration.SPLIT_TAG) || str.endsWith(","))) {
                str = str.substring(0, length - 1);
            }
            if (L.h(context, "android.permission.READ_CONTACTS")) {
                return Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str));
            }
            return Uri.withAppendedPath(C0847h.b.f29148b, Uri.encode(str));
        }
        return ContactsContract.PhoneLookup.CONTENT_FILTER_URI;
    }

    public static synchronized PhoneNumberUtil k() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (C0848i.class) {
            try {
                if (f29156a == null) {
                    f29156a = PhoneNumberUtil.C();
                }
                phoneNumberUtil = f29156a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return phoneNumberUtil;
    }

    public static String l(Context context, int i10, int i11) {
        String string;
        try {
            if (i10 <= 1) {
                string = context.getString(com.oplus.blacklistapp.u.f27522H2);
            } else if (i10 == i11) {
                string = context.getString(com.oplus.blacklistapp.u.f27526I2);
            } else {
                string = context.getString(com.oplus.blacklistapp.u.f27534K2, Integer.valueOf(Integer.parseInt(C0849j.d(i10))));
            }
            return string;
        } catch (Exception e10) {
            Log.e("BlacklistUtils", "getRecoverBlockedSmsMessage exception " + e10);
            return "";
        }
    }

    public static String m(Context context, int i10, int i11) {
        String string;
        try {
            if (i10 <= 1) {
                string = context.getString(com.oplus.blacklistapp.u.f27522H2);
            } else if (i10 == i11) {
                string = context.getString(com.oplus.blacklistapp.u.f27526I2);
            } else {
                string = context.getString(com.oplus.blacklistapp.u.f27530J2, Integer.valueOf(Integer.parseInt(C0849j.d(i10))));
            }
            return string;
        } catch (Exception e10) {
            Log.e("BlacklistUtils", "getRecoverCallLogMessage exception " + e10);
            return "";
        }
    }

    public static String n(Context context, String str) {
        String a10 = I6.a.b(context).a();
        C0846g.i("BlacklistUtils", "countryIso: " + a10);
        List<String> list = null;
        if (!TextUtils.isEmpty(str)) {
            PhoneNumberUtil C10 = PhoneNumberUtil.C();
            try {
                Phonenumber$PhoneNumber r02 = C10.r0(str, a10);
                if (r02 != null) {
                    if (r02.g() != Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD) {
                        list = C10.O(r02.f());
                    }
                    if (list == null && str.startsWith("00")) {
                        String l10 = r02.l();
                        if (!TextUtils.isEmpty(l10)) {
                            if (l10.startsWith("00" + r02.f())) {
                                list = C10.O(r02.f());
                            }
                        }
                    }
                }
            } catch (NumberParseException e10) {
                Log.e("BlacklistUtils", e10.toString());
            }
        }
        if (list == null) {
            return a10;
        }
        if (list.contains(a10)) {
            return a10;
        }
        return list.get(0);
    }

    public static Uri o(Context context) {
        if (L.h(context, "android.permission.READ_CONTACTS")) {
            return C0855p.f29167b;
        }
        return C0847h.b.f29150d;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean p(android.content.Context r4, java.lang.String r5) {
        /*
            boolean r0 = com.oplus.utils.C0846g.c()
            java.lang.String r1 = "BlacklistUtils"
            if (r0 == 0) goto Ld
            java.lang.String r0 = "isAppInstalled begin."
            android.util.Log.d(r1, r0)
        Ld:
            r0 = 1
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newFixedThreadPool(r0)
            com.oplus.utils.i$a r2 = new com.oplus.utils.i$a
            r2.<init>(r4, r5)
            java.util.concurrent.Future r4 = r0.submit(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f java.lang.InterruptedException -> L38 java.util.concurrent.TimeoutException -> L3e
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f java.lang.InterruptedException -> L38 java.util.concurrent.TimeoutException -> L3e
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r4 = r4.get(r2, r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f java.lang.InterruptedException -> L38 java.util.concurrent.TimeoutException -> L3e
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f java.lang.InterruptedException -> L38 java.util.concurrent.TimeoutException -> L3e
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f java.lang.InterruptedException -> L38 java.util.concurrent.TimeoutException -> L3e
            r0.shutdown()
            goto L45
        L2d:
            r4 = move-exception
            goto L60
        L2f:
            java.lang.String r4 = "isAppInstalled has an error."
            android.util.Log.e(r1, r4)     // Catch: java.lang.Throwable -> L2d
        L34:
            r0.shutdown()
            goto L44
        L38:
            java.lang.String r4 = "isAppInstalled is interrupted."
            android.util.Log.e(r1, r4)     // Catch: java.lang.Throwable -> L2d
            goto L34
        L3e:
            java.lang.String r4 = "isAppInstalled is time out."
            android.util.Log.e(r1, r4)     // Catch: java.lang.Throwable -> L2d
            goto L34
        L44:
            r4 = 0
        L45:
            boolean r5 = com.oplus.utils.C0846g.c()
            if (r5 == 0) goto L5f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "isAppInstalled end. "
            r5.append(r0)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r1, r5)
        L5f:
            return r4
        L60:
            r0.shutdown()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.C0848i.p(android.content.Context, java.lang.String):boolean");
    }

    public static boolean q(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || packageManager.resolveActivity(intent, 0) == null) {
            return false;
        }
        return true;
    }

    public static boolean r(Context context) {
        try {
            if (z6.b.c(context, 2, "global_delete_sound", 1) == 0) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            Log.d("BlacklistUtils", "exception when get global Sound switch, " + e10);
            return false;
        }
    }

    public static boolean s(String str) {
        int length;
        if (str == null) {
            length = 0;
        } else {
            length = str.length();
        }
        if (length <= 0) {
            return true;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (!PhoneNumberUtils.isNonSeparator(Character.toUpperCase(str.charAt(i10)))) {
                return false;
            }
        }
        return true;
    }

    public static String t(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        int z10 = k().z(str2);
        arrayList.add("+" + z10);
        arrayList.add("00" + z10);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (str.startsWith((String) arrayList.get(i10)) && str.length() > ((String) arrayList.get(i10)).length()) {
                return str.substring(((String) arrayList.get(i10)).length());
            }
        }
        return str;
    }

    public static boolean u(Context context) {
        boolean z10;
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
        if (!defaultSharedPreferences.getString("QUERY_DAY", "").equals(format)) {
            edit.putString("QUERY_DAY", format);
            edit.apply();
            z10 = true;
        } else {
            z10 = false;
        }
        if (C0846g.c()) {
            Log.d("BlacklistUtils", "should notify = " + z10);
        }
        return z10;
    }

    public static boolean v(Context context) {
        boolean z10 = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("have_updated_intercept_rule", false);
        if (C0846g.c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("should update intercept rule = ");
            sb.append(!z10);
            Log.d("BlacklistUtils", sb.toString());
        }
        return !z10;
    }
}
