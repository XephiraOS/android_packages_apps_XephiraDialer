package com.android.incallui.mvvm.utils;

/* compiled from: IgnoreEqualsLiveData.kt */
/* loaded from: classes.dex */
public final class y<T> extends androidx.lifecycle.t<T> implements g<T> {

    /* renamed from: m, reason: collision with root package name */
    public final boolean f18609m;

    /* renamed from: n, reason: collision with root package name */
    public T f18610n;

    public y() {
        this(false, 1, null);
    }

    @Override // androidx.lifecycle.LiveData, com.android.incallui.mvvm.utils.g
    public T getValue() {
        T t10 = (T) super.getValue();
        if (t10 == null) {
            return r();
        }
        return t10;
    }

    @Override // androidx.lifecycle.v, androidx.lifecycle.LiveData
    public void m(T t10) {
        super.m(t10);
    }

    @Override // androidx.lifecycle.v, androidx.lifecycle.LiveData
    public void o(T t10) {
        if (s() && kotlin.jvm.internal.i.b(super.getValue(), t10)) {
            return;
        }
        super.o(t10);
    }

    public T r() {
        return this.f18610n;
    }

    public boolean s() {
        return this.f18609m;
    }

    public void u(T t10) {
        this.f18610n = t10;
    }

    public /* synthetic */ y(boolean z10, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public y(boolean z10) {
        this.f18609m = z10;
    }

    public y(T t10, boolean z10) {
        this(z10);
        u(t10);
    }
}
