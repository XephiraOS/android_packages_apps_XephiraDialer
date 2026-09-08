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
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowVoiceAnswerBtnBehavior;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: DriveModeFloatingWindowViewModel.kt */
/* loaded from: classes.dex */
public final class DriveModeFloatingWindowViewModel extends c {

    /* renamed from: s, reason: collision with root package name */
    public static final a f18971s = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public final LocalObservableField<q> f18972j;

    /* renamed from: k, reason: collision with root package name */
    public final NonNullObservableField<Integer> f18973k;

    /* renamed from: l, reason: collision with root package name */
    public final LocalObservableField<Integer> f18974l;

    /* renamed from: m, reason: collision with root package name */
    public final LocalObservableField<String> f18975m;

    /* renamed from: n, reason: collision with root package name */
    public final NonNullObservableField<Integer> f18976n;

    /* renamed from: o, reason: collision with root package name */
    public final LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> f18977o;

    /* renamed from: p, reason: collision with root package name */
    public final LocalObservableField<q> f18978p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f18979q;

    /* renamed from: r, reason: collision with root package name */
    public final LocalObservableField<q> f18980r;

    /* compiled from: DriveModeFloatingWindowViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DriveModeFloatingWindowViewModel(final b eventBus) {
        super("DriveModeFloatingWindowViewModel", eventBus);
        i.f(eventBus, "eventBus");
        this.f18972j = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{r().r(), r().s()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel$updateWindowType$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                Integer s02 = b.this.d().s0();
                if (s02 != null && s02.intValue() == 4 && !this.p().o() && this.C()) {
                    this.p().h().b(1);
                }
            }
        });
        this.f18973k = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{r().f()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel$layoutWidth$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                return Integer.valueOf(DriveModeFloatingWindowViewModel.this.r().f().getValue().widthPixels - (DriveModeFloatingWindowViewModel.this.r().h() * 2));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18974l = new LocalObservableField<>(new androidx.databinding.i[]{o().d()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel$slotIdRes$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int s02 = DriveModeFloatingWindowViewModel.this.o().d().s0();
                if (s02 != 0) {
                    if (s02 != 1) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.ic_call_card_driver_mode_sim2);
                }
                return Integer.valueOf(R.drawable.ic_call_card_driver_mode_sim1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        LocalObservableField<String> j10 = o().j();
        this.f18975m = j10;
        this.f18976n = new NonNullObservableField<>(new androidx.databinding.i[]{j10}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel$thirdLineVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                String s02 = DriveModeFloatingWindowViewModel.this.A().s0();
                if (s02 != null && s02.length() != 0) {
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
        this.f18977o = new LocalObservableField<>(new LiveData[]{d().d(), n().f()}, new ObservableBoolean[]{n().w()}, new l<Boolean, com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel$rightBtnBehavior$1
            {
                super(1);
            }

            public final com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a b(boolean z10) {
                boolean booleanValue = DriveModeFloatingWindowViewModel.this.d().m().b().booleanValue();
                boolean s02 = DriveModeFloatingWindowViewModel.this.n().w().s0();
                Call value = DriveModeFloatingWindowViewModel.this.n().j().getValue();
                InCallPresenter.InCallState s03 = DriveModeFloatingWindowViewModel.this.n().e().s0();
                if (s03.isIncoming()) {
                    if (s02) {
                        return FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_VOWIFI;
                    }
                    if (booleanValue) {
                        return FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_BLUETOOTH;
                    }
                    return FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER;
                }
                if (!s03.isDialing() && !s03.isInCall(value)) {
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
        this.f18978p = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.c()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel$onFakeAnswer$1
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
                com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a s02 = DriveModeFloatingWindowViewModel.this.y().s0();
                if (s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_VOWIFI) {
                    DriveModeFloatingWindowViewModel.this.y().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE_VOWIFI);
                } else if (s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_BLUETOOTH) {
                    DriveModeFloatingWindowViewModel.this.y().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE_BLUETOOTH);
                } else if (s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER) {
                    DriveModeFloatingWindowViewModel.this.y().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE);
                }
            }
        });
        this.f18980r = new LocalObservableField<>(new androidx.databinding.i[]{o().e()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.DriveModeFloatingWindowViewModel$toastForContact$1
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
                if (DriveModeFloatingWindowViewModel.this.w() || (s02 = DriveModeFloatingWindowViewModel.this.o().e().s0()) == null || s02.length() == 0) {
                    return;
                }
                DriveModeFloatingWindowViewModel.this.o().k().b(s02, Integer.valueOf(DriveModeFloatingWindowViewModel.this.r().g()));
                DriveModeFloatingWindowViewModel.this.D(true);
            }
        });
    }

    public final LocalObservableField<String> A() {
        return this.f18975m;
    }

    public final NonNullObservableField<Integer> B() {
        return this.f18976n;
    }

    public final boolean C() {
        if (r().s().getValue().intValue() == 0) {
            return true;
        }
        return false;
    }

    public final void D(boolean z10) {
        this.f18979q = z10;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void u() {
        super.u();
        UseCase1.e(q().c(), 4, t().b(), null, 4, null);
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void v() {
        super.v();
        this.f18972j.close();
        this.f18973k.close();
        this.f18974l.close();
        this.f18977o.close();
        this.f18976n.close();
        this.f18980r.close();
        this.f18978p.close();
    }

    public final boolean w() {
        return this.f18979q;
    }

    public final NonNullObservableField<Integer> x() {
        return this.f18973k;
    }

    public final LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> y() {
        return this.f18977o;
    }

    public final LocalObservableField<Integer> z() {
        return this.f18974l;
    }
}
