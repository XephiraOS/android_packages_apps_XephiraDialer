package com.android.contacts.voicemail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import com.android.contacts.util.C0703d;
import com.android.contacts.util.InterfaceC0702c;
import com.android.contacts.util.w;
import com.customize.contacts.util.C0802m;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import s1.n;
import t1.C1580a;
import w0.C1643c;

/* loaded from: classes.dex */
public class VoicemailPlaybackPresenter implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {

    /* renamed from: n, reason: collision with root package name */
    public static final String f17876n = VoicemailPlaybackPresenter.class.getName() + ".VOICEMAIL_URI";

    /* renamed from: o, reason: collision with root package name */
    public static final String f17877o = VoicemailPlaybackPresenter.class.getName() + ".IS_PREPARED";

    /* renamed from: p, reason: collision with root package name */
    public static final String f17878p = VoicemailPlaybackPresenter.class.getName() + ".IS_PLAYING_STATE_KEY";

    /* renamed from: q, reason: collision with root package name */
    public static final String f17879q = VoicemailPlaybackPresenter.class.getName() + ".CLIP_POSITION_KEY";

    /* renamed from: r, reason: collision with root package name */
    public static final String f17880r = VoicemailPlaybackPresenter.class.getName() + ".IS_SPEAKER_PHONE_ON";

    /* renamed from: s, reason: collision with root package name */
    public static VoicemailPlaybackPresenter f17881s;

    /* renamed from: t, reason: collision with root package name */
    public static ScheduledExecutorService f17882t;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f17883a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public Context f17884b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f17885c;

    /* renamed from: d, reason: collision with root package name */
    public MediaPlayer f17886d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0702c f17887e;

    /* renamed from: f, reason: collision with root package name */
    public Activity f17888f;

    /* renamed from: g, reason: collision with root package name */
    public f f17889g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17890h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f17891i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17892j;

    /* renamed from: k, reason: collision with root package name */
    public d f17893k;

    /* renamed from: l, reason: collision with root package name */
    public PowerManager.WakeLock f17894l;

    /* renamed from: m, reason: collision with root package name */
    public n f17895m;

    /* loaded from: classes.dex */
    public enum Tasks {
        CHECK_FOR_CONTENT,
        CHECK_CONTENT_AFTER_CHANGE,
        SHARE_VOICEMAIL,
        SEND_FETCH_REQUEST
    }

    /* loaded from: classes.dex */
    public class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f17901a;

