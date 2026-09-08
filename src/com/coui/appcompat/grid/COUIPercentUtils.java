package com.coui.appcompat.grid;

import X8.f;
import android.content.Context;
import android.content.res.Resources;

@Deprecated
/* loaded from: classes.dex */
public class COUIPercentUtils {
    private static final int CARD_LIST_FLAG = 2;
    private static final int LARGE_SCRREN_GRID_SIZE = 12;
    private static final int LARGE_SCRREN_WIDTH_LIMIT = 840;
    private static final int MEDIUM_SCRREN_GRID_SIZE = 8;
    private static final int MEDIUM_SCRREN_WIDTH_LIMIT = 600;
    private static final int PADDING_COUNT = 2;
    private static final int PREFERENCE_FLAG = 1;
    private static final int SMALL_SCRREN_GRID_SIZE = 4;
    private static final int SMALL_SCRREN_WIDTH_LIMIT = 480;

    @Deprecated
    public static float calculateWidth(float f10, int i10, int i11, int i12, Context context) {
        boolean z10;
        int dimensionPixelOffset;
        if (i10 > 0 && i10 <= i11) {
            int i13 = 0;
            if (i12 != 1 && i12 != 2) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (i12 == 2) {
                dimensionPixelOffset = context.getResources().getDimensionPixelOffset(f.f4467A5);
            } else {
                dimensionPixelOffset = context.getResources().getDimensionPixelOffset(f.f4474B5);
            }
            int i14 = dimensionPixelOffset * 2;
            Resources resources = context.getResources();
            int i15 = f.f4481C5;
            float dimensionPixelOffset2 = ((((f10 - i14) - ((i11 - 1) * resources.getDimensionPixelOffset(i15))) / i11) * i10) + (context.getResources().getDimensionPixelOffset(i15) * Math.max(i10 - 1, 0));
            if (z10) {
                i13 = i14;
            }
            return dimensionPixelOffset2 + i13;
        }
        return f10;
    }

    @Deprecated
    public static int getTotalGridSize(Context context) {
        int i10 = context.getResources().getConfiguration().screenWidthDp;
        if (i10 < 600) {
            return 4;
        }
        if (i10 < 840) {
            return 8;
        }
        if (i10 <= 840) {
            return 4;
        }
        return 12;
    }
}
