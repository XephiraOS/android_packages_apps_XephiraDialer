package com.customize.contacts.util;

import R0.c;
import R0.d;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.contacts.ContactsApplication;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.heytap.accessory.bean.BtDirectAdvertiseSetting;
import com.internal_dependency.Constants;
import com.oplus.dialer.R;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: SimCardUtils.java */
/* loaded from: classes3.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, PhoneAccountHandle> f22034a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Integer, PhoneAccountHandle> f22035b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static int f22036c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static int f22037d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static int f22038e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static String f22039f = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f22040g = "";

    /* renamed from: h, reason: collision with root package name */
    public static String f22041h = "";

    /* renamed from: i, reason: collision with root package name */
    public static String f22042i = "";

    /* renamed from: j, reason: collision with root package name */
    public static String f22043j = "";

    /* renamed from: k, reason: collision with root package name */
    public static String f22044k = "";

    /* renamed from: l, reason: collision with root package name */
    public static long f22045l = -1;

    /* renamed from: m, reason: collision with root package name */
    public static long f22046m = -1;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f22047n = false;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f22048o = false;

    /* renamed from: p, reason: collision with root package name */
    public static Boolean f22049p = null;

    /* renamed from: q, reason: collision with root package name */
    public static Boolean f22050q = null;

    /* compiled from: SimCardUtils.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f22051a;

        /* renamed from: b, reason: collision with root package name */
        public long f22052b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f22053c;

        public a(int i10, long j10, boolean z10) {
            this.f22051a = i10;
            this.f22052b = j10;
            this.f22053c = z10;
        }

        public String toString() {
            return "slot = " + this.f22051a + ", subId = " + this.f22052b + ", unavailable = " + this.f22053c;
        }
    }

    public static long A() {
        return f22045l;
    }

    public static boolean A0(int i10) {
        return "volte".equals(M7.d.a("gsm.ims.type" + i10));
    }

    public static String B() {
        return f22041h;
    }

    public static boolean B0(Context context) {
        boolean z10 = false;
        if (context == null) {
            return false;
        }
        try {
            if (G0.c.d(context, 1, "multi_sim_voice_prompt", 1) != 0) {
                z10 = true;
            }
        } catch (Exception unused) {
            H7.b.c("SimCardUtils", "get isVoicePromptEnabled error!");
        }
        H7.b.b("SimCardUtils", "isVoicePromptEnabled = " + z10);
        return z10;
    }

    public static String C() {
        return f22043j;
    }

    public static boolean C0(Context context, List<a> list) {
        boolean z10 = false;
        if (FeatureOption.i()) {
            return false;
        }
        try {
            z10 = d(context, list);
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "isWifiCallingUseable " + z10);
            }
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "isWifiCallingUseable error " + th);
        }
        return z10;
    }

    public static long D() {
        return f22046m;
    }

    public static void D0(Context context, int i10) {
        f22036c = i10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("INSERT_SIM_COUNT", i10);
        edit.apply();
    }

    public static String E() {
        return f22042i;
    }

    public static void E0(Context context, int i10) {
        if (B3.a.i()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (i10 == 0) {
                f22039f = O7.a.b(context, 0);
            } else if (i10 == 1) {
                f22040g = O7.a.b(context, 1);
            } else {
                f22039f = "";
                f22040g = "";
            }
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "getSimCardSubscriberId spend time = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public static String F() {
        return f22044k;
    }

    public static void F0(Context context, int i10, String str, long j10, String str2, String str3, long j11, String str4) {
        f22038e = i10;
        f22041h = str;
        f22042i = str3;
        f22043j = str2;
        f22044k = str4;
        f22045l = j10;
        f22046m = j11;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("SIM_COUNT", i10);
        edit.putString("SIM_1_NAME", str);
        edit.putString("SIM_2_NAME", str3);
        edit.putString("SIM_1_NUMBER", str2);
        edit.putString("SIM_2_NUMBER", str4);
        edit.putLong("SIM_1_ID", j10);
        edit.putLong("SIM_2_ID", j11);
        edit.apply();
    }

    public static int G(Context context, int i10) {
        Uri withAppendedId = ContentUris.withAppendedId(d.b.f3250h, i10);
        int i11 = -1;
        try {
            Cursor query = context.getContentResolver().query(withAppendedId, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        i11 = query.getInt(0);
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("SimCardUtils", "Exception e: " + e10);
        }
        H7.b.e("SimCardUtils", "currentUri = " + withAppendedId + ", currentStorage = " + i11);
        return i11;
    }

    public static void G0() {
        f22050q = null;
        f22049p = null;
    }

    public static int H(Context context, String str) {
        return G(context, K(context, str));
    }

    public static void H0() {
        if (B3.a.i()) {
            f22039f = "";
            f22040g = "";
        }
    }

    public static String I(Context context, int i10) {
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex;
        String str = null;
        if (B3.a.i()) {
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            if (subscriptionManager != null) {
                try {
                    activeSubscriptionInfoForSimSlotIndex = subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i10);
                } catch (Throwable th) {
                    H7.b.c("SimCardUtils", "" + th);
                }
            } else {
                activeSubscriptionInfoForSimSlotIndex = null;
            }
            if (activeSubscriptionInfoForSimSlotIndex != null && activeSubscriptionInfoForSimSlotIndex.getDisplayName() != null) {
                str = activeSubscriptionInfoForSimSlotIndex.getDisplayName().toString();
            }
        }
        if (str == null) {
            return context.getString(R.string.oplus_storage_sim);
        }
        return str;
    }

    public static Uri I0(Context context, int i10) {
        try {
            if (B3.a.o() && B3.a.i()) {
                int r10 = D7.c.r(context, Integer.valueOf(i10));
                String a10 = D7.c.a(Integer.valueOf(i10));
                if (H7.a.b()) {
                    H7.b.b("SimCardUtils", "cardType: " + a10);
                }
                if (!TextUtils.equals(a10, "USIM") && !TextUtils.equals(a10, "CSIM")) {
                    return Uri.withAppendedPath(d.b.f3246d, String.valueOf(r10));
                }
                return Uri.withAppendedPath(d.b.f3248f, String.valueOf(r10));
            }
            if (B3.a.o()) {
                if (TextUtils.equals(D7.c.a(0), "USIM")) {
                    return d.b.f3247e;
                }
                return d.b.f3245c;
            }
            if (B3.a.T()) {
                return Uri.withAppendedPath(d.b.f3246d, String.valueOf(D7.c.r(context, Integer.valueOf(i10))));
            }
            return d.b.f3245c;
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "Exception e: " + th);
            return null;
        }
    }

    public static String[] J(Context context) {
        Object obj;
        String[] strArr = new String[2];
        if (B3.a.i()) {
            for (SubscriptionInfo subscriptionInfo : e(context)) {
                H7.b.e("SimCardUtils", "simInfo.mSlot is " + subscriptionInfo.getSimSlotIndex());
                if (subscriptionInfo.getSimSlotIndex() == 0 || subscriptionInfo.getSimSlotIndex() == 1) {
                    int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                    if (subscriptionInfo.getDisplayName() != null) {
                        obj = subscriptionInfo.getDisplayName();
                    } else {
                        obj = strArr[subscriptionInfo.getSimSlotIndex()];
                    }
                    strArr[simSlotIndex] = (String) obj;
                }
            }
        }
        return strArr;
    }

    public static void J0(Context context, int i10) {
        f22037d = i10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt("ACTIVE_SIM_COUNT", f22037d);
        edit.apply();
    }

    public static int K(Context context, String str) {
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            return com.android.contacts.framework.api.appstore.simcard.a.b(context, str);
        }
        return L(context, str);
    }

    public static void K0(int i10, boolean z10) {
        if (i10 == 0) {
            f22048o = z10;
            return;
        }
        if (i10 == 1) {
            f22047n = z10;
            return;
        }
        H7.b.b("SimCardUtils", "unknown slot " + i10);
    }

    public static int L(Context context, String str) {
        Context applicationContext;
        int i10 = -1;
        if (str == null || context == null || (applicationContext = context.getApplicationContext()) == null) {
            return -1;
        }
        if (B3.a.i()) {
            if (TextUtils.isEmpty(f22039f)) {
                E0(applicationContext, 0);
            }
            if (str.equals(f22039f)) {
                return 0;
            }
            if (TextUtils.isEmpty(f22040g)) {
                E0(applicationContext, 1);
            }
            if (str.equals(f22040g)) {
                return 1;
            }
        } else {
            i10 = 0;
        }
        try {
            if (B3.a.o()) {
                if (str.equals(O7.a.b(applicationContext, 0))) {
                    return 0;
                }
                if (str.equals(O7.a.b(applicationContext, 1))) {
                    return 1;
                }
            } else {
                O7.a.b(applicationContext, 0);
            }
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "getSimCardSlotIdFromIMSI throwable = " + th);
        }
        return i10;
    }

    public static void L0(int i10) {
        f22036c = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int M(android.content.Context r10, int r11) {
        /*
            java.lang.String r0 = "SimCardUtils"
            android.net.Uri r1 = R0.d.b.f3249g
            long r2 = (long) r11
            android.net.Uri r11 = android.content.ContentUris.withAppendedId(r1, r2)
            r1 = -1
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Exception -> L2f
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            r5 = r11
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L2f
            if (r10 == 0) goto L32
            boolean r2 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L32
            r2 = 0
            int r2 = r10.getInt(r2)     // Catch: java.lang.Throwable -> L25
            goto L33
        L25:
            r2 = move-exception
            r10.close()     // Catch: java.lang.Throwable -> L2a
            goto L2e
        L2a:
            r10 = move-exception
            r2.addSuppressed(r10)     // Catch: java.lang.Exception -> L2f
        L2e:
            throw r2     // Catch: java.lang.Exception -> L2f
        L2f:
            r10 = move-exception
            r2 = r1
            goto L3a
        L32:
            r2 = r1
        L33:
            if (r10 == 0) goto L4e
            r10.close()     // Catch: java.lang.Exception -> L39
            goto L4e
        L39:
            r10 = move-exception
        L3a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception e: "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            H7.b.c(r0, r10)
        L4e:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "totalUri = "
            r10.append(r3)
            r10.append(r11)
            java.lang.String r11 = ", totalStorage = "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            H7.b.e(r0, r10)
            if (r2 > 0) goto L6d
            goto L6e
        L6d:
            r1 = r2
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.b0.M(android.content.Context, int):int");
    }

    public static void M0(Map<Integer, PhoneAccountHandle> map) {
        ConcurrentHashMap<Integer, PhoneAccountHandle> concurrentHashMap = f22034a;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(map);
    }

    public static int N(Context context, String str) {
        return M(context, com.customize.contacts.simcontacts.b.j(str));
    }

    public static void N0(Map<Integer, PhoneAccountHandle> map) {
        ConcurrentHashMap<Integer, PhoneAccountHandle> concurrentHashMap = f22035b;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(map);
    }

    public static int O() {
        return f22036c;
    }

    public static boolean O0(Context context, long j10, String str, String str2, String str3, String str4, String str5) {
        if (B3.a.o()) {
            j10++;
        }
        if (j10 <= 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(j10));
        contentValues.put("newTag", str);
        contentValues.put("newNumber", str2);
        if (FeatureOption.i()) {
            if (P0(context, str5)) {
                contentValues.put("newAnr", str3);
                contentValues.put("newEmails", str4);
            }
        } else {
            if (P0(context, str5)) {
                contentValues.put("newAnr", str3);
            }
            if (Y(context, str5)) {
                contentValues.put("newEmails", str4);
            }
        }
        try {
            boolean z10 = true;
            if (context.getContentResolver().update(I0(context, K(context, str5)), contentValues, null, null) != 1) {
                z10 = false;
            }
            H7.b.b("SimCardUtils", "update sim card contacts " + z10);
            return z10;
        } catch (SecurityException e10) {
            H7.b.c("SimCardUtils", "Update a simcard contact failed : SecurityException!" + e10.toString());
            return false;
        } catch (Exception e11) {
            H7.b.c("SimCardUtils", "Update a simcard contact failed : Exception!" + e11.toString());
            return false;
        }
    }

    public static void P(SharedPreferences sharedPreferences) {
        f22036c = sharedPreferences.getInt("INSERT_SIM_COUNT", 0);
        f22037d = sharedPreferences.getInt("ACTIVE_SIM_COUNT", 0);
        f22038e = sharedPreferences.getInt("SIM_COUNT", 0);
        f22041h = sharedPreferences.getString("SIM_1_NAME", "");
        f22042i = sharedPreferences.getString("SIM_2_NAME", "");
        f22043j = sharedPreferences.getString("SIM_1_NUMBER", "");
        f22044k = sharedPreferences.getString("SIM_2_NUMBER", "");
        f22045l = sharedPreferences.getLong("SIM_1_ID", -1L);
        f22046m = sharedPreferences.getLong("SIM_2_ID", -1L);
    }

    public static boolean P0(Context context, String str) {
        try {
            int K10 = K(context, str);
            boolean z10 = true;
            if (B3.a.i()) {
                String a10 = D7.c.a(Integer.valueOf(K10));
                if (TextUtils.isEmpty(a10)) {
                    return false;
                }
                if (a10.equalsIgnoreCase("USIM")) {
                    if (!FeatureOption.i() && !X(context, str)) {
                        return false;
                    }
                    return true;
                }
                if (a10.equalsIgnoreCase("CSIM")) {
                    try {
                        Cursor query = context.getContentResolver().query(ContentUris.withAppendedId(d.b.f3252j, D7.c.r(context, Integer.valueOf(K10))), null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.moveToFirst()) {
                                    if (query.getInt(4) <= 0) {
                                        z10 = false;
                                    }
                                    query.close();
                                    return z10;
                                }
                            } catch (Throwable th) {
                                if (query != null) {
                                    try {
                                        query.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                    } catch (Exception e10) {
                        H7.b.c("SimCardUtils", "Exception e: " + e10);
                    }
                }
                return false;
            }
            if (B3.a.o()) {
                if (!TextUtils.equals(D7.c.a(0), "USIM") || (!FeatureOption.i() && !X(context, str))) {
                    return false;
                }
                return true;
            }
            String a11 = D7.c.a(0);
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "single card vstr: " + a11);
            }
            if (TextUtils.isEmpty(a11) || !"USIM".equalsIgnoreCase(a11)) {
                return false;
            }
            return true;
        } catch (Throwable th3) {
            H7.b.c("SimCardUtils", "Exception e: " + th3);
            return false;
        }
    }

    public static int Q(Context context, int i10) {
        TelephonyManager telephonyManager;
        int i11 = -1;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService(TelephonyManager.class);
        } catch (Exception e10) {
            H7.b.c("SimCardUtils", "hasNoSimService: exception: " + e10);
        }
        if (telephonyManager == null) {
            H7.b.i("SimCardUtils", "hasNoSimService: manager is null.");
            return -1;
        }
        PhoneAccountHandle s10 = s(context, i10);
        if (s10 != null) {
            TelephonyManager createForPhoneAccountHandle = telephonyManager.createForPhoneAccountHandle(s10);
            if (createForPhoneAccountHandle != null) {
                i11 = createForPhoneAccountHandle.getServiceState().getState();
                H7.b.e("SimCardUtils", "hasNoSimService: slot: " + i10 + ", state: " + i11 + ", state: " + i11);
            } else {
                H7.b.i("SimCardUtils", "hasNoSimService: telephonyManager is null.");
            }
        } else {
            H7.b.i("SimCardUtils", "hasNoSimService: phoneAccountHandle is null.");
        }
        H7.b.e("SimCardUtils", "hasNoSimService: slot: " + i10 + ", state: " + i11);
        return i11;
    }

    public static boolean Q0(Context context, String str) {
        if (Y(context, str) && X(context, str)) {
            return true;
        }
        return false;
    }

    public static int R(Context context, int i10) {
        return S(context, D7.c.r(context, Integer.valueOf(i10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int S(android.content.Context r10, int r11) {
        /*
            java.lang.String r0 = "SimCardUtils"
            android.net.Uri r1 = R0.d.b.f3252j
            long r2 = (long) r11
            android.net.Uri r11 = android.content.ContentUris.withAppendedId(r1, r2)
            r1 = -1
            android.content.ContentResolver r4 = r10.getContentResolver()     // Catch: java.lang.Exception -> L4a
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            r5 = r11
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L4a
            if (r10 == 0) goto L4e
            boolean r2 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L3e
            if (r2 == 0) goto L4e
            r2 = 0
            int r3 = r10.getInt(r2)     // Catch: java.lang.Throwable -> L3e
            r4 = 1
            int r5 = r10.getInt(r4)     // Catch: java.lang.Throwable -> L3e
            r6 = 2
            int r6 = r10.getInt(r6)     // Catch: java.lang.Throwable -> L3e
            r7 = 3
            int r7 = r10.getInt(r7)     // Catch: java.lang.Throwable -> L3e
            if (r3 != r5) goto L38
            if (r5 <= 0) goto L38
            goto L4f
        L38:
            if (r7 < r6) goto L4e
            if (r6 <= 0) goto L4e
            r2 = r4
            goto L4f
        L3e:
            r2 = move-exception
            if (r10 == 0) goto L4d
            r10.close()     // Catch: java.lang.Throwable -> L45
            goto L4d
        L45:
            r10 = move-exception
            r2.addSuppressed(r10)     // Catch: java.lang.Exception -> L4a
            goto L4d
        L4a:
            r10 = move-exception
            r2 = r1
            goto L56
        L4d:
            throw r2     // Catch: java.lang.Exception -> L4a
        L4e:
            r2 = r1
        L4f:
            if (r10 == 0) goto L6a
            r10.close()     // Catch: java.lang.Exception -> L55
            goto L6a
        L55:
            r10 = move-exception
        L56:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Exception e: "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            H7.b.c(r0, r10)
        L6a:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "totalUri = "
            r10.append(r3)
            r10.append(r11)
            java.lang.String r11 = ", totalStates = "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            H7.b.e(r0, r10)
            if (r2 >= 0) goto L89
            goto L8a
        L89:
            r1 = r2
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.b0.S(android.content.Context, int):int");
    }

    public static boolean T(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || !telephonyManager.hasIccCard()) {
                return false;
            }
            if (W(context)) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            H7.b.c("SimCardUtils", "hasIccCard Exception: " + e10);
        }
        return false;
    }

    public static boolean U(Context context, int i10) {
        if (B3.a.i()) {
            return u0(context, i10);
        }
        return T(context);
    }

    public static boolean V(Context context) {
        if (B3.a.i()) {
            if (!u0(context, 0) && !u0(context, 1)) {
                return false;
            }
            return true;
        }
        return T(context);
    }

    public static boolean W(Context context) {
        boolean z10;
        try {
            z10 = D7.c.j();
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "hasSoftSimCard throwable = " + th);
            z10 = false;
        }
        H7.b.b("SimCardUtils", "hasSoftSimCard " + z10);
        return z10;
    }

    public static boolean X(Context context, String str) {
        int K10 = K(context, str);
        boolean z10 = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("max_anr" + K10, false);
        H7.b.b("SimCardUtils", "isSupportAnr, the isSupportAnr is " + z10);
        return z10;
    }

    public static boolean Y(Context context, String str) {
        int K10 = K(context, str);
        boolean z10 = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("max_email" + K10, false);
        H7.b.b("SimCardUtils", "isSupportEmail, the isSupportEmail is " + z10);
        return z10;
    }

    public static Uri Z(Context context, String str, String str2, String str3, String str4, int i10, boolean z10) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        boolean isEmpty3 = TextUtils.isEmpty(str3);
        boolean isEmpty4 = TextUtils.isEmpty(str4);
        if (isEmpty) {
            str = "";
        }
        if (isEmpty2) {
            str2 = "";
        }
        if (isEmpty3) {
            str3 = "";
        }
        if (isEmpty4) {
            str4 = "";
        }
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("tag", str);
        contentValues.put("number", str2);
        if (FeatureOption.i()) {
            if (z10) {
                contentValues.put("anr", str3);
                contentValues.put("emails", str4);
            }
        } else {
            if (z10) {
                contentValues.put("anr", str3);
            }
            contentValues.put("emails", str4);
        }
        try {
            Uri insert = context.getContentResolver().insert(I0(context, i10), contentValues);
            H7.b.e("SimCardUtils", "resultUri = " + insert);
            return insert;
        } catch (SecurityException e10) {
            H7.b.c("SimCardUtils", "Insert a simcard contact failed : SecurityException " + e10.toString());
            return null;
        } catch (Exception e11) {
            H7.b.c("SimCardUtils", "Insert a simcard contact failed : Exception " + e11.toString());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x0112, code lost:
    
        if (r3.c() != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0033, code lost:
    
        r16 = r4;
        r17 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x003c, code lost:
    
        if (r11.f22052b != r20) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x020a, code lost:
    
        if (c0(r18, r10.f22052b) != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0241, code lost:
    
        if (r5.c() != false) goto L130;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b1 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:3:0x0006, B:4:0x000f, B:7:0x001c, B:9:0x0024, B:13:0x003e, B:15:0x0044, B:16:0x006e, B:18:0x0074, B:19:0x0084, B:22:0x0092, B:25:0x0098, B:26:0x00ae, B:28:0x00b4, B:31:0x00d0, B:41:0x017c, B:43:0x0182, B:46:0x01a2, B:48:0x01a8, B:49:0x01b8, B:59:0x01c9, B:62:0x01cf, B:63:0x01e2, B:65:0x01e8, B:68:0x0204, B:71:0x0295, B:73:0x029b, B:77:0x01da, B:79:0x0214, B:80:0x0221, B:82:0x0227, B:85:0x023d, B:90:0x0256, B:91:0x0269, B:93:0x026f, B:96:0x028b, B:100:0x0261, B:104:0x024b, B:108:0x021b, B:110:0x01b1, B:118:0x00a3, B:122:0x00e5, B:123:0x00f2, B:125:0x00f8, B:128:0x010e, B:133:0x0126, B:134:0x013c, B:136:0x0142, B:139:0x015e, B:144:0x0131, B:150:0x011a, B:154:0x00ec, B:159:0x007c, B:161:0x0033), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0182 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:3:0x0006, B:4:0x000f, B:7:0x001c, B:9:0x0024, B:13:0x003e, B:15:0x0044, B:16:0x006e, B:18:0x0074, B:19:0x0084, B:22:0x0092, B:25:0x0098, B:26:0x00ae, B:28:0x00b4, B:31:0x00d0, B:41:0x017c, B:43:0x0182, B:46:0x01a2, B:48:0x01a8, B:49:0x01b8, B:59:0x01c9, B:62:0x01cf, B:63:0x01e2, B:65:0x01e8, B:68:0x0204, B:71:0x0295, B:73:0x029b, B:77:0x01da, B:79:0x0214, B:80:0x0221, B:82:0x0227, B:85:0x023d, B:90:0x0256, B:91:0x0269, B:93:0x026f, B:96:0x028b, B:100:0x0261, B:104:0x024b, B:108:0x021b, B:110:0x01b1, B:118:0x00a3, B:122:0x00e5, B:123:0x00f2, B:125:0x00f8, B:128:0x010e, B:133:0x0126, B:134:0x013c, B:136:0x0142, B:139:0x015e, B:144:0x0131, B:150:0x011a, B:154:0x00ec, B:159:0x007c, B:161:0x0033), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a8 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:3:0x0006, B:4:0x000f, B:7:0x001c, B:9:0x0024, B:13:0x003e, B:15:0x0044, B:16:0x006e, B:18:0x0074, B:19:0x0084, B:22:0x0092, B:25:0x0098, B:26:0x00ae, B:28:0x00b4, B:31:0x00d0, B:41:0x017c, B:43:0x0182, B:46:0x01a2, B:48:0x01a8, B:49:0x01b8, B:59:0x01c9, B:62:0x01cf, B:63:0x01e2, B:65:0x01e8, B:68:0x0204, B:71:0x0295, B:73:0x029b, B:77:0x01da, B:79:0x0214, B:80:0x0221, B:82:0x0227, B:85:0x023d, B:90:0x0256, B:91:0x0269, B:93:0x026f, B:96:0x028b, B:100:0x0261, B:104:0x024b, B:108:0x021b, B:110:0x01b1, B:118:0x00a3, B:122:0x00e5, B:123:0x00f2, B:125:0x00f8, B:128:0x010e, B:133:0x0126, B:134:0x013c, B:136:0x0142, B:139:0x015e, B:144:0x0131, B:150:0x011a, B:154:0x00ec, B:159:0x007c, B:161:0x0033), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c9 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:3:0x0006, B:4:0x000f, B:7:0x001c, B:9:0x0024, B:13:0x003e, B:15:0x0044, B:16:0x006e, B:18:0x0074, B:19:0x0084, B:22:0x0092, B:25:0x0098, B:26:0x00ae, B:28:0x00b4, B:31:0x00d0, B:41:0x017c, B:43:0x0182, B:46:0x01a2, B:48:0x01a8, B:49:0x01b8, B:59:0x01c9, B:62:0x01cf, B:63:0x01e2, B:65:0x01e8, B:68:0x0204, B:71:0x0295, B:73:0x029b, B:77:0x01da, B:79:0x0214, B:80:0x0221, B:82:0x0227, B:85:0x023d, B:90:0x0256, B:91:0x0269, B:93:0x026f, B:96:0x028b, B:100:0x0261, B:104:0x024b, B:108:0x021b, B:110:0x01b1, B:118:0x00a3, B:122:0x00e5, B:123:0x00f2, B:125:0x00f8, B:128:0x010e, B:133:0x0126, B:134:0x013c, B:136:0x0142, B:139:0x015e, B:144:0x0131, B:150:0x011a, B:154:0x00ec, B:159:0x007c, B:161:0x0033), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r18, java.util.List<com.customize.contacts.util.b0.a> r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.b0.a(android.content.Context, java.util.List, int, boolean):boolean");
    }

    public static boolean a0(Context context) {
        if (!q0(0) || !q0(1)) {
            return false;
        }
        return true;
    }

    public static boolean b(Context context, int i10) {
        boolean z10 = false;
        try {
            boolean o10 = D7.c.o(context, Integer.valueOf(i10));
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "checkVideoCallingStatus isVtEnabledByPlatform = " + o10);
            }
            if (o10) {
                z10 = C7.b.b() ? T8.a.a(i10).d() : L6.a.a(i10).d();
            }
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "checkVideoCallingStatus throwable " + th);
        }
        if (H7.a.b()) {
            H7.b.b("SimCardUtils", "checkVideoCallingStatus isVideoCallingChecked = " + z10);
        }
        return z10;
    }

    public static boolean b0(Context context, int i10) {
        boolean z10;
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex = SubscriptionManager.from(context).getActiveSubscriptionInfoForSimSlotIndex(i10);
        boolean z11 = true;
        boolean z12 = false;
        if (activeSubscriptionInfoForSimSlotIndex != null) {
            int carrierId = activeSubscriptionInfoForSimSlotIndex.getCarrierId();
            if (H7.a.b()) {
                StringBuilder sb = new StringBuilder();
                sb.append("isCTCCCard: carrierId = ");
                sb.append(carrierId);
                sb.append(", ");
                if (carrierId == 2237) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                sb.append(z10);
                H7.b.b("SimCardUtils", sb.toString());
            }
            if (v0(context, i10)) {
                return false;
            }
            if (carrierId == 2237) {
                return true;
            }
            if (carrierId == 1435 || carrierId == 1436 || carrierId == 1911) {
                return false;
            }
        }
        try {
            String a10 = D7.c.a(Integer.valueOf(i10));
            if (!"CSIM".equals(a10)) {
                if (!"RUIM".equals(a10)) {
                    z11 = false;
                }
            }
            try {
                H7.b.b("SimCardUtils", "isCTCCCard: iccCardType = " + a10 + ", slotId = " + i10 + ", flag = " + z11);
                return z11;
            } catch (Throwable th) {
                th = th;
                z12 = z11;
                H7.b.c("SimCardUtils", "Exception e: " + th);
                return z12;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bb, code lost:
    
        if (r7.c() != false) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(android.content.Context r14, java.util.List<com.customize.contacts.util.b0.a> r15) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.b0.c(android.content.Context, java.util.List):boolean");
    }

    public static boolean c0(Context context, long j10) {
        PersistableBundle persistableBundle;
        PersistableBundle a10;
        boolean z10 = false;
        if (j10 < 0) {
            H7.b.b("SimCardUtils", "isCarrierViwifiSupport: false (subId < 0)");
            return false;
        }
        CarrierConfigManager carrierConfigManager = (CarrierConfigManager) context.getSystemService("carrier_config");
        if (carrierConfigManager != null) {
            persistableBundle = carrierConfigManager.getConfigForSubId((int) j10);
        } else {
            persistableBundle = null;
        }
        String b10 = com.android.contacts.compat.data.f.b(Constants.CONFIG_OPLUS_SUPPORT_VIWIFI_BOOL);
        if (persistableBundle != null) {
            b10 = z(b10, persistableBundle);
            z10 = persistableBundle.getBoolean(b10);
        } else if (J3.a.a() != null && (a10 = J3.a.a()) != null) {
            b10 = z(b10, a10);
            z10 = a10.getBoolean(b10);
        }
        if (H7.a.b()) {
            H7.b.b("SimCardUtils", "getBooleanCarrierConfig: key = " + b10 + ", subId " + j10 + ", config = " + z10);
        }
        return z10;
    }

    public static boolean d(Context context, List<a> list) {
        L6.a a10;
        boolean z10;
        boolean z11;
        boolean equals;
        boolean z12;
        try {
            boolean z13 = false;
            for (a aVar : list) {
                T8.a aVar2 = null;
                if (C7.b.b()) {
                    aVar2 = T8.a.a(aVar.f22051a);
                    a10 = null;
                } else {
                    a10 = L6.a.a(aVar.f22051a);
                }
                if (aVar2 != null) {
                    z10 = aVar2.f();
                    z11 = aVar2.e();
                } else if (a10 != null) {
                    z10 = a10.f();
                    z11 = a10.e();
                } else {
                    z10 = false;
                    z11 = false;
                }
                if (aVar.f22051a == 0) {
                    equals = M7.d.b("gsm.ims.type0", "volte").equals("vowifi");
                } else {
                    equals = M7.d.b("gsm.ims.type1", "volte").equals("vowifi");
                }
                if (aVar2 != null) {
                    z12 = aVar2.c();
                } else if (a10 != null) {
                    z12 = a10.c();
                } else {
                    z12 = false;
                }
                if (H7.a.b()) {
                    H7.b.b("SimCardUtils", "info.mSlotId = " + aVar.f22051a + ", isWfcEnabledByUser = " + z10 + ", isWfcEnabledByPlatform = " + z11 + ", simWifiActive = " + equals + ", isVtEnabledByPlatform = " + z12);
                }
                if (z10 && z11 && equals) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    break;
                }
            }
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "checkVolteStatus isViWifiChecked = " + z13);
            }
            return z13;
        } catch (Exception e10) {
            H7.b.c("SimCardUtils", "Exception when checkWifiCallingStatus : " + e10);
            return false;
        }
    }

    public static boolean d0(Context context, int i10) {
        if (!b0(context, i10) && !j0(context, i10)) {
            return false;
        }
        if (H7.a.b()) {
            H7.b.b("SimCardUtils", "isCtccOrSatelliteSim: " + i10);
            return true;
        }
        return true;
    }

    public static List<SubscriptionInfo> e(Context context) {
        List<SubscriptionInfo> list = null;
        try {
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            if (subscriptionManager != null) {
                list = subscriptionManager.getActiveSubscriptionInfoList();
            }
            if (list != null) {
                for (SubscriptionInfo subscriptionInfo : list) {
                    if (v0(context, subscriptionInfo.getSimSlotIndex())) {
                        list.remove(subscriptionInfo);
                        return list;
                    }
                }
            }
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "" + th);
        }
        if (list == null) {
            return new ArrayList();
        }
        return list;
    }

    public static boolean e0(Context context, int i10) {
        if (i10 == -1) {
            return false;
        }
        String r10 = r(context, D7.c.q(context, Integer.valueOf(i10)));
        if (TextUtils.isEmpty(r10)) {
            return false;
        }
        return r10.startsWith("460");
    }

    public static boolean f(Context context, long j10, String str) {
        if (B3.a.o()) {
            j10++;
        }
        if (j10 <= 0) {
            return false;
        }
        String str2 = "id='" + j10 + "'";
        ContentResolver contentResolver = context.getContentResolver();
        Uri I02 = I0(context, K(context, str));
        try {
            int delete = contentResolver.delete(I02, str2, null);
            boolean z10 = true;
            if (delete != 1) {
                z10 = false;
            }
            H7.b.e("SimCardUtils", "deleteSimCardContact simUri = " + I02 + ", simId = " + j10 + ", success = " + z10);
            return z10;
        } catch (SecurityException e10) {
            H7.b.c("SimCardUtils", "Delete a simcard contact failed : SecurityException!" + e10.toString());
            return false;
        } catch (Exception e11) {
            H7.b.c("SimCardUtils", "Delete a simcard contact failed : Exception!" + e11.toString());
            return false;
        }
    }

    public static boolean f0(Context context) {
        if (context == null) {
            H7.b.i("SimCardUtils", "isDualLteSupportedByPlatform return true for context is null!");
            return true;
        }
        try {
            boolean h10 = D7.c.h();
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "isDualLteSupportedByPlatform isSupported = " + h10);
            }
            return h10;
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "isDualLteSupportedByPlatform throwable = " + th);
            return false;
        }
    }

    public static boolean g(Context context, ContentResolver contentResolver, long j10, Uri uri) {
        if (B3.a.o()) {
            j10++;
        }
        boolean z10 = false;
        if (j10 <= 0) {
            return false;
        }
        try {
            if (contentResolver.delete(uri, "id='" + j10 + "'", null) == 1) {
                z10 = true;
            }
            H7.b.e("SimCardUtils", "deleteSimCardContact simUri = " + uri + ", simId = " + j10 + ", success = " + z10);
        } catch (SecurityException e10) {
            H7.b.c("SimCardUtils", "Delete a simcard contact failed : SecurityException!" + e10.toString());
        } catch (Exception e11) {
            H7.b.c("SimCardUtils", "Delete a simcard contact failed : Exception!" + e11.toString());
        }
        return z10;
    }

    public static boolean g0(String str) {
        if (TextUtils.isEmpty(str) || str.length() == str.getBytes().length) {
            return false;
        }
        return true;
    }

    public static int h() {
        return f22037d;
    }

    public static boolean h0(int i10) {
        String b10 = M7.d.b("gsm.ims.type" + i10, "");
        H7.b.b("SimCardUtils", "slotId = " + i10 + "  imsType = " + b10);
        if (!"volte".equals(b10) && !"vowifi".equals(b10)) {
            return false;
        }
        return true;
    }

    public static boolean i(Context context) {
        if (com.android.contacts.framework.api.satellite.a.e()) {
            if (H7.a.b()) {
                H7.b.i("SimCardUtils", "getAutoCallBack: satellite mode, ignore auto call back.");
            }
            return false;
        }
        int d10 = G0.c.d(context, 1, c.a.f3202h, 0);
        H7.b.b("SimCardUtils", "getAutoCallBack autoCallBack=" + d10);
        if (d10 != 1) {
            return false;
        }
        return true;
    }

    public static boolean i0(Context context) {
        boolean z10 = false;
        if (context == null) {
            return false;
        }
        if (h0(0) || h0(1)) {
            z10 = true;
        }
        H7.b.b("SimCardUtils", "isImsRegistered = " + z10);
        return z10;
    }

    public static int j() {
        return f22038e;
    }

    public static boolean j0(Context context, int i10) {
        boolean equals = "46059".equals(r(context, i10));
        if (H7.a.b()) {
            H7.b.b("SimCardUtils", "isSatelliteCard: " + equals + ", slotId: " + i10);
        }
        return equals;
    }

    public static int k(Context context) {
        try {
            int defaultVoiceSubscriptionId = SubscriptionManager.getDefaultVoiceSubscriptionId();
            int slotIndex = SubscriptionManager.getSlotIndex(defaultVoiceSubscriptionId);
            H7.b.b("SimCardUtils", "getDefaultVoiceSlotId defaultVoiceSubId = " + defaultVoiceSubscriptionId + " defaultVoiceSlotId = " + slotIndex);
            if (slotIndex == 0 || slotIndex == 1) {
                return slotIndex;
            }
            return 0;
        } catch (Exception e10) {
            H7.b.c("SimCardUtils", "Exception in getDefaultVoiceSlotId " + e10);
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean k0(android.content.Context r3, int r4) {
        /*
            boolean r0 = B3.a.i()
            java.lang.String r1 = "SimCardUtils"
            r2 = 0
            if (r0 == 0) goto L28
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L12
            int r3 = D7.c.c(r3)     // Catch: java.lang.Throwable -> L12
            goto L4b
        L12:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Throw an exception while getSimStateGemini"
            r4.append(r0)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            H7.b.c(r1, r3)
            goto L4a
        L28:
            java.lang.Class<android.telephony.TelephonyManager> r4 = android.telephony.TelephonyManager.class
            java.lang.Object r3 = r3.getSystemService(r4)     // Catch: java.lang.Exception -> L35
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch: java.lang.Exception -> L35
            int r3 = r3.getSimState()     // Catch: java.lang.Exception -> L35
            goto L4b
        L35:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Throw an exception while getSimState"
            r4.append(r0)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            H7.b.c(r1, r3)
        L4a:
            r3 = r2
        L4b:
            boolean r4 = H7.a.b()
            if (r4 == 0) goto L71
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "isGeminiSupported : "
            r4.append(r0)
            boolean r0 = B3.a.i()
            r4.append(r0)
            java.lang.String r0 = ", nowSimState : "
            r4.append(r0)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            H7.b.b(r1, r4)
        L71:
            r4 = 1
            if (r4 != r3) goto L75
            r2 = r4
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.b0.k0(android.content.Context, int):boolean");
    }

    public static String l(String str, int i10, int i11) {
        int n10 = n(str, i11);
        if (n10 < 0) {
            return str;
        }
        if (str.length() > n10) {
            str = str.substring(0, n10);
        }
        return str.trim();
    }

    public static boolean l0(Context context) {
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            return com.android.contacts.framework.api.appstore.simcard.a.d(context);
        }
        return o0(context);
    }

    public static int m(String str, String str2, int i10) {
        if (!TextUtils.isEmpty(str2)) {
            return i10 - (str.length() - str2.length());
        }
        return i10 / 2;
    }

    public static boolean m0(Context context, int i10) {
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            return com.android.contacts.framework.api.appstore.simcard.a.e(context, i10);
        }
        return p0(context, i10);
    }

    public static int n(String str, int i10) {
        int i11;
        boolean z10;
        int length = str.length();
        if (TextUtils.isEmpty(str)) {
            return i10;
        }
        String replaceAll = str.replaceAll("[\\|\\\\\\[\\]{}~\\^]*", "");
        if (!TextUtils.isEmpty(replaceAll)) {
            i11 = replaceAll.length();
        } else {
            i11 = 0;
        }
        if (i11 < length) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (w0(str) && !z10) {
            return m(str, replaceAll, i10);
        }
        try {
            byte[] bytes = str.getBytes("utf-16be");
            return o(bytes, 0, bytes.length, i10, z10);
        } catch (UnsupportedEncodingException e10) {
            H7.b.c("SimCardUtils", "unsurport encoding." + e10);
            return i10;
        }
    }

    public static boolean n0(Context context, String str) {
        int K10;
        if (B3.a.i()) {
            String b10 = O7.a.b(context, 0);
            if (str != null && str.equals(b10)) {
                K10 = 0;
            } else {
                K10 = -1;
            }
            String b11 = O7.a.b(context, 1);
            if (str != null && str.equals(b11)) {
                K10 = 1;
            }
        } else {
            K10 = K(context, str);
        }
        if (K10 == -1) {
            return false;
        }
        return m0(context, K10);
    }

    public static int o(byte[] bArr, int i10, int i11, int i12, boolean z10) {
        if (z10) {
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "ifContainSepcailChar is true, We should use 80 format");
            }
            return (i12 - 1) / 2;
        }
        int i13 = 32767;
        int i14 = 0;
        if (i11 >= 2) {
            int i15 = 0;
            while (true) {
                if (i14 < i11) {
                    int i16 = i10 + i14;
                    int i17 = bArr[i16];
                    if (i17 != 0) {
                        int i18 = (bArr[i16 + 1] & 255) | ((i17 << 8) & 65280);
                        if (i13 > i18) {
                            i13 = i18;
                        }
                        if (i15 < i18) {
                            i15 = i18;
                        }
                    } else if ((bArr[i16 + 1] & BtDirectAdvertiseSetting.FLAG_PAIRING_STATE) != 0) {
                        i14 = i13 + 130;
                        break;
                    }
                    i14 += 2;
                } else {
                    i14 = i15;
                    break;
                }
            }
        }
        if (H7.a.b()) {
            H7.b.b("SimCardUtils", "at last the max is " + i14 + ",the min is " + i13);
        }
        if (i14 - i13 < 128) {
            if (((byte) (i13 & 128)) == ((byte) (i14 & 128))) {
                if (H7.a.b()) {
                    H7.b.b("SimCardUtils", "We should use 81 format");
                }
                return i12 - 3;
            }
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "We should use 82 format");
            }
            return i12 - 4;
        }
        return (i12 - 1) / 2;
    }

    public static boolean o0(Context context) {
        if ((!m0(context, 0) || v0(context, 0) || k0(context, 0)) && (!m0(context, 1) || v0(context, 1) || k0(context, 1))) {
            return false;
        }
        return true;
    }

    public static int p(Context context, int i10, boolean z10) {
        int i11 = -1;
        try {
            Cursor query = context.getContentResolver().query(ContentUris.withAppendedId(d.b.f3251i, i10), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        i11 = query.getInt(0);
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e10) {
            H7.b.c("SimCardUtils", "Exception e: " + e10);
        }
        if (H7.a.b()) {
            H7.b.b("SimCardUtils", "getMaxNameLenOfSimCard slotId = " + i10 + ", length = " + i11);
        }
        if (z10 && i11 > 14) {
            return 14;
        }
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0067 A[Catch: all -> 0x001c, TryCatch #0 {all -> 0x001c, blocks: (B:24:0x0006, B:26:0x000a, B:28:0x0014, B:31:0x001f, B:13:0x0045, B:15:0x0067, B:22:0x0070, B:4:0x0028, B:6:0x002c, B:8:0x0036, B:11:0x003f), top: B:23:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean p0(android.content.Context r4, int r5) {
        /*
            java.lang.String r0 = "SimCardUtils"
            r1 = 1
            r2 = 0
            if (r5 != 0) goto L26
            java.lang.Boolean r3 = com.customize.contacts.util.b0.f22049p     // Catch: java.lang.Throwable -> L1c
            if (r3 != 0) goto L26
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L1c
            boolean r3 = D7.c.n(r3)     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L1e
            boolean r4 = v0(r4, r5)     // Catch: java.lang.Throwable -> L1c
            if (r4 != 0) goto L1e
            r4 = r1
            goto L1f
        L1c:
            r4 = move-exception
            goto L77
        L1e:
            r4 = r2
        L1f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L1c
            com.customize.contacts.util.b0.f22049p = r4     // Catch: java.lang.Throwable -> L1c
            goto L45
        L26:
            if (r5 != r1) goto L45
            java.lang.Boolean r3 = com.customize.contacts.util.b0.f22050q     // Catch: java.lang.Throwable -> L1c
            if (r3 != 0) goto L45
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L1c
            boolean r3 = D7.c.n(r3)     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L3e
            boolean r4 = v0(r4, r5)     // Catch: java.lang.Throwable -> L1c
            if (r4 != 0) goto L3e
            r4 = r1
            goto L3f
        L3e:
            r4 = r2
        L3f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L1c
            com.customize.contacts.util.b0.f22050q = r4     // Catch: java.lang.Throwable -> L1c
        L45:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            r4.<init>()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r3 = "is sim card active : "
            r4.append(r3)     // Catch: java.lang.Throwable -> L1c
            java.lang.Boolean r3 = com.customize.contacts.util.b0.f22049p     // Catch: java.lang.Throwable -> L1c
            r4.append(r3)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r3 = " sim2: "
            r4.append(r3)     // Catch: java.lang.Throwable -> L1c
            java.lang.Boolean r3 = com.customize.contacts.util.b0.f22050q     // Catch: java.lang.Throwable -> L1c
            r4.append(r3)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L1c
            H7.b.b(r0, r4)     // Catch: java.lang.Throwable -> L1c
            if (r5 != 0) goto L6e
            java.lang.Boolean r4 = com.customize.contacts.util.b0.f22049p     // Catch: java.lang.Throwable -> L1c
            boolean r2 = r4.booleanValue()     // Catch: java.lang.Throwable -> L1c
            goto L8b
        L6e:
            if (r5 != r1) goto L8b
            java.lang.Boolean r4 = com.customize.contacts.util.b0.f22050q     // Catch: java.lang.Throwable -> L1c
            boolean r2 = r4.booleanValue()     // Catch: java.lang.Throwable -> L1c
            goto L8b
        L77:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = ""
            r1.append(r3)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            H7.b.c(r0, r4)
        L8b:
            boolean r4 = H7.a.b()
            if (r4 == 0) goto Lad
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "isSimCardAvailable() slotId:"
            r4.append(r1)
            r4.append(r5)
            java.lang.String r5 = ", isAvailable:"
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            H7.b.e(r0, r4)
        Lad:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.util.b0.p0(android.content.Context, int):boolean");
    }

    public static int q(Context context, String str, String str2) {
        return p(context, K(context, str2), FeatureOption.i());
    }

    public static boolean q0(int i10) {
        if (i10 == 0) {
            if (!m0(ContactsApplication.h(), 0) || f22048o) {
                return true;
            }
            return false;
        }
        if (i10 == 1) {
            if (!m0(ContactsApplication.h(), 1) || f22047n) {
                return true;
            }
            return false;
        }
        H7.b.b("SimCardUtils", "unknown slot " + i10);
        return false;
    }

    public static String r(Context context, int i10) {
        if (context == null) {
            return null;
        }
        return J3.c.a(i10, OplusPhoneUtils.PROPERTY_ICC_OPERATOR_NUMERIC, "");
    }

    public static boolean r0(Context context, String str) {
        int j10 = com.customize.contacts.simcontacts.b.j(str);
        int M10 = M(context, j10);
        if (M10 == -1 || G(context, j10) < M10) {
            return false;
        }
        return true;
    }

    public static PhoneAccountHandle s(Context context, int i10) {
        ConcurrentHashMap<Integer, PhoneAccountHandle> concurrentHashMap = f22034a;
        PhoneAccountHandle phoneAccountHandle = concurrentHashMap.get(Integer.valueOf(i10));
        if (phoneAccountHandle == null && O() > 1 && (phoneAccountHandle = u(context, i10)) != null) {
            concurrentHashMap.put(Integer.valueOf(i10), phoneAccountHandle);
        }
        return phoneAccountHandle;
    }

    public static boolean s0(Context context, int i10) {
        boolean z10;
        try {
            z10 = D7.c.i(Integer.valueOf(i10));
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "isSimCardNetworkRoaming throwable = " + th);
            z10 = false;
        }
        if (H7.a.b()) {
            H7.b.b("SimCardUtils", "slotId = " + i10 + ", isNetWorkRoaming = " + z10);
        }
        return z10;
    }

    public static PhoneAccountHandle t(Context context, int i10) {
        ConcurrentHashMap<Integer, PhoneAccountHandle> concurrentHashMap = f22035b;
        PhoneAccountHandle phoneAccountHandle = concurrentHashMap.get(Integer.valueOf(i10));
        if (phoneAccountHandle == null && O() > 1 && (phoneAccountHandle = u(context, D7.c.q(context, Integer.valueOf(i10)))) != null) {
            concurrentHashMap.put(Integer.valueOf(i10), phoneAccountHandle);
        }
        return phoneAccountHandle;
    }

    public static boolean t0(Context context, int i10) {
        return !m0(context, i10);
    }

    public static PhoneAccountHandle u(Context context, int i10) {
        if (!x0(i10)) {
            return null;
        }
        try {
            SubscriptionInfo activeSubscriptionInfoForSimSlotIndex = ((SubscriptionManager) context.getSystemService(SubscriptionManager.class)).getActiveSubscriptionInfoForSimSlotIndex(i10);
            if (activeSubscriptionInfoForSimSlotIndex != null) {
                List<PhoneAccountHandle> callCapablePhoneAccounts = ((TelecomManager) context.getSystemService("telecom")).getCallCapablePhoneAccounts();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(TelephonyManager.class);
                for (int i11 = 0; i11 < callCapablePhoneAccounts.size(); i11++) {
                    PhoneAccountHandle phoneAccountHandle = callCapablePhoneAccounts.get(i11);
                    if (telephonyManager.getSubscriptionId(phoneAccountHandle) == activeSubscriptionInfoForSimSlotIndex.getSubscriptionId()) {
                        return phoneAccountHandle;
                    }
                }
            }
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "getPhoneAccountHandleToDualCall: exception: " + th);
        }
        return null;
    }

    public static boolean u0(Context context, int i10) {
        try {
            if (!D7.c.g(Integer.valueOf(i10))) {
                return false;
            }
            if (v0(context, i10)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "isSimInsert is error, the e is " + th);
            return false;
        }
    }

    public static int v(Context context) {
        int d10 = G0.c.d(context, 1, c.a.f3196b, 0);
        H7.b.b("SimCardUtils", "getPrimarySlotId: primarySlotId = " + d10);
        return d10;
    }

    public static boolean v0(Context context, int i10) {
        int i11;
        boolean z10;
        try {
            i11 = D7.c.m();
        } catch (Throwable th) {
            H7.b.c("SimCardUtils", "isSoftSimCard throwable = " + th);
            i11 = -1;
        }
        if (i10 == i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        H7.b.b("SimCardUtils", "isSoftSimCard: " + z10 + ", slot " + i10 + ", softSimSlotId: " + i11);
        return z10;
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return y(38, 20, str);
    }

    public static boolean w0(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if ((charAt < ' ' || charAt > 127) && (charAt < 161 || charAt > 255)) {
                return false;
            }
        }
        return true;
    }

    public static String x(Context context, String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return l(str, 0, p(context, i10, FeatureOption.i()));
    }

    public static boolean x0(int i10) {
        boolean z10 = true;
        if (i10 != 0 && i10 != 1) {
            z10 = false;
        }
        if (!z10) {
            H7.b.i("SimCardUtils", "isValidSlotId: " + z10 + ", slotId: " + i10);
        }
        return z10;
    }

    public static String y(int i10, int i11, String str) {
        int length = str.length();
        if (length <= i11) {
            return str;
        }
        if (i10 < 0) {
            return "";
        }
        if (g0(str)) {
            int i12 = length - 1;
            String substring = str.substring(0, i12);
            while (g0(substring) && substring.length() > i11) {
                i12--;
                substring = str.substring(0, i12);
            }
            if (g0(substring)) {
                return substring;
            }
            return str.substring(0, Math.min(i10, i12));
        }
        return str.substring(0, Math.min(i10, length));
    }

    public static boolean y0(Context context, int i10) {
        L6.a a10;
        boolean z10;
        if (context == null) {
            return false;
        }
        try {
            T8.a aVar = null;
            if (C7.b.b()) {
                aVar = T8.a.a(i10);
                a10 = null;
            } else {
                a10 = L6.a.a(i10);
            }
            if (aVar != null) {
                z10 = aVar.b();
            } else if (a10 != null) {
                z10 = a10.b();
            } else {
                z10 = false;
            }
            if (H7.a.b()) {
                H7.b.b("SimCardUtils", "isVoLTEChecked lteOn = " + z10);
            }
            return z10;
        } catch (Exception e10) {
            H7.b.c("SimCardUtils", "Exception when isVoLTEChecked : " + e10);
            return false;
        }
    }

    public static String z(String str, BaseBundle baseBundle) {
        if (!TextUtils.isEmpty(str) && str.contains("#")) {
            for (String str2 : str.trim().split("#")) {
                if (!TextUtils.isEmpty(str2) && baseBundle.containsKey(str2)) {
                    return str2;
                }
            }
            return str;
        }
        return str;
    }

    public static boolean z0(Context context, List<a> list) {
        boolean a10;
        int i10;
        boolean z10 = false;
        try {
            if (f0(context)) {
                i10 = G0.c.d(context, 1, "multi_sim_voice_prompt", 1);
                if (list.size() >= 2 && i10 != 1) {
                    if (i10 == 0) {
                        int defaultVoiceSubscriptionId = SubscriptionManager.getDefaultVoiceSubscriptionId();
                        if (H7.a.b()) {
                            H7.b.b("SimCardUtils", "isVoLTEOrViWifiUseable:getDefaultVoiceSubscriptionId = " + defaultVoiceSubscriptionId);
                        }
                        a10 = a(context, list, defaultVoiceSubscriptionId, false);
                    } else {
                        a10 = false;
                    }
                }
                a10 = c(context, list);
            } else {
                if (list.size() < 2) {
                    a10 = c(context, list);
                } else {
                    a10 = a(context, list, v(context), true);
                }
                i10 = 1;
            }
            try {
                if (H7.a.b()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("isVoLTEOrViWifiUseable ");
                    sb.append(a10);
                    sb.append(", simInfos.size ");
                    sb.append(list.size());
                    sb.append(", alwaysAsk ");
                    if (i10 == 1) {
                        z10 = true;
                    }
                    sb.append(z10);
                    H7.b.b("SimCardUtils", sb.toString());
                    return a10;
                }
                return a10;
            } catch (Throwable th) {
                z10 = a10;
                th = th;
                H7.b.c("SimCardUtils", "isVoLTEOrViWifiUseable error " + th);
                return z10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
