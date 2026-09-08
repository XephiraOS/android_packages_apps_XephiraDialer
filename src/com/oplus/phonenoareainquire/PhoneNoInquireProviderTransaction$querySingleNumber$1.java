package com.oplus.phonenoareainquire;

import android.database.MatrixCursor;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: PhoneNoInquireProviderTransaction.kt */
@InterfaceC1470d(c = "com.oplus.phonenoareainquire.PhoneNoInquireProviderTransaction$querySingleNumber$1", f = "PhoneNoInquireProviderTransaction.kt", l = {61, 62, 63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class PhoneNoInquireProviderTransaction$querySingleNumber$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super MatrixCursor>, Object> {
    final /* synthetic */ String $countryIso;
    final /* synthetic */ MatrixCursor $defaultRes;
    final /* synthetic */ boolean $isDomesticSim;
    final /* synthetic */ boolean $isForceQueryDomestic;
    final /* synthetic */ boolean $isNeedCarrierInfo;
    final /* synthetic */ boolean $isRoam;
    final /* synthetic */ boolean $needCarrierNameIfNoCityName;
    final /* synthetic */ String $phoneNumber;
    final /* synthetic */ PhoneNoInquireProvider $provider;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNoInquireProviderTransaction$querySingleNumber$1(PhoneNoInquireProvider phoneNoInquireProvider, boolean z10, boolean z11, String str, String str2, MatrixCursor matrixCursor, boolean z12, boolean z13, boolean z14, kotlin.coroutines.c<? super PhoneNoInquireProviderTransaction$querySingleNumber$1> cVar) {
        super(2, cVar);
        this.$provider = phoneNoInquireProvider;
        this.$isNeedCarrierInfo = z10;
        this.$needCarrierNameIfNoCityName = z11;
        this.$phoneNumber = str;
        this.$countryIso = str2;
        this.$defaultRes = matrixCursor;
        this.$isForceQueryDomestic = z12;
        this.$isRoam = z13;
        this.$isDomesticSim = z14;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        PhoneNoInquireProviderTransaction$querySingleNumber$1 phoneNoInquireProviderTransaction$querySingleNumber$1 = new PhoneNoInquireProviderTransaction$querySingleNumber$1(this.$provider, this.$isNeedCarrierInfo, this.$needCarrierNameIfNoCityName, this.$phoneNumber, this.$countryIso, this.$defaultRes, this.$isForceQueryDomestic, this.$isRoam, this.$isDomesticSim, cVar);
        phoneNoInquireProviderTransaction$querySingleNumber$1.L$0 = obj;
        return phoneNoInquireProviderTransaction$querySingleNumber$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v26, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.CharSequence, T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v21, types: [T, java.lang.String] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.phonenoareainquire.PhoneNoInquireProviderTransaction$querySingleNumber$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super MatrixCursor> cVar) {
        return ((PhoneNoInquireProviderTransaction$querySingleNumber$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
