package com.android.incallui.mvvm.view_model;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: OplusInCallViewModel.kt */
@InterfaceC1470d(c = "com.android.incallui.mvvm.view_model.OplusInCallViewModel$mAutoControlAudioDialog$1$1$1", f = "OplusInCallViewModel.kt", l = {71}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class OplusInCallViewModel$mAutoControlAudioDialog$1$1$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;
    final /* synthetic */ OplusInCallViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OplusInCallViewModel$mAutoControlAudioDialog$1$1$1(OplusInCallViewModel oplusInCallViewModel, c<? super OplusInCallViewModel$mAutoControlAudioDialog$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = oplusInCallViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new OplusInCallViewModel$mAutoControlAudioDialog$1$1$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            OplusInCallViewModel oplusInCallViewModel = this.this$0;
            this.label = 1;
            if (OplusInCallViewModel.j(oplusInCallViewModel, 0L, 0L, this, 3, null) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((OplusInCallViewModel$mAutoControlAudioDialog$1$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
