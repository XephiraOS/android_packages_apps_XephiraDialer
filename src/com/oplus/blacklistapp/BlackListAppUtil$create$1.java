package com.oplus.blacklistapp;

import android.content.Context;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: BlackListAppUtil.kt */
@InterfaceC1470d(c = "com.oplus.blacklistapp.BlackListAppUtil$create$1", f = "BlackListAppUtil.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BlackListAppUtil$create$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListAppUtil$create$1(Context context, kotlin.coroutines.c<? super BlackListAppUtil$create$1> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new BlackListAppUtil$create$1(this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            com.oplus.blacklistapp.framework.api.appstore.virtualsupport.a.c(this.$context, com.oplus.blacklistapp.framework.api.appstore.virtualsupport.a.b());
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((BlackListAppUtil$create$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
