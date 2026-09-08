package com.oplus.contacts.list.viewmodel;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m1.U;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ContactsMainListViewModel.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.viewmodel.ContactsMainListViewModel$providerStatusListener$1$1$1", f = "ContactsMainListViewModel.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListViewModel$providerStatusListener$1$1$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ U $providerStatusWatcher;
    int label;
    final /* synthetic */ ContactsMainListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListViewModel$providerStatusListener$1$1$1(U u10, ContactsMainListViewModel contactsMainListViewModel, c<? super ContactsMainListViewModel$providerStatusListener$1$1$1> cVar) {
        super(2, cVar);
        this.$providerStatusWatcher = u10;
        this.this$0 = contactsMainListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new ContactsMainListViewModel$providerStatusListener$1$1$1(this.$providerStatusWatcher, this.this$0, cVar);
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
            int i11 = this.$providerStatusWatcher.i();
            H7.b.e("ContactsMainListViewModel", "providerStatusListener : " + i11);
            iVar = this.this$0.f28088j;
            Integer d10 = C1467a.d(i11);
            this.label = 1;
            if (iVar.emit(d10, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((ContactsMainListViewModel$providerStatusListener$1$1$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
