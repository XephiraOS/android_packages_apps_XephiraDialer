package com.coui.appcompat.state;

import X8.c;
import X8.f;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.coui.appcompat.contextutil.COUIContextUtil;

/* loaded from: classes.dex */
public class COUIStrokeDrawable extends StatefulDrawable {
    private static final float DEFAULT_SPRING_BOUNCE = 0.0f;
    private static final float DEFAULT_SPRING_RESPONSE = 0.3f;
    private boolean mAnimateEnabled;
    private final Path mClipPath;
    private final StateEffectAnimator mFocusAnimator;
    private StatefulDrawableListener mListener;
    private float mRadiusX;
    private float mRadiusY;
    private final Paint mStrokePaint;
    private Path mStrokePath;
    private RectF mStrokeRect;

    public COUIStrokeDrawable(Context context) {
        super("COUIStrokeDrawable");
        Paint paint = new Paint(1);
        this.mStrokePaint = paint;
        this.mClipPath = new Path();
        this.mAnimateEnabled = true;
        this.mListener = null;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimensionPixelOffset(f.f4835y5) * 2);
        StateEffectAnimator stateEffectAnimator = new StateEffectAnimator(this, "focus", 0, COUIContextUtil.getAttrColor(context, c.f4410v));
        this.mFocusAnimator = stateEffectAnimator;
        stateEffectAnimator.setSpringBounce(0.0f);
        stateEffectAnimator.setSpringResponse(0.3f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (isDrawableEnabled() && this.mFocusAnimator.getCurrentMaskColor() != 0) {
            this.mStrokePaint.setColor(this.mFocusAnimator.getCurrentMaskColor());
            canvas.save();
            Path path = this.mStrokePath;
            if (path != null) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(this.mStrokePath, this.mStrokePaint);
            } else if (this.mStrokeRect != null) {
                this.mClipPath.reset();
                this.mClipPath.addRoundRect(this.mStrokeRect, this.mRadiusX, this.mRadiusY, Path.Direction.CCW);
                canvas.clipPath(this.mClipPath, Region.Op.DIFFERENCE);
                canvas.drawPath(this.mClipPath, this.mStrokePaint);
            } else {
                Rect bounds = getBounds();
                float max = Math.max(0, Math.min(bounds.width(), bounds.height())) / 2.0f;
                this.mClipPath.reset();
                this.mClipPath.addRoundRect(bounds.left, bounds.top, bounds.right, bounds.bottom, max, max, Path.Direction.CCW);
                canvas.clipPath(this.mClipPath, Region.Op.DIFFERENCE);
                canvas.drawPath(this.mClipPath, this.mStrokePaint);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        StatefulDrawableListener statefulDrawableListener = this.mListener;
        if (statefulDrawableListener != null) {
            statefulDrawableListener.onDrawableUpdate();
        }
    }

    @Override // com.coui.appcompat.state.DrawableStateProxy
    public void onViewStateChanged(int i10) {
        float f10 = 0.0f;
        if (i10 == 16842910 && !isEnabled()) {
            this.mFocusAnimator.animateToProgress(0.0f, false);
            return;
        }
        if (isEnabled() && i10 == 16842908) {
            StateEffectAnimator stateEffectAnimator = this.mFocusAnimator;
            if (isFocused()) {
                f10 = 10000.0f;
            }
            stateEffectAnimator.animateToProgress(f10, this.mAnimateEnabled);
        }
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void refresh(Context context) {
        this.mFocusAnimator.setEndMaskColor(COUIContextUtil.getAttrColor(context, c.f4410v));
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void reset() {
        this.mFocusAnimator.animateToProgress(0.0f, false);
    }

    @Override // com.coui.appcompat.state.IStateEffect
    public void setAnimateEnabled(boolean z10) {
        this.mAnimateEnabled = z10;
    }

    @Override // com.coui.appcompat.state.StatefulDrawable, com.coui.appcompat.state.DrawableStateProxy
    public void setDrawableEnabled(boolean z10) {
        super.setDrawableEnabled(z10);
        if (!z10) {
            this.mFocusAnimator.animateToProgress(0.0f, false);
        }
    }

    public void setFocusStateLocked(boolean z10, boolean z11, boolean z12) {
        setStateLocked(16842908, z10, z11, z12);
    }

    @Override // com.coui.appcompat.state.StatefulDrawable, com.coui.appcompat.state.DrawableStateProxy
    public void setStateLocked(int i10, boolean z10, boolean z11, boolean z12) {
        float f10;
        super.setStateLocked(i10, z10, z11, z12);
        if (i10 == 16842908) {
            StateEffectAnimator stateEffectAnimator = this.mFocusAnimator;
            if (z11) {
                f10 = 10000.0f;
            } else {
                f10 = 0.0f;
            }
            stateEffectAnimator.animateToProgress(f10, z12);
        }
    }

    public void setStatefulDrawableListener(StatefulDrawableListener statefulDrawableListener) {
        this.mListener = statefulDrawableListener;
    }

    public void setStrokePath(Path path) {
        this.mStrokePath = path;
    }

    public void setStrokeRect(RectF rectF, float f10, float f11) {
        this.mStrokeRect = rectF;
        this.mRadiusX = f10;
        this.mRadiusY = f11;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
