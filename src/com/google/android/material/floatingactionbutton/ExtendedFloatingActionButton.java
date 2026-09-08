package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import e4.C0976b;
import e4.C0977c;
import f4.C1008i;
import java.util.Iterator;
import java.util.List;
import q4.AbstractC1486b;
import q4.C1485a;

/* loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {

    /* renamed from: N, reason: collision with root package name */
    public static final int f23298N = e4.l.f31006H;

    /* renamed from: O, reason: collision with root package name */
    public static final Property<View, Float> f23299O = new f(Float.class, "width");

    /* renamed from: P, reason: collision with root package name */
    public static final Property<View, Float> f23300P = new g(Float.class, "height");

    /* renamed from: Q, reason: collision with root package name */
    public static final Property<View, Float> f23301Q = new h(Float.class, "paddingStart");

    /* renamed from: R, reason: collision with root package name */
    public static final Property<View, Float> f23302R = new i(Float.class, "paddingEnd");

    /* renamed from: A, reason: collision with root package name */
    public final com.google.android.material.floatingactionbutton.b f23303A;

    /* renamed from: B, reason: collision with root package name */
    public final com.google.android.material.floatingactionbutton.b f23304B;

    /* renamed from: C, reason: collision with root package name */
    public final int f23305C;

    /* renamed from: D, reason: collision with root package name */
    public int f23306D;

    /* renamed from: E, reason: collision with root package name */
    public int f23307E;

    /* renamed from: F, reason: collision with root package name */
    public final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> f23308F;

    /* renamed from: G, reason: collision with root package name */
    public boolean f23309G;

    /* renamed from: H, reason: collision with root package name */
    public boolean f23310H;

    /* renamed from: I, reason: collision with root package name */
    public boolean f23311I;

    /* renamed from: J, reason: collision with root package name */
    public ColorStateList f23312J;

    /* renamed from: K, reason: collision with root package name */
    public int f23313K;

    /* renamed from: L, reason: collision with root package name */
    public int f23314L;

    /* renamed from: M, reason: collision with root package name */
    public final int f23315M;

    /* renamed from: r, reason: collision with root package name */
    public int f23316r;

    /* renamed from: x, reason: collision with root package name */
    public final C1485a f23317x;

    /* renamed from: y, reason: collision with root package name */
    public final com.google.android.material.floatingactionbutton.b f23318y;

    /* renamed from: z, reason: collision with root package name */
    public final com.google.android.material.floatingactionbutton.b f23319z;

    /* loaded from: classes3.dex */
    public class a implements n {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int b() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams c() {
            return new ViewGroup.LayoutParams(a(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int d() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements n {
        public b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.f23306D + ExtendedFloatingActionButton.this.f23307E;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int b() {
            return ExtendedFloatingActionButton.this.f23307E;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams c() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int d() {
            return ExtendedFloatingActionButton.this.f23306D;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f23325a;

        public c(n nVar) {
            this.f23325a = nVar;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            int i10;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.f23325a.a();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && layoutParams.width == -2) {
                return this.f23325a.a();
            }
            int paddingLeft = view.getPaddingLeft() + view.getPaddingRight();
            if ((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) != null) {
                i10 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            } else {
                i10 = 0;
            }
            return (view.getWidth() - i10) - paddingLeft;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int b() {
            return ExtendedFloatingActionButton.this.f23307E;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams c() {
            int i10;
            if (ExtendedFloatingActionButton.this.f23314L != 0) {
                i10 = ExtendedFloatingActionButton.this.f23314L;
            } else {
                i10 = -2;
            }
            return new ViewGroup.LayoutParams(-1, i10);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int d() {
            return ExtendedFloatingActionButton.this.f23306D;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            int i10;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (ExtendedFloatingActionButton.this.f23314L == -1) {
                if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                    return this.f23325a.getHeight();
                }
                View view = (View) ExtendedFloatingActionButton.this.getParent();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null && layoutParams.height == -2) {
                    return this.f23325a.getHeight();
                }
                int paddingTop = view.getPaddingTop() + view.getPaddingBottom();
                if ((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) != null) {
                    i10 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                } else {
                    i10 = 0;
                }
                return (view.getHeight() - i10) - paddingTop;
            }
            if (ExtendedFloatingActionButton.this.f23314L != 0 && ExtendedFloatingActionButton.this.f23314L != -2) {
                return ExtendedFloatingActionButton.this.f23314L;
            }
            return this.f23325a.getHeight();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f23327a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ n f23328b;

        public d(n nVar, n nVar2) {
            this.f23327a = nVar;
            this.f23328b = nVar2;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int a() {
            if (ExtendedFloatingActionButton.this.f23313K == -1) {
                return this.f23327a.a();
            }
            if (ExtendedFloatingActionButton.this.f23313K != 0 && ExtendedFloatingActionButton.this.f23313K != -2) {
                return ExtendedFloatingActionButton.this.f23313K;
            }
            return this.f23328b.a();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int b() {
            return ExtendedFloatingActionButton.this.f23307E;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public ViewGroup.LayoutParams c() {
            int i10;
            int i11 = -2;
            if (ExtendedFloatingActionButton.this.f23313K != 0) {
                i10 = ExtendedFloatingActionButton.this.f23313K;
            } else {
                i10 = -2;
            }
            if (ExtendedFloatingActionButton.this.f23314L != 0) {
                i11 = ExtendedFloatingActionButton.this.f23314L;
            }
            return new ViewGroup.LayoutParams(i10, i11);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int d() {
            return ExtendedFloatingActionButton.this.f23306D;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.n
        public int getHeight() {
            if (ExtendedFloatingActionButton.this.f23314L == -1) {
                return this.f23327a.getHeight();
            }
            if (ExtendedFloatingActionButton.this.f23314L != 0 && ExtendedFloatingActionButton.this.f23314L != -2) {
                return ExtendedFloatingActionButton.this.f23314L;
            }
            return this.f23328b.getHeight();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f23330a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.floatingactionbutton.b f23331b;

        public e(com.google.android.material.floatingactionbutton.b bVar, l lVar) {
            this.f23331b = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f23330a = true;
            this.f23331b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f23331b.onAnimationEnd();
            if (!this.f23330a) {
                this.f23331b.i(null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f23331b.onAnimationStart(animator);
            this.f23330a = false;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends Property<View, Float> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends Property<View, Float> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends Property<View, Float> {
        public h(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(K.A(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            K.A0(view, f10.intValue(), view.getPaddingTop(), K.z(view), view.getPaddingBottom());
        }
    }

    /* loaded from: classes3.dex */
    public class i extends Property<View, Float> {
        public i(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(K.z(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            K.A0(view, K.A(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class l {
    }

    /* loaded from: classes3.dex */
    public interface n {
        int a();

        int b();

        ViewGroup.LayoutParams c();

        int d();

        int getHeight();
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0977c.f30628C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x() {
        if (getVisibility() == 0) {
            if (this.f23316r != 1) {
                return false;
            }
            return true;
        }
        if (this.f23316r == 2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        if (getVisibility() != 0) {
            if (this.f23316r != 2) {
                return false;
            }
            return true;
        }
        if (this.f23316r == 1) {
            return false;
        }
        return true;
    }

    public final void A() {
        this.f23312J = getTextColors();
    }

    public final boolean B() {
        if ((K.O(this) || (!y() && this.f23311I)) && !isInEditMode()) {
            return true;
        }
        return false;
    }

    public void C(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.f23308F;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i10 = this.f23305C;
        if (i10 < 0) {
            return (Math.min(K.A(this), K.z(this)) * 2) + getIconSize();
        }
        return i10;
    }

    public C1008i getExtendMotionSpec() {
        return this.f23319z.d();
    }

    public C1008i getHideMotionSpec() {
        return this.f23304B.d();
    }

    public C1008i getShowMotionSpec() {
        return this.f23303A.d();
    }

    public C1008i getShrinkMotionSpec() {
        return this.f23318y.d();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f23309G && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f23309G = false;
            this.f23318y.c();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.f23311I = z10;
    }

    public void setExtendMotionSpec(C1008i c1008i) {
        this.f23319z.f(c1008i);
    }

    public void setExtendMotionSpecResource(int i10) {
        setExtendMotionSpec(C1008i.d(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        com.google.android.material.floatingactionbutton.b bVar;
        if (this.f23309G == z10) {
            return;
        }
        if (z10) {
            bVar = this.f23319z;
        } else {
            bVar = this.f23318y;
        }
        if (bVar.e()) {
            return;
        }
        bVar.c();
    }

    public void setHideMotionSpec(C1008i c1008i) {
        this.f23304B.f(c1008i);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(C1008i.d(getContext(), i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (this.f23309G && !this.f23310H) {
            this.f23306D = K.A(this);
            this.f23307E = K.z(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        if (this.f23309G && !this.f23310H) {
            this.f23306D = i10;
            this.f23307E = i12;
        }
    }

    public void setShowMotionSpec(C1008i c1008i) {
        this.f23303A.f(c1008i);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(C1008i.d(getContext(), i10));
    }

    public void setShrinkMotionSpec(C1008i c1008i) {
        this.f23318y.f(c1008i);
    }

    public void setShrinkMotionSpecResource(int i10) {
        setShrinkMotionSpec(C1008i.d(getContext(), i10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        A();
    }

    public final n w(int i10) {
        b bVar = new b();
        c cVar = new c(bVar);
        d dVar = new d(cVar, bVar);
        if (i10 != 1) {
            if (i10 != 2) {
                return dVar;
            }
            return cVar;
        }
        return bVar;
    }

    public final void z(int i10, l lVar) {
        com.google.android.material.floatingactionbutton.b bVar;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        bVar = this.f23319z;
                    } else {
                        throw new IllegalStateException("Unknown strategy type: " + i10);
                    }
                } else {
                    bVar = this.f23318y;
                }
            } else {
                bVar = this.f23304B;
            }
        } else {
            bVar = this.f23303A;
        }
        if (bVar.e()) {
            return;
        }
        if (!B()) {
            bVar.c();
            bVar.i(lVar);
            return;
        }
        if (i10 == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                this.f23313K = layoutParams.width;
                this.f23314L = layoutParams.height;
            } else {
                this.f23313K = getWidth();
                this.f23314L = getHeight();
            }
        }
        measure(0, 0);
        AnimatorSet g10 = bVar.g();
        g10.addListener(new e(bVar, lVar));
        Iterator<Animator.AnimatorListener> it = bVar.h().iterator();
        while (it.hasNext()) {
            g10.addListener(it.next());
        }
        g10.start();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ExtendedFloatingActionButton(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.f23298N
            r1 = r17
            android.content.Context r1 = B4.a.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.f23316r = r10
            q4.a r1 = new q4.a
            r1.<init>()
            r0.f23317x = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$m r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$m
            r11.<init>(r1)
            r0.f23303A = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k
            r12.<init>(r1)
            r0.f23304B = r12
            r13 = 1
            r0.f23309G = r13
            r0.f23310H = r10
            r0.f23311I = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.f23308F = r1
            int[] r3 = e4.m.f31475n3
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = e4.m.f31530s3
            f4.i r2 = f4.C1008i.c(r14, r1, r2)
            int r3 = e4.m.f31519r3
            f4.i r3 = f4.C1008i.c(r14, r1, r3)
            int r4 = e4.m.f31497p3
            f4.i r4 = f4.C1008i.c(r14, r1, r4)
            int r5 = e4.m.f31541t3
            f4.i r5 = f4.C1008i.c(r14, r1, r5)
            int r6 = e4.m.f31486o3
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.f23305C = r6
            int r6 = e4.m.f31508q3
            int r6 = r1.getInt(r6, r13)
            r0.f23315M = r6
            int r15 = androidx.core.view.K.A(r16)
            r0.f23306D = r15
            int r15 = androidx.core.view.K.z(r16)
            r0.f23307E = r15
            q4.a r15 = new q4.a
            r15.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$n r6 = r0.w(r6)
            r10.<init>(r15, r6, r13)
            r0.f23319z = r10
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j r6 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            r13.<init>()
            r7 = 0
            r6.<init>(r15, r13, r7)
            r0.f23318y = r6
            r11.f(r2)
            r12.f(r3)
            r10.f(r4)
            r6.f(r5)
            r1.recycle()
            x4.d r1 = x4.n.f37922m
            r2 = r18
            x4.n$b r1 = x4.n.g(r14, r2, r8, r9, r1)
            x4.n r1 = r1.m()
            r0.setShapeAppearanceModel(r1)
            r16.A()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* loaded from: classes3.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f23320a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f23321b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f23322c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f23321b = false;
            this.f23322c = true;
        }

        public static boolean isBottomSheet(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                return ((CoordinatorLayout.e) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i10;
            if (this.f23322c) {
                i10 = 3;
            } else {
                i10 = 0;
            }
            extendedFloatingActionButton.z(i10, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                g(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (isBottomSheet(view)) {
                h(view, extendedFloatingActionButton);
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List<View> p10 = coordinatorLayout.p(extendedFloatingActionButton);
            int size = p10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = p10.get(i11);
                if (view instanceof AppBarLayout) {
                    if (g(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (isBottomSheet(view) && h(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.G(extendedFloatingActionButton, i10);
            return true;
        }

        public final boolean e(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            CoordinatorLayout.e eVar = (CoordinatorLayout.e) extendedFloatingActionButton.getLayoutParams();
            if ((!this.f23321b && !this.f23322c) || eVar.e() != view.getId()) {
                return false;
            }
            return true;
        }

        public void f(ExtendedFloatingActionButton extendedFloatingActionButton) {
            int i10;
            if (this.f23322c) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            extendedFloatingActionButton.z(i10, null);
        }

        public final boolean g(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!e(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f23320a == null) {
                this.f23320a = new Rect();
            }
            Rect rect = this.f23320a;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                f(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        public final boolean h(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!e(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.e) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                f(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
            if (eVar.f9323h == 0) {
                eVar.f9323h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e4.m.f31552u3);
            this.f23321b = obtainStyledAttributes.getBoolean(e4.m.f31563v3, false);
            this.f23322c = obtainStyledAttributes.getBoolean(e4.m.f31574w3, true);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        A();
    }

    /* loaded from: classes3.dex */
    public class j extends AbstractC1486b {

        /* renamed from: g, reason: collision with root package name */
        public final n f23333g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f23334h;

        public j(C1485a c1485a, n nVar, boolean z10) {
            super(ExtendedFloatingActionButton.this, c1485a);
            this.f23333g = nVar;
            this.f23334h = z10;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int b() {
            if (this.f23334h) {
                return C0976b.f30617b;
            }
            return C0976b.f30616a;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void c() {
            ExtendedFloatingActionButton.this.f23309G = this.f23334h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!this.f23334h) {
                ExtendedFloatingActionButton.this.f23313K = layoutParams.width;
                ExtendedFloatingActionButton.this.f23314L = layoutParams.height;
            }
            layoutParams.width = this.f23333g.c().width;
            layoutParams.height = this.f23333g.c().height;
            K.A0(ExtendedFloatingActionButton.this, this.f23333g.d(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f23333g.b(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean e() {
            if (this.f23334h != ExtendedFloatingActionButton.this.f23309G && ExtendedFloatingActionButton.this.getIcon() != null && !TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText())) {
                return false;
            }
            return true;
        }

        @Override // q4.AbstractC1486b, com.google.android.material.floatingactionbutton.b
        public AnimatorSet g() {
            float f10;
            C1008i l10 = l();
            if (l10.j("width")) {
                PropertyValuesHolder[] g10 = l10.g("width");
                g10[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f23333g.a());
                l10.l("width", g10);
            }
            if (l10.j("height")) {
                PropertyValuesHolder[] g11 = l10.g("height");
                g11[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f23333g.getHeight());
                l10.l("height", g11);
            }
            if (l10.j("paddingStart")) {
                PropertyValuesHolder[] g12 = l10.g("paddingStart");
                g12[0].setFloatValues(K.A(ExtendedFloatingActionButton.this), this.f23333g.d());
                l10.l("paddingStart", g12);
            }
            if (l10.j("paddingEnd")) {
                PropertyValuesHolder[] g13 = l10.g("paddingEnd");
                g13[0].setFloatValues(K.z(ExtendedFloatingActionButton.this), this.f23333g.b());
                l10.l("paddingEnd", g13);
            }
            if (l10.j("labelOpacity")) {
                PropertyValuesHolder[] g14 = l10.g("labelOpacity");
                boolean z10 = this.f23334h;
                float f11 = 1.0f;
                if (z10) {
                    f10 = 0.0f;
                } else {
                    f10 = 1.0f;
                }
                if (!z10) {
                    f11 = 0.0f;
                }
                g14[0].setFloatValues(f10, f11);
                l10.l("labelOpacity", g14);
            }
            return super.k(l10);
        }

        @Override // q4.AbstractC1486b, com.google.android.material.floatingactionbutton.b
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.f23310H = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f23333g.c().width;
            layoutParams.height = this.f23333g.c().height;
        }

        @Override // q4.AbstractC1486b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.f23309G = this.f23334h;
            ExtendedFloatingActionButton.this.f23310H = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void i(l lVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class k extends AbstractC1486b {

        /* renamed from: g, reason: collision with root package name */
        public boolean f23336g;

        public k(C1485a c1485a) {
            super(ExtendedFloatingActionButton.this, c1485a);
        }

        @Override // q4.AbstractC1486b, com.google.android.material.floatingactionbutton.b
        public void a() {
            super.a();
            this.f23336g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int b() {
            return C0976b.f30618c;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void c() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean e() {
            return ExtendedFloatingActionButton.this.x();
        }

        @Override // q4.AbstractC1486b, com.google.android.material.floatingactionbutton.b
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.f23316r = 0;
            if (!this.f23336g) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        @Override // q4.AbstractC1486b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f23336g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f23316r = 1;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void i(l lVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class m extends AbstractC1486b {
        public m(C1485a c1485a) {
            super(ExtendedFloatingActionButton.this, c1485a);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public int b() {
            return C0976b.f30619d;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void c() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public boolean e() {
            return ExtendedFloatingActionButton.this.y();
        }

        @Override // q4.AbstractC1486b, com.google.android.material.floatingactionbutton.b
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.this.f23316r = 0;
        }

        @Override // q4.AbstractC1486b, com.google.android.material.floatingactionbutton.b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f23316r = 2;
        }

        @Override // com.google.android.material.floatingactionbutton.b
        public void i(l lVar) {
        }
    }
}
