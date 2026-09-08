package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.clean.domain.interactor.UseCase1;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowInCallStateDeclineBtnBehavior;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowVideoAnswerBtnBehavior;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowVoiceAnswerBtnBehavior;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: DefaultFloatingWindowViewModel.kt */
/* loaded from: classes.dex */
public final class DefaultFloatingWindowViewModel extends c {

    /* renamed from: u, reason: collision with root package name */
    public static final a f18959u = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public final NonNullObservableField<Integer> f18960j;

    /* renamed from: k, reason: collision with root package name */
    public final NonNullObservableField<Integer> f18961k;

    /* renamed from: l, reason: collision with root package name */
    public final LocalObservableField<Integer> f18962l;

    /* renamed from: m, reason: collision with root package name */
    public final LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> f18963m;

    /* renamed from: n, reason: collision with root package name */
    public final LocalObservableField<q> f18964n;

    /* renamed from: o, reason: collision with root package name */
    public final NonNullObservableField<Integer> f18965o;

    /* renamed from: p, reason: collision with root package name */
    public final NonNullObservableField<Integer> f18966p;

    /* renamed from: q, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f18967q;

    /* renamed from: r, reason: collision with root package name */
    public final LocalObservableField<Integer> f18968r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f18969s;

    /* renamed from: t, reason: collision with root package name */
    public final LocalObservableField<q> f18970t;

