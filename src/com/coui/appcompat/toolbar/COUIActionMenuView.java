package com.coui.appcompat.toolbar;

import X8.f;
import X8.k;
import X8.m;
import X8.n;
import X8.o;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.P;
import androidx.appcompat.widget.S;
import androidx.core.view.K;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.COUISubMenuClickListener;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.reddot.COUIHintRedDotHelper;
import com.coui.appcompat.state.COUIMaskRippleDrawable;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import com.coui.appcompat.uiutil.AnimLevel;
import com.coui.appcompat.uiutil.UIUtil;
import e.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p.C1415a;

/* loaded from: classes3.dex */
public class COUIActionMenuView extends ActionMenuView {
    private static final String EMPTY_TITLE = "";
    private static final int HUNDRED = 100;
    private static final int MAX_TEXT_MENU_ITEM_LINE = 2;
    private static final String OVER_FLOW_MENU_CLASS = "androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton";
    private static final String TAG = "COUIActionMenuView";
    private static final int TEN = 10;
    private AnimLevel mBlurMinAnimLevel;
    private int mEdgeIconItemMargin;
    private int mEdgeTextItemMargin;
    private boolean mEnableAddExtraWidth;
    private COUIHintRedDotHelper mHintRedDotHelper;
    private int mIconItemHorOffset;
    private boolean mIsFixTitleFontSize;
    private boolean mIsSameSide;
    private int mItemSpacing;
    private C1415a<Integer, Integer> mItemSpecialColorMap;
    private int mItemVerOffset;
    private COUIMaskRippleDrawable mMaskRippleDrawable;
    private MenuBuilder mMenu;
    private int mMenuIconBgRadius;
    private int mMenuIconTopPadding;
    private MenuItemImpl mMenuItem;
    private int mMenuViewPadding;
    private int mNonActionRedDotCount;
    private int mNonActionRedDotSum;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private AdapterView.OnItemClickListener mOnSubMenuItemClickListener;
    private final OpenOverflowRunnable mOpenOverflowRunnable;
    private String mOverFlowButtonDescription;
    private int mOverFlowHorPadding;
    private View mOverFlowMenuButton;
    private int mOverFlowMinWidth;
    private ArrayList<PopupListItem> mOverflowItems;
    private OverflowMenuListener mOverflowMenuListener;
    public COUIPopupListWindow mOverflowPopup;
    private List<Class<?>> mPresenterClasses;
    private String mRedDotDescription;
    private int mRedDotHorizontalOffset;
    private HashMap<Integer, Integer> mRedDotMap;
    private int mRedDotVerticalOffset;
    private int mRedDotWithBigNumberHorizontalOffset;
    private int mRedDotWithNumberDescriptionId;
    private int mRedDotWithNumberHorizontalOffset;
    private int mRedDotWithNumberVerticalOffset;
    private int mRedDotWithSmallNumberHorizontalOffset;
    private C1415a<Integer, Integer> mSubItemSpecialColorMap;
    private ArrayList<PopupListItem> mSubMenuList;
    private int mSubPosition;
    private int mTextExtarPadding;
    private int mTextMenuItemHorizontalPadding;
    private int mTextMenuItemMaxWidth;
    private int mToolbarTitleMinWidth;
    private boolean mUseBackgroundBlur;

