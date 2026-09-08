package x4;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w4.C1649a;

/* compiled from: ShapePath.java */
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f37965a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f37966b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f37967c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f37968d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f37969e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f37970f;

    /* renamed from: g, reason: collision with root package name */
    public final List<f> f37971g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List<g> f37972h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public boolean f37973i;

    /* compiled from: ShapePath.java */
    /* loaded from: classes3.dex */
    public class a extends g {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f37974c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f37975d;

        public a(List list, Matrix matrix) {
            this.f37974c = list;
            this.f37975d = matrix;
        }

        @Override // x4.p.g
        public void a(Matrix matrix, C1649a c1649a, int i10, Canvas canvas) {
            Iterator it = this.f37974c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f37975d, c1649a, i10, canvas);
            }
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes3.dex */
    public static class b extends g {

        /* renamed from: c, reason: collision with root package name */
        public final d f37977c;

        public b(d dVar) {
            this.f37977c = dVar;
        }

        @Override // x4.p.g
        public void a(Matrix matrix, C1649a c1649a, int i10, Canvas canvas) {
            c1649a.a(canvas, matrix, new RectF(this.f37977c.k(), this.f37977c.o(), this.f37977c.l(), this.f37977c.j()), i10, this.f37977c.m(), this.f37977c.n());
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes3.dex */
    public static class c extends g {

        /* renamed from: c, reason: collision with root package name */
        public final e f37978c;

        /* renamed from: d, reason: collision with root package name */
        public final float f37979d;

        /* renamed from: e, reason: collision with root package name */
        public final float f37980e;

        public c(e eVar, float f10, float f11) {
            this.f37978c = eVar;
            this.f37979d = f10;
            this.f37980e = f11;
        }

        @Override // x4.p.g
        public void a(Matrix matrix, C1649a c1649a, int i10, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f37978c.f37989c - this.f37980e, this.f37978c.f37988b - this.f37979d), 0.0f);
            this.f37992a.set(matrix);
            this.f37992a.preTranslate(this.f37979d, this.f37980e);
            this.f37992a.preRotate(c());
            c1649a.b(canvas, this.f37992a, rectF, i10);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f37978c.f37989c - this.f37980e) / (this.f37978c.f37988b - this.f37979d)));
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes3.dex */
    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        public static final RectF f37981h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f37982b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f37983c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f37984d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f37985e;

        /* renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f37986f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f37987g;

        public d(float f10, float f11, float f12, float f13) {
            q(f10);
            u(f11);
            r(f12);
            p(f13);
        }

        @Override // x4.p.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f37990a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f37981h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }

        public final float j() {
            return this.f37985e;
        }

        public final float k() {
            return this.f37982b;
        }

        public final float l() {
            return this.f37984d;
        }

        public final float m() {
            return this.f37986f;
        }

        public final float n() {
            return this.f37987g;
        }

        public final float o() {
            return this.f37983c;
        }

        public final void p(float f10) {
            this.f37985e = f10;
        }

        public final void q(float f10) {
            this.f37982b = f10;
        }

        public final void r(float f10) {
            this.f37984d = f10;
        }

        public final void s(float f10) {
            this.f37986f = f10;
        }

        public final void t(float f10) {
            this.f37987g = f10;
        }

        public final void u(float f10) {
            this.f37983c = f10;
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes3.dex */
    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        public float f37988b;

        /* renamed from: c, reason: collision with root package name */
        public float f37989c;

        @Override // x4.p.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f37990a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f37988b, this.f37989c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes3.dex */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f37990a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes3.dex */
    public static abstract class g {

        /* renamed from: b, reason: collision with root package name */
        public static final Matrix f37991b = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f37992a = new Matrix();

        public abstract void a(Matrix matrix, C1649a c1649a, int i10, Canvas canvas);

        public final void b(C1649a c1649a, int i10, Canvas canvas) {
            a(f37991b, c1649a, i10, canvas);
        }
    }

    public p() {
        n(0.0f, 0.0f);
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15) {
        boolean z10;
        float f16;
        d dVar = new d(f10, f11, f12, f13);
        dVar.s(f14);
        dVar.t(f15);
        this.f37971g.add(dVar);
        b bVar = new b(dVar);
        float f17 = f14 + f15;
        if (f15 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        if (z10) {
            f16 = (180.0f + f17) % 360.0f;
        } else {
            f16 = f17;
        }
        c(bVar, f14, f16);
        double d10 = f17;
        r(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        s(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public final void b(float f10) {
        if (g() == f10) {
            return;
        }
        float g10 = ((f10 - g()) + 360.0f) % 360.0f;
        if (g10 > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(g10);
        this.f37972h.add(new b(dVar));
        p(f10);
    }

    public final void c(g gVar, float f10, float f11) {
        b(f10);
        this.f37972h.add(gVar);
        p(f11);
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f37971g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f37971g.get(i10).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f37973i;
    }

    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f37972h), new Matrix(matrix));
    }

    public final float g() {
        return this.f37969e;
    }

    public final float h() {
        return this.f37970f;
    }

    public float i() {
        return this.f37967c;
    }

    public float j() {
        return this.f37968d;
    }

    public float k() {
        return this.f37965a;
    }

    public float l() {
        return this.f37966b;
    }

    public void m(float f10, float f11) {
        e eVar = new e();
        eVar.f37988b = f10;
        eVar.f37989c = f11;
        this.f37971g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f10);
        s(f11);
    }

    public void n(float f10, float f11) {
        o(f10, f11, 270.0f, 0.0f);
    }

    public void o(float f10, float f11, float f12, float f13) {
        t(f10);
        u(f11);
        r(f10);
        s(f11);
        p(f12);
        q((f12 + f13) % 360.0f);
        this.f37971g.clear();
        this.f37972h.clear();
        this.f37973i = false;
    }

    public final void p(float f10) {
        this.f37969e = f10;
    }

    public final void q(float f10) {
        this.f37970f = f10;
    }

    public final void r(float f10) {
        this.f37967c = f10;
    }

    public final void s(float f10) {
        this.f37968d = f10;
    }

    public final void t(float f10) {
        this.f37965a = f10;
    }

    public final void u(float f10) {
        this.f37966b = f10;
    }
}
