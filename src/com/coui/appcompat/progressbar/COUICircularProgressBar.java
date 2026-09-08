package com.coui.appcompat.progressbar;

import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.progressbar.COUICircularProgressDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class COUICircularProgressBar extends View {
    private static final int FOLLOW_THEME_PROGRESS_BAR_TRACK_ALPHA = 89;
    public static final int LARGE_SIZE = 1;
    public static final int MEDIUM_SIZE = 0;
    private static final String TAG = "COUICircularProgressBar";
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 10;
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_FOLLOW_THEME = 2;
    public static final int TYPE_ON_IMAGE = 1;
    private AccessibilityEventSender mAccessibilityEventSender;
    private float mCenterX;
    private float mCenterY;
    private Context mContext;
    private final COUICircularProgressDrawable mDrawable;
    private boolean mError;
    private int mErrorDrawableTint;
    private int mHeight;
    private int mInnerPadding;
    private AccessibilityManager mManager;
    private int mMax;
    private int mPauseDrawableTint;
    private boolean mPaused;
    private int mProgress;
    private int mProgressBarColor;
    private int mProgressBarSize;
    private int mProgressBarTrackColor;
    private int mProgressBarType;
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
            COUICircularProgressBar.this.sendAccessibilityEvent(4);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ProgressBarSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ProgressBarType {
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.progressbar.COUICircularProgressBar.SavedState.1
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
        int mMax;
        int mProgress;

        public String toString() {
            return "COUICircularProgressBar.SavedState { " + Integer.toHexString(System.identityHashCode(this)) + " mProgress = " + this.mProgress + " mMax = " + this.mMax + " }";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeValue(Integer.valueOf(this.mProgress));
            parcel.writeValue(Integer.valueOf(this.mMax));
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
            this.mMax = ((Integer) parcel.readValue(getClass().getClassLoader())).intValue();
        }
    }

    public COUICircularProgressBar(Context context) {
        this(context, null);
    }

    private void configDrawable() {
        if (2 == this.mProgressBarType) {
            this.mDrawable.setTrackColor(B.a.w(this.mProgressBarTrackColor, 89));
        } else {
            this.mDrawable.setTrackColor(this.mProgressBarTrackColor);
        }
        COUICircularProgressDrawable cOUICircularProgressDrawable = this.mDrawable;
        boolean z10 = true;
        if (1 != this.mProgressBarType) {
            z10 = false;
        }
        cOUICircularProgressDrawable.setIsDrawShadow(z10);
        this.mDrawable.setProgressColor(this.mProgressBarColor);
        this.mDrawable.setPauseIconColor(this.mPauseDrawableTint);
        this.mDrawable.setErrorIconColor(this.mErrorDrawableTint);
        COUICircularProgressDrawable cOUICircularProgressDrawable2 = this.mDrawable;
        float f10 = this.mCenterX;
        int i10 = this.mInnerPadding;
        cOUICircularProgressDrawable2.setProperties(f10 + i10, this.mCenterY + i10, this.mWidth - (i10 * 2), this.mStrokeWidth);
        this.mDrawable.setProgressBarErrorSize(this.mContext.getResources().getDimensionPixelSize(X8.f.f4511H0), this.mContext.getResources().getDimensionPixelSize(X8.f.f4553N0));
        this.mDrawable.invalidateSelf();
        invalidate();
    }

    private void init() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.mManager = (AccessibilityManager) this.mContext.getSystemService("accessibility");
        setProgress(this.mProgress);
        setMax(this.mMax);
        configDrawable();
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

    public void error() {
        if (!this.mDrawable.isAnimating() && !this.mPaused && !this.mError) {
            this.mDrawable.error();
            this.mError = true;
        }
    }

    public int getMax() {
        return this.mMax;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public float getVisualProgress() {
        return this.mDrawable.getVisualProgress();
    }

    public boolean isError() {
        return this.mError;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        this.mDrawable.setHostView(this);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        COUICircularProgressDrawable cOUICircularProgressDrawable = this.mDrawable;
        if (cOUICircularProgressDrawable != null) {
            cOUICircularProgressDrawable.recycle();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.mWidth;
        int i13 = this.mInnerPadding;
        setMeasuredDimension(i12 + (i13 * 2), this.mHeight + (i13 * 2));
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
        setProgress(savedState.mProgress, false);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mProgress = this.mProgress;
        return savedState;
    }

    public void pause() {
        int i10 = this.mProgressBarType;
        if (i10 != 0 && 2 != i10) {
            if (!this.mDrawable.isAnimating() && !this.mError && !this.mPaused) {
                this.mDrawable.pause();
                this.mPaused = true;
                return;
            }
            return;
        }
        Log.w(TAG, "Default type circular progress bar can not pause!");
    }

    public void recover() {
        if (!this.mDrawable.isAnimating() && !this.mPaused && this.mError) {
            this.mDrawable.recover();
            this.mError = false;
        }
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5294e0, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5294e0, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mProgressBarColor = typedArray.getColor(o.f5334j0, 0);
            this.mProgressBarTrackColor = typedArray.getColor(o.f5358m0, 0);
            this.mPauseDrawableTint = typedArray.getColor(o.f5318h0, 0);
            this.mErrorDrawableTint = typedArray.getColor(o.f5302f0, 0);
            typedArray.recycle();
        }
    }

    public void resume() {
        if (!this.mDrawable.isAnimating() && !this.mError && this.mPaused) {
            this.mDrawable.resume();
            this.mPaused = false;
        }
    }

    public void setMax(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 != this.mMax) {
            this.mMax = i10;
            this.mDrawable.setMax(i10);
            int i11 = this.mProgress;
            int i12 = this.mMax;
            if (i11 > i12) {
                this.mProgress = i12;
            }
        }
    }

    public void setOnProgressChangedListener(COUICircularProgressDrawable.OnProgressChangedListener onProgressChangedListener) {
        COUICircularProgressDrawable cOUICircularProgressDrawable = this.mDrawable;
        if (cOUICircularProgressDrawable != null) {
            cOUICircularProgressDrawable.setOnProgressChangedListener(onProgressChangedListener);
        }
    }

    public void setOnProgressStateAnimationListener(COUICircularProgressDrawable.OnProgressStateAnimatorListener onProgressStateAnimatorListener) {
        COUICircularProgressDrawable cOUICircularProgressDrawable = this.mDrawable;
        if (cOUICircularProgressDrawable != null) {
            cOUICircularProgressDrawable.setOnProgressStateAnimatorListener(onProgressStateAnimatorListener);
        }
    }

    public void setProgress(int i10) {
        setProgress(i10, true);
    }

    public void setProgressBarType(int i10) {
        this.mProgressBarType = i10;
        configDrawable();
    }

    public void setProgressSize(int i10) {
        this.mProgressBarSize = i10;
        if (i10 == 0) {
            int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(X8.f.f4574Q0);
            this.mWidth = dimensionPixelOffset;
            this.mHeight = dimensionPixelOffset;
            this.mStrokeWidth = this.mStrokeMediumWidth;
        } else if (1 == i10) {
            int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(X8.f.f4560O0);
            this.mWidth = dimensionPixelOffset2;
            this.mHeight = dimensionPixelOffset2;
            this.mStrokeWidth = this.mStrokeLargeWidth;
        }
        this.mCenterX = this.mWidth >> 1;
        this.mCenterY = this.mHeight >> 1;
        configDrawable();
        requestLayout();
    }

    public COUICircularProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4378f);
    }

    public void setProgress(int i10, boolean z10) {
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = this.mMax;
        if (i10 > i11) {
            i10 = i11;
        }
        if (i10 != this.mProgress) {
            this.mProgress = i10;
            this.mDrawable.setProgress(i10, z10);
        }
        onProgressRefresh();
    }

    public COUICircularProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mProgressBarSize = 0;
        this.mProgressBarType = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mInnerPadding = 0;
        this.mStrokeWidth = 0;
        this.mMax = 100;
        this.mProgress = 0;
        this.mPaused = false;
        this.mError = false;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.mContext = context;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(X8.f.f4560O0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5294e0, i10, 0);
        this.mWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5374o0, dimensionPixelSize);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(o.f5342k0, dimensionPixelSize);
        this.mProgressBarType = obtainStyledAttributes.getInteger(o.f5366n0, 0);
        this.mProgressBarSize = obtainStyledAttributes.getInteger(o.f5350l0, 1);
        this.mProgressBarColor = obtainStyledAttributes.getColor(o.f5334j0, 0);
        this.mProgressBarTrackColor = obtainStyledAttributes.getColor(o.f5358m0, 0);
        this.mPauseDrawableTint = obtainStyledAttributes.getColor(o.f5318h0, 0);
        this.mErrorDrawableTint = obtainStyledAttributes.getColor(o.f5302f0, 0);
        this.mProgress = obtainStyledAttributes.getInteger(o.f5326i0, this.mProgress);
        this.mMax = obtainStyledAttributes.getInteger(o.f5310g0, this.mMax);
        obtainStyledAttributes.recycle();
        this.mInnerPadding = context.getResources().getDimensionPixelSize(X8.f.f4504G0);
        this.mStrokeMediumWidth = context.getResources().getDimensionPixelSize(X8.f.f4581R0);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(X8.f.f4567P0);
        this.mStrokeLargeWidth = dimensionPixelSize2;
        int i11 = this.mProgressBarSize;
        if (i11 == 0) {
            this.mStrokeWidth = this.mStrokeMediumWidth;
        } else if (1 == i11) {
            this.mStrokeWidth = dimensionPixelSize2;
        }
        this.mCenterX = this.mWidth >> 1;
        this.mCenterY = this.mHeight >> 1;
        this.mDrawable = new COUICircularProgressDrawable(context);
        init();
    }
}
