package com.coui.appcompat.cardlist;

import X8.c;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import b9.C0535e;
import b9.l;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.preference.ListSelectedItemLayout;
import com.coui.appcompat.roundRect.COUIShapePath;
import com.coui.appcompat.state.COUIStateEffectDrawable;

/* loaded from: classes.dex */
public class COUICardListSelectedItemLayout extends ListSelectedItemLayout {

    /* renamed from: T, reason: collision with root package name */
    public static final int f19811T = 32;
    private static final String TAG = "COUICardListSelectedItemLayout";
    private final int HEAD_OR_TAIL_PADDING;
    private boolean mApplyOutline;
    private boolean mBottomRounded;
    private int mCardBackgroundColor;
    private final Drawable mCardBackgroundDrawable;
    private final RectF mCardRect;
    private ConfigurationChangedListener mConfigurationChangeListener;
    private int mHorizontalMargin;
    private int mInitPaddingBottom;
    private int mInitPaddingTop;
    private boolean mIsDrawPathType;
    private boolean mIsSelected;
    private int mMinimumHeight;
    private final ViewOutlineProvider mOutLineProvider;
    private final Paint mPaint;
    private Path mPath;
    private float mRadius;

    @Deprecated
    protected ValueAnimator mRestoreBackgroundAppearAnimator;

    @Deprecated
    protected ValueAnimator mRestoreBackgroundDisappearAnimator;
    private boolean mTopRounded;

    @Deprecated
    /* loaded from: classes.dex */
    public static class AnimatorHelper {
        int animatorValue;
        int type;

        public AnimatorHelper(int i10, int i11) {
            this.animatorValue = i10;
            this.type = i11;
        }
    }

    /* loaded from: classes.dex */
    public interface ConfigurationChangedListener {
        void configurationChanged(Configuration configuration);
    }

    public COUICardListSelectedItemLayout(Context context) {
        this(context, null);
    }

    private void init(Context context, boolean z10) {
        if (!z10) {
            this.mHorizontalMargin = context.getResources().getDimensionPixelOffset(C0535e.f12429r);
        } else {
            this.mHorizontalMargin = context.getResources().getDimensionPixelOffset(C0535e.f12431s);
        }
        this.mCardBackgroundColor = COUIContextUtil.getAttrColor(context, c.f4386j);
        this.mMinimumHeight = getMinimumHeight();
        this.mInitPaddingTop = getPaddingTop();
        this.mInitPaddingBottom = getPaddingBottom();
        setBackground(this.mCardBackgroundDrawable);
    }

    private void setCardRadiusStyle(int i10) {
        if (i10 == 4) {
            this.mTopRounded = true;
            this.mBottomRounded = true;
        } else if (i10 == 1) {
            this.mTopRounded = true;
            this.mBottomRounded = false;
        } else if (i10 == 3) {
            this.mTopRounded = false;
            this.mBottomRounded = true;
        } else {
            this.mTopRounded = false;
            this.mBottomRounded = false;
        }
    }

    private void setPadding(int i10) {
        int i11;
        int i12 = 0;
        if (i10 == 1) {
            i12 = this.HEAD_OR_TAIL_PADDING;
            i11 = 0;
        } else if (i10 == 3) {
            i11 = this.HEAD_OR_TAIL_PADDING;
        } else {
            if (i10 == 4) {
                i12 = this.HEAD_OR_TAIL_PADDING;
            }
            i11 = i12;
        }
        setMinimumHeight(this.mMinimumHeight + i12 + i11);
        setPaddingRelative(getPaddingStart(), this.mInitPaddingTop + i12, getPaddingEnd(), this.mInitPaddingBottom + i11);
    }

    private void updatePath() {
        this.mPath.reset();
        this.mCardRect.set(this.mHorizontalMargin, 0.0f, getWidth() - this.mHorizontalMargin, getHeight());
        Path path = this.mPath;
        RectF rectF = this.mCardRect;
        float f10 = this.mRadius;
        boolean z10 = this.mTopRounded;
        boolean z11 = this.mBottomRounded;
        COUIShapePath.getRoundRectPath(path, rectF, f10, z10, z10, z11, z11);
    }

