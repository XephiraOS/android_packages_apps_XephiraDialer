package com.coui.appcompat.preference;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.coui.appcompat.roundRect.COUIRoundRectUtil;
import x4.i;

/* loaded from: classes.dex */
public class COUIRecommendedDrawable extends i {
    private int mColor;
    private Paint mPaint = new Paint(1);
    private Path mPath = new Path();
    private float mRadius;

    public COUIRecommendedDrawable(float f10, int i10) {
        this.mRadius = f10;
        this.mColor = i10;
        this.mPaint.setColor(this.mColor);
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mPath.reset();
        Path path = COUIRoundRectUtil.getInstance().getPath(getBounds(), this.mRadius);
        this.mPath = path;
        canvas.drawPath(path, this.mPaint);
    }
}
