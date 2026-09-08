package com.coui.component.responsiveui.window;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.coui.component.responsiveui.ResponsiveUILog;
import com.coui.component.responsiveui.unit.Dp;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: WindowSizeClass.kt */
/* loaded from: classes3.dex */
public final class WindowTotalSizeClass {
    public static final WindowTotalSizeClass Compact;
    public static final Companion Companion = new Companion(null);
    public static final WindowTotalSizeClass Expanded;
    public static final WindowTotalSizeClass ExpandedLandPortrait;
    public static final WindowTotalSizeClass MediumLandScape;
    public static final WindowTotalSizeClass MediumPortrait;
    public static final WindowTotalSizeClass MediumSquare;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f20041b;

    /* renamed from: a, reason: collision with root package name */
    public final String f20042a;

    /* compiled from: WindowSizeClass.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final WindowTotalSizeClass a(float f10, float f11) {
            WindowWidthSizeClass _hide_fromWidth = WindowWidthSizeClass.Companion._hide_fromWidth(f10);
            if (i.b(_hide_fromWidth, WindowWidthSizeClass.Compact)) {
                return WindowTotalSizeClass.Compact;
            }
            if (i.b(_hide_fromWidth, WindowWidthSizeClass.Medium)) {
                WindowHeightSizeClass _hide_fromHeight = WindowHeightSizeClass.Companion._hide_fromHeight(f11);
                if (i.b(_hide_fromHeight, WindowHeightSizeClass.Compact)) {
                    return WindowTotalSizeClass.MediumLandScape;
                }
                if (i.b(_hide_fromHeight, WindowHeightSizeClass.Medium)) {
                    return WindowTotalSizeClass.MediumSquare;
                }
                return WindowTotalSizeClass.MediumPortrait;
            }
            if (i.b(WindowHeightSizeClass.Companion._hide_fromHeight(f11), WindowHeightSizeClass.Compact)) {
                return WindowTotalSizeClass.ExpandedLandPortrait;
            }
            return WindowTotalSizeClass.Expanded;
        }

        public final WindowTotalSizeClass fromWidthAndHeight(Dp width, Dp height) {
            i.f(width, "width");
            i.f(height, "height");
            if (WindowTotalSizeClass.f20041b) {
                Log.d("WindowHeightSizeClass", "[fromWidthAndHeight] width : " + width + ", height : " + height);
            }
            if (width.getValue() >= 0.0f && height.getValue() >= 0.0f) {
                return a(width.getValue(), height.getValue());
            }
            Log.e("WindowHeightSizeClass", "width :" + width.getValue() + " height :" + height.getValue() + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
            return WindowTotalSizeClass.Compact;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final WindowTotalSizeClass fromWidthAndHeight(Context context, int i10, int i11) {
            i.f(context, "context");
            if (WindowTotalSizeClass.f20041b) {
                Log.d("WindowHeightSizeClass", "[fromWidthAndHeight] width : " + i10 + " pixel, height : " + i11 + " pixel");
            }
            if (i10 >= 0 && i11 >= 0) {
                float f10 = context.getResources().getDisplayMetrics().density;
                return a(i10 / f10, i11 / f10);
            }
            Log.e("WindowHeightSizeClass", "width :" + i10 + " height :" + i11 + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
            return WindowTotalSizeClass.Compact;
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
        f20041b = z10;
        Compact = new WindowTotalSizeClass("Compact");
        MediumLandScape = new WindowTotalSizeClass("MediumLandScape");
        MediumSquare = new WindowTotalSizeClass("MediumSquare");
        MediumPortrait = new WindowTotalSizeClass("MediumPortrait");
        Expanded = new WindowTotalSizeClass("Expanded");
        ExpandedLandPortrait = new WindowTotalSizeClass("ExpandedLandPortrait");
    }

    public WindowTotalSizeClass(String str) {
        this.f20042a = str;
    }

    public String toString() {
        return this.f20042a + " window base-total";
    }
}
