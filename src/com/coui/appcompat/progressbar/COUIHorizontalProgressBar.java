package com.coui.appcompat.progressbar;

import X8.o;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class COUIHorizontalProgressBar extends ProgressBar {
    private static final int DEFAULT_BACKGROUND_COLOR = Color.argb(12, 0, 0, 0);
    private static final int DEFAULT_PROGRESS_COLOR = Color.parseColor("#FF2AD181");
    private static final int[] mAttrArray = {X8.c.f4395n0};
    private ColorStateList mBackgroundColor;
    private RectF mBackgroundRect;
    private Context mContext;
    private boolean mNeedRadius;
    private Paint mPaint;
    private Path mPath;
    private ColorStateList mProgressColor;
    private Path mProgressPath;
    private RectF mProgressRect;
    private int mRadius;
    private int mStyle;

    public COUIHorizontalProgressBar(Context context) {
        this(context, null);
    }

    private int getStateColor(ColorStateList colorStateList, int i10) {
        if (colorStateList == null) {
            return i10;
        }
        return colorStateList.getColorForState(getDrawableState(), i10);
    }

    public boolean isLayoutRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        this.mProgressPath.reset();
        this.mPath.reset();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.mPaint.setColor(getStateColor(this.mBackgroundColor, DEFAULT_BACKGROUND_COLOR));
        this.mBackgroundRect.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        Path path = this.mPath;
        RectF rectF = this.mBackgroundRect;
        int i10 = this.mRadius;
        Path.Direction direction = Path.Direction.CCW;
        path.addRoundRect(rectF, i10, i10, direction);
        canvas.clipPath(this.mPath);
        RectF rectF2 = this.mBackgroundRect;
        int i11 = this.mRadius;
        canvas.drawRoundRect(rectF2, i11, i11, this.mPaint);
        float progress = getProgress() / getMax();
        if (isLayoutRtl()) {
            this.mProgressRect.set(Math.round((getWidth() - getPaddingRight()) - (progress * width)), getPaddingTop(), r1 + width, getHeight() - getPaddingBottom());
        } else {
            this.mProgressRect.set(Math.round(getPaddingLeft() - ((1.0f - progress) * width)), getPaddingTop(), r1 + width, getHeight() - getPaddingBottom());
        }
        this.mPaint.setColor(getStateColor(this.mProgressColor, DEFAULT_PROGRESS_COLOR));
        this.mProgressPath.addRoundRect(this.mProgressRect, this.mRadius, 0.0f, direction);
        this.mProgressPath.op(this.mPath, Path.Op.INTERSECT);
        canvas.drawPath(this.mProgressPath, this.mPaint);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int i14;
        super.onSizeChanged(i10, i11, i12, i13);
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        int paddingTop = (i11 - getPaddingTop()) - getPaddingBottom();
        if (this.mNeedRadius) {
            if (paddingRight >= paddingTop) {
                i14 = paddingTop / 2;
            } else {
                i14 = paddingRight / 2;
            }
            this.mRadius = i14;
            return;
        }
        this.mRadius = 0;
    }

    public void refresh() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(mAttrArray);
        obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5336j2, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5336j2, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mBackgroundColor = typedArray.getColorStateList(o.f5344k2);
            this.mProgressColor = typedArray.getColorStateList(o.f5352l2);
            typedArray.recycle();
        }
    }

    public void setBackgroundColor(ColorStateList colorStateList) {
        this.mBackgroundColor = colorStateList;
    }

    public void setProgressColor(ColorStateList colorStateList) {
        this.mProgressColor = colorStateList;
    }

    public COUIHorizontalProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4358Q);
    }

    public COUIHorizontalProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, X8.c.f4358Q);
        this.mPaint = new Paint();
        this.mBackgroundRect = new RectF();
        this.mProgressRect = new RectF();
        this.mRadius = Integer.MAX_VALUE;
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        this.mContext = context;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(mAttrArray);
        obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, o.f5336j2, i10, 0);
        this.mBackgroundColor = obtainStyledAttributes2.getColorStateList(o.f5344k2);
        this.mProgressColor = obtainStyledAttributes2.getColorStateList(o.f5352l2);
        this.mNeedRadius = obtainStyledAttributes2.getBoolean(o.f5360m2, true);
        obtainStyledAttributes2.recycle();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        setLayerType(1, this.mPaint);
        this.mPath = new Path();
        this.mProgressPath = new Path();
    }
}
