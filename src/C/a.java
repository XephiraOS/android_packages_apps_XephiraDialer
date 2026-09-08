package C;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DrawableCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: DrawableCompat.java */
    /* renamed from: C.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0005a {
        public static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        public static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        public static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public static void e(Drawable drawable, float f10, float f11) {
            drawable.setHotspot(f10, f11);
        }

        public static void f(Drawable drawable, int i10, int i11, int i12, int i13) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }

        public static void g(Drawable drawable, int i10) {
            drawable.setTint(i10);
        }

        public static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    /* compiled from: DrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        public static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public static boolean b(Drawable drawable, int i10) {
            return drawable.setLayoutDirection(i10);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        C0005a.a(drawable, theme);
    }

    public static boolean b(Drawable drawable) {
        return C0005a.b(drawable);
    }

    public static void c(Drawable drawable) {
        drawable.clearColorFilter();
    }

    @Deprecated
    public static int d(Drawable drawable) {
        return drawable.getAlpha();
    }

    public static ColorFilter e(Drawable drawable) {
        return C0005a.c(drawable);
    }

    public static int f(Drawable drawable) {
        return b.a(drawable);
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0005a.d(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    @Deprecated
    public static boolean h(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    @Deprecated
    public static void j(Drawable drawable, boolean z10) {
        drawable.setAutoMirrored(z10);
    }

    public static void k(Drawable drawable, float f10, float f11) {
        C0005a.e(drawable, f10, f11);
    }

    public static void l(Drawable drawable, int i10, int i11, int i12, int i13) {
        C0005a.f(drawable, i10, i11, i12, i13);
    }

    public static boolean m(Drawable drawable, int i10) {
        return b.b(drawable, i10);
    }

    public static void n(Drawable drawable, int i10) {
        C0005a.g(drawable, i10);
    }

    public static void o(Drawable drawable, ColorStateList colorStateList) {
        C0005a.h(drawable, colorStateList);
    }

    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        C0005a.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(Drawable drawable) {
        if (drawable instanceof e) {
            return (T) ((e) drawable).b();
        }
        return drawable;
    }

    public static Drawable r(Drawable drawable) {
        return drawable;
    }
}
