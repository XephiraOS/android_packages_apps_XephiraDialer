package b6;

import a6.C0423a;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import c6.AbstractC0558a;
import c6.C0560c;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.N;
import com.oplus.anim.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
import m6.C1336b;
import p.C1420f;

/* compiled from: GradientFillContent.java */
/* loaded from: classes3.dex */
public class h implements e, AbstractC0558a.b, k {

    /* renamed from: a, reason: collision with root package name */
    public final String f12237a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f12238b;

    /* renamed from: c, reason: collision with root package name */
    public final com.oplus.anim.model.layer.a f12239c;

    /* renamed from: d, reason: collision with root package name */
    public final C1420f<LinearGradient> f12240d = new C1420f<>();

    /* renamed from: e, reason: collision with root package name */
    public final C1420f<RadialGradient> f12241e = new C1420f<>();

    /* renamed from: f, reason: collision with root package name */
    public final Path f12242f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f12243g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f12244h;

    /* renamed from: i, reason: collision with root package name */
    public final List<m> f12245i;

    /* renamed from: j, reason: collision with root package name */
    public final GradientType f12246j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC0558a<g6.d, g6.d> f12247k;

    /* renamed from: l, reason: collision with root package name */
    public final AbstractC0558a<Integer, Integer> f12248l;

    /* renamed from: m, reason: collision with root package name */
    public final AbstractC0558a<PointF, PointF> f12249m;

    /* renamed from: n, reason: collision with root package name */
    public final AbstractC0558a<PointF, PointF> f12250n;

    /* renamed from: o, reason: collision with root package name */
    public AbstractC0558a<ColorFilter, ColorFilter> f12251o;

    /* renamed from: p, reason: collision with root package name */
    public c6.q f12252p;

    /* renamed from: q, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12253q;

    /* renamed from: r, reason: collision with root package name */
    public final int f12254r;

    /* renamed from: s, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f12255s;

    /* renamed from: t, reason: collision with root package name */
    public float f12256t;

    /* renamed from: u, reason: collision with root package name */
    public C0560c f12257u;

    public h(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar, g6.e eVar) {
        Path path = new Path();
        this.f12242f = path;
        this.f12243g = new C0423a(1);
        this.f12244h = new RectF();
        this.f12245i = new ArrayList();
        this.f12256t = 0.0f;
        this.f12239c = aVar;
        this.f12237a = eVar.f();
        this.f12238b = eVar.i();
        this.f12253q = effectiveAnimationDrawable;
        this.f12246j = eVar.e();
        path.setFillType(eVar.c());
        this.f12254r = (int) (c0820a.d() / 32.0f);
        AbstractC0558a<g6.d, g6.d> a10 = eVar.d().a();
        this.f12247k = a10;
        a10.a(this);
        aVar.j(a10);
        AbstractC0558a<Integer, Integer> a11 = eVar.g().a();
        this.f12248l = a11;
        a11.a(this);
        aVar.j(a11);
        AbstractC0558a<PointF, PointF> a12 = eVar.h().a();
        this.f12249m = a12;
        a12.a(this);
        aVar.j(a12);
        AbstractC0558a<PointF, PointF> a13 = eVar.b().a();
        this.f12250n = a13;
        a13.a(this);
        aVar.j(a13);
        if (aVar.w() != null) {
            AbstractC0558a<Float, Float> a14 = aVar.w().a().a();
            this.f12255s = a14;
            a14.a(this);
            aVar.j(this.f12255s);
        }
        if (aVar.y() != null) {
            this.f12257u = new C0560c(this, aVar, aVar.y());
        }
    }

