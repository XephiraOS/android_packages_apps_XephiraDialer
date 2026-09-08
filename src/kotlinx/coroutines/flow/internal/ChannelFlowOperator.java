package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.q;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: d, reason: collision with root package name */
    public final kotlinx.coroutines.flow.a<S> f34443d;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(kotlinx.coroutines.flow.a<? extends S> aVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f34443d = aVar;
    }

    public static /* synthetic */ <S, T> Object j(ChannelFlowOperator<S, T> channelFlowOperator, kotlinx.coroutines.flow.b<? super T> bVar, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object c11;
        Object c12;
        if (channelFlowOperator.f34441b == -3) {
            CoroutineContext context = cVar.getContext();
            CoroutineContext d10 = CoroutineContextKt.d(context, channelFlowOperator.f34440a);
            if (kotlin.jvm.internal.i.b(d10, context)) {
                Object m10 = channelFlowOperator.m(bVar, cVar);
                c12 = kotlin.coroutines.intrinsics.b.c();
                if (m10 == c12) {
                    return m10;
                }
                return q.f35511a;
            }
            d.b bVar2 = kotlin.coroutines.d.f34217t;
            if (kotlin.jvm.internal.i.b(d10.a(bVar2), context.a(bVar2))) {
                Object l10 = channelFlowOperator.l(bVar, d10, cVar);
                c11 = kotlin.coroutines.intrinsics.b.c();
                if (l10 == c11) {
                    return l10;
                }
                return q.f35511a;
            }
        }
        Object collect = super.collect(bVar, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (collect == c10) {
            return collect;
        }
        return q.f35511a;
    }

    public static /* synthetic */ <S, T> Object k(ChannelFlowOperator<S, T> channelFlowOperator, kotlinx.coroutines.channels.l<? super T> lVar, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object m10 = channelFlowOperator.m(new k(lVar), cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (m10 == c10) {
            return m10;
        }
        return q.f35511a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.a
    public Object collect(kotlinx.coroutines.flow.b<? super T> bVar, kotlin.coroutines.c<? super q> cVar) {
        return j(this, bVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public Object e(kotlinx.coroutines.channels.l<? super T> lVar, kotlin.coroutines.c<? super q> cVar) {
        return k(this, lVar, cVar);
    }

    public final Object l(kotlinx.coroutines.flow.b<? super T> bVar, CoroutineContext coroutineContext, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object c11 = d.c(coroutineContext, d.a(bVar, cVar.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), cVar, 4, null);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (c11 == c10) {
            return c11;
        }
        return q.f35511a;
    }

    public abstract Object m(kotlinx.coroutines.flow.b<? super T> bVar, kotlin.coroutines.c<? super q> cVar);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.f34443d + " -> " + super.toString();
    }
}
