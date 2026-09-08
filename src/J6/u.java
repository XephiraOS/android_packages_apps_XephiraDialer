package j6;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import java.lang.ref.WeakReference;
import m6.C1337c;

/* compiled from: KeyframeParser.java */
/* loaded from: classes3.dex */
public class u {

    /* renamed from: b, reason: collision with root package name */
    public static p.j<WeakReference<Interpolator>> f33948b;

    /* renamed from: a, reason: collision with root package name */
    public static final Interpolator f33947a = new LinearInterpolator();

    /* renamed from: c, reason: collision with root package name */
    public static JsonReader.a f33949c = JsonReader.a.a("t", "s", "e", com.android.contacts.util.o.f17586f, "i", "h", "to", "ti");

    /* renamed from: d, reason: collision with root package name */
    public static JsonReader.a f33950d = JsonReader.a.a("x", "y");

    public static WeakReference<Interpolator> a(int i10) {
        WeakReference<Interpolator> d10;
        synchronized (u.class) {
            d10 = g().d(i10);
        }
        return d10;
    }

    public static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        Interpolator linearInterpolator;
        pointF.x = l6.g.b(pointF.x, -1.0f, 1.0f);
        pointF.y = l6.g.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = l6.g.b(pointF2.x, -1.0f, 1.0f);
        float b10 = l6.g.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = b10;
        int i10 = l6.h.i(pointF.x, pointF.y, pointF2.x, b10);
        WeakReference<Interpolator> a10 = a(i10);
        if (a10 != null) {
            interpolator = a10.get();
        } else {
            interpolator = null;
        }
        if (a10 == null || interpolator == null) {
            try {
                linearInterpolator = K.a.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e10) {
                if ("The Path cannot loop back on itself.".equals(e10.getMessage())) {
                    linearInterpolator = K.a.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                h(i10, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    public static <T> C1337c<T> c(JsonReader jsonReader, C0820a c0820a, float f10, N<T> n10, boolean z10, boolean z11) {
        if (z10 && z11) {
            return e(c0820a, jsonReader, f10, n10);
        }
        if (z10) {
            return d(c0820a, jsonReader, f10, n10);
        }
        return f(jsonReader, f10, n10);
    }

    public static <T> C1337c<T> d(C0820a c0820a, JsonReader jsonReader, float f10, N<T> n10) {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t10;
        jsonReader.e();
        PointF pointF = null;
        T t11 = null;
        T t12 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f11 = 0.0f;
        boolean z10 = false;
        PointF pointF4 = null;
        while (jsonReader.l()) {
            switch (jsonReader.L(f33949c)) {
                case 0:
                    f11 = (float) jsonReader.r();
                    break;
                case 1:
                    t12 = n10.a(jsonReader, f10);
                    break;
                case 2:
                    t11 = n10.a(jsonReader, f10);
                    break;
                case 3:
                    pointF = t.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF4 = t.e(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.s() == 1) {
                        z10 = true;
                        break;
                    } else {
                        z10 = false;
                        break;
                    }
                case 6:
                    pointF2 = t.e(jsonReader, f10);
                    break;
                case 7:
                    pointF3 = t.e(jsonReader, f10);
                    break;
                default:
                    jsonReader.S();
                    break;
            }
        }
        jsonReader.g();
        if (z10) {
            interpolator2 = f33947a;
            t10 = t12;
        } else {
            if (pointF != null && pointF4 != null) {
                interpolator = b(pointF, pointF4);
            } else {
                interpolator = f33947a;
            }
            interpolator2 = interpolator;
            t10 = t11;
        }
        C1337c<T> c1337c = new C1337c<>(c0820a, t12, t10, interpolator2, f11, null);
        c1337c.f35168o = pointF2;
        c1337c.f35169p = pointF3;
        return c1337c;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    public static <T> C1337c<T> e(C0820a c0820a, JsonReader jsonReader, float f10, N<T> n10) {
        Interpolator interpolator;
        Interpolator b10;
        Interpolator b11;
        T t10;
        PointF pointF;
        C1337c<T> c1337c;
        PointF pointF2;
        float f11;
        PointF pointF3;
        float f12;
        jsonReader.e();
        PointF pointF4 = null;
        boolean z10 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t11 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f13 = 0.0f;
        PointF pointF11 = null;
        T t12 = null;
        while (jsonReader.l()) {
            switch (jsonReader.L(f33949c)) {
                case 0:
                    pointF2 = pointF4;
                    f13 = (float) jsonReader.r();
                    pointF4 = pointF2;
                    break;
                case 1:
                    pointF2 = pointF4;
                    t11 = n10.a(jsonReader, f10);
                    pointF4 = pointF2;
                    break;
                case 2:
                    pointF2 = pointF4;
                    t12 = n10.a(jsonReader, f10);
                    pointF4 = pointF2;
                    break;
                case 3:
                    pointF2 = pointF4;
                    f11 = f13;
                    PointF pointF12 = pointF11;
                    if (jsonReader.G() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.e();
                        float f14 = 0.0f;
                        float f15 = 0.0f;
                        float f16 = 0.0f;
                        float f17 = 0.0f;
                        while (jsonReader.l()) {
                            int L10 = jsonReader.L(f33950d);
                            if (L10 != 0) {
                                if (L10 != 1) {
                                    jsonReader.S();
                                } else {
                                    JsonReader.Token G10 = jsonReader.G();
                                    JsonReader.Token token = JsonReader.Token.NUMBER;
                                    if (G10 == token) {
                                        f17 = (float) jsonReader.r();
                                        f15 = f17;
                                    } else {
                                        jsonReader.c();
                                        f15 = (float) jsonReader.r();
                                        if (jsonReader.G() == token) {
                                            f17 = (float) jsonReader.r();
                                        } else {
                                            f17 = f15;
                                        }
                                        jsonReader.f();
                                    }
                                }
                            } else {
                                JsonReader.Token G11 = jsonReader.G();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (G11 == token2) {
                                    f16 = (float) jsonReader.r();
                                    f14 = f16;
                                } else {
                                    jsonReader.c();
                                    f14 = (float) jsonReader.r();
                                    if (jsonReader.G() == token2) {
                                        f16 = (float) jsonReader.r();
                                    } else {
                                        f16 = f14;
                                    }
                                    jsonReader.f();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f14, f15);
                        PointF pointF14 = new PointF(f16, f17);
                        jsonReader.g();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f13 = f11;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF5 = t.e(jsonReader, f10);
                        f13 = f11;
                        pointF11 = pointF12;
                        pointF4 = pointF2;
                    }
                case 4:
                    if (jsonReader.G() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.e();
                        float f18 = 0.0f;
                        float f19 = 0.0f;
                        float f20 = 0.0f;
                        float f21 = 0.0f;
                        while (jsonReader.l()) {
                            PointF pointF15 = pointF11;
                            int L11 = jsonReader.L(f33950d);
                            if (L11 != 0) {
                                pointF3 = pointF4;
                                if (L11 != 1) {
                                    jsonReader.S();
                                } else {
                                    JsonReader.Token G12 = jsonReader.G();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (G12 == token3) {
                                        f21 = (float) jsonReader.r();
                                        f13 = f13;
                                        f19 = f21;
                                    } else {
                                        float f22 = f13;
                                        jsonReader.c();
                                        float r10 = (float) jsonReader.r();
                                        if (jsonReader.G() == token3) {
                                            f12 = (float) jsonReader.r();
                                        } else {
                                            f12 = r10;
                                        }
                                        jsonReader.f();
                                        f13 = f22;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f21 = f12;
                                        f19 = r10;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f23 = f13;
                                JsonReader.Token G13 = jsonReader.G();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (G13 == token4) {
                                    f20 = (float) jsonReader.r();
                                    f13 = f23;
                                    f18 = f20;
                                } else {
                                    jsonReader.c();
                                    f18 = (float) jsonReader.r();
                                    if (jsonReader.G() == token4) {
                                        f20 = (float) jsonReader.r();
                                    } else {
                                        f20 = f18;
                                    }
                                    jsonReader.f();
                                    f13 = f23;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f11 = f13;
                        PointF pointF16 = new PointF(f18, f19);
                        PointF pointF17 = new PointF(f20, f21);
                        jsonReader.g();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f13 = f11;
                        pointF4 = pointF2;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = t.e(jsonReader, f10);
                        pointF4 = pointF2;
                    }
                case 5:
                    if (jsonReader.s() == 1) {
                        z10 = true;
                        break;
                    } else {
                        z10 = false;
                        break;
                    }
                case 6:
                    pointF11 = t.e(jsonReader, f10);
                    break;
                case 7:
                    pointF4 = t.e(jsonReader, f10);
                    break;
                default:
                    jsonReader.S();
                    break;
            }
        }
        PointF pointF18 = pointF4;
        float f24 = f13;
        PointF pointF19 = pointF11;
        jsonReader.g();
        if (z10) {
            interpolator = f33947a;
            t10 = t11;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else {
                if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                    b10 = b(pointF7, pointF9);
                    b11 = b(pointF8, pointF10);
                    t10 = t12;
                    interpolator = null;
                    if (b10 == null && b11 != null) {
                        pointF = pointF19;
                        c1337c = new C1337c<>(c0820a, t11, t10, b10, b11, f24, null);
                    } else {
                        pointF = pointF19;
                        c1337c = new C1337c<>(c0820a, t11, t10, interpolator, f24, null);
                    }
                    c1337c.f35168o = pointF;
                    c1337c.f35169p = pointF18;
                    return c1337c;
                }
                interpolator = f33947a;
            }
            t10 = t12;
        }
        b10 = null;
        b11 = null;
        if (b10 == null) {
        }
        pointF = pointF19;
        c1337c = new C1337c<>(c0820a, t11, t10, interpolator, f24, null);
        c1337c.f35168o = pointF;
        c1337c.f35169p = pointF18;
        return c1337c;
    }

    public static <T> C1337c<T> f(JsonReader jsonReader, float f10, N<T> n10) {
        return new C1337c<>(n10.a(jsonReader, f10));
    }

    public static p.j<WeakReference<Interpolator>> g() {
        if (f33948b == null) {
            f33948b = new p.j<>();
        }
        return f33948b;
    }

    public static void h(int i10, WeakReference<Interpolator> weakReference) {
        synchronized (u.class) {
            f33948b.g(i10, weakReference);
        }
    }
}
