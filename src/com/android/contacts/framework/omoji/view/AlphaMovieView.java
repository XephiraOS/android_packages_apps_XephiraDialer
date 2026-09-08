package com.android.contacts.framework.omoji.view;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import com.android.contacts.framework.omoji.view.i;
import com.oplus.foundation.util.io.CloseableUtils;
import java.io.IOException;
import kotlin.Result;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: AlphaMovieView.kt */
/* loaded from: classes.dex */
public final class AlphaMovieView extends GLTextureView {

    /* renamed from: D, reason: collision with root package name */
    public static final a f16201D = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public boolean f16202A;

    /* renamed from: B, reason: collision with root package name */
    public final m9.d f16203B;

    /* renamed from: C, reason: collision with root package name */
    public final m9.d f16204C;

    /* renamed from: l, reason: collision with root package name */
    public volatile PlayerState f16205l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f16206m;

    /* renamed from: n, reason: collision with root package name */
    public volatile boolean f16207n;

    /* renamed from: o, reason: collision with root package name */
    public volatile boolean f16208o;

    /* renamed from: p, reason: collision with root package name */
    public volatile boolean f16209p;

    /* renamed from: q, reason: collision with root package name */
    public i f16210q;

    /* renamed from: r, reason: collision with root package name */
    public AssetFileDescriptor f16211r;

    /* renamed from: x, reason: collision with root package name */
    public b f16212x;

    /* renamed from: y, reason: collision with root package name */
    public String f16213y;

    /* renamed from: z, reason: collision with root package name */
    public String f16214z;

    /* compiled from: AlphaMovieView.kt */
    /* loaded from: classes.dex */
    public enum PlayerState {
        NOT_PREPARED,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        RELEASE,
        PREPARING,
        COMPLETED
    }

    /* compiled from: AlphaMovieView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: AlphaMovieView.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* compiled from: AlphaMovieView.kt */
    /* loaded from: classes.dex */
    public interface c {
    }

    /* compiled from: AlphaMovieView.kt */
    /* loaded from: classes.dex */
    public static final class d implements i.b {
        public d() {
        }

        @Override // com.android.contacts.framework.omoji.view.i.b
        public void a(Surface surface) {
            Object b10;
            H7.b.b("AlphaMovieView", "surfacePrepared");
            AlphaMovieView.this.f16207n = true;
            AlphaMovieView alphaMovieView = AlphaMovieView.this;
            try {
                Result.a aVar = Result.f34166a;
                alphaMovieView.getMMediaPlayer().setSurface(surface);
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("AlphaMovieView", "addOnSurfacePrepareListener e: " + d10);
            }
            if (AlphaMovieView.this.f16208o) {
                AlphaMovieView.this.I();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaMovieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m9.d b10;
        m9.d b11;
        kotlin.jvm.internal.i.f(attrs, "attrs");
        this.f16205l = PlayerState.NOT_PREPARED;
        this.f16213y = "";
        this.f16214z = "";
        b10 = kotlin.a.b(AlphaMovieView$mTaskDispatcher$2.f16226a);
        this.f16203B = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<MediaPlayer>() { // from class: com.android.contacts.framework.omoji.view.AlphaMovieView$mMediaPlayer$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final MediaPlayer invoke() {
                return new MediaPlayer();
            }
        });
        this.f16204C = b11;
        if (!isInEditMode()) {
            l();
        }
    }

