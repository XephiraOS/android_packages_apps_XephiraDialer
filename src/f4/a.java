package F4;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: ArrayTypeAdapter.java */
/* loaded from: classes3.dex */
public final class a<E> extends r<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final s f847c = new C0015a();

    /* renamed from: a, reason: collision with root package name */
    public final Class<E> f848a;

    /* renamed from: b, reason: collision with root package name */
    public final r<E> f849b;

    /* compiled from: ArrayTypeAdapter.java */
    /* renamed from: F4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0015a implements s {
        @Override // com.google.gson.s
        public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type g10 = C$Gson$Types.g(type);
            return new a(dVar, dVar.l(J4.a.get(g10)), C$Gson$Types.k(g10));
        }
    }

    public a(com.google.gson.d dVar, r<E> rVar, Class<E> cls) {
        this.f849b = new n(dVar, rVar, cls);
        this.f848a = cls;
    }

    @Override // com.google.gson.r
    public Object b(K4.a aVar) {
        if (aVar.f0() == JsonToken.NULL) {
            aVar.X();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.y()) {
            arrayList.add(this.f849b.b(aVar));
        }
        aVar.l();
        int size = arrayList.size();
        if (this.f848a.isPrimitive()) {
            Object newInstance = Array.newInstance((Class<?>) this.f848a, size);
            for (int i10 = 0; i10 < size; i10++) {
                Array.set(newInstance, i10, arrayList.get(i10));
            }
            return newInstance;
        }
        return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.f848a, size));
    }

    @Override // com.google.gson.r
    public void d(K4.b bVar, Object obj) {
        if (obj == null) {
            bVar.I();
            return;
        }
        bVar.e();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f849b.d(bVar, Array.get(obj, i10));
        }
        bVar.l();
    }
}
