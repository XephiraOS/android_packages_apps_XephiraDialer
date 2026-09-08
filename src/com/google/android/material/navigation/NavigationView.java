package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.K;
import androidx.core.view.C0455j;
import androidx.core.view.X;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.WindowUtils;
import e.C0961a;
import e4.C0977c;
import e4.l;
import e4.m;
import f.C0991a;
import f4.C1001b;
import h4.C1079a;
import j.C1150g;
import java.util.Objects;
import s4.C1544c;
import s4.C1549h;
import s4.InterfaceC1543b;
import u4.C1607c;
import x4.i;
import x4.j;
import x4.n;
import x4.s;

/* loaded from: classes3.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements InterfaceC1543b {

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f23478p = {R.attr.state_checked};

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f23479q = {-16842910};

    /* renamed from: r, reason: collision with root package name */
    public static final int f23480r = l.f31031n;

    /* renamed from: a, reason: collision with root package name */
    public final NavigationMenu f23481a;

    /* renamed from: b, reason: collision with root package name */
    public final NavigationMenuPresenter f23482b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23483c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f23484d;

    /* renamed from: e, reason: collision with root package name */
    public MenuInflater f23485e;

    /* renamed from: f, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f23486f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f23487g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f23488h;

    /* renamed from: i, reason: collision with root package name */
    public int f23489i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f23490j;

    /* renamed from: k, reason: collision with root package name */
    public final int f23491k;

    /* renamed from: l, reason: collision with root package name */
    public final s f23492l;

    /* renamed from: m, reason: collision with root package name */
    public final C1549h f23493m;

    /* renamed from: n, reason: collision with root package name */
    public final C1544c f23494n;

    /* renamed from: o, reason: collision with root package name */
    public final DrawerLayout.DrawerListener f23495o;

    /* loaded from: classes3.dex */
    public class a extends DrawerLayout.SimpleDrawerListener {
        public a() {
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                navigationView.f23494n.f();
                NavigationView.this.o();
            }
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.SimpleDrawerListener, androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view) {
            NavigationView navigationView = NavigationView.this;
            if (view == navigationView) {
                final C1544c c1544c = navigationView.f23494n;
                Objects.requireNonNull(c1544c);
                view.post(new Runnable() { // from class: com.google.android.material.navigation.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        C1544c.this.e();
                    }
                });
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            boolean z15;
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f23484d);
            boolean z16 = true;
            if (NavigationView.this.f23484d[1] == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            NavigationView.this.f23482b.setBehindStatusBar(z10);
            NavigationView navigationView2 = NavigationView.this;
            if (z10 && navigationView2.m()) {
                z11 = true;
            } else {
                z11 = false;
            }
            navigationView2.setDrawTopInsetForeground(z11);
            if (NavigationView.this.f23484d[0] != 0 && NavigationView.this.f23484d[0] + NavigationView.this.getWidth() != 0) {
                z12 = false;
            } else {
                z12 = true;
            }
            NavigationView.this.setDrawLeftInsetForeground(z12);
            Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
            if (activity != null) {
                Rect currentWindowBounds = WindowUtils.getCurrentWindowBounds(activity);
                if (currentWindowBounds.height() - NavigationView.this.getHeight() == NavigationView.this.f23484d[1]) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                NavigationView navigationView3 = NavigationView.this;
                if (z13 && z14 && navigationView3.l()) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                navigationView3.setDrawBottomInsetForeground(z15);
                if (currentWindowBounds.width() != NavigationView.this.f23484d[0] && currentWindowBounds.width() - NavigationView.this.getWidth() != NavigationView.this.f23484d[0]) {
                    z16 = false;
                }
                NavigationView.this.setDrawRightInsetForeground(z16);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30674j0);
    }

    private ColorStateList f(int i10) {
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
        int[] iArr = f23479q;
        return new ColorStateList(new int[][]{iArr, f23478p, FrameLayout.EMPTY_STATE_SET}, new int[]{a10.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.f23485e == null) {
            this.f23485e = new C1150g(getContext());
        }
        return this.f23485e;
    }

    @Override // s4.InterfaceC1543b
    public void cancelBackProgress() {
        q();
        this.f23493m.f();
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f23492l.e(canvas, new C1079a.InterfaceC0303a() { // from class: com.google.android.material.navigation.f
            @Override // h4.C1079a.InterfaceC0303a
            public final void a(Canvas canvas2) {
                NavigationView.this.n(canvas2);
            }
        });
    }

    public final Drawable g(K k10) {
        return h(k10, C1607c.b(getContext(), k10, m.f31162K7));
    }

    public C1549h getBackHelper() {
        return this.f23493m;
    }

    public MenuItem getCheckedItem() {
        return this.f23482b.getCheckedItem();
    }

    public int getDividerInsetEnd() {
        return this.f23482b.getDividerInsetEnd();
    }

    public int getDividerInsetStart() {
        return this.f23482b.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.f23482b.getHeaderCount();
    }

    public Drawable getItemBackground() {
        return this.f23482b.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.f23482b.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.f23482b.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.f23482b.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.f23482b.getItemMaxLines();
    }

    public ColorStateList getItemTextColor() {
        return this.f23482b.getItemTextColor();
    }

    public int getItemVerticalPadding() {
        return this.f23482b.getItemVerticalPadding();
    }

    public Menu getMenu() {
        return this.f23481a;
    }

    public int getSubheaderInsetEnd() {
        return this.f23482b.getSubheaderInsetEnd();
    }

    public int getSubheaderInsetStart() {
        return this.f23482b.getSubheaderInsetStart();
    }

    public final Drawable h(K k10, ColorStateList colorStateList) {
        i iVar = new i(n.b(getContext(), k10.n(m.f31140I7, 0), k10.n(m.f31151J7, 0)).m());
        iVar.setFillColor(colorStateList);
        return new InsetDrawable((Drawable) iVar, k10.f(m.f31195N7, 0), k10.f(m.f31206O7, 0), k10.f(m.f31184M7, 0), k10.f(m.f31173L7, 0));
    }

    @Override // s4.InterfaceC1543b
    public void handleBackInvoked() {
        Pair<DrawerLayout, DrawerLayout.LayoutParams> q10 = q();
        DrawerLayout drawerLayout = (DrawerLayout) q10.first;
        androidx.activity.b c10 = this.f23493m.c();
        if (c10 != null) {
            this.f23493m.h(c10, ((DrawerLayout.LayoutParams) q10.second).gravity, com.google.android.material.navigation.b.b(drawerLayout, this), com.google.android.material.navigation.b.c(drawerLayout));
            return;
        }
        drawerLayout.closeDrawer(this);
    }

    public final boolean i(K k10) {
        if (!k10.s(m.f31140I7) && !k10.s(m.f31151J7)) {
            return false;
        }
        return true;
    }

    public View j(int i10) {
        return this.f23482b.inflateHeaderView(i10);
    }

    public void k(int i10) {
        this.f23482b.setUpdateSuspended(true);
        getMenuInflater().inflate(i10, this.f23481a);
        this.f23482b.setUpdateSuspended(false);
        this.f23482b.updateMenuView(false);
    }

    public boolean l() {
        return this.f23488h;
    }

    public boolean m() {
        return this.f23487g;
    }

    public final /* synthetic */ void n(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public final void o() {
        if (this.f23490j && this.f23489i != 0) {
            this.f23489i = 0;
            p(getWidth(), getHeight());
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.f23494n.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.removeDrawerListener(this.f23495o);
            drawerLayout.addDrawerListener(this.f23495o);
            if (drawerLayout.isDrawerOpen(this)) {
                this.f23494n.e();
            }
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f23486f);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).removeDrawerListener(this.f23495o);
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void onInsetsChanged(X x10) {
        this.f23482b.dispatchApplyWindowInsets(x10);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i10 = View.MeasureSpec.makeMeasureSpec(this.f23483c, 1073741824);
            }
        } else {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), this.f23483c), 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f23481a.restorePresenterStates(savedState.f23496a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f23496a = bundle;
        this.f23481a.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        p(i10, i11);
    }

    public final void p(int i10, int i11) {
        boolean z10;
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.LayoutParams)) {
            if ((this.f23489i > 0 || this.f23490j) && (getBackground() instanceof i)) {
                if (C0455j.b(((DrawerLayout.LayoutParams) getLayoutParams()).gravity, androidx.core.view.K.v(this)) == 3) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                i iVar = (i) getBackground();
                n.b o10 = iVar.getShapeAppearanceModel().v().o(this.f23489i);
                if (z10) {
                    o10.H(0.0f);
                    o10.w(0.0f);
                } else {
                    o10.M(0.0f);
                    o10.B(0.0f);
                }
                n m10 = o10.m();
                iVar.setShapeAppearanceModel(m10);
                this.f23492l.g(this, m10);
                this.f23492l.f(this, new RectF(0.0f, 0.0f, i10, i11));
                this.f23492l.i(this, true);
            }
        }
    }

    public final Pair<DrawerLayout, DrawerLayout.LayoutParams> q() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.LayoutParams)) {
            return new Pair<>((DrawerLayout) parent, (DrawerLayout.LayoutParams) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    public final void r() {
        this.f23486f = new c();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f23486f);
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.f23488h = z10;
    }

    public void setCheckedItem(int i10) {
        MenuItem findItem = this.f23481a.findItem(i10);
        if (findItem != null) {
            this.f23482b.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    public void setDividerInsetEnd(int i10) {
        this.f23482b.setDividerInsetEnd(i10);
    }

    public void setDividerInsetStart(int i10) {
        this.f23482b.setDividerInsetStart(i10);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        j.d(this, f10);
    }

    public void setForceCompatClippingEnabled(boolean z10) {
        this.f23492l.h(this, z10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f23482b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        setItemBackground(androidx.core.content.b.e(getContext(), i10));
    }

    public void setItemHorizontalPadding(int i10) {
        this.f23482b.setItemHorizontalPadding(i10);
    }

    public void setItemHorizontalPaddingResource(int i10) {
        this.f23482b.setItemHorizontalPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconPadding(int i10) {
        this.f23482b.setItemIconPadding(i10);
    }

    public void setItemIconPaddingResource(int i10) {
        this.f23482b.setItemIconPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconSize(int i10) {
        this.f23482b.setItemIconSize(i10);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f23482b.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i10) {
        this.f23482b.setItemMaxLines(i10);
    }

    public void setItemTextAppearance(int i10) {
        this.f23482b.setItemTextAppearance(i10);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.f23482b.setItemTextAppearanceActiveBoldEnabled(z10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f23482b.setItemTextColor(colorStateList);
    }

    public void setItemVerticalPadding(int i10) {
        this.f23482b.setItemVerticalPadding(i10);
    }

    public void setItemVerticalPaddingResource(int i10) {
        this.f23482b.setItemVerticalPadding(getResources().getDimensionPixelSize(i10));
    }

    @Override // android.view.View
    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
        NavigationMenuPresenter navigationMenuPresenter = this.f23482b;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i10);
        }
    }

    public void setSubheaderInsetEnd(int i10) {
        this.f23482b.setSubheaderInsetEnd(i10);
    }

    public void setSubheaderInsetStart(int i10) {
        this.f23482b.setSubheaderInsetStart(i10);
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.f23487g = z10;
    }

    @Override // s4.InterfaceC1543b
    public void startBackProgress(androidx.activity.b bVar) {
        q();
        this.f23493m.j(bVar);
    }

    @Override // s4.InterfaceC1543b
    public void updateBackProgress(androidx.activity.b bVar) {
        this.f23493m.l(bVar, ((DrawerLayout.LayoutParams) q().second).gravity);
        if (this.f23490j) {
            this.f23489i = C1001b.c(0, this.f23491k, this.f23493m.a(bVar.a()));
            p(getWidth(), getHeight());
        }
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public Bundle f23496a;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f23496a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f23496a);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationView(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f23481a.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f23482b.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    /* loaded from: classes3.dex */
    public class b implements MenuBuilder.Callback {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            NavigationView.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    public void setNavigationItemSelectedListener(d dVar) {
    }
}
