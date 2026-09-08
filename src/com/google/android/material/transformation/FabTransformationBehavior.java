package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.K;
import com.google.android.material.circularreveal.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e4.g;
import f4.C1001b;
import f4.C1002c;
import f4.C1003d;
import f4.C1004e;
import f4.C1005f;
import f4.C1008i;
import f4.C1009j;
import f4.C1010k;
import java.util.ArrayList;
import java.util.List;
import r4.C1509a;

@Deprecated
/* loaded from: classes3.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f24256c;

    /* renamed from: d, reason: collision with root package name */
    public final RectF f24257d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f24258e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f24259f;

    /* renamed from: g, reason: collision with root package name */
    public float f24260g;

    /* renamed from: h, reason: collision with root package name */
    public float f24261h;

    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f24262a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f24263b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f24264c;

        public a(boolean z10, View view, View view2) {
            this.f24262a = z10;
            this.f24263b = view;
            this.f24264c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f24262a) {
                this.f24263b.setVisibility(4);
                this.f24264c.setAlpha(1.0f);
                this.f24264c.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f24262a) {
                this.f24263b.setVisibility(0);
                this.f24264c.setAlpha(0.0f);
                this.f24264c.setVisibility(4);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f24266a;

        public b(View view) {
            this.f24266a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f24266a.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.circularreveal.c f24268a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Drawable f24269b;

        public c(com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.f24268a = cVar;
            this.f24269b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f24268a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f24268a.setCircularRevealOverlayDrawable(this.f24269b);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.android.material.circularreveal.c f24271a;

        public d(com.google.android.material.circularreveal.c cVar) {
            this.f24271a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e revealInfo = this.f24271a.getRevealInfo();
            revealInfo.f23094c = Float.MAX_VALUE;
            this.f24271a.setRevealInfo(revealInfo);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public C1008i f24273a;

        /* renamed from: b, reason: collision with root package name */
        public C1010k f24274b;
    }

    public FabTransformationBehavior() {
        this.f24256c = new Rect();
        this.f24257d = new RectF();
        this.f24258e = new RectF();
        this.f24259f = new int[2];
    }

    public abstract e A(Context context, boolean z10);

    public final ViewGroup B(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet f(View view, View view2, boolean z10, boolean z11) {
        e A10 = A(view2.getContext(), z10);
        if (z10) {
            this.f24260g = view.getTranslationX();
            this.f24261h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        t(view, view2, z10, z11, A10, arrayList, arrayList2);
        RectF rectF = this.f24257d;
        y(view, view2, z10, z11, A10, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        s(view, view2, z10, A10, arrayList);
        v(view, view2, z10, z11, A10, arrayList, arrayList2);
        u(view, view2, z10, z11, A10, width, height, arrayList, arrayList2);
        r(view, view2, z10, z11, A10, arrayList, arrayList2);
        q(view, view2, z10, z11, A10, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        C1002c.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener(arrayList2.get(i10));
        }
        return animatorSet;
    }

    public final ViewGroup g(View view) {
        View findViewById = view.findViewById(g.f30843F);
        if (findViewById != null) {
            return B(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return B(view);
        }
        return B(((ViewGroup) view).getChildAt(0));
    }

    public final void h(View view, e eVar, C1009j c1009j, C1009j c1009j2, float f10, float f11, float f12, float f13, RectF rectF) {
        float o10 = o(eVar, c1009j, f10, f12);
        float o11 = o(eVar, c1009j2, f11, f13);
        Rect rect = this.f24256c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f24257d;
        rectF2.set(rect);
        RectF rectF3 = this.f24258e;
        p(view, rectF3);
        rectF3.offset(o10, o11);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final void i(View view, RectF rectF) {
        p(view, rectF);
        rectF.offset(this.f24260g, this.f24261h);
    }

    public final Pair<C1009j, C1009j> j(float f10, float f11, boolean z10, e eVar) {
        C1009j h10;
        C1009j h11;
        if (f10 != 0.0f && f11 != 0.0f) {
            if ((z10 && f11 < 0.0f) || (!z10 && f11 > 0.0f)) {
                h10 = eVar.f24273a.h("translationXCurveUpwards");
                h11 = eVar.f24273a.h("translationYCurveUpwards");
            } else {
                h10 = eVar.f24273a.h("translationXCurveDownwards");
                h11 = eVar.f24273a.h("translationYCurveDownwards");
            }
        } else {
            h10 = eVar.f24273a.h("translationXLinear");
            h11 = eVar.f24273a.h("translationYLinear");
        }
        return new Pair<>(h10, h11);
    }

    public final float k(View view, View view2, C1010k c1010k) {
        RectF rectF = this.f24257d;
        RectF rectF2 = this.f24258e;
        i(view, rectF);
        p(view2, rectF2);
        rectF2.offset(-m(view, view2, c1010k), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    public final float l(View view, View view2, C1010k c1010k) {
        RectF rectF = this.f24257d;
        RectF rectF2 = this.f24258e;
        i(view, rectF);
        p(view2, rectF2);
        rectF2.offset(0.0f, -n(view, view2, c1010k));
        return rectF.centerY() - rectF2.top;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint != 0 && expandedComponentIdHint != view.getId()) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    public final float m(View view, View view2, C1010k c1010k) {
        float centerX;
        float centerX2;
        float f10;
        RectF rectF = this.f24257d;
        RectF rectF2 = this.f24258e;
        i(view, rectF);
        p(view2, rectF2);
        int i10 = c1010k.f31722a & 7;
        if (i10 != 1) {
            if (i10 != 3) {
                if (i10 != 5) {
                    f10 = 0.0f;
                    return f10 + c1010k.f31723b;
                }
                centerX = rectF2.right;
                centerX2 = rectF.right;
            } else {
                centerX = rectF2.left;
                centerX2 = rectF.left;
            }
        } else {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        }
        f10 = centerX - centerX2;
        return f10 + c1010k.f31723b;
    }

    public final float n(View view, View view2, C1010k c1010k) {
        float centerY;
        float centerY2;
        float f10;
        RectF rectF = this.f24257d;
        RectF rectF2 = this.f24258e;
        i(view, rectF);
        p(view2, rectF2);
        int i10 = c1010k.f31722a & 112;
        if (i10 != 16) {
            if (i10 != 48) {
                if (i10 != 80) {
                    f10 = 0.0f;
                    return f10 + c1010k.f31724c;
                }
                centerY = rectF2.bottom;
                centerY2 = rectF.bottom;
            } else {
                centerY = rectF2.top;
                centerY2 = rectF.top;
            }
        } else {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        }
        f10 = centerY - centerY2;
        return f10 + c1010k.f31724c;
    }

    public final float o(e eVar, C1009j c1009j, float f10, float f11) {
        long c10 = c1009j.c();
        long d10 = c1009j.d();
        C1009j h10 = eVar.f24273a.h("expansion");
        return C1001b.a(f10, f11, c1009j.e().getInterpolation(((float) (((h10.c() + h10.d()) + 17) - c10)) / ((float) d10)));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.e eVar) {
        if (eVar.f9323h == 0) {
            eVar.f9323h = 80;
        }
    }

    public final void p(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f24259f);
        rectF.offsetTo(r3[0], r3[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void q(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup g10;
        ObjectAnimator ofFloat;
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        if (((view2 instanceof com.google.android.material.circularreveal.c) && com.google.android.material.circularreveal.b.f23078j == 0) || (g10 = g(view2)) == null) {
            return;
        }
        if (z10) {
            if (!z11) {
                C1004e.f31708a.set(g10, Float.valueOf(0.0f));
            }
            ofFloat = ObjectAnimator.ofFloat(g10, C1004e.f31708a, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(g10, C1004e.f31708a, 0.0f);
        }
        eVar.f24273a.h("contentFade").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (!(view2 instanceof com.google.android.material.circularreveal.c)) {
            return;
        }
        com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
        int z12 = z(view);
        int i10 = 16777215 & z12;
        if (z10) {
            if (!z11) {
                cVar.setCircularRevealScrimColor(z12);
            }
            ofInt = ObjectAnimator.ofInt(cVar, c.d.f23091a, i10);
        } else {
            ofInt = ObjectAnimator.ofInt(cVar, c.d.f23091a, z12);
        }
        ofInt.setEvaluator(C1003d.b());
        eVar.f24273a.h("color").a(ofInt);
        list.add(ofInt);
    }

    public final void s(View view, View view2, boolean z10, e eVar, List<Animator> list) {
        float m10 = m(view, view2, eVar.f24274b);
        float n10 = n(view, view2, eVar.f24274b);
        Pair<C1009j, C1009j> j10 = j(m10, n10, z10, eVar);
        C1009j c1009j = (C1009j) j10.first;
        C1009j c1009j2 = (C1009j) j10.second;
        Property property = View.TRANSLATION_X;
        if (!z10) {
            m10 = this.f24260g;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, m10);
        Property property2 = View.TRANSLATION_Y;
        if (!z10) {
            n10 = this.f24261h;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, n10);
        c1009j.a(ofFloat);
        c1009j2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public final void t(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float r10 = K.r(view2) - K.r(view);
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-r10);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -r10);
        }
        eVar.f24273a.h("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(View view, View view2, boolean z10, boolean z11, e eVar, float f10, float f11, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (!(view2 instanceof com.google.android.material.circularreveal.c)) {
            return;
        }
        com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
        float k10 = k(view, view2, eVar.f24274b);
        float l10 = l(view, view2, eVar.f24274b);
        ((FloatingActionButton) view).h(this.f24256c);
        float width = this.f24256c.width() / 2.0f;
        C1009j h10 = eVar.f24273a.h("expansion");
        if (z10) {
            if (!z11) {
                cVar.setRevealInfo(new c.e(k10, l10, width));
            }
            if (z11) {
                width = cVar.getRevealInfo().f23094c;
            }
            animator = com.google.android.material.circularreveal.a.a(cVar, k10, l10, C1509a.b(k10, l10, 0.0f, 0.0f, f10, f11));
            animator.addListener(new d(cVar));
            x(view2, h10.c(), (int) k10, (int) l10, width, list);
        } else {
            float f12 = cVar.getRevealInfo().f23094c;
            Animator a10 = com.google.android.material.circularreveal.a.a(cVar, k10, l10, width);
            int i10 = (int) k10;
            int i11 = (int) l10;
            x(view2, h10.c(), i10, i11, f12, list);
            w(view2, h10.c(), h10.d(), eVar.f24273a.i(), i10, i11, width, list);
            animator = a10;
        }
        h10.a(animator);
        list.add(animator);
        list2.add(com.google.android.material.circularreveal.a.b(cVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z10) {
                if (!z11) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, C1005f.f31709b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, C1005f.f31709b, 255);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.f24273a.h("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(cVar, drawable));
        }
    }

    public final void w(View view, long j10, long j11, long j12, int i10, int i11, float f10, List<Animator> list) {
        long j13 = j10 + j11;
        if (j13 < j12) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            createCircularReveal.setStartDelay(j13);
            createCircularReveal.setDuration(j12 - j13);
            list.add(createCircularReveal);
        }
    }

    public final void x(View view, long j10, int i10, int i11, float f10, List<Animator> list) {
        if (j10 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j10);
            list.add(createCircularReveal);
        }
    }

    public final void y(View view, View view2, boolean z10, boolean z11, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float m10 = m(view, view2, eVar.f24274b);
        float n10 = n(view, view2, eVar.f24274b);
        Pair<C1009j, C1009j> j10 = j(m10, n10, z10, eVar);
        C1009j c1009j = (C1009j) j10.first;
        C1009j c1009j2 = (C1009j) j10.second;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-m10);
                view2.setTranslationY(-n10);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            h(view2, eVar, c1009j, c1009j2, -m10, -n10, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -m10);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -n10);
        }
        c1009j.a(ofFloat);
        c1009j2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public final int z(View view) {
        ColorStateList o10 = K.o(view);
        if (o10 != null) {
            return o10.getColorForState(view.getDrawableState(), o10.getDefaultColor());
        }
        return 0;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24256c = new Rect();
        this.f24257d = new RectF();
        this.f24258e = new RectF();
        this.f24259f = new int[2];
    }
}
