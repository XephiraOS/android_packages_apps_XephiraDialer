package com.android.incallui.mvvm.utils;

import androidx.lifecycle.InterfaceC0492o;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: IgnoreEqualsLiveData.kt */
/* loaded from: classes.dex */
public final class SingleNonNullLiveEvent<T> extends h<T> {

    /* renamed from: n, reason: collision with root package name */
    public boolean f18587n;

    /* renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f18588o;

    public /* synthetic */ SingleNonNullLiveEvent(Object obj, boolean z10, int i10, kotlin.jvm.internal.f fVar) {
        this(obj, (i10 & 2) != 0 ? false : z10);
    }

    public static final void v(v9.l tmp0, Object obj) {
        kotlin.jvm.internal.i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.lifecycle.LiveData
    public void i(InterfaceC0492o owner, final androidx.lifecycle.w<? super T> observer) {
        kotlin.jvm.internal.i.f(owner, "owner");
        kotlin.jvm.internal.i.f(observer, "observer");
        if (g()) {
            return;
        }
        final v9.l<T, m9.q> lVar = new v9.l<T, m9.q>(this) { // from class: com.android.incallui.mvvm.utils.SingleNonNullLiveEvent$observe$1
            final /* synthetic */ SingleNonNullLiveEvent<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final void b(T t10) {
                AtomicBoolean atomicBoolean;
                atomicBoolean = this.this$0.f18588o;
                if (atomicBoolean.compareAndSet(true, false)) {
                    observer.onChanged(t10);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Object obj) {
                b(obj);
                return m9.q.f35511a;
            }
        };
        super.i(owner, new androidx.lifecycle.w() { // from class: com.android.incallui.mvvm.utils.z
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                SingleNonNullLiveEvent.v(v9.l.this, obj);
            }
        });
    }

    @Override // com.android.incallui.mvvm.utils.h, androidx.lifecycle.v, androidx.lifecycle.LiveData
    public void o(T t10) {
        if (q() && kotlin.jvm.internal.i.b(super.getValue(), t10)) {
            return;
        }
        this.f18588o.set(true);
        super.o(t10);
    }

    @Override // com.android.incallui.mvvm.utils.h
    public boolean q() {
        return this.f18587n;
    }

    public SingleNonNullLiveEvent(T t10, boolean z10) {
        super(t10, z10);
        this.f18587n = z10;
        this.f18588o = new AtomicBoolean(false);
    }
}
