package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: DiffUtil.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator<d> f11113a = new a();

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<d> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar.f11116a - dVar2.f11116a;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract boolean a(int i10, int i11);

        public abstract boolean b(int i10, int i11);

        public Object c(int i10, int i11) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f11114a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11115b;

        public c(int i10) {
            int[] iArr = new int[i10];
            this.f11114a = iArr;
            this.f11115b = iArr.length / 2;
        }

        public int[] a() {
            return this.f11114a;
        }

        public int b(int i10) {
            return this.f11114a[i10 + this.f11115b];
        }

        public void c(int i10, int i11) {
            this.f11114a[i10 + this.f11115b] = i11;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f11116a;

        /* renamed from: b, reason: collision with root package name */
        public final int f11117b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11118c;

        public d(int i10, int i11, int i12) {
            this.f11116a = i10;
            this.f11117b = i11;
            this.f11118c = i12;
        }

        public int a() {
            return this.f11116a + this.f11118c;
        }

        public int b() {
            return this.f11117b + this.f11118c;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final List<d> f11119a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f11120b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f11121c;

        /* renamed from: d, reason: collision with root package name */
        public final b f11122d;

        /* renamed from: e, reason: collision with root package name */
        public final int f11123e;

        /* renamed from: f, reason: collision with root package name */
        public final int f11124f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f11125g;

        public e(b bVar, List<d> list, int[] iArr, int[] iArr2, boolean z10) {
            this.f11119a = list;
            this.f11120b = iArr;
            this.f11121c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f11122d = bVar;
            this.f11123e = bVar.e();
            this.f11124f = bVar.d();
            this.f11125g = z10;
            a();
            e();
        }

        public static g g(Collection<g> collection, int i10, boolean z10) {
            g gVar;
            Iterator<g> it = collection.iterator();
            while (true) {
                if (it.hasNext()) {
                    gVar = it.next();
                    if (gVar.f11126a == i10 && gVar.f11128c == z10) {
                        it.remove();
                        break;
                    }
                } else {
                    gVar = null;
                    break;
                }
            }
            while (it.hasNext()) {
                g next = it.next();
                if (z10) {
                    next.f11127b--;
                } else {
                    next.f11127b++;
                }
            }
            return gVar;
        }

        public final void a() {
            d dVar;
            if (this.f11119a.isEmpty()) {
                dVar = null;
            } else {
                dVar = this.f11119a.get(0);
            }
            if (dVar == null || dVar.f11116a != 0 || dVar.f11117b != 0) {
                this.f11119a.add(0, new d(0, 0, 0));
            }
            this.f11119a.add(new d(this.f11123e, this.f11124f, 0));
        }

        public void b(q qVar) {
            androidx.recyclerview.widget.e eVar;
            int i10;
            if (qVar instanceof androidx.recyclerview.widget.e) {
                eVar = (androidx.recyclerview.widget.e) qVar;
            } else {
                eVar = new androidx.recyclerview.widget.e(qVar);
            }
            int i11 = this.f11123e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i12 = this.f11123e;
            int i13 = this.f11124f;
            for (int size = this.f11119a.size() - 1; size >= 0; size--) {
                d dVar = this.f11119a.get(size);
                int a10 = dVar.a();
                int b10 = dVar.b();
                while (true) {
                    if (i12 <= a10) {
                        break;
                    }
                    i12--;
                    int i14 = this.f11120b[i12];
                    if ((i14 & 12) != 0) {
                        int i15 = i14 >> 4;
                        g g10 = g(arrayDeque, i15, false);
                        if (g10 != null) {
                            int i16 = (i11 - g10.f11127b) - 1;
                            eVar.a(i12, i16);
                            if ((i14 & 4) != 0) {
                                eVar.d(i16, 1, this.f11122d.c(i12, i15));
                            }
                        } else {
                            arrayDeque.add(new g(i12, (i11 - i12) - 1, true));
                        }
                    } else {
                        eVar.c(i12, 1);
                        i11--;
                    }
                }
                while (i13 > b10) {
                    i13--;
                    int i17 = this.f11121c[i13];
                    if ((i17 & 12) != 0) {
                        int i18 = i17 >> 4;
                        g g11 = g(arrayDeque, i18, true);
                        if (g11 == null) {
                            arrayDeque.add(new g(i13, i11 - i12, false));
                        } else {
                            eVar.a((i11 - g11.f11127b) - 1, i12);
                            if ((i17 & 4) != 0) {
                                eVar.d(i12, 1, this.f11122d.c(i18, i13));
                            }
                        }
                    } else {
                        eVar.b(i12, 1);
                        i11++;
                    }
                }
                int i19 = dVar.f11116a;
                int i20 = dVar.f11117b;
                for (i10 = 0; i10 < dVar.f11118c; i10++) {
                    if ((this.f11120b[i19] & 15) == 2) {
                        eVar.d(i19, 1, this.f11122d.c(i19, i20));
                    }
                    i19++;
                    i20++;
                }
                i12 = dVar.f11116a;
                i13 = dVar.f11117b;
            }
            eVar.e();
        }

        public void c(RecyclerView.Adapter adapter) {
            b(new androidx.recyclerview.widget.b(adapter));
        }

        public final void d(int i10) {
            int i11;
            int size = this.f11119a.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                d dVar = this.f11119a.get(i13);
                while (i12 < dVar.f11117b) {
                    if (this.f11121c[i12] == 0 && this.f11122d.b(i10, i12)) {
                        if (this.f11122d.a(i10, i12)) {
                            i11 = 8;
                        } else {
                            i11 = 4;
                        }
                        this.f11120b[i10] = (i12 << 4) | i11;
                        this.f11121c[i12] = (i10 << 4) | i11;
                        return;
                    }
                    i12++;
                }
                i12 = dVar.b();
            }
        }

        public final void e() {
            int i10;
            for (d dVar : this.f11119a) {
                for (int i11 = 0; i11 < dVar.f11118c; i11++) {
                    int i12 = dVar.f11116a + i11;
                    int i13 = dVar.f11117b + i11;
                    if (this.f11122d.a(i12, i13)) {
                        i10 = 1;
                    } else {
                        i10 = 2;
                    }
                    this.f11120b[i12] = (i13 << 4) | i10;
                    this.f11121c[i13] = (i12 << 4) | i10;
                }
            }
            if (this.f11125g) {
                f();
            }
        }

        public final void f() {
            int i10 = 0;
            for (d dVar : this.f11119a) {
                while (i10 < dVar.f11116a) {
                    if (this.f11120b[i10] == 0) {
                        d(i10);
                    }
                    i10++;
                }
                i10 = dVar.a();
            }
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class f<T> {
        public abstract boolean areContentsTheSame(T t10, T t11);

        public abstract boolean areItemsTheSame(T t10, T t11);

        public Object getChangePayload(T t10, T t11) {
            return null;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public int f11126a;

        /* renamed from: b, reason: collision with root package name */
        public int f11127b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f11128c;

        public g(int i10, int i11, boolean z10) {
            this.f11126a = i10;
            this.f11127b = i11;
            this.f11128c = z10;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f11129a;

        /* renamed from: b, reason: collision with root package name */
        public int f11130b;

        /* renamed from: c, reason: collision with root package name */
        public int f11131c;

        /* renamed from: d, reason: collision with root package name */
        public int f11132d;

        public h() {
        }

        public int a() {
            return this.f11132d - this.f11131c;
        }

        public int b() {
            return this.f11130b - this.f11129a;
        }

        public h(int i10, int i11, int i12, int i13) {
            this.f11129a = i10;
            this.f11130b = i11;
            this.f11131c = i12;
            this.f11132d = i13;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public int f11133a;

        /* renamed from: b, reason: collision with root package name */
        public int f11134b;

        /* renamed from: c, reason: collision with root package name */
        public int f11135c;

        /* renamed from: d, reason: collision with root package name */
        public int f11136d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11137e;

        public int a() {
            return Math.min(this.f11135c - this.f11133a, this.f11136d - this.f11134b);
        }

        public boolean b() {
            if (this.f11136d - this.f11134b != this.f11135c - this.f11133a) {
                return true;
            }
            return false;
        }

        public boolean c() {
            if (this.f11136d - this.f11134b > this.f11135c - this.f11133a) {
                return true;
            }
            return false;
        }

        public d d() {
            if (b()) {
                if (this.f11137e) {
                    return new d(this.f11133a, this.f11134b, a());
                }
                if (c()) {
                    return new d(this.f11133a, this.f11134b + 1, a());
                }
                return new d(this.f11133a + 1, this.f11134b, a());
            }
            int i10 = this.f11133a;
            return new d(i10, this.f11134b, this.f11135c - i10);
        }
    }

    public static i a(h hVar, b bVar, c cVar, c cVar2, int i10) {
        boolean z10;
        int b10;
        int i11;
        int i12;
        int i13;
        if ((hVar.b() - hVar.a()) % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int b11 = hVar.b() - hVar.a();
        int i14 = -i10;
        for (int i15 = i14; i15 <= i10; i15 += 2) {
            if (i15 != i14 && (i15 == i10 || cVar2.b(i15 + 1) >= cVar2.b(i15 - 1))) {
                b10 = cVar2.b(i15 - 1);
                i11 = b10 - 1;
            } else {
                b10 = cVar2.b(i15 + 1);
                i11 = b10;
            }
            int i16 = hVar.f11132d - ((hVar.f11130b - i11) - i15);
            if (i10 != 0 && i11 == b10) {
                i12 = i16 + 1;
            } else {
                i12 = i16;
            }
            while (i11 > hVar.f11129a && i16 > hVar.f11131c && bVar.b(i11 - 1, i16 - 1)) {
                i11--;
                i16--;
            }
            cVar2.c(i15, i11);
            if (z10 && (i13 = b11 - i15) >= i14 && i13 <= i10 && cVar.b(i13) >= i11) {
                i iVar = new i();
                iVar.f11133a = i11;
                iVar.f11134b = i16;
                iVar.f11135c = b10;
                iVar.f11136d = i12;
                iVar.f11137e = true;
                return iVar;
            }
        }
        return null;
    }

    public static e b(b bVar) {
        return c(bVar, true);
    }

    public static e c(b bVar, boolean z10) {
        h hVar;
        int e10 = bVar.e();
        int d10 = bVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new h(0, e10, 0, d10));
        int i10 = ((((e10 + d10) + 1) / 2) * 2) + 1;
        c cVar = new c(i10);
        c cVar2 = new c(i10);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            h hVar2 = (h) arrayList2.remove(arrayList2.size() - 1);
            i e11 = e(hVar2, bVar, cVar, cVar2);
            if (e11 != null) {
                if (e11.a() > 0) {
                    arrayList.add(e11.d());
                }
                if (arrayList3.isEmpty()) {
                    hVar = new h();
                } else {
                    hVar = (h) arrayList3.remove(arrayList3.size() - 1);
                }
                hVar.f11129a = hVar2.f11129a;
                hVar.f11131c = hVar2.f11131c;
                hVar.f11130b = e11.f11133a;
                hVar.f11132d = e11.f11134b;
                arrayList2.add(hVar);
                hVar2.f11130b = hVar2.f11130b;
                hVar2.f11132d = hVar2.f11132d;
                hVar2.f11129a = e11.f11135c;
                hVar2.f11131c = e11.f11136d;
                arrayList2.add(hVar2);
            } else {
                arrayList3.add(hVar2);
            }
        }
        Collections.sort(arrayList, f11113a);
        return new e(bVar, arrayList, cVar.a(), cVar2.a(), z10);
    }

    public static i d(h hVar, b bVar, c cVar, c cVar2, int i10) {
        int b10;
        int i11;
        int i12;
        boolean z10 = true;
        if (Math.abs(hVar.b() - hVar.a()) % 2 != 1) {
            z10 = false;
        }
        int b11 = hVar.b() - hVar.a();
        int i13 = -i10;
        for (int i14 = i13; i14 <= i10; i14 += 2) {
            if (i14 != i13 && (i14 == i10 || cVar.b(i14 + 1) <= cVar.b(i14 - 1))) {
                b10 = cVar.b(i14 - 1);
                i11 = b10 + 1;
            } else {
                b10 = cVar.b(i14 + 1);
                i11 = b10;
            }
            int i15 = (hVar.f11131c + (i11 - hVar.f11129a)) - i14;
            int i16 = (i10 != 0 && i11 == b10) ? i15 - 1 : i15;
            while (i11 < hVar.f11130b && i15 < hVar.f11132d && bVar.b(i11, i15)) {
                i11++;
                i15++;
            }
            cVar.c(i14, i11);
            if (z10 && (i12 = b11 - i14) >= i13 + 1 && i12 <= i10 - 1 && cVar2.b(i12) <= i11) {
                i iVar = new i();
                iVar.f11133a = b10;
                iVar.f11134b = i16;
                iVar.f11135c = i11;
                iVar.f11136d = i15;
                iVar.f11137e = false;
                return iVar;
            }
        }
        return null;
    }

    public static i e(h hVar, b bVar, c cVar, c cVar2) {
        if (hVar.b() >= 1 && hVar.a() >= 1) {
            int b10 = ((hVar.b() + hVar.a()) + 1) / 2;
            cVar.c(1, hVar.f11129a);
            cVar2.c(1, hVar.f11130b);
            for (int i10 = 0; i10 < b10; i10++) {
                i d10 = d(hVar, bVar, cVar, cVar2, i10);
                if (d10 != null) {
                    return d10;
                }
                i a10 = a(hVar, bVar, cVar, cVar2, i10);
                if (a10 != null) {
                    return a10;
                }
            }
        }
        return null;
    }
}
