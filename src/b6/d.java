package b6;

import a6.C0423a;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import c6.AbstractC0558a;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import java.util.ArrayList;
import java.util.List;
import m6.C1336b;

/* compiled from: ContentGroup.java */
/* loaded from: classes3.dex */
public class d implements e, m, AbstractC0558a.b, e6.f {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f12205a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f12206b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f12207c;

    /* renamed from: d, reason: collision with root package name */
    public final Path f12208d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f12209e;

    /* renamed from: f, reason: collision with root package name */
    public final String f12210f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f12211g;

    /* renamed from: h, reason: collision with root package name */
    public final List<c> f12212h;

    /* renamed from: i, reason: collision with root package name */
    public final EffectiveAnimationDrawable f12213i;

    /* renamed from: j, reason: collision with root package name */
    public List<m> f12214j;

    /* renamed from: k, reason: collision with root package name */
    public c6.p f12215k;

    public d(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, g6.k kVar, C0820a c0820a) {
        this(effectiveAnimationDrawable, aVar, kVar.c(), kVar.d(), f(effectiveAnimationDrawable, c0820a, aVar, kVar.b()), j(kVar.b()));
    }

    public static List<c> f(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar, List<g6.c> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            c a10 = list.get(i10).a(effectiveAnimationDrawable, c0820a, aVar);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    public static f6.l j(List<g6.c> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            g6.c cVar = list.get(i10);
            if (cVar instanceof f6.l) {
                return (f6.l) cVar;
            }
        }
        return null;
    }

    @Override // c6.AbstractC0558a.b
    public void a() {
        this.f12213i.invalidateSelf();
    }

    @Override // b6.c
    public void b(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f12212h.size());
        arrayList.addAll(list);
        for (int size = this.f12212h.size() - 1; size >= 0; size--) {
            c cVar = this.f12212h.get(size);
            cVar.b(arrayList, this.f12212h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // b6.m
    public Path d() {
        this.f12207c.reset();
        c6.p pVar = this.f12215k;
        if (pVar != null) {
            this.f12207c.set(pVar.f());
        }
        this.f12208d.reset();
        if (this.f12211g) {
            return this.f12208d;
        }
        for (int size = this.f12212h.size() - 1; size >= 0; size--) {
            c cVar = this.f12212h.get(size);
            if (cVar instanceof m) {
                this.f12208d.addPath(((m) cVar).d(), this.f12207c);
            }
        }
        return this.f12208d;
    }

    @Override // b6.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f12207c.set(matrix);
        c6.p pVar = this.f12215k;
        if (pVar != null) {
            this.f12207c.preConcat(pVar.f());
        }
        this.f12209e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f12212h.size() - 1; size >= 0; size--) {
            c cVar = this.f12212h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).e(this.f12209e, this.f12207c, z10);
                rectF.union(this.f12209e);
            }
        }
    }

    @Override // e6.f
    public void g(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2) {
        if (!eVar.g(getName(), i10) && !"__container".equals(getName())) {
            return;
        }
        if (!"__container".equals(getName())) {
            eVar2 = eVar2.a(getName());
            if (eVar.c(getName(), i10)) {
                list.add(eVar2.i(this));
            }
        }
        if (eVar.h(getName(), i10)) {
            int e10 = i10 + eVar.e(getName(), i10);
            for (int i11 = 0; i11 < this.f12212h.size(); i11++) {
                c cVar = this.f12212h.get(i11);
                if (cVar instanceof e6.f) {
                    ((e6.f) cVar).g(eVar, e10, list, eVar2);
                }
            }
        }
    }

    @Override // b6.c
    public String getName() {
        return this.f12210f;
    }

    @Override // b6.e
    public void h(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        int intValue;
        if (this.f12211g) {
            return;
        }
        this.f12207c.set(matrix);
        c6.p pVar = this.f12215k;
        if (pVar != null) {
            this.f12207c.preConcat(pVar.f());
            if (this.f12215k.h() == null) {
                intValue = 100;
            } else {
                intValue = this.f12215k.h().h().intValue();
            }
            i10 = (int) ((((intValue / 100.0f) * i10) / 255.0f) * 255.0f);
        }
        if (this.f12213i.i0() && n() && i10 != 255) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f12206b.set(0.0f, 0.0f, 0.0f, 0.0f);
            e(this.f12206b, this.f12207c, true);
            this.f12205a.setAlpha(i10);
            l6.h.n(canvas, this.f12206b, this.f12205a);
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.f12212h.size() - 1; size >= 0; size--) {
            c cVar = this.f12212h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).h(canvas, this.f12207c, i10);
            }
        }
        if (z10) {
            canvas.restore();
        }
    }

    @Override // e6.f
    public <T> void i(T t10, C1336b<T> c1336b) {
        c6.p pVar = this.f12215k;
        if (pVar != null) {
            pVar.c(t10, c1336b);
        }
    }

    public List<c> k() {
        return this.f12212h;
    }

    public List<m> l() {
        if (this.f12214j == null) {
            this.f12214j = new ArrayList();
            for (int i10 = 0; i10 < this.f12212h.size(); i10++) {
                c cVar = this.f12212h.get(i10);
                if (cVar instanceof m) {
                    this.f12214j.add((m) cVar);
                }
            }
        }
        return this.f12214j;
    }

    public Matrix m() {
        c6.p pVar = this.f12215k;
        if (pVar != null) {
            return pVar.f();
        }
        this.f12207c.reset();
        return this.f12207c;
    }

    public final boolean n() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f12212h.size(); i11++) {
            if ((this.f12212h.get(i11) instanceof e) && (i10 = i10 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public d(EffectiveAnimationDrawable effectiveAnimationDrawable, com.oplus.anim.model.layer.a aVar, String str, boolean z10, List<c> list, f6.l lVar) {
        this.f12205a = new C0423a();
        this.f12206b = new RectF();
        this.f12207c = new Matrix();
        this.f12208d = new Path();
        this.f12209e = new RectF();
        this.f12210f = str;
        this.f12213i = effectiveAnimationDrawable;
        this.f12211g = z10;
        this.f12212h = list;
        if (lVar != null) {
            c6.p b10 = lVar.b();
            this.f12215k = b10;
            b10.a(aVar);
            this.f12215k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).f(list.listIterator(list.size()));
        }
    }
}
