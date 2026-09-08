package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import p.C1420f;

/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public final p.i<RecyclerView.B, a> f11217a = new p.i<>();

    /* renamed from: b, reason: collision with root package name */
    public final C1420f<RecyclerView.B> f11218b = new C1420f<>();

    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public static I.e<a> f11219d = new I.f(20);

        /* renamed from: a, reason: collision with root package name */
        public int f11220a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.l.c f11221b;

        /* renamed from: c, reason: collision with root package name */
        public RecyclerView.l.c f11222c;

        public static void a() {
            do {
            } while (f11219d.b() != null);
        }

        public static a b() {
            a b10 = f11219d.b();
            if (b10 == null) {
                return new a();
            }
            return b10;
        }

        public static void c(a aVar) {
            aVar.f11220a = 0;
            aVar.f11221b = null;
            aVar.f11222c = null;
            f11219d.a(aVar);
        }
    }

    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.B b10);

        void b(RecyclerView.B b10, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.B b10, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.B b10, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    public void a(RecyclerView.B b10, RecyclerView.l.c cVar) {
        a aVar = this.f11217a.get(b10);
        if (aVar == null) {
            aVar = a.b();
            this.f11217a.put(b10, aVar);
        }
        aVar.f11220a |= 2;
        aVar.f11221b = cVar;
    }

    public void b(RecyclerView.B b10) {
        a aVar = this.f11217a.get(b10);
        if (aVar == null) {
            aVar = a.b();
            this.f11217a.put(b10, aVar);
        }
        aVar.f11220a |= 1;
    }

    public void c(long j10, RecyclerView.B b10) {
        this.f11218b.h(j10, b10);
    }

    public void d(RecyclerView.B b10, RecyclerView.l.c cVar) {
        a aVar = this.f11217a.get(b10);
        if (aVar == null) {
            aVar = a.b();
            this.f11217a.put(b10, aVar);
        }
        aVar.f11222c = cVar;
        aVar.f11220a |= 8;
    }

    public void e(RecyclerView.B b10, RecyclerView.l.c cVar) {
        a aVar = this.f11217a.get(b10);
        if (aVar == null) {
            aVar = a.b();
            this.f11217a.put(b10, aVar);
        }
        aVar.f11221b = cVar;
        aVar.f11220a |= 4;
    }

    public void f() {
        this.f11217a.clear();
        this.f11218b.a();
    }

    public RecyclerView.B g(long j10) {
        return this.f11218b.d(j10);
    }

    public boolean h(RecyclerView.B b10) {
        a aVar = this.f11217a.get(b10);
        if (aVar != null && (aVar.f11220a & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean i(RecyclerView.B b10) {
        a aVar = this.f11217a.get(b10);
        if (aVar != null && (aVar.f11220a & 4) != 0) {
            return true;
        }
        return false;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.B b10) {
        p(b10);
    }

    public final RecyclerView.l.c l(RecyclerView.B b10, int i10) {
        a l10;
        RecyclerView.l.c cVar;
        int f10 = this.f11217a.f(b10);
        if (f10 >= 0 && (l10 = this.f11217a.l(f10)) != null) {
            int i11 = l10.f11220a;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                l10.f11220a = i12;
                if (i10 == 4) {
                    cVar = l10.f11221b;
                } else if (i10 == 8) {
                    cVar = l10.f11222c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i12 & 12) == 0) {
                    this.f11217a.j(f10);
                    a.c(l10);
                }
                return cVar;
            }
        }
        return null;
    }

    public RecyclerView.l.c m(RecyclerView.B b10) {
        return l(b10, 8);
    }

    public RecyclerView.l.c n(RecyclerView.B b10) {
        return l(b10, 4);
    }

    public void o(b bVar) {
        for (int size = this.f11217a.size() - 1; size >= 0; size--) {
            RecyclerView.B h10 = this.f11217a.h(size);
            a j10 = this.f11217a.j(size);
            int i10 = j10.f11220a;
            if ((i10 & 3) == 3) {
                bVar.a(h10);
            } else if ((i10 & 1) != 0) {
                RecyclerView.l.c cVar = j10.f11221b;
                if (cVar == null) {
                    bVar.a(h10);
                } else {
                    bVar.c(h10, cVar, j10.f11222c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.b(h10, j10.f11221b, j10.f11222c);
            } else if ((i10 & 12) == 12) {
                bVar.d(h10, j10.f11221b, j10.f11222c);
            } else if ((i10 & 4) != 0) {
                bVar.c(h10, j10.f11221b, null);
            } else if ((i10 & 8) != 0) {
                bVar.b(h10, j10.f11221b, j10.f11222c);
            }
            a.c(j10);
        }
    }

    public void p(RecyclerView.B b10) {
        a aVar = this.f11217a.get(b10);
        if (aVar == null) {
            return;
        }
        aVar.f11220a &= -2;
    }

    public void q(RecyclerView.B b10) {
        int k10 = this.f11218b.k() - 1;
        while (true) {
            if (k10 < 0) {
                break;
            }
            if (b10 == this.f11218b.l(k10)) {
                this.f11218b.j(k10);
                break;
            }
            k10--;
        }
        a remove = this.f11217a.remove(b10);
        if (remove != null) {
            a.c(remove);
        }
    }
}
