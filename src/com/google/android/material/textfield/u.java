package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.K;
import e4.C0977c;
import e4.C0979e;
import f4.C1001b;
import f4.C1002c;
import java.util.ArrayList;
import java.util.List;
import s4.C1550i;
import u4.C1607c;

/* compiled from: IndicatorViewController.java */
/* loaded from: classes3.dex */
public final class u {

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f24132A;

    /* renamed from: B, reason: collision with root package name */
    public Typeface f24133B;

    /* renamed from: a, reason: collision with root package name */
    public final int f24134a;

    /* renamed from: b, reason: collision with root package name */
    public final int f24135b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24136c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f24137d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f24138e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f24139f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f24140g;

    /* renamed from: h, reason: collision with root package name */
    public final TextInputLayout f24141h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f24142i;

    /* renamed from: j, reason: collision with root package name */
    public int f24143j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f24144k;

    /* renamed from: l, reason: collision with root package name */
    public Animator f24145l;

    /* renamed from: m, reason: collision with root package name */
    public final float f24146m;

    /* renamed from: n, reason: collision with root package name */
    public int f24147n;

    /* renamed from: o, reason: collision with root package name */
    public int f24148o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f24149p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f24150q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f24151r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f24152s;

    /* renamed from: t, reason: collision with root package name */
    public int f24153t;

    /* renamed from: u, reason: collision with root package name */
    public int f24154u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f24155v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f24156w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f24157x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f24158y;

    /* renamed from: z, reason: collision with root package name */
    public int f24159z;

    /* compiled from: IndicatorViewController.java */
    /* loaded from: classes3.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f24160a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f24161b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f24162c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f24163d;

        public a(int i10, TextView textView, int i11, TextView textView2) {
            this.f24160a = i10;
            this.f24161b = textView;
            this.f24162c = i11;
            this.f24163d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u.this.f24147n = this.f24160a;
            u.this.f24145l = null;
            TextView textView = this.f24161b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f24162c == 1 && u.this.f24151r != null) {
                    u.this.f24151r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f24163d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f24163d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f24163d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f24163d.setAlpha(0.0f);
            }
        }
    }

    /* compiled from: IndicatorViewController.java */
    /* loaded from: classes3.dex */
    public class b extends View.AccessibilityDelegate {
        public b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = u.this.f24141h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public u(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f24140g = context;
        this.f24141h = textInputLayout;
        this.f24146m = context.getResources().getDimensionPixelSize(C0979e.f30804q);
        int i10 = C0977c.f30656a0;
        this.f24134a = C1550i.f(context, i10, 217);
        this.f24135b = C1550i.f(context, C0977c.f30651W, 167);
        this.f24136c = C1550i.f(context, i10, 167);
        int i11 = C0977c.f30660c0;
        this.f24137d = C1550i.g(context, i11, C1001b.f31705d);
        TimeInterpolator timeInterpolator = C1001b.f31702a;
        this.f24138e = C1550i.g(context, i11, timeInterpolator);
        this.f24139f = C1550i.g(context, C0977c.f30664e0, timeInterpolator);
    }

    public boolean A() {
        return this.f24150q;
    }

    public boolean B() {
        return this.f24157x;
    }

    public void C(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f24142i == null) {
            return;
        }
        if (z(i10) && (frameLayout = this.f24144k) != null) {
            frameLayout.removeView(textView);
        } else {
            this.f24142i.removeView(textView);
        }
        int i11 = this.f24143j - 1;
        this.f24143j = i11;
        O(this.f24142i, i11);
    }

    public final void D(int i10, int i11) {
        TextView m10;
        TextView m11;
        if (i10 == i11) {
            return;
        }
        if (i11 != 0 && (m11 = m(i11)) != null) {
            m11.setVisibility(0);
            m11.setAlpha(1.0f);
        }
        if (i10 != 0 && (m10 = m(i10)) != null) {
            m10.setVisibility(4);
            if (i10 == 1) {
                m10.setText((CharSequence) null);
            }
        }
        this.f24147n = i11;
    }

