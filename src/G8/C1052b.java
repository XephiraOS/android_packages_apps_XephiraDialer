package g8;

import f8.e;
import h8.C1086a;
import h8.c;

/* compiled from: World.java */
/* renamed from: g8.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1052b {

    /* renamed from: a, reason: collision with root package name */
    public C1051a f31959a;

    /* renamed from: b, reason: collision with root package name */
    public h8.b f31960b;

    /* renamed from: c, reason: collision with root package name */
    public int f31961c;

    /* renamed from: d, reason: collision with root package name */
    public int f31962d;

    /* renamed from: e, reason: collision with root package name */
    public final e f31963e;

    public C1052b() {
        this(new e());
    }

    public C1051a a(e eVar, int i10, int i11, float f10, float f11, String str) {
        C1051a c1051a = new C1051a(eVar, i10, i11, f10, f11);
        c1051a.u(str);
        c1051a.f31943j = null;
        C1051a c1051a2 = this.f31959a;
        c1051a.f31944k = c1051a2;
        if (c1051a2 != null) {
            c1051a2.f31943j = c1051a;
        }
        this.f31959a = c1051a;
        this.f31961c++;
        if (f8.b.b()) {
            e();
        }
        return c1051a;
    }

    public h8.b b(c cVar) {
        h8.b a10 = h8.b.a(this, cVar);
        if (a10 == null) {
            return null;
        }
        a10.f32108a = null;
        h8.b bVar = this.f31960b;
        a10.f32109b = bVar;
        if (bVar != null) {
            bVar.f32108a = a10;
        }
        this.f31960b = a10;
        this.f31962d++;
        C1086a c1086a = a10.f32110c;
        c1086a.f32105b = a10;
        c1086a.f32104a = a10.c();
        C1086a c1086a2 = a10.f32110c;
        c1086a2.f32106c = null;
        c1086a2.f32107d = a10.b().f31945l;
        if (a10.b().f31945l != null) {
            a10.b().f31945l.f32106c = a10.f32110c;
        }
        a10.b().f31945l = a10.f32110c;
        C1086a c1086a3 = a10.f32111d;
        c1086a3.f32105b = a10;
        c1086a3.f32104a = a10.b();
        C1086a c1086a4 = a10.f32111d;
        c1086a4.f32106c = null;
        c1086a4.f32107d = a10.c().f31945l;
        if (a10.c().f31945l != null) {
            a10.c().f31945l.f32106c = a10.f32111d;
        }
        a10.c().f31945l = a10.f32111d;
        return a10;
    }

    public void c(C1051a c1051a) {
        if (this.f31961c <= 0) {
            return;
        }
        C1086a c1086a = c1051a.f31945l;
        while (c1086a != null) {
            C1086a c1086a2 = c1086a.f32107d;
            h8.b bVar = c1086a.f32105b;
            if (bVar != null) {
                d(bVar);
            }
            c1051a.f31945l = c1086a2;
            c1086a = c1086a2;
        }
        c1051a.f31945l = null;
        C1051a c1051a2 = c1051a.f31943j;
        if (c1051a2 != null) {
            c1051a2.f31944k = c1051a.f31944k;
        }
        C1051a c1051a3 = c1051a.f31944k;
        if (c1051a3 != null) {
            c1051a3.f31943j = c1051a2;
        }
        if (c1051a == this.f31959a) {
            this.f31959a = c1051a3;
        }
        this.f31961c--;
    }

    public void d(h8.b bVar) {
        if (this.f31962d <= 0) {
            return;
        }
        h8.b bVar2 = bVar.f32108a;
        if (bVar2 != null) {
            bVar2.f32109b = bVar.f32109b;
        }
        h8.b bVar3 = bVar.f32109b;
        if (bVar3 != null) {
            bVar3.f32108a = bVar2;
        }
        if (bVar == this.f31960b) {
            this.f31960b = bVar3;
        }
        C1051a b10 = bVar.b();
        C1051a c10 = bVar.c();
        C1086a c1086a = bVar.f32110c;
        C1086a c1086a2 = c1086a.f32106c;
        if (c1086a2 != null) {
            c1086a2.f32107d = c1086a.f32107d;
        }
        C1086a c1086a3 = c1086a.f32107d;
        if (c1086a3 != null) {
            c1086a3.f32106c = c1086a2;
        }
        if (c1086a == b10.f31945l) {
            b10.f31945l = c1086a3;
        }
        c1086a.f32106c = null;
        c1086a.f32107d = null;
        C1086a c1086a4 = bVar.f32111d;
        C1086a c1086a5 = c1086a4.f32106c;
        if (c1086a5 != null) {
            c1086a5.f32107d = c1086a4.f32107d;
        }
        C1086a c1086a6 = c1086a4.f32107d;
        if (c1086a6 != null) {
            c1086a6.f32106c = c1086a5;
        }
        if (c1086a4 == c10.f31945l) {
            c10.f31945l = c1086a6;
        }
        c1086a4.f32106c = null;
        c1086a4.f32107d = null;
        this.f31962d--;
    }

    public final void e() {
        for (C1051a c1051a = this.f31959a; c1051a != null; c1051a = c1051a.f31944k) {
            f8.b.c("world has body ====>>> " + c1051a);
        }
    }

    public e f() {
        return this.f31963e;
    }

    public final void g(float f10) {
        for (C1051a c1051a = this.f31959a; c1051a != null; c1051a = c1051a.f31944k) {
            c1051a.f31957x = false;
        }
        for (h8.b bVar = this.f31960b; bVar != null; bVar = bVar.f32109b) {
            bVar.f32112e = false;
        }
        for (C1051a c1051a2 = this.f31959a; c1051a2 != null; c1051a2 = c1051a2.f31944k) {
            if (!c1051a2.f31957x && c1051a2.f31946m && c1051a2.h() != 0) {
                h(c1051a2, f10);
                c1051a2.f31957x = true;
                c1051a2.f31939f.f();
            }
        }
    }

    public final void h(C1051a c1051a, float f10) {
        c1051a.x();
        c1051a.f31938e.a(c1051a.f31939f.b(c1051a.f31952s).b(f10));
        c1051a.f31938e.b(1.0f / ((c1051a.f31953t * f10) + 1.0f));
        for (C1086a c1086a = c1051a.f31945l; c1086a != null; c1086a = c1086a.f32107d) {
            h8.b bVar = c1086a.f32105b;
            if (!bVar.f32112e) {
                bVar.f32112e = true;
                C1051a c1051a2 = c1086a.f32104a;
                if (!c1051a2.f31957x && c1051a2.f31946m) {
                    bVar.e(c1051a, f10);
                    for (int i10 = 0; i10 < 4; i10++) {
                        c1086a.f32105b.j(c1051a);
                    }
                }
            }
        }
        e eVar = c1051a.f31936c;
        float f11 = eVar.f31799a;
        e eVar2 = c1051a.f31938e;
        eVar.f31799a = f11 + (eVar2.f31799a * f10);
        eVar.f31800b += f10 * eVar2.f31800b;
        c1051a.w();
    }

    public void i(float f10) {
        g(f10);
    }

    public C1052b(e eVar) {
        this.f31963e = eVar;
        this.f31959a = null;
        this.f31960b = null;
        this.f31961c = 0;
        this.f31962d = 0;
    }
}
