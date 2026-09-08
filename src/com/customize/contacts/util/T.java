package com.customize.contacts.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.util.Property;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.bottomnavigation.COUINavigationMenuView;
import com.coui.appcompat.bottomnavigation.COUINavigationView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;

/* compiled from: NavigationViewController.kt */
/* loaded from: classes3.dex */
public final class T {

    /* renamed from: p, reason: collision with root package name */
    public static final a f21946p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final PathInterpolator f21947q = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: r, reason: collision with root package name */
    public static final PathInterpolator f21948r = new PathInterpolator(0.33f, 0.0f, 0.83f, 0.83f);

    /* renamed from: s, reason: collision with root package name */
    public static final PathInterpolator f21949s = new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public Activity f21950a;

    /* renamed from: b, reason: collision with root package name */
    public COUINavigationView f21951b;

    /* renamed from: c, reason: collision with root package name */
    public COUINavigationView f21952c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f21953d;

    /* renamed from: e, reason: collision with root package name */
    public ObjectAnimator f21954e;

    /* renamed from: f, reason: collision with root package name */
    public ObjectAnimator f21955f;

    /* renamed from: g, reason: collision with root package name */
    public ObjectAnimator f21956g;

    /* renamed from: h, reason: collision with root package name */
    public ObjectAnimator f21957h;

    /* renamed from: i, reason: collision with root package name */
    public ObjectAnimator f21958i;

    /* renamed from: j, reason: collision with root package name */
    public float f21959j;

    /* renamed from: k, reason: collision with root package name */
    public float f21960k;

    /* renamed from: l, reason: collision with root package name */
    public float f21961l;

    /* renamed from: m, reason: collision with root package name */
    public float f21962m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f21963n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21964o;

