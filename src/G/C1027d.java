package g;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import e.C0961a;
import e.i;
import e.j;

/* compiled from: DrawerArrowDrawable.java */
/* renamed from: g.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1027d extends Drawable {

    /* renamed from: m, reason: collision with root package name */
    public static final float f31803m = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    public final Paint f31804a;

    /* renamed from: b, reason: collision with root package name */
    public float f31805b;

    /* renamed from: c, reason: collision with root package name */
    public float f31806c;

    /* renamed from: d, reason: collision with root package name */
    public float f31807d;

    /* renamed from: e, reason: collision with root package name */
    public float f31808e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f31809f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f31810g;

    /* renamed from: h, reason: collision with root package name */
    public final int f31811h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f31812i;

    /* renamed from: j, reason: collision with root package name */
    public float f31813j;

    /* renamed from: k, reason: collision with root package name */
    public float f31814k;

    /* renamed from: l, reason: collision with root package name */
    public int f31815l;

    public C1027d(Context context) {
        Paint paint = new Paint();
        this.f31804a = paint;
        this.f31810g = new Path();
        this.f31812i = false;
        this.f31815l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, j.f30420b1, C0961a.f30084B, i.f30277a);
        c(obtainStyledAttributes.getColor(j.f30442f1, 0));
        b(obtainStyledAttributes.getDimension(j.f30462j1, 0.0f));
        f(obtainStyledAttributes.getBoolean(j.f30457i1, true));
        d(Math.round(obtainStyledAttributes.getDimension(j.f30452h1, 0.0f)));
        this.f31811h = obtainStyledAttributes.getDimensionPixelSize(j.f30447g1, 0);
        this.f31806c = Math.round(obtainStyledAttributes.getDimension(j.f30437e1, 0.0f));
        this.f31805b = Math.round(obtainStyledAttributes.getDimension(j.f30426c1, 0.0f));
        this.f31807d = obtainStyledAttributes.getDimension(j.f30432d1, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public void b(float f10) {
        if (this.f31804a.getStrokeWidth() != f10) {
            this.f31804a.setStrokeWidth(f10);
            this.f31814k = (float) ((f10 / 2.0f) * Math.cos(f31803m));
            invalidateSelf();
        }
    }

    public void c(int i10) {
        if (i10 != this.f31804a.getColor()) {
            this.f31804a.setColor(i10);
            invalidateSelf();
        }
    }

    public void d(float f10) {
        if (f10 != this.f31808e) {
            this.f31808e = f10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f10;
        float f11;
        int i10;
        Rect bounds = getBounds();
        int i11 = this.f31815l;
        boolean z10 = false;
        if (i11 != 0 && (i11 == 1 || (i11 == 3 ? C.a.f(this) == 0 : C.a.f(this) == 1))) {
            z10 = true;
        }
        float f12 = this.f31805b;
        float a10 = a(this.f31806c, (float) Math.sqrt(f12 * f12 * 2.0f), this.f31813j);
        float a11 = a(this.f31806c, this.f31807d, this.f31813j);
        float round = Math.round(a(0.0f, this.f31814k, this.f31813j));
        float a12 = a(0.0f, f31803m, this.f31813j);
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = -180.0f;
        }
        if (z10) {
            f11 = 180.0f;
        } else {
            f11 = 0.0f;
        }
        float a13 = a(f10, f11, this.f31813j);
        double d10 = a10;
        double d11 = a12;
        boolean z11 = z10;
        float round2 = (float) Math.round(Math.cos(d11) * d10);
        float round3 = (float) Math.round(d10 * Math.sin(d11));
        this.f31810g.rewind();
        float a14 = a(this.f31808e + this.f31804a.getStrokeWidth(), -this.f31814k, this.f31813j);
        float f13 = (-a11) / 2.0f;
        this.f31810g.moveTo(f13 + round, 0.0f);
        this.f31810g.rLineTo(a11 - (round * 2.0f), 0.0f);
        this.f31810g.moveTo(f13, a14);
        this.f31810g.rLineTo(round2, round3);
        this.f31810g.moveTo(f13, -a14);
        this.f31810g.rLineTo(round2, -round3);
        this.f31810g.close();
        canvas.save();
        float strokeWidth = this.f31804a.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f31808e);
        if (this.f31809f) {
            if (this.f31812i ^ z11) {
                i10 = -1;
            } else {
                i10 = 1;
            }
            canvas.rotate(a13 * i10);
        } else if (z11) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f31810g, this.f31804a);
        canvas.restore();
    }

    public void e(float f10) {
        if (this.f31813j != f10) {
            this.f31813j = f10;
            invalidateSelf();
        }
    }

    public void f(boolean z10) {
        if (this.f31809f != z10) {
            this.f31809f = z10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f31811h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f31811h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f31804a.getAlpha()) {
            this.f31804a.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f31804a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
