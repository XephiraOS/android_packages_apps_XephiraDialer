package t4;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import l4.C1292a;
import r4.C1509a;
import t4.g;

/* compiled from: LinearDrawingDelegate.java */
/* loaded from: classes3.dex */
public final class j extends g<LinearProgressIndicatorSpec> {

    /* renamed from: b, reason: collision with root package name */
    public float f37242b;

    /* renamed from: c, reason: collision with root package name */
    public float f37243c;

    /* renamed from: d, reason: collision with root package name */
    public float f37244d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f37245e;

    /* renamed from: f, reason: collision with root package name */
    public float f37246f;

    public j(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f37242b = 300.0f;
    }

    @Override // t4.g
    public void a(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11) {
        boolean z12;
        this.f37242b = rect.width();
        float f11 = ((LinearProgressIndicatorSpec) this.f37232a).f37182a;
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - f11) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f37232a).f23522j) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f12 = this.f37242b / 2.0f;
        float f13 = f11 / 2.0f;
        canvas.clipRect(-f12, -f13, f12, f13);
        S s10 = this.f37232a;
        if (((LinearProgressIndicatorSpec) s10).f37182a / 2 == ((LinearProgressIndicatorSpec) s10).f37183b) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.f37245e = z12;
        this.f37243c = ((LinearProgressIndicatorSpec) s10).f37182a * f10;
        this.f37244d = Math.min(((LinearProgressIndicatorSpec) s10).f37182a / 2, ((LinearProgressIndicatorSpec) s10).f37183b) * f10;
        if (z10 || z11) {
            if ((z10 && ((LinearProgressIndicatorSpec) this.f37232a).f37186e == 2) || (z11 && ((LinearProgressIndicatorSpec) this.f37232a).f37187f == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z10 || (z11 && ((LinearProgressIndicatorSpec) this.f37232a).f37187f != 3)) {
                canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.f37232a).f37182a * (1.0f - f10)) / 2.0f);
            }
        }
        if (z11 && ((LinearProgressIndicatorSpec) this.f37232a).f37187f == 3) {
            this.f37246f = f10;
        } else {
            this.f37246f = 1.0f;
        }
    }

    @Override // t4.g
    public void b(Canvas canvas, Paint paint, int i10, int i11) {
        int a10 = C1292a.a(i10, i11);
        if (((LinearProgressIndicatorSpec) this.f37232a).f23523k > 0 && a10 != 0) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(a10);
            PointF pointF = new PointF((this.f37242b / 2.0f) - (this.f37243c / 2.0f), 0.0f);
            S s10 = this.f37232a;
            i(canvas, paint, pointF, ((LinearProgressIndicatorSpec) s10).f23523k, ((LinearProgressIndicatorSpec) s10).f23523k);
        }
    }

    @Override // t4.g
    public void c(Canvas canvas, Paint paint, g.a aVar, int i10) {
        int a10 = C1292a.a(aVar.f37235c, i10);
        float f10 = aVar.f37233a;
        float f11 = aVar.f37234b;
        int i11 = aVar.f37236d;
        h(canvas, paint, f10, f11, a10, i11, i11);
    }

    @Override // t4.g
    public void d(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12) {
        h(canvas, paint, f10, f11, C1292a.a(i10, i11), i12, i12);
    }

    @Override // t4.g
    public int e() {
        return ((LinearProgressIndicatorSpec) this.f37232a).f37182a;
    }

    @Override // t4.g
    public int f() {
        return -1;
    }

    public final void h(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12) {
        Paint.Cap cap;
        float a10 = E.a.a(f10, 0.0f, 1.0f);
        float a11 = E.a.a(f11, 0.0f, 1.0f);
        float d10 = C1509a.d(1.0f - this.f37246f, 1.0f, a10);
        float d11 = C1509a.d(1.0f - this.f37246f, 1.0f, a11);
        int a12 = (int) ((i11 * E.a.a(d10, 0.0f, 0.01f)) / 0.01f);
        int a13 = (int) ((i12 * (1.0f - E.a.a(d11, 0.99f, 1.0f))) / 0.01f);
        float f12 = this.f37242b;
        int i13 = (int) ((d10 * f12) + a12);
        int i14 = (int) ((d11 * f12) - a13);
        float f13 = (-f12) / 2.0f;
        if (i13 <= i14) {
            float f14 = this.f37244d;
            float f15 = i13 + f14;
            float f16 = i14 - f14;
            float f17 = f14 * 2.0f;
            paint.setColor(i10);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.f37243c);
            if (f15 >= f16) {
                j(canvas, paint, new PointF(f15 + f13, 0.0f), new PointF(f16 + f13, 0.0f), f17, this.f37243c);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            if (this.f37245e) {
                cap = Paint.Cap.ROUND;
            } else {
                cap = Paint.Cap.BUTT;
            }
            paint.setStrokeCap(cap);
            float f18 = f15 + f13;
            float f19 = f16 + f13;
            canvas.drawLine(f18, 0.0f, f19, 0.0f, paint);
            if (!this.f37245e && this.f37244d > 0.0f) {
                paint.setStyle(Paint.Style.FILL);
                if (f15 > 0.0f) {
                    i(canvas, paint, new PointF(f18, 0.0f), f17, this.f37243c);
                }
                if (f16 < this.f37242b) {
                    i(canvas, paint, new PointF(f19, 0.0f), f17, this.f37243c);
                }
            }
        }
    }

    public final void i(Canvas canvas, Paint paint, PointF pointF, float f10, float f11) {
        j(canvas, paint, pointF, null, f10, f11);
    }

    public final void j(Canvas canvas, Paint paint, PointF pointF, PointF pointF2, float f10, float f11) {
        float min = Math.min(f11, this.f37243c);
        float f12 = f10 / 2.0f;
        float min2 = Math.min(f12, (this.f37244d * min) / this.f37243c);
        RectF rectF = new RectF((-f10) / 2.0f, (-min) / 2.0f, f12, min / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, min2, min2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }
}
