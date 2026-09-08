package o;

import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawableWithShadow.java */
/* renamed from: o.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1387e extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public static final double f35655a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f10, float f11, boolean z10) {
        if (z10) {
            return (float) (f10 + ((1.0d - f35655a) * f11));
        }
        return f10;
    }

    public static float b(float f10, float f11, boolean z10) {
        if (z10) {
            return (float) ((f10 * 1.5f) + ((1.0d - f35655a) * f11));
        }
        return f10 * 1.5f;
    }
}
