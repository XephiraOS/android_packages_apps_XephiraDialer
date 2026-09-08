package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0458m;
import androidx.core.view.K;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.search.SearchView;
import f4.C1001b;
import g.C1027d;
import java.util.Objects;
import s4.C1548g;

/* compiled from: SearchViewAnimationHelper.java */
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public final SearchView f23633a;

    /* renamed from: b, reason: collision with root package name */
    public final View f23634b;

    /* renamed from: c, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f23635c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f23636d;

    /* renamed from: e, reason: collision with root package name */
    public final FrameLayout f23637e;

    /* renamed from: f, reason: collision with root package name */
    public final Toolbar f23638f;

    /* renamed from: g, reason: collision with root package name */
    public final Toolbar f23639g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f23640h;

    /* renamed from: i, reason: collision with root package name */
    public final EditText f23641i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageButton f23642j;

    /* renamed from: k, reason: collision with root package name */
    public final View f23643k;

    /* renamed from: l, reason: collision with root package name */
    public final TouchObserverFrameLayout f23644l;

    /* renamed from: m, reason: collision with root package name */
    public final C1548g f23645m;

    /* renamed from: n, reason: collision with root package name */
    public AnimatorSet f23646n;

    /* renamed from: o, reason: collision with root package name */
    public SearchBar f23647o;

    /* compiled from: SearchViewAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!t.this.f23633a.o()) {
                t.this.f23633a.F();
            }
            t.this.f23633a.setTransitionState(SearchView.TransitionState.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            t.this.f23635c.setVisibility(0);
            t.this.f23647o.p();
        }
    }

    /* compiled from: SearchViewAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            t.this.f23635c.setVisibility(8);
            if (!t.this.f23633a.o()) {
                t.this.f23633a.l();
            }
            t.this.f23633a.setTransitionState(SearchView.TransitionState.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            t.this.f23633a.setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    /* compiled from: SearchViewAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!t.this.f23633a.o()) {
                t.this.f23633a.F();
            }
            t.this.f23633a.setTransitionState(SearchView.TransitionState.SHOWN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            t.this.f23635c.setVisibility(0);
            t.this.f23633a.setTransitionState(SearchView.TransitionState.SHOWING);
        }
    }

    /* compiled from: SearchViewAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            t.this.f23635c.setVisibility(8);
            if (!t.this.f23633a.o()) {
                t.this.f23633a.l();
            }
            t.this.f23633a.setTransitionState(SearchView.TransitionState.HIDDEN);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            t.this.f23633a.setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    /* compiled from: SearchViewAnimationHelper.java */
    /* loaded from: classes3.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f23652a;

        public e(boolean z10) {
            this.f23652a = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            float f10;
            t tVar = t.this;
            if (this.f23652a) {
                f10 = 1.0f;
            } else {
                f10 = 0.0f;
            }
            tVar.U(f10);
            t.this.f23635c.resetClipBoundsAndCornerRadius();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            float f10;
            t tVar = t.this;
            if (this.f23652a) {
                f10 = 0.0f;
            } else {
                f10 = 1.0f;
            }
            tVar.U(f10);
        }
    }

    public t(SearchView searchView) {
        this.f23633a = searchView;
        this.f23634b = searchView.f23575a;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.f23576b;
        this.f23635c = clippableRoundedCornerLayout;
        this.f23636d = searchView.f23579e;
        this.f23637e = searchView.f23580f;
        this.f23638f = searchView.f23581g;
        this.f23639g = searchView.f23582h;
        this.f23640h = searchView.f23583i;
        this.f23641i = searchView.f23584j;
        this.f23642j = searchView.f23585k;
        this.f23643k = searchView.f23586l;
        this.f23644l = searchView.f23587m;
        this.f23645m = new C1548g(clippableRoundedCornerLayout);
    }

    public static /* synthetic */ void N(C1027d c1027d, ValueAnimator valueAnimator) {
        c1027d.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void O(FadeThroughDrawable fadeThroughDrawable, ValueAnimator valueAnimator) {
        fadeThroughDrawable.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public final Animator A(boolean z10) {
        return K(z10, true, this.f23641i);
    }

    public final AnimatorSet B(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f23646n == null) {
            animatorSet.playTogether(s(z10), t(z10));
        }
        animatorSet.playTogether(H(z10), G(z10), u(z10), w(z10), F(z10), z(z10), q(z10), A(z10), I(z10));
        animatorSet.addListener(new e(z10));
        return animatorSet;
    }

    public final int C(View view) {
        int a10 = C0458m.a((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        if (ViewUtils.isLayoutRtl(this.f23647o)) {
            return this.f23647o.getLeft() - a10;
        }
        return (this.f23647o.getRight() - this.f23633a.getWidth()) + a10;
    }

    public final int D(View view) {
        int b10 = C0458m.b((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        int A10 = K.A(this.f23647o);
        if (ViewUtils.isLayoutRtl(this.f23647o)) {
            return ((this.f23647o.getWidth() - this.f23647o.getRight()) + b10) - A10;
        }
        return (this.f23647o.getLeft() - b10) + A10;
    }

    public final int E() {
        return ((this.f23647o.getTop() + this.f23647o.getBottom()) / 2) - ((this.f23637e.getTop() + this.f23637e.getBottom()) / 2);
    }

    public final Animator F(boolean z10) {
        return K(z10, false, this.f23636d);
    }

    public final Animator G(boolean z10) {
        long j10;
        Rect m10 = this.f23645m.m();
        Rect l10 = this.f23645m.l();
        if (m10 == null) {
            m10 = ViewUtils.calculateRectFromBounds(this.f23633a);
        }
        if (l10 == null) {
            l10 = ViewUtils.calculateOffsetRectFromBounds(this.f23635c, this.f23647o);
        }
        final Rect rect = new Rect(l10);
        final float cornerSize = this.f23647o.getCornerSize();
        final float max = Math.max(this.f23635c.getCornerRadius(), this.f23645m.k());
        ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), l10, m10);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.n
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                t.this.P(cornerSize, max, rect, valueAnimator);
            }
        });
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofObject.setDuration(j10);
        ofObject.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        return ofObject;
    }

    public final Animator H(boolean z10) {
        TimeInterpolator timeInterpolator;
        long j10;
        if (z10) {
            timeInterpolator = C1001b.f31702a;
        } else {
            timeInterpolator = C1001b.f31703b;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, timeInterpolator));
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(this.f23634b));
        return ofFloat;
    }

    public final Animator I(boolean z10) {
        return K(z10, true, this.f23640h);
    }

    public final AnimatorSet J(boolean z10) {
        long j10;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(L());
        k(animatorSet);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        if (z10) {
            j10 = 350;
        } else {
            j10 = 300;
        }
        animatorSet.setDuration(j10);
        return animatorSet;
    }

    public final Animator K(boolean z10, boolean z11, View view) {
        int C10;
        long j10;
        if (z11) {
            C10 = D(view);
        } else {
            C10 = C(view);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(C10, 0.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(view));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        return animatorSet;
    }

    public final Animator L() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f23635c.getHeight(), 0.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationYListener(this.f23635c));
        return ofFloat;
    }

    public AnimatorSet M() {
        if (this.f23647o != null) {
            return b0();
        }
        return c0();
    }

    public final /* synthetic */ void P(float f10, float f11, Rect rect, ValueAnimator valueAnimator) {
        this.f23635c.updateClipBoundsAndCornerRadius(rect, C1001b.a(f10, f11, valueAnimator.getAnimatedFraction()));
    }

    public final /* synthetic */ void Q() {
        AnimatorSet B10 = B(true);
        B10.addListener(new a());
        B10.start();
    }

    public final /* synthetic */ void R() {
        this.f23635c.setTranslationY(r0.getHeight());
        AnimatorSet J10 = J(true);
        J10.addListener(new c());
        J10.start();
    }

    public androidx.activity.b S() {
        return this.f23645m.c();
    }

    public final void T(float f10) {
        ActionMenuView actionMenuView;
        if (this.f23633a.r() && (actionMenuView = ToolbarUtils.getActionMenuView(this.f23638f)) != null) {
            actionMenuView.setAlpha(f10);
        }
    }

    public final void U(float f10) {
        this.f23642j.setAlpha(f10);
        this.f23643k.setAlpha(f10);
        this.f23644l.setAlpha(f10);
        T(f10);
    }

    public final void V(Drawable drawable) {
        if (drawable instanceof C1027d) {
            ((C1027d) drawable).e(1.0f);
        }
        if (drawable instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) drawable).setProgress(1.0f);
        }
    }

    public final void W(Toolbar toolbar) {
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(toolbar);
        if (actionMenuView != null) {
            for (int i10 = 0; i10 < actionMenuView.getChildCount(); i10++) {
                View childAt = actionMenuView.getChildAt(i10);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    public void X(SearchBar searchBar) {
        this.f23647o = searchBar;
    }

    public final void Y() {
        Menu menu = this.f23639g.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (this.f23647o.getMenuResId() != -1 && this.f23633a.r()) {
            this.f23639g.inflateMenu(this.f23647o.getMenuResId());
            W(this.f23639g);
            this.f23639g.setVisibility(0);
            return;
        }
        this.f23639g.setVisibility(8);
    }

    public void Z() {
        if (this.f23647o != null) {
            d0();
        } else {
            e0();
        }
    }

    public void a0(androidx.activity.b bVar) {
        this.f23645m.t(bVar, this.f23647o);
    }

    public final AnimatorSet b0() {
        if (this.f23633a.o()) {
            this.f23633a.l();
        }
        AnimatorSet B10 = B(false);
        B10.addListener(new b());
        B10.start();
        return B10;
    }

    public final AnimatorSet c0() {
        if (this.f23633a.o()) {
            this.f23633a.l();
        }
        AnimatorSet J10 = J(false);
        J10.addListener(new d());
        J10.start();
        return J10;
    }

    public final void d0() {
        if (this.f23633a.o()) {
            this.f23633a.F();
        }
        this.f23633a.setTransitionState(SearchView.TransitionState.SHOWING);
        Y();
        this.f23641i.setText(this.f23647o.getText());
        EditText editText = this.f23641i;
        editText.setSelection(editText.getText().length());
        this.f23635c.setVisibility(4);
        this.f23635c.post(new Runnable() { // from class: com.google.android.material.search.q
            @Override // java.lang.Runnable
            public final void run() {
                t.this.Q();
            }
        });
    }

    public final void e0() {
        if (this.f23633a.o()) {
            final SearchView searchView = this.f23633a;
            Objects.requireNonNull(searchView);
            searchView.postDelayed(new Runnable() { // from class: com.google.android.material.search.r
                @Override // java.lang.Runnable
                public final void run() {
                    SearchView.this.F();
                }
            }, 150L);
        }
        this.f23635c.setVisibility(4);
        this.f23635c.post(new Runnable() { // from class: com.google.android.material.search.s
            @Override // java.lang.Runnable
            public final void run() {
                t.this.R();
            }
        });
    }

    public void f0(androidx.activity.b bVar) {
        if (bVar.a() <= 0.0f) {
            return;
        }
        C1548g c1548g = this.f23645m;
        SearchBar searchBar = this.f23647o;
        c1548g.v(bVar, searchBar, searchBar.getCornerSize());
        AnimatorSet animatorSet = this.f23646n;
        if (animatorSet == null) {
            if (this.f23633a.o()) {
                this.f23633a.l();
            }
            if (!this.f23633a.p()) {
                return;
            }
            AnimatorSet s10 = s(false);
            this.f23646n = s10;
            s10.start();
            this.f23646n.pause();
            return;
        }
        animatorSet.setCurrentPlayTime(bVar.a() * ((float) this.f23646n.getDuration()));
    }

    public final void j(AnimatorSet animatorSet) {
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(this.f23638f);
        if (actionMenuView == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(C(actionMenuView), 0.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(actionMenuView));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(actionMenuView));
        animatorSet.playTogether(ofFloat, ofFloat2);
    }

    public final void k(AnimatorSet animatorSet) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this.f23638f);
        if (navigationIconButton == null) {
            return;
        }
        Drawable q10 = C.a.q(navigationIconButton.getDrawable());
        if (this.f23633a.p()) {
            m(animatorSet, q10);
            n(animatorSet, q10);
        } else {
            V(q10);
        }
    }

    public final void l(AnimatorSet animatorSet) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this.f23638f);
        if (navigationIconButton == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(D(navigationIconButton), 0.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(navigationIconButton));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(E(), 0.0f);
        ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(navigationIconButton));
        animatorSet.playTogether(ofFloat, ofFloat2);
    }

    public final void m(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof C1027d) {
            final C1027d c1027d = (C1027d) drawable;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.o
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    t.N(C1027d.this, valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    public final void n(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof FadeThroughDrawable) {
            final FadeThroughDrawable fadeThroughDrawable = (FadeThroughDrawable) drawable;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.search.p
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    t.O(FadeThroughDrawable.this, valueAnimator);
                }
            });
            animatorSet.playTogether(ofFloat);
        }
    }

    public void o() {
        this.f23645m.g(this.f23647o);
        AnimatorSet animatorSet = this.f23646n;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.f23646n = null;
    }

    public void p() {
        this.f23645m.j(M().getTotalDuration(), this.f23647o);
        if (this.f23646n != null) {
            t(false).start();
            this.f23646n.resume();
        }
        this.f23646n = null;
    }

    public final Animator q(boolean z10) {
        long j10;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        if (this.f23633a.r()) {
            ofFloat.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.getActionMenuView(this.f23639g), ToolbarUtils.getActionMenuView(this.f23638f)));
        }
        return ofFloat;
    }

    public C1548g r() {
        return this.f23645m;
    }

    public final AnimatorSet s(boolean z10) {
        long j10;
        AnimatorSet animatorSet = new AnimatorSet();
        k(animatorSet);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        return animatorSet;
    }

    public final AnimatorSet t(boolean z10) {
        long j10;
        AnimatorSet animatorSet = new AnimatorSet();
        l(animatorSet);
        j(animatorSet);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        return animatorSet;
    }

    public final Animator u(boolean z10) {
        long j10;
        long j11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (z10) {
            j10 = 50;
        } else {
            j10 = 42;
        }
        ofFloat.setDuration(j10);
        if (z10) {
            j11 = 250;
        } else {
            j11 = 0;
        }
        ofFloat.setStartDelay(j11);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31702a));
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(this.f23642j));
        return ofFloat;
    }

    public final Animator v(boolean z10) {
        long j10;
        long j11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (z10) {
            j10 = 150;
        } else {
            j10 = 83;
        }
        ofFloat.setDuration(j10);
        if (z10) {
            j11 = 75;
        } else {
            j11 = 0;
        }
        ofFloat.setStartDelay(j11);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31702a));
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(this.f23643k, this.f23644l));
        return ofFloat;
    }

    public final Animator w(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(v(z10), y(z10), x(z10));
        return animatorSet;
    }

    public final Animator x(boolean z10) {
        long j10;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.95f, 1.0f);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        ofFloat.addUpdateListener(MultiViewUpdateListener.scaleListener(this.f23644l));
        return ofFloat;
    }

    public final Animator y(boolean z10) {
        long j10;
        ValueAnimator ofFloat = ValueAnimator.ofFloat((this.f23644l.getHeight() * 0.050000012f) / 2.0f, 0.0f);
        if (z10) {
            j10 = 300;
        } else {
            j10 = 250;
        }
        ofFloat.setDuration(j10);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z10, C1001b.f31703b));
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationYListener(this.f23643k));
        return ofFloat;
    }

    public final Animator z(boolean z10) {
        return K(z10, false, this.f23639g);
    }
}
