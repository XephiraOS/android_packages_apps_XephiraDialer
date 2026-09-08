package V;

import V.a;
import kotlin.jvm.internal.i;

/* compiled from: CreationExtras.kt */
/* loaded from: classes.dex */
public final class d extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // V.a
    public <T> T a(a.b<T> key) {
        i.f(key, "key");
        return (T) b().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void c(a.b<T> key, T t10) {
        i.f(key, "key");
        b().put(key, t10);
    }

    public d(a initialExtras) {
        i.f(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    public /* synthetic */ d(a aVar, int i10, kotlin.jvm.internal.f fVar) {
        this((i10 & 1) != 0 ? a.C0073a.f3957b : aVar);
    }
}
