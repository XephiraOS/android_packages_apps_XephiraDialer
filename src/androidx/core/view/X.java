package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class X {

    /* renamed from: b, reason: collision with root package name */
    public static final X f9471b = i.f9486l;

    /* renamed from: a, reason: collision with root package name */
    public final j f9472a;

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class c extends b {
        public c() {
        }

        public c(X x10) {
            super(x10);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final X f9475a;

        /* renamed from: b, reason: collision with root package name */
        public B.b[] f9476b;

        public d() {
            this(new X((X) null));
        }

        public final void a() {
            B.b[] bVarArr = this.f9476b;
            if (bVarArr != null) {
                B.b bVar = bVarArr[k.b(1)];
                B.b bVar2 = this.f9476b[k.b(2)];
                if (bVar2 == null) {
                    bVar2 = this.f9475a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f9475a.f(1);
                }
                f(B.b.a(bVar, bVar2));
                B.b bVar3 = this.f9476b[k.b(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                B.b bVar4 = this.f9476b[k.b(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                B.b bVar5 = this.f9476b[k.b(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        public X b() {
            throw null;
        }

        public void c(B.b bVar) {
            throw null;
        }

        public void d(B.b bVar) {
            throw null;
        }

        public void e(B.b bVar) {
            throw null;
        }

        public void f(B.b bVar) {
            throw null;
        }

        public void g(B.b bVar) {
            throw null;
        }

        public d(X x10) {
            this.f9475a = x10;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class g extends f {
        public g(X x10, WindowInsets windowInsets) {
            super(x10, windowInsets);
        }

        @Override // androidx.core.view.X.j
        public X a() {
            return X.x(this.f9477c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.X.e, androidx.core.view.X.j
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            if (Objects.equals(this.f9477c, gVar.f9477c) && Objects.equals(this.f9481g, gVar.f9481g)) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.view.X.j
        public C0453h f() {
            return C0453h.e(this.f9477c.getDisplayCutout());
        }

        @Override // androidx.core.view.X.j
        public int hashCode() {
            return this.f9477c.hashCode();
        }

        public g(X x10, g gVar) {
            super(x10, gVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class i extends h {

        /* renamed from: l, reason: collision with root package name */
        public static final X f9486l = X.x(WindowInsets.CONSUMED);

        public i(X x10, WindowInsets windowInsets) {
            super(x10, windowInsets);
        }

        @Override // androidx.core.view.X.e, androidx.core.view.X.j
        public B.b g(int i10) {
            return B.b.c(this.f9477c.getInsets(l.a(i10)));
        }

        @Override // androidx.core.view.X.e, androidx.core.view.X.j
        public B.b h(int i10) {
            return B.b.c(this.f9477c.getInsetsIgnoringVisibility(l.a(i10)));
        }

        @Override // androidx.core.view.X.e, androidx.core.view.X.j
        public boolean q(int i10) {
            return this.f9477c.isVisible(l.a(i10));
        }

        public i(X x10, i iVar) {
            super(x10, iVar);
        }

        @Override // androidx.core.view.X.e, androidx.core.view.X.j
        public final void d(View view) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class k {
        public static int a() {
            return 8;
        }

        public static int b(int i10) {
            if (i10 != 1) {
                if (i10 == 2) {
                    return 1;
                }
                if (i10 == 4) {
                    return 2;
                }
                if (i10 != 8) {
                    if (i10 == 16) {
                        return 4;
                    }
                    if (i10 != 32) {
                        if (i10 != 64) {
                            if (i10 != 128) {
                                if (i10 == 256) {
                                    return 8;
                                }
                                throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
                            }
                            return 7;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 3;
            }
            return 0;
        }

        public static int c() {
            return 32;
        }

        public static int d() {
            return 2;
        }

        public static int e() {
            return 1;
        }

        public static int f() {
            return 7;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class l {
        public static int a(int i10) {
            int statusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 != 1) {
                        if (i12 != 2) {
                            if (i12 != 4) {
                                if (i12 != 8) {
                                    if (i12 != 16) {
                                        if (i12 != 32) {
                                            if (i12 != 64) {
                                                if (i12 == 128) {
                                                    statusBars = WindowInsets.Type.displayCutout();
                                                }
                                            } else {
                                                statusBars = WindowInsets.Type.tappableElement();
                                            }
                                        } else {
                                            statusBars = WindowInsets.Type.mandatorySystemGestures();
                                        }
                                    } else {
                                        statusBars = WindowInsets.Type.systemGestures();
                                    }
                                } else {
                                    statusBars = WindowInsets.Type.ime();
                                }
                            } else {
                                statusBars = WindowInsets.Type.captionBar();
                            }
                        } else {
                            statusBars = WindowInsets.Type.navigationBars();
                        }
                    } else {
                        statusBars = WindowInsets.Type.statusBars();
                    }
                    i11 |= statusBars;
                }
            }
            return i11;
        }
    }

    public X(WindowInsets windowInsets) {
        this.f9472a = new i(this, windowInsets);
    }

    public static B.b p(B.b bVar, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, bVar.f207a - i10);
        int max2 = Math.max(0, bVar.f208b - i11);
        int max3 = Math.max(0, bVar.f209c - i12);
        int max4 = Math.max(0, bVar.f210d - i13);
        if (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) {
            return bVar;
        }
        return B.b.b(max, max2, max3, max4);
    }

    public static X x(WindowInsets windowInsets) {
        return y(windowInsets, null);
    }

    public static X y(WindowInsets windowInsets, View view) {
        X x10 = new X((WindowInsets) I.h.e(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            x10.v(K.C(view));
            x10.d(view.getRootView());
        }
        return x10;
    }

    @Deprecated
    public X a() {
        return this.f9472a.a();
    }

    @Deprecated
    public X b() {
        return this.f9472a.b();
    }

    @Deprecated
    public X c() {
        return this.f9472a.c();
    }

    public void d(View view) {
        this.f9472a.d(view);
    }

    public C0453h e() {
        return this.f9472a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X)) {
            return false;
        }
        return I.c.a(this.f9472a, ((X) obj).f9472a);
    }

    public B.b f(int i10) {
        return this.f9472a.g(i10);
    }

    public B.b g(int i10) {
        return this.f9472a.h(i10);
    }

    @Deprecated
    public B.b h() {
        return this.f9472a.j();
    }

    public int hashCode() {
        j jVar = this.f9472a;
        if (jVar == null) {
            return 0;
        }
        return jVar.hashCode();
    }

    @Deprecated
    public B.b i() {
        return this.f9472a.k();
    }

    @Deprecated
    public int j() {
        return this.f9472a.l().f210d;
    }

    @Deprecated
    public int k() {
        return this.f9472a.l().f207a;
    }

    @Deprecated
    public int l() {
        return this.f9472a.l().f209c;
    }

    @Deprecated
    public int m() {
        return this.f9472a.l().f208b;
    }

    @Deprecated
    public boolean n() {
        return !this.f9472a.l().equals(B.b.f206e);
    }

    public X o(int i10, int i11, int i12, int i13) {
        return this.f9472a.n(i10, i11, i12, i13);
    }

    public boolean q() {
        return this.f9472a.o();
    }

    public boolean r(int i10) {
        return this.f9472a.q(i10);
    }

    @Deprecated
    public X s(int i10, int i11, int i12, int i13) {
        return new a(this).c(B.b.b(i10, i11, i12, i13)).a();
    }

    public void t(B.b[] bVarArr) {
        this.f9472a.r(bVarArr);
    }

    public void u(B.b bVar) {
        this.f9472a.s(bVar);
    }

    public void v(X x10) {
        this.f9472a.t(x10);
    }

    public WindowInsets w() {
        j jVar = this.f9472a;
        if (jVar instanceof e) {
            return ((e) jVar).f9477c;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final d f9473a;

        public a() {
            this.f9473a = new c();
        }

        public X a() {
            return this.f9473a.b();
        }

        @Deprecated
        public a b(B.b bVar) {
            this.f9473a.d(bVar);
            return this;
        }

        @Deprecated
        public a c(B.b bVar) {
            this.f9473a.f(bVar);
            return this;
        }

        public a(X x10) {
            this.f9473a = new c(x10);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class b extends d {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f9474c;

        public b() {
            this.f9474c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.X.d
        public X b() {
            a();
            X x10 = X.x(this.f9474c.build());
            x10.t(this.f9476b);
            return x10;
        }

        @Override // androidx.core.view.X.d
        public void c(B.b bVar) {
            this.f9474c.setMandatorySystemGestureInsets(bVar.d());
        }

        @Override // androidx.core.view.X.d
        public void d(B.b bVar) {
            this.f9474c.setStableInsets(bVar.d());
        }

        @Override // androidx.core.view.X.d
        public void e(B.b bVar) {
            this.f9474c.setSystemGestureInsets(bVar.d());
        }

        @Override // androidx.core.view.X.d
        public void f(B.b bVar) {
            this.f9474c.setSystemWindowInsets(bVar.d());
        }

        @Override // androidx.core.view.X.d
        public void g(B.b bVar) {
            this.f9474c.setTappableElementInsets(bVar.d());
        }

        public b(X x10) {
            super(x10);
            WindowInsets.Builder builder;
            WindowInsets w10 = x10.w();
            if (w10 != null) {
                builder = new WindowInsets.Builder(w10);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f9474c = builder;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class f extends e {

        /* renamed from: h, reason: collision with root package name */
        public B.b f9482h;

        public f(X x10, WindowInsets windowInsets) {
            super(x10, windowInsets);
            this.f9482h = null;
        }

        @Override // androidx.core.view.X.j
        public X b() {
            return X.x(this.f9477c.consumeStableInsets());
        }

        @Override // androidx.core.view.X.j
        public X c() {
            return X.x(this.f9477c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.X.j
        public final B.b j() {
            if (this.f9482h == null) {
                this.f9482h = B.b.b(this.f9477c.getStableInsetLeft(), this.f9477c.getStableInsetTop(), this.f9477c.getStableInsetRight(), this.f9477c.getStableInsetBottom());
            }
            return this.f9482h;
        }

        @Override // androidx.core.view.X.j
        public boolean o() {
            return this.f9477c.isConsumed();
        }

        public f(X x10, f fVar) {
            super(x10, fVar);
            this.f9482h = null;
            this.f9482h = fVar.f9482h;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class e extends j {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets f9477c;

        /* renamed from: d, reason: collision with root package name */
        public B.b[] f9478d;

        /* renamed from: e, reason: collision with root package name */
        public B.b f9479e;

        /* renamed from: f, reason: collision with root package name */
        public X f9480f;

        /* renamed from: g, reason: collision with root package name */
        public B.b f9481g;

        public e(X x10, WindowInsets windowInsets) {
            super(x10);
            this.f9479e = null;
            this.f9477c = windowInsets;
        }

        private B.b u(int i10, boolean z10) {
            B.b bVar = B.b.f206e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    bVar = B.b.a(bVar, v(i11, z10));
                }
            }
            return bVar;
        }

        private B.b w() {
            X x10 = this.f9480f;
            if (x10 != null) {
                return x10.h();
            }
            return B.b.f206e;
        }

        private B.b x(View view) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.X.j
        public void d(View view) {
            B.b x10 = x(view);
            if (x10 == null) {
                x10 = B.b.f206e;
            }
            s(x10);
        }

        @Override // androidx.core.view.X.j
        public void e(X x10) {
            x10.v(this.f9480f);
            x10.u(this.f9481g);
        }

        @Override // androidx.core.view.X.j
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f9481g, ((e) obj).f9481g);
        }

        @Override // androidx.core.view.X.j
        public B.b g(int i10) {
            return u(i10, false);
        }

        @Override // androidx.core.view.X.j
        public B.b h(int i10) {
            return u(i10, true);
        }

        @Override // androidx.core.view.X.j
        public final B.b l() {
            if (this.f9479e == null) {
                this.f9479e = B.b.b(this.f9477c.getSystemWindowInsetLeft(), this.f9477c.getSystemWindowInsetTop(), this.f9477c.getSystemWindowInsetRight(), this.f9477c.getSystemWindowInsetBottom());
            }
            return this.f9479e;
        }

        @Override // androidx.core.view.X.j
        public X n(int i10, int i11, int i12, int i13) {
            a aVar = new a(X.x(this.f9477c));
            aVar.c(X.p(l(), i10, i11, i12, i13));
            aVar.b(X.p(j(), i10, i11, i12, i13));
            return aVar.a();
        }

        @Override // androidx.core.view.X.j
        public boolean p() {
            return this.f9477c.isRound();
        }

        @Override // androidx.core.view.X.j
        public boolean q(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0 && !y(i11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.X.j
        public void r(B.b[] bVarArr) {
            this.f9478d = bVarArr;
        }

        @Override // androidx.core.view.X.j
        public void s(B.b bVar) {
            this.f9481g = bVar;
        }

        @Override // androidx.core.view.X.j
        public void t(X x10) {
            this.f9480f = x10;
        }

        public B.b v(int i10, boolean z10) {
            int i11;
            C0453h f10;
            if (i10 != 1) {
                B.b bVar = null;
                if (i10 != 2) {
                    if (i10 != 8) {
                        if (i10 != 16) {
                            if (i10 != 32) {
                                if (i10 != 64) {
                                    if (i10 != 128) {
                                        return B.b.f206e;
                                    }
                                    X x10 = this.f9480f;
                                    if (x10 != null) {
                                        f10 = x10.e();
                                    } else {
                                        f10 = f();
                                    }
                                    if (f10 != null) {
                                        return B.b.b(f10.b(), f10.d(), f10.c(), f10.a());
                                    }
                                    return B.b.f206e;
                                }
                                return m();
                            }
                            return i();
                        }
                        return k();
                    }
                    B.b[] bVarArr = this.f9478d;
                    if (bVarArr != null) {
                        bVar = bVarArr[k.b(8)];
                    }
                    if (bVar != null) {
                        return bVar;
                    }
                    B.b l10 = l();
                    B.b w10 = w();
                    int i12 = l10.f210d;
                    if (i12 > w10.f210d) {
                        return B.b.b(0, 0, 0, i12);
                    }
                    B.b bVar2 = this.f9481g;
                    if (bVar2 != null && !bVar2.equals(B.b.f206e) && (i11 = this.f9481g.f210d) > w10.f210d) {
                        return B.b.b(0, 0, 0, i11);
                    }
                    return B.b.f206e;
                }
                if (z10) {
                    B.b w11 = w();
                    B.b j10 = j();
                    return B.b.b(Math.max(w11.f207a, j10.f207a), 0, Math.max(w11.f209c, j10.f209c), Math.max(w11.f210d, j10.f210d));
                }
                B.b l11 = l();
                X x11 = this.f9480f;
                if (x11 != null) {
                    bVar = x11.h();
                }
                int i13 = l11.f210d;
                if (bVar != null) {
                    i13 = Math.min(i13, bVar.f210d);
                }
                return B.b.b(l11.f207a, 0, l11.f209c, i13);
            }
            if (z10) {
                return B.b.b(0, Math.max(w().f208b, l().f208b), 0, 0);
            }
            return B.b.b(0, l().f208b, 0, 0);
        }

        public boolean y(int i10) {
            if (i10 != 1 && i10 != 2) {
                if (i10 == 4) {
                    return false;
                }
                if (i10 != 8 && i10 != 128) {
                    return true;
                }
            }
            return !v(i10, false).equals(B.b.f206e);
        }

        public e(X x10, e eVar) {
            this(x10, new WindowInsets(eVar.f9477c));
        }
    }

    public X(X x10) {
        if (x10 != null) {
            j jVar = x10.f9472a;
            if (jVar instanceof i) {
                this.f9472a = new i(this, (i) jVar);
            } else if (jVar instanceof h) {
                this.f9472a = new h(this, (h) jVar);
            } else if (jVar instanceof g) {
                this.f9472a = new g(this, (g) jVar);
            } else if (jVar instanceof f) {
                this.f9472a = new f(this, (f) jVar);
            } else if (jVar instanceof e) {
                this.f9472a = new e(this, (e) jVar);
            } else {
                this.f9472a = new j(this);
            }
            jVar.e(this);
            return;
        }
        this.f9472a = new j(this);
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class h extends g {

        /* renamed from: i, reason: collision with root package name */
        public B.b f9483i;

        /* renamed from: j, reason: collision with root package name */
        public B.b f9484j;

        /* renamed from: k, reason: collision with root package name */
        public B.b f9485k;

        public h(X x10, WindowInsets windowInsets) {
            super(x10, windowInsets);
            this.f9483i = null;
            this.f9484j = null;
            this.f9485k = null;
        }

        @Override // androidx.core.view.X.j
        public B.b i() {
            if (this.f9484j == null) {
                this.f9484j = B.b.c(this.f9477c.getMandatorySystemGestureInsets());
            }
            return this.f9484j;
        }

        @Override // androidx.core.view.X.j
        public B.b k() {
            if (this.f9483i == null) {
                this.f9483i = B.b.c(this.f9477c.getSystemGestureInsets());
            }
            return this.f9483i;
        }

        @Override // androidx.core.view.X.j
        public B.b m() {
            if (this.f9485k == null) {
                this.f9485k = B.b.c(this.f9477c.getTappableElementInsets());
            }
            return this.f9485k;
        }

        @Override // androidx.core.view.X.e, androidx.core.view.X.j
        public X n(int i10, int i11, int i12, int i13) {
            return X.x(this.f9477c.inset(i10, i11, i12, i13));
        }

        public h(X x10, h hVar) {
            super(x10, hVar);
            this.f9483i = null;
            this.f9484j = null;
            this.f9485k = null;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: b, reason: collision with root package name */
        public static final X f9487b = new a().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        public final X f9488a;

        public j(X x10) {
            this.f9488a = x10;
        }

        public X a() {
            return this.f9488a;
        }

        public X b() {
            return this.f9488a;
        }

        public X c() {
            return this.f9488a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            if (p() == jVar.p() && o() == jVar.o() && I.c.a(l(), jVar.l()) && I.c.a(j(), jVar.j()) && I.c.a(f(), jVar.f())) {
                return true;
            }
            return false;
        }

        public C0453h f() {
            return null;
        }

        public B.b g(int i10) {
            return B.b.f206e;
        }

        public B.b h(int i10) {
            if ((i10 & 8) == 0) {
                return B.b.f206e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return I.c.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        public B.b i() {
            return l();
        }

        public B.b j() {
            return B.b.f206e;
        }

        public B.b k() {
            return l();
        }

        public B.b l() {
            return B.b.f206e;
        }

        public B.b m() {
            return l();
        }

        public X n(int i10, int i11, int i12, int i13) {
            return f9487b;
        }

        public boolean o() {
            return false;
        }

        public boolean p() {
            return false;
        }

        public boolean q(int i10) {
            return true;
        }

        public void d(View view) {
        }

        public void e(X x10) {
        }

        public void r(B.b[] bVarArr) {
        }

        public void s(B.b bVar) {
        }

        public void t(X x10) {
        }
    }
}
