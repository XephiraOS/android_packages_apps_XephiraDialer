package com.android.contacts.framework.repository;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: ContactsRepository.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.repository.ContactsRepository", f = "ContactsRepository.kt", l = {64}, m = "getPhoneEmailList")
/* loaded from: classes.dex */
public final class ContactsRepository$getPhoneEmailList$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    public ContactsRepository$getPhoneEmailList$1(c<? super ContactsRepository$getPhoneEmailList$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContactsRepository.a(null, 0L, null, null, this);
    }
}
