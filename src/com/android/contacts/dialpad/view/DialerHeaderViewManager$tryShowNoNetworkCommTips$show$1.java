package com.android.contacts.dialpad.view;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowNoNetworkCommTips$show$1", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowNoNetworkCommTips$show$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super Boolean>, Object> {
    final /* synthetic */ InterfaceC1637a<Boolean> $needShowFunc;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowNoNetworkCommTips$show$1(InterfaceC1637a<Boolean> interfaceC1637a, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowNoNetworkCommTips$show$1> cVar) {
        super(2, cVar);
        this.$needShowFunc = interfaceC1637a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$tryShowNoNetworkCommTips$show$1(this.$needShowFunc, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            return this.$needShowFunc.invoke();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super Boolean> cVar) {
        return ((DialerHeaderViewManager$tryShowNoNetworkCommTips$show$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
