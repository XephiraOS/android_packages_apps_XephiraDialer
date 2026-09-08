package com.google.android.material.appbar;

import H.d;
import X8.f;
import X8.o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.K;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.searchview.COUISearchViewAnimate;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.StaticLayoutBuilderCompat;
import com.google.android.material.internal.CollapsingTextHelper;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class COUICollapsingToolbarLayout extends CollapsingToolbarLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final long DEFAULT_FADE_IN_ALPHA_ANIMATION_DURATION = 200;
    private static final float DEFAULT_FADE_MODE_EXPANSION_FRACTION = 0.81f;
    private static final float DEFAULT_FADE_MODE_EXPANSION_FRACTION_ERROR = 0.02f;
    private static final float DEFAULT_FADE_MODE_START_FRACTION = 1.0f;
    private static final long DEFAULT_FADE_OUT_ALPHA_ANIMATION_DURATION = 150;
    private static final int DEFAULT_NORMAL_TEXT_COLOR_ALPHA = 255;
    private static final float DEFAULT_SCALE_MODE_START_FRACTION = 0.5f;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final String ELLIPSIS_TWO_DOTS = "‥";
    private static final float FADE_MODE_EXPANSION_FRACTION_ERROR_WITH_SEARCH = 0.0075f;
    private static final float FADE_MODE_EXPANSION_FRACTION_WITH_SEARCH = 0.35f;
    private static final boolean IS_DEBUG = false;
    private static final String TAG = "COUICollapsingToolbar";
    private static final PathInterpolator TITLE_PATH_INTERPOLATOR = new COUIEaseInterpolator();
    private ObjectAnimator mAlphaAnimator;
    private Rect mCollapsedBounds;
    private int mCollapsedSubtitleMarginTopIfNotHidden;
    private ColorStateList mCollapsedTextColor;
    private ColorDrawable mContentScrimDrawable;
    private RectF mCurrentBounds;
    private Rect mExpandedBounds;
    private float mFadeModeExpansionFraction;
    private float mFadeModeExpansionFractionError;
    private View mIconView;
    private ViewTreeObserver.OnGlobalLayoutListener mIconViewFirstLayoutListener;
    private boolean mIsAllowFadeInAnimation;
    private boolean mIsAllowFadeOutAnimation;
    private boolean mIsInsideSideNavigationBar;
    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private StaticLayout mTextLayout;
    private TextPaint mTextPaint;
    private int mTitleTranslateOffset;
    private COUIToolbar mToolbar;
    private int mToolbarNormalPaddingEnd;
    private int mToolbarNormalPaddingStart;

    /* loaded from: classes3.dex */
    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i10) {
            if (COUICollapsingToolbarLayout.this.mToolbar != null && COUICollapsingToolbarLayout.this.mToolbar.getIsTitleCenterStyle()) {
                COUICollapsingToolbarLayout.this.fixCollapsingTitleAlpha();
                COUICollapsingToolbarLayout.this.collapsingTextHelper.recalculate();
            }
        }
    }

    public COUICollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    private void addIconView() {
        View view = this.mIconView;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CollapsingToolbarLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) layoutParams)).gravity = 8388691;
        }
        addView(this.mIconView, getChildCount());
        this.mIconView.getViewTreeObserver().addOnGlobalLayoutListener(this.mIconViewFirstLayoutListener);
    }

    private int calculateCollapsedBound() {
        View findSubtitleContentView;
        int measuredHeight;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (!(viewGroup instanceof COUICollapsableAppBarLayout)) {
            return 0;
        }
        COUICollapsableAppBarLayout cOUICollapsableAppBarLayout = (COUICollapsableAppBarLayout) viewGroup;
        if (cOUICollapsableAppBarLayout.isSubtitleHideEnable() || (findSubtitleContentView = cOUICollapsableAppBarLayout.findSubtitleContentView()) == null || findSubtitleContentView.getVisibility() == 8 || (measuredHeight = findSubtitleContentView.getMeasuredHeight()) == 0) {
            return 0;
        }
        return ((this.mCollapsedBounds.height() - ((int) this.collapsingTextHelper.getCollapsedTextHeight())) / 2) - (measuredHeight + this.mCollapsedSubtitleMarginTopIfNotHidden);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        H.c cVar;
        if (K.v(this) == 1) {
            cVar = d.f1197d;
        } else {
            cVar = d.f1196c;
        }
        return cVar.a(charSequence, 0, charSequence.length());
    }

    private StaticLayout createStaticLayout() {
        float floatValue = ((Float) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "scale")).floatValue();
        if (floatValue == 1.0f || floatValue == 0.0f) {
            return null;
        }
        CharSequence text = this.collapsingTextHelper.getText();
        try {
            return StaticLayoutBuilderCompat.obtain(text, this.mTextPaint, (int) (this.mCurrentBounds.width() / floatValue)).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(calculateIsRtl(text)).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(1).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e10) {
            Log.e(TAG, e10.getCause().getMessage(), e10);
            return null;
        }
    }

    private void ensureToolbar() {
        if (this.mToolbar != null) {
            return;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof COUIToolbar) {
                this.mToolbar = (COUIToolbar) childAt;
                return;
            }
        }
    }

    private Object getReflectField(Class cls, Object obj, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e10) {
            Log.e(TAG, "getReflectField error: " + e10.getMessage());
            return null;
        }
    }

    private float getScale() {
        try {
            return ((Float) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "scale")).floatValue();
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    private Rect getTextHelperCollapsedBounds() {
        try {
            return (Rect) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "collapsedBounds");
        } catch (Exception unused) {
            return null;
        }
    }

    private RectF getTextHelperCurrentBounds() {
        try {
            return (RectF) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "currentBounds");
        } catch (Exception unused) {
            return null;
        }
    }

    private Rect getTextHelperExpandedBounds() {
        try {
            return (Rect) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "expandedBounds");
        } catch (Exception unused) {
            return null;
        }
    }

    private StaticLayout getTextLayout() {
        try {
            return (StaticLayout) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "textLayout");
        } catch (Exception unused) {
            return null;
        }
    }

    private TextPaint getTextPaint() {
        try {
            return (TextPaint) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "textPaint");
        } catch (Exception unused) {
            return null;
        }
    }

    private void init(AttributeSet attributeSet) {
        resetTextHelperInterpolator();
        TextPaint textPaint = getTextPaint();
        this.mTextPaint = textPaint;
        if (textPaint != null) {
            textPaint.setElegantTextHeight(getContext().getResources().getBoolean(X8.d.f4421b));
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f5446x0);
            int resourceId = obtainStyledAttributes.getResourceId(o.f5454y0, 0);
            obtainStyledAttributes.recycle();
            setIconView(resourceId);
        }
    }

    private void setReflectField(Class cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception e10) {
            Log.e(TAG, "setReflectField error: " + e10.getMessage());
        }
    }

    private void showCollapsedTitleAnimation() {
        if (this.mToolbar.getIsTitleCenterStyle() && this.mToolbar.getCOUITitleTextView() != null) {
            getCollapsingTextHelper().setFadeModeStartFraction(1.0f);
            float expansionFraction = getCollapsingTextHelper().getExpansionFraction();
            float f10 = this.mFadeModeExpansionFraction;
            if (expansionFraction <= f10) {
                startFadeAnimation(false, this.mToolbar.getCOUITitleTextView());
            } else if (expansionFraction > f10 + this.mFadeModeExpansionFractionError) {
                startFadeAnimation(true, this.mToolbar.getCOUITitleTextView());
            }
        }
    }

    private void startFadeAnimation(final boolean z10, TextView textView) {
        float f10;
        long j10;
        if (z10) {
            this.mIsAllowFadeOutAnimation = true;
            if (!this.mIsAllowFadeInAnimation) {
                return;
            }
        } else {
            this.mIsAllowFadeInAnimation = true;
            if (!this.mIsAllowFadeOutAnimation) {
                return;
            }
        }
        if (textView == null) {
            return;
        }
        ObjectAnimator objectAnimator = this.mAlphaAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mAlphaAnimator.cancel();
        }
        float f11 = 1.0f;
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        if (!z10) {
            f11 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "alpha", f10, f11);
        this.mAlphaAnimator = ofFloat;
        if (z10) {
            j10 = 200;
        } else {
            j10 = 150;
        }
        ofFloat.setDuration(j10);
        this.mAlphaAnimator.setInterpolator(TITLE_PATH_INTERPOLATOR);
        this.mAlphaAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.appbar.COUICollapsingToolbarLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                COUICollapsingToolbarLayout.this.mAlphaAnimator = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z10) {
                    COUICollapsingToolbarLayout.this.mIsAllowFadeInAnimation = false;
                } else {
                    COUICollapsingToolbarLayout.this.mIsAllowFadeOutAnimation = false;
                }
            }
        });
        this.mAlphaAnimator.start();
    }

    private void translateTitleIfNeed() {
        if (this.mCollapsedBounds == null) {
            return;
        }
        int calculateCollapsedBound = calculateCollapsedBound();
        this.mTitleTranslateOffset = calculateCollapsedBound;
        if (calculateCollapsedBound != 0) {
            this.mCollapsedBounds.offset(0, calculateCollapsedBound);
            this.collapsingTextHelper.recalculate();
        }
    }

    private void updateFadeModeExpansionFraction() {
        float f10;
        float f11;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                AppBarLayout appBarLayout = (AppBarLayout) parent;
                if (i10 >= appBarLayout.getChildCount()) {
                    break;
                }
                View childAt = appBarLayout.getChildAt(i10);
                if ((childAt instanceof COUISearchBar) || (childAt instanceof COUISearchViewAnimate)) {
                    break;
                } else {
                    i10++;
                }
            }
            z10 = true;
            if (z10) {
                f10 = FADE_MODE_EXPANSION_FRACTION_WITH_SEARCH;
            } else {
                f10 = DEFAULT_FADE_MODE_EXPANSION_FRACTION;
            }
            this.mFadeModeExpansionFraction = f10;
            if (z10) {
                f11 = FADE_MODE_EXPANSION_FRACTION_ERROR_WITH_SEARCH;
            } else {
                f11 = DEFAULT_FADE_MODE_EXPANSION_FRACTION_ERROR;
            }
            this.mFadeModeExpansionFractionError = f11;
        }
    }

    private void updateTextLayoutIfNeed() {
        StaticLayout staticLayout;
        StaticLayout createStaticLayout;
        if (!isExpanded() && !isCollapsed() && getMaxLines() <= 1 && (staticLayout = this.mTextLayout) != null) {
            CharSequence text = staticLayout.getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            if ((!text.toString().contains(ELLIPSIS_TWO_DOTS) && !text.toString().contains(ELLIPSIS_NORMAL)) || (createStaticLayout = createStaticLayout()) == null) {
                return;
            }
            setReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "textLayout", createStaticLayout);
            this.mTextLayout = createStaticLayout;
        }
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.View
    public void draw(Canvas canvas) {
        COUIToolbar cOUIToolbar = this.mToolbar;
        if (cOUIToolbar != null && cOUIToolbar.getIsTitleCenterStyle()) {
            setScrimAlpha(255);
            showCollapsedTitleAnimation();
        }
        super.draw(canvas);
    }

    public void fixCollapsingTitleAlpha() {
        this.collapsingTextHelper.setFadeModeStartFraction(1.0f);
        this.mTextPaint.setAlpha(255);
    }

    public CollapsingTextHelper getCollapsingTextHelper() {
        return this.collapsingTextHelper;
    }

    public StaticLayout getCollapsingTextLayout() {
        return this.mTextLayout;
    }

    public TextPaint getCollapsingTextPaint() {
        return this.mTextPaint;
    }

    public View getIconView() {
        return this.mIconView;
    }

    public boolean isCollapsed() {
        if (this.collapsingTextHelper.getExpansionFraction() == 1.0f) {
            return true;
        }
        return false;
    }

    public boolean isExpanded() {
        if (this.collapsingTextHelper.getExpansionFraction() == 0.0f) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.mOnOffsetChangedListener == null) {
                this.mOnOffsetChangedListener = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.mOnOffsetChangedListener);
            K.f0(this);
        }
        bringChildToFront(this.mIconView);
        setTouchscreenBlocksFocus(false);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        updateFadeModeExpansionFraction();
        updateTextLayoutIfNeed();
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.mTextLayout = getTextLayout();
        if (this.mCurrentBounds.isEmpty()) {
            this.mCurrentBounds = getTextHelperCurrentBounds();
        }
        if (this.mCollapsedBounds.isEmpty()) {
            this.mCollapsedBounds = getTextHelperCollapsedBounds();
        }
        if (this.mExpandedBounds.isEmpty()) {
            this.mExpandedBounds = getTextHelperExpandedBounds();
        }
        translateTitleIfNeed();
        COUIToolbar cOUIToolbar = this.mToolbar;
        if (cOUIToolbar != null && cOUIToolbar.getIsTitleCenterStyle()) {
            this.collapsingTextHelper.setCollapsedBounds(this.mExpandedBounds);
            this.collapsingTextHelper.recalculate();
        }
        View view = this.mIconView;
        if (view != null && view.getVisibility() == 0) {
            if (calculateIsRtl(this.mTextLayout.getText())) {
                this.mCollapsedBounds.left += this.mIconView.getMeasuredWidth();
                this.mExpandedBounds.left += this.mIconView.getMeasuredWidth();
            } else {
                this.mCollapsedBounds.right -= this.mIconView.getMeasuredWidth();
                this.mExpandedBounds.right -= this.mIconView.getMeasuredWidth();
            }
            this.collapsingTextHelper.recalculate();
        }
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        super.onMeasure(i10, i11);
        if (this.mIsInsideSideNavigationBar) {
            setExpandedTitleMarginStart(this.mToolbarNormalPaddingStart);
            setExpandedTitleMarginEnd(this.mToolbarNormalPaddingEnd);
            return;
        }
        if (COUIResponsiveUtils.isSmallScreen(getContext(), getMeasuredWidth())) {
            i12 = getContext().getResources().getDimensionPixelOffset(f.f4587S);
            i13 = getContext().getResources().getDimensionPixelOffset(f.f4559O);
        } else if (COUIResponsiveUtils.isMediumScreen(getContext(), getMeasuredWidth())) {
            i12 = getContext().getResources().getDimensionPixelOffset(f.f4601U);
            i13 = getContext().getResources().getDimensionPixelOffset(f.f4573Q);
        } else if (COUIResponsiveUtils.isLargeScreen(getContext(), getMeasuredWidth())) {
            i12 = getContext().getResources().getDimensionPixelOffset(f.f4594T);
            i13 = getContext().getResources().getDimensionPixelOffset(f.f4566P);
        } else {
            i12 = 0;
            i13 = 0;
        }
        setExpandedTitleMarginStart(i12);
        setExpandedTitleMarginEnd(i13);
    }

    public void resetTextHelperInterpolator() {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        PathInterpolator pathInterpolator = TITLE_PATH_INTERPOLATOR;
        collapsingTextHelper.setTextSizeInterpolator(pathInterpolator);
        this.collapsingTextHelper.setPositionInterpolator(pathInterpolator);
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout
    public void setCollapsedTitleTextColor(int i10) {
        super.setCollapsedTitleTextColor(i10);
        this.mCollapsedTextColor = ColorStateList.valueOf(i10);
    }

    @Deprecated
    public void setEditStyle(boolean z10) {
        setIsTitleCenterStyle(z10);
    }

    public void setIconView(int i10) {
        setIconView(i10 == 0 ? null : LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, false));
    }

    public void setIsInsideSideNavigationBar(boolean z10) {
        this.mIsInsideSideNavigationBar = z10;
        requestLayout();
    }

    public void setIsTitleCenterStyle(boolean z10) {
        float f10;
        setTitleCollapseMode(z10 ? 1 : 0);
        setContentScrim(this.mContentScrimDrawable);
        ensureToolbar();
        COUIToolbar cOUIToolbar = this.mToolbar;
        if (cOUIToolbar != null) {
            cOUIToolbar.setIsTitleCenterStyle(z10);
            TextView cOUITitleTextView = this.mToolbar.getCOUITitleTextView();
            if (isExpanded()) {
                f10 = 0.0f;
            } else {
                f10 = 1.0f;
            }
            cOUITitleTextView.setAlpha(f10);
            if (z10) {
                getCollapsingTextHelper().setCollapsedTextColor(ColorStateList.valueOf(0));
            } else if (this.mCollapsedTextColor != null) {
                getCollapsingTextHelper().setCollapsedTextColor(this.mCollapsedTextColor);
            } else {
                getCollapsingTextHelper().setFadeModeStartFraction(0.5f);
            }
        }
        this.mIsAllowFadeInAnimation = isExpanded();
        this.mIsAllowFadeOutAnimation = !isExpanded();
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        post(new Runnable() { // from class: com.google.android.material.appbar.COUICollapsingToolbarLayout.3
            @Override // java.lang.Runnable
            public void run() {
                COUICollapsingToolbarLayout.this.updateIconViewLocationIfNeed();
            }
        });
    }

    public void updateIconViewLocationIfNeed() {
        View view;
        boolean z10;
        float f10;
        float f11;
        StaticLayout staticLayout = this.mTextLayout;
        if (staticLayout == null) {
            return;
        }
        CharSequence text = staticLayout.getText();
        if (!TextUtils.isEmpty(text) && (view = this.mIconView) != null && view.getVisibility() == 0) {
            if (!text.toString().contains(ELLIPSIS_TWO_DOTS) && !text.toString().contains(ELLIPSIS_NORMAL)) {
                z10 = false;
            } else {
                z10 = true;
            }
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            float scale = getScale();
            boolean calculateIsRtl = calculateIsRtl(text);
            int i10 = (int) ((fontMetricsInt.descent - fontMetricsInt.ascent) * scale);
            int measuredHeight = (int) (((getMeasuredHeight() - this.mCurrentBounds.top) - i10) + (this.mTitleTranslateOffset * this.collapsingTextHelper.getExpansionFraction()));
            int measuredWidth = (getMeasuredWidth() - this.mIconView.getMeasuredWidth()) - getExpandedTitleMarginEnd();
            if (z10) {
                if (!isExpanded()) {
                    if (calculateIsRtl) {
                        f11 = this.mCurrentBounds.width() + getExpandedTitleMarginStart();
                    } else {
                        f11 = this.mCurrentBounds.right;
                    }
                    measuredWidth = (int) f11;
                }
            } else {
                int lineWidth = (int) (this.mTextLayout.getLineWidth(0) * scale);
                if (calculateIsRtl) {
                    f10 = getMeasuredWidth() - this.mCurrentBounds.right;
                } else {
                    f10 = this.mCurrentBounds.left;
                }
                measuredWidth = Math.min((int) (f10 + lineWidth), measuredWidth);
            }
            ViewGroup.LayoutParams layoutParams = this.mIconView.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                layoutParams.height = i10;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.bottomMargin = measuredHeight;
                marginLayoutParams.setMarginStart(measuredWidth);
                this.mIconView.setLayoutParams(layoutParams);
            }
        }
    }

    public COUICollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUICollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mCollapsedSubtitleMarginTopIfNotHidden = 0;
        this.mToolbarNormalPaddingStart = 0;
        this.mToolbarNormalPaddingEnd = 0;
        this.mFadeModeExpansionFraction = DEFAULT_FADE_MODE_EXPANSION_FRACTION;
        this.mFadeModeExpansionFractionError = DEFAULT_FADE_MODE_EXPANSION_FRACTION_ERROR;
        this.mCollapsedBounds = new Rect();
        this.mExpandedBounds = new Rect();
        this.mCurrentBounds = new RectF();
        this.mIsAllowFadeInAnimation = false;
        this.mIsAllowFadeOutAnimation = false;
        this.mIsInsideSideNavigationBar = false;
        this.mContentScrimDrawable = new ColorDrawable(0);
        this.mIconViewFirstLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.appbar.COUICollapsingToolbarLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (COUICollapsingToolbarLayout.this.mIconView == null) {
                    return;
                }
                COUICollapsingToolbarLayout.this.mIconView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                COUICollapsingToolbarLayout.this.updateIconViewLocationIfNeed();
            }
        };
        init(attributeSet);
        this.mCollapsedSubtitleMarginTopIfNotHidden = context.getResources().getDimensionPixelOffset(f.f4545M);
        this.mToolbarNormalPaddingStart = getContext().getResources().getDimensionPixelOffset(f.f4580R);
        this.mToolbarNormalPaddingEnd = getContext().getResources().getDimensionPixelOffset(f.f4552N);
        this.mCollapsedTextColor = getCollapsingTextHelper().getCollapsedTextColor();
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout
    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        super.setCollapsedTitleTextColor(colorStateList);
        this.mCollapsedTextColor = colorStateList;
    }

    public void setIconView(View view) {
        View view2 = this.mIconView;
        if (view2 == view) {
            return;
        }
        if (view == null) {
            removeView(view2);
            this.mIconView = null;
        } else {
            this.mIconView = view;
            addIconView();
        }
    }
}
