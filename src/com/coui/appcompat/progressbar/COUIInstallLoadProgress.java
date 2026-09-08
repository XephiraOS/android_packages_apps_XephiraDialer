package com.coui.appcompat.progressbar;

import X8.m;
import X8.o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;
import androidx.appcompat.widget.S;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.roundRect.COUIRoundRectUtil;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.tintimageview.COUITintUtil;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUIInstallLoadProgress extends COUILoadProgress {
    private static final String CIRCLE_BRIGHTNESS_HOLDER = "circleBrightnessHolder";
    private static final String CIRCLE_IN_ALPHA_HOLDER = "circleInAlphaHolder";
    private static final int CIRCLE_MAX_ALPHA = 255;
    private static final String CIRCLE_OUT_ALPHA_HOLDER = "circleOutAlphaHolder";
    private static final String CIRCLE_RADIUS_HOLDER = "circleRadiusHolder";
    private static final float DEFAULT_BRIGHTNESS_MAX_VALUE = 0.8f;
    private static final float DEFAULT_MIN_PRESS_FEEDBACK = 0.005f;
    private static final float DEFAULT_NARROW_FINAL_VALUE = 0.92f;
    private static final float DEFAULT_SCALE_PARAMETER = 0.05f;
    private static final float DEFAULT_SCALE_PERCENT = 0.4f;
    private static final String HOLDER_BRIGHTNESS = "brightnessHolder";
    private static final String HOLDER_NARROW_FONT = "narrowHolderFont";
    private static final String HOLDER_NARROW_X = "narrowHolderX";
    private static final String HOLDER_NARROW_Y = "narrowHolderY";
    public static final int LOAD_STYLE_BIG_ROUND = 1;
    public static final int LOAD_STYLE_CIRCLE = 2;
    public static final int LOAD_STYLE_DEFAULT = 0;
    private static final int MAX_COLOR = 255;
    private static final int NORMAL_ANIMATOR_DURATION = 340;
    private static final float ONE_POINT_FIVE = 1.5f;
    private static final double POINT_FIVE = 0.5d;
    private static final int PRESS_ANIMATOR_DURATION = 200;
    private static final int[] mAttrArray = {X8.c.f4347F, X8.c.f4352K};
    private final boolean DEBUG;
    private final String TAG;
    private String mApostrophe;
    private int mBtnTextColor;
    private boolean mBtnTextColorChanged;
    private ColorStateList mBtnTextColorStateList;
    private Bitmap mCircleLoadBitmap;
    private Paint mCirclePaint;
    private Bitmap mCirclePauseBitmap;
    private Bitmap mCircleReloadBitmap;
    private float[] mColorHsl;
    private int mColorPrimary;
    private int mColorSecondary;
    private int mColorWhite;
    private Context mContext;
    private float mCurrentBrightness;
    private float mCurrentCircleRadius;
    private int mCurrentInBitmapAlpha;
    private int mCurrentOutBitmapAlpha;
    private int mCurrentRoundBorderRadius;
    private int mDefaultCircleRadius;
    private ColorStateList mDefaultTextColor;
    private int mDefaultTextSize;
    private int mDefaultWidth;
    private int mDisabledColor;
    private String mDownloadingContentDecrpition;
    private int mExpandOffsetX;
    private int mExpandOffsetY;
    private Paint.FontMetricsInt mFmi;
    private boolean mHasBrightness;
    private Paint mInBitmapPaint;
    private Drawable mInstallGiftBg;
    private boolean mIsChangeTextColor;
    private boolean mIsNeedVibrate;
    private int mLoadStyle;
    private Locale mLocale;
    private float mMaxBrightness;
    private float mNarrowOffsetFont;
    private Interpolator mNormalAnimationInterpolator;
    private ValueAnimator mNormalAnimator;
    private Paint mOutBitmapPaint;
    private Interpolator mPressAnimationInterpolator;
    private ValueAnimator mPressedAnimator;
    private float mRadiusOffset;
    private Paint mRoundRectPaint;
    private Path mRoundRectPath;
    private int mSpace;
    private int mStyle;
    private int mSurpassProgressColor;
    private int mTextColor;
    private int mTextPadding;
    private TextPaint mTextPaint;
    private String mTextView;
    private int mThemeColor;
    private ColorStateList mThemeColorStateList;
    private int mThemeSecondaryColor;
    private ColorStateList mThemeSecondaryColorStateList;
    private int mTouchModeCircleRadius;
    private int mTouchModeHeight;
    private int mTouchModeWidth;
    private int mUserTextColor;
    private int mUserTextSize;

    public COUIInstallLoadProgress(Context context) {
        this(context, null);
    }

    private void addApostrophe() {
        String displayText = getDisplayText(this.mTextView, this.mDefaultWidth);
        if (displayText.length() > 0 && displayText.length() < this.mTextView.length()) {
            this.mTextView = isEnglish(getDisplayText(displayText, (this.mDefaultWidth - (this.mTextPadding * 2)) - ((int) this.mTextPaint.measureText(this.mApostrophe)))) + this.mApostrophe;
        }
    }

    private void cancelAnim(ValueAnimator valueAnimator) {
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
    }

    private int dip2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + POINT_FIVE);
    }

    private Bitmap getBitmapFromVectorDrawable(int i10) {
        Drawable drawable = getContext().getDrawable(i10);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private int getCurrentColor(int i10) {
        if (!isEnabled()) {
            return this.mDisabledColor;
        }
        B.a.m(i10, this.mColorHsl);
        float[] fArr = this.mColorHsl;
        fArr[2] = fArr[2] * this.mCurrentBrightness;
        int a10 = B.a.a(fArr);
        int red = Color.red(a10);
        int green = Color.green(a10);
        int blue = Color.blue(a10);
        int alpha = Color.alpha(i10);
        if (red > 255) {
            red = 255;
        }
        if (green > 255) {
            green = 255;
        }
        if (blue > 255) {
            blue = 255;
        }
        return Color.argb(alpha, red, green, blue);
    }

    private int getDefaultSize(int i10, float f10, boolean z10) {
        int dip2px;
        if (z10) {
            dip2px = dip2px(getContext(), f10);
        } else {
            dip2px = dip2px(getContext(), f10) * 2;
        }
        return i10 - dip2px;
    }

    private String getDisplayText(String str, int i10) {
        int breakText = this.mTextPaint.breakText(str, true, i10, null);
        if (breakText != 0 && breakText != str.length()) {
            return str.substring(0, breakText - 1);
        }
        return str;
    }

    private void init() {
        if (this.mLoadStyle == 2) {
            return;
        }
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        int i10 = this.mUserTextSize;
        if (i10 == 0) {
            i10 = this.mDefaultTextSize;
        }
        int i11 = this.mUserTextColor;
        this.mTextColor = i11;
        if (i11 == -1) {
            this.mTextColor = this.mDefaultTextColor.getColorForState(getDrawableState(), COUIContextUtil.getAttrColor(getContext(), X8.c.f4355N, 0));
        }
        this.mTextPaint.setTextSize(i10);
        COUIChangeTextUtil.adaptBoldAndMediumFont((Paint) this.mTextPaint, true);
        this.mFmi = this.mTextPaint.getFontMetricsInt();
        addApostrophe();
    }

    private static boolean isChinese(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (Character.toString(str.charAt(i11)).matches("^[一-龥]{1}$")) {
                i10++;
            }
        }
        if (i10 <= 0) {
            return false;
        }
        return true;
    }

    private String isEnglish(String str) {
        int lastIndexOf;
        if (!isChinese(str) && (lastIndexOf = str.lastIndexOf(32)) > 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    private boolean isZhLanguage(Locale locale) {
        return "zh".equalsIgnoreCase(locale.getLanguage());
    }

    private void onDrawButtonDrawable(Canvas canvas, float f10, float f11, float f12, float f13) {
        Drawable drawable = this.mButtonDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.mButtonDrawable.getIntrinsicHeight();
            int i10 = ((int) (f12 - intrinsicWidth)) / 2;
            int i11 = ((int) (f13 - intrinsicHeight)) / 2;
            int i12 = intrinsicWidth + i10;
            int i13 = intrinsicHeight + i11;
            this.mButtonDrawable.setBounds(i10, i11, i12, i13);
            Drawable drawable2 = this.mButtonDrawable;
            int i14 = this.mTextColor;
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            drawable2.setColorFilter(i14, mode);
            this.mButtonDrawable.draw(canvas);
            if (this.mIsChangeTextColor) {
                canvas.save();
                this.mButtonDrawableReverseColor.setBounds(i10, i11, i12, i13);
                this.mButtonDrawableReverseColor.setColorFilter(this.mSurpassProgressColor, mode);
                if (!S.b(this)) {
                    canvas.clipRect(f10, f11, this.mSpace, f13);
                } else {
                    canvas.clipRect(f12 - this.mSpace, f11, f12, f13);
                }
                this.mButtonDrawableReverseColor.draw(canvas);
                canvas.restore();
                this.mIsChangeTextColor = false;
            }
        }
    }

    private void onDrawCircle(Canvas canvas, float f10, float f11, boolean z10, Bitmap bitmap, Bitmap bitmap2) {
        int i10;
        int i11;
        if (bitmap != null && !bitmap.isRecycled() && bitmap2 != null && !bitmap2.isRecycled()) {
            Paint paint = this.mCirclePaint;
            if (this.mThemeColorStateList == null) {
                i10 = getCurrentColor(this.mColorPrimary);
            } else {
                i10 = this.mThemeColor;
            }
            paint.setColor(i10);
            if (!z10) {
                Paint paint2 = this.mCirclePaint;
                if (this.mThemeSecondaryColorStateList == null) {
                    i11 = getCurrentColor(this.mColorSecondary);
                } else {
                    i11 = this.mThemeSecondaryColor;
                }
                paint2.setColor(i11);
            }
            float f12 = this.mCurrentCircleRadius;
            Path path = COUIRoundRectUtil.getInstance().getPath(new RectF(f10 - f12, f11 - f12, f10 + f12, f11 + f12), this.mCurrentRoundBorderRadius);
            this.mRoundRectPath = path;
            canvas.drawPath(path, this.mCirclePaint);
            int width = (this.mTouchModeWidth - bitmap.getWidth()) / 2;
            int height = (this.mTouchModeHeight - bitmap.getHeight()) / 2;
            this.mInBitmapPaint.setAlpha(this.mCurrentInBitmapAlpha);
            this.mOutBitmapPaint.setAlpha(this.mCurrentOutBitmapAlpha);
            float f13 = width;
            float f14 = height;
            canvas.drawBitmap(bitmap, f13, f14, this.mInBitmapPaint);
            canvas.drawBitmap(bitmap2, f13, f14, this.mOutBitmapPaint);
            canvas.save();
        }
    }

    private void onDrawRoundRect(Canvas canvas, float f10, float f11, float f12, float f13, boolean z10, float f14, float f15) {
        int i10;
        int i11;
        canvas.translate(f14, f15);
        RectF rectF = new RectF(f10, f11, f12, f13);
        Paint paint = this.mRoundRectPaint;
        if (this.mThemeColorStateList == null) {
            i10 = getCurrentColor(this.mColorPrimary);
        } else {
            i10 = this.mThemeColor;
        }
        paint.setColor(i10);
        if (!z10) {
            Paint paint2 = this.mRoundRectPaint;
            if (this.mThemeSecondaryColorStateList == null) {
                i11 = getCurrentColor(this.mColorSecondary);
            } else {
                i11 = this.mThemeSecondaryColor;
            }
            paint2.setColor(i11);
        }
        Path path = COUIRoundRectUtil.getInstance().getPath(rectF, ((f13 - f11) / 2.0f) - this.mRadiusOffset);
        this.mRoundRectPath = path;
        canvas.drawPath(path, this.mRoundRectPaint);
        canvas.translate(-f14, -f15);
    }

    private void onDrawText(Canvas canvas, float f10, float f11, float f12, float f13) {
        if (this.mTextView != null) {
            this.mTextPaint.setTextSize(this.mDefaultTextSize * this.mNarrowOffsetFont);
            float measureText = this.mTextPaint.measureText(this.mTextView);
            float f14 = this.mTextPadding + (((f12 - measureText) - (r1 * 2)) / 2.0f);
            Paint.FontMetricsInt fontMetricsInt = this.mFmi;
            int i10 = fontMetricsInt.bottom;
            float f15 = ((f13 - (i10 - r0)) / 2.0f) - fontMetricsInt.top;
            canvas.drawText(this.mTextView, f14, f15, this.mTextPaint);
            if (this.mIsChangeTextColor) {
                this.mTextPaint.setColor(this.mSurpassProgressColor);
                canvas.save();
                if (!S.b(this)) {
                    canvas.clipRect(f10, f11, this.mSpace, f13);
                } else {
                    canvas.clipRect(f12 - this.mSpace, f11, f12, f13);
                }
                canvas.drawText(this.mTextView, f14, f15, this.mTextPaint);
                canvas.restore();
                this.mIsChangeTextColor = false;
            }
        }
    }

    private void performHapticFeedback() {
        if (this.mIsNeedVibrate) {
            performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        }
    }

    private void performTouchEndAnim(final boolean z10) {
        performHapticFeedback();
        if (!this.mHasBrightness) {
            return;
        }
        cancelAnim(this.mPressedAnimator);
        int i10 = this.mLoadStyle;
        if (i10 != 0 && i10 != 1) {
            if (i10 == 2) {
                ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(CIRCLE_RADIUS_HOLDER, this.mCurrentCircleRadius, this.mDefaultCircleRadius), PropertyValuesHolder.ofFloat(CIRCLE_BRIGHTNESS_HOLDER, this.mCurrentBrightness, 1.0f), PropertyValuesHolder.ofInt(CIRCLE_IN_ALPHA_HOLDER, 0, 255), PropertyValuesHolder.ofInt(CIRCLE_OUT_ALPHA_HOLDER, 255, 0));
                this.mNormalAnimator = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setInterpolator(this.mNormalAnimationInterpolator);
                this.mNormalAnimator.setDuration(340L);
                this.mNormalAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.COUIInstallLoadProgress.5
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        COUIInstallLoadProgress.this.mCurrentCircleRadius = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.CIRCLE_RADIUS_HOLDER)).floatValue();
                        COUIInstallLoadProgress.this.mCurrentBrightness = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.CIRCLE_BRIGHTNESS_HOLDER)).floatValue();
                        COUIInstallLoadProgress.this.mCurrentInBitmapAlpha = ((Integer) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.CIRCLE_IN_ALPHA_HOLDER)).intValue();
                        COUIInstallLoadProgress.this.mCurrentOutBitmapAlpha = ((Integer) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.CIRCLE_OUT_ALPHA_HOLDER)).intValue();
                        COUIInstallLoadProgress.this.invalidate();
                    }
                });
                this.mNormalAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.progressbar.COUIInstallLoadProgress.6
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        COUIInstallLoadProgress.super.performClick();
                    }
                });
                this.mNormalAnimator.start();
            }
        } else {
            ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(HOLDER_BRIGHTNESS, this.mCurrentBrightness, 1.0f), PropertyValuesHolder.ofFloat(HOLDER_NARROW_X, this.mExpandOffsetX, 0.0f), PropertyValuesHolder.ofFloat(HOLDER_NARROW_Y, this.mExpandOffsetY, 0.0f), PropertyValuesHolder.ofFloat(HOLDER_NARROW_FONT, this.mNarrowOffsetFont, 1.0f));
            this.mNormalAnimator = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setInterpolator(this.mNormalAnimationInterpolator);
            this.mNormalAnimator.setDuration(340L);
            this.mNormalAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.COUIInstallLoadProgress.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUIInstallLoadProgress.this.mCurrentBrightness = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.HOLDER_BRIGHTNESS)).floatValue();
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.HOLDER_NARROW_X)).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.HOLDER_NARROW_Y)).floatValue();
                    COUIInstallLoadProgress.this.mNarrowOffsetFont = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.HOLDER_NARROW_FONT)).floatValue();
                    COUIInstallLoadProgress.this.mExpandOffsetX = (int) (floatValue + COUIInstallLoadProgress.POINT_FIVE);
                    COUIInstallLoadProgress.this.mExpandOffsetY = (int) (floatValue2 + COUIInstallLoadProgress.POINT_FIVE);
                    COUIInstallLoadProgress.this.invalidate();
                }
            });
            this.mNormalAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.progressbar.COUIInstallLoadProgress.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (z10) {
                        COUIInstallLoadProgress.super.performClick();
                    }
                }
            });
            this.mNormalAnimator.start();
        }
        this.mHasBrightness = false;
    }

    private void performTouchStartAnim() {
        if (this.mHasBrightness) {
            return;
        }
        cancelAnim(this.mNormalAnimator);
        int i10 = this.mLoadStyle;
        if (i10 != 0 && i10 != 1) {
            if (i10 == 2) {
                ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(CIRCLE_RADIUS_HOLDER, this.mCurrentCircleRadius, this.mDefaultCircleRadius * 0.9f), PropertyValuesHolder.ofFloat(CIRCLE_BRIGHTNESS_HOLDER, this.mCurrentBrightness, this.mMaxBrightness));
                this.mPressedAnimator = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setInterpolator(this.mPressAnimationInterpolator);
                this.mPressedAnimator.setDuration(200L);
                this.mPressedAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.COUIInstallLoadProgress.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        COUIInstallLoadProgress.this.mCurrentCircleRadius = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.CIRCLE_RADIUS_HOLDER)).floatValue();
                        COUIInstallLoadProgress.this.mCurrentBrightness = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.CIRCLE_BRIGHTNESS_HOLDER)).floatValue();
                        COUIInstallLoadProgress.this.invalidate();
                    }
                });
                this.mPressedAnimator.start();
            }
        } else {
            ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat(HOLDER_BRIGHTNESS, 1.0f, this.mMaxBrightness), PropertyValuesHolder.ofFloat(HOLDER_NARROW_X, 0.0f, getMeasuredWidth() * DEFAULT_SCALE_PARAMETER), PropertyValuesHolder.ofFloat(HOLDER_NARROW_Y, 0.0f, getMeasuredHeight() * DEFAULT_SCALE_PARAMETER), PropertyValuesHolder.ofFloat(HOLDER_NARROW_FONT, 1.0f, DEFAULT_NARROW_FINAL_VALUE));
            this.mPressedAnimator = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setInterpolator(this.mPressAnimationInterpolator);
            this.mPressedAnimator.setDuration(200L);
            this.mPressedAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.progressbar.COUIInstallLoadProgress.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUIInstallLoadProgress.this.mCurrentBrightness = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.HOLDER_BRIGHTNESS)).floatValue();
                    float floatValue = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.HOLDER_NARROW_X)).floatValue();
                    float floatValue2 = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.HOLDER_NARROW_Y)).floatValue();
                    float floatValue3 = ((Float) valueAnimator.getAnimatedValue(COUIInstallLoadProgress.HOLDER_NARROW_FONT)).floatValue();
                    if (floatValue < COUIInstallLoadProgress.this.getMeasuredWidth() * COUIInstallLoadProgress.DEFAULT_MIN_PRESS_FEEDBACK && floatValue2 < COUIInstallLoadProgress.this.getMeasuredHeight() * COUIInstallLoadProgress.DEFAULT_MIN_PRESS_FEEDBACK) {
                        floatValue = COUIInstallLoadProgress.this.getMeasuredWidth() * COUIInstallLoadProgress.DEFAULT_MIN_PRESS_FEEDBACK;
                        floatValue2 = COUIInstallLoadProgress.this.getMeasuredHeight() * COUIInstallLoadProgress.DEFAULT_MIN_PRESS_FEEDBACK;
                    }
                    COUIInstallLoadProgress.this.mExpandOffsetX = (int) (floatValue + COUIInstallLoadProgress.POINT_FIVE);
                    COUIInstallLoadProgress.this.mExpandOffsetY = (int) (floatValue2 + COUIInstallLoadProgress.POINT_FIVE);
                    COUIInstallLoadProgress.this.mNarrowOffsetFont = floatValue3;
                    COUIInstallLoadProgress.this.invalidate();
                }
            });
            this.mPressedAnimator.start();
        }
        this.mHasBrightness = true;
    }

    @Override // com.coui.appcompat.progressbar.COUILoadProgress, androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        int i10;
        super.onAttachedToWindow();
        if (this.mLoadStyle == 2) {
            Bitmap bitmap = this.mCircleLoadBitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap bitmapFromVectorDrawable = getBitmapFromVectorDrawable(X8.g.f4860m);
                this.mCircleLoadBitmap = bitmapFromVectorDrawable;
                if (this.mThemeColorStateList == null) {
                    i10 = this.mColorPrimary;
                } else {
                    i10 = this.mThemeColor;
                }
                this.mCircleLoadBitmap = COUITintUtil.tintBitmap(bitmapFromVectorDrawable, i10);
            }
            Bitmap bitmap2 = this.mCircleReloadBitmap;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.mCircleReloadBitmap = getBitmapFromVectorDrawable(X8.g.f4862o);
            }
            Bitmap bitmap3 = this.mCirclePauseBitmap;
            if (bitmap3 == null || bitmap3.isRecycled()) {
                this.mCirclePauseBitmap = getBitmapFromVectorDrawable(X8.g.f4861n);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Locale locale = Locale.getDefault();
        if (this.mLoadStyle == 0 && !this.mLocale.getLanguage().equalsIgnoreCase(locale.getLanguage())) {
            this.mLocale = locale;
            int dimensionPixelSize = getResources().getDimensionPixelSize(X8.f.f4750n2);
            if (!isZhLanguage(this.mLocale)) {
                this.mTouchModeWidth += dimensionPixelSize;
                this.mDefaultWidth += dimensionPixelSize;
            } else {
                this.mTouchModeWidth -= dimensionPixelSize;
                this.mDefaultWidth -= dimensionPixelSize;
            }
            invalidate();
        }
    }

    @Override // com.coui.appcompat.progressbar.COUILoadProgress, android.view.View
    public void onDetachedFromWindow() {
        if (this.mLoadStyle == 2) {
            Bitmap bitmap = this.mCircleLoadBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mCircleLoadBitmap.recycle();
            }
            Bitmap bitmap2 = this.mCirclePauseBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.mCirclePauseBitmap.recycle();
            }
            Bitmap bitmap3 = this.mCircleReloadBitmap;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.mCircleReloadBitmap.recycle();
            }
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // com.coui.appcompat.progressbar.COUILoadProgress, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r23) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.progressbar.COUIInstallLoadProgress.onDraw(android.graphics.Canvas):void");
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(this.mMax);
        accessibilityEvent.setCurrentItemIndex(this.mProgress);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        String str;
        String str2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int i10 = this.mState;
        if ((i10 == 0 || i10 == 3 || i10 == 2) && (str = this.mTextView) != null) {
            accessibilityNodeInfo.setContentDescription(str);
        } else if (i10 == 1 && (str2 = this.mDownloadingContentDecrpition) != null) {
            accessibilityNodeInfo.setContentDescription(str2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(this.mTouchModeWidth, this.mTouchModeHeight);
        init();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            boolean z10 = false;
            if (action != 1) {
                if (action == 3) {
                    performTouchEndAnim(false);
                }
            } else {
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (x10 >= 0.0f && x10 <= this.mTouchModeWidth && y10 >= 0.0f && y10 <= this.mTouchModeHeight) {
                    z10 = true;
                }
                performTouchEndAnim(z10);
            }
        } else {
            performHapticFeedback();
            performTouchStartAnim();
        }
        return true;
    }

    public void refresh() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(mAttrArray);
        this.mColorPrimary = obtainStyledAttributes.getColor(0, 0);
        this.mColorSecondary = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5456y2, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = this.mContext.obtainStyledAttributes(null, o.f5456y2, 0, this.mStyle);
        }
        if (typedArray != null) {
            this.mDisabledColor = typedArray.getColor(o.f5146L2, 0);
            typedArray.recycle();
        }
    }

    @Deprecated
    public void setBtnTextColor(int i10) {
        this.mBtnTextColor = i10;
        this.mBtnTextColorChanged = true;
        invalidate();
    }

    public void setBtnTextColorBySurpassProgress(int i10) {
        this.mSurpassProgressColor = i10;
        invalidate();
    }

    public void setBtnTextColorStateList(ColorStateList colorStateList) {
        this.mBtnTextColorStateList = colorStateList;
        if (colorStateList == null) {
            setBtnTextColor(-1);
        } else {
            setBtnTextColor(colorStateList.getDefaultColor());
        }
    }

    public void setDefaultTextSize(int i10) {
        this.mDefaultTextSize = i10;
    }

    public void setDisabledColor(int i10) {
        this.mDisabledColor = i10;
    }

    public void setDownloadingContentDecrpition(String str) {
        this.mDownloadingContentDecrpition = str;
    }

    public void setIsNeedVibrate(boolean z10) {
        this.mIsNeedVibrate = z10;
    }

    public void setLoadStyle(int i10) {
        if (i10 == 2) {
            this.mLoadStyle = 2;
            Paint paint = new Paint(1);
            this.mCirclePaint = paint;
            paint.setAntiAlias(true);
            Paint paint2 = new Paint(1);
            this.mInBitmapPaint = paint2;
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint(1);
            this.mOutBitmapPaint = paint3;
            paint3.setAntiAlias(true);
            this.mCircleLoadBitmap = getBitmapFromVectorDrawable(X8.g.f4860m);
            this.mCircleReloadBitmap = getBitmapFromVectorDrawable(X8.g.f4862o);
            this.mCirclePauseBitmap = getBitmapFromVectorDrawable(X8.g.f4861n);
            int dimensionPixelSize = getResources().getDimensionPixelSize(X8.f.f4710i2);
            this.mTouchModeCircleRadius = dimensionPixelSize;
            int defaultSize = getDefaultSize(dimensionPixelSize, ONE_POINT_FIVE, true);
            this.mDefaultCircleRadius = defaultSize;
            this.mCurrentCircleRadius = defaultSize;
            return;
        }
        this.mLoadStyle = i10;
        this.mRoundRectPaint = new Paint(1);
    }

    public void setMaxBrightness(int i10) {
        this.mMaxBrightness = i10;
    }

    public void setText(String str) {
        if (!str.equals(this.mTextView)) {
            this.mTextView = str;
            if (this.mTextPaint != null) {
                addApostrophe();
            }
            invalidate();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        if (i10 != 0) {
            this.mUserTextColor = i10;
        }
    }

    public void setTextId(int i10) {
        setText(getResources().getString(i10));
    }

    public void setTextPadding(int i10) {
        this.mTextPadding = i10;
    }

    public void setTextSize(int i10) {
        if (i10 != 0) {
            this.mUserTextSize = i10;
        }
    }

    @Deprecated
    public void setThemeColor(int i10) {
        this.mThemeColor = i10;
        Bitmap bitmap = this.mCircleLoadBitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            this.mCircleLoadBitmap = getBitmapFromVectorDrawable(X8.g.f4860m);
        }
        this.mCircleLoadBitmap = COUITintUtil.tintBitmap(this.mCircleLoadBitmap, this.mThemeColor);
        invalidate();
    }

    public void setThemeColorStateList(ColorStateList colorStateList) {
        this.mThemeColorStateList = colorStateList;
        if (colorStateList == null) {
            setThemeColor(-1);
        } else {
            setThemeColor(colorStateList.getDefaultColor());
        }
    }

    @Deprecated
    public void setThemeSecondaryColor(int i10) {
        this.mThemeSecondaryColor = i10;
        invalidate();
    }

    public void setThemeSecondaryColorStateList(ColorStateList colorStateList) {
        this.mThemeSecondaryColorStateList = colorStateList;
        if (colorStateList == null) {
            setThemeSecondaryColor(-1);
        } else {
            setThemeSecondaryColor(colorStateList.getDefaultColor());
        }
    }

    public void setTouchModeHeight(int i10) {
        this.mTouchModeHeight = i10;
    }

    public void setTouchModeWidth(int i10) {
        this.mTouchModeWidth = i10;
    }

    public COUIInstallLoadProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X8.c.f4360S);
    }

    public COUIInstallLoadProgress(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.TAG = "COUIInstallLoadProgress";
        this.DEBUG = true;
        this.mTextPaint = null;
        this.mUserTextSize = 0;
        this.mTextPadding = 0;
        this.mApostrophe = null;
        this.mFmi = null;
        this.mCurrentRoundBorderRadius = 0;
        this.mRoundRectPaint = null;
        this.mSpace = 0;
        this.mIsChangeTextColor = false;
        this.mTouchModeCircleRadius = 0;
        this.mDefaultCircleRadius = 0;
        this.mCurrentCircleRadius = 0.0f;
        this.mCurrentInBitmapAlpha = 255;
        this.mCurrentOutBitmapAlpha = 0;
        this.mCirclePaint = null;
        this.mInBitmapPaint = null;
        this.mOutBitmapPaint = null;
        this.mInstallGiftBg = null;
        this.mLoadStyle = 0;
        this.mBtnTextColorChanged = false;
        this.mCurrentBrightness = 1.0f;
        this.mUserTextColor = -1;
        this.mExpandOffsetY = 0;
        this.mExpandOffsetX = 0;
        this.mNarrowOffsetFont = 1.0f;
        this.mColorHsl = new float[3];
        COUIDarkModeUtil.setForceDarkAllow(this, false);
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.mStyle = attributeSet.getStyleAttribute();
        } else {
            this.mStyle = i10;
        }
        this.mContext = context;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(mAttrArray);
        this.mColorPrimary = obtainStyledAttributes.getColor(0, 0);
        this.mColorSecondary = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.mLocale = Locale.getDefault();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, o.f5210T2, i10, 0);
        Resources resources = getResources();
        int i11 = X8.e.f4448n;
        this.mColorWhite = resources.getColor(i11);
        this.mSurpassProgressColor = getResources().getColor(i11);
        this.mIsNeedVibrate = obtainStyledAttributes2.getBoolean(o.f5242X2, false);
        Drawable drawable = obtainStyledAttributes2.getDrawable(o.f5218U2);
        if (drawable != null) {
            setButtonDrawable(drawable);
        }
        setState(obtainStyledAttributes2.getInteger(o.f5234W2, 0));
        obtainStyledAttributes2.recycle();
        int dimensionPixelSize = getResources().getDimensionPixelSize(X8.f.f4742m2);
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, o.f5456y2, i10, 0);
        setLoadStyle(obtainStyledAttributes3.getInteger(o.f5114H2, 0));
        this.mInstallGiftBg = obtainStyledAttributes3.getDrawable(o.f5066B2);
        this.mTouchModeHeight = obtainStyledAttributes3.getDimensionPixelSize(o.f5098F2, 0);
        int dimensionPixelOffset = obtainStyledAttributes3.getDimensionPixelOffset(o.f5106G2, 0);
        this.mTouchModeWidth = dimensionPixelOffset;
        this.mDefaultWidth = getDefaultSize(dimensionPixelOffset, ONE_POINT_FIVE, false);
        this.mMaxBrightness = obtainStyledAttributes3.getFloat(o.f5464z2, DEFAULT_BRIGHTNESS_MAX_VALUE);
        this.mDisabledColor = obtainStyledAttributes3.getColor(o.f5146L2, 0);
        this.mPressAnimationInterpolator = new COUIMoveEaseInterpolator();
        this.mNormalAnimationInterpolator = new COUIMoveEaseInterpolator();
        int i12 = this.mLoadStyle;
        if (i12 != 2) {
            if (i12 == 1) {
                this.mCurrentRoundBorderRadius = getResources().getDimensionPixelSize(X8.f.f4718j2);
            } else {
                this.mCurrentRoundBorderRadius = getResources().getDimensionPixelSize(X8.f.f4734l2);
                if (!isZhLanguage(this.mLocale)) {
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(X8.f.f4750n2);
                    this.mTouchModeWidth += dimensionPixelSize2;
                    this.mDefaultWidth += dimensionPixelSize2;
                }
            }
            this.mDefaultTextColor = obtainStyledAttributes3.getColorStateList(o.f5058A2);
            this.mTextPadding = obtainStyledAttributes3.getDimensionPixelOffset(o.f5074C2, 0);
            this.mTextView = obtainStyledAttributes3.getString(o.f5090E2);
            this.mDefaultTextSize = obtainStyledAttributes3.getDimensionPixelSize(o.f5082D2, dimensionPixelSize);
            this.mDefaultTextSize = (int) COUIChangeTextUtil.getSuitableFontSize(this.mDefaultTextSize, getResources().getConfiguration().fontScale, 2);
            if (this.mApostrophe == null) {
                this.mApostrophe = getResources().getString(m.f5006e);
            }
        } else {
            this.mCurrentRoundBorderRadius = getResources().getDimensionPixelSize(X8.f.f4702h2);
        }
        setThemeColorStateList(obtainStyledAttributes3.getColorStateList(o.f5122I2));
        setThemeSecondaryColorStateList(obtainStyledAttributes3.getColorStateList(o.f5130J2));
        setBtnTextColorStateList(obtainStyledAttributes3.getColorStateList(o.f5138K2));
        obtainStyledAttributes3.recycle();
        this.mRadiusOffset = getResources().getDimension(X8.f.f4726k2);
    }
}
