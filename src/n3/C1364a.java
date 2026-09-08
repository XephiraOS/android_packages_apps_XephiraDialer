package n3;

import java.util.ArrayList;
import java.util.List;

/* compiled from: EncoderRegistry.java */
/* renamed from: n3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1364a {

    /* renamed from: a, reason: collision with root package name */
    public final List<C0335a<?>> f35607a = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: n3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0335a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f35608a;

        /* renamed from: b, reason: collision with root package name */
        public final X2.a<T> f35609b;

        public C0335a(Class<T> cls, X2.a<T> aVar) {
            this.f35608a = cls;
            this.f35609b = aVar;
        }

        public boolean a(Class<?> cls) {
            return this.f35608a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, X2.a<T> aVar) {
        this.f35607a.add(new C0335a<>(cls, aVar));
    }

    public synchronized <T> X2.a<T> b(Class<T> cls) {
        for (C0335a<?> c0335a : this.f35607a) {
            if (c0335a.a(cls)) {
                return (X2.a<T>) c0335a.f35609b;
            }
        }
        return null;
    }
}
