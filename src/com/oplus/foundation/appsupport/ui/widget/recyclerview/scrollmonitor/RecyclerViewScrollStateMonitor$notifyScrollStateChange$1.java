package com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecyclerViewScrollStateMonitor.kt */
@InterfaceC1470d(c = "com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor.RecyclerViewScrollStateMonitor$notifyScrollStateChange$1", f = "RecyclerViewScrollStateMonitor.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecyclerViewScrollStateMonitor$notifyScrollStateChange$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ boolean $isIdle;
    int label;
    final /* synthetic */ RecyclerViewScrollStateMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecyclerViewScrollStateMonitor$notifyScrollStateChange$1(RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor, boolean z10, c<? super RecyclerViewScrollStateMonitor$notifyScrollStateChange$1> cVar) {
        super(2, cVar);
        this.this$0 = recyclerViewScrollStateMonitor;
        this.$isIdle = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new RecyclerViewScrollStateMonitor$notifyScrollStateChange$1(this.this$0, this.$isIdle, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        i iVar;
        Object value;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            iVar = this.this$0.f28262d;
            boolean z10 = this.$isIdle;
            do {
                value = iVar.getValue();
            } while (!iVar.c(value, new a(z10)));
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((RecyclerViewScrollStateMonitor$notifyScrollStateChange$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
