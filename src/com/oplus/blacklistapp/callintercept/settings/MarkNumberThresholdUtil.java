package com.oplus.blacklistapp.callintercept.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.oplus.common.data.SettingsWrapper$Global;
import com.oplus.utils.C0846g;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import v6.C1632f;
import v9.InterfaceC1637a;

/* compiled from: MarkNumberThresholdUtil.kt */
/* loaded from: classes3.dex */
public final class MarkNumberThresholdUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final MarkNumberThresholdUtil f26799a = new MarkNumberThresholdUtil();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f26800b;

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<String, Pair<String, String>> f26801c;

    static {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        f26800b = hashMap;
        HashMap<String, Pair<String, String>> hashMap2 = new HashMap<>();
        f26801c = hashMap2;
        hashMap.put(0, 1);
        hashMap.put(25, 20);
        hashMap.put(50, 50);
        String HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY = C1632f.f37455i;
        kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY, "HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY");
        hashMap2.put(HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY, new Pair<>(C1632f.f37470x, C1632f.f37471y));
        String HARASS_INTERCEPT_MARK_HARASSMENT_KEY = C1632f.f37456j;
        kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_HARASSMENT_KEY, "HARASS_INTERCEPT_MARK_HARASSMENT_KEY");
        hashMap2.put(HARASS_INTERCEPT_MARK_HARASSMENT_KEY, new Pair<>(C1632f.f37472z, C1632f.f37426A));
        String HARASS_INTERCEPT_MARK_ADVERTISING_KEY = C1632f.f37457k;
        kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_ADVERTISING_KEY, "HARASS_INTERCEPT_MARK_ADVERTISING_KEY");
        hashMap2.put(HARASS_INTERCEPT_MARK_ADVERTISING_KEY, new Pair<>(C1632f.f37427B, C1632f.f37428C));
        String HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY = C1632f.f37458l;
        kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY, "HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY");
        hashMap2.put(HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY, new Pair<>(C1632f.f37429D, C1632f.f37430E));
    }

    public static final int a(String key) {
        kotlin.jvm.internal.i.f(key, "key");
        if (kotlin.jvm.internal.i.b(key, C1632f.f37455i)) {
            return 3;
        }
        return 0;
    }

    public static final int b(int i10, Context context) {
        String d10;
        int i11;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i12 = Integer.MAX_VALUE;
        for (Map.Entry<String, Pair<String, String>> entry : f26801c.entrySet()) {
            String key = entry.getKey();
            Pair<String, String> value = entry.getValue();
            if (i10 == 0) {
                d10 = value.c();
            } else {
                d10 = value.d();
            }
            String str = d10;
            if (C1632f.B(context, key, a(key), i10)) {
                if (context != null) {
                    i11 = defaultSharedPreferences.getInt(str, 1);
                } else {
                    i11 = 1;
                }
                Log.d("MarkNumberThresholdUtil", "steve ### content " + key + " value " + i11);
                if (i11 < i12) {
                    i12 = i11;
                }
            }
        }
        if (1 <= i12 && i12 < 11) {
            return 0;
        }
        if (11 <= i12 && i12 < 31) {
            return 25;
        }
        if (31 > i12 || i12 >= 51) {
            return 0;
        }
        return 50;
    }

    public static final int c(int i10) {
        Integer num = f26800b.get(Integer.valueOf(i10));
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public static final int d(int i10, final Context context) {
        final String key;
        if (i10 == 0) {
            key = C1632f.f37468v;
        } else {
            key = C1632f.f37469w;
        }
        C0846g.i("MarkNumberThresholdUtil", "key=" + key);
        if (context == null) {
            return 0;
        }
        ContentResolver contentResolver = context.getContentResolver();
        kotlin.jvm.internal.i.e(contentResolver, "context.contentResolver");
        kotlin.jvm.internal.i.e(key, "key");
        return SettingsWrapper$Global.a(contentResolver, key, 0, new InterfaceC1637a<Integer>() { // from class: com.oplus.blacklistapp.callintercept.settings.MarkNumberThresholdUtil$getOldThreshold$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                return Integer.valueOf(z6.b.b(context, 1, key));
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (r2 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int e(int r2, android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.i.f(r4, r0)
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)
            java.util.HashMap<java.lang.String, kotlin.Pair<java.lang.String, java.lang.String>> r1 = com.oplus.blacklistapp.callintercept.settings.MarkNumberThresholdUtil.f26801c
            java.lang.Object r1 = r1.get(r4)
            kotlin.Pair r1 = (kotlin.Pair) r1
            if (r1 == 0) goto L23
            if (r2 != 0) goto L1c
            java.lang.Object r2 = r1.c()
        L19:
            java.lang.String r2 = (java.lang.String) r2
            goto L21
        L1c:
            java.lang.Object r2 = r1.d()
            goto L19
        L21:
            if (r2 != 0) goto L25
        L23:
            java.lang.String r2 = ""
        L25:
            r1 = 0
            if (r3 == 0) goto L2c
            int r1 = r0.getInt(r2, r1)
        L2c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Current value for content '"
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = "': "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "MarkNumberThresholdUtil"
            android.util.Log.d(r3, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.settings.MarkNumberThresholdUtil.e(int, android.content.Context, java.lang.String):int");
    }

    public static final void f(int i10, Context context, int i11) {
        String str;
        if (i10 == 0) {
            str = C1632f.f37468v;
        } else {
            str = C1632f.f37469w;
        }
        z6.b.k(context, 1, str, i11, 0, 16, null);
        C0846g.i("MarkNumberThresholdUtil", "setOldThreshold key=" + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0025, code lost:
    
        if (r4 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(int r2, android.content.Context r3, java.lang.String r4, int r5, boolean r6) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.i.f(r4, r0)
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.util.HashMap<java.lang.String, kotlin.Pair<java.lang.String, java.lang.String>> r1 = com.oplus.blacklistapp.callintercept.settings.MarkNumberThresholdUtil.f26801c
            java.lang.Object r4 = r1.get(r4)
            kotlin.Pair r4 = (kotlin.Pair) r4
            if (r4 == 0) goto L27
            if (r2 != 0) goto L20
            java.lang.Object r4 = r4.c()
        L1d:
            java.lang.String r4 = (java.lang.String) r4
            goto L25
        L20:
            java.lang.Object r4 = r4.d()
            goto L1d
        L25:
            if (r4 != 0) goto L29
        L27:
            java.lang.String r4 = ""
        L29:
            r0.putInt(r4, r5)
            r0.apply()
            if (r6 == 0) goto L34
            h(r2, r3)
        L34:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setThresholdByContent key="
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = " threshold="
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "MarkNumberThresholdUtil"
            com.oplus.utils.C0846g.i(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.settings.MarkNumberThresholdUtil.g(int, android.content.Context, java.lang.String, int, boolean):void");
    }

    public static final void h(int i10, Context context) {
        int b10 = b(i10, context);
        f(i10, context, b10);
        Log.d("CallHarassInterceptMarkedNumberFragment", "将最小数值设置：" + b10 + "设置为非需求版本的阈值");
    }
}
