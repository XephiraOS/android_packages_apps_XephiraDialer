package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class Q {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f9456a;

    /* compiled from: ViewPropertyAnimatorCompat.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ S f9457a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f9458b;

        public a(S s10, View view) {
            this.f9457a = s10;
            this.f9458b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f9457a.a(this.f9458b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9457a.b(this.f9458b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f9457a.c(this.f9458b);
        }
    }

    public Q(View view) {
        this.f9456a = new WeakReference<>(view);
    }

    public Q b(float f10) {
        View view = this.f9456a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void c() {
        View view = this.f9456a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long d() {
        View view = this.f9456a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public Q f(float f10) {
        View view = this.f9456a.get();
        if (view != null) {
            view.animate().rotation(f10);
        }
        return this;
    }

    public Q g(long j10) {
        View view = this.f9456a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public Q h(Interpolator interpolator) {
        View view = this.f9456a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public Q i(S s10) {
        View view = this.f9456a.get();
        if (view != null) {
            j(view, s10);
        }
        return this;
    }

    public final void j(View view, S s10) {
        if (s10 != null) {
            view.animate().setListener(new a(s10, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public Q k(long j10) {
        View view = this.f9456a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public Q l(final U u10) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
        final View view = this.f9456a.get();
        if (view != null) {
            if (u10 != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.P
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        U.this.a(view);
                    }
                };
            } else {
                animatorUpdateListener = null;
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    public void m() {
        View view = this.f9456a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public Q n(float f10) {
        View view = this.f9456a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
