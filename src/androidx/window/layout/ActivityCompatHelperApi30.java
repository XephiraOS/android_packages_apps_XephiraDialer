package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import kotlin.jvm.internal.i;

/* compiled from: ActivityCompatHelper.kt */
/* loaded from: classes.dex */
public final class ActivityCompatHelperApi30 {

    /* renamed from: a, reason: collision with root package name */
    public static final ActivityCompatHelperApi30 f11986a = new ActivityCompatHelperApi30();

    private ActivityCompatHelperApi30() {
    }

    public final Rect a(Activity activity) {
        i.f(activity, "activity");
        Rect bounds = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        i.e(bounds, "activity.windowManager.currentWindowMetrics.bounds");
        return bounds;
    }
}
