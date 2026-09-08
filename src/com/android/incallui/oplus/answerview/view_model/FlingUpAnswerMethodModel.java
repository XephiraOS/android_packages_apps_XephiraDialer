package com.android.incallui.oplus.answerview.view_model;

import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import com.android.incallui.oplus.answerview.protocol.VoiceGuideViewBehavior;
import kotlin.jvm.internal.i;
import v9.l;

/* compiled from: FlingUpAnswerMethodModel.kt */
/* loaded from: classes.dex */
public final class FlingUpAnswerMethodModel extends StaticAnswerMethodModel {

    /* renamed from: n, reason: collision with root package name */
    public final y<VoiceGuideViewBehavior> f18859n;

    public FlingUpAnswerMethodModel() {
        h<Boolean> hVar = h().mIsVideoCall;
        i.e(hVar, "mAnswerPresenter.mIsVideoCall");
        this.f18859n = IgnoreEqualsLiveDataKt.C(hVar, false, new l<Boolean, VoiceGuideViewBehavior>() { // from class: com.android.incallui.oplus.answerview.view_model.FlingUpAnswerMethodModel$mVoiceAnswerGuideViewBehavior$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final VoiceGuideViewBehavior invoke(Boolean it) {
                i.e(it, "it");
                if (it.booleanValue()) {
                    return VoiceGuideViewBehavior.VOICE_GUIDE_VIEW_IN_VIDEO_MODE;
                }
                return VoiceGuideViewBehavior.VOICE_GUIDE_VIEW_IN_VOICE_MODE;
            }
        }, 1, null);
    }

    @Override // com.android.incallui.oplus.answerview.view_model.StaticAnswerMethodModel, com.android.incallui.oplus.answerview.view_model.AnswerMethodModel, androidx.lifecycle.I
    public void e() {
        super.e();
        this.f18859n.q(h().mIsVideoCall);
    }

    public final y<VoiceGuideViewBehavior> r() {
        return this.f18859n;
    }
}
