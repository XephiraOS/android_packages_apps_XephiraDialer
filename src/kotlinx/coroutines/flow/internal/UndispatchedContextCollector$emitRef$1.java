package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ChannelFlow.kt */
@InterfaceC1470d(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", l = {212}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class UndispatchedContextCollector$emitRef$1<T> extends SuspendLambda implements p<T, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.b<T> $downstream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UndispatchedContextCollector$emitRef$1(kotlinx.coroutines.flow.b<? super T> bVar, kotlin.coroutines.c<? super UndispatchedContextCollector$emitRef$1> cVar) {
        super(2, cVar);
        this.$downstream = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        UndispatchedContextCollector$emitRef$1 undispatchedContextCollector$emitRef$1 = new UndispatchedContextCollector$emitRef$1(this.$downstream, cVar);
        undispatchedContextCollector$emitRef$1.L$0 = obj;
        return undispatchedContextCollector$emitRef$1;
    }

    @Override // v9.p
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Object invoke(T t10, kotlin.coroutines.c<? super q> cVar) {
        return ((UndispatchedContextCollector$emitRef$1) create(t10, cVar)).invokeSuspend(q.f35511a);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
            Object obj2 = this.L$0;
            kotlinx.coroutines.flow.b<T> bVar = this.$downstream;
            this.label = 1;
            if (bVar.emit(obj2, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }
}
