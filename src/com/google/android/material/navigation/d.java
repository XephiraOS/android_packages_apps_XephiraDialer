package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* compiled from: NavigationBarMenu.java */
/* loaded from: classes3.dex */
public final class d extends MenuBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f23509a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23510b;

    public d(Context context, Class<?> cls, int i10) {
        super(context);
        this.f23509a = cls;
        this.f23510b = i10;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuItem addInternal(int i10, int i11, int i12, CharSequence charSequence) {
        if (size() + 1 <= this.f23510b) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i10, i11, i12, charSequence);
            if (addInternal instanceof MenuItemImpl) {
                ((MenuItemImpl) addInternal).setExclusiveCheckable(true);
            }
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.f23509a.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.f23510b + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f23509a.getSimpleName() + " does not support submenus");
    }
}
