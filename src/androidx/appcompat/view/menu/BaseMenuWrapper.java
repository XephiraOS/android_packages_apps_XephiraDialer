package androidx.appcompat.view.menu;

import D.b;
import D.c;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import p.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class BaseMenuWrapper {
    final Context mContext;
    private i<b, MenuItem> mMenuItems;
    private i<c, SubMenu> mSubMenus;

    public BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (menuItem instanceof b) {
            b bVar = (b) menuItem;
            if (this.mMenuItems == null) {
                this.mMenuItems = new i<>();
            }
            MenuItem menuItem2 = this.mMenuItems.get(bVar);
            if (menuItem2 == null) {
                MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.mContext, bVar);
                this.mMenuItems.put(bVar, menuItemWrapperICS);
                return menuItemWrapperICS;
            }
            return menuItem2;
        }
        return menuItem;
    }

    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        if (subMenu instanceof c) {
            c cVar = (c) subMenu;
            if (this.mSubMenus == null) {
                this.mSubMenus = new i<>();
            }
            SubMenu subMenu2 = this.mSubMenus.get(cVar);
            if (subMenu2 == null) {
                SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.mContext, cVar);
                this.mSubMenus.put(cVar, subMenuWrapperICS);
                return subMenuWrapperICS;
            }
            return subMenu2;
        }
        return subMenu;
    }

    public final void internalClear() {
        i<b, MenuItem> iVar = this.mMenuItems;
        if (iVar != null) {
            iVar.clear();
        }
        i<c, SubMenu> iVar2 = this.mSubMenus;
        if (iVar2 != null) {
            iVar2.clear();
        }
    }

    public final void internalRemoveGroup(int i10) {
        if (this.mMenuItems == null) {
            return;
        }
        int i11 = 0;
        while (i11 < this.mMenuItems.size()) {
            if (this.mMenuItems.h(i11).getGroupId() == i10) {
                this.mMenuItems.j(i11);
                i11--;
            }
            i11++;
        }
    }

    public final void internalRemoveItem(int i10) {
        if (this.mMenuItems == null) {
            return;
        }
        for (int i11 = 0; i11 < this.mMenuItems.size(); i11++) {
            if (this.mMenuItems.h(i11).getItemId() == i10) {
                this.mMenuItems.j(i11);
                return;
            }
        }
    }
}
