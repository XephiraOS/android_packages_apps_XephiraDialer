package s3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* renamed from: s3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1537h<T, Y> {

    /* renamed from: a, reason: collision with root package name */
    public final Map<T, a<Y>> f36765a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    public final long f36766b;

    /* renamed from: c, reason: collision with root package name */
    public long f36767c;

    /* renamed from: d, reason: collision with root package name */
    public long f36768d;

    /* compiled from: LruCache.java */
    /* renamed from: s3.h$a */
    /* loaded from: classes.dex */
    public static final class a<Y> {

        /* renamed from: a, reason: collision with root package name */
        public final Y f36769a;

        /* renamed from: b, reason: collision with root package name */
        public final int f36770b;

        public a(Y y10, int i10) {
            this.f36769a = y10;
            this.f36770b = i10;
        }
    }

    public C1537h(long j10) {
        this.f36766b = j10;
        this.f36767c = j10;
    }

    public void b() {
        m(0L);
    }

    public final void f() {
        m(this.f36767c);
    }

    public synchronized Y g(T t10) {
        Y y10;
        a<Y> aVar = this.f36765a.get(t10);
        if (aVar != null) {
            y10 = aVar.f36769a;
        } else {
            y10 = null;
        }
        return y10;
    }

    public synchronized long h() {
        return this.f36767c;
    }

    public int i(Y y10) {
        return 1;
    }

    public synchronized Y k(T t10, Y y10) {
        a<Y> aVar;
        int i10 = i(y10);
        long j10 = i10;
        Y y11 = null;
        if (j10 >= this.f36767c) {
            j(t10, y10);
            return null;
        }
        if (y10 != null) {
            this.f36768d += j10;
        }
        Map<T, a<Y>> map = this.f36765a;
        if (y10 == null) {
            aVar = null;
        } else {
            aVar = new a<>(y10, i10);
        }
        a<Y> put = map.put(t10, aVar);
        if (put != null) {
            this.f36768d -= put.f36770b;
            if (!put.f36769a.equals(y10)) {
                j(t10, put.f36769a);
            }
        }
        f();
        if (put != null) {
            y11 = put.f36769a;
        }
        return y11;
    }

    public synchronized Y l(T t10) {
        a<Y> remove = this.f36765a.remove(t10);
        if (remove == null) {
            return null;
        }
        this.f36768d -= remove.f36770b;
        return remove.f36769a;
    }

    public synchronized void m(long j10) {
        while (this.f36768d > j10) {
            Iterator<Map.Entry<T, a<Y>>> it = this.f36765a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.f36768d -= value.f36770b;
            T key = next.getKey();
            it.remove();
            j(key, value.f36769a);
        }
    }

    public void j(T t10, Y y10) {
    }
}
