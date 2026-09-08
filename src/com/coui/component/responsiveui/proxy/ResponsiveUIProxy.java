package com.coui.component.responsiveui.proxy;

import android.content.Context;
import android.util.Log;
import com.coui.component.responsiveui.IResponsiveUI;
import com.coui.component.responsiveui.ResponsiveUILog;
import com.coui.component.responsiveui.layoutgrid.ILayoutGrid;
import com.coui.component.responsiveui.layoutgrid.LayoutGridSystem;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.status.IWindowStatus;
import com.coui.component.responsiveui.status.WindowStatus;
import com.coui.component.responsiveui.unit.DpKt;
import com.coui.component.responsiveui.window.LayoutGridWindowSize;
import com.coui.component.responsiveui.window.WindowSizeClass;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ResponsiveUIProxy.kt */
/* loaded from: classes3.dex */
public final class ResponsiveUIProxy implements IResponsiveUI, ILayoutGrid, IWindowStatus {
    public static final Companion Companion = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f20014e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LayoutGridSystem f20015a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WindowStatus f20016b;

    /* renamed from: c, reason: collision with root package name */
    public final WindowStatus f20017c;

    /* renamed from: d, reason: collision with root package name */
    public final LayoutGridSystem f20018d;

    /* compiled from: ResponsiveUIProxy.kt */
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
        if (!responsiveUILog.getLOG_DEBUG() && !responsiveUILog.isLoggable("ResponsiveUIProxy", 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        f20014e = z10;
    }

    public ResponsiveUIProxy(LayoutGridSystem layoutGridSystem, WindowStatus windowStatus) {
        i.f(layoutGridSystem, "layoutGridSystem");
        i.f(windowStatus, "windowStatus");
        this.f20015a = layoutGridSystem;
        this.f20016b = windowStatus;
        this.f20017c = windowStatus;
        this.f20018d = layoutGridSystem;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[][] allColumnWidth() {
        return this.f20015a.allColumnWidth();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[] allMargin() {
        return this.f20015a.allMargin();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public ILayoutGrid chooseMargin(MarginType marginType) {
        i.f(marginType, "marginType");
        return this.f20015a.chooseMargin(marginType);
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int columnCount() {
        return this.f20015a.columnCount();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[] columnWidth() {
        return this.f20015a.columnWidth();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int gutter() {
        return this.f20015a.gutter();
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public LayoutGridWindowSize layoutGridWindowSize() {
        return this.f20016b.layoutGridWindowSize();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int layoutGridWindowWidth() {
        return this.f20015a.layoutGridWindowWidth();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int margin() {
        return this.f20015a.margin();
    }

    @Override // com.coui.component.responsiveui.IResponsiveUI
    public void onConfigurationChanged(Context context, LayoutGridWindowSize windowSize) {
        i.f(context, "context");
        i.f(windowSize, "windowSize");
        rebuild(context, windowSize);
    }

    @Override // com.coui.component.responsiveui.IResponsiveUI
    public void rebuild(Context context, LayoutGridWindowSize windowSize) {
        i.f(context, "context");
        i.f(windowSize, "windowSize");
        WindowStatus windowStatus = this.f20017c;
        windowStatus.setOrientation(context.getResources().getConfiguration().orientation);
        windowStatus.setLayoutGridWindowSize(windowSize);
        windowStatus.setWindowSizeClass(WindowSizeClass.Companion.calculateFromSize(DpKt.pixel2Dp(windowSize.getWidth(), context), DpKt.pixel2Dp(windowSize.getHeight(), context)));
        this.f20018d.rebuild(context, this.f20017c.getWindowSizeClass(), windowSize.getWidth());
        if (f20014e) {
            Log.d("ResponsiveUIProxy", "[rebuild]: " + this.f20017c);
            Log.d("ResponsiveUIProxy", "[rebuild]: " + this.f20018d);
        }
    }

    @Override // com.coui.component.responsiveui.IResponsiveUI
    public String showLayoutGridInfo() {
        return String.valueOf(this.f20018d);
    }

    @Override // com.coui.component.responsiveui.IResponsiveUI
    public String showWindowStatusInfo() {
        return String.valueOf(this.f20017c);
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int width(int i10, int i11) {
        return this.f20015a.width(i10, i11);
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public int windowOrientation() {
        return this.f20016b.windowOrientation();
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public WindowSizeClass windowSizeClass() {
        return this.f20016b.windowSizeClass();
    }
}
