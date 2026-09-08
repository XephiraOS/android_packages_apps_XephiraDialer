package com.coui.appcompat.reddot;

import X8.e;
import X8.f;
import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.coui.appcompat.roundRect.COUIRoundRectUtil;
import com.coui.appcompat.textutil.COUIChangeTextUtil;

/* loaded from: classes.dex */
public class COUIHintRedDotHelper {
    public static final int CONSTANT_VALUE_0 = 0;
    public static final int CONSTANT_VALUE_10 = 10;
    public static final int CONSTANT_VALUE_100 = 100;
    public static final int CONSTANT_VALUE_1000 = 1000;
    private static final int MAX_ALPHA_VALUE = 255;
    private static final int RATIO = 2;
    private int mBgColor;
    private Paint mBgPaint;
    private int mCornerRadius;
    private int mDotCornerRadius;
    private int mDotDiameter;
    private int mEllipsisDiameter;
    private int mEllipsisSpacing;
    private int mLargeWidth;
    private int mMediumWidth;
    private int mNaviSmallWidth;
    private int mSmallWidth;
    private int mStrokeColor;
    private Paint mStrokePaint;
    private int mStrokeWidth;
    private int mTextColor;
    private TextPaint mTextPaint;
    private int mTextSize;
    private int mViewHeight;

