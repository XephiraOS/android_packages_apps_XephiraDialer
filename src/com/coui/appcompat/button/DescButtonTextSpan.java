package com.coui.appcompat.button;

import X8.f;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import com.coui.appcompat.textutil.COUIChangeTextUtil;

/* loaded from: classes.dex */
public class DescButtonTextSpan extends ReplacementSpan {
    private Context mContext;
    private TextPaint mDescPaint;
    private String mDescText;
    private int mDescTextWidth;
    private int mHeight;
    private boolean mIsRtl;
    private int mMaxWidth;
    private String mText;
    private int mTextColor;
    private TextPaint mTextPaint;
    private int mTextWidth;
    private int mTopMargin;
    private int mWidth;

    public DescButtonTextSpan(Context context, String str, String str2, int i10, int i11, int i12, int i13, Paint paint, boolean z10) {
        this.mText = str;
        this.mDescText = str2;
        this.mMaxWidth = i10;
        this.mWidth = i11 < 0 ? 0 : i11;
        this.mContext = context;
        this.mHeight = i12;
        this.mTextColor = i13;
        this.mIsRtl = z10;
        this.mTextPaint = new TextPaint(paint);
        initPaint();
        handleSubString();
    }

    private int getEmptyWidth() {
        return ((int) this.mTextPaint.measureText(" ")) / 2;
    }

    private int getStartText() {
        return Math.abs(this.mTextWidth - this.mDescTextWidth) / 2;
    }

    private String getSubStringByWidth(String str, int i10, TextPaint textPaint) {
        if (!TextUtils.isEmpty(str) && i10 >= 0) {
            return StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, i10).setMaxLines(1).setEllipsize(TextUtils.TruncateAt.END).build().getText().toString();
        }
        return "";
    }

    private int getWidth() {
        if (!TextUtils.isEmpty(this.mDescText) && !TextUtils.isEmpty(this.mText)) {
            return Math.max(this.mDescTextWidth, this.mTextWidth);
        }
        return 0;
    }

    private void handleSubString() {
        int i10 = this.mDescTextWidth;
        int i11 = this.mMaxWidth;
        if (i10 > i11) {
            String subStringByWidth = getSubStringByWidth(this.mDescText, i11, this.mDescPaint);
            this.mDescText = subStringByWidth;
            this.mDescTextWidth = (int) this.mDescPaint.measureText(subStringByWidth);
        }
        int i12 = this.mTextWidth;
        int i13 = this.mMaxWidth;
        if (i12 > i13) {
            String subStringByWidth2 = getSubStringByWidth(this.mText, i13, this.mTextPaint);
            this.mText = subStringByWidth2;
            this.mTextWidth = (int) this.mTextPaint.measureText(subStringByWidth2);
        }
    }

    private void initPaint() {
        float f10 = this.mContext.getResources().getConfiguration().fontScale;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.f4795t0);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(f.f4788s0);
        int suitableFontSize = (int) COUIChangeTextUtil.getSuitableFontSize(dimensionPixelSize, f10, 2);
        int suitableFontSize2 = (int) COUIChangeTextUtil.getSuitableFontSize(dimensionPixelSize2, f10, 2);
        this.mTextPaint.setTextSize(suitableFontSize);
        this.mTextPaint.setColor(this.mTextColor);
        TextPaint textPaint = new TextPaint(this.mTextPaint);
        this.mDescPaint = textPaint;
        textPaint.setTextSize(suitableFontSize2);
        this.mDescPaint.setColor(this.mTextColor);
        this.mDescTextWidth = (int) this.mDescPaint.measureText(this.mDescText);
        this.mTextWidth = (int) this.mTextPaint.measureText(this.mText);
        this.mTopMargin = this.mContext.getResources().getDimensionPixelSize(f.f4802u0);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        Paint.FontMetricsInt fontMetricsInt = this.mDescPaint.getFontMetricsInt();
        Paint.FontMetricsInt fontMetricsInt2 = this.mTextPaint.getFontMetricsInt();
        int i15 = fontMetricsInt.descent;
        int i16 = fontMetricsInt.ascent;
        int i17 = fontMetricsInt.leading;
        int i18 = i13 - ((((i15 - i16) + i17) + this.mTopMargin) / 2);
        int abs = fontMetricsInt2.bottom + i18 + i17 + Math.abs(i16) + this.mTopMargin;
        int emptyWidth = getEmptyWidth();
        int startText = getStartText();
        if (this.mIsRtl) {
            emptyWidth = -emptyWidth;
        }
        float f11 = f10 - emptyWidth;
        if (this.mTextWidth > this.mDescTextWidth) {
            canvas.drawText(this.mText, f11, i18, this.mTextPaint);
            canvas.drawText(this.mDescText, f11 + startText, abs, this.mDescPaint);
        } else {
            canvas.drawText(this.mText, startText + f11, i18, this.mTextPaint);
            canvas.drawText(this.mDescText, f11, abs, this.mDescPaint);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        return getWidth();
    }
}
