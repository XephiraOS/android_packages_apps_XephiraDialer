package i4;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.K;
import com.google.android.material.card.MaterialCardView;
import e4.C0977c;
import e4.g;
import e4.l;
import e4.m;
import f4.C1001b;
import l4.C1292a;
import s4.C1550i;
import u4.C1607c;
import x4.e;
import x4.f;
import x4.i;
import x4.n;

/* compiled from: MaterialCardViewHelper.java */
/* renamed from: i4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1099b {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialCardView f32161a;

    /* renamed from: c, reason: collision with root package name */
    public final i f32163c;

    /* renamed from: d, reason: collision with root package name */
    public final i f32164d;

    /* renamed from: e, reason: collision with root package name */
    public int f32165e;

    /* renamed from: f, reason: collision with root package name */
    public int f32166f;

    /* renamed from: g, reason: collision with root package name */
    public int f32167g;

    /* renamed from: h, reason: collision with root package name */
    public int f32168h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f32169i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f32170j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f32171k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f32172l;

    /* renamed from: m, reason: collision with root package name */
    public n f32173m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f32174n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f32175o;

    /* renamed from: p, reason: collision with root package name */
    public LayerDrawable f32176p;

    /* renamed from: q, reason: collision with root package name */
    public i f32177q;

    /* renamed from: r, reason: collision with root package name */
    public i f32178r;

    /* renamed from: t, reason: collision with root package name */
    public boolean f32180t;

    /* renamed from: u, reason: collision with root package name */
    public ValueAnimator f32181u;

    /* renamed from: v, reason: collision with root package name */
    public final TimeInterpolator f32182v;

    /* renamed from: w, reason: collision with root package name */
    public final int f32183w;

    /* renamed from: x, reason: collision with root package name */
    public final int f32184x;

    /* renamed from: z, reason: collision with root package name */
    public static final double f32160z = Math.cos(Math.toRadians(45.0d));

    /* renamed from: A, reason: collision with root package name */
    public static final Drawable f32159A = null;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f32162b = new Rect();

    /* renamed from: s, reason: collision with root package name */
    public boolean f32179s = false;

    /* renamed from: y, reason: collision with root package name */
    public float f32185y = 0.0f;

    /* compiled from: MaterialCardViewHelper.java */
    /* renamed from: i4.b$a */
    /* loaded from: classes3.dex */
    public class a extends InsetDrawable {
        public a(Drawable drawable, int i10, int i11, int i12, int i13) {
            super(drawable, i10, i11, i12, i13);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public C1099b(MaterialCardView materialCardView, AttributeSet attributeSet, int i10, int i11) {
        this.f32161a = materialCardView;
        i iVar = new i(materialCardView.getContext(), attributeSet, i10, i11);
        this.f32163c = iVar;
        iVar.initializeElevationOverlay(materialCardView.getContext());
        iVar.setShadowColor(-12303292);
        n.b v10 = iVar.getShapeAppearanceModel().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, m.f31473n1, i10, l.f31018a);
        int i12 = m.f31484o1;
        if (obtainStyledAttributes.hasValue(i12)) {
            v10.o(obtainStyledAttributes.getDimension(i12, 0.0f));
        }
        this.f32164d = new i();
        Z(v10.m());
        this.f32182v = C1550i.g(materialCardView.getContext(), C0977c.f30664e0, C1001b.f31702a);
        this.f32183w = C1550i.f(materialCardView.getContext(), C0977c.f30653Y, 300);
        this.f32184x = C1550i.f(materialCardView.getContext(), C0977c.f30652X, 300);
        obtainStyledAttributes.recycle();
    }

    public ColorStateList A() {
        return this.f32174n;
    }

    public int B() {
        return this.f32168h;
    }

    public Rect C() {
        return this.f32162b;
    }

    public final Drawable D(Drawable drawable) {
        int i10;
        int i11;
        if (this.f32161a.getUseCompatPadding()) {
            i11 = (int) Math.ceil(f());
            i10 = (int) Math.ceil(e());
        } else {
            i10 = 0;
            i11 = 0;
        }
        return new a(drawable, i10, i11, i10, i11);
    }

    public boolean E() {
        return this.f32179s;
    }

    public boolean F() {
        return this.f32180t;
    }

    public final boolean G() {
        if ((this.f32167g & 80) == 80) {
            return true;
        }
        return false;
    }

    public final boolean H() {
        if ((this.f32167g & 8388613) == 8388613) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void I(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f32170j.setAlpha((int) (255.0f * floatValue));
        this.f32185y = floatValue;
    }

    public void J(TypedArray typedArray) {
        Drawable drawable;
        ColorStateList a10 = C1607c.a(this.f32161a.getContext(), typedArray, m.f31138I5);
        this.f32174n = a10;
        if (a10 == null) {
            this.f32174n = ColorStateList.valueOf(-1);
        }
        this.f32168h = typedArray.getDimensionPixelSize(m.f31149J5, 0);
        boolean z10 = typedArray.getBoolean(m.f31050A5, false);
        this.f32180t = z10;
        this.f32161a.setLongClickable(z10);
        this.f32172l = C1607c.a(this.f32161a.getContext(), typedArray, m.f31116G5);
        R(C1607c.e(this.f32161a.getContext(), typedArray, m.f31072C5));
        U(typedArray.getDimensionPixelSize(m.f31105F5, 0));
        T(typedArray.getDimensionPixelSize(m.f31094E5, 0));
        this.f32167g = typedArray.getInteger(m.f31083D5, 8388661);
        ColorStateList a11 = C1607c.a(this.f32161a.getContext(), typedArray, m.f31127H5);
        this.f32171k = a11;
        if (a11 == null) {
            this.f32171k = ColorStateList.valueOf(C1292a.d(this.f32161a, C0977c.f30683o));
        }
        N(C1607c.a(this.f32161a.getContext(), typedArray, m.f31061B5));
        l0();
        i0();
        m0();
        this.f32161a.setBackgroundInternal(D(this.f32163c));
        if (f0()) {
            drawable = t();
        } else {
            drawable = this.f32164d;
        }
        this.f32169i = drawable;
        this.f32161a.setForeground(D(drawable));
    }

    public void K(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        if (this.f32176p != null) {
            if (this.f32161a.getUseCompatPadding()) {
                i12 = (int) Math.ceil(f() * 2.0f);
                i13 = (int) Math.ceil(e() * 2.0f);
            } else {
                i12 = 0;
                i13 = 0;
            }
            if (H()) {
                i14 = ((i10 - this.f32165e) - this.f32166f) - i13;
            } else {
                i14 = this.f32165e;
            }
            if (G()) {
                i15 = this.f32165e;
            } else {
                i15 = ((i11 - this.f32165e) - this.f32166f) - i12;
            }
            int i20 = i15;
            if (H()) {
                i16 = this.f32165e;
            } else {
                i16 = ((i10 - this.f32165e) - this.f32166f) - i13;
            }
            if (G()) {
                i17 = ((i11 - this.f32165e) - this.f32166f) - i12;
            } else {
                i17 = this.f32165e;
            }
            int i21 = i17;
            if (K.v(this.f32161a) == 1) {
                i19 = i16;
                i18 = i14;
            } else {
                i18 = i16;
                i19 = i14;
            }
            this.f32176p.setLayerInset(2, i19, i21, i18, i20);
        }
    }

    public void L(boolean z10) {
        this.f32179s = z10;
    }

    public void M(ColorStateList colorStateList) {
        this.f32163c.setFillColor(colorStateList);
    }

    public void N(ColorStateList colorStateList) {
        i iVar = this.f32164d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        iVar.setFillColor(colorStateList);
    }

    public void O(boolean z10) {
        this.f32180t = z10;
    }

    public void P(boolean z10) {
        Q(z10, false);
    }

    public void Q(boolean z10, boolean z11) {
        int i10;
        float f10;
        Drawable drawable = this.f32170j;
        if (drawable != null) {
            if (z11) {
                b(z10);
                return;
            }
            if (z10) {
                i10 = 255;
            } else {
                i10 = 0;
            }
            drawable.setAlpha(i10);
            if (z10) {
                f10 = 1.0f;
            } else {
                f10 = 0.0f;
            }
            this.f32185y = f10;
        }
    }

    public void R(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = C.a.r(drawable).mutate();
            this.f32170j = mutate;
            C.a.o(mutate, this.f32172l);
            P(this.f32161a.isChecked());
        } else {
            this.f32170j = f32159A;
        }
        LayerDrawable layerDrawable = this.f32176p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(g.f30842E, this.f32170j);
        }
    }

    public void S(int i10) {
        this.f32167g = i10;
        K(this.f32161a.getMeasuredWidth(), this.f32161a.getMeasuredHeight());
    }

    public void T(int i10) {
        this.f32165e = i10;
    }

    public void U(int i10) {
        this.f32166f = i10;
    }

    public void V(ColorStateList colorStateList) {
        this.f32172l = colorStateList;
        Drawable drawable = this.f32170j;
        if (drawable != null) {
            C.a.o(drawable, colorStateList);
        }
    }

    public void W(float f10) {
        Z(this.f32173m.w(f10));
        this.f32169i.invalidateSelf();
        if (e0() || d0()) {
            h0();
        }
        if (e0()) {
            k0();
        }
    }

    public void X(float f10) {
        this.f32163c.setInterpolation(f10);
        i iVar = this.f32164d;
        if (iVar != null) {
            iVar.setInterpolation(f10);
        }
        i iVar2 = this.f32178r;
        if (iVar2 != null) {
            iVar2.setInterpolation(f10);
        }
    }

    public void Y(ColorStateList colorStateList) {
        this.f32171k = colorStateList;
        l0();
    }

    public void Z(n nVar) {
        this.f32173m = nVar;
        this.f32163c.setShapeAppearanceModel(nVar);
        this.f32163c.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        i iVar = this.f32164d;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        i iVar2 = this.f32178r;
        if (iVar2 != null) {
            iVar2.setShapeAppearanceModel(nVar);
        }
        i iVar3 = this.f32177q;
        if (iVar3 != null) {
            iVar3.setShapeAppearanceModel(nVar);
        }
    }

    public void a0(ColorStateList colorStateList) {
        if (this.f32174n == colorStateList) {
            return;
        }
        this.f32174n = colorStateList;
        m0();
    }

    public void b(boolean z10) {
        float f10;
        float f11;
        int i10;
        if (z10) {
            f10 = 1.0f;
        } else {
            f10 = 0.0f;
        }
        if (z10) {
            f11 = 1.0f - this.f32185y;
        } else {
            f11 = this.f32185y;
        }
        ValueAnimator valueAnimator = this.f32181u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f32181u = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f32185y, f10);
        this.f32181u = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: i4.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                C1099b.this.I(valueAnimator2);
            }
        });
        this.f32181u.setInterpolator(this.f32182v);
        ValueAnimator valueAnimator2 = this.f32181u;
        if (z10) {
            i10 = this.f32183w;
        } else {
            i10 = this.f32184x;
        }
        valueAnimator2.setDuration(i10 * f11);
        this.f32181u.start();
    }

    public void b0(int i10) {
        if (i10 == this.f32168h) {
            return;
        }
        this.f32168h = i10;
        m0();
    }

    public final float c() {
        return Math.max(Math.max(d(this.f32173m.q(), this.f32163c.getTopLeftCornerResolvedSize()), d(this.f32173m.s(), this.f32163c.getTopRightCornerResolvedSize())), Math.max(d(this.f32173m.k(), this.f32163c.getBottomRightCornerResolvedSize()), d(this.f32173m.i(), this.f32163c.getBottomLeftCornerResolvedSize())));
    }

    public void c0(int i10, int i11, int i12, int i13) {
        this.f32162b.set(i10, i11, i12, i13);
        h0();
    }

    public final float d(e eVar, float f10) {
        if (eVar instanceof x4.m) {
            return (float) ((1.0d - f32160z) * f10);
        }
        if (eVar instanceof f) {
            return f10 / 2.0f;
        }
        return 0.0f;
    }

    public final boolean d0() {
        if (this.f32161a.getPreventCornerOverlap() && !g()) {
            return true;
        }
        return false;
    }

    public final float e() {
        float f10;
        float maxCardElevation = this.f32161a.getMaxCardElevation();
        if (e0()) {
            f10 = c();
        } else {
            f10 = 0.0f;
        }
        return maxCardElevation + f10;
    }

    public final boolean e0() {
        if (this.f32161a.getPreventCornerOverlap() && g() && this.f32161a.getUseCompatPadding()) {
            return true;
        }
        return false;
    }

    public final float f() {
        float f10;
        float maxCardElevation = this.f32161a.getMaxCardElevation() * 1.5f;
        if (e0()) {
            f10 = c();
        } else {
            f10 = 0.0f;
        }
        return maxCardElevation + f10;
    }

    public final boolean f0() {
        if (this.f32161a.isClickable()) {
            return true;
        }
        View view = this.f32161a;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final boolean g() {
        return this.f32163c.isRoundRect();
    }

    public void g0() {
        Drawable drawable;
        Drawable drawable2 = this.f32169i;
        if (f0()) {
            drawable = t();
        } else {
            drawable = this.f32164d;
        }
        this.f32169i = drawable;
        if (drawable2 != drawable) {
            j0(drawable);
        }
    }

    public final Drawable h() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        i j10 = j();
        this.f32177q = j10;
        j10.setFillColor(this.f32171k);
        stateListDrawable.addState(new int[]{16842919}, this.f32177q);
        return stateListDrawable;
    }

    public void h0() {
        float c10;
        if (!d0() && !e0()) {
            c10 = 0.0f;
        } else {
            c10 = c();
        }
        int v10 = (int) (c10 - v());
        MaterialCardView materialCardView = this.f32161a;
        Rect rect = this.f32162b;
        materialCardView.k(rect.left + v10, rect.top + v10, rect.right + v10, rect.bottom + v10);
    }

    public final Drawable i() {
        if (v4.b.f37396a) {
            this.f32178r = j();
            return new RippleDrawable(this.f32171k, null, this.f32178r);
        }
        return h();
    }

    public void i0() {
        this.f32163c.setElevation(this.f32161a.getCardElevation());
    }

    public final i j() {
        return new i(this.f32173m);
    }

    public final void j0(Drawable drawable) {
        if (this.f32161a.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.f32161a.getForeground()).setDrawable(drawable);
        } else {
            this.f32161a.setForeground(D(drawable));
        }
    }

    public void k() {
        Drawable drawable = this.f32175o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i10 = bounds.bottom;
            this.f32175o.setBounds(bounds.left, bounds.top, bounds.right, i10 - 1);
            this.f32175o.setBounds(bounds.left, bounds.top, bounds.right, i10);
        }
    }

    public void k0() {
        if (!E()) {
            this.f32161a.setBackgroundInternal(D(this.f32163c));
        }
        this.f32161a.setForeground(D(this.f32169i));
    }

    public i l() {
        return this.f32163c;
    }

    public final void l0() {
        Drawable drawable;
        if (v4.b.f37396a && (drawable = this.f32175o) != null) {
            ((RippleDrawable) drawable).setColor(this.f32171k);
            return;
        }
        i iVar = this.f32177q;
        if (iVar != null) {
            iVar.setFillColor(this.f32171k);
        }
    }

    public ColorStateList m() {
        return this.f32163c.getFillColor();
    }

    public void m0() {
        this.f32164d.setStroke(this.f32168h, this.f32174n);
    }

    public ColorStateList n() {
        return this.f32164d.getFillColor();
    }

    public Drawable o() {
        return this.f32170j;
    }

    public int p() {
        return this.f32167g;
    }

    public int q() {
        return this.f32165e;
    }

    public int r() {
        return this.f32166f;
    }

    public ColorStateList s() {
        return this.f32172l;
    }

    public final Drawable t() {
        if (this.f32175o == null) {
            this.f32175o = i();
        }
        if (this.f32176p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f32175o, this.f32164d, this.f32170j});
            this.f32176p = layerDrawable;
            layerDrawable.setId(2, g.f30842E);
        }
        return this.f32176p;
    }

    public float u() {
        return this.f32163c.getTopLeftCornerResolvedSize();
    }

    public final float v() {
        if (this.f32161a.getPreventCornerOverlap() && this.f32161a.getUseCompatPadding()) {
            return (float) ((1.0d - f32160z) * this.f32161a.getCardViewRadius());
        }
        return 0.0f;
    }

    public float w() {
        return this.f32163c.getInterpolation();
    }

    public ColorStateList x() {
        return this.f32171k;
    }

    public n y() {
        return this.f32173m;
    }

    public int z() {
        ColorStateList colorStateList = this.f32174n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }
}
