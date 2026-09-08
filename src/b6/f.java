package b6;

import android.graphics.Path;
import android.graphics.PointF;
import c6.AbstractC0558a;
import com.oplus.anim.EffectiveAnimationDrawable;
import com.oplus.anim.model.content.ShapeTrimPath;
import g6.C1049b;
import java.util.List;
import m6.C1336b;

/* compiled from: EllipseContent.java */
/* loaded from: classes3.dex */
public class f implements m, AbstractC0558a.b, k {

    /* renamed from: b, reason: collision with root package name */
    public final String f12217b;

    /* renamed from: c, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12218c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0558a<?, PointF> f12219d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0558a<?, PointF> f12220e;

    /* renamed from: f, reason: collision with root package name */
    public final C1049b f12221f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12223h;

    /* renamed from: a, reason: collision with root package name */
    public final Path f12216a = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final b f12222g = new b();

    public f(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, C1049b c1049b) {
        this.f12217b = c1049b.b();
        this.f12218c = effectiveAnimationDrawable;
        AbstractC0558a<PointF, PointF> a10 = c1049b.d().a();
        this.f12219d = a10;
        AbstractC0558a<PointF, PointF> a11 = c1049b.c().a();
        this.f12220e = a11;
        this.f12221f = c1049b;
        aVar.j(a10);
        aVar.j(a11);
        a10.a(this);
        a11.a(this);
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
                    this.f12222g.a(uVar);
                    uVar.f(this);
                }
            }
        }
    }

    @Override // b6.m
    public Path d() {
        if (this.f12223h) {
            return this.f12216a;
        }
        this.f12216a.reset();
        if (this.f12221f.e()) {
            this.f12223h = true;
            return this.f12216a;
        }
        PointF h10 = this.f12219d.h();
        float f10 = h10.x / 2.0f;
        float f11 = h10.y / 2.0f;
        float f12 = f10 * 0.55228f;
        float f13 = 0.55228f * f11;
        this.f12216a.reset();
        if (this.f12221f.f()) {
            float f14 = -f11;
            this.f12216a.moveTo(0.0f, f14);
            float f15 = 0.0f - f12;
            float f16 = -f10;
            float f17 = 0.0f - f13;
            this.f12216a.cubicTo(f15, f14, f16, f17, f16, 0.0f);
            float f18 = f13 + 0.0f;
            this.f12216a.cubicTo(f16, f18, f15, f11, 0.0f, f11);
            float f19 = f12 + 0.0f;
            this.f12216a.cubicTo(f19, f11, f10, f18, f10, 0.0f);
            this.f12216a.cubicTo(f10, f17, f19, f14, 0.0f, f14);
        } else {
            float f20 = -f11;
            this.f12216a.moveTo(0.0f, f20);
            float f21 = f12 + 0.0f;
            float f22 = 0.0f - f13;
            this.f12216a.cubicTo(f21, f20, f10, f22, f10, 0.0f);
            float f23 = f13 + 0.0f;
            this.f12216a.cubicTo(f10, f23, f21, f11, 0.0f, f11);
            float f24 = 0.0f - f12;
            float f25 = -f10;
            this.f12216a.cubicTo(f24, f11, f25, f23, f25, 0.0f);
            this.f12216a.cubicTo(f25, f22, f24, f20, 0.0f, f20);
        }
        PointF h11 = this.f12220e.h();
        this.f12216a.offset(h11.x, h11.y);
        this.f12216a.close();
        this.f12222g.b(this.f12216a);
        this.f12223h = true;
        return this.f12216a;
    }

    public final void f() {
        this.f12223h = false;
        this.f12218c.invalidateSelf();
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        l6.g.k(eVar, i10, list, eVar2, this);
    }

    @Override // b6.c
    public String getName() {
        return this.f12217b;
    }

    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        if (t10 == com.oplus.anim.r.f26183k) {
            this.f12219d.n(c1336b);
        } else if (t10 == com.oplus.anim.r.f26186n) {
            this.f12220e.n(c1336b);
        }
    }
}
