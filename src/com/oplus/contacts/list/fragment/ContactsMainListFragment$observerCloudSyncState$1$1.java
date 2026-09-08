package com.oplus.contacts.list.fragment;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.android.contacts.framework.api.cloudsync.SyncFeature;
import com.customize.contacts.pushnotification.model.PushNotificationViewModel;
import com.oplus.contacts.list.cloudsync.CloudSyncState;
import com.oplus.contacts.list.cloudsync.CloudSyncViewModel;
import com.oplus.contacts.list.fragment.ContactsMainListFragment;
import com.oplus.foundation.appsupport.ui.widget.SuitableSizeTextView;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.E;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;
import x0.AbstractC1663a;

/* compiled from: ContactsMainListFragment.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$observerCloudSyncState$1$1", f = "ContactsMainListFragment.kt", l = {919}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListFragment$observerCloudSyncState$1$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    int label;
    final /* synthetic */ ContactsMainListFragment<BD> this$0;

    /* compiled from: ContactsMainListFragment.kt */
    @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$observerCloudSyncState$1$1$1", f = "ContactsMainListFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerCloudSyncState$1$1$1, reason: invalid class name */
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
            CloudSyncViewModel L22;
            CloudSyncViewModel L23;
            CloudSyncViewModel L24;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                L22 = this.this$0.L2();
                LiveData<Boolean> u10 = L22.u();
                InterfaceC0492o viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
                final ContactsMainListFragment<BD> contactsMainListFragment = this.this$0;
                u10.i(viewLifecycleOwner, new ContactsMainListFragment.d(new v9.l<Boolean, m9.q>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment.observerCloudSyncState.1.1.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(Boolean bool) {
                        CloudSyncViewModel L25;
                        L25 = contactsMainListFragment.L2();
                        final ContactsMainListFragment<BD> contactsMainListFragment2 = contactsMainListFragment;
                        L25.A(new InterfaceC1637a<m9.q>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment.observerCloudSyncState.1.1.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // v9.InterfaceC1637a
                            public /* bridge */ /* synthetic */ m9.q invoke() {
                                invoke2();
                                return m9.q.f35511a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                CloudSyncViewModel L26;
                                PushNotificationViewModel pushNotificationViewModel;
                                PushNotificationViewModel pushNotificationViewModel2;
                                PushNotificationViewModel pushNotificationViewModel3;
                                PushNotificationViewModel pushNotificationViewModel4;
                                PushNotificationViewModel pushNotificationViewModel5;
                                if (contactsMainListFragment2.getContext() == null) {
                                    return;
                                }
                                PushNotificationViewModel pushNotificationViewModel6 = null;
                                if (!OsUtils.h()) {
                                    L26 = contactsMainListFragment2.L2();
                                    if (L26.w() || P7.e.c()) {
                                        pushNotificationViewModel = contactsMainListFragment2.f27969z;
                                        if (pushNotificationViewModel == null) {
                                            kotlin.jvm.internal.i.q("pushNotificationViewModel");
                                            pushNotificationViewModel = null;
                                        }
                                        pushNotificationViewModel.i("cloud sync");
                                    }
                                } else {
                                    boolean d10 = SyncFeature.d();
                                    if (H7.a.b()) {
                                        H7.b.b("ContactsMainListFragment", "updateCloudSyncNotification: syncSwitchOpen: " + d10);
                                    }
                                    if (!CommonOSPublicFeature.f()) {
                                        pushNotificationViewModel3 = contactsMainListFragment2.f27969z;
                                        if (pushNotificationViewModel3 == null) {
                                            kotlin.jvm.internal.i.q("pushNotificationViewModel");
                                            pushNotificationViewModel3 = null;
                                        }
                                        pushNotificationViewModel3.i("cloud recommend");
                                    } else {
                                        com.android.contacts.framework.api.cloudsync.a.d();
                                        if (C7.f.a()) {
                                            pushNotificationViewModel5 = contactsMainListFragment2.f27969z;
                                            if (pushNotificationViewModel5 == null) {
                                                kotlin.jvm.internal.i.q("pushNotificationViewModel");
                                                pushNotificationViewModel5 = null;
                                            }
                                            pushNotificationViewModel5.r("cloud recommend");
                                        } else {
                                            pushNotificationViewModel4 = contactsMainListFragment2.f27969z;
                                            if (pushNotificationViewModel4 == null) {
                                                kotlin.jvm.internal.i.q("pushNotificationViewModel");
                                                pushNotificationViewModel4 = null;
                                            }
                                            pushNotificationViewModel4.i("cloud recommend");
                                        }
                                    }
                                }
                                pushNotificationViewModel2 = contactsMainListFragment2.f27969z;
                                if (pushNotificationViewModel2 == null) {
                                    kotlin.jvm.internal.i.q("pushNotificationViewModel");
                                } else {
                                    pushNotificationViewModel6 = pushNotificationViewModel2;
                                }
                                pushNotificationViewModel6.p(true);
                                contactsMainListFragment2.D3(350L);
                            }
                        });
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                        b(bool);
                        return m9.q.f35511a;
                    }
                }));
                L23 = this.this$0.L2();
                LiveData<Boolean> q10 = L23.q();
                InterfaceC0492o viewLifecycleOwner2 = this.this$0.getViewLifecycleOwner();
                final ContactsMainListFragment<BD> contactsMainListFragment2 = this.this$0;
                q10.i(viewLifecycleOwner2, new ContactsMainListFragment.d(new v9.l<Boolean, m9.q>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment.observerCloudSyncState.1.1.1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(Boolean bool) {
                        CloudSyncViewModel L25;
                        L25 = contactsMainListFragment2.L2();
                        final ContactsMainListFragment<BD> contactsMainListFragment3 = contactsMainListFragment2;
                        L25.A(new InterfaceC1637a<m9.q>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment.observerCloudSyncState.1.1.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // v9.InterfaceC1637a
                            public /* bridge */ /* synthetic */ m9.q invoke() {
                                invoke2();
                                return m9.q.f35511a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                PushNotificationViewModel pushNotificationViewModel;
                                pushNotificationViewModel = contactsMainListFragment3.f27969z;
                                if (pushNotificationViewModel == null) {
                                    kotlin.jvm.internal.i.q("pushNotificationViewModel");
                                    pushNotificationViewModel = null;
                                }
                                pushNotificationViewModel.p(true);
                                contactsMainListFragment3.D3(350L);
                            }
                        });
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                        b(bool);
                        return m9.q.f35511a;
                    }
                }));
                L24 = this.this$0.L2();
                LiveData<CloudSyncState> t10 = L24.t();
                InterfaceC0492o viewLifecycleOwner3 = this.this$0.getViewLifecycleOwner();
                final ContactsMainListFragment<BD> contactsMainListFragment3 = this.this$0;
                t10.i(viewLifecycleOwner3, new ContactsMainListFragment.d(new v9.l<CloudSyncState, m9.q>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment.observerCloudSyncState.1.1.1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(CloudSyncState state) {
                        boolean c32;
                        kotlin.jvm.internal.i.f(state, "state");
                        H7.b.e("ContactsMainListFragment", "cloud state update " + state);
                        AbstractC1663a abstractC1663a = contactsMainListFragment3.M2().f37692G;
                        ContactsMainListFragment<BD> contactsMainListFragment4 = contactsMainListFragment3;
                        Context requireContext = contactsMainListFragment4.requireContext();
                        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
                        c32 = contactsMainListFragment4.c3(requireContext);
                        if (c32 && !(state instanceof CloudSyncState.d)) {
                            Context requireContext2 = contactsMainListFragment4.requireContext();
                            kotlin.jvm.internal.i.e(requireContext2, "requireContext()");
                            CharSequence b10 = state.b(requireContext2);
                            Integer a10 = state.a();
                            if (b10.length() == 0 || a10 == null) {
                                ImageView subtitleIcon = abstractC1663a.f37688L;
                                kotlin.jvm.internal.i.e(subtitleIcon, "subtitleIcon");
                                subtitleIcon.setVisibility(8);
                                contactsMainListFragment4.N1(contactsMainListFragment4.n());
                            } else {
                                ImageView subtitleIcon2 = abstractC1663a.f37688L;
                                kotlin.jvm.internal.i.e(subtitleIcon2, "subtitleIcon");
                                subtitleIcon2.setVisibility(0);
                                abstractC1663a.f37688L.setImageResource(a10.intValue());
                                SuitableSizeTextView subTitleView = abstractC1663a.f37686J;
                                kotlin.jvm.internal.i.e(subTitleView, "subTitleView");
                                subTitleView.setVisibility(0);
                                subTitleView.setText(b10);
                                subTitleView.setMovementMethod(LinkMovementMethod.getInstance());
                            }
                        } else {
                            ImageView subtitleIcon3 = abstractC1663a.f37688L;
                            kotlin.jvm.internal.i.e(subtitleIcon3, "subtitleIcon");
                            subtitleIcon3.setVisibility(8);
                            contactsMainListFragment4.N1(contactsMainListFragment4.n());
                        }
                        contactsMainListFragment4.D3(350L);
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ m9.q invoke(CloudSyncState cloudSyncState) {
                        b(cloudSyncState);
                        return m9.q.f35511a;
                    }
                }));
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
    public ContactsMainListFragment$observerCloudSyncState$1$1(ContactsMainListFragment<BD> contactsMainListFragment, kotlin.coroutines.c<? super ContactsMainListFragment$observerCloudSyncState$1$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListFragment$observerCloudSyncState$1$1(this.this$0, cVar);
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
            InterfaceC0492o viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(viewLifecycleOwner, state, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ContactsMainListFragment$observerCloudSyncState$1$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
