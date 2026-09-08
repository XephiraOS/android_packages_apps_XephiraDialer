package com.customize.contacts.manager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.customize.contacts.fragment.SearchFragment;
import com.oplus.dialer.R;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: MainActivitySearchManager.kt */
/* loaded from: classes3.dex */
public final class MainActivitySearchManager {

    /* renamed from: f, reason: collision with root package name */
    public static final a f21514f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final FragmentActivity f21515a;

    /* renamed from: b, reason: collision with root package name */
    public b f21516b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f21517c;

    /* renamed from: d, reason: collision with root package name */
    public SearchFragment f21518d;

    /* renamed from: e, reason: collision with root package name */
    public View f21519e;

    /* compiled from: MainActivitySearchManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: MainActivitySearchManager.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    public MainActivitySearchManager(FragmentActivity activity) {
        kotlin.jvm.internal.i.f(activity, "activity");
        this.f21515a = activity;
    }

    public static /* synthetic */ void e(MainActivitySearchManager mainActivitySearchManager, SearchFragment searchFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        mainActivitySearchManager.d(searchFragment, z10);
    }

    public final void c() {
        if (this.f21518d == null) {
            C1248i.d(androidx.lifecycle.p.a(this.f21515a), S.a(), null, new MainActivitySearchManager$cacheSearchFragment$1(this, null), 2, null);
        }
    }

    public final void d(SearchFragment searchFragment, boolean z10) {
        searchFragment.K3();
        androidx.fragment.app.B r10 = this.f21515a.getSupportFragmentManager().p().r(searchFragment);
        kotlin.jvm.internal.i.e(r10, "activity.supportFragment…action().remove(fragment)");
        if (z10) {
            r10.u(R.anim.anim_no, R.anim.search_exit);
            r10.j();
        } else {
            r10.l();
        }
        View view = this.f21519e;
        if (view != null) {
            view.setVisibility(0);
        }
        if (z10) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f21515a, R.anim.search_enter);
            View view2 = this.f21519e;
            if (view2 != null) {
                view2.startAnimation(loadAnimation);
            }
        }
        this.f21517c = false;
        b bVar = this.f21516b;
        if (bVar != null) {
            bVar.b();
        }
        c();
    }

    public final void f(boolean z10) {
        Fragment m02 = this.f21515a.getSupportFragmentManager().m0("contacts_search_fragment");
        if (m02 instanceof SearchFragment) {
            d((SearchFragment) m02, z10);
        }
    }

    public final FragmentActivity g() {
        return this.f21515a;
    }

    public final void h(Bundle bundle, View view, b searchListener) {
        View view2;
        kotlin.jvm.internal.i.f(view, "view");
        kotlin.jvm.internal.i.f(searchListener, "searchListener");
        this.f21519e = view;
        this.f21516b = searchListener;
        if (bundle != null && bundle.containsKey("contacts_in_search")) {
            boolean z10 = bundle.getBoolean("contacts_in_search");
            this.f21517c = z10;
            if (z10 && (view2 = this.f21519e) != null) {
                view2.setVisibility(4);
            }
        }
    }

    public final boolean i() {
        return this.f21517c;
    }

    public final boolean j() {
        Fragment m02 = this.f21515a.getSupportFragmentManager().m0("contacts_search_fragment");
        if (!(m02 instanceof SearchFragment)) {
            return false;
        }
        SearchFragment searchFragment = (SearchFragment) m02;
        if (!searchFragment.R3()) {
            e(this, searchFragment, false, 2, null);
            return true;
        }
        return true;
    }

    public final void k(Bundle bundle) {
        if (bundle != null) {
            bundle.putBoolean("contacts_in_search", this.f21517c);
        }
    }

    public final void l() {
        if (this.f21517c) {
            H7.b.i("MainActivitySearchManager", "startSearch already in search");
            return;
        }
        if (H7.a.b()) {
            H7.b.b("MainActivitySearchManager", "startSearch cacheSearchFragment = " + this.f21518d);
        }
        SearchFragment searchFragment = this.f21518d;
        if (searchFragment != null) {
            this.f21518d = null;
        } else {
            searchFragment = new SearchFragment();
        }
        androidx.fragment.app.B p10 = this.f21515a.getSupportFragmentManager().p();
        kotlin.jvm.internal.i.e(p10, "activity.supportFragmentManager.beginTransaction()");
        p10.u(R.anim.search_enter, R.anim.anim_no);
        p10.c(R.id.contact_activity_main_layout, searchFragment, "contacts_search_fragment").i();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f21515a, R.anim.search_exit);
        loadAnimation.setAnimationListener(new c());
        View view = this.f21519e;
        if (view != null) {
            view.startAnimation(loadAnimation);
        }
        this.f21517c = true;
        b bVar = this.f21516b;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void m() {
        Fragment m02 = this.f21515a.getSupportFragmentManager().m0("contacts_search_fragment");
        if (m02 instanceof SearchFragment) {
            ((SearchFragment) m02).V3();
        }
    }

    /* compiled from: MainActivitySearchManager.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = MainActivitySearchManager.this.f21519e;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
