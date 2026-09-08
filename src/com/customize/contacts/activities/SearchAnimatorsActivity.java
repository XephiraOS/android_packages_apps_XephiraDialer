package com.customize.contacts.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.tablayout.COUITabLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

/* compiled from: SearchAnimatorsActivity.kt */
/* loaded from: classes3.dex */
public class SearchAnimatorsActivity extends BasicActivity {

    /* renamed from: P, reason: collision with root package name */
    public static final /* synthetic */ C9.j<Object>[] f20551P = {kotlin.jvm.internal.k.d(new MutablePropertyReference1Impl(SearchAnimatorsActivity.class, "isSearchMode", "isSearchMode()Z", 0))};

    /* renamed from: A, reason: collision with root package name */
    public ObjectAnimator f20552A;

    /* renamed from: B, reason: collision with root package name */
    public ObjectAnimator f20553B;

    /* renamed from: C, reason: collision with root package name */
    public ObjectAnimator f20554C;

    /* renamed from: D, reason: collision with root package name */
    public ObjectAnimator f20555D;

    /* renamed from: E, reason: collision with root package name */
    public ObjectAnimator f20556E;

    /* renamed from: F, reason: collision with root package name */
    public ObjectAnimator f20557F;

    /* renamed from: G, reason: collision with root package name */
    public ObjectAnimator f20558G;

    /* renamed from: H, reason: collision with root package name */
    public ObjectAnimator f20559H;

    /* renamed from: I, reason: collision with root package name */
    public ObjectAnimator f20560I;

    /* renamed from: J, reason: collision with root package name */
    public ObjectAnimator f20561J;

    /* renamed from: K, reason: collision with root package name */
    public ObjectAnimator f20562K;

    /* renamed from: N, reason: collision with root package name */
    public ObjectAnimator f20565N;

    /* renamed from: O, reason: collision with root package name */
    public ObjectAnimator f20566O;

    /* renamed from: o, reason: collision with root package name */
    public COUITabLayout f20567o;

    /* renamed from: p, reason: collision with root package name */
    public COUISearchBar f20568p;

    /* renamed from: q, reason: collision with root package name */
    public View f20569q;

    /* renamed from: r, reason: collision with root package name */
    public View f20570r;

    /* renamed from: x, reason: collision with root package name */
    public COUIToolbar f20571x;

    /* renamed from: y, reason: collision with root package name */
    public AppBarLayout f20572y;

    /* renamed from: z, reason: collision with root package name */
    public final y9.c f20573z = y9.a.f38157a.a();

    /* renamed from: L, reason: collision with root package name */
    public final AnimatorSet f20563L = new AnimatorSet();

    /* renamed from: M, reason: collision with root package name */
    public final AnimatorSet f20564M = new AnimatorSet();

