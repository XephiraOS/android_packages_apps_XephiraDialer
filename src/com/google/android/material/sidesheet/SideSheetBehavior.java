package com.google.android.material.sidesheet;

import J.d;
import J.g;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C0455j;
import androidx.core.view.K;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.c;
import com.android.incallui.OplusPhoneUtils;
import com.google.android.material.sidesheet.SideSheetBehavior;
import e4.k;
import e4.l;
import e4.m;
import f4.C1001b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import s4.C1549h;
import s4.InterfaceC1543b;
import u4.C1607c;
import x4.i;
import x4.n;
import y4.C1705a;
import y4.d;
import y4.e;
import y4.j;

/* loaded from: classes3.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements InterfaceC1543b {

    /* renamed from: E, reason: collision with root package name */
    public static final int f23654E = k.f30972Y;

    /* renamed from: F, reason: collision with root package name */
    public static final int f23655F = l.f31040w;

    /* renamed from: A, reason: collision with root package name */
    public C1549h f23656A;

    /* renamed from: B, reason: collision with root package name */
    public int f23657B;

    /* renamed from: C, reason: collision with root package name */
    public final Set<j> f23658C;

    /* renamed from: D, reason: collision with root package name */
    public final c.AbstractC0115c f23659D;

    /* renamed from: a, reason: collision with root package name */
    public d f23660a;

    /* renamed from: b, reason: collision with root package name */
    public float f23661b;

    /* renamed from: c, reason: collision with root package name */
    public i f23662c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f23663d;

    /* renamed from: e, reason: collision with root package name */
    public n f23664e;

    /* renamed from: f, reason: collision with root package name */
    public final SideSheetBehavior<V>.c f23665f;

    /* renamed from: g, reason: collision with root package name */
    public float f23666g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f23667h;

    /* renamed from: i, reason: collision with root package name */
    public int f23668i;

    /* renamed from: j, reason: collision with root package name */
    public int f23669j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.customview.widget.c f23670k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f23671l;

    /* renamed from: m, reason: collision with root package name */
    public float f23672m;

    /* renamed from: n, reason: collision with root package name */
    public int f23673n;

    /* renamed from: o, reason: collision with root package name */
    public int f23674o;

    /* renamed from: p, reason: collision with root package name */
    public int f23675p;

    /* renamed from: q, reason: collision with root package name */
    public int f23676q;

    /* renamed from: r, reason: collision with root package name */
    public WeakReference<V> f23677r;

    /* renamed from: x, reason: collision with root package name */
    public WeakReference<View> f23678x;

    /* renamed from: y, reason: collision with root package name */
    public int f23679y;

    /* renamed from: z, reason: collision with root package name */
    public VelocityTracker f23680z;

    /* loaded from: classes3.dex */
    public class a extends c.AbstractC0115c {
        public a() {
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionHorizontal(View view, int i10, int i11) {
            return E.a.b(i10, SideSheetBehavior.this.f23660a.g(), SideSheetBehavior.this.f23660a.f());
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int clampViewPositionVertical(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public int getViewHorizontalDragRange(View view) {
            return SideSheetBehavior.this.f23673n + SideSheetBehavior.this.x();
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewDragStateChanged(int i10) {
            if (i10 == 1 && SideSheetBehavior.this.f23667h) {
                SideSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewPositionChanged(View view, int i10, int i11, int i12, int i13) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View u10 = SideSheetBehavior.this.u();
            if (u10 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) u10.getLayoutParams()) != null) {
                SideSheetBehavior.this.f23660a.p(marginLayoutParams, view.getLeft(), view.getRight());
                u10.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.this.q(view, i10);
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public void onViewReleased(View view, float f10, float f11) {
            int o10 = SideSheetBehavior.this.o(view, f10, f11);
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            sideSheetBehavior.startSettling(view, o10, sideSheetBehavior.shouldSkipSmoothAnimation());
        }

        @Override // androidx.customview.widget.c.AbstractC0115c
        public boolean tryCaptureView(View view, int i10) {
            if (SideSheetBehavior.this.f23668i == 1 || SideSheetBehavior.this.f23677r == null || SideSheetBehavior.this.f23677r.get() != view) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.setStateInternal(5);
            if (SideSheetBehavior.this.f23677r != null && SideSheetBehavior.this.f23677r.get() != null) {
                ((View) SideSheetBehavior.this.f23677r.get()).requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f23684a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f23685b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f23686c = new Runnable() { // from class: y4.i
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.c.this.c();
            }
        };

        public c() {
        }

        public void b(int i10) {
            if (SideSheetBehavior.this.f23677r != null && SideSheetBehavior.this.f23677r.get() != null) {
                this.f23684a = i10;
                if (!this.f23685b) {
                    K.a0((View) SideSheetBehavior.this.f23677r.get(), this.f23686c);
                    this.f23685b = true;
                }
            }
        }

        public final /* synthetic */ void c() {
            this.f23685b = false;
            if (SideSheetBehavior.this.f23670k != null && SideSheetBehavior.this.f23670k.n(true)) {
                b(this.f23684a);
            } else if (SideSheetBehavior.this.f23668i == 2) {
                SideSheetBehavior.this.setStateInternal(this.f23684a);
            }
        }
    }

    public SideSheetBehavior() {
        this.f23665f = new c();
        this.f23667h = true;
        this.f23668i = 5;
        this.f23669j = 5;
        this.f23672m = 0.1f;
        this.f23679y = -1;
        this.f23658C = new LinkedHashSet();
        this.f23659D = new a();
    }

    public int A() {
        return this.f23674o;
    }

    public androidx.customview.widget.c B() {
        return this.f23670k;
    }

    public final CoordinatorLayout.e C() {
        V v10;
        WeakReference<V> weakReference = this.f23677r;
        if (weakReference != null && (v10 = weakReference.get()) != null && (v10.getLayoutParams() instanceof CoordinatorLayout.e)) {
            return (CoordinatorLayout.e) v10.getLayoutParams();
        }
        return null;
    }

    public final boolean D() {
        CoordinatorLayout.e C10 = C();
        if (C10 != null && ((ViewGroup.MarginLayoutParams) C10).leftMargin > 0) {
            return true;
        }
        return false;
    }

    public final boolean E() {
        CoordinatorLayout.e C10 = C();
        if (C10 != null && ((ViewGroup.MarginLayoutParams) C10).rightMargin > 0) {
            return true;
        }
        return false;
    }

    public final boolean F(MotionEvent motionEvent) {
        if (!shouldHandleDraggingWithHelper() || n(this.f23657B, motionEvent.getX()) <= this.f23670k.A()) {
            return false;
        }
        return true;
    }

    public final boolean G(float f10) {
        return this.f23660a.k(f10);
    }

    public final boolean H(V v10) {
        ViewParent parent = v10.getParent();
        if (parent != null && parent.isLayoutRequested() && K.N(v10)) {
            return true;
        }
        return false;
    }

    public final boolean I(View view, int i10, boolean z10) {
        int y10 = y(i10);
        androidx.customview.widget.c B10 = B();
        if (B10 != null && (!z10 ? B10.R(view, y10, view.getTop()) : B10.P(y10, view.getTop()))) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ boolean J(int i10, View view, g.a aVar) {
        setState(i10);
        return true;
    }

    public final /* synthetic */ void K(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, View view, ValueAnimator valueAnimator) {
        this.f23660a.o(marginLayoutParams, C1001b.c(i10, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    public final /* synthetic */ void L(int i10) {
        V v10 = this.f23677r.get();
        if (v10 != null) {
            startSettling(v10, i10, false);
        }
    }

    public final void M(CoordinatorLayout coordinatorLayout) {
        int i10;
        View findViewById;
        if (this.f23678x == null && (i10 = this.f23679y) != -1 && (findViewById = coordinatorLayout.findViewById(i10)) != null) {
            this.f23678x = new WeakReference<>(findViewById);
        }
    }

    public final void N() {
        VelocityTracker velocityTracker = this.f23680z;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f23680z = null;
        }
    }

    public void O(int i10) {
        this.f23679y = i10;
        p();
        WeakReference<V> weakReference = this.f23677r;
        if (weakReference != null) {
            V v10 = weakReference.get();
            if (i10 != -1 && K.O(v10)) {
                v10.requestLayout();
            }
        }
    }

    public final void P(int i10) {
        d dVar = this.f23660a;
        if (dVar != null && dVar.j() == i10) {
            return;
        }
        if (i10 == 0) {
            this.f23660a = new y4.b(this);
            if (this.f23664e != null && !E()) {
                n.b v10 = this.f23664e.v();
                v10.M(0.0f).B(0.0f);
                T(v10.m());
                return;
            }
            return;
        }
        if (i10 == 1) {
            this.f23660a = new C1705a(this);
            if (this.f23664e != null && !D()) {
                n.b v11 = this.f23664e.v();
                v11.H(0.0f).w(0.0f);
                T(v11.m());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid sheet edge position value: " + i10 + ". Must be 0 or 1.");
    }

    public final void Q(V v10, int i10) {
        int i11;
        if (C0455j.b(((CoordinatorLayout.e) v10.getLayoutParams()).f9318c, i10) == 3) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        P(i11);
    }

    public final boolean R(V v10) {
        if ((v10.isShown() || K.l(v10) != null) && this.f23667h) {
            return true;
        }
        return false;
    }

    public final void S() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        WeakReference<V> weakReference = this.f23677r;
        if (weakReference != null && weakReference.get() != null) {
            V v10 = this.f23677r.get();
            View u10 = u();
            if (u10 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) u10.getLayoutParams()) == null) {
                return;
            }
            this.f23660a.o(marginLayoutParams, (int) ((this.f23673n * v10.getScaleX()) + this.f23676q));
            u10.requestLayout();
        }
    }

    public final void T(n nVar) {
        i iVar = this.f23662c;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
    }

    public final void U(View view) {
        int i10;
        if (this.f23668i == 5) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        if (view.getVisibility() != i10) {
            view.setVisibility(i10);
        }
    }

    @Override // s4.InterfaceC1543b
    public void cancelBackProgress() {
        C1549h c1549h = this.f23656A;
        if (c1549h == null) {
            return;
        }
        c1549h.f();
    }

    public final g createAccessibilityViewCommandForState(final int i10) {
        return new g() { // from class: y4.g
            @Override // J.g
            public final boolean perform(View view, g.a aVar) {
                boolean J10;
                J10 = SideSheetBehavior.this.J(i10, view, aVar);
                return J10;
            }
        };
    }

    public final void createMaterialShapeDrawableIfNeeded(Context context) {
        if (this.f23664e == null) {
            return;
        }
        i iVar = new i(this.f23664e);
        this.f23662c = iVar;
        iVar.initializeElevationOverlay(context);
        ColorStateList colorStateList = this.f23663d;
        if (colorStateList != null) {
            this.f23662c.setFillColor(colorStateList);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
        this.f23662c.setTint(typedValue.data);
    }

    public final int getChildMeasureSpec(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode != 1073741824) {
            if (size != 0) {
                i12 = Math.min(size, i12);
            }
            return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
    }

    public int getExpandedOffset() {
        return this.f23660a.d();
    }

    public float getHideFriction() {
        return this.f23672m;
    }

    public int getSignificantVelocityThreshold() {
        return 500;
    }

    @Override // s4.InterfaceC1543b
    public void handleBackInvoked() {
        C1549h c1549h = this.f23656A;
        if (c1549h == null) {
            return;
        }
        androidx.activity.b c10 = c1549h.c();
        if (c10 != null) {
            this.f23656A.h(c10, v(), new b(), t());
        } else {
            setState(5);
        }
    }

    public final int m(int i10, V v10) {
        int i11 = this.f23668i;
        if (i11 != 1 && i11 != 2) {
            if (i11 != 3) {
                if (i11 == 5) {
                    return this.f23660a.e();
                }
                throw new IllegalStateException("Unexpected value: " + this.f23668i);
            }
            return 0;
        }
        return i10 - this.f23660a.h(v10);
    }

    public final float n(float f10, float f11) {
        return Math.abs(f10 - f11);
    }

    public final int o(View view, float f10, float f11) {
        if (G(f10)) {
            return 3;
        }
        if (shouldHide(view, f10)) {
            if (!this.f23660a.m(f10, f11) && !this.f23660a.l(view)) {
                return 3;
            }
        } else if (f10 == 0.0f || !e.a(f10, f11)) {
            int left = view.getLeft();
            if (Math.abs(left - getExpandedOffset()) < Math.abs(left - this.f23660a.e())) {
                return 3;
            }
        }
        return 5;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
        super.onAttachedToLayoutParams(eVar);
        this.f23677r = null;
        this.f23670k = null;
        this.f23656A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f23677r = null;
        this.f23670k = null;
        this.f23656A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        androidx.customview.widget.c cVar;
        if (!R(v10)) {
            this.f23671l = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            N();
        }
        if (this.f23680z == null) {
            this.f23680z = VelocityTracker.obtain();
        }
        this.f23680z.addMovement(motionEvent);
        if (actionMasked != 0) {
            if ((actionMasked == 1 || actionMasked == 3) && this.f23671l) {
                this.f23671l = false;
                return false;
            }
        } else {
            this.f23657B = (int) motionEvent.getX();
        }
        if (!this.f23671l && (cVar = this.f23670k) != null && cVar.Q(motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        int i11;
        if (K.s(coordinatorLayout) && !K.s(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.f23677r == null) {
            this.f23677r = new WeakReference<>(v10);
            this.f23656A = new C1549h(v10);
            i iVar = this.f23662c;
            if (iVar != null) {
                K.n0(v10, iVar);
                i iVar2 = this.f23662c;
                float f10 = this.f23666g;
                if (f10 == -1.0f) {
                    f10 = K.r(v10);
                }
                iVar2.setElevation(f10);
            } else {
                ColorStateList colorStateList = this.f23663d;
                if (colorStateList != null) {
                    K.o0(v10, colorStateList);
                }
            }
            U(v10);
            updateAccessibilityActions();
            if (K.t(v10) == 0) {
                K.t0(v10, 1);
            }
            r(v10);
        }
        Q(v10, i10);
        if (this.f23670k == null) {
            this.f23670k = androidx.customview.widget.c.p(coordinatorLayout, this.f23659D);
        }
        int h10 = this.f23660a.h(v10);
        coordinatorLayout.G(v10, i10);
        this.f23674o = coordinatorLayout.getWidth();
        this.f23675p = this.f23660a.i(coordinatorLayout);
        this.f23673n = v10.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        if (marginLayoutParams != null) {
            i11 = this.f23660a.a(marginLayoutParams);
        } else {
            i11 = 0;
        }
        this.f23676q = i11;
        K.T(v10, m(h10, v10));
        M(coordinatorLayout);
        for (j jVar : this.f23658C) {
            if (jVar instanceof j) {
                jVar.c(v10);
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(getChildMeasureSpec(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, -1, marginLayoutParams.width), getChildMeasureSpec(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, -1, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v10, savedState.getSuperState());
        }
        int i10 = savedState.f23681a;
        if (i10 == 1 || i10 == 2) {
            i10 = 5;
        }
        this.f23668i = i10;
        this.f23669j = i10;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v10), (SideSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f23668i == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.f23670k.G(motionEvent);
        }
        if (actionMasked == 0) {
            N();
        }
        if (this.f23680z == null) {
            this.f23680z = VelocityTracker.obtain();
        }
        this.f23680z.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.f23671l && F(motionEvent)) {
            this.f23670k.c(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f23671l;
    }

    public final void p() {
        WeakReference<View> weakReference = this.f23678x;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f23678x = null;
    }

    public final void q(View view, int i10) {
        if (!this.f23658C.isEmpty()) {
            float b10 = this.f23660a.b(i10);
            Iterator<j> it = this.f23658C.iterator();
            while (it.hasNext()) {
                it.next().b(view, b10);
            }
        }
    }

    public final void r(View view) {
        if (K.l(view) == null) {
            K.m0(view, view.getResources().getString(f23654E));
        }
    }

    public final void replaceAccessibilityActionForState(V v10, d.a aVar, int i10) {
        K.e0(v10, aVar, null, createAccessibilityViewCommandForState(i10));
    }

    public final void runAfterLayout(V v10, Runnable runnable) {
        if (H(v10)) {
            v10.post(runnable);
        } else {
            runnable.run();
        }
    }

    public int s() {
        return this.f23673n;
    }

    public void setDraggable(boolean z10) {
        this.f23667h = z10;
    }

    public void setState(final int i10) {
        String str;
        if (i10 != 1 && i10 != 2) {
            WeakReference<V> weakReference = this.f23677r;
            if (weakReference != null && weakReference.get() != null) {
                runAfterLayout(this.f23677r.get(), new Runnable() { // from class: y4.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        SideSheetBehavior.this.L(i10);
                    }
                });
                return;
            } else {
                setStateInternal(i10);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("STATE_");
        if (i10 == 1) {
            str = "DRAGGING";
        } else {
            str = "SETTLING";
        }
        sb.append(str);
        sb.append(" should not be set externally.");
        throw new IllegalArgumentException(sb.toString());
    }

    public void setStateInternal(int i10) {
        V v10;
        if (this.f23668i == i10) {
            return;
        }
        this.f23668i = i10;
        if (i10 == 3 || i10 == 5) {
            this.f23669j = i10;
        }
        WeakReference<V> weakReference = this.f23677r;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        U(v10);
        Iterator<j> it = this.f23658C.iterator();
        while (it.hasNext()) {
            it.next().a(v10, i10);
        }
        updateAccessibilityActions();
    }

    public final boolean shouldHandleDraggingWithHelper() {
        if (this.f23670k != null && (this.f23667h || this.f23668i == 1)) {
            return true;
        }
        return false;
    }

    public boolean shouldHide(View view, float f10) {
        return this.f23660a.n(view, f10);
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    @Override // s4.InterfaceC1543b
    public void startBackProgress(androidx.activity.b bVar) {
        C1549h c1549h = this.f23656A;
        if (c1549h == null) {
            return;
        }
        c1549h.j(bVar);
    }

    public final void startSettling(View view, int i10, boolean z10) {
        if (I(view, i10, z10)) {
            setStateInternal(2);
            this.f23665f.b(i10);
        } else {
            setStateInternal(i10);
        }
    }

    public final ValueAnimator.AnimatorUpdateListener t() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        final View u10 = u();
        if (u10 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) u10.getLayoutParams()) == null) {
            return null;
        }
        final int c10 = this.f23660a.c(marginLayoutParams);
        return new ValueAnimator.AnimatorUpdateListener() { // from class: y4.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SideSheetBehavior.this.K(marginLayoutParams, c10, u10, valueAnimator);
            }
        };
    }

    public View u() {
        WeakReference<View> weakReference = this.f23678x;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void updateAccessibilityActions() {
        V v10;
        WeakReference<V> weakReference = this.f23677r;
        if (weakReference == null || (v10 = weakReference.get()) == null) {
            return;
        }
        K.c0(v10, 262144);
        K.c0(v10, OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS);
        if (this.f23668i != 5) {
            replaceAccessibilityActionForState(v10, d.a.f1410y, 5);
        }
        if (this.f23668i != 3) {
            replaceAccessibilityActionForState(v10, d.a.f1408w, 3);
        }
    }

    @Override // s4.InterfaceC1543b
    public void updateBackProgress(androidx.activity.b bVar) {
        C1549h c1549h = this.f23656A;
        if (c1549h == null) {
            return;
        }
        c1549h.l(bVar, v());
        S();
    }

    public final int v() {
        y4.d dVar = this.f23660a;
        if (dVar == null || dVar.j() == 0) {
            return 5;
        }
        return 3;
    }

    public float w() {
        return 0.5f;
    }

    public int x() {
        return this.f23676q;
    }

    public int y(int i10) {
        if (i10 != 3) {
            if (i10 == 5) {
                return this.f23660a.e();
            }
            throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i10);
        }
        return getExpandedOffset();
    }

    public int z() {
        return this.f23675p;
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f23681a;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f23681a = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f23681a);
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.f23681a = sideSheetBehavior.f23668i;
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23665f = new c();
        this.f23667h = true;
        this.f23668i = 5;
        this.f23669j = 5;
        this.f23672m = 0.1f;
        this.f23679y = -1;
        this.f23658C = new LinkedHashSet();
        this.f23659D = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f31470m9);
        int i10 = m.f31492o9;
        if (obtainStyledAttributes.hasValue(i10)) {
            this.f23663d = C1607c.a(context, obtainStyledAttributes, i10);
        }
        if (obtainStyledAttributes.hasValue(m.f31525r9)) {
            this.f23664e = n.e(context, attributeSet, 0, f23655F).m();
        }
        int i11 = m.f31514q9;
        if (obtainStyledAttributes.hasValue(i11)) {
            O(obtainStyledAttributes.getResourceId(i11, -1));
        }
        createMaterialShapeDrawableIfNeeded(context);
        this.f23666g = obtainStyledAttributes.getDimension(m.f31481n9, -1.0f);
        setDraggable(obtainStyledAttributes.getBoolean(m.f31503p9, true));
        obtainStyledAttributes.recycle();
        this.f23661b = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
