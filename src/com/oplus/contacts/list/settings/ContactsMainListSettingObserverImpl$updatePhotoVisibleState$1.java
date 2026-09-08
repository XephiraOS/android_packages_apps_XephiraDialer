package com.oplus.contacts.list.settings;

import android.content.Context;
import com.customize.contacts.util.U;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ContactsMainListSettingObserverImpl.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.settings.ContactsMainListSettingObserverImpl$updatePhotoVisibleState$1", f = "ContactsMainListSettingObserverImpl.kt", l = {141}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListSettingObserverImpl$updatePhotoVisibleState$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ ContactsMainListSettingObserverImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListSettingObserverImpl$updatePhotoVisibleState$1(ContactsMainListSettingObserverImpl contactsMainListSettingObserverImpl, Context context, kotlin.coroutines.c<? super ContactsMainListSettingObserverImpl$updatePhotoVisibleState$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListSettingObserverImpl;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListSettingObserverImpl$updatePhotoVisibleState$1(this.this$0, this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        i iVar;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            iVar = this.this$0.f28049g;
            Boolean a10 = C1467a.a(U.e(this.$context));
            this.label = 1;
            if (iVar.emit(a10, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ContactsMainListSettingObserverImpl$updatePhotoVisibleState$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