    /* compiled from: SearchAnimatorsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            SearchAnimatorsActivity.this.Q1().setBackground(null);
        }
    }

    /* compiled from: SearchAnimatorsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            SearchAnimatorsActivity.this.Q1().setBackgroundResource(R.drawable.coui_tablayout_bg);
        }
    }

    /* compiled from: SearchAnimatorsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            if (A7.a.a()) {
                SearchAnimatorsActivity.this.S1().setBackgroundResource(R.drawable.pb_bg_another_search_view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            if (A7.a.a()) {
                SearchAnimatorsActivity.this.S1().setBackgroundResource(R.drawable.coui_toolbar_bg);
            }
        }
    }

    /* compiled from: SearchAnimatorsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            if (A7.a.a()) {
                SearchAnimatorsActivity.this.S1().setBackgroundResource(R.drawable.coui_toolbar_bg);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            if (A7.a.a()) {
                SearchAnimatorsActivity.this.S1().setBackgroundResource(R.drawable.pb_bg_another_search_view);
            }
        }
    }

    /* compiled from: SearchAnimatorsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class e extends AnimatorListenerAdapter {
        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            SearchAnimatorsActivity.this.S1().setBackgroundResource(R.drawable.pb_bg_search_view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            SearchAnimatorsActivity.this.S1().setBackgroundResource(R.drawable.coui_toolbar_bg);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            ObjectAnimator objectAnimator = SearchAnimatorsActivity.this.f20556E;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
            SearchAnimatorsActivity.this.S1().setBackground(null);
        }
    }

    /* compiled from: SearchAnimatorsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            SearchAnimatorsActivity.this.S1().setBackgroundResource(R.drawable.coui_toolbar_bg);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            SearchAnimatorsActivity.this.getToolbar().setAlpha(1.0f);
            SearchAnimatorsActivity.this.getToolbar().setVisibility(0);
            SearchAnimatorsActivity.this.Q1().setAlpha(1.0f);
            SearchAnimatorsActivity.this.Q1().setVisibility(0);
            SearchAnimatorsActivity.this.S1().setBackgroundResource(R.drawable.pb_bg_search_view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            ObjectAnimator objectAnimator;
            kotlin.jvm.internal.i.f(animation, "animation");
            ObjectAnimator objectAnimator2 = SearchAnimatorsActivity.this.f20556E;
            if (objectAnimator2 != null && objectAnimator2.isRunning() && (objectAnimator = SearchAnimatorsActivity.this.f20556E) != null) {
                objectAnimator.cancel();
            }
            SearchAnimatorsActivity.this.S1().setBackground(null);
        }
    }

    /* compiled from: SearchAnimatorsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            ObjectAnimator objectAnimator = SearchAnimatorsActivity.this.f20556E;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        }
    }

    /* compiled from: SearchAnimatorsActivity.kt */
    /* loaded from: classes3.dex */
    public static final class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            SearchAnimatorsActivity.this.getToolbar().setAlpha(1.0f);
            SearchAnimatorsActivity.this.getToolbar().setVisibility(0);
            SearchAnimatorsActivity.this.Q1().setAlpha(1.0f);
            SearchAnimatorsActivity.this.Q1().setVisibility(0);
        }
    }

    public static final void F1(SearchAnimatorsActivity this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.X1(true);
    }

    public static final void H1(SearchAnimatorsActivity this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.getToolbar().setVisibility(8);
    }

    public static final void I1(SearchAnimatorsActivity this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.X1(true);
    }

    public static final void J1(COUITabLayout it) {
        kotlin.jvm.internal.i.f(it, "$it");
        it.setVisibility(8);
    }

    public static final void L1(SearchAnimatorsActivity this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.X1(false);
    }

    public static final void M1(SearchAnimatorsActivity this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.T1().setVisibility(8);
        this$0.n1();
    }

    public static final void O1(SearchAnimatorsActivity this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.T1().setVisibility(8);
        this$0.X1(false);
    }

    public final void A1(View view, int i10) {
        kotlin.jvm.internal.i.f(view, "view");
        if (this.f20552A == null) {
            V3.c cVar = new V3.c();
            cVar.a(view);
            int t02 = t0() + s0() + getResources().getDimensionPixelOffset(R.dimen.list_padding_top);
            this.f20552A = Z3.f.k(cVar, 450, i10, t02);
            this.f20553B = Z3.f.k(cVar, 450, t02, i10);
        }
    }

    public final void B1() {
        if (this.f20561J == null) {
            V3.b bVar = new V3.b(S1());
            this.f20561J = Z3.f.j(bVar, 450, S1().getHeight(), t0());
            this.f20562K = Z3.f.j(bVar, 450, t0(), S1().getHeight());
            ObjectAnimator objectAnimator = this.f20561J;
            if (objectAnimator != null) {
                objectAnimator.addListener(new c());
            }
            ObjectAnimator objectAnimator2 = this.f20562K;
            if (objectAnimator2 != null) {
                objectAnimator2.addListener(new d());
            }
        }
    }

    public final void C1() {
        if (this.f20561J == null) {
            V3.b bVar = new V3.b(S1());
            int a10 = bVar.a();
            int t02 = t0();
            this.f20561J = Z3.f.j(bVar, 450, a10, t02);
            this.f20562K = Z3.f.j(bVar, 450, t02, a10);
            if (A7.a.a()) {
                ObjectAnimator objectAnimator = this.f20561J;
                if (objectAnimator != null) {
                    objectAnimator.addListener(new e());
                }
                ObjectAnimator objectAnimator2 = this.f20562K;
                if (objectAnimator2 != null) {
                    objectAnimator2.addListener(new f());
                    return;
                }
                return;
            }
            ObjectAnimator objectAnimator3 = this.f20561J;
            if (objectAnimator3 != null) {
                objectAnimator3.addListener(new g());
            }
            ObjectAnimator objectAnimator4 = this.f20562K;
            if (objectAnimator4 != null) {
                objectAnimator4.addListener(new h());
            }
        }
    }

    public final void D1() {
        if (this.f20554C == null) {
            if (A7.a.a()) {
                V3.b bVar = new V3.b(getToolbar());
                this.f20554C = Z3.f.j(bVar, 450, getToolbar().getHeight(), S1().getHeight());
                this.f20555D = Z3.f.j(bVar, 450, S1().getHeight(), getToolbar().getHeight());
                this.f20556E = Z3.f.h(getToolbar(), 200, 1.0f, 0.0f);
                return;
            }
            V3.b bVar2 = new V3.b(getToolbar());
            this.f20554C = Z3.f.j(bVar2, 450, getToolbar().getHeight(), 0);
            this.f20555D = Z3.f.j(bVar2, 450, 0, getToolbar().getHeight());
        }
    }

    public final void E1() {
        this.f20563L.playTogether(this.f20565N, this.f20561J, this.f20557F);
        this.f20563L.setInterpolator(Z3.f.f5905e);
        this.f20563L.start();
        T1().setVisibility(0);
        T1().setAlpha(0.0f);
        T1().animate().alpha(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.customize.contacts.activities.n0
            @Override // java.lang.Runnable
            public final void run() {
                SearchAnimatorsActivity.F1(SearchAnimatorsActivity.this);
            }
        }).start();
    }

    public final void G1() {
        this.f20563L.playTogether(this.f20561J, this.f20552A, this.f20554C, this.f20559H);
        this.f20563L.setInterpolator(Z3.f.f5905e);
        this.f20563L.start();
        if (!A7.a.a()) {
            getToolbar().animate().alpha(0.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.customize.contacts.activities.r0
                @Override // java.lang.Runnable
                public final void run() {
                    SearchAnimatorsActivity.H1(SearchAnimatorsActivity.this);
                }
            }).start();
        }
        T1().setVisibility(0);
        T1().setAlpha(0.0f);
        T1().animate().alpha(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.customize.contacts.activities.s0
            @Override // java.lang.Runnable
            public final void run() {
                SearchAnimatorsActivity.I1(SearchAnimatorsActivity.this);
            }
        }).start();
        final COUITabLayout Q12 = Q1();
        Q12.animate().alpha(0.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.customize.contacts.activities.t0
            @Override // java.lang.Runnable
            public final void run() {
                SearchAnimatorsActivity.J1(COUITabLayout.this);
            }
        }).start();
    }

    public final void K1() {
        this.f20564M.playTogether(this.f20566O, this.f20558G, this.f20562K);
        this.f20564M.setInterpolator(Z3.f.f5906f);
        this.f20564M.start();
        T1().animate().alpha(0.0f).setDuration(150L).withStartAction(new Runnable() { // from class: com.customize.contacts.activities.o0
            @Override // java.lang.Runnable
            public final void run() {
                SearchAnimatorsActivity.L1(SearchAnimatorsActivity.this);
            }
        }).withEndAction(new Runnable() { // from class: com.customize.contacts.activities.p0
            @Override // java.lang.Runnable
            public final void run() {
                SearchAnimatorsActivity.M1(SearchAnimatorsActivity.this);
            }
        }).start();
    }

    public final void N1() {
        this.f20564M.playTogether(this.f20562K, this.f20553B, this.f20560I, this.f20555D);
        this.f20564M.setInterpolator(Z3.f.f5906f);
        this.f20564M.start();
        T1().animate().alpha(0.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.customize.contacts.activities.q0
            @Override // java.lang.Runnable
            public final void run() {
                SearchAnimatorsActivity.O1(SearchAnimatorsActivity.this);
            }
        }).start();
    }

    public AppBarLayout P1() {
        AppBarLayout appBarLayout = this.f20572y;
        if (appBarLayout != null) {
            return appBarLayout;
        }
        kotlin.jvm.internal.i.q("appBar");
        return null;
    }

    public COUITabLayout Q1() {
        COUITabLayout cOUITabLayout = this.f20567o;
        if (cOUITabLayout != null) {
            return cOUITabLayout;
        }
        kotlin.jvm.internal.i.q("colorTabLayout");
        return null;
    }

    public View R1() {
        View view = this.f20569q;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.i.q("headerView");
        return null;
    }

    public COUISearchBar S1() {
        COUISearchBar cOUISearchBar = this.f20568p;
        if (cOUISearchBar != null) {
            return cOUISearchBar;
        }
        kotlin.jvm.internal.i.q("searchViewAnimate");
        return null;
    }

    public View T1() {
        View view = this.f20570r;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.i.q("windowMask");
        return null;
    }

    public boolean U1() {
        return ((Boolean) this.f20573z.a(this, f20551P[0])).booleanValue();
    }

    public final boolean V1() {
        ObjectAnimator objectAnimator = this.f20554C;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            return true;
        }
        ObjectAnimator objectAnimator2 = this.f20555D;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            return true;
        }
        return false;
    }

    public void W1(COUITabLayout cOUITabLayout) {
        kotlin.jvm.internal.i.f(cOUITabLayout, "<set-?>");
        this.f20567o = cOUITabLayout;
    }

    public void X1(boolean z10) {
        this.f20573z.b(this, f20551P[0], Boolean.valueOf(z10));
    }

    public COUIToolbar getToolbar() {
        COUIToolbar cOUIToolbar = this.f20571x;
        if (cOUIToolbar != null) {
            return cOUIToolbar;
        }
        kotlin.jvm.internal.i.q("toolbar");
        return null;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        X1(false);
    }

    public void setHeaderView(View view) {
        kotlin.jvm.internal.i.f(view, "<set-?>");
        this.f20569q = view;
    }

    public void setWindowMask(View view) {
        kotlin.jvm.internal.i.f(view, "<set-?>");
        this.f20570r = view;
    }

    public final void x1() {
        if (this.f20565N == null) {
            V3.b bVar = new V3.b(P1());
            this.f20565N = Z3.f.j(bVar, 450, P1().getHeight(), 0);
            this.f20566O = Z3.f.j(bVar, 450, 0, P1().getHeight());
        }
    }

    public final void y1() {
        if (this.f20559H == null) {
            int height = Q1().getHeight();
            V3.b bVar = new V3.b(Q1());
            this.f20559H = Z3.f.j(bVar, 450, height, 0);
            this.f20560I = Z3.f.j(bVar, 450, 0, height);
        }
        if (A7.a.a()) {
            ObjectAnimator objectAnimator = this.f20559H;
            if (objectAnimator != null) {
                objectAnimator.addListener(new a());
            }
            ObjectAnimator objectAnimator2 = this.f20560I;
            if (objectAnimator2 != null) {
                objectAnimator2.addListener(new b());
            }
        }
    }

    public final void z1() {
        if (this.f20557F == null) {
            V3.b bVar = new V3.b(R1());
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.list_padding_top);
            this.f20557F = Z3.f.j(bVar, 450, R1().getHeight(), t0() + dimensionPixelSize);
            this.f20558G = Z3.f.j(bVar, 450, t0() + dimensionPixelSize, R1().getHeight());
        }
    }
}
