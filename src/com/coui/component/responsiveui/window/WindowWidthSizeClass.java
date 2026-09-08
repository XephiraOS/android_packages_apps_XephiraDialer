package com.coui.component.responsiveui.window;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.coui.component.responsiveui.ResponsiveUILog;
import com.coui.component.responsiveui.breakpoints.Breakpoints;
import com.coui.component.responsiveui.unit.Dp;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: WindowSizeClass.kt */
/* loaded from: classes3.dex */
public final class WindowWidthSizeClass {
    public static final WindowWidthSizeClass Compact;
    public static final Companion Companion = new Companion(null);
    public static final WindowWidthSizeClass Expanded;
    public static final WindowWidthSizeClass Medium;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f20043b;

    /* renamed from: a, reason: collision with root package name */
    public final String f20044a;

    /* compiled from: WindowSizeClass.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final WindowWidthSizeClass _hide_fromWidth(float f10) {
            if (f10 < Breakpoints.BP_MEDIUM_WINDOW_BASE_WIDTH.getValue()) {
                return WindowWidthSizeClass.Compact;
            }
            if (f10 < Breakpoints.BP_EXPANDED_WINDOW_BASE_WIDTH.getValue()) {
                return WindowWidthSizeClass.Medium;
            }
            return WindowWidthSizeClass.Expanded;
        }

        public final WindowWidthSizeClass fromWidth(Dp width) {
            i.f(width, "width");
            if (WindowWidthSizeClass.f20043b) {
                Log.d("WindowWidthSizeClass", "[fromWidth] width : " + width);
            }
            if (width.getValue() < 0.0f) {
                Log.e("WindowWidthSizeClass", "width :" + width.getValue() + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
                return WindowWidthSizeClass.Compact;
            }
            return _hide_fromWidth(width.getValue());
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final WindowWidthSizeClass fromWidth(Context context, int i10) {
            i.f(context, "context");
            if (WindowWidthSizeClass.f20043b) {
                Log.d("WindowWidthSizeClass", "[fromWidth] width : " + i10 + " pixel");
            }
            if (i10 < 0) {
                Log.e("WindowWidthSizeClass", "width :" + i10 + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
                return WindowWidthSizeClass.Compact;
            }
            return _hide_fromWidth(i10 / context.getResources().getDisplayMetrics().density);
        }
    }

    static {
        boolean z10;
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        if (!responsiveUILog.getLOG_DEBUG() && !responsiveUILog.isLoggable("WindowSizeClass", 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        f20043b = z10;
        Compact = new WindowWidthSizeClass("Compact");
        Medium = new WindowWidthSizeClass("Medium");
        Expanded = new WindowWidthSizeClass("Expanded");
    }

    public WindowWidthSizeClass(String str) {
        this.f20044a = str;
    }

    public String toString() {
        return this.f20044a + " window base-width";
    }
}
