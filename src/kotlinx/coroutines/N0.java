package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Unconfined.kt */
/* loaded from: classes4.dex */
public final class N0 extends CoroutineDispatcher {

    /* renamed from: c, reason: collision with root package name */
    public static final N0 f34329c = new N0();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void f0(CoroutineContext coroutineContext, Runnable runnable) {
        R0 r02 = (R0) coroutineContext.a(R0.f34334c);
        if (r02 != null) {
            r02.f34335b = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean g0(CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
