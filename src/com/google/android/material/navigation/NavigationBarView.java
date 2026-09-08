package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.K;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0979e;
import e4.m;
import j.C1150g;
import n4.C1370a;
import u4.C1607c;
import x4.i;
import x4.j;
import x4.n;

/* loaded from: classes3.dex */
public abstract class NavigationBarView extends FrameLayout {
    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;
    private final d menu;
    private MenuInflater menuInflater;
    private final e menuView;
    private final NavigationBarPresenter presenter;
    private b reselectedListener;
    private c selectedListener;

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public Bundle f23476a;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void b(Parcel parcel, ClassLoader classLoader) {
            this.f23476a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f23476a);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    /* loaded from: classes3.dex */
    public interface c {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public NavigationBarView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(B4.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.presenter = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = m.f31260T6;
        int i12 = m.f31402g7;
        int i13 = m.f31380e7;
        K obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, iArr, i10, i11, i12, i13);
        d dVar = new d(context2, getClass(), getMaxItemCount());
        this.menu = dVar;
        e createNavigationBarMenuView = createNavigationBarMenuView(context2);
        this.menuView = createNavigationBarMenuView;
        navigationBarPresenter.b(createNavigationBarMenuView);
        navigationBarPresenter.a(1);
        createNavigationBarMenuView.setPresenter(navigationBarPresenter);
        dVar.addMenuPresenter(navigationBarPresenter);
        navigationBarPresenter.initForMenu(getContext(), dVar);
        int i14 = m.f31336a7;
        if (obtainTintedStyledAttributes.s(i14)) {
            createNavigationBarMenuView.setIconTintList(obtainTintedStyledAttributes.c(i14));
        } else {
            createNavigationBarMenuView.setIconTintList(createNavigationBarMenuView.createDefaultColorStateList(R.attr.textColorSecondary));
        }
        setItemIconSize(obtainTintedStyledAttributes.f(m.f31325Z6, getResources().getDimensionPixelSize(C0979e.f30726B0)));
        if (obtainTintedStyledAttributes.s(i12)) {
            setItemTextAppearanceInactive(obtainTintedStyledAttributes.n(i12, 0));
        }
        if (obtainTintedStyledAttributes.s(i13)) {
            setItemTextAppearanceActive(obtainTintedStyledAttributes.n(i13, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(obtainTintedStyledAttributes.a(m.f31391f7, true));
        int i15 = m.f31413h7;
        if (obtainTintedStyledAttributes.s(i15)) {
            setItemTextColor(obtainTintedStyledAttributes.c(i15));
        }
        Drawable background = getBackground();
        ColorStateList g10 = C1370a.g(background);
        if (background == null || g10 != null) {
            i iVar = new i(n.e(context2, attributeSet, i10, i11).m());
            if (g10 != null) {
                iVar.setFillColor(g10);
            }
            iVar.initializeElevationOverlay(context2);
            androidx.core.view.K.n0(this, iVar);
        }
        int i16 = m.f31358c7;
        if (obtainTintedStyledAttributes.s(i16)) {
            setItemPaddingTop(obtainTintedStyledAttributes.f(i16, 0));
        }
        int i17 = m.f31347b7;
        if (obtainTintedStyledAttributes.s(i17)) {
            setItemPaddingBottom(obtainTintedStyledAttributes.f(i17, 0));
        }
        int i18 = m.f31271U6;
        if (obtainTintedStyledAttributes.s(i18)) {
            setActiveIndicatorLabelPadding(obtainTintedStyledAttributes.f(i18, 0));
        }
        if (obtainTintedStyledAttributes.s(m.f31293W6)) {
            setElevation(obtainTintedStyledAttributes.f(r10, 0));
        }
        C.a.o(getBackground().mutate(), C1607c.b(context2, obtainTintedStyledAttributes, m.f31282V6));
        setLabelVisibilityMode(obtainTintedStyledAttributes.l(m.f31424i7, -1));
        int n10 = obtainTintedStyledAttributes.n(m.f31315Y6, 0);
        if (n10 != 0) {
            createNavigationBarMenuView.setItemBackgroundRes(n10);
        } else {
            setItemRippleColor(C1607c.b(context2, obtainTintedStyledAttributes, m.f31369d7));
        }
        int n11 = obtainTintedStyledAttributes.n(m.f31304X6, 0);
        if (n11 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(n11, m.f31194N6);
            setItemActiveIndicatorWidth(obtainStyledAttributes.getDimensionPixelSize(m.f31216P6, 0));
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(m.f31205O6, 0));
            setItemActiveIndicatorMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(m.f31238R6, 0));
            setItemActiveIndicatorColor(C1607c.a(context2, obtainStyledAttributes, m.f31227Q6));
            setItemActiveIndicatorShapeAppearance(n.b(context2, obtainStyledAttributes.getResourceId(m.f31249S6, 0), 0).m());
            obtainStyledAttributes.recycle();
        }
        int i19 = m.f31435j7;
        if (obtainTintedStyledAttributes.s(i19)) {
            inflateMenu(obtainTintedStyledAttributes.n(i19, 0));
        }
        obtainTintedStyledAttributes.y();
        addView(createNavigationBarMenuView);
        dVar.setCallback(new a());
    }

