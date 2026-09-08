package com.oplus.utils;

import android.content.Context;
import com.android.incallui.OplusAutoRedialNotificationUI;
import java.util.HashMap;
import java.util.Map;
import s8.C1569l;

/* loaded from: classes3.dex */
public class StatisticsUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f29090a = {new int[]{201081007, 201081010}, new int[]{201081008, 201081011}, new int[]{201081009, 201081012}, new int[]{201081013, 201081013}};

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<Integer, String> f29091b = new HashMap() { // from class: com.oplus.utils.StatisticsUtils.1
        {
            put(20, "one_ring_block_call");
            put(22, "private_numbers_block_call");
            put(24, "region_block_call");
            put(25, "unknown_block_call");
            put(26, "all_block_call");
            put(27, "blacklist_block_call");
            put(56, "fraud_call");
            put(50, "scam_block_call");
            put(51, "nuisance_block_call");
            put(52, "telemarketing_block_call");
            put(53, "real_estate_agent_block_call");
            put(54, "smart_drive");
            put(55, "ride_mode");
            put(28, "anonymous_number");
            put(29, "unrecognized_number");
            put(30, "payphone_number");
        }
    };

    public static void a(Context context, int i10, int i11, Map map, boolean z10) {
        C1569l.s(context, String.valueOf(i10), String.valueOf(i11), map);
    }

    public static void b(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(OplusAutoRedialNotificationUI.TIME, String.valueOf(System.currentTimeMillis()));
        hashMap.put("attribution_number", str);
        a(context, 2010804, 201082003, hashMap, false);
    }

    public static void c(Context context, String str, boolean z10, int i10) {
        String g10 = g(z10, i10);
        HashMap hashMap = new HashMap();
        hashMap.put("enter_page", str);
        hashMap.put("sim_select", g10);
        a(context, 2010804, 201082001, hashMap, false);
    }

    public static void d(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exit", str);
        a(context, 2010802, 201081003, hashMap, false);
    }

    public static void e(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exit_page", str);
        a(context, 2010804, 201082002, hashMap, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        if (r6 == 0) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        if (r4 == 3) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        if (r6 == 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000f, code lost:
    
        r4 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> f(java.lang.String r3, int r4, boolean r5, int r6) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r5 == 0) goto L1b
            r5 = 0
            r1 = 1
            if (r4 != r1) goto L11
            if (r6 != 0) goto Lf
        Ld:
            r4 = r1
            goto L1b
        Lf:
            r4 = r5
            goto L1b
        L11:
            r2 = 2
            if (r4 != r2) goto L17
            if (r6 != 0) goto Ld
            goto Lf
        L17:
            r5 = 3
            if (r4 != r5) goto L1b
            goto Ld
        L1b:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.put(r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.StatisticsUtils.f(java.lang.String, int, boolean, int):java.util.HashMap");
    }

    public static String g(boolean z10, int i10) {
        if (z10) {
            return "1_" + (i10 + 1);
        }
        return "2_" + (i10 + 1);
    }

    public static void h(Context context) {
        C1569l.h(context);
    }
}
