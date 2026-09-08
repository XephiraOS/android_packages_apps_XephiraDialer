package com.android.contacts.framework.omoji.view;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: AlphaMovieView.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.view.AlphaMovieView$setVideoFromAssets$1", f = "AlphaMovieView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AlphaMovieView$setVideoFromAssets$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ String $assetsFileName;
    final /* synthetic */ boolean $isLooping;
    int label;
    final /* synthetic */ AlphaMovieView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaMovieView$setVideoFromAssets$1(AlphaMovieView alphaMovieView, String str, boolean z10, kotlin.coroutines.c<? super AlphaMovieView$setVideoFromAssets$1> cVar) {
        super(2, cVar);
        this.this$0 = alphaMovieView;
        this.$assetsFileName = str;
        this.$isLooping = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new AlphaMovieView$setVideoFromAssets$1(this.this$0, this.$assetsFileName, this.$isLooping, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.Q(this.$assetsFileName, this.$isLooping);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((AlphaMovieView$setVideoFromAssets$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
