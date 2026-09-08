package f5;

import com.google.zxing.NotFoundException;

/* compiled from: BoundingBox.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final S4.b f31731a;

    /* renamed from: b, reason: collision with root package name */
    public final P4.g f31732b;

    /* renamed from: c, reason: collision with root package name */
    public final P4.g f31733c;

    /* renamed from: d, reason: collision with root package name */
    public final P4.g f31734d;

    /* renamed from: e, reason: collision with root package name */
    public final P4.g f31735e;

    /* renamed from: f, reason: collision with root package name */
    public final int f31736f;

    /* renamed from: g, reason: collision with root package name */
    public final int f31737g;

    /* renamed from: h, reason: collision with root package name */
    public final int f31738h;

    /* renamed from: i, reason: collision with root package name */
    public final int f31739i;

    public c(S4.b bVar, P4.g gVar, P4.g gVar2, P4.g gVar3, P4.g gVar4) {
        boolean z10 = gVar == null || gVar2 == null;
        boolean z11 = gVar3 == null || gVar4 == null;
        if (z10 && z11) {
            throw NotFoundException.a();
        }
        if (z10) {
            gVar = new P4.g(0.0f, gVar3.d());
            gVar2 = new P4.g(0.0f, gVar4.d());
        } else if (z11) {
            gVar3 = new P4.g(bVar.j() - 1, gVar.d());
            gVar4 = new P4.g(bVar.j() - 1, gVar2.d());
        }
        this.f31731a = bVar;
        this.f31732b = gVar;
        this.f31733c = gVar2;
        this.f31734d = gVar3;
        this.f31735e = gVar4;
        this.f31736f = (int) Math.min(gVar.c(), gVar2.c());
        this.f31737g = (int) Math.max(gVar3.c(), gVar4.c());
        this.f31738h = (int) Math.min(gVar.d(), gVar3.d());
        this.f31739i = (int) Math.max(gVar2.d(), gVar4.d());
    }

    public static c j(c cVar, c cVar2) {
        if (cVar == null) {
            return cVar2;
        }
        if (cVar2 == null) {
            return cVar;
        }
        return new c(cVar.f31731a, cVar.f31732b, cVar.f31733c, cVar2.f31734d, cVar2.f31735e);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f5.c a(int r13, int r14, boolean r15) {
        /*
            r12 = this;
            P4.g r0 = r12.f31732b
            P4.g r1 = r12.f31733c
            P4.g r2 = r12.f31734d
            P4.g r3 = r12.f31735e
            if (r13 <= 0) goto L2a
            if (r15 == 0) goto Le
            r4 = r0
            goto Lf
        Le:
            r4 = r2
        Lf:
            float r5 = r4.d()
            int r5 = (int) r5
            int r5 = r5 - r13
            if (r5 >= 0) goto L18
            r5 = 0
        L18:
            P4.g r13 = new P4.g
            float r4 = r4.c()
            float r5 = (float) r5
            r13.<init>(r4, r5)
            if (r15 == 0) goto L27
            r8 = r13
        L25:
            r10 = r2
            goto L2c
        L27:
            r10 = r13
            r8 = r0
            goto L2c
        L2a:
            r8 = r0
            goto L25
        L2c:
            if (r14 <= 0) goto L5d
            if (r15 == 0) goto L33
            P4.g r13 = r12.f31733c
            goto L35
        L33:
            P4.g r13 = r12.f31735e
        L35:
            float r0 = r13.d()
            int r0 = (int) r0
            int r0 = r0 + r14
            S4.b r14 = r12.f31731a
            int r14 = r14.g()
            if (r0 < r14) goto L4b
            S4.b r14 = r12.f31731a
            int r14 = r14.g()
            int r0 = r14 + (-1)
        L4b:
            P4.g r14 = new P4.g
            float r13 = r13.c()
            float r0 = (float) r0
            r14.<init>(r13, r0)
            if (r15 == 0) goto L5a
            r9 = r14
        L58:
            r11 = r3
            goto L5f
        L5a:
            r11 = r14
            r9 = r1
            goto L5f
        L5d:
            r9 = r1
            goto L58
        L5f:
            f5.c r13 = new f5.c
            S4.b r7 = r12.f31731a
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.c.a(int, int, boolean):f5.c");
    }

    public P4.g b() {
        return this.f31733c;
    }

    public P4.g c() {
        return this.f31735e;
    }

    public int d() {
        return this.f31737g;
    }

    public int e() {
        return this.f31739i;
    }

    public int f() {
        return this.f31736f;
    }

    public int g() {
        return this.f31738h;
    }

    public P4.g h() {
        return this.f31732b;
    }

    public P4.g i() {
        return this.f31734d;
    }

    public c(c cVar) {
        this.f31731a = cVar.f31731a;
        this.f31732b = cVar.h();
        this.f31733c = cVar.b();
        this.f31734d = cVar.i();
        this.f31735e = cVar.c();
        this.f31736f = cVar.f();
        this.f31737g = cVar.d();
        this.f31738h = cVar.g();
        this.f31739i = cVar.e();
    }
}
