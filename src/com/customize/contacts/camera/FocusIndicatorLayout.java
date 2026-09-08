package com.customize.contacts.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* loaded from: classes3.dex */
public class FocusIndicatorLayout extends View {

    /* renamed from: a, reason: collision with root package name */
    public Runnable f20849a;

    /* renamed from: b, reason: collision with root package name */
    public Runnable f20850b;

    /* renamed from: c, reason: collision with root package name */
    public State f20851c;

    /* loaded from: classes3.dex */
    public enum State {
        STATE_IDLE,
        STATE_FOCUSING,
        STATE_DONE
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            FocusIndicatorLayout.this.setVisibility(4);
            FocusIndicatorLayout.this.f20851c = State.STATE_IDLE;
        }

        public a() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            FocusIndicatorLayout focusIndicatorLayout = FocusIndicatorLayout.this;
            focusIndicatorLayout.postDelayed(focusIndicatorLayout.f20849a, 200L);
        }

        public b() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusIndicatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20849a = new a();
        this.f20850b = new b();
    }

    public void c() {
        animate().cancel();
        removeCallbacks(this.f20849a);
        this.f20849a.run();
        setScaleX(1.0f);
        setScaleY(1.0f);
    }

    public void d(boolean z10) {
        Runnable runnable;
        if (this.f20851c != State.STATE_FOCUSING) {
            return;
        }
        setVisibility(0);
        animate().cancel();
        ViewPropertyAnimator scaleY = animate().withLayer().setDuration(100L).scaleX(0.55f).scaleY(0.55f);
        if (z10) {
            runnable = this.f20850b;
        } else {
            runnable = null;
        }
        scaleY.withEndAction(runnable);
        this.f20851c = State.STATE_DONE;
    }

    public void e() {
        c();
        if (this.f20851c != State.STATE_IDLE) {
            return;
        }
        setVisibility(0);
        animate().cancel();
        animate().withLayer().setDuration(160L).scaleX(0.55f).scaleY(0.55f);
        this.f20851c = State.STATE_FOCUSING;
    }
}
