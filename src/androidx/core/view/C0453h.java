package androidx.core.view;

import android.view.DisplayCutout;

/* compiled from: DisplayCutoutCompat.java */
/* renamed from: androidx.core.view.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0453h {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f9506a;

    /* compiled from: DisplayCutoutCompat.java */
    /* renamed from: androidx.core.view.h$a */
    /* loaded from: classes.dex */
    public static class a {
        public static int a(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        public static int b(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        public static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        public static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    public C0453h(DisplayCutout displayCutout) {
        this.f9506a = displayCutout;
    }

    public static C0453h e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C0453h(displayCutout);
    }

    public int a() {
        return a.a(this.f9506a);
    }

    public int b() {
        return a.b(this.f9506a);
    }

    public int c() {
        return a.c(this.f9506a);
    }

    public int d() {
        return a.d(this.f9506a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0453h.class == obj.getClass()) {
            return I.c.a(this.f9506a, ((C0453h) obj).f9506a);
        }
        return false;
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f9506a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f9506a + "}";
    }
}
