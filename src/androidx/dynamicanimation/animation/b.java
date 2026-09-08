package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.c;

/* compiled from: COUIPanelDragToHiddenAnimation.java */
/* loaded from: classes.dex */
public class b extends c<b> {

    /* renamed from: A, reason: collision with root package name */
    public final a f9682A;

    /* renamed from: B, reason: collision with root package name */
    public float f9683B;

    /* renamed from: C, reason: collision with root package name */
    public float f9684C;

    /* renamed from: D, reason: collision with root package name */
    public long f9685D;

    /* renamed from: E, reason: collision with root package name */
    public long f9686E;

    /* compiled from: COUIPanelDragToHiddenAnimation.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        public float f9689c;

        /* renamed from: a, reason: collision with root package name */
        public final c.p f9687a = new c.p();

        /* renamed from: b, reason: collision with root package name */
        public float f9688b = -4.2f;

        /* renamed from: d, reason: collision with root package name */
        public long f9690d = 0;

        /* renamed from: e, reason: collision with root package name */
        public long f9691e = 0;

        /* renamed from: f, reason: collision with root package name */
        public float f9692f = 0.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f9693g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        public float f9694h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        public float f9695i = 0.0f;

        public final float g(long j10) {
            long j11 = this.f9691e;
            if (j10 >= j11) {
                return this.f9695i;
            }
            long j12 = this.f9690d;
            float f10 = ((float) (j10 - j12)) / ((float) (j11 - j12));
            float f11 = this.f9694h;
            return f11 + ((this.f9695i - f11) * f10);
        }

        public final float h(long j10) {
            long j11 = this.f9691e;
            if (j10 >= j11) {
                return this.f9693g;
            }
            long j12 = this.f9690d;
            float f10 = ((float) (j10 - j12)) / ((float) (j11 - j12));
            float f11 = this.f9692f;
            return f11 + ((this.f9693g - f11) * f10);
        }

        public boolean i(float f10, float f11) {
            if (Math.abs(f11) < this.f9689c) {
                return true;
            }
            return false;
        }

        public void j(float f10) {
            this.f9689c = f10 * 62.5f;
        }

        public c.p k(float f10, float f11, long j10, long j11) {
            if (this.f9693g < 0.0f) {
                float f12 = (float) j11;
                this.f9687a.f9725b = (float) (f11 * Math.exp((f12 / 1000.0f) * this.f9688b));
                c.p pVar = this.f9687a;
                float f13 = this.f9688b;
                pVar.f9724a = (float) ((f10 - (f11 / f13)) + ((f11 / f13) * Math.exp((f13 * f12) / 1000.0f)));
            } else {
                this.f9687a.f9725b = h(j10);
                this.f9687a.f9724a = g(j10);
            }
            c.p pVar2 = this.f9687a;
            if (i(pVar2.f9724a, pVar2.f9725b)) {
                this.f9687a.f9725b = 0.0f;
            }
            return this.f9687a;
        }
    }

    public <K> b(K k10, d<K> dVar) {
        super(k10, dVar);
        a aVar = new a();
        this.f9682A = aVar;
        this.f9683B = 0.0f;
        this.f9684C = -1.0f;
        this.f9685D = 0L;
        this.f9686E = 120L;
        aVar.j(f());
    }

    @Override // androidx.dynamicanimation.animation.c
    public void o(float f10) {
        this.f9682A.j(f10);
    }

    @Override // androidx.dynamicanimation.animation.c
    public void p() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f9685D = currentTimeMillis;
        this.f9682A.f9690d = currentTimeMillis;
        this.f9682A.f9691e = this.f9685D + this.f9686E;
        this.f9682A.f9692f = this.f9683B;
        this.f9682A.f9693g = this.f9684C;
        this.f9682A.f9694h = 0.0f;
        this.f9682A.f9695i = this.f9716g;
        super.p();
    }

    @Override // androidx.dynamicanimation.animation.c
    public boolean r(long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        c.p k10 = this.f9682A.k(this.f9711b, this.f9710a, currentTimeMillis, j10);
        float f10 = k10.f9724a;
        this.f9711b = f10;
        float f11 = k10.f9725b;
        this.f9710a = f11;
        float f12 = this.f9684C;
        if (f12 >= 0.0f && (f11 <= f12 || currentTimeMillis >= this.f9685D + this.f9686E)) {
            this.f9711b = this.f9716g;
            return true;
        }
        float f13 = this.f9717h;
        if (f10 < f13) {
            this.f9711b = f13;
            return true;
        }
        float f14 = this.f9716g;
        if (f10 > f14) {
            this.f9711b = f14;
            return true;
        }
        if (s(f10, f11)) {
            return true;
        }
        return false;
    }

    public boolean s(float f10, float f11) {
        if (f10 < this.f9716g && f10 > this.f9717h && !this.f9682A.i(f10, f11)) {
            return false;
        }
        return true;
    }

    public b t(float f10) {
        if (f10 > 0.0f) {
            this.f9684C = f10;
            return this;
        }
        throw new IllegalArgumentException("Velocity must be positive");
    }

    public b u(float f10) {
        super.i(f10);
        return this;
    }

    public b v(float f10) {
        super.j(f10);
        return this;
    }

    public b w(float f10) {
        super.n(f10);
        this.f9683B = f10;
        return this;
    }
}
