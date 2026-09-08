package c6;

import android.graphics.Matrix;
import android.graphics.PointF;
import c6.AbstractC0558a;
import com.oplus.anim.r;
import java.util.Collections;
import m6.C1336b;
import m6.C1337c;
import m6.C1338d;

/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f12845a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Matrix f12846b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f12847c;

    /* renamed from: d, reason: collision with root package name */
    public final Matrix f12848d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f12849e;

    /* renamed from: f, reason: collision with root package name */
    public AbstractC0558a<PointF, PointF> f12850f;

    /* renamed from: g, reason: collision with root package name */
    public AbstractC0558a<?, PointF> f12851g;

    /* renamed from: h, reason: collision with root package name */
    public AbstractC0558a<C1338d, C1338d> f12852h;

    /* renamed from: i, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f12853i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC0558a<Integer, Integer> f12854j;

    /* renamed from: k, reason: collision with root package name */
    public C0561d f12855k;

    /* renamed from: l, reason: collision with root package name */
    public C0561d f12856l;

    /* renamed from: m, reason: collision with root package name */
    public AbstractC0558a<?, Float> f12857m;

    /* renamed from: n, reason: collision with root package name */
    public AbstractC0558a<?, Float> f12858n;

    public p(f6.l lVar) {
        AbstractC0558a<PointF, PointF> a10;
        AbstractC0558a<PointF, PointF> a11;
        AbstractC0558a<C1338d, C1338d> a12;
        AbstractC0558a<Float, Float> a13;
        C0561d c0561d;
        C0561d c0561d2;
        if (lVar.c() == null) {
            a10 = null;
        } else {
            a10 = lVar.c().a();
        }
        this.f12850f = a10;
        if (lVar.f() == null) {
            a11 = null;
        } else {
            a11 = lVar.f().a();
        }
        this.f12851g = a11;
        if (lVar.h() == null) {
            a12 = null;
        } else {
            a12 = lVar.h().a();
        }
        this.f12852h = a12;
        if (lVar.g() == null) {
            a13 = null;
        } else {
            a13 = lVar.g().a();
        }
        this.f12853i = a13;
        if (lVar.i() == null) {
            c0561d = null;
        } else {
            c0561d = (C0561d) lVar.i().a();
        }
        this.f12855k = c0561d;
        if (c0561d != null) {
            this.f12846b = new Matrix();
            this.f12847c = new Matrix();
            this.f12848d = new Matrix();
            this.f12849e = new float[9];
        } else {
            this.f12846b = null;
            this.f12847c = null;
            this.f12848d = null;
            this.f12849e = null;
        }
        if (lVar.j() == null) {
            c0561d2 = null;
        } else {
            c0561d2 = (C0561d) lVar.j().a();
        }
        this.f12856l = c0561d2;
        if (lVar.e() != null) {
            this.f12854j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.f12857m = lVar.k().a();
        } else {
            this.f12857m = null;
        }
        if (lVar.d() != null) {
            this.f12858n = lVar.d().a();
        } else {
            this.f12858n = null;
        }
    }

    public void a(com.oplus.anim.model.layer.a aVar) {
        aVar.j(this.f12854j);
        aVar.j(this.f12857m);
        aVar.j(this.f12858n);
        aVar.j(this.f12850f);
        aVar.j(this.f12851g);
        aVar.j(this.f12852h);
        aVar.j(this.f12853i);
        aVar.j(this.f12855k);
        aVar.j(this.f12856l);
    }

    public void b(AbstractC0558a.b bVar) {
        AbstractC0558a<Integer, Integer> abstractC0558a = this.f12854j;
        if (abstractC0558a != null) {
            abstractC0558a.a(bVar);
        }
        AbstractC0558a<?, Float> abstractC0558a2 = this.f12857m;
        if (abstractC0558a2 != null) {
            abstractC0558a2.a(bVar);
        }
        AbstractC0558a<?, Float> abstractC0558a3 = this.f12858n;
        if (abstractC0558a3 != null) {
            abstractC0558a3.a(bVar);
        }
        AbstractC0558a<PointF, PointF> abstractC0558a4 = this.f12850f;
        if (abstractC0558a4 != null) {
            abstractC0558a4.a(bVar);
        }
        AbstractC0558a<?, PointF> abstractC0558a5 = this.f12851g;
        if (abstractC0558a5 != null) {
            abstractC0558a5.a(bVar);
        }
        AbstractC0558a<C1338d, C1338d> abstractC0558a6 = this.f12852h;
        if (abstractC0558a6 != null) {
            abstractC0558a6.a(bVar);
        }
        AbstractC0558a<Float, Float> abstractC0558a7 = this.f12853i;
        if (abstractC0558a7 != null) {
            abstractC0558a7.a(bVar);
        }
        C0561d c0561d = this.f12855k;
        if (c0561d != null) {
            c0561d.a(bVar);
        }
        C0561d c0561d2 = this.f12856l;
        if (c0561d2 != null) {
            c0561d2.a(bVar);
        }
    }

    public <T> boolean c(T t10, C1336b<T> c1336b) {
        if (t10 == r.f26178f) {
            AbstractC0558a<PointF, PointF> abstractC0558a = this.f12850f;
            if (abstractC0558a == null) {
                this.f12850f = new q(c1336b, new PointF());
                return true;
            }
            abstractC0558a.n(c1336b);
            return true;
        }
        if (t10 == r.f26179g) {
            AbstractC0558a<?, PointF> abstractC0558a2 = this.f12851g;
            if (abstractC0558a2 == null) {
                this.f12851g = new q(c1336b, new PointF());
                return true;
            }
            abstractC0558a2.n(c1336b);
            return true;
        }
        if (t10 == r.f26180h) {
            AbstractC0558a<?, PointF> abstractC0558a3 = this.f12851g;
            if (abstractC0558a3 instanceof n) {
                ((n) abstractC0558a3).r(c1336b);
                return true;
            }
        }
        if (t10 == r.f26181i) {
            AbstractC0558a<?, PointF> abstractC0558a4 = this.f12851g;
            if (abstractC0558a4 instanceof n) {
                ((n) abstractC0558a4).s(c1336b);
                return true;
            }
        }
        if (t10 == r.f26187o) {
            AbstractC0558a<C1338d, C1338d> abstractC0558a5 = this.f12852h;
            if (abstractC0558a5 == null) {
                this.f12852h = new q(c1336b, new C1338d());
                return true;
            }
            abstractC0558a5.n(c1336b);
            return true;
        }
        if (t10 == r.f26188p) {
            AbstractC0558a<Float, Float> abstractC0558a6 = this.f12853i;
            if (abstractC0558a6 == null) {
                this.f12853i = new q(c1336b, Float.valueOf(0.0f));
                return true;
            }
            abstractC0558a6.n(c1336b);
            return true;
        }
        if (t10 == r.f26175c) {
            AbstractC0558a<Integer, Integer> abstractC0558a7 = this.f12854j;
            if (abstractC0558a7 == null) {
                this.f12854j = new q(c1336b, 100);
                return true;
            }
            abstractC0558a7.n(c1336b);
            return true;
        }
        if (t10 == r.f26160C) {
            AbstractC0558a<?, Float> abstractC0558a8 = this.f12857m;
            if (abstractC0558a8 == null) {
                this.f12857m = new q(c1336b, Float.valueOf(100.0f));
                return true;
            }
            abstractC0558a8.n(c1336b);
            return true;
        }
        if (t10 == r.f26161D) {
            AbstractC0558a<?, Float> abstractC0558a9 = this.f12858n;
            if (abstractC0558a9 == null) {
                this.f12858n = new q(c1336b, Float.valueOf(100.0f));
                return true;
            }
            abstractC0558a9.n(c1336b);
            return true;
        }
        if (t10 == r.f26189q) {
            if (this.f12855k == null) {
                this.f12855k = new C0561d(Collections.singletonList(new C1337c(Float.valueOf(0.0f))));
            }
            this.f12855k.n(c1336b);
            return true;
        }
        if (t10 == r.f26190r) {
            if (this.f12856l == null) {
                this.f12856l = new C0561d(Collections.singletonList(new C1337c(Float.valueOf(0.0f))));
            }
            this.f12856l.n(c1336b);
            return true;
        }
        return false;
    }

    public final void d() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.f12849e[i10] = 0.0f;
        }
    }

    public AbstractC0558a<?, Float> e() {
        return this.f12858n;
    }

    public Matrix f() {
        PointF h10;
        float cos;
        float sin;
        float p10;
        PointF h11;
        this.f12845a.reset();
        AbstractC0558a<?, PointF> abstractC0558a = this.f12851g;
        if (abstractC0558a != null && (h11 = abstractC0558a.h()) != null) {
            float f10 = h11.x;
            if (f10 != 0.0f || h11.y != 0.0f) {
                this.f12845a.preTranslate(f10, h11.y);
            }
        }
        AbstractC0558a<Float, Float> abstractC0558a2 = this.f12853i;
        if (abstractC0558a2 != null) {
            if (abstractC0558a2 instanceof q) {
                p10 = abstractC0558a2.h().floatValue();
            } else {
                p10 = ((C0561d) abstractC0558a2).p();
            }
            if (p10 != 0.0f) {
                this.f12845a.preRotate(p10);
            }
        }
        if (this.f12855k != null) {
            if (this.f12856l == null) {
                cos = 0.0f;
            } else {
                cos = (float) Math.cos(Math.toRadians((-r3.p()) + 90.0f));
            }
            if (this.f12856l == null) {
                sin = 1.0f;
            } else {
                sin = (float) Math.sin(Math.toRadians((-r5.p()) + 90.0f));
            }
            float tan = (float) Math.tan(Math.toRadians(r0.p()));
            d();
            float[] fArr = this.f12849e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f11 = -sin;
            fArr[3] = f11;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f12846b.setValues(fArr);
            d();
            float[] fArr2 = this.f12849e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f12847c.setValues(fArr2);
            d();
            float[] fArr3 = this.f12849e;
            fArr3[0] = cos;
            fArr3[1] = f11;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f12848d.setValues(fArr3);
            this.f12847c.preConcat(this.f12846b);
            this.f12848d.preConcat(this.f12847c);
            this.f12845a.preConcat(this.f12848d);
        }
        AbstractC0558a<C1338d, C1338d> abstractC0558a3 = this.f12852h;
        if (abstractC0558a3 != null) {
            C1338d h12 = abstractC0558a3.h();
            if (h12.b() != 1.0f || h12.c() != 1.0f) {
                this.f12845a.preScale(h12.b(), h12.c());
            }
        }
        AbstractC0558a<PointF, PointF> abstractC0558a4 = this.f12850f;
        if (abstractC0558a4 != null && (h10 = abstractC0558a4.h()) != null) {
            float f12 = h10.x;
            if (f12 != 0.0f || h10.y != 0.0f) {
                this.f12845a.preTranslate(-f12, -h10.y);
            }
        }
        return this.f12845a;
    }

    public Matrix g(float f10) {
        PointF h10;
        C1338d h11;
        float f11;
        AbstractC0558a<?, PointF> abstractC0558a = this.f12851g;
        PointF pointF = null;
        if (abstractC0558a == null) {
            h10 = null;
        } else {
            h10 = abstractC0558a.h();
        }
        AbstractC0558a<C1338d, C1338d> abstractC0558a2 = this.f12852h;
        if (abstractC0558a2 == null) {
            h11 = null;
        } else {
            h11 = abstractC0558a2.h();
        }
        this.f12845a.reset();
        if (h10 != null) {
            this.f12845a.preTranslate(h10.x * f10, h10.y * f10);
        }
        if (h11 != null) {
            double d10 = f10;
            this.f12845a.preScale((float) Math.pow(h11.b(), d10), (float) Math.pow(h11.c(), d10));
        }
        AbstractC0558a<Float, Float> abstractC0558a3 = this.f12853i;
        if (abstractC0558a3 != null) {
            float floatValue = abstractC0558a3.h().floatValue();
            AbstractC0558a<PointF, PointF> abstractC0558a4 = this.f12850f;
            if (abstractC0558a4 != null) {
                pointF = abstractC0558a4.h();
            }
            Matrix matrix = this.f12845a;
            float f12 = floatValue * f10;
            float f13 = 0.0f;
            if (pointF == null) {
                f11 = 0.0f;
            } else {
                f11 = pointF.x;
            }
            if (pointF != null) {
                f13 = pointF.y;
            }
            matrix.preRotate(f12, f11, f13);
        }
        return this.f12845a;
    }

    public AbstractC0558a<?, Integer> h() {
        return this.f12854j;
    }

    public AbstractC0558a<?, Float> i() {
        return this.f12857m;
    }

    public void j(float f10) {
        AbstractC0558a<Integer, Integer> abstractC0558a = this.f12854j;
        if (abstractC0558a != null) {
            abstractC0558a.m(f10);
        }
        AbstractC0558a<?, Float> abstractC0558a2 = this.f12857m;
        if (abstractC0558a2 != null) {
            abstractC0558a2.m(f10);
        }
        AbstractC0558a<?, Float> abstractC0558a3 = this.f12858n;
        if (abstractC0558a3 != null) {
            abstractC0558a3.m(f10);
        }
        AbstractC0558a<PointF, PointF> abstractC0558a4 = this.f12850f;
        if (abstractC0558a4 != null) {
            abstractC0558a4.m(f10);
        }
        AbstractC0558a<?, PointF> abstractC0558a5 = this.f12851g;
        if (abstractC0558a5 != null) {
            abstractC0558a5.m(f10);
        }
        AbstractC0558a<C1338d, C1338d> abstractC0558a6 = this.f12852h;
        if (abstractC0558a6 != null) {
            abstractC0558a6.m(f10);
        }
        AbstractC0558a<Float, Float> abstractC0558a7 = this.f12853i;
        if (abstractC0558a7 != null) {
            abstractC0558a7.m(f10);
        }
        C0561d c0561d = this.f12855k;
        if (c0561d != null) {
            c0561d.m(f10);
        }
        C0561d c0561d2 = this.f12856l;
        if (c0561d2 != null) {
            c0561d2.m(f10);
        }
    }
}
