package com.google.android.material.textfield;

import J.c;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.K;
import androidx.core.view.C0458m;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import e4.C0979e;
import f.C0991a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import u4.C1607c;

/* compiled from: EndCompoundLayout.java */
/* loaded from: classes3.dex */
public class r extends LinearLayout {

    /* renamed from: A, reason: collision with root package name */
    public final TextWatcher f24098A;

    /* renamed from: B, reason: collision with root package name */
    public final TextInputLayout.f f24099B;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f24100a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f24101b;

    /* renamed from: c, reason: collision with root package name */
    public final CheckableImageButton f24102c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f24103d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f24104e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnLongClickListener f24105f;

    /* renamed from: g, reason: collision with root package name */
    public final CheckableImageButton f24106g;

    /* renamed from: h, reason: collision with root package name */
    public final d f24107h;

    /* renamed from: i, reason: collision with root package name */
    public int f24108i;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashSet<TextInputLayout.g> f24109j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f24110k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f24111l;

    /* renamed from: m, reason: collision with root package name */
    public int f24112m;

    /* renamed from: n, reason: collision with root package name */
    public ImageView.ScaleType f24113n;

    /* renamed from: o, reason: collision with root package name */
    public View.OnLongClickListener f24114o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f24115p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f24116q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f24117r;

    /* renamed from: x, reason: collision with root package name */
    public EditText f24118x;

    /* renamed from: y, reason: collision with root package name */
    public final AccessibilityManager f24119y;

    /* renamed from: z, reason: collision with root package name */
    public c.a f24120z;

