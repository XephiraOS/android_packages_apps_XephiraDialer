package c7;

import T6.a;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.oplus.utils.C0854o;
import com.oplus.view.OplusWindowAttributesManager;
import kotlin.jvm.internal.i;

/* compiled from: LayoutParamsCustomize.kt */
/* renamed from: c7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0565a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0565a f12860a = new C0565a();

    public static final void a(Window window, WindowManager.LayoutParams params) {
        i.f(window, "window");
        i.f(params, "params");
        try {
            if (C0854o.c(0, 0, 3, null)) {
                OplusWindowAttributesManager.setIgnoreHomeMenuKeyState(window, 1);
            } else {
                a.C0067a.a(params, a.C0067a.f3758b);
            }
        } catch (Throwable th) {
            Log.e("LayoutParamsCustomize", "setHomeAndMenuKeyState error :" + th);
        }
    }
}
