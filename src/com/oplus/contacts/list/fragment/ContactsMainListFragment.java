package com.oplus.contacts.list.fragment;

import W.c;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.fragment.app.x;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.K;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.C0543d;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.activities.GroupBrowserActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.api.cloudsync.SyncFeature;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.AiCallTranslateStateController;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.NoNetworkCommUiStateUtil;
import com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel;
import com.android.contacts.framework.baseui.widget.RecommendView;
import com.android.contacts.list.ContactListFilter;
import com.android.contacts.model.Account;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.BusinessCardCaptureActivity;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.activities.FunctionsActivity;
import com.customize.contacts.activities.ServiceNumberActivity;
import com.customize.contacts.activities.SimAccountsListActivity;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.pushnotification.model.PushNotificationViewModel;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0807s;
import com.customize.contacts.util.C0810v;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.W;
import com.customize.contacts.util.g0;
import com.customize.contacts.util.h0;
import com.customize.contacts.util.k0;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.customize.contacts.widget.TouchSearchView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.COUICollapsingToolbarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.contacts.list.ContactsMainListHeaderView;
import com.oplus.contacts.list.cloudsync.CloudSyncState;
import com.oplus.contacts.list.cloudsync.CloudSyncViewModel;
import com.oplus.contacts.list.cursorloader.ContactsMainListCursorLoader;
import com.oplus.contacts.list.dialog.delete.ContactsDeleteInfo;
import com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialog;
import com.oplus.contacts.list.viewmodel.ContactsMainListViewModel;
import com.oplus.contacts.list.widget.ContactsMainListCollapsableAppBarLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.lifecycle.FlowExtKt;
import com.oplus.foundation.appsupport.ui.widget.SuitableSizeTextView;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.DragSelectRecyclerView;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor.RecyclerViewScrollStateMonitor;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.scheduler.ThreadUtilsKt;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import f.C0991a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.S;
import m1.AbstractC1316l;
import o1.C1393c;
import p7.C1463d;
import p9.InterfaceC1470d;
import q7.C1493b;
import q7.InterfaceC1494c;
import r0.C1501d;
import s7.C1557b;
import v9.InterfaceC1637a;
import w0.C1641a;
import w7.b;
import x0.AbstractC1663a;
import x0.AbstractC1665c;

/* compiled from: ContactsMainListFragment.kt */
/* loaded from: classes3.dex */
public abstract class ContactsMainListFragment<BD extends ViewDataBinding> extends com.oplus.foundation.appsupport.ui.fragment.f<BD> implements TouchSearchView.d, ContactsMainListHeaderView.b, w7.c, w7.b, c.InterfaceC0078c<Cursor>, c.b<Cursor>, COUIStatusBarResponseUtil.StatusBarClickListener, InterfaceC1494c {

    /* renamed from: S, reason: collision with root package name */
    public static final a f27939S = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public LinearLayoutManager f27940A;

    /* renamed from: B, reason: collision with root package name */
    public com.oplus.contacts.list.selectmanager.a f27941B;

    /* renamed from: C, reason: collision with root package name */
    public ContactsMainListHeaderView f27942C;

    /* renamed from: D, reason: collision with root package name */
    public RecyclerViewScrollStateMonitor f27943D;

    /* renamed from: E, reason: collision with root package name */
    public int f27944E;

    /* renamed from: F, reason: collision with root package name */
    public int f27945F;

    /* renamed from: G, reason: collision with root package name */
    public com.oplus.contacts.list.a f27946G;

    /* renamed from: H, reason: collision with root package name */
    public final m9.d f27947H;

    /* renamed from: I, reason: collision with root package name */
    public Z3.a f27948I;

    /* renamed from: J, reason: collision with root package name */
    public CancellationSignal f27949J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f27950K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f27951L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f27952M;

    /* renamed from: N, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f27953N;

    /* renamed from: O, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f27954O;

    /* renamed from: P, reason: collision with root package name */
    public final w<Boolean> f27955P;

    /* renamed from: Q, reason: collision with root package name */
    public final ContactsMainListFragment$contactsMainListReceiver$1 f27956Q;

    /* renamed from: R, reason: collision with root package name */
    public final m9.d f27957R;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Z6.a f27958j = new Z6.a();

