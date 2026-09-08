package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.view.K;
import com.google.android.material.internal.ViewUtils;
import e4.C0977c;
import e4.m;
import l4.C1292a;
import u4.C1607c;
import v4.C1625a;
import v4.b;
import x4.i;
import x4.n;
import x4.r;

/* compiled from: MaterialButtonHelper.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f22888u = true;

    /* renamed from: v, reason: collision with root package name */
    public static final boolean f22889v = false;

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f22890a;

    /* renamed from: b, reason: collision with root package name */
    public n f22891b;

    /* renamed from: c, reason: collision with root package name */
    public int f22892c;

    /* renamed from: d, reason: collision with root package name */
    public int f22893d;

    /* renamed from: e, reason: collision with root package name */
    public int f22894e;

    /* renamed from: f, reason: collision with root package name */
    public int f22895f;

    /* renamed from: g, reason: collision with root package name */
    public int f22896g;

    /* renamed from: h, reason: collision with root package name */
    public int f22897h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f22898i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f22899j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f22900k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f22901l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f22902m;

    /* renamed from: q, reason: collision with root package name */
    public boolean f22906q;

    /* renamed from: s, reason: collision with root package name */
    public LayerDrawable f22908s;

    /* renamed from: t, reason: collision with root package name */
    public int f22909t;

    /* renamed from: n, reason: collision with root package name */
    public boolean f22903n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f22904o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f22905p = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f22907r = true;

    public a(MaterialButton materialButton, n nVar) {
        this.f22890a = materialButton;
        this.f22891b = nVar;
    }

    public void A(boolean z10) {
        this.f22903n = z10;
        J();
    }

    public void B(ColorStateList colorStateList) {
        if (this.f22900k != colorStateList) {
            this.f22900k = colorStateList;
            J();
        }
    }

    public void C(int i10) {
        if (this.f22897h != i10) {
            this.f22897h = i10;
            J();
        }
    }

    public void D(ColorStateList colorStateList) {
        if (this.f22899j != colorStateList) {
            this.f22899j = colorStateList;
            if (f() != null) {
                C.a.o(f(), this.f22899j);
            }
        }
    }

    public void E(PorterDuff.Mode mode) {
        if (this.f22898i != mode) {
            this.f22898i = mode;
            if (f() != null && this.f22898i != null) {
                C.a.p(f(), this.f22898i);
            }
        }
    }

    public void F(boolean z10) {
        this.f22907r = z10;
    }

    public final void G(int i10, int i11) {
        int A10 = K.A(this.f22890a);
        int paddingTop = this.f22890a.getPaddingTop();
        int z10 = K.z(this.f22890a);
        int paddingBottom = this.f22890a.getPaddingBottom();
        int i12 = this.f22894e;
        int i13 = this.f22895f;
        this.f22895f = i11;
        this.f22894e = i10;
        if (!this.f22904o) {
            H();
        }
        K.A0(this.f22890a, A10, (paddingTop + i10) - i12, z10, (paddingBottom + i11) - i13);
    }

    public final void H() {
        this.f22890a.setInternalBackground(a());
        i f10 = f();
        if (f10 != null) {
            f10.setElevation(this.f22909t);
            f10.setState(this.f22890a.getDrawableState());
        }
    }

    public final void I(n nVar) {
        if (f22889v && !this.f22904o) {
            int A10 = K.A(this.f22890a);
            int paddingTop = this.f22890a.getPaddingTop();
            int z10 = K.z(this.f22890a);
            int paddingBottom = this.f22890a.getPaddingBottom();
            H();
            K.A0(this.f22890a, A10, paddingTop, z10, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(nVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(nVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(nVar);
        }
    }

    public final void J() {
        int i10;
        i f10 = f();
        i n10 = n();
        if (f10 != null) {
            f10.setStroke(this.f22897h, this.f22900k);
            if (n10 != null) {
                float f11 = this.f22897h;
                if (this.f22903n) {
                    i10 = C1292a.d(this.f22890a, C0977c.f30697v);
                } else {
                    i10 = 0;
                }
                n10.setStroke(f11, i10);
            }
        }
    }

    public final InsetDrawable K(Drawable drawable) {
        return new InsetDrawable(drawable, this.f22892c, this.f22894e, this.f22893d, this.f22895f);
    }

    public final Drawable a() {
        i iVar = new i(this.f22891b);
        iVar.initializeElevationOverlay(this.f22890a.getContext());
        C.a.o(iVar, this.f22899j);
        PorterDuff.Mode mode = this.f22898i;
        if (mode != null) {
            C.a.p(iVar, mode);
        }
        iVar.setStroke(this.f22897h, this.f22900k);
        i iVar2 = new i(this.f22891b);
        int i10 = 0;
        iVar2.setTint(0);
        float f10 = this.f22897h;
        if (this.f22903n) {
            i10 = C1292a.d(this.f22890a, C0977c.f30697v);
        }
        iVar2.setStroke(f10, i10);
        if (f22888u) {
            i iVar3 = new i(this.f22891b);
            this.f22902m = iVar3;
            C.a.n(iVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.d(this.f22901l), K(new LayerDrawable(new Drawable[]{iVar2, iVar})), this.f22902m);
            this.f22908s = rippleDrawable;
            return rippleDrawable;
        }
        C1625a c1625a = new C1625a(this.f22891b);
        this.f22902m = c1625a;
        C.a.o(c1625a, b.d(this.f22901l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{iVar2, iVar, this.f22902m});
        this.f22908s = layerDrawable;
        return K(layerDrawable);
    }

    public int b() {
        return this.f22896g;
    }

    public int c() {
        return this.f22895f;
    }

    public int d() {
        return this.f22894e;
    }

    public r e() {
        LayerDrawable layerDrawable = this.f22908s;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 1) {
            if (this.f22908s.getNumberOfLayers() > 2) {
                return (r) this.f22908s.getDrawable(2);
            }
            return (r) this.f22908s.getDrawable(1);
        }
        return null;
    }

    public i f() {
        return g(false);
    }

    public final i g(boolean z10) {
        LayerDrawable layerDrawable = this.f22908s;
        if (layerDrawable != null && layerDrawable.getNumberOfLayers() > 0) {
            if (f22888u) {
                return (i) ((LayerDrawable) ((InsetDrawable) this.f22908s.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0);
            }
            return (i) this.f22908s.getDrawable(!z10 ? 1 : 0);
        }
        return null;
    }

    public ColorStateList h() {
        return this.f22901l;
    }

    public n i() {
        return this.f22891b;
    }

    public ColorStateList j() {
        return this.f22900k;
    }

    public int k() {
        return this.f22897h;
    }

    public ColorStateList l() {
        return this.f22899j;
    }

    public PorterDuff.Mode m() {
        return this.f22898i;
    }

    public final i n() {
        return g(true);
    }

    public boolean o() {
        return this.f22904o;
    }

    public boolean p() {
        return this.f22906q;
    }

    public boolean q() {
        return this.f22907r;
    }

    public void r(TypedArray typedArray) {
        this.f22892c = typedArray.getDimensionPixelOffset(m.f31115G4, 0);
        this.f22893d = typedArray.getDimensionPixelOffset(m.f31126H4, 0);
        this.f22894e = typedArray.getDimensionPixelOffset(m.f31137I4, 0);
        this.f22895f = typedArray.getDimensionPixelOffset(m.f31148J4, 0);
        int i10 = m.f31192N4;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f22896g = dimensionPixelSize;
            z(this.f22891b.w(dimensionPixelSize));
            this.f22905p = true;
        }
        this.f22897h = typedArray.getDimensionPixelSize(m.f31302X4, 0);
        this.f22898i = ViewUtils.parseTintMode(typedArray.getInt(m.f31181M4, -1), PorterDuff.Mode.SRC_IN);
        this.f22899j = C1607c.a(this.f22890a.getContext(), typedArray, m.f31170L4);
        this.f22900k = C1607c.a(this.f22890a.getContext(), typedArray, m.f31291W4);
        this.f22901l = C1607c.a(this.f22890a.getContext(), typedArray, m.f31280V4);
        this.f22906q = typedArray.getBoolean(m.f31159K4, false);
        this.f22909t = typedArray.getDimensionPixelSize(m.f31203O4, 0);
        this.f22907r = typedArray.getBoolean(m.f31313Y4, true);
        int A10 = K.A(this.f22890a);
        int paddingTop = this.f22890a.getPaddingTop();
        int z10 = K.z(this.f22890a);
        int paddingBottom = this.f22890a.getPaddingBottom();
        if (typedArray.hasValue(m.f31104F4)) {
            t();
        } else {
            H();
        }
        K.A0(this.f22890a, A10 + this.f22892c, paddingTop + this.f22894e, z10 + this.f22893d, paddingBottom + this.f22895f);
    }

    public void s(int i10) {
        if (f() != null) {
            f().setTint(i10);
        }
    }

    public void t() {
        this.f22904o = true;
        this.f22890a.setSupportBackgroundTintList(this.f22899j);
        this.f22890a.setSupportBackgroundTintMode(this.f22898i);
    }

    public void u(boolean z10) {
        this.f22906q = z10;
    }

    public void v(int i10) {
        if (!this.f22905p || this.f22896g != i10) {
            this.f22896g = i10;
            this.f22905p = true;
            z(this.f22891b.w(i10));
        }
    }

    public void w(int i10) {
        G(this.f22894e, i10);
    }

    public void x(int i10) {
        G(i10, this.f22895f);
    }

    public void y(ColorStateList colorStateList) {
        if (this.f22901l != colorStateList) {
            this.f22901l = colorStateList;
            boolean z10 = f22888u;
            if (z10 && (this.f22890a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f22890a.getBackground()).setColor(b.d(colorStateList));
            } else if (!z10 && (this.f22890a.getBackground() instanceof C1625a)) {
                ((C1625a) this.f22890a.getBackground()).setTintList(b.d(colorStateList));
            }
        }
    }

    public void z(n nVar) {
        this.f22891b = nVar;
        I(nVar);
    }
}
