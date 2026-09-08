package com.android.incallui.mvvm.command_model;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.l;
import v9.p;

/* JADX WARN: Incorrect field signature: TF; */
/* compiled from: CommandModelPipeLine.kt */
@InterfaceC1470d(c = "com.android.incallui.mvvm.command_model.CommandModelPipeLineKt$coroutineInvoke$2", f = "CommandModelPipeLine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CommandModelPipeLineKt$coroutineInvoke$2 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ P1 $param;
    final /* synthetic */ l $this_coroutineInvoke;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (TF;TP1;Lkotlin/coroutines/c<-Lcom/android/incallui/mvvm/command_model/CommandModelPipeLineKt$coroutineInvoke$2;>;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public CommandModelPipeLineKt$coroutineInvoke$2(l lVar, Object obj, c cVar) {
        super(2, cVar);
        this.$this_coroutineInvoke = lVar;
        this.$param = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new CommandModelPipeLineKt$coroutineInvoke$2(this.$this_coroutineInvoke, this.$param, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.$this_coroutineInvoke.invoke(this.$param);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((CommandModelPipeLineKt$coroutineInvoke$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
