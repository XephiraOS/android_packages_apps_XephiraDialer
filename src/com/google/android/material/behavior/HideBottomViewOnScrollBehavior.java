package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e4.C0977c;
import f4.C1001b;
import java.util.Iterator;
import java.util.LinkedHashSet;
import s4.C1550i;

/* loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: j, reason: collision with root package name */
    public static final int f22710j = C0977c.f30648T;

    /* renamed from: k, reason: collision with root package name */
    public static final int f22711k = C0977c.f30651W;

    /* renamed from: l, reason: collision with root package name */
    public static final int f22712l = C0977c.f30662d0;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<b> f22713a;

    /* renamed from: b, reason: collision with root package name */
    public int f22714b;

    /* renamed from: c, reason: collision with root package name */
    public int f22715c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f22716d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f22717e;

    /* renamed from: f, reason: collision with root package name */
    public int f22718f;

    /* renamed from: g, reason: collision with root package name */
    public int f22719g;

    /* renamed from: h, reason: collision with root package name */
    public int f22720h;

    /* renamed from: i, reason: collision with root package name */
    public ViewPropertyAnimator f22721i;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f22721i = null;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, int i10);
    }

    public HideBottomViewOnScrollBehavior() {
        this.f22713a = new LinkedHashSet<>();
        this.f22718f = 0;
        this.f22719g = 2;
        this.f22720h = 0;
    }

    public final void b(V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f22721i = v10.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new a());
    }

    public boolean c() {
        if (this.f22719g == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f22719g == 2) {
            return true;
        }
        return false;
    }

    public void e(V v10, int i10) {
        this.f22720h = i10;
        if (this.f22719g == 1) {
            v10.setTranslationY(this.f22718f + i10);
        }
    }

    public void f(V v10) {
        g(v10, true);
    }

    public void g(V v10, boolean z10) {
        if (c()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f22721i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        j(v10, 1);
        int i10 = this.f22718f + this.f22720h;
        if (z10) {
            b(v10, i10, this.f22715c, this.f22717e);
        } else {
            v10.setTranslationY(i10);
        }
    }

    public void h(V v10) {
        i(v10, true);
    }

    public void i(V v10, boolean z10) {
        if (d()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f22721i;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        j(v10, 2);
        if (z10) {
            b(v10, 0, this.f22714b, this.f22716d);
        } else {
            v10.setTranslationY(0);
        }
    }

    public final void j(V v10, int i10) {
        this.f22719g = i10;
        Iterator<b> it = this.f22713a.iterator();
        while (it.hasNext()) {
            it.next().a(v10, this.f22719g);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        this.f22718f = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        this.f22714b = C1550i.f(v10.getContext(), f22710j, 225);
        this.f22715c = C1550i.f(v10.getContext(), f22711k, 175);
        Context context = v10.getContext();
        int i11 = f22712l;
        this.f22716d = C1550i.g(context, i11, C1001b.f31705d);
        this.f22717e = C1550i.g(v10.getContext(), i11, C1001b.f31704c);
        return super.onLayoutChild(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i11 > 0) {
            f(v10);
        } else if (i11 < 0) {
            h(v10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        if (i10 == 2) {
            return true;
        }
        return false;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22713a = new LinkedHashSet<>();
        this.f22718f = 0;
        this.f22719g = 2;
        this.f22720h = 0;
    }
}
