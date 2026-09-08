package com.oplus.foundation.util.ui;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ShowUnfoldScreenStatusChecker.kt */
@InterfaceC1470d(c = "com.oplus.foundation.util.ui.ShowUnfoldScreenStatusChecker$refreshIfNeed$1$1$1", f = "ShowUnfoldScreenStatusChecker.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ShowUnfoldScreenStatusChecker$refreshIfNeed$1$1$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ boolean $isShowUnFoldScreenFromSettings;
    int label;
    final /* synthetic */ ShowUnfoldScreenStatusChecker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShowUnfoldScreenStatusChecker$refreshIfNeed$1$1$1(ShowUnfoldScreenStatusChecker showUnfoldScreenStatusChecker, boolean z10, AppCompatActivity appCompatActivity, kotlin.coroutines.c<? super ShowUnfoldScreenStatusChecker$refreshIfNeed$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = showUnfoldScreenStatusChecker;
        this.$isShowUnFoldScreenFromSettings = z10;
        this.$activity = appCompatActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ShowUnfoldScreenStatusChecker$refreshIfNeed$1$1$1(this.this$0, this.$isShowUnFoldScreenFromSettings, this.$activity, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.f(true);
            this.this$0.g(this.$isShowUnFoldScreenFromSettings);
            AppCompatActivity appCompatActivity = this.$activity;
            appCompatActivity.onConfigurationChanged(appCompatActivity.getResources().getConfiguration());
            this.this$0.f(false);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ShowUnfoldScreenStatusChecker$refreshIfNeed$1$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
