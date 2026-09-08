package com.oplus.utils;

import android.app.ActivityManager;
import android.content.Context;

/* compiled from: MemoryUtils.java */
/* loaded from: classes3.dex */
public final class A {

    /* renamed from: a, reason: collision with root package name */
    public static ActivityManager.MemoryInfo f29034a;

    public static long a(Context context) {
        if (f29034a == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            f29034a = memoryInfo;
            activityManager.getMemoryInfo(memoryInfo);
        }
        return f29034a.totalMem;
    }
}
