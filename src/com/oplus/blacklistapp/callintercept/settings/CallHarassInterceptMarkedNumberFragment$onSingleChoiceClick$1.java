package com.oplus.blacklistapp.callintercept.settings;

import android.widget.RadioButton;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.callintercept.settings.CallHarassInterceptMarkedNumberFragment$onSingleChoiceClick$1", f = "CallHarassInterceptMarkedNumberFragment.kt", l = {414}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class CallHarassInterceptMarkedNumberFragment$onSingleChoiceClick$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ int $position;
    final /* synthetic */ RadioButton $radioButton;
    int label;
    final /* synthetic */ CallHarassInterceptMarkedNumberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallHarassInterceptMarkedNumberFragment$onSingleChoiceClick$1(CallHarassInterceptMarkedNumberFragment callHarassInterceptMarkedNumberFragment, int i10, RadioButton radioButton, kotlin.coroutines.c<? super CallHarassInterceptMarkedNumberFragment$onSingleChoiceClick$1> cVar) {
        super(2, cVar);
        this.this$0 = callHarassInterceptMarkedNumberFragment;
        this.$position = i10;
        this.$radioButton = radioButton;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new CallHarassInterceptMarkedNumberFragment$onSingleChoiceClick$1(this.this$0, this.$position, this.$radioButton, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.settings.CallHarassInterceptMarkedNumberFragment$onSingleChoiceClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((CallHarassInterceptMarkedNumberFragment$onSingleChoiceClick$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
