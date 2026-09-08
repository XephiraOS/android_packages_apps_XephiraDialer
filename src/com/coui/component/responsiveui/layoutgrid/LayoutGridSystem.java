package com.coui.component.responsiveui.layoutgrid;

import android.content.Context;
import android.util.Log;
import com.coui.component.responsiveui.ResponsiveUILog;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.unit.DpKt;
import com.coui.component.responsiveui.window.WindowSizeClass;
import com.coui.component.responsiveui.window.WindowTotalSizeClass;
import com.coui.component.responsiveui.window.WindowWidthSizeClass;
import d9.C0959a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: LayoutGridSystem.kt */
/* loaded from: classes3.dex */
public final class LayoutGridSystem implements ILayoutGrid {
    public static final Companion Companion = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f20005h;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f20006a;

    /* renamed from: b, reason: collision with root package name */
    public int f20007b;

    /* renamed from: c, reason: collision with root package name */
    public int f20008c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutGrid f20009d;

    /* renamed from: e, reason: collision with root package name */
    public MarginType f20010e;

    /* renamed from: f, reason: collision with root package name */
    public IColumnsWidthCalculator f20011f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20012g;

    /* compiled from: LayoutGridSystem.kt */
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
        if (!responsiveUILog.getLOG_DEBUG() && !responsiveUILog.isLoggable("LayoutGridSystem", 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        f20005h = z10;
    }

    public LayoutGridSystem(Context context, WindowSizeClass windowSizeClass, int i10) {
        i.f(context, "context");
        i.f(windowSizeClass, "windowSizeClass");
        this.f20006a = new int[MarginType.values().length];
        this.f20010e = MarginType.MARGIN_LARGE;
        this.f20011f = new AccumulationCalculator();
        rebuild(context, windowSizeClass, i10);
    }

    public final LayoutGrid a(Context context, WindowTotalSizeClass windowTotalSizeClass, IColumnsWidthCalculator iColumnsWidthCalculator) {
        int i10;
        if (i.b(windowTotalSizeClass, WindowTotalSizeClass.Compact)) {
            i10 = 4;
        } else if (i.b(windowTotalSizeClass, WindowTotalSizeClass.MediumLandScape) || i.b(windowTotalSizeClass, WindowTotalSizeClass.MediumPortrait) || i.b(windowTotalSizeClass, WindowTotalSizeClass.MediumSquare) || i.b(windowTotalSizeClass, WindowTotalSizeClass.ExpandedLandPortrait)) {
            i10 = 8;
        } else {
            i10 = 12;
        }
        MarginType[] values = MarginType.values();
        int length = values.length;
        int[][] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = new int[i10];
        }
        if (this.f20012g) {
            Dp pixel2Dp = DpKt.pixel2Dp(this.f20008c, context);
            int length2 = values.length;
            Dp[] dpArr = new Dp[length2];
            for (int i12 = 0; i12 < length2; i12++) {
                dpArr[i12] = DpKt.pixel2Dp(this.f20006a[i12], context);
            }
            Dp pixel2Dp2 = DpKt.pixel2Dp(this.f20007b, context);
            Dp[][] dpArr2 = new Dp[length2];
            for (int i13 = 0; i13 < length2; i13++) {
                dpArr2[i13] = iColumnsWidthCalculator.calculate(pixel2Dp, dpArr[i13], pixel2Dp2, i10);
            }
            for (MarginType marginType : values) {
                for (int i14 = 0; i14 < i10; i14++) {
                    iArr[marginType.ordinal()][i14] = (int) dpArr2[marginType.ordinal()][i14].toPixel(context);
                }
            }
        } else {
            for (MarginType marginType2 : values) {
                iArr[marginType2.ordinal()] = iColumnsWidthCalculator.calculate(this.f20008c, this.f20006a[marginType2.ordinal()], this.f20007b, i10);
            }
        }
        LayoutGrid layoutGrid = new LayoutGrid(i10, iArr, this.f20007b, this.f20006a);
        if (f20005h) {
            Log.d("LayoutGridSystem", "[calculateLayoutGrid] widthSizeClass: " + windowTotalSizeClass + ", layoutGridWindowWidth: " + this.f20008c + ", " + layoutGrid);
        }
        return layoutGrid;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[][] allColumnWidth() {
        LayoutGrid layoutGrid = this.f20009d;
        if (layoutGrid == null) {
            i.q("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getColumnsWidth();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[] allMargin() {
        LayoutGrid layoutGrid = this.f20009d;
        if (layoutGrid == null) {
            i.q("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getMargin();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public ILayoutGrid chooseMargin(MarginType marginType) {
        i.f(marginType, "marginType");
        this.f20010e = marginType;
        return this;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int columnCount() {
        LayoutGrid layoutGrid = this.f20009d;
        if (layoutGrid == null) {
            i.q("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getColumnCount();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[] columnWidth() {
        LayoutGrid layoutGrid = this.f20009d;
        if (layoutGrid == null) {
            i.q("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getColumnsWidth()[this.f20010e.ordinal()];
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int gutter() {
        LayoutGrid layoutGrid = this.f20009d;
        if (layoutGrid == null) {
            i.q("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getGutter();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int layoutGridWindowWidth() {
        return this.f20008c;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int margin() {
        LayoutGrid layoutGrid = this.f20009d;
        if (layoutGrid == null) {
            i.q("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getMargin()[this.f20010e.ordinal()];
    }

    public final void rebuild(Context context, WindowSizeClass windowSizeClass, int i10) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        i.f(context, "context");
        i.f(windowSizeClass, "windowSizeClass");
        for (MarginType marginType : MarginType.values()) {
            int[] iArr = this.f20006a;
            int ordinal = marginType.ordinal();
            WindowWidthSizeClass windowWidthSizeClass = windowSizeClass.getWindowWidthSizeClass();
            if (i.b(windowWidthSizeClass, WindowWidthSizeClass.Compact)) {
                dimensionPixelSize2 = context.getResources().getDimensionPixelSize(marginType.resId()[0]);
            } else if (i.b(windowWidthSizeClass, WindowWidthSizeClass.Medium)) {
                dimensionPixelSize2 = context.getResources().getDimensionPixelSize(marginType.resId()[1]);
            } else {
                dimensionPixelSize2 = context.getResources().getDimensionPixelSize(marginType.resId()[2]);
            }
            iArr[ordinal] = dimensionPixelSize2;
        }
        if (i.b(windowSizeClass.getWindowWidthSizeClass(), WindowWidthSizeClass.Expanded)) {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(C0959a.f30070b);
        } else {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(C0959a.f30069a);
        }
        this.f20007b = dimensionPixelSize;
        this.f20008c = i10;
        this.f20009d = a(context, windowSizeClass.getWindowTotalSizeClass(), this.f20011f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("layout-grid width = ");
        sb.append(this.f20008c);
        sb.append(", current margin = ");
        sb.append(margin());
        sb.append(", ");
        LayoutGrid layoutGrid = this.f20009d;
        if (layoutGrid == null) {
            i.q("layoutGrid");
            layoutGrid = null;
        }
        sb.append(layoutGrid);
        return sb.toString();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int width(int i10, int i11) {
        int e10;
        int b10;
        e10 = B9.i.e(i10, i11);
        b10 = B9.i.b(i10, i11);
        if (e10 >= 0) {
            LayoutGrid layoutGrid = this.f20009d;
            LayoutGrid layoutGrid2 = null;
            if (layoutGrid == null) {
                i.q("layoutGrid");
                layoutGrid = null;
            }
            if (b10 < layoutGrid.getColumnCount()) {
                int i12 = b10 - e10;
                LayoutGrid layoutGrid3 = this.f20009d;
                if (layoutGrid3 == null) {
                    i.q("layoutGrid");
                    layoutGrid3 = null;
                }
                int gutter = i12 * layoutGrid3.getGutter();
                if (e10 <= b10) {
                    while (true) {
                        LayoutGrid layoutGrid4 = this.f20009d;
                        if (layoutGrid4 == null) {
                            i.q("layoutGrid");
                            layoutGrid4 = null;
                        }
                        gutter += layoutGrid4.getColumnsWidth()[this.f20010e.ordinal()][e10];
                        if (e10 == b10) {
                            break;
                        }
                        e10++;
                    }
                }
                return gutter;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("column index must be less than ");
            LayoutGrid layoutGrid5 = this.f20009d;
            if (layoutGrid5 == null) {
                i.q("layoutGrid");
            } else {
                layoutGrid2 = layoutGrid5;
            }
            sb.append(layoutGrid2.getColumnCount());
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("column index must not be negative");
    }
}
