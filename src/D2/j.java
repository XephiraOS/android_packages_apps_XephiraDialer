package D2;

import android.view.View;
import android.view.Window;

/* compiled from: OplusStatusNavigationBarUtils.java */
/* loaded from: classes.dex */
public class j {
    public static void a(Window window) {
        if (window != null && window.getDecorView() != null) {
            View decorView = window.getDecorView();
            window.clearFlags(201326592);
            decorView.setSystemUiVisibility(1792);
            window.setStatusBarColor(0);
            window.setNavigationBarColor(0);
            window.setStatusBarContrastEnforced(false);
            window.setNavigationBarContrastEnforced(false);
        }
    }

    public static void b(Window window) {
        if (window != null && window.getDecorView() != null) {
            View decorView = window.getDecorView();
            window.clearFlags(201326592);
            decorView.setSystemUiVisibility(4868);
            window.setNavigationBarColor(0);
            window.setNavigationBarContrastEnforced(false);
        }
    }
}
