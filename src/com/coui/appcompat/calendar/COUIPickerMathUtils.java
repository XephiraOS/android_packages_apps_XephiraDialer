package com.coui.appcompat.calendar;

import a9.m;
import android.R;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.K;

/* loaded from: classes.dex */
public final class COUIPickerMathUtils {
    public static final int UNSET_INT = Integer.MIN_VALUE;
    public static final int VIEW_STATE_ACCELERATED = 64;
    public static final int VIEW_STATE_ACTIVATED = 32;
    public static final int VIEW_STATE_DRAG_CAN_ACCEPT = 256;
    public static final int VIEW_STATE_DRAG_HOVERED = 512;
    public static final int VIEW_STATE_ENABLED = 8;
    public static final int VIEW_STATE_FOCUSED = 4;
    public static final int VIEW_STATE_HOVERED = 128;
    static final int[] VIEW_STATE_IDS;
    public static final int VIEW_STATE_PRESSED = 16;
    public static final int VIEW_STATE_SELECTED = 2;
    private static final int[][] VIEW_STATE_SETS;
    public static final int VIEW_STATE_WINDOW_FOCUSED = 1;

    static {
        int[] iArr = {R.attr.state_window_focused, 1, 16842913, 2, 16842908, 4, 16842910, 8, 16842919, 16, R.attr.state_activated, 32, R.attr.state_accelerated, 64, 16843623, 128, R.attr.state_drag_can_accept, 256, R.attr.state_drag_hovered, 512};
        VIEW_STATE_IDS = iArr;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i10 = 0;
        while (true) {
            int[] iArr3 = m.f6844d3;
            if (i10 >= iArr3.length) {
                break;
            }
            int i11 = iArr3[i10];
            int i12 = 0;
            while (true) {
                int[] iArr4 = VIEW_STATE_IDS;
                if (i12 < iArr4.length) {
                    if (iArr4[i12] == i11) {
                        int i13 = i10 * 2;
                        iArr2[i13] = i11;
                        iArr2[i13 + 1] = iArr4[i12 + 1];
                    }
                    i12 += 2;
                }
            }
            i10++;
        }
        VIEW_STATE_SETS = new int[1 << (VIEW_STATE_IDS.length / 2)];
        for (int i14 = 0; i14 < VIEW_STATE_SETS.length; i14++) {
            int[] iArr5 = new int[Integer.bitCount(i14)];
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16 += 2) {
                if ((iArr2[i16 + 1] & i14) != 0) {
                    iArr5[i15] = iArr2[i16];
                    i15++;
                }
            }
            VIEW_STATE_SETS[i14] = iArr5;
        }
    }

    private COUIPickerMathUtils() {
    }

    public static float constrain(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    public static float dist(float f10, float f11, float f12, float f13) {
        return (float) Math.hypot(f12 - f10, f13 - f11);
    }

    public static float distanceToFurthestCorner(float f10, float f11, float f12, float f13, float f14, float f15) {
        return max(dist(f10, f11, f12, f13), dist(f10, f11, f14, f13), dist(f10, f11, f14, f15), dist(f10, f11, f12, f15));
    }

    public static float dpToPx(Context context, int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static float floorMod(float f10, int i10) {
        float f11 = i10;
        int i11 = (int) (f10 / f11);
        if (Math.signum(f10) * f11 < 0.0f && i11 * i10 != f10) {
            i11--;
        }
        return f10 - (i11 * i10);
    }

    public static boolean geq(float f10, float f11, float f12) {
        if (f10 + f12 >= f11) {
            return true;
        }
        return false;
    }

    public static int[] getViewState(int i10) {
        int[][] iArr = VIEW_STATE_SETS;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        throw new IllegalArgumentException("Invalid state set mask");
    }

    public static boolean isLayoutRtl(View view) {
        if (K.v(view) == 1) {
            return true;
        }
        return false;
    }

    public static float lerp(float f10, float f11, float f12) {
        return ((1.0f - f12) * f10) + (f12 * f11);
    }

    public static float lerpDeg(float f10, float f11, float f12) {
        return (((((f11 - f10) + 180.0f) % 360.0f) - 180.0f) * f12) + f10;
    }

    private static float max(float f10, float f11, float f12, float f13) {
        if (f10 <= f11 || f10 <= f12 || f10 <= f13) {
            if (f11 > f12 && f11 > f13) {
                return f11;
            }
            if (f12 > f13) {
                return f12;
            }
            return f13;
        }
        return f10;
    }

    public static int constrain(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    public static int floorMod(int i10, int i11) {
        int i12 = i10 / i11;
        if ((i10 ^ i11) < 0 && i12 * i11 != i10) {
            i12--;
        }
        return i10 - (i12 * i11);
    }

    public static long constrain(long j10, long j11, long j12) {
        return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
    }
}
