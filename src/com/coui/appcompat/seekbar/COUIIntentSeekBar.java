package com.coui.appcompat.seekbar;

import a9.l;
import a9.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.coui.appcompat.contextutil.COUIContextUtil;

/* loaded from: classes.dex */
public class COUIIntentSeekBar extends COUISeekBar {
    private boolean mIsFollowThumb;
    private int mSecondaryProgress;
    private int mSecondaryProgressColor;
    private float mThumbOutShadeRadius;

    public COUIIntentSeekBar(Context context) {
        this(context, null);
    }

    private void drawThumbs(Canvas canvas) {
        float start;
        float seekBarWidth = getSeekBarWidth();
        int seekBarCenterY = getSeekBarCenterY();
        if (isLayoutRtl()) {
            start = ((getStart() + this.mCurPaddingHorizontal) + seekBarWidth) - (this.mScale * seekBarWidth);
        } else {
            start = getStart() + this.mCurPaddingHorizontal + (this.mScale * seekBarWidth);
        }
        float f10 = this.mThumbOutRadius;
        float f11 = start - f10;
        float f12 = start + f10;
        this.mPaint.setColor(this.mThumbColor);
        if (this.mIsDragging && !this.mIsFollowThumb) {
            float f13 = this.mThumbOutShadeRadius;
            float f14 = seekBarCenterY;
            float f15 = this.mThumbOutRadius;
            canvas.drawRoundRect(f11 - f13, (f14 - f15) - f13, f12 + f13, f14 + f15 + f13, f15 + f13, f15 + f13, this.mPaint);
        } else {
            float f16 = seekBarCenterY;
            float f17 = this.mThumbOutRadius;
            canvas.drawRoundRect(f11, f16 - f17, f12, f16 + f17, f17, f17, this.mPaint);
        }
        this.mLabelX = f11 + ((f12 - f11) / 2.0f);
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void drawActiveTrack(Canvas canvas, float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        if (!this.mShowProgress) {
            return;
        }
        int seekBarCenterY = getSeekBarCenterY();
        getWidth();
        getEnd();
        int i10 = this.mMax - this.mMin;
        if (isLayoutRtl()) {
            f13 = getStart() + this.mCurPaddingHorizontal + f10;
            int i11 = this.mOldProgress;
            int i12 = this.mMin;
            float f15 = i10;
            float f16 = f13 - (((i11 - i12) * f10) / f15);
            f14 = f13 - (((this.mSecondaryProgress - i12) * f10) / f15);
            f11 = f16;
            f12 = f13;
        } else {
            float start = this.mCurPaddingHorizontal + getStart();
            int i13 = this.mOldProgress;
            int i14 = this.mMin;
            float f17 = i10;
            float f18 = (((i13 - i14) * f10) / f17) + start;
            float f19 = start + (((this.mSecondaryProgress - i14) * f10) / f17);
            f11 = start;
            f12 = f18;
            f13 = f19;
            f14 = f11;
        }
        this.mPaint.setColor(this.mSecondaryProgressColor);
        float f20 = this.mCurProgressRadius;
        float f21 = seekBarCenterY;
        this.mProgressRect.set(f14 - f20, f21 - f20, f13 + f20, f20 + f21);
        RectF rectF = this.mProgressRect;
        float f22 = this.mCurProgressRadius;
        canvas.drawRoundRect(rectF, f22, f22, this.mPaint);
        if (this.mIsFollowThumb) {
            super.drawActiveTrack(canvas, f10);
            return;
        }
        this.mPaint.setColor(this.mProgressColor);
        RectF rectF2 = this.mProgressRect;
        float f23 = this.mCurProgressRadius;
        rectF2.set(f11 - f23, f21 - f23, f12 + f23, f21 + f23);
        RectF rectF3 = this.mProgressRect;
        float f24 = this.mCurProgressRadius;
        canvas.drawRoundRect(rectF3, f24, f24, this.mPaint);
        drawThumbs(canvas);
    }

    @Override // android.widget.ProgressBar
    public int getSecondaryProgress() {
        return this.mSecondaryProgress;
    }

    public boolean isFollowThumb() {
        return this.mIsFollowThumb;
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar, i8.InterfaceC1105a
    public /* bridge */ /* synthetic */ void onAnimationStart(i8.c cVar) {
        super.onAnimationStart(cVar);
    }

    @Override // com.coui.appcompat.seekbar.COUISeekBar
    public void onStopTrackingTouch() {
        super.onStopTrackingTouch();
        this.mOldProgress = this.mProgress;
    }

    public void setFollowThumb(boolean z10) {
        this.mIsFollowThumb = z10;
    }

    @Override // android.widget.ProgressBar
    public void setSecondaryProgress(int i10) {
        if (i10 >= 0) {
            this.mSecondaryProgress = Math.max(this.mMin, Math.min(i10, this.mMax));
            invalidate();
        }
    }

    public void setSecondaryProgressColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mSecondaryProgressColor = getColor(this, colorStateList, androidx.core.content.b.c(getContext(), a9.c.f6489m));
            invalidate();
        }
    }

    public COUIIntentSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a9.b.f6465c);
    }

    public COUIIntentSeekBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, COUIContextUtil.isCOUIDarkTheme(context) ? l.f6696b : l.f6695a);
    }

    public COUIIntentSeekBar(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mSecondaryProgress = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f6862i0, i10, i11);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(m.f6870k0);
        this.mIsFollowThumb = obtainStyledAttributes.getBoolean(m.f6866j0, false);
        obtainStyledAttributes.recycle();
        this.mSecondaryProgressColor = getColor(this, colorStateList, COUIContextUtil.getColor(getContext(), a9.c.f6488l));
        this.mThumbOutShadeRadius = getResources().getDimensionPixelSize(a9.d.f6548a0);
    }
}
