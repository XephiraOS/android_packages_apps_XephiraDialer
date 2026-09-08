package androidx.lifecycle;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC1470d;

/* compiled from: Lifecycle.kt */
@InterfaceC1470d(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", l = {356}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class LifecycleCoroutineScope$launchWhenStarted$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> $block;
    int label;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LifecycleCoroutineScope$launchWhenStarted$1(LifecycleCoroutineScope lifecycleCoroutineScope, v9.p<? super kotlinx.coroutines.E, ? super kotlin.coroutines.c<? super m9.q>, ? extends Object> pVar, kotlin.coroutines.c<? super LifecycleCoroutineScope$launchWhenStarted$1> cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new LifecycleCoroutineScope$launchWhenStarted$1(this.this$0, this.$block, cVar);
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
            Lifecycle a10 = this.this$0.a();
            v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> pVar = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.a(a10, pVar, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((LifecycleCoroutineScope$launchWhenStarted$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