    public static /* synthetic */ b access$000(NavigationBarView navigationBarView) {
        navigationBarView.getClass();
        return null;
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new C1150g(getContext());
        }
        return this.menuInflater;
    }

    public abstract e createNavigationBarMenuView(Context context);

    public int getActiveIndicatorLabelPadding() {
        return this.menuView.getActiveIndicatorLabelPadding();
    }

    public com.google.android.material.badge.a getBadge(int i10) {
        return this.menuView.getBadge(i10);
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.menuView.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.menuView.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorMarginHorizontal();
    }

    public n getItemActiveIndicatorShapeAppearance() {
        return this.menuView.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.menuView.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.menuView.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.menuView.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.menuView.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.menu;
    }

    public MenuView getMenuView() {
        return this.menuView;
    }

    public com.google.android.material.badge.a getOrCreateBadge(int i10) {
        return this.menuView.getOrCreateBadge(i10);
    }

    public NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int i10) {
        this.presenter.c(true);
        getMenuInflater().inflate(i10, this.menu);
        this.presenter.c(false);
        this.presenter.updateMenuView(true);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.menuView.getItemActiveIndicatorEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.e(this);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.f23476a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f23476a = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void removeBadge(int i10) {
        this.menuView.removeBadge(i10);
    }

    public void setActiveIndicatorLabelPadding(int i10) {
        this.menuView.setActiveIndicatorLabelPadding(i10);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        j.d(this, f10);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.menuView.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.menuView.setItemActiveIndicatorEnabled(z10);
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.menuView.setItemActiveIndicatorHeight(i10);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.menuView.setItemActiveIndicatorMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorShapeAppearance(n nVar) {
        this.menuView.setItemActiveIndicatorShapeAppearance(nVar);
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.menuView.setItemActiveIndicatorWidth(i10);
    }

    public void setItemBackground(Drawable drawable) {
        this.menuView.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        this.menuView.setItemBackgroundRes(i10);
    }

    public void setItemIconSize(int i10) {
        this.menuView.setItemIconSize(i10);
    }

    public void setItemIconSizeRes(int i10) {
        setItemIconSize(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.menuView.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i10, View.OnTouchListener onTouchListener) {
        this.menuView.setItemOnTouchListener(i10, onTouchListener);
    }

    public void setItemPaddingBottom(int i10) {
        this.menuView.setItemPaddingBottom(i10);
    }

    public void setItemPaddingTop(int i10) {
        this.menuView.setItemPaddingTop(i10);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.menuView.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i10) {
        this.menuView.setItemTextAppearanceActive(i10);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z10) {
        this.menuView.setItemTextAppearanceActiveBoldEnabled(z10);
    }

    public void setItemTextAppearanceInactive(int i10) {
        this.menuView.setItemTextAppearanceInactive(i10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.menuView.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.menuView.getLabelVisibilityMode() != i10) {
            this.menuView.setLabelVisibilityMode(i10);
            this.presenter.updateMenuView(false);
        }
    }

    public void setOnItemSelectedListener(c cVar) {
        this.selectedListener = cVar;
    }

    public void setSelectedItemId(int i10) {
        MenuItem findItem = this.menu.findItem(i10);
        if (findItem != null && !this.menu.performItemAction(findItem, this.presenter, 0)) {
            findItem.setChecked(true);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements MenuBuilder.Callback {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            NavigationBarView.access$000(NavigationBarView.this);
            if (NavigationBarView.this.selectedListener != null && !NavigationBarView.this.selectedListener.onNavigationItemSelected(menuItem)) {
                return true;
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    public void setOnItemReselectedListener(b bVar) {
    }
}
