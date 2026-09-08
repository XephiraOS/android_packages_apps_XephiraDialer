package com.android.incallui.oplus.answerview.view_model;

import android.telecom.CallAudioState;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.R;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.repository.dynamic.a;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import com.android.incallui.oplus.answerview.protocol.RideModeAnswerViewBehavior;
import com.android.incallui.oplus.answerview.protocol.RideModeDeclineViewBehavior;
import kotlin.jvm.internal.i;
import m9.g;
import v9.l;
import v9.p;

/* compiled from: RideModeAnswerMethodModel.kt */
/* loaded from: classes.dex */
public final class RideModeAnswerMethodModel extends AnswerMethodModel {

    /* renamed from: f, reason: collision with root package name */
    public final String f18861f = g().getString(R.string.oplus_video_call_audio_answer_text);

    /* renamed from: g, reason: collision with root package name */
    public final String f18862g = g().getString(R.string.oplus_video_call_video_answer_text);

    /* renamed from: h, reason: collision with root package name */
    public final h<RideModeDeclineViewBehavior> f18863h = new h<>(RideModeDeclineViewBehavior.DECLINE_IN_RIDE_MODE, false, 2, null);

    /* renamed from: i, reason: collision with root package name */
    public final y<RideModeAnswerViewBehavior> f18864i = IgnoreEqualsLiveDataKt.C(a.f18559a.G(), false, new l<CallAudioState, RideModeAnswerViewBehavior>() { // from class: com.android.incallui.oplus.answerview.view_model.RideModeAnswerMethodModel$mRideModeAnswerViewBehavior$1
        @Override // v9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final RideModeAnswerViewBehavior invoke(CallAudioState it) {
            i.f(it, "it");
            if (AudioModeProvider.getInstance().isShowBluetoothIcon()) {
                return RideModeAnswerViewBehavior.VOICE_ANSWER_IN_BLUETOOTH_MODE;
            }
            return RideModeAnswerViewBehavior.VOICE_ANSWER_IN_RIDE_MODE;
        }
    }, 1, null);

    /* renamed from: j, reason: collision with root package name */
    public final y<String> f18865j;

    /* renamed from: k, reason: collision with root package name */
    public final y<Integer> f18866k;

    /* renamed from: l, reason: collision with root package name */
    public final y<Integer> f18867l;

    public RideModeAnswerMethodModel() {
        h<Boolean> hVar = h().mIsVideoCall;
        i.e(hVar, "mAnswerPresenter.mIsVideoCall");
        this.f18865j = IgnoreEqualsLiveDataKt.C(hVar, false, new l<Boolean, String>() { // from class: com.android.incallui.oplus.answerview.view_model.RideModeAnswerMethodModel$mAnswerText$1
            {
                super(1);
            }

            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String invoke(Boolean it) {
                String str;
                String str2;
                i.e(it, "it");
                if (it.booleanValue()) {
                    str2 = RideModeAnswerMethodModel.this.f18861f;
                    return str2;
                }
                str = RideModeAnswerMethodModel.this.f18862g;
                return str;
            }
        }, 1, null);
        ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
        this.f18866k = IgnoreEqualsLiveDataKt.F(g.a(responsiveConfigRepository.o1(), responsiveConfigRepository.N0()), false, new p<Double, Integer, Integer>() { // from class: com.android.incallui.oplus.answerview.view_model.RideModeAnswerMethodModel$mBottomShrinkMargin$1
            {
                super(2);
            }

            public final Integer b(double d10, int i10) {
                Integer valueOf = Integer.valueOf((int) (RideModeAnswerMethodModel.this.g().getResources().getDimensionPixelSize(R.dimen.ride_mode_answer_method_description_margin_bottom) * d10));
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
        this.f18867l = IgnoreEqualsLiveDataKt.D(responsiveConfigRepository.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.oplus.answerview.view_model.RideModeAnswerMethodModel$mBtnTopShrinkMargin$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                return Integer.valueOf((int) (RideModeAnswerMethodModel.this.g().getResources().getDimensionPixelSize(R.dimen.ride_mode_answer_method_swipe_view_margin_top) * d10));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
    }

    @Override // com.android.incallui.oplus.answerview.view_model.AnswerMethodModel, androidx.lifecycle.I
    public void e() {
        super.e();
        this.f18865j.q(h().mIsVideoCall);
        this.f18864i.q(a.f18559a.G());
    }

    public final y<String> l() {
        return this.f18865j;
    }

    public final y<Integer> m() {
        return this.f18866k;
    }

    public final y<Integer> n() {
        return this.f18867l;
    }

    public final y<RideModeAnswerViewBehavior> o() {
        return this.f18864i;
    }

    public final h<RideModeDeclineViewBehavior> p() {
        return this.f18863h;
    }
}
