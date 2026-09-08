package com.coui.appcompat.bottomnavigation;

import X8.c;
import X8.f;
import Y8.a;
import Y8.d;
import Y8.h;
import Y8.i;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.b;
import androidx.core.view.K;
import androidx.core.view.X;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;
import com.coui.appcompat.animation.COUIOutEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.poplist.PopupMenuConfigRule;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.e;

/* loaded from: classes.dex */
public class COUINavigationView extends BottomNavigationView implements PopupMenuConfigRule {
    private static final long DEFAULT_ENTER_TRANSLATE_ANIMATION_DURATION = 350;
    private static final long DEFAULT_HIDE_TRANSLATE_ANIMATION_DURATION = 200;
    public static final int DEFAULT_ITEM_LAYOUT_TYPE = 0;
    private static final long DEFAULT_SHOW_TRANSLATE_ANIMATION_DURATION = 250;
    private static final float END_ALPHA = 1.0f;
    public static final int ENTER_ANIMATION_TYPE = 1;
    public static final int EXIT_ANIMATION_TYPE = 2;
    public static final int NAVIGATION_TYPE_ENLARGE = 2;
    public static final int NAVIGATION_TYPE_TAB = 1;
    public static final int NAVIGATION_TYPE_TOOL = 0;
    private static final float START_ALPHA = 0.0f;
    public static final int VERTICAL_ITEM_LAYOUT_TYPE = 1;
    private COUINavigationMenuView mCOUINavigationMenuView;
    private OnConfigChangedListener mConfigChangedListener;
    private Rect mDisplayFrame;
    private Rect mDisplayFrameOutsets;
    private View mDividerView;
    private OnNavigationEnterExitListener mEndListener;
    private FrameLayout mEnlargeBgView;
    private int mEnlargeNavigationViewBgId;
    private OnEnlargeSelectListener mEnlargeSelectListener;
    private Animator mEnterAnimation;
    private ValueAnimator mEnterTranslateAnimation;
    private Animator mExitAnimation;
    private ValueAnimator mHideTranslateAnimation;
    private boolean mIsCheckEnlarge;
    private boolean mIsEnlarge;
    private int mLayoutType;
    private int mNavigationType;
    private int mNextMenuResId;
    private boolean mPopupRuleEnable;
    private OnNavigationShowHideListener mShowHideListener;
    private ValueAnimator mShowTranslateAnimation;
    private int mTextSizeResId;
    private Rect mWindowFrame;

    /* loaded from: classes.dex */
    public interface OnConfigChangedListener {
        void onConfigChanged(Configuration configuration);
    }

