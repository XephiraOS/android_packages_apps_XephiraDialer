package com.android.contacts.framework.baseui.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.android.contacts.framework.baseui.widget.FloatingTabView;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import v9.InterfaceC1637a;

/* compiled from: FloatingTabView.kt */
/* loaded from: classes.dex */
public final class FloatingTabView$switchAnimator$2 extends Lambda implements InterfaceC1637a<ValueAnimator> {
    final /* synthetic */ FloatingTabView this$0;

    /* compiled from: Animator.kt */
    /* loaded from: classes.dex */
    public static final class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatingTabView f16076a;

        public a(FloatingTabView floatingTabView) {
            this.f16076a = floatingTabView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
            this.f16076a.r();
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

    /* compiled from: Animator.kt */
    /* loaded from: classes.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f16077a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatingTabView f16078b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f16079c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f16080d;

        public b(ValueAnimator valueAnimator, FloatingTabView floatingTabView, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2) {
            this.f16077a = valueAnimator;
            this.f16078b = floatingTabView;
            this.f16079c = ref$ObjectRef;
            this.f16080d = ref$ObjectRef2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            kotlin.jvm.internal.i.f(animator, "animator");
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [android.widget.TextView, T] */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FloatingTabView.b bVar;
            FloatingTabView.b bVar2;
            ArrayList<FloatingTabView.e> arrayList;
            Integer num;
            Integer num2;
            kotlin.jvm.internal.i.f(animator, "animator");
            ValueAnimator valueAnimator = this.f16077a;
            bVar = this.f16078b.f16062p;
            bVar2 = this.f16078b.f16061o;
            valueAnimator.setObjectValues(bVar, bVar2);
            arrayList = this.f16078b.f16059m;
            for (FloatingTabView.e eVar : arrayList) {
                ?? r12 = (TextView) this.f16078b.findViewById(eVar.a());
                int a10 = eVar.a();
                num = this.f16078b.f16064r;
                if (num != null && a10 == num.intValue()) {
                    this.f16079c.element = r12;
                } else {
                    int a11 = eVar.a();
                    num2 = this.f16078b.f16065x;
                    if (num2 != null && a11 == num2.intValue()) {
                        this.f16080d.element = r12;
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingTabView$switchAnimator$2(FloatingTabView floatingTabView) {
        super(0);
        this.this$0 = floatingTabView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(FloatingTabView this$0, Ref$ObjectRef fadeInTextView, Ref$ObjectRef fadeOutTextView, ValueAnimator animation) {
        FloatingTabView.b bVar;
        FloatingTabView.b bVar2;
        int textSelectedColor;
        int textUnselectedColor;
        int textUnselectedColor2;
        int textSelectedColor2;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(fadeInTextView, "$fadeInTextView");
        kotlin.jvm.internal.i.f(fadeOutTextView, "$fadeOutTextView");
        kotlin.jvm.internal.i.f(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        kotlin.jvm.internal.i.d(animatedValue, "null cannot be cast to non-null type com.android.contacts.framework.baseui.widget.FloatingTabView.IndicatorPosition");
        FloatingTabView.b bVar3 = (FloatingTabView.b) animatedValue;
        bVar = this$0.f16060n;
        bVar.g(bVar3.b());
        bVar2 = this$0.f16060n;
        bVar2.h(bVar3.d());
        TextView textView = (TextView) fadeInTextView.element;
        if (textView != null) {
            textUnselectedColor2 = this$0.getTextUnselectedColor();
            textSelectedColor2 = this$0.getTextSelectedColor();
            textView.setTextColor(B.a.i(textUnselectedColor2, textSelectedColor2, bVar3.c()));
        }
        TextView textView2 = (TextView) fadeOutTextView.element;
        if (textView2 != null) {
            textSelectedColor = this$0.getTextSelectedColor();
            textUnselectedColor = this$0.getTextUnselectedColor();
            textView2.setTextColor(B.a.i(textSelectedColor, textUnselectedColor, bVar3.c()));
        }
        this$0.invalidate();
    }

    @Override // v9.InterfaceC1637a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ValueAnimator invoke() {
        FloatingTabView.b bVar;
        FloatingTabView.b bVar2;
        PathInterpolator pathInterpolator;
        long j10;
        FloatingTabView.d dVar = new FloatingTabView.d();
        bVar = this.this$0.f16062p;
        bVar2 = this.this$0.f16061o;
        ValueAnimator invoke$lambda$4 = ValueAnimator.ofObject(dVar, bVar, bVar2);
        final FloatingTabView floatingTabView = this.this$0;
        pathInterpolator = FloatingTabView.f16038J;
        invoke$lambda$4.setInterpolator(pathInterpolator);
        j10 = floatingTabView.f16058l;
        invoke$lambda$4.setDuration(j10);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        invoke$lambda$4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.contacts.framework.baseui.widget.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingTabView$switchAnimator$2.e(FloatingTabView.this, ref$ObjectRef, ref$ObjectRef2, valueAnimator);
            }
        });
        kotlin.jvm.internal.i.e(invoke$lambda$4, "invoke$lambda$4");
        invoke$lambda$4.addListener(new b(invoke$lambda$4, floatingTabView, ref$ObjectRef, ref$ObjectRef2));
        invoke$lambda$4.addListener(new a(floatingTabView));
        return invoke$lambda$4;
    }
}
