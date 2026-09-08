package b6;

import android.graphics.Path;
import android.graphics.PointF;
import c6.AbstractC0558a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.content.PolystarShape;
import com.oplus.anim.model.content.ShapeTrimPath;
import java.util.List;
import m6.C1336b;

/* compiled from: PolystarContent.java */
/* loaded from: classes3.dex */
public class n implements m, AbstractC0558a.b, k {

    /* renamed from: b, reason: collision with root package name */
    public final String f12277b;

    /* renamed from: c, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12278c;

    /* renamed from: d, reason: collision with root package name */
    public final PolystarShape.Type f12279d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12280e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12281f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12282g;

    /* renamed from: h, reason: collision with root package name */
    public final AbstractC0558a<?, PointF> f12283h;

    /* renamed from: i, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12284i;

    /* renamed from: j, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12285j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12286k;

    /* renamed from: l, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12287l;

    /* renamed from: m, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12288m;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12290o;

    /* renamed from: a, reason: collision with root package name */
    public final Path f12276a = new Path();

    /* renamed from: n, reason: collision with root package name */
    public final b f12289n = new b();

    /* compiled from: PolystarContent.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12291a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f12291a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12291a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, PolystarShape polystarShape) {
        this.f12278c = effectiveAnimationDrawable;
        this.f12277b = polystarShape.d();
        PolystarShape.Type j10 = polystarShape.j();
        this.f12279d = j10;
        this.f12280e = polystarShape.k();
        this.f12281f = polystarShape.l();
        AbstractC0558a<Float, Float> a10 = polystarShape.g().a();
        this.f12282g = a10;
        AbstractC0558a<PointF, PointF> a11 = polystarShape.h().a();
        this.f12283h = a11;
        AbstractC0558a<Float, Float> a12 = polystarShape.i().a();
        this.f12284i = a12;
        AbstractC0558a<Float, Float> a13 = polystarShape.e().a();
        this.f12286k = a13;
        AbstractC0558a<Float, Float> a14 = polystarShape.f().a();
        this.f12288m = a14;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (j10 == type) {
            this.f12285j = polystarShape.b().a();
            this.f12287l = polystarShape.c().a();
        } else {
            this.f12285j = null;
            this.f12287l = null;
        }
        aVar.j(a10);
        aVar.j(a11);
        aVar.j(a12);
        aVar.j(a13);
        aVar.j(a14);
        if (j10 == type) {
            aVar.j(this.f12285j);
            aVar.j(this.f12287l);
        }
        a10.a(this);
        a11.a(this);
        a12.a(this);
        a13.a(this);
        a14.a(this);
        if (j10 == type) {
            this.f12285j.a(this);
            this.f12287l.a(this);
        }
    }

    private void k() {
        this.f12290o = false;
        this.f12278c.invalidateSelf();
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        k();
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.k() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f12289n.a(uVar);
                    uVar.f(this);
                }
            }
        }
    }

    @Override // b6.m
    public Path d() {
        if (this.f12290o) {
            return this.f12276a;
        }
        this.f12276a.reset();
        if (this.f12280e) {
            this.f12290o = true;
            return this.f12276a;
        }
        int i10 = a.f12291a[this.f12279d.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                f();
            }
        } else {
            j();
        }
        this.f12276a.close();
        this.f12289n.b(this.f12276a);
        this.f12290o = true;
        return this.f12276a;
    }

    public final void f() {
        double floatValue;
        int i10;
        double d10;
        double d11;
        double d12;
        int floor = (int) Math.floor(this.f12282g.h().floatValue());
        AbstractC0558a<?, Float> abstractC0558a = this.f12284i;
        if (abstractC0558a == null) {
            floatValue = 0.0d;
        } else {
            floatValue = abstractC0558a.h().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d13 = floor;
        float floatValue2 = this.f12288m.h().floatValue() / 100.0f;
        float floatValue3 = this.f12286k.h().floatValue();
        double d14 = floatValue3;
        float cos = (float) (Math.cos(radians) * d14);
        float sin = (float) (Math.sin(radians) * d14);
        this.f12276a.moveTo(cos, sin);
        double d15 = (float) (6.283185307179586d / d13);
        double d16 = radians + d15;
        double ceil = Math.ceil(d13);
        int i11 = 0;
        while (i11 < ceil) {
            float cos2 = (float) (Math.cos(d16) * d14);
            double d17 = ceil;
            float sin2 = (float) (d14 * Math.sin(d16));
            if (floatValue2 != 0.0f) {
                d11 = d14;
                i10 = i11;
                d10 = d16;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d12 = d15;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f10 = floatValue3 * floatValue2 * 0.25f;
                this.f12276a.cubicTo(cos - (cos3 * f10), sin - (sin3 * f10), cos2 + (((float) Math.cos(atan22)) * f10), sin2 + (f10 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i10 = i11;
                d10 = d16;
                d11 = d14;
                d12 = d15;
                this.f12276a.lineTo(cos2, sin2);
            }
            d16 = d10 + d12;
            i11 = i10 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d17;
            d14 = d11;
            d15 = d12;
        }
        PointF h10 = this.f12283h.h();
        this.f12276a.offset(h10.x, h10.y);
        this.f12276a.close();
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        l6.g.k(eVar, i10, list, eVar2, this);
    }

    @Override // b6.c
    public String getName() {
        return this.f12277b;
    }

    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        AbstractC0558a<?, Float> abstractC0558a;
        AbstractC0558a<?, Float> abstractC0558a2;
        if (t10 == com.oplus.anim.r.f26195w) {
            this.f12282g.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26196x) {
            this.f12284i.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26186n) {
            this.f12283h.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26197y && (abstractC0558a2 = this.f12285j) != null) {
            abstractC0558a2.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26198z) {
            this.f12286k.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26158A && (abstractC0558a = this.f12287l) != null) {
            abstractC0558a.n(c1336b);
        } else if (t10 == com.oplus.anim.r.f26159B) {
            this.f12288m.n(c1336b);
        }
    }

    public final void j() {
        double floatValue;
        float f10;
        float f11;
        int i10;
        float f12;
        float f13;
        double d10;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        double d11;
        float f19;
        float f20;
        float f21;
        double d12;
        float f22;
        float f23;
        float f24;
        float f25;
        float floatValue2 = this.f12282g.h().floatValue();
        AbstractC0558a<?, Float> abstractC0558a = this.f12284i;
        if (abstractC0558a == null) {
            floatValue = 0.0d;
        } else {
            floatValue = abstractC0558a.h().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d13 = floatValue2;
        float f26 = (float) (6.283185307179586d / d13);
        if (this.f12281f) {
            f26 *= -1.0f;
        }
        float f27 = f26 / 2.0f;
        float f28 = floatValue2 - ((int) floatValue2);
        int i11 = (f28 > 0.0f ? 1 : (f28 == 0.0f ? 0 : -1));
        if (i11 != 0) {
            radians += (1.0f - f28) * f27;
        }
        float floatValue3 = this.f12286k.h().floatValue();
        float floatValue4 = this.f12285j.h().floatValue();
        AbstractC0558a<?, Float> abstractC0558a2 = this.f12287l;
        if (abstractC0558a2 != null) {
            f10 = abstractC0558a2.h().floatValue() / 100.0f;
        } else {
            f10 = 0.0f;
        }
        AbstractC0558a<?, Float> abstractC0558a3 = this.f12288m;
        if (abstractC0558a3 != null) {
            f11 = abstractC0558a3.h().floatValue() / 100.0f;
        } else {
            f11 = 0.0f;
        }
        if (i11 != 0) {
            f15 = ((floatValue3 - floatValue4) * f28) + floatValue4;
            i10 = i11;
            double d14 = f15;
            float cos = (float) (d14 * Math.cos(radians));
            f14 = (float) (d14 * Math.sin(radians));
            this.f12276a.moveTo(cos, f14);
            d10 = radians + ((f26 * f28) / 2.0f);
            f12 = cos;
            f13 = f27;
        } else {
            i10 = i11;
            double d15 = floatValue3;
            float cos2 = (float) (Math.cos(radians) * d15);
            float sin = (float) (d15 * Math.sin(radians));
            this.f12276a.moveTo(cos2, sin);
            f12 = cos2;
            f13 = f27;
            d10 = radians + f13;
            f14 = sin;
            f15 = 0.0f;
        }
        double ceil = Math.ceil(d13) * 2.0d;
        int i12 = 0;
        float f29 = f13;
        float f30 = f12;
        boolean z10 = false;
        while (true) {
            double d16 = i12;
            if (d16 < ceil) {
                if (z10) {
                    f16 = floatValue3;
                } else {
                    f16 = floatValue4;
                }
                if (f15 != 0.0f && d16 == ceil - 2.0d) {
                    f17 = f26;
                    f18 = (f26 * f28) / 2.0f;
                } else {
                    f17 = f26;
                    f18 = f29;
                }
                if (f15 != 0.0f && d16 == ceil - 1.0d) {
                    d11 = d16;
                    f19 = f15;
                } else {
                    d11 = d16;
                    f19 = f15;
                    f15 = f16;
                }
                double d17 = f15;
                double d18 = ceil;
                float cos3 = (float) (d17 * Math.cos(d10));
                float sin2 = (float) (d17 * Math.sin(d10));
                if (f10 == 0.0f && f11 == 0.0f) {
                    this.f12276a.lineTo(cos3, sin2);
                    d12 = d10;
                    f20 = f10;
                    f21 = f11;
                } else {
                    f20 = f10;
                    double atan2 = (float) (Math.atan2(f14, f30) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f21 = f11;
                    d12 = d10;
                    double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z10) {
                        f22 = f20;
                    } else {
                        f22 = f21;
                    }
                    if (z10) {
                        f23 = f21;
                    } else {
                        f23 = f20;
                    }
                    if (z10) {
                        f24 = floatValue4;
                    } else {
                        f24 = floatValue3;
                    }
                    if (z10) {
                        f25 = floatValue3;
                    } else {
                        f25 = floatValue4;
                    }
                    float f31 = f24 * f22 * 0.47829f;
                    float f32 = cos4 * f31;
                    float f33 = f31 * sin3;
                    float f34 = f25 * f23 * 0.47829f;
                    float f35 = cos5 * f34;
                    float f36 = f34 * sin4;
                    if (i10 != 0) {
                        if (i12 == 0) {
                            f32 *= f28;
                            f33 *= f28;
                        } else if (d11 == d18 - 1.0d) {
                            f35 *= f28;
                            f36 *= f28;
                        }
                    }
                    this.f12276a.cubicTo(f30 - f32, f14 - f33, cos3 + f35, sin2 + f36, cos3, sin2);
                }
                d10 = d12 + f18;
                z10 = !z10;
                i12++;
                f30 = cos3;
                f14 = sin2;
                f11 = f21;
                f10 = f20;
                f15 = f19;
                f26 = f17;
                ceil = d18;
            } else {
                PointF h10 = this.f12283h.h();
                this.f12276a.offset(h10.x, h10.y);
                this.f12276a.close();
                return;
            }
        }
    }
}