    public COUIHintRedDotHelper(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
        this.mBgColor = obtainStyledAttributes.getColor(o.f5264a2, 0);
        this.mTextColor = obtainStyledAttributes.getColor(o.f5272b2, 0);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(o.f5304f2, 0);
        this.mSmallWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5328i2, 0);
        this.mMediumWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5320h2, 0);
        this.mLargeWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5312g2, 0);
        this.mViewHeight = obtainStyledAttributes.getDimensionPixelSize(o.f5256Z1, 0);
        this.mCornerRadius = obtainStyledAttributes.getDimensionPixelSize(o.f5233W1, 0);
        this.mDotDiameter = obtainStyledAttributes.getDimensionPixelSize(o.f5241X1, 0);
        this.mEllipsisDiameter = obtainStyledAttributes.getDimensionPixelSize(o.f5249Y1, 0);
        obtainStyledAttributes.recycle();
        this.mDotCornerRadius = context.getResources().getDimensionPixelSize(f.f4554N1);
        this.mNaviSmallWidth = context.getResources().getDimensionPixelSize(f.f4547M1);
        this.mEllipsisSpacing = context.getResources().getDimensionPixelSize(f.f4463A1);
        this.mStrokeWidth = context.getResources().getDimensionPixelSize(f.f4781r1);
        this.mStrokeColor = androidx.core.content.b.c(context, e.f4446l);
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mTextPaint.setColor(this.mTextColor);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setTypeface(Typeface.create(COUIChangeTextUtil.MEDIUM_FONT, 0));
        Paint paint = new Paint();
        this.mBgPaint = paint;
        paint.setAntiAlias(true);
        this.mBgPaint.setColor(this.mBgColor);
        Paint paint2 = this.mBgPaint;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.mStrokePaint = paint3;
        paint3.setAntiAlias(true);
        this.mStrokePaint.setColor(this.mStrokeColor);
        this.mStrokePaint.setStyle(style);
    }

    private void drawNumber(Canvas canvas, int i10, int i11, RectF rectF) {
        if (i10 <= 0) {
            return;
        }
        this.mTextPaint.setAlpha(Math.max(0, Math.min(255, i11)));
        if (i10 < 1000) {
            String valueOf = String.valueOf(i10);
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            int measureText = (int) this.mTextPaint.measureText(valueOf);
            float f10 = rectF.left;
            canvas.drawText(valueOf, f10 + (((rectF.right - f10) - measureText) / 2.0f), (((rectF.top + rectF.bottom) - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2.0f, this.mTextPaint);
            return;
        }
        float f11 = (rectF.left + rectF.right) / 2.0f;
        float f12 = (rectF.top + rectF.bottom) / 2.0f;
        for (int i12 = -1; i12 <= 1; i12++) {
            int i13 = this.mEllipsisSpacing;
            canvas.drawCircle(((i13 + r2) * i12) + f11, f12, this.mEllipsisDiameter / 2.0f, this.mTextPaint);
        }
    }

    private void drawPointOnly(Canvas canvas, RectF rectF) {
        float f10 = rectF.bottom;
        float f11 = rectF.top;
        float f12 = (f10 - f11) / 2.0f;
        canvas.drawCircle(rectF.left + f12, f11 + f12, f12, this.mBgPaint);
    }

    private void drawPointStroke(Canvas canvas, RectF rectF) {
        float f10 = rectF.bottom;
        float f11 = rectF.top;
        float f12 = (f10 - f11) / 2.0f;
        canvas.drawCircle(rectF.left + f12, f11 + f12, f12 - this.mStrokeWidth, this.mBgPaint);
    }

    private void drawPointWithNumber(Canvas canvas, Object obj, RectF rectF) {
        Path path;
        boolean z10 = obj instanceof String;
        if (z10) {
            if (TextUtils.isEmpty((CharSequence) obj)) {
                return;
            }
        } else if (obj instanceof Integer) {
            if (((Integer) obj).intValue() <= 0) {
                return;
            }
        } else {
            throw new IllegalArgumentException("params 'number' must be String or Integer!");
        }
        if (Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top) < this.mCornerRadius * 2) {
            path = COUIRoundRectUtil.getInstance().getPath(rectF, ((int) Math.min(rectF.right - rectF.left, rectF.bottom - rectF.top)) / 2);
        } else {
            path = COUIRoundRectUtil.getInstance().getPath(rectF, this.mCornerRadius);
        }
        canvas.drawPath(path, this.mBgPaint);
        if (z10) {
            drawText(canvas, (String) obj, 255, rectF);
        } else {
            drawNumber(canvas, ((Integer) obj).intValue(), 255, rectF);
        }
    }

    private void drawPointWithStroke(Canvas canvas, Object obj, RectF rectF) {
        boolean z10 = obj instanceof String;
        if (z10) {
            if (TextUtils.isEmpty((CharSequence) obj)) {
                return;
            }
        } else if (obj instanceof Integer) {
            if (((Integer) obj).intValue() <= 0) {
                return;
            }
        } else {
            throw new IllegalArgumentException("params 'number' must be String or Integer!");
        }
        RectF rectF2 = new RectF();
        rectF2.left = 0.0f;
        float f10 = rectF.right;
        int i10 = this.mStrokeWidth;
        float f11 = f10 - (i10 * 2);
        rectF2.right = f11;
        rectF2.top = 0.0f;
        float f12 = rectF.bottom - (i10 * 2);
        rectF2.bottom = f12;
        int min = ((int) Math.min(f11 - 0.0f, f12 - 0.0f)) / 2;
        canvas.drawPath(COUIRoundRectUtil.getInstance().getPath(rectF, this.mCornerRadius), this.mStrokePaint);
        canvas.save();
        int i11 = this.mStrokeWidth;
        canvas.translate(i11, i11);
        canvas.drawPath(COUIRoundRectUtil.getInstance().getPath(rectF2, min), this.mBgPaint);
        canvas.restore();
        if (z10) {
            drawText(canvas, (String) obj, 255, rectF);
        } else {
            drawNumber(canvas, ((Integer) obj).intValue(), 255, rectF);
        }
    }

    private void drawText(Canvas canvas, String str, int i10, RectF rectF) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mTextPaint.setAlpha(Math.max(0, Math.min(255, i10)));
        float measureText = this.mTextPaint.measureText(str);
        if (measureText < this.mTextPaint.measureText(String.valueOf(1000))) {
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            float f10 = rectF.left;
            canvas.drawText(str, f10 + (((rectF.right - f10) - measureText) / 2.0f), (((rectF.top + rectF.bottom) - fontMetricsInt.ascent) - fontMetricsInt.descent) / 2.0f, this.mTextPaint);
            return;
        }
        float f11 = (rectF.left + rectF.right) / 2.0f;
        float f12 = (rectF.top + rectF.bottom) / 2.0f;
        for (int i11 = -1; i11 <= 1; i11++) {
            int i12 = this.mEllipsisSpacing;
            canvas.drawCircle(((i12 + r2) * i11) + f11, f12, this.mEllipsisDiameter / 2.0f, this.mTextPaint);
        }
    }

    private int getBgHeight() {
        return this.mViewHeight;
    }

    private int getBgWidth(int i10) {
        if (i10 < 10) {
            return Math.max(this.mSmallWidth, this.mViewHeight);
        }
        if (i10 < 100) {
            return Math.max(this.mMediumWidth, this.mViewHeight);
        }
        if (i10 < 1000) {
            return Math.max(this.mLargeWidth, this.mViewHeight);
        }
        return Math.max(this.mMediumWidth, this.mViewHeight);
    }

    private int getNaviBgWidth(int i10) {
        if (i10 < 10) {
            return this.mNaviSmallWidth;
        }
        if (i10 < 100) {
            return this.mSmallWidth;
        }
        return this.mMediumWidth;
    }

    private boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        do {
            length--;
            if (length < 0) {
                return true;
            }
        } while (Character.isDigit(str.charAt(length)));
        return false;
    }

    public void drawPointWithFadeNumber(Canvas canvas, int i10, int i11, int i12, int i13, RectF rectF) {
        canvas.drawPath(COUIRoundRectUtil.getInstance().getPath(rectF, this.mCornerRadius), this.mBgPaint);
        if (i11 > i13) {
            drawNumber(canvas, i10, i11, rectF);
            drawNumber(canvas, i12, i13, rectF);
        } else {
            drawNumber(canvas, i12, i13, rectF);
            drawNumber(canvas, i10, i11, rectF);
        }
    }

    public void drawRedPoint(Canvas canvas, int i10, Object obj, RectF rectF) {
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                if (i10 != 4) {
                    if (i10 == 5) {
                        drawPointWithStroke(canvas, obj, rectF);
                        return;
                    }
                    return;
                }
                drawPointStroke(canvas, rectF);
                return;
            }
            drawPointWithNumber(canvas, obj, rectF);
            return;
        }
        drawPointOnly(canvas, rectF);
    }

    public int getViewHeight(int i10) {
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                if (i10 != 4) {
                    if (i10 != 5) {
                        return 0;
                    }
                }
            }
            return getBgHeight();
        }
        return this.mDotDiameter;
    }

    public int getViewWidth(int i10, int i11) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return getNaviBgWidth(i11);
                }
                if (i10 != 4) {
                    if (i10 != 5) {
                        return 0;
                    }
                }
            }
            return getBgWidth(i11);
        }
        return this.mDotDiameter;
    }

    public void setBgColor(int i10) {
        this.mBgColor = i10;
        this.mBgPaint.setColor(i10);
    }

    public void setCornerRadius(int i10) {
        this.mCornerRadius = i10;
    }

    public void setDotDiameter(int i10) {
        this.mDotDiameter = i10;
    }

    public void setEllipsisDiameter(int i10) {
        this.mEllipsisDiameter = i10;
    }

    public void setLargeWidth(int i10) {
        this.mLargeWidth = i10;
    }

    public void setMediumWidth(int i10) {
        this.mMediumWidth = i10;
    }

    public void setSmallWidth(int i10) {
        this.mSmallWidth = i10;
    }

    public void setTextColor(int i10) {
        this.mTextColor = i10;
        this.mTextPaint.setColor(i10);
    }

    public void setTextSize(int i10) {
        this.mTextSize = i10;
    }

    public void setViewHeight(int i10) {
        this.mViewHeight = i10;
        setCornerRadius(i10 / 2);
    }

    private int getNaviBgWidth(String str) {
        float measureText = (int) this.mTextPaint.measureText(str);
        if (measureText < this.mTextPaint.measureText(String.valueOf(10))) {
            return this.mNaviSmallWidth;
        }
        if (measureText < this.mTextPaint.measureText(String.valueOf(100))) {
            return this.mMediumWidth;
        }
        if (measureText < this.mTextPaint.measureText(String.valueOf(1000))) {
            return this.mLargeWidth;
        }
        return this.mMediumWidth;
    }

    public int getViewWidth(int i10, String str) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return getNaviBgWidth(str);
                }
                if (i10 != 4) {
                    if (i10 != 5) {
                        return 0;
                    }
                }
            }
            return getBgWidth(str);
        }
        return this.mDotDiameter;
    }

    private int getBgWidth(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.mSmallWidth;
        }
        if (isNumeric(str)) {
            return getBgWidth(Integer.parseInt(str));
        }
        float measureText = (int) this.mTextPaint.measureText(str);
        if (measureText < this.mTextPaint.measureText(String.valueOf(10))) {
            return Math.max(this.mSmallWidth, this.mViewHeight);
        }
        if (measureText < this.mTextPaint.measureText(String.valueOf(100))) {
            return Math.max(this.mMediumWidth, this.mViewHeight);
        }
        if (measureText < this.mTextPaint.measureText(String.valueOf(1000))) {
            return Math.max(this.mLargeWidth, this.mViewHeight);
        }
        return Math.max(this.mMediumWidth, this.mViewHeight);
    }
}
