package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref$ObjectRef;
import m9.q;

/* compiled from: Distinct.kt */
/* loaded from: classes4.dex */
public final class DistinctFlowImpl<T> implements a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final a<T> f34425a;

    /* renamed from: b, reason: collision with root package name */
    public final v9.l<T, Object> f34426b;

    /* renamed from: c, reason: collision with root package name */
    public final v9.p<Object, Object, Boolean> f34427c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(a<? extends T> aVar, v9.l<? super T, ? extends Object> lVar, v9.p<Object, Object, Boolean> pVar) {
        this.f34425a = aVar;
        this.f34426b = lVar;
        this.f34427c = pVar;
    }

    @Override // kotlinx.coroutines.flow.a
    public Object collect(b<? super T> bVar, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (T) kotlinx.coroutines.flow.internal.j.f34464a;
        Object collect = this.f34425a.collect(new DistinctFlowImpl$collect$2(this, ref$ObjectRef, bVar), cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (collect == c10) {
            return collect;
        }
        return q.f35511a;
    }
}
