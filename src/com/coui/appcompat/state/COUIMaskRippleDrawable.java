package com.coui.appcompat.state;

import X8.c;
import X8.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.log.COUILog;

/* loaded from: classes.dex */
public class COUIMaskRippleDrawable extends RippleStatefulDrawable {
    private static final float DEFAULT_SPRING_BOUNCE = 0.0f;
    private static final float DEFAULT_SPRING_RESPONSE = 0.3f;
    private static final int[] PRESS_ENTERED_STATE_SET = {16842910, 16842919};
    private static final int[] PRESS_EXITED_STATE_SET = {16842910};
    public static final int RIPPLE_MASK_TYPE_CIRCLE = 0;
    public static final int RIPPLE_MASK_TYPE_CUSTOM_PATH = 1;
    private static final int RIPPLE_RADIUS_AUTO = -1;
    public static final int RIPPLE_TYPE_CHECKBOX_RADIUS = 1;
    public static final int RIPPLE_TYPE_ICON_RADIUS = 0;
    private static final String TAG = "COUIMaskRippleDrawable";

    /* renamed from: U, reason: collision with root package name */
    private static final int f19938U = 34;
    private boolean mAnimateEnabled;
    private final Path mClipPath;
    private final StateEffectAnimator mFocusAnimator;
    private final Rect mHostBounds;
    private final StateEffectAnimator mHoverAnimator;
    private Path mMaskPath;
    private float mMaskRadiusX;
    private float mMaskRadiusY;
    private RectF mMaskRect;
    private final Paint mPaint;
    private int mRadius;
    private int mRippleMaskType;

    public COUIMaskRippleDrawable(Context context) {
        super(TAG);
        this.mClipPath = new Path();
        this.mPaint = new Paint(1);
        this.mAnimateEnabled = true;
        this.mMaskRadiusX = 0.0f;
        this.mMaskRadiusY = 0.0f;
        this.mHostBounds = getBounds();
        setColor(ColorStateList.valueOf(COUIContextUtil.getAttrColor(context, c.f4345D)));
        setCircleRippleMask(0);
        StateEffectAnimator stateEffectAnimator = new StateEffectAnimator(this, "hover", 0, COUIContextUtil.getAttrColor(context, c.f4414x));
        this.mHoverAnimator = stateEffectAnimator;
        StateEffectAnimator stateEffectAnimator2 = new StateEffectAnimator(this, "focus", 0, COUIContextUtil.getAttrColor(context, c.f4408u));
        this.mFocusAnimator = stateEffectAnimator2;
        stateEffectAnimator.setSpringBounce(0.0f);
        stateEffectAnimator.setSpringResponse(0.3f);
        stateEffectAnimator2.setSpringBounce(0.0f);
        stateEffectAnimator2.setSpringResponse(0.3f);
    }

