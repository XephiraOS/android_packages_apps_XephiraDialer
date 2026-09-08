package com.oplus.contacts.list.fragment;

import android.content.Context;
import android.os.CancellationSignal;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.InterfaceC0492o;
import com.android.contacts.framework.repository.ContactsRepository;
import com.customize.contacts.manager.n;
import com.customize.contacts.util.BlackListUtils;
import java.util.HashMap;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import p9.InterfaceC1470d;

/* compiled from: ContactsMainListFragment.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$onItemLongClick$1$1", f = "ContactsMainListFragment.kt", l = {1765}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListFragment$onItemLongClick$1$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ com.oplus.contacts.list.f $item;
    final /* synthetic */ int $touchX;
    final /* synthetic */ int $touchY;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ ContactsMainListFragment<BD> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListFragment$onItemLongClick$1$1(ContactsMainListFragment<BD> contactsMainListFragment, com.oplus.contacts.list.f fVar, View view, int i10, int i11, kotlin.coroutines.c<? super ContactsMainListFragment$onItemLongClick$1$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListFragment;
        this.$item = fVar;
        this.$view = view;
        this.$touchX = i10;
        this.$touchY = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListFragment$onItemLongClick$1$1(this.this$0, this.$item, this.$view, this.$touchX, this.$touchY, cVar);
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
            Context requireContext = this.this$0.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            long d10 = this.$item.d();
            CancellationSignal K22 = this.this$0.K2();
            final ContactsMainListFragment<BD> contactsMainListFragment = this.this$0;
            final View view = this.$view;
            final com.oplus.contacts.list.f fVar = this.$item;
            final int i11 = this.$touchX;
            final int i12 = this.$touchY;
            v9.l<ContactsRepository.a, m9.q> lVar = new v9.l<ContactsRepository.a, m9.q>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$onItemLongClick$1$1.1

                /* compiled from: ContactsMainListFragment.kt */
                @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$onItemLongClick$1$1$1$1", f = "ContactsMainListFragment.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$onItemLongClick$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes3.dex */
                public static final class C02581 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
                    final /* synthetic */ n.i $moreDialogParam;
                    int label;
                    final /* synthetic */ ContactsMainListFragment<BD> this$0;

                    /* compiled from: ContactsMainListFragment.kt */
                    /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$onItemLongClick$1$1$1$1$a */
                    /* loaded from: classes3.dex */
                    public static final class a implements n.h {

                        /* renamed from: a, reason: collision with root package name */
                        public final /* synthetic */ ContactsMainListFragment<BD> f27981a;

                        public a(ContactsMainListFragment<BD> contactsMainListFragment) {
                            this.f27981a = contactsMainListFragment;
                        }

                        @Override // com.customize.contacts.manager.n.h
                        public void a() {
                            this.f27981a.N2().notifyDataSetChanged();
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C02581(ContactsMainListFragment<BD> contactsMainListFragment, n.i iVar, kotlin.coroutines.c<? super C02581> cVar) {
                        super(2, cVar);
                        this.this$0 = contactsMainListFragment;
                        this.$moreDialogParam = iVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
                        return new C02581(this.this$0, this.$moreDialogParam, cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        kotlin.coroutines.intrinsics.b.c();
                        if (this.label == 0) {
                            kotlin.b.b(obj);
                            a aVar = new a(this.this$0);
                            Fragment fragment = this.this$0;
                            com.customize.contacts.manager.n.B(fragment, fragment.requireContext(), this.$moreDialogParam, 1, true, false, aVar);
                            return m9.q.f35511a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Override // v9.p
                    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
                        return ((C02581) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(ContactsRepository.a phoneEmailInfo) {
                    kotlin.jvm.internal.i.f(phoneEmailInfo, "phoneEmailInfo");
                    HashMap<String, Boolean> d11 = BlackListUtils.d(contactsMainListFragment.requireContext(), phoneEmailInfo.b());
                    Boolean bool = d11.get("isBlackList");
                    if (bool == null) {
                        bool = Boolean.FALSE;
                    }
                    boolean booleanValue = bool.booleanValue();
                    Boolean bool2 = d11.get("isWhiteList");
                    if (bool2 == null) {
                        bool2 = Boolean.FALSE;
                    }
                    n.i iVar = new n.i(contactsMainListFragment.M2().f37693H, view, fVar.d(), -1L, fVar.g(), fVar.h(), fVar.c(), phoneEmailInfo.b(), phoneEmailInfo.a(), booleanValue, bool2.booleanValue(), phoneEmailInfo.c(), fVar.n(), i11, i12);
                    InterfaceC0492o viewLifecycleOwner = contactsMainListFragment.getViewLifecycleOwner();
                    kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
                    C1248i.d(androidx.lifecycle.p.a(viewLifecycleOwner), S.c(), null, new C02581(contactsMainListFragment, iVar, null), 2, null);
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(ContactsRepository.a aVar) {
                    b(aVar);
                    return m9.q.f35511a;
                }
            };
            this.label = 1;
            if (ContactsRepository.a(requireContext, d10, K22, lVar, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactsMainListFragment$onItemLongClick$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
