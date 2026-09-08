package com.coui.appcompat.navigationrail;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.google.android.material.navigation.c;
import com.google.android.material.navigationrail.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class COUINavigationRailMenuView extends b {
    public COUINavigationRailMenuView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.coui.appcompat.navigationrail.COUINavigationRailMenuView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return true;
            }
        });
    }

    @Override // com.google.android.material.navigationrail.b, com.google.android.material.navigation.e
    public c createNavigationBarItemView(Context context) {
        return new COUINavigationRailItemView(context);
    }

    public MenuItemImpl getVisibleItem(int i10) {
        return getMenu().getVisibleItems().get(i10);
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        return getMenu().getVisibleItems();
    }

    public void refresh() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof COUINavigationRailItemView) {
                ((COUINavigationRailItemView) childAt).refresh();
            }
        }
    }
}
