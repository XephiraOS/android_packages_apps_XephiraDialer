package com.oplus.foundation.appsupport.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.X;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.InterfaceC0492o;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.coui.responsiveui.config.UIConfig;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oplus.foundation.appsupport.ui.uiconfig.UIConfigObserverImpl;
import com.oplus.systembarlib.FragmentSystemBarController;
import com.oplus.systembarlib.h;
import com.oplus.systembarlib.m;
import f.C0991a;
import kotlin.jvm.internal.i;
import m7.C1340a;
import m7.C1343d;
import r7.C1514c;
import r7.InterfaceC1512a;
import r7.InterfaceC1515d;
import t7.C1595a;
import u7.InterfaceC1611a;
import v9.InterfaceC1637a;

/* compiled from: BaseUIFragment.kt */
/* loaded from: classes3.dex */
public abstract class BaseUIFragment<BD extends ViewDataBinding> extends Fragment implements InterfaceC1512a, InterfaceC1515d, InterfaceC1611a, FragmentSystemBarController.b, h, m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1595a f28193a = new C1595a();

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIConfigObserverImpl f28194b = new UIConfigObserverImpl();

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FragmentSystemBarController f28195c = new FragmentSystemBarController();

    /* renamed from: d, reason: collision with root package name */
    public int f28196d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f28197e = -1;

    /* renamed from: f, reason: collision with root package name */
    public BD f28198f;

    /* renamed from: g, reason: collision with root package name */
    public final m9.d f28199g;

    /* renamed from: h, reason: collision with root package name */
    public final m9.d f28200h;

    public BaseUIFragment() {
        m9.d b10;
        m9.d b11;
        b10 = kotlin.a.b(new InterfaceC1637a<AppBarLayout>(this) { // from class: com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment$appBarLayout$2
            final /* synthetic */ BaseUIFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AppBarLayout invoke() {
                return (AppBarLayout) this.this$0.l1().K0().findViewById(m7.e.f35179a);
            }
        });
        this.f28199g = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<CollapsingToolbarLayout>(this) { // from class: com.oplus.foundation.appsupport.ui.fragment.BaseUIFragment$collapsingToolbarLayout$2
            final /* synthetic */ BaseUIFragment<BD> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CollapsingToolbarLayout invoke() {
                return (CollapsingToolbarLayout) this.this$0.l1().K0().findViewById(m7.e.f35180b);
            }
        });
        this.f28200h = b11;
    }

    public static final void F1(BaseUIFragment this$0, View view) {
        i.f(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
    }

    public static /* synthetic */ void H1(BaseUIFragment baseUIFragment, int i10, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i10 = m7.e.f35189k;
            }
            if ((i12 & 2) != 0) {
                i11 = m7.e.f35188j;
            }
            baseUIFragment.G1(i10, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setToolbarMenuMarkItemClickListener");
    }

    public static final void I1(BaseUIFragment this$0, MenuItem menuItem, View view) {
        i.f(this$0, "this$0");
        i.f(menuItem, "$menuItem");
        this$0.A1(menuItem);
    }

    private final void g1() {
        COUIToolbar toolbar = getToolbar();
        if (toolbar != null) {
            toolbar.getMenu().clear();
            x1(toolbar);
            Menu menu = toolbar.getMenu();
            i.e(menu, "menu");
            y1(menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: com.oplus.foundation.appsupport.ui.fragment.a
                @Override // androidx.appcompat.widget.Toolbar.g
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    boolean h12;
                    h12 = BaseUIFragment.h1(BaseUIFragment.this, menuItem);
                    return h12;
                }
            });
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.oplus.foundation.appsupport.ui.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseUIFragment.i1(BaseUIFragment.this, view);
                }
            });
            H1(this, 0, 0, 3, null);
        }
    }

    public static final boolean h1(BaseUIFragment this$0, MenuItem item) {
        i.f(this$0, "this$0");
        i.e(item, "item");
        return this$0.A1(item);
    }

    public static final void i1(BaseUIFragment this$0, View view) {
        i.f(this$0, "this$0");
        this$0.requireActivity().onBackPressed();
    }

    @Override // u7.InterfaceC1611a
    public void A0(boolean z10) {
        C1514c.b(this);
    }

    public boolean A1(MenuItem item) {
        i.f(item, "item");
        return false;
    }

    public String C0() {
        return InterfaceC1512a.C0349a.c(this);
    }

    public void C1(m listener) {
        i.f(listener, "listener");
        this.f28195c.i(listener);
    }

    public void D1(InterfaceC1611a listener) {
        i.f(listener, "listener");
        this.f28194b.i(listener);
    }

    @Override // r7.InterfaceC1512a
    public TextView E0() {
        return InterfaceC1512a.C0349a.j(this);
    }

    public final void E1(Drawable drawable) {
        COUIToolbar toolbar = getToolbar();
        if (toolbar != null) {
            toolbar.setNavigationIcon(drawable);
            if (drawable != null) {
                toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.oplus.foundation.appsupport.ui.fragment.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseUIFragment.F1(BaseUIFragment.this, view);
                    }
                });
            }
        }
    }

    @Override // com.oplus.systembarlib.m
    public void F0(X windowInsets) {
        i.f(windowInsets, "windowInsets");
        View K02 = l1().K0();
        i.e(K02, "viewDataBinding.root");
        z1(K02, windowInsets);
    }

    public final void G1(int i10, int i11) {
        final MenuItem findItem;
        View findViewById;
        COUIToolbar toolbar = getToolbar();
        if (toolbar != null) {
            this.f28196d = i10;
            this.f28197e = i11;
            Menu menu = toolbar.getMenu();
            if (menu != null && (findItem = menu.findItem(this.f28196d)) != null) {
                i.e(findItem, "findItem(toolbarMarkMenuId)");
                View actionView = findItem.getActionView();
                if (actionView != null && (findViewById = actionView.findViewById(this.f28197e)) != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.foundation.appsupport.ui.fragment.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BaseUIFragment.I1(BaseUIFragment.this, findItem, view);
                        }
                    });
                }
            }
        }
    }

    @Override // r7.InterfaceC1512a
    public int J() {
        return InterfaceC1512a.C0349a.f(this);
    }

    @Override // r7.InterfaceC1512a
    public int J0() {
        return InterfaceC1512a.C0349a.d(this);
    }

    public final void J1(BD bd) {
        i.f(bd, "<set-?>");
        this.f28198f = bd;
    }

    public void K1(m listener) {
        i.f(listener, "listener");
        this.f28195c.k(listener);
    }

    public void L1(InterfaceC1611a listener) {
        i.f(listener, "listener");
        this.f28194b.k(listener);
    }

    public final void M1(String str) {
        C1514c.g(this, str);
    }

    public final void N1(CharSequence charSequence) {
        C1514c.h(this, charSequence);
    }

    @Override // r7.InterfaceC1512a
    public boolean S() {
        return true;
    }

    @Override // r7.InterfaceC1512a
    public boolean V() {
        return InterfaceC1512a.C0349a.m(this);
    }

    @Override // r7.InterfaceC1512a
    public CollapsingToolbarLayout W0() {
        return (CollapsingToolbarLayout) this.f28200h.getValue();
    }

    @Override // r7.InterfaceC1512a
    public ViewGroup X0() {
        return InterfaceC1512a.C0349a.i(this);
    }

    @Override // r7.InterfaceC1512a
    public Drawable Y() {
        if (A7.a.a()) {
            return C0991a.b(requireContext(), C1343d.f35178a);
        }
        if (q1()) {
            return new ColorDrawable(COUIContextUtil.getAttrColor(requireContext(), C1340a.f35172a));
        }
        return C0991a.b(requireContext(), C1343d.f35178a);
    }

    @Override // r7.InterfaceC1512a
    public int a0() {
        return InterfaceC1512a.C0349a.e(this);
    }

    @Override // r7.InterfaceC1512a
    public AppBarLayout a1() {
        return (AppBarLayout) this.f28199g.getValue();
    }

    @Override // com.oplus.systembarlib.FragmentSystemBarController.b
    public com.oplus.systembarlib.d e() {
        return new com.oplus.systembarlib.d(this);
    }

    @Override // r7.InterfaceC1512a
    public COUIToolbar getToolbar() {
        return InterfaceC1512a.C0349a.k(this);
    }

    @Override // r7.InterfaceC1512a
    public boolean i0() {
        return InterfaceC1512a.C0349a.b(this);
    }

    public void j0(boolean z10) {
        InterfaceC1611a.C0368a.a(this, z10);
    }

    public abstract int j1();

    public int k1() {
        return InterfaceC1512a.C0349a.l(this);
    }

    public final BD l1() {
        BD bd = this.f28198f;
        if (bd != null) {
            return bd;
        }
        i.q("viewDataBinding");
        return null;
    }

    public void m1(Context context, InterfaceC1512a appBarConfig) {
        i.f(context, "context");
        i.f(appBarConfig, "appBarConfig");
        this.f28193a.b(context, appBarConfig);
    }

    public String n() {
        return InterfaceC1512a.C0349a.h(this);
    }

    public void n1(Fragment fragment, FragmentSystemBarController.b styleGetter) {
        i.f(fragment, "fragment");
        i.f(styleGetter, "styleGetter");
        this.f28195c.f(fragment, styleGetter);
    }

    public void o1(Activity activity, InterfaceC0492o owner) {
        i.f(activity, "activity");
        i.f(owner, "owner");
        this.f28194b.d(activity, owner);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        u1(newConfig);
        v1(newConfig);
        super.onConfigurationChanged(newConfig);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        i.e(requireActivity, "requireActivity()");
        o1(requireActivity, this);
        D1(this);
        Context requireContext = requireContext();
        i.e(requireContext, "requireContext()");
        m1(requireContext, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        ViewDataBinding h10 = g.h(inflater, j1(), viewGroup, false);
        i.e(h10, "inflate(inflater, layoutResId, container, false)");
        J1(h10);
        l1().b1(this);
        View K02 = l1().K0();
        i.e(K02, "viewDataBinding.root");
        w1(K02);
        return l1().K0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        L1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        K1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() == 16908332) {
            requireActivity().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        g1();
        n1(this, this);
        C1(this);
        C1514c.f(this, k1(), this);
    }

    public void p1() {
        g1();
    }

    public boolean q1() {
        return false;
    }

    public boolean r1() {
        return this.f28194b.f();
    }

    public final boolean s1() {
        if (isResumed() && isVisible() && getUserVisibleHint()) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (isAdded()) {
            B1(z10);
        }
    }

    public final boolean t1() {
        if (this.f28198f != null) {
            return true;
        }
        return false;
    }

    public void u1(Configuration config) {
        i.f(config, "config");
        this.f28195c.h(config);
    }

    public void v1(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        this.f28194b.h(newConfig);
    }

    @Override // r7.InterfaceC1512a
    public boolean w() {
        return InterfaceC1512a.C0349a.g(this);
    }

    @Override // u7.InterfaceC1611a
    public void w0(UIConfig uIConfig, UIConfig uIConfig2) {
        InterfaceC1611a.C0368a.b(this, uIConfig, uIConfig2);
    }

    public void w1(View contentView) {
        i.f(contentView, "contentView");
        this.f28193a.c(contentView);
    }

    public void x1(COUIToolbar toolbar) {
        i.f(toolbar, "toolbar");
    }

    public void y1(Menu menu) {
        i.f(menu, "menu");
    }

    public void z1(View contentView, X windowInsets) {
        i.f(contentView, "contentView");
        i.f(windowInsets, "windowInsets");
        this.f28193a.d(contentView, windowInsets);
    }

    public void B1(boolean z10) {
    }

    public void I0(int i10) {
    }
}
