package com.android.contacts.dialpad.view;

import com.customize.contacts.FeatureOption;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowCallSummaryTips$3", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowCallSummaryTips$3 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Ref$BooleanRef $isSupportAICallTranslate;
    final /* synthetic */ Ref$BooleanRef $isSupportBreenoCall;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowCallSummaryTips$3(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowCallSummaryTips$3> cVar) {
        super(2, cVar);
        this.$isSupportAICallTranslate = ref$BooleanRef;
        this.$isSupportBreenoCall = ref$BooleanRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$tryShowCallSummaryTips$3(this.$isSupportAICallTranslate, this.$isSupportBreenoCall, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.$isSupportAICallTranslate.element = FeatureOption.l();
            this.$isSupportBreenoCall.element = FeatureOption.m();
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DialerHeaderViewManager$tryShowCallSummaryTips$3) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
