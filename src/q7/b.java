package Q7;

import android.app.Activity;
import android.content.Intent;
import kotlin.jvm.internal.i;

/* compiled from: ActivityExt.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final boolean b(final Activity activity, Intent intent, int i10, final int i11) {
        i.f(activity, "<this>");
        i.f(intent, "intent");
        try {
            activity.startActivityForResult(intent, i10);
            return true;
        } catch (Throwable th) {
            if (i11 != 0) {
                activity.runOnUiThread(new Runnable() { // from class: Q7.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.d(activity, i11);
                    }
                });
            }
            H7.b.c("ActivityExt", "Activity.startSafeActivityForResult error, " + th);
            return false;
        }
    }

    public static /* synthetic */ boolean c(Activity activity, Intent intent, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = B7.a.f261a;
        }
        return b(activity, intent, i10, i11);
    }

    public static final void d(Activity this_startActivityForResultSafely, int i10) {
        i.f(this_startActivityForResultSafely, "$this_startActivityForResultSafely");
        com.oplus.foundation.util.ui.c.d(this_startActivityForResultSafely, i10);
    }
}
