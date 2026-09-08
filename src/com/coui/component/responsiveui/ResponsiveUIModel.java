package com.coui.component.responsiveui;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.coui.component.responsiveui.layoutgrid.LayoutGridSystem;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.proxy.ResponsiveUIProxy;
import com.coui.component.responsiveui.status.WindowStatus;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.unit.DpKt;
import com.coui.component.responsiveui.window.LayoutGridWindowSize;
import com.coui.component.responsiveui.window.WindowSizeClass;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ResponsiveUIModel.kt */
/* loaded from: classes3.dex */
public final class ResponsiveUIModel {
    public static final Companion Companion = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f19997d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f19998a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutGridWindowSize f19999b;

    /* renamed from: c, reason: collision with root package name */
    public final ResponsiveUIProxy f20000c;

    /* compiled from: ResponsiveUIModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        boolean z10;
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        if (!responsiveUILog.getLOG_DEBUG() && !responsiveUILog.isLoggable("ResponsiveUIModel", 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        f19997d = z10;
    }

    public ResponsiveUIModel(Context mContext, LayoutGridWindowSize mWindowSize) {
        i.f(mContext, "mContext");
        i.f(mWindowSize, "mWindowSize");
        this.f19998a = mContext;
        this.f19999b = mWindowSize;
        WindowStatus windowStatus = new WindowStatus(mContext.getResources().getConfiguration().orientation, WindowSizeClass.Companion.calculateFromSize(DpKt.pixel2Dp(this.f19999b.getWidth(), mContext), DpKt.pixel2Dp(this.f19999b.getHeight(), mContext)), new LayoutGridWindowSize(this.f19999b));
        LayoutGridSystem layoutGridSystem = new LayoutGridSystem(mContext, windowStatus.windowSizeClass(), this.f19999b.getWidth());
        if (f19997d) {
            Log.d("ResponsiveUIModel", "[init]: " + windowStatus);
            Log.d("ResponsiveUIModel", "[init]: " + layoutGridSystem);
        }
        this.f20000c = new ResponsiveUIProxy(layoutGridSystem, windowStatus);
    }

    public final int[][] allColumnWidth() {
        return this.f20000c.allColumnWidth();
    }

    public final int[] allMargin() {
        return this.f20000c.allMargin();
    }

    public final int calculateGridWidth(int i10) {
        if (i10 > this.f20000c.columnCount()) {
            if (f19997d) {
                Log.w("ResponsiveUIModel", "calculateGridWidth: requested grid number larger then current grid total number, fill the whole grid");
            }
            i10 = this.f20000c.columnCount();
        }
        return this.f20000c.width((this.f20000c.columnCount() - i10) / 2, (i10 + r0) - 1);
    }

    public final ResponsiveUIModel chooseMargin(MarginType marginType) {
        i.f(marginType, "marginType");
        this.f20000c.chooseMargin(marginType);
        return this;
    }

    public final int columnCount() {
        return this.f20000c.columnCount();
    }

    public final int[] columnWidth() {
        return this.f20000c.columnWidth();
    }

    public final Context getMContext() {
        return this.f19998a;
    }

    public final LayoutGridWindowSize getMWindowSize() {
        return this.f19999b;
    }

    public final IResponsiveUI getResponsiveUI() {
        return this.f20000c;
    }

    public final int gutter() {
        return this.f20000c.gutter();
    }

    public final LayoutGridWindowSize layoutGridWindowSize() {
        return this.f20000c.layoutGridWindowSize();
    }

    public final int layoutGridWindowWidth() {
        return this.f20000c.layoutGridWindowWidth();
    }

    public final int margin() {
        return this.f20000c.margin();
    }

    public final void onConfigurationChanged(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        this.f19999b.setWidth((int) new Dp(newConfig.screenWidthDp).toPixel(this.f19998a));
        this.f19999b.setHeight((int) new Dp(newConfig.screenWidthDp).toPixel(this.f19998a));
        this.f20000c.rebuild(this.f19998a, this.f19999b);
    }

    public final ResponsiveUIModel rebuild(LayoutGridWindowSize windowSize) {
        i.f(windowSize, "windowSize");
        this.f19999b = windowSize;
        this.f20000c.rebuild(this.f19998a, windowSize);
        return this;
    }

    public final void setMWindowSize(LayoutGridWindowSize layoutGridWindowSize) {
        i.f(layoutGridWindowSize, "<set-?>");
        this.f19999b = layoutGridWindowSize;
    }

    public final String showLayoutGridInfo() {
        return this.f20000c.showLayoutGridInfo();
    }

    public final String showWindowStatusInfo() {
        return this.f20000c.showWindowStatusInfo();
    }

    public final int width(int i10, int i11) {
        return this.f20000c.width(i10, i11);
    }

    public final int windowOrientation() {
        return this.f20000c.windowOrientation();
    }

    public final WindowSizeClass windowSizeClass() {
        return this.f20000c.windowSizeClass();
    }

    public final ResponsiveUIModel rebuild(float f10, float f11) {
        this.f19999b.setWidth((int) new Dp(f10).toPixel(this.f19998a));
        this.f19999b.setHeight((int) new Dp(f11).toPixel(this.f19998a));
        this.f20000c.rebuild(this.f19998a, this.f19999b);
        return this;
    }

    public final ResponsiveUIModel rebuild(int i10, int i11) {
        this.f19999b.setWidth(i10);
        this.f19999b.setHeight(i11);
        this.f20000c.rebuild(this.f19998a, this.f19999b);
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResponsiveUIModel(Context context, float f10, float f11) {
        this(context, new LayoutGridWindowSize(context, new Dp(f10), new Dp(f11)));
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResponsiveUIModel(Context context, int i10, int i11) {
        this(context, new LayoutGridWindowSize(i10, i11));
        i.f(context, "context");
    }
}
