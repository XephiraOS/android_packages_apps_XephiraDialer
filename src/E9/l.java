package E9;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
public final class l extends CoroutineDispatcher {

    /* renamed from: c, reason: collision with root package name */
    public static final l f764c = new l();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void f0(CoroutineContext coroutineContext, Runnable runnable) {
        b.f745i.j0(runnable, k.f763h, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher h0(int i10) {
        kotlinx.coroutines.internal.m.a(i10);
        if (i10 >= k.f759d) {
            return this;
        }
        return super.h0(i10);
    }
}
