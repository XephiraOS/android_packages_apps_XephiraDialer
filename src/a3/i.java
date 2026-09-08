package a3;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import s3.C1540k;

/* compiled from: LruArrayPool.java */
/* loaded from: classes.dex */
public final class i implements a3.b {

    /* renamed from: a, reason: collision with root package name */
    public final g<a, Object> f6363a = new g<>();

    /* renamed from: b, reason: collision with root package name */
    public final b f6364b = new b();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f6365c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, InterfaceC0420a<?>> f6366d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final int f6367e;

    /* renamed from: f, reason: collision with root package name */
    public int f6368f;

    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    public static final class a implements l {

        /* renamed from: a, reason: collision with root package name */
        public final b f6369a;

        /* renamed from: b, reason: collision with root package name */
        public int f6370b;

        /* renamed from: c, reason: collision with root package name */
        public Class<?> f6371c;

        public a(b bVar) {
            this.f6369a = bVar;
        }

        @Override // a3.l
        public void a() {
            this.f6369a.c(this);
        }

        public void b(int i10, Class<?> cls) {
            this.f6370b = i10;
            this.f6371c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f6370b != aVar.f6370b || this.f6371c != aVar.f6371c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i10;
            int i11 = this.f6370b * 31;
            Class<?> cls = this.f6371c;
            if (cls != null) {
                i10 = cls.hashCode();
            } else {
                i10 = 0;
            }
            return i11 + i10;
        }

        public String toString() {
            return "Key{size=" + this.f6370b + "array=" + this.f6371c + '}';
        }
    }

    /* compiled from: LruArrayPool.java */
    /* loaded from: classes.dex */
    public static final class b extends c<a> {
        @Override // a3.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i10, Class<?> cls) {
            a b10 = b();
            b10.b(i10, cls);
            return b10;
        }
    }

    public i(int i10) {
        this.f6367e = i10;
    }

    @Override // a3.b
    public synchronized void a(int i10) {
        try {
            if (i10 >= 40) {
                b();
            } else if (i10 >= 20 || i10 == 15) {
                h(this.f6367e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // a3.b
    public synchronized void b() {
        h(0);
    }

    @Override // a3.b
    public synchronized <T> T c(int i10, Class<T> cls) {
        return (T) l(this.f6364b.e(i10, cls), cls);
    }

    @Override // a3.b
    public synchronized <T> void d(T t10) {
        Class<?> cls = t10.getClass();
        InterfaceC0420a<T> j10 = j(cls);
        int b10 = j10.b(t10);
        int a10 = j10.a() * b10;
        if (!o(a10)) {
            return;
        }
        a e10 = this.f6364b.e(b10, cls);
        this.f6363a.d(e10, t10);
        NavigableMap<Integer, Integer> m10 = m(cls);
        Integer num = m10.get(Integer.valueOf(e10.f6370b));
        Integer valueOf = Integer.valueOf(e10.f6370b);
        int i10 = 1;
        if (num != null) {
            i10 = 1 + num.intValue();
        }
        m10.put(valueOf, Integer.valueOf(i10));
        this.f6368f += a10;
        g();
    }

    @Override // a3.b
    public synchronized <T> T e(int i10, Class<T> cls) {
        a e10;
        try {
            Integer ceilingKey = m(cls).ceilingKey(Integer.valueOf(i10));
            if (p(i10, ceilingKey)) {
                e10 = this.f6364b.e(ceilingKey.intValue(), cls);
            } else {
                e10 = this.f6364b.e(i10, cls);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (T) l(e10, cls);
    }

    public final void f(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> m10 = m(cls);
        Integer num = m10.get(Integer.valueOf(i10));
        if (num != null) {
            if (num.intValue() == 1) {
                m10.remove(Integer.valueOf(i10));
                return;
            } else {
                m10.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
    }

    public final void g() {
        h(this.f6367e);
    }

    public final void h(int i10) {
        while (this.f6368f > i10) {
            Object f10 = this.f6363a.f();
            C1540k.d(f10);
            InterfaceC0420a i11 = i(f10);
            this.f6368f -= i11.b(f10) * i11.a();
            f(i11.b(f10), f10.getClass());
            if (Log.isLoggable(i11.getTag(), 2)) {
                Log.v(i11.getTag(), "evicted: " + i11.b(f10));
            }
        }
    }

    public final <T> InterfaceC0420a<T> i(T t10) {
        return j(t10.getClass());
    }

    public final <T> InterfaceC0420a<T> j(Class<T> cls) {
        InterfaceC0420a<T> interfaceC0420a = (InterfaceC0420a) this.f6366d.get(cls);
        if (interfaceC0420a == null) {
            if (cls.equals(int[].class)) {
                interfaceC0420a = new h();
            } else if (cls.equals(byte[].class)) {
                interfaceC0420a = new f();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f6366d.put(cls, interfaceC0420a);
        }
        return interfaceC0420a;
    }

    public final <T> T k(a aVar) {
        return (T) this.f6363a.a(aVar);
    }

    public final <T> T l(a aVar, Class<T> cls) {
        InterfaceC0420a<T> j10 = j(cls);
        T t10 = (T) k(aVar);
        if (t10 != null) {
            this.f6368f -= j10.b(t10) * j10.a();
            f(j10.b(t10), cls);
        }
        if (t10 == null) {
            if (Log.isLoggable(j10.getTag(), 2)) {
                Log.v(j10.getTag(), "Allocated " + aVar.f6370b + " bytes");
            }
            return j10.newArray(aVar.f6370b);
        }
        return t10;
    }

    public final NavigableMap<Integer, Integer> m(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f6365c.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f6365c.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    public final boolean n() {
        int i10 = this.f6368f;
        if (i10 != 0 && this.f6367e / i10 < 2) {
            return false;
        }
        return true;
    }

    public final boolean o(int i10) {
        if (i10 <= this.f6367e / 2) {
            return true;
        }
        return false;
    }

    public final boolean p(int i10, Integer num) {
        if (num != null && (n() || num.intValue() <= i10 * 8)) {
            return true;
        }
        return false;
    }
}
