package com.coui.appcompat.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.textutil.COUIChangeTextUtil;

/* loaded from: classes.dex */
public class TextDrawable extends ShapeDrawable {
    private final int WIDTH;
    private Context mContext;
    private int mFontSize;
    private int mMarginBottom;
    private int mPaddingEnd;
    private String mText;
    private int mTextHeight;
    private Paint mTextPaint;

    public TextDrawable(Context context) {
        super(new RectShape());
        this.mText = "";
        this.WIDTH = 144;
        this.mContext = context;
        this.mFontSize = context.getResources().getDimensionPixelOffset(a9.d.f6560e0);
        this.mTextHeight = context.getResources().getDimensionPixelOffset(a9.d.f6551b0);
        this.mMarginBottom = context.getResources().getDimensionPixelOffset(a9.d.f6554c0);
        this.mPaddingEnd = context.getResources().getDimensionPixelOffset(a9.d.f6557d0);
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setColor(COUIContextUtil.getAttrColor(context, X8.c.f4348G));
        this.mTextPaint.setAntiAlias(true);
        this.mTextPaint.setStyle(Paint.Style.FILL);
        this.mTextPaint.setTypeface(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
        if (isLayoutRtl()) {
            this.mTextPaint.setTextAlign(Paint.Align.LEFT);
        } else {
            this.mTextPaint.setTextAlign(Paint.Align.RIGHT);
        }
        this.mTextPaint.setStrokeWidth(0.0f);
        getPaint().setColor(0);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.translate(bounds.left, bounds.top);
        this.mTextPaint.setTextSize(this.mFontSize);
        if (isLayoutRtl()) {
            canvas.drawText(this.mText, this.mPaddingEnd, this.mFontSize, this.mTextPaint);
        } else {
            canvas.drawText(this.mText, 144 - this.mPaddingEnd, this.mFontSize, this.mTextPaint);
        }
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mTextHeight + this.mMarginBottom;
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return 144;
    }

    public boolean isLayoutRtl() {
        if (this.mContext.getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public void setText(String str) {
        this.mText = str;
    }
}
