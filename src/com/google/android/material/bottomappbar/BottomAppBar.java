package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import e4.C0976b;
import e4.C0977c;
import e4.C0979e;
import e4.l;
import f4.C1001b;
import f4.InterfaceC1011l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s4.C1550i;

/* loaded from: classes3.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {

    /* renamed from: F, reason: collision with root package name */
    public static final int f22741F = l.f31042y;

    /* renamed from: G, reason: collision with root package name */
    public static final int f22742G = C0977c.f30648T;

    /* renamed from: H, reason: collision with root package name */
    public static final int f22743H = C0977c.f30662d0;

    /* renamed from: A, reason: collision with root package name */
    public int f22744A;

    /* renamed from: B, reason: collision with root package name */
    public int f22745B;

    /* renamed from: C, reason: collision with root package name */
    public int f22746C;

    /* renamed from: D, reason: collision with root package name */
    public AnimatorListenerAdapter f22747D;

    /* renamed from: E, reason: collision with root package name */
    public InterfaceC1011l<FloatingActionButton> f22748E;

    /* renamed from: a, reason: collision with root package name */
    public Integer f22749a;

    /* renamed from: b, reason: collision with root package name */
    public final x4.i f22750b;

    /* renamed from: c, reason: collision with root package name */
    public Animator f22751c;

    /* renamed from: d, reason: collision with root package name */
    public Animator f22752d;

    /* renamed from: e, reason: collision with root package name */
    public int f22753e;

    /* renamed from: f, reason: collision with root package name */
    public int f22754f;

    /* renamed from: g, reason: collision with root package name */
    public int f22755g;

    /* renamed from: h, reason: collision with root package name */
    public final int f22756h;

    /* renamed from: i, reason: collision with root package name */
    public int f22757i;

    /* renamed from: j, reason: collision with root package name */
    public int f22758j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f22759k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f22760l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f22761m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f22762n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f22763o;

    /* renamed from: p, reason: collision with root package name */
    public int f22764p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<j> f22765q;

    /* renamed from: r, reason: collision with root package name */
    public int f22766r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f22767x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f22768y;

    /* renamed from: z, reason: collision with root package name */
    public Behavior f22769z;

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f22775a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f22776b;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f22775a);
            parcel.writeInt(this.f22776b ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f22775a = parcel.readInt();
            this.f22776b = parcel.readInt() != 0;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!BottomAppBar.this.f22767x) {
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.Y(bottomAppBar.f22753e, BottomAppBar.this.f22768y);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements InterfaceC1011l<FloatingActionButton> {
        public b() {
        }

        @Override // f4.InterfaceC1011l
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(FloatingActionButton floatingActionButton) {
            float f10;
            x4.i iVar = BottomAppBar.this.f22750b;
            if (floatingActionButton.getVisibility() == 0 && BottomAppBar.this.f22755g == 1) {
                f10 = floatingActionButton.getScaleY();
            } else {
                f10 = 0.0f;
            }
            iVar.setInterpolation(f10);
        }

        @Override // f4.InterfaceC1011l
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(FloatingActionButton floatingActionButton) {
            if (BottomAppBar.this.f22755g != 1) {
                return;
            }
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().h() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().n(translationX);
                BottomAppBar.this.f22750b.invalidateSelf();
            }
            float f10 = 0.0f;
            float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().c() != max) {
                BottomAppBar.this.getTopEdgeTreatment().i(max);
                BottomAppBar.this.f22750b.invalidateSelf();
            }
            x4.i iVar = BottomAppBar.this.f22750b;
            if (floatingActionButton.getVisibility() == 0) {
                f10 = floatingActionButton.getScaleY();
            }
            iVar.setInterpolation(f10);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ViewUtils.OnApplyWindowInsetsListener {
        public c() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public X onApplyWindowInsets(View view, X x10, ViewUtils.RelativePadding relativePadding) {
            boolean z10;
            if (BottomAppBar.this.f22761m) {
                BottomAppBar.this.f22744A = x10.j();
            }
            boolean z11 = true;
            boolean z12 = false;
            if (BottomAppBar.this.f22762n) {
                if (BottomAppBar.this.f22746C != x10.k()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                BottomAppBar.this.f22746C = x10.k();
            } else {
                z10 = false;
            }
            if (BottomAppBar.this.f22763o) {
                if (BottomAppBar.this.f22745B == x10.l()) {
                    z11 = false;
                }
                BottomAppBar.this.f22745B = x10.l();
                z12 = z11;
            }
            if (z10 || z12) {
                BottomAppBar.this.M();
                BottomAppBar.this.c0();
                BottomAppBar.this.b0();
            }
            return x10;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.Q();
            BottomAppBar.this.f22751c = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.R();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends FloatingActionButton.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22781a;

        /* loaded from: classes3.dex */
        public class a extends FloatingActionButton.b {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.Q();
            }
        }

        public e(int i10) {
            this.f22781a = i10;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.V(this.f22781a));
            floatingActionButton.r(new a());
        }
    }

    /* loaded from: classes3.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.Q();
            BottomAppBar.this.f22767x = false;
            BottomAppBar.this.f22752d = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.R();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f22785a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f22786b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f22787c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f22788d;

        public g(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f22786b = actionMenuView;
            this.f22787c = i10;
            this.f22788d = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f22785a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            boolean z10;
            if (!this.f22785a) {
                if (BottomAppBar.this.f22766r != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                BottomAppBar bottomAppBar = BottomAppBar.this;
                bottomAppBar.a0(bottomAppBar.f22766r);
                BottomAppBar.this.g0(this.f22786b, this.f22787c, this.f22788d, z10);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMenuView f22790a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22791b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f22792c;

        public h(ActionMenuView actionMenuView, int i10, boolean z10) {
            this.f22790a = actionMenuView;
            this.f22791b = i10;
            this.f22792c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f22790a.setTranslationX(BottomAppBar.this.U(r0, this.f22791b, this.f22792c));
        }
    }

    /* loaded from: classes3.dex */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.f22747D.onAnimationStart(animator);
            FloatingActionButton S10 = BottomAppBar.this.S();
            if (S10 != null) {
                S10.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30661d);
    }

    private ActionMenuView getActionMenuView() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.f22744A;
    }

    private int getFabAlignmentAnimationDuration() {
        return C1550i.f(getContext(), f22742G, 300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return V(this.f22753e);
    }

    private float getFabTranslationY() {
        int i10;
        if (this.f22755g == 1) {
            return -getTopEdgeTreatment().c();
        }
        View T10 = T();
        if (T10 != null) {
            i10 = (-((getMeasuredHeight() + getBottomInset()) - T10.getMeasuredHeight())) / 2;
        } else {
            i10 = 0;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.f22746C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.f22745B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.material.bottomappbar.b getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.b) this.f22750b.getShapeAppearanceModel().p();
    }

    public static void h0(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
        eVar.f9319d = 17;
        int i10 = bottomAppBar.f22755g;
        if (i10 == 1) {
            eVar.f9319d = 17 | 48;
        }
        if (i10 == 0) {
            eVar.f9319d |= 80;
        }
    }

    public final void L(FloatingActionButton floatingActionButton) {
        floatingActionButton.d(this.f22747D);
        floatingActionButton.e(new i());
        floatingActionButton.f(this.f22748E);
    }

    public final void M() {
        Animator animator = this.f22752d;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f22751c;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    public void N(int i10, List<Animator> list) {
        FloatingActionButton S10 = S();
        if (S10 != null && !S10.n()) {
            R();
            S10.l(new e(i10));
        }
    }

    public final void O(int i10, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(S(), "translationX", V(i10));
        ofFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(ofFloat);
    }

    public final void P(int i10, boolean z10, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        ofFloat.setDuration(0.8f * fabAlignmentAnimationDuration);
        if (Math.abs(actionMenuView.getTranslationX() - U(actionMenuView, i10, z10)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.setDuration(fabAlignmentAnimationDuration * 0.2f);
            ofFloat2.addListener(new g(actionMenuView, i10, z10));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
            return;
        }
        if (actionMenuView.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    public final void Q() {
        ArrayList<j> arrayList;
        int i10 = this.f22764p - 1;
        this.f22764p = i10;
        if (i10 == 0 && (arrayList = this.f22765q) != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b(this);
            }
        }
    }

    public final void R() {
        ArrayList<j> arrayList;
        int i10 = this.f22764p;
        this.f22764p = i10 + 1;
        if (i10 == 0 && (arrayList = this.f22765q) != null) {
            Iterator<j> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        }
    }

    public final FloatingActionButton S() {
        View T10 = T();
        if (T10 instanceof FloatingActionButton) {
            return (FloatingActionButton) T10;
        }
        return null;
    }

    public final View T() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).q(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    public int U(ActionMenuView actionMenuView, int i10, boolean z10) {
        int i11;
        int left;
        int i12;
        int i13 = 0;
        if (this.f22758j != 1 && (i10 != 1 || !z10)) {
            return 0;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (isLayoutRtl) {
            i11 = getMeasuredWidth();
        } else {
            i11 = 0;
        }
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View childAt = getChildAt(i14);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & 8388615) == 8388611) {
                if (isLayoutRtl) {
                    i11 = Math.min(i11, childAt.getLeft());
                } else {
                    i11 = Math.max(i11, childAt.getRight());
                }
            }
        }
        if (isLayoutRtl) {
            left = actionMenuView.getRight();
        } else {
            left = actionMenuView.getLeft();
        }
        if (isLayoutRtl) {
            i12 = this.f22745B;
        } else {
            i12 = -this.f22746C;
        }
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(C0979e.f30725B);
            if (!isLayoutRtl) {
                dimensionPixelOffset = -dimensionPixelOffset;
            }
            i13 = dimensionPixelOffset;
        }
        return i11 - ((left + i12) + i13);
    }

    public final float V(int i10) {
        int i11;
        int i12;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int i13 = 1;
        if (i10 == 1) {
            View T10 = T();
            if (isLayoutRtl) {
                i11 = this.f22746C;
            } else {
                i11 = this.f22745B;
            }
            if (this.f22757i != -1 && T10 != null) {
                i12 = (T10.getMeasuredWidth() / 2) + this.f22757i;
            } else {
                i12 = this.f22756h;
            }
            int measuredWidth = (getMeasuredWidth() / 2) - (i11 + i12);
            if (isLayoutRtl) {
                i13 = -1;
            }
            return measuredWidth * i13;
        }
        return 0.0f;
    }

    public final boolean W() {
        FloatingActionButton S10 = S();
        if (S10 != null && S10.o()) {
            return true;
        }
        return false;
    }

    public final void Y(int i10, boolean z10) {
        if (!K.O(this)) {
            this.f22767x = false;
            a0(this.f22766r);
            return;
        }
        Animator animator = this.f22752d;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!W()) {
            i10 = 0;
            z10 = false;
        }
        P(i10, z10, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f22752d = animatorSet;
        animatorSet.addListener(new f());
        this.f22752d.start();
    }

    public final void Z(int i10) {
        if (this.f22753e != i10 && K.O(this)) {
            Animator animator = this.f22751c;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f22754f == 1) {
                O(i10, arrayList);
            } else {
                N(i10, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setInterpolator(C1550i.g(getContext(), f22743H, C1001b.f31702a));
            this.f22751c = animatorSet;
            animatorSet.addListener(new d());
            this.f22751c.start();
        }
    }

    public void a0(int i10) {
        if (i10 != 0) {
            this.f22766r = 0;
            getMenu().clear();
            inflateMenu(i10);
        }
    }

    public final void b0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.f22752d == null) {
            actionMenuView.setAlpha(1.0f);
            if (!W()) {
                f0(actionMenuView, 0, false);
            } else {
                f0(actionMenuView, this.f22753e, this.f22768y);
            }
        }
    }

    public final void c0() {
        float f10;
        getTopEdgeTreatment().n(getFabTranslationX());
        x4.i iVar = this.f22750b;
        if (this.f22768y && W() && this.f22755g == 1) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        iVar.setInterpolation(f10);
        View T10 = T();
        if (T10 != null) {
            T10.setTranslationY(getFabTranslationY());
            T10.setTranslationX(getFabTranslationX());
        }
    }

    public void d0(int i10, int i11) {
        this.f22766r = i11;
        this.f22767x = true;
        Y(i10, this.f22768y);
        Z(i10);
        this.f22753e = i10;
    }

    public boolean e0(int i10) {
        float f10 = i10;
        if (f10 != getTopEdgeTreatment().g()) {
            getTopEdgeTreatment().m(f10);
            this.f22750b.invalidateSelf();
            return true;
        }
        return false;
    }

    public final void f0(ActionMenuView actionMenuView, int i10, boolean z10) {
        g0(actionMenuView, i10, z10, false);
    }

    public final void g0(ActionMenuView actionMenuView, int i10, boolean z10, boolean z11) {
        h hVar = new h(actionMenuView, i10, z10);
        if (z11) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    public ColorStateList getBackgroundTint() {
        return this.f22750b.getTintList();
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.f22753e;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.f22757i;
    }

    public int getFabAnchorMode() {
        return this.f22755g;
    }

    public int getFabAnimationMode() {
        return this.f22754f;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().e();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f();
    }

    public boolean getHideOnScroll() {
        return this.f22760l;
    }

    public int getMenuAlignmentMode() {
        return this.f22758j;
    }

    public final Drawable maybeTintNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f22749a != null) {
            Drawable r10 = C.a.r(drawable.mutate());
            C.a.n(r10, this.f22749a.intValue());
            return r10;
        }
        return drawable;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x4.j.f(this, this.f22750b);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10) {
            M();
            c0();
            final View T10 = T();
            if (T10 != null && K.O(T10)) {
                T10.post(new Runnable() { // from class: com.google.android.material.bottomappbar.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        T10.requestLayout();
                    }
                });
            }
        }
        b0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f22753e = savedState.f22775a;
        this.f22768y = savedState.f22776b;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f22775a = this.f22753e;
        savedState.f22776b = this.f22768y;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        C.a.o(this.f22750b, colorStateList);
    }

    public void setCradleVerticalOffset(float f10) {
        if (f10 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().i(f10);
            this.f22750b.invalidateSelf();
            c0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        this.f22750b.setElevation(f10);
        getBehavior().e(this, this.f22750b.getShadowRadius() - this.f22750b.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int i10) {
        d0(i10, 0);
    }

    public void setFabAlignmentModeEndMargin(int i10) {
        if (this.f22757i != i10) {
            this.f22757i = i10;
            c0();
        }
    }

    public void setFabAnchorMode(int i10) {
        this.f22755g = i10;
        c0();
        View T10 = T();
        if (T10 != null) {
            h0(this, T10);
            T10.requestLayout();
            this.f22750b.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i10) {
        this.f22754f = i10;
    }

    public void setFabCornerSize(float f10) {
        if (f10 != getTopEdgeTreatment().d()) {
            getTopEdgeTreatment().j(f10);
            this.f22750b.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f10) {
        if (f10 != getFabCradleMargin()) {
            getTopEdgeTreatment().k(f10);
            this.f22750b.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        if (f10 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().l(f10);
            this.f22750b.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z10) {
        this.f22760l = z10;
    }

    public void setMenuAlignmentMode(int i10) {
        if (this.f22758j != i10) {
            this.f22758j = i10;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                f0(actionMenuView, this.f22753e, W());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.f22749a = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public BottomAppBar(android.content.Context r13, android.util.AttributeSet r14, int r15) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.f22769z == null) {
            this.f22769z = new Behavior();
        }
        return this.f22769z;
    }

    /* loaded from: classes3.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: m, reason: collision with root package name */
        public final Rect f22770m;

        /* renamed from: n, reason: collision with root package name */
        public WeakReference<BottomAppBar> f22771n;

        /* renamed from: o, reason: collision with root package name */
        public int f22772o;

        /* renamed from: p, reason: collision with root package name */
        public final View.OnLayoutChangeListener f22773p;

        /* loaded from: classes3.dex */
        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f22771n.get();
                if (bottomAppBar != null && ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    int height = view.getHeight();
                    if (view instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                        floatingActionButton.i(Behavior.this.f22770m);
                        int height2 = Behavior.this.f22770m.height();
                        bottomAppBar.e0(height2);
                        bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f22770m)));
                        height = height2;
                    }
                    CoordinatorLayout.e eVar = (CoordinatorLayout.e) view.getLayoutParams();
                    if (Behavior.this.f22772o == 0) {
                        if (bottomAppBar.f22755g == 1) {
                            ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(C0979e.f30793k0) - ((view.getMeasuredHeight() - height) / 2));
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = bottomAppBar.getRightInset();
                        if (ViewUtils.isLayoutRtl(view)) {
                            ((ViewGroup.MarginLayoutParams) eVar).leftMargin += bottomAppBar.f22756h;
                        } else {
                            ((ViewGroup.MarginLayoutParams) eVar).rightMargin += bottomAppBar.f22756h;
                        }
                    }
                    bottomAppBar.c0();
                    return;
                }
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f22773p = new a();
            this.f22770m = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i10) {
            this.f22771n = new WeakReference<>(bottomAppBar);
            View T10 = bottomAppBar.T();
            if (T10 != null && !K.O(T10)) {
                BottomAppBar.h0(bottomAppBar, T10);
                this.f22772o = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) T10.getLayoutParams())).bottomMargin;
                if (T10 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) T10;
                    if (bottomAppBar.f22755g == 0 && bottomAppBar.f22759k) {
                        K.r0(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(C0976b.f30621f);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(C0976b.f30620e);
                    }
                    bottomAppBar.L(floatingActionButton);
                }
                T10.addOnLayoutChangeListener(this.f22773p);
                bottomAppBar.c0();
            }
            coordinatorLayout.G(bottomAppBar, i10);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i10);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i10, int i11) {
            if (bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i10, i11)) {
                return true;
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f22773p = new a();
            this.f22770m = new Rect();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
