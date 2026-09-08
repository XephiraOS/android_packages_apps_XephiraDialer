package com.android.incallui.mvvm.view_model;

import android.graphics.drawable.Drawable;
import android.telecom.VideoProfile;
import com.android.incallui.Call;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.mvvm.base.BaseViewModel;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.repository.dynamic.b;
import com.android.incallui.mvvm.usecase.VideoBackgroundUseCase;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import f2.c;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.o;
import kotlin.jvm.internal.i;
import m9.g;
import v9.InterfaceC1637a;
import v9.l;
import v9.p;
import v9.q;

/* compiled from: CallCardViewModel.kt */
/* loaded from: classes.dex */
public final class CallCardViewModel extends BaseViewModel {

    /* renamed from: A, reason: collision with root package name */
    public final y<Pair<String, String>> f18682A;

    /* renamed from: B, reason: collision with root package name */
    public final y<Drawable> f18683B;

    /* renamed from: d, reason: collision with root package name */
    public final h<Boolean> f18684d = new h<>(Boolean.TRUE, false, 2, null);

    /* renamed from: e, reason: collision with root package name */
    public final y<Integer> f18685e;

    /* renamed from: f, reason: collision with root package name */
    public final y<Integer> f18686f;

    /* renamed from: g, reason: collision with root package name */
    public final h<Boolean> f18687g;

    /* renamed from: h, reason: collision with root package name */
    public final h<Boolean> f18688h;

    /* renamed from: i, reason: collision with root package name */
    public final y<Integer> f18689i;

    /* renamed from: j, reason: collision with root package name */
    public final y<Integer> f18690j;

    /* renamed from: k, reason: collision with root package name */
    public final y<Integer> f18691k;

    /* renamed from: l, reason: collision with root package name */
    public final y<Integer> f18692l;

    /* renamed from: m, reason: collision with root package name */
    public final y<Integer> f18693m;

    /* renamed from: n, reason: collision with root package name */
    public final h<Boolean> f18694n;

    /* renamed from: o, reason: collision with root package name */
    public final h<Boolean> f18695o;

    /* renamed from: p, reason: collision with root package name */
    public final y<Boolean> f18696p;

    /* renamed from: q, reason: collision with root package name */
    public final y<String> f18697q;

    /* renamed from: r, reason: collision with root package name */
    public final h<String> f18698r;

    /* renamed from: x, reason: collision with root package name */
    public final h<Boolean> f18699x;

    /* renamed from: y, reason: collision with root package name */
    public final h<String> f18700y;

    /* renamed from: z, reason: collision with root package name */
    public h<Long> f18701z;

