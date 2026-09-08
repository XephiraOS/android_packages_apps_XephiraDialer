package kotlinx.coroutines.flow;

import m9.q;

/* compiled from: Builders.kt */
/* loaded from: classes4.dex */
public final class j<T> extends AbstractFlow<T> {

    /* renamed from: a, reason: collision with root package name */
    public final v9.p<b<? super T>, kotlin.coroutines.c<? super q>, Object> f34470a;

    /* JADX WARN: Multi-variable type inference failed */
    public j(v9.p<? super b<? super T>, ? super kotlin.coroutines.c<? super q>, ? extends Object> pVar) {
        this.f34470a = pVar;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    public Object b(b<? super T> bVar, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object invoke = this.f34470a.invoke(bVar, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (invoke == c10) {
            return invoke;
        }
        return q.f35511a;
    }
}
