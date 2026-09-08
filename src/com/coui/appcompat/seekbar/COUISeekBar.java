package com.coui.appcompat.seekbar;

import J.d;
import a9.m;
import android.animation.Animator;
import android.animation.AnimatorSet;
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
import android.graphics.RectF;
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
import com.google.android.material.internal.DescendantOffsetUtils;
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
public class COUISeekBar extends AbsSeekBar implements InterfaceC1105a, i8.b {
    private static final float BACKGROUND_RADIUS_SCALE = 6.0f;
    private static final int DAMPING_DISTANCE = 20;
    protected static final int DIRECTION_180 = 180;
    private static final int DIRECTION_360 = 360;
    protected static final int DIRECTION_90 = 90;
    private static final int DURATION_150 = 150;
    private static final int DURATION_483 = 483;
    private static final int FAST_MOVE_VELOCITY = 95;
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
    private static final String TAG = "COUISeekBar";
    private static final float TEXT_SHADOW_DX = 0.0f;
    private static final float TEXT_SHADOW_DY = 8.0f;
    private static final float TEXT_SHADOW_RADIUS = 25.0f;
    private static final int THUMB_SHADOW_OFFSET = 8;
    private static final int TOUCH_ANIMATION_ENLARGE_DURATION = 183;
    private static final int VELOCITY_COMPUTE_TIME = 100;
    protected int mBackgroundColor;
    ColorStateList mBackgroundColorStateList;
    protected float mBackgroundEnlargeScale;
    protected float mBackgroundHeight;
    protected float mBackgroundRadius;
    private RectF mBackgroundRect;
    protected float mBackgroundRoundCornerWeight;
    protected AnimatorSet mClickAnimatorSet;
    protected Path mClipProgressPath;
    protected RectF mClipProgressRect;
    protected float mCurBackgroundHeight;
    protected float mCurBackgroundRadius;
    private float mCurBottomDeformationValue;
    protected float mCurPaddingHorizontal;
    protected float mCurProgressHeight;
    protected float mCurProgressRadius;
    private float mCurTopDeformationValue;
    private float mCustomProgressAnimDuration;
    private Interpolator mCustomProgressAnimInterpolator;
    private float mDamping;
    protected boolean mEnableAdaptiveVibrator;
    protected boolean mEnableVibrator;
    private PatternExploreByTouchHelper mExploreByTouchHelper;
    private float mFastMoveScaleOffsetX;
    private g mFastMoveSpring;
    private h mFastMoveSpringConfig;
    private i8.h mFlingBehavior;
    private float mFlingDampingRatio;
    private float mFlingFrequency;
    private float mFlingLinearDamping;
    private j mFlingValueHolder;
    private float mFlingVelocity;
    private Paint.FontMetricsInt mFmi;
    protected boolean mHasMotorVibrator;
    private float mHeightBottomDeformedDownValue;
    private float mHeightBottomDeformedUpValue;
    private float mHeightTopDeformedDownValue;
    private float mHeightTopDeformedUpValue;
    protected float mHorizontalPaddingScale;
    private int mIncrement;
    private int mInnerShadowRadiusSize;
    private Interpolator mInterpolator;
    protected boolean mIsDragging;
    private boolean mIsPhysicsEnable;
    private boolean mIsProgressFull;
    private boolean mIsStartFromMiddle;
    private boolean mIsSupportDeformation;
    private boolean mIsSupportSmoothRoundCorner;
    protected float mLabelX;
    protected float mLastX;
    protected Object mLinearMotorVibrator;
    protected int mMax;
    private float mMaxHeightDeformedValue;
    private int mMaxMovingDistance;
    private int mMaxWidth;
    private float mMaxWidthDeformedValue;
    protected int mMin;
    private int mMoveType;
    protected int mOldProgress;
    private OnDeformedListener mOnDeformedListener;
    private OnSeekBarChangeListener mOnSeekBarChangeListener;
    protected float mPaddingHorizontal;
    protected Paint mPaint;
    private k mPhysicalAnimator;
    protected int mProgress;
    protected int mProgressColor;
    ColorStateList mProgressColorStateList;
    private String mProgressContentDescription;
    protected float mProgressEnlargeScale;
    protected float mProgressHeight;
    protected float mProgressRadius;
    protected RectF mProgressRect;
    protected float mProgressRoundCornerWeight;
    protected Interpolator mProgressScaleInterpolator;
    protected float mProgressScaleRadius;
    private int mRealProgress;
    private int mRefreshStyle;
    protected float mScale;
    private int mSeekbarMinHeight;
    private int mShadowColor;
    private int mShadowRadiusSize;
    protected boolean mShowProgress;
    private boolean mShowText;
    protected boolean mShowThumb;
    private boolean mStartDragging;
    protected RectF mTempRect;
    private int mTextColor;
    private String mTextContent;
    private TextDrawable mTextDrawable;
    private float mTextMarginTop;
    private TextPaint mTextPaint;
    protected Interpolator mThumbAnimateInterpolator;
    private Bitmap mThumbBitmap;
    protected int mThumbColor;
    ColorStateList mThumbColorStateList;
    protected float mThumbOutHeight;
    protected float mThumbOutRadius;
    protected float mThumbOutRoundCornerWeight;
    protected int mThumbShadowColor;
    private int mThumbShadowRadiusSize;
    protected AnimatorSet mTouchAnimator;
    protected float mTouchDownX;
    protected int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private ExecutorService mVibratorExecutor;
    private float mWidthDeformedValue;
    protected static final Interpolator THUMB_ANIMATE_INTERPOLATOR = new COUIMoveEaseInterpolator();
    protected static final Interpolator PROGRESS_SCALE_INTERPOLATOR = new COUIEaseInterpolator();

    /* loaded from: classes.dex */
    public interface OnSeekBarChangeListener {
        void onProgressChanged(COUISeekBar cOUISeekBar, int i10, boolean z10);

        void onStartTrackingTouch(COUISeekBar cOUISeekBar);

        void onStopTrackingTouch(COUISeekBar cOUISeekBar);
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
            rect.right = COUISeekBar.this.getWidth();
            rect.bottom = COUISeekBar.this.getHeight();
            return rect;
        }

