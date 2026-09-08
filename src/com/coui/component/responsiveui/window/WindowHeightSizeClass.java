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
public final class WindowHeightSizeClass {
    public static final WindowHeightSizeClass Compact;
    public static final Companion Companion = new Companion(null);
    public static final WindowHeightSizeClass Expanded;
    public static final WindowHeightSizeClass Medium;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f20036b;

    /* renamed from: a, reason: collision with root package name */
    public final String f20037a;

    /* compiled from: WindowSizeClass.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final WindowHeightSizeClass _hide_fromHeight(float f10) {
            if (f10 < Breakpoints.BP_MEDIUM_WINDOW_BASE_HEIGHT.getValue()) {
                return WindowHeightSizeClass.Compact;
            }
            if (f10 < Breakpoints.BP_EXPANDED_WINDOW_BASE_HEIGHT.getValue()) {
                return WindowHeightSizeClass.Medium;
            }
            return WindowHeightSizeClass.Expanded;
        }

        public final WindowHeightSizeClass fromHeight(Dp height) {
            i.f(height, "height");
            if (WindowHeightSizeClass.f20036b) {
                Log.d("WindowHeightSizeClass", "[fromHeight] height : " + height);
            }
            if (height.getValue() < 0.0f) {
                Log.e("WindowHeightSizeClass", "height :" + height.getValue() + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
                return WindowHeightSizeClass.Compact;
            }
            return _hide_fromHeight(height.getValue());
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final WindowHeightSizeClass fromHeight(Context context, int i10) {
            i.f(context, "context");
            if (WindowHeightSizeClass.f20036b) {
                Log.d("WindowHeightSizeClass", "[fromHeight] height : " + i10 + " pixel");
            }
            if (i10 < 0) {
                Log.e("WindowHeightSizeClass", "height :" + i10 + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
                return WindowHeightSizeClass.Compact;
            }
            return _hide_fromHeight(i10 / context.getResources().getDisplayMetrics().density);
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
        f20036b = z10;
        Compact = new WindowHeightSizeClass("Compact");
        Medium = new WindowHeightSizeClass("Medium");
        Expanded = new WindowHeightSizeClass("Expanded");
    }

    public WindowHeightSizeClass(String str) {
        this.f20037a = str;
    }

    public String toString() {
        return this.f20037a + " window base-height";
    }
}
