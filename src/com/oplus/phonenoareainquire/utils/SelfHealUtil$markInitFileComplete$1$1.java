package com.oplus.phonenoareainquire.utils;

import android.content.Context;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: SelfHealUtil.kt */
@InterfaceC1470d(c = "com.oplus.phonenoareainquire.utils.SelfHealUtil$markInitFileComplete$1$1", f = "SelfHealUtil.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class SelfHealUtil$markInitFileComplete$1$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelfHealUtil$markInitFileComplete$1$1(Context context, kotlin.coroutines.c<? super SelfHealUtil$markInitFileComplete$1$1> cVar) {
        super(2, cVar);
        this.$it = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SelfHealUtil$markInitFileComplete$1$1(this.$it, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            SelfHealUtil.c(this.$it);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((SelfHealUtil$markInitFileComplete$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
