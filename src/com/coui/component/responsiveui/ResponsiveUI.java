package com.coui.component.responsiveui;

import android.content.Context;
import android.util.Log;
import com.coui.component.responsiveui.layoutgrid.LayoutGridSystem;
import com.coui.component.responsiveui.proxy.ResponsiveUIProxy;
import com.coui.component.responsiveui.status.WindowStatus;
import com.coui.component.responsiveui.unit.DpKt;
import com.coui.component.responsiveui.window.LayoutGridWindowSize;
import com.coui.component.responsiveui.window.WindowSizeClass;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ResponsiveUI.kt */
/* loaded from: classes3.dex */
public final class ResponsiveUI {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f19984a;

    /* compiled from: ResponsiveUI.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final IResponsiveUI getInstance(Context context, LayoutGridWindowSize windowSize) {
            i.f(context, "context");
            i.f(windowSize, "windowSize");
            WindowStatus windowStatus = new WindowStatus(context.getResources().getConfiguration().orientation, WindowSizeClass.Companion.calculateFromSize(DpKt.pixel2Dp(windowSize.getWidth(), context), DpKt.pixel2Dp(windowSize.getHeight(), context)), new LayoutGridWindowSize(windowSize));
            LayoutGridSystem layoutGridSystem = new LayoutGridSystem(context, windowStatus.windowSizeClass(), windowSize.getWidth());
            if (ResponsiveUI.f19984a) {
                Log.d("ResponsiveUI", "[init]: " + windowStatus);
                Log.d("ResponsiveUI", "[init]: " + layoutGridSystem);
            }
            return new ResponsiveUIProxy(layoutGridSystem, windowStatus);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        boolean z10;
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        if (!responsiveUILog.getLOG_DEBUG() && !responsiveUILog.isLoggable("ResponsiveUI", 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        f19984a = z10;
    }
}
