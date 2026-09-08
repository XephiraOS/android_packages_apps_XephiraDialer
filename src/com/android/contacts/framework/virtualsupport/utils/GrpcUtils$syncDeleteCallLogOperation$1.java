package com.android.contacts.framework.virtualsupport.utils;

import android.content.Context;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: GrpcUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.virtualsupport.utils.GrpcUtils$syncDeleteCallLogOperation$1", f = "GrpcUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class GrpcUtils$syncDeleteCallLogOperation$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $deletedCallLogVirtualId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrpcUtils$syncDeleteCallLogOperation$1(Context context, String str, c<? super GrpcUtils$syncDeleteCallLogOperation$1> cVar) {
        super(2, cVar);
        this.$context = context;
        this.$deletedCallLogVirtualId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new GrpcUtils$syncDeleteCallLogOperation$1(this.$context, this.$deletedCallLogVirtualId, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            GrpcUtils.syncDeleteCallLog$virtualsupport_release(this.$context, this.$deletedCallLogVirtualId);
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((GrpcUtils$syncDeleteCallLogOperation$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
