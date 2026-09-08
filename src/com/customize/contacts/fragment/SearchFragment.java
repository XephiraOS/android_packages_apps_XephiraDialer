package com.customize.contacts.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.toolbar.COUIActionMenuView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.manager.ContactUnfoldFragmentManager;
import com.customize.contacts.ui.UnfoldContainerView;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.widget.DefaultContactListView;
import com.customize.contacts.widget.MultiChoiceListView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.FeatureUtil;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m1.AbstractC1315k;
import m1.C1304B;

/* compiled from: SearchFragment.kt */
/* loaded from: classes3.dex */
public final class SearchFragment extends m1.x implements x, UnfoldContainerView.b {

    /* renamed from: r1, reason: collision with root package name */
    public static final a f21258r1 = new a(null);

    /* renamed from: e1, reason: collision with root package name */
    public boolean f21259e1;

    /* renamed from: f1, reason: collision with root package name */
    public CallDetailActivityFragment f21260f1;

    /* renamed from: g1, reason: collision with root package name */
    public View f21261g1;

    /* renamed from: h1, reason: collision with root package name */
    public View f21262h1;

    /* renamed from: i1, reason: collision with root package name */
    public Animation f21263i1;

    /* renamed from: j1, reason: collision with root package name */
    public Animation f21264j1;

    /* renamed from: k1, reason: collision with root package name */
    public DefaultContactListView f21265k1;

    /* renamed from: l1, reason: collision with root package name */
    public View f21266l1;

    /* renamed from: m1, reason: collision with root package name */
    public String f21267m1 = "";

    /* renamed from: n1, reason: collision with root package name */
    public int f21268n1;

    /* renamed from: o1, reason: collision with root package name */
    public int f21269o1;

    /* renamed from: p1, reason: collision with root package name */
    public final androidx.fragment.app.v f21270p1;

    /* renamed from: q1, reason: collision with root package name */
    public final c f21271q1;

    /* compiled from: SearchFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SearchFragment.kt */
    /* loaded from: classes3.dex */
    public interface b {

        /* compiled from: SearchFragment.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            public static /* synthetic */ void a(b bVar, boolean z10, int i10, Object obj) {
                if (obj == null) {
                    if ((i10 & 1) != 0) {
                        z10 = true;
                    }
                    bVar.h(z10);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitSearchFragment");
            }
        }

        void h(boolean z10);
    }

