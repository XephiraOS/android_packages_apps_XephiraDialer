package l3;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TranscoderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final List<a<?, ?>> f34683a = new ArrayList();

    /* compiled from: TranscoderRegistry.java */
    /* loaded from: classes.dex */
    public static final class a<Z, R> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<Z> f34684a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<R> f34685b;

        /* renamed from: c, reason: collision with root package name */
        public final e<Z, R> f34686c;

        public a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f34684a = cls;
            this.f34685b = cls2;
            this.f34686c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            if (this.f34684a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f34685b)) {
                return true;
            }
            return false;
        }
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f34683a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f34686c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f34683a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f34685b)) {
                arrayList.add(aVar.f34685b);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f34683a.add(new a<>(cls, cls2, eVar));
    }
}
