package com.android.contacts.framework.virtualsupport.utils;

import com.android.contacts.framework.virtualsupport.ChatCallImpl;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GrpcUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.virtualsupport.utils.GrpcUtils$initGrpcProvider$1$onChat$1", f = "GrpcUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GrpcUtils$initGrpcProvider$1$onChat$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ ChatCallImpl.Invoker $iv;
    final /* synthetic */ int $transactionId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrpcUtils$initGrpcProvider$1$onChat$1(int i10, ChatCallImpl.Invoker invoker, c<? super GrpcUtils$initGrpcProvider$1$onChat$1> cVar) {
        super(2, cVar);
        this.$transactionId = i10;
        this.$iv = invoker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new GrpcUtils$initGrpcProvider$1$onChat$1(this.$transactionId, this.$iv, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            concurrentHashMap = GrpcUtils.chatInvokerMap;
            concurrentHashMap.put(C1467a.d(this.$transactionId), this.$iv);
            H7.b.b(GrpcUtils.TAG, "Provider onChat: consumer connect transactionId = " + this.$transactionId);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((GrpcUtils$initGrpcProvider$1$onChat$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