    /* compiled from: NavigationViewController.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final PathInterpolator a() {
            return T.f21947q;
        }

        public final PathInterpolator b() {
            return T.f21948r;
        }

        public final PathInterpolator c() {
            return T.f21949s;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public T(Activity activity, COUINavigationView labelNavigationView, COUINavigationView cOUINavigationView) {
        float f10;
        float f11;
        float f12;
        Resources resources;
        Resources resources2;
        Resources resources3;
        Resources resources4;
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(labelNavigationView, "labelNavigationView");
        this.f21950a = activity;
        this.f21951b = cOUINavigationView;
        this.f21952c = labelNavigationView;
        float f13 = 0.0f;
        if (activity != null && (resources4 = activity.getResources()) != null) {
            f10 = resources4.getDimension(R.dimen.DP_30);
        } else {
            f10 = 0.0f;
        }
        this.f21959j = f10;
        Activity activity2 = this.f21950a;
        if (activity2 != null && (resources3 = activity2.getResources()) != null) {
            f11 = resources3.getDimension(R.dimen.contact_bottom_tab_height);
        } else {
            f11 = 0.0f;
        }
        this.f21960k = f11;
        Activity activity3 = this.f21950a;
        if (activity3 != null && (resources2 = activity3.getResources()) != null) {
            f12 = resources2.getDimension(R.dimen.contact_bottom_tab_unfold_height);
        } else {
            f12 = 0.0f;
        }
        this.f21961l = f12;
        Activity activity4 = this.f21950a;
        if (activity4 != null && (resources = activity4.getResources()) != null) {
            f13 = resources.getDimension(R.dimen.contact_bottom_tab_height);
        }
        this.f21962m = f13;
    }

    public final void e(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator = this.f21958i;
        if (objectAnimator == null) {
            if (z10) {
                animatorSet.playTogether(this.f21954e, this.f21955f);
            } else {
                animatorSet.playTogether(this.f21954e);
            }
        } else if (z10) {
            animatorSet.playTogether(objectAnimator, this.f21954e, this.f21955f);
        } else {
            animatorSet.playTogether(objectAnimator, this.f21954e);
        }
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    public final void f(boolean z10) {
        if (!this.f21963n) {
            return;
        }
        this.f21963n = false;
        H7.b.b("DebugTest", "Enter exitEditMode");
        e(z10);
    }

    public final void g(boolean z10) {
        View view;
        View view2;
        View view3;
        View view4;
        COUINavigationView cOUINavigationView;
        COUINavigationView cOUINavigationView2;
        COUINavigationView cOUINavigationView3 = this.f21951b;
        if (cOUINavigationView3 != null) {
            view = cOUINavigationView3.getChildAt(0);
        } else {
            view = null;
        }
        if ((view instanceof COUINavigationMenuView) && (cOUINavigationView2 = this.f21951b) != null) {
            view2 = cOUINavigationView2.getChildAt(0);
        } else {
            view2 = null;
        }
        COUINavigationView cOUINavigationView4 = this.f21952c;
        if (cOUINavigationView4 != null) {
            view3 = cOUINavigationView4.getChildAt(0);
        } else {
            view3 = null;
        }
        if ((view3 instanceof COUINavigationMenuView) && (cOUINavigationView = this.f21952c) != null) {
            view4 = cOUINavigationView.getChildAt(0);
        } else {
            view4 = null;
        }
        boolean r10 = DisplayUtil.r(this.f21950a, null, null, 6, null);
        this.f21964o = r10;
        if (r10) {
            q(view2, view4);
        } else {
            m(view2, view4);
        }
        if (z10) {
            if (this.f21964o) {
                p(view2, view4);
            } else {
                l(view2, view4);
            }
        }
    }

    public final void h(boolean z10) {
        H7.b.b("NavigationViewController", "Enter showEditMode");
        this.f21963n = true;
        i(z10);
    }

    public final void i(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator = this.f21957h;
        if (objectAnimator == null) {
            if (z10) {
                animatorSet.playTogether(this.f21953d, this.f21956g);
            } else {
                animatorSet.playTogether(this.f21953d);
            }
        } else if (z10) {
            animatorSet.playTogether(objectAnimator, this.f21953d, this.f21956g);
        } else {
            animatorSet.playTogether(objectAnimator, this.f21953d);
        }
        animatorSet.addListener(new c());
        animatorSet.start();
    }

    public final void j() {
        View view;
        View view2;
        View view3;
        COUINavigationView cOUINavigationView;
        COUINavigationView cOUINavigationView2;
        COUINavigationView cOUINavigationView3 = this.f21951b;
        View view4 = null;
        if (cOUINavigationView3 != null) {
            view = cOUINavigationView3.getChildAt(0);
        } else {
            view = null;
        }
        if ((view instanceof COUINavigationMenuView) && (cOUINavigationView2 = this.f21951b) != null) {
            view2 = cOUINavigationView2.getChildAt(0);
        } else {
            view2 = null;
        }
        COUINavigationView cOUINavigationView4 = this.f21952c;
        if (cOUINavigationView4 != null) {
            view3 = cOUINavigationView4.getChildAt(0);
        } else {
            view3 = null;
        }
        if ((view3 instanceof COUINavigationMenuView) && (cOUINavigationView = this.f21952c) != null) {
            view4 = cOUINavigationView.getChildAt(0);
        }
        k(view2, view4);
    }

    public final void k(View view, View view2) {
        if (this.f21964o) {
            p(view, view2);
        } else {
            l(view, view2);
        }
    }

    public final void l(View view, View view2) {
        COUINavigationView cOUINavigationView = this.f21951b;
        if (cOUINavigationView == null) {
            cOUINavigationView = new COUINavigationView(this.f21950a);
        }
        Property property = View.ALPHA;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cOUINavigationView, (Property<COUINavigationView, Float>) property, 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        PathInterpolator pathInterpolator = f21949s;
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat.setStartDelay(100L);
        this.f21957h = ofFloat;
        COUINavigationView cOUINavigationView2 = this.f21951b;
        if (cOUINavigationView2 == null) {
            cOUINavigationView2 = new COUINavigationView(this.f21950a);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(cOUINavigationView2, (Property<COUINavigationView, Float>) property, 1.0f, 0.0f);
        ofFloat2.setDuration(230L);
        PathInterpolator pathInterpolator2 = f21948r;
        ofFloat2.setInterpolator(pathInterpolator2);
        this.f21958i = ofFloat2;
        Property property2 = View.TRANSLATION_Y;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, this.f21959j, 0.0f);
        ofFloat3.setDuration(300L);
        ofFloat3.setInterpolator(pathInterpolator);
        ofFloat3.setStartDelay(100L);
        this.f21953d = ofFloat3;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, this.f21959j);
        ofFloat4.setDuration(230L);
        ofFloat4.setInterpolator(pathInterpolator2);
        this.f21954e = ofFloat4;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 0.0f, 1.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.setStartDelay(230L);
        PathInterpolator pathInterpolator3 = f21947q;
        ofFloat5.setInterpolator(pathInterpolator3);
        this.f21955f = ofFloat5;
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 1.0f, 0.0f);
        ofFloat6.setDuration(200L);
        ofFloat6.setInterpolator(pathInterpolator3);
        this.f21956g = ofFloat6;
    }

    public final void m(View view, View view2) {
        if (this.f21963n) {
            COUINavigationView cOUINavigationView = this.f21952c;
            if (cOUINavigationView != null) {
                cOUINavigationView.setTranslationY(0.0f);
            }
            if (view != null) {
                view.setTranslationY(0.0f);
            }
            COUINavigationView cOUINavigationView2 = this.f21951b;
            if (cOUINavigationView2 != null) {
                cOUINavigationView2.setAlpha(1.0f);
            }
            if (view2 != null) {
                view2.setAlpha(0.0f);
                return;
            }
            return;
        }
        if (view != null) {
            view.setTranslationY(this.f21959j);
        }
        COUINavigationView cOUINavigationView3 = this.f21951b;
        if (cOUINavigationView3 != null) {
            cOUINavigationView3.setTranslationY(0.0f);
        }
        COUINavigationView cOUINavigationView4 = this.f21951b;
        if (cOUINavigationView4 != null) {
            cOUINavigationView4.setAlpha(0.0f);
        }
    }

    public final void n(int i10, boolean z10) {
        COUINavigationView cOUINavigationView = this.f21952c;
        if (cOUINavigationView != null) {
            Menu menu = cOUINavigationView.getMenu();
            MenuItem findItem = menu.findItem(i10);
            int size = menu.size();
            int i11 = -1;
            for (int i12 = 0; i12 < size; i12++) {
                MenuItem item = menu.getItem(i12);
                if (item.isVisible()) {
                    i11++;
                }
                if (kotlin.jvm.internal.i.b(item, findItem)) {
                    if (H7.a.b()) {
                        H7.b.e("NavigationViewController", " index = " + i12 + "  visibleSize=" + i11 + " hasRed=" + z10);
                    }
                    if (z10) {
                        cOUINavigationView.setTipsView(i11, 0, 1);
                        return;
                    } else {
                        cOUINavigationView.setTipsView(i11, 0, 3);
                        return;
                    }
                }
            }
        }
    }

    public final void o(COUINavigationView toolNavigationView) {
        kotlin.jvm.internal.i.f(toolNavigationView, "toolNavigationView");
        this.f21951b = toolNavigationView;
    }

    public final void p(View view, View view2) {
        this.f21957h = null;
        this.f21958i = null;
        float f10 = this.f21960k;
        COUINavigationView cOUINavigationView = this.f21951b;
        Property property = View.TRANSLATION_Y;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cOUINavigationView, (Property<COUINavigationView, Float>) property, f10, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(f21949s);
        ofFloat.setStartDelay(100L);
        this.f21953d = ofFloat;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21951b, (Property<COUINavigationView, Float>) property, 0.0f, f10);
        ofFloat2.setDuration(230L);
        ofFloat2.setInterpolator(f21948r);
        this.f21954e = ofFloat2;
        float f11 = this.f21961l;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f21952c, (Property<COUINavigationView, Float>) property, f11, 0.0f);
        ofFloat3.setDuration(200L);
        ofFloat3.setStartDelay(230L);
        PathInterpolator pathInterpolator = f21947q;
        ofFloat3.setInterpolator(pathInterpolator);
        this.f21955f = ofFloat3;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f21952c, (Property<COUINavigationView, Float>) property, 0.0f, f11);
        ofFloat4.setDuration(200L);
        ofFloat4.setInterpolator(pathInterpolator);
        this.f21956g = ofFloat4;
    }

    public final void q(View view, View view2) {
        if (this.f21963n) {
            COUINavigationView cOUINavigationView = this.f21952c;
            if (cOUINavigationView != null) {
                cOUINavigationView.setTranslationY(this.f21961l);
            }
            if (view != null) {
                view.setTranslationY(0.0f);
            }
            if (view2 != null) {
                view2.setAlpha(1.0f);
            }
            COUINavigationView cOUINavigationView2 = this.f21951b;
            if (cOUINavigationView2 != null) {
                cOUINavigationView2.setAlpha(1.0f);
                return;
            }
            return;
        }
        COUINavigationView cOUINavigationView3 = this.f21951b;
        if (cOUINavigationView3 != null) {
            cOUINavigationView3.setTranslationY(this.f21960k);
        }
        COUINavigationView cOUINavigationView4 = this.f21951b;
        if (cOUINavigationView4 != null) {
            cOUINavigationView4.setAlpha(1.0f);
        }
        if (view != null) {
            view.setTranslationY(0.0f);
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            COUINavigationView cOUINavigationView = T.this.f21951b;
            if (cOUINavigationView != null) {
                cOUINavigationView.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            COUINavigationView cOUINavigationView = T.this.f21951b;
            if (cOUINavigationView != null) {
                cOUINavigationView.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
