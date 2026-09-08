package com.customize.contacts.mediaplayer;

import android.content.ContentUris;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordPlayerPresenter.kt */
@InterfaceC1470d(c = "com.customize.contacts.mediaplayer.RecordPlayerPresenter$prepareToPlayerStart$1$1$1", f = "RecordPlayerPresenter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecordPlayerPresenter$prepareToPlayerStart$1$1$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Ref$LongRef $id;
    int label;
    final /* synthetic */ RecordPlayerPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPlayerPresenter$prepareToPlayerStart$1$1$1(RecordPlayerPresenter recordPlayerPresenter, Ref$LongRef ref$LongRef, kotlin.coroutines.c<? super RecordPlayerPresenter$prepareToPlayerStart$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = recordPlayerPresenter;
        this.$id = ref$LongRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new RecordPlayerPresenter$prepareToPlayerStart$1$1$1(this.this$0, this.$id, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int S10;
        long j10;
        long j11;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.M();
            S10 = this.this$0.S();
            try {
                MediaPlayer mediaPlayer = this.this$0.f21653g;
                if (mediaPlayer != null) {
                    RecordPlayerPresenter recordPlayerPresenter = this.this$0;
                    Ref$LongRef ref$LongRef = this.$id;
                    mediaPlayer.reset();
                    mediaPlayer.setAudioStreamType(S10);
                    mediaPlayer.setDataSource(recordPlayerPresenter.U(), ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, ref$LongRef.element));
                    mediaPlayer.prepare();
                    j10 = recordPlayerPresenter.f21660n;
                    if (j10 != -1) {
                        j11 = recordPlayerPresenter.f21660n;
                        mediaPlayer.seekTo((int) j11);
                    }
                }
                this.this$0.w0(S10);
            } catch (Exception unused) {
                this.this$0.k0();
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordPlayerPresenter$prepareToPlayerStart$1$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
