package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.R;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowInCallStateDeclineBtnBehavior;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowVoiceAnswerBtnBehavior;
import kotlin.jvm.internal.i;
import m9.q;
import v9.l;

/* compiled from: NaviFloatingWindowViewModel.kt */
/* loaded from: classes.dex */
public abstract class NaviFloatingWindowViewModel extends c {

    /* renamed from: j, reason: collision with root package name */
    public final LocalObservableField<Integer> f19027j;

    /* renamed from: k, reason: collision with root package name */
    public final LocalObservableField<Integer> f19028k;

    /* renamed from: l, reason: collision with root package name */
    public final LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> f19029l;

    /* renamed from: m, reason: collision with root package name */
    public final LocalObservableField<q> f19030m;

    /* renamed from: n, reason: collision with root package name */
    public final LocalObservableField<String> f19031n;

    /* renamed from: o, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19032o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NaviFloatingWindowViewModel(String tag, final b eventBus) {
        super(tag, eventBus);
        i.f(tag, "tag");
        i.f(eventBus, "eventBus");
        this.f19027j = new LocalObservableField<>(new androidx.databinding.i[]{o().d()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviFloatingWindowViewModel$slotIdRes$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int s02 = NaviFloatingWindowViewModel.this.o().d().s0();
                if (s02 != 0) {
                    if (s02 != 1) {
                        return null;
                    }
                    return Integer.valueOf(R.drawable.ic_call_card_navi_sim2);
                }
                return Integer.valueOf(R.drawable.ic_call_card_navi_sim1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19028k = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.g()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviFloatingWindowViewModel$rttVerifiedTextLeftDrawableRes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                if (b.this.g().s0().booleanValue()) {
                    return this.n().o(true);
                }
                return null;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19029l = new LocalObservableField<>(new LiveData[]{d().d(), n().f()}, new ObservableBoolean[]{n().w()}, new l<Boolean, com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviFloatingWindowViewModel$rightBtnBehavior$1
            {
                super(1);
            }

            public final com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a b(boolean z10) {
                boolean booleanValue = NaviFloatingWindowViewModel.this.d().m().b().booleanValue();
                boolean s02 = NaviFloatingWindowViewModel.this.n().w().s0();
                Call value = NaviFloatingWindowViewModel.this.n().j().getValue();
                InCallPresenter.InCallState s03 = NaviFloatingWindowViewModel.this.n().e().s0();
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
        this.f19030m = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.c()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviFloatingWindowViewModel$onFakeAnswer$1
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
                com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a s02 = NaviFloatingWindowViewModel.this.w().s0();
                if (s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_VOWIFI) {
                    NaviFloatingWindowViewModel.this.w().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE_VOWIFI);
                } else if (s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER_BLUETOOTH) {
                    NaviFloatingWindowViewModel.this.w().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE_BLUETOOTH);
                } else if (s02 == FloatingWindowVoiceAnswerBtnBehavior.VOICE_ANSWER) {
                    NaviFloatingWindowViewModel.this.w().x0(FloatingWindowInCallStateDeclineBtnBehavior.INCALL_STATE_DECLINE);
                }
            }
        });
        LocalObservableField<String> j10 = o().j();
        this.f19031n = j10;
        this.f19032o = new NonNullObservableField<>(new androidx.databinding.i[]{j10}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.NaviFloatingWindowViewModel$thirdLineVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                String s02 = NaviFloatingWindowViewModel.this.z().s0();
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
    }

    public final NonNullObservableField<Integer> A() {
        return this.f19032o;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void v() {
        super.v();
        this.f19027j.close();
        this.f19028k.close();
        this.f19029l.close();
        this.f19032o.close();
        this.f19030m.close();
    }

    public final LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> w() {
        return this.f19029l;
    }

    public final LocalObservableField<Integer> x() {
        return this.f19028k;
    }

    public final LocalObservableField<Integer> y() {
        return this.f19027j;
    }

    public final LocalObservableField<String> z() {
        return this.f19031n;
    }
}
