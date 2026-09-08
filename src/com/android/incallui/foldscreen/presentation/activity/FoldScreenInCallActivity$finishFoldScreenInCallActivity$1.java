package com.android.incallui.foldscreen.presentation.activity;

import androidx.fragment.app.FragmentManager;
import com.android.incallui.foldscreen.presentation.fragment.FoldScreenInCallDialogFragment;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: FoldScreenInCallActivity.kt */
@InterfaceC1470d(c = "com.android.incallui.foldscreen.presentation.activity.FoldScreenInCallActivity$finishFoldScreenInCallActivity$1", f = "FoldScreenInCallActivity.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FoldScreenInCallActivity$finishFoldScreenInCallActivity$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;
    final /* synthetic */ FoldScreenInCallActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldScreenInCallActivity$finishFoldScreenInCallActivity$1(FoldScreenInCallActivity foldScreenInCallActivity, c<? super FoldScreenInCallActivity$finishFoldScreenInCallActivity$1> cVar) {
        super(2, cVar);
        this.this$0 = foldScreenInCallActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new FoldScreenInCallActivity$finishFoldScreenInCallActivity$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FoldScreenInCallDialogFragment r02;
        q qVar;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            FoldScreenInCallActivity foldScreenInCallActivity = this.this$0;
            FragmentManager supportFragmentManager = foldScreenInCallActivity.getSupportFragmentManager();
            i.e(supportFragmentManager, "supportFragmentManager");
            r02 = foldScreenInCallActivity.r0(supportFragmentManager);
            if (r02 != null) {
                r02.dismiss();
                qVar = q.f35511a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                this.this$0.finish();
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((FoldScreenInCallActivity$finishFoldScreenInCallActivity$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
