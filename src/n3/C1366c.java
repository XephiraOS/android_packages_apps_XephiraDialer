package n3;

import com.bumptech.glide.load.engine.i;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import l3.g;
import p.C1415a;
import s3.C1539j;

/* compiled from: LoadPathCache.java */
/* renamed from: n3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1366c {

    /* renamed from: c, reason: collision with root package name */
    public static final i<?, ?, ?> f35611c = new i<>(Object.class, Object.class, Object.class, Collections.singletonList(new com.bumptech.glide.load.engine.e(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    public final C1415a<C1539j, i<?, ?, ?>> f35612a = new C1415a<>();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<C1539j> f35613b = new AtomicReference<>();

    public <Data, TResource, Transcode> i<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        i<Data, TResource, Transcode> iVar;
        C1539j b10 = b(cls, cls2, cls3);
        synchronized (this.f35612a) {
            iVar = (i) this.f35612a.get(b10);
        }
        this.f35613b.set(b10);
        return iVar;
    }

    public final C1539j b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        C1539j andSet = this.f35613b.getAndSet(null);
        if (andSet == null) {
            andSet = new C1539j();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public boolean c(i<?, ?, ?> iVar) {
        return f35611c.equals(iVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, i<?, ?, ?> iVar) {
        synchronized (this.f35612a) {
            C1415a<C1539j, i<?, ?, ?>> c1415a = this.f35612a;
            C1539j c1539j = new C1539j(cls, cls2, cls3);
            if (iVar == null) {
                iVar = f35611c;
            }
            c1415a.put(c1539j, iVar);
        }
    }
}
