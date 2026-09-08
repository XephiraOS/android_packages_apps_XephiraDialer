package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import s3.C1540k;

/* compiled from: DataRewinderRegistry.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public static final e.a<?> f19417b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, e.a<?>> f19418a = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: classes.dex */
    public class a implements e.a<Object> {
        @Override // com.bumptech.glide.load.data.e.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.e.a
        public e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    public synchronized <T> e<T> a(T t10) {
        e.a<?> aVar;
        try {
            C1540k.d(t10);
            aVar = this.f19418a.get(t10.getClass());
            if (aVar == null) {
                Iterator<e.a<?>> it = this.f19418a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a<?> next = it.next();
                    if (next.a().isAssignableFrom(t10.getClass())) {
                        aVar = next;
                        break;
                    }
                }
            }
            if (aVar == null) {
                aVar = f19417b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return (e<T>) aVar.b(t10);
    }

    public synchronized void b(e.a<?> aVar) {
        this.f19418a.put(aVar.a(), aVar);
    }

    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: classes.dex */
    public static final class b implements e<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f19419a;

        public b(Object obj) {
            this.f19419a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        public Object a() {
            return this.f19419a;
        }

        @Override // com.bumptech.glide.load.data.e
        public void b() {
        }
    }
}
