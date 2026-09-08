package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.C1275q0;
import kotlinx.coroutines.S;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements InterfaceC0489l {

    /* renamed from: a, reason: collision with root package name */
    public final Lifecycle f10289a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f10290b;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        kotlin.jvm.internal.i.f(lifecycle, "lifecycle");
        kotlin.jvm.internal.i.f(coroutineContext, "coroutineContext");
        this.f10289a = lifecycle;
        this.f10290b = coroutineContext;
        if (a().b() == Lifecycle.State.DESTROYED) {
            C1275q0.d(s(), null, 1, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle a() {
        return this.f10289a;
    }

    public final void c() {
        C1248i.d(this, S.c().i0(), null, new LifecycleCoroutineScopeImpl$register$1(this, null), 2, null);
    }

    @Override // androidx.lifecycle.InterfaceC0489l
    public void onStateChanged(InterfaceC0492o source, Lifecycle.Event event) {
        kotlin.jvm.internal.i.f(source, "source");
        kotlin.jvm.internal.i.f(event, "event");
        if (a().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            a().d(this);
            C1275q0.d(s(), null, 1, null);
        }
    }

    @Override // kotlinx.coroutines.E
    public CoroutineContext s() {
        return this.f10290b;
    }
}
