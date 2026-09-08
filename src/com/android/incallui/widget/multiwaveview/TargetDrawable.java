package com.android.incallui.widget.multiwaveview;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* loaded from: classes.dex */
public class TargetDrawable {
    private static final boolean DEBUG = false;
    private static final String TAG = "TargetDrawable";
    private float mAlpha;
    private Rect mBounds;
    private Drawable mDrawable;
    private boolean mEnabled;
    private int mNumDrawables;
    private float mPositionX;
    private float mPositionY;
    private final int mResourceId;
    private float mScaleX;
    private float mScaleY;
    private float mTranslationX;
    private float mTranslationY;
    public static final int[] STATE_ACTIVE = {16842910, R.attr.state_active};
    public static final int[] STATE_INACTIVE = {16842910, -16842914};
    public static final int[] STATE_FOCUSED = {16842910, -16842914, 16842908};

    public TargetDrawable(Context context, int i10, int i11) {
        this.mTranslationX = 0.0f;
        this.mTranslationY = 0.0f;
        this.mPositionX = 0.0f;
        this.mPositionY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mAlpha = 1.0f;
        this.mEnabled = true;
        this.mNumDrawables = 1;
        this.mResourceId = i10;
        setDrawable(context, i10);
        this.mNumDrawables = i11;
    }

    private void resizeDrawables() {
        Drawable drawable = this.mDrawable;
        if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < this.mNumDrawables; i12++) {
                stateListDrawable.selectDrawable(i12);
                Drawable current = stateListDrawable.getCurrent();
                i10 = Math.max(i10, current.getIntrinsicWidth());
                i11 = Math.max(i11, current.getIntrinsicHeight());
            }
            stateListDrawable.setBounds(0, 0, i10, i11);
            for (int i13 = 0; i13 < this.mNumDrawables; i13++) {
                stateListDrawable.selectDrawable(i13);
                stateListDrawable.getCurrent().setBounds(0, 0, i10, i11);
            }
            return;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }
    }

    public void draw(Canvas canvas) {
        if (this.mDrawable != null && this.mEnabled) {
            canvas.save();
            canvas.scale(this.mScaleX, this.mScaleY, this.mPositionX, this.mPositionY);
            canvas.translate(this.mTranslationX + this.mPositionX, this.mTranslationY + this.mPositionY);
            canvas.translate(getWidth() * (-0.5f), getHeight() * (-0.5f));
            this.mDrawable.setAlpha(Math.round(this.mAlpha * 255.0f));
            this.mDrawable.draw(canvas);
            canvas.restore();
        }
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public Rect getBounds() {
        if (this.mBounds == null) {
            this.mBounds = new Rect();
        }
        this.mBounds.set((int) ((this.mTranslationX + this.mPositionX) - (getWidth() * 0.5d)), (int) ((this.mTranslationY + this.mPositionY) - (getHeight() * 0.5d)), (int) (this.mTranslationX + this.mPositionX + (getWidth() * 0.5d)), (int) (this.mTranslationY + this.mPositionY + (getHeight() * 0.5d)));
        return this.mBounds;
    }

    public int getHeight() {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 0;
    }

    public float getPositionX() {
        return this.mPositionX;
    }

    public float getPositionY() {
        return this.mPositionY;
    }

    public int getResourceId() {
        return this.mResourceId;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public int getWidth() {
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 0;
    }

    public float getX() {
        return this.mTranslationX;
    }

    public float getY() {
        return this.mTranslationY;
    }

    public boolean isActive() {
        Drawable drawable = this.mDrawable;
        if (drawable instanceof StateListDrawable) {
            for (int i10 : ((StateListDrawable) drawable).getState()) {
                if (i10 == 16842908) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEnabled() {
        if (this.mDrawable != null && this.mEnabled) {
            return true;
        }
        return false;
    }

    public void setAlpha(float f10) {
        this.mAlpha = f10;
    }

    public void setDrawable(Context context, int i10) {
        Drawable drawable;
        Drawable drawable2 = null;
        if (i10 == 0) {
            drawable = null;
        } else {
            drawable = context.getDrawable(i10);
        }
        if (drawable != null) {
            drawable2 = drawable.mutate();
        }
        this.mDrawable = drawable2;
        resizeDrawables();
        setState(STATE_INACTIVE);
    }

    public void setEnabled(boolean z10) {
        this.mEnabled = z10;
    }

    public void setPositionX(float f10) {
        this.mPositionX = f10;
    }

    public void setPositionY(float f10) {
        this.mPositionY = f10;
    }

    public void setScaleX(float f10) {
        this.mScaleX = f10;
    }

    public void setScaleY(float f10) {
        this.mScaleY = f10;
    }

    public void setState(int[] iArr) {
        Drawable drawable = this.mDrawable;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(iArr);
        }
    }

    public void setX(float f10) {
        this.mTranslationX = f10;
    }

    public void setY(float f10) {
        this.mTranslationY = f10;
    }

    public TargetDrawable(TargetDrawable targetDrawable) {
        this.mTranslationX = 0.0f;
        this.mTranslationY = 0.0f;
        this.mPositionX = 0.0f;
        this.mPositionY = 0.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mAlpha = 1.0f;
        this.mEnabled = true;
        this.mNumDrawables = 1;
        this.mResourceId = targetDrawable.mResourceId;
        Drawable drawable = targetDrawable.mDrawable;
        this.mDrawable = drawable != null ? drawable.mutate() : null;
        resizeDrawables();
        setState(STATE_INACTIVE);
    }
}
