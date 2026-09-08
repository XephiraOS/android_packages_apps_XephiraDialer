package r6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.animation.PathInterpolator;
import android.widget.TextView;

/* compiled from: FadeInOutText.kt */
/* loaded from: classes3.dex */
public final class y {

    /* renamed from: i, reason: collision with root package name */
    public static final a f36522i = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final TextView f36523a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f36524b;

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f36525c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f36526d;

    /* renamed from: e, reason: collision with root package name */
    public ObjectAnimator f36527e;

    /* renamed from: f, reason: collision with root package name */
    public ObjectAnimator f36528f;

    /* renamed from: g, reason: collision with root package name */
    public AnimatorSet f36529g;

    /* renamed from: h, reason: collision with root package name */
    public AnimatorSet f36530h;

    /* compiled from: FadeInOutText.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: FadeInOutText.kt */
    /* loaded from: classes3.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            onAnimationEnd(animation);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            y.this.e(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            y.this.f36523a.setVisibility(0);
            y.this.f36524b.setVisibility(0);
        }
    }

    /* compiled from: FadeInOutText.kt */
    /* loaded from: classes3.dex */
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            onAnimationEnd(animation);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            y.this.e(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            y.this.f36523a.setVisibility(0);
            y.this.f36524b.setVisibility(0);
        }
    }

    public y(TextView textViewA, TextView textViewB) {
        kotlin.jvm.internal.i.f(textViewA, "textViewA");
        kotlin.jvm.internal.i.f(textViewB, "textViewB");
        this.f36523a = textViewA;
        this.f36524b = textViewB;
        c();
    }

    public final void c() {
        PathInterpolator pathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f36523a, "alpha", 1.0f, 0.0f);
        kotlin.jvm.internal.i.e(ofFloat, "ofFloat(textViewA, \"alpha\", 1f, 0f)");
        this.f36526d = ofFloat;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f36524b, "alpha", 0.0f, 1.0f);
        kotlin.jvm.internal.i.e(ofFloat2, "ofFloat(textViewB, \"alpha\", 0f, 1f)");
        this.f36527e = ofFloat2;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator = this.f36526d;
        ObjectAnimator objectAnimator2 = null;
        if (objectAnimator == null) {
            kotlin.jvm.internal.i.q("fadeOutAlphaA");
            objectAnimator = null;
        }
        ObjectAnimator objectAnimator3 = this.f36527e;
        if (objectAnimator3 == null) {
            kotlin.jvm.internal.i.q("fadeInAlphaB");
            objectAnimator3 = null;
        }
        animatorSet.playTogether(objectAnimator, objectAnimator3);
        animatorSet.setInterpolator(pathInterpolator);
        animatorSet.setDuration(200L);
        animatorSet.addListener(new b());
        this.f36529g = animatorSet;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f36523a, "alpha", 0.0f, 1.0f);
        kotlin.jvm.internal.i.e(ofFloat3, "ofFloat(textViewA, \"alpha\", 0f, 1f)");
        this.f36525c = ofFloat3;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f36524b, "alpha", 1.0f, 0.0f);
        kotlin.jvm.internal.i.e(ofFloat4, "ofFloat(textViewB, \"alpha\", 1f, 0f)");
        this.f36528f = ofFloat4;
        AnimatorSet animatorSet2 = new AnimatorSet();
        ObjectAnimator objectAnimator4 = this.f36528f;
        if (objectAnimator4 == null) {
            kotlin.jvm.internal.i.q("fadeOutAlphaB");
            objectAnimator4 = null;
        }
        ObjectAnimator objectAnimator5 = this.f36525c;
        if (objectAnimator5 == null) {
            kotlin.jvm.internal.i.q("fadeInAlphaA");
        } else {
            objectAnimator2 = objectAnimator5;
        }
        animatorSet2.playTogether(objectAnimator4, objectAnimator2);
        animatorSet2.setInterpolator(pathInterpolator);
        animatorSet2.setDuration(200L);
        animatorSet2.addListener(new c());
        this.f36530h = animatorSet2;
    }

    public final void d(boolean z10) {
        AnimatorSet animatorSet = this.f36529g;
        AnimatorSet animatorSet2 = null;
        if (animatorSet == null) {
            kotlin.jvm.internal.i.q("fadeAlphaSetEnter");
            animatorSet = null;
        }
        boolean isRunning = animatorSet.isRunning();
        AnimatorSet animatorSet3 = this.f36530h;
        if (animatorSet3 == null) {
            kotlin.jvm.internal.i.q("fadeAlphaSetExit");
            animatorSet3 = null;
        }
        Log.d("FadeInOutText", "isEnter = " + z10 + ", Running[" + isRunning + ", " + animatorSet3.isRunning() + "], code[" + hashCode() + "]");
        if (z10) {
            AnimatorSet animatorSet4 = this.f36529g;
            if (animatorSet4 == null) {
                kotlin.jvm.internal.i.q("fadeAlphaSetEnter");
                animatorSet4 = null;
            }
            if (!animatorSet4.isRunning()) {
                AnimatorSet animatorSet5 = this.f36529g;
                if (animatorSet5 == null) {
                    kotlin.jvm.internal.i.q("fadeAlphaSetEnter");
                } else {
                    animatorSet2 = animatorSet5;
                }
                animatorSet2.start();
                return;
            }
            return;
        }
        AnimatorSet animatorSet6 = this.f36530h;
        if (animatorSet6 == null) {
            kotlin.jvm.internal.i.q("fadeAlphaSetExit");
            animatorSet6 = null;
        }
        if (!animatorSet6.isRunning()) {
            AnimatorSet animatorSet7 = this.f36530h;
            if (animatorSet7 == null) {
                kotlin.jvm.internal.i.q("fadeAlphaSetExit");
            } else {
                animatorSet2 = animatorSet7;
            }
            animatorSet2.start();
        }
    }

    public final void e(boolean z10) {
        if (z10) {
            this.f36523a.setAlpha(0.0f);
            this.f36523a.setVisibility(4);
            this.f36524b.setAlpha(1.0f);
            this.f36524b.setVisibility(0);
            return;
        }
        this.f36524b.setAlpha(0.0f);
        this.f36524b.setVisibility(4);
        this.f36523a.setAlpha(1.0f);
        this.f36523a.setVisibility(0);
    }
}
