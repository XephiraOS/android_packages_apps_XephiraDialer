package com.android.incallui.oplus.answerview.view_model;

import android.telecom.CallAudioState;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.mvvm.repository.dynamic.a;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import com.android.incallui.oplus.answerview.protocol.AnswerDialogBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.DeclineBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VideoAnswerBtnBehavior;
import com.android.incallui.oplus.answerview.protocol.VoiceAnswerBtnBehavior;
import kotlin.Pair;
import kotlin.jvm.internal.i;
import m9.g;
import v9.l;
import v9.p;
import v9.q;

/* compiled from: StaticAnswerMethodModel.kt */
/* loaded from: classes.dex */
public class StaticAnswerMethodModel extends AnswerMethodModel {

    /* renamed from: f, reason: collision with root package name */
    public final y<DeclineBtnBehavior> f18869f;

    /* renamed from: g, reason: collision with root package name */
    public final y<VoiceAnswerBtnBehavior> f18870g;

    /* renamed from: h, reason: collision with root package name */
    public final y<Integer> f18871h;

    /* renamed from: i, reason: collision with root package name */
    public final y<VideoAnswerBtnBehavior> f18872i;

    /* renamed from: j, reason: collision with root package name */
    public final h<Boolean> f18873j;

    /* renamed from: k, reason: collision with root package name */
    public final y<AnswerDialogBtnBehavior> f18874k;

    /* renamed from: l, reason: collision with root package name */
    public final y<Integer> f18875l;

    /* renamed from: m, reason: collision with root package name */
    public final y<Integer> f18876m;

