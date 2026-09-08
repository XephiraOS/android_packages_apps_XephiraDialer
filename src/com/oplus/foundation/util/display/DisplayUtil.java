package com.oplus.foundation.util.display;

import H7.b;
import M7.b;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import com.coui.appcompat.baseview.util.FoldSettingsHelper;
import com.coui.responsiveui.config.ResponsiveUIConfig;
import com.coui.responsiveui.config.UIConfig;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.FeatureUtil;
import kotlin.Result;
import kotlin.a;
import kotlin.jvm.internal.i;
import m9.d;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: DisplayUtil.kt */
/* loaded from: classes3.dex */
public final class DisplayUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final DisplayUtil f28283a = new DisplayUtil();

    /* renamed from: b, reason: collision with root package name */
    public static final d f28284b;

    static {
        d b10;
        b10 = a.b(new InterfaceC1637a<Boolean>() { // from class: com.oplus.foundation.util.display.DisplayUtil$isSupportWCGDisplay$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                PackageManager packageManager = P7.a.f2961a.a().getPackageManager();
                return Boolean.valueOf(packageManager != null ? packageManager.hasSystemFeature("oplus.software.display.wcg_2.0_support") : false);
            }
        });
        f28284b = b10;
    }

    public static final int a(Context context, float f10) {
        i.f(context, "context");
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final int b(Context context) {
        Object obj;
        WindowManager windowManager;
        Display defaultDisplay;
        Integer num = null;
        if (context != null) {
            obj = context.getSystemService("window");
        } else {
            obj = null;
        }
        if (obj instanceof WindowManager) {
            windowManager = (WindowManager) obj;
        } else {
            windowManager = null;
        }
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            num = Integer.valueOf(defaultDisplay.getRotation());
        }
        if (num != null && num.intValue() == 0) {
            return 0;
        }
        if (num != null && num.intValue() == 1) {
            return 90;
        }
        if (num != null && num.intValue() == 2) {
            return 180;
        }
        if (num == null || num.intValue() != 3) {
            return 0;
        }
        return 270;
    }

    public static final float c(Context context) {
        Resources resources;
        Configuration configuration;
        if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
            return configuration.fontScale;
        }
        return 1.0f;
    }

    public static final int d(Context context) {
        int identifier;
        if (context == null || (identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static final int e(Context context, boolean z10) {
        if (context == null) {
            b.b("DisplayUtil", "getScreenHeight context is null, return 0");
            return 0;
        }
        Object systemService = context.getSystemService("window");
        i.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        if (z10 && CommonFeatureOption.m()) {
            return (int) Math.min(windowManager.getCurrentWindowMetrics().getBounds().height(), windowManager.getCurrentWindowMetrics().getBounds().width());
        }
        return windowManager.getCurrentWindowMetrics().getBounds().height();
    }

    public static final int f(Context context, boolean z10) {
        if (context == null) {
            b.b("DisplayUtil", "getScreenWidth context is null, return 0");
            return 0;
        }
        Object systemService = context.getSystemService("window");
        i.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        if (z10 && CommonFeatureOption.m()) {
            return Math.max(windowManager.getCurrentWindowMetrics().getBounds().height(), windowManager.getCurrentWindowMetrics().getBounds().width());
        }
        return windowManager.getCurrentWindowMetrics().getBounds().width();
    }

    public static final int g(Context context) {
        i.f(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final boolean h(Context context) {
        float c10 = c(context);
        if (H7.a.b()) {
            b.b("DisplayUtil", "System Text scale :" + c10);
        }
        if (c10 > 1.35d) {
            return true;
        }
        return false;
    }

    public static final boolean i(Activity activity) {
        if (activity == null || !CommonFeatureOption.m() || activity.isInMultiWindowMode() || activity.getResources().getConfiguration().orientation != 1) {
            return false;
        }
        return true;
    }

    public static final boolean j(Activity activity) {
        Object b10;
        boolean z10 = false;
        if (activity == null) {
            return false;
        }
        try {
            Result.a aVar = Result.f34166a;
            if (FlexibleWindowManager.getInstance().getFlexibleWindowState(activity) == 1) {
                z10 = true;
            }
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c("DisplayUtil", "it = " + d10);
        }
        if (H7.a.b()) {
            b.b("DisplayUtil", "freeForm = " + z10);
        }
        return z10;
    }

    public static final boolean k(Context context) {
        i.f(context, "context");
        if (context.getResources().getConfiguration().smallestScreenWidthDp >= 480) {
            return true;
        }
        return false;
    }

    public static final boolean l(Configuration configuration) {
        if (configuration != null && configuration.smallestScreenWidthDp >= 480) {
            return true;
        }
        return false;
    }

    public static final boolean m(Context context) {
        i.f(context, "context");
        boolean z10 = false;
        if (b.C0045b.a(2).f1797a.a(context.getContentResolver(), FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY, 0) == 1) {
            z10 = true;
        }
        if (H7.a.b()) {
            H7.b.b("DisplayUtil", "isParallelWindowMode = " + z10);
        }
        return z10;
    }

    public static final boolean n(Activity activity) {
        return r(activity, null, null, 6, null);
    }

    public static final boolean o(Activity activity, Configuration configuration) {
        return r(activity, configuration, null, 4, null);
    }

    public static final boolean p(Activity activity, Configuration configuration, Boolean bool) {
        UIConfig.Status status;
        if (activity != null && configuration != null && bool != null) {
            UIConfig value = ResponsiveUIConfig.getDefault(activity).getUiConfig().getValue();
            if (value != null) {
                status = value.getStatus();
            } else {
                status = null;
            }
            return q(status, Integer.valueOf(configuration.orientation), bool.booleanValue(), configuration.screenWidthDp);
        }
        return false;
    }

    public static final boolean q(UIConfig.Status status, Integer num, boolean z10, int i10) {
        H7.b.e("DisplayUtil", "screenWidthDp : " + i10 + " status : " + status);
        if (FeatureUtil.V()) {
            if (num != null && num.intValue() == 2) {
                return true;
            }
            if (z10 && i10 >= 600) {
                return true;
            }
        } else if (i10 >= 600 && status == UIConfig.Status.UNFOLD) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean r(Activity activity, Configuration configuration, Boolean bool, int i10, Object obj) {
        Resources resources;
        if ((i10 & 2) != 0) {
            if (activity != null && (resources = activity.getResources()) != null) {
                configuration = resources.getConfiguration();
            } else {
                configuration = null;
            }
        }
        if ((i10 & 4) != 0) {
            if (activity != null) {
                bool = Boolean.valueOf(activity.isInMultiWindowMode());
            } else {
                bool = null;
            }
        }
        return p(activity, configuration, bool);
    }

    public static final boolean s() {
        boolean z10;
        if (f28283a.t() && P7.a.f2961a.a().getResources().getConfiguration().isScreenWideColorGamut()) {
            z10 = true;
        } else {
            z10 = false;
        }
        H7.b.e("DisplayUtil", "isSupportWCG: " + z10);
        return z10;
    }

    public static final void u(Context context, ContentObserver contentObserver) {
        Uri b10;
        Context applicationContext;
        ContentResolver contentResolver;
        if (contentObserver != null && (b10 = b.C0045b.a(2).f1797a.b(FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY)) != null && context != null && (applicationContext = context.getApplicationContext()) != null && (contentResolver = applicationContext.getContentResolver()) != null) {
            contentResolver.registerContentObserver(b10, true, contentObserver);
        }
    }

    public static final void v(Activity activity) {
        i.f(activity, "activity");
        if (s()) {
            activity.getWindow().setColorMode(1);
        }
    }

    public static final void w(Context context, ContentObserver contentObserver) {
        Context applicationContext;
        ContentResolver contentResolver;
        if (contentObserver != null && context != null && (applicationContext = context.getApplicationContext()) != null && (contentResolver = applicationContext.getContentResolver()) != null) {
            contentResolver.unregisterContentObserver(contentObserver);
        }
    }

    public final boolean t() {
        return ((Boolean) f28284b.getValue()).booleanValue();
    }
}