    public void changeDrawCanvasType(boolean z10) {
        if (this.mIsDrawPathType == z10) {
            return;
        }
        this.mIsDrawPathType = z10;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.mIsDrawPathType && !this.mApplyOutline) {
            canvas.save();
            canvas.clipPath(this.mPath);
            super.draw(canvas);
            canvas.restore();
            return;
        }
        updatePath();
        super.draw(canvas);
    }

    public boolean getIsSelected() {
        return this.mIsSelected;
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout
    public Path getLayoutPath() {
        if (this.mPath == null) {
            this.mPath = new Path();
        }
        return this.mPath;
    }

    public int getMarginHorizontal() {
        return this.mHorizontalMargin;
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ConfigurationChangedListener configurationChangedListener = this.mConfigurationChangeListener;
        if (configurationChangedListener != null) {
            configurationChangedListener.configurationChanged(configuration);
        }
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        updatePath();
        if (!this.mIsDrawPathType) {
            setOutlineProvider(this.mOutLineProvider);
            setClipToOutline(true);
        } else {
            this.mApplyOutline = false;
            setClipToOutline(false);
        }
    }

    public void refreshCardBg(int i10) {
        this.mCardBackgroundColor = i10;
        invalidate();
    }

    @Deprecated
    public synchronized void restoreAnimator(AnimatorHelper animatorHelper) {
    }

    @Deprecated
    public AnimatorHelper saveAndEndAnimator() {
        return null;
    }

    public void setConfigurationChangeListener(ConfigurationChangedListener configurationChangedListener) {
        this.mConfigurationChangeListener = configurationChangedListener;
    }

    public void setIsSelected(boolean z10) {
        setIsSelected(z10, false);
    }

    public void setMarginHorizontal(int i10) {
        this.mHorizontalMargin = i10;
        requestLayout();
    }

    public void setPositionInGroup(int i10) {
        if (i10 > 0) {
            setPadding(i10);
            setCardRadiusStyle(i10);
            updatePath();
        }
    }

    public void setRadius(float f10) {
        this.mRadius = f10;
        updatePath();
        invalidate();
    }

    public COUICardListSelectedItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setIsSelected(boolean z10, boolean z11) {
        if (this.mIsSelected != z10) {
            this.mIsSelected = z10;
            Drawable background = getBackground();
            if (background instanceof COUIStateEffectDrawable) {
                ((COUIStateEffectDrawable) background).setStateLocked(1, z10, z10, z11);
            }
        }
    }

    public COUICardListSelectedItemLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public COUICardListSelectedItemLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.HEAD_OR_TAIL_PADDING = getResources().getDimensionPixelOffset(C0535e.f12411i);
        this.mCardRect = new RectF();
        this.mPaint = new Paint();
        this.mCardBackgroundDrawable = new Drawable() { // from class: com.coui.appcompat.cardlist.COUICardListSelectedItemLayout.1
            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                if (COUICardListSelectedItemLayout.this.mIsDrawPathType) {
                    COUICardListSelectedItemLayout.this.mPaint.setColor(COUICardListSelectedItemLayout.this.mCardBackgroundColor);
                    canvas.drawPath(COUICardListSelectedItemLayout.this.mPath, COUICardListSelectedItemLayout.this.mPaint);
                } else {
                    canvas.drawColor(COUICardListSelectedItemLayout.this.mCardBackgroundColor);
                }
            }

            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i12) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
            }
        };
        this.mOutLineProvider = new ViewOutlineProvider() { // from class: com.coui.appcompat.cardlist.COUICardListSelectedItemLayout.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setPath(COUICardListSelectedItemLayout.this.mPath);
                COUICardListSelectedItemLayout.this.mApplyOutline = true;
            }
        };
        this.mTopRounded = true;
        this.mBottomRounded = true;
        this.mApplyOutline = false;
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f12643p, i10, i11);
        boolean z10 = obtainStyledAttributes.getBoolean(l.f12652s, false);
        this.mRadius = obtainStyledAttributes.getDimensionPixelOffset(l.f12649r, COUIContextUtil.getAttrDimens(context, c.f4373c0));
        init(getContext(), z10);
        this.mHorizontalMargin = obtainStyledAttributes.getDimensionPixelOffset(l.f12646q, this.mHorizontalMargin);
        obtainStyledAttributes.recycle();
        if (getId() != -1) {
            try {
                if ("single_card".equals(getContext().getResources().getResourceEntryName(getId()))) {
                    consumeDispatchingEventForState(true);
                }
            } catch (Resources.NotFoundException e10) {
                COUILog.e(TAG, e10.getMessage());
            }
        }
    }
}
