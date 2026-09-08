package com.google.android.material.textfield;

import J.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.K;
import com.google.android.material.internal.CheckableImageButton;
import e4.C0977c;
import f4.C1001b;
import s4.C1550i;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes3.dex */
public class p extends s {

    /* renamed from: s, reason: collision with root package name */
    public static final boolean f24082s = true;

    /* renamed from: e, reason: collision with root package name */
    public final int f24083e;

    /* renamed from: f, reason: collision with root package name */
    public final int f24084f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f24085g;

    /* renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f24086h;

    /* renamed from: i, reason: collision with root package name */
    public final View.OnClickListener f24087i;

    /* renamed from: j, reason: collision with root package name */
    public final View.OnFocusChangeListener f24088j;

    /* renamed from: k, reason: collision with root package name */
    public final c.a f24089k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f24090l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f24091m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f24092n;

    /* renamed from: o, reason: collision with root package name */
    public long f24093o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f24094p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f24095q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f24096r;

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.r();
            p.this.f24096r.start();
        }
    }

    public p(r rVar) {
        super(rVar);
        this.f24087i = new View.OnClickListener() { // from class: com.google.android.material.textfield.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.this.J(view);
            }
        };
        this.f24088j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                p.this.K(view, z10);
            }
        };
        this.f24089k = new c.a() { // from class: com.google.android.material.textfield.n
            @Override // J.c.a
            public final void onTouchExplorationStateChanged(boolean z10) {
                p.this.L(z10);
            }
        };
        this.f24093o = Long.MAX_VALUE;
        Context context = rVar.getContext();
        int i10 = C0977c.f30654Z;
        this.f24084f = C1550i.f(context, i10, 67);
        this.f24083e = C1550i.f(rVar.getContext(), i10, 50);
        this.f24085g = C1550i.g(rVar.getContext(), C0977c.f30664e0, C1001b.f31702a);
    }

    public static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private void F() {
        this.f24096r = E(this.f24084f, 0.0f, 1.0f);
        ValueAnimator E10 = E(this.f24083e, 1.0f, 0.0f);
        this.f24095q = E10;
        E10.addListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z10) {
        this.f24090l = z10;
        r();
        if (!z10) {
            O(false);
            this.f24091m = false;
        }
    }

    public final ValueAnimator E(int i10, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(this.f24085g);
        ofFloat.setDuration(i10);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                p.this.I(valueAnimator);
            }
        });
        return ofFloat;
    }

    public final boolean G() {
        long currentTimeMillis = System.currentTimeMillis() - this.f24093o;
        if (currentTimeMillis >= 0 && currentTimeMillis <= 300) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ void H() {
        boolean isPopupShowing = this.f24086h.isPopupShowing();
        O(isPopupShowing);
        this.f24091m = isPopupShowing;
    }

    public final /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f24131d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public final /* synthetic */ void L(boolean z10) {
        int i10;
        AutoCompleteTextView autoCompleteTextView = this.f24086h;
        if (autoCompleteTextView != null && !q.a(autoCompleteTextView)) {
            CheckableImageButton checkableImageButton = this.f24131d;
            if (z10) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            K.t0(checkableImageButton, i10);
        }
    }

    public final /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f24091m = false;
            }
            Q();
            R();
        }
        return false;
    }

    public final /* synthetic */ void N() {
        R();
        O(false);
    }

    public final void O(boolean z10) {
        if (this.f24092n != z10) {
            this.f24092n = z10;
            this.f24096r.cancel();
            this.f24095q.start();
        }
    }

    public final void P() {
        this.f24086h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean M10;
                M10 = p.this.M(view, motionEvent);
                return M10;
            }
        });
        if (f24082s) {
            this.f24086h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.k
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    p.this.N();
                }
            });
        }
        this.f24086h.setThreshold(0);
    }

    public final void Q() {
        if (this.f24086h == null) {
            return;
        }
        if (G()) {
            this.f24091m = false;
        }
        if (!this.f24091m) {
            if (f24082s) {
                O(!this.f24092n);
            } else {
                this.f24092n = !this.f24092n;
                r();
            }
            if (this.f24092n) {
                this.f24086h.requestFocus();
                this.f24086h.showDropDown();
                return;
            } else {
                this.f24086h.dismissDropDown();
                return;
            }
        }
        this.f24091m = false;
    }

    public final void R() {
        this.f24091m = true;
        this.f24093o = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f24094p.isTouchExplorationEnabled() && q.a(this.f24086h) && !this.f24131d.hasFocus()) {
            this.f24086h.dismissDropDown();
        }
        this.f24086h.post(new Runnable() { // from class: com.google.android.material.textfield.o
            @Override // java.lang.Runnable
            public final void run() {
                p.this.H();
            }
        });
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return e4.k.f30982j;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        if (f24082s) {
            return e4.f.f30833j;
        }
        return e4.f.f30834k;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f24088j;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f24087i;
    }

    @Override // com.google.android.material.textfield.s
    public c.a h() {
        return this.f24089k;
    }

    @Override // com.google.android.material.textfield.s
    public boolean i(int i10) {
        if (i10 != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.s
    public boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean k() {
        return this.f24090l;
    }

    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return this.f24092n;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f24086h = D(editText);
        P();
        this.f24128a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.f24094p.isTouchExplorationEnabled()) {
            K.t0(this.f24131d, 2);
        }
        this.f24128a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.s
    public void o(View view, J.d dVar) {
        if (!q.a(this.f24086h)) {
            dVar.h0(Spinner.class.getName());
        }
        if (dVar.S()) {
            dVar.s0(null);
        }
    }

    @Override // com.google.android.material.textfield.s
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        boolean z10;
        if (this.f24094p.isEnabled() && !q.a(this.f24086h)) {
            if ((accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f24092n && !this.f24086h.isPopupShowing()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (accessibilityEvent.getEventType() == 1 || z10) {
                Q();
                R();
            }
        }
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        F();
        this.f24094p = (AccessibilityManager) this.f24130c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.s
    public boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f24086h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f24082s) {
                this.f24086h.setOnDismissListener(null);
            }
        }
    }
}
