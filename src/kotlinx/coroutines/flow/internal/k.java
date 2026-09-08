package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.o;
import m9.q;

/* compiled from: SendingCollector.kt */
/* loaded from: classes4.dex */
public final class k<T> implements kotlinx.coroutines.flow.b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final o<T> f34467a;

    /* JADX WARN: Multi-variable type inference failed */
    public k(o<? super T> oVar) {
        this.f34467a = oVar;
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(T t10, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object k10 = this.f34467a.k(t10, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (k10 == c10) {
            return k10;
        }
        return q.f35511a;
    }
}
