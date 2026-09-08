package com.customize.contacts.startupspeed;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: FastReadData.kt */
@InterfaceC1470d(c = "com.customize.contacts.startupspeed.FastReadData$acquireEvent$1", f = "FastReadData.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FastReadData$acquireEvent$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ FastReadData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastReadData$acquireEvent$1(FastReadData fastReadData, kotlin.coroutines.c<? super FastReadData$acquireEvent$1> cVar) {
        super(2, cVar);
        this.this$0 = fastReadData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new FastReadData$acquireEvent$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.d();
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((FastReadData$acquireEvent$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
