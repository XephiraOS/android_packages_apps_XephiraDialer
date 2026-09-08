package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.InterfaceC1265l0;

/* compiled from: LifecycleController.kt */
/* renamed from: androidx.lifecycle.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0487j {

    /* renamed from: a, reason: collision with root package name */
    public final Lifecycle f10364a;

    /* renamed from: b, reason: collision with root package name */
    public final Lifecycle.State f10365b;

    /* renamed from: c, reason: collision with root package name */
    public final C0482e f10366c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0489l f10367d;

    public C0487j(Lifecycle lifecycle, Lifecycle.State minState, C0482e dispatchQueue, final InterfaceC1265l0 parentJob) {
        kotlin.jvm.internal.i.f(lifecycle, "lifecycle");
        kotlin.jvm.internal.i.f(minState, "minState");
        kotlin.jvm.internal.i.f(dispatchQueue, "dispatchQueue");
        kotlin.jvm.internal.i.f(parentJob, "parentJob");
        this.f10364a = lifecycle;
        this.f10365b = minState;
        this.f10366c = dispatchQueue;
        InterfaceC0489l interfaceC0489l = new InterfaceC0489l() { // from class: androidx.lifecycle.i
            @Override // androidx.lifecycle.InterfaceC0489l
            public final void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
                C0487j.c(C0487j.this, parentJob, interfaceC0492o, event);
            }
        };
        this.f10367d = interfaceC0489l;
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            InterfaceC1265l0.a.a(parentJob, null, 1, null);
            b();
        } else {
            lifecycle.a(interfaceC0489l);
        }
    }

    public static final void c(C0487j this$0, InterfaceC1265l0 parentJob, InterfaceC0492o source, Lifecycle.Event event) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(parentJob, "$parentJob");
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(event, "<anonymous parameter 1>");
        if (source.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            InterfaceC1265l0.a.a(parentJob, null, 1, null);
            this$0.b();
        } else if (source.getLifecycle().b().compareTo(this$0.f10365b) < 0) {
            this$0.f10366c.h();
        } else {
            this$0.f10366c.i();
        }
    }

    public final void b() {
        this.f10364a.d(this.f10367d);
        this.f10366c.g();
    }
}
