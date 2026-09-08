package com.coui.appcompat.animation;

/* loaded from: classes.dex */
public class COUIPhysicalAnimationUtil {
    private static final float FLOAT_NUM_ONE = 1.0f;
    private static final float INT_NUM_FIVE = 5.0f;
    private static final float INT_NUM_ONE = 1.0f;
    private static final float INT_NUM_THREE = 3.0f;
    private static final float INT_NUM_TWO = 2.0f;
    private static final float OVERFLING_MAX_DISTANCE_FACTOR = 0.9f;
    private static final float OVERFLING_MAX_DISTANCE_SCREEN_FACTOR = 0.3731f;
    private static final float OVERFLING_TANH_FACTOR = 2.5f;
    private static final float OVERFLING_TANH_PARAM_FACTOR = 1.5f;

    public static int calcOverFlingDecelerateDist(int i10, int i11, int i12) {
        return i10 + ((int) (i12 * OVERFLING_MAX_DISTANCE_SCREEN_FACTOR * Math.tanh(((i11 / OVERFLING_TANH_PARAM_FACTOR) * OVERFLING_TANH_FACTOR) / (r5 * 0.9f))));
    }

    public static int calcRealOverScrollDist(int i10, int i11, int i12) {
        return (int) (((i10 * (1.0f - Math.min((Math.abs(i11) * 1.0f) / i12, 1.0f))) / INT_NUM_FIVE) * 2.0f);
    }
}
