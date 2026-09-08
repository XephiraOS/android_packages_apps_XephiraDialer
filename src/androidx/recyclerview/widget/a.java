package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
public final class a implements r.a {

    /* renamed from: a, reason: collision with root package name */
    public I.e<b> f10999a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f11000b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f11001c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC0135a f11002d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f11003e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11004f;

    /* renamed from: g, reason: collision with root package name */
    public final r f11005g;

    /* renamed from: h, reason: collision with root package name */
    public int f11006h;

    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0135a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(int i10, int i11, Object obj);

        void d(b bVar);

        RecyclerView.B e(int i10);

        void f(int i10, int i11);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    /* compiled from: AdapterHelper.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f11007a;

        /* renamed from: b, reason: collision with root package name */
        public int f11008b;

        /* renamed from: c, reason: collision with root package name */
        public Object f11009c;

        /* renamed from: d, reason: collision with root package name */
        public int f11010d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f11007a = i10;
            this.f11008b = i11;
            this.f11010d = i12;
            this.f11009c = obj;
        }

        public String a() {
            int i10 = this.f11007a;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 4) {
                        if (i10 != 8) {
                            return "??";
                        }
                        return "mv";
                    }
                    return "up";
                }
                return "rm";
            }
            return "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f11007a;
            if (i10 != bVar.f11007a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f11010d - this.f11008b) == 1 && this.f11010d == bVar.f11008b && this.f11008b == bVar.f11010d) {
                return true;
            }
            if (this.f11010d != bVar.f11010d || this.f11008b != bVar.f11008b) {
                return false;
            }
            Object obj2 = this.f11009c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f11009c)) {
                    return false;
                }
            } else if (bVar.f11009c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f11007a * 31) + this.f11008b) * 31) + this.f11010d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f11008b + "c:" + this.f11010d + ",p:" + this.f11009c + "]";
        }
    }

    public a(InterfaceC0135a interfaceC0135a) {
        this(interfaceC0135a, false);
    }

    @Override // androidx.recyclerview.widget.r.a
    public void a(b bVar) {
        if (!this.f11004f) {
            bVar.f11009c = null;
            this.f10999a.a(bVar);
        }
    }

    @Override // androidx.recyclerview.widget.r.a
    public b b(int i10, int i11, int i12, Object obj) {
        b b10 = this.f10999a.b();
        if (b10 == null) {
            return new b(i10, i11, i12, obj);
        }
        b10.f11007a = i10;
        b10.f11008b = i11;
        b10.f11010d = i12;
        b10.f11009c = obj;
        return b10;
    }

    public final void c(b bVar) {
        v(bVar);
    }

    public final void d(b bVar) {
        v(bVar);
    }

    public int e(int i10) {
        int size = this.f11000b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f11000b.get(i11);
            int i12 = bVar.f11007a;
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 == 8) {
                        int i13 = bVar.f11008b;
                        if (i13 == i10) {
                            i10 = bVar.f11010d;
                        } else {
                            if (i13 < i10) {
                                i10--;
                            }
                            if (bVar.f11010d <= i10) {
                                i10++;
                            }
                        }
                    }
                } else {
                    int i14 = bVar.f11008b;
                    if (i14 <= i10) {
                        int i15 = bVar.f11010d;
                        if (i14 + i15 > i10) {
                            return -1;
                        }
                        i10 -= i15;
                    } else {
                        continue;
                    }
                }
            } else if (bVar.f11008b <= i10) {
                i10 += bVar.f11010d;
            }
        }
        return i10;
    }

    public final void f(b bVar) {
        boolean z10;
        char c10;
        int i10 = bVar.f11008b;
        int i11 = bVar.f11010d + i10;
        char c11 = 65535;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f11002d.e(i12) == null && !h(i12)) {
                if (c11 == 1) {
                    v(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 0;
            } else {
                if (c11 == 0) {
                    k(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c10 = 1;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            c11 = c10;
        }
        if (i13 != bVar.f11010d) {
            a(bVar);
            bVar = b(2, i10, i13, null);
        }
        if (c11 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final void g(b bVar) {
        int i10 = bVar.f11008b;
        int i11 = bVar.f11010d + i10;
        int i12 = 0;
        boolean z10 = -1;
        int i13 = i10;
        while (i10 < i11) {
            if (this.f11002d.e(i10) == null && !h(i10)) {
                if (z10) {
                    v(b(4, i13, i12, bVar.f11009c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = false;
            } else {
                if (!z10) {
                    k(b(4, i13, i12, bVar.f11009c));
                    i13 = i10;
                    i12 = 0;
                }
                z10 = true;
            }
            i12++;
            i10++;
        }
        if (i12 != bVar.f11010d) {
            Object obj = bVar.f11009c;
            a(bVar);
            bVar = b(4, i13, i12, obj);
        }
        if (!z10) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    public final boolean h(int i10) {
        int size = this.f11001c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f11001c.get(i11);
            int i12 = bVar.f11007a;
            if (i12 == 8) {
                if (n(bVar.f11010d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f11008b;
                int i14 = bVar.f11010d + i13;
                while (i13 < i14) {
                    if (n(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.f11001c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f11002d.d(this.f11001c.get(i10));
        }
        x(this.f11001c);
        this.f11006h = 0;
    }

    public void j() {
        i();
        int size = this.f11000b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f11000b.get(i10);
            int i11 = bVar.f11007a;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 4) {
                        if (i11 == 8) {
                            this.f11002d.d(bVar);
                            this.f11002d.a(bVar.f11008b, bVar.f11010d);
                        }
                    } else {
                        this.f11002d.d(bVar);
                        this.f11002d.c(bVar.f11008b, bVar.f11010d, bVar.f11009c);
                    }
                } else {
                    this.f11002d.d(bVar);
                    this.f11002d.h(bVar.f11008b, bVar.f11010d);
                }
            } else {
                this.f11002d.d(bVar);
                this.f11002d.g(bVar.f11008b, bVar.f11010d);
            }
            Runnable runnable = this.f11003e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f11000b);
        this.f11006h = 0;
    }

    public final void k(b bVar) {
        int i10;
        int i11 = bVar.f11007a;
        if (i11 != 1 && i11 != 8) {
            int z10 = z(bVar.f11008b, i11);
            int i12 = bVar.f11008b;
            int i13 = bVar.f11007a;
            if (i13 != 2) {
                if (i13 == 4) {
                    i10 = 1;
                } else {
                    throw new IllegalArgumentException("op should be remove or update." + bVar);
                }
            } else {
                i10 = 0;
            }
            int i14 = 1;
            for (int i15 = 1; i15 < bVar.f11010d; i15++) {
                int z11 = z(bVar.f11008b + (i10 * i15), bVar.f11007a);
                int i16 = bVar.f11007a;
                if (i16 == 2 ? z11 == z10 : !(i16 != 4 || z11 != z10 + 1)) {
                    i14++;
                } else {
                    b b10 = b(i16, z10, i14, bVar.f11009c);
                    l(b10, i12);
                    a(b10);
                    if (bVar.f11007a == 4) {
                        i12 += i14;
                    }
                    i14 = 1;
                    z10 = z11;
                }
            }
            Object obj = bVar.f11009c;
            a(bVar);
            if (i14 > 0) {
                b b11 = b(bVar.f11007a, z10, i14, obj);
                l(b11, i12);
                a(b11);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void l(b bVar, int i10) {
        this.f11002d.b(bVar);
        int i11 = bVar.f11007a;
        if (i11 != 2) {
            if (i11 == 4) {
                this.f11002d.c(i10, bVar.f11010d, bVar.f11009c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        this.f11002d.h(i10, bVar.f11010d);
    }

    public int m(int i10) {
        return n(i10, 0);
    }

    public int n(int i10, int i11) {
        int size = this.f11001c.size();
        while (i11 < size) {
            b bVar = this.f11001c.get(i11);
            int i12 = bVar.f11007a;
            if (i12 == 8) {
                int i13 = bVar.f11008b;
                if (i13 == i10) {
                    i10 = bVar.f11010d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f11010d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f11008b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f11010d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f11010d;
                }
            }
            i11++;
        }
        return i10;
    }

    public boolean o(int i10) {
        if ((this.f11006h & i10) != 0) {
            return true;
        }
        return false;
    }

    public boolean p() {
        if (this.f11000b.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (!this.f11001c.isEmpty() && !this.f11000b.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean r(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f11000b.add(b(4, i10, i11, obj));
        this.f11006h |= 4;
        if (this.f11000b.size() != 1) {
            return false;
        }
        return true;
    }

    public boolean s(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f11000b.add(b(1, i10, i11, null));
        this.f11006h |= 1;
        if (this.f11000b.size() != 1) {
            return false;
        }
        return true;
    }

    public boolean t(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 == 1) {
            this.f11000b.add(b(8, i10, i11, null));
            this.f11006h |= 8;
            if (this.f11000b.size() != 1) {
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public boolean u(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f11000b.add(b(2, i10, i11, null));
        this.f11006h |= 2;
        if (this.f11000b.size() != 1) {
            return false;
        }
        return true;
    }

    public final void v(b bVar) {
        this.f11001c.add(bVar);
        int i10 = bVar.f11007a;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 4) {
                    if (i10 == 8) {
                        this.f11002d.a(bVar.f11008b, bVar.f11010d);
                        return;
                    }
                    throw new IllegalArgumentException("Unknown update op type for " + bVar);
                }
                this.f11002d.c(bVar.f11008b, bVar.f11010d, bVar.f11009c);
                return;
            }
            this.f11002d.f(bVar.f11008b, bVar.f11010d);
            return;
        }
        this.f11002d.g(bVar.f11008b, bVar.f11010d);
    }

    public void w() {
        this.f11005g.b(this.f11000b);
        int size = this.f11000b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f11000b.get(i10);
            int i11 = bVar.f11007a;
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 4) {
                        if (i11 == 8) {
                            d(bVar);
                        }
                    } else {
                        g(bVar);
                    }
                } else {
                    f(bVar);
                }
            } else {
                c(bVar);
            }
            Runnable runnable = this.f11003e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f11000b.clear();
    }

    public void x(List<b> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(list.get(i10));
        }
        list.clear();
    }

    public void y() {
        x(this.f11000b);
        x(this.f11001c);
        this.f11006h = 0;
    }

    public final int z(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f11001c.size() - 1; size >= 0; size--) {
            b bVar = this.f11001c.get(size);
            int i14 = bVar.f11007a;
            if (i14 == 8) {
                int i15 = bVar.f11008b;
                int i16 = bVar.f11010d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 >= i13 && i10 <= i12) {
                    if (i13 == i15) {
                        if (i11 == 1) {
                            bVar.f11010d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f11010d = i16 - 1;
                        }
                        i10++;
                    } else {
                        if (i11 == 1) {
                            bVar.f11008b = i15 + 1;
                        } else if (i11 == 2) {
                            bVar.f11008b = i15 - 1;
                        }
                        i10--;
                    }
                } else if (i10 < i15) {
                    if (i11 == 1) {
                        bVar.f11008b = i15 + 1;
                        bVar.f11010d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f11008b = i15 - 1;
                        bVar.f11010d = i16 - 1;
                    }
                }
            } else {
                int i17 = bVar.f11008b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f11010d;
                    } else if (i14 == 2) {
                        i10 += bVar.f11010d;
                    }
                } else if (i11 == 1) {
                    bVar.f11008b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f11008b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f11001c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f11001c.get(size2);
            if (bVar2.f11007a == 8) {
                int i18 = bVar2.f11010d;
                if (i18 == bVar2.f11008b || i18 < 0) {
                    this.f11001c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f11010d <= 0) {
                this.f11001c.remove(size2);
                a(bVar2);
            }
        }
        return i10;
    }

    public a(InterfaceC0135a interfaceC0135a, boolean z10) {
        this.f10999a = new I.f(30);
        this.f11000b = new ArrayList<>();
        this.f11001c = new ArrayList<>();
        this.f11006h = 0;
        this.f11002d = interfaceC0135a;
        this.f11004f = z10;
        this.f11005g = new r(this);
    }
}
