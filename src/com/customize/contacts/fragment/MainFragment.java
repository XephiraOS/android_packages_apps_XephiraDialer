package com.customize.contacts.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import com.android.contacts.framework.baseui.behavior.BaseTitleBehavior;
import com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.activities.ContactsTabActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import v9.InterfaceC1637a;

/* compiled from: MainFragment.kt */
/* loaded from: classes3.dex */
public class MainFragment extends Fragment {

    /* renamed from: i, reason: collision with root package name */
    public static final a f21246i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Context f21247a;

    /* renamed from: b, reason: collision with root package name */
    public COUIToolbar f21248b;

    /* renamed from: c, reason: collision with root package name */
    public View f21249c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f21250d;

    /* renamed from: e, reason: collision with root package name */
    public AppBarLayout f21251e;

    /* renamed from: f, reason: collision with root package name */
    public BaseTitleBehavior f21252f;

    /* renamed from: g, reason: collision with root package name */
    public CoordinatorLayout.e f21253g;

    /* renamed from: h, reason: collision with root package name */
    public final m9.d f21254h = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(TabActivityViewModel.class), new InterfaceC1637a<M>() { // from class: com.customize.contacts.fragment.MainFragment$special$$inlined$activityViewModels$default$1
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
    }, new InterfaceC1637a<K.b>() { // from class: com.customize.contacts.fragment.MainFragment$special$$inlined$activityViewModels$default$2
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

    /* compiled from: MainFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: MainFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements androidx.lifecycle.w, kotlin.jvm.internal.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.l f21255a;

        public b(v9.l function) {
            kotlin.jvm.internal.i.f(function, "function");
            this.f21255a = function;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof androidx.lifecycle.w) || !(obj instanceof kotlin.jvm.internal.g)) {
                return false;
            }
            return kotlin.jvm.internal.i.b(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.g
        public final m9.c<?> getFunctionDelegate() {
            return this.f21255a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21255a.invoke(obj);
        }
    }

    private final TabActivityViewModel n1() {
        return (TabActivityViewModel) this.f21254h.getValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean p1(com.customize.contacts.fragment.MainFragment r3, android.view.MenuItem r4) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.i.f(r3, r0)
            int r0 = r4.getItemId()
            r1 = 1
            switch(r0) {
                case 2131427547: goto L2b;
                case 2131427549: goto L2b;
                case 2131427618: goto L27;
                case 2131427885: goto L2b;
                case 2131428384: goto L23;
                case 2131428657: goto L2b;
                case 2131428891: goto L12;
                case 2131428922: goto Le;
                case 2131429377: goto L2b;
                default: goto Ld;
            }
        Ld:
            goto L5e
        Le:
            r3.s1()
            goto L5e
        L12:
            r3.g1()
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            java.lang.String r0 = "search_icon"
            java.lang.String r3 = r3.i1()
            com.customize.contacts.util.h0.Z(r4, r0, r3)
            goto L5e
        L23:
            r3.s1()
            goto L5e
        L27:
            r3.u1()
            goto L5e
        L2b:
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            if (r0 == 0) goto L3a
            int r4 = r4.getItemId()
            android.view.View r4 = r0.findViewById(r4)
            goto L3b
        L3a:
            r4 = 0
        L3b:
            androidx.fragment.app.FragmentActivity r0 = r3.getActivity()
            boolean r0 = com.customize.contacts.util.C0792c.c(r0)
            if (r0 == 0) goto L5e
            boolean r0 = r3.e1()
            if (r0 == 0) goto L5e
            Z3.o r0 = r3.m1()
            if (r0 == 0) goto L5e
            boolean r2 = r3.r1()
            boolean r4 = r0.n(r4, r2)
            if (r4 != r1) goto L5e
            r3.t1()
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.fragment.MainFragment.p1(com.customize.contacts.fragment.MainFragment, android.view.MenuItem):boolean");
    }

    public static final void q1(MainFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.u1();
    }

    public final boolean e1() {
        if (isAdded() && isResumed()) {
            return true;
        }
        return false;
    }

    public final String i1() {
        TabActivityViewModel tabActivityViewModel;
        androidx.lifecycle.v<TabActivityViewModel.TabFragment> j10;
        TabActivityViewModel.TabFragment value;
        FragmentActivity activity = getActivity();
        if (activity != null && (tabActivityViewModel = (TabActivityViewModel) new K(activity).a(TabActivityViewModel.class)) != null && (j10 = tabActivityViewModel.j()) != null && (value = j10.getValue()) != null) {
            return value.b();
        }
        return null;
    }

    public BaseTitleBehavior j1() {
        BaseTitleBehavior baseTitleBehavior = this.f21252f;
        if (baseTitleBehavior != null) {
            return baseTitleBehavior;
        }
        kotlin.jvm.internal.i.q("mBehavior");
        return null;
    }

    public COUIToolbar k1() {
        COUIToolbar cOUIToolbar = this.f21248b;
        if (cOUIToolbar != null) {
            return cOUIToolbar;
        }
        kotlin.jvm.internal.i.q("mToolbar");
        return null;
    }

    public Integer l1() {
        return null;
    }

    public final Z3.o m1() {
        ContactsTabActivity contactsTabActivity;
        Context context = getContext();
        if (context instanceof ContactsTabActivity) {
            contactsTabActivity = (ContactsTabActivity) context;
        } else {
            contactsTabActivity = null;
        }
        if (contactsTabActivity == null) {
            return null;
        }
        return contactsTabActivity.n2();
    }

    public void o1() {
        k1().setOnMenuItemClickListener(new Toolbar.g() { // from class: com.customize.contacts.fragment.B
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean p12;
                p12 = MainFragment.p1(MainFragment.this, menuItem);
                return p12;
            }
        });
        k1().setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.fragment.C
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainFragment.q1(MainFragment.this, view);
            }
        });
        f1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        super.onAttach(context);
        this.f21247a = context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        n1().l().i(getViewLifecycleOwner(), new b(new v9.l<Boolean, m9.q>() { // from class: com.customize.contacts.fragment.MainFragment$onViewCreated$1
            {
                super(1);
            }

            public final void b(Boolean show) {
                int i10;
                Integer l12 = MainFragment.this.l1();
                if (l12 != null) {
                    MainFragment mainFragment = MainFragment.this;
                    int intValue = l12.intValue();
                    if (H7.a.b()) {
                        H7.b.b("MainFragment", "onViewCreated isShowToolbarRedDot: " + show);
                    }
                    COUIToolbar k12 = mainFragment.k1();
                    kotlin.jvm.internal.i.e(show, "show");
                    if (show.booleanValue()) {
                        i10 = 0;
                    } else {
                        i10 = -1;
                    }
                    k12.setRedDot(intValue, i10);
                }
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ m9.q invoke(Boolean bool) {
                b(bool);
                return m9.q.f35511a;
            }
        }));
    }

    public boolean r1() {
        return false;
    }

    public void v1(boolean z10) {
        BaseTitleBehavior j12 = j1();
        if (j12 != null) {
            j12.Z(z10);
        }
        if (z10) {
            k1().setTitleMarginStart(getResources().getDimensionPixelSize(R.dimen.DP_1));
        } else {
            k1().setTitleMarginStart(0);
        }
    }

    public void w1(boolean z10) {
        int i10;
        v1(z10);
        BaseTitleBehavior j12 = j1();
        if (j12 != null) {
            j12.k0();
        }
        BaseTitleBehavior j13 = j1();
        if (j13 != null) {
            j13.l0();
        }
        Integer l12 = l1();
        if (l12 != null) {
            int intValue = l12.intValue();
            COUIToolbar k12 = k1();
            if (kotlin.jvm.internal.i.b(n1().l().getValue(), Boolean.TRUE)) {
                i10 = 0;
            } else {
                i10 = -1;
            }
            k12.setRedDot(intValue, i10);
        }
    }

    public void f1() {
    }

    public void g1() {
    }

    public void h1() {
    }

    public void s1() {
    }

    public void t1() {
    }

    public void u1() {
    }
}