        public a(e eVar) {
            this.f17901a = eVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            VoicemailPlaybackPresenter voicemailPlaybackPresenter = VoicemailPlaybackPresenter.this;
            return Boolean.valueOf(voicemailPlaybackPresenter.y(voicemailPlaybackPresenter.f17885c));
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            this.f17901a.a(bool.booleanValue());
        }
    }

    /* loaded from: classes.dex */
    public class b extends AsyncTask<Void, Void, Void> {
        public b() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            String string;
            Cursor query = VoicemailPlaybackPresenter.this.f17884b.getContentResolver().query(VoicemailPlaybackPresenter.this.f17885c, new String[]{"source_package"}, null, null, null);
            try {
                if (!VoicemailPlaybackPresenter.l(query)) {
                    C1.a.b("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.requestContent mVoicemailUri does not return a SOURCE_PACKAGE");
                    string = null;
                } else {
                    string = query.getString(0);
                }
                Intent intent = new Intent("android.intent.action.FETCH_VOICEMAIL", VoicemailPlaybackPresenter.this.f17885c);
                intent.setPackage(string);
                C1.a.d("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.requestContent Sending ACTION_FETCH_VOICEMAIL to " + string);
                VoicemailPlaybackPresenter.this.f17884b.sendBroadcast(intent);
                if (query != null) {
                    query.close();
                }
                return null;
            } catch (Throwable th) {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements e {
        public c() {
        }

        @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.e
        public void a(boolean z10) {
            if (z10) {
                VoicemailPlaybackPresenter.this.f17890h = true;
                VoicemailPlaybackPresenter.this.x();
            } else {
                VoicemailPlaybackPresenter voicemailPlaybackPresenter = VoicemailPlaybackPresenter.this;
                voicemailPlaybackPresenter.f17890h = voicemailPlaybackPresenter.z(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends ContentObserver implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f17905a;

        /* renamed from: b, reason: collision with root package name */
        public final Uri f17906b;

        /* renamed from: c, reason: collision with root package name */
        public AtomicBoolean f17907c;

        /* loaded from: classes.dex */
        public class a extends AsyncTask<Void, Void, Boolean> {
            public a() {
            }

            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(Void... voidArr) {
                d dVar = d.this;
                return Boolean.valueOf(VoicemailPlaybackPresenter.this.y(dVar.f17906b));
            }

            @Override // android.os.AsyncTask
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                if (bool.booleanValue()) {
                    d dVar = d.this;
                    if (VoicemailPlaybackPresenter.this.f17884b != null && dVar.f17907c.getAndSet(false)) {
                        try {
                            VoicemailPlaybackPresenter.this.f17884b.getContentResolver().unregisterContentObserver(d.this);
                        } catch (Exception e10) {
                            H7.b.c("VoicemailPlaybackPresenter", "unregisterContentObserver: " + e10);
                        }
                        VoicemailPlaybackPresenter.this.x();
                    }
                }
            }
        }

        public d(Handler handler, Uri uri, int i10) {
            super(handler);
            this.f17907c = new AtomicBoolean(true);
            this.f17905a = handler;
            this.f17906b = uri;
            Context context = VoicemailPlaybackPresenter.this.f17884b;
            if (context != null) {
                if (w.o(context)) {
                    VoicemailPlaybackPresenter.this.f17884b.getContentResolver().registerContentObserver(uri, false, this);
                }
                handler.postDelayed(this, 20000L);
            }
        }

        public void c() {
            Context context;
            if (this.f17907c.getAndSet(false) && (context = VoicemailPlaybackPresenter.this.f17884b) != null) {
                try {
                    context.getContentResolver().unregisterContentObserver(this);
                } catch (Exception e10) {
                    H7.b.c("VoicemailPlaybackPresenter", "unregisterContentObserver: " + e10);
                }
                this.f17905a.removeCallbacks(this);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            VoicemailPlaybackPresenter.this.f17887e.a(Tasks.CHECK_CONTENT_AFTER_CHANGE, new a(), new Void[0]);
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            if (this.f17907c.getAndSet(false) && (context = VoicemailPlaybackPresenter.this.f17884b) != null) {
                try {
                    context.getContentResolver().unregisterContentObserver(this);
                } catch (Exception e10) {
                    H7.b.c("VoicemailPlaybackPresenter", "unregisterContentObserver: " + e10);
                }
                if (VoicemailPlaybackPresenter.this.f17889g != null) {
                    VoicemailPlaybackPresenter.this.f17889g.d();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(boolean z10);
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(int i10, int i11);

        void b();

        void c();

        void d();

        void e();

        void f();

        int getDesiredClipPosition();

        int getPlaybackPosition();

        boolean getSpeakerphoneOn();

        void h();

        void i();

        void j(int i10);

        void k(int i10, ScheduledExecutorService scheduledExecutorService);
    }

    public VoicemailPlaybackPresenter(Activity activity) {
        Context applicationContext = activity.getApplicationContext();
        this.f17887e = C0703d.b();
        this.f17895m = new n(applicationContext, this);
        PowerManager powerManager = (PowerManager) applicationContext.getSystemService("power");
        if (powerManager.isWakeLockLevelSupported(32)) {
            this.f17894l = powerManager.newWakeLock(32, "Contacts:VoicemailPlaybackPresenterWakeLock");
        }
    }

    public static VoicemailPlaybackPresenter h(Activity activity, Bundle bundle) {
        if (f17881s == null) {
            f17881s = new VoicemailPlaybackPresenter(activity);
        }
        f17881s.m(activity, bundle);
        return f17881s;
    }

    public static synchronized ScheduledExecutorService j() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (VoicemailPlaybackPresenter.class) {
            try {
                if (f17882t == null) {
                    f17882t = Executors.newScheduledThreadPool(2);
                }
                scheduledExecutorService = f17882t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return scheduledExecutorService;
    }

    public static boolean l(Cursor cursor) {
        if (cursor != null && cursor.moveToFirst()) {
            return true;
        }
        return false;
    }

    public void A() {
        if (this.f17889g == null) {
            return;
        }
        if (!this.f17891i) {
            e(new c());
            return;
        }
        this.f17890h = true;
        this.f17888f.getWindow().addFlags(128);
        MediaPlayer mediaPlayer = this.f17886d;
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            int max = Math.max(0, Math.min(this.f17889g.getPlaybackPosition(), this.f17883a.get()));
            this.f17886d.seekTo(max);
            C1.a.a("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.resumePlayback resumed playback at pistion " + max);
            try {
                this.f17895m.i();
                this.f17886d.start();
                E(this.f17889g.getSpeakerphoneOn());
                this.f17895m.m(this.f17889g.getSpeakerphoneOn());
            } catch (RejectedExecutionException e10) {
                k(e10);
            }
        }
        this.f17889g.k(this.f17883a.get(), j());
    }

    public void B(int i10) {
        f fVar = this.f17889g;
        if (fVar != null) {
            fVar.j(i10);
        }
        if (this.f17892j) {
            this.f17892j = false;
            A();
        }
    }

    public void C(int i10) {
        f fVar = this.f17889g;
        if (fVar != null) {
            fVar.j(i10);
        }
        MediaPlayer mediaPlayer = this.f17886d;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(i10);
        }
    }

    public void D(f fVar, Uri uri) {
        if (this.f17889g != fVar || this.f17885c != uri) {
            t();
            this.f17891i = false;
        }
        this.f17889g = fVar;
        this.f17885c = uri;
    }

    public void E(boolean z10) {
        if (this.f17889g != null && this.f17890h) {
            if (!z10 && !this.f17895m.g()) {
                g();
            } else {
                f(false);
            }
        }
    }

    public void F(boolean z10) {
        this.f17895m.m(!z10);
        E(!z10);
    }

    public void e(e eVar) {
        this.f17887e.a(Tasks.CHECK_FOR_CONTENT, new a(eVar), new Void[0]);
    }

    public final void f(boolean z10) {
        PowerManager.WakeLock wakeLock = this.f17894l;
        if (wakeLock == null) {
            return;
        }
        if (wakeLock.isHeld()) {
            C1.a.d("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.disableProximitySensor releasing proximity wake lock");
            this.f17894l.release(z10 ? 1 : 0);
        } else {
            C1.a.d("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.disableProximitySensor proximity wake lock already released");
        }
    }

    public final void g() {
        MediaPlayer mediaPlayer;
        if (this.f17894l != null) {
            f fVar = this.f17889g;
            if ((fVar == null || !fVar.getSpeakerphoneOn()) && this.f17891i && (mediaPlayer = this.f17886d) != null && mediaPlayer.isPlaying()) {
                if (!this.f17894l.isHeld()) {
                    C1.a.d("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.enableProximitySensor acquiring proximity wake lock");
                    this.f17894l.acquire();
                } else {
                    C1.a.d("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.enableProximitySensor proximity wake lock already acquired");
                }
            }
        }
    }

    public int i() {
        MediaPlayer mediaPlayer;
        if (this.f17891i && (mediaPlayer = this.f17886d) != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public void k(Exception exc) {
        C1.a.b("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.handlerError could not play voicemail " + exc);
        if (this.f17891i) {
            this.f17886d.release();
            this.f17886d = null;
            this.f17891i = false;
        }
        f fVar = this.f17889g;
        if (fVar != null) {
            fVar.f();
            this.f17889g.j(0);
        }
        this.f17890h = false;
    }

    public void m(Activity activity, Bundle bundle) {
        C1580a.c();
        this.f17888f = activity;
        this.f17884b = activity;
        if (bundle != null) {
            this.f17891i = bundle.getBoolean(f17877o);
            this.f17890h = bundle.getBoolean(f17878p, false);
        }
        if (this.f17886d == null) {
            this.f17891i = false;
            this.f17890h = false;
        }
        if (this.f17888f != null) {
            if (n()) {
                this.f17888f.getWindow().addFlags(128);
            } else {
                this.f17888f.getWindow().clearFlags(128);
            }
        }
    }

    public boolean n() {
        return this.f17890h;
    }

    public void o(boolean z10) {
        if (this.f17890h == z10) {
            return;
        }
        if (z10) {
            A();
        } else {
            u(true);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        t();
        if (this.f17889g != null) {
            mediaPlayer.seekTo(0);
            this.f17889g.j(0);
            this.f17889g.a(0, this.f17883a.get());
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
        k(new IllegalStateException("MediaPlayer error listener invoked: " + i11));
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.f17889g != null && this.f17884b != null) {
            C1.a.a("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.onPrepared");
            this.f17891i = true;
            this.f17883a.set(this.f17886d.getDuration());
            int playbackPosition = this.f17889g.getPlaybackPosition();
            C1.a.a("VoicemailPlaybackPresenter.onPrepared", "mPosition=" + playbackPosition);
            this.f17889g.a(playbackPosition, this.f17883a.get());
            this.f17889g.c();
            this.f17889g.e();
            if (!mediaPlayer.isPlaying()) {
                this.f17886d.seekTo(playbackPosition);
            }
            if (this.f17890h) {
                A();
            } else {
                t();
            }
        }
    }

    public void p() {
        this.f17888f = null;
        this.f17884b = null;
        ScheduledExecutorService scheduledExecutorService = f17882t;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            f17882t = null;
        }
        d dVar = this.f17893k;
        if (dVar != null) {
            dVar.c();
            this.f17893k = null;
        }
        MediaPlayer mediaPlayer = this.f17886d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f17886d = null;
        }
    }

    public void q() {
        this.f17895m.p();
        Activity activity = this.f17888f;
        if (activity != null && this.f17891i && activity.isChangingConfigurations()) {
            C1.a.a("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.onPause configuration changed.");
            return;
        }
        w(false);
        if (C1643c.w()) {
            this.f17895m.k(0);
        }
    }

    public void r() {
        this.f17895m.h();
    }

    public void s(Bundle bundle) {
        if (this.f17889g != null) {
            bundle.putParcelable(f17876n, this.f17885c);
            bundle.putBoolean(f17877o, this.f17891i);
            bundle.putInt(f17879q, this.f17889g.getDesiredClipPosition());
            bundle.putBoolean(f17878p, this.f17890h);
        }
    }

    public void t() {
        u(false);
    }

    public final void u(boolean z10) {
        if (!this.f17891i) {
            return;
        }
        int i10 = 0;
        this.f17890h = false;
        MediaPlayer mediaPlayer = this.f17886d;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f17886d.pause();
        }
        MediaPlayer mediaPlayer2 = this.f17886d;
        if (mediaPlayer2 != null) {
            i10 = mediaPlayer2.getCurrentPosition();
        }
        f fVar = this.f17889g;
        if (fVar != null) {
            fVar.j(i10);
        }
        C1.a.a("VoicemailPlaybackPresenter", "VoicemailPlaybackPresenter.pausePlayback paused playback at pistion " + i10);
        f fVar2 = this.f17889g;
        if (fVar2 != null) {
            fVar2.b();
        }
        if (!z10) {
            this.f17895m.b();
        }
        Activity activity = this.f17888f;
        if (activity != null) {
            activity.getWindow().clearFlags(128);
        }
        f(true);
    }

    public void v() {
        MediaPlayer mediaPlayer = this.f17886d;
        if (mediaPlayer != null) {
            this.f17892j = mediaPlayer.isPlaying();
        }
        u(true);
    }

    public void w(boolean z10) {
        f fVar;
        t();
        MediaPlayer mediaPlayer = this.f17886d;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f17886d = null;
        }
        f(false);
        this.f17891i = false;
        this.f17890h = false;
        if (z10 && (fVar = this.f17889g) != null) {
            fVar.j(0);
        }
        f fVar2 = this.f17889g;
        if (fVar2 != null) {
            fVar2.b();
            if (z10) {
                this.f17889g.a(0, this.f17883a.get());
                return;
            }
            f fVar3 = this.f17889g;
            if (fVar3 != null) {
                fVar3.j(fVar3.getDesiredClipPosition());
            }
        }
    }

    public void x() {
        if (this.f17889g != null && this.f17884b != null) {
            C1.a.a("VoicemailPlaybackPresenter.prepareContent", "");
            MediaPlayer mediaPlayer = this.f17886d;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                this.f17886d = null;
            }
            this.f17889g.h();
            this.f17891i = false;
            Context context = this.f17884b;
            if (context != null && C0802m.b(context)) {
                k(new IllegalStateException("Cannot play voicemail when call is in progress"));
                return;
            }
            try {
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                this.f17886d = mediaPlayer2;
                mediaPlayer2.setOnPreparedListener(this);
                this.f17886d.setOnErrorListener(this);
                this.f17886d.setOnCompletionListener(this);
                this.f17886d.reset();
                this.f17886d.setDataSource(this.f17884b, this.f17885c);
                this.f17886d.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(0).build());
                this.f17886d.prepareAsync();
            } catch (IOException e10) {
                k(e10);
            }
        }
    }

    public final boolean y(Uri uri) {
        Context context;
        int i10;
        boolean z10 = false;
        if (uri != null && (context = this.f17884b) != null) {
            Cursor query = context.getContentResolver().query(uri, new String[]{"duration", "has_content"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        int i11 = query.getInt(0);
                        AtomicInteger atomicInteger = this.f17883a;
                        if (i11 > 0) {
                            i10 = i11 * 1000;
                        } else {
                            i10 = 0;
                        }
                        atomicInteger.set(i10);
                        if (query.getInt(1) == 1) {
                            z10 = true;
                        }
                        return z10;
                    }
                } finally {
                    com.oplus.foundation.util.io.e.a(query);
                }
            }
        }
        return false;
    }

    public boolean z(int i10) {
        if (this.f17884b == null || this.f17885c == null) {
            return false;
        }
        d dVar = new d(new Handler(), this.f17885c, i10);
        d dVar2 = this.f17893k;
        if (dVar2 != null) {
            dVar2.c();
        }
        this.f17889g.i();
        this.f17893k = dVar;
        this.f17887e.a(Tasks.SEND_FETCH_REQUEST, new b(), new Void[0]);
        return true;
    }
}
