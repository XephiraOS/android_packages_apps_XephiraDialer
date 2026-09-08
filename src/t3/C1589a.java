package t3;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FactoryPools.java */
/* renamed from: t3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1589a {

    /* renamed from: a, reason: collision with root package name */
    public static final g<Object> f37177a = new C0363a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* renamed from: t3.a$b */
    /* loaded from: classes.dex */
    public class b<T> implements d<List<T>> {
        @Override // t3.C1589a.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FactoryPools.java */
    /* renamed from: t3.a$c */
    /* loaded from: classes.dex */
    public class c<T> implements g<List<T>> {
        @Override // t3.C1589a.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List<T> list) {
            list.clear();
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: t3.a$d */
    /* loaded from: classes.dex */
    public interface d<T> {
        T create();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: t3.a$e */
    /* loaded from: classes.dex */
    public static final class e<T> implements I.e<T> {

        /* renamed from: a, reason: collision with root package name */
        public final d<T> f37178a;

        /* renamed from: b, reason: collision with root package name */
        public final g<T> f37179b;

        /* renamed from: c, reason: collision with root package name */
        public final I.e<T> f37180c;

        public e(I.e<T> eVar, d<T> dVar, g<T> gVar) {
            this.f37180c = eVar;
            this.f37178a = dVar;
            this.f37179b = gVar;
        }

        @Override // I.e
        public boolean a(T t10) {
            if (t10 instanceof f) {
                ((f) t10).e().b(true);
            }
            this.f37179b.a(t10);
            return this.f37180c.a(t10);
        }

        @Override // I.e
        public T b() {
            T b10 = this.f37180c.b();
            if (b10 == null) {
                b10 = this.f37178a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + b10.getClass());
                }
            }
            if (b10 instanceof f) {
                b10.e().b(false);
            }
            return (T) b10;
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: t3.a$f */
    /* loaded from: classes.dex */
    public interface f {
        t3.c e();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: t3.a$g */
    /* loaded from: classes.dex */
    public interface g<T> {
        void a(T t10);
    }

    public static <T extends f> I.e<T> a(I.e<T> eVar, d<T> dVar) {
        return b(eVar, dVar, c());
    }

    public static <T> I.e<T> b(I.e<T> eVar, d<T> dVar, g<T> gVar) {
        return new e(eVar, dVar, gVar);
    }

    public static <T> g<T> c() {
        return (g<T>) f37177a;
    }

    public static <T extends f> I.e<T> d(int i10, d<T> dVar) {
        return a(new I.g(i10), dVar);
    }

    public static <T> I.e<List<T>> e() {
        return f(20);
    }

    public static <T> I.e<List<T>> f(int i10) {
        return b(new I.g(i10), new b(), new c());
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: t3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0363a implements g<Object> {
        @Override // t3.C1589a.g
        public void a(Object obj) {
        }
    }
}
