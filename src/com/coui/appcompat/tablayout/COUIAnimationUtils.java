package com.coui.appcompat.tablayout;

import T.b;
import T.c;
import android.content.Context;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.coui.appcompat.animation.COUILinearInterpolator;

/* loaded from: classes3.dex */
public class COUIAnimationUtils {
    private static final int SCALE_STANDARD = 100;
    public static final Interpolator LINEAR_INTERPOLATOR = new COUILinearInterpolator();
    public static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new b();
    public static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new T.a();
    public static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new c();
    public static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

    public static int getScaleStandard(Context context) {
        return (int) (context.getResources().getDisplayMetrics().density * 100.0f);
    }

    public static float lerp(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static int lerp(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * (i11 - i10));
    }
}
