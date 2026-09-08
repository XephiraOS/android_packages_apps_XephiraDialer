package com.coui.appcompat.progressbar;

import X8.n;
import X8.o;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.log.COUILog;
import com.oplus.anim.EffectiveAnimationView;

/* loaded from: classes.dex */
public class COUICompProgressIndicator extends LinearLayout {
    public static final int LARGE_ANIMATION = 0;
    public static final int LARGE_ANIMATION_WITH_TEXT_VERTICAL = 3;
    public static final int SMALL_ANIMATION = 1;
    public static final int SMALL_ANIMATION_WITH_TEXT_HORIZONTAL = 2;
    public static final int SMALL_ANIMATION_WITH_TEXT_VERTICAL = 4;
    private static final String TAG = "COUICompProgressIndicator";
    private static final int TEXTSIZE_DP_VALUE = 12;
    private boolean mAutoPlay;
    private Context mContext;
    private int mCouiLargeLoadingTextviewTopMargin;
    private int mCouiLoadingTextviewBottomMargin;
    private int mCouiLoadingTextviewLeftMargin;
    private int mCouiLoadingType;
    private String mCouiLottieLoadingJsonName;
    private int mCouiLottieLoadingRawRes;
    private int mCouiLottieLoadingViewHeight;
    private int mCouiLottieLoadingViewHeightMax;
    private int mCouiLottieLoadingViewWidth;
    private int mCouiLottieLoadingViewWidthMax;
    private int mCouiSmallLoadingTextviewTopMargin;
    private int mCouiSmallLottieLoadingViewHeight;
    private int mCouiSmallLottieLoadingViewWidth;
    private int mDefaultType;
    private EffectiveAnimationView mEffectViewAnimationView;
    private String mLoadingTips;
    private boolean mNeedRePlay;
    private int mRepeatCount;
    private boolean mTextFix;
    private TextView mTipsTextView;

    public COUICompProgressIndicator(Context context) {
        this(context, null);
    }

