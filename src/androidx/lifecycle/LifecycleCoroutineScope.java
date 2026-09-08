package androidx.lifecycle;

import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.InterfaceC1265l0;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements kotlinx.coroutines.E {
    public abstract Lifecycle a();

    public final InterfaceC1265l0 b(v9.p<? super kotlinx.coroutines.E, ? super kotlin.coroutines.c<? super m9.q>, ? extends Object> block) {
        InterfaceC1265l0 d10;
        kotlin.jvm.internal.i.f(block, "block");
        d10 = C1248i.d(this, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(this, block, null), 3, null);
        return d10;
    }
}
