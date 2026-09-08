package com.coui.appcompat.progressbar;

import X8.o;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.K;

/* loaded from: classes.dex */
public class COUILoadProgress extends AppCompatButton {
    public static final int DEFAULT_UP_OR_DOWN = 0;
    public static final int INSTALL_HAVE_GIFT = 4;
    private static final float ONE = 1.0f;
    private static final float ONE_MILLION = 1.0E-7f;
    private static final int PROGRESS_ANIM_DURATION = 80;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 10;
    public static final int UPING_OR_DOWNING = 1;
    public static final int UP_OR_DOWN_FAIL = 3;
    public static final int UP_OR_DOWN_WAIT = 2;
    private final boolean DEBUG;
    private final String TAG;
    private AccessibilityEventSender mAccessibilityEventSender;
    private boolean mBroadcasting;
    protected Drawable mButtonDrawable;
    protected Drawable mButtonDrawableReverseColor;
    private int mButtonResource;
    private Context mContext;
    protected boolean mIsUpdateWithAnimation;
    private final AccessibilityManager mManager;
    public int mMax;
    private OnStateChangeListener mOnStateChangeListener;
    private OnStateChangeListener mOnStateChangeWidgetListener;
    public int mProgress;
    public int mState;
    protected float mVisualProgress;
    private ValueAnimator mVisualProgressAnimator;
    private static final DecelerateInterpolator PROGRESS_ANIM_INTERPOLATOR = new DecelerateInterpolator();
    private static final int[] DEFAULT_SET = {X8.c.f4405s0};
    private static final int[] WAIT_SET = {X8.c.f4413w0};
    private static final int[] FAIL_SET = {X8.c.f4407t0};
    private static final int[] ING_SET = {X8.c.f4409u0};

