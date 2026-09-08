package com.android.contacts.framework.omoji.view;

import android.media.MediaPlayer;
import com.android.contacts.framework.omoji.view.AlphaMovieView;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: AlphaMovieView.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.omoji.view.AlphaMovieView$start$1", f = "AlphaMovieView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AlphaMovieView$start$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ AlphaMovieView this$0;

    /* compiled from: AlphaMovieView.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16227a;

        static {
            int[] iArr = new int[AlphaMovieView.PlayerState.values().length];
            try {
                iArr[AlphaMovieView.PlayerState.PREPARED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AlphaMovieView.PlayerState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AlphaMovieView.PlayerState.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AlphaMovieView.PlayerState.STOPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f16227a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaMovieView$start$1(AlphaMovieView alphaMovieView, kotlin.coroutines.c<? super AlphaMovieView$start$1> cVar) {
        super(2, cVar);
        this.this$0 = alphaMovieView;
    }

    public static final void g(AlphaMovieView alphaMovieView, MediaPlayer mediaPlayer) {
        alphaMovieView.getMMediaPlayer().start();
        alphaMovieView.f16205l = AlphaMovieView.PlayerState.STARTED;
        AlphaMovieView.w(alphaMovieView);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new AlphaMovieView$start$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        q qVar;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b("AlphaMovieView", "start,  state:" + this.this$0.getMState() + " isDataSourceSet：" + this.this$0.f16208o);
            final AlphaMovieView alphaMovieView = this.this$0;
            try {
                Result.a aVar = Result.f34166a;
                int i10 = a.f16227a[alphaMovieView.getMState().ordinal()];
                if (i10 != 1) {
                    if (i10 != 2 && i10 != 3) {
                        if (i10 == 4) {
                            alphaMovieView.K(new MediaPlayer.OnPreparedListener() { // from class: com.android.contacts.framework.omoji.view.e
                                @Override // android.media.MediaPlayer.OnPreparedListener
                                public final void onPrepared(MediaPlayer mediaPlayer) {
                                    AlphaMovieView$start$1.g(AlphaMovieView.this, mediaPlayer);
                                }
                            });
                            qVar = q.f35511a;
                        } else {
                            H7.b.c("AlphaMovieView", "MediaPlayer start failed, state: " + alphaMovieView.getMState());
                            qVar = q.f35511a;
                        }
                    } else {
                        alphaMovieView.getMMediaPlayer().start();
                        alphaMovieView.f16205l = AlphaMovieView.PlayerState.STARTED;
                        qVar = q.f35511a;
                    }
                } else {
                    alphaMovieView.getMMediaPlayer().start();
                    alphaMovieView.f16205l = AlphaMovieView.PlayerState.STARTED;
                    AlphaMovieView.w(alphaMovieView);
                    qVar = null;
                }
                b10 = Result.b(qVar);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("AlphaMovieView", "mMediaPlayer start e: " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((AlphaMovieView$start$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
