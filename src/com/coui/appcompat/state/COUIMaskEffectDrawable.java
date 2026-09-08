package com.coui.appcompat.state;

import B.a;
import X8.c;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.log.COUILog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class COUIMaskEffectDrawable extends StatefulDrawable {
    private static final float DEFAULT_MIN_PROGRESS_FOR_TOUCH_ENTER_ANIMATION = 0.7f;
    public static final float DEFAULT_SPRING_BOUNCE = 0.0f;
    public static final float DEFAULT_SPRING_RESPONSE = 0.3f;
    public static final int MASK_EFFECT_TYPE_CONTAINER_WIDGET = 1;
    public static final int MASK_EFFECT_TYPE_WIDGET_WITH_BACKGROUND = 0;
    private static final String TAG = "COUIMaskEffectDrawable";
    private boolean mAnimateEnabled;
    private boolean mEnableFocusedState;
    private boolean mEnableSelectedState;
    private final StateEffectAnimator mFocusAnimator;
    private final StateEffectAnimator mHoverAnimator;
    private StatefulDrawableListener mListener;
    private Path mMaskPath;
    private float mMaskRadiusX;
    private float mMaskRadiusY;
    private RectF mMaskRect;
    private int mMaskType;
    private float mMinProgressForTouchEnterAnimation;
    private final Paint mPaint;
    private final StateEffectAnimator mPressAnimator;
    private boolean mRoundStyle;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MaskEffectType {
    }

    public COUIMaskEffectDrawable(Context context, int i10) {
        super(TAG);
        this.mPaint = new Paint(1);
        this.mAnimateEnabled = true;
        this.mEnableSelectedState = true;
        this.mEnableFocusedState = true;
        this.mRoundStyle = true;
        this.mMaskRadiusX = 0.0f;
        this.mMaskRadiusY = 0.0f;
        this.mMinProgressForTouchEnterAnimation = DEFAULT_MIN_PROGRESS_FOR_TOUCH_ENTER_ANIMATION;
        this.mListener = null;
        this.mMaskType = i10;
        StateEffectAnimator stateEffectAnimator = new StateEffectAnimator(this, "hover", 0, COUIContextUtil.getAttrColor(context, c.f4414x));
        this.mHoverAnimator = stateEffectAnimator;
        StateEffectAnimator stateEffectAnimator2 = new StateEffectAnimator(this, "focus", 0, COUIContextUtil.getAttrColor(context, c.f4408u));
        this.mFocusAnimator = stateEffectAnimator2;
        StateEffectAnimator stateEffectAnimator3 = new StateEffectAnimator(this, "press", 0, COUIContextUtil.getAttrColor(context, c.f4345D));
        this.mPressAnimator = stateEffectAnimator3;
        stateEffectAnimator.setSpringResponse(0.3f);
        stateEffectAnimator.setSpringBounce(0.0f);
        stateEffectAnimator2.setSpringResponse(0.3f);
        stateEffectAnimator2.setSpringBounce(0.0f);
        stateEffectAnimator3.setSpringResponse(0.3f);
        stateEffectAnimator3.setSpringBounce(0.0f);
    }

    private void drawContainerWidgetType(Canvas canvas) {
        if (this.mHoverAnimator.getCurrentMaskColor() != 0) {
            this.mPaint.setColor(this.mHoverAnimator.getCurrentMaskColor());
            drawPathOrRect(canvas);
        }
        if (this.mFocusAnimator.getCurrentMaskColor() != 0) {
            this.mPaint.setColor(this.mFocusAnimator.getCurrentMaskColor());
            drawPathOrRect(canvas);
        }
        if (this.mPressAnimator.getCurrentMaskColor() != 0) {
            this.mPaint.setColor(this.mPressAnimator.getCurrentMaskColor());
            drawPathOrRect(canvas);
        }
    }

    private void drawPathOrRect(Canvas canvas) {
        float f10;
        Path path = this.mMaskPath;
        if (path != null) {
            canvas.drawPath(path, this.mPaint);
            return;
        }
        RectF rectF = this.mMaskRect;
        if (rectF != null) {
            canvas.drawRoundRect(rectF, this.mMaskRadiusX, this.mMaskRadiusY, this.mPaint);
            return;
        }
        Rect bounds = getBounds();
        if (this.mRoundStyle) {
            f10 = Math.max(0, Math.min(bounds.width(), bounds.height())) / 2.0f;
        } else {
            f10 = 0.0f;
        }
        float f11 = f10;
        canvas.drawRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, f11, f11, this.mPaint);
    }

    private void drawWidgetWithBackgroundType(Canvas canvas) {
        if (this.mHoverAnimator.getCurrentMaskColor() != 0) {
            this.mPaint.setColor(this.mHoverAnimator.getCurrentMaskColor());
            drawPathOrRect(canvas);
        }
        if (this.mPressAnimator.getCurrentMaskColor() != 0) {
            this.mPaint.setColor(this.mPressAnimator.getCurrentMaskColor());
            drawPathOrRect(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!isDrawableEnabled()) {
            return;
        }
        int i10 = this.mMaskType;
        if (i10 != 0) {
            if (i10 == 1) {
                drawContainerWidgetType(canvas);
                return;
            }
            return;
        }
        drawWidgetWithBackgroundType(canvas);
    }

    public void enableFocusedState(boolean z10) {
        this.mEnableFocusedState = z10;
    }

    public void enableSelectedState(boolean z10) {
        this.mEnableSelectedState = z10;
    }

    public int getCompositeMaskColor() {
        return a.q(this.mPressAnimator.getCurrentMaskColor(), a.q(this.mFocusAnimator.getCurrentMaskColor(), this.mHoverAnimator.getCurrentMaskColor()));
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        StatefulDrawableListener statefulDrawableListener = this.mListener;
        if (statefulDrawableListener != null) {
            statefulDrawableListener.onDrawableUpdate();
        }
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void onViewStateChanged(int i10) {
        float f10 = 0.0f;
        if (i10 == 16842910 && !isEnabled()) {
            this.mPressAnimator.animateToProgress(0.0f, false);
            this.mHoverAnimator.animateToProgress(0.0f, false);
            this.mFocusAnimator.animateToProgress(0.0f, false);
            return;
        }
        if (!isEnabled()) {
            return;
        }
        if (i10 == 1 && !isStateLocked(1)) {
            int touchType = getTouchType();
            if (touchType != 0) {
                if (touchType == 1) {
                    StateEffectAnimator stateEffectAnimator = this.mPressAnimator;
                    if (isTouchEntered()) {
                        f10 = 10000.0f;
                    }
                    stateEffectAnimator.animateToProgress(f10, false);
                    return;
                }
                return;
            }
            if (isTouchEntered()) {
                this.mPressAnimator.animateToProgress(10000.0f, true);
                return;
            } else {
                this.mPressAnimator.animateToProgressUntil(0.0f, this.mMinProgressForTouchEnterAnimation * 10000.0f);
                return;
            }
        }
        if (i10 == 16843623 && !isStateLocked(16843623)) {
            StateEffectAnimator stateEffectAnimator2 = this.mHoverAnimator;
            if (isHovered()) {
                f10 = 10000.0f;
            }
            stateEffectAnimator2.animateToProgress(f10, this.mAnimateEnabled);
            return;
        }
        if (this.mEnableFocusedState && i10 == 16842908 && !isStateLocked(16842908)) {
            if (this.mMaskType == 1) {
                StateEffectAnimator stateEffectAnimator3 = this.mFocusAnimator;
                if (isFocused()) {
                    f10 = 10000.0f;
                }
                stateEffectAnimator3.animateToProgress(f10, this.mAnimateEnabled);
                return;
            }
            return;
        }
        if (this.mEnableSelectedState && i10 == 16842913 && !isStateLocked(16842913) && this.mMaskType == 1) {
            StateEffectAnimator stateEffectAnimator4 = this.mFocusAnimator;
            if (isSelected()) {
                f10 = 10000.0f;
            }
            stateEffectAnimator4.animateToProgress(f10, this.mAnimateEnabled);
        }
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void refresh(Context context) {
        this.mHoverAnimator.setEndMaskColor(COUIContextUtil.getAttrColor(context, c.f4414x));
        this.mFocusAnimator.setEndMaskColor(COUIContextUtil.getAttrColor(context, c.f4408u));
        this.mPressAnimator.setEndMaskColor(COUIContextUtil.getAttrColor(context, c.f4345D));
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void reset() {
        this.mHoverAnimator.animateToProgress(0.0f, false);
        this.mFocusAnimator.animateToProgress(0.0f, false);
        this.mPressAnimator.animateToProgress(0.0f, false);
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void setAnimateEnabled(boolean z10) {
        this.mAnimateEnabled = z10;
    }

    @Override // com.coui.appcompat.state.StatefulDrawable, com.coui.appcompat.state.DrawableStateProxy
    public void setDrawableEnabled(boolean z10) {
        super.setDrawableEnabled(z10);
        if (!z10) {
            this.mPressAnimator.animateToProgress(0.0f, false);
            this.mHoverAnimator.animateToProgress(0.0f, false);
            this.mFocusAnimator.animateToProgress(0.0f, false);
        }
    }

    public void setFocusStateLocked(boolean z10, boolean z11, boolean z12) {
        setStateLocked(16842908, z10, z11, z12);
    }

    public void setHoverStateLocked(boolean z10, boolean z11, boolean z12) {
        setStateLocked(16843623, z10, z11, z12);
    }

    public void setIsRoundStyle(boolean z10) {
        this.mRoundStyle = z10;
    }

    public void setMaskPath(Path path) {
        this.mMaskPath = path;
    }

    public void setMaskRect(RectF rectF, float f10, float f11) {
        this.mMaskRect = rectF;
        this.mMaskRadiusX = f10;
        this.mMaskRadiusY = f11;
    }

    public void setMaskType(int i10) {
        this.mMaskType = i10;
    }

    public void setMinProgressForTouchEnterAnimation(float f10) {
        if (f10 >= 0.0f && f10 <= 1.0f) {
            this.mMinProgressForTouchEnterAnimation = f10;
        } else {
            COUILog.e(TAG, "Touch enter min progress should be within range [0, 1]");
        }
    }

    @Override // com.coui.appcompat.state.StatefulDrawable, com.coui.appcompat.state.DrawableStateProxy
    public void setStateLocked(int i10, boolean z10, boolean z11, boolean z12) {
        float f10;
        float f11;
        super.setStateLocked(i10, z10, z11, z12);
        float f12 = 0.0f;
        if (i10 == 1) {
            StateEffectAnimator stateEffectAnimator = this.mPressAnimator;
            if (z11) {
                f11 = 10000.0f;
            } else {
                f11 = 0.0f;
            }
            stateEffectAnimator.animateToProgress(f11, z12);
        }
        if (i10 == 16843623) {
            StateEffectAnimator stateEffectAnimator2 = this.mHoverAnimator;
            if (z11) {
                f10 = 10000.0f;
            } else {
                f10 = 0.0f;
            }
            stateEffectAnimator2.animateToProgress(f10, z12);
        }
        if (i10 == 16842908) {
            StateEffectAnimator stateEffectAnimator3 = this.mFocusAnimator;
            if (z11) {
                f12 = 10000.0f;
            }
            stateEffectAnimator3.animateToProgress(f12, z12);
        }
    }

    public void setStatefulDrawableListener(StatefulDrawableListener statefulDrawableListener) {
        this.mListener = statefulDrawableListener;
    }

    public void setTouchEnterStateLocked(boolean z10, boolean z11, boolean z12) {
        setStateLocked(1, z10, z11, z12);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
