package com.android.incallui.mvvm.view_model;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: OplusInCallViewModel.kt */
@InterfaceC1470d(c = "com.android.incallui.mvvm.view_model.OplusInCallViewModel", f = "OplusInCallViewModel.kt", l = {86, 92}, m = "autoShowAudioModeDialog")
/* loaded from: classes.dex */
public final class OplusInCallViewModel$autoShowAudioModeDialog$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OplusInCallViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OplusInCallViewModel$autoShowAudioModeDialog$1(OplusInCallViewModel oplusInCallViewModel, c<? super OplusInCallViewModel$autoShowAudioModeDialog$1> cVar) {
        super(cVar);
        this.this$0 = oplusInCallViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object i10;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        i10 = this.this$0.i(0L, 0L, this);
        return i10;
    }
}
