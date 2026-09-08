package J3;

import T6.a;
import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import com.oplus.view.OplusWindowAttributesManager;

/* compiled from: WindowCustomize.kt */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f1585a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final int f1586b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f1587c;

    static {
        int i10;
        int i11 = 1;
        if (C7.b.a(30, 1)) {
            i10 = 1;
        } else {
            i10 = a.C0067a.f3758b;
        }
        f1586b = i10;
        if (!C7.b.a(30, 1)) {
            i11 = a.C0067a.f3762f;
        }
        f1587c = i11;
    }

    public static final void a(Window window, int i10) {
        if (window != null) {
            try {
                if (C7.b.a(30, 1)) {
                    OplusWindowAttributesManager.setIgnoreHomeMenuKeyState(window, i10);
                } else {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    a.C0067a.a(attributes, i10);
                    window.setAttributes(attributes);
                }
            } catch (Throwable th) {
                H7.b.c("LayoutParamsCustomize", "setHomeAndMenuKeyState error :" + th);
            }
        }
    }

    public static final void b(Dialog dialog) {
        if (dialog != null) {
            a(dialog.getWindow(), f1586b);
        }
    }

    public static final void c(Dialog dialog) {
        if (dialog != null) {
            d(dialog.getWindow(), f1587c);
        }
    }

    public static final void d(Window window, int i10) {
        if (window != null) {
            try {
                if (C7.b.a(30, 1)) {
                    OplusWindowAttributesManager.setStatusBarState(window, i10);
                } else {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    a.C0067a.b(attributes, i10);
                    window.setAttributes(attributes);
                }
            } catch (Throwable th) {
                H7.b.c("LayoutParamsCustomize", "setStatusBarStateByWindowManager error :" + th);
            }
        }
    }
}
