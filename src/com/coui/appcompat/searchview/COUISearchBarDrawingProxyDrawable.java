package com.coui.appcompat.searchview;

import android.animation.ArgbEvaluator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: COUISearchBarBackgroundDrawable.java */
/* loaded from: classes.dex */
public class COUISearchBarDrawingProxyDrawable extends Drawable {
    private static final ArgbEvaluator DEFAULT_EVALUATOR = new ArgbEvaluator();
    private int mButtonDividerColor;
    private int mCurrentBackgroundColor;
    private final Rect mDividerRect = new Rect();
    private final Path mNormalBackgroundPath = new Path();
    private final Paint mPressFeedbackPaint = new Paint(1);
    private final Paint mNormalPaint = new Paint(1);
    private float mDividerAlpha = 0.0f;

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPressFeedbackPaint.setStyle(Paint.Style.FILL);
        this.mPressFeedbackPaint.setColor(this.mCurrentBackgroundColor);
        canvas.drawPath(this.mNormalBackgroundPath, this.mPressFeedbackPaint);
        this.mNormalPaint.setColor(((Integer) DEFAULT_EVALUATOR.evaluate(this.mDividerAlpha, 0, Integer.valueOf(this.mButtonDividerColor))).intValue());
        canvas.drawRect(this.mDividerRect, this.mNormalPaint);
    }

    public int getCurrentBackgroundColor() {
        return this.mCurrentBackgroundColor;
    }

    public Path getNormalBackgroundPath() {
        return this.mNormalBackgroundPath;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void setButtonDividerColor(int i10) {
        this.mButtonDividerColor = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        invalidateSelf();
    }

    public void setCurrentBackgroundColor(int i10) {
        this.mCurrentBackgroundColor = i10;
        invalidateSelf();
    }

    public void setDividerAlpha(float f10) {
        this.mDividerAlpha = f10;
        invalidateSelf();
    }

    public void setDividerRect(Rect rect) {
        this.mDividerRect.set(rect);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }
}
