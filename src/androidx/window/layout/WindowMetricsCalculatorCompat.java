package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.i;

/* compiled from: WindowMetricsCalculatorCompat.kt */
/* loaded from: classes.dex */
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {

    /* renamed from: a, reason: collision with root package name */
    public static final WindowMetricsCalculatorCompat f12075a = new WindowMetricsCalculatorCompat();

    /* renamed from: b, reason: collision with root package name */
    public static final String f12076b;

    static {
        String simpleName = WindowMetricsCalculatorCompat.class.getSimpleName();
        i.e(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f12076b = simpleName;
    }

    private WindowMetricsCalculatorCompat() {
    }

    public WindowMetrics a(Activity activity) {
        i.f(activity, "activity");
        return new WindowMetrics(ActivityCompatHelperApi30.f11986a.a(activity));
    }
}
