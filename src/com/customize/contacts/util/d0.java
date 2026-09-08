package com.customize.contacts.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.android.contacts.ContactsApplication;
import com.customize.contacts.FeatureOption;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: SimpleModeVoicePlayer.java */
/* loaded from: classes3.dex */
public class d0 {

    /* renamed from: u, reason: collision with root package name */
    public static volatile d0 f22061u;

    /* renamed from: a, reason: collision with root package name */
    public AudioManager f22062a;

    /* renamed from: b, reason: collision with root package name */
    public Context f22063b;

    /* renamed from: c, reason: collision with root package name */
    public View.OnClickListener f22064c;

    /* renamed from: d, reason: collision with root package name */
    public View f22065d;

    /* renamed from: e, reason: collision with root package name */
    public SoundPool f22066e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22068g;

    /* renamed from: r, reason: collision with root package name */
    public d f22079r;

    /* renamed from: s, reason: collision with root package name */
    public HandlerThread f22080s;

    /* renamed from: t, reason: collision with root package name */
    public final ContentObserver f22081t;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22067f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22069h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f22070i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f22071j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f22072k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f22073l = false;

    /* renamed from: m, reason: collision with root package name */
    public int f22074m = 0;

    /* renamed from: n, reason: collision with root package name */
    public HashMap<Integer, Integer> f22075n = new HashMap<>();

    /* renamed from: o, reason: collision with root package name */
    public final String[] f22076o = {"dialpad_wav_1", "dialpad_wav_2", "dialpad_wav_3", "dialpad_wav_4", "dialpad_wav_5", "dialpad_wav_6", "dialpad_wav_7", "dialpad_wav_8", "dialpad_wav_9", "dialpad_wav_star", "dialpad_wav_zero", "dialpad_wav_sharp", "dialpad_wav_close", "dialpad_wav_dial", "dialpad_wav_del"};

    /* renamed from: p, reason: collision with root package name */
    public final int[] f22077p = {8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 7, 18, 119, 5, 67};

    /* renamed from: q, reason: collision with root package name */
    public Handler f22078q = new a(Looper.getMainLooper());

