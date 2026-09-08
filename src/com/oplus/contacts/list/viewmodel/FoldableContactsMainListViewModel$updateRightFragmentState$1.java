package com.oplus.contacts.list.viewmodel;

import com.oplus.contacts.list.uistate.ContactsMainListRightFragmentUiState;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import kotlinx.coroutines.flow.i;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: FoldableContactsMainListViewModel.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.viewmodel.FoldableContactsMainListViewModel$updateRightFragmentState$1", f = "FoldableContactsMainListViewModel.kt", l = {41}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FoldableContactsMainListViewModel$updateRightFragmentState$1 extends SuspendLambda implements p<E, c<? super q>, Object> {
    final /* synthetic */ ContactsMainListRightFragmentUiState $state;
    int label;
    final /* synthetic */ FoldableContactsMainListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoldableContactsMainListViewModel$updateRightFragmentState$1(ContactsMainListRightFragmentUiState contactsMainListRightFragmentUiState, FoldableContactsMainListViewModel foldableContactsMainListViewModel, c<? super FoldableContactsMainListViewModel$updateRightFragmentState$1> cVar) {
        super(2, cVar);
        this.$state = contactsMainListRightFragmentUiState;
        this.this$0 = foldableContactsMainListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<q> create(Object obj, c<?> cVar) {
        return new FoldableContactsMainListViewModel$updateRightFragmentState$1(this.$state, this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        i iVar;
        i iVar2;
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
            H7.b.b("FoldableContactsMainListViewModel", "updateRightFragmentState: state:" + this.$state);
            FoldableContactsMainListViewModel foldableContactsMainListViewModel = this.this$0;
            iVar = foldableContactsMainListViewModel.f28093n;
            foldableContactsMainListViewModel.J((ContactsMainListRightFragmentUiState) iVar.getValue());
            iVar2 = this.this$0.f28093n;
            ContactsMainListRightFragmentUiState contactsMainListRightFragmentUiState = this.$state;
            this.label = 1;
            if (iVar2.emit(contactsMainListRightFragmentUiState, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, c<? super q> cVar) {
        return ((FoldableContactsMainListViewModel$updateRightFragmentState$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
