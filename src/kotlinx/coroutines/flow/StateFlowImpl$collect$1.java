package kotlinx.coroutines.flow;

import com.oplus.backup.sdk.common.utils.ModuleType;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: StateFlow.kt */
@InterfaceC1470d(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {ModuleType.TYPE_SYSTEM_SETTING, 396, 401}, m = "collect")
/* loaded from: classes4.dex */
public final class StateFlowImpl$collect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StateFlowImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateFlowImpl$collect$1(StateFlowImpl<T> stateFlowImpl, kotlin.coroutines.c<? super StateFlowImpl$collect$1> cVar) {
        super(cVar);
        this.this$0 = stateFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
