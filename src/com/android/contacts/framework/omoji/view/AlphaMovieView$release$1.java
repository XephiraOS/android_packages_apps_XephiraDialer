package com.android.contacts.framework.omoji.view;

import com.android.contacts.framework.omoji.view.AlphaMovieView;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: AlphaMovieView.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.view.AlphaMovieView$release$1", f = "AlphaMovieView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AlphaMovieView$release$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ AlphaMovieView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaMovieView$release$1(AlphaMovieView alphaMovieView, kotlin.coroutines.c<? super AlphaMovieView$release$1> cVar) {
        super(2, cVar);
        this.this$0 = alphaMovieView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new AlphaMovieView$release$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b("AlphaMovieView", "player release");
            AlphaMovieView.PlayerState mState = this.this$0.getMState();
            AlphaMovieView.PlayerState playerState = AlphaMovieView.PlayerState.RELEASE;
            if (mState != playerState) {
                this.this$0.f16205l = playerState;
                this.this$0.getMMediaPlayer().release();
            }
            this.this$0.k();
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((AlphaMovieView$release$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