    /* compiled from: EndCompoundLayout.java */
    /* loaded from: classes3.dex */
    public class a extends TextWatcherAdapter {
        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            r.this.m().a(editable);
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            r.this.m().b(charSequence, i10, i11, i12);
        }
    }

    /* compiled from: EndCompoundLayout.java */
    /* loaded from: classes3.dex */
    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            if (r.this.f24118x == textInputLayout.getEditText()) {
                return;
            }
            if (r.this.f24118x != null) {
                r.this.f24118x.removeTextChangedListener(r.this.f24098A);
                if (r.this.f24118x.getOnFocusChangeListener() == r.this.m().e()) {
                    r.this.f24118x.setOnFocusChangeListener(null);
                }
            }
            r.this.f24118x = textInputLayout.getEditText();
            if (r.this.f24118x != null) {
                r.this.f24118x.addTextChangedListener(r.this.f24098A);
            }
            r.this.m().n(r.this.f24118x);
            r rVar = r.this;
            rVar.h0(rVar.m());
        }
    }

    /* compiled from: EndCompoundLayout.java */
    /* loaded from: classes3.dex */
    public class c implements View.OnAttachStateChangeListener {
        public c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            r.this.g();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            r.this.M();
        }
    }

    /* compiled from: EndCompoundLayout.java */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final SparseArray<s> f24124a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        public final r f24125b;

        /* renamed from: c, reason: collision with root package name */
        public final int f24126c;

        /* renamed from: d, reason: collision with root package name */
        public final int f24127d;

        public d(r rVar, K k10) {
            this.f24125b = rVar;
            this.f24126c = k10.n(e4.m.Pb, 0);
            this.f24127d = k10.n(e4.m.nc, 0);
        }

        public final s b(int i10) {
            if (i10 != -1) {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 == 3) {
                                return new p(this.f24125b);
                            }
                            throw new IllegalArgumentException("Invalid end icon mode: " + i10);
                        }
                        return new f(this.f24125b);
                    }
                    return new x(this.f24125b, this.f24127d);
                }
                return new v(this.f24125b);
            }
            return new g(this.f24125b);
        }

        public s c(int i10) {
            s sVar = this.f24124a.get(i10);
            if (sVar == null) {
                s b10 = b(i10);
                this.f24124a.append(i10, b10);
                return b10;
            }
            return sVar;
        }
    }

    public r(TextInputLayout textInputLayout, K k10) {
        super(textInputLayout.getContext());
        this.f24108i = 0;
        this.f24109j = new LinkedHashSet<>();
        this.f24098A = new a();
        b bVar = new b();
        this.f24099B = bVar;
        this.f24119y = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f24100a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f24101b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton i10 = i(this, from, e4.g.f30889m0);
        this.f24102c = i10;
        CheckableImageButton i11 = i(frameLayout, from, e4.g.f30887l0);
        this.f24106g = i11;
        this.f24107h = new d(this, k10);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f24116q = appCompatTextView;
        C(k10);
        B(k10);
        D(k10);
        frameLayout.addView(i11);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(i10);
        textInputLayout.i(bVar);
        addOnAttachStateChangeListener(new c());
    }

    public boolean A() {
        if (this.f24108i != 0) {
            return true;
        }
        return false;
    }

    public final void B(K k10) {
        int i10 = e4.m.oc;
        if (!k10.s(i10)) {
            int i11 = e4.m.Tb;
            if (k10.s(i11)) {
                this.f24110k = C1607c.b(getContext(), k10, i11);
            }
            int i12 = e4.m.Ub;
            if (k10.s(i12)) {
                this.f24111l = ViewUtils.parseTintMode(k10.k(i12, -1), null);
            }
        }
        int i13 = e4.m.Rb;
        if (k10.s(i13)) {
            U(k10.k(i13, 0));
            int i14 = e4.m.Ob;
            if (k10.s(i14)) {
                Q(k10.p(i14));
            }
            O(k10.a(e4.m.Nb, true));
        } else if (k10.s(i10)) {
            int i15 = e4.m.pc;
            if (k10.s(i15)) {
                this.f24110k = C1607c.b(getContext(), k10, i15);
            }
            int i16 = e4.m.qc;
            if (k10.s(i16)) {
                this.f24111l = ViewUtils.parseTintMode(k10.k(i16, -1), null);
            }
            U(k10.a(i10, false) ? 1 : 0);
            Q(k10.p(e4.m.mc));
        }
        T(k10.f(e4.m.Qb, getResources().getDimensionPixelSize(C0979e.f30724A0)));
        int i17 = e4.m.Sb;
        if (k10.s(i17)) {
            X(t.b(k10.k(i17, -1)));
        }
    }

    public final void C(K k10) {
        int i10 = e4.m.Zb;
        if (k10.s(i10)) {
            this.f24103d = C1607c.b(getContext(), k10, i10);
        }
        int i11 = e4.m.ac;
        if (k10.s(i11)) {
            this.f24104e = ViewUtils.parseTintMode(k10.k(i11, -1), null);
        }
        int i12 = e4.m.Yb;
        if (k10.s(i12)) {
            c0(k10.g(i12));
        }
        this.f24102c.setContentDescription(getResources().getText(e4.k.f30981i));
        androidx.core.view.K.t0(this.f24102c, 2);
        this.f24102c.setClickable(false);
        this.f24102c.setPressable(false);
        this.f24102c.setFocusable(false);
    }

    public final void D(K k10) {
        this.f24116q.setVisibility(8);
        this.f24116q.setId(e4.g.f30901s0);
        this.f24116q.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        androidx.core.view.K.l0(this.f24116q, 1);
        q0(k10.n(e4.m.Fc, 0));
        int i10 = e4.m.Gc;
        if (k10.s(i10)) {
            r0(k10.c(i10));
        }
        p0(k10.p(e4.m.Ec));
    }

    public boolean E() {
        if (A() && this.f24106g.isChecked()) {
            return true;
        }
        return false;
    }

    public boolean F() {
        if (this.f24101b.getVisibility() == 0 && this.f24106g.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean G() {
        if (this.f24102c.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void H(boolean z10) {
        this.f24117r = z10;
        y0();
    }

    public void I() {
        w0();
        K();
        J();
        if (m().t()) {
            u0(this.f24100a.d0());
        }
    }

    public void J() {
        t.d(this.f24100a, this.f24106g, this.f24110k);
    }

    public void K() {
        t.d(this.f24100a, this.f24102c, this.f24103d);
    }

    public void L(boolean z10) {
        boolean z11;
        boolean isActivated;
        boolean isChecked;
        s m10 = m();
        boolean z12 = true;
        if (m10.l() && (isChecked = this.f24106g.isChecked()) != m10.m()) {
            this.f24106g.setChecked(!isChecked);
            z11 = true;
        } else {
            z11 = false;
        }
        if (m10.j() && (isActivated = this.f24106g.isActivated()) != m10.k()) {
            N(!isActivated);
        } else {
            z12 = z11;
        }
        if (z10 || z12) {
            J();
        }
    }

    public final void M() {
        AccessibilityManager accessibilityManager;
        c.a aVar = this.f24120z;
        if (aVar != null && (accessibilityManager = this.f24119y) != null) {
            J.c.c(accessibilityManager, aVar);
        }
    }

    public void N(boolean z10) {
        this.f24106g.setActivated(z10);
    }

    public void O(boolean z10) {
        this.f24106g.setCheckable(z10);
    }

    public void P(int i10) {
        CharSequence charSequence;
        if (i10 != 0) {
            charSequence = getResources().getText(i10);
        } else {
            charSequence = null;
        }
        Q(charSequence);
    }

    public void Q(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f24106g.setContentDescription(charSequence);
        }
    }

    public void R(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = C0991a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        S(drawable);
    }

    public void S(Drawable drawable) {
        this.f24106g.setImageDrawable(drawable);
        if (drawable != null) {
            t.a(this.f24100a, this.f24106g, this.f24110k, this.f24111l);
            J();
        }
    }

    public void T(int i10) {
        if (i10 >= 0) {
            if (i10 != this.f24112m) {
                this.f24112m = i10;
                t.g(this.f24106g, i10);
                t.g(this.f24102c, i10);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    public void U(int i10) {
        boolean z10;
        if (this.f24108i == i10) {
            return;
        }
        t0(m());
        int i11 = this.f24108i;
        this.f24108i = i10;
        j(i11);
        if (i10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a0(z10);
        s m10 = m();
        R(t(m10));
        P(m10.c());
        O(m10.l());
        if (m10.i(this.f24100a.getBoxBackgroundMode())) {
            s0(m10);
            V(m10.f());
            EditText editText = this.f24118x;
            if (editText != null) {
                m10.n(editText);
                h0(m10);
            }
            t.a(this.f24100a, this.f24106g, this.f24110k, this.f24111l);
            L(true);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.f24100a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i10);
    }

    public void V(View.OnClickListener onClickListener) {
        t.h(this.f24106g, onClickListener, this.f24114o);
    }

    public void W(View.OnLongClickListener onLongClickListener) {
        this.f24114o = onLongClickListener;
        t.i(this.f24106g, onLongClickListener);
    }

    public void X(ImageView.ScaleType scaleType) {
        this.f24113n = scaleType;
        t.j(this.f24106g, scaleType);
        t.j(this.f24102c, scaleType);
    }

    public void Y(ColorStateList colorStateList) {
        if (this.f24110k != colorStateList) {
            this.f24110k = colorStateList;
            t.a(this.f24100a, this.f24106g, colorStateList, this.f24111l);
        }
    }

    public void Z(PorterDuff.Mode mode) {
        if (this.f24111l != mode) {
            this.f24111l = mode;
            t.a(this.f24100a, this.f24106g, this.f24110k, mode);
        }
    }

    public void a0(boolean z10) {
        int i10;
        if (F() != z10) {
            CheckableImageButton checkableImageButton = this.f24106g;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            checkableImageButton.setVisibility(i10);
            v0();
            x0();
            this.f24100a.o0();
        }
    }

    public void b0(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = C0991a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        c0(drawable);
        K();
    }

    public void c0(Drawable drawable) {
        this.f24102c.setImageDrawable(drawable);
        w0();
        t.a(this.f24100a, this.f24102c, this.f24103d, this.f24104e);
    }

    public void d0(View.OnClickListener onClickListener) {
        t.h(this.f24102c, onClickListener, this.f24105f);
    }

    public void e0(View.OnLongClickListener onLongClickListener) {
        this.f24105f = onLongClickListener;
        t.i(this.f24102c, onLongClickListener);
    }

    public void f0(ColorStateList colorStateList) {
        if (this.f24103d != colorStateList) {
            this.f24103d = colorStateList;
            t.a(this.f24100a, this.f24102c, colorStateList, this.f24104e);
        }
    }

    public final void g() {
        if (this.f24120z != null && this.f24119y != null && androidx.core.view.K.N(this)) {
            J.c.a(this.f24119y, this.f24120z);
        }
    }

    public void g0(PorterDuff.Mode mode) {
        if (this.f24104e != mode) {
            this.f24104e = mode;
            t.a(this.f24100a, this.f24102c, this.f24103d, mode);
        }
    }

    public void h() {
        this.f24106g.performClick();
        this.f24106g.jumpDrawablesToCurrentState();
    }

    public final void h0(s sVar) {
        if (this.f24118x == null) {
            return;
        }
        if (sVar.e() != null) {
            this.f24118x.setOnFocusChangeListener(sVar.e());
        }
        if (sVar.g() != null) {
            this.f24106g.setOnFocusChangeListener(sVar.g());
        }
    }

    public final CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i10) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(e4.i.f30931k, viewGroup, false);
        checkableImageButton.setId(i10);
        t.e(checkableImageButton);
        if (C1607c.j(getContext())) {
            C0458m.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public void i0(int i10) {
        CharSequence charSequence;
        if (i10 != 0) {
            charSequence = getResources().getText(i10);
        } else {
            charSequence = null;
        }
        j0(charSequence);
    }

    public final void j(int i10) {
        Iterator<TextInputLayout.g> it = this.f24109j.iterator();
        while (it.hasNext()) {
            it.next().a(this.f24100a, i10);
        }
    }

    public void j0(CharSequence charSequence) {
        this.f24106g.setContentDescription(charSequence);
    }

    public CheckableImageButton k() {
        if (G()) {
            return this.f24102c;
        }
        if (A() && F()) {
            return this.f24106g;
        }
        return null;
    }

    public void k0(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            drawable = C0991a.b(getContext(), i10);
        } else {
            drawable = null;
        }
        l0(drawable);
    }

    public CharSequence l() {
        return this.f24106g.getContentDescription();
    }

    public void l0(Drawable drawable) {
        this.f24106g.setImageDrawable(drawable);
    }

    public s m() {
        return this.f24107h.c(this.f24108i);
    }

    public void m0(boolean z10) {
        if (z10 && this.f24108i != 1) {
            U(1);
        } else if (!z10) {
            U(0);
        }
    }

    public Drawable n() {
        return this.f24106g.getDrawable();
    }

    public void n0(ColorStateList colorStateList) {
        this.f24110k = colorStateList;
        t.a(this.f24100a, this.f24106g, colorStateList, this.f24111l);
    }

    public int o() {
        return this.f24112m;
    }

    public void o0(PorterDuff.Mode mode) {
        this.f24111l = mode;
        t.a(this.f24100a, this.f24106g, this.f24110k, mode);
    }

    public int p() {
        return this.f24108i;
    }

    public void p0(CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.f24115p = charSequence2;
        this.f24116q.setText(charSequence);
        y0();
    }

    public ImageView.ScaleType q() {
        return this.f24113n;
    }

    public void q0(int i10) {
        androidx.core.widget.k.p(this.f24116q, i10);
    }

    public CheckableImageButton r() {
        return this.f24106g;
    }

    public void r0(ColorStateList colorStateList) {
        this.f24116q.setTextColor(colorStateList);
    }

    public Drawable s() {
        return this.f24102c.getDrawable();
    }

    public final void s0(s sVar) {
        sVar.s();
        this.f24120z = sVar.h();
        g();
    }

    public final int t(s sVar) {
        int i10 = this.f24107h.f24126c;
        if (i10 == 0) {
            return sVar.d();
        }
        return i10;
    }

    public final void t0(s sVar) {
        M();
        this.f24120z = null;
        sVar.u();
    }

    public CharSequence u() {
        return this.f24106g.getContentDescription();
    }

    public final void u0(boolean z10) {
        if (z10 && n() != null) {
            Drawable mutate = C.a.r(n()).mutate();
            C.a.n(mutate, this.f24100a.getErrorCurrentTextColors());
            this.f24106g.setImageDrawable(mutate);
            return;
        }
        t.a(this.f24100a, this.f24106g, this.f24110k, this.f24111l);
    }

    public Drawable v() {
        return this.f24106g.getDrawable();
    }

    public final void v0() {
        int i10;
        boolean z10;
        FrameLayout frameLayout = this.f24101b;
        int i11 = 8;
        if (this.f24106g.getVisibility() == 0 && !G()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        frameLayout.setVisibility(i10);
        if (this.f24115p != null && !this.f24117r) {
            z10 = false;
        } else {
            z10 = 8;
        }
        if (F() || G() || !z10) {
            i11 = 0;
        }
        setVisibility(i11);
    }

    public CharSequence w() {
        return this.f24115p;
    }

    public final void w0() {
        boolean z10;
        int i10 = 0;
        if (s() != null && this.f24100a.N() && this.f24100a.d0()) {
            z10 = true;
        } else {
            z10 = false;
        }
        CheckableImageButton checkableImageButton = this.f24102c;
        if (!z10) {
            i10 = 8;
        }
        checkableImageButton.setVisibility(i10);
        v0();
        x0();
        if (!A()) {
            this.f24100a.o0();
        }
    }

    public ColorStateList x() {
        return this.f24116q.getTextColors();
    }

    public void x0() {
        int i10;
        if (this.f24100a.f24008d == null) {
            return;
        }
        if (!F() && !G()) {
            i10 = androidx.core.view.K.z(this.f24100a.f24008d);
        } else {
            i10 = 0;
        }
        androidx.core.view.K.A0(this.f24116q, getContext().getResources().getDimensionPixelSize(C0979e.f30779d0), this.f24100a.f24008d.getPaddingTop(), i10, this.f24100a.f24008d.getPaddingBottom());
    }

    public int y() {
        int measuredWidth;
        if (!F() && !G()) {
            measuredWidth = 0;
        } else {
            measuredWidth = this.f24106g.getMeasuredWidth() + C0458m.b((ViewGroup.MarginLayoutParams) this.f24106g.getLayoutParams());
        }
        return androidx.core.view.K.z(this) + androidx.core.view.K.z(this.f24116q) + measuredWidth;
    }

    public final void y0() {
        int i10;
        int visibility = this.f24116q.getVisibility();
        boolean z10 = false;
        if (this.f24115p != null && !this.f24117r) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        if (visibility != i10) {
            s m10 = m();
            if (i10 == 0) {
                z10 = true;
            }
            m10.q(z10);
        }
        v0();
        this.f24116q.setVisibility(i10);
        this.f24100a.o0();
    }

    public TextView z() {
        return this.f24116q;
    }
}
