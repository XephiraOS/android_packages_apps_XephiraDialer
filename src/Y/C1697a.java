package y;

import I.e;
import I.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p.i;

/* compiled from: DirectedAcyclicGraph.java */
/* renamed from: y.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1697a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final e<ArrayList<T>> f38102a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    public final i<T, ArrayList<T>> f38103b = new i<>();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f38104c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet<T> f38105d = new HashSet<>();

    public void a(T t10, T t11) {
        if (this.f38103b.containsKey(t10) && this.f38103b.containsKey(t11)) {
            ArrayList<T> arrayList = this.f38103b.get(t10);
            if (arrayList == null) {
                arrayList = f();
                this.f38103b.put(t10, arrayList);
            }
            arrayList.add(t11);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void b(T t10) {
        if (!this.f38103b.containsKey(t10)) {
            this.f38103b.put(t10, null);
        }
    }

    public void c() {
        int size = this.f38103b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> l10 = this.f38103b.l(i10);
            if (l10 != null) {
                k(l10);
            }
        }
        this.f38103b.clear();
    }

    public boolean d(T t10) {
        return this.f38103b.containsKey(t10);
    }

    public final void e(T t10, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t10)) {
            return;
        }
        if (!hashSet.contains(t10)) {
            hashSet.add(t10);
            ArrayList<T> arrayList2 = this.f38103b.get(t10);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    e(arrayList2.get(i10), arrayList, hashSet);
                }
            }
            hashSet.remove(t10);
            arrayList.add(t10);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    public final ArrayList<T> f() {
        ArrayList<T> b10 = this.f38102a.b();
        if (b10 == null) {
            return new ArrayList<>();
        }
        return b10;
    }

    public List g(T t10) {
        return this.f38103b.get(t10);
    }

    public List<T> h(T t10) {
        int size = this.f38103b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> l10 = this.f38103b.l(i10);
            if (l10 != null && l10.contains(t10)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f38103b.h(i10));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f38104c.clear();
        this.f38105d.clear();
        int size = this.f38103b.size();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f38103b.h(i10), this.f38104c, this.f38105d);
        }
        return this.f38104c;
    }

    public boolean j(T t10) {
        int size = this.f38103b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList<T> l10 = this.f38103b.l(i10);
            if (l10 != null && l10.contains(t10)) {
                return true;
            }
        }
        return false;
    }

    public final void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f38102a.a(arrayList);
    }
}
