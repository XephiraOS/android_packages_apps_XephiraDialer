package C7;

import android.util.LruCache;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ExpirableCache.java */
/* loaded from: classes3.dex */
public class d<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f402a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public LruCache<K, a<V>> f403b;

    /* compiled from: ExpirableCache.java */
    /* loaded from: classes3.dex */
    public interface a<V> {
        boolean a();

        V getValue();
    }

    /* compiled from: ExpirableCache.java */
    /* loaded from: classes3.dex */
    public static class b<V> implements a<V> {

        /* renamed from: a, reason: collision with root package name */
        public final V f404a;

        /* renamed from: b, reason: collision with root package name */
        public final int f405b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicInteger f406c;

        public b(V v10, AtomicInteger atomicInteger) {
            this.f404a = v10;
            this.f406c = atomicInteger;
            this.f405b = atomicInteger.get();
        }

        @Override // C7.d.a
        public boolean a() {
            if (this.f405b != this.f406c.get()) {
                return true;
            }
            return false;
        }

        @Override // C7.d.a
        public V getValue() {
            return this.f404a;
        }
    }

    public d(LruCache<K, a<V>> lruCache) {
        this.f403b = lruCache;
    }

    public static <K, V> d<K, V> c(int i10) {
        return d(new LruCache(i10));
    }

    public static <K, V> d<K, V> d(LruCache<K, a<V>> lruCache) {
        return new d<>(lruCache);
    }

    public void a() {
        LruCache<K, a<V>> lruCache = this.f403b;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    public void b(K k10) {
        LruCache<K, a<V>> lruCache;
        if (k10 != null && (lruCache = this.f403b) != null) {
            lruCache.remove(k10);
        }
    }

    public void e() {
        this.f402a.incrementAndGet();
    }

    public a<V> f(K k10) {
        if (k10 == null) {
            return null;
        }
        return this.f403b.get(k10);
    }

    public V g(K k10) {
        a<V> f10 = f(k10);
        if (f10 == null) {
            return null;
        }
        return f10.getValue();
    }

    public V get(K k10) {
        a<V> f10 = f(k10);
        if (f10 != null && !f10.a()) {
            return f10.getValue();
        }
        return null;
    }

    public a<V> h(V v10) {
        return new b(v10, this.f402a);
    }

    public void i(K k10, V v10) {
        this.f403b.put(k10, h(v10));
    }
}
