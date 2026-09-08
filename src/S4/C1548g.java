package s4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ViewUtils;
import e4.C0979e;
import f4.C1001b;

/* compiled from: MaterialMainContainerBackHelper.java */
/* renamed from: s4.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1548g extends AbstractC1542a<View> {

    /* renamed from: g, reason: collision with root package name */
    public final float f36796g;

    /* renamed from: h, reason: collision with root package name */
    public final float f36797h;

    /* renamed from: i, reason: collision with root package name */
    public float f36798i;

    /* renamed from: j, reason: collision with root package name */
    public Rect f36799j;

    /* renamed from: k, reason: collision with root package name */
    public Rect f36800k;

    /* renamed from: l, reason: collision with root package name */
    public Integer f36801l;

    /* compiled from: MaterialMainContainerBackHelper.java */
    /* renamed from: s4.g$a */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f36802a;

        public a(View view) {
            this.f36802a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f36802a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public C1548g(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f36796g = resources.getDimension(C0979e.f30812u);
        this.f36797h = resources.getDimension(C0979e.f30810t);
    }

    public static /* synthetic */ void q(ClippableRoundedCornerLayout clippableRoundedCornerLayout, ValueAnimator valueAnimator) {
        clippableRoundedCornerLayout.updateCornerRadius(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void g(View view) {
        if (super.b() == null) {
            return;
        }
        AnimatorSet i10 = i(view);
        V v10 = this.f36780b;
        if (v10 instanceof ClippableRoundedCornerLayout) {
            i10.playTogether(h((ClippableRoundedCornerLayout) v10));
        }
        i10.setDuration(this.f36783e);
        i10.start();
        r();
    }

    public final ValueAnimator h(final ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), k());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: s4.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                C1548g.q(ClippableRoundedCornerLayout.this, valueAnimator);
            }
        });
        return ofFloat;
    }

    public final AnimatorSet i(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.f36780b, (Property<V, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new a(view));
        return animatorSet;
    }

    public void j(long j10, View view) {
        AnimatorSet i10 = i(view);
        i10.setDuration(j10);
        i10.start();
        r();
    }

    public int k() {
        int i10;
        if (this.f36801l == null) {
            if (p()) {
                i10 = n();
            } else {
                i10 = 0;
            }
            this.f36801l = Integer.valueOf(i10);
        }
        return this.f36801l.intValue();
    }

    public Rect l() {
        return this.f36800k;
    }

    public Rect m() {
        return this.f36799j;
    }

    public final int n() {
        WindowInsets rootWindowInsets = this.f36780b.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return 0;
        }
        return Math.max(Math.max(o(rootWindowInsets, 0), o(rootWindowInsets, 1)), Math.max(o(rootWindowInsets, 3), o(rootWindowInsets, 2)));
    }

    public final int o(WindowInsets windowInsets, int i10) {
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(i10);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return 0;
    }

    public final boolean p() {
        int[] iArr = new int[2];
        this.f36780b.getLocationOnScreen(iArr);
        if (iArr[1] == 0) {
            return true;
        }
        return false;
    }

    public final void r() {
        this.f36798i = 0.0f;
        this.f36799j = null;
        this.f36800k = null;
    }

    public void s(float f10, View view) {
        this.f36799j = ViewUtils.calculateRectFromBounds(this.f36780b);
        if (view != null) {
            this.f36800k = ViewUtils.calculateOffsetRectFromBounds(this.f36780b, view);
        }
        this.f36798i = f10;
    }

    public void t(androidx.activity.b bVar, View view) {
        super.d(bVar);
        s(bVar.c(), view);
    }

    public void u(float f10, boolean z10, float f11, float f12) {
        int i10;
        float a10 = a(f10);
        float width = this.f36780b.getWidth();
        float height = this.f36780b.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float a11 = C1001b.a(1.0f, 0.9f, a10);
            float a12 = C1001b.a(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - this.f36796g), a10);
            if (z10) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            float f13 = a12 * i10;
            float min = Math.min(Math.max(0.0f, ((height - (a11 * height)) / 2.0f) - this.f36796g), this.f36797h);
            float f14 = f11 - this.f36798i;
            float a13 = C1001b.a(0.0f, min, Math.abs(f14) / height) * Math.signum(f14);
            this.f36780b.setScaleX(a11);
            this.f36780b.setScaleY(a11);
            this.f36780b.setTranslationX(f13);
            this.f36780b.setTranslationY(a13);
            V v10 = this.f36780b;
            if (v10 instanceof ClippableRoundedCornerLayout) {
                ((ClippableRoundedCornerLayout) v10).updateCornerRadius(C1001b.a(k(), f12, a10));
            }
        }
    }

    public void v(androidx.activity.b bVar, View view, float f10) {
        boolean z10;
        if (super.e(bVar) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        if (bVar.b() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        u(bVar.a(), z10, bVar.c(), f10);
    }
}
