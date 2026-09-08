package com.coui.appcompat.roundRect;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class COUIRoundDrawable extends Drawable {
    private COUIRoundDrawableState drawableState;
    private Paint fillPaint;
    private Path fillPath;
    private boolean pathDirty;
    private RectF rectF;
    private Paint strokePaint;
    private Path strokePath;
    private PorterDuffColorFilter strokeTintFilter;
    private PorterDuffColorFilter tintFilter;

    public COUIRoundDrawable() {
        this(new COUIRoundDrawableState());
    }

    private void calculatePath() {
        this.fillPath = COUIShapePath.getRoundRectPath(this.fillPath, getBoundsAsRectF(), this.drawableState.radius);
    }

    private void calculateStrokePath() {
        this.strokePath = COUIShapePath.getRoundRectPath(this.strokePath, getBoundsAsRectF(), this.drawableState.radius);
    }

    private PorterDuffColorFilter calculateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    private boolean hasFill() {
        Paint paint = this.fillPaint;
        if ((paint != null && paint.getColor() != 0) || this.tintFilter != null) {
            return true;
        }
        return false;
    }

    private boolean hasStroke() {
        Paint paint = this.strokePaint;
        if ((paint != null && paint.getStrokeWidth() > 0.0f && this.strokePaint.getColor() != 0) || this.strokeTintFilter != null) {
            return true;
        }
        return false;
    }

    private static int modulateAlpha(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    private boolean updateColorsForState(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.drawableState.fillColor != null && color2 != (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, (color2 = this.fillPaint.getColor())))) {
            this.fillPaint.setColor(colorForState2);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.drawableState.strokeColor != null && color != (colorForState = this.drawableState.strokeColor.getColorForState(iArr, (color = this.strokePaint.getColor())))) {
            this.strokePaint.setColor(colorForState);
            return true;
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.alpha));
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.alpha));
        if (this.pathDirty) {
            calculateStrokePath();
            calculatePath();
            this.pathDirty = false;
        }
        if (hasFill()) {
            canvas.drawPath(this.fillPath, this.fillPaint);
        }
        if (hasStroke()) {
            canvas.drawPath(this.strokePath, this.strokePaint);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void invalidateIgnoreCalculate() {
        this.pathDirty = false;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        if (!super.isStateful() && (((colorStateList = this.drawableState.tintList) == null || !colorStateList.isStateful()) && (((colorStateList2 = this.drawableState.strokeTintList) == null || !colorStateList2.isStateful()) && (((colorStateList3 = this.drawableState.strokeColor) == null || !colorStateList3.isStateful()) && ((colorStateList4 = this.drawableState.fillColor) == null || !colorStateList4.isStateful()))))) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.drawableState = new COUIRoundDrawableState(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean updateColorsForState = updateColorsForState(iArr);
        if (updateColorsForState) {
            invalidateSelf();
        }
        return updateColorsForState;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        COUIRoundDrawableState cOUIRoundDrawableState = this.drawableState;
        if (cOUIRoundDrawableState.alpha != i10) {
            cOUIRoundDrawableState.alpha = i10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        COUIRoundDrawableState cOUIRoundDrawableState = this.drawableState;
        if (cOUIRoundDrawableState.colorFilter != colorFilter) {
            cOUIRoundDrawableState.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    public void setFillColor(ColorStateList colorStateList) {
        COUIRoundDrawableState cOUIRoundDrawableState = this.drawableState;
        if (cOUIRoundDrawableState.fillColor != colorStateList) {
            cOUIRoundDrawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setRadius(float f10) {
        this.drawableState.radius = f10;
    }

    public void setStroke(float f10, int i10) {
        setStroke(f10, ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        COUIRoundDrawableState cOUIRoundDrawableState = this.drawableState;
        cOUIRoundDrawableState.tintList = colorStateList;
        PorterDuffColorFilter calculateTintFilter = calculateTintFilter(colorStateList, cOUIRoundDrawableState.tintMode);
        this.strokeTintFilter = calculateTintFilter;
        this.tintFilter = calculateTintFilter;
        invalidateIgnoreCalculate();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        COUIRoundDrawableState cOUIRoundDrawableState = this.drawableState;
        cOUIRoundDrawableState.tintMode = mode;
        PorterDuffColorFilter calculateTintFilter = calculateTintFilter(cOUIRoundDrawableState.tintList, mode);
        this.strokeTintFilter = calculateTintFilter;
        this.tintFilter = calculateTintFilter;
        invalidateIgnoreCalculate();
    }

    public COUIRoundDrawable(COUIRoundDrawableState cOUIRoundDrawableState) {
        this.fillPaint = new Paint(1);
        this.strokePaint = new Paint(1);
        this.rectF = new RectF();
        this.fillPath = new Path();
        this.strokePath = new Path();
        this.drawableState = cOUIRoundDrawableState;
        this.fillPaint.setStyle(Paint.Style.FILL);
        this.strokePaint.setStyle(Paint.Style.STROKE);
    }

    public void setStroke(float f10, ColorStateList colorStateList) {
        COUIRoundDrawableState cOUIRoundDrawableState = this.drawableState;
        if (cOUIRoundDrawableState.strokeWidth == f10 && cOUIRoundDrawableState.strokeColor == colorStateList) {
            return;
        }
        cOUIRoundDrawableState.strokeWidth = f10;
        cOUIRoundDrawableState.strokeColor = colorStateList;
        if (onStateChange(getState())) {
            return;
        }
        invalidateSelf();
    }

    public void setFillColor(int i10) {
        setFillColor(ColorStateList.valueOf(i10));
    }

    /* loaded from: classes.dex */
    public static final class COUIRoundDrawableState extends Drawable.ConstantState {
        public int alpha;
        public ColorFilter colorFilter;
        public ColorStateList fillColor;
        public float radius;
        public ColorStateList strokeColor;
        public ColorStateList strokeTintList;
        public float strokeWidth;
        public ColorStateList tintList;
        public PorterDuff.Mode tintMode;

        public COUIRoundDrawableState() {
            this.colorFilter = null;
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.alpha = 255;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            COUIRoundDrawable cOUIRoundDrawable = new COUIRoundDrawable(this);
            cOUIRoundDrawable.pathDirty = true;
            return cOUIRoundDrawable;
        }

        public COUIRoundDrawableState(COUIRoundDrawableState cOUIRoundDrawableState) {
            this.colorFilter = null;
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.alpha = 255;
            this.colorFilter = cOUIRoundDrawableState.colorFilter;
            this.fillColor = cOUIRoundDrawableState.fillColor;
            this.strokeColor = cOUIRoundDrawableState.strokeColor;
            this.strokeTintList = cOUIRoundDrawableState.strokeTintList;
            this.tintList = cOUIRoundDrawableState.tintList;
            this.strokeWidth = cOUIRoundDrawableState.strokeWidth;
            this.radius = cOUIRoundDrawableState.radius;
        }
    }
}
