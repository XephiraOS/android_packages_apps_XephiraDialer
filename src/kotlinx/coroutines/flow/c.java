package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.BufferOverflow;
import m9.q;

/* loaded from: classes4.dex */
public final class c {
    public static final <T> a<T> a(a<? extends T> aVar, int i10, BufferOverflow bufferOverflow) {
        return f.a(aVar, i10, bufferOverflow);
    }

    public static final Object c(a<?> aVar, kotlin.coroutines.c<? super q> cVar) {
        return e.a(aVar, cVar);
    }

    public static final <T> Object d(a<? extends T> aVar, v9.p<? super T, ? super kotlin.coroutines.c<? super q>, ? extends Object> pVar, kotlin.coroutines.c<? super q> cVar) {
        return e.b(aVar, pVar, cVar);
    }

    public static final <T> a<T> e(a<? extends T> aVar) {
        return FlowKt__DistinctKt.a(aVar);
    }

    public static final <T> Object f(b<? super T> bVar, kotlinx.coroutines.channels.n<? extends T> nVar, kotlin.coroutines.c<? super q> cVar) {
        return FlowKt__ChannelsKt.b(bVar, nVar, cVar);
    }

    public static final void g(b<?> bVar) {
        g.a(bVar);
    }

    public static final <T> a<T> h(v9.p<? super b<? super T>, ? super kotlin.coroutines.c<? super q>, ? extends Object> pVar) {
        return d.a(pVar);
    }

    public static final <T, R> a<R> i(a<? extends T> aVar, v9.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar) {
        return FlowKt__MergeKt.a(aVar, pVar);
    }

    public static final <T, R> a<R> j(a<? extends T> aVar, v9.q<? super b<? super R>, ? super T, ? super kotlin.coroutines.c<? super q>, ? extends Object> qVar) {
        return FlowKt__MergeKt.b(aVar, qVar);
    }
}
