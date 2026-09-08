package Z2;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Map<X2.b, com.bumptech.glide.load.engine.g<?>> f5884a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<X2.b, com.bumptech.glide.load.engine.g<?>> f5885b = new HashMap();

    public com.bumptech.glide.load.engine.g<?> a(X2.b bVar, boolean z10) {
        return b(z10).get(bVar);
    }

    public final Map<X2.b, com.bumptech.glide.load.engine.g<?>> b(boolean z10) {
        if (z10) {
            return this.f5885b;
        }
        return this.f5884a;
    }

    public void c(X2.b bVar, com.bumptech.glide.load.engine.g<?> gVar) {
        b(gVar.p()).put(bVar, gVar);
    }

    public void d(X2.b bVar, com.bumptech.glide.load.engine.g<?> gVar) {
        Map<X2.b, com.bumptech.glide.load.engine.g<?>> b10 = b(gVar.p());
        if (gVar.equals(b10.get(bVar))) {
            b10.remove(bVar);
        }
    }
}
