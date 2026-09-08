package C6;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;

/* compiled from: StatusBarUtil.java */
/* loaded from: classes3.dex */
public class g {
    public static void a(Activity activity, int i10) {
        b(activity, activity.getWindow(), i10);
    }

    public static void b(Context context, Window window, int i10) {
        int i11;
        View decorView = window.getDecorView();
        window.setStatusBarColor(i10);
        int systemUiVisibility = decorView.getSystemUiVisibility();
        boolean z10 = context.getResources().getBoolean(d.f385a);
        if (F6.c.b()) {
            window.addFlags(Integer.MIN_VALUE);
            if (a.c(context)) {
                i11 = systemUiVisibility & (-8209);
            } else if (!z10) {
                i11 = systemUiVisibility | 8192;
            } else {
                i11 = systemUiVisibility | 256;
            }
            decorView.setSystemUiVisibility(i11);
        }
    }

    public static void c(Activity activity) {
        b(activity, activity.getWindow(), 0);
    }
}
