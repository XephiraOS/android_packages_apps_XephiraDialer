package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.circularreveal.c;
import r4.C1509a;

/* compiled from: CircularRevealHelper.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: j, reason: collision with root package name */
    public static final int f23078j = 2;

    /* renamed from: a, reason: collision with root package name */
    public final a f23079a;

    /* renamed from: b, reason: collision with root package name */
    public final View f23080b;

    /* renamed from: c, reason: collision with root package name */
    public final Path f23081c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f23082d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f23083e;

    /* renamed from: f, reason: collision with root package name */
    public c.e f23084f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f23085g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f23086h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23087i;

    /* compiled from: CircularRevealHelper.java */
    /* loaded from: classes3.dex */
    public interface a {
        void c(Canvas canvas);

        boolean d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f23079a = aVar;
        View view = (View) aVar;
        this.f23080b = view;
        view.setWillNotDraw(false);
        this.f23081c = new Path();
        this.f23082d = new Paint(7);
        Paint paint = new Paint(1);
        this.f23083e = paint;
        paint.setColor(0);
    }

    public void a() {
        if (f23078j == 0) {
            this.f23086h = true;
            this.f23087i = false;
            this.f23080b.buildDrawingCache();
            Bitmap drawingCache = this.f23080b.getDrawingCache();
            if (drawingCache == null && this.f23080b.getWidth() != 0 && this.f23080b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f23080b.getWidth(), this.f23080b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f23080b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f23082d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f23086h = false;
            this.f23087i = true;
        }
    }

    public void b() {
        if (f23078j == 0) {
            this.f23087i = false;
            this.f23080b.destroyDrawingCache();
            this.f23082d.setShader(null);
            this.f23080b.invalidate();
        }
    }

    public void c(Canvas canvas) {
        if (n()) {
            int i10 = f23078j;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        this.f23079a.c(canvas);
                        if (p()) {
                            canvas.drawRect(0.0f, 0.0f, this.f23080b.getWidth(), this.f23080b.getHeight(), this.f23083e);
                        }
                    } else {
                        throw new IllegalStateException("Unsupported strategy " + i10);
                    }
                } else {
                    int save = canvas.save();
                    canvas.clipPath(this.f23081c);
                    this.f23079a.c(canvas);
                    if (p()) {
                        canvas.drawRect(0.0f, 0.0f, this.f23080b.getWidth(), this.f23080b.getHeight(), this.f23083e);
                    }
                    canvas.restoreToCount(save);
                }
            } else {
                c.e eVar = this.f23084f;
                canvas.drawCircle(eVar.f23092a, eVar.f23093b, eVar.f23094c, this.f23082d);
                if (p()) {
                    c.e eVar2 = this.f23084f;
                    canvas.drawCircle(eVar2.f23092a, eVar2.f23093b, eVar2.f23094c, this.f23083e);
                }
            }
        } else {
            this.f23079a.c(canvas);
            if (p()) {
                canvas.drawRect(0.0f, 0.0f, this.f23080b.getWidth(), this.f23080b.getHeight(), this.f23083e);
            }
        }
        d(canvas);
    }

    public final void d(Canvas canvas) {
        if (o()) {
            Rect bounds = this.f23085g.getBounds();
            float width = this.f23084f.f23092a - (bounds.width() / 2.0f);
            float height = this.f23084f.f23093b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f23085g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public Drawable e() {
        return this.f23085g;
    }

    public int f() {
        return this.f23083e.getColor();
    }

    public final float g(c.e eVar) {
        return C1509a.b(eVar.f23092a, eVar.f23093b, 0.0f, 0.0f, this.f23080b.getWidth(), this.f23080b.getHeight());
    }

    public c.e h() {
        c.e eVar = this.f23084f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.f23094c = g(eVar2);
        }
        return eVar2;
    }

    public final void i() {
        if (f23078j == 1) {
            this.f23081c.rewind();
            c.e eVar = this.f23084f;
            if (eVar != null) {
                this.f23081c.addCircle(eVar.f23092a, eVar.f23093b, eVar.f23094c, Path.Direction.CW);
            }
        }
        this.f23080b.invalidate();
    }

    public boolean j() {
        if (this.f23079a.d() && !n()) {
            return true;
        }
        return false;
    }

    public void k(Drawable drawable) {
        this.f23085g = drawable;
        this.f23080b.invalidate();
    }

    public void l(int i10) {
        this.f23083e.setColor(i10);
        this.f23080b.invalidate();
    }

    public void m(c.e eVar) {
        if (eVar == null) {
            this.f23084f = null;
        } else {
            c.e eVar2 = this.f23084f;
            if (eVar2 == null) {
                this.f23084f = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (C1509a.c(eVar.f23094c, g(eVar), 1.0E-4f)) {
                this.f23084f.f23094c = Float.MAX_VALUE;
            }
        }
        i();
    }

    public final boolean n() {
        boolean z10;
        c.e eVar = this.f23084f;
        if (eVar != null && !eVar.a()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (f23078j == 0) {
            if (z10 || !this.f23087i) {
                return false;
            }
            return true;
        }
        return !z10;
    }

    public final boolean o() {
        if (!this.f23086h && this.f23085g != null && this.f23084f != null) {
            return true;
        }
        return false;
    }

    public final boolean p() {
        if (!this.f23086h && Color.alpha(this.f23083e.getColor()) != 0) {
            return true;
        }
        return false;
    }
}
