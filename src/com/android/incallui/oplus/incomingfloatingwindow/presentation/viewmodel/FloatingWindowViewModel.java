package com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel;

import android.util.DisplayMetrics;
import android.util.Log;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import com.android.incallui.Call;
import com.android.incallui.InCallPresenter;
import com.android.incallui.clean.domain.interactor.LocalObservableField;
import com.android.incallui.clean.domain.interactor.NonNullObservableField;
import com.android.incallui.mvvm.utils.y;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowInComingStateDeclineBtnBehavior;
import com.android.incallui.oplus.incomingfloatingwindow.domain.bean.FloatingWindowSpeakerBtnBehavior;
import kotlin.Pair;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import q2.C1481a;
import v9.l;

/* compiled from: FloatingWindowViewModel.kt */
/* loaded from: classes.dex */
public final class FloatingWindowViewModel extends c {

    /* renamed from: M, reason: collision with root package name */
    public static final a f18997M = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f18998A;

    /* renamed from: B, reason: collision with root package name */
    public final LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> f18999B;

    /* renamed from: C, reason: collision with root package name */
    public final LocalObservableField<q> f19000C;

    /* renamed from: D, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19001D;

    /* renamed from: E, reason: collision with root package name */
    public final LocalObservableField<String> f19002E;

    /* renamed from: F, reason: collision with root package name */
    public final LocalObservableField<String> f19003F;

    /* renamed from: G, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19004G;

    /* renamed from: H, reason: collision with root package name */
    public final LocalObservableField<Integer> f19005H;

    /* renamed from: I, reason: collision with root package name */
    public final LocalObservableField<Integer> f19006I;

    /* renamed from: J, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f19007J;

    /* renamed from: K, reason: collision with root package name */
    public final NonNullObservableField<Float> f19008K;

    /* renamed from: L, reason: collision with root package name */
    public final LocalObservableField<C1481a> f19009L;

    /* renamed from: j, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19010j;

    /* renamed from: k, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19011k;

    /* renamed from: l, reason: collision with root package name */
    public final LocalObservableField<Integer> f19012l;

    /* renamed from: m, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19013m;

    /* renamed from: n, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19014n;

    /* renamed from: o, reason: collision with root package name */
    public final LocalObservableField<q> f19015o;

    /* renamed from: p, reason: collision with root package name */
    public final LocalObservableField<String> f19016p;

    /* renamed from: q, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19017q;

    /* renamed from: r, reason: collision with root package name */
    public final LocalObservableField<String> f19018r;

    /* renamed from: s, reason: collision with root package name */
    public final LocalObservableField<String> f19019s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f19020t;

    /* renamed from: u, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f19021u;

    /* renamed from: v, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19022v;

    /* renamed from: w, reason: collision with root package name */
    public final LocalObservableField<String> f19023w;

    /* renamed from: x, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19024x;

    /* renamed from: y, reason: collision with root package name */
    public final NonNullObservableField<Boolean> f19025y;

    /* renamed from: z, reason: collision with root package name */
    public final NonNullObservableField<Integer> f19026z;

