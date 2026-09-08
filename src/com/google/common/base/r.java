package com.google.common.base;

/* compiled from: Ticker.java */
/* loaded from: classes3.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f24342a = new a();

    /* compiled from: Ticker.java */
    /* loaded from: classes3.dex */
    public class a extends r {
        @Override // com.google.common.base.r
        public long a() {
            return System.nanoTime();
        }
    }

    public static r b() {
        return f24342a;
    }

    public abstract long a();
}