        @Override // androidx.customview.widget.a
        public int getVirtualViewAt(float f10, float f11) {
            if (f10 >= 0.0f && f10 <= COUISeekBar.this.getWidth() && f11 >= 0.0f && f11 <= COUISeekBar.this.getHeight()) {
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
            dVar.B0(d.g.a(1, COUISeekBar.this.getMin(), COUISeekBar.this.getMax(), COUISeekBar.this.mProgress));
            if (COUISeekBar.this.isEnabled()) {
                int progress = COUISeekBar.this.getProgress();
                if (progress > COUISeekBar.this.getMin()) {
                    dVar.a(8192);
                }
                if (progress < COUISeekBar.this.getMax()) {
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
            accessibilityEvent.setItemCount(COUISeekBar.this.getMax() - COUISeekBar.this.getMin());
            accessibilityEvent.setCurrentItemIndex(COUISeekBar.this.getProgress());
        }

        @Override // androidx.customview.widget.a
        public void onPopulateNodeForVirtualView(int i10, J.d dVar) {
            dVar.l0("");
            dVar.h0(COUISeekBar.class.getName());
            dVar.c0(getBoundsForVirtualView(i10));
        }

        @Override // androidx.core.view.C0446a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            if (!COUISeekBar.this.isEnabled()) {
                return false;
            }
            if (i10 != 4096) {
                if (i10 != 8192) {
                    return false;
                }
                COUISeekBar cOUISeekBar = COUISeekBar.this;
                cOUISeekBar.setProgress(cOUISeekBar.getProgress() - COUISeekBar.this.mIncrement, false, true);
                COUISeekBar cOUISeekBar2 = COUISeekBar.this;
                cOUISeekBar2.announceForAccessibility(cOUISeekBar2.mProgressContentDescription);
                return true;
            }
            COUISeekBar cOUISeekBar3 = COUISeekBar.this;
            cOUISeekBar3.setProgress(cOUISeekBar3.getProgress() + COUISeekBar.this.mIncrement, false, true);
            COUISeekBar cOUISeekBar4 = COUISeekBar.this;
            cOUISeekBar4.announceForAccessibility(cOUISeekBar4.mProgressContentDescription);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.seekbar.COUISeekBar.SavedState.1
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

    public COUISeekBar(Context context) {
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

    private float calculateDamping(float f10) {
        float f11 = this.mDamping;
        if (f11 != 0.0f) {
            return f11;
        }
        float seekBarWidth = getSeekBarWidth();
        float f12 = seekBarWidth / 2.0f;
        float interpolation = 1.0f - this.mInterpolator.getInterpolation(Math.abs(f10 - f12) / f12);
        if (f10 > seekBarWidth - getPaddingRight() || f10 < getPaddingLeft() || interpolation < MAX_MOVE_DAMPING) {
            return MAX_MOVE_DAMPING;
        }
        return interpolation;
    }

    private void calculateFlingDeformationValue(float f10) {
        if (f10 > 1.0f) {
            double d10 = f10 - 1.0f;
            this.mHeightBottomDeformedUpValue = computeValue(d10, this.mMaxMovingDistance);
            this.mHeightTopDeformedUpValue = computeValue(d10, this.mMaxMovingDistance + this.mMaxHeightDeformedValue);
            this.mWidthDeformedValue = computeValue(d10, this.mMaxWidthDeformedValue);
            heightDeformedChanged();
            return;
        }
        if (f10 < 0.0f) {
            double abs = Math.abs(f10);
            this.mHeightTopDeformedDownValue = computeValue(abs, this.mMaxMovingDistance);
            this.mHeightBottomDeformedDownValue = computeValue(abs, this.mMaxMovingDistance + this.mMaxHeightDeformedValue);
            this.mWidthDeformedValue = computeValue(abs, this.mMaxWidthDeformedValue);
            heightDeformedChanged();
            return;
        }
        resetDeformationValue();
    }

    private void calculateTouchDeformationValue() {
        float f10 = this.mScale;
        if (f10 > 1.0f) {
            double d10 = (f10 - 1.0f) / 5.0f;
            this.mHeightBottomDeformedUpValue = computeValue(d10, this.mMaxMovingDistance);
            this.mHeightTopDeformedUpValue = computeValue(d10, this.mMaxMovingDistance + this.mMaxHeightDeformedValue);
            this.mWidthDeformedValue = computeValue(d10, this.mMaxWidthDeformedValue);
            heightDeformedChanged();
            return;
        }
        if (f10 < 0.0f) {
            double abs = Math.abs(f10) / 5.0f;
            this.mHeightTopDeformedDownValue = computeValue(abs, this.mMaxMovingDistance);
            this.mHeightBottomDeformedDownValue = computeValue(abs, this.mMaxMovingDistance + this.mMaxHeightDeformedValue);
            this.mWidthDeformedValue = computeValue(abs, this.mMaxWidthDeformedValue);
            heightDeformedChanged();
        }
    }

    private void clearDeformationValue() {
        int i10 = this.mProgress;
        if (i10 > this.mMin && i10 < this.mMax) {
            resetDeformationValue();
        }
    }

    private float computeValue(double d10, float f10) {
        return (float) (f10 * (1.0d - Math.exp(d10 * (-11.5d))));
    }

    private void drawProgress(Canvas canvas, int i10, float f10, float f11) {
        boolean z10;
        if (this.mIsSupportSmoothRoundCorner && this.mProgressRoundCornerWeight != 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.mInnerShadowRadiusSize > 0 && this.mCurProgressRadius > this.mProgressRadius) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(0.0f);
            this.mPaint.setColor(0);
            this.mPaint.setShadowLayer(this.mInnerShadowRadiusSize, 0.0f, 0.0f, this.mShadowColor);
            RectF rectF = this.mProgressRect;
            int i11 = this.mInnerShadowRadiusSize;
            float f12 = this.mCurProgressRadius;
            float f13 = i10;
            float f14 = this.mCurProgressHeight;
            rectF.set((f10 - (i11 / 2)) - f12, (f13 - (f14 / 2.0f)) - (i11 / 2), (i11 / 2) + f11 + f12, f13 + (f14 / 2.0f) + (i11 / 2));
            if (z10) {
                OplusCanvas oplusCanvas = new OplusCanvas(canvas);
                RectF rectF2 = this.mProgressRect;
                float f15 = this.mCurProgressRadius;
                oplusCanvas.drawSmoothRoundRect(rectF2, f15, f15, this.mPaint, this.mProgressRoundCornerWeight);
            } else {
                RectF rectF3 = this.mProgressRect;
                float f16 = this.mCurProgressRadius;
                canvas.drawRoundRect(rectF3, f16, f16, this.mPaint);
            }
            this.mPaint.clearShadowLayer();
            this.mPaint.setStyle(Paint.Style.FILL);
        }
        this.mPaint.setColor(this.mProgressColor);
        if (this.mIsStartFromMiddle && f10 > f11) {
            RectF rectF4 = this.mProgressRect;
            float f17 = i10;
            float f18 = this.mCurProgressHeight;
            rectF4.set(f11, f17 - (f18 / 2.0f), f10, f17 + (f18 / 2.0f));
        } else if (isLayoutRtl()) {
            RectF rectF5 = this.mProgressRect;
            float f19 = f10 - this.mHeightTopDeformedUpValue;
            float f20 = this.mHeightBottomDeformedDownValue;
            float f21 = i10;
            float f22 = this.mCurProgressHeight;
            float f23 = this.mWidthDeformedValue;
            rectF5.set(f19 + f20, f21 - ((f22 / 2.0f) - f23), (f11 - this.mHeightBottomDeformedUpValue) + f20, f21 + ((f22 / 2.0f) - f23));
        } else {
            RectF rectF6 = this.mProgressRect;
            float f24 = this.mHeightBottomDeformedDownValue;
            float f25 = (f10 - f24) + this.mHeightBottomDeformedUpValue;
            float f26 = i10;
            float f27 = this.mCurProgressHeight;
            float f28 = this.mWidthDeformedValue;
            rectF6.set(f25, f26 - ((f27 / 2.0f) - f28), (f11 + this.mHeightTopDeformedUpValue) - f24, f26 + ((f27 / 2.0f) - f28));
        }
        this.mClipProgressPath.reset();
        if (z10) {
            OplusPath oplusPath = new OplusPath(this.mClipProgressPath);
            RectF rectF7 = this.mClipProgressRect;
            float f29 = this.mCurProgressRadius;
            oplusPath.addSmoothRoundRect(rectF7, f29, f29, this.mProgressRoundCornerWeight, Path.Direction.CCW);
        } else {
            Path path = this.mClipProgressPath;
            RectF rectF8 = this.mClipProgressRect;
            float f30 = this.mCurProgressRadius;
            path.addRoundRect(rectF8, f30, f30, Path.Direction.CCW);
        }
        canvas.save();
        canvas.clipPath(this.mClipProgressPath);
        if (this.mShowThumb) {
            RectF rectF9 = this.mProgressRect;
            float f31 = rectF9.left;
            float f32 = this.mThumbOutHeight;
            rectF9.left = f31 - (f32 / 2.0f);
            rectF9.right += f32 / 2.0f;
            if (z10) {
                OplusCanvas oplusCanvas2 = new OplusCanvas(canvas);
                RectF rectF10 = this.mProgressRect;
                float f33 = this.mCurProgressRadius;
                oplusCanvas2.drawSmoothRoundRect(rectF10, f33, f33, this.mPaint, this.mProgressRoundCornerWeight);
            } else {
                float f34 = this.mCurProgressRadius;
                canvas.drawRoundRect(rectF9, f34, f34, this.mPaint);
            }
        } else {
            canvas.drawRect(this.mProgressRect, this.mPaint);
        }
        canvas.restore();
    }

    private void drawText(Canvas canvas, int i10) {
        float width;
        if (TextUtils.isEmpty(this.mTextContent)) {
            return;
        }
        this.mTextPaint.setColor(this.mTextColor);
        canvas.save();
        float measureText = this.mTextPaint.measureText(this.mTextContent);
        Paint.FontMetricsInt fontMetricsInt = this.mFmi;
        float f10 = fontMetricsInt.descent - fontMetricsInt.ascent;
        int i11 = fontMetricsInt.bottom;
        int i12 = fontMetricsInt.top;
        float f11 = (((i10 * 2) - (i11 - i12)) / 2) - i12;
        if (isLayoutRtl()) {
            width = (((((getStart() + this.mCurPaddingHorizontal) - this.mCurBackgroundRadius) + this.mTextMarginTop) - ((measureText / 2.0f) - (f10 / 2.0f))) - this.mHeightTopDeformedUpValue) + this.mHeightTopDeformedDownValue;
        } else {
            width = (((((((getWidth() - getEnd()) - this.mCurPaddingHorizontal) + this.mCurBackgroundRadius) - this.mTextMarginTop) - (f10 / 2.0f)) - (measureText / 2.0f)) + this.mHeightTopDeformedUpValue) - this.mHeightTopDeformedDownValue;
        }
        canvas.translate(width, 0.0f);
        canvas.rotate(-getRotation(), measureText / 2.0f, i10);
        canvas.drawText(this.mTextContent, 0.0f, f11, this.mTextPaint);
        canvas.restore();
    }

    private void drawThumb(Canvas canvas, int i10, float f10, float f11) {
        Bitmap bitmap;
        if (this.mThumbShadowRadiusSize > 0 && this.mCurProgressRadius < this.mThumbOutRadius) {
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setShadowLayer(this.mThumbShadowRadiusSize, 0.0f, TEXT_SHADOW_DY, this.mShadowColor);
        }
        if (getThumb() != null && (bitmap = this.mThumbBitmap) != null) {
            canvas.drawBitmap(bitmap, f10, i10 - (this.mThumbOutHeight / 2.0f), this.mPaint);
        } else {
            this.mPaint.setColor(this.mThumbColor);
            if (this.mIsSupportSmoothRoundCorner && this.mThumbOutRoundCornerWeight != 0.0f) {
                OplusCanvas oplusCanvas = new OplusCanvas(canvas);
                float f12 = i10;
                float f13 = this.mThumbOutHeight;
                float f14 = this.mThumbOutRadius;
                oplusCanvas.drawSmoothRoundRect(f10, f12 - (f13 / 2.0f), f11, f12 + (f13 / 2.0f), f14, f14, this.mPaint, this.mThumbOutRoundCornerWeight);
            } else {
                float f15 = i10;
                float f16 = this.mThumbOutHeight;
                float f17 = this.mThumbOutRadius;
                canvas.drawRoundRect(f10, f15 - (f16 / 2.0f), f11, f15 + (f16 / 2.0f), f17, f17, this.mPaint);
            }
        }
        this.mPaint.clearShadowLayer();
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
            f10 = (getResources().getDimensionPixelSize(a9.d.f6566g0) + (this.mBackgroundRadius * this.mBackgroundEnlargeScale)) / this.mPaddingHorizontal;
        }
        this.mHorizontalPaddingScale = f10;
        float f11 = this.mProgressRadius;
        this.mCurProgressRadius = f11;
        this.mCurBackgroundRadius = this.mBackgroundRadius;
        float f12 = this.mProgressEnlargeScale;
        this.mThumbOutRadius = f11 * f12;
        this.mThumbOutRoundCornerWeight = this.mProgressRoundCornerWeight;
        float f13 = this.mProgressHeight;
        this.mCurProgressHeight = f13;
        this.mCurBackgroundHeight = this.mBackgroundHeight;
        this.mThumbOutHeight = f13 * f12;
        this.mCurPaddingHorizontal = this.mPaddingHorizontal;
        COUILog.i(TAG, "COUISeekBar ensureSize : mIsProgressFull:" + this.mIsProgressFull + ",mBackgroundRadius:" + this.mBackgroundRadius + ",mBackgroundHeight:" + this.mBackgroundHeight + ",mBackgroundEnlargeScale" + this.mBackgroundEnlargeScale + ",mProgressRadius:" + this.mProgressRadius + ",mProgressHeight:" + this.mProgressHeight + ",mProgressEnlargeScale" + this.mProgressEnlargeScale + ",mPaddingHorizontal" + this.mPaddingHorizontal);
        updateBehavior();
    }

    private void flingBehaviorAfterDeformationDrag() {
        if (this.mIsSupportDeformation) {
            float f10 = this.mScale;
            float f11 = 0.0f;
            if (f10 > 1.0f || f10 < 0.0f) {
                int normalSeekBarWidth = getNormalSeekBarWidth();
                int i10 = this.mMax - this.mMin;
                if (i10 > 0) {
                    f11 = normalSeekBarWidth / i10;
                }
                if (isLayoutRtl()) {
                    this.mFlingValueHolder.c((this.mMax - (getDeformationFlingScale() * i10)) * f11);
                } else {
                    this.mFlingValueHolder.c(getDeformationFlingScale() * i10 * f11);
                }
                this.mFlingBehavior.j0();
            }
        }
    }

    private void flingBehaviorAfterEndDrag(float f10) {
        float f11;
        int normalSeekBarWidth = getNormalSeekBarWidth();
        int i10 = this.mMax - this.mMin;
        if (i10 > 0) {
            f11 = normalSeekBarWidth / i10;
        } else {
            f11 = 0.0f;
        }
        if (isLayoutRtl()) {
            if (this.mIsSupportDeformation) {
                this.mFlingValueHolder.c((this.mMax - (getDeformationFlingScale() * i10)) * f11);
            } else {
                this.mFlingValueHolder.c(((this.mMax - this.mProgress) + this.mMin) * f11);
            }
        } else if (this.mIsSupportDeformation) {
            this.mFlingValueHolder.c(getDeformationFlingScale() * i10 * f11);
        } else {
            this.mFlingValueHolder.c((this.mProgress - this.mMin) * f11);
        }
        this.mFlingBehavior.k0(f10);
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

    private g getFastMoveSpring() {
        if (this.mFastMoveSpring == null) {
            initFastMoveAnimation();
        }
        return this.mFastMoveSpring;
    }

    private float getHeightBottomDeformedValue() {
        float f10;
        float f11;
        if (isLayoutRtl()) {
            f10 = this.mHeightBottomDeformedDownValue;
            f11 = this.mHeightBottomDeformedUpValue;
        } else {
            f10 = this.mHeightBottomDeformedUpValue;
            f11 = this.mHeightBottomDeformedDownValue;
        }
        return f10 - f11;
    }

    private float getHeightTopDeformedValue() {
        float f10;
        float f11;
        if (isLayoutRtl()) {
            f10 = this.mHeightTopDeformedDownValue;
            f11 = this.mHeightTopDeformedUpValue;
        } else {
            f10 = this.mHeightTopDeformedUpValue;
            f11 = this.mHeightTopDeformedDownValue;
        }
        return f10 - f11;
    }

    private int getNormalSeekBarWidth() {
        return (int) (((getWidth() - getStart()) - getEnd()) - (this.mPaddingHorizontal * 2.0f));
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
        this.mTouchAnimator.setInterpolator(PROGRESS_SCALE_INTERPOLATOR);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(183L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.COUISeekBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUISeekBar.this.onEnlargeAnimationUpdate(valueAnimator);
                COUISeekBar.this.invalidate();
            }
        });
        this.mTouchAnimator.play(ofFloat);
    }