    /* loaded from: classes.dex */
    public interface OnEnlargeSelectListener {
        void onEnlargeSelect(boolean z10, MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface OnNavigationEnterExitListener {
        void onAnimationEnterEnd();

        void onAnimationExitEnd();
    }

    /* loaded from: classes.dex */
    public interface OnNavigationShowHideListener {
        void onAnimationHideEnd();

        void onAnimationHideStart();

        void onAnimationHideUpdate(int i10);

        void onAnimationShowEnd();

        void onAnimationShowStart();

        void onAnimationShowUpdate(int i10);
    }

    public COUINavigationView(Context context) {
        this(context, null);
    }

    private void addCompatibilityTopDivider(Context context) {
        View view = new View(context);
        this.mDividerView = view;
        COUIDarkModeUtil.setForceDarkAllow(view, false);
        this.mDividerView.setBackgroundColor(COUIContextUtil.getAttrColor(context, c.f4400q));
        this.mDividerView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.f5670z)));
        if (this.mIsEnlarge) {
            addView(this.mDividerView, 0);
        } else {
            addView(this.mDividerView);
            this.mCOUINavigationMenuView.setTop(0);
        }
    }

    private void addEnlargeBackgroundView() {
        this.mEnlargeBgView = new FrameLayout(getContext());
        this.mEnlargeBgView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.mEnlargeBgView, 0);
        K.n0(this.mEnlargeBgView, new ColorDrawable(b.c(getContext(), Y8.c.f5607c)));
    }

    private void adjustMenuItemTextSize(Context context) {
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(d.f5653j);
        if (this.mTextSizeResId != 0) {
            dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(this.mTextSizeResId);
        } else if (this.mLayoutType == 1) {
            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(d.f5651i);
        }
        this.mCOUINavigationMenuView.setTextSize(dimensionPixelOffset);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public X onApplyWindowInsets(View view, X x10, ViewUtils.RelativePadding relativePadding) {
                int i10;
                boolean z10 = true;
                if (K.v(view) != 1) {
                    z10 = false;
                }
                int i11 = x10.f(X.k.f()).f207a;
                int i12 = x10.f(X.k.f()).f209c;
                int i13 = relativePadding.start;
                if (z10) {
                    i10 = i12;
                } else {
                    i10 = i11;
                }
                relativePadding.start = i13 + i10;
                int i14 = relativePadding.end;
                if (!z10) {
                    i11 = i12;
                }
                relativePadding.end = i14 + i11;
                relativePadding.applyToView(view);
                return x10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkEnlargeState() {
        if (this.mEnlargeNavigationViewBgId == 0) {
            return;
        }
        if (this.mIsCheckEnlarge) {
            setItemForEnlargeColor();
            this.mEnlargeBgView.setBackgroundResource(this.mEnlargeNavigationViewBgId);
        } else {
            this.mCOUINavigationMenuView.clearColorFilter();
            this.mCOUINavigationMenuView.setItemTextColor(getItemTextColor());
            this.mEnlargeBgView.setBackgroundColor(getResources().getColor(Y8.c.f5607c));
        }
    }

    private void initAnimation() {
        final AnimatorSet animatorSet = new AnimatorSet();
        COUINavigationMenuView cOUINavigationMenuView = this.mCOUINavigationMenuView;
        Property property = View.ALPHA;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cOUINavigationMenuView, (Property<COUINavigationMenuView, Float>) property, 0.0f, 1.0f);
        this.mEnterAnimation = ofFloat;
        ofFloat.setInterpolator(new COUIInEaseInterpolator());
        this.mEnterAnimation.setDuration(100L);
        this.mEnterAnimation.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUINavigationView.this.mEndListener != null) {
                    COUINavigationView.this.mEndListener.onAnimationEnterEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUINavigationView.this.mNextMenuResId != 0) {
                    COUINavigationView cOUINavigationView = COUINavigationView.this;
                    cOUINavigationView.inflateMenu(cOUINavigationView.mNextMenuResId);
                    COUINavigationView.this.mNextMenuResId = 0;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mCOUINavigationMenuView, (Property<COUINavigationMenuView, Float>) property, 1.0f, 0.0f);
        this.mExitAnimation = ofFloat2;
        ofFloat2.setInterpolator(new COUILinearInterpolator());
        this.mExitAnimation.setDuration(100L);
        this.mExitAnimation.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUINavigationView.this.mNextMenuResId != 0) {
                    COUINavigationView.this.mCOUINavigationMenuView.setTranslationY(-COUINavigationView.this.getHeight());
                    animatorSet.start();
                }
                if (COUINavigationView.this.mEndListener != null) {
                    COUINavigationView.this.mEndListener.onAnimationExitEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mEnterTranslateAnimation = ofFloat3;
        ofFloat3.setInterpolator(new COUIInEaseInterpolator());
        this.mEnterTranslateAnimation.setDuration(DEFAULT_ENTER_TRANSLATE_ANIMATION_DURATION);
        this.mEnterTranslateAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUINavigationView.this.mCOUINavigationMenuView.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * COUINavigationView.this.getMeasuredHeight());
            }
        });
        animatorSet.playTogether(this.mEnterAnimation, this.mEnterTranslateAnimation);
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mHideTranslateAnimation = ofFloat4;
        ofFloat4.setInterpolator(new COUIOutEaseInterpolator());
        this.mHideTranslateAnimation.setDuration(200L);
        this.mHideTranslateAnimation.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUINavigationView.this.mShowHideListener != null) {
                    COUINavigationView.this.mShowHideListener.onAnimationHideEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUINavigationView.this.mShowHideListener != null) {
                    COUINavigationView.this.mShowHideListener.onAnimationHideStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mHideTranslateAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) COUINavigationView.this.getLayoutParams();
                marginLayoutParams.bottomMargin = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * COUINavigationView.this.getMeasuredHeight() * (-1.0f));
                COUINavigationView.this.setLayoutParams(marginLayoutParams);
                if (COUINavigationView.this.mShowHideListener != null) {
                    COUINavigationView.this.mShowHideListener.onAnimationHideUpdate(marginLayoutParams.bottomMargin);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mShowTranslateAnimation = ofFloat5;
        ofFloat5.setInterpolator(new COUIInEaseInterpolator());
        this.mShowTranslateAnimation.setDuration(DEFAULT_SHOW_TRANSLATE_ANIMATION_DURATION);
        this.mShowTranslateAnimation.addListener(new Animator.AnimatorListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUINavigationView.this.mShowHideListener != null) {
                    COUINavigationView.this.mShowHideListener.onAnimationShowEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUINavigationView.this.mShowHideListener != null) {
                    COUINavigationView.this.mShowHideListener.onAnimationShowStart();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mShowTranslateAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) COUINavigationView.this.getLayoutParams();
                marginLayoutParams.bottomMargin = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * COUINavigationView.this.getMeasuredHeight() * (-1.0f));
                COUINavigationView.this.setLayoutParams(marginLayoutParams);
                if (COUINavigationView.this.mShowHideListener != null) {
                    COUINavigationView.this.mShowHideListener.onAnimationShowUpdate(marginLayoutParams.bottomMargin);
                }
            }
        });
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private void setItemForEnlargeColor() {
        this.mCOUINavigationMenuView.setItemForEnlargeColor();
    }

    public void adjustNavigationItem() {
        if (COUIResponsiveUtils.isSmallScreen(getContext(), getMeasuredWidth())) {
            setItemLayoutType(1);
            this.mCOUINavigationMenuView.setTextSize(getContext().getResources().getDimensionPixelOffset(d.f5653j));
        } else {
            setItemLayoutType(0);
            this.mCOUINavigationMenuView.setTextSize(getContext().getResources().getDimensionPixelOffset(d.f5649h));
        }
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView, com.google.android.material.navigation.NavigationBarView
    public e createNavigationBarMenuView(Context context) {
        return new COUINavigationMenuView(new ContextThemeWrapper(context, COUIContextUtil.getAttrId(context, a.f5599a, h.f5688a)));
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public int getBarrierDirection() {
        if (this.mWindowFrame == null) {
            this.mWindowFrame = new Rect();
        }
        getRootView().getGlobalVisibleRect(this.mWindowFrame);
        if (this.mWindowFrame.height() <= getContext().getResources().getDimensionPixelSize(f.f4711i3)) {
            return -1;
        }
        return 3;
    }

    public COUINavigationMenuView getCOUINavigationMenuView() {
        return this.mCOUINavigationMenuView;
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public Rect getDisplayFrame() {
        if (this.mDisplayFrame == null) {
            this.mDisplayFrame = new Rect();
        }
        getGlobalVisibleRect(this.mDisplayFrame);
        return this.mDisplayFrame;
    }

    public View getDividerView() {
        return this.mDividerView;
    }

    public FrameLayout getEnlargeBgView() {
        return this.mEnlargeBgView;
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView, com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 10;
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public Rect getOutsets() {
        if (this.mDisplayFrameOutsets == null) {
            this.mDisplayFrameOutsets = new Rect(0, getContext().getResources().getDimensionPixelOffset(d.f5610B), 0, 0);
        }
        return this.mDisplayFrameOutsets;
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public boolean getPopupMenuRuleEnabled() {
        return this.mPopupRuleEnable;
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public int getType() {
        return 2;
    }

    public void hide() {
        hide(true);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void inflateMenu(int i10) {
        if (getMenu().size() > 0) {
            getMenu().clear();
        }
        super.inflateMenu(i10);
        if (this.mNavigationType == 0) {
            this.mCOUINavigationMenuView.setShowPressShadow(true);
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsEnlarge) {
            addEnlargeBackgroundView();
        }
        adjustMenuItemTextSize(getContext());
        this.mCOUINavigationMenuView.setItemLayoutType(this.mLayoutType);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        OnConfigChangedListener onConfigChangedListener = this.mConfigChangedListener;
        if (onConfigChangedListener != null) {
            onConfigChangedListener.onConfigChanged(configuration);
        }
        adjustMenuItemTextSize(getContext().createConfigurationContext(configuration));
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f5650h0);
        if (mode == Integer.MIN_VALUE) {
            i11 = View.MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824);
        } else if (mode == 1073741824) {
            i11 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void refresh() {
        int i10;
        Context context = getContext();
        int[] iArr = i.f5720a;
        int i11 = a.f5600b;
        if (COUIContextUtil.isCOUIDarkTheme(getContext())) {
            i10 = h.f5693f;
        } else {
            i10 = h.f5692e;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i11, i10);
        this.mCOUINavigationMenuView.setIconTintList(obtainStyledAttributes.getColorStateList(i.f5723d));
        this.mCOUINavigationMenuView.setItemTextColor(obtainStyledAttributes.getColorStateList(i.f5725f));
        this.mDividerView.setBackgroundColor(COUIContextUtil.getAttrColor(getContext(), c.f4400q));
        int resourceId = obtainStyledAttributes.getResourceId(i.f5730k, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(i.f5729j, 0);
        int i12 = this.mNavigationType;
        if (i12 == 2) {
            setBackgroundColor(0);
        } else if (i12 == 0) {
            setBackground(b.e(getContext(), resourceId));
        } else {
            setBackground(b.e(getContext(), resourceId2));
        }
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if (childAt instanceof COUINavigationItemView) {
                ((COUINavigationItemView) childAt).refresh();
            }
        }
        obtainStyledAttributes.recycle();
    }

    public void setAnimationType(int i10) {
        if (i10 == 1) {
            this.mEnterAnimation.start();
        } else if (i10 == 2) {
            this.mExitAnimation.start();
        }
    }

    public void setEnlargeIndex(int i10) {
        this.mCOUINavigationMenuView.setEnlarge(this.mIsEnlarge, i10);
    }

    public void setItemLayoutType(int i10) {
        this.mLayoutType = i10;
        adjustMenuItemTextSize(getContext());
        this.mCOUINavigationMenuView.setItemLayoutType(this.mLayoutType);
    }

    public void setOnAnimatorListener(OnNavigationEnterExitListener onNavigationEnterExitListener) {
        this.mEndListener = onNavigationEnterExitListener;
    }

    public void setOnAnimatorShowHideListener(OnNavigationShowHideListener onNavigationShowHideListener) {
        this.mShowHideListener = onNavigationShowHideListener;
    }

    public void setOnConfigChangedListener(OnConfigChangedListener onConfigChangedListener) {
        this.mConfigChangedListener = onConfigChangedListener;
    }

    public void setOnEnlargeSelectListener(OnEnlargeSelectListener onEnlargeSelectListener) {
        this.mEnlargeSelectListener = onEnlargeSelectListener;
        setOnItemSelectedListener(new NavigationBarView.c() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationView.2
            @Override // com.google.android.material.navigation.NavigationBarView.c
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean z10;
                COUINavigationView cOUINavigationView = COUINavigationView.this;
                if (cOUINavigationView.mCOUINavigationMenuView.getEnlargeId() == menuItem.getItemId()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                cOUINavigationView.mIsCheckEnlarge = z10;
                COUINavigationView.this.mEnlargeSelectListener.onEnlargeSelect(COUINavigationView.this.mIsCheckEnlarge, menuItem);
                COUINavigationView.this.checkEnlargeState();
                return true;
            }
        });
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public void setPopupMenuRuleEnabled(boolean z10) {
        this.mPopupRuleEnable = z10;
    }

    public void setTipsView(int i10, int i11, int i12) {
        if (i10 >= this.mCOUINavigationMenuView.getVisibleItems().size()) {
            return;
        }
        setTipsView(i10, String.valueOf(i11), i12);
    }

    public void setTipsViewByItemId(int i10, int i11, int i12) {
        setTipsView((COUINavigationItemView) this.mCOUINavigationMenuView.findItemView(i10), String.valueOf(i11), i12);
    }

    public void show() {
        show(true);
    }

    public void switchToMenu(int i10) {
        switchToMenu(i10, true);
    }

    public COUINavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.f5600b);
    }

    public int getMaxItemCount(int i10) {
        if (COUIResponsiveUtils.isLargeScreen(getContext(), i10)) {
            return 7;
        }
        return COUIResponsiveUtils.isMediumScreen(getContext(), i10) ? 6 : 5;
    }

    public void hide(boolean z10) {
        if (z10) {
            this.mHideTranslateAnimation.start();
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.bottomMargin = getMeasuredHeight() * (-1);
        setLayoutParams(marginLayoutParams);
    }

    public void show(boolean z10) {
        if (z10) {
            this.mShowTranslateAnimation.start();
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.bottomMargin = 0;
        setLayoutParams(marginLayoutParams);
    }

    public void switchToMenu(int i10, boolean z10) {
        if (z10) {
            this.mNextMenuResId = i10;
            this.mExitAnimation.start();
        } else {
            inflateMenu(i10);
        }
    }

    public COUINavigationView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, h.f5692e);
    }

    public void setTipsView(int i10, String str, int i11) {
        if (i10 >= this.mCOUINavigationMenuView.getVisibleItems().size()) {
            return;
        }
        setTipsView((COUINavigationItemView) this.mCOUINavigationMenuView.findItemView(getCOUINavigationMenuView().getVisibleItem(i10).getItemId()), str, i11);
    }

    public void setTipsViewByItemId(int i10, String str, int i11) {
        setTipsView((COUINavigationItemView) this.mCOUINavigationMenuView.findItemView(i10), str, i11);
    }

    public COUINavigationView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mNextMenuResId = 0;
        this.mTextSizeResId = 0;
        this.mIsEnlarge = false;
        this.mIsCheckEnlarge = false;
        this.mPopupRuleEnable = true;
        this.mDisplayFrame = null;
        this.mWindowFrame = null;
        this.mDisplayFrameOutsets = null;
        androidx.appcompat.widget.K w10 = androidx.appcompat.widget.K.w(context, attributeSet, i.f5720a, i10, i11);
        this.mCOUINavigationMenuView = (COUINavigationMenuView) getMenuView();
        int i12 = i.f5725f;
        if (w10.s(i12)) {
            setItemTextColor(w10.c(i12));
        } else {
            setItemTextColor(getResources().getColorStateList(Y8.c.f5606b));
        }
        this.mCOUINavigationMenuView.setIconTintList(w10.c(i.f5723d));
        this.mNavigationType = w10.k(i.f5731l, 0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f5653j);
        int i13 = i.f5726g;
        int f10 = w10.f(i13, dimensionPixelSize);
        this.mTextSizeResId = w10.n(i13, 0);
        this.mCOUINavigationMenuView.setTextSize((int) COUIChangeTextUtil.getSuitableFontSize(f10, getResources().getConfiguration().fontScale, 2));
        int l10 = w10.l(i.f5728i, -1);
        int l11 = w10.l(i.f5727h, 0);
        int i14 = i.f5724e;
        if (w10.s(i14)) {
            inflateMenu(w10.n(i14, 0));
            setTipsView(0, l11, l10);
        }
        int n10 = w10.n(i.f5730k, 0);
        int n11 = w10.n(i.f5729j, 0);
        this.mEnlargeNavigationViewBgId = w10.n(i.f5721b, 0);
        int i15 = this.mNavigationType;
        if (i15 == 2) {
            this.mIsEnlarge = true;
            setBackgroundColor(0);
            this.mCOUINavigationMenuView.initEnlargeParams();
        } else if (i15 == 0) {
            setBackgroundResource(n10);
        } else {
            setBackgroundResource(n11);
        }
        int i16 = i.f5722c;
        if (w10.s(i16)) {
            setItemLayoutType(w10.l(i16, 0));
        }
        setLabelVisibilityMode(1);
        setClipChildren(false);
        setClipToPadding(false);
        addCompatibilityTopDivider(context);
        setElevation(0.0f);
        w10.y();
        initAnimation();
        applyWindowInsets();
        COUIDarkModeUtil.setForceDarkAllow(this, false);
    }

    private void setTipsView(COUINavigationItemView cOUINavigationItemView, String str, int i10) {
        if (cOUINavigationItemView != null) {
            if (i10 == 1) {
                cOUINavigationItemView.getCOUIHintRedDot().setVisibility(0);
                cOUINavigationItemView.getCOUIHintRedDot().setPointMode(1);
            } else {
                if (i10 != 2) {
                    cOUINavigationItemView.getCOUIHintRedDot().setVisibility(4);
                    return;
                }
                cOUINavigationItemView.getCOUIHintRedDot().setVisibility(0);
                if (isNumeric(str)) {
                    cOUINavigationItemView.getCOUIHintRedDot().setPointMode(2);
                    cOUINavigationItemView.getCOUIHintRedDot().setPointNumber(Integer.parseInt(str));
                } else {
                    cOUINavigationItemView.getCOUIHintRedDot().setPointMode(3);
                    cOUINavigationItemView.getCOUIHintRedDot().setPointText(str);
                }
            }
        }
    }

    @Deprecated
    public void setNeedTextAnim(boolean z10) {
    }
}
