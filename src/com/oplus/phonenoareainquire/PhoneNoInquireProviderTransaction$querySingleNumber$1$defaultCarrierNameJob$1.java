package com.oplus.phonenoareainquire;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: PhoneNoInquireProviderTransaction.kt */
@InterfaceC1470d(c = "com.oplus.phonenoareainquire.PhoneNoInquireProviderTransaction$querySingleNumber$1$defaultCarrierNameJob$1", f = "PhoneNoInquireProviderTransaction.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class PhoneNoInquireProviderTransaction$querySingleNumber$1$defaultCarrierNameJob$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super String>, Object> {
    final /* synthetic */ String $countryIso;
    final /* synthetic */ String $phoneNumber;
    final /* synthetic */ PhoneNoInquireProvider $provider;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNoInquireProviderTransaction$querySingleNumber$1$defaultCarrierNameJob$1(PhoneNoInquireProvider phoneNoInquireProvider, String str, String str2, kotlin.coroutines.c<? super PhoneNoInquireProviderTransaction$querySingleNumber$1$defaultCarrierNameJob$1> cVar) {
        super(2, cVar);
        this.$provider = phoneNoInquireProvider;
        this.$phoneNumber = str;
        this.$countryIso = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new PhoneNoInquireProviderTransaction$querySingleNumber$1$defaultCarrierNameJob$1(this.$provider, this.$phoneNumber, this.$countryIso, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            String k10 = this.$provider.k(this.$phoneNumber, this.$countryIso);
            if (k10 == null) {
                return null;
            }
            return k10;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super String> cVar) {
        return ((PhoneNoInquireProviderTransaction$querySingleNumber$1$defaultCarrierNameJob$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
