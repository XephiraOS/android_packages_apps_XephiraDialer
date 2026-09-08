package com.oplus.contacts.list.settings;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m9.q;
import o1.C1393c;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ContactsMainListSettingObserverImpl.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.settings.ContactsMainListSettingObserverImpl$updateOrderSetting$1", f = "ContactsMainListSettingObserverImpl.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListSettingObserverImpl$updateOrderSetting$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ ContactsMainListSettingObserverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListSettingObserverImpl$updateOrderSetting$1(ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl, kotlin.coroutines.c<? super ContactsMainListSettingObserverImpl$updateOrderSetting$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListSettingObserverImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListSettingObserverImpl$updateOrderSetting$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        i iVar;
        Object value;
        C1393c c1393c;
        C1393c c1393c2;
        C1393c c1393c3;
        a a10;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            iVar = this.this$0.f28048f;
            ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl = this.this$0;
            do {
                value = iVar.getValue();
                a aVar = (a) value;
                c1393c = contactsMainListSettingObserverImpl.f28043a;
                C1393c c1393c4 = null;
                if (c1393c == null) {
                    kotlin.jvm.internal.i.q("contactsPreferences");
                    c1393c = null;
                }
                int g10 = c1393c.g();
                c1393c2 = contactsMainListSettingObserverImpl.f28043a;
                if (c1393c2 == null) {
                    kotlin.jvm.internal.i.q("contactsPreferences");
                    c1393c2 = null;
                }
                int h10 = c1393c2.h();
                c1393c3 = contactsMainListSettingObserverImpl.f28043a;
                if (c1393c3 == null) {
                    kotlin.jvm.internal.i.q("contactsPreferences");
                } else {
                    c1393c4 = c1393c3;
                }
                a10 = aVar.a((r20 & 1) != 0 ? aVar.f28057a : 0, (r20 & 2) != 0 ? aVar.f28058b : null, (r20 & 4) != 0 ? aVar.f28059c : null, (r20 & 8) != 0 ? aVar.f28060d : null, (r20 & 16) != 0 ? aVar.f28061e : false, (r20 & 32) != 0 ? aVar.f28062f : null, (r20 & 64) != 0 ? aVar.f28063g : h10, (r20 & 128) != 0 ? aVar.f28064h : g10, (r20 & 256) != 0 ? aVar.f28065i : c1393c4.j());
                H7.b.b("ContactsMainListSettingObserverImpl", "contact order change:" + a10);
            } while (!iVar.c(value, a10));
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ContactsMainListSettingObserverImpl$updateOrderSetting$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
