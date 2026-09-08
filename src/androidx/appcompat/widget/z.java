package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* compiled from: MenuPopupWindow.java */
/* loaded from: classes.dex */
public class z extends ListPopupWindow implements y {

    /* renamed from: L, reason: collision with root package name */
    public y f7944L;

    /* compiled from: MenuPopupWindow.java */
    /* loaded from: classes.dex */
    public static class a {
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    /* loaded from: classes.dex */
    public static class b {
        public static void a(PopupWindow popupWindow, boolean z10) {
            popupWindow.setTouchModal(z10);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    /* loaded from: classes.dex */
    public static class c extends v {

        /* renamed from: n, reason: collision with root package name */
        public final int f7945n;

        /* renamed from: o, reason: collision with root package name */
        public final int f7946o;

        /* renamed from: p, reason: collision with root package name */
        public y f7947p;

        /* renamed from: q, reason: collision with root package name */
        public MenuItem f7948q;

        public c(Context context, boolean z10) {
            super(context, z10);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f7945n = 21;
                this.f7946o = 22;
            } else {
                this.f7945n = 22;
                this.f7946o = 21;
            }
        }

        @Override // androidx.appcompat.widget.v
        public /* bridge */ /* synthetic */ int d(int i10, int i11, int i12, int i13, int i14) {
            return super.d(i10, i11, i12, i13, i14);
        }

        @Override // androidx.appcompat.widget.v
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i10) {
            return super.e(motionEvent, i10);
        }

        @Override // androidx.appcompat.widget.v, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.v, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.v, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.v, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.v, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            MenuAdapter menuAdapter;
            int i10;
            MenuItemImpl menuItemImpl;
            int pointToPosition;
            int i11;
            if (this.f7947p != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i10 = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    i10 = 0;
                }
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i11 = pointToPosition - i10) >= 0 && i11 < menuAdapter.getCount()) {
                    menuItemImpl = menuAdapter.getItem(i11);
                } else {
                    menuItemImpl = null;
                }
                MenuItem menuItem = this.f7948q;
                if (menuItem != menuItemImpl) {
                    MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                    if (menuItem != null) {
                        this.f7947p.onItemHoverExit(adapterMenu, menuItem);
                    }
                    this.f7948q = menuItemImpl;
                    if (menuItemImpl != null) {
                        this.f7947p.onItemHoverEnter(adapterMenu, menuItemImpl);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            MenuAdapter menuAdapter;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f7945n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i10 == this.f7946o) {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    menuAdapter = (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                }
                menuAdapter.getAdapterMenu().close(false);
                return true;
            }
            return super.onKeyDown(i10, keyEvent);
        }

        @Override // androidx.appcompat.widget.v, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(y yVar) {
            this.f7947p = yVar;
        }

        @Override // androidx.appcompat.widget.v, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    public z(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public void O(Object obj) {
        a.a(this.f7738K, (Transition) obj);
    }

    public void P(Object obj) {
        a.b(this.f7738K, (Transition) obj);
    }

    public void Q(y yVar) {
        this.f7944L = yVar;
    }

    public void R(boolean z10) {
        b.a(this.f7738K, z10);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    public v n(Context context, boolean z10) {
        c cVar = new c(context, z10);
        cVar.setHoverListener(this);
        return cVar;
    }

    @Override // androidx.appcompat.widget.y
    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        y yVar = this.f7944L;
        if (yVar != null) {
            yVar.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.y
    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        y yVar = this.f7944L;
        if (yVar != null) {
            yVar.onItemHoverExit(menuBuilder, menuItem);
        }
    }
}
