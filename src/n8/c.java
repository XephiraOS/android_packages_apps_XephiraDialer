package N8;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import m9.q;

/* compiled from: OplusMediaPlayer.kt */
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f2387d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public MediaPlayer f2388a = new MediaPlayer();

    /* renamed from: b, reason: collision with root package name */
    public MediaPlayer.OnCompletionListener f2389b;

    /* renamed from: c, reason: collision with root package name */
    public MediaPlayer.OnErrorListener f2390c;

    /* compiled from: OplusMediaPlayer.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void p(c this$0, MediaPlayer mediaPlayer) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        MediaPlayer.OnCompletionListener onCompletionListener = this$0.f2389b;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion(this$0.f2388a);
        }
    }

    public static final boolean r(c this$0, MediaPlayer mediaPlayer, int i10, int i11) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        R8.a.f3357a.d("OplusMediaPlayer", "mMediaPlayer  onErroer  what = " + i10 + " extra = " + i11);
        MediaPlayer.OnErrorListener onErrorListener = this$0.f2390c;
        if (onErrorListener != null) {
            return onErrorListener.onError(this$0.f2388a, i10, i11);
        }
        return false;
    }

    public final int c() {
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public final int d() {
        int i10;
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            i10 = mediaPlayer.getVideoHeight();
        } else {
            i10 = 0;
        }
        R8.a.f3357a.b("OplusMediaPlayer", "getVideoHeight : " + i10 + ' ');
        return i10;
    }

    public final int e() {
        int i10;
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            i10 = mediaPlayer.getVideoWidth();
        } else {
            i10 = 0;
        }
        R8.a.f3357a.b("OplusMediaPlayer", "getVideoWidth : " + i10 + ' ');
        return i10;
    }

    public final boolean f() {
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            return mediaPlayer.isPlaying();
        }
        return false;
    }

    public final void g() {
        q qVar;
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "pause");
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            aVar.d("OplusMediaPlayer", "pause error");
        }
    }

    public final void h(int i10) {
        q qVar;
        R8.a.f3357a.b("OplusMediaPlayer", "prepare ");
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setAudioStreamType(i10);
                mediaPlayer.prepare();
            } catch (IOException e10) {
                R8.a.f3357a.d("OplusMediaPlayer", "prepare  e = " + e10.getMessage());
            }
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            R8.a.f3357a.d("OplusMediaPlayer", "prepare error state ");
        }
    }

    public final void i() {
        q qVar;
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "release");
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            aVar.d("OplusMediaPlayer", "release error state ");
        }
        this.f2388a = null;
    }

    public final void j() {
        q qVar;
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "reset");
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            aVar.d("OplusMediaPlayer", "reset error state ");
        }
    }

    public final void k(int i10) {
        q qVar;
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "seekTo msec = $msec");
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i10);
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            aVar.d("OplusMediaPlayer", "seekTo error");
        }
    }

    public final void l(Context context, Uri uri) {
        q qVar;
        kotlin.jvm.internal.i.f(uri, "uri");
        R8.a.f3357a.b("OplusMediaPlayer", "setDataSource uri = " + uri);
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            if (context != null) {
                try {
                    mediaPlayer.setDataSource(context, uri);
                } catch (IOException e10) {
                    R8.a.f3357a.d("OplusMediaPlayer", "setDataSource uri e = " + e10.getMessage());
                }
            }
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            R8.a.f3357a.d("OplusMediaPlayer", "setDataSource error state ");
        }
    }

    public final void m(String str) {
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "setDataSource");
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            try {
                kotlin.jvm.internal.i.c(mediaPlayer);
                mediaPlayer.setDataSource(str);
                return;
            } catch (IOException e10) {
                R8.a.f3357a.d("OplusMediaPlayer", "setDataSource e = " + e10.getMessage());
                return;
            }
        }
        aVar.d("OplusMediaPlayer", "setDataSource error state ");
    }

    public final void n(boolean z10) {
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z10);
        }
    }

    public final void o(MediaPlayer.OnCompletionListener onCompletionListener) {
        q qVar;
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "setOnCompletionListener");
        this.f2389b = onCompletionListener;
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: N8.b
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer2) {
                    c.p(c.this, mediaPlayer2);
                }
            });
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            aVar.d("OplusMediaPlayer", "setOnCompletionListener error");
        }
    }

    public final void q(MediaPlayer.OnErrorListener onErrorListener) {
        q qVar;
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "setOnErrorListener");
        this.f2390c = onErrorListener;
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: N8.a
                @Override // android.media.MediaPlayer.OnErrorListener
                public final boolean onError(MediaPlayer mediaPlayer2, int i10, int i11) {
                    boolean r10;
                    r10 = c.r(c.this, mediaPlayer2, i10, i11);
                    return r10;
                }
            });
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            aVar.d("OplusMediaPlayer", "setOnErrorListener error");
        }
    }

    public final void s(Surface surface) {
        Log.d("OplusMediaPlayer", "setSurface: " + surface);
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    public final void t(float f10) {
        R8.a.f3357a.b("OplusMediaPlayer", "setVolume volume  " + f10);
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f10, f10);
        }
    }

    public final void u() {
        q qVar;
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "start");
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            aVar.d("OplusMediaPlayer", "start error");
        }
    }

    public final void v() {
        q qVar;
        R8.a aVar = R8.a.f3357a;
        aVar.b("OplusMediaPlayer", "stop");
        MediaPlayer mediaPlayer = this.f2388a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            qVar = q.f35511a;
        } else {
            qVar = null;
        }
        if (qVar == null) {
            aVar.d("OplusMediaPlayer", "stop error state ");
        }
    }
}
