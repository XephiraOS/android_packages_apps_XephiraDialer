package com.oplus.contacts.list.fragment;

import a7.C0424a;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.w;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.model.Account;
import com.android.incallui.OplusNumberMarkUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ImportContactsActivity;
import com.customize.contacts.activities.SimAccountsListActivity;
import com.customize.contacts.activities.SimContactsListActivity;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.b0;
import com.customize.pbap.bluetooth.pbapclient.BluetoothImportActivity;
import com.oplus.contacts.list.cloudsync.CloudSyncViewModel;
import com.oplus.contacts.list.viewmodel.ImportContactsTipsViewModel;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.lifecycle.FlowExtKt;
import com.oplus.foundation.appsupport.ui.widget.SuitableSizeTextView;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import p9.InterfaceC1470d;
import v9.InterfaceC1637a;

/* compiled from: ImportContactsTipsFragment.kt */
/* loaded from: classes3.dex */
public final class ImportContactsTipsFragment extends Fragment implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    public static final a f27988e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final m9.d f27989a;

    /* renamed from: b, reason: collision with root package name */
    public final m9.d f27990b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f27991c;

    /* renamed from: d, reason: collision with root package name */
    public x0.q f27992d;

    /* compiled from: ImportContactsTipsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ImportContactsTipsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements w, kotlin.jvm.internal.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.l f27997a;

        public b(v9.l function) {
            kotlin.jvm.internal.i.f(function, "function");
            this.f27997a = function;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof w) || !(obj instanceof kotlin.jvm.internal.g)) {
                return false;
            }
            return kotlin.jvm.internal.i.b(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.g
        public final m9.c<?> getFunctionDelegate() {
            return this.f27997a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object obj) {
            this.f27997a.invoke(obj);
        }
    }

    public ImportContactsTipsFragment() {
        final InterfaceC1637a<Fragment> interfaceC1637a = new InterfaceC1637a<Fragment>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f27989a = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(ImportContactsTipsViewModel.class), new InterfaceC1637a<M>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$special$$inlined$viewModels$default$2
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
        }, new InterfaceC1637a<K.b>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$special$$inlined$viewModels$default$3
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
        final InterfaceC1637a<Fragment> interfaceC1637a2 = new InterfaceC1637a<Fragment>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$special$$inlined$viewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f27990b = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(CloudSyncViewModel.class), new InterfaceC1637a<M>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$special$$inlined$viewModels$default$5
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
        }, new InterfaceC1637a<K.b>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$special$$inlined$viewModels$default$6
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
    }

    private final CloudSyncViewModel i1() {
        return (CloudSyncViewModel) this.f27990b.getValue();
    }

    private final void q1() {
        x0.q qVar = null;
        if (PrimaryUserUtils.a() && !FeatureOption.k() && CommonFeatureOption.j() && !VirtualSupportUtils.m()) {
            x0.q qVar2 = this.f27992d;
            if (qVar2 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar2 = null;
            }
            qVar2.f37768m.setOnClickListener(this);
        } else {
            x0.q qVar3 = this.f27992d;
            if (qVar3 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar3 = null;
            }
            SuitableSizeTextView suitableSizeTextView = qVar3.f37768m;
            kotlin.jvm.internal.i.e(suitableSizeTextView, "viewBinding.importFromSim");
            suitableSizeTextView.setVisibility(8);
            x0.q qVar4 = this.f27992d;
            if (qVar4 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar4 = null;
            }
            ImageView imageView = qVar4.f37769n;
            kotlin.jvm.internal.i.e(imageView, "viewBinding.importFromSimDivider");
            imageView.setVisibility(8);
        }
        x0.q qVar5 = this.f27992d;
        if (qVar5 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar5 = null;
        }
        qVar5.f37770o.setOnClickListener(this);
        if (com.android.contacts.framework.api.togoogle.a.c()) {
            x0.q qVar6 = this.f27992d;
            if (qVar6 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar6 = null;
            }
            qVar6.f37760e.setOnClickListener(this);
        } else {
            x0.q qVar7 = this.f27992d;
            if (qVar7 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar7 = null;
            }
            SuitableSizeTextView suitableSizeTextView2 = qVar7.f37760e;
            kotlin.jvm.internal.i.e(suitableSizeTextView2, "viewBinding.importFromGoogleAccount");
            suitableSizeTextView2.setVisibility(8);
            x0.q qVar8 = this.f27992d;
            if (qVar8 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar8 = null;
            }
            ImageView imageView2 = qVar8.f37761f;
            kotlin.jvm.internal.i.e(imageView2, "viewBinding.importFromGoogleAccountDivider");
            imageView2.setVisibility(8);
        }
        x0.q qVar9 = this.f27992d;
        if (qVar9 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar9 = null;
        }
        qVar9.f37764i.setOnClickListener(this);
        x0.q qVar10 = this.f27992d;
        if (qVar10 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar10 = null;
        }
        qVar10.f37766k.setOnClickListener(this);
        if (PrimaryUserUtils.a()) {
            x0.q qVar11 = this.f27992d;
            if (qVar11 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar11 = null;
            }
            qVar11.f37762g.setOnClickListener(this);
        } else {
            x0.q qVar12 = this.f27992d;
            if (qVar12 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar12 = null;
            }
            SuitableSizeTextView suitableSizeTextView3 = qVar12.f37762g;
            kotlin.jvm.internal.i.e(suitableSizeTextView3, "viewBinding.importFromOtherAccount");
            suitableSizeTextView3.setVisibility(8);
            x0.q qVar13 = this.f27992d;
            if (qVar13 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar13 = null;
            }
            ImageView imageView3 = qVar13.f37763h;
            kotlin.jvm.internal.i.e(imageView3, "viewBinding.importFromOtherAccountDivider");
            imageView3.setVisibility(8);
        }
        if (!CommonOSPublicFeature.f()) {
            x0.q qVar14 = this.f27992d;
            if (qVar14 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar14 = null;
            }
            SuitableSizeTextView suitableSizeTextView4 = qVar14.f37759d;
            kotlin.jvm.internal.i.e(suitableSizeTextView4, "viewBinding.importFromCloudSync");
            suitableSizeTextView4.setVisibility(8);
        }
        x0.q qVar15 = this.f27992d;
        if (qVar15 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar15 = null;
        }
        qVar15.f37759d.setOnClickListener(this);
        x0.q qVar16 = this.f27992d;
        if (qVar16 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar16 = null;
        }
        qVar16.f37772q.setIsParentChildHierarchy(!this.f27991c);
        Context context = getContext();
        x0.q qVar17 = this.f27992d;
        if (qVar17 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
        } else {
            qVar = qVar17;
        }
        com.android.contacts.framework.baseui.util.r.e(context, qVar.f37774s);
    }

    public static final void s1(final ImportContactsTipsFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (com.android.contacts.framework.api.cloudsync.a.g()) {
            Transformations.a(this$0.i1().u()).i(this$0.getViewLifecycleOwner(), new b(new v9.l<Boolean, m9.q>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$5$1
                {
                    super(1);
                }

                public final void b(Boolean bool) {
                    ImportContactsTipsViewModel j12;
                    j12 = ImportContactsTipsFragment.this.j1();
                    j12.n();
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                    b(bool);
                    return m9.q.f35511a;
                }
            }));
            Transformations.a(this$0.i1().q()).i(this$0.getViewLifecycleOwner(), new b(new v9.l<Boolean, m9.q>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$5$2
                {
                    super(1);
                }

                public final void b(Boolean bool) {
                    ImportContactsTipsViewModel j12;
                    j12 = ImportContactsTipsFragment.this.j1();
                    j12.n();
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                    b(bool);
                    return m9.q.f35511a;
                }
            }));
        }
    }

    public final void h1() {
        j1().n();
        ImportContactsTipsViewModel j12 = j1();
        String string = getResources().getString(R.string.backup_restore_pkg);
        kotlin.jvm.internal.i.e(string, "resources.getString(R.string.backup_restore_pkg)");
        j12.p(string);
    }

    public final ImportContactsTipsViewModel j1() {
        return (ImportContactsTipsViewModel) this.f27989a.getValue();
    }

    public final void k1() {
        CloudSyncViewModel i12 = i1();
        FragmentActivity requireActivity = requireActivity();
        kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
        i12.x(requireActivity);
    }

    public final void l1() {
        Intent intent = new Intent("android.settings.SYNC_SETTINGS");
        intent.setFlags(524288);
        R7.b.f(getActivity(), intent, 0, null, 6, null);
        A.a(getContext(), 2000314, 200030191, null, false);
    }

    public final void m1() {
        A.a(getContext(), 2000314, 200030181, null, false);
        R7.b.f(getContext(), new Intent(getContext(), (Class<?>) BluetoothImportActivity.class), 0, null, 6, null);
    }

    public final void n1() {
        C0792c.m(getContext());
        A.a(getContext(), 2000314, 200031192, null, false);
    }

    public final void o1() {
        ArrayList<Account> m10 = M3.c.m(getContext());
        int size = m10.size();
        if (size == 1) {
            Intent intent = new Intent(getContext(), (Class<?>) SimContactsListActivity.class);
            intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, m10.get(0).f16941a);
            intent.putExtra("imprort_sim_contacts", true);
            R7.b.f(getContext(), intent, 0, null, 6, null);
        } else if (size > 1) {
            Intent intent2 = new Intent(getContext(), (Class<?>) SimAccountsListActivity.class);
            intent2.putExtra("imprort_sim_contacts", true);
            R7.b.f(getContext(), intent2, 0, null, 6, null);
        } else if (b0.O() > 0) {
            com.oplus.foundation.util.ui.c.b(getContext(), R.string.oplus_refreshing_sim_data);
        } else {
            com.oplus.foundation.util.ui.c.b(getContext(), R.string.simcard_abnormal_please_check_and_try_again);
        }
        A.a(getContext(), 2000314, 200030187, null, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        kotlin.jvm.internal.i.f(v10, "v");
        switch (v10.getId()) {
            case R.id.import_from_cloud_sync /* 2131428175 */:
                k1();
                return;
            case R.id.import_from_google_account /* 2131428176 */:
                com.android.contacts.framework.api.togoogle.a aVar = com.android.contacts.framework.api.togoogle.a.f15622a;
                Context context = v10.getContext();
                kotlin.jvm.internal.i.e(context, "v.context");
                aVar.d(context);
                return;
            case R.id.import_from_google_account_divider /* 2131428177 */:
            case R.id.import_from_other_account_divider /* 2131428179 */:
            case R.id.import_from_other_device_divider /* 2131428181 */:
            case R.id.import_from_phone_clone_divider /* 2131428183 */:
            case R.id.import_from_sim_divider /* 2131428185 */:
            default:
                return;
            case R.id.import_from_other_account /* 2131428178 */:
                l1();
                return;
            case R.id.import_from_other_device /* 2131428180 */:
                m1();
                return;
            case R.id.import_from_phone_clone /* 2131428182 */:
                n1();
                return;
            case R.id.import_from_sim /* 2131428184 */:
                o1();
                return;
            case R.id.import_from_vcard /* 2131428186 */:
                p1();
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        x0.q qVar = this.f27992d;
        if (qVar == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar = null;
        }
        qVar.f37772q.setIsParentChildHierarchy(!this.f27991c);
        u1();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        x0.q c10 = x0.q.c(inflater, viewGroup, false);
        kotlin.jvm.internal.i.e(c10, "inflate(inflater, container, false)");
        this.f27992d = c10;
        if (c10 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            c10 = null;
        }
        FrameLayout b10 = c10.b();
        kotlin.jvm.internal.i.e(b10, "viewBinding.root");
        return b10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z10) {
        super.onMultiWindowModeChanged(z10);
        u1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        h1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        boolean z10;
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z10 = arguments.getBoolean("show_in_left");
        } else {
            z10 = false;
        }
        this.f27991c = z10;
        q1();
        r1();
        v1();
        u1();
    }

    public final void p1() {
        R7.b.f(getActivity(), new Intent(getContext(), (Class<?>) ImportContactsActivity.class), 0, null, 6, null);
        A.a(getContext(), 2000314, 200030188, null, false);
    }

    public final void r1() {
        final kotlinx.coroutines.flow.m<C0424a> m10 = j1().m();
        FlowExtKt.b(new kotlinx.coroutines.flow.a<Boolean>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ kotlinx.coroutines.flow.b f27994a;

                /* compiled from: Emitters.kt */
                @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1$2", f = "ImportContactsTipsFragment.kt", l = {223}, m = "emit")
                /* renamed from: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1$2$1, reason: invalid class name */
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
                    this.f27994a = bVar;
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
                        boolean r0 = r6 instanceof com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1$2$1 r0 = (com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1$2$1 r0 = new com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1$2$1
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
                        kotlinx.coroutines.flow.b r4 = r4.f27994a
                        a7.a r5 = (a7.C0424a) r5
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
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
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
        }, this, null, new v9.l<Boolean, m9.q>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$2
            {
                super(1);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return m9.q.f35511a;
            }

            public final void invoke(boolean z10) {
                Log.d("ImportContactsTipsFragment", "observerUiState: cloud enable:" + z10);
                ImportContactsTipsFragment.this.t1(z10);
            }
        }, 2, null);
        final kotlinx.coroutines.flow.m<C0424a> m11 = j1().m();
        FlowExtKt.b(new kotlinx.coroutines.flow.a<C0424a.C0094a>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2

            /* compiled from: Emitters.kt */
            /* renamed from: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ kotlinx.coroutines.flow.b f27996a;

                /* compiled from: Emitters.kt */
                @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2$2", f = "ImportContactsTipsFragment.kt", l = {223}, m = "emit")
                /* renamed from: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2$2$1, reason: invalid class name */
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
                    this.f27996a = bVar;
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
                        boolean r0 = r6 instanceof com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2$2$1 r0 = (com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2$2$1 r0 = new com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.a.c()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.b.b(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.b.b(r6)
                        kotlinx.coroutines.flow.b r4 = r4.f27996a
                        a7.a r5 = (a7.C0424a) r5
                        a7.a$a r5 = r5.d()
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L45
                        return r1
                    L45:
                        m9.q r4 = m9.q.f35511a
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.a
            public Object collect(kotlinx.coroutines.flow.b<? super C0424a.C0094a> bVar, kotlin.coroutines.c cVar) {
                Object c10;
                Object collect = kotlinx.coroutines.flow.a.this.collect(new AnonymousClass2(bVar), cVar);
                c10 = kotlin.coroutines.intrinsics.b.c();
                if (collect == c10) {
                    return collect;
                }
                return m9.q.f35511a;
            }
        }, this, null, new v9.l<C0424a.C0094a, m9.q>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$observerUiState$4
            {
                super(1);
            }

            public final void b(C0424a.C0094a it) {
                x0.q qVar;
                x0.q qVar2;
                x0.q qVar3;
                x0.q qVar4;
                x0.q qVar5;
                kotlin.jvm.internal.i.f(it, "it");
                x0.q qVar6 = null;
                if (it.d()) {
                    qVar3 = ImportContactsTipsFragment.this.f27992d;
                    if (qVar3 == null) {
                        kotlin.jvm.internal.i.q("viewBinding");
                        qVar3 = null;
                    }
                    qVar3.f37766k.setText(ImportContactsTipsFragment.this.getResources().getString(R.string.import_from_clone_phone_tablet, it.c()));
                    qVar4 = ImportContactsTipsFragment.this.f27992d;
                    if (qVar4 == null) {
                        kotlin.jvm.internal.i.q("viewBinding");
                        qVar4 = null;
                    }
                    SuitableSizeTextView suitableSizeTextView = qVar4.f37766k;
                    kotlin.jvm.internal.i.e(suitableSizeTextView, "viewBinding.importFromPhoneClone");
                    suitableSizeTextView.setVisibility(0);
                    qVar5 = ImportContactsTipsFragment.this.f27992d;
                    if (qVar5 == null) {
                        kotlin.jvm.internal.i.q("viewBinding");
                    } else {
                        qVar6 = qVar5;
                    }
                    ImageView imageView = qVar6.f37767l;
                    kotlin.jvm.internal.i.e(imageView, "viewBinding.importFromPhoneCloneDivider");
                    imageView.setVisibility(0);
                } else {
                    qVar = ImportContactsTipsFragment.this.f27992d;
                    if (qVar == null) {
                        kotlin.jvm.internal.i.q("viewBinding");
                        qVar = null;
                    }
                    SuitableSizeTextView suitableSizeTextView2 = qVar.f37766k;
                    kotlin.jvm.internal.i.e(suitableSizeTextView2, "viewBinding.importFromPhoneClone");
                    suitableSizeTextView2.setVisibility(8);
                    qVar2 = ImportContactsTipsFragment.this.f27992d;
                    if (qVar2 == null) {
                        kotlin.jvm.internal.i.q("viewBinding");
                    } else {
                        qVar6 = qVar2;
                    }
                    ImageView imageView2 = qVar6.f37767l;
                    kotlin.jvm.internal.i.e(imageView2, "viewBinding.importFromPhoneCloneDivider");
                    imageView2.setVisibility(8);
                }
                ImportContactsTipsFragment.this.v1();
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(C0424a.C0094a c0094a) {
                b(c0094a);
                return m9.q.f35511a;
            }
        }, 2, null);
        com.android.contacts.framework.api.cloudsync.a.a("ImportContactsTipsFragment observerUiState", androidx.lifecycle.p.a(this), new Runnable() { // from class: com.oplus.contacts.list.fragment.p
            @Override // java.lang.Runnable
            public final void run() {
                ImportContactsTipsFragment.s1(ImportContactsTipsFragment.this);
            }
        });
    }

    public final void t1(boolean z10) {
        x0.q qVar = this.f27992d;
        x0.q qVar2 = null;
        if (qVar == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar = null;
        }
        SuitableSizeTextView suitableSizeTextView = qVar.f37759d;
        kotlin.jvm.internal.i.e(suitableSizeTextView, "viewBinding.importFromCloudSync");
        x0.q qVar3 = this.f27992d;
        if (qVar3 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
        } else {
            qVar2 = qVar3;
        }
        ImageView imageView = qVar2.f37763h;
        kotlin.jvm.internal.i.e(imageView, "viewBinding.importFromOtherAccountDivider");
        InterfaceC0492o viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.i.e(viewLifecycleOwner, "viewLifecycleOwner");
        C1248i.d(androidx.lifecycle.p.a(viewLifecycleOwner), S.b(), null, new ImportContactsTipsFragment$updateCloudSyncVisibility$1(this, z10, suitableSizeTextView, imageView, null), 2, null);
    }

    public final void u1() {
        x0.q qVar = this.f27992d;
        x0.q qVar2 = null;
        if (qVar == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar = null;
        }
        ViewGroup.LayoutParams layoutParams = qVar.f37757b.getLayoutParams();
        kotlin.jvm.internal.i.d(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.f27991c) {
            x0.q qVar3 = this.f27992d;
            if (qVar3 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
                qVar3 = null;
            }
            FrameLayout frameLayout = qVar3.f37758c;
            kotlin.jvm.internal.i.e(frameLayout, "viewBinding.contentLayout");
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            frameLayout.setPadding(frameLayout.getPaddingLeft(), DisplayUtil.g(requireContext) + getResources().getDimensionPixelSize(R.dimen.coui_appbar_title_expanded_height), frameLayout.getPaddingRight(), getResources().getDimensionPixelSize(R.dimen.contact_bottom_tab_height));
            x0.q qVar4 = this.f27992d;
            if (qVar4 == null) {
                kotlin.jvm.internal.i.q("viewBinding");
            } else {
                qVar2 = qVar4;
            }
            LinearLayout linearLayout = qVar2.f37773r;
            kotlin.jvm.internal.i.e(linearLayout, "viewBinding.realScrollView");
            linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), getResources().getDimensionPixelSize(R.dimen.DP_60));
            if (!FeatureUtil.V()) {
                Context requireContext2 = requireContext();
                kotlin.jvm.internal.i.e(requireContext2, "requireContext()");
                if ((!DisplayUtil.m(requireContext2) || !FeatureUtil.N()) && requireActivity().isInMultiWindowMode()) {
                    layoutParams2.gravity = 48;
                    return;
                }
            }
            layoutParams2.gravity = 17;
            return;
        }
        x0.q qVar5 = this.f27992d;
        if (qVar5 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar5 = null;
        }
        FrameLayout frameLayout2 = qVar5.f37758c;
        kotlin.jvm.internal.i.e(frameLayout2, "viewBinding.contentLayout");
        frameLayout2.setPadding(frameLayout2.getPaddingLeft(), 0, frameLayout2.getPaddingRight(), 0);
        x0.q qVar6 = this.f27992d;
        if (qVar6 == null) {
            kotlin.jvm.internal.i.q("viewBinding");
        } else {
            qVar2 = qVar6;
        }
        LinearLayout linearLayout2 = qVar2.f37773r;
        kotlin.jvm.internal.i.e(linearLayout2, "viewBinding.realScrollView");
        linearLayout2.setPadding(linearLayout2.getPaddingLeft(), linearLayout2.getPaddingTop(), linearLayout2.getPaddingRight(), 0);
        layoutParams2.gravity = 17;
    }

    public final void v1() {
        kotlin.sequences.e h10;
        int g10;
        x0.q qVar = this.f27992d;
        if (qVar == null) {
            kotlin.jvm.internal.i.q("viewBinding");
            qVar = null;
        }
        LinearLayout linearLayout = qVar.f37774s;
        kotlin.jvm.internal.i.e(linearLayout, "viewBinding.rootLayout");
        h10 = SequencesKt___SequencesKt.h(androidx.core.view.N.b(linearLayout), new v9.l<View, Boolean>() { // from class: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$updateItemsBackground$visibleChildren$1
            @Override // v9.l
            public final Boolean invoke(View it) {
                kotlin.jvm.internal.i.f(it, "it");
                return Boolean.valueOf(it.getVisibility() == 0);
            }
        });
        g10 = SequencesKt___SequencesKt.g(h10);
        int i10 = 0;
        for (Object obj : h10) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.o.o();
            }
            View view = (View) obj;
            if (i10 == 0) {
                if (g10 == 1) {
                    view.setBackgroundResource(R.drawable.pb_bg_contacts_unavailable_view_one);
                } else {
                    view.setBackgroundResource(R.drawable.pb_bg_contacts_unavailable_view_first);
                }
            } else if (i10 == g10 - 1) {
                view.setBackgroundResource(R.drawable.pb_bg_contacts_unavailable_view_last);
            } else {
                view.setBackgroundResource(R.drawable.coui_preference_bg_selector);
            }
            i10 = i11;
        }
    }
}
