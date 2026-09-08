package x4;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: ShapeAppearancePathProvider.java */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final p[] f37947a = new p[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f37948b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f37949c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f37950d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f37951e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f37952f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final p f37953g = new p();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f37954h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f37955i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f37956j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f37957k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public boolean f37958l = true;

    /* compiled from: ShapeAppearancePathProvider.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final o f37959a = new o();
    }

    /* compiled from: ShapeAppearancePathProvider.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(p pVar, Matrix matrix, int i10);

        void b(p pVar, Matrix matrix, int i10);
    }

    /* compiled from: ShapeAppearancePathProvider.java */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final n f37960a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f37961b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f37962c;

        /* renamed from: d, reason: collision with root package name */
        public final b f37963d;

        /* renamed from: e, reason: collision with root package name */
        public final float f37964e;

        public c(n nVar, float f10, RectF rectF, b bVar, Path path) {
            this.f37963d = bVar;
            this.f37960a = nVar;
            this.f37964e = f10;
            this.f37962c = rectF;
            this.f37961b = path;
        }
    }

    public o() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f37947a[i10] = new p();
            this.f37948b[i10] = new Matrix();
            this.f37949c[i10] = new Matrix();
        }
    }

    public static o k() {
        return a.f37959a;
    }

    public final float a(int i10) {
        return ((i10 + 1) % 4) * 90;
    }

    public final void b(c cVar, int i10) {
        this.f37954h[0] = this.f37947a[i10].k();
        this.f37954h[1] = this.f37947a[i10].l();
        this.f37948b[i10].mapPoints(this.f37954h);
        if (i10 == 0) {
            Path path = cVar.f37961b;
            float[] fArr = this.f37954h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f37961b;
            float[] fArr2 = this.f37954h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f37947a[i10].d(this.f37948b[i10], cVar.f37961b);
        b bVar = cVar.f37963d;
        if (bVar != null) {
            bVar.b(this.f37947a[i10], this.f37948b[i10], i10);
        }
    }

    public final void c(c cVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.f37954h[0] = this.f37947a[i10].i();
        this.f37954h[1] = this.f37947a[i10].j();
        this.f37948b[i10].mapPoints(this.f37954h);
        this.f37955i[0] = this.f37947a[i11].k();
        this.f37955i[1] = this.f37947a[i11].l();
        this.f37948b[i11].mapPoints(this.f37955i);
        float f10 = this.f37954h[0];
        float[] fArr = this.f37955i;
        float max = Math.max(((float) Math.hypot(f10 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float i12 = i(cVar.f37962c, i10);
        this.f37953g.n(0.0f, 0.0f);
        g j10 = j(i10, cVar.f37960a);
        j10.b(max, i12, cVar.f37964e, this.f37953g);
        this.f37956j.reset();
        this.f37953g.d(this.f37949c[i10], this.f37956j);
        if (this.f37958l && (j10.a() || l(this.f37956j, i10) || l(this.f37956j, i11))) {
            Path path = this.f37956j;
            path.op(path, this.f37952f, Path.Op.DIFFERENCE);
            this.f37954h[0] = this.f37953g.k();
            this.f37954h[1] = this.f37953g.l();
            this.f37949c[i10].mapPoints(this.f37954h);
            Path path2 = this.f37951e;
            float[] fArr2 = this.f37954h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f37953g.d(this.f37949c[i10], this.f37951e);
        } else {
            this.f37953g.d(this.f37949c[i10], cVar.f37961b);
        }
        b bVar = cVar.f37963d;
        if (bVar != null) {
            bVar.a(this.f37953g, this.f37949c[i10], i10);
        }
    }

    public void d(n nVar, float f10, RectF rectF, Path path) {
        e(nVar, f10, rectF, null, path);
    }

    public void e(n nVar, float f10, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f37951e.rewind();
        this.f37952f.rewind();
        this.f37952f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(nVar, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            m(cVar, i10);
            o(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            b(cVar, i11);
            c(cVar, i11);
        }
        path.close();
        this.f37951e.close();
        if (!this.f37951e.isEmpty()) {
            path.op(this.f37951e, Path.Op.UNION);
        }
    }

    public final void f(int i10, RectF rectF, PointF pointF) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    pointF.set(rectF.right, rectF.top);
                    return;
                } else {
                    pointF.set(rectF.left, rectF.top);
                    return;
                }
            }
            pointF.set(rectF.left, rectF.bottom);
            return;
        }
        pointF.set(rectF.right, rectF.bottom);
    }

    public final d g(int i10, n nVar) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return nVar.t();
                }
                return nVar.r();
            }
            return nVar.j();
        }
        return nVar.l();
    }

    public final e h(int i10, n nVar) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return nVar.s();
                }
                return nVar.q();
            }
            return nVar.i();
        }
        return nVar.k();
    }

    public final float i(RectF rectF, int i10) {
        float[] fArr = this.f37954h;
        p pVar = this.f37947a[i10];
        fArr[0] = pVar.f37967c;
        fArr[1] = pVar.f37968d;
        this.f37948b[i10].mapPoints(fArr);
        if (i10 != 1 && i10 != 3) {
            return Math.abs(rectF.centerY() - this.f37954h[1]);
        }
        return Math.abs(rectF.centerX() - this.f37954h[0]);
    }

    public final g j(int i10, n nVar) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return nVar.o();
                }
                return nVar.p();
            }
            return nVar.n();
        }
        return nVar.h();
    }

    public final boolean l(Path path, int i10) {
        this.f37957k.reset();
        this.f37947a[i10].d(this.f37948b[i10], this.f37957k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f37957k.computeBounds(rectF, true);
        path.op(this.f37957k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
            return true;
        }
        return false;
    }

    public final void m(c cVar, int i10) {
        h(i10, cVar.f37960a).b(this.f37947a[i10], 90.0f, cVar.f37964e, cVar.f37962c, g(i10, cVar.f37960a));
        float a10 = a(i10);
        this.f37948b[i10].reset();
        f(i10, cVar.f37962c, this.f37950d);
        Matrix matrix = this.f37948b[i10];
        PointF pointF = this.f37950d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f37948b[i10].preRotate(a10);
    }

    public void n(boolean z10) {
        this.f37958l = z10;
    }

    public final void o(int i10) {
        this.f37954h[0] = this.f37947a[i10].i();
        this.f37954h[1] = this.f37947a[i10].j();
        this.f37948b[i10].mapPoints(this.f37954h);
        float a10 = a(i10);
        this.f37949c[i10].reset();
        Matrix matrix = this.f37949c[i10];
        float[] fArr = this.f37954h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f37949c[i10].preRotate(a10);
    }
}