    /* compiled from: DefaultFloatingWindowViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFloatingWindowViewModel(final b eventBus) {
        super("DefaultFloatingWindowViewModel", eventBus);
        i.f(eventBus, "eventBus");
        this.f18960j = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{r().f()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$layoutWidth$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int b10 = DefaultFloatingWindowViewModel.this.r().b();
                int c10 = DefaultFloatingWindowViewModel.this.r().c();
                int i10 = DefaultFloatingWindowViewModel.this.r().f().getValue().widthPixels;
                int i11 = c10 * 2;
                if (i10 < b10 + i11) {
                    b10 = i10 - i11;
                }
                return Integer.valueOf(b10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18961k = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{r().f(), r().r()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$layoutTopMargin$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int d10;
                if (DefaultFloatingWindowViewModel.this.r().r().getValue().intValue() == 1 && !DefaultFloatingWindowViewModel.this.r().u()) {
                    d10 = DefaultFloatingWindowViewModel.this.r().e();
                } else {
                    d10 = DefaultFloatingWindowViewModel.this.r().d();
                }
                return Integer.valueOf(d10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18962l = new LocalObservableField<>(new androidx.databinding.i[]{o().d()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$slotIdRes$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int s02 = DefaultFloatingWindowViewModel.this.o().d().s0();
                if (s02 != 0) {
                    if (s02 != 1) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.ic_call_card_sim2);
                }
                return Integer.valueOf(R.drawable.ic_call_card_sim1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18963m = new LocalObservableField<>(new LiveData[]{d().d(), n().f()}, new ObservableBoolean[]{n().w(), n().v()}, new l<Boolean, com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$rightBtnBehavior$1
            {
                super(1);
            }

            public final com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a b(boolean z10) {
                boolean booleanValue = DefaultFloatingWindowViewModel.this.d().m().b().booleanValue();
                boolean s02 = DefaultFloatingWindowViewModel.this.n().w().s0();
                boolean s03 = DefaultFloatingWindowViewModel.this.n().v().s0();
                Call value = DefaultFloatingWindowViewModel.this.n().j().getValue();
                InCallPresenter.InCallState s04 = DefaultFloatingWindowViewModel.this.n().e().s0();
                if (s04.isIncoming()) {
                    if (s02 && s03) {
                        return FloatingWindowVideoAnswerBtnBehavior.VIDEO_ANSWER_VOWIFI;
                    }
                    if (s02 && !s03) {
                        return FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_VOWIFI;
                    }
                    if (booleanValue && s03) {
                        return FloatingWindowVideoAnswerBtnBehavior.VIDEO_ANSWER_BLUETOOTH;
                    }
                    if (booleanValue && !s03) {
                        return FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_BLUETOOTH;
                    }
                    if (s03) {
                        return FloatingWindowVideoAnswerBtnBehavior.VIDEO_ANSWER;
                    }
                    return FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER;
                }
                if (!s04.isDialing() && !s04.isInCall(value)) {
                    return null;
                }
                if (s02) {
                    return FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE_VOWIFI;
                }
                if (booleanValue) {
                    return FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE_BLUETOOTH;
                }
                return FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18964n = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.c()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$onFakeAnswer$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                if (z10) {
                    return;
                }
                com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a s02 = DefaultFloatingWindowViewModel.this.A().s0();
                if (s02 == FloatingWindowVideoAnswerBtnBehavior.VIDEO_ANSWER_VOWIFI || s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_VOWIFI) {
                    DefaultFloatingWindowViewModel.this.A().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE_VOWIFI);
                    return;
                }
                if (s02 == FloatingWindowVideoAnswerBtnBehavior.VIDEO_ANSWER_BLUETOOTH || s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_BLUETOOTH) {
                    DefaultFloatingWindowViewModel.this.A().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE_BLUETOOTH);
                } else if (s02 == FloatingWindowVideoAnswerBtnBehavior.VIDEO_ANSWER || s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER) {
                    DefaultFloatingWindowViewModel.this.A().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE);
                }
            }
        });
        this.f18965o = new NonNullObservableField<>(new androidx.databinding.i[]{n().e(), n().v()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$videoToVoiceAnswerBtnVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                boolean s02 = DefaultFloatingWindowViewModel.this.n().v().s0();
                boolean isIncoming = DefaultFloatingWindowViewModel.this.n().e().s0().isIncoming();
                if (s02 && isIncoming) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                return Integer.valueOf(i10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18966p = new NonNullObservableField<>(new LiveData[]{d().d()}, new ObservableBoolean[]{n().w()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$videoToVoiceAnswerBtnRes$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                boolean booleanValue = DefaultFloatingWindowViewModel.this.d().m().b().booleanValue();
                if (DefaultFloatingWindowViewModel.this.n().w().s0()) {
                    i10 = R.drawable.floating_window_btn_video_to_voice_vowifi_answer;
                } else if (booleanValue) {
                    i10 = R.drawable.floating_window_btn_video_to_voice_bluetooth_answer;
                } else {
                    i10 = R.drawable.floating_window_btn_video_to_voice_answer;
                }
                return Integer.valueOf(i10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18967q = new NonNullObservableField<>(new androidx.databinding.i[]{n().e(), n().v()}, new l<Boolean, Boolean>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$needAdaptConstraintForRtt$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                boolean z11;
                if (!DefaultFloatingWindowViewModel.this.n().v().s0() && DefaultFloatingWindowViewModel.this.n().e().s0().isIncoming() && DefaultFloatingWindowViewModel.this.n().u()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18968r = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.g()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$rttVerifiedTextLeftDrawableRes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                if (b.this.g().s0().booleanValue()) {
                    return this.n().o(false);
                }
                return null;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18970t = new LocalObservableField<>(new androidx.databinding.i[]{o().e()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DefaultFloatingWindowViewModel$toastForContact$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                String s02;
                if (DefaultFloatingWindowViewModel.this.w() || (s02 = DefaultFloatingWindowViewModel.this.o().e().s0()) == null || s02.length() == 0) {
                    return;
                }
                DefaultFloatingWindowViewModel.this.o().k().b(s02, null);
                DefaultFloatingWindowViewModel.this.F(true);
            }
        });
    }

    public final LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> A() {
        return this.f18963m;
    }

    public final LocalObservableField<Integer> B() {
        return this.f18968r;
    }

    public final LocalObservableField<Integer> C() {
        return this.f18962l;
    }

    public final NonNullObservableField<Integer> D() {
        return this.f18966p;
    }

    public final NonNullObservableField<Integer> E() {
        return this.f18965o;
    }

    public final void F(boolean z10) {
        this.f18969s = z10;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void u() {
        super.u();
        UseCase1.e(q().c(), 1, t().b(), null, 4, null);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void v() {
        super.v();
        this.f18960j.close();
        this.f18961k.close();
        this.f18962l.close();
        this.f18963m.close();
        this.f18965o.close();
        this.f18966p.close();
        this.f18968r.close();
        this.f18970t.close();
        this.f18964n.close();
        this.f18967q.close();
    }

    public final boolean w() {
        return this.f18969s;
    }

    public final NonNullObservableField<Integer> x() {
        return this.f18961k;
    }

    public final NonNullObservableField<Integer> y() {
        return this.f18960j;
    }

    public final NonNullObservableField<Boolean> z() {
        return this.f18967q;
    }
}
