package com.android.contacts.framework.baseui.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.coui.appcompat.animation.COUIEaseInterpolator;

/* compiled from: TitleAlphaAnimateHelper.kt */
/* loaded from: classes.dex */
public final class D {

    /* renamed from: f, reason: collision with root package name */
    public static final a f15842f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public int f15844b;

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f15845c;

    /* renamed from: a, reason: collision with root package name */
    public final PathInterpolator f15843a = new COUIEaseInterpolator();

    /* renamed from: d, reason: collision with root package name */
    public final float f15846d = 0.75f;

    /* renamed from: e, reason: collision with root package name */
    public final float f15847e = b();

    /* compiled from: TitleAlphaAnimateHelper.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: TitleAlphaAnimateHelper.kt */
    /* loaded from: classes.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15848a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ D f15849b;

        public b(boolean z10, D d10) {
            this.f15848a = z10;
            this.f15849b = d10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            super.onAnimationEnd(animation);
            this.f15849b.f15844b = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.i.f(animation, "animation");
            super.onAnimationStart(animation);
            if (this.f15848a) {
                this.f15849b.f15844b = 1;
            } else {
                this.f15849b.f15844b = 2;
            }
        }
    }

    public final float b() {
        float f10 = this.f15846d;
        return f10 + ((1 - f10) * 0.5f);
    }

    public final void c(float f10, TextView textView) {
        if (textView == null) {
            H7.b.i("TitleAlphaAnimateHelper", "showTitleAnimation, textView is null");
        } else {
            if (Math.abs(this.f15846d - f10) < 0.005f) {
                return;
            }
            if (f10 < this.f15847e) {
                d(false, textView);
            } else {
                d(true, textView);
            }
        }
    }

    public final void d(boolean z10, TextView textView) {
        float f10;
        long j10;
        ObjectAnimator objectAnimator;
        Float f11 = null;
        float f12 = 0.0f;
        if (z10) {
            if (textView != null) {
                f11 = Float.valueOf(textView.getAlpha());
            }
            if (kotlin.jvm.internal.i.a(f11, 1.0f)) {
                return;
            }
        } else {
            if (textView != null) {
                f11 = Float.valueOf(textView.getAlpha());
            }
            if (kotlin.jvm.internal.i.a(f11, 0.0f)) {
                return;
            }
        }
        ObjectAnimator objectAnimator2 = this.f15845c;
        if (objectAnimator2 != null && objectAnimator2.isRunning() && z10 && this.f15844b == 1) {
            if (H7.a.b()) {
                H7.b.b("TitleAlphaAnimateHelper", "same " + this.f15844b + " is running");
                return;
            }
            return;
        }
        ObjectAnimator objectAnimator3 = this.f15845c;
        if (objectAnimator3 != null && objectAnimator3.isRunning() && !z10 && this.f15844b == 2) {
            if (H7.a.b()) {
                H7.b.b("TitleAlphaAnimateHelper", "same " + this.f15844b + " is running");
                return;
            }
            return;
        }
        ObjectAnimator objectAnimator4 = this.f15845c;
        if (objectAnimator4 != null && objectAnimator4.isRunning() && (objectAnimator = this.f15845c) != null) {
            objectAnimator.cancel();
        }
        if (z10) {
            f10 = 0.0f;
        } else {
            f10 = 1.0f;
        }
        if (z10) {
            f12 = 1.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "alpha", f10, f12);
        this.f15845c = ofFloat;
        if (ofFloat != null) {
            if (z10) {
                j10 = 200;
            } else {
                j10 = 150;
            }
            ofFloat.setDuration(j10);
            ofFloat.setInterpolator(this.f15843a);
            ofFloat.addListener(new b(z10, this));
            ofFloat.start();
        }
    }
}
