package com.oplus.contacts.list.viewmodel;

import android.database.Cursor;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: ContactsMainListViewModel.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.viewmodel.ContactsMainListViewModel$onLoadComplete$1", f = "ContactsMainListViewModel.kt", l = {93}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListViewModel$onLoadComplete$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ Cursor $data;
    int label;
    final /* synthetic */ ContactsMainListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListViewModel$onLoadComplete$1(ContactsMainListViewModel contactsMainListViewModel, Cursor cursor, c<? super ContactsMainListViewModel$onLoadComplete$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListViewModel;
        this.$data = cursor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new ContactsMainListViewModel$onLoadComplete$1(this.this$0, this.$data, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
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
            ContactsMainListViewModel contactsMainListViewModel = this.this$0;
            Cursor cursor = this.$data;
            this.label = 1;
            if (contactsMainListViewModel.u(cursor, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((ContactsMainListViewModel$onLoadComplete$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
