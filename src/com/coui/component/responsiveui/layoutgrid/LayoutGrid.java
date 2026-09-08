package com.coui.component.responsiveui.layoutgrid;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.C1226g;
import kotlin.collections.C1227h;
import kotlin.collections.C1228i;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: LayoutGridSystem.kt */
/* loaded from: classes3.dex */
final class LayoutGrid {

    /* renamed from: a, reason: collision with root package name */
    public int f20001a;

    /* renamed from: b, reason: collision with root package name */
    public int[][] f20002b;

    /* renamed from: c, reason: collision with root package name */
    public int f20003c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f20004d;

    public LayoutGrid(int i10, int[][] columnsWidth, int i11, int[] margin) {
        i.f(columnsWidth, "columnsWidth");
        i.f(margin, "margin");
        this.f20001a = i10;
        this.f20002b = columnsWidth;
        this.f20003c = i11;
        this.f20004d = margin;
    }

    public static /* synthetic */ LayoutGrid copy$default(LayoutGrid layoutGrid, int i10, int[][] iArr, int i11, int[] iArr2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = layoutGrid.f20001a;
        }
        if ((i12 & 2) != 0) {
            iArr = layoutGrid.f20002b;
        }
        if ((i12 & 4) != 0) {
            i11 = layoutGrid.f20003c;
        }
        if ((i12 & 8) != 0) {
            iArr2 = layoutGrid.f20004d;
        }
        return layoutGrid.copy(i10, iArr, i11, iArr2);
    }

    public final int component1() {
        return this.f20001a;
    }

    public final int[][] component2() {
        return this.f20002b;
    }

    public final int component3() {
        return this.f20003c;
    }

    public final int[] component4() {
        return this.f20004d;
    }

    public final LayoutGrid copy(int i10, int[][] columnsWidth, int i11, int[] margin) {
        i.f(columnsWidth, "columnsWidth");
        i.f(margin, "margin");
        return new LayoutGrid(i10, columnsWidth, i11, margin);
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        boolean d10;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!i.b(LayoutGrid.class, cls)) {
            return false;
        }
        i.d(obj, "null cannot be cast to non-null type com.coui.component.responsiveui.layoutgrid.LayoutGrid");
        LayoutGrid layoutGrid = (LayoutGrid) obj;
        if (this.f20001a == layoutGrid.f20001a) {
            d10 = C1227h.d(this.f20002b, layoutGrid.f20002b);
            if (d10 && this.f20003c == layoutGrid.f20003c && Arrays.equals(this.f20004d, layoutGrid.f20004d)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int getColumnCount() {
        return this.f20001a;
    }

    public final int[][] getColumnsWidth() {
        return this.f20002b;
    }

    public final int getGutter() {
        return this.f20003c;
    }

    public final int[] getMargin() {
        return this.f20004d;
    }

    public int hashCode() {
        int b10;
        int i10 = this.f20001a * 31;
        b10 = C1226g.b(this.f20002b);
        return ((((i10 + b10) * 31) + this.f20003c) * 31) + Arrays.hashCode(this.f20004d);
    }

    public final void setColumnCount(int i10) {
        this.f20001a = i10;
    }

    public final void setColumnsWidth(int[][] iArr) {
        i.f(iArr, "<set-?>");
        this.f20002b = iArr;
    }

    public final void setGutter(int i10) {
        this.f20003c = i10;
    }

    public final void setMargin(int[] iArr) {
        i.f(iArr, "<set-?>");
        this.f20004d = iArr;
    }

    public String toString() {
        List e10;
        int D10;
        int D11;
        List e11;
        StringBuffer value = new StringBuffer("[LayoutGrid] columnCount = " + this.f20001a + ", ");
        value.append("gutter = " + this.f20003c + ", ");
        StringBuilder sb = new StringBuilder();
        sb.append("margins = ");
        e10 = C1228i.e(this.f20004d);
        sb.append(e10);
        sb.append(", ");
        value.append(sb.toString());
        value.append("columnWidth = [");
        for (int[] iArr : this.f20002b) {
            e11 = C1228i.e(iArr);
            value.append(e11.toString());
            value.append(", ");
        }
        i.e(value, "value");
        D10 = StringsKt__StringsKt.D(value);
        D11 = StringsKt__StringsKt.D(value);
        value.delete(D10 - 1, D11 + 1);
        value.append("]");
        String stringBuffer = value.toString();
        i.e(stringBuffer, "value.toString()");
        return stringBuffer;
    }
}