    private int[] f(int[] iArr) {
        c6.q qVar = this.f12252p;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    private int j() {
        int i10;
        int round = Math.round(this.f12249m.f() * this.f12254r);
        int round2 = Math.round(this.f12250n.f() * this.f12254r);
        int round3 = Math.round(this.f12247k.f() * this.f12254r);
        if (round != 0) {
            i10 = 527 * round;
        } else {
            i10 = 17;
        }
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        if (round3 != 0) {
            return i10 * 31 * round3;
        }
        return i10;
    }

    private LinearGradient k() {
        long j10 = j();
        LinearGradient d10 = this.f12240d.d(j10);
        if (d10 != null) {
            return d10;
        }
        PointF h10 = this.f12249m.h();
        PointF h11 = this.f12250n.h();
        g6.d h12 = this.f12247k.h();
        LinearGradient linearGradient = new LinearGradient(h10.x, h10.y, h11.x, h11.y, f(h12.c()), h12.d(), Shader.TileMode.CLAMP);
        this.f12240d.h(j10, linearGradient);
        return linearGradient;
    }

    private RadialGradient l() {
        long j10 = j();
        RadialGradient d10 = this.f12241e.d(j10);
        if (d10 != null) {
            return d10;
        }
        PointF h10 = this.f12249m.h();
        PointF h11 = this.f12250n.h();
        g6.d h12 = this.f12247k.h();
        int[] f10 = f(h12.c());
        float[] d11 = h12.d();
        float f11 = h10.x;
        float f12 = h10.y;
        float hypot = (float) Math.hypot(h11.x - f11, h11.y - f12);
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient = new RadialGradient(f11, f12, hypot, f10, d11, Shader.TileMode.CLAMP);
        this.f12241e.h(j10, radialGradient);
        return radialGradient;
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        this.f12253q.invalidateSelf();
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof m) {
                this.f12245i.add((m) cVar);
            }
        }
    }

    @Override // b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f12242f.reset();
        for (int i10 = 0; i10 < this.f12245i.size(); i10++) {
            this.f12242f.addPath(this.f12245i.get(i10).d(), matrix);
        }
        this.f12242f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        l6.g.k(eVar, i10, list, eVar2, this);
    }

    @Override // b6.c
    public String getName() {
        return this.f12237a;
    }

    @Override // b6.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        Shader l10;
        if (this.f12238b) {
            return;
        }
        N.a("GradientFillContent#draw");
        this.f12242f.reset();
        for (int i11 = 0; i11 < this.f12245i.size(); i11++) {
            this.f12242f.addPath(this.f12245i.get(i11).d(), matrix);
        }
        this.f12242f.computeBounds(this.f12244h, false);
        if (this.f12246j == GradientType.LINEAR) {
            l10 = k();
        } else {
            l10 = l();
        }
        l10.setLocalMatrix(matrix);
        this.f12243g.setShader(l10);
        AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f12251o;
        if (abstractC0558a != null) {
            this.f12243g.setColorFilter(abstractC0558a.h());
        }
        AbstractC0558a<Float, Float> abstractC0558a2 = this.f12255s;
        if (abstractC0558a2 != null) {
            float floatValue = abstractC0558a2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f12243g.setMaskFilter(null);
            } else if (floatValue != this.f12256t) {
                this.f12243g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f12256t = floatValue;
        }
        C0560c c0560c = this.f12257u;
        if (c0560c != null) {
            c0560c.b(this.f12243g);
        }
        this.f12243g.setAlpha(l6.g.c((int) ((((i10 / 255.0f) * this.f12248l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f12242f, this.f12243g);
        N.b("GradientFillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        C0560c c0560c;
        C0560c c0560c2;
        C0560c c0560c3;
        C0560c c0560c4;
        C0560c c0560c5;
        if (t10 == com.oplus.anim.r.f26176d) {
            this.f12248l.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26168K) {
            AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f12251o;
            if (abstractC0558a != null) {
                this.f12239c.H(abstractC0558a);
            }
            if (c1336b == null) {
                this.f12251o = null;
                return;
            }
            c6.q qVar = new c6.q(c1336b);
            this.f12251o = qVar;
            qVar.a(this);
            this.f12239c.j(this.f12251o);
            return;
        }
        if (t10 == com.oplus.anim.r.f26169L) {
            c6.q qVar2 = this.f12252p;
            if (qVar2 != null) {
                this.f12239c.H(qVar2);
            }
            if (c1336b == null) {
                this.f12252p = null;
                return;
            }
            this.f12240d.a();
            this.f12241e.a();
            c6.q qVar3 = new c6.q(c1336b);
            this.f12252p = qVar3;
            qVar3.a(this);
            this.f12239c.j(this.f12252p);
            return;
        }
        if (t10 == com.oplus.anim.r.f26182j) {
            AbstractC0558a<Float, Float> abstractC0558a2 = this.f12255s;
            if (abstractC0558a2 != null) {
                abstractC0558a2.n(c1336b);
                return;
            }
            c6.q qVar4 = new c6.q(c1336b);
            this.f12255s = qVar4;
            qVar4.a(this);
            this.f12239c.j(this.f12255s);
            return;
        }
        if (t10 == com.oplus.anim.r.f26177e && (c0560c5 = this.f12257u) != null) {
            c0560c5.c(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26164G && (c0560c4 = this.f12257u) != null) {
            c0560c4.f(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26165H && (c0560c3 = this.f12257u) != null) {
            c0560c3.d(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26166I && (c0560c2 = this.f12257u) != null) {
            c0560c2.e(c1336b);
        } else if (t10 == com.oplus.anim.r.f26167J && (c0560c = this.f12257u) != null) {
            c0560c.g(c1336b);
        }
    }
}
