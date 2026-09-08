package p;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import m9.q;
import q.C1475b;

/* compiled from: LruCache.kt */
/* renamed from: p.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1422h<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final C1475b lock;
    private final q.c<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public C1422h(int i10) {
        this.maxSize = i10;
        if (i10 > 0) {
            this.map = new q.c<>(0, 0.75f);
            this.lock = new C1475b();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    private final int safeSizeOf(K k10, V v10) {
        int sizeOf = sizeOf(k10, v10);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException(("Negative size: " + k10 + '=' + v10).toString());
    }

    public V create(K key) {
        kotlin.jvm.internal.i.f(key, "key");
        return null;
    }

    public final int createCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.createCount;
        }
        return i10;
    }

    public void entryRemoved(boolean z10, K key, V oldValue, V v10) {
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(oldValue, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.evictionCount;
        }
        return i10;
    }

    public final V get(K key) {
        V v10;
        kotlin.jvm.internal.i.f(key, "key");
        synchronized (this.lock) {
            V a10 = this.map.a(key);
            if (a10 != null) {
                this.hitCount++;
                return a10;
            }
            this.missCount++;
            V create = create(key);
            if (create == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    v10 = (V) this.map.d(key, create);
                    if (v10 != null) {
                        this.map.d(key, v10);
                    } else {
                        this.size += safeSizeOf(key, create);
                        q qVar = q.f35511a;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v10 != null) {
                entryRemoved(false, key, create, v10);
                return v10;
            }
            trimToSize(this.maxSize);
            return create;
        }
    }

    public final int hitCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.hitCount;
        }
        return i10;
    }

    public final int maxSize() {
        int i10;
        synchronized (this.lock) {
            i10 = this.maxSize;
        }
        return i10;
    }

    public final int missCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.missCount;
        }
        return i10;
    }

    public final V put(K key, V value) {
        V d10;
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(value, "value");
        synchronized (this.lock) {
            try {
                this.putCount++;
                this.size += safeSizeOf(key, value);
                d10 = this.map.d(key, value);
                if (d10 != null) {
                    this.size -= safeSizeOf(key, d10);
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (d10 != null) {
            entryRemoved(false, key, d10, value);
        }
        trimToSize(this.maxSize);
        return d10;
    }

    public final int putCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.putCount;
        }
        return i10;
    }

    public final V remove(K key) {
        V e10;
        kotlin.jvm.internal.i.f(key, "key");
        synchronized (this.lock) {
            try {
                e10 = this.map.e(key);
                if (e10 != null) {
                    this.size -= safeSizeOf(key, e10);
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (e10 != null) {
            entryRemoved(false, key, e10, null);
        }
        return e10;
    }

    public void resize(int i10) {
        if (i10 > 0) {
            synchronized (this.lock) {
                this.maxSize = i10;
                q qVar = q.f35511a;
            }
            trimToSize(i10);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public final int size() {
        int i10;
        synchronized (this.lock) {
            i10 = this.size;
        }
        return i10;
    }

    public int sizeOf(K key, V value) {
        kotlin.jvm.internal.i.f(key, "key");
        kotlin.jvm.internal.i.f(value, "value");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.lock) {
            try {
                Iterator<T> it = this.map.b().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        int i10;
        String str;
        synchronized (this.lock) {
            try {
                int i11 = this.hitCount;
                int i12 = this.missCount + i11;
                if (i12 != 0) {
                    i10 = (i11 * 100) / i12;
                } else {
                    i10 = 0;
                }
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + i10 + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!".toString());
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trimToSize(int r6) {
        /*
            r5 = this;
        L0:
            q.b r0 = r5.lock
            monitor-enter(r0)
            int r1 = r5.size     // Catch: java.lang.Throwable -> L14
            if (r1 < 0) goto L57
            q.c<K, V> r1 = r5.map     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L16
            int r1 = r5.size     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L57
            goto L16
        L14:
            r5 = move-exception
            goto L63
        L16:
            int r1 = r5.size     // Catch: java.lang.Throwable -> L14
            if (r1 <= r6) goto L55
            q.c<K, V> r1 = r5.map     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L23
            goto L55
        L23:
            q.c<K, V> r1 = r5.map     // Catch: java.lang.Throwable -> L14
            java.util.Set r1 = r1.b()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = kotlin.collections.m.w(r1)     // Catch: java.lang.Throwable -> L14
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L33
            monitor-exit(r0)
            return
        L33:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L14
            q.c<K, V> r3 = r5.map     // Catch: java.lang.Throwable -> L14
            r3.e(r2)     // Catch: java.lang.Throwable -> L14
            int r3 = r5.size     // Catch: java.lang.Throwable -> L14
            int r4 = r5.safeSizeOf(r2, r1)     // Catch: java.lang.Throwable -> L14
            int r3 = r3 - r4
            r5.size = r3     // Catch: java.lang.Throwable -> L14
            int r3 = r5.evictionCount     // Catch: java.lang.Throwable -> L14
            r4 = 1
            int r3 = r3 + r4
            r5.evictionCount = r3     // Catch: java.lang.Throwable -> L14
            monitor-exit(r0)
            r0 = 0
            r5.entryRemoved(r4, r2, r1, r0)
            goto L0
        L55:
            monitor-exit(r0)
            return
        L57:
            java.lang.String r5 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L14
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L14
            throw r6     // Catch: java.lang.Throwable -> L14
        L63:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p.C1422h.trimToSize(int):void");
    }
}