    /* loaded from: classes.dex */
    public class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUILoadProgress.this.sendAccessibilityEvent(4);
        }
    }

    /* loaded from: classes.dex */
    public interface OnStateChangeListener {
        void onStateChanged(COUILoadProgress cOUILoadProgress, int i10);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.progressbar.COUILoadProgress.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        int mProgress;
        int mState;

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " mState = " + this.mState + " mProgress = " + this.mProgress + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.mState));
            parcel.writeValue(Integer.valueOf(this.mProgress));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mState = ((Integer) parcel.readValue(null)).intValue();
            this.mProgress = ((Integer) parcel.readValue(null)).intValue();
        }
    }

    public COUILoadProgress(Context context) {
        this(context, null);
    }

    private void init() {
        this.mProgress = 0;
        this.mMax = 100;
    }

    private void refreshProgressWithAnim() {
        ValueAnimator valueAnimator = this.mVisualProgressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mVisualProgressAnimator = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.mVisualProgress, this.mProgress * 1.0f);
        this.mVisualProgressAnimator = ofFloat;
        ofFloat.setDuration(80L);
        this.mVisualProgressAnimator.setInterpolator(PROGRESS_ANIM_INTERPOLATOR);
        this.mVisualProgressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.COUILoadProgress.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUILoadProgress.this.mVisualProgress = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                COUILoadProgress.this.invalidate();
            }
        });
        this.mVisualProgressAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.progressbar.COUILoadProgress.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUILoadProgress.this.mIsUpdateWithAnimation = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUILoadProgress cOUILoadProgress = COUILoadProgress.this;
                cOUILoadProgress.mIsUpdateWithAnimation = false;
                cOUILoadProgress.onProgressRefresh(cOUILoadProgress.mProgress);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUILoadProgress.this.mIsUpdateWithAnimation = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mVisualProgressAnimator.start();
    }

    private void scheduleAccessibilityEventSender() {
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.mAccessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        postDelayed(this.mAccessibilityEventSender, 10L);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mButtonDrawable != null) {
            this.mButtonDrawable.setState(getDrawableState());
            invalidate();
        }
    }

    public int getMax(int i10) {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public int getState() {
        return this.mState;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mButtonDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (getState() == 0) {
            View.mergeDrawableStates(onCreateDrawableState, DEFAULT_SET);
        }
        if (getState() == 1) {
            View.mergeDrawableStates(onCreateDrawableState, ING_SET);
        }
        if (getState() == 2) {
            View.mergeDrawableStates(onCreateDrawableState, WAIT_SET);
        }
        if (getState() == 3) {
            View.mergeDrawableStates(onCreateDrawableState, FAIL_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void onProgressRefresh(int i10) {
        AccessibilityManager accessibilityManager = this.mManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && J.c.b(this.mManager)) {
            scheduleAccessibilityEventSender();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.mState);
        setProgress(savedState.mProgress);
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        setFreezesText(true);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mState = getState();
        savedState.mProgress = this.mProgress;
        return savedState;
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setButtonDrawable(int i10) {
        if (i10 == 0 || i10 != this.mButtonResource) {
            this.mButtonResource = i10;
            setButtonDrawable(i10 != 0 ? getResources().getDrawable(this.mButtonResource) : null);
        }
    }

    public void setMax(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 != this.mMax) {
            this.mMax = i10;
            if (this.mProgress > i10) {
                this.mProgress = i10;
            }
            invalidate();
        }
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeListener = onStateChangeListener;
    }

    public void setOnStateChangeWidgetListener(OnStateChangeListener onStateChangeListener) {
        this.mOnStateChangeWidgetListener = onStateChangeListener;
    }

    public void setProgress(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = this.mMax;
        if (i10 > i11) {
            i10 = i11;
        }
        if (i10 != this.mProgress) {
            this.mProgress = i10;
        }
        if (this.mIsUpdateWithAnimation) {
            this.mIsUpdateWithAnimation = false;
        }
        invalidate();
        onProgressRefresh(i10);
    }

    public void setState(int i10) {
        if (this.mState != i10) {
            this.mState = i10;
            refreshDrawableState();
            if (this.mBroadcasting) {
                return;
            }
            this.mBroadcasting = true;
            OnStateChangeListener onStateChangeListener = this.mOnStateChangeListener;
            if (onStateChangeListener != null) {
                onStateChangeListener.onStateChanged(this, this.mState);
            }
            OnStateChangeListener onStateChangeListener2 = this.mOnStateChangeWidgetListener;
            if (onStateChangeListener2 != null) {
                onStateChangeListener2.onStateChanged(this, this.mState);
            }
            this.mBroadcasting = false;
        }
    }

    public void toggle() {
        int i10 = this.mState;
        if (i10 == 0) {
            setState(1);
            return;
        }
        if (i10 == 1) {
            setState(2);
        } else if (i10 == 2) {
            setState(1);
        } else if (i10 == 3) {
            setState(1);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mButtonDrawable) {
            return false;
        }
        return true;
    }

    public COUILoadProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4361T);
    }

    public int getMax() {
        return this.mMax;
    }

    public COUILoadProgress(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.TAG = "COUILoadProgress";
        this.DEBUG = false;
        this.mIsUpdateWithAnimation = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5210T2, i10, 0);
        int integer = obtainStyledAttributes.getInteger(o.f5234W2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(o.f5218U2);
        if (drawable != null) {
            setButtonDrawable(drawable);
        }
        setProgress(obtainStyledAttributes.getInt(o.f5226V2, this.mProgress));
        setState(integer);
        obtainStyledAttributes.recycle();
        init();
        if (K.t(this) == 0) {
            K.t0(this, 1);
        }
        this.mManager = (AccessibilityManager) context.getSystemService("accessibility");
    }

    public void setButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            Drawable drawable2 = this.mButtonDrawable;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.mButtonDrawable);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
            this.mButtonDrawable = drawable;
            this.mButtonDrawableReverseColor = drawable.getConstantState().newDrawable();
            this.mButtonDrawable.setState(null);
            setMinHeight(this.mButtonDrawable.getIntrinsicHeight());
            refreshDrawableState();
            return;
        }
        this.mButtonDrawable = null;
        this.mButtonDrawableReverseColor = null;
        this.mButtonResource = 0;
    }

    public void setProgress(int i10, boolean z10) {
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = this.mMax;
        if (i10 > i11) {
            i10 = i11;
        }
        int i12 = this.mProgress;
        if (i10 != i12) {
            this.mVisualProgress = i12 * 1.0f;
            this.mProgress = i10;
        }
        if (Math.abs(this.mVisualProgress - this.mProgress) > ONE_MILLION) {
            refreshProgressWithAnim();
        }
    }
}
