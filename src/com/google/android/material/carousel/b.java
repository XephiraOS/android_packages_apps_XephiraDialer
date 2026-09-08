package com.google.android.material.carousel;

import f4.C1001b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: KeylineState.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f22947a;

    /* renamed from: b, reason: collision with root package name */
    public final List<c> f22948b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22949c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22950d;

    /* compiled from: KeylineState.java */
    /* renamed from: com.google.android.material.carousel.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0210b {

        /* renamed from: a, reason: collision with root package name */
        public final float f22951a;

        /* renamed from: b, reason: collision with root package name */
        public final float f22952b;

        /* renamed from: d, reason: collision with root package name */
        public c f22954d;

        /* renamed from: e, reason: collision with root package name */
        public c f22955e;

        /* renamed from: c, reason: collision with root package name */
        public final List<c> f22953c = new ArrayList();

        /* renamed from: f, reason: collision with root package name */
        public int f22956f = -1;

        /* renamed from: g, reason: collision with root package name */
        public int f22957g = -1;

        /* renamed from: h, reason: collision with root package name */
        public float f22958h = 0.0f;

        /* renamed from: i, reason: collision with root package name */
        public int f22959i = -1;

        public C0210b(float f10, float f11) {
            this.f22951a = f10;
            this.f22952b = f11;
        }

        public static float j(float f10, float f11, int i10, int i11) {
            return (f10 - (i10 * f11)) + (i11 * f11);
        }

        public C0210b a(float f10, float f11, float f12) {
            return d(f10, f11, f12, false, true);
        }

        public C0210b b(float f10, float f11, float f12) {
            return c(f10, f11, f12, false);
        }

        public C0210b c(float f10, float f11, float f12, boolean z10) {
            return d(f10, f11, f12, z10, false);
        }

        public C0210b d(float f10, float f11, float f12, boolean z10, boolean z11) {
            float f13;
            float f14 = f12 / 2.0f;
            float f15 = f10 - f14;
            float f16 = f14 + f10;
            float f17 = this.f22952b;
            if (f16 > f17) {
                f13 = Math.abs(f16 - Math.max(f16 - f12, f17));
            } else {
                f13 = 0.0f;
                if (f15 < 0.0f) {
                    f13 = Math.abs(f15 - Math.min(f15 + f12, 0.0f));
                }
            }
            return e(f10, f11, f12, z10, z11, f13);
        }

        public C0210b e(float f10, float f11, float f12, boolean z10, boolean z11, float f13) {
            return f(f10, f11, f12, z10, z11, f13, 0.0f, 0.0f);
        }

        public C0210b f(float f10, float f11, float f12, boolean z10, boolean z11, float f13, float f14, float f15) {
            if (f12 <= 0.0f) {
                return this;
            }
            if (z11) {
                if (!z10) {
                    int i10 = this.f22959i;
                    if (i10 != -1 && i10 != 0) {
                        throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                    }
                    this.f22959i = this.f22953c.size();
                } else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }
            c cVar = new c(Float.MIN_VALUE, f10, f11, f12, z11, f13, f14, f15);
            if (z10) {
                if (this.f22954d == null) {
                    this.f22954d = cVar;
                    this.f22956f = this.f22953c.size();
                }
                if (this.f22957g != -1 && this.f22953c.size() - this.f22957g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f12 == this.f22954d.f22963d) {
                    this.f22955e = cVar;
                    this.f22957g = this.f22953c.size();
                } else {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
            } else {
                if (this.f22954d == null && cVar.f22963d < this.f22958h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f22955e != null && cVar.f22963d > this.f22958h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f22958h = cVar.f22963d;
            this.f22953c.add(cVar);
            return this;
        }

        public C0210b g(float f10, float f11, float f12, int i10) {
            return h(f10, f11, f12, i10, false);
        }

        public C0210b h(float f10, float f11, float f12, int i10, boolean z10) {
            if (i10 > 0 && f12 > 0.0f) {
                for (int i11 = 0; i11 < i10; i11++) {
                    c((i11 * f12) + f10, f11, f12, z10);
                }
            }
            return this;
        }

        public b i() {
            if (this.f22954d != null) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < this.f22953c.size(); i10++) {
                    c cVar = this.f22953c.get(i10);
                    arrayList.add(new c(j(this.f22954d.f22961b, this.f22951a, this.f22956f, i10), cVar.f22961b, cVar.f22962c, cVar.f22963d, cVar.f22964e, cVar.f22965f, cVar.f22966g, cVar.f22967h));
                }
                return new b(this.f22951a, arrayList, this.f22956f, this.f22957g);
            }
            throw new IllegalStateException("There must be a keyline marked as focal.");
        }
    }

    /* compiled from: KeylineState.java */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final float f22960a;

        /* renamed from: b, reason: collision with root package name */
        public final float f22961b;

        /* renamed from: c, reason: collision with root package name */
        public final float f22962c;

        /* renamed from: d, reason: collision with root package name */
        public final float f22963d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f22964e;

        /* renamed from: f, reason: collision with root package name */
        public final float f22965f;

        /* renamed from: g, reason: collision with root package name */
        public final float f22966g;

        /* renamed from: h, reason: collision with root package name */
        public final float f22967h;

        public c(float f10, float f11, float f12, float f13) {
            this(f10, f11, f12, f13, false, 0.0f, 0.0f, 0.0f);
        }

        public static c a(c cVar, c cVar2, float f10) {
            return new c(C1001b.a(cVar.f22960a, cVar2.f22960a, f10), C1001b.a(cVar.f22961b, cVar2.f22961b, f10), C1001b.a(cVar.f22962c, cVar2.f22962c, f10), C1001b.a(cVar.f22963d, cVar2.f22963d, f10));
        }

        public c(float f10, float f11, float f12, float f13, boolean z10, float f14, float f15, float f16) {
            this.f22960a = f10;
            this.f22961b = f11;
            this.f22962c = f12;
            this.f22963d = f13;
            this.f22964e = z10;
            this.f22965f = f14;
            this.f22966g = f15;
            this.f22967h = f16;
        }
    }

    public static b m(b bVar, b bVar2, float f10) {
        if (bVar.f() == bVar2.f()) {
            List<c> g10 = bVar.g();
            List<c> g11 = bVar2.g();
            if (g10.size() == g11.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < bVar.g().size(); i10++) {
                    arrayList.add(c.a(g10.get(i10), g11.get(i10), f10));
                }
                return new b(bVar.f(), arrayList, C1001b.c(bVar.b(), bVar2.b(), f10), C1001b.c(bVar.i(), bVar2.i(), f10));
            }
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }

    public static b n(b bVar, float f10) {
        boolean z10;
        C0210b c0210b = new C0210b(bVar.f(), f10);
        float f11 = (f10 - bVar.j().f22961b) - (bVar.j().f22963d / 2.0f);
        for (int size = bVar.g().size() - 1; size >= 0; size--) {
            c cVar = bVar.g().get(size);
            float f12 = f11 + (cVar.f22963d / 2.0f);
            if (size >= bVar.b() && size <= bVar.i()) {
                z10 = true;
            } else {
                z10 = false;
            }
            c0210b.d(f12, cVar.f22962c, cVar.f22963d, z10, cVar.f22964e);
            f11 += cVar.f22963d;
        }
        return c0210b.i();
    }

    public c a() {
        return this.f22948b.get(this.f22949c);
    }

    public int b() {
        return this.f22949c;
    }

    public c c() {
        return this.f22948b.get(0);
    }

    public c d() {
        for (int i10 = 0; i10 < this.f22948b.size(); i10++) {
            c cVar = this.f22948b.get(i10);
            if (!cVar.f22964e) {
                return cVar;
            }
        }
        return null;
    }

    public List<c> e() {
        return this.f22948b.subList(this.f22949c, this.f22950d + 1);
    }

    public float f() {
        return this.f22947a;
    }

    public List<c> g() {
        return this.f22948b;
    }

    public c h() {
        return this.f22948b.get(this.f22950d);
    }

    public int i() {
        return this.f22950d;
    }

    public c j() {
        return this.f22948b.get(r1.size() - 1);
    }

    public c k() {
        for (int size = this.f22948b.size() - 1; size >= 0; size--) {
            c cVar = this.f22948b.get(size);
            if (!cVar.f22964e) {
                return cVar;
            }
        }
        return null;
    }

    public int l() {
        Iterator<c> it = this.f22948b.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (it.next().f22964e) {
                i10++;
            }
        }
        return this.f22948b.size() - i10;
    }

    public b(float f10, List<c> list, int i10, int i11) {
        this.f22947a = f10;
        this.f22948b = Collections.unmodifiableList(list);
        this.f22949c = i10;
        this.f22950d = i11;
    }
}
