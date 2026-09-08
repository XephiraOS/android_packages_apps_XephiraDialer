package d3;

import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public final s f29993a;

    /* renamed from: b, reason: collision with root package name */
    public final a f29994b;

    /* compiled from: ModelLoaderRegistry.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, C0292a<?>> f29995a = new HashMap();

        /* compiled from: ModelLoaderRegistry.java */
        /* renamed from: d3.q$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0292a<Model> {

            /* renamed from: a, reason: collision with root package name */
            public final List<o<Model, ?>> f29996a;

            public C0292a(List<o<Model, ?>> list) {
                this.f29996a = list;
            }
        }

        public void a() {
            this.f29995a.clear();
        }

        public <Model> List<o<Model, ?>> b(Class<Model> cls) {
            C0292a<?> c0292a = this.f29995a.get(cls);
            if (c0292a == null) {
                return null;
            }
            return (List<o<Model, ?>>) c0292a.f29996a;
        }

        public <Model> void c(Class<Model> cls, List<o<Model, ?>> list) {
            if (this.f29995a.put(cls, new C0292a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public q(I.e<List<Throwable>> eVar) {
        this(new s(eVar));
    }

    public static <A> Class<A> b(A a10) {
        return (Class<A>) a10.getClass();
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, p<? extends Model, ? extends Data> pVar) {
        this.f29993a.b(cls, cls2, pVar);
        this.f29994b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.f29993a.g(cls);
    }

    public <A> List<o<A, ?>> d(A a10) {
        List<o<A, ?>> e10 = e(b(a10));
        if (!e10.isEmpty()) {
            int size = e10.size();
            List<o<A, ?>> emptyList = Collections.emptyList();
            boolean z10 = true;
            for (int i10 = 0; i10 < size; i10++) {
                o<A, ?> oVar = e10.get(i10);
                if (oVar.a(a10)) {
                    if (z10) {
                        emptyList = new ArrayList<>(size - i10);
                        z10 = false;
                    }
                    emptyList.add(oVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a10, e10);
        }
        throw new Registry.NoModelLoaderAvailableException(a10);
    }

    public final synchronized <A> List<o<A, ?>> e(Class<A> cls) {
        List<o<A, ?>> b10;
        b10 = this.f29994b.b(cls);
        if (b10 == null) {
            b10 = Collections.unmodifiableList(this.f29993a.e(cls));
            this.f29994b.c(cls, b10);
        }
        return b10;
    }

    public q(s sVar) {
        this.f29994b = new a();
        this.f29993a = sVar;
    }
}
