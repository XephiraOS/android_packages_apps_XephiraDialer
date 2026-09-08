package com.oplus.utils;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: BlackListCoroutineUtils.kt */
@InterfaceC1470d(c = "com.oplus.utils.BlackListCoroutineUtils$startCoroutineForRunnable$1$1", f = "BlackListCoroutineUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BlackListCoroutineUtils$startCoroutineForRunnable$1$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Runnable $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListCoroutineUtils$startCoroutineForRunnable$1$1(Runnable runnable, kotlin.coroutines.c<? super BlackListCoroutineUtils$startCoroutineForRunnable$1$1> cVar) {
        super(2, cVar);
        this.$it = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new BlackListCoroutineUtils$startCoroutineForRunnable$1$1(this.$it, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.$it.run();
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((BlackListCoroutineUtils$startCoroutineForRunnable$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