    /* compiled from: FloatingWindowViewModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingWindowViewModel(final b eventBus) {
        super("FloatingWindowViewModel", eventBus);
        i.f(eventBus, "eventBus");
        this.f19010j = new NonNullObservableField<>(new androidx.databinding.i[]{eventBus.d()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$defaultViewVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                Integer s02 = b.this.d().s0();
                if (s02 != null && s02.intValue() == 1) {
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
        this.f19011k = new NonNullObservableField<>(new androidx.databinding.i[]{eventBus.d()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$driveModeViewVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                Integer s02 = b.this.d().s0();
                if (s02 != null && s02.intValue() == 4) {
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
        LocalObservableField<Integer> localObservableField = new LocalObservableField<>(new y[]{r().f()}, new LocalObservableField[]{eventBus.d()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$naviViewType$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                DisplayMetrics value = FloatingWindowViewModel.this.r().f().getValue();
                Integer s02 = eventBus.d().s0();
                if (s02 == null || s02.intValue() != 5) {
                    return null;
                }
                if (value.widthPixels < FloatingWindowViewModel.this.r().o()) {
                    return 2;
                }
                return 3;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19012l = localObservableField;
        this.f19013m = new NonNullObservableField<>(new androidx.databinding.i[]{localObservableField}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$naviLandscapeViewVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                Integer s02 = FloatingWindowViewModel.this.K().s0();
                if (s02 != null && s02.intValue() == 3) {
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
        this.f19014n = new NonNullObservableField<>(new androidx.databinding.i[]{localObservableField}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$naviPortraitViewVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                Integer s02 = FloatingWindowViewModel.this.K().s0();
                if (s02 != null && s02.intValue() == 2) {
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
        this.f19015o = new LocalObservableField<>(new androidx.databinding.i[]{localObservableField}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$updateNaviWindowHeight$1
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
                int n10;
                if (FloatingWindowViewModel.this.n().u()) {
                    return;
                }
                Integer s02 = FloatingWindowViewModel.this.K().s0();
                if (s02 != null && s02.intValue() == 3) {
                    n10 = FloatingWindowViewModel.this.r().j();
                } else if (s02 == null || s02.intValue() != 2) {
                    return;
                } else {
                    n10 = FloatingWindowViewModel.this.r().n();
                }
                if (FloatingWindowViewModel.this.n().e().s0().isDialing()) {
                    n10 += FloatingWindowViewModel.this.r().p();
                }
                Log.d("FloatingWindowViewModel", "updateNaviWindowHeight: " + n10);
                eventBus.a().I(n10);
            }
        });
        this.f19016p = o().f();
        this.f19017q = new NonNullObservableField<>(new androidx.databinding.i[]{o().f()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$firstLineVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                String s02 = FloatingWindowViewModel.this.o().f().s0();
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
        LocalObservableField<String> localObservableField2 = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{n().j()}, new l<Boolean, String>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$callEndPrompt$1
            {
                super(1);
            }

            public final String b(boolean z10) {
                Call value = FloatingWindowViewModel.this.n().j().getValue();
                if (value != null && value.getState() == 10) {
                    return FloatingWindowViewModel.this.n().d(value);
                }
                return null;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ String invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19018r = localObservableField2;
        LocalObservableField<String> localObservableField3 = new LocalObservableField<>(new androidx.databinding.i[]{o().i(), n().g(), localObservableField2}, new l<Boolean, String>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$numberAndLocation$1
            {
                super(1);
            }

            public final String b(boolean z10) {
                String s02 = FloatingWindowViewModel.this.w().s0();
                String s03 = FloatingWindowViewModel.this.n().g().s0();
                String s04 = FloatingWindowViewModel.this.o().i().s0();
                if (s02 == null || s02.length() == 0) {
                    if (s03 != null && s03.length() != 0) {
                        return s03;
                    }
                    return s04;
                }
                return s02;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ String invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19019s = localObservableField3;
        this.f19020t = true;
        this.f19021u = new NonNullObservableField<>(new androidx.databinding.i[]{localObservableField3}, new l<Boolean, Boolean>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$isNeedNumberAndLocationTextAnim$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                boolean z11 = true;
                if (i.b(FloatingWindowViewModel.this.L().s0(), FloatingWindowViewModel.this.n().g().s0())) {
                    if (FloatingWindowViewModel.this.U()) {
                        FloatingWindowViewModel.this.X(false);
                    } else {
                        z11 = false;
                    }
                }
                return Boolean.valueOf(z11);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19022v = new NonNullObservableField<>(new androidx.databinding.i[]{localObservableField3}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$numberAndLocationVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                String s02 = FloatingWindowViewModel.this.L().s0();
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
        LocalObservableField<String> localObservableField4 = new LocalObservableField<>(new androidx.databinding.i[]{o().g(), localObservableField2}, new l<Boolean, String>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$callMark$1
            {
                super(1);
            }

            public final String b(boolean z10) {
                String s02 = FloatingWindowViewModel.this.w().s0();
                if (s02 != null && s02.length() != 0) {
                    return null;
                }
                return FloatingWindowViewModel.this.o().g().s0();
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ String invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19023w = localObservableField4;
        this.f19024x = new NonNullObservableField<>(new androidx.databinding.i[]{localObservableField4}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$callMarkVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                String s02 = FloatingWindowViewModel.this.x().s0();
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
        this.f19025y = new NonNullObservableField<>(new androidx.databinding.i[]{localObservableField4}, new l<Boolean, Boolean>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$goneCallMarkAutoWrapWithAnim$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                boolean z11;
                String s02 = FloatingWindowViewModel.this.x().s0();
                if (s02 != null && s02.length() != 0) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19026z = new NonNullObservableField<>(new androidx.databinding.i[]{o().d()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$slotIdVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                if (FloatingWindowViewModel.this.o().d().s0() == -1) {
                    i10 = 8;
                } else {
                    i10 = 0;
                }
                return Integer.valueOf(i10);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18998A = new NonNullObservableField<>(new androidx.databinding.i[]{localObservableField3}, new l<Boolean, Boolean>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$doCallCardIdIconAnim$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                boolean z11 = false;
                if (FloatingWindowViewModel.this.o().d().s0() != -1 && !i.b(FloatingWindowViewModel.this.L().s0(), FloatingWindowViewModel.this.n().g().s0())) {
                    z11 = true;
                }
                return Boolean.valueOf(z11);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f18999B = new LocalObservableField<>(new LiveData[]{d().d(), d().n(), n().f()}, new ObservableBoolean[]{n().w()}, new l<Boolean, com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$leftBtnBehavior$1
            {
                super(1);
            }

            public final com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a b(boolean z10) {
                boolean booleanValue = FloatingWindowViewModel.this.d().m().b().booleanValue();
                boolean s02 = FloatingWindowViewModel.this.n().w().s0();
                boolean b10 = i.b(FloatingWindowViewModel.this.d().n().getValue(), Boolean.TRUE);
                Call value = FloatingWindowViewModel.this.n().j().getValue();
                InCallPresenter.InCallState s03 = FloatingWindowViewModel.this.n().e().s0();
                if (s03.isIncoming()) {
                    if (s02) {
                        return FloatingWindowInComingStateDeclineBtnBehavior.INCOMING_STATE_DECLINE_VOWIFI;
                    }
                    if (booleanValue) {
                        return FloatingWindowInComingStateDeclineBtnBehavior.INCOMING_STATE_DECLINE_BLUETOOTH;
                    }
                    return FloatingWindowInComingStateDeclineBtnBehavior.INCOMING_STATE_DECLINE;
                }
                if (!s03.isDialing() && !s03.isInCall(value)) {
                    return null;
                }
                if (b10) {
                    return FloatingWindowSpeakerBtnBehavior.SPEAKER_ON;
                }
                return FloatingWindowSpeakerBtnBehavior.SPEAKER_OFF;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19000C = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.c()}, new l<Boolean, q>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$onFakeAnswer$1
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return q.f35511a;
            }

            public final void invoke(boolean z10) {
                FloatingWindowSpeakerBtnBehavior floatingWindowSpeakerBtnBehavior;
                if (z10) {
                    return;
                }
                boolean b10 = i.b(FloatingWindowViewModel.this.d().n().getValue(), Boolean.TRUE);
                LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> H10 = FloatingWindowViewModel.this.H();
                if (b10) {
                    floatingWindowSpeakerBtnBehavior = FloatingWindowSpeakerBtnBehavior.SPEAKER_ON;
                } else {
                    floatingWindowSpeakerBtnBehavior = FloatingWindowSpeakerBtnBehavior.SPEAKER_OFF;
                }
                H10.x0(floatingWindowSpeakerBtnBehavior);
            }
        });
        this.f19001D = new NonNullObservableField<>(new LiveData[]{n().f()}, new ObservableBoolean[]{n().v()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$rttLabelVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                Call call;
                int i10;
                boolean s02 = FloatingWindowViewModel.this.n().v().s0();
                Pair<Call, InCallPresenter.InCallState> value = FloatingWindowViewModel.this.n().f().getValue();
                InCallPresenter.InCallState inCallState = null;
                if (value != null) {
                    call = value.c();
                } else {
                    call = null;
                }
                Pair<Call, InCallPresenter.InCallState> value2 = FloatingWindowViewModel.this.n().f().getValue();
                if (value2 != null) {
                    inCallState = value2.d();
                }
                if (FloatingWindowViewModel.this.n().y(call, s02, inCallState)) {
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
        this.f19002E = new LocalObservableField<>((LiveData<?>[]) new LiveData[]{n().j()}, new l<Boolean, String>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$rttLabelContent$1
            {
                super(1);
            }

            public final String b(boolean z10) {
                return FloatingWindowViewModel.this.n().l(FloatingWindowViewModel.this.n().j().getValue());
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ String invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19003F = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.g()}, new l<Boolean, String>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$rttVerifiedContent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final String b(boolean z10) {
                if (b.this.g().s0().booleanValue()) {
                    return this.n().m();
                }
                return null;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ String invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19004G = new NonNullObservableField<>(new androidx.databinding.i[]{eventBus.g()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$rttVerifiedVisibility$1
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                int i10;
                if (b.this.g().s0().booleanValue()) {
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
        this.f19005H = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.g()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$rttVerifiedTextColor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                if (b.this.g().s0().booleanValue()) {
                    return this.n().n();
                }
                return null;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19006I = new LocalObservableField<>(new androidx.databinding.i[]{eventBus.g()}, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$rttVerifiedTextPadding$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Integer b(boolean z10) {
                if (b.this.g().s0().booleanValue()) {
                    return this.n().p();
                }
                return null;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19007J = new NonNullObservableField<>((LiveData<?>[]) new LiveData[]{r().t()}, new l<Boolean, Boolean>() { // from class: com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.FloatingWindowViewModel$isNightModeActive$1
            {
                super(1);
            }

            public final Boolean b(boolean z10) {
                return FloatingWindowViewModel.this.r().t().getValue();
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return b(bool.booleanValue());
            }
        });
        this.f19008K = eventBus.f();
        this.f19009L = eventBus.e();
    }

    public final NonNullObservableField<Boolean> A() {
        return this.f18998A;
    }

    public final NonNullObservableField<Integer> B() {
        return this.f19011k;
    }

    public final LocalObservableField<String> C() {
        return this.f19016p;
    }

    public final NonNullObservableField<Integer> D() {
        return this.f19017q;
    }

    public final NonNullObservableField<Boolean> E() {
        return this.f19025y;
    }

    public final LocalObservableField<C1481a> F() {
        return this.f19009L;
    }

    public final NonNullObservableField<Float> G() {
        return this.f19008K;
    }

    public final LocalObservableField<com.android.incallui.oplus.incomingfloatingwindow.domain.bean.a> H() {
        return this.f18999B;
    }

    public final NonNullObservableField<Integer> I() {
        return this.f19013m;
    }

    public final NonNullObservableField<Integer> J() {
        return this.f19014n;
    }

    public final LocalObservableField<Integer> K() {
        return this.f19012l;
    }

    public final LocalObservableField<String> L() {
        return this.f19019s;
    }

    public final NonNullObservableField<Integer> M() {
        return this.f19022v;
    }

    public final LocalObservableField<String> N() {
        return this.f19002E;
    }

    public final NonNullObservableField<Integer> O() {
        return this.f19001D;
    }

    public final LocalObservableField<String> P() {
        return this.f19003F;
    }

    public final LocalObservableField<Integer> Q() {
        return this.f19005H;
    }

    public final LocalObservableField<Integer> R() {
        return this.f19006I;
    }

    public final NonNullObservableField<Integer> S() {
        return this.f19004G;
    }

    public final NonNullObservableField<Integer> T() {
        return this.f19026z;
    }

    public final boolean U() {
        return this.f19020t;
    }

    public final NonNullObservableField<Boolean> V() {
        return this.f19021u;
    }

    public final NonNullObservableField<Boolean> W() {
        return this.f19007J;
    }

    public final void X(boolean z10) {
        this.f19020t = z10;
    }

    @Override // com.android.incallui.oplus.incomingfloatingwindow.presentation.viewmodel.c
    public void v() {
        super.v();
        this.f19010j.close();
        this.f19011k.close();
        this.f19012l.close();
        this.f19013m.close();
        this.f19014n.close();
        this.f19017q.close();
        this.f19018r.close();
        this.f19019s.close();
        this.f19021u.close();
        this.f19022v.close();
        this.f19023w.close();
        this.f19024x.close();
        this.f19025y.close();
        this.f19026z.close();
        this.f18998A.close();
        this.f18999B.close();
        this.f19001D.close();
        this.f19002E.close();
        this.f19003F.close();
        this.f19004G.close();
        this.f19005H.close();
        this.f19006I.close();
        this.f19007J.close();
        this.f19015o.close();
        this.f19000C.close();
    }

    public final LocalObservableField<String> w() {
        return this.f19018r;
    }

    public final LocalObservableField<String> x() {
        return this.f19023w;
    }

    public final NonNullObservableField<Integer> y() {
        return this.f19024x;
    }

    public final NonNullObservableField<Integer> z() {
        return this.f19010j;
    }
}
