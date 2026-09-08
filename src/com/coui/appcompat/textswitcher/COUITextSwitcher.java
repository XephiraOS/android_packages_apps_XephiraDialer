package com.coui.appcompat.textswitcher;

import X8.o;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.coui.appcompat.animation.COUIAnimationListenerAdapter;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class COUITextSwitcher extends TextSwitcher implements ViewSwitcher.ViewFactory {
    public static final int ALPHA = 3;
    public static final int ALPHA_SCALE_BLUR = 1;
    private static final int BLUR_ANIM_DELAY = 300;
    private static final int BLUR_ANIM_DURATION = 300;
    private static final PathInterpolator COUI_MOVE_EASE = new COUIMoveEaseInterpolator();
    private static final int DEFAULT_BLUR_RADIUS = 10;
    private static final float DEFAULT_SCALE = 1.22f;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    private static final String TAG = "COUITextSwitcher";
    public static final int TRANSLATE = 2;
    public static final int TRANSLATE_ALPHA = 0;
    public static final int UP = 0;
    private int mAnimDirection;
    private int mAnimEffect;
    private Context mContext;
    private int mEllipse;
    private ValueAnimator mInBlurAnim;
    private float mMaxBlur;
    private float mMaxScale;
    private ValueAnimator mOutBlurAnim;
    private CharSequence mText;
    private int mTextAppearance;
    private int mTextColor;
    private int mTextSize;
    private int mTextStyle;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnimDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnimEffect {
    }

    public COUITextSwitcher(Context context) {
        this(context, null);
    }

    private void createBlurAnim(boolean z10) {
        if (this.mOutBlurAnim == null || z10) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mOutBlurAnim = ofFloat;
            ofFloat.setDuration(300L);
            this.mOutBlurAnim.setInterpolator(COUI_MOVE_EASE);
            this.mOutBlurAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.textswitcher.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUITextSwitcher.this.lambda$createBlurAnim$0(valueAnimator);
                }
            });
        }
        if (this.mInBlurAnim == null || z10) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.mInBlurAnim = ofFloat2;
            ofFloat2.setDuration(300L);
            this.mInBlurAnim.setStartDelay(300L);
            this.mInBlurAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.textswitcher.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUITextSwitcher.this.lambda$createBlurAnim$1(valueAnimator);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createBlurAnim$0(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.mMaxBlur;
        if (floatValue > 0.0f) {
            updatePreviousViewBlur(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createBlurAnim$1(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.mMaxBlur;
        if (floatValue > 0.0f) {
            updateCurrentViewBlur(floatValue);
        } else {
            removeBlur();
        }
    }

    private void selectAnimation() {
        int i10 = this.mAnimEffect;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        setInAnimation(this.mContext, X8.a.f4321a);
                        setOutAnimation(this.mContext, X8.a.f4322b);
                        return;
                    }
                    return;
                }
                setInAnimation(this.mContext, X8.a.f4336p);
                setOutAnimation(this.mContext, X8.a.f4337q);
                return;
            }
            createBlurAnim(false);
            setAlphaScaleBlurEffectInAnim();
            setAlphaScaleBlurEffectOutAnim();
            return;
        }
        int i11 = this.mAnimDirection;
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        setInAnimation(this.mContext, X8.a.f4333m);
                        setOutAnimation(this.mContext, X8.a.f4332l);
                        return;
                    }
                    return;
                }
                setInAnimation(this.mContext, X8.a.f4330j);
                setOutAnimation(this.mContext, X8.a.f4331k);
                return;
            }
            setInAnimation(this.mContext, X8.a.f4328h);
            setOutAnimation(this.mContext, X8.a.f4329i);
            return;
        }
        setInAnimation(this.mContext, X8.a.f4334n);
        setOutAnimation(this.mContext, X8.a.f4335o);
    }

    private void setAlphaScaleBlurEffectInAnim() {
        AnimationSet animationSet = new AnimationSet(true);
        float f10 = this.mMaxScale;
        ScaleAnimation scaleAnimation = new ScaleAnimation(f10, 1.0f, f10, 1.0f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        animationSet.setInterpolator(COUI_MOVE_EASE);
        animationSet.setStartOffset(300L);
        animationSet.setDuration(300L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new COUIAnimationListenerAdapter() { // from class: com.coui.appcompat.textswitcher.COUITextSwitcher.1
            @Override // com.coui.appcompat.animation.COUIAnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (COUITextSwitcher.this.mInBlurAnim != null) {
                    COUITextSwitcher.this.mInBlurAnim.end();
                }
            }

            @Override // com.coui.appcompat.animation.COUIAnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (COUITextSwitcher.this.mInBlurAnim != null) {
                    COUITextSwitcher.this.mInBlurAnim.start();
                }
            }
        });
        setInAnimation(animationSet);
    }

    private void setAlphaScaleBlurEffectOutAnim() {
        AnimationSet animationSet = new AnimationSet(true);
        float f10 = this.mMaxScale;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f10, 1.0f, f10, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.setInterpolator(COUI_MOVE_EASE);
        animationSet.setDuration(300L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setAnimationListener(new COUIAnimationListenerAdapter() { // from class: com.coui.appcompat.textswitcher.COUITextSwitcher.2
            @Override // com.coui.appcompat.animation.COUIAnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (COUITextSwitcher.this.mOutBlurAnim != null) {
                    COUITextSwitcher.this.mOutBlurAnim.end();
                }
            }

            @Override // com.coui.appcompat.animation.COUIAnimationListenerAdapter, android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (COUITextSwitcher.this.mOutBlurAnim != null) {
                    COUITextSwitcher.this.mOutBlurAnim.start();
                }
            }
        });
        setOutAnimation(animationSet);
    }

    private void updateCurrentViewBlur(float f10) {
        getCurrentView().setRenderEffect(RenderEffect.createBlurEffect(f10, f10, Shader.TileMode.CLAMP));
    }

    private void updatePreviousViewBlur(float f10) {
        getPreviousView().setRenderEffect(RenderEffect.createBlurEffect(f10, f10, Shader.TileMode.CLAMP));
    }

    public View getPreviousView() {
        int displayedChild = getDisplayedChild() - 1;
        if (displayedChild >= getChildCount()) {
            displayedChild = 0;
        } else if (displayedChild < 0) {
            displayedChild = getChildCount() - 1;
        }
        return getChildAt(displayedChild);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView;
        int i10 = this.mTextStyle;
        if (i10 != 0 && i10 != 1) {
            textView = new SpacingTextView(this.mContext);
        } else {
            textView = new TextView(this.mContext);
        }
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            textView.setText(charSequence);
        }
        int i11 = this.mTextSize;
        if (i11 != -1) {
            textView.setTextSize(0, i11);
        }
        int i12 = this.mTextColor;
        if (i12 != 0) {
            textView.setTextColor(i12);
        }
        int i13 = this.mEllipse;
        if (i13 != 1) {
            if (i13 != 2) {
                if (i13 != 3) {
                    if (i13 == 4) {
                        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    }
                } else {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
            } else {
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            }
        } else {
            textView.setEllipsize(TextUtils.TruncateAt.START);
        }
        int i14 = this.mTextStyle;
        if (i14 != 1) {
            if (i14 != 2) {
                if (i14 == 3) {
                    textView.setTypeface(Typeface.defaultFromStyle(3));
                }
            } else {
                textView.setTypeface(Typeface.defaultFromStyle(2));
            }
        } else {
            textView.setTypeface(Typeface.defaultFromStyle(1));
        }
        int i15 = this.mTextAppearance;
        if (i15 != 0) {
            textView.setTextAppearance(this.mContext, i15);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public void removeBlur() {
        getCurrentView().setRenderEffect(null);
    }

    public void setAnimDirection(int i10) {
        if (this.mAnimDirection != i10) {
            this.mAnimDirection = i10;
            selectAnimation();
        }
    }

    public void setAnimEffect(int i10) {
        if (this.mAnimEffect != i10) {
            this.mAnimEffect = i10;
            selectAnimation();
        }
    }

    public void setBlurRadius(int i10) {
        if (this.mAnimEffect != 1) {
            Log.d(TAG, "You can not set blur radius for the anim effect not contain blur anim");
            return;
        }
        float f10 = i10;
        if (f10 != this.mMaxBlur) {
            this.mMaxBlur = f10;
            createBlurAnim(true);
        }
    }

    public void setScale(float f10) {
        if (this.mAnimEffect != 1) {
            Log.d(TAG, "You can not set scale for the anim effect not contain blur anim");
        } else if (f10 != this.mMaxScale) {
            this.mMaxScale = f10;
            setAlphaScaleBlurEffectOutAnim();
            setAlphaScaleBlurEffectInAnim();
        }
    }

    public COUITextSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextSize = -1;
        this.mTextColor = 0;
        this.mContext = context;
        int[] iArr = o.f5260Z5;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.mText = obtainStyledAttributes.getText(o.f5316g6);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(o.f5332i6, this.mTextSize);
        this.mTextColor = obtainStyledAttributes.getColor(o.f5324h6, this.mTextColor);
        this.mEllipse = obtainStyledAttributes.getInt(o.f5292d6, 0);
        this.mTextStyle = obtainStyledAttributes.getInt(o.f5340j6, 0);
        this.mTextAppearance = obtainStyledAttributes.getResourceId(o.f5308f6, 0);
        if (getInAnimation() == null && getOutAnimation() == null) {
            this.mAnimEffect = obtainStyledAttributes.getInt(o.f5276b6, 3);
            this.mAnimDirection = obtainStyledAttributes.getInt(o.f5268a6, 0);
            this.mMaxBlur = obtainStyledAttributes.getFloat(o.f5284c6, 10.0f);
            this.mMaxScale = obtainStyledAttributes.getFloat(o.f5300e6, DEFAULT_SCALE);
            selectAnimation();
        }
        obtainStyledAttributes.recycle();
        setFactory(this);
    }
}