    private void initFastMoveAnimation() {
        if (this.mFastMoveSpring != null) {
            return;
        }
        g c10 = l.h().c();
        this.mFastMoveSpring = c10;
        c10.q(this.mFastMoveSpringConfig);
        this.mFastMoveSpring.a(new c4.j() { // from class: com.coui.appcompat.seekbar.COUISeekBar.2
            @Override // c4.j
            public void onSpringUpdate(g gVar) {
                if (COUISeekBar.this.mFastMoveScaleOffsetX != gVar.e()) {
                    if (!COUISeekBar.this.isEnabled()) {
                        COUISeekBar.this.mFastMoveScaleOffsetX = 0.0f;
                    } else {
                        COUISeekBar.this.mFastMoveScaleOffsetX = (float) gVar.c();
                    }
                    COUISeekBar.this.invalidate();
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
        int normalSeekBarWidth = getNormalSeekBarWidth();
        COUILog.i(TAG, "COUISeekBar initPhysicsAnimator : setActiveFrame:" + normalSeekBarWidth);
        i8.h hVar = (i8.h) ((i8.h) new i8.h(4, 0.0f, (float) normalSeekBarWidth).I(this.mFlingValueHolder)).z(this.mFlingFrequency, this.mFlingDampingRatio).b(null);
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
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        PatternExploreByTouchHelper patternExploreByTouchHelper = new PatternExploreByTouchHelper(this);
        this.mExploreByTouchHelper = patternExploreByTouchHelper;
        K.j0(this, patternExploreByTouchHelper);
        K.t0(this, 1);
        this.mExploreByTouchHelper.invalidateRoot();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setTextSize(getResources().getDimensionPixelSize(a9.d.f6573j0));
        this.mTextPaint.setShadowLayer(TEXT_SHADOW_RADIUS, 0.0f, TEXT_SHADOW_DY, this.mTextColor);
        this.mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mFmi = this.mTextPaint.getFontMetricsInt();
        setThumbBitmap();
    }

    private void invalidateProgress(MotionEvent motionEvent) {
        float start;
        float x10 = motionEvent.getX();
        float seekBarWidth = getSeekBarWidth();
        float f10 = this.mCurProgressRadius;
        float f11 = seekBarWidth + (2.0f * f10);
        float f12 = this.mCurPaddingHorizontal - f10;
        if (isLayoutRtl()) {
            start = (((getWidth() - x10) - getStart()) - f12) / f11;
        } else {
            start = ((x10 - getStart()) - f12) / f11;
        }
        this.mScale = Math.max(0.0f, Math.min(start, 1.0f));
        int progressLimit = getProgressLimit(Math.round((this.mScale * (getMax() - getMin())) + getMin()));
        int i10 = this.mProgress;
        int i11 = this.mRealProgress;
        setLocalProgress(progressLimit);
        invalidate();
        if (i10 != this.mProgress) {
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(this, this.mRealProgress, true);
            }
            if (i11 != this.mRealProgress) {
                performFeedback();
            }
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
            this.mProgressHeight = this.mBackgroundHeight;
            this.mProgressEnlargeScale = this.mBackgroundEnlargeScale;
        }
    }

    private void setDeformationScale(float f10) {
        if (f10 > 1.0f) {
            f10 = ((f10 - 1.0f) * 5.0f) + 1.0f;
        } else if (f10 < 0.0f) {
            f10 *= 5.0f;
        }
        this.mScale = Math.max(-1.0f, Math.min(f10, 2.0f));
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

    private void setValueForLabel(TextDrawable textDrawable, String str) {
        textDrawable.setText(str);
        if (isLayoutRtl()) {
            int start = getStart();
            textDrawable.setBounds(start, 0 - textDrawable.getIntrinsicHeight(), textDrawable.getIntrinsicWidth() + start, 0);
        } else {
            int width = getWidth() - getEnd();
            textDrawable.setBounds(width, 0 - textDrawable.getIntrinsicHeight(), width - textDrawable.getIntrinsicWidth(), 0);
        }
        Rect rect = new Rect(textDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        textDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(textDrawable);
    }

    private void startFastMoveAnimation(float f10) {
        g fastMoveSpring = getFastMoveSpring();
        if (fastMoveSpring.c() == fastMoveSpring.e()) {
            int i10 = this.mMax - this.mMin;
            if (f10 >= 95.0f) {
                int i11 = this.mProgress;
                float f11 = i10;
                if (i11 <= MAX_FAST_MOVE_PERCENT * f11 && i11 >= f11 * MIN_FAST_MOVE_PERCENT) {
                    fastMoveSpring.n(1.0d);
                    return;
                }
                return;
            }
            if (f10 <= -95.0f) {
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
        float y10 = motionEvent.getY();
        if (y10 >= 0.0f && y10 <= view.getHeight()) {
            return true;
        }
        return false;
    }

    private void trackTouchEvent(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float f10 = x10 - this.mLastX;
        int i10 = this.mMax - this.mMin;
        if (isLayoutRtl()) {
            f10 = -f10;
        }
        float f11 = i10;
        setTouchScale((this.mProgress / f11) + ((f10 * calculateDamping(x10)) / getSeekBarWidth()));
        int progressLimit = getProgressLimit(Math.round((this.mScale * f11) + getMin()));
        int i11 = this.mProgress;
        int i12 = this.mRealProgress;
        setLocalProgress(progressLimit);
        invalidate();
        if (i11 != this.mProgress) {
            this.mLastX = x10;
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(this, this.mRealProgress, true);
            }
            if (i12 != this.mRealProgress) {
                performFeedback();
            }
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(100);
            startFastMoveAnimation(this.mVelocityTracker.getXVelocity());
        }
    }

    private void trackTouchEventByFinger(MotionEvent motionEvent) {
        int start;
        float f10;
        int round = Math.round(((motionEvent.getX() - this.mLastX) * calculateDamping(motionEvent.getX())) + this.mLastX);
        int width = getWidth();
        int width2 = (getWidth() - getStart()) - getEnd();
        if (isLayoutRtl()) {
            if (round <= width - getStart()) {
                if (round >= getEnd()) {
                    start = (width - round) - getEnd();
                    f10 = start / width2;
                }
                f10 = 1.0f;
            }
            f10 = 0.0f;
        } else {
            if (round >= getStart()) {
                if (round <= width - getEnd()) {
                    start = round - getStart();
                    f10 = start / width2;
                }
                f10 = 1.0f;
            }
            f10 = 0.0f;
        }
        this.mScale = Math.max(0.0f, Math.min(f10, 1.0f));
        int progressLimit = getProgressLimit(Math.round((this.mScale * (getMax() - getMin())) + getMin()));
        int i10 = this.mProgress;
        int i11 = this.mRealProgress;
        setLocalProgress(progressLimit);
        invalidate();
        if (i10 != this.mProgress) {
            this.mLastX = round;
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(this, this.mRealProgress, true);
            }
            if (i11 != this.mRealProgress) {
                performFeedback();
            }
        }
    }

    private void updateBehavior() {
        if (this.mIsPhysicsEnable && this.mPhysicalAnimator != null && this.mFlingBehavior != null) {
            int normalSeekBarWidth = getNormalSeekBarWidth();
            COUILog.i(TAG, "COUISeekBar updateBehavior : setActiveFrame:" + normalSeekBarWidth);
            this.mFlingBehavior.g0(0.0f, (float) normalSeekBarWidth);
        }
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
        float start;
        float seekBarWidth = getSeekBarWidth();
        float f11 = this.mCurProgressRadius;
        float f12 = seekBarWidth + (2.0f * f11);
        float f13 = this.mCurPaddingHorizontal - f11;
        if (isLayoutRtl()) {
            start = (((getWidth() - f10) - getStart()) - f13) / f12;
        } else {
            start = ((f10 - getStart()) - f13) / f12;
        }
        startTransitionAnim(getProgressLimit(Math.round((start * (getMax() - getMin())) + getMin())), true);
    }

    public void checkThumbPosChange(int i10) {
        checkThumbPosChange(i10, true, true);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return super.dispatchHoverEvent(motionEvent);
    }

    public void drawActiveTrack(Canvas canvas, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        int seekBarCenterY = getSeekBarCenterY();
        if (!this.mShowThumb) {
            float f18 = this.mCurPaddingHorizontal;
            float f19 = this.mCurProgressRadius;
            f13 = f10 + (f19 * 2.0f);
            f14 = f18 - f19;
            f11 = f14;
            f12 = f13;
        } else {
            float f20 = this.mCurPaddingHorizontal;
            float f21 = this.mThumbOutHeight;
            float f22 = this.mThumbOutRadius;
            f11 = ((f21 / 2.0f) - f22) + f20;
            float f23 = f10 - (f21 - (f22 * 2.0f));
            float f24 = this.mCurProgressRadius;
            float f25 = f20 - f24;
            f12 = f10 + (f24 * 2.0f);
            f13 = f23;
            f14 = f25;
        }
        RectF rectF = this.mClipProgressRect;
        float f26 = seekBarCenterY;
        float f27 = this.mCurProgressHeight;
        float f28 = this.mWidthDeformedValue;
        rectF.top = (f26 - (f27 / 2.0f)) + f28;
        rectF.bottom = (f26 + (f27 / 2.0f)) - f28;
        if (this.mIsStartFromMiddle) {
            if (isLayoutRtl()) {
                f16 = getWidth() / 2.0f;
                f17 = f16 - ((getRealScale(this.mScale) - 0.5f) * f13);
                RectF rectF2 = this.mClipProgressRect;
                float f29 = f12 / 2.0f;
                rectF2.left = f16 - f29;
                rectF2.right = f29 + f16;
                f15 = f17;
            } else {
                float width = getWidth() / 2.0f;
                float realScale = width + ((getRealScale(this.mScale) - 0.5f) * f13);
                RectF rectF3 = this.mClipProgressRect;
                float f30 = f12 / 2.0f;
                rectF3.left = width - f30;
                rectF3.right = f30 + width;
                f15 = realScale;
                f17 = width;
                f16 = f15;
            }
        } else if (isLayoutRtl()) {
            float start = getStart() + f11 + f13;
            f17 = start - (getRealScale(this.mScale) * f13);
            RectF rectF4 = this.mClipProgressRect;
            float start2 = getStart() + f14 + f12;
            float f31 = this.mHeightBottomDeformedUpValue;
            rectF4.right = (start2 - f31) + this.mHeightBottomDeformedDownValue;
            RectF rectF5 = this.mClipProgressRect;
            rectF5.left = (rectF5.right - f12) - (this.mHeightTopDeformedUpValue - f31);
            f15 = f17;
            f16 = start;
        } else {
            float start3 = f11 + getStart();
            float realScale2 = start3 + (getRealScale(this.mScale) * f13);
            RectF rectF6 = this.mClipProgressRect;
            float start4 = getStart() + f14;
            float f32 = this.mHeightBottomDeformedDownValue;
            float f33 = this.mHeightBottomDeformedUpValue;
            rectF6.left = (start4 - f32) + f33;
            RectF rectF7 = this.mClipProgressRect;
            rectF7.right = ((((rectF7.left + f12) + this.mHeightTopDeformedUpValue) - f33) + f32) - this.mHeightTopDeformedDownValue;
            f15 = realScale2;
            f16 = f15;
            f17 = start3;
        }
        if (this.mShowProgress) {
            drawProgress(canvas, seekBarCenterY, f17, f16);
        }
        float f34 = this.mThumbOutHeight;
        float f35 = f15 - (f34 / 2.0f);
        float f36 = f15 + (f34 / 2.0f);
        this.mLabelX = ((f36 - f35) / 2.0f) + f35;
        if (this.mShowThumb) {
            drawThumb(canvas, seekBarCenterY, f35, f36);
        }
        if (this.mShowText) {
            drawText(canvas, seekBarCenterY);
        }
    }

    public void drawInactiveTrack(Canvas canvas) {
        boolean z10;
        float start = (getStart() + this.mCurPaddingHorizontal) - this.mCurBackgroundRadius;
        float width = ((getWidth() - getEnd()) - this.mCurPaddingHorizontal) + this.mCurBackgroundRadius;
        int seekBarCenterY = getSeekBarCenterY();
        if (this.mIsSupportSmoothRoundCorner && this.mBackgroundRoundCornerWeight != 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.mShadowRadiusSize > 0) {
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(0.0f);
            this.mPaint.setColor(0);
            this.mPaint.setShadowLayer(this.mShadowRadiusSize, 0.0f, 0.0f, this.mShadowColor);
            RectF rectF = this.mBackgroundRect;
            int i10 = this.mShadowRadiusSize;
            float f10 = seekBarCenterY;
            float f11 = this.mCurBackgroundHeight;
            rectF.set(start - (i10 / 2), (f10 - (f11 / 2.0f)) - (i10 / 2), (i10 / 2) + width, f10 + (f11 / 2.0f) + (i10 / 2));
            if (z10) {
                OplusCanvas oplusCanvas = new OplusCanvas(canvas);
                RectF rectF2 = this.mBackgroundRect;
                float f12 = this.mCurBackgroundRadius;
                oplusCanvas.drawSmoothRoundRect(rectF2, f12, f12, this.mPaint, this.mBackgroundRoundCornerWeight);
            } else {
                RectF rectF3 = this.mBackgroundRect;
                float f13 = this.mCurBackgroundRadius;
                canvas.drawRoundRect(rectF3, f13, f13, this.mPaint);
            }
            this.mPaint.clearShadowLayer();
            this.mPaint.setStyle(Paint.Style.FILL);
        }
        this.mPaint.setColor(this.mBackgroundColor);
        if (isLayoutRtl()) {
            RectF rectF4 = this.mBackgroundRect;
            float f14 = (start - this.mHeightTopDeformedUpValue) + this.mHeightTopDeformedDownValue;
            float f15 = seekBarCenterY;
            float f16 = this.mCurBackgroundHeight;
            float f17 = this.mWidthDeformedValue;
            rectF4.set(f14, f15 - ((f16 / 2.0f) - f17), (width - this.mHeightBottomDeformedUpValue) + this.mHeightBottomDeformedDownValue, f15 + ((f16 / 2.0f) - f17));
        } else {
            RectF rectF5 = this.mBackgroundRect;
            float f18 = (start - this.mHeightBottomDeformedDownValue) + this.mHeightBottomDeformedUpValue;
            float f19 = seekBarCenterY;
            float f20 = this.mCurBackgroundHeight;
            float f21 = this.mWidthDeformedValue;
            rectF5.set(f18, f19 - ((f20 / 2.0f) - f21), (width + this.mHeightTopDeformedUpValue) - this.mHeightTopDeformedDownValue, f19 + ((f20 / 2.0f) - f21));
        }
        if (z10) {
            OplusCanvas oplusCanvas2 = new OplusCanvas(canvas);
            RectF rectF6 = this.mBackgroundRect;
            float f22 = this.mCurBackgroundRadius;
            oplusCanvas2.drawSmoothRoundRect(rectF6, f22, f22, this.mPaint, this.mBackgroundRoundCornerWeight);
            return;
        }
        RectF rectF7 = this.mBackgroundRect;
        float f23 = this.mCurBackgroundRadius;
        canvas.drawRoundRect(rectF7, f23, f23, this.mPaint);
    }

    public void ensureLabelsAdded(String str) {
        setValueForLabel(this.mTextDrawable, str);
    }

    public void ensureLabelsRemoved() {
        ViewUtils.getContentViewOverlay(this).remove(this.mTextDrawable);
    }

    public int getColor(View view, ColorStateList colorStateList, int i10) {
        if (colorStateList == null) {
            return i10;
        }
        return colorStateList.getColorForState(view.getDrawableState(), i10);
    }

    public int getEnd() {
        return getPaddingEnd();
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

    public int getSeekBarCenterY() {
        return getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) >> 1);
    }

    public int getSeekBarWidth() {
        return (int) (((getWidth() - getStart()) - getEnd()) - (this.mCurPaddingHorizontal * 2.0f));
    }

    public int getStart() {
        return getPaddingStart();
    }

    public void handleMotionEventDown(MotionEvent motionEvent) {
        this.mTouchDownX = motionEvent.getX();
        this.mLastX = motionEvent.getX();
    }

    public void handleMotionEventMove(MotionEvent motionEvent) {
        float f10;
        float seekBarWidth = getSeekBarWidth();
        int i10 = this.mMax;
        int i11 = this.mMin;
        int i12 = i10 - i11;
        if (i12 > 0) {
            f10 = (this.mProgress * seekBarWidth) / i12;
        } else {
            f10 = 0.0f;
        }
        float f11 = f10 + i11;
        if (this.mIsStartFromMiddle && Float.compare(f11, seekBarWidth / 2.0f) == 0 && Math.abs(motionEvent.getX() - this.mLastX) < 20.0f) {
            return;
        }
        if (this.mIsDragging && this.mStartDragging) {
            int i13 = this.mMoveType;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
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
        float x10 = motionEvent.getX();
        if (Math.abs(x10 - this.mTouchDownX) > this.mTouchSlop) {
            stopDeformationFling();
            startDrag();
            touchAnim();
            this.mLastX = x10;
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
            animForClick(motionEvent.getX());
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
        OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onStopTrackingTouch(this);
        }
    }

    public /* bridge */ /* synthetic */ void onAnimationStart(i8.c cVar) {
        super.onAnimationStart(cVar);
    }

    @Override // i8.b
    public void onAnimationUpdate(i8.c cVar) {
        float f10;
        Object n10 = cVar.n();
        if (n10 == null) {
            return;
        }
        float floatValue = ((Float) n10).floatValue();
        int normalSeekBarWidth = getNormalSeekBarWidth();
        if (isLayoutRtl()) {
            float f11 = normalSeekBarWidth;
            f10 = (f11 - floatValue) / f11;
        } else {
            f10 = floatValue / normalSeekBarWidth;
        }
        setFlingScale(f10);
        float f12 = this.mProgress;
        setLocalProgress(getProgressLimit(Math.round((this.mMax - this.mMin) * this.mScale) + this.mMin));
        invalidate();
        if (f12 != this.mProgress) {
            this.mLastX = floatValue + getStart();
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(this, this.mRealProgress, true);
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
        float seekBarWidth = getSeekBarWidth();
        drawInactiveTrack(canvas);
        drawActiveTrack(canvas, seekBarWidth);
    }

    public void onEnlargeAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        float f10 = this.mBackgroundRadius;
        float f11 = this.mBackgroundEnlargeScale;
        this.mCurBackgroundRadius = f10 + (((f10 * f11) - f10) * animatedFraction);
        float f12 = this.mProgressRadius;
        float f13 = this.mProgressEnlargeScale;
        this.mCurProgressRadius = f12 + (((f12 * f13) - f12) * animatedFraction);
        float f14 = this.mBackgroundHeight;
        this.mCurBackgroundHeight = f14 + (((f11 * f14) - f14) * animatedFraction);
        float f15 = this.mProgressHeight;
        this.mCurProgressHeight = f15 + (((f13 * f15) - f15) * animatedFraction);
        float f16 = this.mPaddingHorizontal;
        this.mCurPaddingHorizontal = f16 + (animatedFraction * ((this.mHorizontalPaddingScale * f16) - f16));
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i10);
        int paddingTop = this.mSeekbarMinHeight + getPaddingTop() + getPaddingBottom();
        if (1073741824 != mode || size < paddingTop) {
            size = paddingTop;
        }
        int i12 = this.mMaxWidth;
        if (i12 > 0 && size2 > i12) {
            size2 = i12;
        }
        setMeasuredDimension(size2, size);
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
        stopPhysicsMove();
        updateBehavior();
    }

    public void onStartTrackingTouch() {
        onStartTrackingTouch(true);
    }

    public void onStopTrackingTouch() {
        onStopTrackingTouch(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if (r0 != 3) goto L36;
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
            if (r0 == 0) goto L6b
            if (r0 == r3) goto L39
            r2 = 2
            if (r0 == r2) goto L2a
            if (r0 == r1) goto L39
            goto L9e
        L2a:
            r4.clearDeformationValue()
            r4.initVelocityTrackerIfNotExists()
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            r0.addMovement(r5)
            r4.handleMotionEventMove(r5)
            goto L9e
        L39:
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            if (r0 == 0) goto L64
            r1 = 1000(0x3e8, float:1.401E-42)
            r2 = 1174011904(0x45fa0000, float:8000.0)
            r0.computeCurrentVelocity(r1, r2)
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            float r0 = r0.getXVelocity()
            r4.mFlingVelocity = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onTouchEvent ACTION_UP mFlingVelocity = "
            r0.append(r1)
            float r1 = r4.mFlingVelocity
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "COUISeekBar"
            com.coui.appcompat.log.COUILog.i(r1, r0)
        L64:
            r4.recycleVelocityTracker()
            r4.handleMotionEventUp(r5)
            goto L9e
        L6b:
            android.animation.AnimatorSet r0 = r4.mClickAnimatorSet
            if (r0 == 0) goto L77
            r0.removeAllListeners()
            android.animation.AnimatorSet r0 = r4.mClickAnimatorSet
            r0.cancel()
        L77:
            boolean r0 = r4.isDeformationFling()
            if (r0 != 0) goto L80
            r4.stopPhysicsMove()
        L80:
            boolean r0 = r4.mIsPhysicsEnable
            if (r0 == 0) goto L8f
            i8.k r0 = r4.mPhysicalAnimator
            if (r0 != 0) goto L8f
            android.content.Context r0 = r4.getContext()
            r4.initPhysicsAnimator(r0)
        L8f:
            r4.initOrResetVelocityTracker()
            android.view.VelocityTracker r0 = r4.mVelocityTracker
            r0.addMovement(r5)
            r4.mIsDragging = r2
            r4.mStartDragging = r2
            r4.handleMotionEventDown(r5)
        L9e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.seekbar.COUISeekBar.onTouchEvent(android.view.MotionEvent):boolean");
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
            this.mVibratorExecutor.execute(new Runnable() { // from class: com.coui.appcompat.seekbar.COUISeekBar.7
                @Override // java.lang.Runnable
                public void run() {
                    COUISeekBar cOUISeekBar = COUISeekBar.this;
                    if (cOUISeekBar.mIsDragging) {
                        LinearmotorVibrator linearmotorVibrator = (LinearmotorVibrator) cOUISeekBar.mLinearMotorVibrator;
                        int i10 = cOUISeekBar.mProgress;
                        int i11 = cOUISeekBar.mMin;
                        VibrateUtils.setLinearMotorVibratorStrength(linearmotorVibrator, VibrateUtils.TYPE_STEPABLE_REGULATE, i10 - i11, cOUISeekBar.mMax - i11, 200, 2000);
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
            this.mVibratorExecutor.execute(new Runnable() { // from class: com.coui.appcompat.seekbar.COUISeekBar.6
                @Override // java.lang.Runnable
                public void run() {
                    COUISeekBar cOUISeekBar = COUISeekBar.this;
                    if (cOUISeekBar.mIsDragging) {
                        cOUISeekBar.performHapticFeedback(COUIHapticFeedbackConstants.STEPPING_SHORT_VIBRATE, 0);
                    }
                }
            });
            return;
        }
        performHapticFeedback(COUIHapticFeedbackConstants.EDGE_SHORT_VIBRATE, 0);
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mRefreshStyle);
        TypedArray typedArray = null;
        if (TextUtils.equals(resourceTypeName, "attr")) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, m.f6903s1, this.mRefreshStyle, 0);
        } else if (TextUtils.equals(resourceTypeName, "style")) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, m.f6903s1, 0, this.mRefreshStyle);
        }
        if (typedArray != null) {
            this.mProgressColor = getColor(this, typedArray.getColorStateList(m.f6743F1), COUIContextUtil.getColor(getContext(), a9.c.f6488l));
            this.mBackgroundColor = getColor(this, typedArray.getColorStateList(m.f6915v1), COUIContextUtil.getColor(getContext(), a9.c.f6485i));
            this.mThumbShadowColor = typedArray.getColor(m.f6811W1, COUIContextUtil.getColor(getContext(), a9.c.f6492p));
            this.mTextColor = typedArray.getColor(m.f6799T1, getResources().getColor(a9.c.f6491o));
            invalidate();
            typedArray.recycle();
        }
    }

    public void releaseAnim() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(PropertyValuesHolder.ofFloat("progressRadius", this.mCurProgressRadius, this.mProgressRadius), PropertyValuesHolder.ofFloat("backgroundRadius", this.mCurBackgroundRadius, this.mBackgroundRadius), PropertyValuesHolder.ofFloat("progressHeight", this.mCurProgressHeight, this.mProgressHeight), PropertyValuesHolder.ofFloat("backgroundHeight", this.mCurBackgroundHeight, this.mBackgroundHeight), PropertyValuesHolder.ofFloat("animatePadding", this.mCurPaddingHorizontal, this.mPaddingHorizontal));
        valueAnimator.setDuration(183L);
        valueAnimator.setInterpolator(PROGRESS_SCALE_INTERPOLATOR);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.COUISeekBar.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                COUISeekBar.this.mCurProgressRadius = ((Float) valueAnimator2.getAnimatedValue("progressRadius")).floatValue();
                COUISeekBar.this.mCurBackgroundRadius = ((Float) valueAnimator2.getAnimatedValue("backgroundRadius")).floatValue();
                COUISeekBar.this.mCurProgressHeight = ((Float) valueAnimator2.getAnimatedValue("progressHeight")).floatValue();
                COUISeekBar.this.mCurBackgroundHeight = ((Float) valueAnimator2.getAnimatedValue("backgroundHeight")).floatValue();
                COUISeekBar.this.mCurPaddingHorizontal = ((Float) valueAnimator2.getAnimatedValue("animatePadding")).floatValue();
                COUISeekBar.this.invalidate();
            }
        });
        this.mTouchAnimator.cancel();
        valueAnimator.start();
    }

    public void setBackgroundEnlargeScale(float f10) {
        this.mBackgroundEnlargeScale = f10;
        ensureSize();
        invalidate();
    }

    public void setBackgroundHeight(float f10) {
        this.mBackgroundHeight = f10;
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
        if (z10) {
            this.mThumbShadowRadiusSize = getContext().getResources().getDimensionPixelSize(a9.d.f6575k0);
        } else {
            this.mThumbShadowRadiusSize = 0;
        }
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

    public void setIncrement(int i10) {
        this.mIncrement = Math.abs(i10);
    }

    @Override // android.widget.ProgressBar
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setLocalMax(int i10) {
        this.mMax = i10;
        updateScale();
        super.setMax(i10);
    }

    public void setLocalMin(int i10) {
        this.mMin = i10;
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
        this.mMaxHeightDeformedValue = f10;
    }

    public void setMaxMovingDistance(int i10) {
        this.mMaxMovingDistance = i10;
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

    public void setPaddingHorizontal(float f10) {
        this.mPaddingHorizontal = f10;
        ensureSize();
        invalidate();
    }

    public void setPhysicalEnabled(boolean z10) {
        if (z10 == this.mIsPhysicsEnable) {
            return;
        }
        if (z10) {
            this.mIsPhysicsEnable = z10;
            updateBehavior();
        } else {
            stopPhysicsMove();
            this.mIsPhysicsEnable = z10;
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

    public void setProgressHeight(float f10) {
        this.mProgressHeight = f10;
        ensureSize();
        invalidate();
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

    public void setSeekBarBackgroundColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mBackgroundColorStateList = colorStateList;
            this.mBackgroundColor = getColor(this, colorStateList, COUIContextUtil.getColor(getContext(), a9.c.f6485i));
            invalidate();
        }
    }

    public void setStartFromMiddle(boolean z10) {
        this.mIsStartFromMiddle = z10;
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

    public void startDrag() {
        setPressed(true);
        onStartTrackingTouch(true);
        attemptClaimDrag();
    }

    public void startTransitionAnim(int i10, final boolean z10) {
        final float f10;
        Interpolator interpolator;
        AnimatorSet animatorSet = this.mClickAnimatorSet;
        if (animatorSet == null) {
            this.mClickAnimatorSet = new AnimatorSet();
        } else {
            animatorSet.removeAllListeners();
            this.mClickAnimatorSet.cancel();
        }
        this.mClickAnimatorSet.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.seekbar.COUISeekBar.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (COUISeekBar.this.mOnSeekBarChangeListener != null) {
                    OnSeekBarChangeListener onSeekBarChangeListener = COUISeekBar.this.mOnSeekBarChangeListener;
                    COUISeekBar cOUISeekBar = COUISeekBar.this;
                    onSeekBarChangeListener.onProgressChanged(cOUISeekBar, cOUISeekBar.mRealProgress, z10);
                }
                COUISeekBar.this.onStopTrackingTouch(z10);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUISeekBar.this.mOnSeekBarChangeListener != null) {
                    OnSeekBarChangeListener onSeekBarChangeListener = COUISeekBar.this.mOnSeekBarChangeListener;
                    COUISeekBar cOUISeekBar = COUISeekBar.this;
                    onSeekBarChangeListener.onProgressChanged(cOUISeekBar, cOUISeekBar.mRealProgress, z10);
                }
                COUISeekBar.this.onStopTrackingTouch(z10);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUISeekBar.this.onStartTrackingTouch(z10);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        int i11 = this.mProgress;
        final int seekBarWidth = getSeekBarWidth();
        int i12 = this.mMax - this.mMin;
        float f11 = 0.0f;
        if (i12 > 0) {
            f10 = seekBarWidth / i12;
        } else {
            f10 = 0.0f;
        }
        if (f10 > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i11 * f10, i10 * f10);
            if (!z10 && (interpolator = this.mCustomProgressAnimInterpolator) != null) {
                ofFloat.setInterpolator(interpolator);
            } else {
                ofFloat.setInterpolator(THUMB_ANIMATE_INTERPOLATOR);
            }
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.seekbar.COUISeekBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    COUISeekBar.this.setLocalProgress((int) (floatValue / f10));
                    COUISeekBar cOUISeekBar = COUISeekBar.this;
                    cOUISeekBar.mScale = (floatValue - (cOUISeekBar.mMin * f10)) / seekBarWidth;
                    cOUISeekBar.invalidate();
                }
            });
            if (!z10) {
                float f12 = this.mCustomProgressAnimDuration;
                if (f12 != -1.0f) {
                    this.mClickAnimatorSet.setDuration(f12);
                    this.mClickAnimatorSet.play(ofFloat);
                    this.mClickAnimatorSet.start();
                }
            }
            if (i12 > 0) {
                f11 = Math.abs(i10 - i11) / i12;
            }
            long j10 = f11 * 483.0f;
            if (j10 < 150) {
                j10 = 150;
            }
            this.mClickAnimatorSet.setDuration(j10);
            this.mClickAnimatorSet.play(ofFloat);
            this.mClickAnimatorSet.start();
        }
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
        if (this.mTouchAnimator.isRunning()) {
            this.mTouchAnimator.cancel();
        }
        this.mTouchAnimator.start();
    }

    public boolean touchInSeekBar(MotionEvent motionEvent, View view) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (x10 >= view.getPaddingLeft() && x10 <= view.getWidth() - view.getPaddingRight() && y10 >= 0.0f && y10 <= view.getHeight()) {
            return true;
        }
        return false;
    }

    public COUISeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a9.b.f6471i);
    }

    public void checkThumbPosChange(int i10, boolean z10, boolean z11) {
        if (this.mProgress != i10) {
            int i11 = this.mRealProgress;
            setLocalProgress(i10);
            OnSeekBarChangeListener onSeekBarChangeListener = this.mOnSeekBarChangeListener;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(this, this.mRealProgress, z11);
            }
            if (!z10 || i11 == this.mRealProgress) {
                return;
            }
            performFeedback();
        }
    }

    public void ensureLabelsAdded() {
        setValueForLabel(this.mTextDrawable, Integer.toString(this.mProgress));
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

    @Override // android.widget.ProgressBar
    public void setProgress(int i10, boolean z10) {
        setProgress(i10, z10, false);
    }

    public COUISeekBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, COUIContextUtil.isCOUIDarkTheme(context) ? a9.l.f6702h : a9.l.f6701g);
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
                    onSeekBarChangeListener.onProgressChanged(this, getRealProgress(max), z11);
                }
                invalidate();
            }
            resetDeformationValue();
        }
    }

    public COUISeekBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mScale = 0.0f;
        this.mEnableVibrator = true;
        this.mEnableAdaptiveVibrator = true;
        this.mHasMotorVibrator = true;
        this.mLinearMotorVibrator = null;
        this.mTouchSlop = 0;
        this.mProgress = 0;
        this.mOldProgress = 0;
        this.mMax = 100;
        this.mMin = 0;
        this.mIsDragging = false;
        this.mProgressColorStateList = null;
        this.mBackgroundColorStateList = null;
        this.mThumbColorStateList = null;
        this.mIsProgressFull = false;
        this.mIsSupportSmoothRoundCorner = false;
        this.mCustomProgressAnimDuration = -1.0f;
        this.mCustomProgressAnimInterpolator = null;
        this.mClipProgressPath = new Path();
        this.mClipProgressRect = new RectF();
        this.mProgressRect = new RectF();
        this.mTempRect = new RectF();
        this.mTouchAnimator = new AnimatorSet();
        this.mProgressScaleInterpolator = K.a.a(0.33f, 0.0f, 0.67f, 1.0f);
        this.mThumbAnimateInterpolator = K.a.a(0.3f, 0.0f, 0.1f, 1.0f);
        this.mShowProgress = false;
        this.mShowThumb = false;
        this.mIncrement = 1;
        this.mStartDragging = false;
        this.mBackgroundRect = new RectF();
        this.mMoveType = 1;
        this.mFastMoveSpringConfig = h.b(500.0d, 30.0d);
        this.mIsStartFromMiddle = false;
        this.mDamping = 0.0f;
        this.mInterpolator = K.a.a(0.3f, 0.0f, 0.1f, 1.0f);
        this.mIsPhysicsEnable = false;
        this.mFlingVelocity = 0.0f;
        this.mFlingFrequency = 2.8f;
        this.mFlingDampingRatio = 1.0f;
        this.mFlingLinearDamping = 15.0f;
        this.mMaxMovingDistance = 30;
        this.mMaxHeightDeformedValue = 28.5f;
        this.mMaxWidthDeformedValue = 4.7f;
        if (attributeSet != null) {
            this.mRefreshStyle = attributeSet.getStyleAttribute();
        }
        if (this.mRefreshStyle == 0) {
            this.mRefreshStyle = i10;
        }
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6903s1, i10, i11);
        this.mEnableVibrator = obtainStyledAttributes.getBoolean(m.f6723A1, true);
        this.mEnableAdaptiveVibrator = obtainStyledAttributes.getBoolean(m.f6907t1, false);
        this.mIsPhysicsEnable = obtainStyledAttributes.getBoolean(m.f6739E1, true);
        this.mShowProgress = obtainStyledAttributes.getBoolean(m.f6779O1, true);
        this.mShowThumb = obtainStyledAttributes.getBoolean(m.f6787Q1, true);
        this.mIsStartFromMiddle = obtainStyledAttributes.getBoolean(m.f6791R1, false);
        this.mIsProgressFull = obtainStyledAttributes.getBoolean(m.f6751H1, false);
        this.mBackgroundColorStateList = obtainStyledAttributes.getColorStateList(m.f6915v1);
        this.mProgressColorStateList = obtainStyledAttributes.getColorStateList(m.f6743F1);
        this.mThumbColorStateList = obtainStyledAttributes.getColorStateList(m.f6807V1);
        this.mBackgroundColor = getColor(this, this.mBackgroundColorStateList, COUIContextUtil.getColor(getContext(), a9.c.f6485i));
        ColorStateList colorStateList = this.mProgressColorStateList;
        Context context2 = getContext();
        int i12 = a9.c.f6488l;
        this.mProgressColor = getColor(this, colorStateList, COUIContextUtil.getColor(context2, i12));
        this.mThumbColor = getColor(this, this.mThumbColorStateList, COUIContextUtil.getColor(getContext(), i12));
        this.mShadowColor = obtainStyledAttributes.getColor(m.f6771M1, COUIContextUtil.getColor(getContext(), a9.c.f6490n));
        this.mThumbShadowColor = obtainStyledAttributes.getColor(m.f6811W1, COUIContextUtil.getColor(getContext(), a9.c.f6492p));
        this.mBackgroundRadius = obtainStyledAttributes.getDimension(m.f6923x1, getResources().getDimension(a9.d.f6545Z));
        this.mProgressRadius = obtainStyledAttributes.getDimension(m.f6763K1, getResources().getDimension(a9.d.f6569h0));
        this.mBackgroundRoundCornerWeight = obtainStyledAttributes.getFloat(m.f6927y1, 0.0f);
        this.mProgressRoundCornerWeight = obtainStyledAttributes.getFloat(m.f6767L1, 0.0f);
        this.mShadowRadiusSize = obtainStyledAttributes.getDimensionPixelSize(m.f6775N1, 0);
        this.mThumbShadowRadiusSize = obtainStyledAttributes.getDimensionPixelSize(m.f6815X1, 0);
        this.mInnerShadowRadiusSize = obtainStyledAttributes.getDimensionPixelSize(m.f6727B1, 0);
        this.mPaddingHorizontal = obtainStyledAttributes.getDimension(m.f6759J1, getResources().getDimension(a9.d.f6563f0));
        this.mBackgroundHeight = obtainStyledAttributes.getDimensionPixelSize(m.f6919w1, (int) (this.mBackgroundRadius * 2.0f));
        this.mProgressHeight = obtainStyledAttributes.getDimensionPixelSize(m.f6755I1, (int) (this.mProgressRadius * 2.0f));
        this.mSeekbarMinHeight = obtainStyledAttributes.getDimensionPixelOffset(m.f6735D1, getResources().getDimensionPixelSize(a9.d.f6577l0));
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(m.f6731C1, 0);
        this.mBackgroundEnlargeScale = obtainStyledAttributes.getFloat(m.f6911u1, BACKGROUND_RADIUS_SCALE);
        this.mProgressEnlargeScale = obtainStyledAttributes.getFloat(m.f6747G1, PROGRESS_RADIUS_SCALE);
        this.mShowText = obtainStyledAttributes.getBoolean(m.f6783P1, false);
        this.mTextContent = obtainStyledAttributes.getString(m.f6795S1);
        this.mTextColor = obtainStyledAttributes.getColor(m.f6799T1, getResources().getColor(a9.c.f6491o));
        this.mTextMarginTop = obtainStyledAttributes.getDimension(m.f6803U1, getResources().getDimension(a9.d.f6571i0));
        this.mIsSupportDeformation = obtainStyledAttributes.getBoolean(m.f6931z1, false);
        obtainStyledAttributes.recycle();
        this.mTextDrawable = new TextDrawable(getContext());
        this.mHasMotorVibrator = VibrateUtils.isLinearMotorVersion(context);
        this.mIsSupportSmoothRoundCorner = RoundCornerUtil.isVersionSupport();
        initView();
        ensureSize();
        initAnimation();
    }

    /* loaded from: classes.dex */
    public interface OnDeformedListener {
        default void onScaleChanged(DeformedValueBean deformedValueBean) {
        }

        default void onHeightDeformedChanged(float f10, float f11) {
        }
    }
}
