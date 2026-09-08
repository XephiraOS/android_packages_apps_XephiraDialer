package n3;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ResourceEncoderRegistry.java */
/* renamed from: n3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1369f {

    /* renamed from: a, reason: collision with root package name */
    public final List<a<?>> f35621a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry.java */
    /* renamed from: n3.f$a */
    /* loaded from: classes.dex */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f35622a;

        /* renamed from: b, reason: collision with root package name */
        public final X2.f<T> f35623b;

        public a(Class<T> cls, X2.f<T> fVar) {
            this.f35622a = cls;
            this.f35623b = fVar;
        }

        public boolean a(Class<?> cls) {
            return this.f35622a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, X2.f<Z> fVar) {
        this.f35621a.add(new a<>(cls, fVar));
    }

    public synchronized <Z> X2.f<Z> b(Class<Z> cls) {
        int size = this.f35621a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a<?> aVar = this.f35621a.get(i10);
            if (aVar.a(cls)) {
                return (X2.f<Z>) aVar.f35623b;
            }
        }
        return null;
    }
}
