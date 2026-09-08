package c4;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Spring.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: o, reason: collision with root package name */
    public static int f12758o;

    /* renamed from: a, reason: collision with root package name */
    public h f12759a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12760b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12761c;

    /* renamed from: d, reason: collision with root package name */
    public final b f12762d;

    /* renamed from: e, reason: collision with root package name */
    public final b f12763e;

    /* renamed from: f, reason: collision with root package name */
    public final b f12764f;

    /* renamed from: g, reason: collision with root package name */
    public double f12765g;

    /* renamed from: h, reason: collision with root package name */
    public double f12766h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12767i = true;

    /* renamed from: j, reason: collision with root package name */
    public double f12768j = 0.005d;

    /* renamed from: k, reason: collision with root package name */
    public double f12769k = 0.005d;

    /* renamed from: l, reason: collision with root package name */
    public CopyOnWriteArraySet<j> f12770l = new CopyOnWriteArraySet<>();

    /* renamed from: m, reason: collision with root package name */
    public double f12771m = 0.0d;

    /* renamed from: n, reason: collision with root package name */
    public final c4.b f12772n;

    /* compiled from: Spring.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public double f12773a;

        /* renamed from: b, reason: collision with root package name */
        public double f12774b;

        public b() {
        }
    }

    public g(c4.b bVar) {
        this.f12762d = new b();
        this.f12763e = new b();
        this.f12764f = new b();
        if (bVar != null) {
            this.f12772n = bVar;
            StringBuilder sb = new StringBuilder();
            sb.append("spring:");
            int i10 = f12758o;
            f12758o = i10 + 1;
            sb.append(i10);
            this.f12761c = sb.toString();
            q(h.f12775c);
            return;
        }
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    public g a(j jVar) {
        if (jVar != null) {
            this.f12770l.add(jVar);
            return this;
        }
        throw new IllegalArgumentException("newListener is required");
    }

    public void b(double d10) {
        double d11;
        boolean z10;
        boolean z11;
        boolean i10 = i();
        if (i10 && this.f12767i) {
            return;
        }
        double d12 = 0.064d;
        if (d10 <= 0.064d) {
            d12 = d10;
        }
        this.f12771m += d12;
        h hVar = this.f12759a;
        double d13 = hVar.f12777b;
        double d14 = hVar.f12776a;
        b bVar = this.f12762d;
        double d15 = bVar.f12773a;
        double d16 = bVar.f12774b;
        b bVar2 = this.f12764f;
        double d17 = bVar2.f12773a;
        double d18 = bVar2.f12774b;
        while (true) {
            d11 = this.f12771m;
            if (d11 < 0.001d) {
                break;
            }
            double d19 = d11 - 0.001d;
            this.f12771m = d19;
            if (d19 < 0.001d) {
                b bVar3 = this.f12763e;
                bVar3.f12773a = d15;
                bVar3.f12774b = d16;
            }
            double d20 = this.f12766h;
            double d21 = ((d20 - d17) * d13) - (d14 * d16);
            double d22 = d16 + (d21 * 0.001d * 0.5d);
            double d23 = ((d20 - (((d16 * 0.001d) * 0.5d) + d15)) * d13) - (d14 * d22);
            double d24 = d16 + (d23 * 0.001d * 0.5d);
            double d25 = ((d20 - (d15 + ((d22 * 0.001d) * 0.5d))) * d13) - (d14 * d24);
            double d26 = d15 + (d24 * 0.001d);
            double d27 = d16 + (d25 * 0.001d);
            d15 += (d16 + ((d22 + d24) * 2.0d) + d27) * 0.16666666666666666d * 0.001d;
            d16 += (d21 + ((d23 + d25) * 2.0d) + (((d20 - d26) * d13) - (d14 * d27))) * 0.16666666666666666d * 0.001d;
            d17 = d26;
            d18 = d27;
        }
        b bVar4 = this.f12764f;
        bVar4.f12773a = d17;
        bVar4.f12774b = d18;
        b bVar5 = this.f12762d;
        bVar5.f12773a = d15;
        bVar5.f12774b = d16;
        if (d11 > 0.0d) {
            h(d11 / 0.001d);
        }
        boolean z12 = true;
        if (!i() && (!this.f12760b || !j())) {
            z10 = i10;
        } else {
            if (d13 > 0.0d) {
                double d28 = this.f12766h;
                this.f12765g = d28;
                this.f12762d.f12773a = d28;
            } else {
                double d29 = this.f12762d.f12773a;
                this.f12766h = d29;
                this.f12765g = d29;
            }
            r(0.0d);
            z10 = true;
        }
        if (this.f12767i) {
            this.f12767i = false;
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10) {
            this.f12767i = true;
        } else {
            z12 = false;
        }
        Iterator<j> it = this.f12770l.iterator();
        while (it.hasNext()) {
            j next = it.next();
            if (z11) {
                next.onSpringActivate(this);
            }
            next.onSpringUpdate(this);
            if (z12) {
                next.onSpringAtRest(this);
            }
        }
    }

    public double c() {
        return this.f12762d.f12773a;
    }

    public final double d(b bVar) {
        return Math.abs(this.f12766h - bVar.f12773a);
    }

    public double e() {
        return this.f12766h;
    }

    public String f() {
        return this.f12761c;
    }

    public double g() {
        return this.f12762d.f12774b;
    }

    public final void h(double d10) {
        b bVar = this.f12762d;
        double d11 = bVar.f12773a * d10;
        b bVar2 = this.f12763e;
        double d12 = 1.0d - d10;
        bVar.f12773a = d11 + (bVar2.f12773a * d12);
        bVar.f12774b = (bVar.f12774b * d10) + (bVar2.f12774b * d12);
    }

    public boolean i() {
        if (Math.abs(this.f12762d.f12774b) <= this.f12768j && (d(this.f12762d) <= this.f12769k || this.f12759a.f12777b == 0.0d)) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (this.f12759a.f12777b > 0.0d && ((this.f12765g < this.f12766h && c() > this.f12766h) || (this.f12765g > this.f12766h && c() < this.f12766h))) {
            return true;
        }
        return false;
    }

    public g k() {
        b bVar = this.f12762d;
        double d10 = bVar.f12773a;
        this.f12766h = d10;
        this.f12764f.f12773a = d10;
        bVar.f12774b = 0.0d;
        return this;
    }

    public g l(double d10) {
        return m(d10, true);
    }

    public g m(double d10, boolean z10) {
        this.f12765g = d10;
        this.f12762d.f12773a = d10;
        this.f12772n.a(f());
        Iterator<j> it = this.f12770l.iterator();
        while (it.hasNext()) {
            it.next().onSpringUpdate(this);
        }
        if (z10) {
            k();
        }
        return this;
    }

    public g n(double d10) {
        if (this.f12766h == d10 && i()) {
            return this;
        }
        this.f12765g = c();
        this.f12766h = d10;
        this.f12772n.a(f());
        Iterator<j> it = this.f12770l.iterator();
        while (it.hasNext()) {
            it.next().onSpringEndStateChange(this);
        }
        return this;
    }

    public g o(double d10) {
        this.f12769k = d10;
        return this;
    }

    public g p(double d10) {
        this.f12768j = d10;
        return this;
    }

    public g q(h hVar) {
        if (hVar != null) {
            this.f12759a = hVar;
            return this;
        }
        throw new IllegalArgumentException("springConfig is required");
    }

    public g r(double d10) {
        b bVar = this.f12762d;
        if (d10 == bVar.f12774b) {
            return this;
        }
        bVar.f12774b = d10;
        this.f12772n.a(f());
        return this;
    }

    public boolean s() {
        if (i() && t()) {
            return false;
        }
        return true;
    }

    public boolean t() {
        return this.f12767i;
    }
}
