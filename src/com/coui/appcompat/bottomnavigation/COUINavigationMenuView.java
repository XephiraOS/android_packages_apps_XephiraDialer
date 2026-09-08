package com.coui.appcompat.bottomnavigation;

import Y8.d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.google.android.material.navigation.c;
import g4.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUINavigationMenuView extends b {
    protected static final long ACTIVE_ANIMATION_DURATION_MS = 100;
    public static final int MAX_ITEM_COUNT = 10;
    public static final int MAX_ITEM_COUNT_LARGE = 7;
    public static final int MAX_ITEM_COUNT_MEDIUM = 6;
    public static final int MAX_ITEM_COUNT_SMALL = 5;
    private COUINavigationItemView mCOUINavigationItemView;
    private int mDefaultPadding;
    private int mEnlargeIndex;
    private int mItemHeight;
    private int mLayoutType;
    private int[] mTempChildWidths;
    private int mTextSize;

    public COUINavigationMenuView(Context context) {
        super(context);
        this.mEnlargeIndex = -1;
        this.mDefaultPadding = getResources().getDimensionPixelSize(d.f5646f0);
        setClipChildren(false);
        setClipToPadding(false);
        this.mTempChildWidths = new int[10];
    }

    private void setLayoutPadding() {
        if (this.mLayoutType == 1) {
            this.mDefaultPadding = getResources().getDimensionPixelSize(d.f5644e0);
            this.mItemHeight = getResources().getDimensionPixelSize(d.f5648g0);
        } else {
            this.mDefaultPadding = getResources().getDimensionPixelSize(d.f5646f0);
            this.mItemHeight = getResources().getDimensionPixelSize(d.f5650h0);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.coui.appcompat.bottomnavigation.COUINavigationMenuView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return true;
            }
        });
    }

    public void clearColorFilter() {
        for (int i10 = 0; i10 < getMenu().size(); i10++) {
            ((COUINavigationItemView) findItemView(getMenu().getItem(i10).getItemId())).clearColorFilter();
        }
    }

    @Override // g4.b, com.google.android.material.navigation.e
    public c createNavigationBarItemView(Context context) {
        COUINavigationItemView cOUINavigationItemView = new COUINavigationItemView(context);
        this.mCOUINavigationItemView = cOUINavigationItemView;
        return cOUINavigationItemView;
    }

    public COUINavigationItemView getCOUINavigationItemView() {
        return this.mCOUINavigationItemView;
    }

    public int getEnlargeId() {
        int i10 = this.mEnlargeIndex;
        if (i10 == -1) {
            return i10;
        }
        return getMenu().getVisibleItems().get(this.mEnlargeIndex).getItemId();
    }

    public MenuItemImpl getVisibleItem(int i10) {
        return getMenu().getVisibleItems().get(i10);
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        return getMenu().getVisibleItems();
    }

    public void initEnlargeParams() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.gravity = 81;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setLayoutPadding();
    }

    @Override // g4.b, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int size = View.MeasureSpec.getSize(i10) - (this.mDefaultPadding * 2);
        int size2 = getMenu().getVisibleItems().size();
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f5650h0);
        this.mItemHeight = dimensionPixelSize;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824);
        if (size2 == 0) {
            i12 = 1;
        } else {
            i12 = size2;
        }
        int i13 = size / i12;
        int i14 = size - (i13 * size2);
        for (int i15 = 0; i15 < size2; i15++) {
            int[] iArr = this.mTempChildWidths;
            iArr[i15] = i13;
            if (i14 > 0) {
                iArr[i15] = i13 + 1;
                i14--;
            }
        }
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < getChildCount(); i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.mTempChildWidths[i17], 1073741824), makeMeasureSpec);
                childAt.getLayoutParams().width = childAt.getMeasuredWidth();
                i16 += childAt.getMeasuredWidth();
                i17++;
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i16, View.MeasureSpec.makeMeasureSpec(i16, 1073741824), 0), View.resolveSizeAndState(this.mItemHeight, makeMeasureSpec, 0));
    }

    public void setEnlarge(boolean z10, int i10) {
        boolean z11;
        this.mEnlargeIndex = i10;
        if (z10 && i10 >= 0) {
            for (int i11 = 0; i11 < getMenu().getVisibleItems().size(); i11++) {
                c findItemView = findItemView(getMenu().getVisibleItems().get(i11).getItemId());
                if (findItemView instanceof COUINavigationItemView) {
                    COUINavigationItemView cOUINavigationItemView = (COUINavigationItemView) findItemView;
                    if (i11 == this.mEnlargeIndex) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    cOUINavigationItemView.setEnlarge(true, z11);
                }
            }
        }
    }

    public void setItemForEnlargeColor() {
        for (int i10 = 0; i10 < getMenu().size(); i10++) {
            c findItemView = findItemView(getMenu().getItem(i10).getItemId());
            findItemView.setTextColor(ColorStateList.valueOf(androidx.core.content.b.c(getContext(), Y8.c.f5608d)));
            if (findItemView instanceof COUINavigationItemView) {
                ((COUINavigationItemView) findItemView).setIconTintForWhite();
            }
        }
    }

    public void setItemLayoutType(int i10) {
        this.mLayoutType = i10;
        setLayoutPadding();
        for (int i11 = 0; i11 < getMenu().size(); i11++) {
            c findItemView = findItemView(getMenu().getItem(i11).getItemId());
            if (findItemView instanceof COUINavigationItemView) {
                ((COUINavigationItemView) findItemView).childLayout(this.mLayoutType);
            }
        }
    }

    public void setShowPressShadow(boolean z10) {
        for (int i10 = 0; i10 < getMenu().size(); i10++) {
            c findItemView = findItemView(getMenu().getItem(i10).getItemId());
            if (findItemView instanceof COUINavigationItemView) {
                ((COUINavigationItemView) findItemView).setShowPressShadow(z10);
            }
        }
    }

    public void setTextSize(int i10) {
        this.mTextSize = i10;
        if (getMenu() != null) {
            for (int i11 = 0; i11 < getMenu().size(); i11++) {
                c findItemView = findItemView(getMenu().getItem(i11).getItemId());
                if (findItemView instanceof COUINavigationItemView) {
                    ((COUINavigationItemView) findItemView).setTextSize(this.mTextSize);
                }
            }
        }
    }
}
