package h8;

import f8.e;
import g8.C1051a;
import g8.C1052b;

/* compiled from: Spring.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public C1086a f32110c;

    /* renamed from: d, reason: collision with root package name */
    public C1086a f32111d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f32112e;

    /* renamed from: f, reason: collision with root package name */
    public float f32113f;

    /* renamed from: g, reason: collision with root package name */
    public float f32114g;

    /* renamed from: i, reason: collision with root package name */
    public float f32116i;

    /* renamed from: k, reason: collision with root package name */
    public float f32118k;

    /* renamed from: l, reason: collision with root package name */
    public C1051a f32119l;

    /* renamed from: m, reason: collision with root package name */
    public C1051a f32120m;

    /* renamed from: n, reason: collision with root package name */
    public final e f32121n;

    /* renamed from: o, reason: collision with root package name */
    public final e f32122o;

    /* renamed from: p, reason: collision with root package name */
    public final e f32123p;

    /* renamed from: q, reason: collision with root package name */
    public final e f32124q;

    /* renamed from: r, reason: collision with root package name */
    public final e f32125r;

    /* renamed from: s, reason: collision with root package name */
    public final f8.c f32126s;

    /* renamed from: a, reason: collision with root package name */
    public b f32108a = null;

    /* renamed from: b, reason: collision with root package name */
    public b f32109b = null;

    /* renamed from: h, reason: collision with root package name */
    public float f32115h = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f32117j = 0.0f;

    public b(e eVar, c cVar) {
        e eVar2 = new e();
        this.f32121n = eVar2;
        this.f32122o = new e();
        e eVar3 = new e();
        this.f32123p = eVar3;
        this.f32124q = new e();
        this.f32126s = new f8.c();
        this.f32125r = eVar;
        this.f32119l = cVar.f32127a;
        this.f32120m = cVar.f32128b;
        this.f32112e = false;
        this.f32110c = new C1086a();
        this.f32111d = new C1086a();
        if (cVar.f32131e >= 0.0f && cVar.f32130d >= 0.0f && cVar.f32132f >= 0.0f) {
            eVar3.e(cVar.f32129c);
            eVar2.e(eVar3).g(this.f32120m.f());
            this.f32116i = cVar.f32130d;
            this.f32113f = cVar.f32131e;
            this.f32114g = cVar.f32132f;
        }
    }

    public static b a(C1052b c1052b, c cVar) {
        return new b(c1052b.f(), cVar);
    }

    public final C1051a b() {
        return this.f32119l;
    }

    public final C1051a c() {
        return this.f32120m;
    }

    public e d() {
        return this.f32123p;
    }

    public void e(C1051a c1051a, float f10) {
        this.f32118k = c1051a.f31952s;
        float f11 = this.f32113f * 6.2831855f;
        float e10 = c1051a.e() * 2.0f * this.f32114g * f11;
        float e11 = c1051a.e() * f11 * f11 * f10;
        float f12 = e10 + e11;
        if (f12 > 1.1920929E-7f) {
            this.f32117j = f10 * f12;
        }
        float f13 = this.f32117j;
        if (f13 != 0.0f) {
            this.f32117j = 1.0f / f13;
        }
        float f14 = this.f32117j;
        this.f32115h = e11 * f14;
        f8.c cVar = this.f32126s;
        e eVar = cVar.f31797a;
        float f15 = this.f32118k;
        eVar.f31799a = f15 + f14;
        cVar.f31798b.f31800b = f15 + f14;
        cVar.a();
        this.f32122o.e(c1051a.f31936c).g(this.f32121n).g(this.f32123p).b(this.f32115h);
        e eVar2 = c1051a.f31938e;
        float f16 = eVar2.f31799a;
        float f17 = this.f32118k;
        e eVar3 = this.f32124q;
        eVar2.f31799a = f16 + (eVar3.f31799a * f17);
        eVar2.f31800b += f17 * eVar3.f31800b;
    }

    public void f(float f10) {
        this.f32114g = f10;
    }

    public void g(float f10) {
        this.f32113f = f10;
    }

    public void h(float f10, float f11) {
        e eVar = this.f32123p;
        eVar.f31799a = f10;
        eVar.f31800b = f11;
    }

    public void i(e eVar) {
        this.f32123p.e(eVar);
    }

    public void j(C1051a c1051a) {
        this.f32125r.e(this.f32124q);
        this.f32125r.b(this.f32117j).a(this.f32122o).a(c1051a.f31938e).c();
        f8.c cVar = this.f32126s;
        e eVar = this.f32125r;
        f8.c.b(cVar, eVar, eVar);
        this.f32124q.a(this.f32125r);
        c1051a.f31938e.a(this.f32125r.b(this.f32118k));
    }
}
