package com.coui.appcompat.reddot;

import X8.n;
import X8.o;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class COUIRedDotDrawable extends Drawable {
    private COUIHintRedDotHelper mCOUIHintRedDotHelper;
    private int mPointMode;
    private int mPointNumber;
    private RectF mRectF;

    public COUIRedDotDrawable(int i10, int i11, Context context, RectF rectF) {
        this.mPointMode = i10;
        this.mPointNumber = i11;
        this.mRectF = rectF;
        this.mCOUIHintRedDotHelper = new COUIHintRedDotHelper(context, null, o.f5225V1, 0, n.f5047s);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mCOUIHintRedDotHelper.drawRedPoint(canvas, this.mPointMode, String.valueOf(this.mPointNumber), this.mRectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