    /* loaded from: classes3.dex */
    public class OpenOverflowRunnable implements Runnable {
        private OpenOverflowRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIPopupListWindow cOUIPopupListWindow;
            if (COUIActionMenuView.this.mMenu != null) {
                COUIActionMenuView.this.mMenu.changeMenuMode();
            }
            if (COUIActionMenuView.this.getWindowToken() != null && (cOUIPopupListWindow = COUIActionMenuView.this.mOverflowPopup) != null && !cOUIPopupListWindow.isShowing()) {
                COUIActionMenuView cOUIActionMenuView = COUIActionMenuView.this;
                cOUIActionMenuView.mOverflowPopup.show(cOUIActionMenuView.mOverFlowMenuButton, COUIActionMenuView.this.mOverFlowMenuButton.getWidth() / 2, COUIActionMenuView.this.mOverFlowMenuButton.getHeight());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OverflowMenuListener {
        void onOverflowMenuPreShow(COUIPopupListWindow cOUIPopupListWindow);
    }

    public COUIActionMenuView(Context context) {
        this(context, null);
    }

    private void configOverflowIconBackground() {
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = new COUIMaskRippleDrawable(getContext());
        this.mMaskRippleDrawable = cOUIMaskRippleDrawable;
        cOUIMaskRippleDrawable.setCircleRippleMask(COUIMaskRippleDrawable.getMaskRippleRadiusByType(getContext(), 0));
        this.mOverFlowMenuButton.setBackground(this.mMaskRippleDrawable);
        COUIDarkModeUtil.setForceDarkAllow(this.mOverFlowMenuButton, false);
    }

    private void drawRedDot(View view, int i10, Canvas canvas) {
        int i11;
        int i12;
        int i13;
        float f10;
        float f11;
        float y10;
        float f12;
        float f13;
        float f14;
        if (i10 != -1) {
            if (i10 != 0) {
                i11 = 2;
            } else {
                i11 = 1;
            }
        } else {
            i11 = 0;
        }
        if (view != null) {
            int viewWidth = this.mHintRedDotHelper.getViewWidth(i11, i10);
            int viewHeight = this.mHintRedDotHelper.getViewHeight(i11);
            if (i11 == 1) {
                i12 = this.mRedDotHorizontalOffset;
                i13 = this.mRedDotVerticalOffset;
            } else if (i10 < 10) {
                i12 = this.mRedDotWithSmallNumberHorizontalOffset;
                i13 = this.mRedDotWithNumberVerticalOffset;
            } else if (i10 < 100) {
                i12 = this.mRedDotWithNumberHorizontalOffset;
                i13 = this.mRedDotWithNumberVerticalOffset;
            } else {
                i12 = this.mRedDotWithBigNumberHorizontalOffset;
                i13 = this.mRedDotWithNumberVerticalOffset;
            }
            RectF rectF = new RectF();
            if ((view instanceof ActionMenuItemView) && ((ActionMenuItemView) view).getItemData().getIcon() == null) {
                if (isLayoutRTL()) {
                    f13 = (view.getX() + i12) - this.mMenuViewPadding;
                    f14 = f13 - viewWidth;
                } else {
                    f14 = ((view.getX() + view.getWidth()) - i12) + this.mMenuViewPadding;
                    f13 = viewWidth + f14;
                }
                y10 = (this.mMenuIconTopPadding - i13) + this.mItemVerOffset;
                f12 = viewHeight + y10;
            } else {
                if (isLayoutRTL()) {
                    f10 = (view.getX() + ((view.getWidth() - this.mMenuIconBgRadius) / 2)) - i12;
                    f11 = viewWidth + f10;
                } else {
                    float x10 = ((view.getX() + view.getWidth()) - ((view.getWidth() - this.mMenuIconBgRadius) / 2)) + i12;
                    f10 = x10 - viewWidth;
                    f11 = x10;
                }
                y10 = (view.getY() + ((view.getHeight() - this.mMenuIconBgRadius) / 2)) - i13;
                f12 = y10 + viewHeight;
                f13 = f11;
                f14 = f10;
            }
            rectF.left = f14;
            rectF.top = y10;
            rectF.right = f13;
            rectF.bottom = f12;
            this.mHintRedDotHelper.drawRedPoint(canvas, i11, Integer.valueOf(i10), rectF);
        }
    }

    private void ensureOverflowMenu() {
        if (this.mOverflowPopup == null) {
            Context context = getContext();
            if (!COUIContextUtil.isCOUITheme(context)) {
                Configuration configuration = getContext().getResources().getConfiguration();
                configuration.densityDpi = getContext().getResources().getDisplayMetrics().densityDpi;
                context = new ContextThemeWrapper(getContext().createConfigurationContext(configuration), n.f5041m);
            }
            COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(context);
            this.mOverflowPopup = cOUIPopupListWindow;
            cOUIPopupListWindow.setUseBackgroundBlur(this.mUseBackgroundBlur, this.mBlurMinAnimLevel);
            this.mOverflowPopup.setInputMethodMode(2);
            this.mOverflowPopup.setOnDismissListener(this.mOnDismissListener);
            this.mOverflowItems = new ArrayList<>();
        }
    }

    private boolean isLayoutRTL() {
        if (K.v(this) == 1) {
            return true;
        }
        return false;
    }

    private int measureChild(int i10, int i11) {
        int measureChildCollapseMargins;
        int i12 = 0;
        if (!shouldUseStrictTextMeasure()) {
            int i13 = 0;
            while (i12 < getChildCount()) {
                i13 += measureChildCollapseMargins(getChildAt(i12), i10, i13, i11, 0);
                i12++;
            }
            return i13;
        }
        int size = View.MeasureSpec.getSize(i10);
        int i14 = this.mToolbarTitleMinWidth;
        while (i12 < getChildCount()) {
            View childAt = getChildAt(i12);
            if (childAt instanceof COUIActionMenuItemView) {
                COUIActionMenuItemView cOUIActionMenuItemView = (COUIActionMenuItemView) childAt;
                if (cOUIActionMenuItemView.isTextMenuItem()) {
                    TextView textView = (TextView) childAt;
                    int measureTextLineCount = COUIChangeTextUtil.measureTextLineCount(textView, this.mTextMenuItemMaxWidth, this.mTextMenuItemHorizontalPadding * 2);
                    if (i12 == 0) {
                        if (measureTextLineCount <= 2) {
                            cOUIActionMenuItemView.setMaxWidth(this.mTextMenuItemMaxWidth);
                        } else {
                            cOUIActionMenuItemView.setMaxWidth((size - i14) / 2);
                        }
                        measureChildCollapseMargins = measureChildCollapseMargins(childAt, i10, ((size - i14) / 2) + i14, i11, 0);
                    } else {
                        if (measureTextLineCount <= 2) {
                            cOUIActionMenuItemView.setMaxWidth(this.mTextMenuItemMaxWidth);
                        } else {
                            cOUIActionMenuItemView.setMaxWidth(COUIChangeTextUtil.binarySearchForOptimalTextViewWidth(textView, 2, this.mTextMenuItemMaxWidth, size - i14, this.mTextMenuItemHorizontalPadding * 2));
                        }
                        measureChildCollapseMargins = measureChildCollapseMargins(childAt, i10, i14, i11, 0);
                    }
                    i14 += measureChildCollapseMargins;
                }
            }
            i12++;
        }
        return i14;
    }

    private int measureChildCollapseMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + i14 + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + i14;
    }

