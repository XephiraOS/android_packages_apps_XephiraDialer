package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.K;

/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    public static final int f9533r = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    public final View f9536c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f9537d;

    /* renamed from: g, reason: collision with root package name */
    public int f9540g;

    /* renamed from: h, reason: collision with root package name */
    public int f9541h;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9545l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9546m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9547n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9548o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9549p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9550q;

    /* renamed from: a, reason: collision with root package name */
    public final C0111a f9534a = new C0111a();

    /* renamed from: b, reason: collision with root package name */
    public final Interpolator f9535b = new AccelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    public float[] f9538e = {0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    public float[] f9539f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i, reason: collision with root package name */
    public float[] f9542i = {0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    public float[] f9543j = {0.0f, 0.0f};

    /* renamed from: k, reason: collision with root package name */
    public float[] f9544k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0111a {

        /* renamed from: a, reason: collision with root package name */
        public int f9551a;

        /* renamed from: b, reason: collision with root package name */
        public int f9552b;

        /* renamed from: c, reason: collision with root package name */
        public float f9553c;

        /* renamed from: d, reason: collision with root package name */
        public float f9554d;

        /* renamed from: j, reason: collision with root package name */
        public float f9560j;

        /* renamed from: k, reason: collision with root package name */
        public int f9561k;

        /* renamed from: e, reason: collision with root package name */
        public long f9555e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        public long f9559i = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f9556f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f9557g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f9558h = 0;

        public void a() {
            if (this.f9556f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g10 = g(e(currentAnimationTimeMillis));
                long j10 = currentAnimationTimeMillis - this.f9556f;
                this.f9556f = currentAnimationTimeMillis;
                float f10 = ((float) j10) * g10;
                this.f9557g = (int) (this.f9553c * f10);
                this.f9558h = (int) (f10 * this.f9554d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f9557g;
        }

        public int c() {
            return this.f9558h;
        }

        public int d() {
            float f10 = this.f9553c;
            return (int) (f10 / Math.abs(f10));
        }

        public final float e(long j10) {
            long j11 = this.f9555e;
            if (j10 < j11) {
                return 0.0f;
            }
            long j12 = this.f9559i;
            if (j12 >= 0 && j10 >= j12) {
                float f10 = this.f9560j;
                return (1.0f - f10) + (f10 * a.e(((float) (j10 - j12)) / this.f9561k, 0.0f, 1.0f));
            }
            return a.e(((float) (j10 - j11)) / this.f9551a, 0.0f, 1.0f) * 0.5f;
        }

        public int f() {
            float f10 = this.f9554d;
            return (int) (f10 / Math.abs(f10));
        }

        public final float g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        public boolean h() {
            if (this.f9559i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f9559i + this.f9561k) {
                return true;
            }
            return false;
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f9561k = a.f((int) (currentAnimationTimeMillis - this.f9555e), 0, this.f9552b);
            this.f9560j = e(currentAnimationTimeMillis);
            this.f9559i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f9552b = i10;
        }

        public void k(int i10) {
            this.f9551a = i10;
        }

        public void l(float f10, float f11) {
            this.f9553c = f10;
            this.f9554d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f9555e = currentAnimationTimeMillis;
            this.f9559i = -1L;
            this.f9556f = currentAnimationTimeMillis;
            this.f9560j = 0.5f;
            this.f9557g = 0;
            this.f9558h = 0;
        }
    }

    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (!aVar.f9548o) {
                return;
            }
            if (aVar.f9546m) {
                aVar.f9546m = false;
                aVar.f9534a.m();
            }
            C0111a c0111a = a.this.f9534a;
            if (!c0111a.h() && a.this.u()) {
                a aVar2 = a.this;
                if (aVar2.f9547n) {
                    aVar2.f9547n = false;
                    aVar2.c();
                }
                c0111a.a();
                a.this.j(c0111a.b(), c0111a.c());
                K.a0(a.this.f9536c, this);
                return;
            }
            a.this.f9548o = false;
        }
    }

    public a(View view) {
        this.f9536c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        o(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f9533r);
        r(500);
        q(500);
    }

    public static float e(float f10, float f11, float f12) {
        if (f10 > f12) {
            return f12;
        }
        if (f10 < f11) {
            return f11;
        }
        return f10;
    }

    public static int f(int i10, int i11, int i12) {
        if (i10 > i12) {
            return i12;
        }
        if (i10 < i11) {
            return i11;
        }
        return i10;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f9536c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public final float d(int i10, float f10, float f11, float f12) {
        float h10 = h(this.f9538e[i10], f11, this.f9539f[i10], f10);
        if (h10 == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f9542i[i10];
        float f14 = this.f9543j[i10];
        float f15 = this.f9544k[i10];
        float f16 = f13 * f12;
        if (h10 > 0.0f) {
            return e(h10 * f16, f14, f15);
        }
        return -e((-h10) * f16, f14, f15);
    }

    public final float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f9540g;
        if (i10 != 0 && i10 != 1) {
            if (i10 == 2 && f10 < 0.0f) {
                return f10 / (-f11);
            }
        } else if (f10 < f11) {
            if (f10 >= 0.0f) {
                return 1.0f - (f10 / f11);
            }
            if (this.f9548o && i10 == 1) {
                return 1.0f;
            }
        }
        return 0.0f;
    }

    public final float h(float f10, float f11, float f12, float f13) {
        float interpolation;
        float e10 = e(f10 * f11, 0.0f, f12);
        float g10 = g(f11 - f13, e10) - g(f13, e10);
        if (g10 < 0.0f) {
            interpolation = -this.f9535b.getInterpolation(-g10);
        } else {
            if (g10 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f9535b.getInterpolation(g10);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public final void i() {
        if (this.f9546m) {
            this.f9548o = false;
        } else {
            this.f9534a.i();
        }
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f9541h = i10;
        return this;
    }

    public a l(int i10) {
        this.f9540g = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f9549p && !z10) {
            i();
        }
        this.f9549p = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f9539f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f9544k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f9549p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f9547n = r2
            r5.f9545l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f9536c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f9536c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f9534a
            r7.l(r0, r6)
            boolean r6 = r5.f9548o
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f9550q
            if (r6 == 0) goto L61
            boolean r5 = r5.f9548o
            if (r5 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f9543j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f9534a.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f9534a.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f9538e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f9542i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0111a c0111a = this.f9534a;
        int f10 = c0111a.f();
        int d10 = c0111a.d();
        if ((f10 != 0 && b(f10)) || (d10 != 0 && a(d10))) {
            return true;
        }
        return false;
    }

    public final void v() {
        int i10;
        if (this.f9537d == null) {
            this.f9537d = new b();
        }
        this.f9548o = true;
        this.f9546m = true;
        if (!this.f9545l && (i10 = this.f9541h) > 0) {
            K.b0(this.f9536c, this.f9537d, i10);
        } else {
            this.f9537d.run();
        }
        this.f9545l = true;
    }
}
