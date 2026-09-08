package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import s3.C1540k;

/* compiled from: LoadPath.java */
/* loaded from: classes.dex */
public class i<Data, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    public final Class<Data> f19605a;

    /* renamed from: b, reason: collision with root package name */
    public final I.e<List<Throwable>> f19606b;

    /* renamed from: c, reason: collision with root package name */
    public final List<? extends e<Data, ResourceType, Transcode>> f19607c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19608d;

    public i(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<e<Data, ResourceType, Transcode>> list, I.e<List<Throwable>> eVar) {
        this.f19605a = cls;
        this.f19606b = eVar;
        this.f19607c = (List) C1540k.c(list);
        this.f19608d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public Z2.j<Transcode> a(com.bumptech.glide.load.data.e<Data> eVar, X2.d dVar, int i10, int i11, e.a<ResourceType> aVar) {
        List<Throwable> list = (List) C1540k.d(this.f19606b.b());
        try {
            return b(eVar, dVar, i10, i11, aVar, list);
        } finally {
            this.f19606b.a(list);
        }
    }

    public final Z2.j<Transcode> b(com.bumptech.glide.load.data.e<Data> eVar, X2.d dVar, int i10, int i11, e.a<ResourceType> aVar, List<Throwable> list) {
        int size = this.f19607c.size();
        Z2.j<Transcode> jVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            try {
                jVar = this.f19607c.get(i12).a(eVar, i10, i11, dVar, aVar);
            } catch (GlideException e10) {
                list.add(e10);
            }
            if (jVar != null) {
                break;
            }
        }
        if (jVar != null) {
            return jVar;
        }
        throw new GlideException(this.f19608d, new ArrayList(list));
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f19607c.toArray()) + '}';
    }
}
