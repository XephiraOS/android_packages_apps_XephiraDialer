package com.coui.appcompat.couiswitch;

import K.a;
import X8.c;
import X8.d;
import X8.f;
import X8.g;
import X8.l;
import X8.m;
import X8.o;
import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.Switch;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.b;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.soundloadutil.COUIAsyncSoundUtil;
import com.coui.appcompat.state.COUIStateEffectDrawable;
import com.coui.appcompat.state.COUIStrokeDrawable;
import com.coui.appcompat.state.StateEffectAnimator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class COUISwitch extends SwitchCompat {
    private static final int ALPHA_VALUE_30 = 1308622847;
    private static final float DEFAULT_STATE_SPRING_BOUNCE = 0.0f;
    private static final float DEFAULT_STATE_SPRING_RESPONSE = 0.3f;
    private static final String TAG = "COUISwitch";
    private int mBarCheckedColor;
    private int mBarCheckedDisabledColor;
    private int mBarHeight;
    private int mBarTrackCurrentColor;
    private int mBarUnCheckedColor;
    private int mBarUncheckedDisabledColor;
    private Drawable mCheckedDrawable;
    private int mCirclePadding;
    private float mCircleScale;
    private float mCircleScaleX;
    private int mCircleTranslation;
    private int mDefaultTranslation;
    private boolean mEnableHapticFeedback;
    private StateEffectAnimator mHoverAnimator;
    private float mInnerCircleAlpha;
    private int mInnerCircleCheckedDisabledColor;
    private int mInnerCircleColor;
    private Paint mInnerCirclePaint;
    private RectF mInnerCircleRectF;
    private int mInnerCircleUncheckedDisabledColor;
    private int mInnerCircleWidth;
    private boolean mIsAttachedToWindow;
    private boolean mIsLoading;
    private boolean mIsLoadingStyle;
    private boolean mIsMeasured;
    private boolean mIsThemedEnabled;
    private float mLoadingAlpha;
    private Drawable mLoadingDrawable;
    private float mLoadingRotation;
    private float mLoadingScale;
    private AccessibilityManager mManager;
    private OnLoadingStateChangedListener mOnLoadingStateChangedListener;
    private int mOuterCircleCheckedDisabledColor;
    private int mOuterCircleColor;
    private Paint mOuterCirclePaint;
    private RectF mOuterCircleRectF;
    private int mOuterCircleStrokeWidth;
    private int mOuterCircleUnCheckedColor;
    private int mOuterCircleUncheckedDisabledColor;
    private int mOuterCircleWidth;
    private int mPadding;
    private StateEffectAnimator mPressAnimator;
    private boolean mShouldPlaySound;
    private AnimatorSet mStartLoadingAnimator;
    private COUIStateEffectDrawable mStateEffectBackground;
    private AnimatorSet mStopLoadingAnimator;
    private COUIStrokeDrawable mStrokeDrawable;
    private int mStyle;
    private String mSwitchLoadingStr;
    private String mSwitchOffStr;
    private String mSwitchOnStr;
    private final RectF mSwitchRect;
    private AnimatorSet mThemedLoadingAnimator;
    private Drawable mThemedLoadingCheckedBackground;
    private Drawable mThemedLoadingDrawable;
    private Drawable mThemedLoadingUncheckedBackground;
    private AnimatorSet mToggleAnimator;
    private Drawable mUncheckedDrawable;
    private ExecutorService mVibratorExecutor;

    /* loaded from: classes.dex */
    public interface OnLoadingStateChangedListener {
        void onStartLoading();

        void onStopLoading();
    }

    public COUISwitch(Context context) {
        this(context, null);
    }

    private void animateWhenStateChanged(boolean z10) {
        int i10;
        int i11;
        if (this.mToggleAnimator == null) {
            this.mToggleAnimator = new AnimatorSet();
        }
        float f10 = 0.0f;
        Interpolator a10 = a.a(0.3f, 0.0f, 0.1f, 1.0f);
        int i12 = this.mCircleTranslation;
        if (isRtlMode()) {
            if (!z10) {
                i10 = this.mDefaultTranslation;
            }
            i10 = 0;
        } else {
            if (z10) {
                i10 = this.mDefaultTranslation;
            }
            i10 = 0;
        }
        this.mToggleAnimator.setInterpolator(a10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "circleScaleX", 1.0f, 1.3f);
        ofFloat.setDuration(133L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "circleScaleX", 1.3f, 1.0f);
        ofFloat2.setStartDelay(133L);
        ofFloat2.setDuration(250L);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "circleTranslation", i12, i10);
        ofInt.setDuration(383L);
        float f11 = this.mInnerCircleAlpha;
        if (!z10) {
            f10 = 1.0f;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "innerCircleAlpha", f11, f10);
        ofFloat3.setDuration(100L);
        int barColor = getBarColor();
        if (z10) {
            i11 = this.mBarCheckedColor;
        } else {
            i11 = this.mBarUnCheckedColor;
        }
        ObjectAnimator ofArgb = ObjectAnimator.ofArgb(this, "barColor", barColor, i11);
        ofArgb.setDuration(450L);
        this.mToggleAnimator.play(ofFloat).with(ofFloat2).with(ofInt).with(ofFloat3).with(ofArgb);
        this.mToggleAnimator.start();
    }

    private Drawable backgroundDrawable() {
        if (isLoading()) {
            if (isChecked()) {
                return this.mThemedLoadingCheckedBackground;
            }
            return this.mThemedLoadingUncheckedBackground;
        }
        if (isChecked()) {
            return this.mCheckedDrawable;
        }
        return this.mUncheckedDrawable;
    }

    private boolean canDrawBar() {
        return true;
    }

    private void configStateEffectAnimator() {
        this.mHoverAnimator = new StateEffectAnimator(this, "hover", 0, COUIContextUtil.getAttrColor(getContext(), c.f4414x));
        this.mPressAnimator = new StateEffectAnimator(this, "press", 0, COUIContextUtil.getAttrColor(getContext(), c.f4345D));
        this.mHoverAnimator.setSpringResponse(0.3f);
        this.mHoverAnimator.setSpringBounce(0.0f);
        this.mPressAnimator.setSpringResponse(0.3f);
        this.mPressAnimator.setSpringBounce(0.0f);
    }

    private void drawBar() {
        Drawable trackDrawable;
        int i10;
        if (canDrawBar() && (trackDrawable = getTrackDrawable()) != null) {
            if (isEnabled()) {
                trackDrawable.setTint(B.a.q(this.mPressAnimator.getCurrentMaskColor(), B.a.q(this.mHoverAnimator.getCurrentMaskColor(), this.mBarTrackCurrentColor)));
                return;
            }
            if (isChecked()) {
                i10 = this.mBarCheckedDisabledColor;
            } else {
                i10 = this.mBarUncheckedDisabledColor;
            }
            trackDrawable.setTint(i10);
        }
    }

    private void drawLoading(Canvas canvas) {
        if (!this.mIsLoading) {
            return;
        }
        canvas.save();
        float f10 = this.mLoadingScale;
        canvas.scale(f10, f10, this.mOuterCircleRectF.centerX(), this.mOuterCircleRectF.centerY());
        canvas.rotate(this.mLoadingRotation, this.mOuterCircleRectF.centerX(), this.mOuterCircleRectF.centerY());
        Drawable drawable = this.mLoadingDrawable;
        if (drawable != null) {
            RectF rectF = this.mOuterCircleRectF;
            drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.mLoadingDrawable.setAlpha((int) (this.mLoadingAlpha * 255.0f));
            this.mLoadingDrawable.draw(canvas);
        }
        canvas.restore();
    }

    private void drawOuterCircle(Canvas canvas) {
        int i10;
        int i11;
        canvas.save();
        float f10 = this.mCircleScale;
        canvas.scale(f10, f10, this.mOuterCircleRectF.centerX(), this.mOuterCircleRectF.centerY());
        Paint paint = this.mOuterCirclePaint;
        if (isChecked()) {
            i10 = this.mOuterCircleColor;
        } else {
            i10 = this.mOuterCircleUnCheckedColor;
        }
        paint.setColor(i10);
        if (!isEnabled()) {
            Paint paint2 = this.mOuterCirclePaint;
            if (isChecked()) {
                i11 = this.mOuterCircleCheckedDisabledColor;
            } else {
                i11 = this.mOuterCircleUncheckedDisabledColor;
            }
            paint2.setColor(i11);
        }
        float f11 = this.mOuterCircleWidth / 2.0f;
        canvas.drawRoundRect(this.mOuterCircleRectF, f11, f11, this.mOuterCirclePaint);
        canvas.restore();
    }

    private void drawThemedBackground(Canvas canvas) {
        canvas.save();
        Drawable backgroundDrawable = backgroundDrawable();
        backgroundDrawable.setAlpha(drawableAlpha());
        int i10 = this.mPadding;
        int switchMinWidth = getSwitchMinWidth();
        int i11 = this.mPadding;
        backgroundDrawable.setBounds(i10, i10, switchMinWidth + i11, this.mBarHeight + i11);
        backgroundDrawable().draw(canvas);
        canvas.restore();
    }

    private void drawThemedLoading(Canvas canvas) {
        if (!this.mIsLoading) {
            return;
        }
        int width = (getWidth() - this.mOuterCircleWidth) / 2;
        int width2 = (getWidth() + this.mOuterCircleWidth) / 2;
        int height = (getHeight() - this.mOuterCircleWidth) / 2;
        int height2 = (getHeight() + this.mOuterCircleWidth) / 2;
        int width3 = getWidth() / 2;
        int height3 = getHeight() / 2;
        canvas.save();
        canvas.rotate(this.mLoadingRotation, width3, height3);
        this.mThemedLoadingDrawable.setBounds(width, height, width2, height2);
        this.mThemedLoadingDrawable.draw(canvas);
        canvas.restore();
    }

    private int drawableAlpha() {
        float f10;
        if (isEnabled()) {
            f10 = 1.0f;
        } else {
            f10 = 0.5f;
        }
        return (int) (f10 * 255.0f);
    }

    private int getBarColor() {
        return this.mBarTrackCurrentColor;
    }

    private void initAnimator() {
        initStartLoadingAnimator();
        initStopLoadingAnimator();
        initThemedLoadingAnimator();
    }

    private void initAttr(TypedArray typedArray, Context context) {
        this.mLoadingDrawable = typedArray.getDrawable(o.f5419t5);
        this.mBarHeight = typedArray.getDimensionPixelSize(o.f5363m5, 0);
        this.mOuterCircleStrokeWidth = typedArray.getDimensionPixelSize(o.f5443w5, 0);
        this.mOuterCircleWidth = typedArray.getDimensionPixelOffset(o.f5459y5, 0);
        this.mInnerCircleWidth = typedArray.getDimensionPixelSize(o.f5411s5, 0);
        this.mCirclePadding = typedArray.getDimensionPixelSize(o.f5379o5, 0);
        this.mInnerCircleColor = typedArray.getColor(o.f5395q5, 0);
        this.mOuterCircleColor = typedArray.getColor(o.f5435v5, 0);
        this.mInnerCircleUncheckedDisabledColor = typedArray.getColor(o.f5403r5, 0);
        this.mOuterCircleUnCheckedColor = typedArray.getColor(o.f5467z5, 0);
        this.mInnerCircleCheckedDisabledColor = typedArray.getColor(o.f5387p5, 0);
        this.mOuterCircleUncheckedDisabledColor = typedArray.getColor(o.f5451x5, 0);
        this.mOuterCircleCheckedDisabledColor = typedArray.getColor(o.f5427u5, 0);
        this.mBarCheckedDisabledColor = typedArray.getColor(o.f5371n5, COUIContextUtil.getAttrColor(context, c.f4347F) & ALPHA_VALUE_30);
        boolean z10 = getContext().getResources().getBoolean(d.f4422c);
        this.mIsThemedEnabled = z10;
        if (z10) {
            this.mThemedLoadingDrawable = typedArray.getDrawable(o.f5077C5);
            this.mThemedLoadingCheckedBackground = typedArray.getDrawable(o.f5069B5);
            this.mThemedLoadingUncheckedBackground = typedArray.getDrawable(o.f5085D5);
            this.mCheckedDrawable = typedArray.getDrawable(o.f5061A5);
            this.mUncheckedDrawable = typedArray.getDrawable(o.f5093E5);
        }
    }

    private void initPaint() {
        this.mOuterCirclePaint = new Paint(1);
        setPaintShadowLayer();
        this.mInnerCirclePaint = new Paint(1);
    }

    private void initResValue(Context context) {
        int i10;
        this.mPadding = context.getResources().getDimensionPixelSize(f.f4627X4);
        this.mSwitchOnStr = getResources().getString(m.f4996F);
        this.mSwitchOffStr = getResources().getString(m.f4995E);
        this.mSwitchLoadingStr = getResources().getString(m.f4994D);
        this.mDefaultTranslation = (getSwitchMinWidth() - (this.mCirclePadding * 2)) - this.mOuterCircleWidth;
        this.mBarCheckedColor = COUIContextUtil.getAttrColor(context, c.f4347F);
        this.mBarUnCheckedColor = COUIContextUtil.getAttrColor(context, c.f4394n);
        if (isChecked()) {
            i10 = this.mBarCheckedColor;
        } else {
            i10 = this.mBarUnCheckedColor;
        }
        this.mBarTrackCurrentColor = i10;
        this.mBarUncheckedDisabledColor = COUIContextUtil.getAttrColor(context, c.f4346E);
        setTrackTintMode(PorterDuff.Mode.SRC);
    }

    private void initStartLoadingAnimator() {
        Interpolator a10 = a.a(0.3f, 0.0f, 0.1f, 1.0f);
        this.mStartLoadingAnimator = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "circleScale", 1.0f, 0.0f);
        ofFloat.setInterpolator(a10);
        ofFloat.setDuration(433L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "loadingScale", 0.5f, 1.0f);
        ofFloat2.setInterpolator(a10);
        ofFloat2.setDuration(550L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "loadingAlpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(a10);
        ofFloat3.setDuration(550L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "loadingRotation", 0.0f, 360.0f);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setDuration(800L);
        ofFloat4.setInterpolator(new COUILinearInterpolator());
        this.mStartLoadingAnimator.play(ofFloat).with(ofFloat3).with(ofFloat2).with(ofFloat4);
    }

    private void initStateEffectBackground() {
        Drawable background = getBackground();
        COUIStrokeDrawable cOUIStrokeDrawable = new COUIStrokeDrawable(getContext());
        this.mStrokeDrawable = cOUIStrokeDrawable;
        RectF rectF = this.mSwitchRect;
        Resources resources = getContext().getResources();
        int i10 = f.f4667d;
        cOUIStrokeDrawable.setStrokeRect(rectF, resources.getDimensionPixelOffset(i10), getContext().getResources().getDimensionPixelOffset(i10));
        if (background == null) {
            background = new ColorDrawable(0);
        }
        Drawable[] drawableArr = {background, this.mStrokeDrawable};
        setDefaultFocusHighlightEnabled(false);
        COUIStateEffectDrawable cOUIStateEffectDrawable = new COUIStateEffectDrawable(drawableArr);
        this.mStateEffectBackground = cOUIStateEffectDrawable;
        super.setBackground(cOUIStateEffectDrawable);
    }

    private void initStopLoadingAnimator() {
        Interpolator a10 = a.a(0.3f, 0.0f, 0.1f, 1.0f);
        this.mStopLoadingAnimator = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "loadingAlpha", 1.0f, 0.0f);
        ofFloat.setInterpolator(a10);
        ofFloat.setDuration(100L);
        this.mStopLoadingAnimator.play(ofFloat);
    }

    private void initThemedLoadingAnimator() {
        this.mThemedLoadingAnimator = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "loadingRotation", 0.0f, 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(800L);
        ofFloat.setInterpolator(new COUILinearInterpolator());
        this.mThemedLoadingAnimator.play(ofFloat);
    }

    private boolean isRtlMode() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void performFeedBack() {
        if (isTactileFeedbackEnabled()) {
            if (this.mVibratorExecutor == null) {
                this.mVibratorExecutor = Executors.newSingleThreadExecutor();
            }
            this.mVibratorExecutor.execute(new Runnable() { // from class: com.coui.appcompat.couiswitch.COUISwitch.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(263L);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                    if (COUISwitch.this.mToggleAnimator != null && COUISwitch.this.mToggleAnimator.isRunning()) {
                        COUISwitch.this.performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
                    }
                }
            });
            setTactileFeedbackEnabled(false);
        }
    }

    private void playSoundEffect(boolean z10) {
        int i10;
        Context context = getContext();
        if (z10) {
            i10 = l.f4990b;
        } else {
            i10 = l.f4989a;
        }
        COUIAsyncSoundUtil.play(context, i10, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    private void setBarColor(int i10) {
        this.mBarTrackCurrentColor = i10;
        invalidate();
    }

    private void setInnerCircleRectF() {
        RectF rectF = this.mOuterCircleRectF;
        float f10 = rectF.left;
        int i10 = this.mOuterCircleStrokeWidth;
        this.mInnerCircleRectF.set(f10 + i10, rectF.top + i10, rectF.right - i10, rectF.bottom - i10);
    }

    private void setOuterCircleRectF() {
        float f10;
        float f11;
        float f12;
        float f13;
        if (isChecked()) {
            if (isRtlMode()) {
                f10 = this.mCirclePadding + this.mCircleTranslation + this.mPadding;
                f11 = this.mOuterCircleWidth;
                f12 = this.mCircleScaleX;
                f13 = (f11 * f12) + f10;
            } else {
                f13 = ((getSwitchMinWidth() - this.mCirclePadding) - (this.mDefaultTranslation - this.mCircleTranslation)) + this.mPadding;
                f10 = f13 - (this.mOuterCircleWidth * this.mCircleScaleX);
            }
        } else if (isRtlMode()) {
            int switchMinWidth = (getSwitchMinWidth() - this.mCirclePadding) - (this.mDefaultTranslation - this.mCircleTranslation);
            int i10 = this.mPadding;
            float f14 = switchMinWidth + i10;
            float f15 = i10 + (f14 - (this.mOuterCircleWidth * this.mCircleScaleX));
            f13 = f14;
            f10 = f15;
        } else {
            f10 = this.mCirclePadding + this.mCircleTranslation + this.mPadding;
            f11 = this.mOuterCircleWidth;
            f12 = this.mCircleScaleX;
            f13 = (f11 * f12) + f10;
        }
        int i11 = this.mBarHeight;
        float f16 = ((i11 - r3) / 2.0f) + this.mPadding;
        this.mOuterCircleRectF.set(f10, f16, f13, this.mOuterCircleWidth + f16);
    }

    private void setPaintShadowLayer() {
        this.mOuterCirclePaint.setShadowLayer(8.0f, 0.0f, 4.0f, Color.argb(25, 0, 0, 0));
    }

    public void disableThemed() {
        this.mIsThemedEnabled = false;
    }

    public void enableThemed() {
        this.mIsThemedEnabled = true;
    }

    @Override // android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Switch.class.getName();
    }

    public final int getOuterCircleUncheckedColor() {
        return this.mOuterCircleUnCheckedColor;
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    public boolean isTactileFeedbackEnabled() {
        return this.mEnableHapticFeedback;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        COUIAsyncSoundUtil.register(getContext(), l.f4990b, l.f4989a);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mIsThemedEnabled) {
            drawThemedBackground(canvas);
            drawThemedLoading(canvas);
            return;
        }
        drawBar();
        setOuterCircleRectF();
        setInnerCircleRectF();
        super.onDraw(canvas);
        drawOuterCircle(canvas);
        drawLoading(canvas);
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        String str;
        String str2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.mIsLoadingStyle) {
            accessibilityNodeInfo.setCheckable(false);
            if (isChecked()) {
                str2 = this.mSwitchOnStr;
            } else {
                str2 = this.mSwitchOffStr;
            }
            accessibilityNodeInfo.setText(str2);
            return;
        }
        if (isChecked()) {
            str = this.mSwitchOnStr;
        } else {
            str = this.mSwitchOffStr;
        }
        accessibilityNodeInfo.setText(str);
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        float f10;
        super.onMeasure(i10, i11);
        int switchMinWidth = getSwitchMinWidth();
        int i12 = this.mPadding;
        setMeasuredDimension(switchMinWidth + (i12 * 2), this.mBarHeight + (i12 * 2));
        if (!this.mIsMeasured) {
            this.mIsMeasured = true;
            int i13 = 0;
            if (isRtlMode()) {
                if (!isChecked()) {
                    i13 = this.mDefaultTranslation;
                }
                this.mCircleTranslation = i13;
            } else {
                if (isChecked()) {
                    i13 = this.mDefaultTranslation;
                }
                this.mCircleTranslation = i13;
            }
            if (isChecked()) {
                f10 = 0.0f;
            } else {
                f10 = 1.0f;
            }
            this.mInnerCircleAlpha = f10;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mSwitchRect.set(0.0f, 0.0f, i10, i11);
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() || isFocusable()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 3) {
                        this.mPressAnimator.animateToProgress(0.0f, true);
                    }
                } else {
                    this.mShouldPlaySound = true;
                    this.mEnableHapticFeedback = true;
                    this.mPressAnimator.animateToProgress(0.0f, true);
                    if (this.mIsLoadingStyle && isEnabled()) {
                        startLoading();
                        return false;
                    }
                }
            } else {
                this.mPressAnimator.animateToProgress(10000.0f, true);
            }
        }
        if (this.mIsLoading) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, o.f5355l5, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = getContext().obtainStyledAttributes(null, o.f5355l5, 0, this.mStyle);
        }
        if (typedArray != null) {
            initAttr(typedArray, getContext());
            typedArray.recycle();
            initResValue(getContext());
        }
        StateEffectAnimator stateEffectAnimator = this.mPressAnimator;
        if (stateEffectAnimator != null) {
            stateEffectAnimator.setEndMaskColor(COUIContextUtil.getAttrColor(getContext(), c.f4345D));
        }
        StateEffectAnimator stateEffectAnimator2 = this.mHoverAnimator;
        if (stateEffectAnimator2 != null) {
            stateEffectAnimator2.setEndMaskColor(COUIContextUtil.getAttrColor(getContext(), c.f4414x));
        }
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            cOUIStateEffectDrawable.refresh(getContext());
        }
        invalidate();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        COUIStateEffectDrawable cOUIStateEffectDrawable = this.mStateEffectBackground;
        if (cOUIStateEffectDrawable != null) {
            if (drawable == null) {
                cOUIStateEffectDrawable.setViewBackground(new ColorDrawable(0));
                return;
            } else {
                cOUIStateEffectDrawable.setViewBackground(drawable);
                return;
            }
        }
        super.setBackground(drawable);
    }

    public final void setBarCheckedColor(int i10) {
        this.mBarCheckedColor = i10;
        if (isChecked()) {
            this.mBarTrackCurrentColor = this.mBarCheckedColor;
        }
        setBarStateListDrawable();
        invalidate();
    }

    public final void setBarCheckedDisabledColor(int i10) {
        this.mBarCheckedDisabledColor = i10;
        setBarStateListDrawable();
        invalidate();
    }

    public void setBarStateListDrawable() {
        Drawable e10 = b.e(getContext(), g.f4846D);
        Drawable e11 = b.e(getContext(), g.f4844B);
        Drawable e12 = b.e(getContext(), g.f4847E);
        Drawable e13 = b.e(getContext(), g.f4845C);
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (this.mBarCheckedColor != 0) {
            GradientDrawable gradientDrawable = (GradientDrawable) e10.mutate();
            gradientDrawable.setColor(this.mBarCheckedColor);
            stateListDrawable.addState(new int[]{R.attr.state_checked, 16842910}, gradientDrawable);
        } else {
            stateListDrawable.addState(new int[]{R.attr.state_checked, 16842910}, e10);
        }
        if (this.mBarUnCheckedColor != 0) {
            GradientDrawable gradientDrawable2 = (GradientDrawable) e11.mutate();
            gradientDrawable2.setColor(this.mBarUnCheckedColor);
            stateListDrawable.addState(new int[]{-16842912, 16842910}, gradientDrawable2);
        } else {
            stateListDrawable.addState(new int[]{-16842912, 16842910}, e11);
        }
        if (this.mBarCheckedDisabledColor != 0) {
            GradientDrawable gradientDrawable3 = (GradientDrawable) e12.mutate();
            gradientDrawable3.setColor(this.mBarCheckedDisabledColor);
            stateListDrawable.addState(new int[]{-16842910, R.attr.state_checked}, gradientDrawable3);
        } else {
            stateListDrawable.addState(new int[]{-16842910, R.attr.state_checked}, e12);
        }
        if (this.mBarUncheckedDisabledColor != 0) {
            GradientDrawable gradientDrawable4 = (GradientDrawable) e13.mutate();
            gradientDrawable4.setColor(this.mBarUncheckedDisabledColor);
            stateListDrawable.addState(new int[]{-16842910, -16842912}, gradientDrawable4);
        } else {
            stateListDrawable.addState(new int[]{-16842910, -16842912}, e13);
        }
        setTrackDrawable(stateListDrawable);
    }

    public final void setBarUnCheckedColor(int i10) {
        this.mBarUnCheckedColor = i10;
        if (!isChecked()) {
            this.mBarTrackCurrentColor = this.mBarUnCheckedColor;
        }
        setBarStateListDrawable();
        invalidate();
    }

    public final void setBarUncheckedDisabledColor(int i10) {
        this.mBarUncheckedDisabledColor = i10;
        setBarStateListDrawable();
        invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        setChecked(z10, true);
    }

    public void setCheckedDrawable(Drawable drawable) {
        this.mCheckedDrawable = drawable;
    }

    public void setCircleScale(float f10) {
        this.mCircleScale = f10;
        invalidate();
    }

    public void setCircleScaleX(float f10) {
        this.mCircleScaleX = f10;
        invalidate();
    }

    public void setCircleTranslation(int i10) {
        this.mCircleTranslation = i10;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (this.mOuterCirclePaint == null) {
            this.mOuterCirclePaint = new Paint(1);
        }
        if (z10) {
            setPaintShadowLayer();
        } else {
            this.mOuterCirclePaint.clearShadowLayer();
        }
    }

    @Override // android.view.View
    public void setHovered(boolean z10) {
        float f10;
        super.setHovered(z10);
        if (isEnabled()) {
            StateEffectAnimator stateEffectAnimator = this.mHoverAnimator;
            if (z10) {
                f10 = 10000.0f;
            } else {
                f10 = 0.0f;
            }
            stateEffectAnimator.animateToProgress(f10, true);
        }
    }

    public void setInnerCircleAlpha(float f10) {
        this.mInnerCircleAlpha = f10;
        invalidate();
    }

    public void setInnerCircleColor(int i10) {
        this.mInnerCircleColor = i10;
    }

    public void setLoadingAlpha(float f10) {
        this.mLoadingAlpha = f10;
        invalidate();
    }

    public void setLoadingDrawable(Drawable drawable) {
        this.mLoadingDrawable = drawable;
    }

    public void setLoadingRotation(float f10) {
        this.mLoadingRotation = f10;
        invalidate();
    }

    public void setLoadingScale(float f10) {
        this.mLoadingScale = f10;
        invalidate();
    }

    public void setLoadingStyle(boolean z10) {
        this.mIsLoadingStyle = z10;
    }

    public void setOnLoadingStateChangedListener(OnLoadingStateChangedListener onLoadingStateChangedListener) {
        this.mOnLoadingStateChangedListener = onLoadingStateChangedListener;
    }

    public void setOuterCircleColor(int i10) {
        this.mOuterCircleColor = i10;
    }

    public void setOuterCircleStrokeWidth(int i10) {
        this.mOuterCircleStrokeWidth = i10;
    }

    public final void setOuterCircleUncheckedColor(int i10) {
        this.mOuterCircleUnCheckedColor = i10;
        invalidate();
    }

    public void setShouldPlaySound(boolean z10) {
        this.mShouldPlaySound = z10;
    }

    public void setTactileFeedbackEnabled(boolean z10) {
        this.mEnableHapticFeedback = z10;
    }

    public void setThemedLoadingCheckedBackground(Drawable drawable) {
        this.mThemedLoadingCheckedBackground = drawable;
    }

    public void setThemedLoadingUncheckedBackground(Drawable drawable) {
        this.mThemedLoadingUncheckedBackground = drawable;
    }

    public void setUncheckedDrawable(Drawable drawable) {
        this.mUncheckedDrawable = drawable;
    }

    public void startLoading() {
        if (!this.mIsLoading) {
            AccessibilityManager accessibilityManager = this.mManager;
            if (accessibilityManager != null && accessibilityManager.isEnabled()) {
                announceForAccessibility(this.mSwitchLoadingStr);
            }
            this.mIsLoading = true;
            if (this.mIsThemedEnabled) {
                this.mThemedLoadingAnimator.start();
            } else {
                this.mStartLoadingAnimator.start();
            }
            OnLoadingStateChangedListener onLoadingStateChangedListener = this.mOnLoadingStateChangedListener;
            if (onLoadingStateChangedListener != null) {
                onLoadingStateChangedListener.onStartLoading();
            }
            invalidate();
        }
    }

    public void stopLoading() {
        AccessibilityManager accessibilityManager;
        String str;
        if (this.mIsLoadingStyle && (accessibilityManager = this.mManager) != null && accessibilityManager.isEnabled()) {
            if (isChecked()) {
                str = this.mSwitchOffStr;
            } else {
                str = this.mSwitchOnStr;
            }
            announceForAccessibility(str);
        }
        AnimatorSet animatorSet = this.mStartLoadingAnimator;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mStartLoadingAnimator.cancel();
        }
        AnimatorSet animatorSet2 = this.mThemedLoadingAnimator;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            this.mThemedLoadingAnimator.cancel();
        }
        if (this.mIsLoading) {
            if (!this.mIsThemedEnabled) {
                this.mStopLoadingAnimator.start();
            }
            setCircleScale(1.0f);
            this.mIsLoading = false;
            toggle();
            OnLoadingStateChangedListener onLoadingStateChangedListener = this.mOnLoadingStateChangedListener;
            if (onLoadingStateChangedListener != null) {
                onLoadingStateChangedListener.onStopLoading();
            }
        }
    }

    public COUISwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f4399p0);
    }

    public void setChecked(boolean z10, boolean z11) {
        if (z10 == isChecked()) {
            return;
        }
        super.setChecked(z10);
        if (!this.mIsThemedEnabled) {
            z10 = isChecked();
            AnimatorSet animatorSet = this.mToggleAnimator;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.mToggleAnimator.cancel();
                this.mToggleAnimator.end();
            }
            if (this.mIsAttachedToWindow && z11) {
                animateWhenStateChanged(z10);
            } else {
                if (isRtlMode()) {
                    setCircleTranslation(z10 ? 0 : this.mDefaultTranslation);
                } else {
                    setCircleTranslation(z10 ? this.mDefaultTranslation : 0);
                }
                setInnerCircleAlpha(z10 ? 0.0f : 1.0f);
                setBarColor(z10 ? this.mBarCheckedColor : this.mBarUnCheckedColor);
            }
        }
        if (this.mShouldPlaySound && this.mIsAttachedToWindow) {
            playSoundEffect(z10);
            this.mShouldPlaySound = false;
        }
        performFeedBack();
        invalidate();
    }

    public COUISwitch(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mSwitchRect = new RectF();
        this.mIsLoading = false;
        this.mIsLoadingStyle = false;
        this.mToggleAnimator = new AnimatorSet();
        this.mOuterCircleRectF = new RectF();
        this.mInnerCircleRectF = new RectF();
        this.mCircleScaleX = 1.0f;
        this.mCircleScale = 1.0f;
        this.mIsMeasured = false;
        setSoundEffectsEnabled(false);
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        this.mManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5355l5, i10, 0);
        initAttr(obtainStyledAttributes, context);
        obtainStyledAttributes.recycle();
        initAnimator();
        initPaint();
        initResValue(context);
        initStateEffectBackground();
        configStateEffectAnimator();
    }
}
