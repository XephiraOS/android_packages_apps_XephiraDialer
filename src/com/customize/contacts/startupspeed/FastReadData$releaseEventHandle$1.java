package com.customize.contacts.startupspeed;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.M;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: FastReadData.kt */
@InterfaceC1470d(c = "com.customize.contacts.startupspeed.FastReadData$releaseEventHandle$1", f = "FastReadData.kt", l = {47}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FastReadData$releaseEventHandle$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ FastReadData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastReadData$releaseEventHandle$1(FastReadData fastReadData, kotlin.coroutines.c<? super FastReadData$releaseEventHandle$1> cVar) {
        super(2, cVar);
        this.this$0 = fastReadData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new FastReadData$releaseEventHandle$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        boolean g10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            this.label = 1;
            if (M.a(1000L, this) == c10) {
                return c10;
            }
        }
        g10 = this.this$0.g();
        if (!g10) {
            this.this$0.h();
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((FastReadData$releaseEventHandle$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
