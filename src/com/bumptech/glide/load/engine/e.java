package com.bumptech.glide.load.engine;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import s3.C1540k;

/* compiled from: DecodePath.java */
/* loaded from: classes.dex */
public class e<DataType, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    public final Class<DataType> f19534a;

    /* renamed from: b, reason: collision with root package name */
    public final List<? extends X2.e<DataType, ResourceType>> f19535b;

    /* renamed from: c, reason: collision with root package name */
    public final l3.e<ResourceType, Transcode> f19536c;

    /* renamed from: d, reason: collision with root package name */
    public final I.e<List<Throwable>> f19537d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19538e;

    /* compiled from: DecodePath.java */
    /* loaded from: classes.dex */
    public interface a<ResourceType> {
        Z2.j<ResourceType> a(Z2.j<ResourceType> jVar);
    }

    public e(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends X2.e<DataType, ResourceType>> list, l3.e<ResourceType, Transcode> eVar, I.e<List<Throwable>> eVar2) {
        this.f19534a = cls;
        this.f19535b = list;
        this.f19536c = eVar;
        this.f19537d = eVar2;
        this.f19538e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public Z2.j<Transcode> a(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, X2.d dVar, a<ResourceType> aVar) {
        return this.f19536c.a(aVar.a(b(eVar, i10, i11, dVar)), dVar);
    }

    public final Z2.j<ResourceType> b(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, X2.d dVar) {
        List<Throwable> list = (List) C1540k.d(this.f19537d.b());
        try {
            return c(eVar, i10, i11, dVar, list);
        } finally {
            this.f19537d.a(list);
        }
    }

    public final Z2.j<ResourceType> c(com.bumptech.glide.load.data.e<DataType> eVar, int i10, int i11, X2.d dVar, List<Throwable> list) {
        int size = this.f19535b.size();
        Z2.j<ResourceType> jVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            X2.e<DataType, ResourceType> eVar2 = this.f19535b.get(i12);
            try {
                if (eVar2.a(eVar.a(), dVar)) {
                    jVar = eVar2.b(eVar.a(), i10, i11, dVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e10) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + eVar2, e10);
                }
                list.add(e10);
            }
            if (jVar != null) {
                break;
            }
        }
        if (jVar != null) {
            return jVar;
        }
        throw new GlideException(this.f19538e, new ArrayList(list));
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f19534a + ", decoders=" + this.f19535b + ", transcoder=" + this.f19536c + '}';
    }
}
