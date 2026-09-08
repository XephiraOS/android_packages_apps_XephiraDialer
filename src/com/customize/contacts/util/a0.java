package com.customize.contacts.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageButton;

/* compiled from: SimAnimationController.kt */
/* loaded from: classes3.dex */
public final class a0 {

    /* renamed from: A, reason: collision with root package name */
    public static final a f21995A = new a(null);

    /* renamed from: B, reason: collision with root package name */
    public static final PathInterpolator f21996B = new PathInterpolator(0.4f, 0.0f, 0.6f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public ImageButton f21997a;

    /* renamed from: b, reason: collision with root package name */
    public ImageButton f21998b;

    /* renamed from: c, reason: collision with root package name */
    public ImageButton f21999c;

    /* renamed from: d, reason: collision with root package name */
    public ImageButton f22000d;

    /* renamed from: e, reason: collision with root package name */
    public ImageButton f22001e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f22002f;

    /* renamed from: g, reason: collision with root package name */
    public ObjectAnimator f22003g;

    /* renamed from: h, reason: collision with root package name */
    public ObjectAnimator f22004h;

    /* renamed from: i, reason: collision with root package name */
    public ObjectAnimator f22005i;

    /* renamed from: j, reason: collision with root package name */
    public ObjectAnimator f22006j;

    /* renamed from: k, reason: collision with root package name */
    public ObjectAnimator f22007k;

    /* renamed from: l, reason: collision with root package name */
    public ObjectAnimator f22008l;

    /* renamed from: m, reason: collision with root package name */
    public ObjectAnimator f22009m;

    /* renamed from: n, reason: collision with root package name */
    public ObjectAnimator f22010n;

    /* renamed from: o, reason: collision with root package name */
    public ObjectAnimator f22011o;

    /* renamed from: p, reason: collision with root package name */
    public ObjectAnimator f22012p;

    /* renamed from: q, reason: collision with root package name */
    public ObjectAnimator f22013q;

    /* renamed from: r, reason: collision with root package name */
    public ObjectAnimator f22014r;

    /* renamed from: s, reason: collision with root package name */
    public ObjectAnimator f22015s;

    /* renamed from: t, reason: collision with root package name */
    public ObjectAnimator f22016t;

    /* renamed from: u, reason: collision with root package name */
    public ObjectAnimator f22017u;

    /* renamed from: v, reason: collision with root package name */
    public ObjectAnimator f22018v;

    /* renamed from: w, reason: collision with root package name */
    public ObjectAnimator f22019w;

    /* renamed from: x, reason: collision with root package name */
    public ObjectAnimator f22020x;

    /* renamed from: y, reason: collision with root package name */
    public ObjectAnimator f22021y;

    /* renamed from: z, reason: collision with root package name */
    public ObjectAnimator f22022z;

    /* compiled from: SimAnimationController.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public a0(ImageButton sim1button, ImageButton sim2Button, ImageButton sim1Prompt, ImageButton sim2Prompt, ImageButton switchBg) {
        kotlin.jvm.internal.i.f(sim1button, "sim1button");
        kotlin.jvm.internal.i.f(sim2Button, "sim2Button");
        kotlin.jvm.internal.i.f(sim1Prompt, "sim1Prompt");
        kotlin.jvm.internal.i.f(sim2Prompt, "sim2Prompt");
        kotlin.jvm.internal.i.f(switchBg, "switchBg");
        this.f21997a = sim1button;
        this.f21998b = sim2Button;
        this.f21999c = sim1Prompt;
        this.f22000d = sim2Prompt;
        this.f22001e = switchBg;
    }

    public final void f() {
        ImageButton imageButton = this.f21999c;
        Property property = View.ALPHA;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageButton, (Property<ImageButton, Float>) property, 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        PathInterpolator pathInterpolator = f21996B;
        ofFloat.setInterpolator(pathInterpolator);
        this.f22003g = ofFloat;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21999c, (Property<ImageButton, Float>) property, 1.0f, 0.0f);
        ofFloat2.setDuration(200L);
        ofFloat2.setInterpolator(pathInterpolator);
        this.f22004h = ofFloat2;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f22000d, (Property<ImageButton, Float>) property, 0.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ofFloat3.setInterpolator(pathInterpolator);
        this.f22005i = ofFloat3;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f22000d, (Property<ImageButton, Float>) property, 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        ofFloat4.setInterpolator(pathInterpolator);
        this.f22006j = ofFloat4;
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f21997a, (Property<ImageButton, Float>) property, 0.0f, 1.0f);
        ofFloat5.setDuration(100L);
        ofFloat5.setInterpolator(pathInterpolator);
        this.f22019w = ofFloat5;
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f21997a, (Property<ImageButton, Float>) property, 1.0f, 0.0f);
        ofFloat6.setDuration(200L);
        ofFloat6.setInterpolator(pathInterpolator);
        this.f22020x = ofFloat6;
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f21998b, (Property<ImageButton, Float>) property, 0.0f, 1.0f);
        ofFloat7.setDuration(100L);
        ofFloat7.setInterpolator(pathInterpolator);
        this.f22021y = ofFloat7;
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f21998b, (Property<ImageButton, Float>) property, 1.0f, 0.0f);
        ofFloat8.setDuration(200L);
        ofFloat8.setInterpolator(pathInterpolator);
        this.f22022z = ofFloat8;
        ImageButton imageButton2 = this.f22001e;
        Property property2 = View.SCALE_X;
        this.f22007k = ObjectAnimator.ofFloat(imageButton2, (Property<ImageButton, Float>) property2, 1.0f, 0.9f);
        ImageButton imageButton3 = this.f22001e;
        Property property3 = View.SCALE_Y;
        this.f22009m = ObjectAnimator.ofFloat(imageButton3, (Property<ImageButton, Float>) property3, 1.0f, 0.9f);
        this.f22008l = ObjectAnimator.ofFloat(this.f22001e, (Property<ImageButton, Float>) property2, 0.9f, 1.0f);
        this.f22010n = ObjectAnimator.ofFloat(this.f22001e, (Property<ImageButton, Float>) property3, 0.9f, 1.0f);
        this.f22011o = ObjectAnimator.ofFloat(this.f21999c, (Property<ImageButton, Float>) property2, 1.0f, 0.9f);
        this.f22013q = ObjectAnimator.ofFloat(this.f21999c, (Property<ImageButton, Float>) property3, 1.0f, 0.9f);
        this.f22012p = ObjectAnimator.ofFloat(this.f21999c, (Property<ImageButton, Float>) property2, 0.9f, 1.0f);
        this.f22014r = ObjectAnimator.ofFloat(this.f21999c, (Property<ImageButton, Float>) property3, 0.9f, 1.0f);
        this.f22015s = ObjectAnimator.ofFloat(this.f22000d, (Property<ImageButton, Float>) property2, 1.0f, 0.9f);
        this.f22017u = ObjectAnimator.ofFloat(this.f22000d, (Property<ImageButton, Float>) property3, 1.0f, 0.9f);
        this.f22016t = ObjectAnimator.ofFloat(this.f22000d, (Property<ImageButton, Float>) property2, 0.9f, 1.0f);
        this.f22018v = ObjectAnimator.ofFloat(this.f22000d, (Property<ImageButton, Float>) property3, 0.9f, 1.0f);
    }

    public final boolean g() {
        return this.f22002f;
    }

    public final void h() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(this.f22007k, this.f22009m, this.f22011o, this.f22013q, this.f22015s, this.f22017u);
        animatorSet.start();
    }

    public final void i() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(this.f22008l, this.f22010n, this.f22012p, this.f22014r, this.f22016t, this.f22018v);
        animatorSet.start();
    }

    public final void j() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(this.f22004h, this.f22005i, this.f22008l, this.f22010n, this.f22016t, this.f22018v, this.f22021y, this.f22020x);
        animatorSet.addListener(new b(this));
        ImageButton imageButton = this.f21998b;
        if (imageButton != null) {
            imageButton.setAlpha(0.0f);
        }
        animatorSet.start();
    }

    public final void k() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(this.f22006j, this.f22003g, this.f22008l, this.f22010n, this.f22012p, this.f22014r, this.f22019w, this.f22022z);
        animatorSet.addListener(new c(this));
        ImageButton imageButton = this.f21997a;
        if (imageButton != null) {
            imageButton.setAlpha(0.0f);
        }
        animatorSet.start();
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Animator.AnimatorListener {
        public b(a0 a0Var) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ImageButton imageButton = a0.this.f21999c;
            if (imageButton != null) {
                imageButton.setVisibility(8);
            }
            ImageButton imageButton2 = a0.this.f21997a;
            if (imageButton2 != null) {
                imageButton2.setVisibility(8);
            }
            a0.this.f22002f = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a0.this.f22002f = true;
            ImageButton imageButton = a0.this.f22000d;
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            ImageButton imageButton2 = a0.this.f21998b;
            if (imageButton2 != null) {
                imageButton2.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes3.dex */
    public static final class c implements Animator.AnimatorListener {
        public c(a0 a0Var) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ImageButton imageButton = a0.this.f22000d;
            if (imageButton != null) {
                imageButton.setVisibility(8);
            }
            ImageButton imageButton2 = a0.this.f21998b;
            if (imageButton2 != null) {
                imageButton2.setVisibility(8);
            }
            a0.this.f22002f = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a0.this.f22002f = true;
            ImageButton imageButton = a0.this.f21999c;
            if (imageButton != null) {
                imageButton.setVisibility(0);
            }
            ImageButton imageButton2 = a0.this.f21997a;
            if (imageButton2 != null) {
                imageButton2.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
