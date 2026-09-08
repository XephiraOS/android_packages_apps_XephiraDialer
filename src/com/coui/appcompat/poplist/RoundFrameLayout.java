package com.coui.appcompat.poplist;

import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.roundcorner.RoundCornerUtil;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.ShadowUtils;
import com.coui.appcompat.uiutil.UIUtil;
import com.oplus.graphics.OplusBlurParam;
import com.oplus.graphics.OplusOutline;
import com.oplus.view.ViewRootManager;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class RoundFrameLayout extends FrameLayout {
    public static final int CANVAS_CLIP = 0;
    private static final int MAX_COLOR = 255;
    public static final int OUTLINE_CLIP = 1;
    private static final String TAG = "RoundFrameLayout";
    private boolean mAllowDispatchEvent;
    private Drawable mBackgroundBlurDrawable;
    private int mClipMode;
    private Consumer<Boolean> mCrossWindowBlurEnabledListener;
    private boolean mIsBlurEnable;
    private boolean mIsCOUIDarkTheme;
    private Boolean mIsSupportSRCWhenBlur;
    private boolean mIsSupportSmoothRoundCorner;
    private Drawable mOriginalBackground;
    private float mOutlineAlpha;
    private final Rect mOutlineRect;
    private final Rect mOverrideRect;
    private Paint mPaint;
    private Path mPath;
    private float mRadius;
    private RectF mRectF;
    private float mRoundCornerWeight;
    private boolean mUseBackgroundBlur;
    private ViewRootManager mViewRootManger;
    private WindowManager mWindowManager;

    public RoundFrameLayout(Context context) {
        this(context, null);
    }

    private void dispatchDraw27(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(genPath(), this.mPaint);
        canvas.restore();
    }

    private void dispatchDraw28(Canvas canvas) {
        canvas.save();
        canvas.clipPath(genPath());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private Path genPath() {
        this.mPath.reset();
        Path path = this.mPath;
        RectF rectF = this.mRectF;
        float f10 = this.mRadius;
        path.addRoundRect(rectF, f10, f10, Path.Direction.CW);
        return this.mPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$0(Boolean bool) {
        int color = COUIContextUtil.getColor(getContext(), X8.e.f4449o);
        int color2 = COUIContextUtil.getColor(getContext(), X8.e.f4450p);
        ViewRootManager viewRootManager = this.mViewRootManger;
        if (!bool.booleanValue()) {
            color = color2;
        }
        viewRootManager.setColor(color);
        invalidate();
        Log.i(TAG, "WindowBlurEnabled = " + bool);
    }

    public void clearOverrideOutline() {
        this.mOverrideRect.setEmpty();
        this.mOutlineAlpha = 1.0f;
        invalidateOutline();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (!this.mOverrideRect.isEmpty()) {
            getBackground().setBounds(this.mOverrideRect);
        }
        dispatchDraw28(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mAllowDispatchEvent) {
            return false;
        }
        if (!this.mOverrideRect.isEmpty() && !this.mOverrideRect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.mOverrideRect.isEmpty()) {
            getBackground().setBounds(this.mOverrideRect);
        }
        super.draw(canvas);
    }

    public boolean getUseBackgroundBlur() {
        return this.mUseBackgroundBlur;
    }

    public void initUseBackgroundBlur(boolean z10) {
        initUseBackgroundBlur(z10, UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        float[] colorToFloats;
        float[] colorToFloats2;
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            COUILog.e(TAG, "Hardware accelerate is disabled! Set background blur failed.");
            return;
        }
        if (this.mUseBackgroundBlur) {
            if (this.mCrossWindowBlurEnabledListener == null) {
                this.mCrossWindowBlurEnabledListener = new Consumer() { // from class: com.coui.appcompat.poplist.k
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        RoundFrameLayout.this.lambda$onAttachedToWindow$0((Boolean) obj);
                    }
                };
            }
            if (this.mWindowManager == null) {
                this.mWindowManager = (WindowManager) getContext().getSystemService("window");
            }
            ViewRootManager viewRootManager = new ViewRootManager(this);
            this.mViewRootManger = viewRootManager;
            this.mBackgroundBlurDrawable = viewRootManager.getBackgroundBlurDrawable();
            this.mWindowManager.addCrossWindowBlurEnabledListener(this.mCrossWindowBlurEnabledListener);
            OplusBlurParam oplusBlurParam = new OplusBlurParam();
            int i10 = 2;
            oplusBlurParam.setBlurType(2);
            if (!COUIDarkModeUtil.isNightMode(getContext()) && !this.mIsCOUIDarkTheme) {
                i10 = 3;
            }
            if (this.mIsCOUIDarkTheme) {
                colorToFloats = UIUtil.colorToFloats(COUIContextUtil.getColor(getContext(), X8.e.f4452r));
                colorToFloats2 = UIUtil.colorToFloats(COUIContextUtil.getColor(getContext(), X8.e.f4455u));
            } else {
                colorToFloats = UIUtil.colorToFloats(COUIContextUtil.getColor(getContext(), X8.e.f4451q));
                colorToFloats2 = UIUtil.colorToFloats(COUIContextUtil.getColor(getContext(), X8.e.f4454t));
            }
            oplusBlurParam.setMaterialParams(i10, colorToFloats, colorToFloats2);
            if (this.mIsSupportSRCWhenBlur.booleanValue()) {
                oplusBlurParam.setSmoothCornerWeight(COUIContextUtil.getAttrFloat(getContext(), X8.c.f4377e0));
                COUILog.i(TAG, "current version support roundCorner when use blur");
            }
            this.mViewRootManger.setBlurParams(oplusBlurParam);
            this.mViewRootManger.setBlurRadius(getContext().getResources().getDimensionPixelSize(X8.f.f4611V2));
            this.mViewRootManger.setCornerRadius(getContext().getResources().getDimensionPixelOffset(X8.f.f4751n3));
            Drawable drawable = this.mBackgroundBlurDrawable;
            if (drawable != null) {
                setBackground(drawable);
                this.mBackgroundBlurDrawable.setAlpha((int) (getAlpha() * 255.0f));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        WindowManager windowManager;
        super.onDetachedFromWindow();
        if (this.mUseBackgroundBlur && (windowManager = this.mWindowManager) != null) {
            windowManager.removeCrossWindowBlurEnabledListener(this.mCrossWindowBlurEnabledListener);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mRectF.set(getPaddingLeft(), getPaddingTop(), i10 - getPaddingRight(), i11 - getPaddingBottom());
    }

    public void setAllowDispatchEvent(boolean z10) {
        this.mAllowDispatchEvent = z10;
    }

    @Override // android.view.View
    public void setAlpha(float f10) {
        super.setAlpha(f10);
        if (this.mUseBackgroundBlur && getBackground() != null) {
            getBackground().setAlpha((int) (f10 * 255.0f));
        }
    }

    public void setClipMode(int i10) {
        this.mClipMode = i10;
        if (i10 == 0) {
            setClipToOutline(false);
            setElevation(0.0f);
            setBackgroundColor(0);
        } else if (i10 == 1) {
            setClipToOutline(true);
            if (ShadowUtils.checkOPlusViewElevationSDK()) {
                ShadowUtils.setElevationToView(this, 3);
            } else {
                setElevation(getContext().getResources().getDimensionPixelSize(X8.f.f4523I5));
                setOutlineSpotShadowColor(androidx.core.content.b.c(getContext(), X8.e.f4458x));
            }
            setBackgroundColor(-1);
        }
    }

    public void setOverrideOutline(int i10, int i11, int i12, int i13, float f10) {
        this.mOutlineAlpha = f10;
        this.mOverrideRect.set(i10, i11, i12, i13);
        if (getBackground() != null) {
            getBackground().setBounds(this.mOverrideRect);
        }
        invalidateOutline();
    }

    public void setRadius(float f10) {
        this.mRadius = f10;
        postInvalidate();
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void initUseBackgroundBlur(boolean z10, AnimLevel animLevel) {
        if (ShadowUtils.checkOPlusViewElevationSDK() && UIUtil.confirmLevelAnim(animLevel) && this.mIsBlurEnable) {
            this.mUseBackgroundBlur = z10;
            return;
        }
        Log.e(TAG, "setUseBackgroundBlur can only be used on versions above OS15 or AnimLevel is higher than " + animLevel + " or is in third party theme");
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mOutlineRect = new Rect();
        this.mOverrideRect = new Rect();
        this.mOutlineAlpha = 1.0f;
        this.mAllowDispatchEvent = true;
        this.mUseBackgroundBlur = false;
        this.mIsCOUIDarkTheme = true;
        this.mIsBlurEnable = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5222U6);
        this.mRadius = obtainStyledAttributes.getDimension(o.f5246X6, 0.0f);
        this.mClipMode = obtainStyledAttributes.getInt(o.f5230V6, 0);
        this.mRoundCornerWeight = obtainStyledAttributes.getFloat(o.f5238W6, 0.0f);
        obtainStyledAttributes.recycle();
        this.mPath = new Path();
        this.mPaint = new Paint(1);
        this.mRectF = new RectF();
        this.mIsSupportSmoothRoundCorner = RoundCornerUtil.isVersionSupport();
        this.mIsSupportSRCWhenBlur = Boolean.valueOf(RoundCornerUtil.isSupportRoundCornerWhenBlur());
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.poplist.RoundFrameLayout.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                if (!RoundFrameLayout.this.mOverrideRect.isEmpty()) {
                    outline.setAlpha(RoundFrameLayout.this.mOutlineAlpha);
                    RoundFrameLayout.this.mOutlineRect.set(RoundFrameLayout.this.mOverrideRect);
                } else {
                    RoundFrameLayout.this.mOutlineRect.set((int) RoundFrameLayout.this.mRectF.left, (int) RoundFrameLayout.this.mRectF.top, (int) RoundFrameLayout.this.mRectF.right, (int) RoundFrameLayout.this.mRectF.bottom);
                }
                if (RoundFrameLayout.this.mIsSupportSmoothRoundCorner && RoundFrameLayout.this.mRoundCornerWeight != 0.0f && (!RoundFrameLayout.this.mUseBackgroundBlur || RoundFrameLayout.this.mIsSupportSRCWhenBlur.booleanValue())) {
                    new OplusOutline(outline).setSmoothRoundRect(RoundFrameLayout.this.mOutlineRect, RoundFrameLayout.this.mRadius, RoundFrameLayout.this.mRoundCornerWeight);
                } else {
                    outline.setRoundRect(RoundFrameLayout.this.mOutlineRect, RoundFrameLayout.this.mRadius);
                }
            }
        });
        setClipMode(this.mClipMode);
        setDefaultFocusHighlightEnabled(false);
        this.mIsCOUIDarkTheme = COUIContextUtil.isCOUIDarkTheme(getContext());
        this.mIsBlurEnable = getContext().getResources().getBoolean(X8.d.f4420a);
    }
}
