package com.google.android.material.navigation;

import J.d;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.view.K;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import androidx.transition.y;
import com.google.android.material.internal.TextScale;
import e.C0961a;
import e4.C0977c;
import e4.h;
import f.C0991a;
import f4.C1001b;
import java.util.HashSet;
import s4.C1550i;
import x4.i;
import x4.n;

/* compiled from: NavigationBarMenuView.java */
/* loaded from: classes3.dex */
public abstract class e extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;
    private final SparseArray<com.google.android.material.badge.a> badgeDrawables;
    private c[] buttons;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorLabelPadding;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable;
    private n itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private final I.e<c> itemPool;
    private ColorStateList itemRippleColor;
    private int itemTextAppearanceActive;
    private boolean itemTextAppearanceActiveBoldEnabled;
    private int itemTextAppearanceInactive;
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;
    private final View.OnClickListener onClickListener;
    private final SparseArray<View.OnTouchListener> onTouchListeners;
    private NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;
    private final TransitionSet set;

    /* compiled from: NavigationBarMenuView.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((c) view).getItemData();
            if (!e.this.menu.performItemAction(itemData, e.this.presenter, 0)) {
                itemData.setChecked(true);
            }
        }
    }

    public e(Context context) {
        super(context);
        this.itemPool = new I.g(5);
        this.onTouchListeners = new SparseArray<>(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray<>(5);
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorLabelPadding = -1;
        this.itemActiveIndicatorResizeable = false;
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.set = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.set = autoTransition;
            autoTransition.r(0);
            autoTransition.setDuration(C1550i.f(getContext(), C0977c.f30651W, getResources().getInteger(h.f30913b)));
            autoTransition.setInterpolator(C1550i.g(getContext(), C0977c.f30666f0, C1001b.f31703b));
            autoTransition.f(new TextScale());
        }
        this.onClickListener = new a();
        K.t0(this, 1);
    }

    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance != null && this.itemActiveIndicatorColor != null) {
            i iVar = new i(this.itemActiveIndicatorShapeAppearance);
            iVar.setFillColor(this.itemActiveIndicatorColor);
            return iVar;
        }
        return null;
    }

    private c getNewItem() {
        c b10 = this.itemPool.b();
        if (b10 == null) {
            return createNavigationBarItemView(getContext());
        }
        return b10;
    }

    private boolean isValidId(int i10) {
        if (i10 != -1) {
            return true;
        }
        return false;
    }

    private void removeUnusedBadges() {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.menu.size(); i10++) {
            hashSet.add(Integer.valueOf(this.menu.getItem(i10).getItemId()));
        }
        for (int i11 = 0; i11 < this.badgeDrawables.size(); i11++) {
            int keyAt = this.badgeDrawables.keyAt(i11);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.badgeDrawables.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(c cVar) {
        com.google.android.material.badge.a aVar;
        int id = cVar.getId();
        if (isValidId(id) && (aVar = this.badgeDrawables.get(id)) != null) {
            cVar.setBadge(aVar);
        }
    }

    private void validateMenuItemId(int i10) {
        if (isValidId(i10)) {
            return;
        }
        throw new IllegalArgumentException(i10 + " is not a valid view id");
    }

    public void buildMenuView() {
        removeAllViews();
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    this.itemPool.a(cVar);
                    cVar.clear();
                }
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        removeUnusedBadges();
        this.buttons = new c[this.menu.size()];
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i10 = 0; i10 < this.menu.size(); i10++) {
            this.presenter.c(true);
            this.menu.getItem(i10).setCheckable(true);
            this.presenter.c(false);
            c newItem = getNewItem();
            this.buttons[i10] = newItem;
            newItem.setIconTintList(this.itemIconTint);
            newItem.setIconSize(this.itemIconSize);
            newItem.setTextColor(this.itemTextColorDefault);
            newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
            newItem.setTextAppearanceActiveBoldEnabled(this.itemTextAppearanceActiveBoldEnabled);
            newItem.setTextColor(this.itemTextColorFromUser);
            int i11 = this.itemPaddingTop;
            if (i11 != -1) {
                newItem.setItemPaddingTop(i11);
            }
            int i12 = this.itemPaddingBottom;
            if (i12 != -1) {
                newItem.setItemPaddingBottom(i12);
            }
            int i13 = this.itemActiveIndicatorLabelPadding;
            if (i13 != -1) {
                newItem.setActiveIndicatorLabelPadding(i13);
            }
            newItem.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
            newItem.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
            newItem.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
            newItem.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            newItem.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
            newItem.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
            Drawable drawable = this.itemBackground;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.itemBackgroundRes);
            }
            newItem.setItemRippleColor(this.itemRippleColor);
            newItem.setShifting(isShifting);
            newItem.setLabelVisibilityMode(this.labelVisibilityMode);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.menu.getItem(i10);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i10);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.onTouchListeners.get(itemId));
            newItem.setOnClickListener(this.onClickListener);
            int i14 = this.selectedItemId;
            if (i14 != 0 && itemId == i14) {
                this.selectedItemPosition = i10;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = min;
        this.menu.getItem(min).setChecked(true);
    }

    public ColorStateList createDefaultColorStateList(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList a10 = C0991a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0961a.f30126y, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = a10.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{a10.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    public abstract c createNavigationBarItemView(Context context);

    public c findItemView(int i10) {
        validateMenuItemId(i10);
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar.getId() == i10) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.itemActiveIndicatorLabelPadding;
    }

    public com.google.android.material.badge.a getBadge(int i10) {
        return this.badgeDrawables.get(i10);
    }

    public SparseArray<com.google.android.material.badge.a> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    public n getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    public Drawable getItemBackground() {
        c[] cVarArr = this.buttons;
        if (cVarArr != null && cVarArr.length > 0) {
            return cVarArr[0].getBackground();
        }
        return this.itemBackground;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public MenuBuilder getMenu() {
        return this.menu;
    }

    public com.google.android.material.badge.a getOrCreateBadge(int i10) {
        validateMenuItemId(i10);
        com.google.android.material.badge.a aVar = this.badgeDrawables.get(i10);
        if (aVar == null) {
            aVar = com.google.android.material.badge.a.c(getContext());
            this.badgeDrawables.put(i10, aVar);
        }
        c findItemView = findItemView(i10);
        if (findItemView != null) {
            findItemView.setBadge(aVar);
        }
        return aVar;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    public boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    public boolean isShifting(int i10, int i11) {
        if (i10 == -1) {
            if (i11 <= 3) {
                return false;
            }
        } else if (i10 != 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        J.d.O0(accessibilityNodeInfo).j0(d.e.b(1, this.menu.getVisibleItems().size(), false, 1));
    }

    public void removeBadge(int i10) {
        validateMenuItemId(i10);
        c findItemView = findItemView(i10);
        if (findItemView != null) {
            findItemView.removeBadge();
        }
        this.badgeDrawables.put(i10, null);
    }

    public void restoreBadgeDrawables(SparseArray<com.google.android.material.badge.a> sparseArray) {
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int keyAt = sparseArray.keyAt(i10);
            if (this.badgeDrawables.indexOfKey(keyAt) < 0) {
                this.badgeDrawables.append(keyAt, sparseArray.get(keyAt));
            }
        }
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                com.google.android.material.badge.a aVar = this.badgeDrawables.get(cVar.getId());
                if (aVar != null) {
                    cVar.setBadge(aVar);
                }
            }
        }
    }

    public void setActiveIndicatorLabelPadding(int i10) {
        this.itemActiveIndicatorLabelPadding = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorLabelPadding(i10);
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.itemActiveIndicatorColor = colorStateList;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.itemActiveIndicatorEnabled = z10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorEnabled(z10);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.itemActiveIndicatorHeight = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorHeight(i10);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.itemActiveIndicatorMarginHorizontal = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorMarginHorizontal(i10);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z10) {
        this.itemActiveIndicatorResizeable = z10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorResizeable(z10);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(n nVar) {
        this.itemActiveIndicatorShapeAppearance = nVar;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.itemActiveIndicatorWidth = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setActiveIndicatorWidth(i10);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackground = drawable;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i10) {
        this.itemBackgroundRes = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemBackground(i10);
            }
        }
    }

    public void setItemIconSize(int i10) {
        this.itemIconSize = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setIconSize(i10);
            }
        }
    }

    public void setItemOnTouchListener(int i10, View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.onTouchListeners.remove(i10);
        } else {
            this.onTouchListeners.put(i10, onTouchListener);
        }
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar.getItemData().getItemId() == i10) {
                    cVar.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i10) {
        this.itemPaddingBottom = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemPaddingBottom(i10);
            }
        }
    }

    public void setItemPaddingTop(int i10) {
        this.itemPaddingTop = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemPaddingTop(i10);
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(int i10) {
        this.itemTextAppearanceActive = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setTextAppearanceActive(i10);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    cVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.itemTextAppearanceActiveBoldEnabled = z10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setTextAppearanceActiveBoldEnabled(z10);
            }
        }
    }

    public void setItemTextAppearanceInactive(int i10) {
        this.itemTextAppearanceInactive = i10;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setTextAppearanceInactive(i10);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    cVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        c[] cVarArr = this.buttons;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                cVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i10) {
        this.labelVisibilityMode = i10;
    }

    public void setPresenter(NavigationBarPresenter navigationBarPresenter) {
        this.presenter = navigationBarPresenter;
    }

    public void tryRestoreSelectedItemId(int i10) {
        int size = this.menu.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.menu.getItem(i11);
            if (i10 == item.getItemId()) {
                this.selectedItemId = i10;
                this.selectedItemPosition = i11;
                item.setChecked(true);
                return;
            }
        }
    }

    public void updateMenuView() {
        TransitionSet transitionSet;
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder != null && this.buttons != null) {
            int size = menuBuilder.size();
            if (size != this.buttons.length) {
                buildMenuView();
                return;
            }
            int i10 = this.selectedItemId;
            for (int i11 = 0; i11 < size; i11++) {
                MenuItem item = this.menu.getItem(i11);
                if (item.isChecked()) {
                    this.selectedItemId = item.getItemId();
                    this.selectedItemPosition = i11;
                }
            }
            if (i10 != this.selectedItemId && (transitionSet = this.set) != null) {
                y.a(this, transitionSet);
            }
            boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
            for (int i12 = 0; i12 < size; i12++) {
                this.presenter.c(true);
                this.buttons[i12].setLabelVisibilityMode(this.labelVisibilityMode);
                this.buttons[i12].setShifting(isShifting);
                this.buttons[i12].initialize((MenuItemImpl) this.menu.getItem(i12), 0);
                this.presenter.c(false);
            }
        }
    }
}
