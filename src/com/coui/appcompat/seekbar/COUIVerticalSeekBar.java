package com.coui.appcompat.seekbar;

import J.d;
import a9.m;
import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.AbsSeekBar;
import androidx.core.view.K;
import c4.g;
import c4.h;
import c4.l;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.roundcorner.RoundCornerUtil;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.google.android.material.internal.ViewUtils;
import com.oplus.graphics.OplusCanvas;
import com.oplus.graphics.OplusPath;
import com.oplus.os.LinearmotorVibrator;
import i8.InterfaceC1105a;
import i8.j;
import i8.k;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class COUIVerticalSeekBar extends AbsSeekBar implements InterfaceC1105a, i8.b {
    private static final float BACKGROUND_RADIUS_SCALE = 6.0f;
    private static final long BUTTON_DEFORMATION_ANIM_DURATION = 350;
    private static final int DAMPING_DISTANCE = 20;
    private static final double DEFORMATION_FORMULA_CONSTANT = -11.5d;
    private static final int DURATION_150 = 150;
    private static final int DURATION_483 = 483;
    private static final int FAST_MOVE_VELOCITY = 95;
    private static final String HOLDER_SCALE = "HOLDER_SCALE";
    private static final float MAX_FAST_MOVE_PERCENT = 0.95f;
    private static final float MAX_MOVE_DAMPING = 0.4f;
    private static final int MAX_VELOCITY = 8000;
    private static final float MIN_FAST_MOVE_PERCENT = 0.05f;
    public static final int MOVE_BY_DEFAULT = 0;
    public static final int MOVE_BY_DISTANCE = 2;
    public static final int MOVE_BY_FINGER = 1;
    private static final int ONE_SECOND_UNITS = 1000;
    private static final int PHYSICAL_VELOCITY_LIMIT = 100;
    private static final float PROGRESS_RADIUS_SCALE = 4.0f;
    protected static final int RELEASE_ANIM_DURATION = 183;
    private static final float SCALE_DEFORMATION_MAX = 2.0f;
    private static final float SCALE_DEFORMATION_MIN = -1.0f;
    private static final int SCALE_DEFORMATION_TIMES = 5;
    private static final float SCALE_MAX = 1.0f;
    private static final float SCALE_MIN = 0.0f;
    private static final String TAG = "COUIVerticalSeekBar";
    private static final float TEXT_SHADOW_DX = 0.0f;
    private static final float TEXT_SHADOW_DY = 8.0f;
    private static final float TEXT_SHADOW_RADIUS = 25.0f;
    private static final float TEXT_SIZE = 12.0f;
    private static final int TOUCH_ANIMATION_ENLARGE_DURATION = 183;
    public static final int TYPE_ENLARGE = 1;
    public static final int TYPE_NORMAL = 0;
    private static final int VELOCITY_COMPUTE_TIME = 100;
    protected int mBackgroundColor;
    protected ColorStateList mBackgroundColorStateList;
    protected float mBackgroundEnlargeScale;
    protected Paint mBackgroundPaint;
    private Path mBackgroundPath;
    protected float mBackgroundRadius;
    protected float mBackgroundRadiusEnlargeScale;
    protected Rect mBackgroundRect;
    protected float mBackgroundRoundCornerWeight;
    protected float mBackgroundWidth;
    private ValueAnimator mButtonDeformationAnimator;
    protected ValueAnimator mClickAnimator;
    protected Path mClipProgressPath;
    protected Rect mClipProgressRect;
    protected float mCurBackgroundRadius;
    protected float mCurBackgroundWidth;
    protected float mCurBottomDeformationValue;
    protected float mCurPaddingVertical;
    protected float mCurProgressRadius;
    protected float mCurProgressWidth;
    protected float mCurTopDeformationValue;
    protected float mCustomProgressAnimDuration;
    private Interpolator mCustomProgressAnimInterpolator;
    private float mDamping;
    private float mDefaultPaddingVertical;
    protected boolean mEnableAdaptiveVibrator;
    private boolean mEnableCustomEnlarge;
    protected boolean mEnableVibrator;
    private ValueAnimator mEnlargeAnimator;
    private PatternExploreByTouchHelper mExploreByTouchHelper;
    private float mFastMoveScaleOffsetY;
    private g mFastMoveSpring;
    private h mFastMoveSpringConfig;
    private i8.h mFlingBehavior;
    private float mFlingDampingRatio;
    private float mFlingFrequency;
    private float mFlingLinearDamping;
    private j mFlingValueHolder;
    private float mFlingVelocity;
    private Paint.FontMetricsInt mFmi;
    private boolean mHasEnlarge;
    protected boolean mHasMotorVibrator;
    protected float mHeightBottomDeformedDownValue;
    protected float mHeightBottomDeformedUpValue;
    protected float mHeightTopDeformedDownValue;
    protected float mHeightTopDeformedUpValue;
    private Drawable mInactiveTrackDrawable;
    private int mIncrement;
    private Interpolator mInterpolator;
    protected boolean mIsDragging;
    private boolean mIsPhysicsEnable;
    private boolean mIsProgressFull;
    private boolean mIsSupportDeformation;
    protected boolean mIsSupportSmoothRoundCorner;
    protected float mLastY;
    protected Object mLinearMotorVibrator;
    protected int mMax;
    private float mMaxBottomHeightDeformedValue;
    private int mMaxBottomMovingDistance;
    private int mMaxHeight;
    private float mMaxTopHeightDeformedValue;
    private int mMaxTopMovingDistance;
    private float mMaxWidthDeformedValue;
    protected int mMin;
    private int mMoveType;
    protected int mOldProgress;
    private OnDeformedListener mOnDeformedListener;
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    protected float mPaddingVertical;
    private k mPhysicalAnimator;
    private float mPixPerProgress;
    protected int mProgress;
    protected int mProgressColor;
    protected ColorStateList mProgressColorStateList;
    private String mProgressContentDescription;
    protected float mProgressEnlargeScale;
    protected Paint mProgressPaint;
    protected float mProgressRadius;
    protected float mProgressRadiusEnlargeScale;
    protected Rect mProgressRect;
    protected float mProgressRoundCornerWeight;
    protected float mProgressWidth;
    private int mRealProgress;
    private int mRefreshStyle;
    private ValueAnimator mReleaseAnimator;
    protected float mScale;
    private int mSeekbarMinWidth;
    protected boolean mShowProgress;
    private boolean mShowText;
    protected boolean mShowThumb;
    private boolean mStartDragging;
    protected Rect mTempRect;
    private int mTextColor;
    private String mTextContent;
    private TextDrawable mTextDrawable;
    protected float mTextMarginTop;
    private TextPaint mTextPaint;
    private Bitmap mThumbBitmap;
    protected int mThumbColor;
    protected ColorStateList mThumbColorStateList;
    protected float mThumbOutRadius;
    protected float mThumbOutRoundCornerWeight;
    protected float mThumbOutWidth;
    protected Paint mThumbPaint;
    private float mThumbPosition;
    protected float mTouchDownY;
    protected ValueAnimator mTouchEnlargeAnimator;
    protected ValueAnimator mTouchReleaseAnimator;
    protected int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    protected float mVerticalPaddingScale;
    private ExecutorService mVibratorExecutor;
    private float mWidthDeformedValue;
    private static final Interpolator THUMB_ANIMATE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private static final Interpolator PROGRESS_SCALE_INTERPOLATOR = new COUIEaseInterpolator();

    /* loaded from: classes.dex */
    public interface OnSeekBarChangeListener {
        void onProgressChanged(COUIVerticalSeekBar cOUIVerticalSeekBar, int i10, boolean z10);

        void onStartTrackingTouch(COUIVerticalSeekBar cOUIVerticalSeekBar);

        void onStopTrackingTouch(COUIVerticalSeekBar cOUIVerticalSeekBar);
    }

    /* loaded from: classes.dex */
    public final class PatternExploreByTouchHelper extends androidx.customview.widget.a {
        private Rect mTempRect;

        public PatternExploreByTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
        }

        private Rect getBoundsForVirtualView(int i10) {
            Rect rect = this.mTempRect;
            rect.left = 0;
            rect.top = 0;
            rect.right = COUIVerticalSeekBar.this.getWidth();
            rect.bottom = COUIVerticalSeekBar.this.getHeight();
            return rect;
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            if (f10 >= 0.0f && f10 <= COUIVerticalSeekBar.this.getWidth() && f11 >= 0.0f && f11 <= COUIVerticalSeekBar.this.getHeight()) {
                return 0;
            }
            return -1;
        }

        @Override // androidx.customview.widget.a
        public void getVisibleVirtualViews(List<Integer> list) {
            list.add(0);
        }

        @Override // androidx.customview.widget.a, androidx.core.view.C0446a
        public void onInitializeAccessibilityNodeInfo(View view, J.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.b(d.a.f1379L);
            dVar.B0(d.g.a(1, COUIVerticalSeekBar.this.getMin(), COUIVerticalSeekBar.this.getMax(), COUIVerticalSeekBar.this.mProgress));
            if (COUIVerticalSeekBar.this.isEnabled()) {
                int progress = COUIVerticalSeekBar.this.getProgress();
                if (progress > COUIVerticalSeekBar.this.getMin()) {
                    dVar.a(8192);
                }
                if (progress < COUIVerticalSeekBar.this.getMax()) {
                    dVar.a(4096);
                }
            }
        }

        @Override // androidx.customview.widget.a
        public boolean onPerformActionForVirtualView(int i10, int i11, Bundle bundle) {
            sendEventForVirtualView(i10, 4);
            return false;
        }

        @Override // androidx.core.view.C0446a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.customview.widget.a
        public void onPopulateEventForVirtualView(int i10, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.getText().add(PatternExploreByTouchHelper.class.getSimpleName());
            accessibilityEvent.setItemCount(COUIVerticalSeekBar.this.getMax() - COUIVerticalSeekBar.this.getMin());
            accessibilityEvent.setCurrentItemIndex(COUIVerticalSeekBar.this.getProgress());
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, J.d dVar) {
            dVar.l0("");
            dVar.h0(COUIVerticalSeekBar.class.getName());
            dVar.c0(getBoundsForVirtualView(i10));
        }

        @Override // androidx.core.view.C0446a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            if (!COUIVerticalSeekBar.this.isEnabled()) {
                return false;
            }
            if (i10 != 4096) {
                if (i10 != 8192) {
                    return false;
                }
                COUIVerticalSeekBar cOUIVerticalSeekBar = COUIVerticalSeekBar.this;
                cOUIVerticalSeekBar.setProgress(cOUIVerticalSeekBar.getProgress() - COUIVerticalSeekBar.this.mIncrement, false, true);
                COUIVerticalSeekBar cOUIVerticalSeekBar2 = COUIVerticalSeekBar.this;
                cOUIVerticalSeekBar2.announceForAccessibility(cOUIVerticalSeekBar2.mProgressContentDescription);
                return true;
            }
            COUIVerticalSeekBar cOUIVerticalSeekBar3 = COUIVerticalSeekBar.this;
            cOUIVerticalSeekBar3.setProgress(cOUIVerticalSeekBar3.getProgress() + COUIVerticalSeekBar.this.mIncrement, false, true);
            COUIVerticalSeekBar cOUIVerticalSeekBar4 = COUIVerticalSeekBar.this;
            cOUIVerticalSeekBar4.announceForAccessibility(cOUIVerticalSeekBar4.mProgressContentDescription);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.seekbar.COUIVerticalSeekBar.SavedState.1
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
        int mSaveProgress;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.mSaveProgress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mSaveProgress = parcel.readInt();
        }
    }

    public COUIVerticalSeekBar(Context context) {
        this(context, null);
    }

    private void attemptClaimDrag() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean bottomDeformedChange() {
        if (this.mIsSupportDeformation) {
            float heightBottomDeformedValue = getHeightBottomDeformedValue();
            if (this.mCurBottomDeformationValue != heightBottomDeformedValue) {
                this.mCurBottomDeformationValue = heightBottomDeformedValue;
                return true;
            }
            return false;
        }
        return false;
    }

    private float calculateDamping() {
        float f10 = this.mDamping;
        if (f10 != 0.0f) {
            return f10;
        }
        return MAX_MOVE_DAMPING;
    }

    private void calculateFlingDeformationValue(float f10) {
        if (f10 > 1.0f) {
            double d10 = f10 - 1.0f;
            this.mHeightBottomDeformedUpValue = computeValue(d10, this.mMaxBottomMovingDistance);
            this.mHeightTopDeformedUpValue = computeValue(d10, this.mMaxTopMovingDistance + this.mMaxTopHeightDeformedValue);
            this.mWidthDeformedValue = computeValue(d10, this.mMaxWidthDeformedValue);
            heightDeformedChanged();
            return;
        }
        if (f10 < 0.0f) {
            double abs = Math.abs(f10);
            this.mHeightTopDeformedDownValue = computeValue(abs, this.mMaxTopMovingDistance);
            this.mHeightBottomDeformedDownValue = computeValue(abs, this.mMaxBottomMovingDistance + this.mMaxBottomHeightDeformedValue);
            this.mWidthDeformedValue = computeValue(abs, this.mMaxWidthDeformedValue);
            heightDeformedChanged();
            return;
        }
        resetDeformationValue();
    }

    private void calculateTouchDeformationValue() {
        float f10 = this.mScale;
        if (f10 >= 1.0f) {
            double d10 = (f10 - 1.0f) / 5.0f;
            this.mHeightBottomDeformedUpValue = computeValue(d10, this.mMaxBottomMovingDistance);
            this.mHeightTopDeformedUpValue = computeValue(d10, this.mMaxTopMovingDistance + this.mMaxTopHeightDeformedValue);
            this.mWidthDeformedValue = computeValue(d10, this.mMaxWidthDeformedValue);
            heightDeformedChanged();
            return;
        }
        if (f10 <= 0.0f) {
            double abs = Math.abs(f10) / 5.0f;
            this.mHeightTopDeformedDownValue = computeValue(abs, this.mMaxTopMovingDistance);
            this.mHeightBottomDeformedDownValue = computeValue(abs, this.mMaxBottomMovingDistance + this.mMaxBottomHeightDeformedValue);
            this.mWidthDeformedValue = computeValue(abs, this.mMaxWidthDeformedValue);
            heightDeformedChanged();
        }
    }

    private void cancelAnim(ValueAnimator valueAnimator) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
    }

    private void clearDeformationValue() {
        int i10 = this.mProgress;
        if (i10 > this.mMin && i10 < this.mMax) {
            resetDeformationValue();
        }
    }

    private float computeValue(double d10, float f10) {
        return (int) (f10 * (1.0d - Math.exp(d10 * DEFORMATION_FORMULA_CONSTANT)));
    }

    private ValueAnimator createClickAnimator(final boolean z10) {
        Interpolator interpolator;
        ValueAnimator valueAnimator = new ValueAnimator();
        if (!z10 && (interpolator = this.mCustomProgressAnimInterpolator) != null) {
            valueAnimator.setInterpolator(interpolator);
        } else {
            valueAnimator.setInterpolator(THUMB_ANIMATE_INTERPOLATOR);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUIVerticalSeekBar.this.lambda$createClickAnimator$0(valueAnimator2);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.seekbar.COUIVerticalSeekBar.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (COUIVerticalSeekBar.this.mOnSeekBarChangeListener != null) {
                    OnSeekBarChangeListener onSeekBarChangeListener = COUIVerticalSeekBar.this.mOnSeekBarChangeListener;
                    COUIVerticalSeekBar cOUIVerticalSeekBar = COUIVerticalSeekBar.this;
                    onSeekBarChangeListener.onProgressChanged(cOUIVerticalSeekBar, cOUIVerticalSeekBar.mRealProgress, z10);
                }
                COUIVerticalSeekBar.this.onStopTrackingTouch(z10);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIVerticalSeekBar.this.mOnSeekBarChangeListener != null) {
                    OnSeekBarChangeListener onSeekBarChangeListener = COUIVerticalSeekBar.this.mOnSeekBarChangeListener;
                    COUIVerticalSeekBar cOUIVerticalSeekBar = COUIVerticalSeekBar.this;
                    onSeekBarChangeListener.onProgressChanged(cOUIVerticalSeekBar, cOUIVerticalSeekBar.mRealProgress, z10);
                }
                COUIVerticalSeekBar.this.onStopTrackingTouch(z10);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIVerticalSeekBar.this.onStartTrackingTouch(z10);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return valueAnimator;
    }

    private Paint createPaint() {
        Paint paint = new Paint(1);
        paint.setDither(true);
        return paint;
    }

    private void drawBackgroundByClip(Canvas canvas, boolean z10) {
        this.mBackgroundPath.reset();
        if (z10) {
            OplusPath oplusPath = new OplusPath(this.mBackgroundPath);
            Rect rect = this.mBackgroundRect;
            float f10 = rect.left;
            float f11 = rect.top;
            float f12 = rect.right;
            float f13 = rect.bottom;
            float f14 = this.mCurBackgroundRadius;
            oplusPath.addSmoothRoundRect(f10, f11, f12, f13, f14, f14, this.mProgressRoundCornerWeight, Path.Direction.CCW);
        } else {
            Path path = this.mBackgroundPath;
            Rect rect2 = this.mBackgroundRect;
            float f15 = rect2.left;
            float f16 = rect2.top;
            float f17 = rect2.right;
            float f18 = rect2.bottom;
            float f19 = this.mCurBackgroundRadius;
            path.addRoundRect(f15, f16, f17, f18, f19, f19, Path.Direction.CCW);
        }
        canvas.save();
        canvas.clipPath(this.mBackgroundPath);
        this.mInactiveTrackDrawable.draw(canvas);
        canvas.restore();
    }

    private void drawBackgroundByPaint(Canvas canvas, boolean z10) {
        this.mBackgroundPaint.setColor(this.mBackgroundColor);
        if (z10) {
            OplusCanvas oplusCanvas = new OplusCanvas(canvas);
            Rect rect = this.mBackgroundRect;
            float f10 = rect.left;
            float f11 = rect.top;
            float f12 = rect.right;
            float f13 = rect.bottom;
            float f14 = this.mCurBackgroundRadius;
            oplusCanvas.drawSmoothRoundRect(f10, f11, f12, f13, f14, f14, this.mBackgroundPaint, this.mBackgroundRoundCornerWeight);
            return;
        }
        Rect rect2 = this.mBackgroundRect;
        float f15 = rect2.left;
        float f16 = rect2.top;
        float f17 = rect2.right;
        float f18 = rect2.bottom;
        float f19 = this.mCurBackgroundRadius;
        canvas.drawRoundRect(f15, f16, f17, f18, f19, f19, this.mBackgroundPaint);
    }

    private void drawProgress(Canvas canvas) {
        boolean z10;
        if (this.mIsSupportSmoothRoundCorner && this.mProgressRoundCornerWeight != 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mProgressPaint.setColor(this.mProgressColor);
        this.mClipProgressPath.reset();
        if (z10) {
            OplusPath oplusPath = new OplusPath(this.mClipProgressPath);
            Rect rect = this.mClipProgressRect;
            float f10 = rect.left;
            float f11 = rect.top;
            float f12 = rect.right;
            float f13 = rect.bottom;
            float f14 = this.mCurProgressRadius;
            oplusPath.addSmoothRoundRect(f10, f11, f12, f13, f14, f14, this.mProgressRoundCornerWeight, Path.Direction.CCW);
        } else {
            Path path = this.mClipProgressPath;
            Rect rect2 = this.mClipProgressRect;
            float f15 = rect2.left;
            float f16 = rect2.top;
            float f17 = rect2.right;
            float f18 = rect2.bottom;
            float f19 = this.mCurProgressRadius;
            path.addRoundRect(f15, f16, f17, f18, f19, f19, Path.Direction.CCW);
        }
        canvas.save();
        canvas.clipPath(this.mClipProgressPath);
        if (this.mShowThumb) {
            Rect rect3 = this.mProgressRect;
            float f20 = rect3.top;
            float f21 = this.mThumbOutWidth;
            int i10 = (int) (f20 - (f21 / 2.0f));
            rect3.top = i10;
            int i11 = (int) (rect3.bottom + (f21 / 2.0f));
            rect3.bottom = i11;
            if (z10) {
                OplusCanvas oplusCanvas = new OplusCanvas(canvas);
                Rect rect4 = this.mProgressRect;
                float f22 = rect4.left;
                float f23 = rect4.top;
                float f24 = rect4.right;
                float f25 = rect4.bottom;
                float f26 = this.mCurProgressRadius;
                oplusCanvas.drawSmoothRoundRect(f22, f23, f24, f25, f26, f26, this.mProgressPaint, this.mProgressRoundCornerWeight);
            } else {
                float f27 = this.mCurProgressRadius;
                canvas.drawRoundRect(rect3.left, i10, rect3.right, i11, f27, f27, this.mProgressPaint);
            }
        } else {
            canvas.drawRect(this.mProgressRect, this.mProgressPaint);
        }
        canvas.restore();
    }

    private void drawText(Canvas canvas) {
        if (TextUtils.isEmpty(this.mTextContent)) {
            return;
        }
        this.mTextPaint.setColor(this.mTextColor);
        canvas.drawText(this.mTextContent, (getWidth() - this.mTextPaint.measureText(this.mTextContent)) / 2.0f, ((this.mTextMarginTop - this.mFmi.ascent) + this.mHeightTopDeformedDownValue) - this.mHeightTopDeformedUpValue, this.mTextPaint);
    }

    private void drawThumb(Canvas canvas) {
        Bitmap bitmap;
        float f10 = this.mThumbPosition;
        float f11 = this.mThumbOutWidth;
        float f12 = f10 - (f11 / 2.0f);
        float f13 = f10 + (f11 / 2.0f);
        int seekBarCenterX = getSeekBarCenterX();
        if (getThumb() != null && (bitmap = this.mThumbBitmap) != null) {
            canvas.drawBitmap(bitmap, seekBarCenterX - (this.mThumbOutWidth / 2.0f), f12, this.mThumbPaint);
            return;
        }
        this.mThumbPaint.setColor(this.mThumbColor);
        if (this.mIsSupportSmoothRoundCorner && this.mThumbOutRoundCornerWeight != 0.0f) {
            OplusCanvas oplusCanvas = new OplusCanvas(canvas);
            float f14 = seekBarCenterX;
            float f15 = this.mThumbOutWidth;
            float f16 = this.mThumbOutRadius;
            oplusCanvas.drawSmoothRoundRect(f14 - (f15 / 2.0f), f12, f14 + (f15 / 2.0f), f13, f16, f16, this.mThumbPaint, this.mThumbOutRoundCornerWeight);
            return;
        }
        float f17 = seekBarCenterX;
        float f18 = this.mThumbOutWidth;
        float f19 = this.mThumbOutRadius;
        canvas.drawRoundRect(f17 - (f18 / 2.0f), f12, f17 + (f18 / 2.0f), f13, f19, f19, this.mThumbPaint);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int max = Math.max(1, drawable.getIntrinsicHeight());
        int max2 = Math.max(1, drawable.getIntrinsicWidth());
        Bitmap createBitmap = Bitmap.createBitmap(max2, max, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, max2, max);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void ensureSize() {
        resetProgressSize();
        float f10 = 1.0f;
        if (this.mBackgroundEnlargeScale != 1.0f) {
            f10 = (getResources().getDimensionPixelSize(a9.d.f6544Y0) + (this.mBackgroundRadius * this.mBackgroundRadiusEnlargeScale)) / this.mPaddingVertical;
        }
        this.mVerticalPaddingScale = f10;
        float f11 = this.mProgressRadius;
        this.mCurProgressRadius = f11;
        this.mCurBackgroundRadius = this.mBackgroundRadius;
        this.mThumbOutRadius = f11 * this.mProgressRadiusEnlargeScale;
        this.mThumbOutRoundCornerWeight = this.mProgressRoundCornerWeight;
        float f12 = this.mProgressWidth;
        this.mCurProgressWidth = f12;
        this.mCurBackgroundWidth = this.mBackgroundWidth;
        this.mThumbOutWidth = f12 * this.mProgressEnlargeScale;
        this.mCurPaddingVertical = this.mPaddingVertical;
        COUILog.i(TAG, "COUIVerticalSeekBar ensureSize : mIsProgressFull:" + this.mIsProgressFull + ",mBackgroundRadius:" + this.mBackgroundRadius + ",mBackgroundWidth:" + this.mBackgroundWidth + ",mBackgroundEnlargeScale" + this.mBackgroundEnlargeScale + ",mProgressRadius:" + this.mProgressRadius + ",mProgressWidth:" + this.mProgressWidth + ",mProgressEnlargeScale" + this.mProgressEnlargeScale + ",mPaddingVertical" + this.mPaddingVertical);
        updateBehavior();
        initAnimation();
    }

    private void executeEnlargeAnim(long j10, Interpolator interpolator) {
        if (this.mEnlargeAnimator == null) {
            ValueAnimator enlargeAnimator = getEnlargeAnimator(j10, interpolator);
            this.mEnlargeAnimator = enlargeAnimator;
            enlargeAnimator.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.seekbar.COUIVerticalSeekBar.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    COUIVerticalSeekBar.this.mHasEnlarge = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        }
        setEnlargeAnimatorValues(this.mEnlargeAnimator);
        this.mEnlargeAnimator.start();
    }

    private void executeReleaseAnim(long j10, Interpolator interpolator) {
        if (this.mReleaseAnimator == null) {
            this.mReleaseAnimator = getReleaseAnimator(j10, interpolator);
        }
        setReleaseAnimatorValues(this.mReleaseAnimator);
        this.mHasEnlarge = false;
        this.mReleaseAnimator.start();
    }

    private void flingBehaviorAfterDeformationDrag() {
        if (this.mFlingValueHolder != null && this.mFlingBehavior != null && this.mIsSupportDeformation) {
            float f10 = this.mScale;
            float f11 = 0.0f;
            if (f10 > 1.0f || f10 < 0.0f) {
                int normalSeekBarHeight = getNormalSeekBarHeight();
                int i10 = this.mMax - this.mMin;
                if (i10 > 0) {
                    f11 = normalSeekBarHeight / i10;
                }
                float deformationFlingScale = getDeformationFlingScale();
                float f12 = i10 * deformationFlingScale * f11;
                this.mFlingValueHolder.c(f12);
                this.mFlingBehavior.j0();
                COUILog.i(TAG, "flingBehaviorAfterDeformationDrag ** range = " + i10 + " height = " + normalSeekBarHeight + " pixPerProgress = " + f11 + " scale = " + deformationFlingScale + " startValue = " + f12);
            }
        }
    }

    private void flingBehaviorAfterEndDrag(float f10) {
        float f11;
        if (this.mFlingValueHolder != null && this.mFlingBehavior != null) {
            int normalSeekBarHeight = getNormalSeekBarHeight();
            int i10 = this.mMax - this.mMin;
            if (i10 > 0) {
                f11 = normalSeekBarHeight / i10;
            } else {
                f11 = 0.0f;
            }
            if (this.mIsSupportDeformation) {
                float deformationFlingScale = getDeformationFlingScale();
                float f12 = i10 * deformationFlingScale * f11;
                this.mFlingValueHolder.c(f12);
                COUILog.i(TAG, "flingBehaviorAfterEndDrag ** range = " + i10 + " height = " + normalSeekBarHeight + " pixPerProgress = " + f11 + " scale = " + deformationFlingScale + " startValue = " + f12 + " velocity = " + f10);
            } else {
                this.mFlingValueHolder.c((this.mProgress - r2) * f11);
            }
            this.mFlingBehavior.k0(-f10);
        }
    }

    private ValueAnimator getButtonDeformationAnimator() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUIVerticalSeekBar.this.lambda$getButtonDeformationAnimator$1(valueAnimator2);
            }
        });
        return valueAnimator;
    }

    private void getCurAnimatorValues(ValueAnimator valueAnimator) {
        this.mCurProgressRadius = (int) ((Float) valueAnimator.getAnimatedValue("progressRadius")).floatValue();
        this.mCurBackgroundRadius = (int) ((Float) valueAnimator.getAnimatedValue("backgroundRadius")).floatValue();
        this.mCurProgressWidth = (int) ((Float) valueAnimator.getAnimatedValue("progressWidth")).floatValue();
        this.mCurBackgroundWidth = (int) ((Float) valueAnimator.getAnimatedValue("backgroundWidth")).floatValue();
        this.mCurPaddingVertical = (int) ((Float) valueAnimator.getAnimatedValue("animatePadding")).floatValue();
    }

    private float getDeformationFlingScale() {
        float f10 = this.mScale;
        if (f10 > 1.0f) {
            return ((f10 - 1.0f) / 5.0f) + 1.0f;
        }
        if (f10 < 0.0f) {
            return f10 / 5.0f;
        }
        return f10;
    }

    private ValueAnimator getEnlargeAnimator(long j10, Interpolator interpolator) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(j10);
        valueAnimator.setInterpolator(interpolator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUIVerticalSeekBar.this.lambda$getEnlargeAnimator$2(valueAnimator2);
            }
        });
        return valueAnimator;
    }

    private g getFastMoveSpring() {
        if (this.mFastMoveSpring == null) {
            initFastMoveAnimation();
        }
        return this.mFastMoveSpring;
    }

    private float getHeightBottomDeformedValue() {
        return this.mHeightBottomDeformedDownValue - this.mHeightBottomDeformedUpValue;
    }

    private float getHeightTopDeformedValue() {
        return this.mHeightTopDeformedDownValue - this.mHeightTopDeformedUpValue;
    }

    private int getNormalSeekBarHeight() {
        return (int) (((getHeight() - getPaddingTop()) - getPaddingBottom()) - (this.mPaddingVertical * 2.0f));
    }

    private int getProgressLimit(int i10) {
        int i11 = this.mMax;
        int i12 = this.mMin;
        int i13 = i11 - i12;
        return Math.max(i12 - i13, Math.min(i10, i11 + i13));
    }

    private int getRealProgress(int i10) {
        return Math.max(this.mMin, Math.min(i10, this.mMax));
    }

    private float getRealScale(float f10) {
        return Math.max(0.0f, Math.min(f10, 1.0f));
    }

    private ValueAnimator getReleaseAnimator(long j10, Interpolator interpolator) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(j10);
        valueAnimator.setInterpolator(interpolator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUIVerticalSeekBar.this.lambda$getReleaseAnimator$3(valueAnimator2);
            }
        });
        return valueAnimator;
    }

    private void heightDeformedChanged() {
        if (this.mOnDeformedListener != null) {
            boolean z10 = topDeformedChange();
            boolean bottomDeformedChange = bottomDeformedChange();
            if (z10 || bottomDeformedChange) {
                this.mOnDeformedListener.onHeightDeformedChanged(this.mCurTopDeformationValue, this.mCurBottomDeformationValue);
            }
        }
    }

    private void initAnimation() {
        ValueAnimator valueAnimator = this.mTouchEnlargeAnimator;
        if (valueAnimator == null) {
            this.mTouchEnlargeAnimator = getEnlargeAnimator(183L, PROGRESS_SCALE_INTERPOLATOR);
        } else {
            cancelAnim(valueAnimator);
        }
        setEnlargeAnimatorValues(this.mTouchEnlargeAnimator);
    }

    private void initFastMoveAnimation() {
        if (this.mFastMoveSpring != null) {
            return;
        }
        g c10 = l.h().c();
        this.mFastMoveSpring = c10;
        c10.q(this.mFastMoveSpringConfig);
        this.mFastMoveSpring.a(new c4.j() { // from class: com.coui.appcompat.seekbar.COUIVerticalSeekBar.1
            @Override // c4.j
            public void onSpringUpdate(g gVar) {
                if (COUIVerticalSeekBar.this.mFastMoveScaleOffsetY != gVar.e()) {
                    if (!COUIVerticalSeekBar.this.isEnabled()) {
                        COUIVerticalSeekBar.this.mFastMoveScaleOffsetY = 0.0f;
                    } else {
                        COUIVerticalSeekBar.this.mFastMoveScaleOffsetY = (float) gVar.c();
                    }
                    COUIVerticalSeekBar.this.invalidate();
                }
            }

            @Override // c4.j
            public void onSpringActivate(g gVar) {
            }

            @Override // c4.j
            public void onSpringAtRest(g gVar) {
            }

            @Override // c4.j
            public void onSpringEndStateChange(g gVar) {
            }
        });
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initPhysicsAnimator(Context context) {
        this.mPhysicalAnimator = k.e(context);
        this.mFlingValueHolder = new j(0.0f);
        int normalSeekBarHeight = getNormalSeekBarHeight();
        COUILog.i(TAG, "COUIVerticalSeekBar initPhysicsAnimator : setActiveFrame:" + normalSeekBarHeight);
        i8.h hVar = (i8.h) ((i8.h) new i8.h(4, 0.0f, (float) normalSeekBarHeight).I(this.mFlingValueHolder)).z(this.mFlingFrequency, this.mFlingDampingRatio).b(null);
        this.mFlingBehavior = hVar;
        hVar.i0(this.mFlingLinearDamping);
        this.mPhysicalAnimator.c(this.mFlingBehavior);
        this.mPhysicalAnimator.a(this.mFlingBehavior, this);
        this.mPhysicalAnimator.b(this.mFlingBehavior, this);
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initView() {
        this.mBackgroundColor = getColor(this, this.mBackgroundColorStateList, COUIContextUtil.getColor(getContext(), a9.c.f6485i));
        ColorStateList colorStateList = this.mProgressColorStateList;
        Context context = getContext();
        int i10 = a9.c.f6488l;
        this.mProgressColor = getColor(this, colorStateList, COUIContextUtil.getColor(context, i10));
        this.mThumbColor = getColor(this, this.mThumbColorStateList, COUIContextUtil.getColor(getContext(), i10));
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        PatternExploreByTouchHelper patternExploreByTouchHelper = new PatternExploreByTouchHelper(this);
        this.mExploreByTouchHelper = patternExploreByTouchHelper;
        K.j0(this, patternExploreByTouchHelper);
        K.t0(this, 1);
        this.mExploreByTouchHelper.invalidateRoot();
        this.mBackgroundPaint = createPaint();
        this.mProgressPaint = createPaint();
        this.mThumbPaint = createPaint();
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setTextSize(getResources().getDimensionPixelSize(a9.d.f6573j0));
        this.mTextPaint.setShadowLayer(TEXT_SHADOW_RADIUS, 0.0f, TEXT_SHADOW_DY, this.mTextColor);
        this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mFmi = this.mTextPaint.getFontMetricsInt();
    }

    private void invalidateProgress(MotionEvent motionEvent) {
        float f10;
        float y10 = motionEvent.getY();
        float seekBarHeight = getSeekBarHeight();
        float f11 = this.mCurProgressRadius;
        float f12 = seekBarHeight + (2.0f * f11);
        float f13 = this.mCurPaddingVertical - f11;
        if (f12 > 0.0f) {
            f10 = (((getHeight() - getPaddingBottom()) - f13) - y10) / f12;
        } else {
            f10 = 0.0f;
        }
        this.mScale = Math.max(0.0f, Math.min(f10, 1.0f));
        int progressLimit = getProgressLimit(Math.round((this.mScale * (getMax() - getMin())) + getMin()));
        int i10 = this.mRealProgress;
        setLocalProgress(progressLimit);
        invalidate();
        int i11 = this.mRealProgress;
        if (i10 != i11) {
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(this, i11, true);
            }
            performFeedback();
        }
    }

    private boolean isDeformationFling() {
        k kVar;
        if (this.mIsSupportDeformation) {
            float f10 = this.mScale;
            if ((f10 > 1.0f || f10 < 0.0f) && (kVar = this.mPhysicalAnimator) != null && kVar.q()) {
                return true;
            }
        }
        return false;
    }

    private boolean isMoveFollowHand() {
        if (this.mMoveType != 2) {
            return true;
        }
        return false;
    }

    private boolean isToucheInSeekBar(MotionEvent motionEvent) {
        if (this.mIsSupportDeformation) {
            float f10 = this.mScale;
            if (f10 > 1.0f || f10 < 0.0f) {
                return touchInSeekBarWhenDeformation(motionEvent, this);
            }
        }
        return touchInSeekBar(motionEvent, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createClickAnimator$0(ValueAnimator valueAnimator) {
        float f10 = 0.0f;
        if (this.mPixPerProgress > 0.0f) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            setLocalProgress((int) (floatValue / this.mPixPerProgress));
            if (getSeekBarHeight() > 0) {
                f10 = (floatValue - (this.mMin * this.mPixPerProgress)) / getSeekBarHeight();
            }
            this.mScale = f10;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getButtonDeformationAnimator$1(ValueAnimator valueAnimator) {
        setTouchScale(((Float) valueAnimator.getAnimatedValue(HOLDER_SCALE)).floatValue());
        setLocalProgress(getProgressLimit(Math.round((this.mMax - this.mMin) * this.mScale) + this.mMin));
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getEnlargeAnimator$2(ValueAnimator valueAnimator) {
        getCurAnimatorValues(valueAnimator);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getReleaseAnimator$3(ValueAnimator valueAnimator) {
        getCurAnimatorValues(valueAnimator);
        invalidate();
    }

    private void logOnAnimationEnd(i8.c cVar) {
        float f10;
        Object n10 = cVar.n();
        if (n10 == null) {
            return;
        }
        float floatValue = ((Float) n10).floatValue();
        int normalSeekBarHeight = getNormalSeekBarHeight();
        if (normalSeekBarHeight > 0) {
            f10 = floatValue / normalSeekBarHeight;
        } else {
            f10 = 0.0f;
        }
        COUILog.i(TAG, "logOnAnimationEnd ** flingValue = " + floatValue + " height = " + normalSeekBarHeight + " scale = " + f10 + " mScale = " + this.mScale + " mClipProgressRect = " + this.mClipProgressRect.toString() + " mBackgroundRect = " + this.mBackgroundRect.toString() + " mProgressRect = " + this.mProgressRect.toString());
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void resetDeformationValue() {
        if (this.mIsSupportDeformation) {
            this.mHeightTopDeformedUpValue = 0.0f;
            this.mHeightBottomDeformedUpValue = 0.0f;
            this.mWidthDeformedValue = 0.0f;
            this.mHeightTopDeformedDownValue = 0.0f;
            this.mHeightBottomDeformedDownValue = 0.0f;
            heightDeformedChanged();
        }
    }

    private void resetProgressSize() {
        if (this.mIsProgressFull) {
            this.mProgressRadius = this.mBackgroundRadius;
            this.mProgressRoundCornerWeight = this.mBackgroundRoundCornerWeight;
            this.mProgressWidth = this.mBackgroundWidth;
            this.mProgressEnlargeScale = this.mBackgroundEnlargeScale;
            this.mProgressRadiusEnlargeScale = this.mBackgroundRadiusEnlargeScale;
        }
    }

    private void setBackgroundRect(int i10) {
        float paddingTop = (getPaddingTop() + this.mCurPaddingVertical) - this.mCurBackgroundRadius;
        float height = ((getHeight() - getPaddingBottom()) - this.mCurPaddingVertical) + this.mCurBackgroundRadius;
        Rect rect = this.mBackgroundRect;
        float f10 = i10;
        float f11 = this.mCurBackgroundWidth;
        float f12 = this.mWidthDeformedValue;
        rect.set((int) (f10 - ((f11 / 2.0f) - f12)), (int) ((paddingTop - this.mHeightTopDeformedUpValue) + this.mHeightTopDeformedDownValue), (int) (f10 + ((f11 / 2.0f) - f12)), (int) ((height - this.mHeightBottomDeformedUpValue) + this.mHeightBottomDeformedDownValue));
    }

    private void setDeformationScale(float f10) {
        if (f10 > 1.0f) {
            f10 = ((f10 - 1.0f) * 5.0f) + 1.0f;
        } else if (f10 < 0.0f) {
            f10 *= 5.0f;
        }
        this.mScale = Math.max(-1.0f, Math.min(f10, 2.0f));
    }

    private void setDrawableBounds(Drawable drawable) {
        if (drawable != null) {
            if (this.mIsSupportDeformation) {
                drawable.setBounds(0, -(this.mMaxTopMovingDistance + ((int) Math.ceil(this.mMaxTopHeightDeformedValue))), getWidth(), getHeight() + this.mMaxBottomMovingDistance + ((int) Math.ceil(this.mMaxBottomHeightDeformedValue)));
                return;
            }
            drawable.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    private void setEnlargeAnimatorValues(ValueAnimator valueAnimator) {
        valueAnimator.setValues(PropertyValuesHolder.ofFloat("progressRadius", this.mCurProgressRadius, this.mProgressRadius * this.mProgressRadiusEnlargeScale), PropertyValuesHolder.ofFloat("backgroundRadius", this.mCurBackgroundRadius, this.mBackgroundRadius * this.mBackgroundRadiusEnlargeScale), PropertyValuesHolder.ofFloat("progressWidth", this.mCurProgressWidth, this.mProgressWidth * this.mProgressEnlargeScale), PropertyValuesHolder.ofFloat("backgroundWidth", this.mCurBackgroundWidth, this.mBackgroundWidth * this.mBackgroundEnlargeScale), PropertyValuesHolder.ofFloat("animatePadding", this.mCurPaddingVertical, this.mPaddingVertical * this.mVerticalPaddingScale));
    }

    private void setFlingScale(float f10) {
        if (this.mIsSupportDeformation) {
            calculateFlingDeformationValue(f10);
            setDeformationScale(f10);
            if (this.mOnDeformedListener != null) {
                DeformedValueBean deformedValueBean = new DeformedValueBean(this.mHeightBottomDeformedUpValue, this.mHeightTopDeformedUpValue, this.mWidthDeformedValue, this.mHeightBottomDeformedDownValue, this.mHeightTopDeformedDownValue, this.mProgress);
                deformedValueBean.setScale(this.mScale);
                this.mOnDeformedListener.onScaleChanged(deformedValueBean);
                return;
            }
            return;
        }
        this.mScale = Math.max(0.0f, Math.min(f10, 1.0f));
    }

    private void setProgressRect(int i10, float f10, float f11) {
        Rect rect = this.mProgressRect;
        float f12 = i10;
        float f13 = this.mCurProgressWidth;
        float f14 = this.mWidthDeformedValue;
        float f15 = f10 - this.mHeightTopDeformedUpValue;
        float f16 = this.mHeightBottomDeformedDownValue;
        rect.set((int) (f12 - ((f13 / 2.0f) - f14)), (int) (f15 + f16), (int) (f12 + ((f13 / 2.0f) - f14)), (int) ((f11 - this.mHeightBottomDeformedUpValue) + f16));
    }

    private void setReleaseAnimatorValues(ValueAnimator valueAnimator) {
        valueAnimator.setValues(PropertyValuesHolder.ofFloat("progressRadius", this.mCurProgressRadius, this.mProgressRadius), PropertyValuesHolder.ofFloat("backgroundRadius", this.mCurBackgroundRadius, this.mBackgroundRadius), PropertyValuesHolder.ofFloat("progressWidth", this.mCurProgressWidth, this.mProgressWidth), PropertyValuesHolder.ofFloat("backgroundWidth", this.mCurBackgroundWidth, this.mBackgroundWidth), PropertyValuesHolder.ofFloat("animatePadding", this.mCurPaddingVertical, this.mPaddingVertical));
    }

    private void setThumbBitmap() {
        if (getThumb() != null) {
            this.mThumbBitmap = drawableToBitmap(getThumb());
        }
    }

    private void setTouchScale(float f10) {
        if (this.mIsSupportDeformation) {
            this.mScale = Math.max(-1.0f, Math.min(f10, 2.0f));
            calculateTouchDeformationValue();
            if (this.mOnDeformedListener != null) {
                DeformedValueBean deformedValueBean = new DeformedValueBean(this.mHeightBottomDeformedUpValue, this.mHeightTopDeformedUpValue, this.mWidthDeformedValue, this.mHeightBottomDeformedDownValue, this.mHeightTopDeformedDownValue, this.mProgress);
                deformedValueBean.setScale(this.mScale);
                this.mOnDeformedListener.onScaleChanged(deformedValueBean);
                return;
            }
            return;
        }
        this.mScale = Math.max(0.0f, Math.min(f10, 1.0f));
    }

    private void startFastMoveAnimation(float f10) {
        g fastMoveSpring = getFastMoveSpring();
        if (fastMoveSpring.c() == fastMoveSpring.e()) {
            int i10 = this.mMax - this.mMin;
            if (f10 <= -95.0f) {
                int i11 = this.mProgress;
                float f11 = i10;
                if (i11 <= MAX_FAST_MOVE_PERCENT * f11 && i11 >= f11 * MIN_FAST_MOVE_PERCENT) {
                    fastMoveSpring.n(1.0d);
                    return;
                }
                return;
            }
            if (f10 >= 95.0f) {
                int i12 = this.mProgress;
                float f12 = i10;
                if (i12 <= MAX_FAST_MOVE_PERCENT * f12 && i12 >= f12 * MIN_FAST_MOVE_PERCENT) {
                    fastMoveSpring.n(-1.0d);
                    return;
                }
                return;
            }
            fastMoveSpring.n(0.0d);
        }
    }

    private void stopDeformationFling() {
        if (isDeformationFling()) {
            stopPhysicsMove();
        }
    }

    private boolean topDeformedChange() {
        if (this.mIsSupportDeformation) {
            float heightTopDeformedValue = getHeightTopDeformedValue();
            if (this.mCurTopDeformationValue != heightTopDeformedValue) {
                this.mCurTopDeformationValue = heightTopDeformedValue;
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean touchInSeekBarWhenDeformation(MotionEvent motionEvent, View view) {
        float x10 = motionEvent.getX();
        if (x10 >= 0.0f && x10 <= view.getWidth()) {
            return true;
        }
        return false;
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        float y10 = motionEvent.getY();
        float f10 = this.mLastY - y10;
        int i10 = this.mMax - this.mMin;
        float calculateDamping = f10 * calculateDamping();
        float seekBarHeight = getSeekBarHeight();
        float f11 = 0.0f;
        if (i10 > 0 && seekBarHeight > 0.0f) {
            f11 = (this.mProgress / i10) + (calculateDamping / seekBarHeight);
        }
        setTouchScale(f11);
        int progressLimit = getProgressLimit(Math.round((this.mScale * i10) + getMin()));
        int i11 = this.mProgress;
        int i12 = this.mRealProgress;
        setLocalProgress(progressLimit);
        invalidate();
        if (i11 != this.mProgress) {
            this.mLastY = y10;
            int i13 = this.mRealProgress;
            if (i12 != i13) {
                OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
                if (onSeekBarChangeListener != null) {
                    onSeekBarChangeListener.onProgressChanged(this, i13, true);
                }
                performFeedback();
            }
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(100);
            startFastMoveAnimation(this.mVelocityTracker.getYVelocity());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void trackTouchEventByFinger(android.view.MotionEvent r6) {
        /*
            r5 = this;
            float r0 = r5.mLastY
            float r6 = r6.getY()
            float r6 = r0 - r6
            float r1 = r5.calculateDamping()
            float r6 = r6 * r1
            float r0 = r0 - r6
            int r6 = java.lang.Math.round(r0)
            int r0 = r5.getHeight()
            int r1 = r5.getPaddingTop()
            int r0 = r0 - r1
            int r1 = r5.getPaddingBottom()
            int r0 = r0 - r1
            int r1 = r5.getHeight()
            int r2 = r5.getPaddingBottom()
            int r1 = r1 - r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r6 <= r1) goto L30
        L2e:
            r1 = r3
            goto L47
        L30:
            int r1 = r5.getPaddingTop()
            if (r6 >= r1) goto L38
            r1 = r2
            goto L47
        L38:
            if (r0 <= 0) goto L2e
            int r1 = r5.getHeight()
            int r4 = r5.getPaddingBottom()
            int r1 = r1 - r4
            int r1 = r1 - r6
            float r1 = (float) r1
            float r0 = (float) r0
            float r1 = r1 / r0
        L47:
            float r0 = java.lang.Math.min(r1, r2)
            float r0 = java.lang.Math.max(r3, r0)
            r5.mScale = r0
            int r0 = r5.getMax()
            int r1 = r5.getMin()
            int r0 = r0 - r1
            float r1 = r5.mScale
            float r0 = (float) r0
            float r1 = r1 * r0
            int r0 = r5.getMin()
            float r0 = (float) r0
            float r1 = r1 + r0
            int r0 = java.lang.Math.round(r1)
            int r0 = r5.getProgressLimit(r0)
            int r1 = r5.mProgress
            int r2 = r5.mRealProgress
            r5.setLocalProgress(r0)
            r5.invalidate()
            int r0 = r5.mProgress
            if (r1 == r0) goto L8c
            float r6 = (float) r6
            r5.mLastY = r6
            int r6 = r5.mRealProgress
            if (r2 == r6) goto L8c
            com.coui.appcompat.seekbar.COUIVerticalSeekBar$OnSeekBarChangeListener r0 = r5.mOnSeekBarChangeListener
            if (r0 == 0) goto L89
            r1 = 1
            r0.onProgressChanged(r5, r6, r1)
        L89:
            r5.performFeedback()
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.seekbar.COUIVerticalSeekBar.trackTouchEventByFinger(android.view.MotionEvent):void");
    }

    private void updateBehavior() {
        if (this.mIsPhysicsEnable && this.mPhysicalAnimator != null && this.mFlingBehavior != null) {
            int normalSeekBarHeight = getNormalSeekBarHeight();
            COUILog.i(TAG, "COUIVerticalSeekBar updateBehavior : setActiveFrame:" + normalSeekBarHeight);
            this.mFlingBehavior.g0(0.0f, (float) normalSeekBarHeight);
        }
    }

    private void updatePixPerProgress() {
        float f10;
        int seekBarHeight = getSeekBarHeight();
        int i10 = this.mMax - this.mMin;
        if (i10 > 0) {
            f10 = seekBarHeight / i10;
        } else {
            f10 = 0.0f;
        }
        this.mPixPerProgress = f10;
    }

    private void updateScale() {
        float f10;
        int i10 = this.mMax - this.mMin;
        if (i10 > 0) {
            f10 = (this.mProgress - r1) / i10;
        } else {
            f10 = 0.0f;
        }
        this.mScale = f10;
    }

    public void animForClick(float f10) {
        float seekBarHeight = getSeekBarHeight();
        float f11 = this.mCurProgressRadius;
        float f12 = seekBarHeight + (2.0f * f11);
        float f13 = this.mCurPaddingVertical - f11;
        float f14 = 0.0f;
        if (f12 > 0.0f) {
            f14 = (((getHeight() - getPaddingBottom()) - f13) - f10) / f12;
        }
        startTransitionAnim(getProgressLimit(Math.round((f14 * (getMax() - getMin())) + getMin())), true);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        float f10;
        float f11;
        float f12;
        float f13;
        int seekBarCenterX = getSeekBarCenterX();
        float seekBarHeight = getSeekBarHeight();
        if (!this.mShowThumb) {
            float f14 = this.mCurPaddingVertical;
            float f15 = this.mCurProgressRadius;
            f12 = seekBarHeight + (f15 * 2.0f);
            f13 = f14 - f15;
            f10 = f13;
            f11 = f12;
        } else {
            float f16 = this.mCurPaddingVertical;
            float f17 = this.mThumbOutWidth;
            float f18 = this.mThumbOutRadius;
            f10 = ((f17 / 2.0f) - f18) + f16;
            float f19 = seekBarHeight - (f17 - (f18 * 2.0f));
            float f20 = this.mCurProgressRadius;
            float f21 = f16 - f20;
            f11 = seekBarHeight + (f20 * 2.0f);
            f12 = f19;
            f13 = f21;
        }
        Rect rect = this.mClipProgressRect;
        float f22 = seekBarCenterX;
        float f23 = this.mCurProgressWidth;
        float f24 = this.mWidthDeformedValue;
        rect.left = (int) ((f22 - (f23 / 2.0f)) + f24);
        rect.right = (int) ((f22 + (f23 / 2.0f)) - f24);
        float paddingTop = getPaddingTop() + f10 + f12;
        float realScale = paddingTop - (getRealScale(this.mScale) * f12);
        this.mThumbPosition = realScale;
        Rect rect2 = this.mClipProgressRect;
        float paddingTop2 = getPaddingTop() + f13;
        float f25 = this.mHeightTopDeformedDownValue;
        float f26 = this.mHeightTopDeformedUpValue;
        rect2.top = (int) ((paddingTop2 + f25) - f26);
        this.mClipProgressRect.bottom = (int) (((((r5.top + f11) + f26) - this.mHeightBottomDeformedUpValue) + this.mHeightBottomDeformedDownValue) - f25);
        setBackgroundRect(seekBarCenterX);
        setProgressRect(seekBarCenterX, realScale, paddingTop);
        super.draw(canvas);
    }

    public void drawActiveTrack(Canvas canvas) {
        if (this.mShowProgress) {
            drawProgress(canvas);
        }
        if (this.mShowThumb) {
            drawThumb(canvas);
        }
        if (this.mShowText) {
            drawText(canvas);
        }
    }

    public void drawInactiveTrack(Canvas canvas) {
        boolean z10;
        if (this.mIsSupportSmoothRoundCorner && this.mBackgroundRoundCornerWeight != 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.mInactiveTrackDrawable != null) {
            drawBackgroundByClip(canvas, z10);
        } else {
            drawBackgroundByPaint(canvas, z10);
        }
    }

    public void endCustomDeformation() {
        cancelAnim(this.mButtonDeformationAnimator);
        setTouchScale(Math.max(0.0f, Math.min(this.mScale, 1.0f)));
        setLocalProgress(getProgressLimit(Math.round((this.mMax - this.mMin) * this.mScale) + this.mMin));
        invalidate();
    }

    public void endEnlargeAnim() {
        ValueAnimator valueAnimator = this.mEnlargeAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mEnlargeAnimator.end();
        }
        ValueAnimator valueAnimator2 = this.mReleaseAnimator;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.mReleaseAnimator.end();
        }
    }

    public void ensureLabelsRemoved() {
        ViewUtils.getContentViewOverlay(this).remove(this.mTextDrawable);
    }

    public Paint getBackgroundPaint() {
        return this.mBackgroundPaint;
    }

    public int getColor(View view, ColorStateList colorStateList, int i10) {
        if (colorStateList == null) {
            return i10;
        }
        return colorStateList.getColorForState(view.getDrawableState(), i10);
    }

    public boolean getHasEnlarge() {
        return this.mHasEnlarge;
    }

    public int getLabelHeight() {
        return this.mTextDrawable.getIntrinsicHeight();
    }

    @Override // android.widget.ProgressBar
    public int getMax() {
        return this.mMax;
    }

    @Override // android.widget.ProgressBar
    public int getMin() {
        return this.mMin;
    }

    public float getMoveDamping() {
        return this.mDamping;
    }

    public int getMoveType() {
        return this.mMoveType;
    }

    @Override // android.widget.ProgressBar
    public int getProgress() {
        return this.mRealProgress;
    }

    public Paint getProgressPaint() {
        return this.mProgressPaint;
    }

    public int getSeekBarCenterX() {
        return getPaddingStart() + (((getWidth() - getPaddingStart()) - getPaddingEnd()) >> 1);
    }

    public int getSeekBarHeight() {
        return (int) (((getHeight() - getPaddingTop()) - getPaddingBottom()) - (this.mCurPaddingVertical * 2.0f));
    }

    public Paint getThumbPaint() {
        return this.mThumbPaint;
    }

    public void handleMotionEventDown(MotionEvent motionEvent) {
        this.mTouchDownY = motionEvent.getY();
        this.mLastY = motionEvent.getY();
    }

    public void handleMotionEventMove(MotionEvent motionEvent) {
        if (this.mIsDragging && this.mStartDragging) {
            cancelAnim(this.mButtonDeformationAnimator);
            int i10 = this.mMoveType;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        return;
                    }
                } else {
                    trackTouchEventByFinger(motionEvent);
                    return;
                }
            }
            trackTouchEvent(motionEvent);
            return;
        }
        if (!isToucheInSeekBar(motionEvent)) {
            return;
        }
        float y10 = motionEvent.getY();
        if (Math.abs(y10 - this.mTouchDownY) > this.mTouchSlop) {
            stopDeformationFling();
            startDrag();
            touchAnim();
            this.mLastY = y10;
            if (isMoveFollowHand()) {
                invalidateProgress(motionEvent);
            }
        }
    }

    public void handleMotionEventUp(MotionEvent motionEvent) {
        OnSeekBarChangeListener onSeekBarChangeListener;
        getFastMoveSpring().n(0.0d);
        if (this.mIsDragging) {
            this.mIsDragging = false;
            this.mStartDragging = false;
            COUILog.i(TAG, "handleMotionEventUp mFlingVelocity = " + this.mFlingVelocity);
            if (this.mIsPhysicsEnable && Math.abs(this.mFlingVelocity) >= 100.0f) {
                flingBehaviorAfterEndDrag(this.mFlingVelocity);
            } else {
                float f10 = this.mScale;
                if (f10 >= 0.0f && f10 <= 1.0f && (onSeekBarChangeListener = this.mOnSeekBarChangeListener) != null) {
                    onSeekBarChangeListener.onStopTrackingTouch(this);
                }
                flingBehaviorAfterDeformationDrag();
            }
            setPressed(false);
            releaseAnim();
            return;
        }
        if (isEnabled() && touchInSeekBar(motionEvent, this) && isMoveFollowHand()) {
            animForClick(motionEvent.getY());
        }
    }

    @Override // android.widget.ProgressBar, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (this.mInactiveTrackDrawable != null) {
            Rect dirtyBounds = drawable.getDirtyBounds();
            invalidate(dirtyBounds.left, dirtyBounds.top, dirtyBounds.right, dirtyBounds.bottom);
        }
    }

    public boolean isLayoutRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public void onAnimationCancel(i8.c cVar) {
        onStopTrackingTouch(true);
    }

    @Override // i8.InterfaceC1105a
    public void onAnimationEnd(i8.c cVar) {
        logOnAnimationEnd(cVar);
        OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    @Override // i8.InterfaceC1105a
    public /* bridge */ /* synthetic */ void onAnimationStart(i8.c cVar) {
        super.onAnimationStart(cVar);
    }

    @Override // i8.b
    public void onAnimationUpdate(i8.c cVar) {
        float f10;
        int i10;
        Object n10 = cVar.n();
        if (n10 == null) {
            return;
        }
        float floatValue = ((Float) n10).floatValue();
        int normalSeekBarHeight = getNormalSeekBarHeight();
        if (normalSeekBarHeight > 0) {
            f10 = floatValue / normalSeekBarHeight;
        } else {
            f10 = 0.0f;
        }
        setFlingScale(f10);
        float f11 = this.mProgress;
        int i11 = this.mRealProgress;
        setLocalProgress(getProgressLimit(Math.round((this.mMax - this.mMin) * this.mScale) + this.mMin));
        invalidate();
        if (f11 != this.mProgress) {
            this.mLastY = (getHeight() - getPaddingBottom()) - floatValue;
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null && i11 != (i10 = this.mRealProgress)) {
                onSeekBarChangeListener.onProgressChanged(this, i10, true);
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        VibrateUtils.registerHapticObserver(getContext());
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopPhysicsMove();
        VibrateUtils.unRegisterHapticObserver();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        drawInactiveTrack(canvas);
        drawActiveTrack(canvas);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingStart = this.mSeekbarMinWidth + getPaddingStart() + getPaddingEnd();
        if (1073741824 != mode || size < paddingStart) {
            size = paddingStart;
        }
        int i12 = this.mMaxHeight;
        if (i12 > 0 && size2 > i12) {
            size2 = i12;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(savedState.mSaveProgress);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mSaveProgress = this.mProgress;
        return savedState;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mStartDragging = false;
        setDrawableBounds(this.mInactiveTrackDrawable);
        stopPhysicsMove();
        updateBehavior();
        updatePixPerProgress();
    }

    public void onStartTrackingTouch() {
        onStartTrackingTouch(true);
    }

    public void onStopTrackingTouch() {
        onStopTrackingTouch(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if (r0 != 3) goto L33;
     */
    @Override // android.widget.AbsSeekBar, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            r1 = 3
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L1b
            int r0 = r5.getAction()
            if (r0 == r3) goto L17
            int r0 = r5.getAction()
            if (r0 != r1) goto L16
            goto L17
        L16:
            return r2
        L17:
            r4.handleMotionEventUp(r5)
            return r3
        L1b:
            int r0 = r5.getAction()
            if (r0 == 0) goto L6a
            if (r0 == r3) goto L38
            r2 = 2
            if (r0 == r2) goto L29
            if (r0 == r1) goto L38
            goto L96
        L29:
            r4.clearDeformationValue()
            r4.initVelocityTrackerIfNotExists()
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            r0.addMovement(r5)
            r4.handleMotionEventMove(r5)
            goto L96
        L38:
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            if (r0 == 0) goto L63
            r1 = 1000(0x3e8, float:1.401E-42)
            r2 = 1174011904(0x45fa0000, float:8000.0)
            r0.computeCurrentVelocity(r1, r2)
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            float r0 = r0.getYVelocity()
            r4.mFlingVelocity = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onTouchEvent ACTION_UP mFlingVelocity = "
            r0.append(r1)
            float r1 = r4.mFlingVelocity
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "COUIVerticalSeekBar"
            com.coui.appcompat.log.COUILog.i(r1, r0)
        L63:
            r4.recycleVelocityTracker()
            r4.handleMotionEventUp(r5)
            goto L96
        L6a:
            android.animation.ValueAnimator r0 = r4.mClickAnimator
            r4.cancelAnim(r0)
            boolean r0 = r4.isDeformationFling()
            if (r0 != 0) goto L78
            r4.stopPhysicsMove()
        L78:
            boolean r0 = r4.mIsPhysicsEnable
            if (r0 == 0) goto L87
            i8.k r0 = r4.mPhysicalAnimator
            if (r0 != 0) goto L87
            android.content.Context r0 = r4.getContext()
            r4.initPhysicsAnimator(r0)
        L87:
            r4.initOrResetVelocityTracker()
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            r0.addMovement(r5)
            r4.mIsDragging = r2
            r4.mStartDragging = r2
            r4.handleMotionEventDown(r5)
        L96:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.seekbar.COUIVerticalSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performAdaptiveFeedback() {
        boolean z10;
        if (this.mLinearMotorVibrator == null) {
            LinearmotorVibrator linearMotorVibrator = VibrateUtils.getLinearMotorVibrator(getContext());
            this.mLinearMotorVibrator = linearMotorVibrator;
            if (linearMotorVibrator != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.mHasMotorVibrator = z10;
        }
        if (this.mLinearMotorVibrator == null) {
            return false;
        }
        if (this.mRealProgress != getMax() && this.mRealProgress != getMin()) {
            if (this.mVibratorExecutor == null) {
                this.mVibratorExecutor = Executors.newSingleThreadExecutor();
            }
            this.mVibratorExecutor.execute(new Runnable() { // from class: com.coui.appcompat.seekbar.COUIVerticalSeekBar.5
                @Override // java.lang.Runnable
                public void run() {
                    COUIVerticalSeekBar cOUIVerticalSeekBar = COUIVerticalSeekBar.this;
                    if (cOUIVerticalSeekBar.mIsDragging) {
                        LinearmotorVibrator linearmotorVibrator = (LinearmotorVibrator) cOUIVerticalSeekBar.mLinearMotorVibrator;
                        int i10 = cOUIVerticalSeekBar.mProgress;
                        int i11 = cOUIVerticalSeekBar.mMin;
                        VibrateUtils.setLinearMotorVibratorStrength(linearmotorVibrator, VibrateUtils.TYPE_STEPABLE_REGULATE, i10 - i11, cOUIVerticalSeekBar.mMax - i11, 200, 2000);
                    }
                }
            });
        } else {
            LinearmotorVibrator linearmotorVibrator = (LinearmotorVibrator) this.mLinearMotorVibrator;
            int i10 = this.mRealProgress;
            int i11 = this.mMin;
            VibrateUtils.setLinearMotorVibratorStrength(linearmotorVibrator, VibrateUtils.TYPE_STEPABLE_EDGE, i10 - i11, this.mMax - i11, 800, 1200);
        }
        return true;
    }

    public void performFeedback() {
        if (!this.mEnableVibrator) {
            return;
        }
        if (this.mHasMotorVibrator && this.mEnableAdaptiveVibrator && performAdaptiveFeedback()) {
            return;
        }
        if (this.mRealProgress != getMax() && this.mRealProgress != getMin()) {
            if (this.mVibratorExecutor == null) {
                this.mVibratorExecutor = Executors.newSingleThreadExecutor();
            }
            this.mVibratorExecutor.execute(new Runnable() { // from class: com.coui.appcompat.seekbar.COUIVerticalSeekBar.4
                @Override // java.lang.Runnable
                public void run() {
                    COUIVerticalSeekBar cOUIVerticalSeekBar = COUIVerticalSeekBar.this;
                    if (cOUIVerticalSeekBar.mIsDragging) {
                        cOUIVerticalSeekBar.performHapticFeedback(COUIHapticFeedbackConstants.STEPPING_SHORT_VIBRATE, 0);
                    }
                }
            });
            return;
        }
        performHapticFeedback(COUIHapticFeedbackConstants.EDGE_SHORT_VIBRATE, 0);
    }

    public void preCalcClipPath() {
        int seekBarCenterX = getSeekBarCenterX();
        float paddingTop = (getPaddingTop() + this.mCurPaddingVertical) - this.mCurBackgroundRadius;
        float height = ((getHeight() - getPaddingBottom()) - this.mCurPaddingVertical) + this.mCurBackgroundRadius;
        Rect rect = this.mBackgroundRect;
        float f10 = seekBarCenterX;
        float f11 = this.mCurBackgroundWidth;
        float f12 = this.mWidthDeformedValue;
        rect.set((int) (f10 - ((f11 / 2.0f) - f12)), (int) ((paddingTop - this.mHeightTopDeformedUpValue) + this.mHeightTopDeformedDownValue), (int) (f10 + ((f11 / 2.0f) - f12)), (int) ((height - this.mHeightBottomDeformedUpValue) + this.mHeightBottomDeformedDownValue));
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mRefreshStyle);
        TypedArray typedArray = null;
        if (TextUtils.equals(resourceTypeName, "attr")) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, m.f6932z2, this.mRefreshStyle, 0);
        } else if (TextUtils.equals(resourceTypeName, "style")) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, m.f6932z2, 0, this.mRefreshStyle);
        }
        if (typedArray != null) {
            this.mProgressColor = getColor(this, typedArray.getColorStateList(m.f6772M2), COUIContextUtil.getColor(getContext(), a9.c.f6488l));
            this.mBackgroundColor = getColor(this, typedArray.getColorStateList(m.f6736D2), COUIContextUtil.getColor(getContext(), a9.c.f6485i));
            this.mTextColor = typedArray.getColor(m.f6820Y2, getResources().getColor(a9.c.f6491o));
            invalidate();
            typedArray.recycle();
        }
    }

    public void releaseAnim() {
        if (this.mEnableCustomEnlarge) {
            return;
        }
        cancelAnim(this.mTouchEnlargeAnimator);
        ValueAnimator valueAnimator = this.mTouchReleaseAnimator;
        if (valueAnimator == null) {
            this.mTouchReleaseAnimator = getReleaseAnimator(183L, PROGRESS_SCALE_INTERPOLATOR);
        } else {
            cancelAnim(valueAnimator);
        }
        setReleaseAnimatorValues(this.mTouchReleaseAnimator);
        this.mTouchReleaseAnimator.start();
    }

    public void setBackgroundEnlargeScale(float f10) {
        this.mBackgroundEnlargeScale = f10;
        ensureSize();
        invalidate();
    }

    public void setBackgroundRadius(float f10) {
        this.mBackgroundRadius = f10;
        ensureSize();
        invalidate();
    }

    public void setBackgroundRoundCornerWeight(float f10) {
        this.mBackgroundRoundCornerWeight = f10;
        invalidate();
    }

    public void setBackgroundWidth(float f10) {
        this.mBackgroundWidth = f10;
        ensureSize();
        invalidate();
    }

    public void setCustomProgressAnimDuration(float f10) {
        if (f10 <= 0.0f) {
            return;
        }
        this.mCustomProgressAnimDuration = f10;
    }

    public void setCustomProgressAnimInterpolator(Interpolator interpolator) {
        this.mCustomProgressAnimInterpolator = interpolator;
    }

    public void setDeformedListener(OnDeformedListener onDeformedListener) {
        this.mOnDeformedListener = onDeformedListener;
    }

    public void setDeformedParams(DeformedValueBean deformedValueBean) {
        this.mScale = deformedValueBean.getScale();
        this.mProgress = deformedValueBean.getProgress();
        this.mHeightBottomDeformedUpValue = deformedValueBean.getHeightBottomDeformedUpValue();
        this.mHeightTopDeformedUpValue = deformedValueBean.getHeightTopDeformedUpValue();
        this.mWidthDeformedValue = deformedValueBean.getWidthDeformedValue();
        this.mHeightBottomDeformedDownValue = deformedValueBean.getHeightBottomDeformedDownValue();
        this.mHeightTopDeformedDownValue = deformedValueBean.getHeightTopDeformedDownValue();
        invalidate();
    }

    public void setEnableAdaptiveVibrator(boolean z10) {
        this.mEnableAdaptiveVibrator = z10;
    }

    public void setEnableCustomEnlarge(boolean z10) {
        this.mEnableCustomEnlarge = z10;
    }

    public void setEnableVibrator(boolean z10) {
        this.mEnableVibrator = z10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        ColorStateList colorStateList = this.mProgressColorStateList;
        Context context = getContext();
        int i10 = a9.c.f6488l;
        this.mProgressColor = getColor(this, colorStateList, COUIContextUtil.getColor(context, i10));
        this.mBackgroundColor = getColor(this, this.mBackgroundColorStateList, COUIContextUtil.getColor(getContext(), a9.c.f6485i));
        this.mThumbColor = getColor(this, this.mThumbColorStateList, COUIContextUtil.getColor(getContext(), i10));
    }

    public void setFlingLinearDamping(float f10) {
        i8.h hVar;
        if (this.mIsPhysicsEnable) {
            this.mFlingLinearDamping = f10;
            if (this.mPhysicalAnimator != null && (hVar = this.mFlingBehavior) != null) {
                hVar.i0(f10);
            }
        }
    }

    public void setFlingProperty(float f10, float f11) {
        i8.h hVar;
        if (this.mIsPhysicsEnable) {
            this.mFlingFrequency = f10;
            this.mFlingDampingRatio = f11;
            if (this.mPhysicalAnimator != null && (hVar = this.mFlingBehavior) != null) {
                hVar.z(f10, f11);
            }
        }
    }

    public void setInactiveTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mInactiveTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mInactiveTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setDrawableBounds(this.mInactiveTrackDrawable);
        }
        invalidate();
    }

    public void setIncrement(int i10) {
        this.mIncrement = Math.abs(i10);
    }

    public void setLocalMax(int i10) {
        this.mMax = i10;
        updatePixPerProgress();
        updateScale();
        super.setMax(i10);
    }

    public void setLocalMin(int i10) {
        this.mMin = i10;
        updatePixPerProgress();
        updateScale();
        super.setMin(i10);
    }

    public void setLocalProgress(int i10) {
        this.mProgress = i10;
        this.mRealProgress = getRealProgress(i10);
        super.setProgress(i10);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar
    public void setMax(int i10) {
        if (i10 < getMin()) {
            int min = getMin();
            Log.e(TAG, "setMax : the input params is lower than min. (inputMax:" + i10 + ",mMin:" + this.mMin + ")");
            i10 = min;
        }
        if (i10 != this.mMax) {
            setLocalMax(i10);
            if (this.mProgress > i10) {
                setProgress(i10);
            }
        }
        invalidate();
    }

    public void setMaxHeightDeformed(float f10) {
        setMaxHeightDeformed(f10, f10);
    }

    public void setMaxMovingDistance(int i10) {
        setMaxMovingDistance(i10, i10);
    }

    public void setMaxWidthDeformed(float f10) {
        this.mMaxWidthDeformedValue = f10;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar
    public void setMin(int i10) {
        int i11;
        if (i10 < 0) {
            i11 = 0;
        } else {
            i11 = i10;
        }
        if (i10 > getMax()) {
            i11 = getMax();
            Log.e(TAG, "setMin : the input params is greater than max. (inputMin:" + i10 + ",mMax:" + this.mMax + ")");
        }
        if (i11 != this.mMin) {
            setLocalMin(i11);
            if (this.mProgress < i11) {
                setProgress(i11);
            }
        }
        invalidate();
    }

    public void setMoveDamping(float f10) {
        this.mDamping = f10;
    }

    public void setMoveType(int i10) {
        this.mMoveType = i10;
    }

    public void setOnSeekBarChangeListener(OnSeekBarChangeListener onSeekBarChangeListener) {
        this.mOnSeekBarChangeListener = onSeekBarChangeListener;
    }

    public void setPaddingVertical(float f10) {
        if (f10 == 0.0f) {
            this.mPaddingVertical = this.mDefaultPaddingVertical;
        } else {
            this.mPaddingVertical = f10;
        }
        ensureSize();
        invalidate();
    }

    public void setPhysicalEnabled(boolean z10) {
        if (z10 == this.mIsPhysicsEnable) {
            return;
        }
        if (z10) {
            this.mIsPhysicsEnable = true;
            updateBehavior();
        } else {
            stopPhysicsMove();
            this.mIsPhysicsEnable = false;
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i10) {
        setProgress(i10, false);
    }

    public void setProgressColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mProgressColorStateList = colorStateList;
            this.mProgressColor = getColor(this, colorStateList, COUIContextUtil.getColor(getContext(), a9.c.f6488l));
            invalidate();
        }
    }

    public void setProgressContentDescription(String str) {
        this.mProgressContentDescription = str;
    }

    public void setProgressEnlargeScale(float f10) {
        this.mProgressEnlargeScale = f10;
        ensureSize();
        invalidate();
    }

    public void setProgressFull() {
        this.mIsProgressFull = true;
        ensureSize();
    }

    public void setProgressRadius(float f10) {
        this.mProgressRadius = f10;
        ensureSize();
        invalidate();
    }

    public void setProgressRoundCornerWeight(float f10) {
        this.mProgressRoundCornerWeight = f10;
        ensureSize();
        invalidate();
    }

    public void setProgressWidth(float f10) {
        this.mProgressWidth = f10;
        ensureSize();
        invalidate();
    }

    public void setSeekBarBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mBackgroundColorStateList = colorStateList;
            this.mBackgroundColor = getColor(this, colorStateList, COUIContextUtil.getColor(getContext(), a9.c.f6485i));
            invalidate();
        }
    }

    public void setSupportDeformation(boolean z10) {
        this.mIsSupportDeformation = z10;
    }

    public void setText(String str) {
        this.mTextContent = str;
        invalidate();
    }

    @Override // android.widget.AbsSeekBar
    public void setThumb(Drawable drawable) {
        super.setThumb(drawable);
        setThumbBitmap();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mThumbColorStateList = colorStateList;
            this.mThumbColor = getColor(this, colorStateList, COUIContextUtil.getColor(getContext(), a9.c.f6488l));
            invalidate();
        }
    }

    public void showText(boolean z10) {
        this.mShowText = z10;
        invalidate();
    }

    public void startCustomDeformation(float f10) {
        if (this.mIsSupportDeformation) {
            if (this.mInterpolator == null) {
                this.mInterpolator = new COUIMoveEaseInterpolator();
            }
            startCustomDeformation(f10, this.mInterpolator, BUTTON_DEFORMATION_ANIM_DURATION);
        }
    }

    public void startDrag() {
        setPressed(true);
        onStartTrackingTouch(true);
        attemptClaimDrag();
    }

    public void startEnlargeAnim(int i10, long j10, Interpolator interpolator) {
        cancelAnim(this.mReleaseAnimator);
        cancelAnim(this.mEnlargeAnimator);
        if (i10 == 1) {
            executeEnlargeAnim(j10, interpolator);
        } else if (i10 == 0) {
            executeReleaseAnim(j10, interpolator);
        }
    }

    public void startTransitionAnim(int i10, boolean z10) {
        float f10;
        int i11 = this.mProgress;
        ValueAnimator valueAnimator = this.mClickAnimator;
        if (valueAnimator == null) {
            this.mClickAnimator = createClickAnimator(z10);
        } else {
            cancelAnim(valueAnimator);
        }
        if (!z10) {
            float f11 = this.mCustomProgressAnimDuration;
            if (f11 != -1.0f) {
                this.mClickAnimator.setDuration(f11);
                float f12 = i11;
                float f13 = this.mPixPerProgress;
                this.mClickAnimator.setValues(PropertyValuesHolder.ofFloat("progressLength", f12 * f13, i10 * f13));
                this.mClickAnimator.start();
            }
        }
        int i12 = this.mMax - this.mMin;
        if (i12 > 0) {
            f10 = Math.abs(i10 - i11) / i12;
        } else {
            f10 = 0.0f;
        }
        long j10 = f10 * 483.0f;
        if (j10 < 150) {
            j10 = 150;
        }
        this.mClickAnimator.setDuration(j10);
        float f122 = i11;
        float f132 = this.mPixPerProgress;
        this.mClickAnimator.setValues(PropertyValuesHolder.ofFloat("progressLength", f122 * f132, i10 * f132));
        this.mClickAnimator.start();
    }

    public void stopPhysicsMove() {
        i8.h hVar;
        if (this.mIsPhysicsEnable && this.mPhysicalAnimator != null && (hVar = this.mFlingBehavior) != null) {
            hVar.m0();
        }
    }

    public float subtract(float f10, float f11) {
        return new BigDecimal(Float.toString(f10)).subtract(new BigDecimal(Float.toString(f11))).floatValue();
    }

    public void touchAnim() {
        if (this.mEnableCustomEnlarge) {
            return;
        }
        cancelAnim(this.mTouchEnlargeAnimator);
        this.mTouchEnlargeAnimator.start();
    }

    public boolean touchInSeekBar(MotionEvent motionEvent, View view) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (x10 >= 0.0f && x10 <= view.getWidth() && y10 >= view.getPaddingTop() && y10 <= view.getHeight() - view.getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public COUIVerticalSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a9.b.f6476n);
    }

    public void onStartTrackingTouch(boolean z10) {
        OnSeekBarChangeListener onSeekBarChangeListener;
        this.mIsDragging = true;
        this.mStartDragging = true;
        if (!z10 || (onSeekBarChangeListener = this.mOnSeekBarChangeListener) == null) {
            return;
        }
        onSeekBarChangeListener.onStartTrackingTouch(this);
    }

    public void onStopTrackingTouch(boolean z10) {
        OnSeekBarChangeListener onSeekBarChangeListener;
        this.mIsDragging = false;
        this.mStartDragging = false;
        if (!z10 || (onSeekBarChangeListener = this.mOnSeekBarChangeListener) == null) {
            return;
        }
        onSeekBarChangeListener.onStopTrackingTouch(this);
    }

    public void setMaxHeightDeformed(float f10, float f11) {
        this.mMaxTopHeightDeformedValue = f10;
        this.mMaxBottomHeightDeformedValue = f11;
    }

    public void setMaxMovingDistance(int i10, int i11) {
        this.mMaxTopMovingDistance = i10;
        this.mMaxBottomMovingDistance = i11;
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i10, boolean z10) {
        setProgress(i10, z10, false);
    }

    public COUIVerticalSeekBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, COUIContextUtil.isCOUIDarkTheme(context) ? a9.l.f6708n : a9.l.f6707m);
    }

    public void setProgress(int i10, boolean z10, boolean z11) {
        this.mOldProgress = this.mProgress;
        int max = Math.max(this.mMin, Math.min(i10, this.mMax));
        if (this.mOldProgress != max) {
            if (z10) {
                startTransitionAnim(max, z11);
            } else {
                setLocalProgress(max);
                this.mOldProgress = max;
                updateScale();
                OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
                if (onSeekBarChangeListener != null) {
                    onSeekBarChangeListener.onProgressChanged(this, this.mRealProgress, z11);
                }
                invalidate();
            }
            resetDeformationValue();
        }
    }

    public COUIVerticalSeekBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mMax = 100;
        this.mMin = 0;
        this.mOldProgress = 0;
        this.mProgress = 0;
        this.mTouchSlop = 0;
        this.mCustomProgressAnimDuration = -1.0f;
        this.mScale = 0.0f;
        this.mShowProgress = false;
        this.mShowThumb = false;
        this.mEnableAdaptiveVibrator = true;
        this.mEnableVibrator = true;
        this.mHasMotorVibrator = true;
        this.mIsDragging = false;
        this.mIsSupportSmoothRoundCorner = false;
        this.mBackgroundColorStateList = null;
        this.mProgressColorStateList = null;
        this.mThumbColorStateList = null;
        this.mLinearMotorVibrator = null;
        this.mClipProgressPath = new Path();
        this.mClipProgressRect = new Rect();
        this.mProgressRect = new Rect();
        this.mTempRect = new Rect();
        this.mBackgroundRect = new Rect();
        this.mHasEnlarge = false;
        this.mIsProgressFull = false;
        this.mCustomProgressAnimInterpolator = null;
        this.mIncrement = 1;
        this.mStartDragging = false;
        this.mMoveType = 1;
        this.mFastMoveSpringConfig = h.b(500.0d, 30.0d);
        this.mDamping = 0.0f;
        this.mThumbPosition = 0.0f;
        this.mIsPhysicsEnable = false;
        this.mFlingVelocity = 0.0f;
        this.mFlingFrequency = 2.8f;
        this.mFlingDampingRatio = 1.0f;
        this.mFlingLinearDamping = 15.0f;
        this.mMaxTopMovingDistance = 30;
        this.mMaxBottomMovingDistance = 30;
        this.mMaxTopHeightDeformedValue = 28.5f;
        this.mMaxBottomHeightDeformedValue = 28.5f;
        this.mMaxWidthDeformedValue = 4.7f;
        this.mBackgroundPath = new Path();
        if (attributeSet != null) {
            this.mRefreshStyle = attributeSet.getStyleAttribute();
        }
        if (this.mRefreshStyle == 0) {
            this.mRefreshStyle = i10;
        }
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6932z2, i10, i11);
        this.mEnableVibrator = obtainStyledAttributes.getBoolean(m.f6756I2, true);
        this.mEnableAdaptiveVibrator = obtainStyledAttributes.getBoolean(m.f6724A2, false);
        this.mIsPhysicsEnable = obtainStyledAttributes.getBoolean(m.f6768L2, true);
        this.mShowProgress = obtainStyledAttributes.getBoolean(m.f6804U2, true);
        this.mShowThumb = obtainStyledAttributes.getBoolean(m.f6812W2, true);
        this.mIsProgressFull = obtainStyledAttributes.getBoolean(m.f6780O2, false);
        this.mShowText = obtainStyledAttributes.getBoolean(m.f6808V2, false);
        this.mIsSupportDeformation = obtainStyledAttributes.getBoolean(m.f6752H2, false);
        this.mBackgroundColorStateList = obtainStyledAttributes.getColorStateList(m.f6736D2);
        this.mProgressColorStateList = obtainStyledAttributes.getColorStateList(m.f6772M2);
        this.mThumbColorStateList = obtainStyledAttributes.getColorStateList(m.f6829a3);
        this.mTextColor = obtainStyledAttributes.getColor(m.f6820Y2, getResources().getColor(a9.c.f6491o));
        this.mBackgroundRadius = obtainStyledAttributes.getDimension(m.f6740E2, getResources().getDimension(a9.d.f6545Z));
        this.mProgressRadius = obtainStyledAttributes.getDimension(m.f6788Q2, getResources().getDimension(a9.d.f6569h0));
        this.mBackgroundRoundCornerWeight = obtainStyledAttributes.getFloat(m.f6744F2, 0.0f);
        this.mProgressRoundCornerWeight = obtainStyledAttributes.getFloat(m.f6796S2, 0.0f);
        float dimension = getResources().getDimension(a9.d.f6542X0);
        this.mDefaultPaddingVertical = dimension;
        float dimension2 = obtainStyledAttributes.getDimension(m.f6784P2, dimension);
        this.mPaddingVertical = dimension2;
        if (dimension2 == 0.0f) {
            this.mPaddingVertical = this.mDefaultPaddingVertical;
        }
        this.mBackgroundWidth = obtainStyledAttributes.getDimensionPixelSize(m.f6748G2, (int) (this.mBackgroundRadius * 2.0f));
        this.mProgressWidth = obtainStyledAttributes.getDimensionPixelSize(m.f6800T2, (int) (this.mProgressRadius * 2.0f));
        this.mSeekbarMinWidth = obtainStyledAttributes.getDimensionPixelOffset(m.f6764K2, getResources().getDimensionPixelSize(a9.d.f6549a1));
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(m.f6760J2, 0);
        this.mBackgroundEnlargeScale = obtainStyledAttributes.getFloat(m.f6728B2, BACKGROUND_RADIUS_SCALE);
        this.mProgressEnlargeScale = obtainStyledAttributes.getFloat(m.f6776N2, PROGRESS_RADIUS_SCALE);
        this.mBackgroundRadiusEnlargeScale = obtainStyledAttributes.getFloat(m.f6732C2, this.mBackgroundEnlargeScale);
        this.mProgressRadiusEnlargeScale = obtainStyledAttributes.getFloat(m.f6792R2, this.mProgressEnlargeScale);
        this.mTextContent = obtainStyledAttributes.getString(m.f6816X2);
        this.mTextMarginTop = obtainStyledAttributes.getDimension(m.f6824Z2, getResources().getDimension(a9.d.f6546Z0));
        obtainStyledAttributes.recycle();
        this.mTextDrawable = new TextDrawable(getContext());
        this.mHasMotorVibrator = VibrateUtils.isLinearMotorVersion(context);
        this.mIsSupportSmoothRoundCorner = RoundCornerUtil.isVersionSupport();
        initView();
        setThumbBitmap();
        ensureSize();
    }

    public void startCustomDeformation(float f10, Interpolator interpolator, long j10) {
        if (this.mIsSupportDeformation) {
            float f11 = this.mScale;
            if ((f11 < 1.0f || f10 < 1.0f) && (f11 > 0.0f || f10 > 0.0f)) {
                return;
            }
            ValueAnimator valueAnimator = this.mButtonDeformationAnimator;
            if (valueAnimator == null) {
                this.mButtonDeformationAnimator = getButtonDeformationAnimator();
            } else {
                cancelAnim(valueAnimator);
            }
            this.mButtonDeformationAnimator.setValues(PropertyValuesHolder.ofFloat(HOLDER_SCALE, this.mScale, f10));
            this.mButtonDeformationAnimator.setInterpolator(interpolator);
            this.mButtonDeformationAnimator.setDuration(j10);
            this.mButtonDeformationAnimator.start();
        }
    }

    /* loaded from: classes.dex */
    public interface OnDeformedListener {
        default void onScaleChanged(DeformedValueBean deformedValueBean) {
        }

        default void onHeightDeformedChanged(float f10, float f11) {
        }
    }
}
