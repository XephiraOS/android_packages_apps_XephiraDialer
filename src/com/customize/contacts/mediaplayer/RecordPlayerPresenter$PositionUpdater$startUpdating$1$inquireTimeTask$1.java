package com.customize.contacts.mediaplayer;

import android.media.MediaPlayer;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordPlayerPresenter.kt */
@InterfaceC1470d(c = "com.customize.contacts.mediaplayer.RecordPlayerPresenter$PositionUpdater$startUpdating$1$inquireTimeTask$1", f = "RecordPlayerPresenter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecordPlayerPresenter$PositionUpdater$startUpdating$1$inquireTimeTask$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Ref$LongRef $seekBarMax;
    final /* synthetic */ Ref$LongRef $seekBarPositionMs;
    int label;
    final /* synthetic */ RecordPlayerPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPlayerPresenter$PositionUpdater$startUpdating$1$inquireTimeTask$1(Ref$LongRef ref$LongRef, RecordPlayerPresenter recordPlayerPresenter, Ref$LongRef ref$LongRef2, kotlin.coroutines.c<? super RecordPlayerPresenter$PositionUpdater$startUpdating$1$inquireTimeTask$1> cVar) {
        super(2, cVar);
        this.$seekBarPositionMs = ref$LongRef;
        this.this$0 = recordPlayerPresenter;
        this.$seekBarMax = ref$LongRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new RecordPlayerPresenter$PositionUpdater$startUpdating$1$inquireTimeTask$1(this.$seekBarPositionMs, this.this$0, this.$seekBarMax, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            try {
                Ref$LongRef ref$LongRef = this.$seekBarPositionMs;
                MediaPlayer mediaPlayer = this.this$0.f21653g;
                int i11 = 0;
                if (mediaPlayer != null) {
                    i10 = mediaPlayer.getCurrentPosition();
                } else {
                    i10 = 0;
                }
                ref$LongRef.element = Math.max(0, i10);
                Ref$LongRef ref$LongRef2 = this.$seekBarMax;
                long j10 = this.$seekBarPositionMs.element;
                MediaPlayer mediaPlayer2 = this.this$0.f21653g;
                if (mediaPlayer2 != null) {
                    i11 = mediaPlayer2.getDuration();
                }
                ref$LongRef2.element = Math.max(j10, i11);
            } catch (Exception e10) {
                H7.b.c("RecordPlayerPresenter", "exception when update the process bar " + e10);
                this.$seekBarMax.element = 0L;
                this.$seekBarPositionMs.element = 0L;
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordPlayerPresenter$PositionUpdater$startUpdating$1$inquireTimeTask$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
