package b6;

import a6.C0423a;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import c6.AbstractC0558a;
import c6.C0560c;
import c6.C0561d;
import c6.C0563f;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.N;
import com.oplus.anim.model.content.ShapeTrimPath;
import f6.C1015b;
import f6.C1017d;
import java.util.ArrayList;
import java.util.List;
import m6.C1336b;

/* compiled from: BaseStrokeContent.java */
/* renamed from: b6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0527a implements AbstractC0558a.b, k, e {

    /* renamed from: e, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12189e;

    /* renamed from: f, reason: collision with root package name */
    public final com.oplus.anim.model.layer.a f12190f;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f12192h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f12193i;

    /* renamed from: j, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12194j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC0558a<?, Integer> f12195k;

    /* renamed from: l, reason: collision with root package name */
    public final List<AbstractC0558a<?, Float>> f12196l;

    /* renamed from: m, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12197m;

    /* renamed from: n, reason: collision with root package name */
    public AbstractC0558a<ColorFilter, ColorFilter> f12198n;

    /* renamed from: o, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f12199o;

    /* renamed from: p, reason: collision with root package name */
    public float f12200p;

    /* renamed from: q, reason: collision with root package name */
    public C0560c f12201q;

    /* renamed from: a, reason: collision with root package name */
    public final PathMeasure f12185a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public final Path f12186b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f12187c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final RectF f12188d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final List<b> f12191g = new ArrayList();

    /* compiled from: BaseStrokeContent.java */
    /* renamed from: b6.a$b */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final List<m> f12202a;

        /* renamed from: b, reason: collision with root package name */
        public final u f12203b;

        public b(u uVar) {
            this.f12202a = new ArrayList();
            this.f12203b = uVar;
        }
    }

    public AbstractC0527a(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f10, C1017d c1017d, C1015b c1015b, List<C1015b> list, C1015b c1015b2) {
        C0423a c0423a = new C0423a(1);
        this.f12193i = c0423a;
        this.f12200p = 0.0f;
        this.f12189e = effectiveAnimationDrawable;
        this.f12190f = aVar;
        c0423a.setStyle(Paint.Style.STROKE);
        c0423a.setStrokeCap(cap);
        c0423a.setStrokeJoin(join);
        c0423a.setStrokeMiter(f10);
        this.f12195k = c1017d.a();
        this.f12194j = c1015b.a();
        if (c1015b2 == null) {
            this.f12197m = null;
        } else {
            this.f12197m = c1015b2.a();
        }
        this.f12196l = new ArrayList(list.size());
        this.f12192h = new float[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f12196l.add(list.get(i10).a());
        }
        aVar.j(this.f12195k);
        aVar.j(this.f12194j);
        for (int i11 = 0; i11 < this.f12196l.size(); i11++) {
            aVar.j(this.f12196l.get(i11));
        }
        AbstractC0558a<?, Float> abstractC0558a = this.f12197m;
        if (abstractC0558a != null) {
            aVar.j(abstractC0558a);
        }
        this.f12195k.a(this);
        this.f12194j.a(this);
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.f12196l.get(i12).a(this);
        }
        AbstractC0558a<?, Float> abstractC0558a2 = this.f12197m;
        if (abstractC0558a2 != null) {
            abstractC0558a2.a(this);
        }
        if (aVar.w() != null) {
            AbstractC0558a<Float, Float> a10 = aVar.w().a().a();
            this.f12199o = a10;
            a10.a(this);
            aVar.j(this.f12199o);
        }
        if (aVar.y() != null) {
            this.f12201q = new C0560c(this, aVar, aVar.y());
        }
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        this.f12189e.invalidateSelf();
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        u uVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof u) {
                u uVar2 = (u) cVar;
                if (uVar2.k() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    uVar = uVar2;
                }
            }
        }
        if (uVar != null) {
            uVar.f(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof u) {
                u uVar3 = (u) cVar2;
                if (uVar3.k() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f12191g.add(bVar);
                    }
                    bVar = new b(uVar3);
                    uVar3.f(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(uVar);
                }
                bVar.f12202a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f12191g.add(bVar);
        }
    }

    @Override // b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        N.a("StrokeContent#getBounds");
        this.f12186b.reset();
        for (int i10 = 0; i10 < this.f12191g.size(); i10++) {
            b bVar = this.f12191g.get(i10);
            for (int i11 = 0; i11 < bVar.f12202a.size(); i11++) {
                this.f12186b.addPath(((m) bVar.f12202a.get(i11)).d(), matrix);
            }
        }
        this.f12186b.computeBounds(this.f12188d, false);
        float p10 = ((C0561d) this.f12194j).p();
        RectF rectF2 = this.f12188d;
        float f10 = p10 / 2.0f;
        rectF2.set(rectF2.left - f10, rectF2.top - f10, rectF2.right + f10, rectF2.bottom + f10);
        rectF.set(this.f12188d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        N.b("StrokeContent#getBounds");
    }

    public final void f(Matrix matrix) {
        float floatValue;
        N.a("StrokeContent#applyDashPattern");
        if (this.f12196l.isEmpty()) {
            N.b("StrokeContent#applyDashPattern");
            return;
        }
        float g10 = l6.h.g(matrix);
        for (int i10 = 0; i10 < this.f12196l.size(); i10++) {
            this.f12192h[i10] = this.f12196l.get(i10).h().floatValue();
            if (i10 % 2 == 0) {
                float[] fArr = this.f12192h;
                if (fArr[i10] < 1.0f) {
                    fArr[i10] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f12192h;
                if (fArr2[i10] < 0.1f) {
                    fArr2[i10] = 0.1f;
                }
            }
            float[] fArr3 = this.f12192h;
            fArr3[i10] = fArr3[i10] * g10;
        }
        AbstractC0558a<?, Float> abstractC0558a = this.f12197m;
        if (abstractC0558a == null) {
            floatValue = 0.0f;
        } else {
            floatValue = g10 * abstractC0558a.h().floatValue();
        }
        this.f12193i.setPathEffect(new DashPathEffect(this.f12192h, floatValue));
        N.b("StrokeContent#applyDashPattern");
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        l6.g.k(eVar, i10, list, eVar2, this);
    }

    @Override // b6.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        N.a("StrokeContent#draw");
        if (l6.h.h(matrix)) {
            N.b("StrokeContent#draw");
            return;
        }
        this.f12193i.setAlpha(l6.g.c((int) ((((i10 / 255.0f) * ((C0563f) this.f12195k).p()) / 100.0f) * 255.0f), 0, 255));
        this.f12193i.setStrokeWidth(((C0561d) this.f12194j).p() * l6.h.g(matrix));
        if (this.f12193i.getStrokeWidth() <= 0.0f) {
            N.b("StrokeContent#draw");
            return;
        }
        f(matrix);
        AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f12198n;
        if (abstractC0558a != null) {
            this.f12193i.setColorFilter(abstractC0558a.h());
        }
        AbstractC0558a<Float, Float> abstractC0558a2 = this.f12199o;
        if (abstractC0558a2 != null) {
            float floatValue = abstractC0558a2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f12193i.setMaskFilter(null);
            } else if (floatValue != this.f12200p) {
                this.f12193i.setMaskFilter(this.f12190f.x(floatValue));
            }
            this.f12200p = floatValue;
        }
        C0560c c0560c = this.f12201q;
        if (c0560c != null) {
            c0560c.b(this.f12193i);
        }
        for (int i11 = 0; i11 < this.f12191g.size(); i11++) {
            b bVar = this.f12191g.get(i11);
            if (bVar.f12203b != null) {
                j(canvas, bVar, matrix);
            } else {
                N.a("StrokeContent#buildPath");
                this.f12186b.reset();
                for (int size = bVar.f12202a.size() - 1; size >= 0; size--) {
                    this.f12186b.addPath(((m) bVar.f12202a.get(size)).d(), matrix);
                }
                N.b("StrokeContent#buildPath");
                N.a("StrokeContent#drawPath");
                canvas.drawPath(this.f12186b, this.f12193i);
                N.b("StrokeContent#drawPath");
            }
        }
        N.b("StrokeContent#draw");
    }

    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        C0560c c0560c;
        C0560c c0560c2;
        C0560c c0560c3;
        C0560c c0560c4;
        C0560c c0560c5;
        if (t10 == com.oplus.anim.r.f26176d) {
            this.f12195k.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26191s) {
            this.f12194j.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26168K) {
            AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f12198n;
            if (abstractC0558a != null) {
                this.f12190f.H(abstractC0558a);
            }
            if (c1336b == null) {
                this.f12198n = null;
                return;
            }
            c6.q qVar = new c6.q(c1336b);
            this.f12198n = qVar;
            qVar.a(this);
            this.f12190f.j(this.f12198n);
            return;
        }
        if (t10 == com.oplus.anim.r.f26182j) {
            AbstractC0558a<Float, Float> abstractC0558a2 = this.f12199o;
            if (abstractC0558a2 != null) {
                abstractC0558a2.n(c1336b);
                return;
            }
            c6.q qVar2 = new c6.q(c1336b);
            this.f12199o = qVar2;
            qVar2.a(this);
            this.f12190f.j(this.f12199o);
            return;
        }
        if (t10 == com.oplus.anim.r.f26177e && (c0560c5 = this.f12201q) != null) {
            c0560c5.c(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26164G && (c0560c4 = this.f12201q) != null) {
            c0560c4.f(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26165H && (c0560c3 = this.f12201q) != null) {
            c0560c3.d(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26166I && (c0560c2 = this.f12201q) != null) {
            c0560c2.e(c1336b);
        } else if (t10 == com.oplus.anim.r.f26167J && (c0560c = this.f12201q) != null) {
            c0560c.g(c1336b);
        }
    }

    public final void j(Canvas canvas, b bVar, Matrix matrix) {
        float f10;
        float f11;
        float f12;
        N.a("StrokeContent#applyTrimPath");
        if (bVar.f12203b == null) {
            N.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f12186b.reset();
        for (int size = bVar.f12202a.size() - 1; size >= 0; size--) {
            this.f12186b.addPath(((m) bVar.f12202a.get(size)).d(), matrix);
        }
        float floatValue = bVar.f12203b.j().h().floatValue() / 100.0f;
        float floatValue2 = bVar.f12203b.g().h().floatValue() / 100.0f;
        float floatValue3 = bVar.f12203b.i().h().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.f12186b, this.f12193i);
            N.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f12185a.setPath(this.f12186b, false);
        float length = this.f12185a.getLength();
        while (this.f12185a.nextContour()) {
            length += this.f12185a.getLength();
        }
        float f13 = floatValue3 * length;
        float f14 = (floatValue * length) + f13;
        float min = Math.min((floatValue2 * length) + f13, (f14 + length) - 1.0f);
        float f15 = 0.0f;
        for (int size2 = bVar.f12202a.size() - 1; size2 >= 0; size2--) {
            this.f12187c.set(((m) bVar.f12202a.get(size2)).d());
            this.f12187c.transform(matrix);
            this.f12185a.setPath(this.f12187c, false);
            float length2 = this.f12185a.getLength();
            if (min > length) {
                float f16 = min - length;
                if (f16 < f15 + length2 && f15 < f16) {
                    if (f14 > length) {
                        f12 = (f14 - length) / length2;
                    } else {
                        f12 = 0.0f;
                    }
                    l6.h.a(this.f12187c, f12, Math.min(f16 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f12187c, this.f12193i);
                    f15 += length2;
                }
            }
            float f17 = f15 + length2;
            if (f17 >= f14 && f15 <= min) {
                if (f17 <= min && f14 < f15) {
                    canvas.drawPath(this.f12187c, this.f12193i);
                } else {
                    if (f14 < f15) {
                        f10 = 0.0f;
                    } else {
                        f10 = (f14 - f15) / length2;
                    }
                    if (min > f17) {
                        f11 = 1.0f;
                    } else {
                        f11 = (min - f15) / length2;
                    }
                    l6.h.a(this.f12187c, f10, f11, 0.0f);
                    canvas.drawPath(this.f12187c, this.f12193i);
                }
            }
            f15 += length2;
        }
        N.b("StrokeContent#applyTrimPath");
    }
}