    private void clipPathOrRect(Canvas canvas) {
        Path path = this.mMaskPath;
        if (path != null) {
            canvas.clipPath(path);
            return;
        }
        if (this.mMaskRect != null) {
            this.mClipPath.reset();
            this.mClipPath.addRoundRect(this.mMaskRect, this.mMaskRadiusX, this.mMaskRadiusY, Path.Direction.CCW);
            canvas.clipPath(this.mClipPath);
        } else {
            Rect bounds = getBounds();
            float max = Math.max(0, Math.min(bounds.width(), bounds.height())) / 2.0f;
            this.mClipPath.reset();
            this.mClipPath.addRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, max, max, Path.Direction.CCW);
            canvas.clipPath(this.mClipPath);
        }
    }

    private void drawPathOrRect(Canvas canvas) {
        int i10 = this.mRippleMaskType;
        if (i10 == 0) {
            canvas.drawCircle(this.mHostBounds.centerX(), this.mHostBounds.centerY(), this.mRadius, this.mPaint);
            return;
        }
        if (i10 == 1) {
            Path path = this.mMaskPath;
            if (path != null) {
                canvas.drawPath(path, this.mPaint);
                return;
            }
            RectF rectF = this.mMaskRect;
            if (rectF != null) {
                canvas.drawRoundRect(rectF, this.mMaskRadiusX, this.mMaskRadiusY, this.mPaint);
                return;
            }
            Rect bounds = getBounds();
            float max = Math.max(0, Math.min(bounds.width(), bounds.height())) / 2.0f;
            canvas.drawRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, max, max, this.mPaint);
        }
    }

    public static int getMaskRippleRadiusByType(Context context, int i10) {
        if (i10 == 0) {
            return context.getResources().getDimensionPixelOffset(f.f4495E5);
        }
        if (i10 == 1) {
            return context.getResources().getDimensionPixelOffset(f.f4699h);
        }
        COUILog.e(TAG, "wrong mask type!");
        return 0;
    }

    private void setRadiusCompat(int i10) {
        setRadius(i10);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!isDrawableEnabled()) {
            return;
        }
        if (this.mRippleMaskType == 1) {
            canvas.save();
            clipPathOrRect(canvas);
        }
        if (this.mHoverAnimator.getCurrentMaskColor() != 0) {
            this.mPaint.setColor(this.mHoverAnimator.getCurrentMaskColor());
            drawPathOrRect(canvas);
        }
        if (this.mFocusAnimator.getCurrentMaskColor() != 0) {
            this.mPaint.setColor(this.mFocusAnimator.getCurrentMaskColor());
            drawPathOrRect(canvas);
        }
        super.draw(canvas);
        if (this.mRippleMaskType == 1) {
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        this.mDrawableStateManager.onStateChange(iArr);
        return false;
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void onViewStateChanged(int i10) {
        if (!isEnabled()) {
            return;
        }
        float f10 = 0.0f;
        if (i10 == 16842908 && !isStateLocked(16842908)) {
            StateEffectAnimator stateEffectAnimator = this.mFocusAnimator;
            if (isFocused()) {
                f10 = 10000.0f;
            }
            stateEffectAnimator.animateToProgress(f10, this.mAnimateEnabled);
            return;
        }
        if (i10 == 16843623 && !isStateLocked(16843623)) {
            StateEffectAnimator stateEffectAnimator2 = this.mHoverAnimator;
            if (isHovered()) {
                f10 = 10000.0f;
            }
            stateEffectAnimator2.animateToProgress(f10, this.mAnimateEnabled);
            return;
        }
        if (i10 == 16842919) {
            int i11 = -16842910;
            if (isPressed()) {
                int[] iArr = PRESS_ENTERED_STATE_SET;
                if (isEnabled()) {
                    i11 = 16842910;
                }
                iArr[0] = i11;
                super.onStateChange(iArr);
            } else {
                int[] iArr2 = PRESS_EXITED_STATE_SET;
                if (isEnabled()) {
                    i11 = 16842910;
                }
                iArr2[0] = i11;
                super.onStateChange(iArr2);
            }
            invalidateSelf();
        }
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void refresh(Context context) {
        this.mHoverAnimator.setEndMaskColor(COUIContextUtil.getAttrColor(context, c.f4414x));
        this.mFocusAnimator.setEndMaskColor(COUIContextUtil.getAttrColor(context, c.f4408u));
        setColor(ColorStateList.valueOf(COUIContextUtil.getAttrColor(context, c.f4345D)));
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void reset() {
        this.mHoverAnimator.animateToProgress(0.0f, false);
        this.mFocusAnimator.animateToProgress(0.0f, false);
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void setAnimateEnabled(boolean z10) {
        this.mAnimateEnabled = z10;
    }

    public void setCircleRippleMask(int i10) {
        if (i10 < 0) {
            COUILog.e(TAG, "radius should larger than 0!");
            return;
        }
        this.mRippleMaskType = 0;
        setRadiusCompat(i10);
        this.mRadius = i10;
    }

    public void setCustomRippleMask() {
        this.mRippleMaskType = 1;
        setRadiusCompat(-1);
    }

    public void setFocusStateLocked(boolean z10, boolean z11, boolean z12) {
        setStateLocked(16842908, z10, z11, z12);
    }

    public void setHoverStateLocked(boolean z10, boolean z11, boolean z12) {
        setStateLocked(16843623, z10, z11, z12);
    }

    public void setMaskPath(Path path) {
        this.mMaskPath = path;
    }

    public void setMaskRect(RectF rectF, float f10, float f11) {
        this.mMaskRect = rectF;
        this.mMaskRadiusX = f10;
        this.mMaskRadiusY = f11;
    }

    @Override // com.coui.appcompat.state.RippleStatefulDrawable, com.coui.appcompat.state.DrawableStateProxy
    public void setStateLocked(int i10, boolean z10, boolean z11, boolean z12) {
        float f10;
        super.setStateLocked(i10, z10, z11, z12);
        if (i10 == 16842919) {
            COUILog.w(TAG, "Lock state press in COUIMaskRippleDrawable is not allowed!");
        }
        float f11 = 0.0f;
        if (i10 == 16843623) {
            StateEffectAnimator stateEffectAnimator = this.mHoverAnimator;
            if (z11) {
                f10 = 10000.0f;
            } else {
                f10 = 0.0f;
            }
            stateEffectAnimator.animateToProgress(f10, z12);
        }
        if (i10 == 16842908) {
            StateEffectAnimator stateEffectAnimator2 = this.mFocusAnimator;
            if (z11) {
                f11 = 10000.0f;
            }
            stateEffectAnimator2.animateToProgress(f11, z12);
        }
    }
}
