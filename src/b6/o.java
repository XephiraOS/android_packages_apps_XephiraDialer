package b6;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import c6.AbstractC0558a;
import c6.C0561d;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.content.ShapeTrimPath;
import java.util.List;
import m6.C1336b;

/* compiled from: RectangleContent.java */
/* loaded from: classes3.dex */
public class o implements AbstractC0558a.b, k, m {

    /* renamed from: c, reason: collision with root package name */
    public final String f12294c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f12295d;

    /* renamed from: e, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12296e;

    /* renamed from: f, reason: collision with root package name */
    public final AbstractC0558a<?, PointF> f12297f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC0558a<?, PointF> f12298g;

    /* renamed from: h, reason: collision with root package name */
    public final AbstractC0558a<?, Float> f12299h;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12302k;

    /* renamed from: a, reason: collision with root package name */
    public final Path f12292a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final RectF f12293b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    public final b f12300i = new b();

    /* renamed from: j, reason: collision with root package name */
    public AbstractC0558a<Float, Float> f12301j = null;

    public o(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, g6.f fVar) {
        this.f12294c = fVar.c();
        this.f12295d = fVar.f();
        this.f12296e = effectiveAnimationDrawable;
        AbstractC0558a<PointF, PointF> a10 = fVar.d().a();
        this.f12297f = a10;
        AbstractC0558a<PointF, PointF> a11 = fVar.e().a();
        this.f12298g = a11;
        AbstractC0558a<Float, Float> a12 = fVar.b().a();
        this.f12299h = a12;
        aVar.j(a10);
        aVar.j(a11);
        aVar.j(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    private void f() {
        this.f12302k = false;
        this.f12296e.invalidateSelf();
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        f();
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.k() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f12300i.a(uVar);
                    uVar.f(this);
                }
            }
            if (cVar instanceof q) {
                this.f12301j = ((q) cVar).i();
            }
        }
    }

    @Override // b6.m
    public Path d() {
        float p10;
        AbstractC0558a<Float, Float> abstractC0558a;
        if (this.f12302k) {
            return this.f12292a;
        }
        this.f12292a.reset();
        if (this.f12295d) {
            this.f12302k = true;
            return this.f12292a;
        }
        PointF h10 = this.f12298g.h();
        float f10 = h10.x / 2.0f;
        float f11 = h10.y / 2.0f;
        AbstractC0558a<?, Float> abstractC0558a2 = this.f12299h;
        if (abstractC0558a2 == null) {
            p10 = 0.0f;
        } else {
            p10 = ((C0561d) abstractC0558a2).p();
        }
        if (p10 == 0.0f && (abstractC0558a = this.f12301j) != null) {
            p10 = Math.min(abstractC0558a.h().floatValue(), Math.min(f10, f11));
        }
        float min = Math.min(f10, f11);
        if (p10 > min) {
            p10 = min;
        }
        PointF h11 = this.f12297f.h();
        this.f12292a.moveTo(h11.x + f10, (h11.y - f11) + p10);
        this.f12292a.lineTo(h11.x + f10, (h11.y + f11) - p10);
        if (p10 > 0.0f) {
            RectF rectF = this.f12293b;
            float f12 = h11.x;
            float f13 = p10 * 2.0f;
            float f14 = h11.y;
            rectF.set((f12 + f10) - f13, (f14 + f11) - f13, f12 + f10, f14 + f11);
            this.f12292a.arcTo(this.f12293b, 0.0f, 90.0f, false);
        }
        this.f12292a.lineTo((h11.x - f10) + p10, h11.y + f11);
        if (p10 > 0.0f) {
            RectF rectF2 = this.f12293b;
            float f15 = h11.x;
            float f16 = h11.y;
            float f17 = p10 * 2.0f;
            rectF2.set(f15 - f10, (f16 + f11) - f17, (f15 - f10) + f17, f16 + f11);
            this.f12292a.arcTo(this.f12293b, 90.0f, 90.0f, false);
        }
        this.f12292a.lineTo(h11.x - f10, (h11.y - f11) + p10);
        if (p10 > 0.0f) {
            RectF rectF3 = this.f12293b;
            float f18 = h11.x;
            float f19 = h11.y;
            float f20 = p10 * 2.0f;
            rectF3.set(f18 - f10, f19 - f11, (f18 - f10) + f20, (f19 - f11) + f20);
            this.f12292a.arcTo(this.f12293b, 180.0f, 90.0f, false);
        }
        this.f12292a.lineTo((h11.x + f10) - p10, h11.y - f11);
        if (p10 > 0.0f) {
            RectF rectF4 = this.f12293b;
            float f21 = h11.x;
            float f22 = p10 * 2.0f;
            float f23 = h11.y;
            rectF4.set((f21 + f10) - f22, f23 - f11, f21 + f10, (f23 - f11) + f22);
            this.f12292a.arcTo(this.f12293b, 270.0f, 90.0f, false);
        }
        this.f12292a.close();
        this.f12300i.b(this.f12292a);
        this.f12302k = true;
        return this.f12292a;
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        l6.g.k(eVar, i10, list, eVar2, this);
    }

    @Override // b6.c
    public String getName() {
        return this.f12294c;
    }

    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        if (t10 == com.oplus.anim.r.f26184l) {
            this.f12298g.n(c1336b);
        } else if (t10 == com.oplus.anim.r.f26186n) {
            this.f12297f.n(c1336b);
        } else if (t10 == com.oplus.anim.r.f26185m) {
            this.f12299h.n(c1336b);
        }
    }
}
