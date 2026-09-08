package F4;

import com.google.gson.p;
import com.google.gson.r;
import com.google.gson.s;

/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes3.dex */
public final class e implements s {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.internal.b f859a;

    public e(com.google.gson.internal.b bVar) {
        this.f859a = bVar;
    }

    @Override // com.google.gson.s
    public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
        E4.b bVar = (E4.b) aVar.getRawType().getAnnotation(E4.b.class);
        if (bVar == null) {
            return null;
        }
        return (r<T>) b(this.f859a, dVar, aVar, bVar);
    }

    public r<?> b(com.google.gson.internal.b bVar, com.google.gson.d dVar, J4.a<?> aVar, E4.b bVar2) {
        p pVar;
        com.google.gson.i iVar;
        r<?> mVar;
        Object a10 = bVar.b(J4.a.get((Class) bVar2.value())).a();
        boolean nullSafe = bVar2.nullSafe();
        if (a10 instanceof r) {
            mVar = (r) a10;
        } else if (a10 instanceof s) {
            mVar = ((s) a10).a(dVar, aVar);
        } else {
            boolean z10 = a10 instanceof p;
            if (!z10 && !(a10 instanceof com.google.gson.i)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a10.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            if (z10) {
                pVar = (p) a10;
            } else {
                pVar = null;
            }
            if (a10 instanceof com.google.gson.i) {
                iVar = (com.google.gson.i) a10;
            } else {
                iVar = null;
            }
            mVar = new m<>(pVar, iVar, dVar, aVar, null, nullSafe);
            nullSafe = false;
        }
        if (mVar != null && nullSafe) {
            return mVar.a();
        }
        return mVar;
    }
}
