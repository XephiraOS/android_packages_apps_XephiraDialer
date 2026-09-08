package com.customize.contacts.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Trace;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.viewmodel.TabActivityViewModel;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.manager.ContactUnfoldFragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import v9.InterfaceC1637a;

/* compiled from: BaseActivityFragment.kt */
/* loaded from: classes3.dex */
public class BaseActivityFragment extends Fragment {

    /* renamed from: E, reason: collision with root package name */
    public static final a f21142E = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public View f21147a;

    /* renamed from: b, reason: collision with root package name */
    public AppBarLayout f21148b;

    /* renamed from: c, reason: collision with root package name */
    public COUIToolbar f21149c;

    /* renamed from: d, reason: collision with root package name */
    public Intent f21150d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f21151e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f21152f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21153g;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21157k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f21158l;

    /* renamed from: m, reason: collision with root package name */
    public FrameLayout f21159m;

    /* renamed from: n, reason: collision with root package name */
    public View f21160n;

    /* renamed from: o, reason: collision with root package name */
    public View f21161o;

    /* renamed from: p, reason: collision with root package name */
    public Integer f21162p;

    /* renamed from: q, reason: collision with root package name */
    public Menu f21163q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21164r;

    /* renamed from: x, reason: collision with root package name */
    public Animation f21165x;

    /* renamed from: z, reason: collision with root package name */
    public boolean f21167z;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21154h = true;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f21155i = "";

    /* renamed from: j, reason: collision with root package name */
    public boolean f21156j = true;

    /* renamed from: y, reason: collision with root package name */
    public final m9.d f21166y = FragmentViewModelLazyKt.a(this, kotlin.jvm.internal.k.b(TabActivityViewModel.class), new InterfaceC1637a<M>() { // from class: com.customize.contacts.fragment.BaseActivityFragment$special$$inlined$activityViewModels$default$1
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
    }, new InterfaceC1637a<K.b>() { // from class: com.customize.contacts.fragment.BaseActivityFragment$special$$inlined$activityViewModels$default$2
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

    /* renamed from: A, reason: collision with root package name */
    public final b f21143A = new b();

    /* renamed from: B, reason: collision with root package name */
    public final Runnable f21144B = new Runnable() { // from class: com.customize.contacts.fragment.e
        @Override // java.lang.Runnable
        public final void run() {
            BaseActivityFragment.F1(BaseActivityFragment.this);
        }
    };

    /* renamed from: C, reason: collision with root package name */
    public final BaseActivityFragment$dialogFragmentListener$1 f21145C = new BasicActivity.DialogFragmentListener() { // from class: com.customize.contacts.fragment.BaseActivityFragment$dialogFragmentListener$1
        @Override // com.android.contacts.framework.baseui.activity.BasicActivity.DialogFragmentListener
        public Dialog b(int i10, Bundle bundle) {
            return BaseActivityFragment.this.I1(i10);
        }
    };

    /* renamed from: D, reason: collision with root package name */
    public final c f21146D = new c();

    /* compiled from: BaseActivityFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: BaseActivityFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Toolbar.g {
        public c() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (menuItem != null) {
                return BaseActivityFragment.this.L1(new z(menuItem));
            }
            return false;
        }
    }

    /* compiled from: BaseActivityFragment.kt */
    /* loaded from: classes3.dex */
    public static final class d implements androidx.lifecycle.w, kotlin.jvm.internal.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v9.l f21170a;

        public d(v9.l function) {
            kotlin.jvm.internal.i.f(function, "function");
            this.f21170a = function;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof androidx.lifecycle.w) || !(obj instanceof kotlin.jvm.internal.g)) {
                return false;
            }
            return kotlin.jvm.internal.i.b(getFunctionDelegate(), ((kotlin.jvm.internal.g) obj).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.g
        public final m9.c<?> getFunctionDelegate() {
            return this.f21170a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.w
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21170a.invoke(obj);
        }
    }

    public static final void F1(BaseActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.getContext() != null) {
            this$0.Q1();
        }
    }

