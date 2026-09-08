package f8;

/* compiled from: MathUtils.java */
/* loaded from: classes3.dex */
public class d {
    public static float a(float f10) {
        if (f10 <= 0.0f) {
            return -f10;
        }
        return f10;
    }

    public static float b(float f10, float f11) {
        if (f10 >= f11) {
            return f11;
        }
        return f10;
    }

    public static float c(float f10) {
        return (float) StrictMath.sqrt(f10);
    }
}
