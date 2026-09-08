package s4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import e4.C0979e;
import f4.C1001b;

/* compiled from: MaterialBottomContainerBackHelper.java */
/* renamed from: s4.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1546e extends AbstractC1542a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f36792g;

    /* renamed from: h, reason: collision with root package name */
    public final float f36793h;

    /* compiled from: MaterialBottomContainerBackHelper.java */
    /* renamed from: s4.e$a */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1546e.this.f36780b.setTranslationY(0.0f);
            C1546e.this.k(0.0f);
        }
    }

    public C1546e(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f36792g = resources.getDimension(C0979e.f30806r);
        this.f36793h = resources.getDimension(C0979e.f30808s);
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator g10 = g();
        g10.setDuration(this.f36783e);
        g10.start();
    }

    public final Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v10 = this.f36780b;
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new T.b());
        return animatorSet;
    }

    public void h(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.TRANSLATION_Y, this.f36780b.getHeight() * this.f36780b.getScaleY());
        ofFloat.setInterpolator(new T.b());
        ofFloat.setDuration(C1001b.c(this.f36781c, this.f36782d, bVar.a()));
        ofFloat.addListener(new a());
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public void i(androidx.activity.b bVar, Animator.AnimatorListener animatorListener) {
        Animator g10 = g();
        g10.setDuration(C1001b.c(this.f36781c, this.f36782d, bVar.a()));
        if (animatorListener != null) {
            g10.addListener(animatorListener);
        }
        g10.start();
    }

    public void j(androidx.activity.b bVar) {
        super.d(bVar);
    }

    public void k(float f10) {
        float f11;
        float a10 = a(f10);
        float width = this.f36780b.getWidth();
        float height = this.f36780b.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float f12 = this.f36792g / width;
            float f13 = this.f36793h / height;
            float a11 = 1.0f - C1001b.a(0.0f, f12, a10);
            float a12 = 1.0f - C1001b.a(0.0f, f13, a10);
            this.f36780b.setScaleX(a11);
            this.f36780b.setPivotY(height);
            this.f36780b.setScaleY(a12);
            V v10 = this.f36780b;
            if (v10 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v10;
                for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                    View childAt = viewGroup.getChildAt(i10);
                    childAt.setPivotY(-childAt.getTop());
                    if (a12 != 0.0f) {
                        f11 = a11 / a12;
                    } else {
                        f11 = 1.0f;
                    }
                    childAt.setScaleY(f11);
                }
            }
        }
    }

    public void l(androidx.activity.b bVar) {
        if (super.e(bVar) == null) {
            return;
        }
        k(bVar.a());
    }
}
