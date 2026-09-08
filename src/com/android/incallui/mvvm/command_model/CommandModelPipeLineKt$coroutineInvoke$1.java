package com.android.incallui.mvvm.command_model;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;
import v9.p;

/* JADX WARN: Incorrect field signature: TF; */
/* compiled from: CommandModelPipeLine.kt */
@InterfaceC1470d(c = "com.android.incallui.mvvm.command_model.CommandModelPipeLineKt$coroutineInvoke$1", f = "CommandModelPipeLine.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CommandModelPipeLineKt$coroutineInvoke$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ InterfaceC1637a $this_coroutineInvoke;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (TF;Lkotlin/coroutines/c<-Lcom/android/incallui/mvvm/command_model/CommandModelPipeLineKt$coroutineInvoke$1;>;)V */
    public CommandModelPipeLineKt$coroutineInvoke$1(InterfaceC1637a interfaceC1637a, c cVar) {
        super(2, cVar);
        this.$this_coroutineInvoke = interfaceC1637a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new CommandModelPipeLineKt$coroutineInvoke$1(this.$this_coroutineInvoke, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.$this_coroutineInvoke.invoke();
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((CommandModelPipeLineKt$coroutineInvoke$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
