package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.MenuItem;

/* compiled from: MenuItemCompat.java */
/* loaded from: classes.dex */
public final class r {

    /* compiled from: MenuItemCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static MenuItem a(MenuItem menuItem, char c10, int i10) {
            return menuItem.setAlphabeticShortcut(c10, i10);
        }

        public static MenuItem b(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        public static MenuItem c(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        public static MenuItem d(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        public static MenuItem e(MenuItem menuItem, char c10, int i10) {
            return menuItem.setNumericShortcut(c10, i10);
        }

        public static MenuItem f(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    public static MenuItem a(MenuItem menuItem, AbstractC0447b abstractC0447b) {
        if (menuItem instanceof D.b) {
            return ((D.b) menuItem).setSupportActionProvider(abstractC0447b);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static void b(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof D.b) {
            ((D.b) menuItem).setAlphabeticShortcut(c10, i10);
        } else {
            a.a(menuItem, c10, i10);
        }
    }

    public static void c(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof D.b) {
            ((D.b) menuItem).setContentDescription(charSequence);
        } else {
            a.b(menuItem, charSequence);
        }
    }

    public static void d(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof D.b) {
            ((D.b) menuItem).setIconTintList(colorStateList);
        } else {
            a.c(menuItem, colorStateList);
        }
    }

    public static void e(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof D.b) {
            ((D.b) menuItem).setIconTintMode(mode);
        } else {
            a.d(menuItem, mode);
        }
    }

    public static void f(MenuItem menuItem, char c10, int i10) {
        if (menuItem instanceof D.b) {
            ((D.b) menuItem).setNumericShortcut(c10, i10);
        } else {
            a.e(menuItem, c10, i10);
        }
    }

    public static void g(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof D.b) {
            ((D.b) menuItem).setTooltipText(charSequence);
        } else {
            a.f(menuItem, charSequence);
        }
    }
}
