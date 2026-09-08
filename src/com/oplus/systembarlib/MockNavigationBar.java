package com.oplus.systembarlib;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import androidx.core.view.X;
import androidx.core.view.z;
import v9.InterfaceC1637a;

/* compiled from: MockNavigationBar.kt */
/* loaded from: classes3.dex */
public final class MockNavigationBar extends View {

    /* renamed from: d, reason: collision with root package name */
    public static final a f28994d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f28995a;

    /* renamed from: b, reason: collision with root package name */
    public final m9.d f28996b;

    /* renamed from: c, reason: collision with root package name */
    public final m9.d f28997c;

    /* compiled from: MockNavigationBar.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: MockNavigationBar.kt */
    /* loaded from: classes3.dex */
    public static final class b implements ViewGroup.OnHierarchyChangeListener {
        public b() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            MockNavigationBar.this.bringToFront();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            MockNavigationBar.this.bringToFront();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MockNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public static final X f(MockNavigationBar this$0, View view, X x10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.g(x10);
        return K.V(view, x10);
    }

    private final Interpolator getColorAnimInterpolator() {
        return (Interpolator) this.f28997c.getValue();
    }

    private final Paint getDebugPaint() {
        return (Paint) this.f28996b.getValue();
    }

    public static /* synthetic */ void h(MockNavigationBar mockNavigationBar, X x10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            x10 = K.C(mockNavigationBar);
        }
        mockNavigationBar.g(x10);
    }

    public static final void i(MockNavigationBar this$0, int i10, int i11, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            this$0.setBackgroundColor(B.a.i(i10, i11, ((Float) animatedValue).floatValue()));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    public final int c(B.b naviInsets) {
        kotlin.jvm.internal.i.f(naviInsets, "naviInsets");
        if (naviInsets.f207a > 0) {
            return 3;
        }
        if (naviInsets.f208b > 0) {
            return 48;
        }
        if (naviInsets.f209c > 0) {
            return 5;
        }
        return 80;
    }

    public final int d(B.b naviInsets) {
        kotlin.jvm.internal.i.f(naviInsets, "naviInsets");
        if (naviInsets.f207a > 0) {
            return 9;
        }
        if (naviInsets.f208b > 0) {
            return 10;
        }
        if (naviInsets.f209c > 0) {
            return 11;
        }
        return 12;
    }

    public final boolean e(B.b bVar) {
        if (bVar.f207a <= 0 && bVar.f209c <= 0) {
            return false;
        }
        return true;
    }

    public final void g(X x10) {
        ViewGroup viewGroup;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (x10 == null) {
            return;
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        viewGroup.setClipToPadding(false);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            return;
        }
        B.b g10 = p.g(x10, false, 1, null);
        if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) marginLayoutParams).gravity = c(g10);
        } else if (marginLayoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) marginLayoutParams).addRule(d(g10));
        } else if (marginLayoutParams instanceof CoordinatorLayout.e) {
            ((CoordinatorLayout.e) marginLayoutParams).f9318c = c(g10);
        } else if (marginLayoutParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) marginLayoutParams;
            layoutParams2.leftToLeft = -1;
            layoutParams2.topToTop = -1;
            layoutParams2.rightToRight = -1;
            layoutParams2.bottomToBottom = -1;
            if (g10.f207a > 0) {
                layoutParams2.leftToLeft = 0;
            } else if (g10.f208b > 0) {
                layoutParams2.topToTop = 0;
            } else if (g10.f209c > 0) {
                layoutParams2.rightToRight = 0;
            } else {
                layoutParams2.bottomToBottom = 0;
            }
        } else {
            throw new IllegalStateException(kotlin.jvm.internal.i.l("MockNavigationView don't support LayoutParams of ", marginLayoutParams.getClass()));
        }
        if (e(g10)) {
            marginLayoutParams.width = p.e(x10, false, 1, null);
            marginLayoutParams.height = -1;
        } else {
            marginLayoutParams.width = -1;
            marginLayoutParams.height = p.e(x10, false, 1, null);
        }
        marginLayoutParams.setMargins(-viewGroup.getPaddingLeft(), -viewGroup.getPaddingTop(), -viewGroup.getPaddingRight(), -viewGroup.getPaddingBottom());
        setLayoutParams(marginLayoutParams);
    }

    public final int getBackgroundColor() {
        return this.f28995a;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup viewGroup = null;
        h(this, null, 1, null);
        K.z0(this, new z() { // from class: com.oplus.systembarlib.k
            @Override // androidx.core.view.z
            public final X onApplyWindowInsets(View view, X x10) {
                X f10;
                f10 = MockNavigationBar.f(MockNavigationBar.this, view, x10);
                return f10;
            }
        });
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.setOnHierarchyChangeListener(new b());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ViewGroup viewGroup;
        super.onDetachedFromWindow();
        K.z0(this, null);
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setOnHierarchyChangeListener(null);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        kotlin.jvm.internal.i.f(canvas, "canvas");
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.f28995a = i10;
        super.setBackgroundColor(i10);
    }

    public final void setBackgroundColorSmooth(final int i10) {
        final int i11 = this.f28995a;
        if (i11 == i10) {
            SystemBarLog.b("MockNavigationView", kotlin.jvm.internal.i.l("setBackgroundColorSmooth. same color, skip. color=", Color.valueOf(i10)));
            return;
        }
        ViewPropertyAnimator animate = animate();
        animate.setInterpolator(getColorAnimInterpolator());
        animate.setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.systembarlib.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                MockNavigationBar.i(MockNavigationBar.this, i11, i10, valueAnimator);
            }
        });
        animate.start();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
    }

    public /* synthetic */ MockNavigationBar(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MockNavigationBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        m9.d b10;
        m9.d b11;
        kotlin.jvm.internal.i.f(context, "context");
        b10 = kotlin.a.b(new InterfaceC1637a<Paint>() { // from class: com.oplus.systembarlib.MockNavigationBar$debugPaint$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Paint invoke() {
                return new Paint();
            }
        });
        this.f28996b = b10;
        setBackgroundColor(this.f28995a);
        b11 = kotlin.a.b(new InterfaceC1637a<PathInterpolator>() { // from class: com.oplus.systembarlib.MockNavigationBar$colorAnimInterpolator$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final PathInterpolator invoke() {
                return new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            }
        });
        this.f28997c = b11;
    }
}