    public void E(int i10) {
        this.f24153t = i10;
        TextView textView = this.f24151r;
        if (textView != null) {
            K.l0(textView, i10);
        }
    }

    public void F(CharSequence charSequence) {
        this.f24152s = charSequence;
        TextView textView = this.f24151r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void G(boolean z10) {
        if (this.f24150q == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f24140g);
            this.f24151r = appCompatTextView;
            appCompatTextView.setId(e4.g.f30893o0);
            this.f24151r.setTextAlignment(5);
            Typeface typeface = this.f24133B;
            if (typeface != null) {
                this.f24151r.setTypeface(typeface);
            }
            H(this.f24154u);
            I(this.f24155v);
            F(this.f24152s);
            E(this.f24153t);
            this.f24151r.setVisibility(4);
            e(this.f24151r, 0);
        } else {
            w();
            C(this.f24151r, 0);
            this.f24151r = null;
            this.f24141h.p0();
            this.f24141h.A0();
        }
        this.f24150q = z10;
    }

    public void H(int i10) {
        this.f24154u = i10;
        TextView textView = this.f24151r;
        if (textView != null) {
            this.f24141h.c0(textView, i10);
        }
    }

    public void I(ColorStateList colorStateList) {
        this.f24155v = colorStateList;
        TextView textView = this.f24151r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void J(int i10) {
        this.f24159z = i10;
        TextView textView = this.f24158y;
        if (textView != null) {
            androidx.core.widget.k.p(textView, i10);
        }
    }

    public void K(boolean z10) {
        if (this.f24157x == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f24140g);
            this.f24158y = appCompatTextView;
            appCompatTextView.setId(e4.g.f30895p0);
            this.f24158y.setTextAlignment(5);
            Typeface typeface = this.f24133B;
            if (typeface != null) {
                this.f24158y.setTypeface(typeface);
            }
            this.f24158y.setVisibility(4);
            K.l0(this.f24158y, 1);
            J(this.f24159z);
            L(this.f24132A);
            e(this.f24158y, 1);
            this.f24158y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f24158y, 1);
            this.f24158y = null;
            this.f24141h.p0();
            this.f24141h.A0();
        }
        this.f24157x = z10;
    }

    public void L(ColorStateList colorStateList) {
        this.f24132A = colorStateList;
        TextView textView = this.f24158y;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void N(Typeface typeface) {
        if (typeface != this.f24133B) {
            this.f24133B = typeface;
            M(this.f24151r, typeface);
            M(this.f24158y, typeface);
        }
    }

    public final void O(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean P(TextView textView, CharSequence charSequence) {
        if (K.O(this.f24141h) && this.f24141h.isEnabled() && (this.f24148o != this.f24147n || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    public void Q(CharSequence charSequence) {
        h();
        this.f24149p = charSequence;
        this.f24151r.setText(charSequence);
        int i10 = this.f24147n;
        if (i10 != 1) {
            this.f24148o = 1;
        }
        S(i10, this.f24148o, P(this.f24151r, charSequence));
    }

    public void R(CharSequence charSequence) {
        h();
        this.f24156w = charSequence;
        this.f24158y.setText(charSequence);
        int i10 = this.f24147n;
        if (i10 != 2) {
            this.f24148o = 2;
        }
        S(i10, this.f24148o, P(this.f24158y, charSequence));
    }

    public final void S(int i10, int i11, boolean z10) {
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f24145l = animatorSet;
            ArrayList arrayList = new ArrayList();
            i(arrayList, this.f24157x, this.f24158y, 2, i10, i11);
            i(arrayList, this.f24150q, this.f24151r, 1, i10, i11);
            C1002c.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i11, m(i10), i10, m(i11)));
            animatorSet.start();
        } else {
            D(i10, i11);
        }
        this.f24141h.p0();
        this.f24141h.u0(z10);
        this.f24141h.A0();
    }

    public void e(TextView textView, int i10) {
        if (this.f24142i == null && this.f24144k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f24140g);
            this.f24142i = linearLayout;
            linearLayout.setOrientation(0);
            this.f24141h.addView(this.f24142i, -1, -2);
            this.f24144k = new FrameLayout(this.f24140g);
            this.f24142i.addView(this.f24144k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f24141h.getEditText() != null) {
                f();
            }
        }
        if (z(i10)) {
            this.f24144k.setVisibility(0);
            this.f24144k.addView(textView);
        } else {
            this.f24142i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f24142i.setVisibility(0);
        this.f24143j++;
    }

    public void f() {
        if (g()) {
            EditText editText = this.f24141h.getEditText();
            boolean j10 = C1607c.j(this.f24140g);
            LinearLayout linearLayout = this.f24142i;
            int i10 = C0979e.f30775b0;
            K.A0(linearLayout, v(j10, i10, K.A(editText)), v(j10, C0979e.f30777c0, this.f24140g.getResources().getDimensionPixelSize(C0979e.f30773a0)), v(j10, i10, K.z(editText)), 0);
        }
    }

    public final boolean g() {
        if (this.f24142i != null && this.f24141h.getEditText() != null) {
            return true;
        }
        return false;
    }

    public void h() {
        Animator animator = this.f24145l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void i(List<Animator> list, boolean z10, TextView textView, int i10, int i11, int i12) {
        boolean z11;
        if (textView != null && z10) {
            if (i10 == i12 || i10 == i11) {
                if (i12 == i10) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                ObjectAnimator j10 = j(textView, z11);
                if (i10 == i12 && i11 != 0) {
                    j10.setStartDelay(this.f24136c);
                }
                list.add(j10);
                if (i12 == i10 && i11 != 0) {
                    ObjectAnimator k10 = k(textView);
                    k10.setStartDelay(this.f24136c);
                    list.add(k10);
                }
            }
        }
    }

    public final ObjectAnimator j(TextView textView, boolean z10) {
        float f10;
        int i10;
        TimeInterpolator timeInterpolator;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, f10);
        if (z10) {
            i10 = this.f24135b;
        } else {
            i10 = this.f24136c;
        }
        ofFloat.setDuration(i10);
        if (z10) {
            timeInterpolator = this.f24138e;
        } else {
            timeInterpolator = this.f24139f;
        }
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    public final ObjectAnimator k(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f24146m, 0.0f);
        ofFloat.setDuration(this.f24134a);
        ofFloat.setInterpolator(this.f24137d);
        return ofFloat;
    }

    public boolean l() {
        return y(this.f24148o);
    }

    public final TextView m(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            return this.f24158y;
        }
        return this.f24151r;
    }

    public int n() {
        return this.f24153t;
    }

    public CharSequence o() {
        return this.f24152s;
    }

    public CharSequence p() {
        return this.f24149p;
    }

    public int q() {
        TextView textView = this.f24151r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public ColorStateList r() {
        TextView textView = this.f24151r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence s() {
        return this.f24156w;
    }

    public View t() {
        return this.f24158y;
    }

    public int u() {
        TextView textView = this.f24158y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int v(boolean z10, int i10, int i11) {
        if (z10) {
            return this.f24140g.getResources().getDimensionPixelSize(i10);
        }
        return i11;
    }

    public void w() {
        this.f24149p = null;
        h();
        if (this.f24147n == 1) {
            if (this.f24157x && !TextUtils.isEmpty(this.f24156w)) {
                this.f24148o = 2;
            } else {
                this.f24148o = 0;
            }
        }
        S(this.f24147n, this.f24148o, P(this.f24151r, ""));
    }

    public void x() {
        h();
        int i10 = this.f24147n;
        if (i10 == 2) {
            this.f24148o = 0;
        }
        S(i10, this.f24148o, P(this.f24158y, ""));
    }

    public final boolean y(int i10) {
        if (i10 == 1 && this.f24151r != null && !TextUtils.isEmpty(this.f24149p)) {
            return true;
        }
        return false;
    }

    public boolean z(int i10) {
        if (i10 == 0 || i10 == 1) {
            return true;
        }
        return false;
    }
}
