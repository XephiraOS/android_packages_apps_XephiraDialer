package com.coui.appcompat.scanning;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.uiutil.UIUtil;

/* loaded from: classes.dex */
public class COUIScanningImageView extends View {
    public static final int ANIMATION_DURATION_WIDE_WIDGET = 1200;
    private PathInterpolator mAnimInterpolator;
    private int mAnimationDuration;
    private final Path mClipPath;
    private Path mCustomClipPath;
    private int[] mGradientColors;
    private float[] mGradientPositions;
    private final Paint mPaint;
    private int mRadius;
    private final RectF mRect;
    private ValueAnimator mScanningAnimator;
    private float mSlope;

    public COUIScanningImageView(Context context) {
        super(context);
        this.mClipPath = new Path();
        this.mRect = new RectF();
        this.mPaint = new Paint();
        init(context);
    }

    private void init(Context context) {
        this.mAnimationDuration = 1200;
        this.mSlope = 0.45f;
        this.mGradientColors = new int[]{UIUtil.CONSTANT_COLOR_MASK, 1442840575, 1442840575, UIUtil.CONSTANT_COLOR_MASK};
        this.mGradientPositions = new float[]{0.0f, 0.4f, 0.5f, 1.0f};
        this.mAnimInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
    }

    private void refreshAnimator(int i10, int i11) {
        final int i12 = i10 / 3;
        ValueAnimator valueAnimator = this.mScanningAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mScanningAnimator.end();
        }
        int i13 = i12 * 2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0 - i13, i10 + i13);
        this.mScanningAnimator = ofFloat;
        ofFloat.setInterpolator(this.mAnimInterpolator);
        this.mScanningAnimator.setDuration(this.mAnimationDuration);
        this.mScanningAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.scanning.COUIScanningImageView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float floatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                COUIScanningImageView.this.mPaint.setShader(new LinearGradient(floatValue, COUIScanningImageView.this.mSlope * floatValue, floatValue + i12, (i12 + floatValue) * COUIScanningImageView.this.mSlope, COUIScanningImageView.this.mGradientColors, COUIScanningImageView.this.mGradientPositions, Shader.TileMode.CLAMP));
                COUIScanningImageView.this.invalidate();
            }
        });
    }

    public void endScanningAnim() {
        ValueAnimator valueAnimator = this.mScanningAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mScanningAnimator.end();
            this.mScanningAnimator.cancel();
        }
    }

    public int getAnimationDuration() {
        return this.mAnimationDuration;
    }

    public Path getClipPath() {
        return this.mCustomClipPath;
    }

    public int getEndColor() {
        return this.mGradientColors[3];
    }

    public int getMidColor() {
        return this.mGradientColors[1];
    }

    public int getRadius() {
        return this.mRadius;
    }

    public float getSlope() {
        return this.mSlope;
    }

    public int getStartColor() {
        return this.mGradientColors[0];
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ValueAnimator valueAnimator = this.mScanningAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mClipPath.reset();
            Path path = this.mCustomClipPath;
            if (path == null) {
                this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
                int height = getHeight() / 2;
                this.mRadius = height;
                this.mClipPath.addRoundRect(this.mRect, height, height, Path.Direction.CW);
            } else {
                this.mClipPath.addPath(path);
            }
            canvas.clipPath(this.mClipPath);
            canvas.drawRect(this.mRect, this.mPaint);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        refreshAnimator(i10, i11);
    }

    public void setAnimationDuration(int i10) {
        this.mAnimationDuration = i10;
        ValueAnimator valueAnimator = this.mScanningAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(i10);
        }
    }

    public void setClipPath(Path path) {
        this.mCustomClipPath = path;
    }

    public void setEndColor(int i10) {
        this.mGradientColors[3] = i10;
    }

    public void setMidColor(int i10) {
        int[] iArr = this.mGradientColors;
        iArr[1] = i10;
        iArr[2] = i10;
    }

    public void setRadius(int i10) {
        this.mRadius = i10;
    }

    public void setSlope(float f10) {
        this.mSlope = f10;
    }

    public void setStartColor(int i10) {
        this.mGradientColors[0] = i10;
    }

    public void startScanningAnim() {
        ValueAnimator valueAnimator = this.mScanningAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public COUIScanningImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mClipPath = new Path();
        this.mRect = new RectF();
        this.mPaint = new Paint();
        init(context);
    }

    public COUIScanningImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mClipPath = new Path();
        this.mRect = new RectF();
        this.mPaint = new Paint();
        init(context);
    }

    public COUIScanningImageView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mClipPath = new Path();
        this.mRect = new RectF();
        this.mPaint = new Paint();
        init(context);
    }
}
