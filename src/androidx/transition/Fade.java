package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;

/* loaded from: classes.dex */
public class Fade extends Visibility {

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final View f11625a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f11626b = false;

        public a(View view) {
            this.f11625a = view;
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
            float f10;
            if (this.f11625a.getVisibility() == 0) {
                f10 = H.b(this.f11625a);
            } else {
                f10 = 0.0f;
            }
            this.f11625a.setTag(C0511n.f11732h, Float.valueOf(f10));
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
            this.f11625a.setTag(C0511n.f11732h, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            H.f(this.f11625a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f11625a.hasOverlappingRendering() && this.f11625a.getLayerType() == 0) {
                this.f11626b = true;
                this.f11625a.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (this.f11626b) {
                this.f11625a.setLayerType(0, null);
            }
            if (z10) {
                return;
            }
            H.f(this.f11625a, 1.0f);
            H.a(this.f11625a);
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
        }

        @Override // androidx.transition.Transition.i
        public void f(Transition transition, boolean z10) {
        }
    }

    public Fade(int i10) {
        g(i10);
    }

    public static float i(C c10, float f10) {
        Float f11;
        if (c10 != null && (f11 = (Float) c10.f11527a.get("android:fade:transitionAlpha")) != null) {
            return f11.floatValue();
        }
        return f10;
    }

    @Override // androidx.transition.Visibility
    public Animator c(ViewGroup viewGroup, View view, C c10, C c11) {
        H.c(view);
        return h(view, i(c10, 0.0f), 1.0f);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C c10) {
        super.captureStartValues(c10);
        Float f10 = (Float) c10.f11528b.getTag(C0511n.f11732h);
        if (f10 == null) {
            if (c10.f11528b.getVisibility() == 0) {
                f10 = Float.valueOf(H.b(c10.f11528b));
            } else {
                f10 = Float.valueOf(0.0f);
            }
        }
        c10.f11527a.put("android:fade:transitionAlpha", f10);
    }

    @Override // androidx.transition.Visibility
    public Animator e(ViewGroup viewGroup, View view, C c10, C c11) {
        H.c(view);
        Animator h10 = h(view, i(c10, 1.0f), 0.0f);
        if (h10 == null) {
            H.f(view, i(c11, 1.0f));
        }
        return h10;
    }

    public final Animator h(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        H.f(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, H.f11628b, f11);
        a aVar = new a(view);
        ofFloat.addListener(aVar);
        getRootTransition().addListener(aVar);
        return ofFloat;
    }

    @Override // androidx.transition.Transition
    public boolean isSeekingSupported() {
        return true;
    }

    public Fade() {
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f11745f);
        g(A.k.k(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, a()));
        obtainStyledAttributes.recycle();
    }
}