    /* compiled from: SearchFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c implements C1304B.d {
        public c() {
        }

        @Override // m1.C1304B.d
        public boolean a(Uri uri) {
            CallDetailActivityFragment callDetailActivityFragment;
            Uri uri2;
            if (uri != null && SearchFragment.this.f21259e1 && (callDetailActivityFragment = SearchFragment.this.f21260f1) != null) {
                Intent t12 = callDetailActivityFragment.t1();
                if (t12 != null) {
                    uri2 = t12.getData();
                } else {
                    uri2 = null;
                }
                if (kotlin.jvm.internal.i.b(uri, uri2)) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public SearchFragment() {
        this.f35043O0 = m1.x.f35037d1.getAndIncrement();
        k2(true);
        p2(true);
        t2(true);
        this.f35044P0 = this;
        this.f21270p1 = new androidx.fragment.app.v() { // from class: com.customize.contacts.fragment.G
            @Override // androidx.fragment.app.v
            public final void a(FragmentManager fragmentManager, Fragment fragment) {
                SearchFragment.G3(SearchFragment.this, fragmentManager, fragment);
            }
        };
        this.f21271q1 = new c();
    }

    public static final void G3(SearchFragment this$0, FragmentManager fragmentManager, Fragment fragment) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(fragmentManager, "<anonymous parameter 0>");
        kotlin.jvm.internal.i.f(fragment, "fragment");
        String tag = fragment.getTag();
        if (tag != null && tag.hashCode() == -988923278 && tag.equals("search_unfold_contact")) {
            this$0.f21260f1 = (CallDetailActivityFragment) fragment;
        }
    }

    private final void J3() {
        Animation animation = this.f21264j1;
        if (animation == null) {
            animation = AnimationUtils.loadAnimation(getContext(), R.anim.coui_close_slide_enter);
        }
        if (animation != null) {
            this.f21264j1 = animation;
            View view = this.f21262h1;
            if (view != null) {
                view.setAnimation(animation);
            }
            animation.start();
        }
    }

    public static final void N3(SearchFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        SoftKeyboardUtil.a().b(this$0.f21262h1);
        this$0.I3();
    }

    private final boolean Q3() {
        if (U0.n.i() || Z3.j.e()) {
            return true;
        }
        return false;
    }

    private final void U3() {
        View view;
        View view2;
        int i10 = 2;
        if (!this.f21259e1 && this.f21260f1 != null && (view2 = this.f21261g1) != null && view2.getVisibility() == 0) {
            i10 = 4;
        }
        View view3 = getView();
        if (view3 != null) {
            view = view3.findViewById(R.id.contacts_container_list);
        } else {
            view = null;
        }
        if (view != null) {
            view.setImportantForAccessibility(i10);
        }
    }

    @Override // m1.x, m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        DefaultContactListView defaultContactListView;
        boolean z10;
        super.A1(view);
        if (view != null) {
            defaultContactListView = (DefaultContactListView) view.findViewById(android.R.id.list);
        } else {
            defaultContactListView = null;
        }
        this.f21265k1 = defaultContactListView;
        if (defaultContactListView != null) {
            if (FeatureUtil.V() && !this.f21259e1) {
                z10 = true;
            } else {
                z10 = false;
            }
            defaultContactListView.setPercentIndentEnabled(z10);
        }
        MultiChoiceListView multiChoiceListView = this.f35041M0;
        if (multiChoiceListView != null) {
            multiChoiceListView.setVisibility(8);
        }
        this.f34960f = true;
    }

    public final void H3() {
        S3();
    }

    public final void I3() {
        LayoutInflater.Factory activity = getActivity();
        if (activity != null && (activity instanceof b)) {
            b.a.a((b) activity, false, 1, null);
        }
    }

    public final void K3() {
        COUISearchBar cOUISearchBar = this.f34972l;
        if (cOUISearchBar != null) {
            cOUISearchBar.openSoftInput(false);
        }
    }

    public final View L3(LayoutInflater layoutInflater) {
        View view = layoutInflater.inflate(R.layout.contact_main_list_content_unfold, (ViewGroup) null);
        O3((COUIToolbar) view.findViewById(R.id.toolbar));
        M3((COUIToolbar) view.findViewById(R.id.toolbar));
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.contact_list_view_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        kotlin.jvm.internal.i.e(view, "view");
        return view;
    }

    public final void M3(COUIToolbar cOUIToolbar) {
        EditText searchEditText;
        TextView functionalButton;
        if (cOUIToolbar != null && this.f34972l == null) {
            COUISearchBar cOUISearchBar = new COUISearchBar(cOUIToolbar.getContext());
            this.f34972l = cOUISearchBar;
            cOUISearchBar.setPadding(cOUIToolbar.getContext().getResources().getDimensionPixelSize(R.dimen.DP_16), 0, cOUIToolbar.getContext().getResources().getDimensionPixelSize(R.dimen.DP_16), 0);
            COUISearchBar cOUISearchBar2 = this.f34972l;
            if (cOUISearchBar2 != null) {
                cOUISearchBar2.setBackground(null);
            }
            COUISearchBar cOUISearchBar3 = this.f34972l;
            if (cOUISearchBar3 != null && (functionalButton = cOUISearchBar3.getFunctionalButton()) != null) {
                functionalButton.setOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.fragment.H
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SearchFragment.N3(SearchFragment.this, view);
                    }
                });
            }
            v3(cOUIToolbar.getContext(), this.f34972l);
            COUISearchBar cOUISearchBar4 = this.f34972l;
            if (cOUISearchBar4 != null && (searchEditText = cOUISearchBar4.getSearchEditText()) != null) {
                searchEditText.setHint(R.string.searchHint);
            }
        }
    }

    public final void O3(COUIToolbar cOUIToolbar) {
        if (cOUIToolbar != null) {
            cOUIToolbar.inflateMenu(R.menu.people_menu);
        }
    }

    public final void P3(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        kotlin.jvm.internal.i.e(from, "from(context)");
        this.f21266l1 = L3(from);
    }

    public final boolean R3() {
        View view;
        if (this.f21259e1 || ((view = this.f21261g1) != null && view.getVisibility() == 8)) {
            return false;
        }
        Fragment m02 = getChildFragmentManager().m0("search_unfold_contact");
        if (m02 instanceof CallDetailActivityFragment) {
            if (!((CallDetailActivityFragment) m02).N3()) {
                S3();
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // m1.x, m1.AbstractC1310f, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> loader, Cursor cursor) {
        kotlin.jvm.internal.i.f(loader, "loader");
        super.S0(loader, cursor);
        if (this.f34962g) {
            MultiChoiceListView multiChoiceListView = this.f35041M0;
            if (multiChoiceListView != null) {
                multiChoiceListView.setVisibility(0);
                return;
            }
            return;
        }
        MultiChoiceListView multiChoiceListView2 = this.f35041M0;
        if (multiChoiceListView2 != null) {
            multiChoiceListView2.setVisibility(8);
        }
    }

    public final void S3() {
        Fragment m02 = getChildFragmentManager().m0("search_unfold_contact");
        this.f21260f1 = null;
        if (m02 != null) {
            androidx.fragment.app.B p10 = getChildFragmentManager().p();
            kotlin.jvm.internal.i.e(p10, "childFragmentManager.beginTransaction()");
            if (this.f21259e1) {
                p10.u(0, R.anim.unfold_fragment_alpha_out);
            } else {
                p10.u(0, R.anim.coui_close_slide_exit);
                J3();
            }
            p10.r(m02);
            p10.j();
            U3();
        }
    }

    public final void T3() {
        Fragment m02 = getChildFragmentManager().m0("search_unfold_contact");
        if (m02 != null) {
            if (!this.f21259e1) {
                if (Q3()) {
                    View view = m02.getView();
                    if (view != null) {
                        view.setVisibility(8);
                        return;
                    }
                    return;
                }
                View view2 = m02.getView();
                if (view2 != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            View view3 = m02.getView();
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
    }

    public final void V3() {
        int o22;
        FragmentActivity activity = getActivity();
        View view = getView();
        if (view != null && (activity instanceof ContactsTabActivity) && view.getPaddingBottom() != (o22 = ((ContactsTabActivity) activity).o2())) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), o22);
        }
    }

    @Override // com.customize.contacts.fragment.x
    public void X(Animation animation) {
        View view = this.f21262h1;
        if (view != null) {
            Animation animation2 = this.f21263i1;
            if (animation2 == null && (animation2 = AnimationUtils.loadAnimation(getContext(), R.anim.coui_open_slide_exit)) != null) {
                this.f21263i1 = animation2;
            }
            if (animation2 != null && animation != null) {
                view.setAnimation(animation2);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(animation2);
                animationSet.addAnimation(animation);
                animationSet.start();
            }
        }
    }

    @Override // m1.x, m1.AbstractViewOnFocusChangeListenerC1314j
    /* renamed from: c3, reason: merged with bridge method [inline-methods] */
    public AbstractC1315k k1() {
        AbstractC1315k adapter = super.k1();
        if (adapter instanceof C1304B) {
            ((C1304B) adapter).z1(this.f21271q1);
        }
        kotlin.jvm.internal.i.e(adapter, "adapter");
        return adapter;
    }

