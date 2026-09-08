package io.grpc;

import io.grpc.G;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ServerRegistry.java */
/* loaded from: classes4.dex */
public final class F {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f32298c = Logger.getLogger(F.class.getName());

    /* renamed from: d, reason: collision with root package name */
    public static F f32299d;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<E> f32300a = new LinkedHashSet<>();

    /* renamed from: b, reason: collision with root package name */
    public List<E> f32301b = Collections.emptyList();

    /* compiled from: ServerRegistry.java */
    /* loaded from: classes4.dex */
    public class a implements Comparator<E> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(E e10, E e11) {
            return e10.c() - e11.c();
        }
    }

    /* compiled from: ServerRegistry.java */
    /* loaded from: classes4.dex */
    public static final class b implements G.b<E> {
        public b() {
        }

        @Override // io.grpc.G.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(E e10) {
            return e10.c();
        }

        @Override // io.grpc.G.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(E e10) {
            return e10.b();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static synchronized F b() {
        F f10;
        synchronized (F.class) {
            try {
                if (f32299d == null) {
                    List<E> c10 = G.c(E.class, getHardCodedClasses(), E.class.getClassLoader(), new b(null));
                    f32299d = new F();
                    for (E e10 : c10) {
                        f32298c.fine("Service loader found " + e10);
                        f32299d.a(e10);
                    }
                    f32299d.d();
                }
                f10 = f32299d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return f10;
    }

    public static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.okhttp.OkHttpServerProvider"));
        } catch (ClassNotFoundException e10) {
            f32298c.log(Level.FINE, "Unable to find OkHttpServerProvider", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(E e10) {
        com.google.common.base.k.e(e10.b(), "isAvailable() returned false");
        this.f32300a.add(e10);
    }

    public E c() {
        List<E> providers = providers();
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    public final synchronized void d() {
        ArrayList arrayList = new ArrayList(this.f32300a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f32301b = Collections.unmodifiableList(arrayList);
    }

    public synchronized List<E> providers() {
        return this.f32301b;
    }
}
