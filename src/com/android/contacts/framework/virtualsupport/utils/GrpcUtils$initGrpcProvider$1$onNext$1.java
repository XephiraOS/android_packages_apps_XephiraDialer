package com.android.contacts.framework.virtualsupport.utils;

import android.content.Context;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.google.protobuf.Any;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GrpcUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.virtualsupport.utils.GrpcUtils$initGrpcProvider$1$onNext$1", f = "GrpcUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GrpcUtils$initGrpcProvider$1$onNext$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ GrpcUtils.OperationCallBack $operationCallBack;
    final /* synthetic */ Any $requestChat;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrpcUtils$initGrpcProvider$1$onNext$1(GrpcUtils.OperationCallBack operationCallBack, Context context, Any any, c<? super GrpcUtils$initGrpcProvider$1$onNext$1> cVar) {
        super(2, cVar);
        this.$operationCallBack = operationCallBack;
        this.$context = context;
        this.$requestChat = any;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new GrpcUtils$initGrpcProvider$1$onNext$1(this.$operationCallBack, this.$context, this.$requestChat, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            H7.b.b(GrpcUtils.TAG, "Provider onNext: get consumer requestChat");
            this.$operationCallBack.doOperation(this.$context, this.$requestChat);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((GrpcUtils$initGrpcProvider$1$onNext$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
