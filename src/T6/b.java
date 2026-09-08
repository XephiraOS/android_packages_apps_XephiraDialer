package T6;

import android.view.WindowManager;
import com.color.inner.view.WindowManagerWrapper;

/* compiled from: WindowManagerNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class b {
    public static Object a() {
        return 0;
    }

    public static Object b() {
        return 1;
    }

    public static Object c() {
        return 2;
    }

    public static Object d() {
        return 2;
    }

    public static Object e() {
        return 1;
    }

    public static Object f() {
        return 3;
    }

    public static Object g() {
        return 0;
    }

    public static void h(WindowManager.LayoutParams layoutParams, int i10) {
        WindowManagerWrapper.LayoutParamsWrapper.setHomeAndMenuKeyState(layoutParams, i10);
    }

    public static void i(WindowManager.LayoutParams layoutParams, int i10) {
        WindowManagerWrapper.LayoutParamsWrapper.setStatusBarStateByWindowManager(layoutParams, i10);
    }
}
