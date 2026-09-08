package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageButton;
import com.coui.appcompat.pressfeedback.COUIPressFeedbackHelper;

/* compiled from: FeedbackButton.kt */
/* loaded from: classes.dex */
public final class FeedbackButton extends AppCompatImageButton {

    /* renamed from: a, reason: collision with root package name */
    public COUIPressFeedbackHelper f16025a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedbackButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer num;
        COUIPressFeedbackHelper cOUIPressFeedbackHelper;
        if (isEnabled()) {
            if (motionEvent != null) {
                num = Integer.valueOf(motionEvent.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                COUIPressFeedbackHelper cOUIPressFeedbackHelper2 = this.f16025a;
                if (cOUIPressFeedbackHelper2 != null) {
                    cOUIPressFeedbackHelper2.executeFeedbackAnimator(true);
                }
            } else if (((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) && (cOUIPressFeedbackHelper = this.f16025a) != null) {
                cOUIPressFeedbackHelper.executeFeedbackAnimator(false);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public /* synthetic */ FeedbackButton(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.i.f(context, "context");
        this.f16025a = new COUIPressFeedbackHelper(this, 2);
    }
}
