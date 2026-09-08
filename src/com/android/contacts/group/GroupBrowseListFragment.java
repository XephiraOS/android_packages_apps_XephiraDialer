package com.android.contacts.group;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.w;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel;
import com.android.contacts.group.GroupBrowseListFragment;
import com.android.contacts.group.c;
import com.android.contacts.group.viewmodel.GroupBrowseListViewModel;
import com.android.contacts.model.Account;
import com.android.contacts.util.C;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.coui.appcompat.tooltips.COUIToolTips;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.SmartGroupActivity;
import com.customize.contacts.activities.ViewGroupActivity;
import com.customize.contacts.util.C0810v;
import com.customize.contacts.util.C0814z;
import com.customize.contacts.util.G;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Result;
import kotlin.collections.o;
import m9.q;
import o1.C1393c;
import q7.C1493b;
import q7.InterfaceC1492a;
import q7.InterfaceC1494c;
import r0.C1501d;
import v9.InterfaceC1637a;

/* compiled from: GroupBrowseListFragment.kt */
/* loaded from: classes.dex */
public final class GroupBrowseListFragment extends Fragment implements View.OnFocusChangeListener, c.b, w7.b, InterfaceC1492a {

    /* renamed from: I, reason: collision with root package name */
    public static final a f16573I = new a(null);

    /* renamed from: A, reason: collision with root package name */
    public String f16574A;

    /* renamed from: b, reason: collision with root package name */
    public GroupBrowseListViewModel f16583b;

    /* renamed from: c, reason: collision with root package name */
    public View f16584c;

    /* renamed from: d, reason: collision with root package name */
    public HeaderFooterRecyclerView f16585d;

    /* renamed from: e, reason: collision with root package name */
    public G f16586e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f16587f;

    /* renamed from: g, reason: collision with root package name */
    public com.android.contacts.group.c f16588g;

    /* renamed from: h, reason: collision with root package name */
    public int f16589h;

    /* renamed from: i, reason: collision with root package name */
    public int f16590i;

    /* renamed from: k, reason: collision with root package name */
    public Uri f16592k;

    /* renamed from: l, reason: collision with root package name */
    public String f16593l;

    /* renamed from: n, reason: collision with root package name */
    public c f16595n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f16596o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f16597p;

    /* renamed from: q, reason: collision with root package name */
    public COUIToolTips f16598q;

    /* renamed from: r, reason: collision with root package name */
    public MenuItem f16599r;

    /* renamed from: x, reason: collision with root package name */
    public MenuItem f16600x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f16601y;

    /* renamed from: z, reason: collision with root package name */
    public COUIToolbar f16602z;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1493b f16582a = new C1493b();

    /* renamed from: j, reason: collision with root package name */
    public int f16591j = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f16594m = 2;

    /* renamed from: B, reason: collision with root package name */
    public final b f16575B = new b(this, new Handler(Looper.getMainLooper()));

    /* renamed from: C, reason: collision with root package name */
    public final e f16576C = new e(this, new Handler(Looper.getMainLooper()));

    /* renamed from: D, reason: collision with root package name */
    public d f16577D = new d();

