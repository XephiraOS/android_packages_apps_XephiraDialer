package kotlinx.coroutines.flow.internal;

import com.coui.appcompat.vibrateutil.VibrateUtils;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ChannelFlow.kt */
@InterfaceC1470d(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {VibrateUtils.TYPE_STEPABLE_REGULATE}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class ChannelFlowOperator$collectWithContextUndispatched$2<T> extends SuspendLambda implements p<kotlinx.coroutines.flow.b<? super T>, kotlin.coroutines.c<? super q>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChannelFlowOperator<S, T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator<S, T> channelFlowOperator, kotlin.coroutines.c<? super ChannelFlowOperator$collectWithContextUndispatched$2> cVar) {
        super(2, cVar);
        this.this$0 = channelFlowOperator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        ChannelFlowOperator$collectWithContextUndispatched$2 channelFlowOperator$collectWithContextUndispatched$2 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.this$0, cVar);
        channelFlowOperator$collectWithContextUndispatched$2.L$0 = obj;
        return channelFlowOperator$collectWithContextUndispatched$2;
    }

    @Override // v9.p
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Object invoke(kotlinx.coroutines.flow.b<? super T> bVar, kotlin.coroutines.c<? super q> cVar) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) create(bVar, cVar)).invokeSuspend(q.f35511a);
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
            kotlinx.coroutines.flow.b<? super T> bVar = (kotlinx.coroutines.flow.b) this.L$0;
            ChannelFlowOperator<S, T> channelFlowOperator = this.this$0;
            this.label = 1;
            if (channelFlowOperator.m(bVar, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }
}
