package androidx.core.view;

import android.view.View;
import android.view.Window;

/* compiled from: WindowCompat.java */
/* loaded from: classes.dex */
public final class V {

    /* compiled from: WindowCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        public static void a(Window window, boolean z10) {
            window.setDecorFitsSystemWindows(z10);
        }
    }

    public static Y a(Window window, View view) {
        return new Y(window, view);
    }

    public static void b(Window window, boolean z10) {
        a.a(window, z10);
    }
}
