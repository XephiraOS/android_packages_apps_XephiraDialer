package m6;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.oplus.anim.C0820a;

/* compiled from: Keyframe.java */
/* renamed from: m6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1337c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final C0820a f35154a;

    /* renamed from: b, reason: collision with root package name */
    public final T f35155b;

    /* renamed from: c, reason: collision with root package name */
    public T f35156c;

    /* renamed from: d, reason: collision with root package name */
    public final Interpolator f35157d;

    /* renamed from: e, reason: collision with root package name */
    public final Interpolator f35158e;

    /* renamed from: f, reason: collision with root package name */
    public final Interpolator f35159f;

    /* renamed from: g, reason: collision with root package name */
    public final float f35160g;

    /* renamed from: h, reason: collision with root package name */
    public Float f35161h;

    /* renamed from: i, reason: collision with root package name */
    public float f35162i;

    /* renamed from: j, reason: collision with root package name */
    public float f35163j;

    /* renamed from: k, reason: collision with root package name */
    public int f35164k;

    /* renamed from: l, reason: collision with root package name */
    public int f35165l;

    /* renamed from: m, reason: collision with root package name */
    public float f35166m;

    /* renamed from: n, reason: collision with root package name */
    public float f35167n;

    /* renamed from: o, reason: collision with root package name */
    public PointF f35168o;

    /* renamed from: p, reason: collision with root package name */
    public PointF f35169p;

    public C1337c(C0820a c0820a, T t10, T t11, Interpolator interpolator, float f10, Float f11) {
        this.f35162i = -3987645.8f;
        this.f35163j = -3987645.8f;
        this.f35164k = 784923401;
        this.f35165l = 784923401;
        this.f35166m = Float.MIN_VALUE;
        this.f35167n = Float.MIN_VALUE;
        this.f35168o = null;
        this.f35169p = null;
        this.f35154a = c0820a;
        this.f35155b = t10;
        this.f35156c = t11;
        this.f35157d = interpolator;
        this.f35158e = null;
        this.f35159f = null;
        this.f35160g = f10;
        this.f35161h = f11;
    }

    public boolean a(float f10) {
        if (f10 >= f() && f10 < c()) {
            return true;
        }
        return false;
    }

    public C1337c<T> b(T t10, T t11) {
        return new C1337c<>(t10, t11);
    }

    public float c() {
        if (this.f35154a == null) {
            return 1.0f;
        }
        if (this.f35167n == Float.MIN_VALUE) {
            if (this.f35161h == null) {
                this.f35167n = 1.0f;
            } else {
                this.f35167n = f() + ((this.f35161h.floatValue() - this.f35160g) / this.f35154a.e());
            }
        }
        return this.f35167n;
    }

    public float d() {
        if (this.f35163j == -3987645.8f) {
            this.f35163j = ((Float) this.f35156c).floatValue();
        }
        return this.f35163j;
    }

    public int e() {
        if (this.f35165l == 784923401) {
            this.f35165l = ((Integer) this.f35156c).intValue();
        }
        return this.f35165l;
    }

    public float f() {
        C0820a c0820a = this.f35154a;
        if (c0820a == null) {
            return 0.0f;
        }
        if (this.f35166m == Float.MIN_VALUE) {
            this.f35166m = (this.f35160g - c0820a.p()) / this.f35154a.e();
        }
        return this.f35166m;
    }

    public float g() {
        if (this.f35162i == -3987645.8f) {
            this.f35162i = ((Float) this.f35155b).floatValue();
        }
        return this.f35162i;
    }

    public int h() {
        if (this.f35164k == 784923401) {
            this.f35164k = ((Integer) this.f35155b).intValue();
        }
        return this.f35164k;
    }

    public boolean i() {
        if (this.f35157d == null && this.f35158e == null && this.f35159f == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f35155b + ", endValue=" + this.f35156c + ", startFrame=" + this.f35160g + ", endFrame=" + this.f35161h + ", interpolator=" + this.f35157d + '}';
    }

    public C1337c(C0820a c0820a, T t10, T t11, Interpolator interpolator, Interpolator interpolator2, float f10, Float f11) {
        this.f35162i = -3987645.8f;
        this.f35163j = -3987645.8f;
        this.f35164k = 784923401;
        this.f35165l = 784923401;
        this.f35166m = Float.MIN_VALUE;
        this.f35167n = Float.MIN_VALUE;
        this.f35168o = null;
        this.f35169p = null;
        this.f35154a = c0820a;
        this.f35155b = t10;
        this.f35156c = t11;
        this.f35157d = null;
        this.f35158e = interpolator;
        this.f35159f = interpolator2;
        this.f35160g = f10;
        this.f35161h = f11;
    }

    public C1337c(C0820a c0820a, T t10, T t11, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f10, Float f11) {
        this.f35162i = -3987645.8f;
        this.f35163j = -3987645.8f;
        this.f35164k = 784923401;
        this.f35165l = 784923401;
        this.f35166m = Float.MIN_VALUE;
        this.f35167n = Float.MIN_VALUE;
        this.f35168o = null;
        this.f35169p = null;
        this.f35154a = c0820a;
        this.f35155b = t10;
        this.f35156c = t11;
        this.f35157d = interpolator;
        this.f35158e = interpolator2;
        this.f35159f = interpolator3;
        this.f35160g = f10;
        this.f35161h = f11;
    }

    public C1337c(T t10) {
        this.f35162i = -3987645.8f;
        this.f35163j = -3987645.8f;
        this.f35164k = 784923401;
        this.f35165l = 784923401;
        this.f35166m = Float.MIN_VALUE;
        this.f35167n = Float.MIN_VALUE;
        this.f35168o = null;
        this.f35169p = null;
        this.f35154a = null;
        this.f35155b = t10;
        this.f35156c = t10;
        this.f35157d = null;
        this.f35158e = null;
        this.f35159f = null;
        this.f35160g = Float.MIN_VALUE;
        this.f35161h = Float.valueOf(Float.MAX_VALUE);
    }

    public C1337c(T t10, T t11) {
        this.f35162i = -3987645.8f;
        this.f35163j = -3987645.8f;
        this.f35164k = 784923401;
        this.f35165l = 784923401;
        this.f35166m = Float.MIN_VALUE;
        this.f35167n = Float.MIN_VALUE;
        this.f35168o = null;
        this.f35169p = null;
        this.f35154a = null;
        this.f35155b = t10;
        this.f35156c = t11;
        this.f35157d = null;
        this.f35158e = null;
        this.f35159f = null;
        this.f35160g = Float.MIN_VALUE;
        this.f35161h = Float.valueOf(Float.MAX_VALUE);
    }
}
