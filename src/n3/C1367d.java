package n3;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p.C1415a;
import s3.C1539j;

/* compiled from: ModelToResourceClassCache.java */
/* renamed from: n3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1367d {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference<C1539j> f35614a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    public final C1415a<C1539j, List<Class<?>>> f35615b = new C1415a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        C1539j andSet = this.f35614a.getAndSet(null);
        if (andSet == null) {
            andSet = new C1539j(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f35615b) {
            list = this.f35615b.get(andSet);
        }
        this.f35614a.set(andSet);
        return list;
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f35615b) {
            this.f35615b.put(new C1539j(cls, cls2, cls3), list);
        }
    }
}
