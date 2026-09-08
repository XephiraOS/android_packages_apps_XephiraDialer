package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import m9.q;
import v9.p;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public final class UndispatchedContextCollector<T> implements kotlinx.coroutines.flow.b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f34452a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f34453b;

    /* renamed from: c, reason: collision with root package name */
    public final p<T, kotlin.coroutines.c<? super q>, Object> f34454c;

    public UndispatchedContextCollector(kotlinx.coroutines.flow.b<? super T> bVar, CoroutineContext coroutineContext) {
        this.f34452a = coroutineContext;
        this.f34453b = ThreadContextKt.b(coroutineContext);
        this.f34454c = new UndispatchedContextCollector$emitRef$1(bVar, null);
    }

    @Override // kotlinx.coroutines.flow.b
    public Object emit(T t10, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object b10 = d.b(this.f34452a, t10, this.f34453b, this.f34454c, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (b10 == c10) {
            return b10;
        }
        return q.f35511a;
    }
}
