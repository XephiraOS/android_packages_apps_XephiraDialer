package a3;

import a3.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GroupedLinkedMap.java */
/* loaded from: classes.dex */
public class g<K extends l, V> {

    /* renamed from: a, reason: collision with root package name */
    public final a<K, V> f6357a = new a<>();

    /* renamed from: b, reason: collision with root package name */
    public final Map<K, a<K, V>> f6358b = new HashMap();

    /* compiled from: GroupedLinkedMap.java */
    /* loaded from: classes.dex */
    public static class a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final K f6359a;

        /* renamed from: b, reason: collision with root package name */
        public List<V> f6360b;

        /* renamed from: c, reason: collision with root package name */
        public a<K, V> f6361c;

        /* renamed from: d, reason: collision with root package name */
        public a<K, V> f6362d;

        public a() {
            this(null);
        }

        public void a(V v10) {
            if (this.f6360b == null) {
                this.f6360b = new ArrayList();
            }
            this.f6360b.add(v10);
        }

        public V b() {
            int c10 = c();
            if (c10 > 0) {
                return this.f6360b.remove(c10 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f6360b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k10) {
            this.f6362d = this;
            this.f6361c = this;
            this.f6359a = k10;
        }
    }

    public static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f6362d;
        aVar2.f6361c = aVar.f6361c;
        aVar.f6361c.f6362d = aVar2;
    }

    public static <K, V> void g(a<K, V> aVar) {
        aVar.f6361c.f6362d = aVar;
        aVar.f6362d.f6361c = aVar;
    }

    public V a(K k10) {
        a<K, V> aVar = this.f6358b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            this.f6358b.put(k10, aVar);
        } else {
            k10.a();
        }
        b(aVar);
        return aVar.b();
    }

    public final void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f6357a;
        aVar.f6362d = aVar2;
        aVar.f6361c = aVar2.f6361c;
        g(aVar);
    }

    public final void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.f6357a;
        aVar.f6362d = aVar2.f6362d;
        aVar.f6361c = aVar2;
        g(aVar);
    }

    public void d(K k10, V v10) {
        a<K, V> aVar = this.f6358b.get(k10);
        if (aVar == null) {
            aVar = new a<>(k10);
            c(aVar);
            this.f6358b.put(k10, aVar);
        } else {
            k10.a();
        }
        aVar.a(v10);
    }

    public V f() {
        for (a aVar = this.f6357a.f6362d; !aVar.equals(this.f6357a); aVar = aVar.f6362d) {
            V v10 = (V) aVar.b();
            if (v10 != null) {
                return v10;
            }
            e(aVar);
            this.f6358b.remove(aVar.f6359a);
            ((l) aVar.f6359a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f6357a.f6361c;
        boolean z10 = false;
        while (!aVar.equals(this.f6357a)) {
            sb.append('{');
            sb.append(aVar.f6359a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
            aVar = aVar.f6361c;
            z10 = true;
        }
        if (z10) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