    public static final void F(AlphaMovieView this$0, MediaPlayer mediaPlayer) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f16205l = PlayerState.COMPLETED;
        b bVar = this$0.f16212x;
        if (bVar != null) {
            bVar.a();
        }
    }

    public static final void J(AlphaMovieView this$0, MediaPlayer mediaPlayer) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        H7.b.b("AlphaMovieView", "prepareAndStartMediaPlayer onPrepared");
        if (this$0.f16214z.length() > 0 && this$0.f16213y.length() > 0 && !kotlin.jvm.internal.i.b(this$0.f16214z, this$0.f16213y)) {
            H7.b.b("AlphaMovieView", "prepareAndStartMediaPlayer prepared assert not same as last set, need reset");
            this$0.O(this$0.f16213y, this$0.f16202A);
        } else {
            this$0.R();
        }
    }

    public static final void L(AlphaMovieView this$0, MediaPlayer.OnPreparedListener onPreparedListener, MediaPlayer mediaPlayer) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(onPreparedListener, "$onPreparedListener");
        this$0.f16205l = PlayerState.PREPARED;
        onPreparedListener.onPrepared(mediaPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaPlayer getMMediaPlayer() {
        return (MediaPlayer) this.f16204C.getValue();
    }

    private final ExecutorCoroutineDispatcher getMTaskDispatcher() {
        return (ExecutorCoroutineDispatcher) this.f16203B.getValue();
    }

    public static final /* synthetic */ c w(AlphaMovieView alphaMovieView) {
        alphaMovieView.getClass();
        return null;
    }

    public final void C() {
        i iVar = this.f16210q;
        if (iVar != null) {
            iVar.h(new d());
        }
    }

    public final String D(int i10) {
        if (i10 == 1) {
            return "omoji_guide.mp4";
        }
        return "";
    }

    public final void E() {
        setScreenOnWhilePlaying(true);
        getMMediaPlayer().setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.android.contacts.framework.omoji.view.a
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                AlphaMovieView.F(AlphaMovieView.this, mediaPlayer);
            }
        });
    }

    public final boolean G() {
        if (this.f16205l == PlayerState.STARTED) {
            return true;
        }
        return false;
    }

    public final void H(MediaMetadataRetriever mediaMetadataRetriever) {
        H7.b.b("AlphaMovieView", "onDataSourceSet");
        this.f16208o = true;
        this.f16214z = this.f16213y;
        if (this.f16207n) {
            I();
        }
        mediaMetadataRetriever.release();
    }

    public final void I() {
        H7.b.b("AlphaMovieView", "prepareAndStartMediaPlayer");
        K(new MediaPlayer.OnPreparedListener() { // from class: com.android.contacts.framework.omoji.view.b
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                AlphaMovieView.J(AlphaMovieView.this, mediaPlayer);
            }
        });
    }

    public final void K(final MediaPlayer.OnPreparedListener onPreparedListener) {
        Object b10;
        if (this.f16205l == PlayerState.NOT_PREPARED || this.f16205l == PlayerState.STOPPED) {
            getMMediaPlayer().setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.android.contacts.framework.omoji.view.c
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer) {
                    AlphaMovieView.L(AlphaMovieView.this, onPreparedListener, mediaPlayer);
                }
            });
            this.f16205l = PlayerState.PREPARING;
            try {
                Result.a aVar = Result.f34166a;
                getMMediaPlayer().prepareAsync();
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("AlphaMovieView", "prepareAsync e: " + d10);
            }
        }
    }

    public void M() {
        C1248i.d(C1241e0.f34422a, getMTaskDispatcher(), null, new AlphaMovieView$release$1(this, null), 2, null);
        getMTaskDispatcher().close();
        CloseableUtils.a(this.f16211r);
    }

    public void N(int i10, boolean z10, boolean z11) {
        O(D(i10), z10);
    }

    public final void O(String assetsFileName, boolean z10) {
        kotlin.jvm.internal.i.f(assetsFileName, "assetsFileName");
        P(assetsFileName, z10, false);
    }

    public final void P(String assetsFileName, boolean z10, boolean z11) {
        kotlin.jvm.internal.i.f(assetsFileName, "assetsFileName");
        if (this.f16206m) {
            H7.b.b("AlphaMovieView", "setVideoFromAssets surface is paused not play " + assetsFileName);
            this.f16202A = z10;
            this.f16213y = assetsFileName;
            this.f16209p = true;
            return;
        }
        if (!z11) {
            C1248i.d(C1241e0.f34422a, getMTaskDispatcher(), null, new AlphaMovieView$setVideoFromAssets$1(this, assetsFileName, z10, null), 2, null);
        } else {
            Q(assetsFileName, z10);
        }
    }

    public final void Q(String str, boolean z10) {
        H7.b.b("AlphaMovieView", "setVideoFromAssets state:" + this.f16205l);
        if (this.f16205l == PlayerState.RELEASE) {
            H7.b.b("AlphaMovieView", "setVideoFromAssets already release");
            return;
        }
        this.f16213y = str;
        this.f16202A = z10;
        if (this.f16205l == PlayerState.PREPARING) {
            H7.b.b("AlphaMovieView", "setVideoFromAssets preparing");
            return;
        }
        try {
            getMMediaPlayer().reset();
            this.f16205l = PlayerState.NOT_PREPARED;
            getMMediaPlayer().setLooping(z10);
            CloseableUtils.a(this.f16211r);
            AssetFileDescriptor openFd = getContext().getAssets().openFd(str);
            getMMediaPlayer().setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            H(mediaMetadataRetriever);
            this.f16211r = openFd;
        } catch (IOException e10) {
            H7.b.c("AlphaMovieView", "setVideoFromAssetsInner media player IO error " + e10.getMessage());
        } catch (IllegalStateException e11) {
            H7.b.c("AlphaMovieView", "setVideoFromAssetsInner media player state error " + e11.getMessage());
        }
    }

    public final void R() {
        C1248i.d(C1241e0.f34422a, getMTaskDispatcher(), null, new AlphaMovieView$start$1(this, null), 2, null);
    }

    public final void S() {
        C1248i.d(C1241e0.f34422a, getMTaskDispatcher(), null, new AlphaMovieView$stop$1(this, null), 2, null);
    }

    public final int getCurrentPosition() {
        return getMMediaPlayer().getCurrentPosition();
    }

    public final PlayerState getMState() {
        return this.f16205l;
    }

    public final void l() {
        setEGLContextClientVersion(2);
        n(8, 8, 8, 8, 16, 0);
        E();
        this.f16210q = new i();
        C();
        setOpaque(false);
        setRenderer(this.f16210q);
        bringToFront();
        setPreserveEGLContextOnPause(true);
    }

    @Override // com.android.contacts.framework.omoji.view.GLTextureView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        M();
    }

    public final void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        getMMediaPlayer().setOnErrorListener(onErrorListener);
    }

    public final void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        getMMediaPlayer().setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public final void setOnVideoEndedListener(b bVar) {
        this.f16212x = bVar;
    }

    public final void setScreenOnWhilePlaying(boolean z10) {
        getMMediaPlayer().setScreenOnWhilePlaying(z10);
    }

    public final void setOnVideoStartedListener(c cVar) {
    }
}
