package com.android.incallui.oplus.answerview.protocol;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import com.android.incallui.R;
import com.android.incallui.oplus.answerview.protocol.a;
import g2.InterfaceC1034a;
import kotlin.jvm.internal.f;

/* compiled from: AnswerViewBehavior.kt */
/* loaded from: classes.dex */
public enum VoiceGuideViewBehavior implements a {
    VOICE_GUIDE_VIEW_IN_VOICE_MODE(R.color.incall_answer_view_voice_guide_view_tint, 0.0f, 2, null),
    VOICE_GUIDE_VIEW_IN_VIDEO_MODE(R.color.incall_answer_view_voice_guide_view_tint_in_video_mode, 0.3f);

    private final float mTintAlpha;
    private final int mTintColor;

    VoiceGuideViewBehavior(int i10, float f10) {
        this.mTintColor = i10;
        this.mTintAlpha = f10;
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void a(Context context, InterfaceC1034a interfaceC1034a, int i10) {
        a.C0183a.a(this, context, interfaceC1034a, i10);
    }

    @Override // com.android.incallui.oplus.answerview.protocol.a
    public void b(View view) {
        ImageView imageView;
        Context context;
        ColorStateList colorStateList = null;
        if (view instanceof ImageView) {
            imageView = (ImageView) view;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            if (view != null && (context = view.getContext()) != null) {
                colorStateList = ColorStateList.valueOf(context.getColor(this.mTintColor));
            }
            imageView.setImageTintList(colorStateList);
        }
    }

    public final float d() {
        return this.mTintAlpha;
    }

    /* synthetic */ VoiceGuideViewBehavior(int i10, float f10, int i11, f fVar) {
        this(i10, (i11 & 2) != 0 ? 1.0f : f10);
    }
}
