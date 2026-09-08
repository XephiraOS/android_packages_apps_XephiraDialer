package L1;

import android.app.ActivityOptions;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.view.Display;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.R;
import kotlin.jvm.internal.i;

/* compiled from: ScreenStatusUtils.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1712a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f1713b;

    static {
        boolean z10;
        Context appContext = OplusInCallApp.getAppContext();
        i.e(appContext, "getAppContext()");
        if (c(appContext) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Log.d("FoldScreenStatusUtils", "isDisplayOfDragonfly: " + z10);
        f1713b = z10;
    }

    public static final Display a(Context context) {
        i.f(context, "context");
        DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        if (displayManager != null) {
            return d.a(displayManager);
        }
        return null;
    }

    public static final Context b(Context context, int i10) {
        i.f(context, "context");
        return e(context, a(context), i10);
    }

    public static final Display c(Context context) {
        i.f(context, "context");
        DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        if (displayManager != null) {
            return d.b(displayManager);
        }
        return null;
    }

    public static final Intent d(Context context) {
        i.f(context, "context");
        Intent intent = new Intent(context.getResources().getString(R.string.ACTION_SHOW_FOLD_SCREEN_INCALLUI));
        intent.setPackage(context.getApplicationInfo().packageName);
        intent.addFlags(277086208);
        return intent;
    }

    public static final Context e(Context context, Display display, int i10) {
        i.f(context, "context");
        Context createWindowContext = context.createDisplayContext(display).createWindowContext(i10, null);
        createWindowContext.setTheme(R.style.Theme_COUI_Blue);
        i.e(createWindowContext, "context.createDisplayCon…heme_COUI_Blue)\n        }");
        return createWindowContext;
    }

    public static final boolean f() {
        return f1713b;
    }

    public static final boolean g(Context context) {
        i.f(context, "context");
        DisplayManager displayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        i.e(displayManager, "displayManager");
        if (d.c(d.a(displayManager)) || !d.c(d.b(displayManager))) {
            return false;
        }
        return true;
    }

    public static final boolean h(Context context, Intent intent) {
        i.f(context, "context");
        i.f(intent, "intent");
        return k(context, intent, 0);
    }

    public static final boolean i(Context context, Intent intent) {
        i.f(context, "context");
        i.f(intent, "intent");
        Display c10 = c(context);
        if (c10 != null) {
            return k(context, intent, c10.getDisplayId());
        }
        return false;
    }

    public static final boolean j(Context context) {
        i.f(context, "context");
        return i(context, d(context));
    }

    public static final boolean k(Context context, Intent intent, int i10) {
        i.f(context, "context");
        i.f(intent, "intent");
        try {
            context.startActivity(intent, ActivityOptions.makeBasic().setLaunchDisplayId(i10).toBundle());
            return true;
        } catch (ActivityNotFoundException e10) {
            Log.d("FoldScreenStatusUtils", "startTargetDisplayActivity: ActivityNotFoundException = " + e10.getMessage());
            return false;
        } catch (Exception e11) {
            Log.d("FoldScreenStatusUtils", "startTargetDisplayActivity: exception = " + e11.getMessage());
            return false;
        }
    }
}
