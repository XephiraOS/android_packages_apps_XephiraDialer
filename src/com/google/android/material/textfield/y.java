package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.K;
import androidx.core.view.C0458m;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import e4.C0979e;
import u4.C1607c;

/* compiled from: StartCompoundLayout.java */
/* loaded from: classes3.dex */
public class y extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f24170a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f24171b;

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f24172c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f24173d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f24174e;

    /* renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f24175f;

    /* renamed from: g, reason: collision with root package name */
    public int f24176g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView.ScaleType f24177h;

    /* renamed from: i, reason: collision with root package name */
    public View.OnLongClickListener f24178i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f24179j;

    public y(TextInputLayout textInputLayout, K k10) {
        super(textInputLayout.getContext());
        this.f24170a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(e4.i.f30932l, (ViewGroup) this, false);
        this.f24173d = checkableImageButton;
        t.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f24171b = appCompatTextView;
        j(k10);
        i(k10);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    public void A(J.d dVar) {
        if (this.f24171b.getVisibility() == 0) {
            dVar.t0(this.f24171b);
            dVar.L0(this.f24171b);
        } else {
            dVar.L0(this.f24173d);
        }
    }

    public void B() {
        int A10;
        EditText editText = this.f24170a.f24008d;
        if (editText == null) {
            return;
        }
        if (k()) {
            A10 = 0;
        } else {
            A10 = androidx.core.view.K.A(editText);
        }
        androidx.core.view.K.A0(this.f24171b, A10, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(C0979e.f30779d0), editText.getCompoundPaddingBottom());
    }

    public final void C() {
        int i10;
        int i11 = 8;
        if (this.f24172c != null && !this.f24179j) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        if (this.f24173d.getVisibility() == 0 || i10 == 0) {
            i11 = 0;
        }
        setVisibility(i11);
        this.f24171b.setVisibility(i10);
        this.f24170a.o0();
    }

    public CharSequence a() {
        return this.f24172c;
    }

    public ColorStateList b() {
        return this.f24171b.getTextColors();
    }

    public int c() {
        int i10;
        if (k()) {
            i10 = this.f24173d.getMeasuredWidth() + C0458m.a((ViewGroup.MarginLayoutParams) this.f24173d.getLayoutParams());
        } else {
            i10 = 0;
        }
        return androidx.core.view.K.A(this) + androidx.core.view.K.A(this.f24171b) + i10;
    }

    public TextView d() {
        return this.f24171b;
    }

    public CharSequence e() {
        return this.f24173d.getContentDescription();
    }

    public Drawable f() {
        return this.f24173d.getDrawable();
    }

    public int g() {
        return this.f24176g;
    }

    public ImageView.ScaleType h() {
        return this.f24177h;
    }

    public final void i(K k10) {
        this.f24171b.setVisibility(8);
        this.f24171b.setId(e4.g.f30899r0);
        this.f24171b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        androidx.core.view.K.l0(this.f24171b, 1);
        o(k10.n(e4.m.vc, 0));
        int i10 = e4.m.wc;
        if (k10.s(i10)) {
            p(k10.c(i10));
        }
        n(k10.p(e4.m.uc));
    }

    public final void j(K k10) {
        if (C1607c.j(getContext())) {
            C0458m.c((ViewGroup.MarginLayoutParams) this.f24173d.getLayoutParams(), 0);
        }
        u(null);
        v(null);
        int i10 = e4.m.Cc;
        if (k10.s(i10)) {
            this.f24174e = C1607c.b(getContext(), k10, i10);
        }
        int i11 = e4.m.Dc;
        if (k10.s(i11)) {
            this.f24175f = ViewUtils.parseTintMode(k10.k(i11, -1), null);
        }
        int i12 = e4.m.zc;
        if (k10.s(i12)) {
            s(k10.g(i12));
            int i13 = e4.m.yc;
            if (k10.s(i13)) {
                r(k10.p(i13));
            }
            q(k10.a(e4.m.xc, true));
        }
        t(k10.f(e4.m.Ac, getResources().getDimensionPixelSize(C0979e.f30724A0)));
        int i14 = e4.m.Bc;
        if (k10.s(i14)) {
            w(t.b(k10.k(i14, -1)));
        }
    }

    public boolean k() {
        if (this.f24173d.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void l(boolean z10) {
        this.f24179j = z10;
        C();
    }

    public void m() {
        t.d(this.f24170a, this.f24173d, this.f24174e);
    }

    public void n(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f24172c = charSequence2;
        this.f24171b.setText(charSequence);
        C();
    }

    public void o(int i10) {
        androidx.core.widget.k.p(this.f24171b, i10);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        B();
    }

    public void p(ColorStateList colorStateList) {
        this.f24171b.setTextColor(colorStateList);
    }

    public void q(boolean z10) {
        this.f24173d.setCheckable(z10);
    }

    public void r(CharSequence charSequence) {
        if (e() != charSequence) {
            this.f24173d.setContentDescription(charSequence);
        }
    }

    public void s(Drawable drawable) {
        this.f24173d.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f24170a, this.f24173d, this.f24174e, this.f24175f);
            z(true);
            m();
        } else {
            z(false);
            u(null);
            v(null);
            r(null);
        }
    }

    public void t(int i10) {
        if (i10 >= 0) {
            if (i10 != this.f24176g) {
                this.f24176g = i10;
                t.g(this.f24173d, i10);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    public void u(View.OnClickListener onClickListener) {
        t.h(this.f24173d, onClickListener, this.f24178i);
    }

    public void v(View.OnLongClickListener onLongClickListener) {
        this.f24178i = onLongClickListener;
        t.i(this.f24173d, onLongClickListener);
    }

    public void w(ImageView.ScaleType scaleType) {
        this.f24177h = scaleType;
        t.j(this.f24173d, scaleType);
    }

    public void x(ColorStateList colorStateList) {
        if (this.f24174e != colorStateList) {
            this.f24174e = colorStateList;
            t.a(this.f24170a, this.f24173d, colorStateList, this.f24175f);
        }
    }

    public void y(PorterDuff.Mode mode) {
        if (this.f24175f != mode) {
            this.f24175f = mode;
            t.a(this.f24170a, this.f24173d, this.f24174e, mode);
        }
    }

    public void z(boolean z10) {
        int i10;
        if (k() != z10) {
            CheckableImageButton checkableImageButton = this.f24173d;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            B();
            C();
        }
    }
}
