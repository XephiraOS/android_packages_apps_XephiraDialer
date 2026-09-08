package com.android.incallui.mvvm.utils;

/* compiled from: IgnoreEqualsLiveData.kt */
/* loaded from: classes.dex */
public class h<T> extends androidx.lifecycle.v<T> implements g<T> {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f18592l;

    /* renamed from: m, reason: collision with root package name */
    public T f18593m;

    public h() {
        this(false, 1, null);
    }

    @Override // androidx.lifecycle.LiveData, com.android.incallui.mvvm.utils.g
    public T getValue() {
        T t10 = (T) super.getValue();
        if (t10 == null) {
            return p();
        }
        return t10;
    }

    @Override // androidx.lifecycle.v, androidx.lifecycle.LiveData
    public void m(T t10) {
        super.m(t10);
    }

    @Override // androidx.lifecycle.v, androidx.lifecycle.LiveData
    public void o(T t10) {
        if (q() && kotlin.jvm.internal.i.b(getValue(), t10)) {
            return;
        }
        super.o(t10);
    }

    public T p() {
        return this.f18593m;
    }

    public boolean q() {
        return this.f18592l;
    }

    public void r(T t10) {
        this.f18593m = t10;
    }

    public /* synthetic */ h(boolean z10, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? false : z10);
    }

    public h(boolean z10) {
        this.f18592l = z10;
    }

    public h(T t10, boolean z10) {
        this(z10);
        r(t10);
        super.o(t10);
    }

    public /* synthetic */ h(Object obj, boolean z10, int i10, kotlin.jvm.internal.f fVar) {
        this(obj, (i10 & 2) != 0 ? false : z10);
    }
}
