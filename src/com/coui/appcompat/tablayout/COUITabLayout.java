package com.coui.appcompat.tablayout;

import I.e;
import I.f;
import I.g;
import X8.c;
import Y8.d;
import Y8.h;
import Y8.i;
import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.content.b;
import androidx.core.view.K;
import androidx.viewpager.widget.ViewPager;
import com.coui.appcompat.animation.COUIEaseInterpolator;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.coui.appcompat.scrollview.COUIHorizontalScrollView;
import e.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class COUITabLayout extends COUIHorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    protected static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    private static final float DEFAULT_MAXIMUM_WIDTH_RATIO = 0.7f;
    public static final int DEFAULT_MIN_INDICATOR = 32;
    private static final int FIFTY = 50;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    private static final int HUNDRED_FIFTY = 150;
    public static final int INVALID_WIDTH = -1;
    private static final String MEDIUM_FONT = "sans-serif-medium";
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    public static final int MOTION_NON_ADJACENT_OFFSET = 24;
    public static final float ONE = 1.0f;
    private static final float POINT_FIVE = 0.5f;
    public static final int PRESS_RIPPLE_CORNER_RADIUS = 8;
    private static final String REGULAR_FONT = "sans-serif";
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final e<COUITab> TAB_POOL = new g(16);
    private static final int THREE_HUNDRED = 300;
    public static final float ZERO = 0.0f;
    private AdapterChangeListener mAdapterChangeListener;
    private int mBottomDividerColor;
    private boolean mBottomDividerEnabled;
    private int mButtonMarginEnd;
    private ArrayList<PrivateButton> mButtons;
    private OnTabSelectedListener mCurrentVpSelectedListener;
    private float mDefaultIndicatorRatio;
    private float mDefaultTabTextSize;
    protected int mDotHorizontalOffset;
    protected int mDotVerticalOffsetFromNumberRed;
    protected int mDotVerticalOffsetFromOnlyRed;
    protected boolean mEnableVibrator;
    private ArgbEvaluator mEvaluator;
    private int mIndicatorPadding;
    private boolean mIsUpdateindicatorposition;
    private float mLastOffset;
    private int mLongTextViewHeight;
    private int mMode;
    protected boolean mNeedAdjust;
    protected int mNormalTextColor;
    protected Typeface mNormalTypeface;
    private int mOriginalRequestedTabMaxWidth;
    private int mOriginalRequestedTabMinWidth;
    private TabLayoutOnPageChangeListener mPageChangeListener;
    private androidx.viewpager.widget.a mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    protected int mRequestedTabMaxWidth;
    private int mRequestedTabMinWidth;
    private int mResizeHeight;
    private ValueAnimator mScrollAnimator;
    private int mSelectedIndicatorColor;
    private int mSelectedIndicatorDisableColor;
    private OnTabSelectedListener mSelectedListener;
    private final ArrayList<OnTabSelectedListener> mSelectedListeners;
    private int mSelectedPosition;
    protected COUITab mSelectedTab;
    protected int mSelectedTextColor;
    protected Typeface mSelectedTypeface;
    private boolean mSetupViewPagerImplicitly;
    private int mStyle;
    protected boolean mTabAlreadyMeasure;
    protected final int mTabBackgroundResId;

    @Deprecated
    private int mTabGravity;
    private int mTabMinDivider;
    private int mTabMinMargin;
    protected int mTabPaddingBottom;
    protected int mTabPaddingEnd;
    protected int mTabPaddingStart;
    protected int mTabPaddingTop;
    protected final COUISlidingTabStrip mTabStrip;
    private int mTabTextAppearance;
    protected ColorStateList mTabTextColors;
    private int mTabTextDisabledColor;
    private float mTabTextSize;
    private Typeface mTabTextTypeFace;
    private final e<COUITabView> mTabViewPool;
    private final ArrayList<COUITab> mTabs;
    private int mTextColorBlue;
    private int mTextColorGreen;
    private int mTextColorRed;
    private ViewPager mViewPager;

    /* loaded from: classes3.dex */
    public class AdapterChangeListener implements ViewPager.h {
        private boolean mAutoRefresh;

        public AdapterChangeListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void onAdapterChanged(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            if (COUITabLayout.this.mViewPager == viewPager) {
                COUITabLayout.this.setPagerAdapter(aVar2, this.mAutoRefresh);
            }
        }

        public void setAutoRefresh(boolean z10) {
            this.mAutoRefresh = z10;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Mode {
    }

    /* loaded from: classes3.dex */
    public interface OnTabSelectedListener {
        void onTabReselected(COUITab cOUITab);

        void onTabSelected(COUITab cOUITab);

        void onTabUnselected(COUITab cOUITab);
    }

    /* loaded from: classes3.dex */
    public class PagerAdapterObserver extends DataSetObserver {
        public PagerAdapterObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            COUITabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            COUITabLayout.this.populateFromPagerAdapter();
        }
    }

    /* loaded from: classes3.dex */
    public class PrivateButton {
        View.OnClickListener mButtonClicklistener;
        Drawable mButtonDrawable;

        public PrivateButton(Drawable drawable, View.OnClickListener onClickListener) {
            this.mButtonDrawable = drawable;
            this.mButtonClicklistener = onClickListener;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TabGravity {
    }

    /* loaded from: classes3.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.i {
        private int mPreviousScrollState;
        private int mScrollState;
        private final WeakReference<COUITabLayout> mTabLayoutRef;

        public TabLayoutOnPageChangeListener(COUITabLayout cOUITabLayout) {
            this.mTabLayoutRef = new WeakReference<>(cOUITabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrollStateChanged(int i10) {
            this.mPreviousScrollState = this.mScrollState;
            this.mScrollState = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            COUITabLayout cOUITabLayout = this.mTabLayoutRef.get();
            if (cOUITabLayout != null) {
                int i12 = this.mScrollState;
                boolean z11 = false;
                if (i12 == 2 && this.mPreviousScrollState != 1) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (i12 != 2 || this.mPreviousScrollState != 0) {
                    z11 = true;
                }
                cOUITabLayout.setScrollPosition(i10, f10, z10, z11);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void onPageSelected(int i10) {
            boolean z10;
            COUITabLayout cOUITabLayout = this.mTabLayoutRef.get();
            if (cOUITabLayout != null && cOUITabLayout.getSelectedTabPosition() != i10 && i10 < cOUITabLayout.getTabCount()) {
                int i11 = this.mScrollState;
                if (i11 != 0 && (i11 != 2 || this.mPreviousScrollState != 0)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                cOUITabLayout.selectTab(cOUITabLayout.getTabAt(i10), z10);
            }
        }

        public void reset() {
            this.mPreviousScrollState = 0;
            this.mScrollState = 0;
        }
    }

    public COUITabLayout(Context context) {
        this(context, null);
    }

    private void addTabFromItemView(COUITabItem cOUITabItem) {
        COUITab newTab = newTab();
        CharSequence charSequence = cOUITabItem.mText;
        if (charSequence != null) {
            newTab.setText(charSequence);
        }
        Drawable drawable = cOUITabItem.mIcon;
        if (drawable != null) {
            newTab.setIcon(drawable);
        }
        int i10 = cOUITabItem.mCustomLayout;
        if (i10 != 0) {
            newTab.setCustomView(i10);
        }
        if (!TextUtils.isEmpty(cOUITabItem.getContentDescription())) {
            newTab.setContentDescription(cOUITabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void addTabView(COUITab cOUITab) {
        this.mTabStrip.addView(cOUITab.mView, cOUITab.getPosition(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (view instanceof COUITabItem) {
            addTabFromItemView((COUITabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int i10) {
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() != null && K.O(this) && !this.mTabStrip.childrenNeedLayout()) {
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i10, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.mScrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                this.mScrollAnimator.start();
            }
            this.mTabStrip.animateIndicatorToPosition(i10, 300);
            return;
        }
        setScrollPosition(i10, 0.0f, true);
    }

    private void applyModeAndGravity() {
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i10, float f10) {
        View view;
        int i11;
        int right;
        int i12 = 0;
        if (getWidth() == 0) {
            return 0;
        }
        View childAt = this.mTabStrip.getChildAt(i10);
        int i13 = i10 + 1;
        if (i13 < this.mTabStrip.getChildCount()) {
            view = this.mTabStrip.getChildAt(i13);
        } else {
            view = null;
        }
        if (childAt != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            i11 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        } else {
            i11 = 0;
        }
        if (view != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view.getLayoutParams();
            i12 = layoutParams2.rightMargin + view.getWidth() + layoutParams2.leftMargin;
        }
        int width = (i11 / 2) - (getWidth() / 2);
        if (childAt != null) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (K.v(this) == 0) {
                right = (childAt.getLeft() - layoutParams3.leftMargin) + (getPaddingLeft() / 2) + (getPaddingRight() / 2);
            } else {
                right = ((childAt.getRight() + layoutParams3.rightMargin) - (getPaddingLeft() / 2)) - (getPaddingRight() / 2);
            }
            width += right;
        }
        int i14 = (int) ((i11 + i12) * 0.5f * f10);
        if (K.v(this) == 0) {
            return width + i14;
        }
        return width - i14;
    }

    private void configureTab(COUITab cOUITab, int i10) {
        cOUITab.setPosition(i10);
        this.mTabs.add(i10, cOUITab);
        int size = this.mTabs.size();
        while (true) {
            i10++;
            if (i10 < size) {
                this.mTabs.get(i10).setPosition(i10);
            } else {
                return;
            }
        }
    }

    private static ColorStateList createColorStateList(int i10, int i11, int i12) {
        return new ColorStateList(new int[][]{new int[]{16842913, 16842910}, new int[]{-16842913, -16842910}, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i12, i11, i10});
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        return new LinearLayout.LayoutParams(1, -1);
    }

    private COUITabView createTabView(COUITab cOUITab) {
        COUITabView cOUITabView;
        e<COUITabView> eVar = this.mTabViewPool;
        if (eVar != null) {
            cOUITabView = eVar.b();
        } else {
            cOUITabView = null;
        }
        if (cOUITabView == null) {
            cOUITabView = new COUITabView(getContext(), this);
        }
        cOUITabView.setTab(cOUITab);
        cOUITabView.setFocusable(true);
        cOUITabView.setMinimumWidth(getTabMinWidth());
        cOUITabView.setEnabled(isEnabled());
        return cOUITabView;
    }

    private void dispatchTabReselected(COUITab cOUITab) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabReselected(cOUITab);
        }
    }

    private void dispatchTabSelected(COUITab cOUITab) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabSelected(cOUITab);
        }
    }

    private void dispatchTabUnselected(COUITab cOUITab) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabUnselected(cOUITab);
        }
    }

    private void drawButton(Canvas canvas) {
        int width;
        int scrollX;
        int width2;
        int width3;
        int scrollX2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f5621M);
        if (this.mButtons.size() == 1) {
            Drawable drawable = this.mButtons.get(0).mButtonDrawable;
            int i10 = this.mButtonMarginEnd;
            if (i10 == -1) {
                i10 = getResources().getDimensionPixelSize(d.f5619K);
            }
            if (K.v(this) == 1) {
                width2 = getScrollX() + i10;
                width3 = dimensionPixelSize + i10;
                scrollX2 = getScrollX();
            } else {
                width2 = (getWidth() - (dimensionPixelSize + i10)) + getScrollX();
                width3 = getWidth() - i10;
                scrollX2 = getScrollX();
            }
            int i11 = width3 + scrollX2;
            int height = getHeight() / 2;
            Resources resources = getResources();
            int i12 = d.f5620L;
            drawable.setBounds(width2, height - resources.getDimensionPixelSize(i12), i11, (getHeight() / 2) + getResources().getDimensionPixelSize(i12));
            drawable.draw(canvas);
            return;
        }
        if (this.mButtons.size() >= 2) {
            for (int i13 = 0; i13 < this.mButtons.size(); i13++) {
                int i14 = this.mButtonMarginEnd;
                if (i14 == -1) {
                    i14 = getResources().getDimensionPixelSize(d.f5626R);
                }
                if (K.v(this) == 1) {
                    scrollX = i14 + (getResources().getDimensionPixelSize(d.f5627S) * i13);
                    width = getScrollX();
                } else {
                    width = getWidth() - ((i14 + dimensionPixelSize) + (getResources().getDimensionPixelSize(d.f5627S) * i13));
                    scrollX = getScrollX();
                }
                int i15 = scrollX + width;
                Drawable drawable2 = this.mButtons.get(i13).mButtonDrawable;
                int height2 = getHeight() / 2;
                Resources resources2 = getResources();
                int i16 = d.f5620L;
                drawable2.setBounds(i15, height2 - resources2.getDimensionPixelSize(i16), i15 + dimensionPixelSize, (getHeight() / 2) + getResources().getDimensionPixelSize(i16));
                drawable2.draw(canvas);
            }
        }
    }

    private void ensureScrollAnimator() {
        if (this.mScrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mScrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(new COUIEaseInterpolator());
            this.mScrollAnimator.setDuration(300L);
            this.mScrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.tablayout.COUITabLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUITabLayout.this.scrollTo(((Integer) valueAnimator2.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private int getDefaultHeight() {
        int size = this.mTabs.size();
        for (int i10 = 0; i10 < size; i10++) {
            COUITab cOUITab = this.mTabs.get(i10);
            if (cOUITab != null && cOUITab.getIcon() != null && !TextUtils.isEmpty(cOUITab.getText())) {
                return 72;
            }
        }
        return 48;
    }

    private float getScrollPosition() {
        return this.mTabStrip.getIndicatorPosition();
    }

    private int getTabMinWidth() {
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.mTabStrip.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i10) {
        COUITabView cOUITabView = (COUITabView) this.mTabStrip.getChildAt(i10);
        this.mTabStrip.removeViewAt(i10);
        if (cOUITabView != null) {
            cOUITabView.reset();
            this.mTabViewPool.a(cOUITabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i10) {
        int childCount = this.mTabStrip.getChildCount();
        if (i10 < childCount) {
            int i11 = 0;
            while (i11 < childCount) {
                this.mTabStrip.getChildAt(i11).setSelected(i11 == i10);
                i11++;
            }
        }
    }

    private void updateAllTabs() {
        int size = this.mTabs.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTabs.get(i10).updateView();
        }
    }

    private void updateTextColor() {
        this.mNormalTextColor = this.mTabTextColors.getDefaultColor();
        int colorForState = this.mTabTextColors.getColorForState(new int[]{16842910, 16842913}, COUIContextUtil.getAttrColor(getContext(), c.f4349H, 0));
        this.mSelectedTextColor = colorForState;
        this.mTextColorRed = Math.abs(Color.red(colorForState) - Color.red(this.mNormalTextColor));
        this.mTextColorGreen = Math.abs(Color.green(this.mSelectedTextColor) - Color.green(this.mNormalTextColor));
        this.mTextColorBlue = Math.abs(Color.blue(this.mSelectedTextColor) - Color.blue(this.mNormalTextColor));
    }

    public void addButton(int i10, View.OnClickListener onClickListener) {
        addButton(b.e(getContext(), i10), onClickListener);
    }

    public void addOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        if (!this.mSelectedListeners.contains(onTabSelectedListener)) {
            this.mSelectedListeners.add(onTabSelectedListener);
        }
    }

    public void addTab(COUITab cOUITab) {
        addTab(cOUITab, this.mTabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip != null) {
            if (cOUISlidingTabStrip.getIndicatorBackgroundPaint() != null) {
                canvas.drawRect(this.mTabStrip.getIndicatorBackgroundPaddingLeft() + getScrollX(), getHeight() - this.mTabStrip.getIndicatorBackgroundHeight(), (getWidth() + getScrollX()) - this.mTabStrip.getIndicatorBackgroundPaddingRight(), getHeight(), this.mTabStrip.getIndicatorBackgroundPaint());
            }
            if (this.mTabStrip.getSelectedIndicatorPaint() != null) {
                canvas.drawText(" ", 0.0f, 0.0f, this.mTabStrip.getSelectedIndicatorPaint());
                if (this.mTabStrip.getIndicatorRight() > this.mTabStrip.getIndicatorLeft()) {
                    int paddingLeft = getPaddingLeft() + this.mTabStrip.getIndicatorLeft();
                    int paddingLeft2 = getPaddingLeft() + this.mTabStrip.getIndicatorRight();
                    int scrollX = (getScrollX() + getPaddingLeft()) - this.mIndicatorPadding;
                    int scrollX2 = ((getScrollX() + getWidth()) - getPaddingRight()) + this.mIndicatorPadding;
                    if (paddingLeft2 > scrollX && paddingLeft < scrollX2) {
                        if (paddingLeft < scrollX) {
                            paddingLeft = scrollX;
                        }
                        if (paddingLeft2 > scrollX2) {
                            paddingLeft2 = scrollX2;
                        }
                        canvas.drawRect(paddingLeft, getHeight() - this.mTabStrip.mSelectedIndicatorHeight, paddingLeft2, getHeight(), this.mTabStrip.getSelectedIndicatorPaint());
                    }
                }
                if (this.mBottomDividerEnabled) {
                    canvas.drawRect(getLeft(), getHeight() - 1, getScrollX() + getWidth() + this.mIndicatorPadding, getHeight(), this.mTabStrip.getBottomDividerPaint());
                }
            }
        }
        drawButton(canvas);
    }

    public int dpToPx(int i10) {
        return Math.round(getResources().getDisplayMetrics().density * i10);
    }

    public boolean enableTab(int i10, boolean z10) {
        COUITabView cOUITabView;
        COUITab tabAt = getTabAt(i10);
        if (tabAt != null && (cOUITabView = tabAt.mView) != null) {
            cOUITabView.setEnabled(z10);
            return true;
        }
        return false;
    }

    public float getDefaultIndicatoRatio() {
        return this.mDefaultIndicatorRatio;
    }

    public int getIndicatorAnimTime(int i10, int i11) {
        return Math.min(300, (Math.abs(i10 - i11) * 50) + 150);
    }

    public int getIndicatorBackgroundHeight() {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return -1;
        }
        return cOUISlidingTabStrip.getIndicatorBackgroundHeight();
    }

    public int getIndicatorBackgroundPaddingLeft() {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return -1;
        }
        return cOUISlidingTabStrip.getIndicatorBackgroundPaddingLeft();
    }

    public int getIndicatorBackgroundPaddingRight() {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return -1;
        }
        return cOUISlidingTabStrip.getIndicatorBackgroundPaddingRight();
    }

    public int getIndicatorBackgroundPaintColor() {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return -1;
        }
        return cOUISlidingTabStrip.getIndicatorBackgroundPaint().getColor();
    }

    public int getIndicatorPadding() {
        return this.mIndicatorPadding;
    }

    public float getIndicatorWidthRatio() {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return -1.0f;
        }
        return cOUISlidingTabStrip.getIndicatorWidthRatio();
    }

    public int getRequestedTabMaxWidth() {
        return this.mRequestedTabMaxWidth;
    }

    public int getRequestedTabMinWidth() {
        return this.mRequestedTabMinWidth;
    }

    public int getSelectedIndicatorColor() {
        return this.mSelectedIndicatorColor;
    }

    public int getSelectedTabPosition() {
        COUITab cOUITab = this.mSelectedTab;
        if (cOUITab != null) {
            return cOUITab.getPosition();
        }
        return -1;
    }

    public COUITab getTabAt(int i10) {
        if (i10 >= 0 && i10 < getTabCount()) {
            return this.mTabs.get(i10);
        }
        return null;
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public int getTabGravity() {
        return this.mTabGravity;
    }

    public int getTabMinDivider() {
        return this.mTabMinDivider;
    }

    public int getTabMinMargin() {
        return this.mTabMinMargin;
    }

    public int getTabMode() {
        return this.mMode;
    }

    public int getTabPaddingBottom() {
        return this.mTabPaddingBottom;
    }

    public int getTabPaddingEnd() {
        return this.mTabPaddingEnd;
    }

    public int getTabPaddingStart() {
        return this.mTabPaddingStart;
    }

    public int getTabPaddingTop() {
        return this.mTabPaddingTop;
    }

    public COUISlidingTabStrip getTabStrip() {
        return this.mTabStrip;
    }

    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }

    public float getTabTextSize() {
        return this.mTabTextSize;
    }

    @Deprecated
    public boolean isResizeText() {
        return false;
    }

    public boolean isUpdateindicatorposition() {
        return this.mIsUpdateindicatorposition;
    }

    public COUITab newTab() {
        COUITab b10 = TAB_POOL.b();
        if (b10 == null) {
            b10 = new COUITab();
        }
        b10.mParent = this;
        b10.mView = createTabView(b10);
        return b10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mTabAlreadyMeasure = false;
    }

    @Override // com.coui.appcompat.scrollview.COUIHorizontalScrollView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.mSetupViewPagerImplicitly = false;
        }
    }

    @Override // com.coui.appcompat.scrollview.COUIHorizontalScrollView, android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            for (int i10 = 0; i10 < this.mButtons.size(); i10++) {
                if (this.mButtons.get(i10).mButtonClicklistener != null && this.mButtons.get(i10).mButtonDrawable.getBounds().contains(((int) motionEvent.getX()) + getScrollX(), (int) motionEvent.getY())) {
                    return true;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.mNeedAdjust && (i14 = this.mSelectedPosition) >= 0 && i14 < this.mTabStrip.getChildCount()) {
            this.mNeedAdjust = false;
            scrollTo(calculateScrollXForTab(this.mSelectedPosition, 0.0f), 0);
        }
    }

    @Override // com.coui.appcompat.scrollview.COUIHorizontalScrollView, android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int dpToPx = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i11 = View.MeasureSpec.makeMeasureSpec(dpToPx, 1073741824);
            }
        } else {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.min(dpToPx, View.MeasureSpec.getSize(i11)), 1073741824);
        }
        int size = View.MeasureSpec.getSize(i10);
        if (this.mOriginalRequestedTabMaxWidth == -1) {
            this.mRequestedTabMaxWidth = (int) (size * DEFAULT_MAXIMUM_WIDTH_RATIO);
        }
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i12 = this.mMode;
        if (i12 != 0) {
            if (i12 == 1) {
                getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i11);
            }
        } else {
            getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE), i11);
        }
        setMeasuredDimension(size, getChildAt(0).getMeasuredHeight());
    }

    @Override // com.coui.appcompat.scrollview.COUIHorizontalScrollView, android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            for (int i10 = 0; i10 < this.mButtons.size(); i10++) {
                if (this.mButtons.get(i10).mButtonClicklistener != null && this.mButtons.get(i10).mButtonDrawable.getBounds().contains(((int) motionEvent.getX()) + getScrollX(), (int) motionEvent.getY())) {
                    this.mButtons.get(i10).mButtonClicklistener.onClick(this);
                    return true;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        androidx.viewpager.widget.a aVar = this.mPagerAdapter;
        if (aVar != null) {
            int count = aVar.getCount();
            androidx.viewpager.widget.a aVar2 = this.mPagerAdapter;
            if (aVar2 instanceof COUIFragmentStatePagerAdapter) {
                COUIFragmentStatePagerAdapter cOUIFragmentStatePagerAdapter = (COUIFragmentStatePagerAdapter) aVar2;
                for (int i10 = 0; i10 < count; i10++) {
                    if (cOUIFragmentStatePagerAdapter.getPageIcon(i10) > 0) {
                        addTab(newTab().setIcon(cOUIFragmentStatePagerAdapter.getPageIcon(i10)), false);
                    } else {
                        addTab(newTab().setText(cOUIFragmentStatePagerAdapter.getPageTitle(i10)), false);
                    }
                }
            } else {
                for (int i11 = 0; i11 < count; i11++) {
                    addTab(newTab().setText(this.mPagerAdapter.getPageTitle(i11)), false);
                }
            }
            ViewPager viewPager = this.mViewPager;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                selectTab(getTabAt(currentItem));
            }
        }
    }

    public void refresh() {
        String resourceTypeName = getResources().getResourceTypeName(this.mStyle);
        TypedArray typedArray = null;
        if ("attr".equals(resourceTypeName)) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, i.f5744y, this.mStyle, 0);
        } else if ("style".equals(resourceTypeName)) {
            typedArray = getContext().getTheme().obtainStyledAttributes(null, i.f5744y, 0, this.mStyle);
        }
        if (typedArray != null) {
            int i10 = i.f5718Y;
            if (typedArray.hasValue(i10)) {
                this.mTabTextColors = typedArray.getColorStateList(i10);
            }
            int i11 = i.f5703J;
            if (typedArray.hasValue(i11)) {
                setSelectedTabIndicatorColor(typedArray.getColor(i11, 0));
            }
            updateTextColor();
            typedArray.recycle();
        }
        Iterator<COUITab> it = this.mTabs.iterator();
        while (it.hasNext()) {
            COUITab next = it.next();
            if (next != null && next.getView() != null) {
                next.getView().refresh();
            }
        }
    }

    public void removeAllButtons(int i10) {
        this.mButtons.clear();
        setTabMode(i10);
        invalidate();
    }

    public void removeAllTabs() {
        for (int childCount = this.mTabStrip.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<COUITab> it = this.mTabs.iterator();
        while (it.hasNext()) {
            COUITab next = it.next();
            it.remove();
            next.reset();
            TAB_POOL.a(next);
        }
        this.mSelectedTab = null;
        this.mTabAlreadyMeasure = false;
    }

    public void removeOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mSelectedListeners.remove(onTabSelectedListener);
    }

    public void removeTab(COUITab cOUITab) {
        if (cOUITab.mParent == this) {
            removeTabAt(cOUITab.getPosition());
            return;
        }
        throw new IllegalArgumentException("COUITab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i10) {
        int i11;
        COUITab cOUITab;
        COUITab cOUITab2 = this.mSelectedTab;
        if (cOUITab2 != null) {
            i11 = cOUITab2.getPosition();
        } else {
            i11 = 0;
        }
        removeTabViewAt(i10);
        COUITab remove = this.mTabs.remove(i10);
        if (remove != null) {
            remove.reset();
            TAB_POOL.a(remove);
        }
        int size = this.mTabs.size();
        for (int i12 = i10; i12 < size; i12++) {
            this.mTabs.get(i12).setPosition(i12);
        }
        if (i11 == i10) {
            if (this.mTabs.isEmpty()) {
                cOUITab = null;
            } else {
                cOUITab = this.mTabs.get(Math.max(0, i10 - 1));
            }
            selectTab(cOUITab);
        }
    }

    public void resetTextColorAfterAnim() {
        int childCount = this.mTabStrip.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.mTabStrip.getChildAt(i10);
            if (childAt instanceof COUITabView) {
                ((COUITabView) childAt).getTextView().setTextColor(this.mTabTextColors);
            }
        }
    }

    public void selectTab(COUITab cOUITab) {
        selectTab(cOUITab, true);
    }

    public void setEnableVibrator(boolean z10) {
        this.mEnableVibrator = z10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        int i10;
        super.setEnabled(z10);
        if (z10) {
            i10 = this.mSelectedIndicatorColor;
        } else {
            i10 = this.mSelectedIndicatorDisableColor;
        }
        this.mTabStrip.setSelectedIndicatorColor(i10);
        for (int i11 = 0; i11 < getTabCount(); i11++) {
            enableTab(i11, z10);
        }
    }

    public void setIndicatorAnimTime(int i10) {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip != null) {
            cOUISlidingTabStrip.setIndicatorAnimTime(i10);
        }
    }

    public void setIndicatorBackgroundColor(int i10) {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return;
        }
        cOUISlidingTabStrip.getIndicatorBackgroundPaint().setColor(i10);
    }

    public void setIndicatorBackgroundHeight(int i10) {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return;
        }
        cOUISlidingTabStrip.setIndicatorBackgroundHeight(i10);
    }

    public void setIndicatorBackgroundPaddingLeft(int i10) {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return;
        }
        cOUISlidingTabStrip.setIndicatorBackgroundPaddingLeft(i10);
    }

    public void setIndicatorBackgroundPaddingRight(int i10) {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return;
        }
        cOUISlidingTabStrip.setIndicatorBackgroundPaddingRight(i10);
    }

    public void setIndicatorPadding(int i10) {
        this.mIndicatorPadding = i10;
        requestLayout();
    }

    public void setIndicatorWidthRatio(float f10) {
        COUISlidingTabStrip cOUISlidingTabStrip = this.mTabStrip;
        if (cOUISlidingTabStrip == null) {
            return;
        }
        this.mDefaultIndicatorRatio = f10;
        cOUISlidingTabStrip.setIndicatorWidthRatio(f10);
    }

    @Deprecated
    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        OnTabSelectedListener onTabSelectedListener2 = this.mSelectedListener;
        if (onTabSelectedListener2 != null) {
            removeOnTabSelectedListener(onTabSelectedListener2);
        }
        this.mSelectedListener = onTabSelectedListener;
        if (onTabSelectedListener != null) {
            addOnTabSelectedListener(onTabSelectedListener);
        }
    }

    public void setPaddingLeftAndRight(int i10, int i11) {
        K.A0(this, i10, 0, i11, 0);
    }

    public void setPagerAdapter(androidx.viewpager.widget.a aVar, boolean z10) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.mPagerAdapter;
        if (aVar2 != null && (dataSetObserver = this.mPagerAdapterObserver) != null) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.mPagerAdapter = aVar;
        if (z10 && aVar != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new PagerAdapterObserver();
            }
            aVar.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    public void setRequestedTabMaxWidth(int i10) {
        this.mRequestedTabMaxWidth = i10;
        this.mOriginalRequestedTabMaxWidth = i10;
    }

    public void setRequestedTabMinWidth(int i10) {
        this.mRequestedTabMinWidth = i10;
        this.mOriginalRequestedTabMinWidth = i10;
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.mScrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i10, float f10, boolean z10) {
        setScrollPosition(i10, f10, z10, true);
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.mTabStrip.setSelectedIndicatorColor(i10);
        this.mSelectedIndicatorColor = i10;
    }

    public void setSelectedTabIndicatorHeight(int i10) {
        this.mTabStrip.setSelectedIndicatorHeight(i10);
    }

    public void setTabMinDivider(int i10) {
        this.mTabMinDivider = i10;
        requestLayout();
    }

    public void setTabMinMargin(int i10) {
        this.mTabMinMargin = i10;
        K.A0(this, i10, 0, i10, 0);
        requestLayout();
    }

    public void setTabMode(int i10) {
        if (i10 != this.mMode) {
            this.mMode = i10;
            applyModeAndGravity();
        }
    }

    public void setTabPaddingBottom(int i10) {
        this.mTabPaddingBottom = i10;
        requestLayout();
    }

    public void setTabPaddingEnd(int i10) {
        this.mTabPaddingEnd = i10;
        requestLayout();
    }

    public void setTabPaddingStart(int i10) {
        this.mTabPaddingStart = i10;
        requestLayout();
    }

    public void setTabPaddingTop(int i10) {
        this.mTabPaddingTop = i10;
        requestLayout();
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            updateTextColor();
            updateAllTabs();
        }
    }

    public void setTabTextSize(float f10) {
        if (this.mTabStrip != null) {
            this.mDefaultTabTextSize = f10;
            this.mTabTextSize = f10;
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(androidx.viewpager.widget.a aVar) {
        setPagerAdapter(aVar, false);
    }

    public void setUpdateindicatorposition(boolean z10) {
        this.mIsUpdateindicatorposition = z10;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        if (getTabScrollRange() > 0) {
            return true;
        }
        return false;
    }

    public void updateTabViews(boolean z10) {
        for (int i10 = 0; i10 < this.mTabStrip.getChildCount(); i10++) {
            COUITabView cOUITabView = (COUITabView) this.mTabStrip.getChildAt(i10);
            cOUITabView.setMinimumWidth(getTabMinWidth());
            if (cOUITabView.getTextView() != null) {
                K.A0(cOUITabView.getTextView(), this.mTabPaddingStart, this.mTabPaddingTop, this.mTabPaddingEnd, this.mTabPaddingBottom);
            }
            if (z10) {
                cOUITabView.requestLayout();
            }
        }
    }

    public COUITabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Y8.a.f5601c);
    }

    public void addButton(Drawable drawable, View.OnClickListener onClickListener) {
        addButton(drawable, onClickListener, (Drawable) null, (View.OnClickListener) null);
    }

    public void addTab(COUITab cOUITab, int i10) {
        addTab(cOUITab, i10, this.mTabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        addViewInternal(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void selectTab(COUITab cOUITab, boolean z10) {
        COUITab cOUITab2 = this.mSelectedTab;
        if (cOUITab2 == cOUITab) {
            if (cOUITab2 != null) {
                dispatchTabReselected(cOUITab);
                return;
            }
            return;
        }
        int position = cOUITab != null ? cOUITab.getPosition() : -1;
        if (z10) {
            if ((cOUITab2 == null || cOUITab2.getPosition() == -1) && position != -1) {
                setScrollPosition(position, 0.0f, true);
            } else {
                animateToTab(position);
            }
            if (position != -1) {
                setSelectedTabView(position);
            }
            this.mSelectedPosition = position;
        } else if (isEnabled() && this.mEnableVibrator) {
            performHapticFeedback(COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE);
        }
        if (cOUITab2 != null) {
            dispatchTabUnselected(cOUITab2);
        }
        this.mSelectedTab = cOUITab;
        if (cOUITab != null) {
            dispatchTabSelected(cOUITab);
        }
    }

    public void setScrollPosition(int i10, float f10, boolean z10, boolean z11) {
        int round = Math.round(i10 + f10);
        if (round < 0 || round >= this.mTabStrip.getChildCount()) {
            return;
        }
        if (z11) {
            this.mTabStrip.setIndicatorPositionFromTabPosition(i10, f10);
        } else if (this.mTabStrip.mSelectedPosition != getSelectedTabPosition()) {
            this.mTabStrip.mSelectedPosition = getSelectedTabPosition();
            this.mTabStrip.updateIndicatorPosition();
        }
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mScrollAnimator.cancel();
        }
        scrollTo(calculateScrollXForTab(i10, f10), 0);
        if (z10) {
            setSelectedTabView(round, f10);
        }
    }

    public void setupWithViewPager(ViewPager viewPager, boolean z10) {
        setupWithViewPager(viewPager, z10, false);
    }

    public COUITabLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, h.f5689b);
    }

    private void setupWithViewPager(ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.mPageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.mAdapterChangeListener;
            if (adapterChangeListener != null) {
                this.mViewPager.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        OnTabSelectedListener onTabSelectedListener = this.mCurrentVpSelectedListener;
        if (onTabSelectedListener != null) {
            removeOnTabSelectedListener(onTabSelectedListener);
            this.mCurrentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.mPageChangeListener == null) {
                this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.mPageChangeListener.reset();
            viewPager.addOnPageChangeListener(this.mPageChangeListener);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.mCurrentVpSelectedListener = viewPagerOnTabSelectedListener;
            addOnTabSelectedListener(viewPagerOnTabSelectedListener);
            if (viewPager.getAdapter() != null) {
                setPagerAdapter(viewPager.getAdapter(), z10);
            }
            if (this.mAdapterChangeListener == null) {
                this.mAdapterChangeListener = new AdapterChangeListener();
            }
            this.mAdapterChangeListener.setAutoRefresh(z10);
            viewPager.addOnAdapterChangeListener(this.mAdapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.mViewPager = null;
            setPagerAdapter(null, false);
        }
        this.mSetupViewPagerImplicitly = z11;
    }

    public void addButton(int i10, View.OnClickListener onClickListener, int i11, View.OnClickListener onClickListener2) {
        addButton(b.e(getContext(), i10), onClickListener, b.e(getContext(), i11), onClickListener2);
    }

    public void addTab(COUITab cOUITab, boolean z10) {
        addTab(cOUITab, this.mTabs.size(), z10);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public COUITabLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mTabs = new ArrayList<>();
        this.mSelectedListeners = new ArrayList<>();
        this.mTabViewPool = new f(12);
        this.mRequestedTabMaxWidth = -1;
        this.mSelectedPosition = 0;
        this.mLastOffset = 0.0f;
        this.mEvaluator = new ArgbEvaluator();
        this.mIsUpdateindicatorposition = false;
        this.mButtons = new ArrayList<>();
        if (attributeSet != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            this.mStyle = styleAttribute;
            if (styleAttribute == 0) {
                this.mStyle = i10;
            }
        } else {
            this.mStyle = i10;
        }
        this.mSelectedTypeface = Typeface.create("sans-serif-medium", 0);
        this.mNormalTypeface = Typeface.create(REGULAR_FONT, 0);
        setHorizontalScrollBarEnabled(false);
        COUISlidingTabStrip cOUISlidingTabStrip = new COUISlidingTabStrip(context, this);
        this.mTabStrip = cOUISlidingTabStrip;
        super.addView(cOUISlidingTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f5744y, i10, i11);
        cOUISlidingTabStrip.setSelectedIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(i.f5705L, 0));
        int color = obtainStyledAttributes.getColor(i.f5703J, 0);
        this.mSelectedIndicatorColor = color;
        cOUISlidingTabStrip.setSelectedIndicatorColor(color);
        this.mBottomDividerColor = obtainStyledAttributes.getColor(i.f5694A, 0);
        this.mBottomDividerEnabled = obtainStyledAttributes.getBoolean(i.f5695B, false);
        cOUISlidingTabStrip.setBottomDividerColor(this.mBottomDividerColor);
        setIndicatorBackgroundHeight(obtainStyledAttributes.getDimensionPixelSize(i.f5700G, 0));
        setIndicatorBackgroundColor(obtainStyledAttributes.getColor(i.f5699F, 0));
        setIndicatorBackgroundPaddingLeft(obtainStyledAttributes.getDimensionPixelSize(i.f5701H, 0));
        setIndicatorBackgroundPaddingRight(obtainStyledAttributes.getDimensionPixelSize(i.f5702I, 0));
        setIndicatorWidthRatio(obtainStyledAttributes.getFloat(i.f5706M, 0.0f));
        this.mResizeHeight = getResources().getDimensionPixelOffset(d.f5640c0);
        this.mLongTextViewHeight = getResources().getDimensionPixelOffset(d.f5652i0);
        this.mTabMinDivider = obtainStyledAttributes.getDimensionPixelOffset(i.f5707N, -1);
        this.mTabMinMargin = obtainStyledAttributes.getDimensionPixelOffset(i.f5708O, -1);
        this.mIndicatorPadding = getResources().getDimensionPixelOffset(d.f5642d0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.f5711R, -1);
        this.mTabPaddingStart = dimensionPixelSize;
        this.mTabPaddingTop = dimensionPixelSize;
        this.mTabPaddingEnd = dimensionPixelSize;
        this.mTabPaddingBottom = dimensionPixelSize;
        this.mTabPaddingStart = obtainStyledAttributes.getDimensionPixelSize(i.f5714U, dimensionPixelSize);
        this.mTabPaddingTop = obtainStyledAttributes.getDimensionPixelSize(i.f5715V, this.mTabPaddingTop);
        this.mTabPaddingEnd = obtainStyledAttributes.getDimensionPixelSize(i.f5713T, this.mTabPaddingEnd);
        this.mTabPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(i.f5712S, this.mTabPaddingBottom);
        this.mTabPaddingStart = Math.max(0, this.mTabPaddingStart);
        this.mTabPaddingTop = Math.max(0, this.mTabPaddingTop);
        this.mTabPaddingEnd = Math.max(0, this.mTabPaddingEnd);
        this.mTabPaddingBottom = Math.max(0, this.mTabPaddingBottom);
        int resourceId = obtainStyledAttributes.getResourceId(i.f5717X, h.f5690c);
        this.mTabTextAppearance = resourceId;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, j.f30428c3);
        try {
            float dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(j.f30434d3, 0);
            this.mTabTextSize = dimensionPixelSize2;
            this.mDefaultTabTextSize = dimensionPixelSize2;
            this.mTabTextColors = obtainStyledAttributes2.getColorStateList(j.f30449g3);
            obtainStyledAttributes2.recycle();
            int i12 = i.f5718Y;
            if (obtainStyledAttributes.hasValue(i12)) {
                this.mTabTextColors = obtainStyledAttributes.getColorStateList(i12);
            }
            this.mTabTextDisabledColor = COUIContextUtil.getAttrColor(getContext(), c.f4398p, 0);
            int i13 = i.f5716W;
            if (obtainStyledAttributes.hasValue(i13)) {
                this.mTabTextColors = createColorStateList(this.mTabTextColors.getDefaultColor(), this.mTabTextDisabledColor, obtainStyledAttributes.getColor(i13, 0));
            }
            this.mRequestedTabMinWidth = obtainStyledAttributes.getDimensionPixelSize(i.f5709P, -1);
            this.mTabBackgroundResId = obtainStyledAttributes.getResourceId(i.f5745z, 0);
            this.mMode = obtainStyledAttributes.getInt(i.f5710Q, 1);
            this.mTabGravity = obtainStyledAttributes.getInt(i.f5698E, 0);
            this.mEnableVibrator = obtainStyledAttributes.getBoolean(i.f5697D, true);
            this.mSelectedIndicatorDisableColor = obtainStyledAttributes.getColor(i.f5704K, getResources().getColor(Y8.c.f5605a));
            int i14 = i.f5719Z;
            if (obtainStyledAttributes.hasValue(i14)) {
                float dimension = obtainStyledAttributes.getDimension(i14, 0.0f);
                this.mTabTextSize = dimension;
                this.mDefaultTabTextSize = dimension;
            }
            this.mOriginalRequestedTabMinWidth = this.mRequestedTabMinWidth;
            this.mOriginalRequestedTabMaxWidth = this.mRequestedTabMaxWidth;
            this.mButtonMarginEnd = obtainStyledAttributes.getDimensionPixelOffset(i.f5696C, -1);
            obtainStyledAttributes.recycle();
            this.mDotHorizontalOffset = context.getResources().getDimensionPixelSize(X8.f.f4773q1);
            this.mDotVerticalOffsetFromOnlyRed = context.getResources().getDimensionPixelSize(X8.f.f4796t1);
            this.mDotVerticalOffsetFromNumberRed = context.getResources().getDimensionPixelSize(X8.f.f4789s1);
            applyModeAndGravity();
            updateTextColor();
            setOverScrollMode(1);
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    private void setSelectedTabView(int i10, float f10) {
        COUITabView cOUITabView;
        float f11;
        if (Math.abs(f10 - this.mLastOffset) > 0.5f || f10 == 0.0f) {
            this.mSelectedPosition = i10;
        }
        this.mLastOffset = f10;
        if (i10 != this.mSelectedPosition && isEnabled()) {
            COUITabView cOUITabView2 = (COUITabView) this.mTabStrip.getChildAt(i10);
            if (f10 >= 0.5f) {
                cOUITabView = (COUITabView) this.mTabStrip.getChildAt(i10 - 1);
                f11 = f10 - 0.5f;
            } else {
                cOUITabView = (COUITabView) this.mTabStrip.getChildAt(i10 + 1);
                f11 = 0.5f - f10;
            }
            float f12 = f11 / 0.5f;
            if (cOUITabView.getTextView() != null) {
                cOUITabView.getTextView().setTextColor(((Integer) this.mEvaluator.evaluate(f12, Integer.valueOf(this.mSelectedTextColor), Integer.valueOf(this.mNormalTextColor))).intValue());
            }
            if (cOUITabView2.getTextView() != null) {
                cOUITabView2.getTextView().setTextColor(((Integer) this.mEvaluator.evaluate(f12, Integer.valueOf(this.mNormalTextColor), Integer.valueOf(this.mSelectedTextColor))).intValue());
            }
        }
        if (f10 != 0.0f || i10 >= getTabCount()) {
            return;
        }
        int i11 = 0;
        while (true) {
            boolean z10 = true;
            if (i11 < getTabCount()) {
                View childAt = this.mTabStrip.getChildAt(i11);
                COUITabView cOUITabView3 = (COUITabView) childAt;
                if (cOUITabView3.getTextView() != null) {
                    cOUITabView3.getTextView().setTextColor(this.mTabTextColors);
                }
                if (i11 != i10) {
                    z10 = false;
                }
                childAt.setSelected(z10);
                i11++;
            } else {
                this.mNeedAdjust = true;
                return;
            }
        }
    }

    public void addTab(COUITab cOUITab, int i10, boolean z10) {
        if (cOUITab.mParent == this) {
            configureTab(cOUITab, i10);
            addTabView(cOUITab);
            if (z10) {
                cOUITab.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("COUITab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    @Deprecated
    public void setTabTextSize(float f10, boolean z10) {
        setTabTextSize(f10);
    }

    public void setTabTextColors(int i10, int i11) {
        setTabTextColors(createColorStateList(i10, this.mTabTextDisabledColor, i11));
    }

    public void addButton(Drawable drawable, View.OnClickListener onClickListener, Drawable drawable2, View.OnClickListener onClickListener2) {
        this.mButtons.clear();
        this.mButtons.add(new PrivateButton(drawable, onClickListener));
        if (drawable2 != null) {
            this.mButtons.add(new PrivateButton(drawable2, onClickListener2));
        }
        setTabMode(0);
        invalidate();
    }

    /* loaded from: classes3.dex */
    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
        private final ViewPager mViewPager;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.mViewPager = viewPager;
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabSelected(COUITab cOUITab) {
            this.mViewPager.setCurrentItem(cOUITab.getPosition());
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabReselected(COUITab cOUITab) {
        }

        @Override // com.coui.appcompat.tablayout.COUITabLayout.OnTabSelectedListener
        public void onTabUnselected(COUITab cOUITab) {
        }
    }

    public void setTabGravity(int i10) {
    }

    @Deprecated
    public void changeTabTextFont(COUITabView cOUITabView, boolean z10) {
    }
}
