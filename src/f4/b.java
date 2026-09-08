package F4;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionTypeAdapterFactory.java */
/* loaded from: classes3.dex */
public final class b implements s {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.internal.b f850a;

    /* compiled from: CollectionTypeAdapterFactory.java */
    /* loaded from: classes3.dex */
    public static final class a<E> extends r<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        public final r<E> f851a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.gson.internal.f<? extends Collection<E>> f852b;

        public a(com.google.gson.d dVar, Type type, r<E> rVar, com.google.gson.internal.f<? extends Collection<E>> fVar) {
            this.f851a = new n(dVar, rVar, type);
            this.f852b = fVar;
        }

        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            Collection<E> a10 = this.f852b.a();
            aVar.a();
            while (aVar.y()) {
                a10.add(this.f851a.b(aVar));
            }
            aVar.l();
            return a10;
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Collection<E> collection) {
            if (collection == null) {
                bVar.I();
                return;
            }
            bVar.e();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f851a.d(bVar, it.next());
            }
            bVar.l();
        }
    }

    public b(com.google.gson.internal.b bVar) {
        this.f850a = bVar;
    }

    @Override // com.google.gson.s
    public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type h10 = C$Gson$Types.h(type, rawType);
        return new a(dVar, h10, dVar.l(J4.a.get(h10)), this.f850a.b(aVar));
    }
}
