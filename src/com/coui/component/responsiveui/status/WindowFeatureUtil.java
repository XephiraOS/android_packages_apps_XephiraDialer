package com.coui.component.responsiveui.status;

import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.p;
import androidx.window.layout.FoldingFeature;
import com.coui.component.responsiveui.ResponsiveUILog;
import java.util.function.Consumer;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: WindowFeatureUtil.kt */
/* loaded from: classes3.dex */
public final class WindowFeatureUtil {
    public static final WindowFeatureUtil INSTANCE = new WindowFeatureUtil();

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f20024a;

    static {
        boolean z10;
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        if (!responsiveUILog.getLOG_DEBUG() && !responsiveUILog.isLoggable("WindowFeatureUtil", 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        f20024a = z10;
    }

    public static final boolean isBookPosture(FoldingFeature foldingFeature) {
        i.f(foldingFeature, "foldingFeature");
        if (f20024a) {
            Log.d("WindowFeatureUtil", "[isBookPosture] state: " + foldingFeature.getState() + ", orientation: " + foldingFeature.c());
        }
        if (i.b(foldingFeature.getState(), FoldingFeature.State.f12011d) && i.b(foldingFeature.c(), FoldingFeature.Orientation.f12006c)) {
            return true;
        }
        return false;
    }

    public static final boolean isSupportWindowFeature() {
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object invoke = cls.getDeclaredMethod("getInstance", null).invoke(null, null);
            if (invoke == null) {
                return false;
            }
            Object invoke2 = cls.getDeclaredMethod("hasFeature", String.class).invoke(invoke, "oplus.software.display.google_extension_layout");
            i.d(invoke2, "null cannot be cast to non-null type kotlin.Boolean");
            if (f20024a) {
                Log.d("WindowFeatureUtil", "[isSupportWindowFeature] " + invoke2);
            }
            return ((Boolean) invoke2).booleanValue();
        } catch (Exception e10) {
            Log.e("WindowFeatureUtil", "[isSupportWindowFeature] " + e10);
            return false;
        }
    }

    public static final boolean isTableTopPosture(FoldingFeature foldingFeature) {
        i.f(foldingFeature, "foldingFeature");
        if (f20024a) {
            Log.d("WindowFeatureUtil", "[isTableTopPosture] state: " + foldingFeature.getState() + ", orientation: " + foldingFeature.c());
        }
        if (i.b(foldingFeature.getState(), FoldingFeature.State.f12011d) && i.b(foldingFeature.c(), FoldingFeature.Orientation.f12007d)) {
            return true;
        }
        return false;
    }

    public final void trackWindowFeature(ComponentActivity activity, Consumer<WindowFeature> action) {
        i.f(activity, "activity");
        i.f(action, "action");
        C1248i.d(p.a(activity), S.c(), null, new WindowFeatureUtil$trackWindowFeature$1(activity, action, null), 2, null);
    }
}
