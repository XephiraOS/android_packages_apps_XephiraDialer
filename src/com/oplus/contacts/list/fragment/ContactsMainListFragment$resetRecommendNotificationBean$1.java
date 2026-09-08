package com.oplus.contacts.list.fragment;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;

/* compiled from: ContactsMainListFragment.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$resetRecommendNotificationBean$1", f = "ContactsMainListFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListFragment$resetRecommendNotificationBean$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ com.customize.contacts.pushnotification.model.c $notificationBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListFragment$resetRecommendNotificationBean$1(com.customize.contacts.pushnotification.model.c cVar, kotlin.coroutines.c<? super ContactsMainListFragment$resetRecommendNotificationBean$1> cVar2) {
        super(2, cVar2);
        this.$notificationBean = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListFragment$resetRecommendNotificationBean$1(this.$notificationBean, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            com.customize.contacts.pushnotification.model.h a10 = com.customize.contacts.pushnotification.model.h.f21786b.a();
            if (a10 != null) {
                com.customize.contacts.pushnotification.model.c cVar = this.$notificationBean;
                com.customize.contacts.pushnotification.model.c cVar2 = null;
                if (cVar != null) {
                    str = cVar.h();
                } else {
                    str = null;
                }
                if (kotlin.jvm.internal.i.b(str, "cloud recommend")) {
                    cVar2 = this.$notificationBean;
                }
                if (cVar2 == null) {
                    cVar2 = a10.e("cloud recommend");
                }
                if (cVar2 != null) {
                    cVar2.p(-1L);
                    cVar2.o(0);
                    H7.b.e("ContactsMainListFragment", "Cloud service disabled, reset push notification.");
                    a10.f(cVar2);
                }
            }
            return m9.q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactsMainListFragment$resetRecommendNotificationBean$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