    /* compiled from: SimpleModeVoicePlayer.java */
    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            H7.b.b("SimpleModeVoicePlayer", "mMainThreadHandler msg.what:" + message.what);
            if (message.what == 1) {
                d0.this.f22070i = false;
                d0.this.f22071j = true;
                d0.this.f22064c.onClick(d0.this.f22065d);
                d0.this.f22071j = false;
            }
        }
    }

    /* compiled from: SimpleModeVoicePlayer.java */
    /* loaded from: classes3.dex */
    public class b extends ContentObserver {
        public b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            d0 d0Var = d0.this;
            d0Var.f22074m = Settings.Secure.getInt(d0Var.f22063b.getContentResolver(), "simple_mode_enabled", 0);
            H7.b.b("SimpleModeVoicePlayer", "mSimpleModeObserver mSimpleMode:" + d0.this.f22074m);
            if (d0.this.f22074m == 1) {
                d0.this.s();
            } else {
                d0.this.A();
            }
        }
    }

    /* compiled from: SimpleModeVoicePlayer.java */
    /* loaded from: classes3.dex */
    public class c implements SoundPool.OnLoadCompleteListener {
        public c() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public void onLoadComplete(SoundPool soundPool, int i10, int i11) {
            d0.this.f22073l = true;
            H7.b.b("SimpleModeVoicePlayer", "onLoadComplete");
        }
    }

    /* compiled from: SimpleModeVoicePlayer.java */
    /* loaded from: classes3.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            H7.b.b("SimpleModeVoicePlayer", "mVoicePlayerHandler msg.what:" + message.what);
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    int i11 = message.arg1;
                    d0 d0Var = d0.this;
                    d0Var.x(d0Var.f22063b, i11);
                    if (d0.this.t()) {
                        com.android.contacts.framework.baseui.util.A.a(d0.this.f22063b.getApplicationContext(), 2000304, 200030403, null, false);
                        return;
                    }
                    return;
                }
                return;
            }
            d0 d0Var2 = d0.this;
            d0Var2.f22074m = Settings.Secure.getInt(d0Var2.f22063b.getContentResolver(), "simple_mode_enabled", 0);
            if (d0.this.f22074m == 1) {
                d0.this.s();
            }
            d0.this.o();
            d0.this.f22072k = K.d();
        }
    }

    public d0(Context context) {
        this.f22068g = false;
        b bVar = new b(new Handler());
        this.f22081t = bVar;
        if (!C0811w.f()) {
            return;
        }
        this.f22063b = context;
        this.f22068g = true;
        context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("simple_mode_enabled"), false, bVar);
        HandlerThread handlerThread = new HandlerThread("simple_voice_player");
        this.f22080s = handlerThread;
        handlerThread.start();
        this.f22079r = new d(this.f22080s.getLooper());
    }

    public static d0 p() {
        if (f22061u == null) {
            synchronized (d0.class) {
                try {
                    if (f22061u == null) {
                        f22061u = new d0(ContactsApplication.h().getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f22061u;
    }

    public final void A() {
        H7.b.b("SimpleModeVoicePlayer", "releaseSoundPool mSoundPool:" + this.f22066e);
        SoundPool soundPool = this.f22066e;
        if (soundPool != null) {
            soundPool.autoPause();
            Iterator<Map.Entry<Integer, Integer>> it = this.f22075n.entrySet().iterator();
            while (it.hasNext()) {
                this.f22066e.unload(it.next().getValue().intValue());
            }
            this.f22066e.release();
            this.f22066e = null;
            this.f22075n.clear();
        }
    }

    public void B() {
        if (!this.f22068g) {
            return;
        }
        H7.b.b("SimpleModeVoicePlayer", "update...");
        Message obtain = Message.obtain();
        obtain.what = 1;
        this.f22079r.sendMessage(obtain);
    }

    public final void o() {
        try {
            boolean z10 = true;
            if (G0.c.d(this.f22063b, 0, "dtmf_tone", 1) != 1) {
                z10 = false;
            }
            this.f22067f = z10;
            H7.b.b("SimpleModeVoicePlayer", "mDTMFToneEnabled " + this.f22067f);
        } catch (Exception e10) {
            H7.b.c("SimpleModeVoicePlayer", "checkDTMFEnabled error " + e10);
            this.f22067f = false;
        }
    }

    public final int q(String str, String str2) {
        return this.f22063b.getResources().getIdentifier(str, str2, this.f22063b.getPackageName());
    }

    public final boolean r(int i10, View.OnClickListener onClickListener, View view) {
        if (i10 == 5 && !this.f22070i && !this.f22071j) {
            this.f22064c = onClickListener;
            this.f22065d = view;
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f22078q.sendMessageDelayed(obtain, 500L);
            H7.b.b("SimpleModeVoicePlayer", "ifNeedReturnAtOnce playing voice for call");
            this.f22070i = true;
        }
        return this.f22070i;
    }

    public final void s() {
        if (this.f22066e != null) {
            return;
        }
        SoundPool.Builder builder = new SoundPool.Builder();
        AudioAttributes build = new AudioAttributes.Builder().setLegacyStreamType(1).build();
        builder.setMaxStreams(5);
        builder.setAudioAttributes(build);
        SoundPool build2 = builder.build();
        this.f22066e = build2;
        build2.setOnLoadCompleteListener(new c());
        this.f22075n.clear();
        int i10 = 0;
        while (true) {
            String[] strArr = this.f22076o;
            if (i10 < strArr.length) {
                int q10 = q(strArr[i10], "raw");
                H7.b.b("SimpleModeVoicePlayer", this.f22076o[i10] + " resId:" + q10);
                if (q10 != 0) {
                    this.f22075n.put(Integer.valueOf(this.f22077p[i10]), Integer.valueOf(this.f22066e.load(this.f22063b, q10, 1)));
                }
                i10++;
            } else {
                return;
            }
        }
    }

    public final boolean t() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f22063b);
        long j10 = defaultSharedPreferences.getLong("last_click_time_for_simple_mode", -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j10 != -1) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(Long.valueOf(currentTimeMillis));
            String format2 = simpleDateFormat.format(Long.valueOf(j10));
            H7.b.b("SimpleModeVoicePlayer", "isFirstTimeInDay currDate = " + format + " lastDate:" + format2);
            if (TextUtils.equals(format, format2)) {
                return false;
            }
        }
        H7.b.b("SimpleModeVoicePlayer", "isFirstTimeInDay true");
        defaultSharedPreferences.edit().putLong("last_click_time_for_simple_mode", currentTimeMillis).apply();
        return true;
    }

    public final boolean u() {
        if (this.f22068g && FeatureOption.i() && this.f22074m == 1 && this.f22067f && this.f22072k && !w()) {
            return true;
        }
        return false;
    }

    public boolean v() {
        if (this.f22068g) {
            return this.f22070i;
        }
        return false;
    }

    public final boolean w() {
        if (this.f22062a == null) {
            this.f22062a = (AudioManager) this.f22063b.getApplicationContext().getSystemService("audio");
        }
        AudioManager audioManager = this.f22062a;
        if (audioManager == null) {
            if (H7.a.b()) {
                H7.b.e("SimpleModeVoicePlayer", "mAudioMgr == null");
            }
            return true;
        }
        int ringerMode = audioManager.getRingerMode();
        if (H7.a.b()) {
            H7.b.e("SimpleModeVoicePlayer", "ringerMode " + ringerMode);
        }
        if (ringerMode == 0 || ringerMode == 1) {
            return true;
        }
        return false;
    }

    public final void x(Context context, int i10) {
        H7.b.b("SimpleModeVoicePlayer", "mSoundPool " + this.f22066e + " mPrepared:" + this.f22073l);
        if (this.f22066e != null && this.f22073l && this.f22075n.get(Integer.valueOf(i10)) != null) {
            this.f22066e.play(this.f22075n.get(Integer.valueOf(i10)).intValue(), 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public final void y(int i10) {
        if (i10 == 5 && this.f22071j) {
            return;
        }
        this.f22079r.removeMessages(2);
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i10;
        this.f22079r.sendMessage(obtain);
    }

    public boolean z(int i10, View.OnClickListener onClickListener, View view) {
        if (u()) {
            y(i10);
            return r(i10, onClickListener, view);
        }
        return false;
    }
}
