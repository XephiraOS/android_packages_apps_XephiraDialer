package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import m9.q;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public final class e<T> extends ChannelFlowOperator<T, T> {
    public /* synthetic */ e(kotlinx.coroutines.flow.a aVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, kotlin.jvm.internal.f fVar) {
        this(aVar, (i11 & 2) != 0 ? EmptyCoroutineContext.f34213a : coroutineContext, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public ChannelFlow<T> f(CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        return new e(this.f34443d, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public Object m(kotlinx.coroutines.flow.b<? super T> bVar, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object collect = this.f34443d.collect(bVar, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (collect == c10) {
            return collect;
        }
        return q.f35511a;
    }

    public e(kotlinx.coroutines.flow.a<? extends T> aVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow) {
        super(aVar, coroutineContext, i10, bufferOverflow);
    }
}
