package f4;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: AnimationUtils.java */
/* renamed from: f4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1001b {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f31702a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final TimeInterpolator f31703b = new T.b();

    /* renamed from: c, reason: collision with root package name */
    public static final TimeInterpolator f31704c = new T.a();

    /* renamed from: d, reason: collision with root package name */
    public static final TimeInterpolator f31705d = new T.c();

    /* renamed from: e, reason: collision with root package name */
    public static final TimeInterpolator f31706e = new DecelerateInterpolator();

    public static float a(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static float b(float f10, float f11, float f12, float f13, float f14) {
        if (f14 <= f12) {
            return f10;
        }
        if (f14 >= f13) {
            return f11;
        }
        return a(f10, f11, (f14 - f12) / (f13 - f12));
    }

    public static int c(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * (i11 - i10));
    }
}
