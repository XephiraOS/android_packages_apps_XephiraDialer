package com.android.contacts.framework.virtualsupport.utils;

import io.grpc.stub.h;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GrpcUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.virtualsupport.utils.GrpcUtils$bindChatConsumer$1$onCompleted$1", f = "GrpcUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GrpcUtils$bindChatConsumer$1$onCompleted$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;

    public GrpcUtils$bindChatConsumer$1$onCompleted$1(c<? super GrpcUtils$bindChatConsumer$1$onCompleted$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new GrpcUtils$bindChatConsumer$1$onCompleted$1(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        h hVar;
        q qVar;
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b(GrpcUtils.TAG, "Consumer onCompleted: proxy complete");
            try {
                Result.a aVar = Result.f34166a;
                hVar = GrpcUtils.chatRequ;
                if (hVar != null) {
                    hVar.onCompleted();
                    qVar = q.f35511a;
                } else {
                    qVar = null;
                }
                b10 = Result.b(qVar);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c(GrpcUtils.TAG, "onCompleted: e = " + d10);
            }
            GrpcUtils.chatRequ = null;
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((GrpcUtils$bindChatConsumer$1$onCompleted$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
