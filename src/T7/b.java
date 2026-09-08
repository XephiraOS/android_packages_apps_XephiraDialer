package T7;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import com.oplus.foundation.util.ui.c;
import kotlin.jvm.internal.i;

/* compiled from: ActivityResultLauncherExt.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final boolean b(androidx.activity.result.b<Intent> bVar, final Context context, Intent intent, final int i10) {
        i.f(bVar, "<this>");
        i.f(intent, "intent");
        try {
            bVar.a(intent);
            return true;
        } catch (ActivityNotFoundException e10) {
            if (i10 != 0) {
                ThreadUtilsKt.d(new Runnable() { // from class: T7.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.c(context, i10);
                    }
                });
            }
            H7.b.c("ActivityResultLauncherExt", "ActivityResultLauncher<Intent>.startSafeActivityForResult error, " + e10);
            return false;
        } catch (Throwable th) {
            H7.b.c("ActivityResultLauncherExt", "ActivityResultLauncher<Intent>.startSafeActivityForResult error: " + th);
            return false;
        }
    }

    public static final void c(Context context, int i10) {
        c.d(context, i10);
    }
}
