package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;
import v9.q;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: Merge.kt */
@InterfaceC1470d(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {217, 217}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__MergeKt$mapLatest$1<R, T> extends SuspendLambda implements q<b<? super R>, T, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ v9.p<T, kotlin.coroutines.c<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__MergeKt$mapLatest$1(v9.p<? super T, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, kotlin.coroutines.c<? super FlowKt__MergeKt$mapLatest$1> cVar) {
        super(3, cVar);
        this.$transform = pVar;
    }

    @Override // v9.q
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Object d(b<? super R> bVar, T t10, kotlin.coroutines.c<? super m9.q> cVar) {
        FlowKt__MergeKt$mapLatest$1 flowKt__MergeKt$mapLatest$1 = new FlowKt__MergeKt$mapLatest$1(this.$transform, cVar);
        flowKt__MergeKt$mapLatest$1.L$0 = bVar;
        flowKt__MergeKt$mapLatest$1.L$1 = t10;
        return flowKt__MergeKt$mapLatest$1.invokeSuspend(m9.q.f35511a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        b bVar;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    kotlin.b.b(obj);
                    return m9.q.f35511a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b bVar2 = (b) this.L$0;
            kotlin.b.b(obj);
            bVar = bVar2;
        } else {
            kotlin.b.b(obj);
            b bVar3 = (b) this.L$0;
            Object obj2 = this.L$1;
            v9.p<T, kotlin.coroutines.c<? super R>, Object> pVar = this.$transform;
            this.L$0 = bVar3;
            this.label = 1;
            obj = pVar.invoke(obj2, this);
            bVar = bVar3;
            if (obj == c10) {
                return c10;
            }
        }
        this.L$0 = null;
        this.label = 2;
        if (bVar.emit(obj, this) == c10) {
            return c10;
        }
        return m9.q.f35511a;
    }
}