    private void resetItemMargin() {
        int i10 = -1;
        int i11 = -1;
        int i12 = 0;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            if (getChildAt(i13).getVisibility() != 8) {
                i12++;
                if (i12 == 1) {
                    i10 = i13;
                    i11 = i10;
                } else {
                    i11 = i13;
                }
            }
        }
        if (i10 != -1 && !this.mIsSameSide && i12 > 1) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuItemView) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (((ActionMenuItemView) childAt).getItemData().getIcon() == null) {
                    if (isLayoutRTL()) {
                        marginLayoutParams.rightMargin = this.mEdgeTextItemMargin;
                    } else {
                        marginLayoutParams.leftMargin = this.mEdgeTextItemMargin;
                    }
                } else if (isLayoutRTL()) {
                    marginLayoutParams.rightMargin = this.mEdgeIconItemMargin;
                } else {
                    marginLayoutParams.leftMargin = this.mEdgeIconItemMargin;
                }
            }
        }
        if (i11 != -1) {
            View childAt2 = getChildAt(i11);
            if (childAt2 instanceof ActionMenuItemView) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                if (((ActionMenuItemView) childAt2).getItemData().getIcon() == null) {
                    if (isLayoutRTL()) {
                        marginLayoutParams2.leftMargin = this.mEdgeTextItemMargin;
                        return;
                    } else {
                        marginLayoutParams2.rightMargin = this.mEdgeTextItemMargin;
                        return;
                    }
                }
                if (isLayoutRTL()) {
                    marginLayoutParams2.leftMargin = this.mEdgeIconItemMargin;
                } else {
                    marginLayoutParams2.rightMargin = this.mEdgeIconItemMargin;
                }
            }
        }
    }

    private String setRedDotDescription(int i10) {
        if (i10 != -1) {
            if (i10 != 0) {
                return getResources().getQuantityString(this.mRedDotWithNumberDescriptionId, i10, Integer.valueOf(i10));
            }
            return this.mRedDotDescription;
        }
        return "";
    }

    private boolean shouldUseStrictTextMeasure() {
        if (getChildCount() != 2 || this.mIsSameSide) {
            return false;
        }
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if ((childAt instanceof COUIActionMenuItemView) && !((COUIActionMenuItemView) childAt).isTextMenuItem()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryBuildOverflowMenu() {
        ArrayList<PopupListItem> arrayList;
        int i10;
        Integer num;
        String str;
        ensureOverflowMenu();
        this.mOverflowItems.clear();
        if (this.mMenu != null) {
            PopupListItem.Builder builder = new PopupListItem.Builder();
            for (int i11 = 0; i11 < this.mMenu.getNonActionItems().size(); i11++) {
                MenuItemImpl menuItemImpl = this.mMenu.getNonActionItems().get(i11);
                this.mMenuItem = menuItemImpl;
                String str2 = "";
                if (menuItemImpl.hasSubMenu()) {
                    arrayList = new ArrayList<>();
                    SubMenu subMenu = this.mMenuItem.getSubMenu();
                    for (int i12 = 0; i12 < subMenu.size(); i12++) {
                        MenuItem item = subMenu.getItem(i12);
                        PopupListItem.Builder icon = builder.reset().setId(item.getItemId()).setIcon(item.getIcon());
                        if (item.getTitle() == null) {
                            str = "";
                        } else {
                            str = item.getTitle().toString();
                        }
                        icon.setTitle(str).setGroupId(item.getGroupId()).setIsEnable(item.isEnabled());
                        arrayList.add(builder.build());
                    }
                } else {
                    arrayList = null;
                }
                int i13 = -1;
                if (this.mRedDotMap.containsKey(Integer.valueOf(this.mMenuItem.getItemId())) && (num = this.mRedDotMap.get(Integer.valueOf(this.mMenuItem.getItemId()))) != null) {
                    i10 = num.intValue();
                } else {
                    i10 = -1;
                }
                PopupListItem.Builder icon2 = builder.reset().setId(this.mMenuItem.getItemId()).setIcon(this.mMenuItem.getIcon());
                if (this.mMenuItem.getTitle() != null) {
                    str2 = this.mMenuItem.getTitle().toString();
                }
                PopupListItem.Builder redDotAmount = icon2.setTitle(str2).setIsChecked(this.mMenuItem.isChecked()).setGroupId(this.mMenuItem.getGroupId()).setRedDotAmount(i10);
                if (i10 != -1) {
                    i13 = 0;
                }
                redDotAmount.setHintType(i13).setSubMenuItemList(arrayList).setIsEnable(this.mMenuItem.isEnabled());
                this.mOverflowItems.add(builder.build());
            }
            this.mOverflowPopup.setItemList(this.mOverflowItems);
            this.mOverflowPopup.setIsFixedFontSize(this.mIsFixTitleFontSize);
            this.mOverflowPopup.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.toolbar.COUIActionMenuView.3
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i14, long j10) {
                    if (i14 >= COUIActionMenuView.this.mMenu.getNonActionItems().size()) {
                        COUILog.e(COUIActionMenuView.TAG, "IndexOutOfBoundsException! position = " + i14 + " non action items size = " + COUIActionMenuView.this.mMenu.getNonActionItems().size() + "popup menu size = " + COUIActionMenuView.this.mOverflowPopup.getItemList().size());
                        return;
                    }
                    if (((PopupListItem) COUIActionMenuView.this.mOverflowItems.get(i14)).getSubMenuItemList() == null) {
                        COUIActionMenuView.this.mMenu.performItemAction(COUIActionMenuView.this.mMenu.getNonActionItems().get(i14), 0);
                        COUIActionMenuView.this.mOverflowPopup.dismiss();
                    } else {
                        COUIActionMenuView.this.mMenu.performItemAction(COUIActionMenuView.this.mMenu.getNonActionItems().get(i14), 4);
                    }
                }
            });
            this.mOverflowPopup.setSubMenuClickListener(this.mOnSubMenuItemClickListener);
            OverflowMenuListener overflowMenuListener = this.mOverflowMenuListener;
            if (overflowMenuListener != null) {
                overflowMenuListener.onOverflowMenuPreShow(this.mOverflowPopup);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.coui.appcompat.toolbar.COUIActionMenuView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return true;
            }
        });
        view.setHapticFeedbackEnabled(false);
        P.a(view, "");
        if (((ActionMenuView.LayoutParams) layoutParams).f7557a) {
            this.mOverFlowMenuButton = view;
            configOverflowIconBackground();
            layoutParams.height = -1;
            this.mOverFlowMenuButton.setMinimumWidth(this.mOverFlowMinWidth);
            View view2 = this.mOverFlowMenuButton;
            view2.setPadding(this.mOverFlowHorPadding, view2.getPaddingTop(), this.mOverFlowHorPadding, this.mOverFlowMenuButton.getPaddingBottom());
            this.mOverFlowMenuButton.setOnTouchListener(null);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.toolbar.COUIActionMenuView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    COUIActionMenuView.this.tryBuildOverflowMenu();
                    COUIActionMenuView cOUIActionMenuView = COUIActionMenuView.this;
                    cOUIActionMenuView.post(cOUIActionMenuView.mOpenOverflowRunnable);
                }
            });
        }
        super.addView(view, i10, layoutParams);
        configMenuItemViewAlignment();
    }

    public void clearRedDotInfo() {
        this.mNonActionRedDotSum = 0;
        this.mNonActionRedDotCount = 0;
        this.mRedDotMap.clear();
        postInvalidate();
    }

    public void configMenuItemViewAlignment() {
        if (getParent() instanceof COUIToolbar) {
            this.mIsSameSide = !((COUIToolbar) getParent()).getIsTitleCenterStyle();
        } else {
            this.mIsSameSide = true;
        }
        if (this.mIsSameSide) {
            int i10 = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt instanceof ActionMenuItemView) {
                    i10++;
                    childAt.setTextAlignment(4);
                }
            }
            if (i10 == 1 && (getChildAt(0) instanceof COUIActionMenuItemView)) {
                COUIActionMenuItemView cOUIActionMenuItemView = (COUIActionMenuItemView) getChildAt(0);
                if (cOUIActionMenuItemView.isTextMenuItem()) {
                    cOUIActionMenuItemView.setTextAlignment(6);
                    return;
                }
                return;
            }
            return;
        }
        View view = null;
        for (int childCount2 = getChildCount() - 1; childCount2 >= 0; childCount2--) {
            View childAt2 = getChildAt(childCount2);
            if (childAt2 instanceof ActionMenuItemView) {
                if (view != null) {
                    childAt2.setTextAlignment(5);
                    view.setTextAlignment(6);
                } else {
                    childAt2.setTextAlignment(6);
                }
                view = childAt2;
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public void dismissPopupMenus() {
        COUIPopupListWindow cOUIPopupListWindow = this.mOverflowPopup;
        if (cOUIPopupListWindow != null) {
            cOUIPopupListWindow.dismiss();
        }
        super.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i10;
        String str;
        int intValue;
        super.dispatchDraw(canvas);
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (this.mRedDotMap.containsKey(Integer.valueOf(childAt.getId()))) {
                Integer num = this.mRedDotMap.get(Integer.valueOf(childAt.getId()));
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                drawRedDot(childAt, intValue, canvas);
            }
            if (((ActionMenuView.LayoutParams) childAt.getLayoutParams()).f7557a && this.mRedDotMap.size() > 0) {
                if (this.mNonActionRedDotCount == 0) {
                    i10 = -1;
                } else {
                    i10 = this.mNonActionRedDotSum;
                }
                drawRedDot(childAt, i10, canvas);
                if (TextUtils.isEmpty(setRedDotDescription(i10))) {
                    str = this.mOverFlowButtonDescription;
                } else {
                    str = this.mOverFlowButtonDescription + "," + setRedDotDescription(i10);
                }
                childAt.setContentDescription(str);
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public Menu getMenu() {
        MenuBuilder menuBuilder = (MenuBuilder) super.getMenu();
        this.mMenu = menuBuilder;
        return menuBuilder;
    }

    public View getOverFlowMenuButton() {
        return this.mOverFlowMenuButton;
    }

    public COUIPopupListWindow getOverflowPopupWindow() {
        return this.mOverflowPopup;
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
        super.initialize(menuBuilder);
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            if (getChildAt(i16).getVisibility() != 8) {
                i15++;
            }
        }
        boolean b10 = S.b(this);
        int i17 = (i13 - i11) / 2;
        if (this.mIsSameSide) {
            if (b10) {
                int width = getWidth() - getPaddingRight();
                while (i14 < childCount) {
                    View childAt = getChildAt(i14);
                    ActionMenuView.LayoutParams layoutParams = (ActionMenuView.LayoutParams) childAt.getLayoutParams();
                    if (childAt.getVisibility() != 8) {
                        int i18 = width - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i19 = i17 - (measuredHeight / 2);
                        childAt.layout(i18 - measuredWidth, i19, i18, measuredHeight + i19);
                        width = i18 - ((measuredWidth + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + this.mItemSpacing);
                    }
                    i14++;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            while (i14 < childCount) {
                View childAt2 = getChildAt(i14);
                ActionMenuView.LayoutParams layoutParams2 = (ActionMenuView.LayoutParams) childAt2.getLayoutParams();
                if (childAt2.getVisibility() != 8) {
                    int i20 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    int i21 = i17 - (measuredHeight2 / 2);
                    childAt2.layout(i20, i21, i20 + measuredWidth2, measuredHeight2 + i21);
                    paddingLeft = i20 + measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + this.mItemSpacing;
                }
                i14++;
            }
            return;
        }
        if (b10) {
            int paddingLeft2 = getPaddingLeft();
            boolean z11 = true;
            for (int i22 = childCount - 1; i22 >= 0; i22--) {
                View childAt3 = getChildAt(i22);
                ActionMenuView.LayoutParams layoutParams3 = (ActionMenuView.LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8) {
                    paddingLeft2 += ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                    if (z11) {
                        if ((childAt3 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt3).getText())) {
                            paddingLeft2 += this.mTextExtarPadding;
                        }
                        z11 = false;
                    }
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i23 = i17 - (measuredHeight3 / 2);
                    if (i22 == 0 && i15 > 1) {
                        int width2 = ((getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams3).rightMargin) - measuredWidth3;
                        if ((childAt3 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt3).getText())) {
                            width2 -= this.mMenuViewPadding;
                        }
                        childAt3.layout(width2, i23, measuredWidth3 + width2, measuredHeight3 + i23);
                    } else {
                        childAt3.layout(paddingLeft2, i23, paddingLeft2 + measuredWidth3, measuredHeight3 + i23);
                        paddingLeft2 += measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + this.mItemSpacing;
                    }
                }
            }
            return;
        }
        int width3 = getWidth() - getPaddingRight();
        boolean z12 = true;
        for (int i24 = childCount - 1; i24 >= 0; i24--) {
            View childAt4 = getChildAt(i24);
            ActionMenuView.LayoutParams layoutParams4 = (ActionMenuView.LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8) {
                width3 -= ((LinearLayout.LayoutParams) layoutParams4).rightMargin;
                if (z12) {
                    if ((childAt4 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt4).getText())) {
                        width3 -= this.mTextExtarPadding;
                    }
                    z12 = false;
                }
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i25 = i17 - (measuredHeight4 / 2);
                if (i24 == 0 && i15 > 1) {
                    int paddingLeft3 = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams4).leftMargin;
                    if ((childAt4 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt4).getText())) {
                        paddingLeft3 += this.mMenuViewPadding;
                    }
                    childAt4.layout(paddingLeft3, i25, measuredWidth4 + paddingLeft3, measuredHeight4 + i25);
                } else {
                    childAt4.layout(width3 - measuredWidth4, i25, width3, measuredHeight4 + i25);
                    width3 -= (measuredWidth4 + ((LinearLayout.LayoutParams) layoutParams4).leftMargin) + this.mItemSpacing;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        if (this.mMenu == null) {
            super.onMeasure(i10, i11);
            return;
        }
        this.mIsSameSide = true;
        if ((getParent() instanceof COUIToolbar) && ((COUIToolbar) getParent()).getIsTitleCenterStyle()) {
            this.mIsSameSide = false;
        }
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        if (K.v(this) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int size = View.MeasureSpec.getSize(i10);
        View.MeasureSpec.getSize(i11);
        resetItemMargin();
        int measureChild = measureChild(i10, i11);
        int i12 = 0;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getMeasuredHeight() > i12) {
                i12 = childAt.getMeasuredHeight();
            }
        }
        if (this.mIsSameSide) {
            int childCount = getChildCount();
            if (childCount > 0) {
                int i14 = 0;
                int i15 = -1;
                for (int i16 = 0; i16 < childCount; i16++) {
                    if (getChildAt(i16).getVisibility() != 8) {
                        i14++;
                        i15 = i16;
                    }
                }
                int i17 = measureChild + ((i14 - 1) * this.mItemSpacing);
                if (i15 != -1) {
                    View childAt2 = getChildAt(i15);
                    if ((childAt2 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt2).getText())) {
                        i17 += this.mTextExtarPadding;
                    }
                }
                size = i17;
            } else {
                size = 0;
            }
            if (z10) {
                setPadding(getPaddingLeft(), getPaddingTop(), 0, getPaddingBottom());
            }
        }
        setMeasuredDimension(size, i12);
    }

    public void refresh() {
        COUIPopupListWindow cOUIPopupListWindow = this.mOverflowPopup;
        if (cOUIPopupListWindow != null) {
            cOUIPopupListWindow.refresh();
        }
        COUIMaskRippleDrawable cOUIMaskRippleDrawable = this.mMaskRippleDrawable;
        if (cOUIMaskRippleDrawable != null) {
            cOUIMaskRippleDrawable.refresh(getContext());
        }
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof COUIActionMenuItemView) {
                ((COUIActionMenuItemView) childAt).refresh();
            }
        }
    }

    public void setBlurMinAnimLevel(AnimLevel animLevel) {
        this.mBlurMinAnimLevel = animLevel;
    }

    @Deprecated
    public void setIsFixTitleFontSize(boolean z10) {
        this.mIsFixTitleFontSize = z10;
    }

    public void setMenuItemGap(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof COUIActionMenuItemView) {
                ((COUIActionMenuItemView) childAt).setItemWithGap(z10);
            }
        }
    }

    public void setOnSubMenuItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnSubMenuItemClickListener = onItemClickListener;
    }

    public void setOverflowMenuListener(OverflowMenuListener overflowMenuListener) {
        this.mOverflowMenuListener = overflowMenuListener;
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public void setOverflowReserved(boolean z10) {
        super.setOverflowReserved(z10);
        COUIPopupListWindow cOUIPopupListWindow = this.mOverflowPopup;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            if (this.mMenu.getNonActionItems().isEmpty()) {
                if (this.mOverflowPopup.getAdapter() instanceof BaseAdapter) {
                    ((BaseAdapter) this.mOverflowPopup.getAdapter()).notifyDataSetChanged();
                }
                this.mOverflowPopup.dismiss();
            } else {
                tryBuildOverflowMenu();
                if (this.mOverflowPopup.getAdapter() instanceof BaseAdapter) {
                    ((BaseAdapter) this.mOverflowPopup.getAdapter()).notifyDataSetChanged();
                }
            }
        }
    }

    public void setPopupWindowOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setRedDot(int i10, int i11) {
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder == null) {
            Log.e(TAG, "The MenuBuilder is null");
            return;
        }
        menuBuilder.flagActionItems();
        MenuItemImpl menuItemImpl = (MenuItemImpl) this.mMenu.findItem(i10);
        if (menuItemImpl == null) {
            return;
        }
        int i12 = 1;
        int i13 = 0;
        if (i11 == -1) {
            if (this.mRedDotMap.containsKey(Integer.valueOf(i10))) {
                if (!menuItemImpl.isActionButton()) {
                    int i14 = this.mNonActionRedDotCount;
                    if (i14 == 0) {
                        i12 = 0;
                    }
                    this.mNonActionRedDotCount = i14 - i12;
                    Integer num = this.mRedDotMap.get(Integer.valueOf(i10));
                    int i15 = this.mNonActionRedDotSum;
                    if (num != null) {
                        i13 = num.intValue();
                    }
                    this.mNonActionRedDotSum = i15 - i13;
                }
                this.mRedDotMap.remove(Integer.valueOf(i10));
            }
        } else {
            if (!menuItemImpl.isActionButton()) {
                if (!this.mRedDotMap.containsKey(Integer.valueOf(i10))) {
                    this.mNonActionRedDotCount++;
                    this.mNonActionRedDotSum += i11;
                } else {
                    Integer num2 = this.mRedDotMap.get(Integer.valueOf(i10));
                    int i16 = this.mNonActionRedDotSum + i11;
                    if (num2 != null) {
                        i13 = num2.intValue();
                    }
                    this.mNonActionRedDotSum = i16 - i13;
                }
            }
            this.mRedDotMap.put(Integer.valueOf(i10), Integer.valueOf(i11));
        }
        CharSequence title = menuItemImpl.getTitle();
        if (i11 != -1) {
            title = ((Object) title) + "," + setRedDotDescription(i11);
        }
        menuItemImpl.setContentDescription(title);
        postInvalidate();
    }

    @Deprecated
    public void setSubMenuClickListener(COUISubMenuClickListener cOUISubMenuClickListener) {
        this.mOnSubMenuItemClickListener = cOUISubMenuClickListener;
    }

    public void setUseBackgroundBlur(boolean z10) {
        this.mUseBackgroundBlur = z10;
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public boolean showOverflowMenu() {
        View view;
        Activity contextToActivity = UIUtil.contextToActivity(getContext());
        if ((contextToActivity != null && (contextToActivity.isFinishing() || contextToActivity.isDestroyed())) || this.mOverflowPopup == null || (view = this.mOverFlowMenuButton) == null || view.getParent() == null) {
            return false;
        }
        tryBuildOverflowMenu();
        post(this.mOpenOverflowRunnable);
        return true;
    }

    public COUIActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOpenOverflowRunnable = new OpenOverflowRunnable();
        this.mMenu = null;
        this.mPresenterClasses = new ArrayList();
        this.mIsSameSide = true;
        this.mMenuViewPadding = 0;
        this.mSubMenuList = null;
        this.mSubPosition = -1;
        this.mEnableAddExtraWidth = true;
        this.mOverflowMenuListener = null;
        this.mUseBackgroundBlur = false;
        this.mBlurMinAnimLevel = UIUtil.ANIM_LEVEL_SUPPORT_BLUR_MIN;
        this.mOverFlowMinWidth = getResources().getDimensionPixelSize(f.f4723k);
        this.mOverFlowHorPadding = getResources().getDimensionPixelSize(f.f4502F5);
        this.mEdgeIconItemMargin = getResources().getDimensionPixelSize(f.f4628X5);
        this.mIconItemHorOffset = getResources().getDimensionPixelSize(f.f4635Y5);
        this.mItemVerOffset = getResources().getDimensionPixelSize(f.f4642Z5);
        this.mItemSpacing = getResources().getDimensionPixelSize(f.f4739m);
        this.mRedDotMap = new HashMap<>();
        this.mRedDotHorizontalOffset = getResources().getDimensionPixelSize(f.f4753n5);
        this.mRedDotVerticalOffset = getResources().getDimensionPixelSize(f.f4761o5);
        this.mRedDotWithNumberVerticalOffset = getResources().getDimensionPixelSize(f.f4785r5);
        this.mRedDotWithNumberHorizontalOffset = getResources().getDimensionPixelSize(f.f4777q5);
        this.mRedDotWithSmallNumberHorizontalOffset = getResources().getDimensionPixelSize(f.f4793s5);
        this.mRedDotWithBigNumberHorizontalOffset = getResources().getDimensionPixelSize(f.f4769p5);
        this.mMenuIconTopPadding = getResources().getDimensionPixelSize(f.f4745m5);
        this.mHintRedDotHelper = new COUIHintRedDotHelper(getContext(), null, o.f5225V1, 0, n.f5047s);
        this.mOverFlowButtonDescription = getResources().getString(h.f30262b);
        this.mRedDotDescription = getResources().getString(m.f4992B);
        this.mRedDotWithNumberDescriptionId = k.f4988a;
        this.mMenuIconBgRadius = getResources().getDimensionPixelSize(f.f4737l5);
        this.mTextMenuItemMaxWidth = context.getResources().getDimensionPixelSize(f.f4715j);
        this.mToolbarTitleMinWidth = context.getResources().getDimensionPixelSize(f.f4821w5);
        this.mTextMenuItemHorizontalPadding = context.getResources().getDimensionPixelSize(f.f4807u5);
    }

    public void dismissPopupMenus(boolean z10) {
        COUIPopupListWindow cOUIPopupListWindow = this.mOverflowPopup;
        if (cOUIPopupListWindow != null) {
            if (z10) {
                cOUIPopupListWindow.dismiss();
            } else {
                cOUIPopupListWindow.superDismiss();
            }
        }
    }

    @Deprecated
    public void setEnableAddExtraWidth(boolean z10) {
    }

    @Deprecated
    public void setItemSpecialColor(int i10, int i11) {
    }

    @Deprecated
    public void setSubItemSpecialColor(int i10, int i11) {
    }

    @Deprecated
    public void setSubMenuList(ArrayList<PopupListItem> arrayList, int i10) {
    }
}
