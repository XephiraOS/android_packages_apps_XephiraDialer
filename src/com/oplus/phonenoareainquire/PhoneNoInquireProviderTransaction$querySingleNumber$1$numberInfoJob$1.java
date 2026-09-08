package com.oplus.phonenoareainquire;

import com.oplus.phonenoareainquire.utils.e;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: PhoneNoInquireProviderTransaction.kt */
@InterfaceC1470d(c = "com.oplus.phonenoareainquire.PhoneNoInquireProviderTransaction$querySingleNumber$1$numberInfoJob$1", f = "PhoneNoInquireProviderTransaction.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class PhoneNoInquireProviderTransaction$querySingleNumber$1$numberInfoJob$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super e.a>, Object> {
    final /* synthetic */ String $phoneNumber;
    final /* synthetic */ PhoneNoInquireProvider $provider;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNoInquireProviderTransaction$querySingleNumber$1$numberInfoJob$1(PhoneNoInquireProvider phoneNoInquireProvider, String str, kotlin.coroutines.c<? super PhoneNoInquireProviderTransaction$querySingleNumber$1$numberInfoJob$1> cVar) {
        super(2, cVar);
        this.$provider = phoneNoInquireProvider;
        this.$phoneNumber = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new PhoneNoInquireProviderTransaction$querySingleNumber$1$numberInfoJob$1(this.$provider, this.$phoneNumber, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            e.a u10 = this.$provider.u(this.$phoneNumber);
            if (u10 == null) {
                return null;
            }
            return u10;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super e.a> cVar) {
        return ((PhoneNoInquireProviderTransaction$querySingleNumber$1$numberInfoJob$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
