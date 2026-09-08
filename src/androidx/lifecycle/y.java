package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.S;

/* compiled from: PausingDispatcher.kt */
/* loaded from: classes.dex */
public final class y extends CoroutineDispatcher {

    /* renamed from: c, reason: collision with root package name */
    public final C0482e f10389c = new C0482e();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void f0(CoroutineContext context, Runnable block) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(block, "block");
        this.f10389c.c(context, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean g0(CoroutineContext context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (S.c().i0().g0(context)) {
            return true;
        }
        return !this.f10389c.b();
    }
}
