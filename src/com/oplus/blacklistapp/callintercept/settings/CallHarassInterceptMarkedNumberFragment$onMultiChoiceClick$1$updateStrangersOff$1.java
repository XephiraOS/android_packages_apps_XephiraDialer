package com.oplus.blacklistapp.callintercept.settings;

import h9.C1087a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.C1467a;
import p9.InterfaceC1470d;

/* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.callintercept.settings.CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1", f = "CallHarassInterceptMarkedNumberFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super Boolean>, Object> {
    int label;
    final /* synthetic */ CallHarassInterceptMarkedNumberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1(CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment, kotlin.coroutines.c<? super CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1> cVar) {
        super(2, cVar);
        this.this$0 = callHarassInterceptMarkedNumberFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            if (this.this$0.getContext() != null) {
                return C1467a.a(!C1087a.m(r1));
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super Boolean> cVar) {
        return ((CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1$updateStrangersOff$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
