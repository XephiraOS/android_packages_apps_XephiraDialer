package com.customize.contacts.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.android.contacts.ContactsApplication;
import com.oplus.dialer.R;

/* compiled from: CustomizeAnimationHelper.java */
/* renamed from: com.customize.contacts.util.y, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class AnimationAnimationListenerC0813y implements Animation.AnimationListener {

    /* renamed from: b, reason: collision with root package name */
    public Animation f22191b;

    /* renamed from: e, reason: collision with root package name */
    public boolean f22194e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f22197h;

    /* renamed from: a, reason: collision with root package name */
    public View f22190a = null;

    /* renamed from: c, reason: collision with root package name */
    public Animation.AnimationListener f22192c = null;

    /* renamed from: d, reason: collision with root package name */
    public String f22193d = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22195f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f22196g = false;

    /* renamed from: i, reason: collision with root package name */
    public long f22198i = 0;

    /* renamed from: j, reason: collision with root package name */
    public long f22199j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f22200k = -1;

    public AnimationAnimationListenerC0813y(Animation animation, boolean z10, View view, boolean z11, long j10) {
        this.f22191b = animation;
        this.f22194e = z11;
        this.f22197h = z10;
        b(j10);
        r(view);
    }

    public static AnimationAnimationListenerC0813y d(Context context, View view, int i10, boolean z10, int i11, boolean z11, long j10) {
        return e(context, view, i10, z10, AnimationUtils.loadAnimation(context, i11), z11, j10);
    }

    public static AnimationAnimationListenerC0813y e(Context context, View view, int i10, boolean z10, Animation animation, boolean z11, long j10) {
        AnimationAnimationListenerC0813y animationAnimationListenerC0813y = new AnimationAnimationListenerC0813y(animation, z11, view, z10, j10);
        animationAnimationListenerC0813y.q(i10);
        return animationAnimationListenerC0813y;
    }

    public static AnimationAnimationListenerC0813y h(View view) {
        if (view != null && view.getVisibility() != 8) {
            AnimationAnimationListenerC0813y m10 = m(view.getContext(), view);
            m10.t(false, new a(view));
            return m10;
        }
        return null;
    }

    public static AnimationAnimationListenerC0813y i(Context context, View view, int i10) {
        if (ContactsApplication.f13094j) {
            return j(context, view, i10);
        }
        return o(context, view, i10);
    }

    public static AnimationAnimationListenerC0813y j(Context context, View view, int i10) {
        return d(context, view, i10, false, R.anim.multiselect_left_enter, true, 0L);
    }

    public static AnimationAnimationListenerC0813y k(Context context, View view, int i10) {
        return d(context, view, i10, false, R.anim.multiselect_left_exit, false, 0L);
    }

    public static AnimationAnimationListenerC0813y l(Context context, View view) {
        return d(context, view, 0, false, R.anim.popupnavi_enter, true, 0L);
    }

    public static AnimationAnimationListenerC0813y m(Context context, View view) {
        return d(context, view, 8, false, R.anim.popupnavi_exit, false, 0L);
    }

    public static AnimationAnimationListenerC0813y n(Context context, View view, int i10) {
        if (ContactsApplication.f13094j) {
            return k(context, view, i10);
        }
        return p(context, view, i10);
    }

    public static AnimationAnimationListenerC0813y o(Context context, View view, int i10) {
        return d(context, view, i10, false, R.anim.multiselect_right_enter, true, 0L);
    }

    public static AnimationAnimationListenerC0813y p(Context context, View view, int i10) {
        return d(context, view, i10, false, R.anim.multiselect_right_exit, false, 0L);
    }

    public static AnimationAnimationListenerC0813y s(View view) {
        if (view == null || view.getVisibility() == 0) {
            return null;
        }
        Context context = view.getContext();
        view.setVisibility(0);
        AnimationAnimationListenerC0813y l10 = l(context, view);
        l10.t(false, null);
        return l10;
    }

    public final void b(long j10) {
        Animation animation = this.f22191b;
        if (animation != null) {
            this.f22199j = animation.getDuration();
        }
        long j11 = this.f22199j + j10;
        this.f22199j = j11;
        if (j11 <= 0) {
            this.f22199j = 1L;
        }
    }

    public void c() {
        View view = this.f22190a;
        if (view != null) {
            view.clearAnimation();
        }
    }

    public final int f() {
        int i10 = this.f22200k;
        if (i10 != -1) {
            return i10;
        }
        if (this.f22197h) {
            return 0;
        }
        return 8;
    }

    public final long g(boolean z10) {
        if (z10) {
            return this.f22198i;
        }
        return 0L;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f22196g = false;
        this.f22190a.setClickable(this.f22195f);
        Animation.AnimationListener animationListener = this.f22192c;
        if (animationListener != null) {
            animationListener.onAnimationEnd(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        Animation.AnimationListener animationListener = this.f22192c;
        if (animationListener != null) {
            animationListener.onAnimationRepeat(animation);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.f22196g = true;
        this.f22195f = this.f22190a.isClickable();
        this.f22190a.setClickable(false);
        Animation.AnimationListener animationListener = this.f22192c;
        if (animationListener != null) {
            animationListener.onAnimationStart(animation);
        }
    }

    public void q(int i10) {
        this.f22200k = i10;
    }

    public final void r(View view) {
        this.f22190a = view;
        if (view != null) {
            this.f22198i = 150L;
        }
    }

    public void t(boolean z10, Animation.AnimationListener animationListener) {
        Animation animation;
        if (this.f22190a != null && (animation = this.f22191b) != null) {
            this.f22196g = false;
            this.f22192c = animationListener;
            animation.setDuration(this.f22199j);
            this.f22191b.setStartOffset(g(z10));
            this.f22191b.setAnimationListener(this);
            this.f22191b.setFillEnabled(true);
            this.f22191b.setFillAfter(this.f22194e);
            this.f22190a.setVisibility(0);
            this.f22190a.startAnimation(this.f22191b);
        }
    }

    public void u(boolean z10, Animation.AnimationListener animationListener, View view) {
        r(view);
        t(z10, animationListener);
    }

    /* compiled from: CustomizeAnimationHelper.java */
    /* renamed from: com.customize.contacts.util.y$a */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f22202b;

        public a(View view) {
            this.f22202b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (H7.a.b()) {
                H7.b.b("CustomizeAnimationHelper", "onAnimationEnd, hide navigationMainView.");
            }
            if (AnimationAnimationListenerC0813y.this.f() == 8) {
                this.f22202b.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
