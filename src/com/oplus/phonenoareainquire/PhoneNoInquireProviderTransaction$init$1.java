package com.oplus.phonenoareainquire;

import android.util.Log;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: PhoneNoInquireProviderTransaction.kt */
@InterfaceC1470d(c = "com.oplus.phonenoareainquire.PhoneNoInquireProviderTransaction$init$1", f = "PhoneNoInquireProviderTransaction.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class PhoneNoInquireProviderTransaction$init$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super Integer>, Object> {
    int label;

    public PhoneNoInquireProviderTransaction$init$1(kotlin.coroutines.c<? super PhoneNoInquireProviderTransaction$init$1> cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new PhoneNoInquireProviderTransaction$init$1(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            return C1467a.d(Log.d("PhoneNoInquireProviderTransaction", "init for coroutines ,otherwise it will take so many time when first query provider"));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super Integer> cVar) {
        return ((PhoneNoInquireProviderTransaction$init$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
