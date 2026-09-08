package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import e4.C0977c;
import f4.C1001b;
import s4.C1550i;

/* compiled from: ClearTextEndIconDelegate.java */
/* loaded from: classes3.dex */
public class f extends s {

    /* renamed from: e, reason: collision with root package name */
    public final int f24062e;

    /* renamed from: f, reason: collision with root package name */
    public final int f24063f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f24064g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f24065h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f24066i;

    /* renamed from: j, reason: collision with root package name */
    public final View.OnClickListener f24067j;

    /* renamed from: k, reason: collision with root package name */
    public final View.OnFocusChangeListener f24068k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f24069l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f24070m;

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f24129b.a0(true);
        }
    }

    /* compiled from: ClearTextEndIconDelegate.java */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f24129b.a0(false);
        }
    }

    public f(r rVar) {
        super(rVar);
        this.f24067j = new View.OnClickListener() { // from class: com.google.android.material.textfield.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.G(view);
            }
        };
        this.f24068k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                f.this.H(view, z10);
            }
        };
        Context context = rVar.getContext();
        int i10 = C0977c.f30654Z;
        this.f24062e = C1550i.f(context, i10, 100);
        this.f24063f = C1550i.f(rVar.getContext(), i10, 150);
        this.f24064g = C1550i.g(rVar.getContext(), C0977c.f30664e0, C1001b.f31702a);
        this.f24065h = C1550i.g(rVar.getContext(), C0977c.f30662d0, C1001b.f31705d);
    }

    public final void A(boolean z10) {
        boolean z11;
        if (this.f24129b.F() == z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && !this.f24069l.isRunning()) {
            this.f24070m.cancel();
            this.f24069l.start();
            if (z11) {
                this.f24069l.end();
                return;
            }
            return;
        }
        if (!z10) {
            this.f24069l.cancel();
            this.f24070m.start();
            if (z11) {
                this.f24070m.end();
            }
        }
    }

    public final ValueAnimator B(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f24064g);
        ofFloat.setDuration(this.f24062e);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.E(valueAnimator);
            }
        });
        return ofFloat;
    }

    public final ValueAnimator C() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f24065h);
        ofFloat.setDuration(this.f24063f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.F(valueAnimator);
            }
        });
        return ofFloat;
    }

    public final void D() {
        ValueAnimator C10 = C();
        ValueAnimator B10 = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f24069l = animatorSet;
        animatorSet.playTogether(C10, B10);
        this.f24069l.addListener(new a());
        ValueAnimator B11 = B(1.0f, 0.0f);
        this.f24070m = B11;
        B11.addListener(new b());
    }

    public final /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f24131d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public final /* synthetic */ void F(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f24131d.setScaleX(floatValue);
        this.f24131d.setScaleY(floatValue);
    }

    public final /* synthetic */ void G(View view) {
        EditText editText = this.f24066i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    public final /* synthetic */ void H(View view, boolean z10) {
        A(J());
    }

    public final /* synthetic */ void I() {
        A(true);
    }

    public final boolean J() {
        EditText editText = this.f24066i;
        if (editText != null && ((editText.hasFocus() || this.f24131d.hasFocus()) && this.f24066i.getText().length() > 0)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f24129b.w() != null) {
            return;
        }
        A(J());
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return e4.k.f30980h;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return e4.f.f30835l;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f24068k;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f24067j;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener g() {
        return this.f24068k;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f24066i = editText;
        this.f24128a.setEndIconVisible(J());
    }

    @Override // com.google.android.material.textfield.s
    public void q(boolean z10) {
        if (this.f24129b.w() == null) {
            return;
        }
        A(z10);
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        D();
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f24066i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.I();
                }
            });
        }
    }
}
