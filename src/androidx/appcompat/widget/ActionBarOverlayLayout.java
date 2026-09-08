package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.C0469y;
import androidx.core.view.InterfaceC0467w;
import androidx.core.view.InterfaceC0468x;
import androidx.core.view.X;
import e.C0961a;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0444s, InterfaceC0467w, InterfaceC0468x {

    /* renamed from: L, reason: collision with root package name */
    public static final int[] f7489L = {C0961a.f30103b, R.attr.windowContentOverlay};

    /* renamed from: M, reason: collision with root package name */
    public static final X f7490M = new X.a().c(B.b.b(0, 1, 0, 1)).a();

    /* renamed from: N, reason: collision with root package name */
    public static final Rect f7491N = new Rect();

    /* renamed from: A, reason: collision with root package name */
    public X f7492A;

    /* renamed from: B, reason: collision with root package name */
    public X f7493B;

    /* renamed from: C, reason: collision with root package name */
    public X f7494C;

    /* renamed from: D, reason: collision with root package name */
    public d f7495D;

    /* renamed from: E, reason: collision with root package name */
    public OverScroller f7496E;

    /* renamed from: F, reason: collision with root package name */
    public ViewPropertyAnimator f7497F;

    /* renamed from: G, reason: collision with root package name */
    public final AnimatorListenerAdapter f7498G;

    /* renamed from: H, reason: collision with root package name */
    public final Runnable f7499H;

    /* renamed from: I, reason: collision with root package name */
    public final Runnable f7500I;

    /* renamed from: J, reason: collision with root package name */
    public final C0469y f7501J;

    /* renamed from: K, reason: collision with root package name */
    public final e f7502K;

    /* renamed from: a, reason: collision with root package name */
    public int f7503a;

    /* renamed from: b, reason: collision with root package name */
    public int f7504b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f7505c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f7506d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0445t f7507e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f7508f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7509g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7510h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7511i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7512j;

    /* renamed from: k, reason: collision with root package name */
    public int f7513k;

    /* renamed from: l, reason: collision with root package name */
    public int f7514l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f7515m;

    /* renamed from: n, reason: collision with root package name */
    public final Rect f7516n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f7517o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f7518p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f7519q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f7520r;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f7521x;

    /* renamed from: y, reason: collision with root package name */
    public final Rect f7522y;

    /* renamed from: z, reason: collision with root package name */
    public X f7523z;

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f7497F = null;
            actionBarOverlayLayout.f7512j = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f7497F = null;
            actionBarOverlayLayout.f7512j = false;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.p();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f7497F = actionBarOverlayLayout.f7506d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f7498G);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.p();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f7497F = actionBarOverlayLayout.f7506d.animate().translationY(-ActionBarOverlayLayout.this.f7506d.getHeight()).setListener(ActionBarOverlayLayout.this.f7498G);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();

        void c(boolean z10);

        void d();

        void e();

        void f(int i10);
    }

    /* loaded from: classes.dex */
    public static final class e extends View {
        public e(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        @Override // android.view.View
        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7504b = 0;
        this.f7515m = new Rect();
        this.f7516n = new Rect();
        this.f7517o = new Rect();
        this.f7518p = new Rect();
        this.f7519q = new Rect();
        this.f7520r = new Rect();
        this.f7521x = new Rect();
        this.f7522y = new Rect();
        X x10 = X.f9471b;
        this.f7523z = x10;
        this.f7492A = x10;
        this.f7493B = x10;
        this.f7494C = x10;
        this.f7498G = new a();
        this.f7499H = new b();
        this.f7500I = new c();
        q(context);
        this.f7501J = new C0469y(this);
        e eVar = new e(context);
        this.f7502K = eVar;
        addView(eVar);
    }

    private void q(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f7489L);
        boolean z10 = false;
        this.f7503a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f7508f = drawable;
        if (drawable == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        obtainStyledAttributes.recycle();
        this.f7496E = new OverScroller(context);
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public void a(Menu menu, MenuPresenter.Callback callback) {
        u();
        this.f7507e.a(menu, callback);
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public boolean b() {
        u();
        return this.f7507e.b();
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public void c() {
        u();
        this.f7507e.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public boolean d() {
        u();
        return this.f7507e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        if (this.f7508f != null) {
            if (this.f7506d.getVisibility() == 0) {
                i10 = (int) (this.f7506d.getBottom() + this.f7506d.getTranslationY() + 0.5f);
            } else {
                i10 = 0;
            }
            this.f7508f.setBounds(0, i10, getWidth(), this.f7508f.getIntrinsicHeight() + i10);
            this.f7508f.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public boolean e() {
        u();
        return this.f7507e.e();
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public boolean f() {
        u();
        return this.f7507e.f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public boolean g() {
        u();
        return this.f7507e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f7506d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f7501J.a();
    }

    public CharSequence getTitle() {
        u();
        return this.f7507e.getTitle();
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public void h(int i10) {
        u();
        if (i10 != 2) {
            if (i10 != 5) {
                if (i10 == 109) {
                    setOverlayMode(true);
                    return;
                }
                return;
            }
            this.f7507e.u();
            return;
        }
        this.f7507e.t();
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public void i() {
        u();
        this.f7507e.h();
    }

    public final void j() {
        p();
        this.f7500I.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(android.view.View r2, android.graphics.Rect r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        /*
            r1 = this;
            android.view.ViewGroup$LayoutParams r1 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r1 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r1
            r2 = 1
            if (r4 == 0) goto L13
            int r4 = r1.leftMargin
            int r0 = r3.left
            if (r4 == r0) goto L13
            r1.leftMargin = r0
            r4 = r2
            goto L14
        L13:
            r4 = 0
        L14:
            if (r5 == 0) goto L1f
            int r5 = r1.topMargin
            int r0 = r3.top
            if (r5 == r0) goto L1f
            r1.topMargin = r0
            r4 = r2
        L1f:
            if (r7 == 0) goto L2a
            int r5 = r1.rightMargin
            int r7 = r3.right
            if (r5 == r7) goto L2a
            r1.rightMargin = r7
            r4 = r2
        L2a:
            if (r6 == 0) goto L35
            int r5 = r1.bottomMargin
            int r3 = r3.bottom
            if (r5 == r3) goto L35
            r1.bottomMargin = r3
            goto L36
        L35:
            r2 = r4
        L36:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.k(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    public final boolean l() {
        androidx.core.view.K.e(this.f7502K, f7490M, this.f7518p);
        return !this.f7518p.equals(f7491N);
    }

    @Override // android.view.ViewGroup
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InterfaceC0445t o(View view) {
        if (view instanceof InterfaceC0445t) {
            return (InterfaceC0445t) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005b, code lost:
    
        if (r0 != false) goto L9;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.WindowInsets onApplyWindowInsets(android.view.WindowInsets r8) {
        /*
            r7 = this;
            r7.u()
            androidx.core.view.X r8 = androidx.core.view.X.y(r8, r7)
            android.graphics.Rect r2 = new android.graphics.Rect
            int r0 = r8.k()
            int r1 = r8.m()
            int r3 = r8.l()
            int r4 = r8.j()
            r2.<init>(r0, r1, r3, r4)
            androidx.appcompat.widget.ActionBarContainer r1 = r7.f7506d
            r5 = 0
            r6 = 1
            r3 = 1
            r4 = 1
            r0 = r7
            boolean r0 = r0.k(r1, r2, r3, r4, r5, r6)
            android.graphics.Rect r1 = r7.f7515m
            androidx.core.view.K.e(r7, r8, r1)
            android.graphics.Rect r1 = r7.f7515m
            int r2 = r1.left
            int r3 = r1.top
            int r4 = r1.right
            int r1 = r1.bottom
            androidx.core.view.X r1 = r8.o(r2, r3, r4, r1)
            r7.f7523z = r1
            androidx.core.view.X r2 = r7.f7492A
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L49
            androidx.core.view.X r0 = r7.f7523z
            r7.f7492A = r0
            r0 = 1
        L49:
            android.graphics.Rect r1 = r7.f7516n
            android.graphics.Rect r2 = r7.f7515m
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L5b
            android.graphics.Rect r0 = r7.f7516n
            android.graphics.Rect r1 = r7.f7515m
            r0.set(r1)
            goto L5d
        L5b:
            if (r0 == 0) goto L60
        L5d:
            r7.requestLayout()
        L60:
            androidx.core.view.X r7 = r8.a()
            androidx.core.view.X r7 = r7.c()
            androidx.core.view.X r7 = r7.b()
            android.view.WindowInsets r7 = r7.w()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onApplyWindowInsets(android.view.WindowInsets):android.view.WindowInsets");
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        q(getContext());
        androidx.core.view.K.f0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        boolean z10;
        int measuredHeight;
        u();
        measureChildWithMargins(this.f7506d, i10, 0, i11, 0);
        LayoutParams layoutParams = (LayoutParams) this.f7506d.getLayoutParams();
        int max = Math.max(0, this.f7506d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.f7506d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f7506d.getMeasuredState());
        if ((androidx.core.view.K.H(this) & 256) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            measuredHeight = this.f7503a;
            if (this.f7510h && this.f7506d.getTabContainer() != null) {
                measuredHeight += this.f7503a;
            }
        } else {
            measuredHeight = this.f7506d.getVisibility() != 8 ? this.f7506d.getMeasuredHeight() : 0;
        }
        this.f7517o.set(this.f7515m);
        this.f7493B = this.f7523z;
        if (!this.f7509g && !z10 && l()) {
            Rect rect = this.f7517o;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f7493B = this.f7493B.o(0, measuredHeight, 0, 0);
        } else {
            this.f7493B = new X.a(this.f7493B).c(B.b.b(this.f7493B.k(), this.f7493B.m() + measuredHeight, this.f7493B.l(), this.f7493B.j())).a();
        }
        k(this.f7505c, this.f7517o, true, true, true, true);
        if (!this.f7494C.equals(this.f7493B)) {
            X x10 = this.f7493B;
            this.f7494C = x10;
            androidx.core.view.K.f(this.f7505c, x10);
        }
        measureChildWithMargins(this.f7505c, i10, 0, i11, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f7505c.getLayoutParams();
        int max3 = Math.max(max, this.f7505c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.f7505c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f7505c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (this.f7511i && z10) {
            if (w(f11)) {
                j();
            } else {
                v();
            }
            this.f7512j = true;
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // androidx.core.view.InterfaceC0468x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        onNestedScroll(view, i10, i11, i12, i13, i14);
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // androidx.core.view.InterfaceC0467w
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onStopNestedScroll(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        boolean z10;
        super.onWindowSystemUiVisibilityChanged(i10);
        u();
        int i11 = this.f7514l ^ i10;
        this.f7514l = i10;
        boolean z11 = false;
        if ((i10 & 4) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((i10 & 256) != 0) {
            z11 = true;
        }
        d dVar = this.f7495D;
        if (dVar != null) {
            dVar.c(!z11);
            if (!z10 && z11) {
                this.f7495D.d();
            } else {
                this.f7495D.a();
            }
        }
        if ((i11 & 256) != 0 && this.f7495D != null) {
            androidx.core.view.K.f0(this);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f7504b = i10;
        d dVar = this.f7495D;
        if (dVar != null) {
            dVar.f(i10);
        }
    }

    public void p() {
        removeCallbacks(this.f7499H);
        removeCallbacks(this.f7500I);
        ViewPropertyAnimator viewPropertyAnimator = this.f7497F;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean r() {
        return this.f7509g;
    }

    public final void s() {
        p();
        postDelayed(this.f7500I, 600L);
    }

    public void setActionBarHideOffset(int i10) {
        p();
        this.f7506d.setTranslationY(-Math.max(0, Math.min(i10, this.f7506d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f7495D = dVar;
        if (getWindowToken() != null) {
            this.f7495D.f(this.f7504b);
            int i10 = this.f7514l;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                androidx.core.view.K.f0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f7510h = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f7511i) {
            this.f7511i = z10;
            if (!z10) {
                p();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i10) {
        u();
        this.f7507e.setIcon(i10);
    }

    public void setLogo(int i10) {
        u();
        this.f7507e.m(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f7509g = z10;
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public void setWindowCallback(Window.Callback callback) {
        u();
        this.f7507e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.InterfaceC0444s
    public void setWindowTitle(CharSequence charSequence) {
        u();
        this.f7507e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t() {
        p();
        postDelayed(this.f7499H, 600L);
    }

    public void u() {
        if (this.f7505c == null) {
            this.f7505c = (ContentFrameLayout) findViewById(e.f.f30215b);
            this.f7506d = (ActionBarContainer) findViewById(e.f.f30216c);
            this.f7507e = o(findViewById(e.f.f30214a));
        }
    }

    public final void v() {
        p();
        this.f7499H.run();
    }

    public final boolean w(float f10) {
        this.f7496E.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f7496E.getFinalY() > this.f7506d.getHeight()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // androidx.core.view.InterfaceC0467w
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f7501J.b(view, view2, i10);
        this.f7513k = getActionBarHideOffset();
        p();
        d dVar = this.f7495D;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f7506d.getVisibility() != 0) {
            return false;
        }
        return this.f7511i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f7511i && !this.f7512j) {
            if (this.f7513k <= this.f7506d.getHeight()) {
                t();
            } else {
                s();
            }
        }
        d dVar = this.f7495D;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f7513k + i11;
        this.f7513k = i14;
        setActionBarHideOffset(i14);
    }

    public void setIcon(Drawable drawable) {
        u();
        this.f7507e.setIcon(drawable);
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }
}
