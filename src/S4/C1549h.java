package s4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.C0455j;
import androidx.core.view.K;
import e4.C0979e;
import f4.C1001b;

/* compiled from: MaterialSideContainerBackHelper.java */
/* renamed from: s4.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1549h extends AbstractC1542a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f36804g;

    /* renamed from: h, reason: collision with root package name */
    public final float f36805h;

    /* renamed from: i, reason: collision with root package name */
    public final float f36806i;

    /* compiled from: MaterialSideContainerBackHelper.java */
    /* renamed from: s4.h$a */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f36807a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f36808b;

        public a(boolean z10, int i10) {
            this.f36807a = z10;
            this.f36808b = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1549h.this.f36780b.setTranslationX(0.0f);
            C1549h.this.k(0.0f, this.f36807a, this.f36808b);
        }
    }

    public C1549h(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f36804g = resources.getDimension(C0979e.f30816w);
        this.f36805h = resources.getDimension(C0979e.f30814v);
        this.f36806i = resources.getDimension(C0979e.f30818x);
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.SCALE_Y, 1.0f));
        V v10 = this.f36780b;
        if (v10 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v10;
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i10), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f36783e);
        animatorSet.start();
    }

    public final boolean g(int i10, int i11) {
        if ((C0455j.b(i10, K.v(this.f36780b)) & i11) == i11) {
            return true;
        }
        return false;
    }

    public void h(androidx.activity.b bVar, int i10, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean z10;
        if (bVar.b() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean g10 = g(i10, 3);
        float width = (this.f36780b.getWidth() * this.f36780b.getScaleX()) + i(g10);
        V v10 = this.f36780b;
        Property property = View.TRANSLATION_X;
        if (g10) {
            width = -width;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(v10, (Property<V, Float>) property, width);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new T.b());
        ofFloat.setDuration(C1001b.c(this.f36781c, this.f36782d, bVar.a()));
        ofFloat.addListener(new a(z10, i10));
        if (animatorListener != null) {
            ofFloat.addListener(animatorListener);
        }
        ofFloat.start();
    }

    public final int i(boolean z10) {
        ViewGroup.LayoutParams layoutParams = this.f36780b.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (z10) {
                return marginLayoutParams.leftMargin;
            }
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public void j(androidx.activity.b bVar) {
        super.d(bVar);
    }

    public void k(float f10, boolean z10, int i10) {
        boolean z11;
        int i11;
        float f11;
        float f12;
        float a10 = a(f10);
        boolean g10 = g(i10, 3);
        if (z10 == g10) {
            z11 = true;
        } else {
            z11 = false;
        }
        int width = this.f36780b.getWidth();
        int height = this.f36780b.getHeight();
        float f13 = width;
        if (f13 > 0.0f) {
            float f14 = height;
            if (f14 > 0.0f) {
                float f15 = this.f36804g / f13;
                float f16 = this.f36805h / f13;
                float f17 = this.f36806i / f14;
                V v10 = this.f36780b;
                if (g10) {
                    f13 = 0.0f;
                }
                v10.setPivotX(f13);
                if (!z11) {
                    f16 = -f15;
                }
                float a11 = C1001b.a(0.0f, f16, a10);
                float f18 = a11 + 1.0f;
                this.f36780b.setScaleX(f18);
                float a12 = 1.0f - C1001b.a(0.0f, f17, a10);
                this.f36780b.setScaleY(a12);
                V v11 = this.f36780b;
                if (v11 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) v11;
                    for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                        View childAt = viewGroup.getChildAt(i12);
                        if (g10) {
                            i11 = (width - childAt.getRight()) + childAt.getWidth();
                        } else {
                            i11 = -childAt.getLeft();
                        }
                        childAt.setPivotX(i11);
                        childAt.setPivotY(-childAt.getTop());
                        if (z11) {
                            f11 = 1.0f - a11;
                        } else {
                            f11 = 1.0f;
                        }
                        if (a12 != 0.0f) {
                            f12 = (f18 / a12) * f11;
                        } else {
                            f12 = 1.0f;
                        }
                        childAt.setScaleX(f11);
                        childAt.setScaleY(f12);
                    }
                }
            }
        }
    }

    public void l(androidx.activity.b bVar, int i10) {
        boolean z10;
        if (super.e(bVar) == null) {
            return;
        }
        if (bVar.b() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        k(bVar.a(), z10, i10);
    }
}
