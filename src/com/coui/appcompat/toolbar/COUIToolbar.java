package com.coui.appcompat.toolbar;

import C.a;
import X8.f;
import X8.g;
import X8.h;
import X8.o;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.O;
import androidx.appcompat.widget.S;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0455j;
import androidx.core.view.C0458m;
import androidx.core.view.C0464t;
import androidx.core.view.K;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.poplist.COUISubMenuClickListener;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.poplist.PopupMenuConfigRule;
import com.coui.appcompat.state.COUIMaskRippleDrawable;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import e.C0961a;
import e.j;
import f.C0991a;
import g.C1024a;
import j.InterfaceC1146c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class COUIToolbar extends Toolbar implements PopupMenuConfigRule {
    private static final int DEFAULT_TEXT_MAX = 24;
    private static final int DEFAULT_TEXT_MIN = 16;
    private static final String TAG = "Toolbar";
    public static final int TITLE_TYPE_HEAD = 0;
    public static final int TITLE_TYPE_SECONDARY = 1;
    private static final Rect TOOLBAR_OUTSETS = new Rect();
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private int mButtonGravity;
    private ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private final COUIRtlSpacingHelper mContentInsets;
    private Rect mDisplayFrame;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    private View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGapBetweenNavigationAndTitle;
    private int mGapBetweenSearchViewAndMenu;
    private int mGravity;
    private boolean mHasSearchViewFlag;
    boolean mIsInsidePanel;
    private boolean mIsInsideSideNavigationBar;
    private boolean mIsTiny;
    private boolean mIsTitleCenterStyle;
    private ImageView mLogoView;
    private COUIMaskRippleDrawable mMaskRippleDrawable;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private COUIActionMenuView mMenuView;
    private final ActionMenuView.d mMenuViewItemClickListener;
    private int mMinHeight;
    private ImageButton mNavButtonView;
    private Toolbar.g mOnMenuItemClickListener;
    private Context mPopupContext;
    private boolean mPopupRuleEnable;
    private int mPopupTheme;
    private int mResId;
    private final int[] mSearchCollapsingMargins;
    private final Runnable mShowOverflowMenuRunnable;
    private int mStyle;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private float mTextMaxSize;
    private float mTextMinSize;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private int mTitleMinWidth;
    private int mTitlePaddingBottom;
    private int mTitlePaddingTop;
    private int[] mTitlePosition;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private float mTitleTextSize;
    private TextView mTitleTextView;
    private int mTitleType;
    private int mToolbarCenterTitlePaddingLeft;
    private int mToolbarCenterTitlePaddingRight;
    private int mToolbarHeight;
    private int mToolbarNormalPaddingLeft;
    private int mToolbarNormalPaddingRight;
    private int mToolbarOverFlowPadding;
    private boolean mUseResponsivePadding;
    private Rect mWindowFrame;
    private O mWrapper;

    public COUIToolbar(Context context) {
        this(context, null);
    }

    private void addCustomViewsWithGravity(List<View> list, int i10) {
        boolean z10;
        if (K.v(this) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int childCount = getChildCount();
        int b10 = C0455j.b(i10, K.v(this));
        list.clear();
        if (z10) {
            for (int i11 = childCount - 1; i11 >= 0; i11--) {
                View childAt = getChildAt(i11);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == b10) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.gravity) == b10) {
                list.add(childAt2);
            }
        }
    }

    private void addSystemView(View view) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.mViewType = 1;
        addView(view, layoutParams);
    }

    private void calculateTitlePosition(int[] iArr) {
        boolean z10;
        int measuredWidth;
        int i10;
        if (K.v(this) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.f4739m);
        iArr[0] = Math.max(this.mContentInsets.getLeft(), getPaddingLeft());
        iArr[1] = getMeasuredWidth() - Math.max(this.mContentInsets.getRight(), getPaddingRight());
        if (shouldLayout(this.mMenuView) && this.mMenuView.getChildCount() != 0) {
            if (this.mMenuView.getChildCount() == 1) {
                i10 = this.mMenuView.getChildAt(0).getMeasuredWidth() + dimensionPixelSize;
                measuredWidth = 0;
            } else {
                measuredWidth = this.mMenuView.getChildAt(0).getMeasuredWidth() + dimensionPixelSize;
                i10 = 0;
                for (int i11 = 1; i11 < this.mMenuView.getChildCount(); i11++) {
                    i10 += this.mMenuView.getChildAt(i11).getMeasuredWidth() + dimensionPixelSize;
                }
            }
            if (z10) {
                iArr[0] = iArr[0] + i10;
                iArr[1] = iArr[1] - measuredWidth;
            } else {
                iArr[0] = iArr[0] + measuredWidth;
                iArr[1] = iArr[1] - i10;
            }
            int max = Math.max(iArr[0], getMeasuredWidth() - iArr[1]) + getResources().getDimensionPixelSize(f.f4689f5);
            if (!this.mIsInsidePanel && COUIChangeTextUtil.measureTextLineCount(this.mTitleTextView, getMeasuredWidth(), max * 2) <= 1) {
                iArr[0] = max;
                iArr[1] = getMeasuredWidth() - max;
            }
        }
    }

    private void calculateToolbarPadding(MenuBuilder menuBuilder, int i10) {
        boolean z10;
        int i11;
        int dimensionPixelOffset;
        int i12;
        int dimensionPixelOffset2;
        int i13;
        int dimensionPixelOffset3;
        boolean shouldLayout = shouldLayout(this.mNavButtonView);
        int i14 = 0;
        if (menuBuilder != null && (!menuBuilder.getNonActionItems().isEmpty() || !menuBuilder.getActionItems().isEmpty())) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (COUIResponsiveUtils.isSmallScreen(getContext(), View.MeasureSpec.getSize(i10))) {
            Resources resources = getContext().getResources();
            if (shouldLayout) {
                i13 = f.f4666c6;
            } else {
                i13 = f.f4738l6;
            }
            this.mToolbarNormalPaddingLeft = resources.getDimensionPixelOffset(i13);
            if (z10) {
                dimensionPixelOffset3 = getContext().getResources().getDimensionPixelOffset(f.f4698g6);
            } else {
                dimensionPixelOffset3 = getContext().getResources().getDimensionPixelOffset(f.f4762o6);
            }
            this.mToolbarNormalPaddingRight = dimensionPixelOffset3;
            this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(f.f4586R5);
        } else if (COUIResponsiveUtils.isMediumScreen(getContext(), View.MeasureSpec.getSize(i10))) {
            Resources resources2 = getContext().getResources();
            if (shouldLayout) {
                i12 = f.f4682e6;
            } else {
                i12 = f.f4754n6;
            }
            this.mToolbarNormalPaddingLeft = resources2.getDimensionPixelOffset(i12);
            if (z10) {
                dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(f.f4714i6);
            } else {
                dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(f.f4778q6);
            }
            this.mToolbarNormalPaddingRight = dimensionPixelOffset2;
            this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(f.f4600T5);
        } else if (COUIResponsiveUtils.isLargeScreen(getContext(), View.MeasureSpec.getSize(i10))) {
            Resources resources3 = getContext().getResources();
            if (shouldLayout) {
                i11 = f.f4674d6;
            } else {
                i11 = f.f4746m6;
            }
            this.mToolbarNormalPaddingLeft = resources3.getDimensionPixelOffset(i11);
            if (z10) {
                dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(f.f4706h6);
            } else {
                dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(f.f4770p6);
            }
            this.mToolbarNormalPaddingRight = dimensionPixelOffset;
            this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(f.f4593S5);
        }
        if (this.mIsInsideSideNavigationBar) {
            this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(f.f4600T5);
        }
        this.mToolbarCenterTitlePaddingRight = this.mToolbarCenterTitlePaddingLeft;
        if (this.mIsTiny) {
            if (!shouldLayout) {
                i14 = getContext().getResources().getDimensionPixelOffset(f.f4722j6);
            }
            this.mToolbarNormalPaddingLeft = i14;
            this.mToolbarNormalPaddingRight = getContext().getResources().getDimensionPixelOffset(f.f4730k6);
        }
    }

    private void changeBackViewParams() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null && this.mIsTiny) {
            LayoutParams layoutParams = (LayoutParams) imageButton.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = getContext().getResources().getDimensionPixelOffset(f.f4697g5);
            this.mNavButtonView.setLayoutParams(layoutParams);
            this.mNavButtonView.setPadding(0, 0, 0, 0);
        }
    }

    private void changeToolbarPadding(MenuBuilder menuBuilder, ImageButton imageButton, boolean z10, int i10) {
        if (menuBuilder == null && imageButton == null) {
            return;
        }
        calculateToolbarPadding(menuBuilder, i10);
        if (menuBuilder != null && (!menuBuilder.getNonActionItems().isEmpty() || !menuBuilder.getActionItems().isEmpty())) {
            int paddingLeft = getPaddingLeft();
            if (this.mUseResponsivePadding) {
                if (this.mIsTitleCenterStyle) {
                    paddingLeft = this.mToolbarCenterTitlePaddingLeft;
                } else {
                    paddingLeft = this.mToolbarNormalPaddingLeft;
                }
            }
            int paddingRight = getPaddingRight();
            if (this.mUseResponsivePadding) {
                if (this.mIsTitleCenterStyle) {
                    paddingRight = this.mToolbarCenterTitlePaddingRight;
                } else {
                    paddingRight = this.mToolbarNormalPaddingRight;
                }
            }
            if (z10) {
                setPadding(paddingRight, getPaddingTop(), paddingLeft, getPaddingBottom());
                return;
            } else {
                setPadding(paddingLeft, getPaddingTop(), paddingRight, getPaddingBottom());
                return;
            }
        }
        int paddingLeft2 = getPaddingLeft();
        if (this.mUseResponsivePadding) {
            if (this.mIsTitleCenterStyle) {
                paddingLeft2 = this.mToolbarCenterTitlePaddingLeft;
            } else {
                paddingLeft2 = this.mToolbarNormalPaddingLeft;
            }
        }
        int paddingRight2 = getPaddingRight();
        if (this.mUseResponsivePadding) {
            if (useTextMenuItemPaddingEnd()) {
                paddingRight2 = this.mToolbarCenterTitlePaddingRight;
            } else {
                paddingRight2 = this.mToolbarNormalPaddingRight;
            }
        }
        if (z10) {
            setPadding(paddingRight2, getPaddingTop(), paddingLeft2, getPaddingBottom());
        } else {
            setPadding(paddingLeft2, getPaddingTop(), paddingRight2, getPaddingBottom());
        }
    }

    private void configNavigationButtonBackground() {
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = new COUIMaskRippleDrawable(getContext());
        this.mMaskRippleDrawable = cOUIMaskRippleDrawable;
        cOUIMaskRippleDrawable.setCircleRippleMask(COUIMaskRippleDrawable.getMaskRippleRadiusByType(getContext(), 0));
        this.mNavButtonView.setBackground(this.mMaskRippleDrawable);
        COUIDarkModeUtil.setForceDarkAllow(this.mNavButtonView, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, C0961a.f30100R);
            this.mCollapseButtonView = imageButton;
            imageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.toolbar.COUIToolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIToolbar.this.collapseActionView();
                }
            });
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new ImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            COUIActionMenuView cOUIActionMenuView = new COUIActionMenuView(getContext());
            this.mMenuView = cOUIActionMenuView;
            cOUIActionMenuView.setId(h.f4884F);
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            if (this.mIsTitleCenterStyle) {
                ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width = -1;
            } else {
                ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width = -2;
            }
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388613;
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, C0961a.f30100R);
            this.mNavButtonView = imageButton;
            imageButton.setId(h.f4882E);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
            configNavigationButtonBackground();
            changeBackViewParams();
        }
    }

    private void ensureTitleTextView() {
        int i10;
        int i11;
        if (this.mTitleTextView == null) {
            Context context = getContext();
            TextView textView = new TextView(context);
            this.mTitleTextView = textView;
            textView.setPaddingRelative(0, this.mTitlePaddingTop, 0, this.mTitlePaddingBottom);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.mTypeTitle = true;
            if (this.mIsTiny) {
                i10 = 0;
            } else {
                i10 = this.mTitleMarginBottom;
            }
            ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).bottomMargin = i10;
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388613;
            this.mTitleTextView.setLayoutParams(generateDefaultLayoutParams);
            this.mTitleTextView.setSingleLine();
            this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
            int i12 = this.mTitleTextAppearance;
            if (i12 != 0) {
                setTitleTextAppearance(context, i12);
            }
            int i13 = this.mTitleTextColor;
            if (i13 != 0) {
                this.mTitleTextView.setTextColor(i13);
            }
            TextView textView2 = this.mTitleTextView;
            if (this.mIsTitleCenterStyle) {
                i11 = 4;
            } else {
                i11 = 5;
            }
            textView2.setTextAlignment(i11);
            if (this.mTitleType == 1) {
                this.mTitleTextView.setTextSize(0, COUIChangeTextUtil.getSuitableFontSize(this.mTitleTextView.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
            }
        }
    }

    private int getChildHorizontalGravity(int i10) {
        int v10 = K.v(this);
        int b10 = C0455j.b(i10, v10) & 7;
        if (b10 != 1 && b10 != 3 && b10 != 5) {
            if (v10 != 1) {
                return 3;
            }
            return 5;
        }
        return b10;
    }

    private int getChildTop(View view, int i10) {
        int i11;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i10 > 0) {
            i11 = (measuredHeight - i10) / 2;
        } else {
            i11 = 0;
        }
        int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
        if (childVerticalGravity != 48) {
            if (childVerticalGravity != 80) {
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i12 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
                int i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                if (i12 < i13) {
                    i12 = i13;
                } else {
                    int i14 = (((height - paddingBottom) - measuredHeight) - i12) - paddingTop;
                    int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    if (i14 < i15) {
                        i12 = Math.max(0, i12 - (i15 - i14));
                    }
                }
                return paddingTop + i12;
            }
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i11;
        }
        return getPaddingTop() - i11;
    }

    private int getChildVerticalGravity(int i10) {
        int i11 = i10 & 112;
        if (i11 != 16 && i11 != 48 && i11 != 80) {
            return this.mGravity & 112;
        }
        return i11;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return C0458m.b(marginLayoutParams) + C0458m.a(marginLayoutParams);
    }

    private int getMinimumHeightCompat() {
        return K.x(this);
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            View view = list.get(i12);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i14 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i10;
            int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i11;
            int max = Math.max(0, i14);
            int max2 = Math.max(0, i15);
            int max3 = Math.max(0, -i14);
            int max4 = Math.max(0, -i15);
            i13 += max + view.getMeasuredWidth() + max2;
            i12++;
            i11 = max4;
            i10 = max3;
        }
        return i13;
    }

    private int layoutChildLeft(View view, int i10, int[] iArr, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int childTop = getChildTop(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int layoutChildRight(View view, int i10, int[] iArr, int i11) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int childTop = getChildTop(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int measureChildCollapseMargins(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        boolean z10;
        int childMeasureSpec;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = 0;
        int i15 = marginLayoutParams.leftMargin - iArr[0];
        boolean z11 = true;
        int i16 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i15) + Math.max(0, i16);
        iArr[0] = Math.max(0, -i15);
        iArr[1] = Math.max(0, -i16);
        if (marginLayoutParams instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) marginLayoutParams;
            if (layoutParams.mTypeSearch && this.mHasSearchViewFlag) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!layoutParams.mTypeTitle || !this.mIsTitleCenterStyle) {
                z11 = false;
            }
        } else {
            z10 = false;
            z11 = false;
        }
        if (!z10 && !z11) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + max + i11, marginLayoutParams.width);
        } else {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, max, marginLayoutParams.width);
        }
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        view.measure(childMeasureSpec, childMeasureSpec2);
        if (z10) {
            COUIActionMenuView cOUIActionMenuView = this.mMenuView;
            if (cOUIActionMenuView != null && cOUIActionMenuView.getVisibility() != 8) {
                if (this.mMenuView.getMeasuredWidth() != 0) {
                    i14 = getPaddingEnd();
                }
                view.measure(ViewGroup.getChildMeasureSpec(i10, max, ((view.getMeasuredWidth() - this.mMenuView.getMeasuredWidth()) - i14) - this.mGapBetweenSearchViewAndMenu), childMeasureSpec2);
            }
            return max;
        }
        return view.getMeasuredWidth() + max;
    }

    private void measureChildConstrained(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildVisibilityForExpandedActionView(boolean z10) {
        int i10;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType != 2 && childAt != this.mMenuView) {
                if (z10) {
                    i10 = 8;
                } else {
                    i10 = 0;
                }
                childAt.setVisibility(i10);
            }
        }
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        if (view != null && view.getParent() == this && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private void updateChildVisibilityForExpandedActionView(View view) {
        int i10;
        if (((LayoutParams) view.getLayoutParams()).mViewType != 2 && view != this.mMenuView) {
            if (this.mExpandedActionView != null) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            view.setVisibility(i10);
        }
    }

    private boolean useTextMenuItemPaddingEnd() {
        boolean z10;
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView != null && cOUIActionMenuView.getChildCount() == 1 && (this.mMenuView.getChildAt(0) instanceof COUIActionMenuItemView)) {
            z10 = ((COUIActionMenuItemView) this.mMenuView.getChildAt(0)).isTextMenuItem();
        } else {
            z10 = false;
        }
        if (this.mIsTitleCenterStyle || z10) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams)) {
            return true;
        }
        return false;
    }

    public void clearMenu() {
        this.mResId = 0;
        getMenu().clear();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void dismissPopupMenus() {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView != null) {
            cOUIActionMenuView.dismissPopupMenus();
        }
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
        return 1;
    }

    public TextView getCOUITitleTextView() {
        ensureTitleTextView();
        return this.mTitleTextView;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetEnd() {
        return this.mContentInsets.getEnd();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetLeft() {
        return this.mContentInsets.getLeft();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetRight() {
        return this.mContentInsets.getRight();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetStart() {
        return this.mContentInsets.getStart();
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public Rect getDisplayFrame() {
        if (this.mDisplayFrame == null) {
            this.mDisplayFrame = new Rect();
        }
        getGlobalVisibleRect(this.mDisplayFrame);
        return this.mDisplayFrame;
    }

    public boolean getIsTitleCenterStyle() {
        return this.mIsTitleCenterStyle;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public COUIActionMenuView getMenuView() {
        ensureMenuView();
        return this.mMenuView;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public Rect getOutsets() {
        return TOOLBAR_OUTSETS;
    }

    public View getOverFlowMenuButton() {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView != null) {
            return cOUIActionMenuView.getOverFlowMenuButton();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public boolean getPopupMenuRuleEnabled() {
        return this.mPopupRuleEnable;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public View getTitleView() {
        return this.mTitleTextView;
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public int getType() {
        return 2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i10) {
        super.inflateMenu(i10);
        this.mResId = i10;
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView instanceof COUIActionMenuView) {
            cOUIActionMenuView.clearRedDotInfo();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a10 = C0464t.a(motionEvent);
        if (a10 == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a10 == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (a10 == 10 || a10 == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0485 A[LOOP:2: B:77:0x0483->B:78:0x0485, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x012f  */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 1178
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.toolbar.COUIToolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        MenuBuilder menuBuilder;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        boolean z11;
        if (this.mMenuView != null) {
            boolean isSmallScreen = COUIResponsiveUtils.isSmallScreen(getContext(), View.MeasureSpec.getSize(i10));
            COUIActionMenuView cOUIActionMenuView = this.mMenuView;
            if (!isSmallScreen && !this.mHasSearchViewFlag) {
                z11 = true;
            } else {
                z11 = false;
            }
            cOUIActionMenuView.setMenuItemGap(z11);
        }
        if (K.v(this) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.mIsTitleCenterStyle) {
            int[] iArr = this.mTempMargins;
            boolean b10 = S.b(this);
            int i33 = !b10 ? 1 : 0;
            int contentInsetStart = getContentInsetStart();
            int max = Math.max(contentInsetStart, 0);
            iArr[b10 ? 1 : 0] = Math.max(0, contentInsetStart);
            if (shouldLayout(this.mMenuView)) {
                changeToolbarPadding((MenuBuilder) this.mMenuView.getMenu(), null, z10, i10);
                measureChildConstrained(this.mMenuView, i10, 0, i11, 0, this.mMaxButtonHeight);
                i24 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
                i25 = Math.max(0, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
                i26 = View.combineMeasuredStates(0, K.w(this.mMenuView));
            } else {
                i24 = 0;
                i25 = 0;
                i26 = 0;
            }
            int contentInsetEnd = getContentInsetEnd();
            int max2 = max + Math.max(contentInsetEnd, i24);
            iArr[i33] = Math.max(0, contentInsetEnd - i24);
            if (shouldLayout(this.mExpandedActionView)) {
                max2 += measureChildCollapseMargins(this.mExpandedActionView, i10, max2, i11, 0, iArr);
                i25 = Math.max(i25, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
                i26 = View.combineMeasuredStates(i26, K.w(this.mExpandedActionView));
            }
            int childCount = getChildCount();
            int i34 = 0;
            while (i34 < childCount) {
                View childAt = getChildAt(i34);
                if (((LayoutParams) childAt.getLayoutParams()).mViewType != 0 || !shouldLayout(childAt)) {
                    i31 = i34;
                    i32 = childCount;
                } else {
                    i31 = i34;
                    i32 = childCount;
                    max2 += measureChildCollapseMargins(childAt, i10, max2, i11, 0, iArr);
                    i25 = Math.max(i25, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                    i26 = View.combineMeasuredStates(i26, K.w(childAt));
                }
                i34 = i31 + 1;
                childCount = i32;
            }
            int i35 = this.mTitleMarginTop + this.mTitleMarginBottom;
            if (shouldLayout(this.mTitleTextView)) {
                this.mTitleTextView.getLayoutParams().width = -2;
                this.mTitleTextView.setTextSize(0, this.mTitleTextSize);
                i27 = -2;
                measureChildCollapseMargins(this.mTitleTextView, i10, 0, i11, i35, iArr);
                int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
                int measuredHeight = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
                i26 = View.combineMeasuredStates(i26, K.w(this.mTitleTextView));
                i29 = measuredWidth;
                i28 = measuredHeight;
            } else {
                i27 = -2;
                i28 = 0;
                i29 = 0;
            }
            if (shouldLayout(this.mSubtitleTextView)) {
                this.mSubtitleTextView.getLayoutParams().width = i27;
                i30 = i28;
                i29 = Math.max(i29, measureChildCollapseMargins(this.mSubtitleTextView, i10, 0, i11, i28 + i35, iArr));
                i26 = View.combineMeasuredStates(i26, K.w(this.mSubtitleTextView));
            } else {
                i30 = i28;
            }
            int max3 = Math.max(i25, i30);
            int paddingLeft = max2 + i29 + getPaddingLeft() + getPaddingRight();
            int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
            int g02 = K.g0(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, i26 & (-16777216));
            int g03 = K.g0(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, i26 << 16);
            if (shouldCollapse()) {
                g03 = 0;
            }
            setMeasuredDimension(g02, g03);
            calculateTitlePosition(this.mTitlePosition);
            int[] iArr2 = this.mTitlePosition;
            int i36 = iArr2[1] - iArr2[0];
            if (shouldLayout(this.mTitleTextView)) {
                this.mTitleTextView.setMaxWidth(i36);
                measureChildCollapseMargins(this.mTitleTextView, View.MeasureSpec.makeMeasureSpec(i36, Integer.MIN_VALUE), 0, i11, i35, iArr);
            }
            if (shouldLayout(this.mSubtitleTextView)) {
                this.mSubtitleTextView.setMaxWidth(i36);
                measureChildCollapseMargins(this.mSubtitleTextView, View.MeasureSpec.makeMeasureSpec(i36, Integer.MIN_VALUE), 0, i11, i30 + i35, iArr);
                return;
            }
            return;
        }
        int[] iArr3 = this.mTempMargins;
        boolean b11 = S.b(this);
        int i37 = !b11 ? 1 : 0;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i10, 0, i11, 0, this.mMaxButtonHeight);
            i12 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i14 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i13 = View.combineMeasuredStates(0, K.w(this.mNavButtonView));
        } else {
            i12 = 0;
            i13 = 0;
            i14 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i10, 0, i11, 0, this.mMaxButtonHeight);
            i12 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i14 = Math.max(i14, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i13 = View.combineMeasuredStates(i13, K.w(this.mCollapseButtonView));
        }
        int i38 = i13;
        int i39 = i14;
        int contentInsetStart2 = getContentInsetStart();
        int max4 = Math.max(contentInsetStart2, i12);
        iArr3[b11 ? 1 : 0] = Math.max(0, contentInsetStart2 - i12);
        if (shouldLayout(this.mMenuView)) {
            MenuBuilder menuBuilder2 = (MenuBuilder) this.mMenuView.getMenu();
            measureChildConstrained(this.mMenuView, i10, max4, i11, 0, this.mMaxButtonHeight);
            i16 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i39 = Math.max(i39, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            int combineMeasuredStates = View.combineMeasuredStates(i38, K.w(this.mMenuView));
            menuBuilder = menuBuilder2;
            i15 = combineMeasuredStates;
        } else {
            i15 = i38;
            i16 = 0;
            menuBuilder = null;
        }
        changeToolbarPadding(menuBuilder, this.mNavButtonView, z10, i10);
        int contentInsetEnd2 = getContentInsetEnd();
        int max5 = max4 + Math.max(contentInsetEnd2, i16);
        iArr3[i37] = Math.max(0, contentInsetEnd2 - i16);
        if (shouldLayout(this.mExpandedActionView)) {
            max5 += measureChildCollapseMargins(this.mExpandedActionView, i10, max5, i11, 0, iArr3);
            i39 = Math.max(i39, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i15 = View.combineMeasuredStates(i15, K.w(this.mExpandedActionView));
        }
        if (shouldLayout(this.mLogoView)) {
            max5 += measureChildCollapseMargins(this.mLogoView, i10, max5, i11, 0, iArr3);
            i39 = Math.max(i39, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i15 = View.combineMeasuredStates(i15, K.w(this.mLogoView));
        }
        int childCount2 = getChildCount();
        int i40 = i39;
        int i41 = i15;
        for (int i42 = 0; i42 < childCount2; i42++) {
            View childAt2 = getChildAt(i42);
            if (((LayoutParams) childAt2.getLayoutParams()).mViewType == 0 && shouldLayout(childAt2)) {
                max5 += measureChildCollapseMargins(childAt2, i10, max5, i11, 0, iArr3);
                i40 = Math.max(i40, childAt2.getMeasuredHeight() + getVerticalMargins(childAt2));
                i41 = View.combineMeasuredStates(i41, K.w(childAt2));
            }
        }
        int i43 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i44 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            this.mTitleTextView.getLayoutParams().width = -1;
            this.mTitleTextView.setTextSize(0, this.mTitleTextSize);
            TextView textView = this.mTitleTextView;
            int i45 = max5 + i44;
            if (shouldLayout(this.mNavButtonView)) {
                i23 = this.mGapBetweenNavigationAndTitle;
            } else {
                i23 = 0;
            }
            i17 = 0;
            measureChildCollapseMargins(textView, i10, i45 + i23, i11, i43, iArr3);
            int measuredWidth2 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            i20 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i18 = View.combineMeasuredStates(i41, K.w(this.mTitleTextView));
            i19 = measuredWidth2;
        } else {
            i17 = 0;
            i18 = i41;
            i19 = 0;
            i20 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            this.mSubtitleTextView.getLayoutParams().width = -1;
            TextView textView2 = this.mSubtitleTextView;
            int i46 = max5 + i44;
            if (shouldLayout(this.mNavButtonView)) {
                i22 = this.mGapBetweenNavigationAndTitle;
            } else {
                i22 = i17;
            }
            i19 = Math.max(i19, measureChildCollapseMargins(textView2, i10, i46 + i22, i11, i20 + i43, iArr3));
            i20 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i18 = View.combineMeasuredStates(i18, K.w(this.mSubtitleTextView));
        }
        int max6 = Math.max(i40, i20);
        int paddingLeft2 = max5 + i19 + getPaddingLeft() + getPaddingRight();
        int paddingTop2 = max6 + getPaddingTop() + getPaddingBottom();
        int g04 = K.g0(Math.max(paddingLeft2, getSuggestedMinimumWidth()), i10, (-16777216) & i18);
        int g05 = K.g0(Math.max(paddingTop2, getSuggestedMinimumHeight()), i11, i18 << 16);
        if (shouldCollapse()) {
            i21 = i17;
        } else {
            i21 = g05;
        }
        setMeasuredDimension(g04, i21);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        COUIRtlSpacingHelper cOUIRtlSpacingHelper = this.mContentInsets;
        if (cOUIRtlSpacingHelper != null) {
            boolean z10 = true;
            if (i10 != 1) {
                z10 = false;
            }
            cOUIRtlSpacingHelper.setDirection(z10);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a10 = C0464t.a(motionEvent);
        if (a10 == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a10 == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (a10 == 1 || a10 == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public void refresh() {
        int i10;
        int i11;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.f30412a, C0961a.f30104c, 0);
        setOverflowIcon(getResources().getDrawable(g.f4872y, getContext().getTheme()));
        Drawable drawable = obtainStyledAttributes.getDrawable(j.f30470l);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = this.mMaskRippleDrawable;
        if (cOUIMaskRippleDrawable != null) {
            cOUIMaskRippleDrawable.refresh(getContext());
        }
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView instanceof COUIActionMenuView) {
            cOUIActionMenuView.mOverflowPopup = null;
        }
        if (this.mTitleTextView != null && this.mTitleTextAppearance != 0) {
            setTitleTextAppearance(getContext(), this.mTitleTextAppearance);
        }
        TextView textView = this.mTitleTextView;
        if (textView != null && (i11 = this.mTitleTextColor) != 0) {
            textView.setTextColor(i11);
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null && this.mSubtitleTextAppearance != 0) {
            textView2.setTextAppearance(getContext(), this.mSubtitleTextAppearance);
        }
        TextView textView3 = this.mSubtitleTextView;
        if (textView3 != null && (i10 = this.mSubtitleTextColor) != 0) {
            textView3.setTextColor(i10);
        }
        if (this.mResId != 0) {
            getMenu().clear();
            inflateMenu(this.mResId);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setCollapsible(boolean z10) {
        this.mCollapsible = z10;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setContentInsetsAbsolute(int i10, int i11) {
        this.mContentInsets.setAbsolute(i10, i11);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setContentInsetsRelative(int i10, int i11) {
        this.mContentInsets.setRelative(i10, i11);
    }

    @Deprecated
    public void setIsFixTitleFontSize(boolean z10) {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView != null) {
            cOUIActionMenuView.setIsFixTitleFontSize(z10);
        } else {
            Log.e(TAG, "setIsFixTitleFontSize when mMenuView is null");
        }
    }

    public void setIsInsideSideNavigationBar(boolean z10) {
        if (this.mIsInsideSideNavigationBar != z10) {
            this.mIsInsideSideNavigationBar = z10;
            requestLayout();
        }
    }

    public void setIsTitleCenterStyle(boolean z10) {
        int i10;
        ensureMenuView();
        this.mIsTitleCenterStyle = z10;
        LayoutParams layoutParams = (LayoutParams) this.mMenuView.getLayoutParams();
        boolean z11 = this.mIsTitleCenterStyle;
        if (z11) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        }
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            if (z11) {
                i10 = 4;
            } else {
                i10 = 5;
            }
            textView.setTextAlignment(i10);
        }
        this.mMenuView.setLayoutParams(layoutParams);
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(int i10) {
        setLogo(C0991a.b(getContext(), i10));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setMenuViewColor(int i10) {
        Drawable overflowIcon;
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView == null || (overflowIcon = cOUIActionMenuView.getOverflowIcon()) == null || (overflowIcon instanceof C1024a)) {
            return;
        }
        a.n(overflowIcon, i10);
        this.mMenuView.setOverflowIcon(overflowIcon);
    }

    public void setMinTitleTextSize(float f10) {
        float f11 = this.mTextMaxSize;
        if (f10 > f11) {
            f10 = f11;
        }
        this.mTextMinSize = f10;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.mMinHeight = i10;
        super.setMinimumHeight(i10);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(int i10) {
        setNavigationIcon(C0991a.b(getContext(), i10));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setOnMenuItemClickListener(Toolbar.g gVar) {
        this.mOnMenuItemClickListener = gVar;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    @Override // com.coui.appcompat.poplist.PopupMenuConfigRule
    public void setPopupMenuRuleEnabled(boolean z10) {
        this.mPopupRuleEnable = z10;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setPopupTheme(int i10) {
        if (this.mPopupTheme != i10) {
            this.mPopupTheme = i10;
            if (i10 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPopupWindowOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView instanceof COUIActionMenuView) {
            cOUIActionMenuView.setPopupWindowOnDismissListener(onDismissListener);
        }
    }

    public void setRedDot(int i10, int i11) {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView == null) {
            Log.e(TAG, "The COUIActionMenuView is null");
        } else {
            cOUIActionMenuView.setRedDot(i10, i11);
        }
    }

    public void setSearchView(View view) {
        LayoutParams layoutParams;
        if (view == null) {
            layoutParams = null;
        } else if (view.getLayoutParams() == null) {
            layoutParams = new LayoutParams(new LayoutParams(-1, this.mToolbarHeight));
        } else {
            layoutParams = new LayoutParams(view.getLayoutParams());
        }
        setSearchView(view, layoutParams);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleTextAppearance(Context context, int i10) {
        this.mSubtitleTextAppearance = i10;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleTextColor(int i10) {
        this.mSubtitleTextColor = i10;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleMarginStart(int i10) {
        this.mTitleMarginStart = i10;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextAppearance(Context context, int i10) {
        this.mTitleTextAppearance = i10;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
            if (this.mTitleType == 1) {
                this.mTitleTextView.setTextSize(0, COUIChangeTextUtil.getSuitableFontSize(this.mTitleTextView.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.minHeight});
            if (obtainStyledAttributes != null) {
                this.mTitleTextView.setMinHeight(obtainStyledAttributes.getDimensionPixelSize(0, 0));
                obtainStyledAttributes.recycle();
            }
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.lineSpacingMultiplier});
            if (obtainStyledAttributes2 != null) {
                float f10 = obtainStyledAttributes2.getFloat(0, 1.4f);
                TextView textView2 = this.mTitleTextView;
                textView2.setLineSpacing(textView2.getLineSpacingExtra(), f10);
                obtainStyledAttributes2.recycle();
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.textAlignment});
            if (obtainStyledAttributes3 != null) {
                int integer = obtainStyledAttributes3.getInteger(0, 5);
                if (integer >= 0) {
                    this.mTitleTextView.setTextAlignment(integer);
                }
                obtainStyledAttributes3.recycle();
            }
            TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.maxLines});
            if (obtainStyledAttributes4 != null) {
                int integer2 = obtainStyledAttributes4.getInteger(0, 1);
                if (integer2 >= 1) {
                    this.mTitleTextView.setSingleLine(false);
                    this.mTitleTextView.setMaxLines(integer2);
                }
                obtainStyledAttributes4.recycle();
            }
            this.mTextMaxSize = this.mTitleTextView.getTextSize();
            this.mTitleTextSize = this.mTitleTextView.getTextSize();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextColor(int i10) {
        this.mTitleTextColor = i10;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public void setTitleTextSize(float f10) {
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextSize(f10);
            this.mTitleTextSize = TypedValue.applyDimension(1, f10, getResources().getDisplayMetrics());
        }
    }

    public void setTitleTextViewTypeface(Typeface typeface) {
        ensureTitleTextView();
        this.mTitleTextView.setTypeface(typeface);
    }

    public void setUseResponsivePadding(boolean z10) {
        this.mUseResponsivePadding = z10;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public boolean showOverflowMenu() {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if ((cOUIActionMenuView instanceof COUIActionMenuView) && cOUIActionMenuView.getWindowToken() != null) {
            return this.mMenuView.showOverflowMenu();
        }
        return super.showOverflowMenu();
    }

    public void tintNavigationIconDrawable(int i10) {
        Drawable drawable;
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null && (drawable = imageButton.getDrawable()) != null && !(drawable instanceof C1024a)) {
            a.n(drawable, i10);
        }
    }

    public COUIToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0961a.f30101S);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (this.mLogoView.getParent() == null) {
                addSystemView(this.mLogoView);
                updateChildVisibilityForExpandedActionView(this.mLogoView);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && imageView.getParent() != null) {
                removeView(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (this.mNavButtonView.getParent() == null) {
                addSystemView(this.mNavButtonView);
                updateChildVisibilityForExpandedActionView(this.mNavButtonView);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && imageButton.getParent() != null) {
                removeView(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new TextView(context);
                LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
                generateDefaultLayoutParams.mTypeTitle = true;
                this.mSubtitleTextView.setLayoutParams(generateDefaultLayoutParams);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.mSubtitleTextAppearance;
                if (i10 != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i10);
                }
                int i11 = this.mSubtitleTextColor;
                if (i11 != 0) {
                    this.mSubtitleTextView.setTextColor(i11);
                }
            }
            if (this.mSubtitleTextView.getParent() == null) {
                addSystemView(this.mSubtitleTextView);
                updateChildVisibilityForExpandedActionView(this.mSubtitleTextView);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && textView.getParent() != null) {
                removeView(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setTextAlignment(5);
            this.mSubtitleTextView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureTitleTextView();
            if (this.mTitleTextView.getParent() == null) {
                addSystemView(this.mTitleTextView);
                updateChildVisibilityForExpandedActionView(this.mTitleTextView);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && textView.getParent() != null) {
                removeView(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
            this.mTitleTextSize = this.mTitleTextView.getTextSize();
        }
        this.mTitleText = charSequence;
    }

    public COUIToolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int i11;
        COUIRtlSpacingHelper cOUIRtlSpacingHelper = new COUIRtlSpacingHelper();
        this.mContentInsets = cOUIRtlSpacingHelper;
        this.mTempViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.d() { // from class: com.coui.appcompat.toolbar.COUIToolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.d
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (COUIToolbar.this.mOnMenuItemClickListener != null) {
                    return COUIToolbar.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.mSearchCollapsingMargins = new int[2];
        this.mShowOverflowMenuRunnable = new Runnable() { // from class: com.coui.appcompat.toolbar.COUIToolbar.2
            @Override // java.lang.Runnable
            public void run() {
                COUIToolbar.this.showOverflowMenu();
            }
        };
        this.mDisplayFrame = null;
        this.mWindowFrame = null;
        this.mGravity = 8388627;
        this.mIsTitleCenterStyle = false;
        this.mTitlePosition = new int[2];
        this.mTitleTextSize = 0.0f;
        this.mHasSearchViewFlag = false;
        this.mIsInsideSideNavigationBar = false;
        this.mPopupRuleEnable = true;
        this.mUseResponsivePadding = true;
        setClipToPadding(false);
        setClipChildren(false);
        if (attributeSet != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            this.mStyle = styleAttribute;
            if (styleAttribute == 0) {
                this.mStyle = i10;
            }
        } else {
            this.mStyle = 0;
        }
        androidx.appcompat.widget.K w10 = androidx.appcompat.widget.K.w(getContext(), attributeSet, o.f5396q6, i10, 0);
        int i12 = o.f5206S6;
        if (w10.s(i12)) {
            this.mTitleType = w10.k(i12, 0);
        }
        this.mTitleTextAppearance = w10.n(o.f5190Q6, 0);
        this.mSubtitleTextAppearance = w10.n(o.f5118H6, 0);
        this.mGravity = w10.l(o.f5404r6, this.mGravity);
        this.mButtonGravity = w10.l(o.f5420t6, 48);
        this.mTitleMarginStart = w10.e(o.f5166N6, 0);
        this.mIsTiny = w10.a(o.f5062A6, false);
        this.mIsInsidePanel = w10.a(o.f5094E6, false);
        int i13 = this.mTitleMarginStart;
        this.mTitleMarginEnd = i13;
        this.mTitleMarginTop = i13;
        this.mTitleMarginBottom = i13;
        int e10 = w10.e(o.f5150L6, getContext().getResources().getDimensionPixelSize(f.f4800t5));
        if (e10 >= 0) {
            this.mTitleMarginStart = e10;
        }
        int e11 = w10.e(o.f5142K6, -1);
        if (e11 >= 0) {
            this.mTitleMarginEnd = e11;
        }
        int e12 = w10.e(o.f5158M6, -1);
        if (e12 >= 0) {
            this.mTitleMarginTop = e12;
        }
        int e13 = w10.e(o.f5134J6, -1);
        if (e13 >= 0) {
            this.mTitleMarginBottom = e13;
        }
        this.mTitlePaddingTop = w10.f(o.f5182P6, 0);
        this.mTitlePaddingBottom = w10.f(o.f5174O6, 0);
        this.mMaxButtonHeight = w10.f(o.f5070B6, -1);
        int e14 = w10.e(o.f5468z6, Integer.MIN_VALUE);
        int e15 = w10.e(o.f5444w6, Integer.MIN_VALUE);
        cOUIRtlSpacingHelper.setAbsolute(w10.f(o.f5452x6, 0), w10.f(o.f5460y6, 0));
        if (e14 != Integer.MIN_VALUE || e15 != Integer.MIN_VALUE) {
            cOUIRtlSpacingHelper.setRelative(e14, e15);
        }
        this.mCollapseIcon = w10.g(o.f5436v6);
        this.mCollapseDescription = w10.p(o.f5428u6);
        CharSequence p10 = w10.p(o.f5126I6);
        if (!TextUtils.isEmpty(p10)) {
            setTitle(p10);
        }
        CharSequence p11 = w10.p(o.f5110G6);
        if (!TextUtils.isEmpty(p11)) {
            setSubtitle(p11);
        }
        this.mPopupContext = getContext();
        setPopupTheme(w10.n(o.f5102F6, 0));
        Drawable g10 = w10.g(o.f5086D6);
        if (g10 != null) {
            setNavigationIcon(g10);
        }
        CharSequence p12 = w10.p(o.f5078C6);
        if (!TextUtils.isEmpty(p12)) {
            setNavigationContentDescription(p12);
        }
        this.mMinHeight = w10.f(j.f30494p3, 0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (w10.s(o.f5412s6)) {
            this.mTextMinSize = w10.f(r0, (int) (displayMetrics.scaledDensity * 16.0f));
        } else {
            this.mTextMinSize = displayMetrics.scaledDensity * 16.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.textSize});
        if (obtainStyledAttributes != null) {
            this.mTextMaxSize = obtainStyledAttributes.getDimensionPixelSize(0, (int) (displayMetrics.scaledDensity * 24.0f));
            obtainStyledAttributes.recycle();
        }
        if (this.mTitleType == 1) {
            this.mTextMaxSize = COUIChangeTextUtil.getSuitableFontSize(this.mTextMaxSize, getResources().getConfiguration().fontScale, 2);
            this.mTextMinSize = COUIChangeTextUtil.getSuitableFontSize(this.mTextMinSize, getResources().getConfiguration().fontScale, 2);
        }
        this.mToolbarHeight = getContext().getResources().getDimensionPixelSize(f.f4650a6);
        this.mToolbarNormalPaddingLeft = getContext().getResources().getDimensionPixelOffset(f.f4658b6);
        if (this.mIsTiny) {
            this.mToolbarNormalPaddingRight = getContext().getResources().getDimensionPixelOffset(f.f4730k6);
            changeBackViewParams();
        } else {
            this.mToolbarNormalPaddingRight = getContext().getResources().getDimensionPixelOffset(f.f4690f6);
        }
        this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(f.f4607U5);
        this.mToolbarCenterTitlePaddingRight = getContext().getResources().getDimensionPixelOffset(f.f4614V5);
        this.mToolbarOverFlowPadding = getContext().getResources().getDimensionPixelOffset(f.f4786r6);
        this.mTitleMinWidth = getContext().getResources().getDimensionPixelOffset(f.f4821w5);
        this.mGapBetweenSearchViewAndMenu = getContext().getResources().getDimensionPixelOffset(f.f4713i5);
        this.mGapBetweenNavigationAndTitle = getContext().getResources().getDimensionPixelOffset(f.f4705h5);
        int i14 = o.f5198R6;
        if (w10.s(i14)) {
            this.mIsTitleCenterStyle = w10.a(i14, false);
        }
        TextView textView = this.mSubtitleTextView;
        if (textView != null && (i11 = this.mSubtitleTextAppearance) != 0) {
            textView.setTextAppearance(context, i11);
        }
        setWillNotDraw(false);
        w10.y();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends Toolbar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        boolean mTypeSearch;
        boolean mTypeTitle;
        int mViewType;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
        }

        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.gravity = 8388627;
        }

        public LayoutParams(int i10, int i11, int i12) {
            super(i10, i11);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.gravity = i12;
        }

        public LayoutParams(int i10) {
            this(-2, -1, i10);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((Toolbar.LayoutParams) layoutParams);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            copyMarginsFromCompat(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            return new LayoutParams((ActionBar.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public void setSearchView(View view, LayoutParams layoutParams) {
        if (view == null) {
            this.mHasSearchViewFlag = false;
            return;
        }
        this.mHasSearchViewFlag = true;
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        layoutParams2.mTypeSearch = true;
        layoutParams2.mViewType = 0;
        addView(view, 0, layoutParams2);
    }

    /* loaded from: classes3.dex */
    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (COUIToolbar.this.mExpandedActionView instanceof InterfaceC1146c) {
                ((InterfaceC1146c) COUIToolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            COUIToolbar cOUIToolbar = COUIToolbar.this;
            cOUIToolbar.removeView(cOUIToolbar.mExpandedActionView);
            COUIToolbar cOUIToolbar2 = COUIToolbar.this;
            cOUIToolbar2.removeView(cOUIToolbar2.mCollapseButtonView);
            COUIToolbar.this.mExpandedActionView = null;
            COUIToolbar.this.setChildVisibilityForExpandedActionView(false);
            this.mCurrentExpandedItem = null;
            COUIToolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            COUIToolbar.this.ensureCollapseButtonView();
            ViewParent parent = COUIToolbar.this.mCollapseButtonView.getParent();
            COUIToolbar cOUIToolbar = COUIToolbar.this;
            if (parent != cOUIToolbar) {
                cOUIToolbar.addView(cOUIToolbar.mCollapseButtonView);
            }
            COUIToolbar.this.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            ViewParent parent2 = COUIToolbar.this.mExpandedActionView.getParent();
            COUIToolbar cOUIToolbar2 = COUIToolbar.this;
            if (parent2 != cOUIToolbar2) {
                LayoutParams generateDefaultLayoutParams = cOUIToolbar2.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = (COUIToolbar.this.mButtonGravity & 112) | 8388611;
                generateDefaultLayoutParams.mViewType = 2;
                COUIToolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                COUIToolbar cOUIToolbar3 = COUIToolbar.this;
                cOUIToolbar3.addView(cOUIToolbar3.mExpandedActionView);
            }
            COUIToolbar.this.setChildVisibilityForExpandedActionView(true);
            COUIToolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (COUIToolbar.this.mExpandedActionView instanceof InterfaceC1146c) {
                ((InterfaceC1146c) COUIToolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.mMenu;
            if (menuBuilder2 != null && (menuItemImpl = this.mCurrentExpandedItem) != null) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.mMenu = menuBuilder;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            if (subMenuBuilder == null || subMenuBuilder.size() <= 0) {
                return false;
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean z10) {
            if (this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.mMenu.getItem(i10) == this.mCurrentExpandedItem) {
                            return;
                        }
                    }
                }
                collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback callback) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        }
    }

    @Deprecated
    public void setEnableAddExtraWidth(boolean z10) {
    }

    @Deprecated
    public void setSubMenuList(ArrayList<PopupListItem> arrayList, int i10, COUISubMenuClickListener cOUISubMenuClickListener) {
    }
}
