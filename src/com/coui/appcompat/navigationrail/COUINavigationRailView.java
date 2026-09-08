package com.coui.appcompat.navigationrail;

import X8.c;
import Y8.d;
import Y8.e;
import Y8.h;
import Y8.i;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.K;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.google.android.material.navigationrail.NavigationRailView;
import com.google.android.material.navigationrail.b;
import e4.C0977c;

/* loaded from: classes.dex */
public class COUINavigationRailView extends NavigationRailView {
    private COUINavigationRailMenuView mCOUINavigationMenuView;
    private View mDividerView;

    public COUINavigationRailView(Context context) {
        this(context, null);
    }

    private void addCompatibilityEndDivider(Context context) {
        View view = new View(context);
        this.mDividerView = view;
        COUIDarkModeUtil.setForceDarkAllow(view, false);
        this.mDividerView.setBackgroundColor(COUIContextUtil.getAttrColor(context, c.f4400q));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getResources().getDimensionPixelSize(d.f5670z), -1);
        layoutParams.gravity = 8388613;
        this.mDividerView.setLayoutParams(layoutParams);
        addView(this.mDividerView);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public COUINavigationRailMenuView getCOUINavigationMenuView() {
        return this.mCOUINavigationMenuView;
    }

    public View getDividerView() {
        return this.mDividerView;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void inflateMenu(int i10) {
        if (getMenu().size() > 0) {
            getMenu().clear();
        }
        super.inflateMenu(i10);
    }

    @Override // com.google.android.material.navigationrail.NavigationRailView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int measuredHeight = getMeasuredHeight();
        int measuredHeight2 = this.mCOUINavigationMenuView.getMeasuredHeight();
        int i14 = (measuredHeight / 2) - (measuredHeight2 / 2);
        COUINavigationRailMenuView cOUINavigationRailMenuView = this.mCOUINavigationMenuView;
        cOUINavigationRailMenuView.layout(0, i14, cOUINavigationRailMenuView.getMeasuredWidth(), measuredHeight2 + i14);
    }

    public void refresh() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof COUINavigationRailMenuView) {
                ((COUINavigationRailMenuView) childAt).refresh();
            }
        }
    }

    public void setTipsView(int i10, int i11, int i12) {
        if (i10 >= this.mCOUINavigationMenuView.getVisibleItems().size()) {
            return;
        }
        setTipsView(i10, String.valueOf(i11), i12);
    }

    public void setTipsViewByItemId(int i10, int i11, int i12) {
        setTipsView((COUINavigationRailItemView) this.mCOUINavigationMenuView.findItemView(i10), String.valueOf(i11), i12);
    }

    public COUINavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30672i0);
    }

    @Override // com.google.android.material.navigationrail.NavigationRailView, com.google.android.material.navigation.NavigationBarView
    public b createNavigationBarMenuView(Context context) {
        return new COUINavigationRailMenuView(context);
    }

    public COUINavigationRailView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, h.f5691d);
    }

    public void setTipsView(int i10, String str, int i11) {
        if (i10 >= this.mCOUINavigationMenuView.getVisibleItems().size()) {
            return;
        }
        setTipsView((COUINavigationRailItemView) this.mCOUINavigationMenuView.findItemView(getCOUINavigationMenuView().getVisibleItem(i10).getItemId()), str, i11);
    }

    public void setTipsViewByItemId(int i10, String str, int i11) {
        setTipsView((COUINavigationRailItemView) this.mCOUINavigationMenuView.findItemView(i10), str, i11);
    }

    public COUINavigationRailView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        K w10 = K.w(context, attributeSet, i.f5732m, i10, i11);
        this.mCOUINavigationMenuView = (COUINavigationRailMenuView) getMenuView();
        if (w10.k(i.f5733n, 0) == 0) {
            setBackgroundResource(e.f5671a);
        }
        setElevation(0.0f);
        w10.y();
        addCompatibilityEndDivider(context);
    }

    private void setTipsView(COUINavigationRailItemView cOUINavigationRailItemView, String str, int i10) {
        if (cOUINavigationRailItemView != null) {
            if (i10 == 1) {
                cOUINavigationRailItemView.getCOUIHintRedDot().setVisibility(0);
                cOUINavigationRailItemView.getCOUIHintRedDot().setPointMode(1);
            } else {
                if (i10 != 2) {
                    cOUINavigationRailItemView.getCOUIHintRedDot().setVisibility(4);
                    return;
                }
                cOUINavigationRailItemView.getCOUIHintRedDot().setVisibility(0);
                if (isNumeric(str)) {
                    cOUINavigationRailItemView.getCOUIHintRedDot().setPointMode(2);
                    cOUINavigationRailItemView.getCOUIHintRedDot().setPointNumber(Integer.parseInt(str));
                } else {
                    cOUINavigationRailItemView.getCOUIHintRedDot().setPointMode(3);
                    cOUINavigationRailItemView.getCOUIHintRedDot().setPointText(str);
                }
            }
        }
    }
}
