package com.android.contacts.framework.baseui.util;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.coui.appcompat.animation.COUIInEaseInterpolator;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;

/* compiled from: FeedbackAnimatorHelper.kt */
/* renamed from: com.android.contacts.framework.baseui.util.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0640e {

    /* renamed from: w, reason: collision with root package name */
    public static final a f15900w = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final C f15901a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15902b;

    /* renamed from: c, reason: collision with root package name */
    public ValueAnimator f15903c;

    /* renamed from: d, reason: collision with root package name */
    public float f15904d;

    /* renamed from: e, reason: collision with root package name */
    public float f15905e;

    /* renamed from: f, reason: collision with root package name */
    public float f15906f;

    /* renamed from: g, reason: collision with root package name */
    public float f15907g;

    /* renamed from: h, reason: collision with root package name */
    public int f15908h;

    /* renamed from: i, reason: collision with root package name */
    public int f15909i;

    /* renamed from: j, reason: collision with root package name */
    public final PathInterpolator f15910j;

    /* renamed from: k, reason: collision with root package name */
    public final PathInterpolator f15911k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15912l;

    /* renamed from: m, reason: collision with root package name */
    public float f15913m;

    /* renamed from: n, reason: collision with root package name */
    public float f15914n;

    /* renamed from: o, reason: collision with root package name */
    public float f15915o;

    /* renamed from: p, reason: collision with root package name */
    public float f15916p;

    /* renamed from: q, reason: collision with root package name */
    public final float f15917q;

    /* renamed from: r, reason: collision with root package name */
    public final float f15918r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f15919s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f15920t;

    /* renamed from: u, reason: collision with root package name */
    public b f15921u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f15922v;

    /* compiled from: FeedbackAnimatorHelper.kt */
    /* renamed from: com.android.contacts.framework.baseui.util.e$a */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FeedbackAnimatorHelper.kt */
    /* renamed from: com.android.contacts.framework.baseui.util.e$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(float f10);
    }

    /* compiled from: Animator.kt */
    /* renamed from: com.android.contacts.framework.baseui.util.e$c */
    /* loaded from: classes.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f15924b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f15925c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f15926d;

        public c(float f10, float f11, float f12) {
            this.f15924b = f10;
            this.f15925c = f11;
            this.f15926d = f12;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
            C0640e.this.n(this.f15924b, this.f15925c, this.f15926d);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
        }
    }

    public C0640e(C holder, int i10) {
        kotlin.jvm.internal.i.f(holder, "holder");
        this.f15901a = holder;
        this.f15902b = i10;
        this.f15904d = 1.0f;
        this.f15908h = -1;
        this.f15909i = -1;
        this.f15910j = new COUIMoveEaseInterpolator();
        this.f15911k = new COUIInEaseInterpolator();
        this.f15913m = 0.92f;
        this.f15914n = 1.0f;
        this.f15919s = true;
        this.f15920t = true;
        TypedValue typedValue = new TypedValue();
        holder.getContext().getResources().getValue(X8.f.f4691g, typedValue, true);
        this.f15915o = typedValue.getFloat();
        holder.getContext().getResources().getValue(X8.f.f4837z0, typedValue, true);
        this.f15916p = typedValue.getFloat();
        int dimensionPixelOffset = holder.getContext().getResources().getDimensionPixelOffset(X8.f.f4534K2);
        int dimensionPixelOffset2 = holder.getContext().getResources().getDimensionPixelOffset(X8.f.f4527J2);
        int dimensionPixelOffset3 = holder.getContext().getResources().getDimensionPixelOffset(X8.f.f4555N2);
        this.f15917q = dimensionPixelOffset * dimensionPixelOffset2;
        this.f15918r = dimensionPixelOffset3 * dimensionPixelOffset3;
    }

    public static final void m(C0640e this$0, float f10, float f11, boolean z10, ValueAnimator animator) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(animator, "animator");
        this$0.o(animator, f10, f11, z10);
    }

    public final float c(int i10, int i11) {
        float f10 = i10 * i11;
        float f11 = this.f15917q;
        float f12 = this.f15918r;
        float f13 = (((f10 - f11) * 0.04000002f) / (f11 - f12)) + 0.98f;
        if (f10 < f12) {
            return 1.0f;
        }
        if (f10 > f11) {
            return 0.98f;
        }
        return f13;
    }

    public final void d() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f15903c;
        if (valueAnimator2 != null && valueAnimator2.isRunning() && (valueAnimator = this.f15903c) != null) {
            valueAnimator.cancel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(boolean r14) {
        /*
            r13 = this;
            r0 = 0
            r13.f15922v = r0
            r13.f15912l = r0
            int r0 = r13.f15902b
            r1 = 340(0x154, double:1.68E-321)
            r3 = 200(0xc8, double:9.9E-322)
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L35
            r6 = 1
            if (r0 == r6) goto L26
            r6 = 2
            if (r0 == r6) goto L1c
            r0 = 0
            r11 = r0
        L18:
            r8 = r5
            r9 = r8
        L1a:
            r10 = r9
            goto L48
        L1c:
            if (r14 == 0) goto L1f
            r1 = r3
        L1f:
            r0 = 1061997773(0x3f4ccccd, float:0.8)
            r8 = r0
            r11 = r1
            r9 = r5
            goto L1a
        L26:
            if (r14 == 0) goto L29
            r1 = r3
        L29:
            float r0 = r13.f15915o
            r3 = 0
            if (r14 == 0) goto L30
            r13.f15905e = r3
        L30:
            r9 = r0
            r11 = r1
            r10 = r3
            r8 = r5
            goto L48
        L35:
            if (r14 == 0) goto L38
            r1 = r3
        L38:
            int r0 = r13.g()
            int r3 = r13.f()
            float r0 = r13.c(r0, r3)
            r13.f15913m = r0
            r11 = r1
            goto L18
        L48:
            r13.d()
            boolean r0 = r13.f15912l
            if (r0 == 0) goto L50
            return
        L50:
            r6 = r13
            r7 = r14
            r6.l(r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.C0640e.e(boolean):void");
    }

    public final int f() {
        int i10 = this.f15909i;
        if (i10 <= 0) {
            return this.f15901a.getHeight();
        }
        return i10;
    }

    public final int g() {
        int i10 = this.f15908h;
        if (i10 <= 0) {
            return this.f15901a.a();
        }
        return i10;
    }

    public final void i(float f10, C c10) {
        if (f10 != c10.f() && this.f15902b != 1) {
            c10.c(f10);
        }
    }

    public final void j(float f10, C c10, float f11) {
        float d10;
        float a10;
        d10 = B9.i.d(1.0f, f10);
        a10 = B9.i.a(f11, d10);
        c10.e(a10);
        c10.b(a10);
        c10.d();
        b bVar = this.f15921u;
        if (bVar != null) {
            bVar.a(a10);
        }
    }

    public final void k(b bVar) {
        this.f15921u = bVar;
    }

    public final void l(final boolean z10, float f10, float f11, float f12, long j10) {
        final float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        PathInterpolator pathInterpolator;
        float f20 = 1.0f;
        if (z10) {
            f13 = 1.0f;
        } else {
            f13 = this.f15914n;
        }
        if (z10) {
            f14 = this.f15913m;
        } else {
            f14 = 1.0f;
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("scaleHolder", f13, f14);
        if (z10) {
            f15 = f10;
        } else {
            f15 = 1.0f;
        }
        if (!z10) {
            f20 = this.f15904d;
        }
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("brightnessHolder", f20, f15);
        if (z10) {
            f16 = f11;
        } else {
            f16 = f12;
        }
        if (z10) {
            f17 = f12;
        } else {
            f17 = this.f15905e;
        }
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("alphaHolder", f17, f16);
        if (z10) {
            f18 = 0.0f;
        } else {
            f18 = this.f15907g;
        }
        if (z10) {
            f19 = this.f15916p;
        } else {
            f19 = 0.0f;
        }
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("blackAlphaHolder", f18, f19);
        final float abs = Math.abs(f14 - f13);
        H7.b.b("FeedbackAnimatorHelper", "startAnimator:" + f13 + " :" + f14 + " isPressed:" + z10);
        this.f15906f = 0.0f;
        ValueAnimator startAnimator$lambda$2 = ValueAnimator.ofPropertyValuesHolder(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        if (z10) {
            pathInterpolator = this.f15910j;
        } else {
            pathInterpolator = this.f15911k;
        }
        startAnimator$lambda$2.setInterpolator(pathInterpolator);
        startAnimator$lambda$2.setDuration(j10);
        kotlin.jvm.internal.i.e(startAnimator$lambda$2, "startAnimator$lambda$2");
        startAnimator$lambda$2.addListener(new c(f14, f16, f15));
        startAnimator$lambda$2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.contacts.framework.baseui.util.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C0640e.m(C0640e.this, abs, f13, z10, valueAnimator);
            }
        });
        startAnimator$lambda$2.start();
        this.f15903c = startAnimator$lambda$2;
    }

    public final void n(float f10, float f11, float f12) {
        if (this.f15922v) {
            H7.b.b("FeedbackAnimatorHelper", "stopAnim:" + f10 + ":" + f11 + ":" + f12);
            this.f15914n = f10;
            this.f15905e = f11;
            this.f15904d = f12;
            if (this.f15919s) {
                j(f10, this.f15901a, this.f15913m);
            }
            if (this.f15920t) {
                i(this.f15905e, this.f15901a);
            }
            h(1.0f);
        }
    }

    public final void o(ValueAnimator valueAnimator, float f10, float f11, boolean z10) {
        Object animatedValue = valueAnimator.getAnimatedValue("scaleHolder");
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this.f15914n = ((Float) animatedValue).floatValue();
        Object animatedValue2 = valueAnimator.getAnimatedValue("brightnessHolder");
        kotlin.jvm.internal.i.d(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        this.f15904d = ((Float) animatedValue2).floatValue();
        Object animatedValue3 = valueAnimator.getAnimatedValue("alphaHolder");
        kotlin.jvm.internal.i.d(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        this.f15905e = ((Float) animatedValue3).floatValue();
        Object animatedValue4 = valueAnimator.getAnimatedValue("blackAlphaHolder");
        kotlin.jvm.internal.i.d(animatedValue4, "null cannot be cast to non-null type kotlin.Float");
        this.f15907g = ((Float) animatedValue4).floatValue();
        if (this.f15919s) {
            j(this.f15914n, this.f15901a, this.f15913m);
        }
        if (this.f15920t) {
            i(this.f15905e, this.f15901a);
        }
        if (f10 != 0.0f) {
            float abs = Math.abs(this.f15914n - f11) / f10;
            if (!z10) {
                abs = 1 - abs;
            }
            this.f15906f = abs;
        }
        h(this.f15906f);
    }

    public final void h(float f10) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0640e(View view, int i10) {
        this(new F(view), i10);
        kotlin.jvm.internal.i.f(view, "view");
    }
}
