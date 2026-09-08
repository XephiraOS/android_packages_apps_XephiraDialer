package b6;

import a6.C0423a;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import c6.AbstractC0558a;
import c6.C0559b;
import c6.C0560c;
import com.coui.appcompat.uiutil.UIUtil;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.N;
import java.util.ArrayList;
import java.util.List;
import m6.C1336b;

/* compiled from: FillContent.java */
/* loaded from: classes3.dex */
public class g implements e, AbstractC0558a.b, k {

    /* renamed from: a, reason: collision with root package name */
    public final Path f12224a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f12225b;

    /* renamed from: c, reason: collision with root package name */
    public final com.oplus.anim.model.layer.a f12226c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12227d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12228e;

    /* renamed from: f, reason: collision with root package name */
    public final List<m> f12229f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC0558a<Integer, Integer> f12230g;

    /* renamed from: h, reason: collision with root package name */
    public final AbstractC0558a<Integer, Integer> f12231h;

    /* renamed from: i, reason: collision with root package name */
    public AbstractC0558a<ColorFilter, ColorFilter> f12232i;

    /* renamed from: j, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12233j;

    /* renamed from: k, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f12234k;

    /* renamed from: l, reason: collision with root package name */
    public float f12235l;

    /* renamed from: m, reason: collision with root package name */
    public C0560c f12236m;

    public g(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, g6.j jVar) {
        Path path = new Path();
        this.f12224a = path;
        this.f12225b = new C0423a(1);
        this.f12229f = new ArrayList();
        this.f12226c = aVar;
        this.f12227d = jVar.d();
        this.f12228e = jVar.f();
        this.f12233j = effectiveAnimationDrawable;
        if (aVar.w() != null) {
            AbstractC0558a<Float, Float> a10 = aVar.w().a().a();
            this.f12234k = a10;
            a10.a(this);
            aVar.j(this.f12234k);
        }
        if (aVar.y() != null) {
            this.f12236m = new C0560c(this, aVar, aVar.y());
        }
        if (jVar.b() != null && jVar.e() != null) {
            path.setFillType(jVar.c());
            AbstractC0558a<Integer, Integer> a11 = jVar.b().a();
            this.f12230g = a11;
            a11.a(this);
            aVar.j(a11);
            AbstractC0558a<Integer, Integer> a12 = jVar.e().a();
            this.f12231h = a12;
            a12.a(this);
            aVar.j(a12);
            return;
        }
        this.f12230g = null;
        this.f12231h = null;
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        this.f12233j.invalidateSelf();
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof m) {
                this.f12229f.add((m) cVar);
            }
        }
    }

    @Override // b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f12224a.reset();
        for (int i10 = 0; i10 < this.f12229f.size(); i10++) {
            this.f12224a.addPath(this.f12229f.get(i10).d(), matrix);
        }
        this.f12224a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        l6.g.k(eVar, i10, list, eVar2, this);
    }

    @Override // b6.c
    public String getName() {
        return this.f12227d;
    }

    @Override // b6.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        if (this.f12228e) {
            return;
        }
        N.a("FillContent#draw");
        this.f12225b.setColor((l6.g.c((int) ((((i10 / 255.0f) * this.f12231h.h().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((C0559b) this.f12230g).p() & UIUtil.CONSTANT_COLOR_MASK));
        AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f12232i;
        if (abstractC0558a != null) {
            this.f12225b.setColorFilter(abstractC0558a.h());
        }
        AbstractC0558a<Float, Float> abstractC0558a2 = this.f12234k;
        if (abstractC0558a2 != null) {
            float floatValue = abstractC0558a2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f12225b.setMaskFilter(null);
            } else if (floatValue != this.f12235l) {
                this.f12225b.setMaskFilter(this.f12226c.x(floatValue));
            }
            this.f12235l = floatValue;
        }
        C0560c c0560c = this.f12236m;
        if (c0560c != null) {
            c0560c.b(this.f12225b);
        }
        this.f12224a.reset();
        for (int i11 = 0; i11 < this.f12229f.size(); i11++) {
            this.f12224a.addPath(this.f12229f.get(i11).d(), matrix);
        }
        canvas.drawPath(this.f12224a, this.f12225b);
        N.b("FillContent#draw");
    }

    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        C0560c c0560c;
        C0560c c0560c2;
        C0560c c0560c3;
        C0560c c0560c4;
        C0560c c0560c5;
        if (t10 == com.oplus.anim.r.f26173a) {
            this.f12230g.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26176d) {
            this.f12231h.n(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26168K) {
            AbstractC0558a<ColorFilter, ColorFilter> abstractC0558a = this.f12232i;
            if (abstractC0558a != null) {
                this.f12226c.H(abstractC0558a);
            }
            if (c1336b == null) {
                this.f12232i = null;
                return;
            }
            c6.q qVar = new c6.q(c1336b);
            this.f12232i = qVar;
            qVar.a(this);
            this.f12226c.j(this.f12232i);
            return;
        }
        if (t10 == com.oplus.anim.r.f26182j) {
            AbstractC0558a<Float, Float> abstractC0558a2 = this.f12234k;
            if (abstractC0558a2 != null) {
                abstractC0558a2.n(c1336b);
                return;
            }
            c6.q qVar2 = new c6.q(c1336b);
            this.f12234k = qVar2;
            qVar2.a(this);
            this.f12226c.j(this.f12234k);
            return;
        }
        if (t10 == com.oplus.anim.r.f26177e && (c0560c5 = this.f12236m) != null) {
            c0560c5.c(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26164G && (c0560c4 = this.f12236m) != null) {
            c0560c4.f(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26165H && (c0560c3 = this.f12236m) != null) {
            c0560c3.d(c1336b);
            return;
        }
        if (t10 == com.oplus.anim.r.f26166I && (c0560c2 = this.f12236m) != null) {
            c0560c2.e(c1336b);
        } else if (t10 == com.oplus.anim.r.f26167J && (c0560c = this.f12236m) != null) {
            c0560c.g(c1336b);
        }
    }
}
