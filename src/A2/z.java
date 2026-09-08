package A2;

import android.os.Handler;
import android.os.Looper;
import com.android.incallui.Log;

/* compiled from: ThreadUtil.java */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final String f196a = "z";

    /* renamed from: b, reason: collision with root package name */
    public static volatile Handler f197b;

    public static Handler a() {
        if (f197b == null) {
            f197b = new Handler(Looper.getMainLooper());
        }
        return f197b;
    }

    public static boolean b() {
        boolean z10;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.i(f196a, "isOnMainInCallUiThread  = " + z10);
        return z10;
    }

    public static void c(Runnable runnable, long j10) {
        a().postDelayed(runnable, j10);
    }
}
