package com.oplus.contacts.list.settings;

import com.customize.contacts.util.U;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m1.AbstractC1316l;
import m9.q;
import o1.C1393c;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ContactsMainListSettingObserverImpl.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.settings.ContactsMainListSettingObserverImpl$initSettingData$1", f = "ContactsMainListSettingObserverImpl.kt", l = {150, 166}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListSettingObserverImpl$initSettingData$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ AbstractC1316l $contactListFilterController;
    final /* synthetic */ C1393c $contactsPreferences;
    int label;
    final /* synthetic */ ContactsMainListSettingObserverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListSettingObserverImpl$initSettingData$1(ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl, AbstractC1316l abstractC1316l, C1393c c1393c, kotlin.coroutines.c<? super ContactsMainListSettingObserverImpl$initSettingData$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListSettingObserverImpl;
        this.$contactListFilterController = abstractC1316l;
        this.$contactsPreferences = c1393c;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListSettingObserverImpl$initSettingData$1(this.this$0, this.$contactListFilterController, this.$contactsPreferences, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        i iVar;
        Object value;
        a a10;
        i iVar2;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    kotlin.b.b(obj);
                    return q.f35511a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        } else {
            kotlin.b.b(obj);
            ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl = this.this$0;
            AbstractC1316l abstractC1316l = this.$contactListFilterController;
            C1393c c1393c = this.$contactsPreferences;
            this.label = 1;
            obj = contactsMainListSettingObserverImpl.o(abstractC1316l, c1393c, this);
            if (obj == c10) {
                return c10;
            }
        }
        a aVar = (a) obj;
        iVar = this.this$0.f28048f;
        do {
            value = iVar.getValue();
            a10 = ((a) value).a(aVar.h(), aVar.c(), aVar.d(), aVar.e(), aVar.j(), aVar.f(), aVar.k(), aVar.g(), aVar.i());
            H7.b.b("ContactsMainListSettingObserverImpl", "init setting data:" + a10);
        } while (!iVar.c(value, a10));
        iVar2 = this.this$0.f28049g;
        Boolean a11 = C1467a.a(U.e(this.this$0.m()));
        this.label = 2;
        if (iVar2.emit(a11, this) == c10) {
            return c10;
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ContactsMainListSettingObserverImpl$initSettingData$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
