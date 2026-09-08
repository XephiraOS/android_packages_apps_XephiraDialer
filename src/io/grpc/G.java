package io.grpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/* compiled from: ServiceProviders.java */
/* loaded from: classes4.dex */
public final class G {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ServiceProviders.java */
    /* loaded from: classes4.dex */
    public class a<T> implements Comparator<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f32303a;

        public a(b bVar) {
            this.f32303a = bVar;
        }

        @Override // java.util.Comparator
        public int compare(T t10, T t11) {
            int b10 = this.f32303a.b(t10) - this.f32303a.b(t11);
            if (b10 != 0) {
                return b10;
            }
            return t10.getClass().getName().compareTo(t11.getClass().getName());
        }
    }

    /* compiled from: ServiceProviders.java */
    /* loaded from: classes4.dex */
    public interface b<T> {
        boolean a(T t10);

        int b(T t10);
    }

    public static <T> T a(Class<T> cls, Class<?> cls2) {
        try {
            return (T) cls2.asSubclass(cls).getConstructor(null).newInstance(null);
        } catch (ClassCastException unused) {
            return null;
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", cls2.getName(), th), th);
        }
    }

    public static boolean b(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T> List<T> c(Class<T> cls, Iterable<Class<?>> iterable, ClassLoader classLoader, b<T> bVar) {
        Iterable candidatesViaServiceLoader;
        if (b(classLoader)) {
            candidatesViaServiceLoader = getCandidatesViaHardCoded(cls, iterable);
        } else {
            candidatesViaServiceLoader = getCandidatesViaServiceLoader(cls, classLoader);
        }
        ArrayList arrayList = new ArrayList();
        for (T t10 : candidatesViaServiceLoader) {
            if (bVar.a(t10)) {
                arrayList.add(t10);
            }
        }
        Collections.sort(arrayList, Collections.reverseOrder(new a(bVar)));
        return Collections.unmodifiableList(arrayList);
    }

    public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> cls, Iterable<Class<?>> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> it = iterable.iterator();
        while (it.hasNext()) {
            Object a10 = a(cls, it.next());
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader load = ServiceLoader.load(cls, classLoader);
        if (!load.iterator().hasNext()) {
            return ServiceLoader.load(cls);
        }
        return load;
    }
}
