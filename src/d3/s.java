package d3;

import com.bumptech.glide.Registry;
import d3.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import s3.C1540k;

/* compiled from: MultiModelLoaderFactory.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: e, reason: collision with root package name */
    public static final c f30006e = new c();

    /* renamed from: f, reason: collision with root package name */
    public static final o<Object, Object> f30007f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<b<?, ?>> f30008a;

    /* renamed from: b, reason: collision with root package name */
    public final c f30009b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<b<?, ?>> f30010c;

    /* renamed from: d, reason: collision with root package name */
    public final I.e<List<Throwable>> f30011d;

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    public static class a implements o<Object, Object> {
        @Override // d3.o
        public boolean a(Object obj) {
            return false;
        }

        @Override // d3.o
        public o.a<Object> b(Object obj, int i10, int i11, X2.d dVar) {
            return null;
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    public static class b<Model, Data> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<Model> f30012a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<Data> f30013b;

        /* renamed from: c, reason: collision with root package name */
        public final p<? extends Model, ? extends Data> f30014c;

        public b(Class<Model> cls, Class<Data> cls2, p<? extends Model, ? extends Data> pVar) {
            this.f30012a = cls;
            this.f30013b = cls2;
            this.f30014c = pVar;
        }

        public boolean a(Class<?> cls) {
            return this.f30012a.isAssignableFrom(cls);
        }

        public boolean b(Class<?> cls, Class<?> cls2) {
            if (a(cls) && this.f30013b.isAssignableFrom(cls2)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: MultiModelLoaderFactory.java */
    /* loaded from: classes.dex */
    public static class c {
        public <Model, Data> r<Model, Data> a(List<o<Model, Data>> list, I.e<List<Throwable>> eVar) {
            return new r<>(list, eVar);
        }
    }

    public s(I.e<List<Throwable>> eVar) {
        this(eVar, f30006e);
    }

    public static <Model, Data> o<Model, Data> f() {
        return (o<Model, Data>) f30007f;
    }

    public final <Model, Data> void a(Class<Model> cls, Class<Data> cls2, p<? extends Model, ? extends Data> pVar, boolean z10) {
        int i10;
        b<?, ?> bVar = new b<>(cls, cls2, pVar);
        List<b<?, ?>> list = this.f30008a;
        if (z10) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        list.add(i10, bVar);
    }

    public synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, p<? extends Model, ? extends Data> pVar) {
        a(cls, cls2, pVar, true);
    }

    public final <Model, Data> o<Model, Data> c(b<?, ?> bVar) {
        return (o) C1540k.d(bVar.f30014c.d(this));
    }

    public synchronized <Model, Data> o<Model, Data> d(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b<?, ?> bVar : this.f30008a) {
                if (this.f30010c.contains(bVar)) {
                    z10 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f30010c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f30010c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f30009b.a(arrayList, this.f30011d);
            }
            if (arrayList.size() == 1) {
                return (o) arrayList.get(0);
            }
            if (z10) {
                return f();
            }
            throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.f30010c.clear();
            throw th;
        }
    }

    public synchronized <Model> List<o<Model, ?>> e(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f30008a) {
                if (!this.f30010c.contains(bVar) && bVar.a(cls)) {
                    this.f30010c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f30010c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f30010c.clear();
            throw th;
        }
        return arrayList;
    }

    public synchronized List<Class<?>> g(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f30008a) {
            if (!arrayList.contains(bVar.f30013b) && bVar.a(cls)) {
                arrayList.add(bVar.f30013b);
            }
        }
        return arrayList;
    }

    public s(I.e<List<Throwable>> eVar, c cVar) {
        this.f30008a = new ArrayList();
        this.f30010c = new HashSet();
        this.f30011d = eVar;
        this.f30009b = cVar;
    }
}
