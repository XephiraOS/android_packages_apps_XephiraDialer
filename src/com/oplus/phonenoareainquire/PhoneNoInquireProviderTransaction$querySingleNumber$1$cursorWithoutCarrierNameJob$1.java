package com.oplus.phonenoareainquire;

import android.database.Cursor;
import android.database.MatrixCursor;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: PhoneNoInquireProviderTransaction.kt */
@InterfaceC1470d(c = "com.oplus.phonenoareainquire.PhoneNoInquireProviderTransaction$querySingleNumber$1$cursorWithoutCarrierNameJob$1", f = "PhoneNoInquireProviderTransaction.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class PhoneNoInquireProviderTransaction$querySingleNumber$1$cursorWithoutCarrierNameJob$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super Cursor>, Object> {
    final /* synthetic */ String $countryIso;
    final /* synthetic */ MatrixCursor $defaultRes;
    final /* synthetic */ boolean $isDomesticSim;
    final /* synthetic */ boolean $isForceQueryDomestic;
    final /* synthetic */ boolean $isRoam;
    final /* synthetic */ String $phoneNumber;
    final /* synthetic */ PhoneNoInquireProvider $provider;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNoInquireProviderTransaction$querySingleNumber$1$cursorWithoutCarrierNameJob$1(PhoneNoInquireProvider phoneNoInquireProvider, String str, String str2, boolean z10, boolean z11, boolean z12, MatrixCursor matrixCursor, kotlin.coroutines.c<? super PhoneNoInquireProviderTransaction$querySingleNumber$1$cursorWithoutCarrierNameJob$1> cVar) {
        super(2, cVar);
        this.$provider = phoneNoInquireProvider;
        this.$phoneNumber = str;
        this.$countryIso = str2;
        this.$isForceQueryDomestic = z10;
        this.$isRoam = z11;
        this.$isDomesticSim = z12;
        this.$defaultRes = matrixCursor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new PhoneNoInquireProviderTransaction$querySingleNumber$1$cursorWithoutCarrierNameJob$1(this.$provider, this.$phoneNumber, this.$countryIso, this.$isForceQueryDomestic, this.$isRoam, this.$isDomesticSim, this.$defaultRes, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            Cursor j10 = this.$provider.j(this.$phoneNumber, this.$countryIso, C1467a.a(this.$isForceQueryDomestic), this.$isRoam, this.$isDomesticSim);
            if (j10 == null) {
                return this.$defaultRes;
            }
            return j10;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super Cursor> cVar) {
        return ((PhoneNoInquireProviderTransaction$querySingleNumber$1$cursorWithoutCarrierNameJob$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
