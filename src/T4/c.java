package t4;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;
import l4.C1292a;
import r4.C1509a;
import t4.g;

/* compiled from: CircularDrawingDelegate.java */
/* loaded from: classes3.dex */
public final class c extends g<CircularProgressIndicatorSpec> {

    /* renamed from: b, reason: collision with root package name */
    public float f37189b;

    /* renamed from: c, reason: collision with root package name */
    public float f37190c;

    /* renamed from: d, reason: collision with root package name */
    public float f37191d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f37192e;

    /* renamed from: f, reason: collision with root package name */
    public float f37193f;

    public c(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    @Override // t4.g
    public void a(Canvas canvas, Rect rect, float f10, boolean z10, boolean z11) {
        boolean z12;
        float width = rect.width() / f();
        float height = rect.height() / e();
        S s10 = this.f37232a;
        float f11 = (((CircularProgressIndicatorSpec) s10).f23516h / 2.0f) + ((CircularProgressIndicatorSpec) s10).f23517i;
        canvas.translate((f11 * width) + rect.left, (f11 * height) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((CircularProgressIndicatorSpec) this.f37232a).f23518j != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f12 = -f11;
        canvas.clipRect(f12, f12, f11, f11);
        S s11 = this.f37232a;
        if (((CircularProgressIndicatorSpec) s11).f37182a / 2 <= ((CircularProgressIndicatorSpec) s11).f37183b) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.f37192e = z12;
        this.f37189b = ((CircularProgressIndicatorSpec) s11).f37182a * f10;
        this.f37190c = Math.min(((CircularProgressIndicatorSpec) s11).f37182a / 2, ((CircularProgressIndicatorSpec) s11).f37183b) * f10;
        S s12 = this.f37232a;
        float f13 = (((CircularProgressIndicatorSpec) s12).f23516h - ((CircularProgressIndicatorSpec) s12).f37182a) / 2.0f;
        this.f37191d = f13;
        if (z10 || z11) {
            if ((z10 && ((CircularProgressIndicatorSpec) s12).f37186e == 2) || (z11 && ((CircularProgressIndicatorSpec) s12).f37187f == 1)) {
                this.f37191d = f13 + (((1.0f - f10) * ((CircularProgressIndicatorSpec) s12).f37182a) / 2.0f);
            } else if ((z10 && ((CircularProgressIndicatorSpec) s12).f37186e == 1) || (z11 && ((CircularProgressIndicatorSpec) s12).f37187f == 2)) {
                this.f37191d = f13 - (((1.0f - f10) * ((CircularProgressIndicatorSpec) s12).f37182a) / 2.0f);
            }
        }
        if (z11 && ((CircularProgressIndicatorSpec) s12).f37187f == 3) {
            this.f37193f = f10;
        } else {
            this.f37193f = 1.0f;
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
        return k();
    }

    @Override // t4.g
    public int f() {
        return k();
    }

    public final void h(Canvas canvas, Paint paint, float f10, float f11, int i10, int i11, int i12) {
        float f12;
        Paint.Cap cap;
        if (f11 >= f10) {
            f12 = f11 - f10;
        } else {
            f12 = (f11 + 1.0f) - f10;
        }
        float f13 = f10 % 1.0f;
        if (this.f37193f < 1.0f) {
            float f14 = f13 + f12;
            if (f14 > 1.0f) {
                h(canvas, paint, f13, 1.0f, i10, i11, 0);
                h(canvas, paint, 1.0f, f14, i10, 0, i12);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.f37190c / this.f37191d);
        if (f13 == 0.0f && f12 >= 0.99f) {
            f12 += ((f12 - 0.99f) * ((degrees * 2.0f) / 360.0f)) / 0.01f;
        }
        float d10 = C1509a.d(1.0f - this.f37193f, 1.0f, f13);
        float d11 = C1509a.d(0.0f, this.f37193f, f12);
        float degrees2 = (float) Math.toDegrees(i11 / this.f37191d);
        float degrees3 = ((d11 * 360.0f) - degrees2) - ((float) Math.toDegrees(i12 / this.f37191d));
        float f15 = (d10 * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i10);
        paint.setStrokeWidth(this.f37189b);
        float f16 = degrees * 2.0f;
        if (degrees3 < f16) {
            float f17 = degrees3 / f16;
            paint.setStyle(Paint.Style.FILL);
            j(canvas, paint, f15 + (degrees * f17), this.f37190c * 2.0f, this.f37189b, f17);
            return;
        }
        float f18 = this.f37191d;
        RectF rectF = new RectF(-f18, -f18, f18, f18);
        paint.setStyle(Paint.Style.STROKE);
        if (this.f37192e) {
            cap = Paint.Cap.ROUND;
        } else {
            cap = Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
        float f19 = f15 + degrees;
        canvas.drawArc(rectF, f19, degrees3 - f16, false, paint);
        if (!this.f37192e && this.f37190c > 0.0f) {
            paint.setStyle(Paint.Style.FILL);
            i(canvas, paint, f19, this.f37190c * 2.0f, this.f37189b);
            i(canvas, paint, (f15 + degrees3) - degrees, this.f37190c * 2.0f, this.f37189b);
        }
    }

    public final void i(Canvas canvas, Paint paint, float f10, float f11, float f12) {
        j(canvas, paint, f10, f11, f12, 1.0f);
    }

    public final void j(Canvas canvas, Paint paint, float f10, float f11, float f12, float f13) {
        float min = (int) Math.min(f12, this.f37189b);
        float f14 = f11 / 2.0f;
        float min2 = Math.min(f14, (this.f37190c * min) / this.f37189b);
        RectF rectF = new RectF((-min) / 2.0f, (-f11) / 2.0f, min / 2.0f, f14);
        canvas.save();
        double d10 = f10;
        canvas.translate((float) (this.f37191d * Math.cos(Math.toRadians(d10))), (float) (this.f37191d * Math.sin(Math.toRadians(d10))));
        canvas.rotate(f10);
        canvas.scale(f13, f13);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    public final int k() {
        S s10 = this.f37232a;
        return ((CircularProgressIndicatorSpec) s10).f23516h + (((CircularProgressIndicatorSpec) s10).f23517i * 2);
    }

    @Override // t4.g
    public void b(Canvas canvas, Paint paint, int i10, int i11) {
    }
}
