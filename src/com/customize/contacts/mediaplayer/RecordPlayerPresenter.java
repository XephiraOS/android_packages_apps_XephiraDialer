package com.customize.contacts.mediaplayer;

import E3.j;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.InterfaceC0492o;
import com.android.contacts.ProximitySensorManager;
import com.android.incallui.OplusAutoRedial;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.coui.appcompat.snackbar.COUISnackBar;
import com.customize.contacts.mediaplayer.a;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.h0;
import com.oplus.dialer.R;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.F;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.J0;
import kotlinx.coroutines.S;
import m9.q;
import t1.C1580a;
import v9.InterfaceC1637a;

/* compiled from: RecordPlayerPresenter.kt */
/* loaded from: classes3.dex */
public class RecordPlayerPresenter implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, a.InterfaceC0204a {

    /* renamed from: D, reason: collision with root package name */
    public static final b f21643D = new b(null);

    /* renamed from: A, reason: collision with root package name */
    public PowerManager f21644A;

    /* renamed from: B, reason: collision with root package name */
    public KeyguardManager f21645B;

    /* renamed from: C, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f21646C;

    /* renamed from: a, reason: collision with root package name */
    public Context f21647a;

    /* renamed from: b, reason: collision with root package name */
    public final E f21648b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorCoroutineDispatcher f21649c;

    /* renamed from: d, reason: collision with root package name */
    public final com.customize.contacts.mediaplayer.a f21650d;

    /* renamed from: e, reason: collision with root package name */
    public final ProximitySensorManager f21651e;

    /* renamed from: f, reason: collision with root package name */
    public final PositionUpdater f21652f;

    /* renamed from: g, reason: collision with root package name */
    public MediaPlayer f21653g;

    /* renamed from: h, reason: collision with root package name */
    public j.f f21654h;

    /* renamed from: i, reason: collision with root package name */
    public PowerManager.WakeLock f21655i;

    /* renamed from: j, reason: collision with root package name */
    public Activity f21656j;

    /* renamed from: k, reason: collision with root package name */
    public AudioManager f21657k;

    /* renamed from: l, reason: collision with root package name */
    public String f21658l;

    /* renamed from: m, reason: collision with root package name */
    public String f21659m;

    /* renamed from: n, reason: collision with root package name */
    public long f21660n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21661o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f21662p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21663q;

    /* renamed from: r, reason: collision with root package name */
    public Boolean f21664r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f21665s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f21666t;

    /* renamed from: u, reason: collision with root package name */
    public Dialog f21667u;

    /* renamed from: v, reason: collision with root package name */
    public int f21668v;

    /* renamed from: w, reason: collision with root package name */
    public a f21669w;

    /* renamed from: x, reason: collision with root package name */
    public ExecutorService f21670x;

