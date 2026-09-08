package com.coui.appcompat.progressbar;

import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class COUICircleProgressBar extends View {
    public static final int ACCURACY = 2;
    private static final int ALPHA_SHOW_DURATION = 360;
    private static final float BASE_PROGRESS_POINT_ALPHA = 0.215f;
    public static final int DEFAULT_TYPE = 0;
    public static final int LARGE_TYPE = 2;
    public static final int MEDIUM_TYPE = 1;
    private static final long ONE_CIRCLE_DEGREE = 360;
    public static final int ORIGINAL_ANGLE = -90;
    private static final int PROGRESS_POINT_COUNT = 360;
    private static final String TAG = "COUICircleProgressBar";
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 10;
    private AccessibilityEventSender mAccessibilityEventSender;
    private float mArcRadius;
    private RectF mArcRect;
    private Paint mBackGroundPaint;
    private float mCenterX;
    private float mCenterY;
    private Context mContext;
    private int mCurrentStepProgress;
    private int mHalfStrokeWidth;
    private int mHalfWidth;
    private int mHeight;
    private AccessibilityManager mManager;
    private int mMax;
    private ArrayList<ProgressPoint> mPointList;
    private int mPointRadius;
    private int mPreStepProgress;
    private int mProgress;
    private int mProgressBarBgCircleColor;
    private int mProgressBarColor;
    private int mProgressBarType;
    private Paint mProgressPaint;
    private float mStepDegree;
    private int mStrokeDefaultWidth;
    private int mStrokeLargeWidth;
    private int mStrokeMediumWidth;
    private int mStrokeWidth;
    private int mStyle;
    private int mWidth;

    /* loaded from: classes.dex */
    public class AccessibilityEventSender implements Runnable {
        private AccessibilityEventSender() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUICircleProgressBar.this.sendAccessibilityEvent(4);
        }
    }

    /* loaded from: classes.dex */
    public class ProgressPoint {
        float mCurrentAlpha;

        public ProgressPoint() {
        }

        public float getCurrentAlpha() {
            return this.mCurrentAlpha;
        }

        public void setCurrentAlpha(float f10) {
            this.mCurrentAlpha = f10;
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.progressbar.COUICircleProgressBar.SavedState.1
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

        public String toString() {
            return "COUICircleProgressBar.SavedState { " + Integer.toHexString(System.identityHashCode(this)) + " mProgress = " + this.mProgress + " }";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.mProgress));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = ((Integer) parcel.readValue(null)).intValue();
        }
    }

    public COUICircleProgressBar(Context context) {
        this(context, null);
    }

    private void drawBackgroudCicle(Canvas canvas) {
        this.mBackGroundPaint.setStrokeWidth(this.mStrokeWidth);
        int i10 = this.mHalfWidth;
        canvas.drawCircle(i10, i10, this.mArcRadius, this.mBackGroundPaint);
    }

    private void init() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        for (int i10 = 0; i10 < 360; i10++) {
            this.mPointList.add(new ProgressPoint());
        }
        initBackgroundPaint();
        initProgressPaint();
        setProgress(this.mProgress);
        setMax(this.mMax);
        this.mManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
    }

    private void initBackgroundPaint() {
        Paint paint = new Paint(1);
        this.mBackGroundPaint = paint;
        paint.setColor(this.mProgressBarBgCircleColor);
        this.mBackGroundPaint.setStyle(Paint.Style.STROKE);
    }

    private void initProgressPaint() {
        Paint paint = new Paint(1);
        this.mProgressPaint = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mProgressPaint.setColor(this.mProgressBarColor);
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeWidth(this.mStrokeWidth);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
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

    private void verifyProgress() {
        int i10 = this.mMax;
        if (i10 > 0) {
            int i11 = (int) (this.mProgress / (i10 / 360.0f));
            this.mCurrentStepProgress = i11;
            if (360 - i11 < 2) {
                this.mCurrentStepProgress = 360;
            }
            this.mPreStepProgress = this.mCurrentStepProgress;
        } else {
            this.mPreStepProgress = 0;
            this.mCurrentStepProgress = 0;
        }
        invalidate();
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender = this.mAccessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        drawBackgroudCicle(canvas);
        canvas.save();
        int i10 = this.mHalfWidth;
        canvas.rotate(-90.0f, i10, i10);
        canvas.drawArc(this.mArcRect, 0.0f, this.mCurrentStepProgress, false, this.mProgressPaint);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public void onProgressRefresh() {
        AccessibilityManager accessibilityManager = this.mManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
            scheduleAccessibilityEventSender();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.mProgress);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mProgress = this.mProgress;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mHalfStrokeWidth = this.mStrokeWidth / 2;
        this.mHalfWidth = getWidth() / 2;
        this.mArcRadius = r3 - this.mHalfStrokeWidth;
        int i14 = this.mHalfWidth;
        float f10 = this.mArcRadius;
        this.mArcRect = new RectF(i14 - f10, i14 - f10, i14 + f10, i14 + f10);
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5231W, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5231W, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mProgressBarColor = typedArray.getColor(o.f5262a0, 0);
            this.mProgressBarBgCircleColor = typedArray.getColor(o.f5254Z, 0);
            typedArray.recycle();
        }
    }

    public void setHeight(int i10) {
        this.mHeight = i10;
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
        }
        verifyProgress();
    }

    public void setProgress(int i10) {
        Log.i(TAG, "setProgress: " + i10);
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
        verifyProgress();
        onProgressRefresh();
    }

    public void setProgressBarBgCircleColor(int i10) {
        this.mProgressBarBgCircleColor = i10;
        initBackgroundPaint();
    }

    public void setProgressBarColor(int i10) {
        this.mProgressBarColor = i10;
        initProgressPaint();
    }

    public void setProgressBarType(int i10) {
        this.mProgressBarType = i10;
    }

    public void setWidth(int i10) {
        this.mWidth = i10;
    }

    public COUICircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4376e);
    }

    public COUICircleProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mWidth = 0;
        this.mHeight = 0;
        this.mProgressBarType = 0;
        this.mStrokeWidth = 0;
        this.mPointRadius = 0;
        this.mMax = 100;
        this.mProgress = 0;
        this.mCurrentStepProgress = 0;
        this.mPreStepProgress = -1;
        this.mStepDegree = 1.0f;
        this.mPointList = new ArrayList<>();
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.mContext = context;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5231W, i10, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(X8.f.f4492E2);
        this.mWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5286d0, dimensionPixelSize);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(o.f5270b0, dimensionPixelSize);
        this.mProgressBarType = obtainStyledAttributes.getInteger(o.f5278c0, 0);
        this.mProgressBarColor = obtainStyledAttributes.getColor(o.f5262a0, 0);
        this.mProgressBarBgCircleColor = obtainStyledAttributes.getColor(o.f5254Z, 0);
        this.mProgress = obtainStyledAttributes.getInteger(o.f5247Y, this.mProgress);
        this.mMax = obtainStyledAttributes.getInteger(o.f5239X, this.mMax);
        obtainStyledAttributes.recycle();
        this.mStrokeDefaultWidth = context.getResources().getDimensionPixelSize(X8.f.f4497F0);
        this.mStrokeMediumWidth = context.getResources().getDimensionPixelSize(X8.f.f4490E0);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(X8.f.f4483D0);
        this.mStrokeLargeWidth = dimensionPixelSize2;
        this.mStrokeWidth = this.mStrokeDefaultWidth;
        int i11 = this.mProgressBarType;
        if (1 == i11) {
            this.mStrokeWidth = this.mStrokeMediumWidth;
        } else if (2 == i11) {
            this.mStrokeWidth = dimensionPixelSize2;
        }
        this.mPointRadius = this.mStrokeWidth >> 1;
        this.mCenterX = this.mWidth >> 1;
        this.mCenterY = this.mHeight >> 1;
        init();
    }
}
