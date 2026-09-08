package F4;

import F4.k;
import com.google.gson.r;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes3.dex */
public final class n<T> extends r<T> {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.d f921a;

    /* renamed from: b, reason: collision with root package name */
    public final r<T> f922b;

    /* renamed from: c, reason: collision with root package name */
    public final Type f923c;

    public n(com.google.gson.d dVar, r<T> rVar, Type type) {
        this.f921a = dVar;
        this.f922b = rVar;
        this.f923c = type;
    }

    public static Type e(Type type, Object obj) {
        if (obj != null) {
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return obj.getClass();
            }
            return type;
        }
        return type;
    }

    public static boolean f(r<?> rVar) {
        r<?> e10;
        while ((rVar instanceof l) && (e10 = ((l) rVar).e()) != rVar) {
            rVar = e10;
        }
        return rVar instanceof k.b;
    }

    @Override // com.google.gson.r
    public T b(K4.a aVar) {
        return this.f922b.b(aVar);
    }

    @Override // com.google.gson.r
    public void d(K4.b bVar, T t10) {
        r<T> rVar = this.f922b;
        Type e10 = e(this.f923c, t10);
        if (e10 != this.f923c) {
            rVar = this.f921a.l(J4.a.get(e10));
            if ((rVar instanceof k.b) && !f(this.f922b)) {
                rVar = this.f922b;
            }
        }
        rVar.d(bVar, t10);
    }
}
