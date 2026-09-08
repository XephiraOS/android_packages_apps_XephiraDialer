package com.oplus.contacts.list.selectmanager;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC1470d;

/* compiled from: ContactsMainListSelectManager.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.selectmanager.ContactsMainListSelectManager", f = "ContactsMainListSelectManager.kt", l = {60}, m = "onCursorChange")
/* loaded from: classes3.dex */
public final class ContactsMainListSelectManager$onCursorChange$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContactsMainListSelectManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListSelectManager$onCursorChange$1(ContactsMainListSelectManager contactsMainListSelectManager, c<? super ContactsMainListSelectManager$onCursorChange$1> cVar) {
        super(cVar);
        this.this$0 = contactsMainListSelectManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.n(null, this);
    }
}
