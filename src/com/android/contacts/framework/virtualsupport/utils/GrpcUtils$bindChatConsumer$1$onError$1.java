package com.android.contacts.framework.virtualsupport.utils;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GrpcUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.virtualsupport.utils.GrpcUtils$bindChatConsumer$1$onError$1", f = "GrpcUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GrpcUtils$bindChatConsumer$1$onError$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Throwable $t;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrpcUtils$bindChatConsumer$1$onError$1(Throwable th, c<? super GrpcUtils$bindChatConsumer$1$onError$1> cVar) {
        super(2, cVar);
        this.$t = th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new GrpcUtils$bindChatConsumer$1$onError$1(this.$t, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b(GrpcUtils.TAG, "Consumer onError: connect error: " + this.$t);
            GrpcUtils.chatRequ = null;
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((GrpcUtils$bindChatConsumer$1$onError$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