    public static final void O1(View it, BaseActivityFragment this$0) {
        kotlin.jvm.internal.i.f(it, "$it");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        it.setVisibility(0);
        this$0.l1(this$0.r1());
    }

    public static final boolean P1(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final void T1(BaseActivityFragment this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2() {
        Integer num = this.f21162p;
        if (num != null) {
            int intValue = num.intValue();
            View view = getView();
            if (view != null) {
                if (this.f21152f && this.f21156j) {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), intValue + getResources().getDimensionPixelOffset(R.dimen.contact_bottom_tab_unfold_height));
                } else {
                    view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), intValue);
                }
            }
        }
    }

    private final void d2() {
        Integer num;
        androidx.lifecycle.v<Integer> i10;
        TabActivityViewModel x12 = x1();
        if (x12 == null || (i10 = x12.i()) == null || (num = i10.getValue()) == null) {
            num = 0;
        }
        e2(num.intValue());
    }

    public boolean A1() {
        return false;
    }

    public final boolean B1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.isDestroyed();
        }
        return true;
    }

    public final boolean C1() {
        return this.f21167z;
    }

    public final boolean D1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.isFinishing();
        }
        return true;
    }

    public final boolean E1() {
        return this.f21151e;
    }

    public boolean G1() {
        return true;
    }

    public boolean H1() {
        if (this.f21151e && CommonFeatureOption.j()) {
            return true;
        }
        return false;
    }

    public Dialog I1(int i10) {
        return null;
    }

    public boolean J1(y menu) {
        kotlin.jvm.internal.i.f(menu, "menu");
        return false;
    }

    public View K1(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle, FrameLayout frameLayout) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        return null;
    }

    public boolean L1(z item) {
        kotlin.jvm.internal.i.f(item, "item");
        return false;
    }

    public boolean M1(y menu) {
        kotlin.jvm.internal.i.f(menu, "menu");
        return false;
    }

    public void N1(Bundle bundle) {
        kotlin.jvm.internal.i.f(bundle, "bundle");
    }

    public final void Q1() {
        COUIToolbar cOUIToolbar = this.f21149c;
        if (cOUIToolbar != null) {
            this.f21163q = cOUIToolbar.getMenu();
            Menu menu = cOUIToolbar.getMenu();
            kotlin.jvm.internal.i.e(menu, "it.menu");
            y yVar = new y(menu);
            if (G1()) {
                yVar.a();
            }
            J1(yVar);
            M1(yVar);
        }
    }

    public final void R1(Runnable runnable) {
        kotlin.jvm.internal.i.f(runnable, "runnable");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(runnable);
        }
    }

    public final void S1(boolean z10) {
        this.f21153g = z10;
        COUIToolbar cOUIToolbar = this.f21149c;
        if (cOUIToolbar != null) {
            if (z10) {
                cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.fragment.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseActivityFragment.T1(BaseActivityFragment.this, view);
                    }
                });
            } else {
                cOUIToolbar.setNavigationOnClickListener(null);
            }
        }
        c2(z10);
    }

    public final void U1(boolean z10) {
        if (this.f21149c != null) {
            if (z10) {
                a2(this.f21155i);
            } else {
                a2("");
            }
        }
        this.f21154h = z10;
    }

    public final void V1(Intent intent) {
        kotlin.jvm.internal.i.f(intent, "intent");
        if (this.f21151e) {
            this.f21150d = intent;
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setIntent(intent);
        }
    }

    public final void W1() {
        this.f21164r = true;
    }

    public void X1(boolean z10, boolean z11) {
        this.f21151e = true;
        this.f21157k = z10;
        this.f21156j = z10;
        this.f21158l = z11;
    }

    public final void Y1(Toolbar toolbar) {
        if (g2()) {
            if (toolbar != null) {
                toolbar.setOnMenuItemClickListener(this.f21146D);
                toolbar.removeCallbacks(this.f21144B);
                toolbar.postOnAnimation(this.f21144B);
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        }
    }

    public final void Z1(int i10) {
        if (g2()) {
            CharSequence text = getResources().getText(i10);
            kotlin.jvm.internal.i.e(text, "resources.getText(resId)");
            a2(text);
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setTitle(i10);
            }
        }
    }

    public final void a2(CharSequence title) {
        COUIToolbar cOUIToolbar;
        kotlin.jvm.internal.i.f(title, "title");
        if (g2()) {
            this.f21155i = title;
            if (this.f21154h && (cOUIToolbar = this.f21149c) != null) {
                cOUIToolbar.setTitle(title);
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(title);
        }
    }

    public final void c2(boolean z10) {
        if (this.f21151e) {
            if (z10 && !this.f21152f) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        COUIToolbar cOUIToolbar = this.f21149c;
        if (cOUIToolbar != null) {
            if (z10) {
                cOUIToolbar.setNavigationIcon(R.drawable.coui_back_arrow);
                cOUIToolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description);
            } else {
                cOUIToolbar.setNavigationIcon((Drawable) null);
            }
        }
    }

    public final void e2(int i10) {
        if (this.f21158l && OsUtils.f28280f) {
            if (this.f21152f) {
                View view = this.f21161o;
                if (view != null && view.getHeight() != 0) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
                View view2 = this.f21160n;
                if (view2 != null) {
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                        if (marginLayoutParams.bottomMargin != 0) {
                            marginLayoutParams.bottomMargin = 0;
                            view2.setLayoutParams(layoutParams2);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            View view3 = this.f21161o;
            if (view3 != null && view3.getHeight() != i10) {
                ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                layoutParams3.height = i10;
                view3.setLayoutParams(layoutParams3);
            }
            View view4 = this.f21160n;
            if (view4 != null) {
                ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    if (marginLayoutParams2.bottomMargin != i10) {
                        marginLayoutParams2.bottomMargin = i10;
                        view4.setLayoutParams(layoutParams4);
                    }
                }
            }
        }
    }

    public final void f2(boolean z10) {
        View view = this.f21147a;
        if (view != null) {
            if (z10) {
                view.setVisibility(0);
            } else {
                view.setVisibility(4);
            }
        }
    }

    public boolean g2() {
        return false;
    }

    public final COUIToolbar getToolbar() {
        return this.f21149c;
    }

    public final void l1(x xVar) {
        if (xVar == null) {
            return;
        }
        Trace.beginSection("doEnterAnimation");
        Animation animation = this.f21165x;
        if (animation == null && (animation = AnimationUtils.loadAnimation(getContext(), R.anim.coui_open_slide_enter)) != null) {
            this.f21165x = animation;
            if (CommonFeatureOption.m()) {
                animation.setAnimationListener(this.f21143A);
            }
        }
        View view = getView();
        if (view != null) {
            view.setAnimation(animation);
        }
        xVar.X(animation);
        Trace.endSection();
    }

    public final <T extends View> T n1(int i10) {
        T t10;
        View view = getView();
        if (view == null || (t10 = (T) view.findViewById(i10)) == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                return (T) activity.findViewById(i10);
            }
            return null;
        }
        return t10;
    }

    public final void o1() {
        if (this.f21151e) {
            ContactUnfoldFragmentManager.f21504e.j(getTag());
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        boolean z10 = this.f21152f;
        boolean r10 = DisplayUtil.r(getActivity(), newConfig, null, 4, null);
        this.f21152f = r10;
        if (z10 != r10 && this.f21151e) {
            if (g2() && this.f21149c != null) {
                c2(this.f21153g);
            }
            if (H1()) {
                b2();
            }
            d2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        if (bundle != null) {
            this.f21151e = bundle.getBoolean("fragment");
            this.f21150d = (Intent) bundle.getParcelable("set_intent");
            this.f21153g = bundle.getBoolean("home_enable");
            this.f21154h = bundle.getBoolean("title_enable");
            CharSequence charSequence = bundle.getCharSequence("title_string");
            if (charSequence == null) {
                charSequence = "";
            }
            this.f21155i = charSequence;
            this.f21157k = bundle.getBoolean("has_tab");
            this.f21158l = bundle.getBoolean("move_to_main_view");
            this.f21156j = this.f21157k;
            N1(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        kotlin.jvm.internal.i.f(menu, "menu");
        kotlin.jvm.internal.i.f(inflater, "inflater");
        super.onCreateOptionsMenu(menu, inflater);
        if (!g2()) {
            this.f21163q = menu;
            J1(new y(menu));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout;
        kotlin.jvm.internal.i.f(inflater, "inflater");
        if (this.f21151e && this.f21158l && OsUtils.f28280f) {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f21159m = frameLayout2;
            View K12 = K1(inflater, viewGroup, bundle, frameLayout2);
            if (K12 != null) {
                if (K12.getParent() == null && (frameLayout = this.f21159m) != null) {
                    frameLayout.addView(K12);
                }
                View view = new View(context);
                this.f21161o = view;
                FrameLayout frameLayout3 = this.f21159m;
                if (frameLayout3 != null) {
                    frameLayout3.addView(view, -1, 0);
                }
                this.f21160n = K12;
            }
            return this.f21159m;
        }
        return K1(inflater, viewGroup, bundle, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        U0.n.h();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        COUIToolbar cOUIToolbar;
        if (g2() && (cOUIToolbar = this.f21149c) != null) {
            cOUIToolbar.removeCallbacks(this.f21144B);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        kotlin.jvm.internal.i.f(item, "item");
        if (!g2()) {
            return L1(new z(item));
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        kotlin.jvm.internal.i.f(menu, "menu");
        if (g2()) {
            COUIToolbar cOUIToolbar = this.f21149c;
            if (cOUIToolbar != null) {
                Menu menu2 = cOUIToolbar.getMenu();
                kotlin.jvm.internal.i.e(menu2, "it.menu");
                M1(new y(menu2));
                return;
            }
            return;
        }
        M1(new y(menu));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f21164r) {
            this.f21164r = false;
            final View view = getView();
            if (view != null) {
                view.setVisibility(4);
                view.post(new Runnable() { // from class: com.customize.contacts.fragment.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseActivityFragment.O1(view, this);
                    }
                });
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.i.f(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("fragment", this.f21151e);
        outState.putBoolean("home_enable", this.f21153g);
        outState.putBoolean("title_enable", this.f21154h);
        outState.putCharSequence("title_string", this.f21155i);
        outState.putBoolean("has_tab", this.f21157k);
        outState.putBoolean("move_to_main_view", this.f21158l);
        Intent intent = this.f21150d;
        if (intent != null) {
            outState.putParcelable("set_intent", intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        androidx.lifecycle.v<Integer> h10;
        androidx.lifecycle.v<Integer> i10;
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        this.f21149c = (COUIToolbar) view.findViewById(R.id.toolbar);
        this.f21148b = (AppBarLayout) view.findViewById(R.id.appbar);
        this.f21147a = view.findViewById(R.id.navigation_view_panel);
        Integer num = null;
        this.f21152f = DisplayUtil.r(getActivity(), null, null, 6, null);
        if (this.f21151e) {
            View view2 = getView();
            if (view2 != null) {
                num = Integer.valueOf(view2.getPaddingBottom());
            }
            this.f21162p = num;
            if (H1()) {
                b2();
            }
            if (A1()) {
                view.setBackgroundResource(R.drawable.coui_window_background_with_card_selector);
            } else {
                view.setBackgroundResource(R.drawable.coui_window_background_selector);
            }
            TabActivityViewModel x12 = x1();
            if (x12 != null && (i10 = x12.i()) != null) {
                i10.i(getViewLifecycleOwner(), new d(new v9.l<Integer, m9.q>() { // from class: com.customize.contacts.fragment.BaseActivityFragment$onViewCreated$1
                    {
                        super(1);
                    }

                    public final void b(Integer it) {
                        if (H7.a.b()) {
                            H7.b.b("BaseActivityFragment", "navigationBarHeight = " + it);
                        }
                        BaseActivityFragment baseActivityFragment = BaseActivityFragment.this;
                        kotlin.jvm.internal.i.e(it, "it");
                        baseActivityFragment.e2(it.intValue());
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ m9.q invoke(Integer num2) {
                        b(num2);
                        return m9.q.f35511a;
                    }
                }));
            }
            d2();
        }
        if (this.f21151e) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.customize.contacts.fragment.d
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    boolean P12;
                    P12 = BaseActivityFragment.P1(view3, motionEvent);
                    return P12;
                }
            });
        }
        TabActivityViewModel x13 = x1();
        if (x13 != null && (h10 = x13.h()) != null) {
            h10.i(getViewLifecycleOwner(), new d(new v9.l<Integer, m9.q>() { // from class: com.customize.contacts.fragment.BaseActivityFragment$onViewCreated$3
                {
                    super(1);
                }

                public final void b(Integer num2) {
                    boolean z10;
                    boolean z11;
                    if (H7.a.b()) {
                        H7.b.b("BaseActivityFragment", "isEditMode = " + num2);
                    }
                    BaseActivityFragment baseActivityFragment = BaseActivityFragment.this;
                    z10 = baseActivityFragment.f21157k;
                    if (z10 && num2 != null && num2.intValue() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    baseActivityFragment.f21156j = z11;
                    BaseActivityFragment.this.b2();
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(Integer num2) {
                    b(num2);
                    return m9.q.f35511a;
                }
            }));
        }
    }

    public final AppBarLayout p1() {
        return this.f21148b;
    }

    public final Integer q1() {
        return this.f21162p;
    }

    public final x r1() {
        InterfaceC0485h parentFragment = getParentFragment();
        if (parentFragment instanceof x) {
            return (x) parentFragment;
        }
        LayoutInflater.Factory activity = getActivity();
        if (activity instanceof x) {
            return (x) activity;
        }
        return null;
    }

    public J s1() {
        ActionBar actionBar;
        if (g2()) {
            return new J(this, null);
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        } else {
            actionBar = null;
        }
        if (actionBar == null) {
            return null;
        }
        return new J(this, actionBar);
    }

    public Intent t1() {
        if (this.f21151e) {
            return this.f21150d;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getIntent();
        }
        return null;
    }

    public final Menu u1() {
        return this.f21163q;
    }

    public final View w1() {
        return this.f21147a;
    }

    public final TabActivityViewModel x1() {
        return (TabActivityViewModel) this.f21166y.getValue();
    }

    public final void y1(int i10, y menu) {
        MenuInflater menuInflater;
        kotlin.jvm.internal.i.f(menu, "menu");
        if (g2()) {
            COUIToolbar cOUIToolbar = this.f21149c;
            if (cOUIToolbar != null) {
                cOUIToolbar.inflateMenu(i10);
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (menuInflater = activity.getMenuInflater()) != null) {
            menuInflater.inflate(i10, menu.b());
        }
    }

    public void z1() {
        if (g2()) {
            COUIToolbar cOUIToolbar = this.f21149c;
            if (cOUIToolbar != null) {
                cOUIToolbar.removeCallbacks(this.f21144B);
                cOUIToolbar.postOnAnimation(this.f21144B);
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.invalidateOptionsMenu();
        }
    }

    public void m1() {
    }

    public BaseActivityFragment v1() {
        return this;
    }

    /* compiled from: BaseActivityFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BaseActivityFragment.this.f21167z = false;
            BaseActivityFragment.this.m1();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            BaseActivityFragment.this.f21167z = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