    /* renamed from: y, reason: collision with root package name */
    public final m9.d f21671y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f21672z;

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public final class PositionUpdater {

        /* renamed from: b, reason: collision with root package name */
        public InterfaceC1265l0 f21674b;

        /* renamed from: c, reason: collision with root package name */
        public j.f f21675c;

        /* renamed from: e, reason: collision with root package name */
        public long f21677e;

        /* renamed from: a, reason: collision with root package name */
        public final int f21673a = 8;

        /* renamed from: d, reason: collision with root package name */
        public final q f21676d = q.f35511a;

        public PositionUpdater() {
        }

        public final q d() {
            return this.f21676d;
        }

        public final long e() {
            return this.f21677e;
        }

        public final void f(long j10) {
            InterfaceC1265l0 d10;
            this.f21677e = j10;
            g();
            this.f21675c = RecordPlayerPresenter.this.f21654h;
            d10 = C1248i.d(RecordPlayerPresenter.this.f21648b, S.a(), null, new RecordPlayerPresenter$PositionUpdater$startUpdating$1(RecordPlayerPresenter.this, this, null), 2, null);
            this.f21674b = d10;
        }

        public final void g() {
            InterfaceC1265l0 interfaceC1265l0;
            InterfaceC1265l0 interfaceC1265l02 = this.f21674b;
            if ((interfaceC1265l02 == null || true != interfaceC1265l02.isCancelled()) && (interfaceC1265l0 = this.f21674b) != null) {
                InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
            }
        }
    }

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a(String str);
    }

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        public b() {
        }

        public final RecordPlayerPresenter a(Activity activity) {
            kotlin.jvm.internal.i.f(activity, "activity");
            RecordPlayerPresenter recordPlayerPresenter = new RecordPlayerPresenter(activity);
            recordPlayerPresenter.e0(activity);
            return recordPlayerPresenter;
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public final class c implements ProximitySensorManager.b {
        public c() {
        }

        @Override // com.android.contacts.ProximitySensorManager.b
        public void a() {
            H7.b.b("RecordPlayerPresenter", "on near, isPaused: " + RecordPlayerPresenter.this.f21665s);
            try {
                if (!RecordPlayerPresenter.this.f21665s && !RecordPlayerPresenter.this.j0("onNear")) {
                    RecordPlayerPresenter.this.f21672z = true;
                    if (RecordPlayerPresenter.this.g0()) {
                        MediaPlayer mediaPlayer = RecordPlayerPresenter.this.f21653g;
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        RecordPlayerPresenter.this.f21653g = null;
                        RecordPlayerPresenter.this.y0();
                    }
                }
            } catch (Exception e10) {
                H7.b.c("RecordPlayerPresenter", "exception when onNear ex:" + e10);
            }
        }

        @Override // com.android.contacts.ProximitySensorManager.b
        public void b() {
            H7.b.b("RecordPlayerPresenter", "on far, isPaused: " + RecordPlayerPresenter.this.f21665s);
            try {
                if (!RecordPlayerPresenter.this.f21665s && !RecordPlayerPresenter.this.j0("onFar")) {
                    RecordPlayerPresenter.this.f21672z = false;
                    if (RecordPlayerPresenter.this.g0()) {
                        MediaPlayer mediaPlayer = RecordPlayerPresenter.this.f21653g;
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        RecordPlayerPresenter.this.f21653g = null;
                        RecordPlayerPresenter.this.y0();
                    }
                }
            } catch (Exception e10) {
                H7.b.c("RecordPlayerPresenter", "exception when onFar ex:" + e10);
            }
        }
    }

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21680a;

        static {
            int[] iArr = new int[PlayState.values().length];
            try {
                iArr[PlayState.PLAYER_STATE_FINISH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PlayState.PLAYER_STATE_PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PlayState.PLAYER_STATE_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PlayState.PLAYER_STATE_HALT_ON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f21680a = iArr;
        }
    }

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class e extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21681a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecordPlayerPresenter f21682b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1637a<q> f21683c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j10, RecordPlayerPresenter recordPlayerPresenter, InterfaceC1637a<q> interfaceC1637a, long j11) {
            super(j10, j11);
            this.f21681a = j10;
            this.f21682b = recordPlayerPresenter;
            this.f21683c = interfaceC1637a;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            MediaPlayer mediaPlayer = this.f21682b.f21653g;
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
            MediaPlayer mediaPlayer2 = this.f21682b.f21653g;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setVolume(1.0f, 1.0f);
            }
            if (H7.a.b()) {
                H7.b.b("RecordPlayerPresenter", "fadeInPause: finish.");
            }
            this.f21683c.invoke();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            float f10 = (((float) j10) * 1.0f) / ((float) this.f21681a);
            MediaPlayer mediaPlayer = this.f21682b.f21653g;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(f10, f10);
            }
        }
    }

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class f extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f21684a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecordPlayerPresenter f21685b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1637a<q> f21686c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(long j10, RecordPlayerPresenter recordPlayerPresenter, InterfaceC1637a<q> interfaceC1637a, long j11) {
            super(j10, j11);
            this.f21684a = j10;
            this.f21685b = recordPlayerPresenter;
            this.f21686c = interfaceC1637a;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            MediaPlayer mediaPlayer = this.f21685b.f21653g;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(1.0f, 1.0f);
            }
            if (H7.a.b()) {
                H7.b.b("RecordPlayerPresenter", "fadeOutStart: finish.");
            }
            this.f21686c.invoke();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            float f10 = 1.0f - ((((float) j10) * 1.0f) / ((float) this.f21684a));
            MediaPlayer mediaPlayer = this.f21685b.f21653g;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(f10, f10);
            }
        }
    }

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class g implements AudioManager.OnAudioFocusChangeListener {
        public g() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            if (i10 != -3 && i10 != -2 && i10 != -1) {
                if (i10 == 1 && !RecordPlayerPresenter.this.g0()) {
                    RecordPlayerPresenter.this.q0();
                    return;
                }
                return;
            }
            RecordPlayerPresenter.this.s0();
        }
    }

    /* compiled from: Runnable.kt */
    /* loaded from: classes3.dex */
    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecordPlayerPresenter.this.u0();
        }
    }

    /* compiled from: RecordPlayerPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class i extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21690a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f21691b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RecordPlayerPresenter f21692c;

        public i(boolean z10, View view, RecordPlayerPresenter recordPlayerPresenter) {
            this.f21690a = z10;
            this.f21691b = view;
            this.f21692c = recordPlayerPresenter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
            if (!this.f21690a) {
                this.f21691b.setVisibility(8);
            } else if (this.f21692c.f21666t) {
                this.f21691b.setVisibility(8);
            } else {
                this.f21691b.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
            super.onAnimationStart(animator);
            if (this.f21690a) {
                this.f21691b.setVisibility(0);
            }
        }
    }

    /* compiled from: Runnable.kt */
    /* loaded from: classes3.dex */
    public static final class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ COUISnackBar f21693a;

        public j(COUISnackBar cOUISnackBar) {
            this.f21693a = cOUISnackBar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f21693a.dismiss();
        }
    }

    public RecordPlayerPresenter(Activity activity) {
        m9.d b10;
        kotlin.jvm.internal.i.f(activity, "activity");
        this.f21648b = F.b();
        this.f21649c = J0.b("RecordPlayerPresenterPlayThread");
        this.f21652f = new PositionUpdater();
        this.f21660n = -1L;
        this.f21670x = Executors.newSingleThreadExecutor();
        b10 = kotlin.a.b(new InterfaceC1637a<com.customize.contacts.mediaplayer.d>() { // from class: com.customize.contacts.mediaplayer.RecordPlayerPresenter$playerController$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d invoke() {
                ComponentCallbacks2 componentCallbacks2;
                componentCallbacks2 = RecordPlayerPresenter.this.f21656j;
                i.c(componentCallbacks2);
                return new d((InterfaceC0492o) componentCallbacks2);
            }
        });
        this.f21671y = b10;
        this.f21646C = new g();
        Context applicationContext = activity.getApplicationContext();
        c cVar = new c();
        com.customize.contacts.mediaplayer.a aVar = new com.customize.contacts.mediaplayer.a(applicationContext);
        this.f21650d = aVar;
        aVar.f(this);
        this.f21651e = new ProximitySensorManager(applicationContext, cVar);
    }

    public static final void D0(View seekbarLayout, ValueAnimator valueAnimator) {
        int i10;
        kotlin.jvm.internal.i.f(seekbarLayout, "$seekbarLayout");
        kotlin.jvm.internal.i.f(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            i10 = ((Integer) animatedValue).intValue();
        } else {
            i10 = 0;
        }
        seekbarLayout.getLayoutParams().height = i10;
        seekbarLayout.requestLayout();
    }

    public static final void L0(Context appContext, View view) {
        kotlin.jvm.internal.i.f(appContext, "$appContext");
        C0801l.w(appContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void O(RecordPlayerPresenter recordPlayerPresenter, long j10, InterfaceC1637a interfaceC1637a, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                j10 = 100;
            }
            if ((i10 & 2) != 0) {
                interfaceC1637a = new InterfaceC1637a<q>() { // from class: com.customize.contacts.mediaplayer.RecordPlayerPresenter$fadeInPause$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // v9.InterfaceC1637a
                    public /* bridge */ /* synthetic */ q invoke() {
                        invoke2();
                        return q.f35511a;
                    }
                };
            }
            recordPlayerPresenter.N(j10, interfaceC1637a);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fadeInPause");
    }

    public static /* synthetic */ void Q(RecordPlayerPresenter recordPlayerPresenter, long j10, InterfaceC1637a interfaceC1637a, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                j10 = 100;
            }
            recordPlayerPresenter.P(j10, interfaceC1637a);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fadeOutStart");
    }

    public static final RecordPlayerPresenter X(Activity activity) {
        return f21643D.a(activity);
    }

    public final void A0(int i10) {
        AudioManager R10 = R();
        if (R10 != null) {
            R10.requestAudioFocus(this.f21646C, i10, 1);
        }
    }

    public final void B0() {
        AudioManager R10 = R();
        if (R10 != null && R10.isSpeakerphoneOn()) {
            R10.setSpeakerphoneOn(false);
        }
    }

    public final void C0(final View view, boolean z10) {
        ValueAnimator ofInt;
        if (this.f21668v == 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.f21668v = view.getMeasuredHeight();
        }
        int i10 = this.f21668v;
        if (z10) {
            ofInt = ValueAnimator.ofInt(0, i10);
        } else {
            ofInt = ValueAnimator.ofInt(i10, 0);
        }
        if (ofInt != null) {
            ofInt.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.33f, 1.0f));
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.customize.contacts.mediaplayer.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecordPlayerPresenter.D0(view, valueAnimator);
                }
            });
            ofInt.addListener(new i(z10, view, this));
            ofInt.setDuration(150L);
            ofInt.start();
        }
    }

    public final void E0(Dialog dialog) {
        Dialog dialog2 = this.f21667u;
        if (dialog2 != null && dialog2 != null) {
            dialog2.dismiss();
        }
        this.f21667u = dialog;
    }

    public final void F0(Context context) {
        kotlin.jvm.internal.i.f(context, "<set-?>");
        this.f21647a = context;
    }

    public final void G0(j.f fVar, String str, String str2) {
        this.f21666t = false;
        if (str != null) {
            this.f21658l = str;
        }
        this.f21659m = str2;
        this.f21652f.d();
        synchronized (q.f35511a) {
            this.f21654h = fVar;
        }
    }

    public final void H(int i10) {
        Log.d("RecordPlayerPresenter", "changeActivityVolumeStream streamType:" + i10);
        Activity activity = this.f21656j;
        if (activity != null) {
            activity.setVolumeControlStream(i10);
        }
    }

    public final void H0(j.f fVar) {
        int i10;
        int i11;
        int i12;
        j.f fVar2;
        COUISeekBar cOUISeekBar;
        COUISeekBar cOUISeekBar2;
        if (!kotlin.jvm.internal.i.b(this.f21654h, fVar)) {
            j.f fVar3 = this.f21654h;
            if (fVar3 != null && (cOUISeekBar2 = fVar3.f597n) != null) {
                i10 = cOUISeekBar2.getMax();
            } else {
                i10 = 0;
            }
            if (this.f21660n != -1 && (fVar2 = this.f21654h) != null && (cOUISeekBar = fVar2.f597n) != null) {
                i11 = cOUISeekBar.getProgress();
            } else {
                i11 = 0;
            }
            H7.b.b("RecordPlayerPresenter", "setPlaybackView: bind play info view, max:" + i10 + ", progress:" + i11);
            if (fVar != null) {
                PlayState value = Y().c().getValue();
                if (value == null) {
                    i12 = -1;
                } else {
                    i12 = d.f21680a[value.ordinal()];
                }
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 == 3) {
                            View view = fVar.f596m;
                            if (view != null) {
                                view.setVisibility(0);
                            }
                            ImageView imageView = fVar.f587d;
                            if (imageView != null) {
                                imageView.setImageResource(R.drawable.pb_ic_voicemail_resume);
                            }
                        }
                    } else {
                        View view2 = fVar.f596m;
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                        ImageView imageView2 = fVar.f587d;
                        if (imageView2 != null) {
                            imageView2.setImageResource(R.drawable.pb_ic_voicemail_pause);
                        }
                    }
                } else {
                    View view3 = fVar.f596m;
                    if (view3 != null) {
                        view3.setVisibility(8);
                    }
                }
                COUISeekBar cOUISeekBar3 = fVar.f597n;
                if (cOUISeekBar3 != null) {
                    cOUISeekBar3.setMax(i10);
                }
                COUISeekBar cOUISeekBar4 = fVar.f597n;
                if (cOUISeekBar4 != null) {
                    cOUISeekBar4.setProgress(i11);
                }
                TextView textView = fVar.f599p;
                if (textView != null) {
                    textView.setText(C0801l.e(i10));
                }
                TextView textView2 = fVar.f598o;
                if (textView2 != null) {
                    textView2.setText(C0801l.e(i11));
                }
            }
            this.f21652f.d();
            synchronized (q.f35511a) {
                this.f21654h = fVar;
            }
        }
    }

    public final boolean I() {
        Object b10;
        AudioDeviceInfo[] audioDeviceInfoArr;
        try {
            Result.a aVar = Result.f34166a;
            AudioManager R10 = R();
            if (R10 != null) {
                audioDeviceInfoArr = R10.getDevices(2);
            } else {
                audioDeviceInfoArr = null;
            }
            if (audioDeviceInfoArr != null) {
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    if (audioDeviceInfo.getType() == 1) {
                        this.f21664r = Boolean.TRUE;
                        return true;
                    }
                }
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
        }
        this.f21664r = Boolean.FALSE;
        return false;
    }

    public final void I0(a aVar) {
        this.f21669w = aVar;
    }

    public final void J(boolean z10) {
        if (f0()) {
            H7.b.b("RecordPlayerPresenter", "disableProximity: HeadsetOn(" + this.f21662p + ", " + this.f21663q + "), return.");
            return;
        }
        H7.b.b("RecordPlayerPresenter", "disableProximity no headset on.");
        K(z10);
    }

    public final void J0() {
        View view;
        j.f fVar = this.f21654h;
        if (fVar != null) {
            ImageView imageView = fVar.f587d;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.pb_ic_voicemail_pause);
            }
            View view2 = fVar.f596m;
            if (view2 == null || view2.getVisibility() != 0) {
                COUISeekBar cOUISeekBar = fVar.f597n;
                if (cOUISeekBar != null) {
                    cOUISeekBar.setProgress(0);
                }
                TextView textView = fVar.f599p;
                if (textView != null) {
                    textView.setText(C0801l.e(0));
                }
                TextView textView2 = fVar.f598o;
                if (textView2 != null) {
                    textView2.setText(C0801l.e(0));
                }
                View mSeekBarLayout = fVar.f596m;
                if (mSeekBarLayout != null) {
                    kotlin.jvm.internal.i.e(mSeekBarLayout, "mSeekBarLayout");
                    C0(mSeekBarLayout, true);
                }
            }
            if (c0() && C0801l.k(U()) && !f0()) {
                Context U10 = U();
                j.f fVar2 = this.f21654h;
                if (fVar2 != null) {
                    view = fVar2.f596m;
                } else {
                    view = null;
                }
                K0(U10, view);
            }
        }
    }

    public final void K(boolean z10) {
        this.f21651e.a(z10);
        PowerManager.WakeLock Z9 = Z();
        if (Z9 != null && true == Z9.isHeld()) {
            H7.b.b("RecordPlayerPresenter", "disableProximity releasing proximity wake lock");
            PowerManager.WakeLock Z10 = Z();
            if (Z10 != null) {
                Z10.release(z10 ? 1 : 0);
                return;
            }
            return;
        }
        H7.b.b("RecordPlayerPresenter", "disableProximity proximity wake lock already released");
    }

    public final void K0(Context context, View view) {
        final Context applicationContext;
        if (context == null || view == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        COUISnackBar make = COUISnackBar.make(view, context.getString(R.string.play_records_tips), OplusAutoRedial.DELAY_FIVE_SECOND);
        kotlin.jvm.internal.i.e(make, "make(view, context.getSt…_records_tips), duration)");
        make.setOnAction(R.string.oplus_know, new View.OnClickListener() { // from class: com.customize.contacts.mediaplayer.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RecordPlayerPresenter.L0(applicationContext, view2);
            }
        });
        make.show();
        new Handler(context.getMainLooper()).postDelayed(new j(make), OplusAutoRedial.DELAY_FIVE_SECOND);
    }

    public final void L() {
        if (f0()) {
            H7.b.b("RecordPlayerPresenter", "enableProximity: HeadsetOn(" + this.f21662p + ", " + this.f21663q + "), return.");
            return;
        }
        this.f21651e.b();
        H7.b.b("RecordPlayerPresenter", "enableProximity no headset on.");
        PowerManager.WakeLock Z9 = Z();
        if (Z9 != null && !Z9.isHeld()) {
            H7.b.b("RecordPlayerPresenter", "enableProximity acquiring proximity wake lock");
            PowerManager.WakeLock Z10 = Z();
            if (Z10 != null) {
                Z10.acquire();
                return;
            }
            return;
        }
        H7.b.b("RecordPlayerPresenter", "enableProximity proximity wake lock already acquired");
    }

    public final void M() {
        if (!Y().b()) {
            Y().d();
        }
        if (this.f21653g == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setOnCompletionListener(this);
            this.f21653g = mediaPlayer;
        }
    }

    public final void M0(boolean z10) {
        int i10;
        PlayState value = Y().c().getValue();
        H7.b.b("RecordPlayerPresenter", "switchPlayState playerStatus:" + value);
        if (value == null) {
            i10 = -1;
        } else {
            i10 = d.f21680a[value.ordinal()];
        }
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        y0();
                        return;
                    } else {
                        y0();
                        return;
                    }
                }
                r0(z10);
                return;
            }
            t0(z10);
            return;
        }
        Y().c().o(PlayState.PLAYER_STATE_INIT);
        y0();
    }

    public final void N(long j10, InterfaceC1637a<q> completed) {
        kotlin.jvm.internal.i.f(completed, "completed");
        new e(j10, this, completed, j10 / 20).start();
    }

    public final void P(long j10, InterfaceC1637a<q> completed) {
        kotlin.jvm.internal.i.f(completed, "completed");
        new f(j10, this, completed, j10 / 20).start();
        MediaPlayer mediaPlayer = this.f21653g;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public final synchronized AudioManager R() {
        try {
            if (this.f21657k == null) {
                Object systemService = U().getSystemService("audio");
                kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                this.f21657k = (AudioManager) systemService;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f21657k;
    }

    public final int S() {
        int i10;
        boolean z10 = this.f21672z;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 3;
        }
        H7.b.e("RecordPlayerPresenter", "getAudioStreamType: " + z10 + ": type: " + i10);
        return i10;
    }

    public final void T() {
        C1248i.d(this.f21648b, this.f21649c, null, new RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1(this, null), 2, null);
    }

    public final Context U() {
        Context context = this.f21647a;
        if (context != null) {
            return context;
        }
        kotlin.jvm.internal.i.q("context");
        return null;
    }

    public final String V() {
        return this.f21658l;
    }

    public final boolean W() {
        return this.f21661o;
    }

    public final com.customize.contacts.mediaplayer.d Y() {
        return (com.customize.contacts.mediaplayer.d) this.f21671y.getValue();
    }

    public final synchronized PowerManager.WakeLock Z() {
        try {
            if (this.f21655i == null) {
                Object systemService = U().getSystemService("power");
                kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager powerManager = (PowerManager) systemService;
                if (powerManager.isWakeLockLevelSupported(32)) {
                    this.f21655i = powerManager.newWakeLock(32, "Contacts:RecordPlayerPresenterWakeLock");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f21655i;
    }

    @Override // com.customize.contacts.mediaplayer.a.InterfaceC0204a
    public void a(boolean z10, boolean z11) {
        H7.b.e("onWiredHeadsetPluggedInChanged", "wired headset was plugged in changed: " + z10 + " -> " + z11);
        this.f21662p = z11;
        if (z11) {
            J(false);
        } else {
            s0();
        }
    }

    public final a a0() {
        return this.f21669w;
    }

    @Override // com.customize.contacts.mediaplayer.a.InterfaceC0204a
    public void b(boolean z10, boolean z11) {
        H7.b.e("onBluetoothPluggedInChanged", "bluetooth headset was plugged in changed: " + z10 + " -> " + z11);
        this.f21663q = z11;
        if (z11) {
            J(false);
        } else {
            s0();
        }
    }

    public final void b0(Exception exc) {
        H7.b.c("RecordPlayerPresenter", "handlerError could not play ex: " + exc);
        C1248i.d(this.f21648b, S.c(), null, new RecordPlayerPresenter$handleError$1(this, null), 2, null);
    }

    public final boolean c0() {
        Boolean bool = this.f21664r;
        if (bool != null) {
            return bool.booleanValue();
        }
        return I();
    }

    public final void d0() {
        j.f fVar = this.f21654h;
        if (fVar != null) {
            View view = fVar.f596m;
            if (view != null) {
                view.setVisibility(8);
            }
            ImageView imageView = fVar.f587d;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.pb_ic_voicemail_resume);
            }
            COUISeekBar cOUISeekBar = fVar.f597n;
            if (cOUISeekBar != null) {
                cOUISeekBar.setProgress(0);
            }
        }
    }

    public final void e0(Activity activity) {
        Object obj;
        PowerManager powerManager;
        Object obj2;
        kotlin.jvm.internal.i.f(activity, "activity");
        C1580a.c();
        F0(activity);
        this.f21656j = activity;
        Context applicationContext = activity.getApplicationContext();
        KeyguardManager keyguardManager = null;
        if (applicationContext != null) {
            obj = applicationContext.getSystemService("power");
        } else {
            obj = null;
        }
        if (obj instanceof PowerManager) {
            powerManager = (PowerManager) obj;
        } else {
            powerManager = null;
        }
        this.f21644A = powerManager;
        Context applicationContext2 = activity.getApplicationContext();
        if (applicationContext2 != null) {
            obj2 = applicationContext2.getSystemService("keyguard");
        } else {
            obj2 = null;
        }
        if (obj2 instanceof KeyguardManager) {
            keyguardManager = (KeyguardManager) obj2;
        }
        this.f21645B = keyguardManager;
    }

    public final boolean f0() {
        if (!this.f21662p && !this.f21663q) {
            return false;
        }
        return true;
    }

    public final boolean g0() {
        if (Y().c().getValue() == PlayState.PLAYER_STATE_PLAYING) {
            return true;
        }
        return false;
    }

    public final boolean h0(String callLogMapping) {
        kotlin.jvm.internal.i.f(callLogMapping, "callLogMapping");
        return TextUtils.equals(callLogMapping, this.f21659m);
    }

    public final boolean i0(String str) {
        return TextUtils.equals(str, this.f21658l);
    }

    public final boolean j0(String str) {
        KeyguardManager keyguardManager;
        Boolean bool;
        PowerManager powerManager = this.f21644A;
        boolean z10 = true;
        if ((powerManager == null || powerManager.isInteractive()) && ((keyguardManager = this.f21645B) == null || !keyguardManager.isKeyguardLocked())) {
            z10 = false;
        }
        PowerManager powerManager2 = this.f21644A;
        Boolean bool2 = null;
        if (powerManager2 != null) {
            bool = Boolean.valueOf(powerManager2.isInteractive());
        } else {
            bool = null;
        }
        KeyguardManager keyguardManager2 = this.f21645B;
        if (keyguardManager2 != null) {
            bool2 = Boolean.valueOf(keyguardManager2.isKeyguardLocked());
        }
        H7.b.e("RecordPlayerPresenter", str + ": isScreenLocked: isInteractive: " + bool + ", keyguardLocked: " + bool2 + ", lock: " + z10);
        return z10;
    }

    public final void k0() {
        H7.b.b("RecordPlayerPresenter", "mediaPlayerError");
        u0();
        Y().c().o(PlayState.PLAYER_STATE_HALT_ON);
        this.f21652f.g();
        this.f21666t = true;
        this.f21658l = null;
        this.f21659m = null;
        d0();
        J(true);
    }

    public final void l0() {
        Object b10;
        H7.b.b("RecordPlayerPresenter", "onDestroy");
        try {
            Result.a aVar = Result.f34166a;
            if (Y().b()) {
                Y().f();
            }
            F.d(this.f21648b, null, 1, null);
            this.f21649c.close();
            ExecutorService executorService = this.f21670x;
            if (executorService != null) {
                executorService.execute(new h());
            }
            ExecutorService executorService2 = this.f21670x;
            if (executorService2 != null) {
                executorService2.shutdown();
            }
            K(false);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("RecordPlayerPresenter", "onDestroy : " + d10);
        }
    }

    public final void m0() {
        Object b10;
        if (!j0("onPause")) {
            try {
                Result.a aVar = Result.f34166a;
                this.f21650d.h();
                n0();
                Dialog dialog = this.f21667u;
                if (dialog != null) {
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                    E0(null);
                }
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                Log.e("RecordPlayerPresenter", "Exception when unregister mCallRecodingWiredHeadsetManager receiver : " + d10);
            }
        }
        this.f21665s = true;
    }

    public final void n0() {
        int i10;
        H7.b.b("RecordPlayerPresenter", "onPauseWithoutUnregisterReceiver");
        this.f21661o = false;
        PlayState value = Y().c().getValue();
        H7.b.b("RecordPlayerPresenter", "onPauseWithoutUnregisterReceiver playerStatus:" + value);
        if (value == null) {
            i10 = -1;
        } else {
            i10 = d.f21680a[value.ordinal()];
        }
        if (i10 == 2 || i10 == 3) {
            z0(value);
        }
        this.f21658l = null;
        this.f21659m = null;
    }

    public final void o0() {
        H7.b.b("RecordPlayerPresenter", "onResume");
        this.f21650d.d();
        T();
        this.f21665s = false;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        kotlin.jvm.internal.i.f(mediaPlayer, "mediaPlayer");
        H7.b.e("RecordPlayerPresenter", "onCompletion: player state: " + Y().c().getValue());
        if (Y().c().getValue() == PlayState.PLAYER_STATE_PLAYING) {
            u0();
            this.f21652f.g();
            Y().c().o(PlayState.PLAYER_STATE_FINISH);
            this.f21661o = false;
            this.f21660n = -1L;
            d0();
            H(3);
            J(true);
            h0.d(U(), "click_item", "pause");
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mp, int i10, int i11) {
        kotlin.jvm.internal.i.f(mp, "mp");
        H7.b.b("RecordPlayerPresenter", "onError what:" + i10 + ", extra:" + i11);
        StringBuilder sb = new StringBuilder();
        sb.append("MediaPlayer error listener invoked: ");
        sb.append(i11);
        b0(new IllegalStateException(sb.toString()));
        return true;
    }

    public final void p0() {
        if (H7.a.b()) {
            H7.b.b("RecordPlayerPresenter", "onStop: no-op");
        }
    }

    public final void q0() {
        r0(false);
    }

    public final void r0(boolean z10) {
        Object b10;
        long currentTimeMillis;
        ImageView imageView;
        try {
            Result.a aVar = Result.f34166a;
            H7.b.e("RecordPlayerPresenter", "playerContinuePlay: userClick: " + z10 + ", hasPlayedLength: " + this.f21660n);
            h0.d(U(), "click_item", "play");
            A0(S());
            B0();
            MediaPlayer mediaPlayer = this.f21653g;
            View view = null;
            if (mediaPlayer != null) {
                long j10 = this.f21660n;
                if (j10 != -1) {
                    mediaPlayer.seekTo((int) j10);
                }
                if (z10) {
                    Q(this, 0L, new InterfaceC1637a<q>() { // from class: com.customize.contacts.mediaplayer.RecordPlayerPresenter$playerContinuePlay$1$1$1
                        @Override // v9.InterfaceC1637a
                        public /* bridge */ /* synthetic */ q invoke() {
                            invoke2();
                            return q.f35511a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            H7.b.e("RecordPlayerPresenter", "fadeOutResume.");
                        }
                    }, 1, null);
                } else {
                    mediaPlayer.start();
                }
                Y().c().o(PlayState.PLAYER_STATE_PLAYING);
                if (this.f21660n != -1) {
                    currentTimeMillis = System.currentTimeMillis() - this.f21660n;
                } else {
                    currentTimeMillis = System.currentTimeMillis();
                }
                H7.b.b("RecordPlayerPresenter", "playerContinuePlay has played time is " + this.f21660n + " , the media player duration is " + mediaPlayer.getDuration() + " , the media player has played position is " + mediaPlayer.getCurrentPosition());
                this.f21652f.f(currentTimeMillis);
                this.f21661o = true;
                L();
                j.f fVar = this.f21654h;
                if (fVar != null && (imageView = fVar.f587d) != null) {
                    imageView.setImageResource(R.drawable.pb_ic_voicemail_pause);
                }
                if (c0() && C0801l.k(U()) && !f0()) {
                    Context U10 = U();
                    j.f fVar2 = this.f21654h;
                    if (fVar2 != null) {
                        view = fVar2.f596m;
                    }
                    K0(U10, view);
                }
            } else {
                mediaPlayer = null;
            }
            b10 = Result.b(mediaPlayer);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("RecordPlayerPresenter", "playerContinuePlay exception:" + d10);
            k0();
        }
    }

    public final void s0() {
        t0(false);
    }

    public final void t0(boolean z10) {
        Object b10;
        ImageView imageView;
        if (!g0()) {
            return;
        }
        try {
            Result.a aVar = Result.f34166a;
            h0.d(U(), "click_item", "pause");
            this.f21652f.g();
            j.f fVar = this.f21654h;
            if (fVar != null && (imageView = fVar.f587d) != null) {
                imageView.setImageResource(R.drawable.pb_ic_voicemail_resume);
            }
            this.f21660n = System.currentTimeMillis() - this.f21652f.e();
            if (z10) {
                Y().c().o(PlayState.PLAYER_STATE_PAUSE);
                O(this, 0L, new InterfaceC1637a<q>() { // from class: com.customize.contacts.mediaplayer.RecordPlayerPresenter$playerPause$1$1
                    {
                        super(0);
                    }

                    @Override // v9.InterfaceC1637a
                    public /* bridge */ /* synthetic */ q invoke() {
                        invoke2();
                        return q.f35511a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AudioManager R10;
                        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
                        H7.b.e("RecordPlayerPresenter", "fadeInPause.");
                        R10 = RecordPlayerPresenter.this.R();
                        if (R10 != null) {
                            onAudioFocusChangeListener = RecordPlayerPresenter.this.f21646C;
                            R10.abandonAudioFocus(onAudioFocusChangeListener);
                        }
                    }
                }, 1, null);
            } else {
                MediaPlayer mediaPlayer = this.f21653g;
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                }
                Y().c().o(PlayState.PLAYER_STATE_PAUSE);
                AudioManager R10 = R();
                if (R10 != null) {
                    R10.abandonAudioFocus(this.f21646C);
                }
            }
            J(true);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("RecordPlayerPresenter", "playerPause exception:" + d10);
        }
    }

    public final void u0() {
        try {
            try {
                MediaPlayer mediaPlayer = this.f21653g;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
            } catch (Exception e10) {
                H7.b.c("RecordPlayerPresenter", "releasePlay error:" + e10);
            }
            AudioManager R10 = R();
            if (R10 != null) {
                R10.abandonAudioFocus(this.f21646C);
            }
        } finally {
            this.f21653g = null;
        }
    }

    public final void v0(int i10) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            this.f21660n = i10;
            if (H7.a.b()) {
                H7.b.b("RecordPlayerPresenter", "playerSeekTo: " + i10);
            }
            MediaPlayer mediaPlayer = this.f21653g;
            if (mediaPlayer != null) {
                mediaPlayer.seekTo(i10);
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("RecordPlayerPresenter", "playerSeekTo : " + d10);
        }
    }

    public final void w0(int i10) {
        long currentTimeMillis;
        Integer num;
        if (this.f21665s) {
            H7.b.b("RecordPlayerPresenter", " is pause, playerStart return");
            return;
        }
        A0(i10);
        try {
            J0();
            B0();
            MediaPlayer mediaPlayer = this.f21653g;
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
            Y().c().o(PlayState.PLAYER_STATE_PLAYING);
            if (this.f21660n != -1) {
                currentTimeMillis = System.currentTimeMillis() - this.f21660n;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            long j10 = this.f21660n;
            MediaPlayer mediaPlayer2 = this.f21653g;
            Integer num2 = null;
            if (mediaPlayer2 != null) {
                num = Integer.valueOf(mediaPlayer2.getDuration());
            } else {
                num = null;
            }
            MediaPlayer mediaPlayer3 = this.f21653g;
            if (mediaPlayer3 != null) {
                num2 = Integer.valueOf(mediaPlayer3.getCurrentPosition());
            }
            H7.b.b("RecordPlayerPresenter", "playerStart, current system time is " + currentTimeMillis2 + ", has played time is " + j10 + "  the media player duration is " + num + " , the media player has played position is " + num2);
            this.f21652f.f(currentTimeMillis);
            this.f21661o = true;
            H(i10);
            L();
        } catch (Exception e10) {
            H7.b.c("RecordPlayerPresenter", "playerStart ex:" + e10);
            k0();
        }
    }

    public final void x0(j.f views, String str, String callLogMapping, boolean z10) {
        int i10;
        kotlin.jvm.internal.i.f(views, "views");
        kotlin.jvm.internal.i.f(callLogMapping, "callLogMapping");
        if (i0(str)) {
            M0(z10);
            return;
        }
        PlayState value = Y().c().getValue();
        H7.b.b("RecordPlayerPresenter", "preparePlayState playerStatus:" + value);
        if (value == null) {
            i10 = -1;
        } else {
            i10 = d.f21680a[value.ordinal()];
        }
        if (i10 == 2 || i10 == 3) {
            z0(value);
        }
        G0(views, str, callLogMapping);
        M0(z10);
    }

    public final void y0() {
        C1248i.d(this.f21648b, this.f21649c, null, new RecordPlayerPresenter$prepareToPlayerStart$1(this, null), 2, null);
    }

    public final void z0(PlayState playState) {
        d0();
        u0();
        Y().c().o(PlayState.PLAYER_STATE_HALT_ON);
        this.f21660n = -1L;
        this.f21658l = null;
        this.f21659m = null;
        if (playState == PlayState.PLAYER_STATE_PLAYING) {
            this.f21652f.g();
            h0.d(U(), "click_item", "pause");
            J(true);
        }
    }
}
