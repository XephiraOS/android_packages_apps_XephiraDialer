package com.android.incallui.oplus.incomingfloatingwindow.presentation.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.android.incallui.Log;
import com.android.incallui.oplus.incomingfloatingwindow.presentation.view.FloatingWindowView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import q2.C1481a;

/* compiled from: FloatingWindowView.kt */
/* loaded from: classes.dex */
public final class FloatingWindowView extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    public static final a f18946j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public static final PathInterpolator f18947k = new PathInterpolator(0.22f, 0.34f, 0.05f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public boolean f18948a;

    /* renamed from: b, reason: collision with root package name */
    public q2.c f18949b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f18950c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f18951d;

    /* renamed from: e, reason: collision with root package name */
    public final Runnable f18952e;

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f18953f;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f18954g;

    /* renamed from: h, reason: collision with root package name */
    public final b f18955h;

    /* renamed from: i, reason: collision with root package name */
    public final c f18956i;

    /* compiled from: FloatingWindowView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: FloatingWindowView.kt */
    /* loaded from: classes.dex */
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FloatingWindowView.this.f18948a = false;
        }
    }

    /* compiled from: FloatingWindowView.kt */
    /* loaded from: classes.dex */
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            FloatingWindowView floatingWindowView = FloatingWindowView.this;
            floatingWindowView.post(floatingWindowView.f18951d);
            FloatingWindowView.this.f18948a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            FloatingWindowView floatingWindowView = FloatingWindowView.this;
            floatingWindowView.post(floatingWindowView.f18950c);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatingWindowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    private final long getFallBackAnimDuration() {
        return (Math.abs(getTranslationY()) / getHeight()) * ((float) 600);
    }

    private final long getFlingAnimDuration() {
        return Math.abs(((getHeight() - Math.abs(getTranslationY())) / getHeight()) * ((float) 600));
    }

    public static final void i(FloatingWindowView this$0) {
        i.f(this$0, "this$0");
        this$0.q(3);
    }

    public static final void j(FloatingWindowView this$0) {
        i.f(this$0, "this$0");
        this$0.q(2);
    }

    public static final void k(FloatingWindowView this$0) {
        i.f(this$0, "this$0");
        this$0.q(1);
    }

    public static final void l(FloatingWindowView this$0) {
        i.f(this$0, "this$0");
        q2.c cVar = this$0.f18949b;
        if (cVar != null) {
            cVar.m();
        }
    }

    public static final void n(FloatingWindowView this$0) {
        i.f(this$0, "this$0");
        q2.c cVar = this$0.f18949b;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        m(motionEvent);
        return false;
    }

    public final q2.c getUserActionListener() {
        return this.f18949b;
    }

    public final void m(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 1 && action != 3) {
            return;
        }
        float translationY = getTranslationY();
        int height = getHeight() / 2;
        if (translationY < (-height)) {
            post(this.f18952e);
        } else if (translationY > height) {
            post(this.f18953f);
        } else {
            post(this.f18954g);
        }
    }

    public final void o() {
        animate().translationY(getHeight()).setDuration(getFlingAnimDuration()).setInterpolator(f18947k).setListener(this.f18956i).start();
    }

    public final void p() {
        animate().translationY(0.0f).setDuration(getFallBackAnimDuration()).setInterpolator(f18947k).setListener(this.f18955h).start();
    }

    public final void q(int i10) {
        if (this.f18948a) {
            return;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                } else {
                    p();
                }
            } else {
                o();
            }
        } else {
            s();
        }
        this.f18948a = true;
    }

    public final void r(C1481a c1481a) {
        Integer a10;
        Log.d("FloatingWindowView", "startFloatingWindowLayoutAnim: " + c1481a + ' ' + this.f18948a);
        if (c1481a != null && (a10 = c1481a.a()) != null) {
            q(a10.intValue());
        }
    }

    public final void s() {
        animate().translationY(-getHeight()).setDuration(getFlingAnimDuration()).setInterpolator(f18947k).setListener(this.f18956i).start();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        if (this.f18948a) {
            return;
        }
        super.setTranslationY(f10);
    }

    public final void setUserActionListener(q2.c cVar) {
        this.f18949b = cVar;
    }

    public /* synthetic */ FloatingWindowView(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingWindowView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
        this.f18950c = new Runnable() { // from class: v2.b
            @Override // java.lang.Runnable
            public final void run() {
                FloatingWindowView.n(FloatingWindowView.this);
            }
        };
        this.f18951d = new Runnable() { // from class: v2.c
            @Override // java.lang.Runnable
            public final void run() {
                FloatingWindowView.l(FloatingWindowView.this);
            }
        };
        this.f18952e = new Runnable() { // from class: v2.d
            @Override // java.lang.Runnable
            public final void run() {
                FloatingWindowView.k(FloatingWindowView.this);
            }
        };
        this.f18953f = new Runnable() { // from class: v2.e
            @Override // java.lang.Runnable
            public final void run() {
                FloatingWindowView.j(FloatingWindowView.this);
            }
        };
        this.f18954g = new Runnable() { // from class: v2.f
            @Override // java.lang.Runnable
            public final void run() {
                FloatingWindowView.i(FloatingWindowView.this);
            }
        };
        this.f18955h = new b();
        this.f18956i = new c();
    }
}