    public StaticAnswerMethodModel() {
        h<Boolean> hVar = h().mIsVoWifiCall;
        i.e(hVar, "mAnswerPresenter.mIsVoWifiCall");
        this.f18869f = IgnoreEqualsLiveDataKt.C(hVar, false, new l<Boolean, DeclineBtnBehavior>() { // from class: com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel$mDeclineBtnBehavior$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final DeclineBtnBehavior invoke(Boolean it) {
                i.e(it, "it");
                if (it.booleanValue()) {
                    return DeclineBtnBehavior.f18748b;
                }
                return DeclineBtnBehavior.f18747a;
            }
        }, 1, null);
        Pair a10 = g.a(h().mIsVideoCall, h().mIsVoWifiCall);
        a aVar = a.f18559a;
        this.f18870g = IgnoreEqualsLiveDataKt.G(IgnoreEqualsLiveDataKt.s(a10, aVar.G()), false, new q<Boolean, Boolean, CallAudioState, VoiceAnswerBtnBehavior>() { // from class: com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel$mVoiceAnswerBtnBehavior$1
            @Override // v9.q
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final VoiceAnswerBtnBehavior d(Boolean isVideo, Boolean isVoWifi, CallAudioState callAudioState) {
                i.f(callAudioState, "<anonymous parameter 2>");
                boolean isShowBluetoothIcon = AudioModeProvider.getInstance().isShowBluetoothIcon();
                i.e(isVoWifi, "isVoWifi");
                if (isVoWifi.booleanValue()) {
                    i.e(isVideo, "isVideo");
                    if (isVideo.booleanValue()) {
                        return VoiceAnswerBtnBehavior.f18762d;
                    }
                }
                if (isVoWifi.booleanValue() && !isVideo.booleanValue()) {
                    return VoiceAnswerBtnBehavior.f18761c;
                }
                if (isShowBluetoothIcon) {
                    i.e(isVideo, "isVideo");
                    if (isVideo.booleanValue()) {
                        return VoiceAnswerBtnBehavior.f18764f;
                    }
                }
                if (isShowBluetoothIcon && !isVideo.booleanValue()) {
                    return VoiceAnswerBtnBehavior.f18763e;
                }
                i.e(isVideo, "isVideo");
                if (isVideo.booleanValue()) {
                    return VoiceAnswerBtnBehavior.f18760b;
                }
                return VoiceAnswerBtnBehavior.f18759a;
            }
        }, 1, null);
        h<Boolean> hVar2 = h().mIsVideoCall;
        i.e(hVar2, "mAnswerPresenter.mIsVideoCall");
        this.f18871h = IgnoreEqualsLiveDataKt.C(hVar2, false, new l<Boolean, Integer>() { // from class: com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel$mVideoAnswerViewVisibility$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(Boolean it) {
                int i10;
                i.e(it, "it");
                if (it.booleanValue()) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                return Integer.valueOf(i10);
            }
        }, 1, null);
        this.f18872i = IgnoreEqualsLiveDataKt.F(g.a(h().mIsVoWifiCall, aVar.G()), false, new p<Boolean, CallAudioState, VideoAnswerBtnBehavior>() { // from class: com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel$mVideoAnswerBtnBehavior$1
            @Override // v9.p
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final VideoAnswerBtnBehavior invoke(Boolean isVoWifi, CallAudioState callAudioState) {
                i.f(callAudioState, "<anonymous parameter 1>");
                boolean isShowBluetoothIcon = AudioModeProvider.getInstance().isShowBluetoothIcon();
                i.e(isVoWifi, "isVoWifi");
                if (isVoWifi.booleanValue()) {
                    return VideoAnswerBtnBehavior.f18756b;
                }
                if (isShowBluetoothIcon) {
                    return VideoAnswerBtnBehavior.f18757c;
                }
                return VideoAnswerBtnBehavior.f18755a;
            }
        }, 1, null);
        this.f18873j = new h<>(Boolean.valueOf(OplusPhoneUtils.isReplyWithSmsAllowed(g())), false, 2, null);
        h<Boolean> hVar3 = h().mIsShowDeclineAndInterceptIcon;
        i.e(hVar3, "mAnswerPresenter.mIsShowDeclineAndInterceptIcon");
        this.f18874k = IgnoreEqualsLiveDataKt.C(hVar3, false, new l<Boolean, AnswerDialogBtnBehavior>() { // from class: com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel$mBottomDialogBtnBehavior$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AnswerDialogBtnBehavior invoke(Boolean it) {
                i.e(it, "it");
                if (it.booleanValue()) {
                    return AnswerDialogBtnBehavior.INTERCEPT_DECLINE_IN_YELLOW_PAGE_MODE;
                }
                return AnswerDialogBtnBehavior.SMS_DECLINE_IN_NORMAL_MODE;
            }
        }, 1, null);
        ResponsiveConfigRepository responsiveConfigRepository = ResponsiveConfigRepository.f18540a;
        this.f18875l = IgnoreEqualsLiveDataKt.D(responsiveConfigRepository.o1(), false, new l<Double, Integer>() { // from class: com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel$mBtnTopShrinkMargin$1
            {
                super(1);
            }

            public final Integer b(double d10) {
                return Integer.valueOf((int) (StaticAnswerMethodModel.this.g().getResources().getDimensionPixelSize(R.dimen.fling_up_answer_method_dialog_btn_margin_top) * d10));
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ Integer invoke(Double d10) {
                return b(d10.doubleValue());
            }
        }, 1, null);
        this.f18876m = IgnoreEqualsLiveDataKt.F(g.a(responsiveConfigRepository.o1(), responsiveConfigRepository.N0()), false, new p<Double, Integer, Integer>() { // from class: com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel$mBtnBottomShrinkMargin$1
            {
                super(2);
            }

            public final Integer b(double d10, int i10) {
                return Integer.valueOf((int) ((StaticAnswerMethodModel.this.g().getResources().getDimensionPixelSize(R.dimen.fling_up_answer_method_dialog_btn_margin_bottom) * d10) + i10));
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Integer invoke(Double d10, Integer num) {
                return b(d10.doubleValue(), num.intValue());
            }
        }, 1, null);
    }

    @Override // com.android.incallui.oplus.answerview.view_model.AnswerMethodModel, androidx.lifecycle.I
    public void e() {
        super.e();
        this.f18869f.q(h().mIsVoWifiCall);
        this.f18870g.q(h().mIsVideoCall);
        this.f18870g.q(h().mIsVoWifiCall);
        y<VoiceAnswerBtnBehavior> yVar = this.f18870g;
        a aVar = a.f18559a;
        yVar.q(aVar.G());
        this.f18871h.q(h().mIsVideoCall);
        this.f18872i.q(h().mIsVoWifiCall);
        this.f18872i.q(aVar.G());
        this.f18874k.q(h().mIsShowDeclineAndInterceptIcon);
    }

    public final y<AnswerDialogBtnBehavior> j() {
        return this.f18874k;
    }

    public final h<Boolean> k() {
        return this.f18873j;
    }

    public final y<Integer> l() {
        return this.f18876m;
    }

    public final y<Integer> m() {
        return this.f18875l;
    }

    public final y<DeclineBtnBehavior> n() {
        return this.f18869f;
    }

    public final y<VideoAnswerBtnBehavior> o() {
        return this.f18872i;
    }

    public final y<Integer> p() {
        return this.f18871h;
    }

    public final y<VoiceAnswerBtnBehavior> q() {
        return this.f18870g;
    }
}
