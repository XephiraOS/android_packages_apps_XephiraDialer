package androidx.core.view;

import android.content.Context;
import android.view.ViewConfiguration;

/* compiled from: ViewConfigurationCompat.java */
/* loaded from: classes.dex */
public final class L {

    /* compiled from: ViewConfigurationCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        public static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    /* compiled from: ViewConfigurationCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        public static boolean a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    /* compiled from: ViewConfigurationCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public static int a(ViewConfiguration viewConfiguration, int i10, int i11, int i12) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i10, i11, i12);
        }

        public static int b(ViewConfiguration viewConfiguration, int i10, int i11, int i12) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i10, i11, i12);
        }
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        return a.a(viewConfiguration);
    }

    public static int b(Context context, ViewConfiguration viewConfiguration, int i10, int i11, int i12) {
        return c.a(viewConfiguration, i10, i11, i12);
    }

    public static int c(Context context, ViewConfiguration viewConfiguration, int i10, int i11, int i12) {
        return c.b(viewConfiguration, i10, i11, i12);
    }

    public static float d(ViewConfiguration viewConfiguration, Context context) {
        return a.b(viewConfiguration);
    }

    public static boolean e(ViewConfiguration viewConfiguration, Context context) {
        return b.a(viewConfiguration);
    }
}
