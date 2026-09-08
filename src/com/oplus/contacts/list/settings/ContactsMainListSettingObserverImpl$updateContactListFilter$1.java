package com.oplus.contacts.list.settings;

import com.android.contacts.list.ContactListFilter;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m1.AbstractC1316l;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ContactsMainListSettingObserverImpl.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.settings.ContactsMainListSettingObserverImpl$updateContactListFilter$1", f = "ContactsMainListSettingObserverImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListSettingObserverImpl$updateContactListFilter$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ ContactsMainListSettingObserverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListSettingObserverImpl$updateContactListFilter$1(ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl, kotlin.coroutines.c<? super ContactsMainListSettingObserverImpl$updateContactListFilter$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListSettingObserverImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListSettingObserverImpl$updateContactListFilter$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        i iVar;
        Object value;
        AbstractC1316l abstractC1316l;
        a a10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            iVar = this.this$0.f28048f;
            ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl = this.this$0;
            do {
                value = iVar.getValue();
                a aVar = (a) value;
                abstractC1316l = contactsMainListSettingObserverImpl.f28044b;
                if (abstractC1316l == null) {
                    kotlin.jvm.internal.i.q("contactListFilterController");
                    abstractC1316l = null;
                }
                ContactListFilter e10 = abstractC1316l.e();
                a10 = aVar.a((r20 & 1) != 0 ? aVar.f28057a : e10.f16738b, (r20 & 2) != 0 ? aVar.f28058b : e10.f16740d, (r20 & 4) != 0 ? aVar.f28059c : e10.f16739c, (r20 & 8) != 0 ? aVar.f28060d : e10.f16741e, (r20 & 16) != 0 ? aVar.f28061e : e10.f16744h, (r20 & 32) != 0 ? aVar.f28062f : e10.f16743g, (r20 & 64) != 0 ? aVar.f28063g : 0, (r20 & 128) != 0 ? aVar.f28064h : 0, (r20 & 256) != 0 ? aVar.f28065i : false);
                H7.b.b("ContactsMainListSettingObserverImpl", "contact list filter change:" + a10);
            } while (!iVar.c(value, a10));
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ContactsMainListSettingObserverImpl$updateContactListFilter$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
