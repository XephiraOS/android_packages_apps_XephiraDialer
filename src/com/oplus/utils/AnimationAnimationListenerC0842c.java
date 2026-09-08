package com.oplus.utils;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/* compiled from: AnimationHelper.java */
/* renamed from: com.oplus.utils.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class AnimationAnimationListenerC0842c implements Animation.AnimationListener {

    /* renamed from: b, reason: collision with root package name */
    public Animation f29123b;

    /* renamed from: e, reason: collision with root package name */
    public boolean f29126e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f29129h;

    /* renamed from: a, reason: collision with root package name */
    public View f29122a = null;

    /* renamed from: c, reason: collision with root package name */
    public Animation.AnimationListener f29124c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f29125d = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f29127f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f29128g = false;

    /* renamed from: i, reason: collision with root package name */
    public long f29130i = 0;

    /* renamed from: j, reason: collision with root package name */
    public long f29131j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f29132k = -1;

    public AnimationAnimationListenerC0842c(Animation animation, boolean z10, View view, boolean z11, long j10) {
        this.f29123b = animation;
        this.f29126e = z11;
        this.f29129h = z10;
        c(j10);
        p(view);
    }

    public static AnimationAnimationListenerC0842c d(Context context, View view, int i10, boolean z10, int i11, boolean z11, long j10) {
        return e(context, view, i10, z10, AnimationUtils.loadAnimation(context, i11), z11, j10);
    }

    public static AnimationAnimationListenerC0842c e(Context context, View view, int i10, boolean z10, Animation animation, boolean z11, long j10) {
        AnimationAnimationListenerC0842c animationAnimationListenerC0842c = new AnimationAnimationListenerC0842c(animation, z11, view, z10, j10);
        animationAnimationListenerC0842c.o(i10);
        return animationAnimationListenerC0842c;
    }

    public static /* synthetic */ void h(S8.r rVar, ValueAnimator valueAnimator) {
        if (valueAnimator != null && valueAnimator.getAnimatedValue() != null) {
            rVar.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public static /* synthetic */ void i(S8.r rVar, ValueAnimator valueAnimator) {
        if (valueAnimator != null && valueAnimator.getAnimatedValue() != null) {
            rVar.a(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public static AnimationAnimationListenerC0842c j(Context context, View view, int i10) {
        return d(context, view, i10, false, com.oplus.blacklistapp.i.f27259a, true, 0L);
    }

    public static AnimationAnimationListenerC0842c k(Context context, View view, int i10) {
        return d(context, view, i10, false, com.oplus.blacklistapp.i.f27260b, false, 0L);
    }

    public static AnimationAnimationListenerC0842c l(Context context, View view, int i10) {
        return d(context, view, i10, false, com.oplus.blacklistapp.i.f27261c, true, 0L);
    }

    public static AnimationAnimationListenerC0842c m(Context context, View view, int i10) {
        return d(context, view, i10, false, com.oplus.blacklistapp.i.f27262d, false, 0L);
    }

    public final void c(long j10) {
        Animation animation = this.f29123b;
        if (animation != null) {
            this.f29131j = animation.getDuration();
        }
        long j11 = this.f29131j + j10;
        this.f29131j = j11;
        if (j11 <= 0) {
            this.f29131j = 1L;
        }
    }

    public void f(Context context, boolean z10, Animation.AnimationListener animationListener) {
        final S8.r rVar = new S8.r(this.f29122a);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(rVar, "width", C0849j.b(context, 5.0f), C0849j.b(context, 41.0f));
        ofInt.setDuration(this.f29131j);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.utils.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationAnimationListenerC0842c.h(S8.r.this, valueAnimator);
            }
        });
        ofInt.start();
        q(z10, animationListener);
    }

    public final long g(boolean z10) {
        if (z10) {
            return this.f29130i;
        }
        return 0L;
    }

    public void n(Context context, Animation.AnimationListener animationListener) {
        final S8.r rVar = new S8.r(this.f29122a);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(rVar, "width", this.f29122a.getMeasuredWidth(), C0849j.b(context, 5.0f));
        ofInt.setDuration(this.f29131j);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.utils.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimationAnimationListenerC0842c.i(S8.r.this, valueAnimator);
            }
        });
        ofInt.start();
        q(false, animationListener);
    }

    public void o(int i10) {
        this.f29132k = i10;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f29128g = false;
        this.f29122a.setClickable(this.f29127f);
        Animation.AnimationListener animationListener = this.f29124c;
        if (animationListener != null) {
            animationListener.onAnimationEnd(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        Animation.AnimationListener animationListener = this.f29124c;
        if (animationListener != null) {
            animationListener.onAnimationRepeat(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f29128g = true;
        this.f29127f = this.f29122a.isClickable();
        this.f29122a.setClickable(false);
        Animation.AnimationListener animationListener = this.f29124c;
        if (animationListener != null) {
            animationListener.onAnimationStart(animation);
        }
    }

    public final void p(View view) {
        this.f29122a = view;
        if (view != null) {
            this.f29130i = view.getContext().getResources().getInteger(com.oplus.blacklistapp.q.f27428a);
        }
    }

    public void q(boolean z10, Animation.AnimationListener animationListener) {
        if (this.f29122a != null) {
            this.f29128g = false;
            this.f29124c = animationListener;
            this.f29123b.setDuration(this.f29131j);
            this.f29123b.setStartOffset(g(z10));
            this.f29123b.setAnimationListener(this);
            this.f29123b.setFillEnabled(true);
            this.f29123b.setFillAfter(this.f29126e);
            this.f29122a.setVisibility(0);
            this.f29122a.startAnimation(this.f29123b);
        }
    }

    public void r(boolean z10, Animation.AnimationListener animationListener, View view) {
        p(view);
        q(z10, animationListener);
    }
}
