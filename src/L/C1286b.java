package l;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: SafeIterableMap.java */
/* renamed from: l.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1286b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    public c<K, V> f34655a;

    /* renamed from: b, reason: collision with root package name */
    public c<K, V> f34656b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap<f<K, V>, Boolean> f34657c = new WeakHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public int f34658d = 0;

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l.b$a */
    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // l.C1286b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f34662d;
        }

        @Override // l.C1286b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f34661c;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0328b<K, V> extends e<K, V> {
        public C0328b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // l.C1286b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.f34661c;
        }

        @Override // l.C1286b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.f34662d;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l.b$c */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f34659a;

        /* renamed from: b, reason: collision with root package name */
        public final V f34660b;

        /* renamed from: c, reason: collision with root package name */
        public c<K, V> f34661c;

        /* renamed from: d, reason: collision with root package name */
        public c<K, V> f34662d;

        public c(K k10, V v10) {
            this.f34659a = k10;
            this.f34660b = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f34659a.equals(cVar.f34659a) && this.f34660b.equals(cVar.f34660b)) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f34659a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f34660b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f34660b.hashCode() ^ this.f34659a.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f34659a + "=" + this.f34660b;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l.b$d */
    /* loaded from: classes.dex */
    public class d extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public c<K, V> f34663a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f34664b = true;

        public d() {
        }

        @Override // l.C1286b.f
        public void a(c<K, V> cVar) {
            boolean z10;
            c<K, V> cVar2 = this.f34663a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f34662d;
                this.f34663a = cVar3;
                if (cVar3 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f34664b = z10;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f34664b) {
                this.f34664b = false;
                this.f34663a = C1286b.this.f34655a;
            } else {
                c<K, V> cVar2 = this.f34663a;
                if (cVar2 != null) {
                    cVar = cVar2.f34661c;
                } else {
                    cVar = null;
                }
                this.f34663a = cVar;
            }
            return this.f34663a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34664b) {
                if (C1286b.this.f34655a == null) {
                    return false;
                }
                return true;
            }
            c<K, V> cVar = this.f34663a;
            if (cVar == null || cVar.f34661c == null) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l.b$e */
    /* loaded from: classes.dex */
    public static abstract class e<K, V> extends f<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public c<K, V> f34666a;

        /* renamed from: b, reason: collision with root package name */
        public c<K, V> f34667b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f34666a = cVar2;
            this.f34667b = cVar;
        }

        @Override // l.C1286b.f
        public void a(c<K, V> cVar) {
            if (this.f34666a == cVar && cVar == this.f34667b) {
                this.f34667b = null;
                this.f34666a = null;
            }
            c<K, V> cVar2 = this.f34666a;
            if (cVar2 == cVar) {
                this.f34666a = b(cVar2);
            }
            if (this.f34667b == cVar) {
                this.f34667b = e();
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f34667b;
            this.f34667b = e();
            return cVar;
        }

        public final c<K, V> e() {
            c<K, V> cVar = this.f34667b;
            c<K, V> cVar2 = this.f34666a;
            if (cVar != cVar2 && cVar2 != null) {
                return c(cVar);
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34667b != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: SafeIterableMap.java */
    /* renamed from: l.b$f */
    /* loaded from: classes.dex */
    public static abstract class f<K, V> {
        public abstract void a(c<K, V> cVar);
    }

    public Map.Entry<K, V> a() {
        return this.f34655a;
    }

    public c<K, V> c(K k10) {
        c<K, V> cVar = this.f34655a;
        while (cVar != null && !cVar.f34659a.equals(k10)) {
            cVar = cVar.f34661c;
        }
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0328b c0328b = new C0328b(this.f34656b, this.f34655a);
        this.f34657c.put(c0328b, Boolean.FALSE);
        return c0328b;
    }

    public C1286b<K, V>.d e() {
        C1286b<K, V>.d dVar = new d();
        this.f34657c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1286b)) {
            return false;
        }
        C1286b c1286b = (C1286b) obj;
        if (size() != c1286b.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = c1286b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        return false;
    }

    public Map.Entry<K, V> g() {
        return this.f34656b;
    }

    public c<K, V> h(K k10, V v10) {
        c<K, V> cVar = new c<>(k10, v10);
        this.f34658d++;
        c<K, V> cVar2 = this.f34656b;
        if (cVar2 == null) {
            this.f34655a = cVar;
            this.f34656b = cVar;
            return cVar;
        }
        cVar2.f34661c = cVar;
        cVar.f34662d = cVar2;
        this.f34656b = cVar;
        return cVar;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().hashCode();
        }
        return i10;
    }

    public V i(K k10, V v10) {
        c<K, V> c10 = c(k10);
        if (c10 != null) {
            return c10.f34660b;
        }
        h(k10, v10);
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f34655a, this.f34656b);
        this.f34657c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V j(K k10) {
        c<K, V> c10 = c(k10);
        if (c10 == null) {
            return null;
        }
        this.f34658d--;
        if (!this.f34657c.isEmpty()) {
            Iterator<f<K, V>> it = this.f34657c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(c10);
            }
        }
        c<K, V> cVar = c10.f34662d;
        if (cVar != null) {
            cVar.f34661c = c10.f34661c;
        } else {
            this.f34655a = c10.f34661c;
        }
        c<K, V> cVar2 = c10.f34661c;
        if (cVar2 != null) {
            cVar2.f34662d = cVar;
        } else {
            this.f34656b = cVar;
        }
        c10.f34661c = null;
        c10.f34662d = null;
        return c10.f34660b;
    }

    public int size() {
        return this.f34658d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
