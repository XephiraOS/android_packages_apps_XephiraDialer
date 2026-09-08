package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.F;
import kotlinx.coroutines.channels.BufferOverflow;
import v9.q;

/* compiled from: Merge.kt */
/* loaded from: classes4.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* renamed from: e, reason: collision with root package name */
    public final q<kotlinx.coroutines.flow.b<? super R>, T, kotlin.coroutines.c<? super m9.q>, Object> f34444e;

    public /* synthetic */ ChannelFlowTransformLatest(q qVar, kotlinx.coroutines.flow.a aVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, kotlin.jvm.internal.f fVar) {
        this(qVar, aVar, (i11 & 4) != 0 ? EmptyCoroutineContext.f34213a : coroutineContext, (i11 & 8) != 0 ? -2 : i10, (i11 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<R> f(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f34444e, this.f34443d, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object m(kotlinx.coroutines.flow.b<? super R> bVar, kotlin.coroutines.c<? super m9.q> cVar) {
        Object c10;
        Object e10 = F.e(new ChannelFlowTransformLatest$flowCollect$3(this, bVar, null), cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (e10 == c10) {
            return e10;
        }
        return m9.q.f35511a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(q<? super kotlinx.coroutines.flow.b<? super R>, ? super T, ? super kotlin.coroutines.c<? super m9.q>, ? extends Object> qVar, kotlinx.coroutines.flow.a<? extends T> aVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        super(aVar, coroutineContext, i10, bufferOverflow);
        this.f34444e = qVar;
    }
}
