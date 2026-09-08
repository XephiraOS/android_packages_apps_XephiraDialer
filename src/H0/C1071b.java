package h0;

import I.h;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: CircularProgressDrawable.java */
/* renamed from: h0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1071b extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f32002g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    public static final Interpolator f32003h = new T.b();

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f32004i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    public final c f32005a;

    /* renamed from: b, reason: collision with root package name */
    public float f32006b;

    /* renamed from: c, reason: collision with root package name */
    public Resources f32007c;

    /* renamed from: d, reason: collision with root package name */
    public Animator f32008d;

    /* renamed from: e, reason: collision with root package name */
    public float f32009e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f32010f;

    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: h0.b$a */
    /* loaded from: classes.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f32011a;

        public a(c cVar) {
            this.f32011a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C1071b.this.n(floatValue, this.f32011a);
            C1071b.this.b(floatValue, this.f32011a, false);
            C1071b.this.invalidateSelf();
        }
    }

    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: h0.b$c */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final RectF f32015a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public final Paint f32016b;

        /* renamed from: c, reason: collision with root package name */
        public final Paint f32017c;

        /* renamed from: d, reason: collision with root package name */
        public final Paint f32018d;

        /* renamed from: e, reason: collision with root package name */
        public float f32019e;

        /* renamed from: f, reason: collision with root package name */
        public float f32020f;

        /* renamed from: g, reason: collision with root package name */
        public float f32021g;

        /* renamed from: h, reason: collision with root package name */
        public float f32022h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f32023i;

        /* renamed from: j, reason: collision with root package name */
        public int f32024j;

        /* renamed from: k, reason: collision with root package name */
        public float f32025k;

        /* renamed from: l, reason: collision with root package name */
        public float f32026l;

        /* renamed from: m, reason: collision with root package name */
        public float f32027m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f32028n;

        /* renamed from: o, reason: collision with root package name */
        public Path f32029o;

        /* renamed from: p, reason: collision with root package name */
        public float f32030p;

        /* renamed from: q, reason: collision with root package name */
        public float f32031q;

        /* renamed from: r, reason: collision with root package name */
        public int f32032r;

        /* renamed from: s, reason: collision with root package name */
        public int f32033s;

        /* renamed from: t, reason: collision with root package name */
        public int f32034t;

        /* renamed from: u, reason: collision with root package name */
        public int f32035u;

        public c() {
            Paint paint = new Paint();
            this.f32016b = paint;
            Paint paint2 = new Paint();
            this.f32017c = paint2;
            Paint paint3 = new Paint();
            this.f32018d = paint3;
            this.f32019e = 0.0f;
            this.f32020f = 0.0f;
            this.f32021g = 0.0f;
            this.f32022h = 5.0f;
            this.f32030p = 1.0f;
            this.f32034t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A() {
            this.f32025k = this.f32019e;
            this.f32026l = this.f32020f;
            this.f32027m = this.f32021g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f32015a;
            float f10 = this.f32031q;
            float f11 = (this.f32022h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                f11 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f32032r * this.f32030p) / 2.0f, this.f32022h / 2.0f);
            }
            rectF.set(rect.centerX() - f11, rect.centerY() - f11, rect.centerX() + f11, rect.centerY() + f11);
            float f12 = this.f32019e;
            float f13 = this.f32021g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f32020f + f13) * 360.0f) - f14;
            this.f32016b.setColor(this.f32035u);
            this.f32016b.setAlpha(this.f32034t);
            float f16 = this.f32022h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f32018d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f32016b);
            b(canvas, f14, f15, rectF);
        }

        public void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f32028n) {
                Path path = this.f32029o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f32029o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f12 = (this.f32032r * this.f32030p) / 2.0f;
                this.f32029o.moveTo(0.0f, 0.0f);
                this.f32029o.lineTo(this.f32032r * this.f32030p, 0.0f);
                Path path3 = this.f32029o;
                float f13 = this.f32032r;
                float f14 = this.f32030p;
                path3.lineTo((f13 * f14) / 2.0f, this.f32033s * f14);
                this.f32029o.offset((min + rectF.centerX()) - f12, rectF.centerY() + (this.f32022h / 2.0f));
                this.f32029o.close();
                this.f32017c.setColor(this.f32035u);
                this.f32017c.setAlpha(this.f32034t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f32029o, this.f32017c);
                canvas.restore();
            }
        }

        public int c() {
            return this.f32034t;
        }

        public float d() {
            return this.f32020f;
        }

        public int e() {
            return this.f32023i[f()];
        }

        public int f() {
            return (this.f32024j + 1) % this.f32023i.length;
        }

        public float g() {
            return this.f32019e;
        }

        public int h() {
            return this.f32023i[this.f32024j];
        }

        public float i() {
            return this.f32026l;
        }

        public float j() {
            return this.f32027m;
        }

        public float k() {
            return this.f32025k;
        }

        public void l() {
            t(f());
        }

        public void m() {
            this.f32025k = 0.0f;
            this.f32026l = 0.0f;
            this.f32027m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        public void n(int i10) {
            this.f32034t = i10;
        }

        public void o(float f10, float f11) {
            this.f32032r = (int) f10;
            this.f32033s = (int) f11;
        }

        public void p(float f10) {
            if (f10 != this.f32030p) {
                this.f32030p = f10;
            }
        }

        public void q(float f10) {
            this.f32031q = f10;
        }

        public void r(int i10) {
            this.f32035u = i10;
        }

        public void s(ColorFilter colorFilter) {
            this.f32016b.setColorFilter(colorFilter);
        }

        public void t(int i10) {
            this.f32024j = i10;
            this.f32035u = this.f32023i[i10];
        }

        public void u(int[] iArr) {
            this.f32023i = iArr;
            t(0);
        }

        public void v(float f10) {
            this.f32020f = f10;
        }

        public void w(float f10) {
            this.f32021g = f10;
        }

        public void x(boolean z10) {
            if (this.f32028n != z10) {
                this.f32028n = z10;
            }
        }

        public void y(float f10) {
            this.f32019e = f10;
        }

        public void z(float f10) {
            this.f32022h = f10;
            this.f32016b.setStrokeWidth(f10);
        }
    }

    public C1071b(Context context) {
        this.f32007c = ((Context) h.e(context)).getResources();
        c cVar = new c();
        this.f32005a = cVar;
        cVar.u(f32004i);
        k(2.5f);
        m();
    }

    public final void a(float f10, c cVar) {
        n(f10, cVar);
        float floor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f10));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((floor - cVar.j()) * f10));
    }

    public void b(float f10, c cVar, boolean z10) {
        float interpolation;
        float f11;
        if (this.f32010f) {
            a(f10, cVar);
            return;
        }
        if (f10 != 1.0f || z10) {
            float j10 = cVar.j();
            if (f10 < 0.5f) {
                interpolation = cVar.k();
                f11 = (f32003h.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float k10 = cVar.k() + 0.79f;
                interpolation = k10 - (((1.0f - f32003h.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f11 = k10;
            }
            float f12 = j10 + (0.20999998f * f10);
            float f13 = (f10 + this.f32009e) * 216.0f;
            cVar.y(interpolation);
            cVar.v(f11);
            cVar.w(f12);
            h(f13);
        }
    }

    public final int c(float f10, int i10, int i11) {
        return ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r5) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r0) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r1) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r7))));
    }

    public void d(boolean z10) {
        this.f32005a.x(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f32006b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f32005a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10) {
        this.f32005a.p(f10);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f32005a.u(iArr);
        this.f32005a.t(0);
        invalidateSelf();
    }

    public void g(float f10) {
        this.f32005a.w(f10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f32005a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(float f10) {
        this.f32006b = f10;
    }

    public final void i(float f10, float f11, float f12, float f13) {
        c cVar = this.f32005a;
        float f14 = this.f32007c.getDisplayMetrics().density;
        cVar.z(f11 * f14);
        cVar.q(f10 * f14);
        cVar.t(0);
        cVar.o(f12 * f14, f13 * f14);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f32008d.isRunning();
    }

    public void j(float f10, float f11) {
        this.f32005a.y(f10);
        this.f32005a.v(f11);
        invalidateSelf();
    }

    public void k(float f10) {
        this.f32005a.z(f10);
        invalidateSelf();
    }

    public void l(int i10) {
        if (i10 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void m() {
        c cVar = this.f32005a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f32002g);
        ofFloat.addListener(new C0301b(cVar));
        this.f32008d = ofFloat;
    }

    public void n(float f10, c cVar) {
        if (f10 > 0.75f) {
            cVar.r(c((f10 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f32005a.n(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f32005a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f32008d.cancel();
        this.f32005a.A();
        if (this.f32005a.d() != this.f32005a.g()) {
            this.f32010f = true;
            this.f32008d.setDuration(666L);
            this.f32008d.start();
        } else {
            this.f32005a.t(0);
            this.f32005a.m();
            this.f32008d.setDuration(1332L);
            this.f32008d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f32008d.cancel();
        h(0.0f);
        this.f32005a.x(false);
        this.f32005a.t(0);
        this.f32005a.m();
        invalidateSelf();
    }

    /* compiled from: CircularProgressDrawable.java */
    /* renamed from: h0.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0301b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f32013a;

        public C0301b(c cVar) {
            this.f32013a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            C1071b.this.b(1.0f, this.f32013a, true);
            this.f32013a.A();
            this.f32013a.l();
            C1071b c1071b = C1071b.this;
            if (c1071b.f32010f) {
                c1071b.f32010f = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                this.f32013a.x(false);
                return;
            }
            c1071b.f32009e += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1071b.this.f32009e = 0.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }
    }
}
