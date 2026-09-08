package com.oplus.systembarlib;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.Window;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.core.view.z;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.InterfaceC0491n;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x;
import java.util.ArrayList;
import java.util.Iterator;
import v9.InterfaceC1637a;

/* compiled from: FragmentSystemBarController.kt */
/* loaded from: classes3.dex */
public final class FragmentSystemBarController implements h, InterfaceC0491n {

    /* renamed from: g, reason: collision with root package name */
    public static final a f28987g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f28988a = new o(null, 1, null);

    /* renamed from: b, reason: collision with root package name */
    public Fragment f28989b;

    /* renamed from: c, reason: collision with root package name */
    public b f28990c;

    /* renamed from: d, reason: collision with root package name */
    public final m9.d f28991d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<m> f28992e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f28993f;

    /* compiled from: FragmentSystemBarController.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FragmentSystemBarController.kt */
    /* loaded from: classes3.dex */
    public interface b {
        d e();
    }

    public FragmentSystemBarController() {
        m9.d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<String>() { // from class: com.oplus.systembarlib.FragmentSystemBarController$fragmentName$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final String invoke() {
                Fragment fragment;
                fragment = FragmentSystemBarController.this.f28989b;
                if (fragment == null) {
                    kotlin.jvm.internal.i.q("innerFragment");
                    fragment = null;
                }
                return fragment.getClass().getSimpleName();
            }
        });
        this.f28991d = b10;
        this.f28992e = new ArrayList<>();
    }

    private final void d(X x10) {
        SystemBarLog.b("FragmentSystemBarController", "dispatchWindowInsetsUpdate. <" + e() + '>');
        b bVar = this.f28990c;
        if (bVar == null) {
            kotlin.jvm.internal.i.q("innerSystemBarStyleGetter");
            bVar = null;
        }
        bVar.e().b(x10);
        Iterator<T> it = this.f28992e.iterator();
        while (it.hasNext()) {
            ((m) it.next()).F0(x10);
        }
    }

    public static final X g(FragmentSystemBarController this$0, View view, X windowInsets) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(windowInsets, "windowInsets");
        this$0.d(windowInsets);
        return K.V(view, windowInsets);
    }

    public void c(Window window) {
        this.f28988a.c(window);
    }

    public final String e() {
        Object value = this.f28991d.getValue();
        kotlin.jvm.internal.i.e(value, "<get-fragmentName>(...)");
        return (String) value;
    }

    public void f(Fragment fragment, b styleGetter) {
        Fragment fragment2;
        Window window;
        kotlin.jvm.internal.i.f(fragment, "fragment");
        kotlin.jvm.internal.i.f(styleGetter, "styleGetter");
        this.f28990c = styleGetter;
        this.f28989b = fragment;
        b bVar = null;
        if (fragment == null) {
            kotlin.jvm.internal.i.q("innerFragment");
            fragment2 = null;
        } else {
            fragment2 = fragment;
        }
        fragment2.getLifecycle().a(this);
        l lVar = l.f29015a;
        Fragment fragment3 = this.f28989b;
        if (fragment3 == null) {
            kotlin.jvm.internal.i.q("innerFragment");
            fragment3 = null;
        }
        Context requireContext = fragment3.requireContext();
        kotlin.jvm.internal.i.e(requireContext, "innerFragment.requireContext()");
        this.f28993f = lVar.a(requireContext);
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            window = null;
        } else {
            window = activity.getWindow();
        }
        c(window);
        j(e());
        b bVar2 = this.f28990c;
        if (bVar2 == null) {
            kotlin.jvm.internal.i.q("innerSystemBarStyleGetter");
        } else {
            bVar = bVar2;
        }
        bVar.e().a();
        View view = fragment.getView();
        if (view == null) {
            return;
        }
        K.z0(view, new z() { // from class: com.oplus.systembarlib.c
            @Override // androidx.core.view.z
            public final X onApplyWindowInsets(View view2, X x10) {
                X g10;
                g10 = FragmentSystemBarController.g(FragmentSystemBarController.this, view2, x10);
                return g10;
            }
        });
    }

    public void h(Configuration config) {
        X C10;
        kotlin.jvm.internal.i.f(config, "config");
        l lVar = l.f29015a;
        Fragment fragment = this.f28989b;
        Fragment fragment2 = null;
        if (fragment == null) {
            kotlin.jvm.internal.i.q("innerFragment");
            fragment = null;
        }
        Context requireContext = fragment.requireContext();
        kotlin.jvm.internal.i.e(requireContext, "innerFragment.requireContext()");
        boolean a10 = lVar.a(requireContext);
        if (this.f28993f != a10) {
            this.f28993f = a10;
            SystemBarLog.b("FragmentSystemBarController", "onConfigChangedForSystemBar. <" + e() + "> dark mode changed, isDarkMode=" + this.f28993f);
            Fragment fragment3 = this.f28989b;
            if (fragment3 == null) {
                kotlin.jvm.internal.i.q("innerFragment");
            } else {
                fragment2 = fragment3;
            }
            View view = fragment2.getView();
            if (view != null && (C10 = K.C(view.getRootView())) != null) {
                d(C10);
            }
        }
    }

    public void i(m listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        if (this.f28992e.contains(listener)) {
            SystemBarLog.b("FragmentSystemBarController", "registerSystemBarChangeListener. <" + e() + "> already added.");
            return;
        }
        this.f28992e.add(listener);
    }

    public void j(String tag) {
        kotlin.jvm.internal.i.f(tag, "tag");
        this.f28988a.d(tag);
    }

    public void k(m listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f28992e.remove(listener);
    }

    @x(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        c(null);
        this.f28992e.clear();
        Fragment fragment = this.f28989b;
        if (fragment == null) {
            kotlin.jvm.internal.i.q("innerFragment");
            fragment = null;
        }
        View view = fragment.getView();
        if (view == null) {
            return;
        }
        K.z0(view, null);
    }

    @x(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        X C10;
        Fragment fragment = this.f28989b;
        if (fragment == null) {
            kotlin.jvm.internal.i.q("innerFragment");
            fragment = null;
        }
        View view = fragment.getView();
        if (view != null && (C10 = K.C(view.getRootView())) != null) {
            d(C10);
        }
    }
}
