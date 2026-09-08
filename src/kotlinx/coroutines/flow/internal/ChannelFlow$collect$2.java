package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.channels.n;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ChannelFlow.kt */
@InterfaceC1470d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ChannelFlow$collect$2 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.b<T> $collector;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlow$collect$2(kotlinx.coroutines.flow.b<? super T> bVar, ChannelFlow<T> channelFlow, kotlin.coroutines.c<? super ChannelFlow$collect$2> cVar) {
        super(2, cVar);
        this.$collector = bVar;
        this.this$0 = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.$collector, this.this$0, cVar);
        channelFlow$collect$2.L$0 = obj;
        return channelFlow$collect$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            E e10 = (E) this.L$0;
            kotlinx.coroutines.flow.b<T> bVar = this.$collector;
            n i11 = this.this$0.i(e10);
            this.label = 1;
            if (kotlinx.coroutines.flow.c.f(bVar, i11, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ChannelFlow$collect$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
