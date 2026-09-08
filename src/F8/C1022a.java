package f8;

/* compiled from: Compat.java */
/* renamed from: f8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1022a {

    /* renamed from: a, reason: collision with root package name */
    public static float f31792a = 0.008333334f;

    /* renamed from: b, reason: collision with root package name */
    public static float f31793b = 0.1f;

    /* renamed from: c, reason: collision with root package name */
    public static float f31794c = 160.0f;

    public static float a(float f10) {
        return (d.c(f10) * 2.8600001f) + 2.2141f;
    }

    public static boolean b(float f10) {
        if (f10 < f31793b) {
            return true;
        }
        return false;
    }

    public static float c(float f10) {
        return f10 * f31794c;
    }

    public static float d(float f10) {
        return f10 / f31794c;
    }

    public static void e(float f10) {
        f31794c = (f10 * 55.0f) + 0.5f;
        f31793b = d(0.1f);
    }

    public static void f(float f10) {
        f31792a = f10;
    }
}
