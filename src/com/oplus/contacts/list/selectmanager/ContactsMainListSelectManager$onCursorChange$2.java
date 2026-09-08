package com.oplus.contacts.list.selectmanager;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ContactsMainListSelectManager.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.selectmanager.ContactsMainListSelectManager$onCursorChange$2", f = "ContactsMainListSelectManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListSelectManager$onCursorChange$2 extends SuspendLambda implements p<E, c<? super q>, Object> {
    int label;
    final /* synthetic */ ContactsMainListSelectManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListSelectManager$onCursorChange$2(ContactsMainListSelectManager contactsMainListSelectManager, c<? super ContactsMainListSelectManager$onCursorChange$2> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListSelectManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new ContactsMainListSelectManager$onCursorChange$2(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            this.this$0.f();
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((ContactsMainListSelectManager$onCursorChange$2) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
