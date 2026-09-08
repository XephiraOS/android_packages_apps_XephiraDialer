package F4;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory.java */
/* loaded from: classes3.dex */
public final class h implements s {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.internal.b f872a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f873b;

    /* compiled from: MapTypeAdapterFactory.java */
    /* loaded from: classes3.dex */
    public final class a<K, V> extends r<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public final r<K> f874a;

        /* renamed from: b, reason: collision with root package name */
        public final r<V> f875b;

        /* renamed from: c, reason: collision with root package name */
        public final com.google.gson.internal.f<? extends Map<K, V>> f876c;

        public a(com.google.gson.d dVar, Type type, r<K> rVar, Type type2, r<V> rVar2, com.google.gson.internal.f<? extends Map<K, V>> fVar) {
            this.f874a = new n(dVar, rVar, type);
            this.f875b = new n(dVar, rVar2, type2);
            this.f876c = fVar;
        }

        public final String e(com.google.gson.j jVar) {
            if (jVar.j()) {
                com.google.gson.n e10 = jVar.e();
                if (e10.s()) {
                    return String.valueOf(e10.o());
                }
                if (e10.q()) {
                    return Boolean.toString(e10.k());
                }
                if (e10.t()) {
                    return e10.p();
                }
                throw new AssertionError();
            }
            if (jVar.h()) {
                return "null";
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(K4.a aVar) {
            JsonToken f02 = aVar.f0();
            if (f02 == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            Map<K, V> a10 = this.f876c.a();
            if (f02 == JsonToken.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.y()) {
                    aVar.a();
                    K b10 = this.f874a.b(aVar);
                    if (a10.put(b10, this.f875b.b(aVar)) == null) {
                        aVar.l();
                    } else {
                        throw new JsonSyntaxException("duplicate key: " + b10);
                    }
                }
                aVar.l();
            } else {
                aVar.c();
                while (aVar.y()) {
                    com.google.gson.internal.e.f24802a.a(aVar);
                    K b11 = this.f874a.b(aVar);
                    if (a10.put(b11, this.f875b.b(aVar)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + b11);
                    }
                }
                aVar.o();
            }
            return a10;
        }

        @Override // com.google.gson.r
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Map<K, V> map) {
            boolean z10;
            if (map == null) {
                bVar.I();
                return;
            }
            if (!h.this.f873b) {
                bVar.f();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    bVar.B(String.valueOf(entry.getKey()));
                    this.f875b.d(bVar, entry.getValue());
                }
                bVar.o();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i10 = 0;
            boolean z11 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                com.google.gson.j c10 = this.f874a.c(entry2.getKey());
                arrayList.add(c10);
                arrayList2.add(entry2.getValue());
                if (!c10.g() && !c10.i()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                z11 |= z10;
            }
            if (z11) {
                bVar.e();
                int size = arrayList.size();
                while (i10 < size) {
                    bVar.e();
                    com.google.gson.internal.j.b((com.google.gson.j) arrayList.get(i10), bVar);
                    this.f875b.d(bVar, arrayList2.get(i10));
                    bVar.l();
                    i10++;
                }
                bVar.l();
                return;
            }
            bVar.f();
            int size2 = arrayList.size();
            while (i10 < size2) {
                bVar.B(e((com.google.gson.j) arrayList.get(i10)));
                this.f875b.d(bVar, arrayList2.get(i10));
                i10++;
            }
            bVar.o();
        }
    }

    public h(com.google.gson.internal.b bVar, boolean z10) {
        this.f872a = bVar;
        this.f873b = z10;
    }

    @Override // com.google.gson.s
    public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type[] j10 = C$Gson$Types.j(type, rawType);
        return new a(dVar, j10[0], b(dVar, j10[0]), j10[1], dVar.l(J4.a.get(j10[1])), this.f872a.b(aVar));
    }

    public final r<?> b(com.google.gson.d dVar, Type type) {
        if (type != Boolean.TYPE && type != Boolean.class) {
            return dVar.l(J4.a.get(type));
        }
        return o.f953f;
    }
}
