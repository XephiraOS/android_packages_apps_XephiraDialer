package com.coui.appcompat.progressbar;

import X8.m;
import X8.o;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.core.view.K;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class COUILoadingView extends View {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_TYPE = 1;
    private static final float LARGE_POINT_END_ALPHA = 1.0f;
    private static final float LARGE_POINT_START_ALPHA = 0.215f;
    public static final int LARGE_TYPE = 2;
    private static final float MEDIUM_POINT_END_ALPHA = 0.4f;
    private static final float MEDIUM_POINT_START_ALPHA = 0.1f;
    public static final int MEDIUM_TYPE = 1;
    private static final int ONE_CIRCLE_DEGREE = 360;
    private static final int ONE_CYCLE_DURATION = 480;
    private static final float ONE_THOUSAND_MILLISECOND = 1000.0f;
    public static final int ORIGINAL_ANGLE = -90;
    private static final int PROGRESS_POINT_COUNT = 6;
    private static final int SEMI_CIRCLE = 180;
    public static final int SMALL_TYPE = 0;
    public static final int SWIPT_ANGEL = 60;
    private static final String TAG = "COUILoadingView";
    private static final int TWO = 2;
    private String mAccessDescription;
    private ValueAnimator.AnimatorUpdateListener mAnimListener;
    private float mArcRadius;
    private RectF mArcRect;
    private Paint mBackGroundPaint;
    private COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction mCOUIViewTalkBalkInteraction;
    private float mCenterX;
    private float mCenterY;
    private Context mContext;
    private float mCurrentDegree;
    private float mCurrentStepProgress;
    private float mEndAlpha;
    private float mHalfHeight;
    private float mHalfStrokeWidth;
    private float mHalfWidth;
    private int mHeight;
    private boolean mIsAnimationCreated;
    private boolean mIsAnimationStarted;
    private int mLoadingType;
    private int mLoadingViewBgCircleColor;
    private int mLoadingViewColor;
    private float[] mPointsAlpha;
    private ValueAnimator mProgressAnimator;
    private Paint mProgressPaint;
    private float mStartAlpha;
    private float mStepDegree;
    private int mStrokeDefaultWidth;
    private int mStrokeLargeWidth;
    private int mStrokeMediumWidth;
    private float mStrokeWidth;
    private int mStyle;
    private COUIViewExplorerByTouchHelper mTouchHelper;
    private int mWidth;

    /* loaded from: classes.dex */
    public static class LoadingAnimUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        WeakReference<COUILoadingView> mWeakRef;

        public LoadingAnimUpdateListener(COUILoadingView cOUILoadingView) {
            this.mWeakRef = new WeakReference<>(cOUILoadingView);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            valueAnimator.getAnimatedFraction();
            COUILoadingView cOUILoadingView = this.mWeakRef.get();
            if (cOUILoadingView != null) {
                if (cOUILoadingView.isAttachedToWindow() && cOUILoadingView.getVisibility() == 0) {
                    cOUILoadingView.invalidate();
                } else {
                    Log.e(COUILoadingView.TAG, "LoadingView state error,cancelAnimations");
                    cOUILoadingView.cancelAnimations();
                }
            }
        }
    }

    public COUILoadingView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimations() {
        ValueAnimator valueAnimator = this.mProgressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    private void createAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mProgressAnimator = ofFloat;
        ofFloat.setDuration(480L);
        this.mProgressAnimator.setInterpolator(new COUILinearInterpolator());
        this.mProgressAnimator.addUpdateListener(new LoadingAnimUpdateListener(this));
        this.mProgressAnimator.setRepeatMode(1);
        this.mProgressAnimator.setRepeatCount(-1);
        this.mProgressAnimator.setInterpolator(new COUILinearInterpolator());
    }

    private void destroyAnimator() {
        ValueAnimator valueAnimator = this.mProgressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mProgressAnimator.removeAllListeners();
            this.mProgressAnimator.removeAllUpdateListeners();
            this.mProgressAnimator = null;
        }
    }

    private void drawBackgroundCircle(Canvas canvas) {
        float f10 = this.mHalfWidth;
        canvas.drawCircle(f10, f10, this.mArcRadius, this.mBackGroundPaint);
    }

    private void initArcRect() {
        this.mHalfStrokeWidth = this.mStrokeWidth / 2.0f;
        this.mHalfWidth = getWidth() / 2;
        this.mHalfHeight = getHeight() / 2;
        this.mArcRadius = this.mHalfWidth - this.mHalfStrokeWidth;
        float f10 = this.mHalfWidth;
        float f11 = this.mArcRadius;
        this.mArcRect = new RectF(f10 - f11, f10 - f11, f10 + f11, f10 + f11);
    }

    private void initBackgroundPaint() {
        Paint paint = new Paint(1);
        this.mBackGroundPaint = paint;
        paint.setColor(this.mLoadingViewBgCircleColor);
        this.mBackGroundPaint.setStyle(Paint.Style.STROKE);
        this.mBackGroundPaint.setStrokeWidth(this.mStrokeWidth);
    }

    private void initProgressPaint() {
        Paint paint = new Paint(1);
        this.mProgressPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setColor(this.mLoadingViewColor);
        this.mProgressPaint.setStrokeWidth(this.mStrokeWidth);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    private void startAnimations() {
        ValueAnimator valueAnimator = this.mProgressAnimator;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.mProgressAnimator.cancel();
            }
            this.mProgressAnimator.start();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mIsAnimationCreated) {
            createAnimator();
            this.mIsAnimationCreated = true;
        }
        if (!this.mIsAnimationStarted && getVisibility() == 0) {
            startAnimations();
            this.mIsAnimationStarted = true;
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        destroyAnimator();
        this.mIsAnimationCreated = false;
        this.mIsAnimationStarted = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.mCurrentStepProgress = ((((float) SystemClock.uptimeMillis()) % ONE_THOUSAND_MILLISECOND) * 360.0f) / ONE_THOUSAND_MILLISECOND;
        drawBackgroundCircle(canvas);
        canvas.save();
        canvas.rotate(-90.0f, this.mHalfWidth, this.mHalfHeight);
        if (this.mArcRect == null) {
            initArcRect();
        }
        RectF rectF = this.mArcRect;
        float f10 = this.mCurrentStepProgress;
        canvas.drawArc(rectF, f10 - 30.0f, (2.0f - Math.abs((180.0f - f10) / 180.0f)) * 60.0f, false, this.mProgressPaint);
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.mArcRect == null) {
            initArcRect();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        initArcRect();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (getVisibility() == 0 && isAttachedToWindow()) {
            if (!this.mIsAnimationCreated) {
                createAnimator();
                this.mIsAnimationCreated = true;
            }
            if (!this.mIsAnimationStarted) {
                startAnimations();
                this.mIsAnimationStarted = true;
                return;
            }
            return;
        }
        cancelAnimations();
        this.mIsAnimationStarted = false;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (i10 == 0 && isAttachedToWindow() && getVisibility() == 0 && getWindowVisibility() == 0) {
            startAnimations();
        } else {
            cancelAnimations();
        }
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5250Y2, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5250Y2, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mLoadingViewColor = typedArray.getColor(o.f5265a3, 0);
            this.mLoadingViewBgCircleColor = typedArray.getColor(o.f5257Z2, 0);
            typedArray.recycle();
        }
        initProgressPaint();
        initBackgroundPaint();
        invalidate();
    }

    public void setHeight(int i10) {
        this.mHeight = i10;
    }

    public void setLoadingType(int i10) {
        this.mLoadingType = i10;
    }

    public void setLoadingViewBgCircleColor(int i10) {
        this.mLoadingViewBgCircleColor = i10;
        initBackgroundPaint();
    }

    public void setLoadingViewColor(int i10) {
        this.mLoadingViewColor = i10;
        initProgressPaint();
    }

    public void setWidth(int i10) {
        this.mWidth = i10;
    }

    public COUILoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4362U);
    }

    public COUILoadingView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, X8.c.f4362U, 0);
    }

    public COUILoadingView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.mPointsAlpha = new float[6];
        this.mWidth = 0;
        this.mHeight = 0;
        this.mLoadingType = 1;
        this.mStepDegree = 60.0f;
        this.mAccessDescription = null;
        this.mStartAlpha = 0.1f;
        this.mEndAlpha = MEDIUM_POINT_END_ALPHA;
        this.mIsAnimationCreated = false;
        this.mIsAnimationStarted = false;
        this.mCOUIViewTalkBalkInteraction = new COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction() { // from class: com.coui.appcompat.progressbar.COUILoadingView.1
            private int mVirtualViewId = -1;

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public CharSequence getClassName() {
                return null;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public int getCurrentPosition() {
                return -1;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public int getDisablePosition() {
                return -1;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public void getItemBounds(int i12, Rect rect) {
                if (i12 == 0) {
                    rect.set(0, 0, COUILoadingView.this.mWidth, COUILoadingView.this.mHeight);
                }
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public int getItemCounts() {
                return 1;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public CharSequence getItemDescription(int i12) {
                if (COUILoadingView.this.mAccessDescription != null) {
                    return COUILoadingView.this.mAccessDescription;
                }
                return getClass().getSimpleName();
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public int getVirtualViewAt(float f10, float f11) {
                if (f10 >= 0.0f && f10 <= COUILoadingView.this.mWidth && f11 >= 0.0f && f11 <= COUILoadingView.this.mHeight) {
                    return 0;
                }
                return -1;
            }

            @Override // com.coui.appcompat.touchhelper.COUIViewExplorerByTouchHelper.COUIViewTalkBalkInteraction
            public void performAction(int i12, int i13, boolean z10) {
            }
        };
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        this.mContext = context;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5250Y2, i10, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(X8.f.f4492E2);
        this.mWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5289d3, dimensionPixelSize);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(o.f5273b3, dimensionPixelSize);
        this.mLoadingType = obtainStyledAttributes.getInteger(o.f5281c3, 1);
        this.mLoadingViewColor = obtainStyledAttributes.getColor(o.f5265a3, 0);
        this.mLoadingViewBgCircleColor = obtainStyledAttributes.getColor(o.f5257Z2, 0);
        obtainStyledAttributes.recycle();
        this.mStrokeDefaultWidth = context.getResources().getDimensionPixelSize(X8.f.f4497F0);
        this.mStrokeMediumWidth = context.getResources().getDimensionPixelSize(X8.f.f4490E0);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(X8.f.f4483D0);
        this.mStrokeLargeWidth = dimensionPixelSize2;
        this.mStrokeWidth = this.mStrokeDefaultWidth;
        int i12 = this.mLoadingType;
        if (1 == i12) {
            this.mStrokeWidth = this.mStrokeMediumWidth;
            this.mStartAlpha = 0.1f;
            this.mEndAlpha = MEDIUM_POINT_END_ALPHA;
        } else if (2 == i12) {
            this.mStrokeWidth = dimensionPixelSize2;
            this.mStartAlpha = LARGE_POINT_START_ALPHA;
            this.mEndAlpha = 1.0f;
        }
        this.mCenterX = this.mWidth >> 1;
        this.mCenterY = this.mHeight >> 1;
        COUIViewExplorerByTouchHelper cOUIViewExplorerByTouchHelper = new COUIViewExplorerByTouchHelper(this);
        this.mTouchHelper = cOUIViewExplorerByTouchHelper;
        cOUIViewExplorerByTouchHelper.setCOUIViewTalkBalkInteraction(this.mCOUIViewTalkBalkInteraction);
        K.j0(this, this.mTouchHelper);
        K.t0(this, 1);
        this.mAccessDescription = context.getString(m.f5007f);
        initProgressPaint();
        initBackgroundPaint();
    }
}
