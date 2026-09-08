package com.android.incallui.clean.domain.interactor;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.l;
import v9.p;

/* compiled from: UseCase.kt */
@InterfaceC1470d(c = "com.android.incallui.clean.domain.interactor.UseCase1$invoke$3", f = "UseCase.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class UseCase1$invoke$3 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ l<R, q> $onResult;
    final /* synthetic */ P1 $p1;
    int label;
    final /* synthetic */ UseCase1<P1, R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UseCase1$invoke$3(UseCase1<? super P1, ? extends R> useCase1, P1 p12, l<? super R, q> lVar, kotlin.coroutines.c<? super UseCase1$invoke$3> cVar) {
        super(2, cVar);
        this.this$0 = useCase1;
        this.$p1 = p12;
        this.$onResult = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new UseCase1$invoke$3(this.this$0, this.$p1, this.$onResult, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Object h10 = this.this$0.h(this.$p1);
            l<R, q> lVar = this.$onResult;
            if (lVar != 0) {
                lVar.invoke(h10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((UseCase1$invoke$3) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
