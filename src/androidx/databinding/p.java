package androidx.databinding;

import androidx.lifecycle.InterfaceC0492o;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: WeakListener.java */
/* loaded from: classes.dex */
public class p<T> extends WeakReference<ViewDataBinding> {

    /* renamed from: a, reason: collision with root package name */
    public final l<T> f9667a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9668b;

    /* renamed from: c, reason: collision with root package name */
    public T f9669c;

    public p(ViewDataBinding viewDataBinding, int i10, l<T> lVar, ReferenceQueue<ViewDataBinding> referenceQueue) {
        super(viewDataBinding, referenceQueue);
        this.f9668b = i10;
        this.f9667a = lVar;
    }

    public ViewDataBinding a() {
        ViewDataBinding viewDataBinding = (ViewDataBinding) get();
        if (viewDataBinding == null) {
            e();
        }
        return viewDataBinding;
    }

    public T b() {
        return this.f9669c;
    }

    public void c(InterfaceC0492o interfaceC0492o) {
        this.f9667a.a(interfaceC0492o);
    }

    public void d(T t10) {
        e();
        this.f9669c = t10;
        if (t10 != null) {
            this.f9667a.c(t10);
        }
    }

    public boolean e() {
        boolean z10;
        T t10 = this.f9669c;
        if (t10 != null) {
            this.f9667a.b(t10);
            z10 = true;
        } else {
            z10 = false;
        }
        this.f9669c = null;
        return z10;
    }
}
