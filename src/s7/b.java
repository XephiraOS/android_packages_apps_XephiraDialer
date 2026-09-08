package S7;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import com.oplus.foundation.util.ui.c;
import kotlin.jvm.internal.i;

/* compiled from: FragmentExt.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final boolean b(final Fragment fragment, Intent intent, int i10, final int i11) {
        i.f(fragment, "<this>");
        i.f(intent, "intent");
        try {
            fragment.startActivityForResult(intent, i10);
            return true;
        } catch (Throwable th) {
            if (i11 != 0) {
                ThreadUtilsKt.d(new Runnable() { // from class: S7.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.d(Fragment.this, i11);
                    }
                });
            }
            H7.b.c("FragmentExt", "Activity.startSafeActivityForResult error, " + th);
            return false;
        }
    }

    public static /* synthetic */ boolean c(Fragment fragment, Intent intent, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = B7.a.f261a;
        }
        return b(fragment, intent, i10, i11);
    }

    public static final void d(Fragment this_startActivityForResultSafely, int i10) {
        i.f(this_startActivityForResultSafely, "$this_startActivityForResultSafely");
        c.d(this_startActivityForResultSafely.getContext(), i10);
    }
}
