package com.customize.contacts.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes3.dex */
public class RotateImageView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    public int f20868a;

    /* renamed from: b, reason: collision with root package name */
    public int f20869b;

    /* renamed from: c, reason: collision with root package name */
    public int f20870c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20871d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20872e;

    /* renamed from: f, reason: collision with root package name */
    public long f20873f;

    /* renamed from: g, reason: collision with root package name */
    public long f20874g;

    public RotateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20868a = 0;
        this.f20869b = 0;
        this.f20870c = 0;
        this.f20871d = false;
        this.f20872e = true;
        this.f20873f = 0L;
        this.f20874g = 0L;
    }

    public void g(int i10, boolean z10) {
        boolean z11;
        int i11;
        boolean z12 = false;
        if (isShown() && z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f20872e = z11;
        if (i10 >= 0) {
            i11 = i10 % 360;
        } else {
            i11 = (i10 % 360) + 360;
        }
        if (i11 == this.f20870c) {
            return;
        }
        this.f20870c = i11;
        if (z11) {
            this.f20869b = this.f20868a;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f20873f = currentAnimationTimeMillis;
            int i12 = this.f20870c - this.f20868a;
            if (i12 < 0) {
                i12 += 360;
            }
            if (i12 > 180) {
                i12 -= 360;
            }
            if (i12 >= 0) {
                z12 = true;
            }
            this.f20871d = z12;
            this.f20874g = currentAnimationTimeMillis + ((Math.abs(i12) * 1000) / 270);
        } else {
            this.f20868a = i11;
        }
        invalidate();
    }

    public int getDegree() {
        return this.f20870c;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i11 = bounds.right - bounds.left;
        int i12 = bounds.bottom - bounds.top;
        if (i11 != 0 && i12 != 0) {
            if (this.f20868a != this.f20870c) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (currentAnimationTimeMillis < this.f20874g) {
                    int i13 = (int) (currentAnimationTimeMillis - this.f20873f);
                    int i14 = this.f20869b;
                    if (!this.f20871d) {
                        i13 = -i13;
                    }
                    int i15 = i14 + ((i13 * 270) / 1000);
                    if (i15 >= 0) {
                        i10 = i15 % 360;
                    } else {
                        i10 = (i15 % 360) + 360;
                    }
                    this.f20868a = i10;
                    invalidate();
                } else {
                    this.f20868a = this.f20870c;
                }
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            int saveCount = canvas.getSaveCount();
            if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i11 || height < i12)) {
                float f10 = width;
                float f11 = height;
                float min = Math.min(f10 / i11, f11 / i12);
                canvas.scale(min, min, f10 / 2.0f, f11 / 2.0f);
            }
            canvas.translate(paddingLeft + (width / 2.0f), paddingTop + (height / 2.0f));
            canvas.rotate(-this.f20868a);
            canvas.translate((-i11) / 2.0f, (-i12) / 2.0f);
            drawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        return false;
    }
}
