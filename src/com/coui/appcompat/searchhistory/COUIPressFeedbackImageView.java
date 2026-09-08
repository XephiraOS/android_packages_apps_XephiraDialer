package com.coui.appcompat.searchhistory;

import a9.l;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.RippleDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;

/* compiled from: COUIPressFeedbackImageView.kt */
/* loaded from: classes.dex */
public final class COUIPressFeedbackImageView extends AppCompatImageView {
    public static final Companion Companion = new Companion(null);
    private static final float DEFAULT_SCALE_MIN_PERCENT = 0.8f;
    private static final float DEFAULT_SCALE_MIN_VALUE = 0.9f;
    private static final long PRESS_FEEDBACK_ANIMATION_DURATION = 200;
    private static final long RELEASE_FEEDBACK_ANIMATION_DURATION = 340;
    private final com.google.android.material.chip.a chipDrawable;
    private float currentScale;
    private boolean isNeedToDelayCancelScaleAnim;
    private final int[] location;
    private boolean mAnimatorPressed;
    private final COUIMoveEaseInterpolator scaleAnimationInterpolator;
    private ValueAnimator scaleAnimator;

    /* compiled from: COUIPressFeedbackImageView.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIPressFeedbackImageView(Context context) {
        super(context);
        kotlin.jvm.internal.i.f(context, "context");
        com.google.android.material.chip.a l10 = com.google.android.material.chip.a.l(context, null, 0, l.f6694B);
        kotlin.jvm.internal.i.e(l10, "createFromAttributes(con….Widget_COUI_Chip_Record)");
        this.chipDrawable = l10;
        this.currentScale = 1.0f;
        this.scaleAnimationInterpolator = new COUIMoveEaseInterpolator();
        this.location = new int[2];
        RippleDrawable rippleDrawable = new RippleDrawable(v4.b.d(l10.V()), l10, null);
        l10.D1(false);
        setBackground(rippleDrawable);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.searchhistory.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = COUIPressFeedbackImageView._init_$lambda$0(COUIPressFeedbackImageView.this, view, motionEvent);
                return _init_$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(COUIPressFeedbackImageView this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(motionEvent, "motionEvent");
        if (!this$0.isTouchAreaInViewArea(motionEvent)) {
            this$0.mAnimatorPressed = false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                this$0.mAnimatorPressed = false;
                this$0.executeScaleAnimator(false);
            }
        } else {
            this$0.mAnimatorPressed = true;
            this$0.executeScaleAnimator(true);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r7 < (((float) r2) * com.coui.appcompat.searchhistory.COUIPressFeedbackImageView.DEFAULT_SCALE_MIN_PERCENT)) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void cancelAnimator(boolean r7) {
        /*
            r6 = this;
            android.animation.ValueAnimator r0 = r6.scaleAnimator
            if (r0 == 0) goto L3a
            if (r0 == 0) goto L3a
            boolean r0 = r0.isRunning()
            r1 = 1
            if (r0 != r1) goto L3a
            if (r7 != 0) goto L2e
            android.animation.ValueAnimator r7 = r6.scaleAnimator
            r2 = 0
            if (r7 == 0) goto L1a
            long r4 = r7.getCurrentPlayTime()
            goto L1b
        L1a:
            r4 = r2
        L1b:
            float r7 = (float) r4
            android.animation.ValueAnimator r0 = r6.scaleAnimator
            if (r0 == 0) goto L24
            long r2 = r0.getDuration()
        L24:
            float r0 = (float) r2
            r2 = 1061997773(0x3f4ccccd, float:0.8)
            float r0 = r0 * r2
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L2e
            goto L2f
        L2e:
            r1 = 0
        L2f:
            r6.isNeedToDelayCancelScaleAnim = r1
            if (r1 != 0) goto L3a
            android.animation.ValueAnimator r6 = r6.scaleAnimator
            if (r6 == 0) goto L3a
            r6.cancel()
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.searchhistory.COUIPressFeedbackImageView.cancelAnimator(boolean):void");
    }

    private final void executeScaleAnimator(final boolean z10) {
        float f10;
        long j10;
        this.isNeedToDelayCancelScaleAnim = false;
        cancelAnimator(z10);
        if (this.isNeedToDelayCancelScaleAnim) {
            return;
        }
        float f11 = 1.0f;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = this.currentScale;
        }
        if (z10) {
            f11 = 0.9f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        this.scaleAnimator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setInterpolator(this.scaleAnimationInterpolator);
        }
        ValueAnimator valueAnimator = this.scaleAnimator;
        if (valueAnimator != null) {
            if (z10) {
                j10 = 200;
            } else {
                j10 = 340;
            }
            valueAnimator.setDuration(j10);
        }
        ValueAnimator valueAnimator2 = this.scaleAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.searchhistory.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    COUIPressFeedbackImageView.executeScaleAnimator$lambda$1(COUIPressFeedbackImageView.this, z10, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.scaleAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeScaleAnimator$lambda$1(COUIPressFeedbackImageView this$0, boolean z10, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        long currentPlayTime = valueAnimator.getCurrentPlayTime();
        Object animatedValue = valueAnimator.getAnimatedValue();
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.currentScale = ((Float) animatedValue).floatValue();
        if (this$0.isNeedToDelayCancelScaleAnim && z10 && ((float) currentPlayTime) > ((float) valueAnimator.getDuration()) * DEFAULT_SCALE_MIN_PERCENT) {
            valueAnimator.cancel();
            this$0.executeScaleAnimator(false);
        } else {
            this$0.setScale(this$0.currentScale);
        }
    }

    private final boolean isTouchAreaInViewArea(MotionEvent motionEvent) {
        getLocationOnScreen(this.location);
        if (motionEvent.getRawX() <= this.location[0] || motionEvent.getRawX() >= this.location[0] + getWidth() || motionEvent.getRawY() <= this.location[1] || motionEvent.getRawY() >= this.location[1] + getHeight()) {
            return false;
        }
        return true;
    }

    private final void setScale(float f10) {
        float d10;
        float a10;
        d10 = B9.i.d(1.0f, f10);
        a10 = B9.i.a(0.9f, d10);
        setScaleX(a10);
        setScaleY(a10);
    }
}
