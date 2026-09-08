package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.Transition;

/* compiled from: TranslationAnimationCreator.java */
/* loaded from: classes.dex */
public class E {
    public static Animator a(View view, C c10, int i10, int i11, float f10, float f11, float f12, float f13, TimeInterpolator timeInterpolator, Transition transition) {
        float f14;
        float f15;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) c10.f11528b.getTag(C0511n.f11733i)) != null) {
            f14 = (r7[0] - i10) + translationX;
            f15 = (r7[1] - i11) + translationY;
        } else {
            f14 = f10;
            f15 = f11;
        }
        view.setTranslationX(f14);
        view.setTranslationY(f15);
        if (f14 == f12 && f15 == f13) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f14, f12), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f15, f13));
        a aVar = new a(view, c10.f11528b, translationX, translationY);
        transition.addListener(aVar);
        ofPropertyValuesHolder.addListener(aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }

    /* compiled from: TranslationAnimationCreator.java */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements Transition.i {

        /* renamed from: a, reason: collision with root package name */
        public final View f11611a;

        /* renamed from: b, reason: collision with root package name */
        public final View f11612b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f11613c;

        /* renamed from: d, reason: collision with root package name */
        public float f11614d;

        /* renamed from: e, reason: collision with root package name */
        public float f11615e;

        /* renamed from: f, reason: collision with root package name */
        public final float f11616f;

        /* renamed from: g, reason: collision with root package name */
        public final float f11617g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f11618h;

        public a(View view, View view2, float f10, float f11) {
            this.f11612b = view;
            this.f11611a = view2;
            this.f11616f = f10;
            this.f11617g = f11;
            int i10 = C0511n.f11733i;
            int[] iArr = (int[]) view2.getTag(i10);
            this.f11613c = iArr;
            if (iArr != null) {
                view2.setTag(i10, null);
            }
        }

        @Override // androidx.transition.Transition.i
        public void b(Transition transition) {
            h();
            this.f11614d = this.f11612b.getTranslationX();
            this.f11615e = this.f11612b.getTranslationY();
            this.f11612b.setTranslationX(this.f11616f);
            this.f11612b.setTranslationY(this.f11617g);
        }

        @Override // androidx.transition.Transition.i
        public void c(Transition transition, boolean z10) {
            if (!this.f11618h) {
                this.f11611a.setTag(C0511n.f11733i, null);
            }
        }

        @Override // androidx.transition.Transition.i
        public void d(Transition transition) {
            c(transition, false);
        }

        @Override // androidx.transition.Transition.i
        public void e(Transition transition) {
            this.f11618h = true;
            this.f11612b.setTranslationX(this.f11616f);
            this.f11612b.setTranslationY(this.f11617g);
        }

        @Override // androidx.transition.Transition.i
        public void g(Transition transition) {
            this.f11612b.setTranslationX(this.f11614d);
            this.f11612b.setTranslationY(this.f11615e);
        }

        public final void h() {
            if (this.f11613c == null) {
                this.f11613c = new int[2];
            }
            this.f11612b.getLocationOnScreen(this.f11613c);
            this.f11611a.setTag(C0511n.f11733i, this.f11613c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f11618h = true;
            this.f11612b.setTranslationX(this.f11616f);
            this.f11612b.setTranslationY(this.f11617g);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            this.f11612b.setTranslationX(this.f11616f);
            this.f11612b.setTranslationY(this.f11617g);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // androidx.transition.Transition.i
        public void a(Transition transition) {
        }
    }
}
