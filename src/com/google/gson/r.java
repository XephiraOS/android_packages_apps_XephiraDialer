package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapter.java */
/* loaded from: classes3.dex */
public abstract class r<T> {

    /* compiled from: TypeAdapter.java */
    /* loaded from: classes3.dex */
    public class a extends r<T> {
        public a() {
        }

        @Override // com.google.gson.r
        public T b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return (T) r.this.b(aVar);
        }

        @Override // com.google.gson.r
        public void d(K4.b bVar, T t10) {
            if (t10 == null) {
                bVar.I();
            } else {
                r.this.d(bVar, t10);
            }
        }
    }

    public final r<T> a() {
        return new a();
    }

    public abstract T b(K4.a aVar);

    public final j c(T t10) {
        try {
            F4.g gVar = new F4.g();
            d(gVar, t10);
            return gVar.m0();
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public abstract void d(K4.b bVar, T t10);
}
