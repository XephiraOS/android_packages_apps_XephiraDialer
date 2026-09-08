package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC0447b;
import e.C0961a;
import j.C1144a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ActionMenuPresenter extends BaseMenuPresenter implements AbstractC0447b.a {

    /* renamed from: a, reason: collision with root package name */
    public d f7527a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f7528b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7529c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7530d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7531e;

    /* renamed from: f, reason: collision with root package name */
    public int f7532f;

    /* renamed from: g, reason: collision with root package name */
    public int f7533g;

    /* renamed from: h, reason: collision with root package name */
    public int f7534h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7535i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7536j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7537k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7538l;

    /* renamed from: m, reason: collision with root package name */
    public int f7539m;

    /* renamed from: n, reason: collision with root package name */
    public final SparseBooleanArray f7540n;

    /* renamed from: o, reason: collision with root package name */
    public e f7541o;

    /* renamed from: p, reason: collision with root package name */
    public a f7542p;

    /* renamed from: q, reason: collision with root package name */
    public c f7543q;

    /* renamed from: r, reason: collision with root package name */
    public b f7544r;

    /* renamed from: x, reason: collision with root package name */
    public final f f7545x;

    /* renamed from: y, reason: collision with root package name */
    public int f7546y;

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f7547a;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f7547a);
        }

        public SavedState(Parcel parcel) {
            this.f7547a = parcel.readInt();
        }
    }

    /* loaded from: classes.dex */
    public class a extends MenuPopupHelper {
        public a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, C0961a.f30113l);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view2 = ActionMenuPresenter.this.f7527a;
                setAnchorView(view2 == null ? (View) ((BaseMenuPresenter) ActionMenuPresenter.this).mMenuView : view2);
            }
            setPresenterCallback(ActionMenuPresenter.this.f7545x);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f7542p = null;
            actionMenuPresenter.f7546y = 0;
            super.onDismiss();
        }
    }

    /* loaded from: classes.dex */
    public class b extends ActionMenuItemView.PopupCallback {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            a aVar = ActionMenuPresenter.this.f7542p;
            if (aVar != null) {
                return aVar.getPopup();
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public e f7550a;

        public c(e eVar) {
            this.f7550a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).mMenu != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).mMenu.changeMenuMode();
            }
            View view = (View) ((BaseMenuPresenter) ActionMenuPresenter.this).mMenuView;
            if (view != null && view.getWindowToken() != null && this.f7550a.tryShow()) {
                ActionMenuPresenter.this.f7541o = this.f7550a;
            }
            ActionMenuPresenter.this.f7543q = null;
        }
    }

    /* loaded from: classes.dex */
    public class d extends AppCompatImageView implements ActionMenuView.a {

        /* loaded from: classes.dex */
        public class a extends x {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ActionMenuPresenter f7553a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f7553a = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.x
            public ShowableListMenu getPopup() {
                e eVar = ActionMenuPresenter.this.f7541o;
                if (eVar == null) {
                    return null;
                }
                return eVar.getPopup();
            }

            @Override // androidx.appcompat.widget.x
            public boolean onForwardingStarted() {
                ActionMenuPresenter.this.u();
                return true;
            }

            @Override // androidx.appcompat.widget.x
            public boolean onForwardingStopped() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f7543q != null) {
                    return false;
                }
                actionMenuPresenter.l();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, C0961a.f30112k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            P.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.u();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* loaded from: classes.dex */
    public class e extends MenuPopupHelper {
        public e(Context context, MenuBuilder menuBuilder, View view, boolean z10) {
            super(context, menuBuilder, view, z10, C0961a.f30113l);
            setGravity(8388613);
            setPresenterCallback(ActionMenuPresenter.this.f7545x);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public void onDismiss() {
            if (((BaseMenuPresenter) ActionMenuPresenter.this).mMenu != null) {
                ((BaseMenuPresenter) ActionMenuPresenter.this).mMenu.close();
            }
            ActionMenuPresenter.this.f7541o = null;
            super.onDismiss();
        }
    }

    /* loaded from: classes.dex */
    public class f implements MenuPresenter.Callback {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == ((BaseMenuPresenter) ActionMenuPresenter.this).mMenu) {
                return false;
            }
            ActionMenuPresenter.this.f7546y = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = ActionMenuPresenter.this.getCallback();
            if (callback == null) {
                return false;
            }
            return callback.onOpenSubMenu(menuBuilder);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, e.g.f30242c, e.g.f30241b);
        this.f7540n = new SparseBooleanArray();
        this.f7545x = new f();
    }

    @Override // androidx.core.view.AbstractC0447b.a
    public void a(boolean z10) {
        if (z10) {
            super.onSubMenuSelected(null);
            return;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.f7544r == null) {
            this.f7544r = new b();
        }
        actionMenuItemView.setPopupCallback(this.f7544r);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f7527a) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ArrayList<MenuItemImpl> arrayList;
        int i10;
        int i11;
        int i12;
        boolean z10;
        int i13;
        boolean z11;
        boolean z12;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
        View view = null;
        ?? r32 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i14 = actionMenuPresenter.f7534h;
        int i15 = actionMenuPresenter.f7533g;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.mMenuView;
        boolean z13 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < i10; i18++) {
            MenuItemImpl menuItemImpl = arrayList.get(i18);
            if (menuItemImpl.requiresActionButton()) {
                i16++;
            } else if (menuItemImpl.requestsActionButton()) {
                i17++;
            } else {
                z13 = true;
            }
            if (actionMenuPresenter.f7538l && menuItemImpl.isActionViewExpanded()) {
                i14 = 0;
            }
        }
        if (actionMenuPresenter.f7530d && (z13 || i17 + i16 > i14)) {
            i14--;
        }
        int i19 = i14 - i16;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f7540n;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f7536j) {
            int i20 = actionMenuPresenter.f7539m;
            i12 = i15 / i20;
            i11 = i20 + ((i15 % i20) / i12);
        } else {
            i11 = 0;
            i12 = 0;
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < i10) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i21);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = actionMenuPresenter.getItemView(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.f7536j) {
                    i12 -= ActionMenuView.measureChildForCells(itemView, i11, i12, makeMeasureSpec, r32);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i22 == 0) {
                    i22 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                z10 = r32;
                i13 = i10;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z14 = sparseBooleanArray.get(groupId2);
                if ((i19 > 0 || z14) && i15 > 0 && (!actionMenuPresenter.f7536j || i12 > 0)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z15 = z11;
                i13 = i10;
                if (z11) {
                    View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                    if (actionMenuPresenter.f7536j) {
                        int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, i11, i12, makeMeasureSpec, 0);
                        i12 -= measureChildForCells;
                        if (measureChildForCells == 0) {
                            z15 = false;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z16 = z15;
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i22 == 0) {
                        i22 = measuredWidth2;
                    }
                    if (!actionMenuPresenter.f7536j ? i15 + i22 > 0 : i15 >= 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    z11 = z16 & z12;
                }
                if (z11 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z14) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i23 = 0; i23 < i21; i23++) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i23);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i19++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (z11) {
                    i19--;
                }
                menuItemImpl2.setIsActionButton(z11);
                z10 = false;
            } else {
                z10 = r32;
                i13 = i10;
                menuItemImpl2.setIsActionButton(z10);
            }
            i21++;
            r32 = z10;
            i10 = i13;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        int i10;
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        if (menuItemImpl.isActionViewExpanded()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        actionView.setVisibility(i10);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public boolean i() {
        return m() | l();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        C1144a b10 = C1144a.b(context);
        if (!this.f7531e) {
            this.f7530d = b10.h();
        }
        if (!this.f7537k) {
            this.f7532f = b10.c();
        }
        if (!this.f7535i) {
            this.f7534h = b10.d();
        }
        int i10 = this.f7532f;
        if (this.f7530d) {
            if (this.f7527a == null) {
                d dVar = new d(this.mSystemContext);
                this.f7527a = dVar;
                if (this.f7529c) {
                    dVar.setImageDrawable(this.f7528b);
                    this.f7528b = null;
                    this.f7529c = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f7527a.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f7527a.getMeasuredWidth();
        } else {
            this.f7527a = null;
        }
        this.f7533g = i10;
        this.f7539m = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View j(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable k() {
        d dVar = this.f7527a;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f7529c) {
            return this.f7528b;
        }
        return null;
    }

    public boolean l() {
        Object obj;
        c cVar = this.f7543q;
        if (cVar != null && (obj = this.mMenuView) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.f7543q = null;
            return true;
        }
        e eVar = this.f7541o;
        if (eVar != null) {
            eVar.dismiss();
            return true;
        }
        return false;
    }

    public boolean m() {
        a aVar = this.f7542p;
        if (aVar != null) {
            aVar.dismiss();
            return true;
        }
        return false;
    }

    public boolean n() {
        if (this.f7543q == null && !o()) {
            return false;
        }
        return true;
    }

    public boolean o() {
        e eVar = this.f7541o;
        if (eVar != null && eVar.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z10) {
        i();
        super.onCloseMenu(menuBuilder, z10);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i10 = ((SavedState) parcelable).f7547a) > 0 && (findItem = this.mMenu.findItem(i10)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f7547a = this.f7546y;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z10 = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View j10 = j(subMenuBuilder2.getItem());
        if (j10 == null) {
            return false;
        }
        this.f7546y = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.mContext, subMenuBuilder, j10);
        this.f7542p = aVar;
        aVar.setForceShowIcon(z10);
        this.f7542p.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void p(Configuration configuration) {
        if (!this.f7535i) {
            this.f7534h = C1144a.b(this.mContext).d();
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    public void q(boolean z10) {
        this.f7538l = z10;
    }

    public void r(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void s(Drawable drawable) {
        d dVar = this.f7527a;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f7529c = true;
            this.f7528b = drawable;
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int i10, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public void t(boolean z10) {
        this.f7530d = z10;
        this.f7531e = true;
    }

    public boolean u() {
        MenuBuilder menuBuilder;
        if (this.f7530d && !o() && (menuBuilder = this.mMenu) != null && this.mMenuView != null && this.f7543q == null && !menuBuilder.getNonActionItems().isEmpty()) {
            c cVar = new c(new e(this.mContext, this.mMenu, this.f7527a, true));
            this.f7543q = cVar;
            ((View) this.mMenuView).post(cVar);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z10) {
        ArrayList<MenuItemImpl> arrayList;
        int size;
        super.updateMenuView(z10);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size2 = actionItems.size();
            for (int i10 = 0; i10 < size2; i10++) {
                AbstractC0447b supportActionProvider = actionItems.get(i10).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.mMenu;
        if (menuBuilder2 != null) {
            arrayList = menuBuilder2.getNonActionItems();
        } else {
            arrayList = null;
        }
        if (this.f7530d && arrayList != null && ((size = arrayList.size()) != 1 ? size > 0 : (!arrayList.get(0).isActionViewExpanded()))) {
            if (this.f7527a == null) {
                this.f7527a = new d(this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.f7527a.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f7527a);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.f7527a, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            d dVar = this.f7527a;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.mMenuView;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f7527a);
                }
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.f7530d);
    }
}
