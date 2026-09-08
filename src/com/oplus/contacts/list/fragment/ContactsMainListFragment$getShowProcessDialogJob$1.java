package com.oplus.contacts.list.fragment;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.M;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import p9.InterfaceC1470d;

/* compiled from: ContactsMainListFragment.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$getShowProcessDialogJob$1", f = "ContactsMainListFragment.kt", l = {738, 739}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListFragment$getShowProcessDialogJob$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ ContactsMainListFragment<BD> this$0;

    /* compiled from: ContactsMainListFragment.kt */
    @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$getShowProcessDialogJob$1$1", f = "ContactsMainListFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$getShowProcessDialogJob$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
        int label;
        final /* synthetic */ ContactsMainListFragment<BD> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContactsMainListFragment<BD> contactsMainListFragment, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = contactsMainListFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                this.this$0.R3();
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListFragment$getShowProcessDialogJob$1(ContactsMainListFragment<BD> contactsMainListFragment, kotlin.coroutines.c<? super ContactsMainListFragment$getShowProcessDialogJob$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListFragment$getShowProcessDialogJob$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    kotlin.b.b(obj);
                    return m9.q.f35511a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        } else {
            kotlin.b.b(obj);
            this.label = 1;
            if (M.a(1000L, this) == c10) {
                return c10;
            }
        }
        w0 c11 = S.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (C1244g.g(c11, anonymousClass1, this) == c10) {
            return c10;
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactsMainListFragment$getShowProcessDialogJob$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