    /* renamed from: k, reason: collision with root package name */
    public final m9.d f27959k = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(TabActivityViewModel.class), new InterfaceC1637a<M>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final M invoke() {
            M viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            kotlin.jvm.internal.i.e(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new InterfaceC1637a<K.b>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final K.b invoke() {
            K.b defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            kotlin.jvm.internal.i.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final m9.d f27960l;

    /* renamed from: m, reason: collision with root package name */
    public final com.oplus.contacts.list.h f27961m;

    /* renamed from: n, reason: collision with root package name */
    public final C1493b f27962n;

    /* renamed from: o, reason: collision with root package name */
    public final m9.d f27963o;

    /* renamed from: p, reason: collision with root package name */
    public RecommendView f27964p;

    /* renamed from: q, reason: collision with root package name */
    public RecommendView f27965q;

    /* renamed from: r, reason: collision with root package name */
    public int f27966r;

    /* renamed from: x, reason: collision with root package name */
    public int f27967x;

    /* renamed from: y, reason: collision with root package name */
    public ContactsMainListCursorLoader f27968y;

    /* renamed from: z, reason: collision with root package name */
    public PushNotificationViewModel f27969z;

    /* compiled from: ContactsMainListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ContactsMainListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b extends RecyclerView.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactsMainListFragment<BD> f27974a;

        public b(ContactsMainListFragment<BD> contactsMainListFragment) {
            this.f27974a = contactsMainListFragment;
        }

        public final boolean a() {
            COUICollapsingToolbarLayout cOUICollapsingToolbarLayout;
            CollapsingToolbarLayout W02 = this.f27974a.W0();
            Boolean bool = null;
            if (W02 instanceof COUICollapsingToolbarLayout) {
                cOUICollapsingToolbarLayout = (COUICollapsingToolbarLayout) W02;
            } else {
                cOUICollapsingToolbarLayout = null;
            }
            if (cOUICollapsingToolbarLayout != null) {
                bool = Boolean.valueOf(cOUICollapsingToolbarLayout.isExpanded());
            }
            return kotlin.jvm.internal.i.b(bool, Boolean.FALSE);
        }

        public final boolean b(RecyclerView recyclerView) {
            if (recyclerView.computeVerticalScrollOffset() == 0 && !recyclerView.canScrollVertically(1) && !recyclerView.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            ContactsMainListCollapsableAppBarLayout contactsMainListCollapsableAppBarLayout;
            kotlin.jvm.internal.i.f(recyclerView, "recyclerView");
            if (i10 == 0) {
                if (!recyclerView.canScrollVertically(-1)) {
                    AppBarLayout a12 = this.f27974a.a1();
                    if (a12 instanceof ContactsMainListCollapsableAppBarLayout) {
                        contactsMainListCollapsableAppBarLayout = (ContactsMainListCollapsableAppBarLayout) a12;
                    } else {
                        contactsMainListCollapsableAppBarLayout = null;
                    }
                    if (contactsMainListCollapsableAppBarLayout != null) {
                        contactsMainListCollapsableAppBarLayout.c();
                    }
                }
                if (b(recyclerView) && a()) {
                    this.f27974a.B3(false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            kotlin.jvm.internal.i.f(recyclerView, "recyclerView");
            if (b(recyclerView) && a()) {
                this.f27974a.B3(false);
            }
        }
    }

    /* compiled from: ContactsMainListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactsMainListFragment<BD> f27976a;

        public c(ContactsMainListFragment<BD> contactsMainListFragment) {
            this.f27976a = contactsMainListFragment;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            ContactsMainListCollapsableAppBarLayout contactsMainListCollapsableAppBarLayout;
            kotlin.jvm.internal.i.f(v10, "v");
            AppBarLayout a12 = this.f27976a.a1();
            if (a12 instanceof ContactsMainListCollapsableAppBarLayout) {
                contactsMainListCollapsableAppBarLayout = (ContactsMainListCollapsableAppBarLayout) a12;
            } else {
                contactsMainListCollapsableAppBarLayout = null;
            }
            if (contactsMainListCollapsableAppBarLayout != null) {
                contactsMainListCollapsableAppBarLayout.setHasDivider(!A7.a.a());
            }
            AppBarLayout a13 = this.f27976a.a1();
            if (a13 != null) {
                a13.removeOnAttachStateChangeListener(this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.i.f(v10, "v");
        }
    }

    /* compiled from: ContactsMainListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class d implements w, kotlin.jvm.internal.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.l f27978a;

        public d(v9.l function) {
            kotlin.jvm.internal.i.f(function, "function");
            this.f27978a = function;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof w) || !(obj instanceof kotlin.jvm.internal.g)) {
                return false;
            }
            return kotlin.jvm.internal.i.b(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.g
        public final m9.c<?> getFunctionDelegate() {
            return this.f27978a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object obj) {
            this.f27978a.invoke(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.oplus.contacts.list.fragment.ContactsMainListFragment$contactsMainListReceiver$1] */
    public ContactsMainListFragment() {
        m9.d b10;
        m9.d b11;
        final InterfaceC1637a<Fragment> interfaceC1637a = new InterfaceC1637a<Fragment>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f27960l = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(CloudSyncViewModel.class), new InterfaceC1637a<M>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final M invoke() {
                M viewModelStore = ((N) InterfaceC1637a.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.i.e(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new InterfaceC1637a<K.b>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final K.b invoke() {
                Object invoke = InterfaceC1637a.this.invoke();
                InterfaceC0485h interfaceC0485h = invoke instanceof InterfaceC0485h ? (InterfaceC0485h) invoke : null;
                K.b defaultViewModelProviderFactory = interfaceC0485h != null ? interfaceC0485h.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                kotlin.jvm.internal.i.e(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f27961m = new com.oplus.contacts.list.h();
        this.f27962n = new C1493b();
        b10 = kotlin.a.b(new InterfaceC1637a<Integer>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$businessHallMenuTitleId$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer invoke() {
                int i10;
                if (FeatureOption.g()) {
                    i10 = com.android.contacts.framework.api.businesshall.a.d();
                } else {
                    i10 = -1;
                }
                return Integer.valueOf(i10);
            }
        });
        this.f27963o = b10;
        this.f27967x = -1;
        this.f27947H = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(ContactsMainListViewModel.class), new InterfaceC1637a<M>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final M invoke() {
                M viewModelStore = Fragment.this.requireActivity().getViewModelStore();
                kotlin.jvm.internal.i.e(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new InterfaceC1637a<K.b>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final K.b invoke() {
                K.b defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.i.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.f27952M = true;
        androidx.activity.result.b registerForActivityResult = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.contacts.list.fragment.a
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                ContactsMainListFragment.B2(ContactsMainListFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult, "registerForActivityResul…sult(it.resultCode)\n    }");
        this.f27953N = registerForActivityResult;
        androidx.activity.result.b registerForActivityResult2 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.contacts.list.fragment.e
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                ContactsMainListFragment.Z2(ContactsMainListFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult2, "registerForActivityResul…sult(it.resultCode)\n    }");
        this.f27954O = registerForActivityResult2;
        this.f27955P = new w() { // from class: com.oplus.contacts.list.fragment.f
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                ContactsMainListFragment.y3(ContactsMainListFragment.this, ((Boolean) obj).booleanValue());
            }
        };
        this.f27956Q = new BroadcastReceiver(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$contactsMainListReceiver$1

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactsMainListFragment<BD> f27977a;

            {
                this.f27977a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str;
                String str2;
                PushNotificationViewModel pushNotificationViewModel;
                String str3 = null;
                if (intent != null) {
                    str = intent.getAction();
                } else {
                    str = null;
                }
                H7.b.b("ContactsMainListFragment", "receive:" + str);
                if (intent != null) {
                    str2 = intent.getAction();
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    int hashCode = str2.hashCode();
                    if (hashCode != -801537571) {
                        if (hashCode != -322838349) {
                            if (hashCode == 47610465 && str2.equals("com.android.contacts.local.ACTION_CLOUD_OFFLINE_RECOMMENDER_CHANGED")) {
                                this.f27977a.z3();
                                String stringExtra = intent.getStringExtra("offline_Type");
                                if (stringExtra != null) {
                                    ContactsMainListFragment<BD> contactsMainListFragment = this.f27977a;
                                    H7.b.e("ContactsMainListFragment", "ConfigOfflineRecommender changed: updateOfflineRecommendView offlineType: " + stringExtra);
                                    contactsMainListFragment.D3(0L);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (str2.equals("com.oplus.contacts.DETAIL_UPDATE_DONE") && C7.e.c(intent, "notInsertVipToBlackList", false)) {
                            com.oplus.foundation.util.ui.c.b(context, R.string.oplus_not_add_to_backlist_in_vip);
                            return;
                        }
                        return;
                    }
                    if (str2.equals("com.android.contacts.local.ACTION_CLOUD_RECOMMENDER_CHANGED")) {
                        pushNotificationViewModel = this.f27977a.f27969z;
                        if (pushNotificationViewModel == null) {
                            kotlin.jvm.internal.i.q("pushNotificationViewModel");
                            pushNotificationViewModel = null;
                        }
                        com.customize.contacts.pushnotification.model.c value = pushNotificationViewModel.k().getValue();
                        if (value != null) {
                            str3 = value.h();
                        }
                        if (kotlin.jvm.internal.i.b(str3, "cloud recommend")) {
                            H7.b.e("ContactsMainListFragment", "ConfigRecommender changed: updateRecommendView.");
                            this.f27977a.a4(value);
                        }
                        if (C7.e.c(intent, "on_cloud_service_disabled", false)) {
                            this.f27977a.C3(value);
                        }
                    }
                }
            }
        };
        b11 = kotlin.a.b(new InterfaceC1637a<SharedPreferences>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$offlinePreferences$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SharedPreferences invoke() {
                return P7.a.f2961a.a().getSharedPreferences("cloud_offline", 0);
            }
        });
        this.f27957R = b11;
    }

    public static final void A3(ContactsMainListFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        RecommendView recommendView = this$0.f27965q;
        if (recommendView != null) {
            this$0.M2().f37693H.C(recommendView, false);
        }
        this$0.f27965q = null;
    }

    public static final void B2(ContactsMainListFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.r3(activityResult.d());
    }

    public static final void D2(ContactsMainListFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        InterfaceC0492o viewLifecycleOwner = this$0.getViewLifecycleOwner();
        kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
        C1248i.d(androidx.lifecycle.p.a(viewLifecycleOwner), S.b(), null, new ContactsMainListFragment$deleteSelectedContact$1$1(this$0, null), 2, null);
    }

    public static final void E3(ContactsMainListFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.Y3();
    }

    public static final void I3(ContactsMainListFragment this$0, String str, Bundle bundle) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(str, "<anonymous parameter 0>");
        kotlin.jvm.internal.i.f(bundle, "bundle");
        int i10 = bundle.getInt("key_which_btn");
        String string = bundle.getString("dialog_fragment_tag");
        if (i10 != -3) {
            if (i10 == -1 && kotlin.jvm.internal.i.b(string, "tag_count_down_dialog")) {
                this$0.A2();
                return;
            }
            return;
        }
        if (kotlin.jvm.internal.i.b(string, "tag_delete_confirm")) {
            this$0.q3((ContactsDeleteInfo) bundle.getParcelable("delete_info"));
        }
    }

    private final TabActivityViewModel U2() {
        return (TabActivityViewModel) this.f27959k.getValue();
    }

    private final void X2() {
        final Context requireContext = requireContext();
        this.f27940A = new LinearLayoutManager(this, requireContext) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$initView$1

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactsMainListFragment<BD> f27979a;

            {
                this.f27979a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.o
            public int getHeight() {
                int i10;
                int i11;
                int i12;
                int height = super.getHeight();
                i10 = this.f27979a.f27945F;
                if (height > i10) {
                    i11 = this.f27979a.f27945F;
                    H7.b.c("ContactsMainListFragment", "LinearLayoutManager getHeight " + height + " is more than screenHeight " + i11);
                    i12 = this.f27979a.f27945F;
                    return i12;
                }
                return height;
            }
        };
        HeaderFooterRecyclerView headerFooterRecyclerView = M2().f37693H;
        C1493b c1493b = this.f27962n;
        FragmentActivity requireActivity = requireActivity();
        kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
        c1493b.T0(requireActivity, headerFooterRecyclerView, this);
        LinearLayoutManager linearLayoutManager = this.f27940A;
        if (linearLayoutManager == null) {
            kotlin.jvm.internal.i.q("recyclerViewLayoutManager");
            linearLayoutManager = null;
        }
        headerFooterRecyclerView.setLayoutManager(linearLayoutManager);
        com.oplus.contacts.list.a N22 = N2();
        kotlin.jvm.internal.i.d(N22, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>");
        headerFooterRecyclerView.setAdapter(N22);
        headerFooterRecyclerView.setItemAnimator(null);
        headerFooterRecyclerView.setDragSelectListener(this);
        headerFooterRecyclerView.setFocusable(false);
        headerFooterRecyclerView.setFocusableInTouchMode(false);
        headerFooterRecyclerView.addOnScrollListener(new b(this));
        ContactTouchSearchView contactTouchSearchView = M2().f37697L;
        contactTouchSearchView.setTouchSearchActionListener(this);
        contactTouchSearchView.setTouchSearchShowListener(new TouchSearchView.e() { // from class: com.oplus.contacts.list.fragment.i
            @Override // com.customize.contacts.widget.TouchSearchView.e
            public final boolean a() {
                boolean Y22;
                Y22 = ContactsMainListFragment.Y2(ContactsMainListFragment.this);
                return Y22;
            }
        });
        AppBarLayout a12 = a1();
        if (a12 != null) {
            a12.addOnAttachStateChangeListener(new c(this));
        }
        z2();
        e4();
    }

    public static final boolean Y2(ContactsMainListFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        return this$0.getUserVisibleHint();
    }

    public static final void Z2(ContactsMainListFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.w3(activityResult.d());
    }

    public static final void Z3(ContactsMainListFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.b3()) {
            H7.b.b("ContactsMainListFragment", "updateOfflineRecommendView is forbidden cloud sync state.");
            this$0.d4(this$0.f27967x);
            this$0.W3(true);
        }
        if (this$0.N3()) {
            H7.b.b("ContactsMainListFragment", "updateOfflineRecommendView isDomestic: " + CommonOSPublicFeature.f() + "  !isCloudSyncSwitchOn()= " + (true ^ SyncFeature.d()) + " recommendView= " + this$0.f27964p);
            this$0.z3();
            return;
        }
        int i10 = this$0.R2().getInt("ignore_count", 0);
        long j10 = this$0.R2().getLong("ignore_time", 0L);
        if (i10 < 3 && System.currentTimeMillis() - j10 > 604800000) {
            com.android.contacts.framework.api.cloudsync.a.c();
        }
    }

    public static final void b4(com.customize.contacts.pushnotification.model.c cVar, ContactsMainListFragment this$0, RecommendView recommendView, View view) {
        FragmentActivity activity;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(recommendView, "$recommendView");
        String h10 = cVar.h();
        switch (h10.hashCode()) {
            case -437939055:
                if (h10.equals("cloud recommend")) {
                    PushNotificationViewModel pushNotificationViewModel = this$0.f27969z;
                    if (pushNotificationViewModel == null) {
                        kotlin.jvm.internal.i.q("pushNotificationViewModel");
                        pushNotificationViewModel = null;
                    }
                    Context requireContext = this$0.requireContext();
                    kotlin.jvm.internal.i.e(requireContext, "requireContext()");
                    pushNotificationViewModel.n(requireContext, cVar);
                    com.android.contacts.framework.api.cloudsync.a.d();
                    break;
                }
                break;
            case -373373530:
                if (h10.equals("cloud sync")) {
                    PushNotificationViewModel pushNotificationViewModel2 = this$0.f27969z;
                    if (pushNotificationViewModel2 == null) {
                        kotlin.jvm.internal.i.q("pushNotificationViewModel");
                        pushNotificationViewModel2 = null;
                    }
                    Context requireContext2 = this$0.requireContext();
                    kotlin.jvm.internal.i.e(requireContext2, "requireContext()");
                    pushNotificationViewModel2.n(requireContext2, cVar);
                    CloudSyncViewModel L22 = this$0.L2();
                    FragmentActivity requireActivity = this$0.requireActivity();
                    kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
                    L22.x(requireActivity);
                    break;
                }
                break;
            case -167176721:
                if (h10.equals("move to google") && (activity = this$0.getActivity()) != null) {
                    com.android.contacts.framework.api.togoogle.a.e(activity);
                    break;
                }
                break;
            case 1229549512:
                if (h10.equals("duplicate contacts")) {
                    PushNotificationViewModel pushNotificationViewModel3 = this$0.f27969z;
                    if (pushNotificationViewModel3 == null) {
                        kotlin.jvm.internal.i.q("pushNotificationViewModel");
                        pushNotificationViewModel3 = null;
                    }
                    Context requireContext3 = this$0.requireContext();
                    kotlin.jvm.internal.i.e(requireContext3, "requireContext()");
                    pushNotificationViewModel3.n(requireContext3, cVar);
                    Intent intent = new Intent(this$0.requireContext(), (Class<?>) FunctionsActivity.class);
                    intent.putExtra("notification_string_id", cVar.h());
                    R7.b.f(this$0.requireContext(), intent, 0, null, 6, null);
                    break;
                }
                break;
        }
        this$0.M2().f37693H.C(recommendView, true);
        Context requireContext4 = this$0.requireContext();
        kotlin.jvm.internal.i.e(requireContext4, "requireContext()");
        h0.V(requireContext4, cVar.h(), AFConstants.EXTRA_INTENT_ACTION, cVar.b());
        this$0.f27964p = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (r7.equals("cloud sync") != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0021, code lost:
    
        if (r7.equals("duplicate contacts") == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x003b, code lost:
    
        r7 = r5.f27969z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003d, code lost:
    
        if (r7 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
    
        kotlin.jvm.internal.i.q("pushNotificationViewModel");
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0043, code lost:
    
        r0 = r5.requireContext();
        kotlin.jvm.internal.i.e(r0, "requireContext()");
        r7.o(r0, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c4(com.customize.contacts.pushnotification.model.c r4, com.oplus.contacts.list.fragment.ContactsMainListFragment r5, com.android.contacts.framework.baseui.widget.RecommendView r6, android.view.View r7) {
        /*
            java.lang.String r7 = "this$0"
            kotlin.jvm.internal.i.f(r5, r7)
            java.lang.String r7 = "$recommendView"
            kotlin.jvm.internal.i.f(r6, r7)
            java.lang.String r7 = r4.h()
            int r0 = r7.hashCode()
            java.lang.String r1 = "pushNotificationViewModel"
            java.lang.String r2 = "requireContext()"
            r3 = 0
            switch(r0) {
                case -437939055: goto L4e;
                case -373373530: goto L33;
                case -167176721: goto L24;
                case 1229549512: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L6c
        L1b:
            java.lang.String r0 = "duplicate contacts"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L3b
            goto L6c
        L24:
            java.lang.String r0 = "move to google"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L2d
            goto L6c
        L2d:
            com.android.contacts.framework.api.togoogle.a r7 = com.android.contacts.framework.api.togoogle.a.f15622a
            r7.a()
            goto L6c
        L33:
            java.lang.String r0 = "cloud sync"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L6c
        L3b:
            com.customize.contacts.pushnotification.model.PushNotificationViewModel r7 = r5.f27969z
            if (r7 != 0) goto L43
            kotlin.jvm.internal.i.q(r1)
            r7 = r3
        L43:
            android.content.Context r0 = r5.requireContext()
            kotlin.jvm.internal.i.e(r0, r2)
            r7.o(r0, r4)
            goto L6c
        L4e:
            java.lang.String r0 = "cloud recommend"
            boolean r7 = r7.equals(r0)
            if (r7 != 0) goto L57
            goto L6c
        L57:
            com.customize.contacts.pushnotification.model.PushNotificationViewModel r7 = r5.f27969z
            if (r7 != 0) goto L5f
            kotlin.jvm.internal.i.q(r1)
            r7 = r3
        L5f:
            android.content.Context r0 = r5.requireContext()
            kotlin.jvm.internal.i.e(r0, r2)
            r7.o(r0, r4)
            com.android.contacts.framework.api.cloudsync.a.d()
        L6c:
            x0.c r7 = r5.M2()
            com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView r7 = r7.f37693H
            r0 = 1
            r7.C(r6, r0)
            android.content.Context r6 = r5.requireContext()
            kotlin.jvm.internal.i.e(r6, r2)
            java.lang.String r7 = r4.h()
            java.lang.String r0 = "ignore"
            int r4 = r4.b()
            com.customize.contacts.util.h0.V(r6, r7, r0, r4)
            r5.f27964p = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.fragment.ContactsMainListFragment.c4(com.customize.contacts.pushnotification.model.c, com.oplus.contacts.list.fragment.ContactsMainListFragment, com.android.contacts.framework.baseui.widget.RecommendView, android.view.View):void");
    }

    public static final void i3(ContactsMainListFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (com.android.contacts.framework.api.cloudsync.a.g()) {
            H7.b.e("ContactsMainListFragment", "observeCloudSync");
            InterfaceC0492o viewLifecycleOwner = this$0.getViewLifecycleOwner();
            kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
            C1248i.d(androidx.lifecycle.p.a(viewLifecycleOwner), null, null, new ContactsMainListFragment$observerCloudSyncState$1$1(this$0, null), 3, null);
        }
    }

    public static final void x3(ContactsMainListFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        A.a(this$0.requireContext(), 2000303, 200030288, null, false);
        Intent intent = new Intent();
        intent.setAction(k0.f22138b);
        intent.putExtra("start_from_callLog", true);
        String c10 = com.android.contacts.framework.api.appstore.appinfo.a.c();
        if (c10.length() > 0) {
            intent.setPackage(c10);
        }
        R7.b.f(this$0.requireContext(), intent, 0, null, 6, null);
        h0.Z(this$0.requireContext(), "block_filter", "contact");
    }

    public static final void y3(ContactsMainListFragment this$0, boolean z10) {
        String str;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (z10) {
            str = "show_photo";
        } else {
            str = "hide_photo";
        }
        if (this$0.M2().f37693H.isComputingLayout()) {
            return;
        }
        this$0.N2().notifyItemRangeChanged(0, this$0.N2().getItemCount(), str);
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.f, com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment
    public boolean A1(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        int itemId = item.getItemId();
        if (itemId != R.id.cancel) {
            if (itemId != R.id.menu_contacts_search) {
                if (itemId != R.id.select_all) {
                    return super.A1(item);
                }
                if (a3()) {
                    W2().t(!W2().q().getValue().c());
                    if (M2().f37693H.isComputingLayout()) {
                        return true;
                    }
                    N2().notifyItemRangeChanged(0, N2().getItemCount(), "selection_change");
                }
                return true;
            }
            T3();
            h0.Z(getActivity(), "search_icon", "contact");
            return true;
        }
        if (a3()) {
            requireActivity().onBackPressed();
        }
        return true;
    }

    public final void A2() {
        List<IdRecord> p10 = W2().p();
        if (p10.isEmpty()) {
            return;
        }
        C0810v.g(p10);
        Intent intent = new Intent("com.oplus.contacts.proc.DELETE_SELECTED_PHONE_SIM_CONTACTS");
        intent.setPackage(C7.e.g());
        try {
            this.f27953N.a(intent);
            G2(true);
        } catch (ActivityNotFoundException e10) {
            H7.b.c("ContactsMainListFragment", "e = " + e10);
            G2(true);
        }
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment
    public void B1(boolean z10) {
        V3(z10);
        if (!z10) {
            M2().f37697L.r();
            E2();
        }
        M2().f37693H.setDisallowReceiveTouchEvent(!z10);
    }

    public final void B3(boolean z10) {
        ContactsMainListCollapsableAppBarLayout contactsMainListCollapsableAppBarLayout;
        AppBarLayout a12 = a1();
        if (a12 instanceof ContactsMainListCollapsableAppBarLayout) {
            contactsMainListCollapsableAppBarLayout = (ContactsMainListCollapsableAppBarLayout) a12;
        } else {
            contactsMainListCollapsableAppBarLayout = null;
        }
        if (contactsMainListCollapsableAppBarLayout != null) {
            contactsMainListCollapsableAppBarLayout.c();
        }
        AppBarLayout a13 = a1();
        if (a13 != null) {
            a13.setExpanded(true, z10);
        }
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, r7.InterfaceC1512a
    public String C0() {
        String string = getString(R.string.oplus_contacts_label);
        kotlin.jvm.internal.i.e(string, "getString(R.string.oplus_contacts_label)");
        return string;
    }

    public final void C2() {
        com.android.contacts.framework.api.cloudsync.a.a("ContactsMainListFragment deleteSelectedContact", androidx.lifecycle.p.a(this), new Runnable() { // from class: com.oplus.contacts.list.fragment.d
            @Override // java.lang.Runnable
            public final void run() {
                ContactsMainListFragment.D2(ContactsMainListFragment.this);
            }
        });
    }

    public final void C3(com.customize.contacts.pushnotification.model.c cVar) {
        C1248i.d(androidx.lifecycle.p.a(this), S.b(), null, new ContactsMainListFragment$resetRecommendNotificationBean$1(cVar, null), 2, null);
    }

    public final void D3(long j10) {
        ThreadUtilsKt.c(new Runnable() { // from class: com.oplus.contacts.list.fragment.h
            @Override // java.lang.Runnable
            public final void run() {
                ContactsMainListFragment.E3(ContactsMainListFragment.this);
            }
        }, j10);
    }

    public final void E2() {
        DeleteConfirmCountDownDialog deleteConfirmCountDownDialog;
        com.oplus.contacts.list.dialog.delete.e eVar;
        Fragment m02 = getChildFragmentManager().m0("tag_count_down_dialog");
        com.oplus.contacts.list.dialog.delete.f fVar = null;
        if (m02 instanceof DeleteConfirmCountDownDialog) {
            deleteConfirmCountDownDialog = (DeleteConfirmCountDownDialog) m02;
        } else {
            deleteConfirmCountDownDialog = null;
        }
        if (deleteConfirmCountDownDialog != null) {
            deleteConfirmCountDownDialog.dismiss();
        }
        Fragment m03 = getChildFragmentManager().m0("tag_delete_confirm");
        if (m03 instanceof com.oplus.contacts.list.dialog.delete.e) {
            eVar = (com.oplus.contacts.list.dialog.delete.e) m03;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            eVar.dismiss();
        }
        Fragment m04 = getChildFragmentManager().m0("tag_delete_process_dialog");
        if (m04 instanceof com.oplus.contacts.list.dialog.delete.f) {
            fVar = (com.oplus.contacts.list.dialog.delete.f) m04;
        }
        if (fVar != null) {
            fVar.dismiss();
        }
    }

    public void F2() {
        U2().n(2);
        W2().E(true);
    }

    public final void F3(int i10) {
        COUICollapsingToolbarLayout cOUICollapsingToolbarLayout;
        AppBarLayout a12;
        if (i10 >= 0) {
            LinearLayoutManager linearLayoutManager = null;
            if (M2().f37693H.canScrollVertically(1)) {
                CollapsingToolbarLayout W02 = W0();
                if (W02 instanceof COUICollapsingToolbarLayout) {
                    cOUICollapsingToolbarLayout = (COUICollapsingToolbarLayout) W02;
                } else {
                    cOUICollapsingToolbarLayout = null;
                }
                if (cOUICollapsingToolbarLayout != null && !cOUICollapsingToolbarLayout.isCollapsed() && (a12 = a1()) != null) {
                    a12.setExpanded(false, true);
                }
            }
            LinearLayoutManager linearLayoutManager2 = this.f27940A;
            if (linearLayoutManager2 == null) {
                kotlin.jvm.internal.i.q("recyclerViewLayoutManager");
            } else {
                linearLayoutManager = linearLayoutManager2;
            }
            linearLayoutManager.scrollToPositionWithOffset(i10, -M2().f37693H.getPaddingTop());
        }
    }

    public void G2(boolean z10) {
        U2().n(0);
        W2().E(false);
        W2().B();
    }

    public final void G3(Z3.a aVar) {
        this.f27948I = aVar;
    }

    @Override // w7.c
    public boolean H(View view, int i10, int i11, int i12) {
        com.oplus.contacts.list.f fVar;
        kotlin.jvm.internal.i.f(view, "view");
        if (!a3()) {
            CancellationSignal cancellationSignal = this.f27949J;
            if (cancellationSignal != null) {
                cancellationSignal.cancel();
            }
            this.f27949J = new CancellationSignal();
            Object tag = view.getTag(R.id.tag_contact_main_list_item_info);
            if (tag instanceof com.oplus.contacts.list.f) {
                fVar = (com.oplus.contacts.list.f) tag;
            } else {
                fVar = null;
            }
            com.oplus.contacts.list.f fVar2 = fVar;
            if (fVar2 != null) {
                InterfaceC0492o viewLifecycleOwner = getViewLifecycleOwner();
                kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
                C1248i.d(androidx.lifecycle.p.a(viewLifecycleOwner), S.b(), null, new ContactsMainListFragment$onItemLongClick$1$1(this, fVar2, view, i11, i12, null), 2, null);
                return true;
            }
            return false;
        }
        return false;
    }

    public final void H2(CharSequence charSequence) {
        F3(S2(charSequence));
    }

    public final void H3() {
        getChildFragmentManager().B1("request_key_dialog_btn_click", this, new x() { // from class: com.oplus.contacts.list.fragment.g
            @Override // androidx.fragment.app.x
            public final void a(String str, Bundle bundle) {
                ContactsMainListFragment.I3(ContactsMainListFragment.this, str, bundle);
            }
        });
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, r7.InterfaceC1515d
    public void I0(int i10) {
        int dimensionPixelSize;
        if (!isAdded()) {
            return;
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.toolbar_title_init_height);
        ViewGroup X02 = X0();
        if (X02 != null) {
            dimensionPixelSize = X02.getHeight();
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.DP_24);
        }
        this.f27944E = dimensionPixelSize2 + dimensionPixelSize + getResources().getDimensionPixelSize(R.dimen.contact_bottom_tab_height);
        X3();
    }

    public final Z3.a I2() {
        return this.f27948I;
    }

    public final int J2() {
        return ((Number) this.f27963o.getValue()).intValue();
    }

    public final void J3(com.oplus.contacts.list.a aVar) {
        kotlin.jvm.internal.i.f(aVar, "<set-?>");
        this.f27946G = aVar;
    }

    @Override // w7.b
    public void K(int i10, int i11, List<? extends View> touchViews) {
        kotlin.jvm.internal.i.f(touchViews, "touchViews");
        Iterator<T> it = touchViews.iterator();
        while (it.hasNext()) {
            t3((View) it.next());
        }
    }

    public final CancellationSignal K2() {
        return this.f27949J;
    }

    public void K3(Context context, boolean z10) {
        this.f27958j.b(context, z10);
    }

    public final CloudSyncViewModel L2() {
        return (CloudSyncViewModel) this.f27960l.getValue();
    }

    public final void L3(boolean z10) {
        this.f27950K = z10;
    }

    public abstract AbstractC1665c M2();

    public final void M3(RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor) {
        kotlin.jvm.internal.i.f(recyclerViewScrollStateMonitor, "<set-?>");
        this.f27943D = recyclerViewScrollStateMonitor;
    }

    public final com.oplus.contacts.list.a N2() {
        com.oplus.contacts.list.a aVar = this.f27946G;
        if (aVar != null) {
            return aVar;
        }
        kotlin.jvm.internal.i.q("contactsListAdapter");
        return null;
    }

    public final boolean N3() {
        if (getContext() != null && !CommonOSPublicFeature.f() && SyncFeature.d() && this.f27964p == null) {
            com.android.contacts.framework.api.cloudsync.a.c();
            return false;
        }
        return true;
    }

    @Override // com.oplus.contacts.list.ContactsMainListHeaderView.b
    public void O0() {
        if (FeatureOption.o()) {
            boolean k10 = com.android.contacts.util.w.k(getContext(), "android.permission.READ_PHONE_NUMBERS");
            H7.b.e("ContactsMainListFragment", "hasPermission = " + k10);
            if (!k10) {
                androidx.core.app.a.q(requireActivity(), new String[]{"android.permission.READ_PHONE_NUMBERS"}, 1);
                return;
            }
        }
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        if (W.c(requireContext) == null) {
            h0.A(requireContext, "edit_my_information");
            Intent intent = new Intent(requireContext, (Class<?>) ContactEditorActivity.class);
            intent.setAction("android.intent.action.INSERT");
            intent.putExtra("newLocalProfile", true);
            W.d(requireContext, intent);
            R7.b.f(requireContext, intent, 0, null, 6, null);
            C0636a.a(requireActivity());
            return;
        }
        h0.A(requireContext, "my_information");
        Intent intent2 = new Intent(requireContext, (Class<?>) CallDetailActivity.class);
        intent2.setData(W.b());
        R7.b.f(requireContext, intent2, 0, null, 6, null);
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.f
    public boolean O1(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (item.getItemId() == R.id.menu_contacts_more) {
            return true;
        }
        return false;
    }

    public final ContactsTabActivity O2() {
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof ContactsTabActivity)) {
            return (ContactsTabActivity) activity;
        }
        return null;
    }

    public final void O3() {
        DeleteConfirmCountDownDialog deleteConfirmCountDownDialog;
        Fragment m02 = getChildFragmentManager().m0("tag_count_down_dialog");
        if (m02 instanceof DeleteConfirmCountDownDialog) {
            deleteConfirmCountDownDialog = (DeleteConfirmCountDownDialog) m02;
        } else {
            deleteConfirmCountDownDialog = null;
        }
        if (deleteConfirmCountDownDialog == null) {
            DeleteConfirmCountDownDialog.f27908d.a(3).show(getChildFragmentManager(), "tag_count_down_dialog");
        }
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.f
    public void P1() {
        h0.Z(getActivity(), "more_icon", "contact");
    }

    public final ContactsMainListHeaderView P2() {
        ContactsMainListHeaderView contactsMainListHeaderView = this.f27942C;
        if (contactsMainListHeaderView == null) {
            kotlin.jvm.internal.i.q("headerView");
            return null;
        }
        return contactsMainListHeaderView;
    }

    public final void P3(ContactsDeleteInfo contactsDeleteInfo) {
        com.oplus.contacts.list.dialog.delete.e eVar;
        Fragment m02 = getChildFragmentManager().m0("tag_delete_confirm");
        if (m02 instanceof com.oplus.contacts.list.dialog.delete.e) {
            eVar = (com.oplus.contacts.list.dialog.delete.e) m02;
        } else {
            eVar = null;
        }
        if (eVar == null) {
            com.oplus.contacts.list.dialog.delete.e.f27921b.a(contactsDeleteInfo).show(getChildFragmentManager(), "tag_delete_confirm");
        }
    }

    public final boolean Q2() {
        return this.f27950K;
    }

    public void Q3(int i10, String tag, boolean z10) {
        kotlin.jvm.internal.i.f(tag, "tag");
        if (i10 == -1) {
            return;
        }
        if (i10 != 2 && i10 != 1) {
            FrameLayout frameLayout = M2().f37694I;
            kotlin.jvm.internal.i.e(frameLayout, "contactMainListBinding.emptyFragmentContainer");
            if (frameLayout.getVisibility() == 0) {
                Fragment m02 = getChildFragmentManager().m0(tag);
                if (m02 != null) {
                    FragmentManager childFragmentManager = getChildFragmentManager();
                    kotlin.jvm.internal.i.e(childFragmentManager, "childFragmentManager");
                    com.oplus.foundation.appsupport.ui.fragment.e.d(childFragmentManager, m02, 0, 0, 6, null);
                }
                FrameLayout frameLayout2 = M2().f37694I;
                kotlin.jvm.internal.i.e(frameLayout2, "contactMainListBinding.emptyFragmentContainer");
                frameLayout2.setVisibility(8);
                return;
            }
            return;
        }
        FrameLayout frameLayout3 = M2().f37694I;
        kotlin.jvm.internal.i.e(frameLayout3, "contactMainListBinding.emptyFragmentContainer");
        if (frameLayout3.getVisibility() != 0) {
            FrameLayout frameLayout4 = M2().f37694I;
            kotlin.jvm.internal.i.e(frameLayout4, "contactMainListBinding.emptyFragmentContainer");
            frameLayout4.setVisibility(0);
        }
        Fragment m03 = getChildFragmentManager().m0(tag);
        if (m03 == null) {
            m03 = new ImportContactsTipsFragment();
        }
        FragmentManager childFragmentManager2 = getChildFragmentManager();
        kotlin.jvm.internal.i.e(childFragmentManager2, "childFragmentManager");
        com.oplus.foundation.appsupport.ui.fragment.e.f(childFragmentManager2, R.id.empty_fragment_container, m03, tag, 0, 0, 24, null);
    }

    @Override // com.oplus.contacts.list.ContactsMainListHeaderView.b
    public void R() {
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        A.a(requireContext, 2000308, 200030040, null, false);
        Intent intent = new Intent();
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.setClass(requireContext, GroupBrowserActivity.class);
        R7.b.f(requireContext, intent, 0, null, 6, null);
    }

    @Override // q7.InterfaceC1494c
    public void R0() {
        B3(true);
    }

    public final SharedPreferences R2() {
        Object value = this.f27957R.getValue();
        kotlin.jvm.internal.i.e(value, "<get-offlinePreferences>(...)");
        return (SharedPreferences) value;
    }

    public final void R3() {
        com.oplus.contacts.list.dialog.delete.f fVar;
        Fragment m02 = getChildFragmentManager().m0("tag_delete_process_dialog");
        if (m02 instanceof com.oplus.contacts.list.dialog.delete.f) {
            fVar = (com.oplus.contacts.list.dialog.delete.f) m02;
        } else {
            fVar = null;
        }
        if (fVar == null) {
            new com.oplus.contacts.list.dialog.delete.f().show(getChildFragmentManager(), "tag_delete_process_dialog");
        }
    }

    public final int S2(CharSequence charSequence) {
        if (charSequence == null) {
            return -1;
        }
        int headersCount = M2().f37693H.getHeadersCount();
        if (U7.e.c(charSequence)) {
            return headersCount;
        }
        String obj = charSequence.toString();
        String[] sections = N2().getSections();
        int length = sections.length;
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                if (kotlin.jvm.internal.i.b(sections[i10], obj)) {
                    break;
                }
                i10++;
            } else {
                i10 = -1;
                break;
            }
        }
        if (i10 < 0) {
            return -1;
        }
        return N2().getPositionForSection(i10) + headersCount;
    }

    public final void S3(Context context, com.oplus.contacts.list.settings.a aVar, RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor) {
        int i10 = this.f27966r;
        this.f27966r = i10 + 1;
        H7.b.b("ContactsMainListFragment", "startLoadContactsList:" + i10);
        ContactsMainListCursorLoader contactsMainListCursorLoader = this.f27968y;
        if (contactsMainListCursorLoader != null) {
            contactsMainListCursorLoader.b();
        }
        ContactsMainListCursorLoader contactsMainListCursorLoader2 = this.f27968y;
        if (contactsMainListCursorLoader2 != null) {
            contactsMainListCursorLoader2.w();
        }
        this.f27968y = null;
        ContactsMainListCursorLoader contactsMainListCursorLoader3 = new ContactsMainListCursorLoader(context, aVar, recyclerViewScrollStateMonitor);
        contactsMainListCursorLoader3.u(i10, this);
        contactsMainListCursorLoader3.v(this);
        contactsMainListCursorLoader3.y();
        this.f27968y = contactsMainListCursorLoader3;
    }

    @Override // w7.b
    public void T() {
        b.a.a(this);
    }

    public final RecyclerViewScrollStateMonitor T2() {
        RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor = this.f27943D;
        if (recyclerViewScrollStateMonitor != null) {
            return recyclerViewScrollStateMonitor;
        }
        kotlin.jvm.internal.i.q("scrollStateMonitor");
        return null;
    }

    public void T3() {
        Intent intent = new Intent("com.android.contacts.action.SEARCH");
        intent.setPackage(requireContext().getPackageName());
        startActivity(intent);
        requireActivity().overridePendingTransition(R.anim.search_enter, R.anim.anim_no);
    }

    @Override // s7.InterfaceC1556a
    public List<C1557b> U() {
        int i10;
        boolean z10;
        int i11;
        ArrayList arrayList = new ArrayList();
        if (W2().x()) {
            arrayList.add(new C1557b(R.id.pop_menu_edit, null, getString(R.string.oplus_menu_edit), !U2().k()));
        }
        if (kotlin.jvm.internal.i.b(NoNetworkCommUiStateUtil.i().getValue(), Boolean.TRUE)) {
            if (C0811w.f()) {
                i11 = R.string.no_network_title_v2_rlm;
            } else {
                i11 = R.string.no_network_title_v2;
            }
            arrayList.add(new C1557b(R.id.pop_menu_no_network, null, getString(i11), PrimaryUserUtils.a()));
        }
        if (!B3.a.q(requireContext())) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                z10 = activity.isInMultiWindowMode();
            } else {
                z10 = false;
            }
            arrayList.add(new C1557b(R.id.pop_menu_card_scan, null, getString(R.string.scan_business_card_description), !z10));
        }
        if (!B3.a.m() && CommonFeatureOption.j() && !VirtualSupportUtils.m() && com.android.contacts.framework.api.appstore.appinfo.a.f15529a.l()) {
            arrayList.add(new C1557b(R.id.pop_menu_block_filter, null, getString(R.string.oplus_black_list), PrimaryUserUtils.a()));
        }
        arrayList.add(new C1557b(R.id.pop_menu_contact_management, null, getString(R.string.menu_contact_manage), PrimaryUserUtils.a()));
        if (J2() > 0 && !com.android.contacts.framework.baseui.util.m.a(requireContext())) {
            arrayList.add(new C1557b(R.id.pop_menu_business_hall, null, getString(J2()), PrimaryUserUtils.a()));
        }
        if (CommonFeatureOption.j()) {
            C1557b c1557b = new C1557b(R.id.pop_menu_settings, null, getString(R.string.oplus_button_set), PrimaryUserUtils.a());
            if (AiCallTranslateStateController.f15829b.a().f(P7.a.f2961a.a())) {
                i10 = 0;
            } else {
                i10 = -1;
            }
            c1557b.setRedDotAmount(i10);
            c1557b.setHintType(0);
            arrayList.add(c1557b);
        }
        if (C1641a.x(requireContext())) {
            arrayList.add(new C1557b(R.id.pop_menu_sdn_number, null, getString(R.string.oplus_sdn_serviceNumber), true));
        }
        if (B3.a.s(requireContext())) {
            arrayList.add(new C1557b(R.id.pop_menu_rcs_group_chat, null, getString(R.string.oplus_rcs_group_chat), true));
        }
        return arrayList;
    }

    public void U3(Context context, boolean z10) {
        this.f27958j.c(context, z10);
    }

    public final InterfaceC1265l0 V2() {
        InterfaceC1265l0 d10;
        InterfaceC0492o viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
        d10 = C1248i.d(androidx.lifecycle.p.a(viewLifecycleOwner), S.b(), null, new ContactsMainListFragment$getShowProcessDialogJob$1(this, null), 2, null);
        return d10;
    }

    public final void V3(boolean z10) {
        if (z10) {
            U3(getContext(), e3());
        }
    }

    public ContactsMainListViewModel W2() {
        return (ContactsMainListViewModel) this.f27947H.getValue();
    }

    public final void W3(boolean z10) {
        PushNotificationViewModel pushNotificationViewModel = null;
        if (OsUtils.h()) {
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            if (c3(requireContext) && CommonOSPublicFeature.f() && C7.f.a()) {
                PushNotificationViewModel pushNotificationViewModel2 = this.f27969z;
                if (pushNotificationViewModel2 == null) {
                    kotlin.jvm.internal.i.q("pushNotificationViewModel");
                    pushNotificationViewModel2 = null;
                }
                pushNotificationViewModel2.r("cloud recommend");
            } else {
                PushNotificationViewModel pushNotificationViewModel3 = this.f27969z;
                if (pushNotificationViewModel3 == null) {
                    kotlin.jvm.internal.i.q("pushNotificationViewModel");
                    pushNotificationViewModel3 = null;
                }
                pushNotificationViewModel3.i("cloud recommend");
            }
        } else {
            Context requireContext2 = requireContext();
            kotlin.jvm.internal.i.e(requireContext2, "requireContext()");
            if (c3(requireContext2)) {
                PushNotificationViewModel pushNotificationViewModel4 = this.f27969z;
                if (pushNotificationViewModel4 == null) {
                    kotlin.jvm.internal.i.q("pushNotificationViewModel");
                    pushNotificationViewModel4 = null;
                }
                pushNotificationViewModel4.r("cloud sync");
            } else {
                PushNotificationViewModel pushNotificationViewModel5 = this.f27969z;
                if (pushNotificationViewModel5 == null) {
                    kotlin.jvm.internal.i.q("pushNotificationViewModel");
                    pushNotificationViewModel5 = null;
                }
                pushNotificationViewModel5.i("cloud sync");
            }
        }
        if (z10) {
            PushNotificationViewModel pushNotificationViewModel6 = this.f27969z;
            if (pushNotificationViewModel6 == null) {
                kotlin.jvm.internal.i.q("pushNotificationViewModel");
            } else {
                pushNotificationViewModel = pushNotificationViewModel6;
            }
            pushNotificationViewModel.p(true);
        }
    }

    public final void X3() {
        int dimensionPixelSize;
        if (requireActivity().isInMultiWindowMode()) {
            int e10 = DisplayUtil.e(getContext(), false);
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            int g10 = (DisplayUtil.g(requireContext) * 2) + getResources().getDimensionPixelSize(R.dimen.coui_appbar_title_expanded_height);
            ViewGroup X02 = X0();
            if (X02 != null) {
                dimensionPixelSize = X02.getHeight();
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.DP_24);
            }
            if (e10 < g10 + dimensionPixelSize + getResources().getDimensionPixelSize(R.dimen.contact_bottom_tab_height) + M2().f37693H.getPaddingTop() + DisplayUtil.d(getContext())) {
                HeaderFooterRecyclerView headerFooterRecyclerView = M2().f37693H;
                kotlin.jvm.internal.i.e(headerFooterRecyclerView, "contactMainListBinding.contactsMainListView");
                headerFooterRecyclerView.setPadding(headerFooterRecyclerView.getPaddingLeft(), headerFooterRecyclerView.getPaddingTop(), headerFooterRecyclerView.getPaddingRight(), getResources().getDimensionPixelSize(R.dimen.contact_bottom_tab_height));
                return;
            }
            HeaderFooterRecyclerView headerFooterRecyclerView2 = M2().f37693H;
            kotlin.jvm.internal.i.e(headerFooterRecyclerView2, "contactMainListBinding.contactsMainListView");
            headerFooterRecyclerView2.setPadding(headerFooterRecyclerView2.getPaddingLeft(), headerFooterRecyclerView2.getPaddingTop(), headerFooterRecyclerView2.getPaddingRight(), this.f27944E);
            return;
        }
        if (M2().f37693H.getPaddingBottom() != this.f27944E) {
            HeaderFooterRecyclerView headerFooterRecyclerView3 = M2().f37693H;
            kotlin.jvm.internal.i.e(headerFooterRecyclerView3, "contactMainListBinding.contactsMainListView");
            headerFooterRecyclerView3.setPadding(headerFooterRecyclerView3.getPaddingLeft(), headerFooterRecyclerView3.getPaddingTop(), headerFooterRecyclerView3.getPaddingRight(), this.f27944E);
        }
    }

    public final void Y3() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.contacts.list.fragment.b
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsMainListFragment.Z3(ContactsMainListFragment.this);
                }
            });
        }
    }

    @Override // w7.b
    public boolean Z0(View view, int i10) {
        kotlin.jvm.internal.i.f(view, "view");
        return t3(view);
    }

    public final boolean a3() {
        return W2().n().getValue().booleanValue();
    }

    public final void a4(final com.customize.contacts.pushnotification.model.c cVar) {
        RecommendView recommendView;
        if (cVar != null) {
            if (this.f27964p == null) {
                View inflate = getLayoutInflater().inflate(R.layout.recommend_view, (ViewGroup) null);
                if (inflate instanceof RecommendView) {
                    recommendView = (RecommendView) inflate;
                } else {
                    recommendView = null;
                }
                this.f27964p = recommendView;
            } else {
                H7.b.i("ContactsMainListFragment", "recommend view is showing, but notification updated:" + cVar);
            }
            final RecommendView recommendView2 = this.f27964p;
            if (recommendView2 != null) {
                com.customize.contacts.pushnotification.model.i a10 = com.customize.contacts.pushnotification.model.i.f21789f.a(cVar);
                if (a10 != null) {
                    if (a10.d()) {
                        recommendView2.e(a10.b(), a10.e(), a10.a(), a10.c());
                    } else if (kotlin.jvm.internal.i.b(cVar.h(), "cloud recommend")) {
                        com.android.contacts.framework.api.cloudsync.a.d();
                        H7.b.e("ContactsMainListFragment", "showRecommender: false");
                        M2().f37693H.C(recommendView2, false);
                        this.f27964p = null;
                        return;
                    }
                }
                recommendView2.setEditMode(W2().n().getValue().booleanValue());
                recommendView2.setActionClickListener(new View.OnClickListener() { // from class: com.oplus.contacts.list.fragment.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContactsMainListFragment.b4(com.customize.contacts.pushnotification.model.c.this, this, recommendView2, view);
                    }
                });
                recommendView2.setDismissClickListener(new View.OnClickListener() { // from class: com.oplus.contacts.list.fragment.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ContactsMainListFragment.c4(com.customize.contacts.pushnotification.model.c.this, this, recommendView2, view);
                    }
                });
                if (recommendView2.getParent() == null) {
                    HeaderFooterRecyclerView headerFooterRecyclerView = M2().f37693H;
                    kotlin.jvm.internal.i.e(headerFooterRecyclerView, "contactMainListBinding.contactsMainListView");
                    HeaderFooterRecyclerView.z(headerFooterRecyclerView, recommendView2, null, 0, 2, null);
                }
                if (this.f27967x == -1) {
                    recommendView2.setVisibility(4);
                }
            }
        } else {
            RecommendView recommendView3 = this.f27964p;
            if (recommendView3 != null) {
                M2().f37693H.C(recommendView3, true);
            }
            this.f27964p = null;
        }
        D3(0L);
    }

    public final boolean b3() {
        com.android.contacts.framework.api.cloudsync.a.c();
        return false;
    }

    public final boolean c3(Context context) {
        if (b3()) {
            return false;
        }
        ContactListFilter e10 = AbstractC1316l.f(context).e();
        if (e10 != null && e10.f16738b != -2 && !M3.c.q(e10.f16740d, e10.f16739c)) {
            return false;
        }
        return true;
    }

    public final void d3(Context context, RecyclerViewScrollStateMonitor recyclerViewScrollStateMonitor) {
        kotlin.jvm.internal.i.f(context, "context");
        H7.b.b("ContactsMainListFragment", "loadContactsList");
        C1248i.d(androidx.lifecycle.p.a(this), S.b(), null, new ContactsMainListFragment$loadContactsList$1(this, AbstractC1316l.f(context), new C1393c(context), context, recyclerViewScrollStateMonitor, null), 2, null);
    }

    public final void d4(int i10) {
        String str;
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        if (!c3(requireContext) || (L2().t().getValue() instanceof CloudSyncState.d)) {
            AbstractC1663a abstractC1663a = M2().f37692G;
            ImageView iconView = abstractC1663a.f37688L;
            iconView.clearAnimation();
            kotlin.jvm.internal.i.e(iconView, "iconView");
            iconView.setVisibility(8);
            SuitableSizeTextView couiAppbarSubtitleTextView = abstractC1663a.f37686J;
            kotlin.jvm.internal.i.e(couiAppbarSubtitleTextView, "couiAppbarSubtitleTextView");
            couiAppbarSubtitleTextView.setVisibility(0);
            if (i10 > 0) {
                kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f34245a;
                String quantityString = getResources().getQuantityString(R.plurals.list_total_all_contacts_count, i10);
                kotlin.jvm.internal.i.e(quantityString, "resources.getQuantityStr…cts_count, contactsCount)");
                str = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
                kotlin.jvm.internal.i.e(str, "format(...)");
            } else {
                str = "";
            }
            N1(str);
        }
    }

    @Override // q7.InterfaceC1494c
    public void e0() {
        M2().f37697L.r();
    }

    public boolean e3() {
        return !a3();
    }

    public final void e4() {
        View view;
        View view2;
        Integer num;
        CollapsingToolbarLayout W02 = W0();
        Integer num2 = null;
        if (W02 != null) {
            view = W02.findViewById(R.id.coui_toolbar);
        } else {
            view = null;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            view2 = activity.findViewById(R.id.floating_button);
        } else {
            view2 = null;
        }
        if (view != null) {
            num = Integer.valueOf(view.getVisibility());
        } else {
            num = null;
        }
        if (view2 != null) {
            num2 = Integer.valueOf(view2.getVisibility());
        }
        H7.b.b("ContactsMainListFragment", "updateTouchSearchViewLayout: " + num + ", " + num2);
        M2().f37697L.O(view, view2);
    }

    public final void f3() {
        try {
            Result.a aVar = Result.f34166a;
            if (this.f27951L) {
                N2().notifyDataSetChanged();
                this.f27951L = false;
                H7.b.e("ContactsMainListFragment", "notifyDataSetChangedIfNeed");
            }
            Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Result.b(kotlin.b.a(th));
        }
    }

    public final void g3() {
        LinearLayoutManager linearLayoutManager;
        if (M2().f37693H.isComputingLayout()) {
            return;
        }
        RecyclerView.o layoutManager = M2().f37693H.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            int headersCount = M2().f37693H.getHeadersCount();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition() - headersCount;
            N2().notifyItemRangeChanged(findFirstVisibleItemPosition, ((linearLayoutManager.findLastVisibleItemPosition() - headersCount) - findFirstVisibleItemPosition) + 1);
        }
    }

    public final void h3() {
        com.android.contacts.framework.api.cloudsync.a.a("ContactsMainListFragment observerCloudSyncState", androidx.lifecycle.p.a(this), new Runnable() { // from class: com.oplus.contacts.list.fragment.l
            @Override // java.lang.Runnable
            public final void run() {
                ContactsMainListFragment.i3(ContactsMainListFragment.this);
            }
        });
    }

    @Override // W.c.b
    public void j(W.c<Cursor> loader) {
        kotlin.jvm.internal.i.f(loader, "loader");
        H7.b.i("ContactsMainListFragment", "onLoadCanceled, " + loader.j());
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, u7.InterfaceC1611a
    public void j0(boolean z10) {
        V3(s1());
        boolean z11 = false;
        Q3(W2().m().getValue().intValue(), "import_contact_tips", false);
        M2().f37697L.r();
        HeaderFooterRecyclerView headerFooterRecyclerView = M2().f37693H;
        if (FeatureUtil.V() && !z10) {
            z11 = true;
        }
        headerFooterRecyclerView.setPercentIndentEnabled(z11);
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment
    public int j1() {
        return R.layout.contacts_main_list_fragment_layout;
    }

    public final void j3() {
        FlowExtKt.c(W2().o(), this, new v9.l<Boolean, m9.q>(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerContactPhotoVisibleStateFlow$1
            final /* synthetic */ ContactsMainListFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return m9.q.f35511a;
            }

            public final void invoke(boolean z10) {
                String str;
                ContactsMainListHeaderView contactsMainListHeaderView;
                H7.b.b("ContactsMainListFragment", "photo visible change:" + z10);
                if (z10) {
                    str = "show_photo";
                } else {
                    str = "hide_photo";
                }
                contactsMainListHeaderView = this.this$0.f27942C;
                if (contactsMainListHeaderView == null) {
                    kotlin.jvm.internal.i.q("headerView");
                    contactsMainListHeaderView = null;
                }
                contactsMainListHeaderView.r(z10);
                if (this.this$0.M2().f37693H.isComputingLayout()) {
                    return;
                }
                this.this$0.N2().notifyItemRangeChanged(0, this.this$0.N2().getItemCount(), str);
            }
        });
    }

    public final void k3() {
        FlowExtKt.c(W2().k(), this, new v9.l<com.oplus.contacts.list.settings.a, m9.q>(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerContactSettingDataFlow$1
            final /* synthetic */ ContactsMainListFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final void b(com.oplus.contacts.list.settings.a it) {
                boolean z10;
                kotlin.jvm.internal.i.f(it, "it");
                H7.b.b("ContactsMainListFragment", "contact setting data collect:" + it);
                this.this$0.W3(true);
                this.this$0.G2(true);
                z10 = this.this$0.f27952M;
                if (z10) {
                    this.this$0.f27952M = false;
                    return;
                }
                ContactsMainListFragment<BD> contactsMainListFragment = this.this$0;
                Context requireContext = contactsMainListFragment.requireContext();
                kotlin.jvm.internal.i.e(requireContext, "requireContext()");
                contactsMainListFragment.S3(requireContext, it, this.this$0.T2());
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(com.oplus.contacts.list.settings.a aVar) {
                b(aVar);
                return m9.q.f35511a;
            }
        });
    }

    public final void l3() {
        kotlinx.coroutines.flow.i<Integer> m10 = W2().m();
        InterfaceC0492o viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
        FlowExtKt.c(m10, viewLifecycleOwner, new v9.l<Integer, m9.q>(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerContactsProviderStatus$1
            final /* synthetic */ ContactsMainListFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final void b(int i10) {
                boolean z10;
                boolean z11;
                ContactsMainListCollapsableAppBarLayout contactsMainListCollapsableAppBarLayout;
                Menu menu;
                MenuItem findItem;
                H7.b.b("ContactsMainListFragment", "observerContactsProviderStatus:" + i10);
                if (i10 == -1) {
                    return;
                }
                if (i10 == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                COUIToolbar toolbar = this.this$0.getToolbar();
                if (toolbar != null && (menu = toolbar.getMenu()) != null && (findItem = menu.findItem(R.id.menu_contacts_search)) != null) {
                    findItem.setVisible(z10);
                }
                this.this$0.Q3(i10, "import_contact_tips", false);
                ContactsMainListFragment<BD> contactsMainListFragment = this.this$0;
                Context requireContext = contactsMainListFragment.requireContext();
                if (i10 != 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                contactsMainListFragment.K3(requireContext, z11);
                ContactsMainListCollapsableAppBarLayout contactsMainListCollapsableAppBarLayout2 = null;
                if (!z10) {
                    if (this.this$0.a3()) {
                        this.this$0.G2(true);
                    }
                    HeaderFooterRecyclerView headerFooterRecyclerView = this.this$0.M2().f37693H;
                    kotlin.jvm.internal.i.e(headerFooterRecyclerView, "contactMainListBinding.contactsMainListView");
                    headerFooterRecyclerView.setVisibility(8);
                    ContactTouchSearchView contactTouchSearchView = this.this$0.M2().f37697L;
                    kotlin.jvm.internal.i.e(contactTouchSearchView, "contactMainListBinding.spellBar");
                    contactTouchSearchView.setVisibility(8);
                    AppBarLayout a12 = this.this$0.a1();
                    if (a12 instanceof ContactsMainListCollapsableAppBarLayout) {
                        contactsMainListCollapsableAppBarLayout = (ContactsMainListCollapsableAppBarLayout) a12;
                    } else {
                        contactsMainListCollapsableAppBarLayout = null;
                    }
                    if (contactsMainListCollapsableAppBarLayout != null) {
                        contactsMainListCollapsableAppBarLayout.setMode(2);
                    }
                    this.this$0.B3(false);
                    A.a(this.this$0.getContext(), 2000314, 200030186, null, false);
                    return;
                }
                HeaderFooterRecyclerView headerFooterRecyclerView2 = this.this$0.M2().f37693H;
                kotlin.jvm.internal.i.e(headerFooterRecyclerView2, "contactMainListBinding.contactsMainListView");
                headerFooterRecyclerView2.setVisibility(0);
                ContactTouchSearchView contactTouchSearchView2 = this.this$0.M2().f37697L;
                kotlin.jvm.internal.i.e(contactTouchSearchView2, "contactMainListBinding.spellBar");
                contactTouchSearchView2.setVisibility(0);
                AppBarLayout a13 = this.this$0.a1();
                if (a13 instanceof ContactsMainListCollapsableAppBarLayout) {
                    contactsMainListCollapsableAppBarLayout2 = (ContactsMainListCollapsableAppBarLayout) a13;
                }
                if (contactsMainListCollapsableAppBarLayout2 != null) {
                    contactsMainListCollapsableAppBarLayout2.setMode(0);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Integer num) {
                b(num.intValue());
                return m9.q.f35511a;
            }
        });
    }

    public final void m3() {
        FlowExtKt.c(W2().n(), this, new v9.l<Boolean, m9.q>(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerEditModeStateFlow$1
            final /* synthetic */ ContactsMainListFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return m9.q.f35511a;
            }

            public final void invoke(boolean z10) {
                ContactsMainListHeaderView contactsMainListHeaderView;
                RecommendView recommendView;
                RecommendView recommendView2;
                com.oplus.contacts.list.selectmanager.a aVar;
                com.oplus.contacts.list.selectmanager.a aVar2;
                String string;
                contactsMainListHeaderView = this.this$0.f27942C;
                if (contactsMainListHeaderView == null) {
                    kotlin.jvm.internal.i.q("headerView");
                    contactsMainListHeaderView = null;
                }
                contactsMainListHeaderView.setEditMode(z10);
                recommendView = this.this$0.f27964p;
                if (recommendView != null) {
                    recommendView.setEditMode(z10);
                }
                recommendView2 = this.this$0.f27965q;
                if (recommendView2 != null) {
                    recommendView2.setEditMode(z10);
                }
                ContactsMainListFragment<BD> contactsMainListFragment = this.this$0;
                contactsMainListFragment.V3(contactsMainListFragment.isVisible() && this.this$0.getUserVisibleHint());
                this.this$0.p1();
                this.this$0.M2().f37697L.q(z10);
                this.this$0.M2().f37692G.f37684H.setEditStyle(z10);
                ConstraintLayout constraintLayout = this.this$0.M2().f37692G.f37685I;
                kotlin.jvm.internal.i.e(constraintLayout, "contactMainListBinding.a…couiAppbarSubtitleContent");
                constraintLayout.setVisibility(z10 ^ true ? 0 : 8);
                this.this$0.M2().f37692G.f37683G.updateSubtitle();
                if (z10) {
                    aVar2 = this.this$0.f27941B;
                    if (aVar2 == null) {
                        kotlin.jvm.internal.i.q("dragSelectController");
                        aVar2 = null;
                    }
                    aVar2.b();
                    if (FeatureUtil.V() && !this.this$0.r1() && !DisplayUtil.j(this.this$0.getActivity())) {
                        HeaderFooterRecyclerView headerFooterRecyclerView = this.this$0.M2().f37693H;
                        kotlin.jvm.internal.i.e(headerFooterRecyclerView, "contactMainListBinding.contactsMainListView");
                        DragSelectRecyclerView.j(headerFooterRecyclerView, this.this$0.getResources().getDimensionPixelSize(R.dimen.DP_145), this.this$0.getResources().getDimensionPixelSize(R.dimen.contact_main_list_checkbox_margin_end), 0, 0, 12, null);
                    } else {
                        HeaderFooterRecyclerView headerFooterRecyclerView2 = this.this$0.M2().f37693H;
                        kotlin.jvm.internal.i.e(headerFooterRecyclerView2, "contactMainListBinding.contactsMainListView");
                        DragSelectRecyclerView.j(headerFooterRecyclerView2, 0, this.this$0.getResources().getDimensionPixelSize(R.dimen.contact_main_list_checkbox_margin_end), 0, 0, 13, null);
                    }
                    this.this$0.E1(null);
                    int a10 = this.this$0.W2().q().getValue().a();
                    if (a10 == 0) {
                        string = this.this$0.getResources().getString(R.string.select_item);
                    } else {
                        string = this.this$0.getResources().getString(R.string.select_items, Integer.valueOf(a10));
                    }
                    kotlin.jvm.internal.i.e(string, "if (selectedCount == 0) …dCount)\n                }");
                    this.this$0.M1(string);
                    Z3.a I22 = this.this$0.I2();
                    if (I22 != null) {
                        I22.b(this.this$0.M2().K0());
                        return;
                    }
                    return;
                }
                aVar = this.this$0.f27941B;
                if (aVar == null) {
                    kotlin.jvm.internal.i.q("dragSelectController");
                    aVar = null;
                }
                aVar.c();
                this.this$0.M2().f37693H.k();
                this.this$0.E1(null);
                com.oplus.foundation.appsupport.ui.fragment.f fVar = this.this$0;
                fVar.M1(fVar.getString(R.string.oplus_contacts_label));
                Z3.a I23 = this.this$0.I2();
                if (I23 != null) {
                    I23.a(this.this$0.M2().K0());
                }
            }
        });
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, r7.InterfaceC1512a
    public String n() {
        int i10 = this.f27967x;
        if (i10 > 0) {
            kotlin.jvm.internal.m mVar = kotlin.jvm.internal.m.f34245a;
            String quantityString = getResources().getQuantityString(R.plurals.list_total_all_contacts_count, i10);
            kotlin.jvm.internal.i.e(quantityString, "resources.getQuantityStr…acts_count, contactCount)");
            String format = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(i10)}, 1));
            kotlin.jvm.internal.i.e(format, "format(...)");
            return format;
        }
        return null;
    }

    public final void n3() {
        W3(false);
        PushNotificationViewModel pushNotificationViewModel = this.f27969z;
        if (pushNotificationViewModel == null) {
            kotlin.jvm.internal.i.q("pushNotificationViewModel");
            pushNotificationViewModel = null;
        }
        Transformations.a(pushNotificationViewModel.k()).i(getViewLifecycleOwner(), new d(new v9.l<com.customize.contacts.pushnotification.model.c, m9.q>(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerPushNotifications$1
            final /* synthetic */ ContactsMainListFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final void b(com.customize.contacts.pushnotification.model.c cVar) {
                this.this$0.a4(cVar);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(com.customize.contacts.pushnotification.model.c cVar) {
                b(cVar);
                return m9.q.f35511a;
            }
        }));
    }

    public final void o3() {
        final kotlinx.coroutines.flow.m<C1463d<com.oplus.contacts.list.f>> q10 = W2().q();
        FlowExtKt.b(new kotlinx.coroutines.flow.a<Integer>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ kotlinx.coroutines.flow.b f27971a;

                /* compiled from: Emitters.kt */
                @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1$2", f = "ContactsMainListFragment.kt", l = {223}, m = "emit")
                /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(kotlinx.coroutines.flow.b bVar) {
                    this.f27971a = bVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1$2$1 r0 = (com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1$2$1 r0 = new com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.b.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.b.b(r6)
                        kotlinx.coroutines.flow.b r4 = r4.f27971a
                        p7.d r5 = (p7.C1463d) r5
                        int r5 = r5.a()
                        java.lang.Integer r5 = p9.C1467a.d(r5)
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L49
                        return r1
                    L49:
                        m9.q r4 = m9.q.f35511a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.a
            public Object collect(kotlinx.coroutines.flow.b<? super Integer> bVar, kotlin.coroutines.c cVar) {
                Object c10;
                Object collect = kotlinx.coroutines.flow.a.this.collect(new AnonymousClass2(bVar), cVar);
                c10 = kotlin.coroutines.intrinsics.b.c();
                if (collect == c10) {
                    return collect;
                }
                return m9.q.f35511a;
            }
        }, this, null, new v9.l<Integer, m9.q>(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$2
            final /* synthetic */ ContactsMainListFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final void b(int i10) {
                Menu menu;
                MenuItem findItem;
                boolean z10;
                String string;
                if (this.this$0.a3()) {
                    if (i10 == 0) {
                        string = this.this$0.getResources().getString(R.string.select_item);
                    } else {
                        string = this.this$0.getResources().getString(R.string.select_items, Integer.valueOf(i10));
                    }
                    kotlin.jvm.internal.i.e(string, "if (selectedCount == 0) …dCount)\n                }");
                    this.this$0.M1(string);
                }
                COUINavigationView cOUINavigationView = (COUINavigationView) this.this$0.requireActivity().findViewById(R.id.navigation_tool_view);
                if (cOUINavigationView != null && (menu = cOUINavigationView.getMenu()) != null && (findItem = menu.findItem(R.id.menu_delete)) != null) {
                    if (i10 != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    findItem.setEnabled(z10);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Integer num) {
                b(num.intValue());
                return m9.q.f35511a;
            }
        }, 2, null);
        final kotlinx.coroutines.flow.m<C1463d<com.oplus.contacts.list.f>> q11 = W2().q();
        FlowExtKt.b(new kotlinx.coroutines.flow.a<Boolean>() { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2

            /* compiled from: Emitters.kt */
            /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ kotlinx.coroutines.flow.b f27973a;

                /* compiled from: Emitters.kt */
                @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2$2", f = "ContactsMainListFragment.kt", l = {223}, m = "emit")
                /* renamed from: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(kotlin.coroutines.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(kotlinx.coroutines.flow.b bVar) {
                    this.f27973a = bVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2$2$1 r0 = (com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2$2$1 r0 = new com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.b.b(r6)
                        goto L49
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.b.b(r6)
                        kotlinx.coroutines.flow.b r4 = r4.f27973a
                        p7.d r5 = (p7.C1463d) r5
                        boolean r5 = r5.c()
                        java.lang.Boolean r5 = p9.C1467a.a(r5)
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L49
                        return r1
                    L49:
                        m9.q r4 = m9.q.f35511a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.a
            public Object collect(kotlinx.coroutines.flow.b<? super Boolean> bVar, kotlin.coroutines.c cVar) {
                Object c10;
                Object collect = kotlinx.coroutines.flow.a.this.collect(new AnonymousClass2(bVar), cVar);
                c10 = kotlin.coroutines.intrinsics.b.c();
                if (collect == c10) {
                    return collect;
                }
                return m9.q.f35511a;
            }
        }, this, null, new v9.l<Boolean, m9.q>(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$observerSelectDataUiStateFlow$4
            final /* synthetic */ ContactsMainListFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return m9.q.f35511a;
            }

            public final void invoke(boolean z10) {
                Menu menu;
                Menu menu2;
                MenuItem menuItem = null;
                if (z10) {
                    COUIToolbar toolbar = this.this$0.getToolbar();
                    if (toolbar != null && (menu2 = toolbar.getMenu()) != null) {
                        menuItem = menu2.findItem(R.id.select_all);
                    }
                    if (menuItem == null) {
                        return;
                    }
                    menuItem.setTitle(this.this$0.getString(R.string.oplus_option_selectcancel));
                    return;
                }
                COUIToolbar toolbar2 = this.this$0.getToolbar();
                if (toolbar2 != null && (menu = toolbar2.getMenu()) != null) {
                    menuItem = menu.findItem(R.id.select_all);
                }
                if (menuItem == null) {
                    return;
                }
                menuItem.setTitle(this.this$0.getString(R.string.oplus_option_selectall));
            }
        }, 2, null);
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int e10 = DisplayUtil.e(requireContext(), false);
        this.f27945F = e10;
        H7.b.e("ContactsMainListFragment", "onConfigurationChanged: screenHeight: " + e10);
        com.oplus.contacts.list.selectmanager.a aVar = this.f27941B;
        if (aVar == null) {
            kotlin.jvm.internal.i.q("dragSelectController");
            aVar = null;
        }
        aVar.e();
        ContactTouchSearchView contactTouchSearchView = M2().f37697L;
        contactTouchSearchView.q(a3());
        contactTouchSearchView.r();
        X3();
        if (U2().k()) {
            if (FeatureUtil.V() && !r1() && !DisplayUtil.j(getActivity())) {
                M2().f37693H.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.DP_145));
            } else {
                M2().f37693H.setDragRegionWidth(getResources().getDimensionPixelSize(R.dimen.contact_main_list_checkbox_margin_end));
            }
        }
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H7.b.e("ContactsMainListFragment", "onCreate");
        K.a.C0124a c0124a = K.a.f10266f;
        Application application = requireActivity().getApplication();
        kotlin.jvm.internal.i.e(application, "requireActivity().application");
        this.f27969z = (PushNotificationViewModel) new K(this, c0124a.b(application)).a(PushNotificationViewModel.class);
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        J3(new com.oplus.contacts.list.a(requireContext, W2()));
        N2().setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT);
        N2().I(this);
        H3();
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        H7.b.e("ContactsMainListFragment", "onDestroy");
        getChildFragmentManager().v("request_key_dialog_btn_click");
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        H7.b.e("ContactsMainListFragment", "onDestroyView");
        ContactsMainListCursorLoader contactsMainListCursorLoader = this.f27968y;
        if (contactsMainListCursorLoader != null) {
            contactsMainListCursorLoader.w();
            contactsMainListCursorLoader.B(this);
            contactsMainListCursorLoader.C(this);
        }
        this.f27968y = null;
        unRegisterReceiver();
        G2(true);
        T2().i(M2().f37693H);
        this.f27962n.F();
        M2().f37693H.clearOnScrollListeners();
        this.f27948I = null;
    }

    @Override // w7.c
    public void onItemClick(View view, int i10) {
        com.oplus.contacts.list.f fVar;
        kotlin.jvm.internal.i.f(view, "view");
        Object tag = view.getTag(R.id.tag_contact_main_list_item_info);
        if (tag instanceof com.oplus.contacts.list.f) {
            fVar = (com.oplus.contacts.list.f) tag;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            if (W2().n().getValue().booleanValue()) {
                W2().C(fVar);
                N2().notifyItemChanged(i10, "selection_change");
            } else if (!C7.a.b((int) fVar.d())) {
                s3(fVar);
            }
        }
    }

    @Override // com.customize.contacts.widget.TouchSearchView.d
    public void onKey(CharSequence key) {
        kotlin.jvm.internal.i.f(key, "key");
        HashMap hashMap = new HashMap();
        hashMap.put("spellbar_click_text", key);
        A.a(getContext(), 2000307, 200030043, hashMap, false);
        H2(key);
        ContactTouchSearchView contactTouchSearchView = M2().f37697L;
        if (U7.e.c(key)) {
            contactTouchSearchView.setName(new String[0]);
            contactTouchSearchView.setFirstKeyPopupDrawable(C0991a.b(requireContext(), 2131232622));
            return;
        }
        contactTouchSearchView.setFirstKeyPopupDrawable(null);
        if (U7.e.b(key)) {
            contactTouchSearchView.setName(new String[0]);
        } else {
            contactTouchSearchView.setName(this.f27961m.c(key));
        }
    }

    @Override // com.customize.contacts.widget.TouchSearchView.d
    public void onNameClick(CharSequence surname) {
        kotlin.jvm.internal.i.f(surname, "surname");
        if (H7.a.b()) {
            H7.b.b("ContactsMainListFragment", "onNameClick");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spellbar_click_text", surname);
        A.a(getContext(), 2000307, 200030044, hashMap, false);
        int S22 = S2(this.f27961m.b());
        if (S22 >= 0) {
            F3(S22 + this.f27961m.a(surname));
            return;
        }
        H7.b.i("ContactsMainListFragment", "onNameClick, get position error for key:" + ((Object) this.f27961m.b()) + ", name:" + ((Object) surname));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        H7.b.e("ContactsMainListFragment", "onPause");
        M2().f37697L.r();
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.f, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H7.b.e("ContactsMainListFragment", "onResume");
        g3();
        PushNotificationViewModel pushNotificationViewModel = this.f27969z;
        if (pushNotificationViewModel == null) {
            kotlin.jvm.internal.i.q("pushNotificationViewModel");
            pushNotificationViewModel = null;
        }
        pushNotificationViewModel.p(true);
        if (this.f27950K) {
            this.f27950K = false;
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            d3(requireContext, T2());
        }
        D3(350L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        M2().f37693H.getWrapHeaderAdapter().A();
        f3();
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        this.f27962n.onStatusBarClicked();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        H7.b.e("ContactsMainListFragment", "onStop");
        Z3.j.c();
        M2().f37693H.getWrapHeaderAdapter().E();
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        int e10 = DisplayUtil.e(requireContext(), false);
        this.f27945F = e10;
        H7.b.e("ContactsMainListFragment", "onViewCreated: screenHeight: " + e10);
        InterfaceC0492o viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
        M3(new RecyclerViewScrollStateMonitor(androidx.lifecycle.p.a(viewLifecycleOwner)));
        T2().h(M2().f37693H);
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        d3(requireContext, T2());
        X2();
        registerReceiver();
        l3();
        k3();
        j3();
        m3();
        o3();
        h3();
        Context requireContext2 = requireContext();
        kotlin.jvm.internal.i.e(requireContext2, "requireContext()");
        HeaderFooterRecyclerView headerFooterRecyclerView = M2().f37693H;
        kotlin.jvm.internal.i.e(headerFooterRecyclerView, "contactMainListBinding.contactsMainListView");
        this.f27941B = new com.oplus.contacts.list.selectmanager.a(requireContext2, headerFooterRecyclerView, N2());
        U2().l().i(getViewLifecycleOwner(), new d(new v9.l<Boolean, m9.q>(this) { // from class: com.oplus.contacts.list.fragment.ContactsMainListFragment$onViewCreated$1
            final /* synthetic */ ContactsMainListFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public final void b(Boolean show) {
                int i10;
                COUIToolbar toolbar = this.this$0.getToolbar();
                if (toolbar != null) {
                    kotlin.jvm.internal.i.e(show, "show");
                    if (show.booleanValue()) {
                        i10 = 0;
                    } else {
                        i10 = -1;
                    }
                    toolbar.setRedDot(R.id.menu_contacts_more, i10);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                b(bool);
                return m9.q.f35511a;
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        B3(false);
    }

    @Override // w7.b
    public void p0() {
        b.a.b(this);
    }

    public final void p3() {
        if (W2().q().getValue().c()) {
            A.a(getContext(), 2000321, 200030257, null, false);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(W2().q().getValue().a()));
        A.a(getContext(), 2000316, 200030286, hashMap, false);
    }

    public final void q3(ContactsDeleteInfo contactsDeleteInfo) {
        Object b10;
        if (contactsDeleteInfo != null) {
            if (contactsDeleteInfo.d() && contactsDeleteInfo.b() >= 10 && contactsDeleteInfo.b() != contactsDeleteInfo.f()) {
                O3();
                return;
            }
            if (contactsDeleteInfo.b() == contactsDeleteInfo.f() && contactsDeleteInfo.f() != 1) {
                Intent c10 = C0807s.c(requireContext());
                if (c10 != null) {
                    try {
                        Result.a aVar = Result.f34166a;
                        this.f27954O.a(c10);
                        b10 = Result.b(m9.q.f35511a);
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.f34166a;
                        b10 = Result.b(kotlin.b.a(th));
                    }
                    Result.a(b10);
                    return;
                }
                if (contactsDeleteInfo.d()) {
                    O3();
                    return;
                } else {
                    A2();
                    return;
                }
            }
            A2();
        }
    }

    public void r3(int i10) {
        X.a b10 = X.a.b(requireContext());
        kotlin.jvm.internal.i.e(b10, "getInstance(requireContext())");
        b10.d(new Intent("com.oplus.contacts.force_refresh_calllog"));
        if (i10 == -1) {
            p3();
        }
        W2().B();
    }

    public final void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.oplus.contacts.DETAIL_UPDATE_DONE");
        intentFilter.addAction("com.android.contacts.local.ACTION_CLOUD_RECOMMENDER_CHANGED");
        intentFilter.addAction("com.android.contacts.local.ACTION_CLOUD_OFFLINE_RECOMMENDER_CHANGED");
        X.a.b(requireContext()).c(this.f27956Q, intentFilter);
    }

    public void s3(com.oplus.contacts.list.f item) {
        kotlin.jvm.internal.i.f(item, "item");
        Intent intent = new Intent(requireContext(), (Class<?>) CallDetailActivity.class);
        intent.setData(item.i());
        R7.b.f(requireContext(), intent, 0, null, 6, null);
    }

    public final boolean t3(View view) {
        com.oplus.contacts.list.f fVar;
        Object tag = view.getTag(R.id.tag_contact_main_list_item_info);
        Integer num = null;
        if (tag instanceof com.oplus.contacts.list.f) {
            fVar = (com.oplus.contacts.list.f) tag;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            Object tag2 = view.getTag(R.id.tag_contact_main_list_item_position);
            if (tag2 instanceof Integer) {
                num = (Integer) tag2;
            }
            if (num != null) {
                int intValue = num.intValue();
                W2().C(fVar);
                N2().notifyItemChanged(intValue, "selection_change");
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // W.c.InterfaceC0078c
    /* renamed from: u3, reason: merged with bridge method [inline-methods] */
    public void t(W.c<Cursor> loader, Cursor cursor) {
        kotlin.jvm.internal.i.f(loader, "loader");
        if (cursor == null) {
            this.f27950K = true;
        }
        int a10 = com.oplus.foundation.util.io.b.a(cursor);
        H7.b.i("ContactsMainListFragment", "onLoadComplete, " + loader.j() + ", count:" + a10);
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            ContactsTabActivity contactsTabActivity = (ContactsTabActivity) activity;
            contactsTabActivity.Z2();
            contactsTabActivity.U2();
        }
        if (cursor != null && cursor.isClosed()) {
            H7.b.i("ContactsMainListFragment", "onLoadComplete, but cursor is isClosed!!!");
        }
        if (!getLifecycle().b().b(Lifecycle.State.STARTED)) {
            H7.b.e("ContactsMainListFragment", "onLoadComplete in background");
            this.f27951L = true;
        }
        if (!M2().f37693H.isComputingLayout()) {
            N2().h(cursor);
            Z0.b.g(requireContext()).t();
            this.f27967x = a10;
            M2().f37697L.r();
            g0.a(M2().f37697L, N2().getSections(), N2().o());
            this.f27961m.d(cursor);
            ContactsMainListHeaderView contactsMainListHeaderView = this.f27942C;
            if (contactsMainListHeaderView == null) {
                kotlin.jvm.internal.i.q("headerView");
                contactsMainListHeaderView = null;
            }
            contactsMainListHeaderView.setVisibility(0);
            RecommendView recommendView = this.f27964p;
            if (recommendView != null) {
                recommendView.setVisibility(0);
            }
            d4(this.f27967x);
            W2().v(cursor);
            return;
        }
        H7.b.i("ContactsMainListFragment", "onLoadComplete isComputingLayout");
    }

    public final void unRegisterReceiver() {
        X.a.b(requireContext()).e(this.f27956Q);
    }

    public final void v3(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (item.getItemId() == R.id.menu_delete) {
            C2();
        }
    }

    public void w3(int i10) {
        if (i10 == -1) {
            A2();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("state", 4);
        A.a(getContext(), 2000321, 200030256, hashMap, false);
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment
    public void x1(COUIToolbar toolbar) {
        kotlin.jvm.internal.i.f(toolbar, "toolbar");
        super.x1(toolbar);
        if (a3()) {
            toolbar.setIsTitleCenterStyle(true);
            toolbar.inflateMenu(R.menu.cancel_select_menu);
        } else {
            toolbar.setIsTitleCenterStyle(false);
            toolbar.inflateMenu(R.menu.contacts_menu);
        }
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment
    public void y1(Menu menu) {
        int i10;
        MenuItem menuItem;
        Menu menu2;
        kotlin.jvm.internal.i.f(menu, "menu");
        if (a3()) {
            COUIToolbar toolbar = getToolbar();
            if (toolbar != null && (menu2 = toolbar.getMenu()) != null) {
                menuItem = menu2.findItem(R.id.select_all);
            } else {
                menuItem = null;
            }
            if (menuItem != null) {
                menuItem.setTitle(getString(R.string.oplus_option_selectall));
                return;
            }
            return;
        }
        MenuItem findItem = menu.findItem(R.id.menu_contacts_search);
        if (findItem != null) {
            findItem.setVisible(W2().x());
            findItem.setContentDescription(getString(R.string.menu_search));
        }
        COUIToolbar toolbar2 = getToolbar();
        if (toolbar2 != null) {
            if (kotlin.jvm.internal.i.b(U2().l().getValue(), Boolean.TRUE)) {
                i10 = 0;
            } else {
                i10 = -1;
            }
            toolbar2.setRedDot(R.id.menu_contacts_more, i10);
        }
    }

    @Override // s7.InterfaceC1556a
    public void z(C1557b popupMenuItem) {
        kotlin.jvm.internal.i.f(popupMenuItem, "popupMenuItem");
        switch (popupMenuItem.a()) {
            case R.id.pop_menu_block_filter /* 2131428698 */:
                if (PrimaryUserUtils.a()) {
                    Context requireContext = requireContext();
                    String str = C1501d.f36273b;
                    if (com.android.contacts.framework.baseui.util.l.d(requireContext, str)) {
                        com.android.contacts.framework.baseui.util.l.f(requireActivity(), str, null, 2);
                        return;
                    } else {
                        com.android.contacts.framework.api.appstore.appinfo.a.a(requireActivity(), new Runnable() { // from class: com.oplus.contacts.list.fragment.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                ContactsMainListFragment.x3(ContactsMainListFragment.this);
                            }
                        });
                        return;
                    }
                }
                return;
            case R.id.pop_menu_business_hall /* 2131428699 */:
                if (PrimaryUserUtils.a() && com.android.contacts.framework.api.businesshall.a.k(requireContext())) {
                    h0.Z(requireContext(), "service_hall_manager", "contact");
                    return;
                }
                return;
            case R.id.pop_menu_card_scan /* 2131428700 */:
                if (popupMenuItem.isEnable()) {
                    A.a(requireContext(), 2000306, 200030287, null, false);
                    Intent intent = new Intent(requireContext(), (Class<?>) BusinessCardCaptureActivity.class);
                    intent.putExtra("mode", "from_main_activity");
                    R7.b.f(requireContext(), intent, 0, null, 6, null);
                    h0.Z(requireContext(), "scan_card", "contact");
                    return;
                }
                return;
            case R.id.pop_menu_contact_management /* 2131428701 */:
                if (PrimaryUserUtils.a()) {
                    C0792c.l(this, 1, -1);
                    h0.Z(requireContext(), "contact_manager", "contact");
                    return;
                }
                return;
            case R.id.pop_menu_edit /* 2131428702 */:
                F2();
                return;
            case R.id.pop_menu_no_network /* 2131428703 */:
                NoNetworkCommUiStateUtil.f15861a.p(getContext());
                h0.Z(requireContext(), "beacon_link", "contact");
                return;
            case R.id.pop_menu_rcs_group_chat /* 2131428704 */:
                Intent intent2 = new Intent("com.suntek.mway.rcs.nativeui.ACTION_LUNCH_RCS_GROUPCHALIST");
                intent2.putExtra("isFromContact", true);
                R7.b.f(requireContext(), intent2, 0, null, 6, null);
                h0.Z(requireContext(), "RCS_group", "contact");
                return;
            case R.id.pop_menu_sdn_number /* 2131428705 */:
                ArrayList<Account> m10 = M3.c.m(requireContext());
                int size = m10.size();
                if (size == 1) {
                    Intent intent3 = new Intent(requireContext(), (Class<?>) ServiceNumberActivity.class);
                    intent3.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, m10.get(0).f16941a);
                    R7.b.f(requireContext(), intent3, 0, null, 6, null);
                } else if (size > 1) {
                    Intent intent4 = new Intent(requireContext(), (Class<?>) SimAccountsListActivity.class);
                    intent4.putExtra("show_sdn_service_number", true);
                    R7.b.f(requireContext(), intent4, 0, null, 6, null);
                }
                h0.Z(requireContext(), "SDN_number", "contact");
                return;
            case R.id.pop_menu_settings /* 2131428706 */:
                if (PrimaryUserUtils.a()) {
                    if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                        FragmentActivity requireActivity = requireActivity();
                        kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
                        com.android.contacts.framework.api.appstore.appinfo.a.n(requireActivity);
                    } else {
                        C0792c.l(this, 0, -1);
                    }
                    h0.Z(requireContext(), "setting", "contact");
                    return;
                }
                return;
            default:
                H7.b.i("ContactsMainListFragment", "onPopMenuItemClick, not support pop menu item:" + popupMenuItem.b());
                return;
        }
    }

    public final void z2() {
        ContactsMainListHeaderView contactsMainListHeaderView;
        ContactsMainListHeaderView contactsMainListHeaderView2 = null;
        View inflate = getLayoutInflater().inflate(R.layout.contacts_main_list_header_view, (ViewGroup) null, false);
        kotlin.jvm.internal.i.d(inflate, "null cannot be cast to non-null type com.oplus.contacts.list.ContactsMainListHeaderView");
        ContactsMainListHeaderView contactsMainListHeaderView3 = (ContactsMainListHeaderView) inflate;
        this.f27942C = contactsMainListHeaderView3;
        if (contactsMainListHeaderView3 == null) {
            kotlin.jvm.internal.i.q("headerView");
            contactsMainListHeaderView3 = null;
        }
        contactsMainListHeaderView3.setHeaderItemClickListener(this);
        z3();
        HeaderFooterRecyclerView headerFooterRecyclerView = M2().f37693H;
        kotlin.jvm.internal.i.e(headerFooterRecyclerView, "contactMainListBinding.contactsMainListView");
        ContactsMainListHeaderView contactsMainListHeaderView4 = this.f27942C;
        if (contactsMainListHeaderView4 == null) {
            kotlin.jvm.internal.i.q("headerView");
            contactsMainListHeaderView = null;
        } else {
            contactsMainListHeaderView = contactsMainListHeaderView4;
        }
        HeaderFooterRecyclerView.z(headerFooterRecyclerView, contactsMainListHeaderView, null, 0, 6, null);
        ContactsMainListHeaderView contactsMainListHeaderView5 = this.f27942C;
        if (contactsMainListHeaderView5 == null) {
            kotlin.jvm.internal.i.q("headerView");
        } else {
            contactsMainListHeaderView2 = contactsMainListHeaderView5;
        }
        contactsMainListHeaderView2.setVisibility(4);
        n3();
    }

    public final void z3() {
        FragmentActivity activity;
        if (!CommonOSPublicFeature.f() && (activity = getActivity()) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.contacts.list.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    ContactsMainListFragment.A3(ContactsMainListFragment.this);
                }
            });
        }
    }
}
