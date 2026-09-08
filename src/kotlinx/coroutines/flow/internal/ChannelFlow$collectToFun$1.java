package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ChannelFlow.kt */
@InterfaceC1470d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ChannelFlow$collectToFun$1<T> extends SuspendLambda implements p<kotlinx.coroutines.channels.l<? super T>, kotlin.coroutines.c<? super q>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collectToFun$1(ChannelFlow<T> channelFlow, kotlin.coroutines.c<? super ChannelFlow$collectToFun$1> cVar) {
        super(2, cVar);
        this.this$0 = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.this$0, cVar);
        channelFlow$collectToFun$1.L$0 = obj;
        return channelFlow$collectToFun$1;
    }

    @Override // v9.p
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Object invoke(kotlinx.coroutines.channels.l<? super T> lVar, kotlin.coroutines.c<? super q> cVar) {
        return ((ChannelFlow$collectToFun$1) create(lVar, cVar)).invokeSuspend(q.f35511a);
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
            kotlinx.coroutines.channels.l<? super T> lVar = (kotlinx.coroutines.channels.l) this.L$0;
            ChannelFlow<T> channelFlow = this.this$0;
            this.label = 1;
            if (channelFlow.e(lVar, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }
}
