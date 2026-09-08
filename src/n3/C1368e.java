package n3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry.java */
/* renamed from: n3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1368e {

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f35616a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, List<a<?, ?>>> f35617b = new HashMap();

    /* compiled from: ResourceDecoderRegistry.java */
    /* renamed from: n3.e$a */
    /* loaded from: classes.dex */
    public static class a<T, R> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f35618a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<R> f35619b;

        /* renamed from: c, reason: collision with root package name */
        public final X2.e<T, R> f35620c;

        public a(Class<T> cls, Class<R> cls2, X2.e<T, R> eVar) {
            this.f35618a = cls;
            this.f35619b = cls2;
            this.f35620c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            if (this.f35618a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f35619b)) {
                return true;
            }
            return false;
        }
    }

    public synchronized <T, R> void a(String str, X2.e<T, R> eVar, Class<T> cls, Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, eVar));
    }

    public synchronized <T, R> List<X2.e<T, R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f35616a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f35617b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f35620c);
                    }
                }
            }
        }
        return arrayList;
    }

    public final synchronized List<a<?, ?>> c(String str) {
        List<a<?, ?>> list;
        try {
            if (!this.f35616a.contains(str)) {
                this.f35616a.add(str);
            }
            list = this.f35617b.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f35617b.put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public synchronized <T, R> List<Class<R>> d(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it = this.f35616a.iterator();
        while (it.hasNext()) {
            List<a<?, ?>> list = this.f35617b.get(it.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f35619b)) {
                        arrayList.add(aVar.f35619b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(List<String> list) {
        try {
            ArrayList<String> arrayList = new ArrayList(this.f35616a);
            this.f35616a.clear();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.f35616a.add(it.next());
            }
            for (String str : arrayList) {
                if (!list.contains(str)) {
                    this.f35616a.add(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
