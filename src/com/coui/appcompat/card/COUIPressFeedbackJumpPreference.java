package com.coui.appcompat.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.preference.l;
import b9.C0532b;
import com.coui.appcompat.preference.COUIJumpPreference;
import com.coui.appcompat.pressfeedback.COUIPressFeedbackHelper;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: COUIPressFeedbackJumpPreference.kt */
/* loaded from: classes.dex */
public class COUIPressFeedbackJumpPreference extends COUIJumpPreference {
    private View rootView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIPressFeedbackJumpPreference(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$0(COUIPressFeedbackJumpPreference this$0, COUIPressFeedbackHelper pressFeedbackHelper, View view, MotionEvent event) {
        i.f(this$0, "this$0");
        i.f(pressFeedbackHelper, "$pressFeedbackHelper");
        i.f(view, "<anonymous parameter 0>");
        i.f(event, "event");
        View view2 = this$0.rootView;
        if (view2 != null && view2.isEnabled()) {
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    pressFeedbackHelper.executeFeedbackAnimator(false);
                }
            } else {
                pressFeedbackHelper.executeFeedbackAnimator(true);
            }
        }
        return false;
    }

    public final View getRootView() {
        return this.rootView;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        this.rootView = holder.itemView;
        final COUIPressFeedbackHelper cOUIPressFeedbackHelper = new COUIPressFeedbackHelper(this.rootView, 0);
        View view = this.rootView;
        if (view != null && view.isEnabled()) {
            View view2 = this.rootView;
            if (view2 != null) {
                view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.card.c
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view3, MotionEvent motionEvent) {
                        boolean onBindViewHolder$lambda$0;
                        onBindViewHolder$lambda$0 = COUIPressFeedbackJumpPreference.onBindViewHolder$lambda$0(COUIPressFeedbackJumpPreference.this, cOUIPressFeedbackHelper, view3, motionEvent);
                        return onBindViewHolder$lambda$0;
                    }
                });
                return;
            }
            return;
        }
        View view3 = this.rootView;
        if (view3 != null) {
            view3.setOnTouchListener(null);
        }
    }

    public final void setRootView(View view) {
        this.rootView = view;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIPressFeedbackJumpPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public COUIPressFeedbackJumpPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public /* synthetic */ COUIPressFeedbackJumpPreference(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? C0532b.f12347f : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIPressFeedbackJumpPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
    }
}
