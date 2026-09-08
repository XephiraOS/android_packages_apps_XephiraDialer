package com.oplus.utils;

import android.os.SystemClock;

/* compiled from: ClickFilter.java */
/* renamed from: com.oplus.utils.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0852m {

    /* renamed from: a, reason: collision with root package name */
    public boolean f29161a = true;

    /* renamed from: b, reason: collision with root package name */
    public long f29162b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f29163c = 0;

    public boolean a() {
        if (!this.f29161a) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f29163c = uptimeMillis;
        if (uptimeMillis - this.f29162b <= 500) {
            this.f29162b = uptimeMillis;
            return true;
        }
        this.f29162b = uptimeMillis;
        return false;
    }
}