    private void addEffectiveView(boolean z10) {
        LinearLayout.LayoutParams layoutParams;
        EffectiveAnimationView effectiveAnimationView = new EffectiveAnimationView(this.mContext);
        this.mEffectViewAnimationView = effectiveAnimationView;
        effectiveAnimationView.setRepeatCount(this.mRepeatCount);
        if (z10) {
            layoutParams = new LinearLayout.LayoutParams(this.mCouiLottieLoadingViewWidth, this.mCouiLottieLoadingViewHeight);
        } else {
            layoutParams = new LinearLayout.LayoutParams(this.mCouiSmallLottieLoadingViewWidth, this.mCouiSmallLottieLoadingViewHeight);
        }
        layoutParams.gravity = 17;
        this.mEffectViewAnimationView.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(this.mCouiLottieLoadingJsonName)) {
            this.mEffectViewAnimationView.setAnimation(this.mCouiLottieLoadingJsonName);
        }
        int i10 = this.mCouiLottieLoadingRawRes;
        if (i10 != -1) {
            this.mEffectViewAnimationView.setAnimation(i10);
        }
        addView(this.mEffectViewAnimationView);
        if (this.mAutoPlay) {
            this.mEffectViewAnimationView.playAnimation();
        }
    }

    private void addSubView() {
        int i10 = this.mCouiLoadingType;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 4) {
                            addEffectiveView(false);
                            addTipsTextView(true);
                            return;
                        }
                        return;
                    }
                    addEffectiveView(true);
                    addTipsTextView(true);
                    return;
                }
                setOrientation(0);
                addEffectiveView(false);
                addTipsTextView(false);
                return;
            }
            addEffectiveView(false);
            return;
        }
        addEffectiveView(true);
    }

    private void addTipsTextView(boolean z10) {
        int i10;
        if (z10) {
            i10 = n.f5045q;
        } else {
            i10 = n.f5044p;
        }
        TextView textView = new TextView(new ContextThemeWrapper(this.mContext, i10));
        this.mTipsTextView = textView;
        textView.setText(this.mLoadingTips);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i11 = this.mCouiLoadingType;
        if (i11 != 2) {
            if (i11 != 3) {
                if (i11 == 4) {
                    layoutParams.setMargins(0, this.mCouiSmallLoadingTextviewTopMargin, 0, this.mCouiLoadingTextviewBottomMargin);
                }
            } else {
                layoutParams.setMargins(0, this.mCouiLargeLoadingTextviewTopMargin, 0, this.mCouiLoadingTextviewBottomMargin);
            }
        } else {
            layoutParams.setMarginStart(this.mCouiLoadingTextviewLeftMargin);
        }
        if (this.mTextFix) {
            this.mTipsTextView.setTextSize(1, 12.0f);
        }
        addView(this.mTipsTextView, layoutParams);
    }

    public EffectiveAnimationView getAnimationView() {
        return this.mEffectViewAnimationView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mEffectViewAnimationView == null) {
            addSubView();
        }
        EffectiveAnimationView effectiveAnimationView = this.mEffectViewAnimationView;
        if (effectiveAnimationView != null && this.mNeedRePlay) {
            effectiveAnimationView.resumeAnimation();
            this.mNeedRePlay = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EffectiveAnimationView effectiveAnimationView = this.mEffectViewAnimationView;
        if (effectiveAnimationView != null && effectiveAnimationView.isAnimating()) {
            this.mNeedRePlay = true;
            this.mEffectViewAnimationView.pauseAnimation();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        EffectiveAnimationView effectiveAnimationView = this.mEffectViewAnimationView;
        if (effectiveAnimationView != null) {
            if (i10 != 0) {
                if (effectiveAnimationView.isAnimating()) {
                    this.mNeedRePlay = true;
                    this.mEffectViewAnimationView.pauseAnimation();
                    return;
                }
                return;
            }
            if (this.mNeedRePlay) {
                effectiveAnimationView.resumeAnimation();
                this.mNeedRePlay = false;
            }
        }
    }

    public void setLoadingTips(String str) {
        this.mLoadingTips = str;
        TextView textView = this.mTipsTextView;
        if (textView != null) {
            textView.setText(str);
        } else {
            Log.e(TAG, "This method only takes effect when mCouiLoadingType is SMALL_ANIMATION_WITH_TEXT_HORIZONTAL 、LARGE_ANIMATION_WITH_TEXT_VERTICAL、SMALL_ANIMATION_WITH_TEXT_VERTICAL");
        }
    }

    public COUICompProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUICompProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, 0, 0);
    }

    public COUICompProgressIndicator(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mDefaultType = 0;
        this.mTextFix = false;
        this.mCouiLottieLoadingRawRes = -1;
        this.mRepeatCount = -1;
        this.mAutoPlay = true;
        this.mNeedRePlay = false;
        this.mContext = context;
        this.mCouiLottieLoadingViewWidthMax = getResources().getDimensionPixelSize(X8.f.f4825x2);
        this.mCouiLottieLoadingViewHeightMax = getResources().getDimensionPixelSize(X8.f.f4818w2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f5462z0, i10, 0);
        this.mCouiLoadingType = obtainStyledAttributes.getInt(o.f5064B0, this.mDefaultType);
        this.mLoadingTips = obtainStyledAttributes.getString(o.f5136K0);
        this.mCouiLottieLoadingJsonName = obtainStyledAttributes.getString(o.f5072C0);
        this.mCouiLottieLoadingRawRes = obtainStyledAttributes.getResourceId(o.f5080D0, -1);
        this.mRepeatCount = obtainStyledAttributes.getInt(o.f5104G0, this.mRepeatCount);
        this.mAutoPlay = obtainStyledAttributes.getBoolean(o.f5056A0, this.mAutoPlay);
        this.mCouiLottieLoadingViewWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5096F0, getResources().getDimensionPixelOffset(X8.f.f4811v2));
        this.mCouiLottieLoadingViewHeight = obtainStyledAttributes.getDimensionPixelSize(o.f5088E0, getResources().getDimensionPixelOffset(X8.f.f4804u2));
        this.mCouiSmallLottieLoadingViewWidth = obtainStyledAttributes.getDimensionPixelSize(o.f5120I0, getResources().getDimensionPixelOffset(X8.f.f4839z2));
        this.mCouiSmallLottieLoadingViewHeight = obtainStyledAttributes.getDimensionPixelSize(o.f5112H0, getResources().getDimensionPixelOffset(X8.f.f4832y2));
        int i12 = this.mCouiLottieLoadingViewWidth;
        int i13 = this.mCouiLottieLoadingViewWidthMax;
        if (i12 > i13) {
            this.mCouiLottieLoadingViewWidth = i13;
            COUILog.v(TAG, "couiLottieLoadingViewWidth Cannot be larger than 40 dp");
        }
        int i14 = this.mCouiLottieLoadingViewHeight;
        int i15 = this.mCouiLottieLoadingViewHeightMax;
        if (i14 > i15) {
            this.mCouiLottieLoadingViewHeight = i15;
            COUILog.v(TAG, "couiLottieLoadingViewHeight Cannot be larger than 40 dp");
        }
        int i16 = this.mCouiSmallLottieLoadingViewWidth;
        int i17 = this.mCouiLottieLoadingViewWidthMax;
        if (i16 > i17) {
            this.mCouiSmallLottieLoadingViewWidth = i17;
            COUILog.v(TAG, "couiSmallLottieLoadingViewWidth Cannot be larger than 40 dp");
        }
        int i18 = this.mCouiSmallLottieLoadingViewHeight;
        int i19 = this.mCouiLottieLoadingViewHeightMax;
        if (i18 > i19) {
            this.mCouiSmallLottieLoadingViewHeight = i19;
            COUILog.v(TAG, "couiSmallLottieLoadingViewHeight Cannot be larger than 40 dp");
        }
        if (TextUtils.isEmpty(this.mCouiLottieLoadingJsonName)) {
            this.mCouiLottieLoadingJsonName = COUIContextUtil.getAttrString(this.mContext, X8.c.f4366Y);
        }
        this.mTextFix = obtainStyledAttributes.getBoolean(o.f5128J0, this.mTextFix);
        obtainStyledAttributes.recycle();
        this.mCouiLoadingTextviewLeftMargin = context.getResources().getDimensionPixelSize(X8.f.f4471B2);
        this.mCouiLargeLoadingTextviewTopMargin = context.getResources().getDimensionPixelSize(X8.f.f4478C2);
        this.mCouiSmallLoadingTextviewTopMargin = context.getResources().getDimensionPixelSize(X8.f.f4485D2);
        this.mCouiLoadingTextviewBottomMargin = context.getResources().getDimensionPixelSize(X8.f.f4464A2);
        setGravity(17);
        setOrientation(1);
    }

    public void setLoadingTips(int i10) {
        setLoadingTips(this.mContext.getString(i10));
    }
}
