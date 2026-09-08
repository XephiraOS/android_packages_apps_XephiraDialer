package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.coui.appcompat.cardview.COUICardView;
import com.coui.appcompat.pressfeedback.COUIPressFeedbackHelper;

/* compiled from: FeedbackCardView.kt */
/* loaded from: classes.dex */
public final class FeedbackCardView extends COUICardView {

    /* renamed from: a, reason: collision with root package name */
    public COUIPressFeedbackHelper f16026a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(attrs, "attrs");
        init();
    }

    private final void init() {
        this.f16026a = new COUIPressFeedbackHelper(this, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer num;
        COUIPressFeedbackHelper cOUIPressFeedbackHelper;
        COUIPressFeedbackHelper cOUIPressFeedbackHelper2;
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            if (isEnabled() && (cOUIPressFeedbackHelper2 = this.f16026a) != null) {
                cOUIPressFeedbackHelper2.executeFeedbackAnimator(true);
            }
        } else if (((num != null && num.intValue() == 1) || (num != null && num.intValue() == 3)) && isEnabled() && (cOUIPressFeedbackHelper = this.f16026a) != null) {
            cOUIPressFeedbackHelper.executeFeedbackAnimator(false);
        }
        return super.onTouchEvent(motionEvent);
    }
}
