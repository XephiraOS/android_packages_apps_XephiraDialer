package b6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import c6.AbstractC0558a;
import com.oplus.anim.EffectiveAnimationDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import m6.C1336b;

/* compiled from: RepeaterContent.java */
/* loaded from: classes3.dex */
public class p implements e, m, j, AbstractC0558a.b, k {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f12303a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Path f12304b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12305c;

    /* renamed from: d, reason: collision with root package name */
    public final com.oplus.anim.model.layer.a f12306d;

    /* renamed from: e, reason: collision with root package name */
    public final String f12307e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12308f;

    /* renamed from: g, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12309g;

    /* renamed from: h, reason: collision with root package name */
    public final AbstractC0558a<Float, Float> f12310h;

    /* renamed from: i, reason: collision with root package name */
    public final c6.p f12311i;

    /* renamed from: j, reason: collision with root package name */
    public d f12312j;

    public p(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, g6.g gVar) {
        this.f12305c = effectiveAnimationDrawable;
        this.f12306d = aVar;
        this.f12307e = gVar.c();
        this.f12308f = gVar.f();
        AbstractC0558a<Float, Float> a10 = gVar.b().a();
        this.f12309g = a10;
        aVar.j(a10);
        a10.a(this);
        AbstractC0558a<Float, Float> a11 = gVar.d().a();
        this.f12310h = a11;
        aVar.j(a11);
        a11.a(this);
        c6.p b10 = gVar.e().b();
        this.f12311i = b10;
        b10.a(aVar);
        b10.b(this);
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        this.f12305c.invalidateSelf();
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        this.f12312j.b(list, list2);
    }

    @Override // b6.m
    public Path d() {
        Path d10 = this.f12312j.d();
        this.f12304b.reset();
        float floatValue = this.f12309g.h().floatValue();
        float floatValue2 = this.f12310h.h().floatValue();
        for (int i10 = ((int) floatValue) - 1; i10 >= 0; i10--) {
            this.f12303a.set(this.f12311i.g(i10 + floatValue2));
            this.f12304b.addPath(d10, this.f12303a);
        }
        return this.f12304b;
    }

    @Override // b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f12312j.e(rectF, matrix, z10);
    }

    @Override // b6.j
    public void f(ListIterator<c> listIterator) {
        if (this.f12312j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f12312j = new d(this.f12305c, this.f12306d, "Repeater", this.f12308f, arrayList, null);
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        l6.g.k(eVar, i10, list, eVar2, this);
        for (int i11 = 0; i11 < this.f12312j.k().size(); i11++) {
            c cVar = this.f12312j.k().get(i11);
            if (cVar instanceof k) {
                l6.g.k(eVar, i10, list, eVar2, (k) cVar);
            }
        }
    }

    @Override // b6.c
    public String getName() {
        return this.f12307e;
    }

    @Override // b6.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        float floatValue = this.f12309g.h().floatValue();
        float floatValue2 = this.f12310h.h().floatValue();
        float floatValue3 = this.f12311i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.f12311i.e().h().floatValue() / 100.0f;
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.f12303a.set(matrix);
            float f10 = i11;
            this.f12303a.preConcat(this.f12311i.g(f10 + floatValue2));
            this.f12312j.h(canvas, this.f12303a, (int) (i10 * l6.g.i(floatValue3, floatValue4, f10 / floatValue)));
        }
    }

    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        if (this.f12311i.c(t10, c1336b)) {
            return;
        }
        if (t10 == com.oplus.anim.r.f26193u) {
            this.f12309g.n(c1336b);
        } else if (t10 == com.oplus.anim.r.f26194v) {
            this.f12310h.n(c1336b);
        }
    }
}