    public CallCardViewModel() {
        List j10;
        List j11;
        List j12;
        ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
        this.f18685e = IgnoreEqualsLiveDataKt.D(responsiveConfigRepository.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mCallStateShrinkMarginTopDefault$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                double dimensionPixelSize = CallCardViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.call_card_primary_info_state_margin_top);
                if (Double.compare(d10, 1.0d) > 0) {
                    d10 = 1.0d;
                } else {
                    Double.compare(d10, d10);
                }
                Integer valueOf = Integer.valueOf((int) (dimensionPixelSize * d10));
                Log.d("CallCardViewModel", "mCallStateShrinkMarginTopDefault change to: " + valueOf.intValue());
                return valueOf;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
        this.f18686f = IgnoreEqualsLiveDataKt.F(g.a(responsiveConfigRepository.o1(), responsiveConfigRepository.r1()), false, new p<Double, Integer, Integer>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mCallStateShrinkMarginTopCenter$1
            {
                super(2);
            }

            public final Integer b(double d10, int i10) {
                Integer valueOf = Integer.valueOf((int) (CallCardViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.call_card_primary_call_state_center_margin_top) * d10));
                Integer valueOf2 = Integer.valueOf(i10);
                if (valueOf.compareTo(valueOf) <= 0 && valueOf.compareTo(valueOf2) < 0) {
                    return valueOf2;
                }
                return valueOf;
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Integer invoke(Double d10, Integer num) {
                return b(d10.doubleValue(), num.intValue());
            }
        }, 1, null);
        Boolean bool = Boolean.FALSE;
        h<Boolean> hVar = new h<>(bool, false, 2, null);
        this.f18687g = hVar;
        this.f18688h = new h<>(bool, false, 2, null);
        this.f18689i = IgnoreEqualsLiveDataKt.D(responsiveConfigRepository.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mNameShrinkMarginTop$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                return Integer.valueOf((int) (CallCardViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.call_card_primary_info_margin_top) * d10));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
        j10 = o.j(responsiveConfigRepository.o1(), responsiveConfigRepository.r1(), hVar);
        this.f18690j = IgnoreEqualsLiveDataKt.E(j10, false, new InterfaceC1637a<Integer>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mNameShrinkGoneMarginTop$1
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                Number valueOf;
                if (CallCardViewModel.this.t().getValue().booleanValue()) {
                    valueOf = Integer.valueOf(CallCardViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.call_card_primary_info_gone_margin_top_emergency));
                } else {
                    valueOf = Double.valueOf(CallCardViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.call_card_primary_info_gone_margin_top) * ResponsiveConfigRepository.f18540a.o1().getValue().doubleValue());
                }
                Integer valueOf2 = Integer.valueOf(valueOf.intValue());
                Integer value = ResponsiveConfigRepository.f18540a.r1().getValue();
                if (valueOf2.compareTo(valueOf2) <= 0 && valueOf2.compareTo(value) < 0) {
                    valueOf2 = value;
                }
                return valueOf2;
            }
        }, 1, null);
        this.f18691k = IgnoreEqualsLiveDataKt.F(g.a(responsiveConfigRepository.o1(), responsiveConfigRepository.r1()), false, new p<Double, Integer, Integer>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mSecondaryShrinkMarginTop$1
            {
                super(2);
            }

            public final Integer b(double d10, int i10) {
                Integer valueOf = Integer.valueOf((int) (CallCardViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.call_card_secondary_info_margin_top) * d10));
                Integer valueOf2 = Integer.valueOf(i10);
                if (valueOf.compareTo(valueOf) <= 0 && valueOf.compareTo(valueOf2) < 0) {
                    return valueOf2;
                }
                return valueOf;
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Integer invoke(Double d10, Integer num) {
                return b(d10.doubleValue(), num.intValue());
            }
        }, 1, null);
        this.f18692l = IgnoreEqualsLiveDataKt.D(responsiveConfigRepository.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mDividerShrinkMarginTop$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                return Integer.valueOf((int) (CallCardViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.call_card_secondary_info_divider_margin_top) * d10));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
        this.f18693m = IgnoreEqualsLiveDataKt.D(responsiveConfigRepository.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mFBENoticeShrinkMarginTop$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                double dimensionPixelSize = CallCardViewModel.this.g().getResources().getDimensionPixelSize(R.dimen.call_card_fbe_notice_margin_top);
                if (Double.compare(d10, 1.0d) > 0) {
                    d10 = 1.0d;
                } else {
                    Double.compare(d10, d10);
                }
                return Integer.valueOf((int) (dimensionPixelSize * d10));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
        h<Boolean> hVar2 = new h<>(bool, false, 2, null);
        this.f18694n = hVar2;
        h<Boolean> hVar3 = new h<>(bool, false, 2, null);
        this.f18695o = hVar3;
        Pair a10 = g.a(hVar2, hVar3);
        b bVar = b.f18561a;
        this.f18696p = IgnoreEqualsLiveDataKt.G(IgnoreEqualsLiveDataKt.s(a10, bVar.a()), false, new q<Boolean, Boolean, Boolean, Boolean>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mCallCardNoticeVisibility$1
            public final Boolean b(boolean z10, boolean z11, boolean z12) {
                boolean z13;
                if (z10 && (z11 || z12)) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                return Boolean.valueOf(z13);
            }

            @Override // v9.q
            public /* bridge */ /* synthetic */ Boolean d(Boolean bool2, Boolean bool3, Boolean bool4) {
                return b(bool2.booleanValue(), bool3.booleanValue(), bool4.booleanValue());
            }
        }, 1, null);
        this.f18697q = IgnoreEqualsLiveDataKt.F(g.a(hVar3, bVar.a()), false, new p<Boolean, Boolean, String>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mCallCardNoticeContent$1
            {
                super(2);
            }

            public final String b(boolean z10, boolean z11) {
                if (z10) {
                    String string = CallCardViewModel.this.g().getString(R.string.oplus_penetrated_incoming_call_prompt);
                    i.e(string, "defaultUiContext.getStri…ted_incoming_call_prompt)");
                    return string;
                }
                if (z11) {
                    String string2 = CallCardViewModel.this.g().getString(R.string.oplus_fbe_read_contact_rejected);
                    i.e(string2, "defaultUiContext.getStri…be_read_contact_rejected)");
                    return string2;
                }
                return "";
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ String invoke(Boolean bool2, Boolean bool3) {
                return b(bool2.booleanValue(), bool3.booleanValue());
            }
        }, 1, null);
        h<String> hVar4 = new h<>("", false, 2, null);
        this.f18698r = hVar4;
        h<Boolean> hVar5 = new h<>(bool, false, 2, null);
        this.f18699x = hVar5;
        h<String> hVar6 = new h<>("", false, 2, null);
        this.f18700y = hVar6;
        h<Long> hVar7 = new h<>(0L, false, 2, null);
        this.f18701z = hVar7;
        j11 = o.j(hVar5, hVar7, hVar6, hVar4);
        this.f18682A = IgnoreEqualsLiveDataKt.E(j11, false, new InterfaceC1637a<Pair<? extends String, ? extends String>>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mCallStateLabel$1
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Pair<String, String> invoke() {
                String value;
                String str;
                if (CallCardViewModel.this.q().getValue().length() > 0) {
                    value = CallCardViewModel.this.q().getValue();
                } else {
                    if (CallCardViewModel.this.w().getValue().booleanValue()) {
                        String a11 = D2.b.a(CallCardViewModel.this.g(), CallCardViewModel.this.k().getValue().longValue() / 1000);
                        i.e(a11, "formatElapsedTime(defaul…onstants.SECONDS_DIVISOR)");
                        String formatDuration = OplusPhoneUtils.formatDuration(CallCardViewModel.this.k().getValue().longValue());
                        i.e(formatDuration, "formatDuration(mCallDuration.value)");
                        str = formatDuration;
                        value = a11;
                        return g.a(value, str);
                    }
                    value = CallCardViewModel.this.l().getValue();
                }
                str = value;
                return g.a(value, str);
            }
        }, 1, null);
        c cVar = c.f31677a;
        j12 = o.j(cVar.b(), cVar.d(), cVar.f(), cVar.g(), VideoBackgroundUseCase.f18569a.j());
        this.f18683B = IgnoreEqualsLiveDataKt.w(j12, null, true, new InterfaceC1637a<Drawable>() { // from class: com.android.incallui.mvvm.view_model.CallCardViewModel$mAvatarDrawable$1
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Drawable invoke() {
                c cVar2 = c.f31677a;
                Drawable value = cVar2.b().getValue();
                Drawable drawable = null;
                if (value != null) {
                    if (VideoBackgroundUseCase.f18569a.j().getValue().intValue() != 2 && (cVar2.g().getValue().booleanValue() || ((!VideoProfile.isBidirectional(cVar2.f().getValue().intValue()) || !Call.State.isConnectingOrDialing(cVar2.d().getValue().intValue())) && ((VideoProfile.isVideo(cVar2.f().getValue().intValue()) && Call.State.isActiveOrHold(cVar2.d().getValue().intValue())) || !com.android.incallui.mvvm.utils.b.a(value))))) {
                        value = null;
                    }
                    drawable = value;
                }
                Log.d("CallCardViewModel", "mAvatarDrawable change " + drawable);
                return drawable;
            }
        });
    }

    public final y<Integer> A() {
        return this.f18691k;
    }

    @Override // androidx.lifecycle.I
    public void e() {
        super.e();
        Log.d("CallCardViewModel", "onCleared: ");
        this.f18683B.o(null);
    }

    public final y<Drawable> h() {
        return this.f18683B;
    }

    public final y<String> i() {
        return this.f18697q;
    }

    public final y<Boolean> j() {
        return this.f18696p;
    }

    public final h<Long> k() {
        return this.f18701z;
    }

    public final h<String> l() {
        return this.f18700y;
    }

    public final y<Pair<String, String>> m() {
        return this.f18682A;
    }

    public final h<Boolean> n() {
        return this.f18684d;
    }

    public final y<Integer> o() {
        return this.f18686f;
    }

    public final y<Integer> p() {
        return this.f18685e;
    }

    public final h<String> q() {
        return this.f18698r;
    }

    public final y<Integer> r() {
        return this.f18692l;
    }

    public final y<Integer> s() {
        return this.f18693m;
    }

    public final h<Boolean> t() {
        return this.f18687g;
    }

    public final h<Boolean> u() {
        return this.f18695o;
    }

    public final h<Boolean> v() {
        return this.f18694n;
    }

    public final h<Boolean> w() {
        return this.f18699x;
    }

    public final y<Integer> x() {
        return this.f18690j;
    }

    public final y<Integer> y() {
        return this.f18689i;
    }

    public final h<Boolean> z() {
        return this.f18688h;
    }
}
