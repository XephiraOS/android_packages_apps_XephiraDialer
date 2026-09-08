package com.coui.component.responsiveui.layoutgrid;

import com.coui.component.responsiveui.unit.Dp;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.i;
import x9.c;

/* compiled from: AccumulationCalculator.kt */
/* loaded from: classes3.dex */
public final class AccumulationCalculator implements IColumnsWidthCalculator {
    @Override // com.coui.component.responsiveui.layoutgrid.IColumnsWidthCalculator
    public Dp[] calculate(Dp layoutGridWidth, Dp margin, Dp gutter, int i10) {
        int z10;
        int a10;
        i.f(layoutGridWidth, "layoutGridWidth");
        i.f(margin, "margin");
        i.f(gutter, "gutter");
        Dp[] dpArr = new Dp[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            dpArr[i12] = new Dp(0.0f);
        }
        float f10 = i10 - 1;
        if ((gutter.getValue() * f10) + (margin.getValue() * 2.0d) > layoutGridWidth.getValue()) {
            return dpArr;
        }
        double value = ((layoutGridWidth.getValue() - (margin.getValue() * 2.0d)) - (f10 * gutter.getValue())) / i10;
        z10 = C1229j.z(dpArr);
        if (z10 >= 0) {
            double d10 = 0.0d;
            while (true) {
                int i13 = i11 + 1;
                a10 = c.a((i13 * value) - d10);
                dpArr[i11] = new Dp(a10);
                d10 += a10;
                if (i11 == z10) {
                    break;
                }
                i11 = i13;
            }
        }
        return dpArr;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.IColumnsWidthCalculator
    public int[] calculate(int i10, int i11, int i12, int i13) {
        int y10;
        int a10;
        int[] iArr = new int[i13];
        double d10 = (i13 - 1) * i12;
        double d11 = i11 * 2.0d;
        double d12 = i10;
        if (d10 + d11 > d12) {
            return iArr;
        }
        double d13 = ((d12 - d11) - d10) / i13;
        y10 = C1229j.y(iArr);
        if (y10 >= 0) {
            double d14 = 0.0d;
            int i14 = 0;
            while (true) {
                int i15 = i14 + 1;
                a10 = c.a((i15 * d13) - d14);
                iArr[i14] = a10;
                d14 += a10;
                if (i14 == y10) {
                    break;
                }
                i14 = i15;
            }
        }
        return iArr;
    }
}
