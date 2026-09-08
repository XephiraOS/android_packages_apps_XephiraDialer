package com.oplus.utils;

import android.util.LruCache;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ExpirableCache.java */
/* renamed from: com.oplus.utils.v, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0860v<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f29189a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public LruCache<K, a<V>> f29190b;

    /* compiled from: ExpirableCache.java */
    /* renamed from: com.oplus.utils.v$a */
    /* loaded from: classes3.dex */
    public interface a<V> {
        boolean a();

        V getValue();
    }

    /* compiled from: ExpirableCache.java */
    /* renamed from: com.oplus.utils.v$b */
    /* loaded from: classes3.dex */
    public static class b<V> implements a<V> {

        /* renamed from: a, reason: collision with root package name */
        public final V f29191a;

        /* renamed from: b, reason: collision with root package name */
        public final int f29192b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicInteger f29193c;

        public b(V v10, AtomicInteger atomicInteger) {
            this.f29191a = v10;
            this.f29193c = atomicInteger;
            this.f29192b = atomicInteger.get();
        }

        @Override // com.oplus.utils.C0860v.a
        public boolean a() {
            if (this.f29192b != this.f29193c.get()) {
                return true;
            }
            return false;
        }

        @Override // com.oplus.utils.C0860v.a
        public V getValue() {
            return this.f29191a;
        }
    }

    public C0860v(LruCache<K, a<V>> lruCache) {
        this.f29190b = lruCache;
    }

    public static <K, V> C0860v<K, V> a(int i10) {
        return b(new LruCache(i10));
    }

    public static <K, V> C0860v<K, V> b(LruCache<K, a<V>> lruCache) {
        return new C0860v<>(lruCache);
    }

    public void c() {
        this.f29189a.incrementAndGet();
    }

    public a<V> d(K k10) {
        if (k10 == null) {
            return null;
        }
        return this.f29190b.get(k10);
    }

    public V e(K k10) {
        a<V> d10 = d(k10);
        if (d10 == null) {
            return null;
        }
        return d10.getValue();
    }

    public a<V> f(V v10) {
        return new b(v10, this.f29189a);
    }

    public void g(K k10, V v10) {
        this.f29190b.put(k10, f(v10));
    }
}
