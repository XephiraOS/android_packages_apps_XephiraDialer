package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.a;
import e4.C0977c;
import e4.C0979e;
import f4.C1001b;
import java.util.List;
import l4.C1292a;
import u4.C1607c;
import z4.InterfaceC1733a;

/* loaded from: classes3.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    public final int f23793a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23794b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23795c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f23796d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f23797e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f23798f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewGroup f23799g;

    /* renamed from: h, reason: collision with root package name */
    public final o f23800h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC1733a f23801i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23802j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f23803k;

    /* renamed from: l, reason: collision with root package name */
    public int f23804l;

    /* renamed from: m, reason: collision with root package name */
    public int f23805m;

    /* renamed from: n, reason: collision with root package name */
    public int f23806n;

    /* renamed from: o, reason: collision with root package name */
    public int f23807o;

    /* renamed from: p, reason: collision with root package name */
    public int f23808p;

    /* renamed from: q, reason: collision with root package name */
    public int f23809q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f23810r;

    /* renamed from: s, reason: collision with root package name */
    public List<m<B>> f23811s;

    /* renamed from: t, reason: collision with root package name */
    public Behavior f23812t;

    /* renamed from: u, reason: collision with root package name */
    public final AccessibilityManager f23813u;

    /* renamed from: v, reason: collision with root package name */
    public a.b f23814v;

    /* renamed from: w, reason: collision with root package name */
    public static final TimeInterpolator f23789w = C1001b.f31703b;

    /* renamed from: x, reason: collision with root package name */
    public static final TimeInterpolator f23790x = C1001b.f31702a;

    /* renamed from: y, reason: collision with root package name */
    public static final TimeInterpolator f23791y = C1001b.f31705d;

    /* renamed from: A, reason: collision with root package name */
    public static final boolean f23786A = false;

    /* renamed from: B, reason: collision with root package name */
    public static final int[] f23787B = {C0977c.f30682n0};

    /* renamed from: C, reason: collision with root package name */
    public static final String f23788C = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: z, reason: collision with root package name */
    public static final Handler f23792z = new Handler(Looper.getMainLooper(), new h());

    /* loaded from: classes3.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: l, reason: collision with root package name */
        public final n f23815l = new n(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean b(View view) {
            return this.f23815l.a(view);
        }

        public final void m(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f23815l.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f23815l.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23816a;

        public a(int i10) {
            this.f23816a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.B(this.f23816a);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f23800h.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f23800h.setScaleX(floatValue);
            BaseTransientBottomBar.this.f23800h.setScaleY(floatValue);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.C();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f23801i.a(BaseTransientBottomBar.this.f23795c - BaseTransientBottomBar.this.f23793a, BaseTransientBottomBar.this.f23793a);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public int f23821a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f23822b;

        public e(int i10) {
            this.f23822b = i10;
            this.f23821a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f23786A) {
                K.U(BaseTransientBottomBar.this.f23800h, intValue - this.f23821a);
            } else {
                BaseTransientBottomBar.this.f23800h.setTranslationY(intValue);
            }
            this.f23821a = intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23824a;

        public f(int i10) {
            this.f23824a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.B(this.f23824a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f23801i.b(0, BaseTransientBottomBar.this.f23794b);
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public int f23826a = 0;

        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f23786A) {
                K.U(BaseTransientBottomBar.this.f23800h, intValue - this.f23826a);
            } else {
                BaseTransientBottomBar.this.f23800h.setTranslationY(intValue);
            }
            this.f23826a = intValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 0) {
                if (i10 != 1) {
                    return false;
                }
                ((BaseTransientBottomBar) message.obj).v(message.arg1);
                return true;
            }
            ((BaseTransientBottomBar) message.obj).H();
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.B(3);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements SwipeDismissBehavior.c {
        public j() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.p(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i10) {
            if (i10 != 0) {
                if (i10 == 1 || i10 == 2) {
                    com.google.android.material.snackbar.a.c().j(BaseTransientBottomBar.this.f23814v);
                    return;
                }
                return;
            }
            com.google.android.material.snackbar.a.c().k(BaseTransientBottomBar.this.f23814v);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar = BaseTransientBottomBar.this.f23800h;
            if (oVar == null) {
                return;
            }
            if (oVar.getParent() != null) {
                BaseTransientBottomBar.this.f23800h.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f23800h.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.J();
            } else {
                BaseTransientBottomBar.this.L();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends AnimatorListenerAdapter {
        public l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.C();
        }
    }

    /* loaded from: classes3.dex */
    public static class n {

        /* renamed from: a, reason: collision with root package name */
        public a.b f23832a;

        public n(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.i(0.1f);
            swipeDismissBehavior.g(0.6f);
            swipeDismissBehavior.j(0);
        }

        public boolean a(View view) {
            return view instanceof o;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    com.google.android.material.snackbar.a.c().k(this.f23832a);
                    return;
                }
                return;
            }
            if (coordinatorLayout.z(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                com.google.android.material.snackbar.a.c().j(this.f23832a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f23832a = baseTransientBottomBar.f23814v;
        }
    }

    /* loaded from: classes3.dex */
    public static class o extends FrameLayout {

        /* renamed from: l, reason: collision with root package name */
        public static final View.OnTouchListener f23833l = new a();

        /* renamed from: a, reason: collision with root package name */
        public BaseTransientBottomBar<?> f23834a;

        /* renamed from: b, reason: collision with root package name */
        public x4.n f23835b;

        /* renamed from: c, reason: collision with root package name */
        public int f23836c;

        /* renamed from: d, reason: collision with root package name */
        public final float f23837d;

        /* renamed from: e, reason: collision with root package name */
        public final float f23838e;

        /* renamed from: f, reason: collision with root package name */
        public final int f23839f;

        /* renamed from: g, reason: collision with root package name */
        public final int f23840g;

        /* renamed from: h, reason: collision with root package name */
        public ColorStateList f23841h;

        /* renamed from: i, reason: collision with root package name */
        public PorterDuff.Mode f23842i;

        /* renamed from: j, reason: collision with root package name */
        public Rect f23843j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f23844k;

        /* loaded from: classes3.dex */
        public class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public o(Context context, AttributeSet attributeSet) {
            super(B4.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, e4.m.f31307X9);
            if (obtainStyledAttributes.hasValue(e4.m.ea)) {
                K.r0(this, obtainStyledAttributes.getDimensionPixelSize(r2, 0));
            }
            this.f23836c = obtainStyledAttributes.getInt(e4.m.aa, 0);
            if (obtainStyledAttributes.hasValue(e4.m.ga) || obtainStyledAttributes.hasValue(e4.m.ha)) {
                this.f23835b = x4.n.e(context2, attributeSet, 0, 0).m();
            }
            this.f23837d = obtainStyledAttributes.getFloat(e4.m.ba, 1.0f);
            setBackgroundTintList(C1607c.a(context2, obtainStyledAttributes, e4.m.ca));
            setBackgroundTintMode(ViewUtils.parseTintMode(obtainStyledAttributes.getInt(e4.m.da, -1), PorterDuff.Mode.SRC_IN));
            this.f23838e = obtainStyledAttributes.getFloat(e4.m.Z9, 1.0f);
            this.f23839f = obtainStyledAttributes.getDimensionPixelSize(e4.m.Y9, -1);
            this.f23840g = obtainStyledAttributes.getDimensionPixelSize(e4.m.fa, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f23833l);
            setFocusable(true);
            if (getBackground() == null) {
                K.n0(this, c());
            }
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f23834a = baseTransientBottomBar;
        }

        public void b(ViewGroup viewGroup) {
            this.f23844k = true;
            viewGroup.addView(this);
            this.f23844k = false;
        }

        public final Drawable c() {
            int k10 = C1292a.k(this, C0977c.f30697v, C0977c.f30689r, getBackgroundOverlayColorAlpha());
            x4.n nVar = this.f23835b;
            Drawable o10 = nVar != null ? BaseTransientBottomBar.o(k10, nVar) : BaseTransientBottomBar.n(k10, getResources());
            if (this.f23841h != null) {
                Drawable r10 = C.a.r(o10);
                C.a.o(r10, this.f23841h);
                return r10;
            }
            return C.a.r(o10);
        }

        public final void d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f23843j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        public float getActionTextColorAlpha() {
            return this.f23838e;
        }

        public int getAnimationMode() {
            return this.f23836c;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f23837d;
        }

        public int getMaxInlineActionWidth() {
            return this.f23840g;
        }

        public int getMaxWidth() {
            return this.f23839f;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f23834a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.y();
            }
            K.f0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f23834a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.z();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f23834a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.A();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (this.f23839f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = this.f23839f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        public void setAnimationMode(int i10) {
            this.f23836c = i10;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f23841h != null) {
                drawable = C.a.r(drawable.mutate());
                C.a.o(drawable, this.f23841h);
                C.a.p(drawable, this.f23842i);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f23841h = colorStateList;
            if (getBackground() != null) {
                Drawable r10 = C.a.r(getBackground().mutate());
                C.a.o(r10, colorStateList);
                C.a.p(r10, this.f23842i);
                if (r10 != getBackground()) {
                    super.setBackgroundDrawable(r10);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f23842i = mode;
            if (getBackground() != null) {
                Drawable r10 = C.a.r(getBackground().mutate());
                C.a.p(r10, mode);
                if (r10 != getBackground()) {
                    super.setBackgroundDrawable(r10);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (!this.f23844k && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                d((ViewGroup.MarginLayoutParams) layoutParams);
                BaseTransientBottomBar<?> baseTransientBottomBar = this.f23834a;
                if (baseTransientBottomBar != null) {
                    baseTransientBottomBar.N();
                }
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener;
            if (onClickListener != null) {
                onTouchListener = null;
            } else {
                onTouchListener = f23833l;
            }
            setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }
    }

    public static GradientDrawable n(int i10, Resources resources) {
        float dimension = resources.getDimension(C0979e.f30756Q0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(dimension);
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }

    public static x4.i o(int i10, x4.n nVar) {
        x4.i iVar = new x4.i(nVar);
        iVar.setFillColor(ColorStateList.valueOf(i10));
        return iVar;
    }

    public void A() {
        if (this.f23810r) {
            I();
            this.f23810r = false;
        }
    }

    public void B(int i10) {
        com.google.android.material.snackbar.a.c().h(this.f23814v);
        List<m<B>> list = this.f23811s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f23811s.get(size).a(this, i10);
            }
        }
        ViewParent parent = this.f23800h.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f23800h);
        }
    }

    public void C() {
        com.google.android.material.snackbar.a.c().i(this.f23814v);
        List<m<B>> list = this.f23811s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f23811s.get(size).b(this);
            }
        }
    }

    public final void D() {
        this.f23807o = m();
        N();
    }

    public final void E(CoordinatorLayout.e eVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.f23812t;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = s();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).m(this);
        }
        swipeDismissBehavior.h(new j());
        eVar.o(swipeDismissBehavior);
        if (r() == null) {
            eVar.f9322g = 80;
        }
    }

    public boolean F() {
        AccessibilityManager accessibilityManager = this.f23813u;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean G() {
        if (this.f23808p > 0 && !this.f23802j && x()) {
            return true;
        }
        return false;
    }

    public final void H() {
        if (this.f23800h.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f23800h.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.e) {
                E((CoordinatorLayout.e) layoutParams);
            }
            this.f23800h.b(this.f23799g);
            D();
            this.f23800h.setVisibility(4);
        }
        if (K.O(this.f23800h)) {
            I();
        } else {
            this.f23810r = true;
        }
    }

    public final void I() {
        if (F()) {
            k();
            return;
        }
        if (this.f23800h.getParent() != null) {
            this.f23800h.setVisibility(0);
        }
        C();
    }

    public final void J() {
        ValueAnimator q10 = q(0.0f, 1.0f);
        ValueAnimator t10 = t(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(q10, t10);
        animatorSet.setDuration(this.f23793a);
        animatorSet.addListener(new l());
        animatorSet.start();
    }

    public final void K(int i10) {
        ValueAnimator q10 = q(1.0f, 0.0f);
        q10.setDuration(this.f23794b);
        q10.addListener(new a(i10));
        q10.start();
    }

    public final void L() {
        int u10 = u();
        if (f23786A) {
            K.U(this.f23800h, u10);
        } else {
            this.f23800h.setTranslationY(u10);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(u10, 0);
        valueAnimator.setInterpolator(this.f23797e);
        valueAnimator.setDuration(this.f23795c);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(u10));
        valueAnimator.start();
    }

    public final void M(int i10) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, u());
        valueAnimator.setInterpolator(this.f23797e);
        valueAnimator.setDuration(this.f23795c);
        valueAnimator.addListener(new f(i10));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    public final void N() {
        int i10;
        boolean z10;
        ViewGroup.LayoutParams layoutParams = this.f23800h.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            Log.w(f23788C, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f23800h.f23843j == null) {
            Log.w(f23788C, "Unable to update margins because original view margins are not set");
            return;
        }
        if (this.f23800h.getParent() == null) {
            return;
        }
        if (r() != null) {
            i10 = this.f23807o;
        } else {
            i10 = this.f23804l;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i11 = this.f23800h.f23843j.bottom + i10;
        int i12 = this.f23800h.f23843j.left + this.f23805m;
        int i13 = this.f23800h.f23843j.right + this.f23806n;
        int i14 = this.f23800h.f23843j.top;
        if (marginLayoutParams.bottomMargin == i11 && marginLayoutParams.leftMargin == i12 && marginLayoutParams.rightMargin == i13 && marginLayoutParams.topMargin == i14) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            marginLayoutParams.bottomMargin = i11;
            marginLayoutParams.leftMargin = i12;
            marginLayoutParams.rightMargin = i13;
            marginLayoutParams.topMargin = i14;
            this.f23800h.requestLayout();
        }
        if ((z10 || this.f23809q != this.f23808p) && G()) {
            this.f23800h.removeCallbacks(this.f23803k);
            this.f23800h.post(this.f23803k);
        }
    }

    public void k() {
        this.f23800h.post(new k());
    }

    public final void l(int i10) {
        if (this.f23800h.getAnimationMode() == 1) {
            K(i10);
        } else {
            M(i10);
        }
    }

    public final int m() {
        if (r() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        r().getLocationOnScreen(iArr);
        int i10 = iArr[1];
        int[] iArr2 = new int[2];
        this.f23799g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f23799g.getHeight()) - i10;
    }

    public void p(int i10) {
        com.google.android.material.snackbar.a.c().b(this.f23814v, i10);
    }

    public final ValueAnimator q(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f23796d);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    public View r() {
        return null;
    }

    public SwipeDismissBehavior<? extends View> s() {
        return new Behavior();
    }

    public final ValueAnimator t(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f23798f);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    public final int u() {
        int height = this.f23800h.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f23800h.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return height;
    }

    public final void v(int i10) {
        if (F() && this.f23800h.getVisibility() == 0) {
            l(i10);
        } else {
            B(i10);
        }
    }

    public boolean w() {
        return com.google.android.material.snackbar.a.c().e(this.f23814v);
    }

    public final boolean x() {
        ViewGroup.LayoutParams layoutParams = this.f23800h.getLayoutParams();
        if ((layoutParams instanceof CoordinatorLayout.e) && (((CoordinatorLayout.e) layoutParams).f() instanceof SwipeDismissBehavior)) {
            return true;
        }
        return false;
    }

    public void y() {
        WindowInsets rootWindowInsets = this.f23800h.getRootWindowInsets();
        if (rootWindowInsets != null) {
            this.f23808p = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            N();
        }
    }

    public void z() {
        if (w()) {
            f23792z.post(new i());
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class m<B> {
        public void b(B b10) {
        }

        public void a(B b10, int i10) {
        }
    }
}
