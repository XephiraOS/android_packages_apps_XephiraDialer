package com.oplus.contacts.list.fragment;

import android.content.Context;
import com.oplus.contacts.list.viewmodel.ContactsMainListViewModel;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor.RecyclerViewScrollStateMonitor;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import m1.AbstractC1316l;
import o1.C1393c;
import p9.InterfaceC1470d;

/* compiled from: ContactsMainListFragment.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$loadContactsList$1", f = "ContactsMainListFragment.kt", l = {1123, 1125}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListFragment$loadContactsList$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ AbstractC1316l $contactsFilter;
    final /* synthetic */ C1393c $contactsPreferences;
    final /* synthetic */ Context $context;
    final /* synthetic */ RecyclerViewScrollStateMonitor $scrollStateMonitor;
    int label;
    final /* synthetic */ ContactsMainListFragment<BD> this$0;

    /* compiled from: ContactsMainListFragment.kt */
    @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$loadContactsList$1$1", f = "ContactsMainListFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$loadContactsList$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.oplus.contacts.list.settings.a $initSettingData;
        final /* synthetic */ RecyclerViewScrollStateMonitor $scrollStateMonitor;
        int label;
        final /* synthetic */ ContactsMainListFragment<BD> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContactsMainListFragment<BD> contactsMainListFragment, Context context, com.oplus.contacts.list.settings.a aVar, RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = contactsMainListFragment;
            this.$context = context;
            this.$initSettingData = aVar;
            this.$scrollStateMonitor = recyclerViewScrollStateMonitor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$context, this.$initSettingData, this.$scrollStateMonitor, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                this.this$0.S3(this.$context, this.$initSettingData, this.$scrollStateMonitor);
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
    public ContactsMainListFragment$loadContactsList$1(ContactsMainListFragment<BD> contactsMainListFragment, AbstractC1316l abstractC1316l, C1393c c1393c, Context context, RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor, kotlin.coroutines.c<? super ContactsMainListFragment$loadContactsList$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListFragment;
        this.$contactsFilter = abstractC1316l;
        this.$contactsPreferences = c1393c;
        this.$context = context;
        this.$scrollStateMonitor = recyclerViewScrollStateMonitor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListFragment$loadContactsList$1(this.this$0, this.$contactsFilter, this.$contactsPreferences, this.$context, this.$scrollStateMonitor, cVar);
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
            ContactsMainListViewModel W22 = this.this$0.W2();
            AbstractC1316l contactsFilter = this.$contactsFilter;
            kotlin.jvm.internal.i.e(contactsFilter, "contactsFilter");
            C1393c c1393c = this.$contactsPreferences;
            this.label = 1;
            obj = W22.l(contactsFilter, c1393c, this);
            if (obj == c10) {
                return c10;
            }
        }
        com.oplus.contacts.list.settings.a aVar = (com.oplus.contacts.list.settings.a) obj;
        H7.b.b("ContactsMainListFragment", "loadContactsList, settingData:" + aVar);
        w0 c11 = S.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$context, aVar, this.$scrollStateMonitor, null);
        this.label = 2;
        if (C1244g.g(c11, anonymousClass1, this) == c10) {
            return c10;
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactsMainListFragment$loadContactsList$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
