package com.oplus.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: StatisticsActionUtils.kt */
/* loaded from: classes3.dex */
public final class W {

    /* renamed from: a, reason: collision with root package name */
    public static final W f29109a = new W();

    public static final void a(int i10, String str, Context context) {
        if (i10 == 56) {
            HashMap hashMap = new HashMap();
            hashMap.put("number", C0846g.f(str));
            StatisticsUtils.a(context, 2010803, 201081014, hashMap, false);
        }
        String str2 = StatisticsUtils.f29091b.get(Integer.valueOf(i10));
        if (!TextUtils.isEmpty(str2)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("call", str2);
            StatisticsUtils.a(context, 2010803, 201081018, hashMap2, false);
        }
    }
}