    @Override // com.customize.contacts.ui.UnfoldContainerView.b
    public boolean o() {
        return this.f21259e1;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        boolean z10;
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        boolean z11 = this.f21259e1;
        boolean r10 = DisplayUtil.r(getActivity(), newConfig, null, 4, null);
        this.f21259e1 = r10;
        if (r10 != z11) {
            T3();
            U3();
            DefaultContactListView defaultContactListView = this.f21265k1;
            if (defaultContactListView != null) {
                if (FeatureUtil.V() && !this.f21259e1) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                defaultContactListView.setPercentIndentEnabled(z10);
            }
        }
    }

    @Override // m1.x, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Window window;
        int b10;
        super.onCreate(bundle);
        getChildFragmentManager().k(this.f21270p1);
        ContactUnfoldFragmentManager.f21504e.m(this);
        if (bundle != null) {
            String string = bundle.getString("last_search_text", "");
            kotlin.jvm.internal.i.e(string, "savedState.getString(LAST_SEARCH_TEXT, \"\")");
            this.f21267m1 = string;
            this.f21268n1 = bundle.getInt("last_search_text_start", 0);
            b10 = B9.i.b(bundle.getInt("last_search_text_end", 0), this.f21268n1);
            this.f21269o1 = b10;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(16);
        }
    }

    @Override // m1.x, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        EditText searchEditText;
        EditText searchEditText2;
        COUIToolbar cOUIToolbar;
        kotlin.jvm.internal.i.f(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        Context context = getContext();
        if (context != null && (cOUIToolbar = this.f35048T0) != null) {
            cOUIToolbar.setSearchView(this.f34972l, new COUIToolbar.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.search_view_height)));
        }
        COUISearchBar cOUISearchBar = this.f34972l;
        if (cOUISearchBar != null && (searchEditText2 = cOUISearchBar.getSearchEditText()) != null) {
            searchEditText2.setText(this.f21267m1);
        }
        COUISearchBar cOUISearchBar2 = this.f34972l;
        if (cOUISearchBar2 != null && (searchEditText = cOUISearchBar2.getSearchEditText()) != null) {
            searchEditText.setSelection(this.f21268n1, this.f21269o1);
        }
        COUISearchBar cOUISearchBar3 = this.f34972l;
        View view2 = null;
        if (cOUISearchBar3 != null) {
            view = cOUISearchBar3.findViewById(R.id.animated_search_icon);
        } else {
            view = null;
        }
        if (view != null) {
            view.setContentDescription(getResources().getString(R.string.menu_search));
        }
        COUISearchBar cOUISearchBar4 = this.f34972l;
        if (cOUISearchBar4 != null) {
            view2 = cOUISearchBar4.getQuickDeleteButton();
        }
        if (view2 != null) {
            view2.setContentDescription(getResources().getString(R.string.delete_button));
        }
        return onCreateView;
    }

    @Override // m1.x, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onDestroy() {
        COUIActionMenuView cOUIActionMenuView;
        Window window;
        getChildFragmentManager().o1(this.f21270p1);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(51);
        }
        COUIToolbar cOUIToolbar = this.f35048T0;
        if (cOUIToolbar != null) {
            cOUIActionMenuView = cOUIToolbar.getMenuView();
        } else {
            cOUIActionMenuView = null;
        }
        if (cOUIActionMenuView != null) {
            cOUIActionMenuView.setVisibility(0);
        }
        super.onDestroy();
    }

    @Override // m1.x, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        C1248i.d(androidx.lifecycle.p.a(this), S.c(), null, new SearchFragment$onResume$1(this, null), 2, null);
    }

    @Override // m1.AbstractC1310f, m1.AbstractViewOnFocusChangeListenerC1314j, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        String str;
        int i10;
        Editable text;
        kotlin.jvm.internal.i.f(outState, "outState");
        EditText editText = this.f34970k;
        if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
            str = "";
        }
        outState.putString("last_search_text", str);
        EditText editText2 = this.f34970k;
        int i11 = 0;
        if (editText2 != null) {
            i10 = editText2.getSelectionStart();
        } else {
            i10 = 0;
        }
        outState.putInt("last_search_text_start", i10);
        EditText editText3 = this.f34970k;
        if (editText3 != null) {
            i11 = editText3.getSelectionEnd();
        }
        outState.putInt("last_search_text_end", i11);
        super.onSaveInstanceState(outState);
    }

    @Override // m1.x, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        boolean z10 = false;
        onStateChange(0, 1);
        CoordinatorLayout.e eVar = this.f35050V0;
        if (eVar != null) {
            eVar.o(null);
        }
        this.f21259e1 = DisplayUtil.r(getActivity(), null, null, 6, null);
        DefaultContactListView defaultContactListView = this.f21265k1;
        if (defaultContactListView != null) {
            if (FeatureUtil.V() && !this.f21259e1) {
                z10 = true;
            }
            defaultContactListView.setPercentIndentEnabled(z10);
        }
        this.f21261g1 = view.findViewById(R.id.contacts_container_content);
        this.f21262h1 = view.findViewById(R.id.contacts_container_list);
        V3();
    }

    @Override // m1.x
    public void w3(Intent intent) {
        View view;
        Uri data;
        Uri uri;
        kotlin.jvm.internal.i.f(intent, "intent");
        Fragment m02 = getChildFragmentManager().m0("search_unfold_contact");
        if (m02 != null && (m02 instanceof CallDetailActivityFragment) && (data = intent.getData()) != null) {
            Intent t12 = ((CallDetailActivityFragment) m02).t1();
            if (t12 != null) {
                uri = t12.getData();
            } else {
                uri = null;
            }
            if (data.equals(uri) && this.f21259e1) {
                return;
            }
        }
        CallDetailActivityFragment callDetailActivityFragment = new CallDetailActivityFragment();
        callDetailActivityFragment.X1(false, false);
        callDetailActivityFragment.V1(intent);
        this.f21260f1 = callDetailActivityFragment;
        if (this.f21259e1) {
            androidx.fragment.app.B p10 = getChildFragmentManager().p();
            kotlin.jvm.internal.i.e(p10, "childFragmentManager.beginTransaction()");
            p10.u(R.anim.unfold_fragment_alpha_in, R.anim.unfold_fragment_alpha_out);
            p10.t(R.id.contacts_container_content, callDetailActivityFragment, "search_unfold_contact");
            p10.j();
        } else {
            Fragment m03 = getChildFragmentManager().m0("search_unfold_contact");
            if (m03 != null && (view = m03.getView()) != null) {
                view.setVisibility(8);
            }
            androidx.fragment.app.B p11 = getChildFragmentManager().p();
            kotlin.jvm.internal.i.e(p11, "childFragmentManager.beginTransaction()");
            p11.t(R.id.contacts_container_content, callDetailActivityFragment, "search_unfold_contact");
            p11.j();
            callDetailActivityFragment.W1();
        }
        U3();
    }

    @Override // m1.x, m1.AbstractViewOnFocusChangeListenerC1314j
    public View z1(LayoutInflater inflater, ViewGroup viewGroup) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        View view = this.f21266l1;
        if (view == null) {
            view = L3(inflater);
        }
        this.f21266l1 = null;
        UnfoldContainerView unfoldContainerView = (UnfoldContainerView) view.findViewById(R.id.contacts_fragment_layout);
        if (unfoldContainerView != null) {
            unfoldContainerView.setUseFold(true);
        }
        if (unfoldContainerView != null) {
            unfoldContainerView.setOnIsShowUnfoldScreenListener(this);
        }
        return view;
    }
}
