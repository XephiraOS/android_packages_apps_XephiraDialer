package com.android.contacts.dialpad.view;

import android.content.Context;
import com.android.contacts.framework.baseui.util.AiCallTranslateStateController;
import com.customize.contacts.FeatureOption;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: DialerHeaderViewManager.kt */
@InterfaceC1470d(c = "com.android.contacts.dialpad.view.DialerHeaderViewManager$tryShowAICallTranslateTips$3", f = "DialerHeaderViewManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DialerHeaderViewManager$tryShowAICallTranslateTips$3 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref$BooleanRef $isAICallTranslateOpen;
    final /* synthetic */ Ref$BooleanRef $isSupportAICallTranslate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialerHeaderViewManager$tryShowAICallTranslateTips$3(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, Context context, kotlin.coroutines.c<? super DialerHeaderViewManager$tryShowAICallTranslateTips$3> cVar) {
        super(2, cVar);
        this.$isSupportAICallTranslate = ref$BooleanRef;
        this.$isAICallTranslateOpen = ref$BooleanRef2;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new DialerHeaderViewManager$tryShowAICallTranslateTips$3(this.$isSupportAICallTranslate, this.$isAICallTranslateOpen, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.$isSupportAICallTranslate.element = FeatureOption.l();
            this.$isAICallTranslateOpen.element = AiCallTranslateStateController.f15829b.a().d(this.$context);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((DialerHeaderViewManager$tryShowAICallTranslateTips$3) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
