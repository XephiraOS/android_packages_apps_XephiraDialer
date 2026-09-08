package com.android.contacts.dialpad;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import com.android.contacts.ContactsApplication;

/* compiled from: DialpadClickToneAndVibratePlayer.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public AudioManager f14918b;

    /* renamed from: c, reason: collision with root package name */
    public Context f14919c;

    /* renamed from: d, reason: collision with root package name */
    public ToneGenerator f14920d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14921e;

    /* renamed from: f, reason: collision with root package name */
    public b f14922f;

    /* renamed from: g, reason: collision with root package name */
    public HandlerThread f14923g;

    /* renamed from: a, reason: collision with root package name */
    public final Object f14917a = new Object();

    /* renamed from: h, reason: collision with root package name */
    public final ContentObserver f14924h = new a(new Handler());

    /* compiled from: DialpadClickToneAndVibratePlayer.java */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            c.this.i();
        }
    }

    /* compiled from: DialpadClickToneAndVibratePlayer.java */
    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            j jVar;
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        c.this.p();
                        return;
                    }
                    if (i10 != 4) {
                        if (i10 == 5 && (jVar = (j) message.obj) != null) {
                            jVar.c();
                            return;
                        }
                        return;
                    }
                    if (c.this.f14920d != null) {
                        c.this.f14920d.release();
                        c.this.f14920d = null;
                    }
                    if (message.arg1 == 1) {
                        c.this.f14923g.quit();
                        return;
                    }
                    return;
                }
                if (c.this.f14921e) {
                    c.this.r();
                    return;
                }
                return;
            }
            if (c.this.f14921e && !c.this.k()) {
                c.this.l(message.arg1);
            }
            j jVar2 = (j) message.obj;
            if (jVar2 != null) {
                jVar2.c();
            }
        }
    }

    public c(Context context) {
        this.f14919c = context;
        HandlerThread handlerThread = new HandlerThread("tone_playback_thread");
        this.f14923g = handlerThread;
        handlerThread.start();
        this.f14922f = new b(this.f14923g.getLooper());
        j();
        n();
    }

    public void i() {
        try {
            boolean z10 = true;
            if (G0.c.d(this.f14919c, 0, "dtmf_tone", 1) != 1) {
                z10 = false;
            }
            this.f14921e = z10;
            if (H7.a.b()) {
                H7.b.b("DialpadClickToneAndVibratePlayer", "mDTMFToneEnabled " + this.f14921e);
            }
        } catch (Exception e10) {
            H7.b.c("DialpadClickToneAndVibratePlayer", "checkDTMFEnabled error " + e10);
            this.f14921e = false;
        }
    }

    public void j() {
        Message obtain = Message.obtain();
        obtain.what = 3;
        this.f14922f.sendMessage(obtain);
    }

    public final boolean k() {
        if (this.f14918b == null) {
            this.f14918b = (AudioManager) this.f14919c.getApplicationContext().getSystemService("audio");
        }
        AudioManager audioManager = this.f14918b;
        if (audioManager == null) {
            if (H7.a.b()) {
                H7.b.e("DialpadClickToneAndVibratePlayer", "mAudioMgr == null");
            }
            return true;
        }
        int ringerMode = audioManager.getRingerMode();
        if (H7.a.b()) {
            H7.b.e("DialpadClickToneAndVibratePlayer", "ringerMode " + ringerMode);
        }
        if (ringerMode == 0 || ringerMode == 1) {
            return true;
        }
        return false;
    }

    public final void l(int i10) {
        synchronized (this.f14917a) {
            try {
                p();
                if (this.f14920d == null) {
                    H7.b.i("DialpadClickToneAndVibratePlayer", "playTone: mToneGenerator == null, tone: " + i10);
                    return;
                }
                if (H7.a.b()) {
                    H7.b.b("DialpadClickToneAndVibratePlayer", "startTone tone = " + i10);
                }
                this.f14920d.startTone(i10, 150);
                if (H7.a.b()) {
                    H7.b.b("DialpadClickToneAndVibratePlayer", "play tone " + i10 + " end.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m(int i10, j jVar) {
        this.f14922f.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i10;
        obtain.obj = jVar;
        this.f14922f.sendMessage(obtain);
    }

    public void n() {
        try {
            ContactsApplication.h().getContentResolver().registerContentObserver(Settings.System.getUriFor("dtmf_tone"), false, this.f14924h);
        } catch (Exception e10) {
            H7.b.c("DialpadClickToneAndVibratePlayer", "registerObserver : " + e10);
        }
    }

    public void o(boolean z10) {
        Message obtain = Message.obtain();
        obtain.what = 4;
        if (z10) {
            obtain.arg1 = 1;
        }
        this.f14922f.sendMessage(obtain);
    }

    public final void p() {
        if (this.f14920d == null) {
            try {
                if (H7.a.b()) {
                    H7.b.e("DialpadClickToneAndVibratePlayer", "mToneGenerator init -----------start");
                }
                this.f14920d = new ToneGenerator(8, 80);
                if (H7.a.b()) {
                    H7.b.e("DialpadClickToneAndVibratePlayer", "mToneGenerator init -----------end");
                }
            } catch (RuntimeException e10) {
                H7.b.i("DialpadClickToneAndVibratePlayer", "Exception caught while creating local tone generator: " + e10);
                this.f14920d = null;
            }
        }
    }

    public void q() {
        Message obtainMessage = this.f14922f.obtainMessage();
        obtainMessage.what = 2;
        this.f14922f.sendMessage(obtainMessage);
    }

    public final void r() {
        synchronized (this.f14917a) {
            try {
                ToneGenerator toneGenerator = this.f14920d;
                if (toneGenerator == null) {
                    H7.b.i("DialpadClickToneAndVibratePlayer", "stopTone: mToneGenerator == null");
                } else {
                    toneGenerator.stopTone();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void s() {
        try {
            ContactsApplication.h().getContentResolver().unregisterContentObserver(this.f14924h);
        } catch (Exception e10) {
            H7.b.c("DialpadClickToneAndVibratePlayer", "unregisterObserver : " + e10);
        }
    }

    public void t(j jVar) {
        this.f14922f.removeMessages(5);
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = jVar;
        this.f14922f.sendMessage(obtain);
    }
}
