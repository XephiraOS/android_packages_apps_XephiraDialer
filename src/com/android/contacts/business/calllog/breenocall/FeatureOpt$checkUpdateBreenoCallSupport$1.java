package com.android.contacts.business.calllog.breenocall;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: FeatureOpt.kt */
@InterfaceC1470d(c = "com.android.contacts.business.calllog.breenocall.FeatureOpt$checkUpdateBreenoCallSupport$1", f = "FeatureOpt.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FeatureOpt$checkUpdateBreenoCallSupport$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Runnable $runnable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureOpt$checkUpdateBreenoCallSupport$1(Runnable runnable, c<? super FeatureOpt$checkUpdateBreenoCallSupport$1> cVar) {
        super(2, cVar);
        this.$runnable = runnable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new FeatureOpt$checkUpdateBreenoCallSupport$1(this.$runnable, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.$runnable.run();
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((FeatureOpt$checkUpdateBreenoCallSupport$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
