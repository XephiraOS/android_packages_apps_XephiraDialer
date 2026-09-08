package com.coui.appcompat.preference;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.list.IListSelectedItem;
import com.coui.appcompat.state.COUIMaskEffectDrawable;
import com.coui.appcompat.state.COUIStateEffectDrawable;

/* loaded from: classes.dex */
public class ListSelectedItemLayout extends COUICheckedLinearLayout implements IListSelectedItem {

    @Deprecated
    protected static final int APPEAR_DURATION = 150;

    @Deprecated
    protected static final int DISAPPEAR_DURATION = 367;

    @Deprecated
    protected static final int STATE_BACKGROUND_APPEAR = 1;

    @Deprecated
    protected static final int STATE_BACKGROUND_DISAPPEAR = 2;

    @Deprecated
    protected Interpolator mAppearInterpolator;
    private boolean mBackgroundAnimationEnabled;

    @Deprecated
    protected ValueAnimator mBackgroundAppearAnimator;

    @Deprecated
    protected ValueAnimator mBackgroundDisappearAnimator;
    private boolean mConsumeDispatchingEventForState;

    @Deprecated
    protected Interpolator mDisappearInterpolator;
    private final RectF mLayoutRect;
    private COUIMaskEffectDrawable mMaskDrawable;

    @Deprecated
    protected boolean mNeedAutoStartDisAppear;

    @Deprecated
    protected int mState;
    private COUIStateEffectDrawable mStateEffectBackground;

    public ListSelectedItemLayout(Context context) {
        this(context, null);
    }

    private void handlePressAnimationInternal(MotionEvent motionEvent) {
        if (isEnabled() && isClickable() && this.mBackgroundAnimationEnabled) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    startDisAppearAnimationOrNot();
                    return;
                }
                return;
            }
            startAppearAnimation();
        }
    }

    private void initStateEffectBackground() {
        Drawable background;
        this.mMaskDrawable = new COUIMaskEffectDrawable(getContext(), 1);
        Path layoutPath = getLayoutPath();
        if (layoutPath != null) {
            this.mMaskDrawable.setMaskPath(layoutPath);
        } else {
            this.mMaskDrawable.setMaskRect(this.mLayoutRect, 0.0f, 0.0f);
        }
        if (getBackground() == null) {
            background = new ColorDrawable(0);
        } else {
            background = getBackground();
        }
        COUIStateEffectDrawable cOUIStateEffectDrawable = new COUIStateEffectDrawable(new Drawable[]{background, this.mMaskDrawable});
        this.mStateEffectBackground = cOUIStateEffectDrawable;
        cOUIStateEffectDrawable.setAnimateEnabled(this.mBackgroundAnimationEnabled);
        super.setBackground(this.mStateEffectBackground);
    }

    public void consumeDispatchingEventForState(boolean z10) {
        this.mConsumeDispatchingEventForState = z10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mConsumeDispatchingEventForState) {
            if (isEnabled() && motionEvent.getActionMasked() == 9) {
                this.mMaskDrawable.setHoverStateLocked(true, true, true);
            }
            if (motionEvent.getActionMasked() == 10) {
                this.mMaskDrawable.setHoverStateLocked(false, false, true);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mConsumeDispatchingEventForState) {
            handlePressAnimationInternal(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Path getLayoutPath() {
        return null;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mLayoutRect.set(0.0f, 0.0f, i10, i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mConsumeDispatchingEventForState) {
            handlePressAnimationInternal(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void refresh() {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            cOUIStateEffectDrawable.refresh(getContext());
        }
        COUIMaskEffectDrawable cOUIMaskEffectDrawable = this.mMaskDrawable;
        if (cOUIMaskEffectDrawable != null) {
            cOUIMaskEffectDrawable.refresh(getContext());
        }
    }

    public void resetBackgroundAnimation() {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            cOUIStateEffectDrawable.reset();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            if (drawable == null) {
                cOUIStateEffectDrawable.setViewBackground(new ColorDrawable(0));
                return;
            } else {
                cOUIStateEffectDrawable.setViewBackground(drawable);
                return;
            }
        }
        super.setBackground(drawable);
    }

    public void setBackgroundAnimationEnabled(boolean z10) {
        this.mBackgroundAnimationEnabled = z10;
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable == null) {
            return;
        }
        cOUIStateEffectDrawable.setAnimateEnabled(z10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (!z10 && isEnabled()) {
            startDisAppearAnimationOrNot();
        }
        super.setEnabled(z10);
    }

    public void setPressScaleEffectEnable(boolean z10) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable == null) {
            return;
        }
        if (z10) {
            cOUIStateEffectDrawable.enableScaleEffect(this);
        } else {
            cOUIStateEffectDrawable.disableScaleEffect();
        }
    }

    public void startAppearAnimation(boolean z10) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable == null) {
            return;
        }
        if (!z10) {
            cOUIStateEffectDrawable.setAnimateEnabled(false);
        }
        this.mStateEffectBackground.setTouched(true);
        if (z10) {
            return;
        }
        this.mStateEffectBackground.setAnimateEnabled(true);
    }

    public void startDisAppearAnimationOrNot(boolean z10) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable == null) {
            return;
        }
        if (!z10) {
            cOUIStateEffectDrawable.setAnimateEnabled(false);
        }
        this.mStateEffectBackground.setTouched(false);
        if (z10) {
            return;
        }
        this.mStateEffectBackground.setAnimateEnabled(true);
    }

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListSelectedItemLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mLayoutRect = new RectF();
        this.mBackgroundAnimationEnabled = true;
        this.mConsumeDispatchingEventForState = false;
        this.mNeedAutoStartDisAppear = false;
        this.mState = 2;
        this.mDisappearInterpolator = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
        this.mAppearInterpolator = new COUILinearInterpolator();
        initStateEffectBackground();
        setDefaultFocusHighlightEnabled(false);
    }

    public void startAppearAnimation() {
        startAppearAnimation(true);
    }

    public void startDisAppearAnimationOrNot() {
        startDisAppearAnimationOrNot(true);
    }

    @Deprecated
    public void initAnimation(Context context) {
    }

    @Deprecated
    public void setBackgroundAnimationDrawable(Drawable drawable) {
    }
}
