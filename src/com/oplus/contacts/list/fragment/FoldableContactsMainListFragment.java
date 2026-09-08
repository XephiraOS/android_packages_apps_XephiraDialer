package com.oplus.contacts.list.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import c.C0543d;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.activities.GroupBrowserActivity;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.group.GroupBrowserActivityFragment;
import com.android.contacts.util.w;
import com.android.incallui.OplusPhoneCapabilities;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.cleaner.RawCleanerJobService;
import com.customize.contacts.manager.ContactUnfoldFragmentManager;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.W;
import com.customize.contacts.util.h0;
import com.oplus.contacts.list.a;
import com.oplus.contacts.list.uistate.ContactsMainListRightFragmentUiState;
import com.oplus.contacts.list.viewmodel.FoldableContactsMainListViewModel;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.lifecycle.FlowExtKt;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import v9.InterfaceC1637a;
import x0.AbstractC1665c;
import x0.AbstractC1667e;

/* compiled from: FoldableContactsMainListFragment.kt */
/* loaded from: classes3.dex */
public final class FoldableContactsMainListFragment extends ContactsMainListFragment<AbstractC1667e> {

    /* renamed from: X, reason: collision with root package name */
    public static final a f27982X = new a(null);

    /* renamed from: T, reason: collision with root package name */
    public final m9.d f27983T = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(FoldableContactsMainListViewModel.class), new InterfaceC1637a<M>() { // from class: com.oplus.contacts.list.fragment.FoldableContactsMainListFragment$special$$inlined$activityViewModels$default$1
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
    }, new InterfaceC1637a<K.b>() { // from class: com.oplus.contacts.list.fragment.FoldableContactsMainListFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: U, reason: collision with root package name */
    public final b f27984U = new b();

    /* renamed from: V, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f27985V;

    /* renamed from: W, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f27986W;

    /* compiled from: FoldableContactsMainListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FoldableContactsMainListFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements a.b {
        public b() {
        }

        @Override // com.oplus.contacts.list.a.b
        public boolean a(Uri uri) {
            if (uri != null && FoldableContactsMainListFragment.this.r1() && !FoldableContactsMainListFragment.this.a3()) {
                ContactsMainListRightFragmentUiState value = FoldableContactsMainListFragment.this.W2().I().getValue();
                if (value instanceof ContactsMainListRightFragmentUiState.MyProfileUiState) {
                    return kotlin.jvm.internal.i.b(uri, ((ContactsMainListRightFragmentUiState.MyProfileUiState) value).f().getData());
                }
                if (value instanceof ContactsMainListRightFragmentUiState.DetailUiState) {
                    return kotlin.jvm.internal.i.b(uri, ((ContactsMainListRightFragmentUiState.DetailUiState) value).f().getData());
                }
            }
            return false;
        }
    }

    public FoldableContactsMainListFragment() {
        androidx.activity.result.b<Intent> registerForActivityResult = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.contacts.list.fragment.n
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                FoldableContactsMainListFragment.H4(FoldableContactsMainListFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult, "registerForActivityResul…leftFocused = false\n    }");
        this.f27985V = registerForActivityResult;
        androidx.activity.result.b<Intent> registerForActivityResult2 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.contacts.list.fragment.o
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                FoldableContactsMainListFragment.J4(FoldableContactsMainListFragment.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult2, "registerForActivityResul…        }\n        }\n    }");
        this.f27986W = registerForActivityResult2;
    }

    public static final void H4(FoldableContactsMainListFragment this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.W2().K(false);
    }

    public static final void J4(FoldableContactsMainListFragment this$0, ActivityResult activityResult) {
        Uri uri;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.W2().K(false);
        if (activityResult.d() == -1) {
            Intent b10 = activityResult.b();
            if (b10 != null) {
                uri = b10.getData();
            } else {
                uri = null;
            }
            if (uri != null) {
                Intent intent = new Intent();
                intent.setData(uri);
                this$0.W2().M(new ContactsMainListRightFragmentUiState.MyProfileUiState(intent, false));
            }
        }
    }

    private final void z4(Intent intent) {
        W2().M(new ContactsMainListRightFragmentUiState.DetailUiState(intent, true));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        if (r3.equals(r0) == true) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A4(android.content.Intent r12, java.lang.String r13) {
        /*
            r11 = this;
            androidx.fragment.app.FragmentManager r0 = r11.getParentFragmentManager()
            androidx.fragment.app.Fragment r0 = r0.m0(r13)
            boolean r1 = r0 instanceof com.android.contacts.detail.CallDetailActivityFragment
            r2 = 0
            if (r1 == 0) goto L10
            com.android.contacts.detail.CallDetailActivityFragment r0 = (com.android.contacts.detail.CallDetailActivityFragment) r0
            goto L11
        L10:
            r0 = r2
        L11:
            r1 = 1
            if (r0 == 0) goto L2e
            android.net.Uri r3 = r12.getData()
            if (r3 == 0) goto L2e
            android.content.Intent r0 = r0.t1()
            if (r0 == 0) goto L25
            android.net.Uri r0 = r0.getData()
            goto L26
        L25:
            r0 = r2
        L26:
            boolean r0 = r3.equals(r0)
            if (r0 != r1) goto L2e
            goto Lb4
        L2e:
            com.android.contacts.detail.CallDetailActivityFragment r0 = new com.android.contacts.detail.CallDetailActivityFragment
            r0.<init>()
            com.customize.contacts.activities.ContactsTabActivity r3 = r11.O2()
            if (r3 == 0) goto L3e
            boolean r3 = r3.G2()
            goto L3f
        L3e:
            r3 = 0
        L3f:
            r0.X1(r3, r1)
            com.oplus.contacts.list.viewmodel.FoldableContactsMainListViewModel r1 = r11.W2()
            android.net.Uri r3 = r12.getData()
            r1.L(r3)
            r0.V1(r12)
            boolean r12 = r11.r1()
            java.lang.String r1 = "parentFragmentManager"
            if (r12 == 0) goto L6e
            androidx.fragment.app.FragmentManager r3 = r11.getParentFragmentManager()
            kotlin.jvm.internal.i.e(r3, r1)
            r7 = 2130772164(0x7f0100c4, float:1.7147439E38)
            r8 = 2130772166(0x7f0100c6, float:1.7147443E38)
            r4 = 2131428084(0x7f0b02f4, float:1.8477802E38)
            r5 = r0
            r6 = r13
            com.oplus.foundation.appsupport.ui.fragment.e.e(r3, r4, r5, r6, r7, r8)
            goto Lb4
        L6e:
            androidx.fragment.app.FragmentManager r12 = r11.getParentFragmentManager()
            com.oplus.contacts.list.viewmodel.FoldableContactsMainListViewModel r3 = r11.W2()
            kotlinx.coroutines.flow.m r3 = r3.I()
            java.lang.Object r3 = r3.getValue()
            com.oplus.contacts.list.uistate.ContactsMainListRightFragmentUiState r3 = (com.oplus.contacts.list.uistate.ContactsMainListRightFragmentUiState) r3
            if (r3 == 0) goto L86
            java.lang.String r2 = r3.b()
        L86:
            androidx.fragment.app.Fragment r12 = r12.m0(r2)
            if (r12 == 0) goto L9d
            android.view.View r12 = r12.getView()
            if (r12 != 0) goto L93
            goto L9d
        L93:
            java.lang.String r2 = "view"
            kotlin.jvm.internal.i.e(r12, r2)
            r2 = 8
            r12.setVisibility(r2)
        L9d:
            androidx.fragment.app.FragmentManager r3 = r11.getParentFragmentManager()
            kotlin.jvm.internal.i.e(r3, r1)
            r9 = 16
            r10 = 0
            r4 = 2131428084(0x7f0b02f4, float:1.8477802E38)
            r7 = 0
            r8 = 0
            r5 = r0
            r6 = r13
            com.oplus.foundation.appsupport.ui.fragment.e.f(r3, r4, r5, r6, r7, r8, r9, r10)
            r0.W1()
        Lb4:
            r11.K4()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.fragment.FoldableContactsMainListFragment.A4(android.content.Intent, java.lang.String):void");
    }

    public final void B4(String str) {
        boolean z10;
        String str2;
        View view;
        if (getParentFragmentManager().m0(str) == null || !r1()) {
            GroupBrowserActivityFragment groupBrowserActivityFragment = new GroupBrowserActivityFragment();
            ContactsTabActivity O22 = O2();
            if (O22 != null) {
                z10 = O22.G2();
            } else {
                z10 = false;
            }
            groupBrowserActivityFragment.X1(z10, true);
            if (r1()) {
                FragmentManager parentFragmentManager = getParentFragmentManager();
                kotlin.jvm.internal.i.e(parentFragmentManager, "parentFragmentManager");
                com.oplus.foundation.appsupport.ui.fragment.e.e(parentFragmentManager, R.id.foldable_contact_right_container, groupBrowserActivityFragment, str, R.anim.unfold_fragment_alpha_in, R.anim.unfold_fragment_alpha_out);
            } else {
                FragmentManager parentFragmentManager2 = getParentFragmentManager();
                ContactsMainListRightFragmentUiState value = W2().I().getValue();
                if (value != null) {
                    str2 = value.b();
                } else {
                    str2 = null;
                }
                Fragment m02 = parentFragmentManager2.m0(str2);
                if (m02 != null && (view = m02.getView()) != null) {
                    kotlin.jvm.internal.i.e(view, "view");
                    view.setVisibility(8);
                }
                FragmentManager parentFragmentManager3 = getParentFragmentManager();
                kotlin.jvm.internal.i.e(parentFragmentManager3, "parentFragmentManager");
                com.oplus.foundation.appsupport.ui.fragment.e.e(parentFragmentManager3, R.id.foldable_contact_right_container, groupBrowserActivityFragment, str, 0, 0);
                groupBrowserActivityFragment.W1();
            }
        }
        K4();
    }

    public final void C4(Intent intent, String str, boolean z10) {
        CallDetailActivityFragment callDetailActivityFragment;
        boolean z11;
        View view;
        Fragment m02 = getParentFragmentManager().m0(str);
        String str2 = null;
        if (m02 instanceof CallDetailActivityFragment) {
            callDetailActivityFragment = (CallDetailActivityFragment) m02;
        } else {
            callDetailActivityFragment = null;
        }
        if (callDetailActivityFragment == null || !r1()) {
            CallDetailActivityFragment callDetailActivityFragment2 = new CallDetailActivityFragment();
            if (!r1()) {
                FragmentManager parentFragmentManager = getParentFragmentManager();
                ContactsMainListRightFragmentUiState value = W2().I().getValue();
                if (value != null) {
                    str2 = value.b();
                }
                Fragment m03 = parentFragmentManager.m0(str2);
                if (m03 != null && (view = m03.getView()) != null) {
                    kotlin.jvm.internal.i.e(view, "view");
                    view.setVisibility(8);
                }
            }
            ContactsTabActivity O22 = O2();
            if (O22 != null) {
                z11 = O22.G2();
            } else {
                z11 = false;
            }
            callDetailActivityFragment2.X1(z11, true);
            callDetailActivityFragment2.V1(intent);
            if (z10) {
                if (r1()) {
                    FragmentManager parentFragmentManager2 = getParentFragmentManager();
                    kotlin.jvm.internal.i.e(parentFragmentManager2, "parentFragmentManager");
                    com.oplus.foundation.appsupport.ui.fragment.e.e(parentFragmentManager2, R.id.foldable_contact_right_container, callDetailActivityFragment2, str, R.anim.unfold_fragment_alpha_in, R.anim.unfold_fragment_alpha_out);
                } else {
                    FragmentManager parentFragmentManager3 = getParentFragmentManager();
                    kotlin.jvm.internal.i.e(parentFragmentManager3, "parentFragmentManager");
                    com.oplus.foundation.appsupport.ui.fragment.e.e(parentFragmentManager3, R.id.foldable_contact_right_container, callDetailActivityFragment2, str, 0, 0);
                    callDetailActivityFragment2.W1();
                }
            } else {
                FragmentManager parentFragmentManager4 = getParentFragmentManager();
                kotlin.jvm.internal.i.e(parentFragmentManager4, "parentFragmentManager");
                com.oplus.foundation.appsupport.ui.fragment.e.e(parentFragmentManager4, R.id.foldable_contact_right_container, callDetailActivityFragment2, str, 0, 0);
            }
        }
        K4();
    }

    public final void D4(boolean z10, String str, boolean z11) {
        String str2;
        int i10;
        int i11 = 0;
        if (z10) {
            Fragment m02 = getParentFragmentManager().m0(str);
            if (m02 == null || !m02.isVisible()) {
                m02 = new r();
            }
            Fragment fragment = m02;
            if (!fragment.isAdded()) {
                if (z11) {
                    i11 = R.anim.unfold_fragment_alpha_out;
                }
                FragmentManager parentFragmentManager = getParentFragmentManager();
                kotlin.jvm.internal.i.e(parentFragmentManager, "parentFragmentManager");
                com.oplus.foundation.appsupport.ui.fragment.e.e(parentFragmentManager, R.id.foldable_contact_right_container, fragment, str, 0, i11);
                return;
            }
            return;
        }
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        ContactsMainListRightFragmentUiState G10 = W2().G();
        ContactsTabActivity contactsTabActivity = null;
        if (G10 != null) {
            str2 = G10.b();
        } else {
            str2 = null;
        }
        Fragment m03 = parentFragmentManager2.m0(str2);
        if (m03 != null) {
            if (z11) {
                i10 = R.anim.coui_close_slide_exit;
            } else {
                i10 = 0;
            }
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            kotlin.jvm.internal.i.e(parentFragmentManager3, "parentFragmentManager");
            com.oplus.foundation.appsupport.ui.fragment.e.a(parentFragmentManager3, m03, 0, i10);
            if (z11) {
                FragmentActivity activity = getActivity();
                if (activity instanceof ContactsTabActivity) {
                    contactsTabActivity = (ContactsTabActivity) activity;
                }
                if (contactsTabActivity != null) {
                    contactsTabActivity.g2();
                    return;
                }
                return;
            }
            View view = m03.getView();
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    public final void E4(boolean z10, String str, boolean z11) {
        String str2;
        int i10;
        int i11 = 0;
        if (z10) {
            Fragment m02 = getParentFragmentManager().m0(str);
            if (m02 == null) {
                m02 = new ImportContactsTipsFragment();
            }
            Fragment fragment = m02;
            if (z11) {
                i11 = R.anim.unfold_fragment_alpha_out;
            }
            FragmentManager parentFragmentManager = getParentFragmentManager();
            kotlin.jvm.internal.i.e(parentFragmentManager, "parentFragmentManager");
            com.oplus.foundation.appsupport.ui.fragment.e.e(parentFragmentManager, R.id.foldable_contact_right_container, fragment, str, 0, i11);
            G4(true);
            return;
        }
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        ContactsMainListRightFragmentUiState G10 = W2().G();
        ContactsTabActivity contactsTabActivity = null;
        if (G10 != null) {
            str2 = G10.b();
        } else {
            str2 = null;
        }
        Fragment m03 = parentFragmentManager2.m0(str2);
        if (m03 != null) {
            if (z11) {
                i10 = R.anim.coui_close_slide_exit;
            } else {
                i10 = 0;
            }
            FragmentManager parentFragmentManager3 = getParentFragmentManager();
            kotlin.jvm.internal.i.e(parentFragmentManager3, "parentFragmentManager");
            com.oplus.foundation.appsupport.ui.fragment.e.a(parentFragmentManager3, m03, 0, i10);
            if (z11) {
                FragmentActivity activity = getActivity();
                if (activity instanceof ContactsTabActivity) {
                    contactsTabActivity = (ContactsTabActivity) activity;
                }
                if (contactsTabActivity != null) {
                    contactsTabActivity.g2();
                }
            }
        }
        F4(true);
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    public void F2() {
        super.F2();
        L4();
    }

    public final void F4(boolean z10) {
        if (z10) {
            FrameLayout frameLayout = M2().f37694I;
            kotlin.jvm.internal.i.e(frameLayout, "contactMainListBinding.emptyFragmentContainer");
            if (frameLayout.getVisibility() != 0) {
                FrameLayout frameLayout2 = M2().f37694I;
                kotlin.jvm.internal.i.e(frameLayout2, "contactMainListBinding.emptyFragmentContainer");
                frameLayout2.setVisibility(0);
            }
            Fragment m02 = getChildFragmentManager().m0("left_fragment_tag_import_contacts");
            if (m02 == null) {
                m02 = new ImportContactsTipsFragment();
                Bundle bundle = new Bundle();
                bundle.putBoolean("show_in_left", true);
                m02.setArguments(bundle);
            }
            FragmentManager childFragmentManager = getChildFragmentManager();
            kotlin.jvm.internal.i.e(childFragmentManager, "childFragmentManager");
            com.oplus.foundation.appsupport.ui.fragment.e.e(childFragmentManager, R.id.empty_fragment_container, m02, "left_fragment_tag_import_contacts", 0, 0);
            return;
        }
        FrameLayout frameLayout3 = M2().f37694I;
        kotlin.jvm.internal.i.e(frameLayout3, "contactMainListBinding.emptyFragmentContainer");
        if (frameLayout3.getVisibility() == 0) {
            Fragment m03 = getChildFragmentManager().m0("left_fragment_tag_import_contacts");
            if (m03 != null) {
                FragmentManager childFragmentManager2 = getChildFragmentManager();
                kotlin.jvm.internal.i.e(childFragmentManager2, "childFragmentManager");
                com.oplus.foundation.appsupport.ui.fragment.e.b(childFragmentManager2, m03, 0, 0, 6, null);
            }
            FrameLayout frameLayout4 = M2().f37694I;
            kotlin.jvm.internal.i.e(frameLayout4, "contactMainListBinding.emptyFragmentContainer");
            frameLayout4.setVisibility(8);
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    public void G2(boolean z10) {
        super.G2(z10);
        L4();
    }

    public final void G4(boolean z10) {
        if (z10) {
            FrameLayout frameLayout = M2().f37694I;
            kotlin.jvm.internal.i.e(frameLayout, "contactMainListBinding.emptyFragmentContainer");
            if (frameLayout.getVisibility() != 0) {
                FrameLayout frameLayout2 = M2().f37694I;
                kotlin.jvm.internal.i.e(frameLayout2, "contactMainListBinding.emptyFragmentContainer");
                frameLayout2.setVisibility(0);
            }
            Fragment m02 = getChildFragmentManager().m0("left_fragment_tag_no_contacts");
            if (m02 == null) {
                m02 = new q();
            }
            FragmentManager childFragmentManager = getChildFragmentManager();
            kotlin.jvm.internal.i.e(childFragmentManager, "childFragmentManager");
            com.oplus.foundation.appsupport.ui.fragment.e.e(childFragmentManager, R.id.empty_fragment_container, m02, "left_fragment_tag_no_contacts", 0, 0);
            return;
        }
        FrameLayout frameLayout3 = M2().f37694I;
        kotlin.jvm.internal.i.e(frameLayout3, "contactMainListBinding.emptyFragmentContainer");
        if (frameLayout3.getVisibility() == 0) {
            Fragment m03 = getChildFragmentManager().m0("left_fragment_tag_no_contacts");
            if (m03 != null) {
                FragmentManager childFragmentManager2 = getChildFragmentManager();
                kotlin.jvm.internal.i.e(childFragmentManager2, "childFragmentManager");
                com.oplus.foundation.appsupport.ui.fragment.e.b(childFragmentManager2, m03, 0, 0, 6, null);
            }
            FrameLayout frameLayout4 = M2().f37694I;
            kotlin.jvm.internal.i.e(frameLayout4, "contactMainListBinding.emptyFragmentContainer");
            frameLayout4.setVisibility(8);
        }
    }

    public final void I4(Intent intent) {
        W2().K(true);
        this.f27986W.a(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K4() {
        if (!t1()) {
            return;
        }
        int i10 = 0;
        if (!r1()) {
            FrameLayout frameLayout = ((AbstractC1667e) l1()).f37702H;
            kotlin.jvm.internal.i.e(frameLayout, "viewDataBinding.foldableContactRightContainer");
            if (!(!v4())) {
                i10 = 8;
            }
            frameLayout.setVisibility(i10);
        } else {
            FrameLayout frameLayout2 = ((AbstractC1667e) l1()).f37702H;
            kotlin.jvm.internal.i.e(frameLayout2, "viewDataBinding.foldableContactRightContainer");
            frameLayout2.setVisibility(0);
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            ((ContactsTabActivity) activity).r3();
        }
    }

    public final void L4() {
        P2().h();
        if (!a3() && r1()) {
            ContactsMainListRightFragmentUiState value = W2().I().getValue();
            if (value instanceof ContactsMainListRightFragmentUiState.MyGroupUiState) {
                P2().o();
                return;
            }
            if (value instanceof ContactsMainListRightFragmentUiState.MyProfileUiState) {
                P2().p();
                return;
            }
            H7.b.b("FoldableContactsMainListFragment", "updateHeaderViewActivatedState. do nothing in " + W2().I().getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    public AbstractC1665c M2() {
        AbstractC1665c abstractC1665c = ((AbstractC1667e) l1()).f37703I;
        kotlin.jvm.internal.i.e(abstractC1665c, "viewDataBinding.pageRootContainer");
        return abstractC1665c;
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment, com.oplus.contacts.list.ContactsMainListHeaderView.b
    public void O0() {
        if (FeatureOption.o()) {
            boolean k10 = w.k(getContext(), "android.permission.READ_PHONE_NUMBERS");
            H7.b.e("FoldableContactsMainListFragment", "hasPermission = " + k10);
            if (!k10) {
                androidx.core.app.a.q(requireActivity(), new String[]{"android.permission.READ_PHONE_NUMBERS"}, 1);
                return;
            }
        }
        g3();
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        if (W.c(requireContext) == null) {
            h0.A(requireContext, "edit_my_information");
            Intent intent = new Intent(requireContext, (Class<?>) ContactEditorActivity.class);
            intent.setAction("android.intent.action.INSERT");
            intent.putExtra("newLocalProfile", true);
            W.d(requireContext, intent);
            if (CommonFeatureOption.o(requireContext)) {
                intent.putExtra("finishActivityOnSaveCompleted", true);
                I4(intent);
            } else {
                R7.b.f(requireContext, intent, 0, null, 6, null);
            }
            C0636a.a(requireActivity());
            return;
        }
        h0.A(requireContext, "my_information");
        Intent intent2 = new Intent(requireContext, (Class<?>) CallDetailActivity.class);
        intent2.setData(W.b());
        if (CommonFeatureOption.o(requireContext)) {
            W2().M(new ContactsMainListRightFragmentUiState.MyProfileUiState(intent2, true));
            y4();
        } else {
            R7.b.f(requireContext, intent2, 0, null, 6, null);
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    public void Q3(int i10, String tag, boolean z10) {
        kotlin.jvm.internal.i.f(tag, "tag");
        if (i10 == -1) {
            return;
        }
        if (i10 != 2 && i10 != 1) {
            if (W2().I().getValue() == null || (W2().I().getValue() instanceof ContactsMainListRightFragmentUiState.NoContactsUiState) || (W2().I().getValue() instanceof ContactsMainListRightFragmentUiState.NoContactSelectedUiState)) {
                W2().M(new ContactsMainListRightFragmentUiState.NoContactSelectedUiState(r1(), z10));
            }
            G4(false);
            return;
        }
        W2().M(new ContactsMainListRightFragmentUiState.NoContactsUiState(r1(), z10));
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment, com.oplus.contacts.list.ContactsMainListHeaderView.b
    public void R() {
        g3();
        Context requireContext = requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        A.a(requireContext, 2000308, 200030040, null, false);
        Intent intent = new Intent();
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        intent.setClass(requireContext, GroupBrowserActivity.class);
        if (CommonFeatureOption.o(requireContext)) {
            W2().M(new ContactsMainListRightFragmentUiState.MyGroupUiState(true, r1()));
        } else {
            R7.b.f(requireContext, intent, 0, null, 6, null);
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    public void T3() {
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            ((ContactsTabActivity) activity).i3();
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment, com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, u7.InterfaceC1611a
    public void j0(boolean z10) {
        String str;
        super.j0(z10);
        L4();
        K4();
        g3();
        if (v4() && !z10) {
            U0.n.h();
            if (W2().I().getValue() instanceof ContactsMainListRightFragmentUiState.MyProfileUiState) {
                FragmentManager parentFragmentManager = getParentFragmentManager();
                ContactsMainListRightFragmentUiState value = W2().I().getValue();
                if (value != null) {
                    str = value.b();
                } else {
                    str = null;
                }
                Fragment m02 = parentFragmentManager.m0(str);
                if (m02 != null && (m02 instanceof GroupBrowserActivityFragment)) {
                    ((GroupBrowserActivityFragment) m02).g3();
                }
            }
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment, com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment
    public int j1() {
        return R.layout.contacts_main_list_fragment_layout_unfold;
    }

    public final void o4(boolean z10) {
        if (W2().y()) {
            if (W2().x()) {
                W2().M(new ContactsMainListRightFragmentUiState.NoContactSelectedUiState(r1(), z10));
            } else {
                W2().M(new ContactsMainListRightFragmentUiState.NoContactsUiState(r1(), z10));
            }
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment, com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ContactsMainListRightFragmentUiState contactsMainListRightFragmentUiState;
        super.onCreate(bundle);
        ContactUnfoldFragmentManager.f21504e.l(this);
        N2().J(this.f27984U);
        if (bundle != null) {
            contactsMainListRightFragmentUiState = (ContactsMainListRightFragmentUiState) bundle.getParcelable("rightFragmentUiState");
        } else {
            contactsMainListRightFragmentUiState = null;
        }
        if (contactsMainListRightFragmentUiState != null) {
            W2().M(contactsMainListRightFragmentUiState);
        }
    }

    @Override // com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        return super.onCreateView(inflater, viewGroup, bundle);
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment, com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            ((ContactsTabActivity) activity).v3();
        }
        K4();
        w4();
        if (W2().y() && W2().I().getValue() == null) {
            if (r1()) {
                if (W2().x()) {
                    W2().M(new ContactsMainListRightFragmentUiState.NoContactSelectedUiState(false, false));
                    return;
                } else {
                    W2().M(new ContactsMainListRightFragmentUiState.NoContactsUiState(true, false));
                    return;
                }
            }
            if (!W2().x()) {
                W2().M(new ContactsMainListRightFragmentUiState.NoContactsUiState(false, false));
            }
        }
    }

    public final void p4() {
        if (t1() && a3()) {
            G2(true);
        }
    }

    public final void q4() {
        o4(true);
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof ContactsTabActivity)) {
            ((ContactsTabActivity) activity).r3();
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    public void r3(int i10) {
        super.r3(i10);
        W2().K(false);
    }

    public final void r4() {
        if (!r1()) {
            W2().K(true);
            K4();
            W2().K(false);
        }
        if (Q2()) {
            L3(false);
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            d3(requireContext, T2());
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    public void s3(com.oplus.contacts.list.f item) {
        kotlin.jvm.internal.i.f(item, "item");
        Intent intent = new Intent(requireContext(), (Class<?>) CallDetailActivity.class);
        intent.setData(item.i());
        if (CommonFeatureOption.o(requireContext())) {
            g3();
            z4(intent);
        } else {
            R7.b.f(requireContext(), intent, 0, null, 6, null);
        }
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    /* renamed from: s4, reason: merged with bridge method [inline-methods] */
    public FoldableContactsMainListViewModel W2() {
        return (FoldableContactsMainListViewModel) this.f27983T.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(Intent intent) {
        kotlin.jvm.internal.i.f(intent, "intent");
        this.f27985V.a(intent);
        W2().K(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i10) {
        kotlin.jvm.internal.i.f(intent, "intent");
        super.startActivityForResult(intent, i10);
        W2().K(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean t4() {
        if (!t1()) {
            return false;
        }
        FrameLayout frameLayout = ((AbstractC1667e) l1()).f37702H;
        kotlin.jvm.internal.i.e(frameLayout, "viewDataBinding.foldableContactRightContainer");
        if (frameLayout.getVisibility() != 0) {
            return false;
        }
        ContactsMainListRightFragmentUiState value = W2().I().getValue();
        if ((value instanceof ContactsMainListRightFragmentUiState.DetailUiState) || (value instanceof ContactsMainListRightFragmentUiState.MyProfileUiState)) {
            return true;
        }
        return value instanceof ContactsMainListRightFragmentUiState.MyGroupUiState;
    }

    public final boolean u4() {
        String str;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        ContactsMainListRightFragmentUiState value = W2().I().getValue();
        GroupBrowserActivityFragment groupBrowserActivityFragment = null;
        if (value != null) {
            str = value.b();
        } else {
            str = null;
        }
        Fragment m02 = parentFragmentManager.m0(str);
        if (m02 instanceof GroupBrowserActivityFragment) {
            groupBrowserActivityFragment = (GroupBrowserActivityFragment) m02;
        }
        if (groupBrowserActivityFragment == null || !groupBrowserActivityFragment.f3()) {
            return false;
        }
        return true;
    }

    public final boolean v4() {
        if (W2().H() || a3() || U0.n.i() || Z3.j.e()) {
            return true;
        }
        ContactsTabActivity O22 = O2();
        if (O22 != null && O22.F2()) {
            return true;
        }
        return false;
    }

    @Override // com.oplus.contacts.list.fragment.ContactsMainListFragment
    public void w3(int i10) {
        super.w3(i10);
        if (i10 != -1) {
            W2().K(false);
        }
    }

    public final void w4() {
        FlowExtKt.c(W2().I(), this, new v9.l<ContactsMainListRightFragmentUiState, m9.q>() { // from class: com.oplus.contacts.list.fragment.FoldableContactsMainListFragment$observerRightFragmentTag$1
            {
                super(1);
            }

            public final void b(ContactsMainListRightFragmentUiState contactsMainListRightFragmentUiState) {
                if (contactsMainListRightFragmentUiState instanceof ContactsMainListRightFragmentUiState.NoContactsUiState) {
                    ContactsMainListRightFragmentUiState.NoContactsUiState noContactsUiState = (ContactsMainListRightFragmentUiState.NoContactsUiState) contactsMainListRightFragmentUiState;
                    FoldableContactsMainListFragment.this.E4(noContactsUiState.f(), noContactsUiState.b(), noContactsUiState.d());
                } else if (contactsMainListRightFragmentUiState instanceof ContactsMainListRightFragmentUiState.NoContactSelectedUiState) {
                    ContactsMainListRightFragmentUiState.NoContactSelectedUiState noContactSelectedUiState = (ContactsMainListRightFragmentUiState.NoContactSelectedUiState) contactsMainListRightFragmentUiState;
                    FoldableContactsMainListFragment.this.D4(noContactSelectedUiState.f(), noContactSelectedUiState.b(), noContactSelectedUiState.d());
                } else if (contactsMainListRightFragmentUiState instanceof ContactsMainListRightFragmentUiState.DetailUiState) {
                    ContactsMainListRightFragmentUiState.DetailUiState detailUiState = (ContactsMainListRightFragmentUiState.DetailUiState) contactsMainListRightFragmentUiState;
                    FoldableContactsMainListFragment.this.A4(detailUiState.f(), detailUiState.b());
                    FoldableContactsMainListFragment.this.y4();
                } else if (contactsMainListRightFragmentUiState instanceof ContactsMainListRightFragmentUiState.MyGroupUiState) {
                    FoldableContactsMainListFragment.this.B4(((ContactsMainListRightFragmentUiState.MyGroupUiState) contactsMainListRightFragmentUiState).b());
                } else if (contactsMainListRightFragmentUiState instanceof ContactsMainListRightFragmentUiState.MyProfileUiState) {
                    ContactsMainListRightFragmentUiState.MyProfileUiState myProfileUiState = (ContactsMainListRightFragmentUiState.MyProfileUiState) contactsMainListRightFragmentUiState;
                    FoldableContactsMainListFragment.this.C4(myProfileUiState.f(), myProfileUiState.b(), myProfileUiState.d());
                }
                FoldableContactsMainListFragment.this.L4();
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(ContactsMainListRightFragmentUiState contactsMainListRightFragmentUiState) {
                b(contactsMainListRightFragmentUiState);
                return m9.q.f35511a;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean x4() {
        CallDetailActivityFragment callDetailActivityFragment;
        GroupBrowserActivityFragment groupBrowserActivityFragment;
        CallDetailActivityFragment callDetailActivityFragment2;
        boolean z10 = false;
        if (!t1()) {
            return false;
        }
        boolean r12 = r1();
        if (H7.a.b()) {
            H7.b.b("FoldableContactsMainListFragment", "onBackPressed unfold = " + r12 + "; uiState = " + W2().I());
        }
        if (a3()) {
            G2(true);
            return true;
        }
        if (!r12) {
            FrameLayout frameLayout = ((AbstractC1667e) l1()).f37702H;
            kotlin.jvm.internal.i.e(frameLayout, "viewDataBinding.foldableContactRightContainer");
            if (frameLayout.getVisibility() != 0) {
                return false;
            }
        }
        ContactsMainListRightFragmentUiState value = W2().I().getValue();
        String str = null;
        if (value instanceof ContactsMainListRightFragmentUiState.DetailUiState) {
            Fragment m02 = getParentFragmentManager().m0(value.b());
            if (m02 != null) {
                if (m02 instanceof CallDetailActivityFragment) {
                    callDetailActivityFragment2 = (CallDetailActivityFragment) m02;
                } else {
                    callDetailActivityFragment2 = null;
                }
                if (callDetailActivityFragment2 != null && callDetailActivityFragment2.N3()) {
                    return true;
                }
            }
        } else if (value instanceof ContactsMainListRightFragmentUiState.MyGroupUiState) {
            Fragment m03 = getParentFragmentManager().m0(value.b());
            if (m03 != null) {
                if (m03 instanceof GroupBrowserActivityFragment) {
                    groupBrowserActivityFragment = (GroupBrowserActivityFragment) m03;
                } else {
                    groupBrowserActivityFragment = null;
                }
                if (groupBrowserActivityFragment != null && groupBrowserActivityFragment.h3()) {
                    return true;
                }
            }
        } else if (value instanceof ContactsMainListRightFragmentUiState.MyProfileUiState) {
            Fragment m04 = getParentFragmentManager().m0(value.b());
            if (m04 != null) {
                if (m04 instanceof CallDetailActivityFragment) {
                    callDetailActivityFragment = (CallDetailActivityFragment) m04;
                } else {
                    callDetailActivityFragment = null;
                }
                if (callDetailActivityFragment != null && callDetailActivityFragment.N3()) {
                    return true;
                }
            }
        } else {
            H7.b.b("FoldableContactsMainListFragment", "onBackPressed. do nothing in " + W2().I().getValue());
        }
        if (!r12 && W2().I().getValue() != null && !(W2().I().getValue() instanceof ContactsMainListRightFragmentUiState.NoContactsUiState) && !(W2().I().getValue() instanceof ContactsMainListRightFragmentUiState.NoContactSelectedUiState)) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            ContactsMainListRightFragmentUiState value2 = W2().I().getValue();
            if (value2 != null) {
                str = value2.b();
            }
            if (parentFragmentManager.m0(str) != null) {
                o4(true);
            }
            FrameLayout frameLayout2 = ((AbstractC1667e) l1()).f37702H;
            kotlin.jvm.internal.i.e(frameLayout2, "viewDataBinding.foldableContactRightContainer");
            if (frameLayout2.getVisibility() == 0) {
                return true;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (C0792c.d(activity)) {
                z10 = C0792c.e(activity, false);
            } else {
                activity.finish();
            }
            RawCleanerJobService.f20875b.b(activity);
        }
        return z10;
    }

    public final void y4() {
        ContactsTabActivity contactsTabActivity;
        FragmentActivity activity = getActivity();
        if (activity instanceof ContactsTabActivity) {
            contactsTabActivity = (ContactsTabActivity) activity;
        } else {
            contactsTabActivity = null;
        }
        if (contactsTabActivity != null) {
            contactsTabActivity.g3(true);
        }
    }
}