    /* renamed from: E, reason: collision with root package name */
    public final m9.d f16578E = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(TabActivityViewModel.class), new InterfaceC1637a<M>() { // from class: com.android.contacts.group.GroupBrowseListFragment$special$$inlined$activityViewModels$default$1
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
    }, new InterfaceC1637a<K.b>() { // from class: com.android.contacts.group.GroupBrowseListFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: F, reason: collision with root package name */
    public boolean f16579F = true;

    /* renamed from: G, reason: collision with root package name */
    public boolean f16580G = true;

    /* renamed from: H, reason: collision with root package name */
    public final Z3.h f16581H = new f();

    /* compiled from: GroupBrowseListFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: GroupBrowseListFragment.kt */
    /* loaded from: classes.dex */
    public final class b extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f16603a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GroupBrowseListFragment f16604b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GroupBrowseListFragment groupBrowseListFragment, Handler handler) {
            super(handler);
            kotlin.jvm.internal.i.f(handler, "handler");
            this.f16604b = groupBrowseListFragment;
            this.f16603a = handler;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            if (H7.a.b()) {
                H7.b.b("GroupBrowseListFragment", "onChange");
            }
            this.f16604b.R1().k();
        }
    }

    /* compiled from: GroupBrowseListFragment.kt */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();

        void c(Uri uri, String str);

        void d();
    }

    /* compiled from: GroupBrowseListFragment.kt */
    /* loaded from: classes.dex */
    public final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GroupBrowseListFragment.this.K1(view);
        }
    }

    /* compiled from: GroupBrowseListFragment.kt */
    /* loaded from: classes.dex */
    public final class e extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f16606a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GroupBrowseListFragment f16607b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(GroupBrowseListFragment groupBrowseListFragment, Handler handler) {
            super(handler);
            kotlin.jvm.internal.i.f(handler, "handler");
            this.f16607b = groupBrowseListFragment;
            this.f16606a = handler;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            if (H7.a.b()) {
                H7.b.b("GroupBrowseListFragment", "VipGroup onChange");
            }
            this.f16607b.R1().l();
        }
    }

    /* compiled from: GroupBrowseListFragment.kt */
    /* loaded from: classes.dex */
    public static final class f implements Z3.h {
        public f() {
        }

        @Override // Z3.h
        public void a(boolean z10) {
            MenuItem menuItem;
            Menu menu;
            Menu menu2;
            Menu menu3;
            COUIToolbar cOUIToolbar = GroupBrowseListFragment.this.f16602z;
            if (cOUIToolbar != null && (menu3 = cOUIToolbar.getMenu()) != null) {
                menu3.clear();
            }
            MenuItem menuItem2 = null;
            if (z10) {
                COUIToolbar cOUIToolbar2 = GroupBrowseListFragment.this.f16602z;
                if (cOUIToolbar2 != null) {
                    GroupBrowseListFragment groupBrowseListFragment = GroupBrowseListFragment.this;
                    cOUIToolbar2.setIsTitleCenterStyle(false);
                    Fragment parentFragment = groupBrowseListFragment.getParentFragment();
                    if ((parentFragment instanceof GroupBrowserActivityFragment) && ((GroupBrowserActivityFragment) parentFragment).E1() && groupBrowseListFragment.f16579F) {
                        cOUIToolbar2.setNavigationIcon((Drawable) null);
                    } else {
                        cOUIToolbar2.setNavigationIcon(R.drawable.coui_back_arrow);
                        cOUIToolbar2.setNavigationContentDescription(R.string.abc_action_bar_up_description);
                    }
                    cOUIToolbar2.inflateMenu(R.menu.select_menu);
                }
                GroupBrowseListFragment groupBrowseListFragment2 = GroupBrowseListFragment.this;
                COUIToolbar cOUIToolbar3 = groupBrowseListFragment2.f16602z;
                if (cOUIToolbar3 != null && (menu2 = cOUIToolbar3.getMenu()) != null) {
                    menuItem = menu2.findItem(R.id.menu_add);
                } else {
                    menuItem = null;
                }
                groupBrowseListFragment2.f16599r = menuItem;
                GroupBrowseListFragment groupBrowseListFragment3 = GroupBrowseListFragment.this;
                COUIToolbar cOUIToolbar4 = groupBrowseListFragment3.f16602z;
                if (cOUIToolbar4 != null && (menu = cOUIToolbar4.getMenu()) != null) {
                    menuItem2 = menu.findItem(R.id.menu_select);
                }
                groupBrowseListFragment3.f16600x = menuItem2;
                e();
                return;
            }
            COUIToolbar cOUIToolbar5 = GroupBrowseListFragment.this.f16602z;
            if (cOUIToolbar5 != null) {
                cOUIToolbar5.setNavigationIcon((Drawable) null);
                cOUIToolbar5.setIsTitleCenterStyle(true);
                cOUIToolbar5.inflateMenu(R.menu.cancel_select_menu);
            }
            d();
        }

        @Override // Z3.h
        public void b() {
            BasicActivity basicActivity = null;
            if (!FeatureUtil.V() || GroupBrowseListFragment.this.f16579F || DisplayUtil.j(GroupBrowseListFragment.this.getActivity())) {
                HeaderFooterRecyclerView headerFooterRecyclerView = GroupBrowseListFragment.this.f16585d;
                if (headerFooterRecyclerView == null) {
                    kotlin.jvm.internal.i.q("recyclerView");
                    headerFooterRecyclerView = null;
                }
                headerFooterRecyclerView.i(GroupBrowseListFragment.this.requireContext().getResources().getDimensionPixelSize(R.dimen.DP_70), 0, 0, 0);
            } else {
                HeaderFooterRecyclerView headerFooterRecyclerView2 = GroupBrowseListFragment.this.f16585d;
                if (headerFooterRecyclerView2 == null) {
                    kotlin.jvm.internal.i.q("recyclerView");
                    headerFooterRecyclerView2 = null;
                }
                headerFooterRecyclerView2.i(GroupBrowseListFragment.this.requireContext().getResources().getDimensionPixelSize(R.dimen.DP_155), 0, 0, 0);
            }
            GroupBrowseListFragment.this.f16601y = true;
            GroupBrowseListFragment.this.P1().q(GroupBrowseListFragment.this.f16601y);
            GroupBrowseListFragment.this.T1().n(2);
            c cVar = GroupBrowseListFragment.this.f16595n;
            if (cVar != null) {
                cVar.b();
            }
            com.android.contacts.group.c cVar2 = GroupBrowseListFragment.this.f16588g;
            if (cVar2 == null) {
                kotlin.jvm.internal.i.q("groupAdapter");
                cVar2 = null;
            }
            cVar2.notifyDataSetChanged();
            GroupBrowseListFragment.this.e2(true);
            GroupBrowseListFragment.this.k2(true);
            a(false);
            if (!GroupBrowseListFragment.this.f16579F) {
                FragmentActivity activity = GroupBrowseListFragment.this.getActivity();
                if (activity instanceof BasicActivity) {
                    basicActivity = (BasicActivity) activity;
                }
                if (basicActivity != null) {
                    basicActivity.f1(basicActivity, false, GroupBrowseListFragment.this.Z1());
                }
            }
        }

        @Override // Z3.h
        public void c() {
            GroupBrowseListFragment.this.f16601y = false;
            G P12 = GroupBrowseListFragment.this.P1();
            P12.q(GroupBrowseListFragment.this.f16601y);
            P12.o(false);
            c cVar = GroupBrowseListFragment.this.f16595n;
            GroupBrowseListFragment groupBrowseListFragment = GroupBrowseListFragment.this;
            if (cVar == null) {
                groupBrowseListFragment.T1().n(0);
            } else {
                groupBrowseListFragment.T1().n(1);
                cVar.d();
            }
            com.android.contacts.group.c cVar2 = GroupBrowseListFragment.this.f16588g;
            BasicActivity basicActivity = null;
            if (cVar2 == null) {
                kotlin.jvm.internal.i.q("groupAdapter");
                cVar2 = null;
            }
            cVar2.notifyDataSetChanged();
            GroupBrowseListFragment.this.e2(false);
            GroupBrowseListFragment.this.k2(true);
            a(true);
            if (!GroupBrowseListFragment.this.f16579F) {
                FragmentActivity activity = GroupBrowseListFragment.this.getActivity();
                if (activity instanceof BasicActivity) {
                    basicActivity = (BasicActivity) activity;
                }
                if (basicActivity != null) {
                    basicActivity.f1(basicActivity, true, GroupBrowseListFragment.this.Z1());
                }
            }
        }

        @Override // Z3.h
        public void d() {
            COUIToolbar cOUIToolbar = GroupBrowseListFragment.this.f16602z;
            if (cOUIToolbar != null) {
                cOUIToolbar.setTitle(GroupBrowseListFragment.this.P1().d());
            }
            g();
        }

        @Override // Z3.h
        public void e() {
            COUIToolbar cOUIToolbar = GroupBrowseListFragment.this.f16602z;
            if (cOUIToolbar != null) {
                cOUIToolbar.setTitle(R.string.oplus_my_groups);
            }
        }

        @Override // Z3.h
        public void f(boolean z10) {
            MenuItem menuItem = GroupBrowseListFragment.this.f16600x;
            if (menuItem != null) {
                menuItem.setVisible(z10);
            }
            MenuItem menuItem2 = GroupBrowseListFragment.this.f16599r;
            if (menuItem2 != null) {
                menuItem2.setVisible(true);
            }
        }

        @Override // Z3.h
        public void g() {
            COUIToolbar cOUIToolbar = GroupBrowseListFragment.this.f16602z;
            if (cOUIToolbar != null) {
                if (GroupBrowseListFragment.this.P1().h()) {
                    cOUIToolbar.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectcancel);
                } else {
                    cOUIToolbar.getMenu().findItem(R.id.select_all).setTitle(R.string.oplus_option_selectall);
                }
            }
        }
    }

    /* compiled from: GroupBrowseListFragment.kt */
    /* loaded from: classes.dex */
    public static final class g implements w, kotlin.jvm.internal.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.l f16609a;

        public g(v9.l function) {
            kotlin.jvm.internal.i.f(function, "function");
            this.f16609a = function;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof w) || !(obj instanceof kotlin.jvm.internal.g)) {
                return false;
            }
            return kotlin.jvm.internal.i.b(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.g
        public final m9.c<?> getFunctionDelegate() {
            return this.f16609a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object obj) {
            this.f16609a.invoke(obj);
        }
    }

    public static final boolean E1(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final void I1(GroupBrowseListFragment this$0, Context context, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(context, "$context");
        if (this$0.f16598q == null) {
            COUIToolTips cOUIToolTips = new COUIToolTips(context, 1);
            this$0.f16598q = cOUIToolTips;
            TextView contentTv = cOUIToolTips.getContentTv();
            if (contentTv != null) {
                contentTv.setTextDirection(5);
            }
            COUIToolTips cOUIToolTips2 = this$0.f16598q;
            if (cOUIToolTips2 != null) {
                cOUIToolTips2.setContent(context.getString(GroupBrowseListViewModel.f16706g.a()));
            }
            COUIToolTips cOUIToolTips3 = this$0.f16598q;
            if (cOUIToolTips3 != null) {
                cOUIToolTips3.setDismissOnTouchOutside(true);
            }
        }
        COUIToolTips cOUIToolTips4 = this$0.f16598q;
        if (cOUIToolTips4 != null && !cOUIToolTips4.isShowing()) {
            cOUIToolTips4.show(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1(View view) {
        Object obj;
        c.C0169c c0169c;
        boolean z10;
        String[] b10;
        boolean z11;
        String[] b11;
        FragmentActivity activity;
        KeyEvent.Callback callback;
        if (H7.a.b()) {
            H7.b.b("GroupBrowseListFragment", "clickItem");
        }
        CheckBox checkBox = null;
        if (view != null) {
            obj = view.getTag();
        } else {
            obj = null;
        }
        if (obj instanceof c.C0169c) {
            c0169c = (c.C0169c) obj;
        } else {
            c0169c = null;
        }
        if (P1().g()) {
            if (view != null) {
                callback = view.findViewById(R.id.listview_scrollchoice_checkbox);
            } else {
                callback = null;
            }
            if (callback instanceof CheckBox) {
                checkBox = (CheckBox) callback;
            }
            P1().k(checkBox, true);
            if (c0169c != null && checkBox != null) {
                C.b(c0169c.k(), checkBox.isChecked());
                return;
            }
            return;
        }
        if (c0169c == null) {
            return;
        }
        long l10 = c0169c.l();
        if (l10 == -2 && (activity = getActivity()) != null) {
            String str = C1501d.f36275d;
            if (com.android.contacts.framework.baseui.util.l.d(activity, str)) {
                com.android.contacts.framework.baseui.util.l.f(activity, str, null, 0);
                return;
            }
        }
        if (l10 != -1 && l10 != -2) {
            String str2 = "sort_key_alt";
            if (l10 == -3) {
                Intent intent = new Intent(getContext(), (Class<?>) ViewGroupActivity.class);
                intent.putExtra("group_name", getResources().getString(R.string.oplus_vip_group));
                intent.putExtra("group_mode", 4);
                Bundle bundle = new Bundle();
                C1393c c1393c = new C1393c(getContext());
                String b12 = C0814z.b(C0810v.d());
                Uri J12 = J1();
                if (c1393c.g() == 2) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                bundle.putString("SELECTION", b12);
                bundle.putParcelable("URI", J12);
                if (c1393c.h() == 1) {
                    str2 = "sort_key";
                }
                bundle.putString("ORDER", str2);
                if (z11) {
                    b11 = R0.b.c();
                } else {
                    b11 = R0.b.b();
                }
                bundle.putStringArray("PROJECTION", b11);
                intent.putExtras(bundle);
                R7.b.f(getActivity(), intent, 0, null, 6, null);
                return;
            }
            if (l10 == -5) {
                Account account = new Account(R0.a.f3165a, R0.a.f3166b);
                long j10 = N3.b.j(getContext(), "Business Card in ColorOS", account);
                if (j10 == -1) {
                    j10 = N3.b.g(getContext(), account);
                }
                Uri withAppendedId = ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, j10);
                kotlin.jvm.internal.i.e(withAppendedId, "withAppendedId(ContactsC…ENT_URI, businessGroupId)");
                Uri withAppendedId2 = ContentUris.withAppendedId(C0814z.f22203a, ContentUris.parseId(withAppendedId));
                kotlin.jvm.internal.i.e(withAppendedId2, "withAppendedId(\n        …eId(it)\n                )");
                C1393c c1393c2 = new C1393c(getContext());
                if (c1393c2.g() == 2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("URI", withAppendedId2);
                if (c1393c2.h() == 1) {
                    str2 = "sort_key";
                }
                bundle2.putString("ORDER", str2);
                if (z10) {
                    b10 = R0.b.c();
                } else {
                    b10 = R0.b.b();
                }
                bundle2.putStringArray("PROJECTION", b10);
                Intent intent2 = new Intent(getContext(), (Class<?>) ViewGroupActivity.class);
                intent2.setData(withAppendedId);
                intent2.putExtra("group_name", getResources().getString(R.string.oplus_business_card));
                intent2.putExtra("group_mode", 6);
                intent2.putExtras(bundle2);
                R7.b.f(getActivity(), intent2, 0, null, 6, null);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(BreenoCallContract.SummaryColumns.COUNT, Integer.valueOf(c0169c.q()));
            A.a(getActivity(), 2000308, 200030049, hashMap, false);
            r2(c0169c.r(), c0169c.n());
            return;
        }
        Intent intent3 = new Intent(getContext(), (Class<?>) SmartGroupActivity.class);
        intent3.putExtra("GroupMode", l10);
        intent3.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        R7.b.f(getContext(), intent3, 0, null, 6, null);
    }

    private final void L1() {
        int i10;
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f16585d;
        HeaderFooterRecyclerView headerFooterRecyclerView2 = null;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        headerFooterRecyclerView.setVerticalScrollbarPosition(headerFooterRecyclerView.getVerticalScrollbarPosition());
        headerFooterRecyclerView.setScrollBarStyle(33554432);
        Context context = getContext();
        int i11 = 0;
        if (context != null) {
            if (this.f16594m == 1) {
                i11 = context.getResources().getDimensionPixelOffset(R.dimen.DP_24);
                i10 = 0;
            } else {
                i10 = context.getResources().getDimensionPixelOffset(R.dimen.DP_24);
            }
        } else {
            i10 = 0;
        }
        HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f16585d;
        if (headerFooterRecyclerView3 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
        } else {
            headerFooterRecyclerView2 = headerFooterRecyclerView3;
        }
        headerFooterRecyclerView2.setPadding(i11, headerFooterRecyclerView2.getPaddingTop(), i10, headerFooterRecyclerView2.getPaddingBottom());
    }

    private final void N1() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof GroupBrowserActivityFragment) {
            ((GroupBrowserActivityFragment) parentFragment).o1();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TabActivityViewModel T1() {
        return (TabActivityViewModel) this.f16578E.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1() {
        TextView textView = this.f16587f;
        if (textView == null) {
            kotlin.jvm.internal.i.q("showEmptyView");
            textView = null;
        }
        textView.setVisibility(8);
    }

    private final void V1() {
        HeaderFooterRecyclerView headerFooterRecyclerView;
        View view = this.f16584c;
        if (view == null) {
            kotlin.jvm.internal.i.q("rootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.empty_view);
        kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.f16587f = textView;
        if (textView == null) {
            kotlin.jvm.internal.i.q("showEmptyView");
            textView = null;
        }
        textView.setText(R.string.noGroups);
        com.android.contacts.group.c cVar = new com.android.contacts.group.c(getActivity(), null);
        this.f16588g = cVar;
        cVar.v(this.f16592k);
        cVar.w(this.f16593l);
        cVar.u(this);
        this.f16590i = getResources().getDimensionPixelOffset(R.dimen.DP_30);
        this.f16589h = getResources().getDimensionPixelOffset(R.dimen.DP_100);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.divider_background_height) + getResources().getDimensionPixelSize(R.dimen.list_padding_top);
        View view2 = this.f16584c;
        if (view2 == null) {
            kotlin.jvm.internal.i.q("rootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.list);
        kotlin.jvm.internal.i.d(findViewById2, "null cannot be cast to non-null type com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView");
        HeaderFooterRecyclerView headerFooterRecyclerView2 = (HeaderFooterRecyclerView) findViewById2;
        this.f16585d = headerFooterRecyclerView2;
        if (headerFooterRecyclerView2 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView2 = null;
        }
        headerFooterRecyclerView2.setLayoutManager(new LinearLayoutManager(headerFooterRecyclerView2.getContext()));
        com.android.contacts.group.c cVar2 = this.f16588g;
        if (cVar2 == null) {
            kotlin.jvm.internal.i.q("groupAdapter");
            cVar2 = null;
        }
        if (!(cVar2 instanceof RecyclerView.Adapter)) {
            cVar2 = null;
        }
        headerFooterRecyclerView2.setAdapter(cVar2);
        headerFooterRecyclerView2.setPadding(0, dimensionPixelSize, 0, this.f16590i);
        headerFooterRecyclerView2.setNestedScrollingEnabled(true);
        headerFooterRecyclerView2.setOnFocusChangeListener(this);
        headerFooterRecyclerView2.setDragSelectListener(this);
        H1();
        G1();
        Fragment parentFragment = getParentFragment();
        com.android.contacts.group.c cVar3 = this.f16588g;
        if (cVar3 == null) {
            kotlin.jvm.internal.i.q("groupAdapter");
            cVar3 = null;
        }
        c2(new G(parentFragment, cVar3, this.f16581H));
        com.android.contacts.group.c cVar4 = this.f16588g;
        if (cVar4 == null) {
            kotlin.jvm.internal.i.q("groupAdapter");
            cVar4 = null;
        }
        cVar4.s(P1());
        FragmentActivity requireActivity = requireActivity();
        kotlin.jvm.internal.i.e(requireActivity, "requireActivity()");
        HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f16585d;
        if (headerFooterRecyclerView3 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        } else {
            headerFooterRecyclerView = headerFooterRecyclerView3;
        }
        InterfaceC1492a.C0345a.b(this, requireActivity, headerFooterRecyclerView, null, 4, null);
    }

    private final void W1() {
        Fragment parentFragment = getParentFragment();
        kotlin.jvm.internal.i.d(parentFragment, "null cannot be cast to non-null type com.android.contacts.group.GroupBrowserActivityFragment");
        final COUIToolbar toolbar = ((GroupBrowserActivityFragment) parentFragment).getToolbar();
        this.f16602z = toolbar;
        if (toolbar != null) {
            toolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: com.android.contacts.group.e
                @Override // androidx.appcompat.widget.Toolbar.g
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean X12;
                    X12 = GroupBrowseListFragment.X1(GroupBrowseListFragment.this, menuItem);
                    return X12;
                }
            });
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.group.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupBrowseListFragment.Y1(GroupBrowseListFragment.this, toolbar, view);
                }
            });
        }
        this.f16581H.a(true);
    }

    public static final boolean X1(GroupBrowseListFragment this$0, MenuItem menuItem) {
        Context context;
        Context context2;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        GroupBrowserActivityFragment groupBrowserActivityFragment = null;
        switch (menuItem.getItemId()) {
            case R.id.cancel /* 2131427618 */:
                this$0.f16581H.c();
                return true;
            case R.id.menu_add /* 2131428368 */:
                FragmentActivity activity = this$0.getActivity();
                if (activity != null) {
                    context = activity.getApplicationContext();
                } else {
                    context = null;
                }
                A.a(context, 2000308, 200030048, null, false);
                Fragment parentFragment = this$0.getParentFragment();
                if (parentFragment instanceof GroupBrowserActivityFragment) {
                    groupBrowserActivityFragment = (GroupBrowserActivityFragment) parentFragment;
                }
                if (groupBrowserActivityFragment != null) {
                    groupBrowserActivityFragment.V2();
                    return true;
                }
                return true;
            case R.id.menu_select /* 2131428392 */:
                this$0.f16581H.b();
                FragmentActivity activity2 = this$0.getActivity();
                if (activity2 != null) {
                    context2 = activity2.getApplicationContext();
                } else {
                    context2 = null;
                }
                A.a(context2, 2000308, 200030047, null, false);
                return true;
            case R.id.select_all /* 2131428922 */:
                this$0.b2();
                return true;
            default:
                return true;
        }
    }

    public static final void Y1(GroupBrowseListFragment this$0, COUIToolbar this_apply, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(this_apply, "$this_apply");
        if (this$0.f16601y) {
            this$0.f16581H.c();
            HashMap hashMap = new HashMap();
            hashMap.put("selected_count", Integer.valueOf(this$0.S1()));
            A.a(this_apply.getContext(), 2000308, 200030050, hashMap, false);
            return;
        }
        this$0.N1();
    }

    private final void q2() {
        HeaderFooterRecyclerView headerFooterRecyclerView = null;
        if (this.f16580G) {
            HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f16585d;
            if (headerFooterRecyclerView2 == null) {
                kotlin.jvm.internal.i.q("recyclerView");
            } else {
                headerFooterRecyclerView = headerFooterRecyclerView2;
            }
            headerFooterRecyclerView.setIsParentChildHierarchy(this.f16579F);
            return;
        }
        HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f16585d;
        if (headerFooterRecyclerView3 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
        } else {
            headerFooterRecyclerView = headerFooterRecyclerView3;
        }
        headerFooterRecyclerView.setIsParentChildHierarchy(false);
    }

    public final void C1(Context context) {
        if (!B3.a.q(context)) {
            k kVar = new k(context);
            c.C0169c c0169c = new c.C0169c(kVar);
            View e10 = c0169c.e();
            if (e10 != null) {
                e10.setVisibility(8);
            }
            c0169c.o().setText(R.string.oplus_business_card);
            c0169c.m().setVisibility(8);
            c0169c.t(-5L);
            M1(c0169c.k());
            c0169c.k().setTag(c0169c);
            HeaderFooterRecyclerView headerFooterRecyclerView = this.f16585d;
            if (headerFooterRecyclerView == null) {
                kotlin.jvm.internal.i.q("recyclerView");
                headerFooterRecyclerView = null;
            }
            HeaderFooterRecyclerView.z(headerFooterRecyclerView, kVar, null, 0, 6, null);
        }
    }

    public final void D1(Context context) {
        k kVar = new k(context);
        c.C0169c c0169c = new c.C0169c(kVar);
        View e10 = c0169c.e();
        if (e10 != null) {
            e10.setVisibility(0);
        }
        View e11 = c0169c.e();
        if (e11 != null) {
            e11.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.group.d
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean E12;
                    E12 = GroupBrowseListFragment.E1(view, motionEvent);
                    return E12;
                }
            });
        }
        TextView g10 = c0169c.g();
        if (g10 != null) {
            g10.setText(R.string.oplus_smart_group);
        }
        TextView f10 = c0169c.f();
        if (f10 != null) {
            f10.setVisibility(8);
        }
        c0169c.t(-1L);
        c0169c.o().setText(R.string.oplus_smart_group_company_title);
        c0169c.m().setVisibility(8);
        M1(c0169c.k());
        c0169c.k().setTag(c0169c);
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f16585d;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        HeaderFooterRecyclerView.z(headerFooterRecyclerView, kVar, null, 0, 6, null);
    }

    @Override // q7.InterfaceC1492a
    public void F() {
        this.f16582a.F();
    }

    public final void F1(Context context) {
        k kVar = new k(context);
        c.C0169c c0169c = new c.C0169c(kVar);
        View e10 = c0169c.e();
        if (e10 != null) {
            e10.setVisibility(8);
        }
        c0169c.o().setText(R.string.oplus_smart_group_location_title);
        c0169c.m().setVisibility(8);
        c0169c.t(-2L);
        M1(c0169c.k());
        c0169c.k().setTag(c0169c);
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f16585d;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        HeaderFooterRecyclerView.z(headerFooterRecyclerView, kVar, null, 0, 6, null);
    }

    public final void G1() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        D1(context);
        if (FeatureOption.i()) {
            F1(context);
        }
        C1(context);
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f16585d;
        HeaderFooterRecyclerView headerFooterRecyclerView2 = null;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        List<View> headerViews = headerFooterRecyclerView.getHeaderViews();
        ArrayList arrayList = new ArrayList();
        for (Object obj : headerViews) {
            if (obj instanceof k) {
                arrayList.add(obj);
            }
        }
        int i10 = 0;
        for (Object obj2 : arrayList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                o.o();
            }
            c.C0169c c0169c = new c.C0169c((k) obj2);
            if (arrayList.size() == 1) {
                COUICardListHelper.setItemCardBackground(c0169c.k(), 4);
                View i12 = c0169c.i();
                if (i12 != null) {
                    i12.setVisibility(8);
                }
            } else if (i10 == 0) {
                COUICardListHelper.setItemCardBackground(c0169c.k(), 1);
                View i13 = c0169c.i();
                if (i13 != null) {
                    i13.setVisibility(0);
                }
            } else if (i10 == arrayList.size() - 1) {
                COUICardListHelper.setItemCardBackground(c0169c.k(), 3);
                View i14 = c0169c.i();
                if (i14 != null) {
                    i14.setVisibility(8);
                }
            } else {
                COUICardListHelper.setItemCardBackground(c0169c.k(), 2);
                View i15 = c0169c.i();
                if (i15 != null) {
                    i15.setVisibility(0);
                }
            }
            i10 = i11;
        }
        HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f16585d;
        if (headerFooterRecyclerView3 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
        } else {
            headerFooterRecyclerView2 = headerFooterRecyclerView3;
        }
        headerFooterRecyclerView2.B();
    }

    @Override // q7.InterfaceC1492a
    public void H0() {
        this.f16582a.H0();
    }

    public final void H1() {
        HeaderFooterRecyclerView headerFooterRecyclerView;
        final Context context = getContext();
        if (context == null) {
            return;
        }
        View vipGroupView = LayoutInflater.from(context).inflate(R.layout.vip_group_item, (ViewGroup) null, false);
        COUICardListHelper.setItemCardBackground(vipGroupView, 4);
        kotlin.jvm.internal.i.e(vipGroupView, "vipGroupView");
        c.C0169c c0169c = new c.C0169c(vipGroupView);
        c0169c.t(-3L);
        c0169c.o().setText(R.string.oplus_vip_group);
        TextView m10 = c0169c.m();
        this.f16597p = m10;
        String str = this.f16574A;
        if (str != null && m10 != null) {
            m10.setText(str);
        }
        M1(c0169c.k());
        c0169c.k().setTag(c0169c);
        HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f16585d;
        if (headerFooterRecyclerView2 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        } else {
            headerFooterRecyclerView = headerFooterRecyclerView2;
        }
        HeaderFooterRecyclerView.z(headerFooterRecyclerView, vipGroupView, null, 0, 6, null);
        View findViewById = vipGroupView.findViewById(R.id.title);
        kotlin.jvm.internal.i.d(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.group.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupBrowseListFragment.I1(GroupBrowseListFragment.this, context, view);
            }
        });
        if (!B3.a.c0()) {
            imageView.setVisibility(8);
        }
    }

    public final Uri J1() {
        Uri uri = C0814z.f22204b.buildUpon().appendQueryParameter("query_vip", "true").build();
        kotlin.jvm.internal.i.e(uri, "uri");
        return uri;
    }

    @Override // w7.b
    public void K(int i10, int i11, List<? extends View> touchViews) {
        kotlin.jvm.internal.i.f(touchViews, "touchViews");
        Iterator<? extends View> it = touchViews.iterator();
        while (it.hasNext()) {
            a2(it.next());
        }
    }

    public final void M1(View view) {
        view.setOnClickListener(this.f16577D);
    }

    public final void O1() {
        P1().m();
    }

    public final G P1() {
        G g10 = this.f16586e;
        if (g10 != null) {
            return g10;
        }
        kotlin.jvm.internal.i.q("editModeHandler");
        return null;
    }

    public final int Q1() {
        return this.f16591j;
    }

    public final GroupBrowseListViewModel R1() {
        GroupBrowseListViewModel groupBrowseListViewModel = this.f16583b;
        if (groupBrowseListViewModel != null) {
            return groupBrowseListViewModel;
        }
        kotlin.jvm.internal.i.q("groupViewModel");
        return null;
    }

    public final int S1() {
        if (Z1()) {
            return P1().c();
        }
        return 0;
    }

    @Override // w7.b
    public void T() {
        k2(false);
    }

    @Override // q7.InterfaceC1492a
    public void T0(Activity activity, RecyclerView recyclerView, InterfaceC1494c interfaceC1494c) {
        kotlin.jvm.internal.i.f(activity, "activity");
        this.f16582a.T0(activity, recyclerView, interfaceC1494c);
    }

    @Override // w7.b
    public boolean Z0(View view, int i10) {
        kotlin.jvm.internal.i.f(view, "view");
        return a2(view);
    }

    public final boolean Z1() {
        return P1().g();
    }

    public final boolean a2(View view) {
        CheckBox checkBox;
        if (view == null) {
            return false;
        }
        k2(false);
        if (!P1().g() || (checkBox = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox)) == null || checkBox.getVisibility() != 0) {
            return false;
        }
        boolean z10 = !checkBox.isChecked();
        checkBox.setChecked(z10);
        P1().k(checkBox, false);
        C.b(view.findViewById(R.id.group_detail), z10);
        return true;
    }

    public final void b2() {
        k2(false);
        P1().l();
        this.f16581H.g();
    }

    public final void c2(G g10) {
        kotlin.jvm.internal.i.f(g10, "<set-?>");
        this.f16586e = g10;
    }

    public final void d2(GroupBrowseListViewModel groupBrowseListViewModel) {
        kotlin.jvm.internal.i.f(groupBrowseListViewModel, "<set-?>");
        this.f16583b = groupBrowseListViewModel;
    }

    public final void e2(boolean z10) {
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f16585d;
        HeaderFooterRecyclerView headerFooterRecyclerView2 = null;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        if (headerFooterRecyclerView.getAdapter() == null) {
            return;
        }
        HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f16585d;
        if (headerFooterRecyclerView3 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView3 = null;
        }
        int headersCount = headerFooterRecyclerView3.getHeadersCount();
        HeaderFooterRecyclerView headerFooterRecyclerView4 = this.f16585d;
        if (headerFooterRecyclerView4 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
        } else {
            headerFooterRecyclerView2 = headerFooterRecyclerView4;
        }
        List<View> headerViews = headerFooterRecyclerView2.getHeaderViews();
        for (int i10 = 0; i10 < headersCount; i10++) {
            View view = headerViews.get(i10);
            if (view != null) {
                n2(view, !z10);
            }
        }
    }

    public final void f2(boolean z10) {
        this.f16580G = z10;
    }

    public final void g2(boolean z10) {
        int i10;
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f16585d;
        HeaderFooterRecyclerView headerFooterRecyclerView2 = null;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f16585d;
        if (headerFooterRecyclerView3 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
        } else {
            headerFooterRecyclerView2 = headerFooterRecyclerView3;
        }
        int paddingTop = headerFooterRecyclerView2.getPaddingTop();
        if (z10) {
            i10 = this.f16589h;
        } else {
            i10 = this.f16590i;
        }
        headerFooterRecyclerView.setPadding(0, paddingTop, 0, i10);
    }

    public final void h2(c listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f16595n = listener;
    }

    public final void i2(List<j> list) {
        com.android.contacts.group.c cVar = null;
        if (list != null) {
            this.f16591j = list.size();
            P1().v(list);
            com.android.contacts.group.c cVar2 = this.f16588g;
            if (cVar2 == null) {
                kotlin.jvm.internal.i.q("groupAdapter");
                cVar2 = null;
            }
            cVar2.t(list);
            if (Z1()) {
                P1().u();
            }
        }
        com.android.contacts.group.c cVar3 = this.f16588g;
        if (cVar3 == null) {
            kotlin.jvm.internal.i.q("groupAdapter");
        } else {
            cVar = cVar3;
        }
        cVar.notifyDataSetChanged();
        this.f16592k = cVar.m();
        this.f16593l = cVar.n();
    }

    public final void j2(Uri uri, String str) {
        this.f16592k = uri;
        this.f16593l = str;
        com.android.contacts.group.c cVar = this.f16588g;
        HeaderFooterRecyclerView headerFooterRecyclerView = null;
        if (cVar == null) {
            kotlin.jvm.internal.i.q("groupAdapter");
            cVar = null;
        }
        cVar.v(uri);
        cVar.w(str);
        HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f16585d;
        if (headerFooterRecyclerView2 == null) {
            kotlin.jvm.internal.i.q("recyclerView");
        } else {
            headerFooterRecyclerView = headerFooterRecyclerView2;
        }
        headerFooterRecyclerView.invalidate();
    }

    public final void k2(boolean z10) {
        com.android.contacts.group.c cVar = this.f16588g;
        if (cVar == null) {
            kotlin.jvm.internal.i.q("groupAdapter");
            cVar = null;
        }
        cVar.x(z10);
    }

    public final void l2(boolean z10) {
        if (H7.a.b()) {
            H7.b.b("GroupBrowseListFragment", "enable = " + z10);
        }
        if (z10) {
            H0();
        } else {
            p();
        }
    }

    @Override // com.android.contacts.group.c.b
    public void m0(View view) {
        k2(false);
        K1(view);
    }

    public final void m2(int i10) {
        if (this.f16594m != i10) {
            this.f16594m = i10;
            L1();
        }
    }

    public final void n2(View view, boolean z10) {
        float f10;
        if (!(view instanceof ViewGroup)) {
            view.setEnabled(z10);
            return;
        }
        Stack stack = new Stack();
        stack.push(view);
        while (!stack.isEmpty()) {
            View view2 = (View) stack.pop();
            if (view2 instanceof COUICardListSelectedItemLayout) {
                ((COUICardListSelectedItemLayout) view2).setEnabled(z10);
            }
            if (view2.getId() == R.id.count) {
                if (z10) {
                    f10 = 1.0f;
                } else {
                    f10 = 0.3f;
                }
                view2.setAlpha(f10);
            } else if (!(view2 instanceof ViewGroup)) {
                view2.setEnabled(z10);
            } else {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    stack.push(viewGroup.getChildAt(i10));
                }
            }
        }
    }

    public final void o2(boolean z10) {
        MenuItem menuItem = this.f16600x;
        if (menuItem != null) {
            menuItem.setEnabled(!z10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        W1();
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        boolean z10 = this.f16579F;
        HeaderFooterRecyclerView headerFooterRecyclerView = null;
        boolean r10 = DisplayUtil.r(getActivity(), newConfig, null, 4, null);
        this.f16579F = r10;
        if (r10 != z10 && !Z1()) {
            this.f16581H.a(true);
        }
        q2();
        o2(T1().k());
        if (this.f16601y) {
            if (FeatureUtil.V() && !this.f16579F && !DisplayUtil.j(getActivity())) {
                HeaderFooterRecyclerView headerFooterRecyclerView2 = this.f16585d;
                if (headerFooterRecyclerView2 == null) {
                    kotlin.jvm.internal.i.q("recyclerView");
                } else {
                    headerFooterRecyclerView = headerFooterRecyclerView2;
                }
                headerFooterRecyclerView.setDragRegionWidth(requireContext().getResources().getDimensionPixelSize(R.dimen.DP_155));
                return;
            }
            HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f16585d;
            if (headerFooterRecyclerView3 == null) {
                kotlin.jvm.internal.i.q("recyclerView");
            } else {
                headerFooterRecyclerView = headerFooterRecyclerView3;
            }
            headerFooterRecyclerView.setDragRegionWidth(requireContext().getResources().getDimensionPixelSize(R.dimen.DP_70));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Object b10;
        q qVar;
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        super.onCreate(bundle);
        M viewModelStore = getViewModelStore();
        kotlin.jvm.internal.i.e(viewModelStore, "viewModelStore");
        d2((GroupBrowseListViewModel) new K(viewModelStore, new K.c(), null, 4, null).a(GroupBrowseListViewModel.class));
        R1().i().i(this, new g(new v9.l<Integer, q>() { // from class: com.android.contacts.group.GroupBrowseListFragment$onCreate$1
            {
                super(1);
            }

            public final void b(Integer num) {
                String str;
                TextView textView;
                String str2;
                GroupBrowseListFragment groupBrowseListFragment = GroupBrowseListFragment.this;
                if (num != null) {
                    str = Z3.g.c(groupBrowseListFragment.getActivity(), num.intValue());
                } else {
                    str = null;
                }
                groupBrowseListFragment.f16574A = String.valueOf(str);
                textView = GroupBrowseListFragment.this.f16597p;
                if (textView != null) {
                    str2 = GroupBrowseListFragment.this.f16574A;
                    textView.setText(str2);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        }));
        R1().h().i(this, new g(new v9.l<List<? extends j>, q>() { // from class: com.android.contacts.group.GroupBrowseListFragment$onCreate$2
            {
                super(1);
            }

            public final void b(List<j> list) {
                int size = C0810v.d().size();
                GroupBrowseListFragment.this.P1().s(size);
                c cVar = GroupBrowseListFragment.this.f16588g;
                if (cVar == null) {
                    kotlin.jvm.internal.i.q("groupAdapter");
                    cVar = null;
                }
                cVar.y(Integer.valueOf(size));
                GroupBrowseListFragment.this.i2(list);
                GroupBrowseListFragment.this.U1();
                GroupBrowseListFragment.c cVar2 = GroupBrowseListFragment.this.f16595n;
                if (cVar2 != null) {
                    cVar2.a();
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(List<? extends j> list) {
                b(list);
                return q.f35511a;
            }
        }));
        try {
            Result.a aVar = Result.f34166a;
            Context context = getContext();
            if (context != null && (contentResolver2 = context.getContentResolver()) != null) {
                contentResolver2.registerContentObserver(ContactsContract.Groups.CONTENT_URI, true, this.f16575B);
            }
            Context context2 = getContext();
            if (context2 != null && (contentResolver = context2.getContentResolver()) != null) {
                contentResolver.registerContentObserver(R0.d.f3229p.buildUpon().query("Vip in ColorOS").build(), true, this.f16576C);
                qVar = q.f35511a;
            } else {
                qVar = null;
            }
            b10 = Result.b(qVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("GroupBrowseListFragment", "e = " + d10);
            N1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Uri uri;
        String str;
        kotlin.jvm.internal.i.f(inflater, "inflater");
        this.f16596o = true;
        if (bundle != null) {
            uri = (Uri) bundle.getParcelable("groups.groupUri");
        } else {
            uri = null;
        }
        this.f16592k = uri;
        if (bundle != null) {
            str = bundle.getString("groups.groupTitle");
        } else {
            str = null;
        }
        this.f16593l = str;
        View inflate = inflater.inflate(R.layout.group_browse_list_fragment, (ViewGroup) null);
        kotlin.jvm.internal.i.e(inflate, "inflater.inflate(R.layou…owse_list_fragment, null)");
        this.f16584c = inflate;
        V1();
        View view = this.f16584c;
        if (view == null) {
            kotlin.jvm.internal.i.q("rootView");
            return null;
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        super.onDestroy();
        T1().n(0);
        Context context = getContext();
        if (context != null && (contentResolver2 = context.getContentResolver()) != null) {
            contentResolver2.unregisterContentObserver(this.f16575B);
        }
        Context context2 = getContext();
        if (context2 != null && (contentResolver = context2.getContentResolver()) != null) {
            contentResolver.unregisterContentObserver(this.f16576C);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        F();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        HeaderFooterRecyclerView headerFooterRecyclerView = this.f16585d;
        HeaderFooterRecyclerView headerFooterRecyclerView2 = null;
        if (headerFooterRecyclerView == null) {
            kotlin.jvm.internal.i.q("recyclerView");
            headerFooterRecyclerView = null;
        }
        if (view == headerFooterRecyclerView && z10) {
            SoftKeyboardUtil a10 = SoftKeyboardUtil.a();
            HeaderFooterRecyclerView headerFooterRecyclerView3 = this.f16585d;
            if (headerFooterRecyclerView3 == null) {
                kotlin.jvm.internal.i.q("recyclerView");
            } else {
                headerFooterRecyclerView2 = headerFooterRecyclerView3;
            }
            a10.b(headerFooterRecyclerView2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        p();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelable("groups.groupUri", this.f16592k);
        outState.putString("groups.groupTitle", this.f16593l);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R1().l();
        R1().k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        COUIToolTips cOUIToolTips = this.f16598q;
        if (cOUIToolTips != null) {
            cOUIToolTips.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f16579F = DisplayUtil.r(getActivity(), null, null, 6, null);
        final TabActivityViewModel T12 = T1();
        T12.j().i(getViewLifecycleOwner(), new g(new v9.l<TabActivityViewModel.TabFragment, q>() { // from class: com.android.contacts.group.GroupBrowseListFragment$onViewCreated$1$1
            {
                super(1);
            }

            public final void b(TabActivityViewModel.TabFragment tabFragment) {
                if (H7.a.b()) {
                    H7.b.b("GroupBrowseListFragment", "it = " + tabFragment);
                }
                if (tabFragment == TabActivityViewModel.TabFragment.Contact) {
                    GroupBrowseListFragment.this.l2(true);
                } else {
                    GroupBrowseListFragment.this.l2(false);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(TabActivityViewModel.TabFragment tabFragment) {
                b(tabFragment);
                return q.f35511a;
            }
        }));
        T12.h().i(getViewLifecycleOwner(), new g(new v9.l<Integer, q>() { // from class: com.android.contacts.group.GroupBrowseListFragment$onViewCreated$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void b(Integer num) {
                GroupBrowseListFragment.this.o2(T12.k());
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        }));
        q2();
    }

    @Override // q7.InterfaceC1492a
    public void p() {
        this.f16582a.p();
    }

    @Override // w7.b
    public void p0() {
        k2(false);
    }

    public final void p2(boolean z10) {
        if (!this.f16601y) {
            this.f16581H.f(z10);
        }
    }

    public final void r2(Uri uri, String groupTitle) {
        kotlin.jvm.internal.i.f(groupTitle, "groupTitle");
        j2(uri, groupTitle);
        c cVar = this.f16595n;
        if (cVar != null) {
            cVar.c(uri, groupTitle);
        }
    }
}
