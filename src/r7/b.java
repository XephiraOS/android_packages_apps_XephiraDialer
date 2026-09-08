package R7;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.android.incallui.OplusPhoneCapabilities;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import kotlin.Result;
import kotlin.jvm.internal.i;

/* compiled from: ContextExt.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final SharedPreferences b(Context context, String fileName, int i10) {
        Object b10;
        i.f(fileName, "fileName");
        Object obj = null;
        if (context == null) {
            return null;
        }
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(context.getSharedPreferences(fileName, i10));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("ContextExt", "Context.getSharedPreferencesSafely error, " + d10);
        }
        if (!Result.f(b10)) {
            obj = b10;
        }
        return (SharedPreferences) obj;
    }

    public static final boolean c(Context context, Intent intent) {
        return f(context, intent, 0, null, 6, null);
    }

    public static final boolean d(Context context, Intent intent, int i10) {
        return f(context, intent, i10, null, 4, null);
    }

    public static final boolean e(final Context context, Intent intent, final int i10, Bundle bundle) {
        if (context != null && intent != null) {
            if (!(context instanceof Activity)) {
                intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            }
            try {
                Result.a aVar = Result.f34166a;
                context.startActivity(intent, bundle);
                return true;
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                Throwable d10 = Result.d(Result.b(kotlin.b.a(th)));
                if (d10 != null) {
                    if ((d10 instanceof ActivityNotFoundException) && i10 != 0) {
                        ThreadUtilsKt.d(new Runnable() { // from class: R7.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                b.g(context, i10);
                            }
                        });
                    } else {
                        H7.b.c("ContextExt", "Context.startSafeActivity error, " + d10);
                    }
                }
            }
        }
        return false;
    }

    public static /* synthetic */ boolean f(Context context, Intent intent, int i10, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = B7.a.f261a;
        }
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        return e(context, intent, i10, bundle);
    }

    public static final void g(Context context, int i10) {
        com.oplus.foundation.util.ui.c.d(context, i10);
    }
}
