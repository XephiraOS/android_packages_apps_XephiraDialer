package androidx.lifecycle;

import kotlinx.coroutines.G0;
import kotlinx.coroutines.S;

/* compiled from: Lifecycle.kt */
/* renamed from: androidx.lifecycle.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0490m {
    public static final LifecycleCoroutineScope a(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        kotlin.jvm.internal.i.f(lifecycle, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.c().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, G0.b(null, 1, null).r(S.c().i0()));
        } while (!lifecycle.c().compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.c();
        return lifecycleCoroutineScopeImpl;
    }
}
