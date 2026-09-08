package com.oplus.contacts.list.fragment;

import androidx.fragment.app.Fragment;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.util.A;
import com.oplus.contacts.list.dialog.delete.ContactsDeleteInfo;
import com.oplus.media.OplusRecorder;
import java.util.HashMap;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.coroutines.E;
import p7.C1463d;
import p9.C1467a;
import p9.InterfaceC1470d;

/* compiled from: ContactsMainListFragment.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1", f = "ContactsMainListFragment.kt", l = {698, OplusRecorder.NAMR_BYTES_P_SEC, 714}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListFragment$deleteSelectedContact$1$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ContactsMainListFragment<BD> this$0;

    /* compiled from: ContactsMainListFragment.kt */
    @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1$1", f = "ContactsMainListFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1$1, reason: invalid class name */
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
            com.oplus.contacts.list.dialog.delete.f fVar;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                Fragment m02 = this.this$0.getChildFragmentManager().m0("tag_delete_process_dialog");
                if (m02 instanceof com.oplus.contacts.list.dialog.delete.f) {
                    fVar = (com.oplus.contacts.list.dialog.delete.f) m02;
                } else {
                    fVar = null;
                }
                if (fVar == null) {
                    return null;
                }
                fVar.dismiss();
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* compiled from: ContactsMainListFragment.kt */
    @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1$2", f = "ContactsMainListFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ Ref$BooleanRef $needShowSyncTips;
        int label;
        final /* synthetic */ ContactsMainListFragment<BD> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ContactsMainListFragment<BD> contactsMainListFragment, Ref$BooleanRef ref$BooleanRef, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.this$0 = contactsMainListFragment;
            this.$needShowSyncTips = ref$BooleanRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass2(this.this$0, this.$needShowSyncTips, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                C1463d<com.oplus.contacts.list.f> value = this.this$0.W2().q().getValue();
                ContactsDeleteInfo contactsDeleteInfo = new ContactsDeleteInfo(value.a(), value.b(), this.this$0.W2().r(), this.$needShowSyncTips.element);
                if (contactsDeleteInfo.b() == contactsDeleteInfo.f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(BreenoCallContract.SummaryColumns.COUNT, C1467a.d(contactsDeleteInfo.f()));
                    A.a(this.this$0.getContext(), 2000321, 200030255, hashMap, false);
                }
                this.this$0.P3(contactsDeleteInfo);
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListFragment$deleteSelectedContact$1$1(ContactsMainListFragment<BD> contactsMainListFragment, kotlin.coroutines.c<? super ContactsMainListFragment$deleteSelectedContact$1$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListFragment$deleteSelectedContact$1$1(this.this$0, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
    
        if (r1.w() == false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.a.c()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2b
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.b.b(r8)
            goto Lcf
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1f:
            kotlin.b.b(r8)
            goto L74
        L23:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.l0 r1 = (kotlinx.coroutines.InterfaceC1265l0) r1
            kotlin.b.b(r8)
            goto L5b
        L2b:
            kotlin.b.b(r8)
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r8 = r7.this$0
            com.oplus.contacts.list.viewmodel.ContactsMainListViewModel r8 = r8.W2()
            kotlinx.coroutines.flow.m r8 = r8.q()
            java.lang.Object r8 = r8.getValue()
            p7.d r8 = (p7.C1463d) r8
            boolean r8 = r8.d()
            if (r8 == 0) goto L74
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r8 = r7.this$0
            kotlinx.coroutines.l0 r1 = com.oplus.contacts.list.fragment.ContactsMainListFragment.k2(r8)
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r8 = r7.this$0
            com.oplus.contacts.list.viewmodel.ContactsMainListViewModel r8 = r8.W2()
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = r8.w(r7)
            if (r8 != r0) goto L5b
            return r0
        L5b:
            kotlinx.coroutines.InterfaceC1265l0.a.a(r1, r5, r4, r5)
            kotlinx.coroutines.w0 r8 = kotlinx.coroutines.S.c()
            com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1$1 r1 = new com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1$1
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r6 = r7.this$0
            r1.<init>(r6, r5)
            r7.L$0 = r5
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.C1244g.g(r8, r1, r7)
            if (r8 != r0) goto L74
            return r0
        L74:
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r1 = r7.this$0
            boolean r1 = com.oplus.contacts.list.fragment.ContactsMainListFragment.n2(r1)
            if (r1 != 0) goto Lbb
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r1 = r7.this$0
            com.oplus.contacts.list.viewmodel.ContactsMainListViewModel r1 = r1.W2()
            boolean r1 = r1.i()
            if (r1 != 0) goto Lbb
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r1 = r7.this$0
            android.content.Context r1 = r1.requireContext()
            m1.l r1 = m1.AbstractC1316l.f(r1)
            com.android.contacts.list.ContactListFilter r1 = r1.e()
            boolean r1 = r1.m()
            if (r1 != 0) goto Lad
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r1 = r7.this$0
            com.oplus.contacts.list.viewmodel.ContactsMainListViewModel r1 = r1.W2()
            boolean r1 = r1.r()
            if (r1 != 0) goto Lb9
        Lad:
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r1 = r7.this$0
            com.oplus.contacts.list.cloudsync.CloudSyncViewModel r1 = com.oplus.contacts.list.fragment.ContactsMainListFragment.d2(r1)
            boolean r1 = r1.w()
            if (r1 == 0) goto Lbb
        Lb9:
            r8.element = r4
        Lbb:
            kotlinx.coroutines.w0 r1 = kotlinx.coroutines.S.c()
            com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1$2 r3 = new com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1$2
            com.oplus.contacts.list.fragment.ContactsMainListFragment<BD> r4 = r7.this$0
            r3.<init>(r4, r8, r5)
            r7.label = r2
            java.lang.Object r7 = kotlinx.coroutines.C1244g.g(r1, r3, r7)
            if (r7 != r0) goto Lcf
            return r0
        Lcf:
            m9.q r7 = m9.q.f35511a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.fragment.ContactsMainListFragment$deleteSelectedContact$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactsMainListFragment$deleteSelectedContact$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
