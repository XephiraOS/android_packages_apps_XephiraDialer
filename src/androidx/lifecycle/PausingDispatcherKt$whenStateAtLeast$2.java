package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.InterfaceC1265l0;
import p9.InterfaceC1470d;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: PausingDispatcher.kt */
@InterfaceC1470d(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {203}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PausingDispatcherKt$whenStateAtLeast$2<T> extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super T>, Object> {
    final /* synthetic */ v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super T>, Object> $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, v9.p<? super kotlinx.coroutines.E, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super PausingDispatcherKt$whenStateAtLeast$2> cVar) {
        super(2, cVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, cVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        C0487j c0487j;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                c0487j = (C0487j) this.L$0;
                try {
                    kotlin.b.b(obj);
                } catch (Throwable th) {
                    th = th;
                    c0487j.b();
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            InterfaceC1265l0 interfaceC1265l0 = (InterfaceC1265l0) ((kotlinx.coroutines.E) this.L$0).s().a(InterfaceC1265l0.f34546v);
            if (interfaceC1265l0 != null) {
                y yVar = new y();
                C0487j c0487j2 = new C0487j(this.$this_whenStateAtLeast, this.$minState, yVar.f10389c, interfaceC1265l0);
                try {
                    v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super T>, Object> pVar = this.$block;
                    this.L$0 = c0487j2;
                    this.label = 1;
                    obj = C1244g.g(yVar, pVar, this);
                    if (obj == c10) {
                        return c10;
                    }
                    c0487j = c0487j2;
                } catch (Throwable th2) {
                    th = th2;
                    c0487j = c0487j2;
                    c0487j.b();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        }
        c0487j.b();
        return obj;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super T> cVar) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
