package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import e4.m;
import f.C0991a;
import f4.C1008i;
import h4.C1079a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import l4.C1292a;
import n4.C1370a;
import u4.C1607c;
import u4.C1608d;
import v4.b;
import x4.i;

/* compiled from: ChipDrawable.java */
/* loaded from: classes3.dex */
public class a extends i implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {

    /* renamed from: p0, reason: collision with root package name */
    public static final int[] f23009p0 = {16842910};

    /* renamed from: q0, reason: collision with root package name */
    public static final ShapeDrawable f23010q0 = new ShapeDrawable(new OvalShape());

    /* renamed from: A, reason: collision with root package name */
    public Drawable f23011A;

    /* renamed from: B, reason: collision with root package name */
    public ColorStateList f23012B;

    /* renamed from: C, reason: collision with root package name */
    public C1008i f23013C;

    /* renamed from: D, reason: collision with root package name */
    public C1008i f23014D;

    /* renamed from: E, reason: collision with root package name */
    public float f23015E;

    /* renamed from: F, reason: collision with root package name */
    public float f23016F;

    /* renamed from: G, reason: collision with root package name */
    public float f23017G;

    /* renamed from: H, reason: collision with root package name */
    public float f23018H;

    /* renamed from: I, reason: collision with root package name */
    public float f23019I;

    /* renamed from: J, reason: collision with root package name */
    public float f23020J;

    /* renamed from: K, reason: collision with root package name */
    public float f23021K;

    /* renamed from: L, reason: collision with root package name */
    public float f23022L;

    /* renamed from: M, reason: collision with root package name */
    public final Context f23023M;

    /* renamed from: N, reason: collision with root package name */
    public final Paint f23024N;

    /* renamed from: O, reason: collision with root package name */
    public final Paint f23025O;

    /* renamed from: P, reason: collision with root package name */
    public final Paint.FontMetrics f23026P;

    /* renamed from: Q, reason: collision with root package name */
    public final RectF f23027Q;

    /* renamed from: R, reason: collision with root package name */
    public final PointF f23028R;

    /* renamed from: S, reason: collision with root package name */
    public final Path f23029S;

    /* renamed from: T, reason: collision with root package name */
    public final TextDrawableHelper f23030T;

    /* renamed from: U, reason: collision with root package name */
    public int f23031U;

    /* renamed from: V, reason: collision with root package name */
    public int f23032V;

    /* renamed from: W, reason: collision with root package name */
    public int f23033W;

    /* renamed from: X, reason: collision with root package name */
    public int f23034X;

    /* renamed from: Y, reason: collision with root package name */
    public int f23035Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f23036Z;

    /* renamed from: a, reason: collision with root package name */
    public ColorStateList f23037a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f23038a0;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f23039b;

    /* renamed from: b0, reason: collision with root package name */
    public int f23040b0;

    /* renamed from: c, reason: collision with root package name */
    public float f23041c;

    /* renamed from: c0, reason: collision with root package name */
    public int f23042c0;

    /* renamed from: d, reason: collision with root package name */
    public float f23043d;

    /* renamed from: d0, reason: collision with root package name */
    public ColorFilter f23044d0;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f23045e;

    /* renamed from: e0, reason: collision with root package name */
    public PorterDuffColorFilter f23046e0;

    /* renamed from: f, reason: collision with root package name */
    public float f23047f;

    /* renamed from: f0, reason: collision with root package name */
    public ColorStateList f23048f0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f23049g;

    /* renamed from: g0, reason: collision with root package name */
    public PorterDuff.Mode f23050g0;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f23051h;

    /* renamed from: h0, reason: collision with root package name */
    public int[] f23052h0;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23053i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f23054i0;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f23055j;

    /* renamed from: j0, reason: collision with root package name */
    public ColorStateList f23056j0;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f23057k;

    /* renamed from: k0, reason: collision with root package name */
    public WeakReference<InterfaceC0211a> f23058k0;

    /* renamed from: l, reason: collision with root package name */
    public float f23059l;

    /* renamed from: l0, reason: collision with root package name */
    public TextUtils.TruncateAt f23060l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f23061m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f23062m0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f23063n;

    /* renamed from: n0, reason: collision with root package name */
    public int f23064n0;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f23065o;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f23066o0;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f23067p;

    /* renamed from: q, reason: collision with root package name */
    public ColorStateList f23068q;

    /* renamed from: r, reason: collision with root package name */
    public float f23069r;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f23070x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f23071y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f23072z;

    /* compiled from: ChipDrawable.java */
    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0211a {
        void onChipDrawableSizeChange();
    }

    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f23043d = -1.0f;
        this.f23024N = new Paint(1);
        this.f23026P = new Paint.FontMetrics();
        this.f23027Q = new RectF();
        this.f23028R = new PointF();
        this.f23029S = new Path();
        this.f23042c0 = 255;
        this.f23050g0 = PorterDuff.Mode.SRC_IN;
        this.f23058k0 = new WeakReference<>(null);
        initializeElevationOverlay(context);
        this.f23023M = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f23030T = textDrawableHelper;
        this.f23051h = "";
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.f23025O = null;
        int[] iArr = f23009p0;
        setState(iArr);
        d1(iArr);
        this.f23062m0 = true;
        if (b.f37396a) {
            f23010q0.setTint(-1);
        }
    }

    public static boolean d0(int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static boolean j0(ColorStateList colorStateList) {
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        return false;
    }

    public static boolean k0(Drawable drawable) {
        if (drawable != null && drawable.isStateful()) {
            return true;
        }
        return false;
    }

    public static a l(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.m0(attributeSet, i10, i11);
        return aVar;
    }

    public static boolean l0(C1608d c1608d) {
        if (c1608d != null && c1608d.i() != null && c1608d.i().isStateful()) {
            return true;
        }
        return false;
    }

    public Drawable A() {
        Drawable drawable = this.f23055j;
        if (drawable != null) {
            return C.a.q(drawable);
        }
        return null;
    }

    @Deprecated
    public void A0(int i10) {
        z0(this.f23023M.getResources().getDimension(i10));
    }

    public void A1(float f10) {
        C1608d Y9 = Y();
        if (Y9 != null) {
            Y9.l(f10);
            this.f23030T.getTextPaint().setTextSize(f10);
            onTextSizeChange();
        }
    }

    public float B() {
        return this.f23059l;
    }

    public void B0(float f10) {
        if (this.f23022L != f10) {
            this.f23022L = f10;
            invalidateSelf();
            n0();
        }
    }

    public void B1(float f10) {
        if (this.f23018H != f10) {
            this.f23018H = f10;
            invalidateSelf();
            n0();
        }
    }

    public ColorStateList C() {
        return this.f23057k;
    }

    public void C0(int i10) {
        B0(this.f23023M.getResources().getDimension(i10));
    }

    public void C1(int i10) {
        B1(this.f23023M.getResources().getDimension(i10));
    }

    public float D() {
        return this.f23041c;
    }

    public void D0(Drawable drawable) {
        Drawable drawable2;
        Drawable A10 = A();
        if (A10 != drawable) {
            float c10 = c();
            if (drawable != null) {
                drawable2 = C.a.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.f23055j = drawable2;
            float c11 = c();
            I1(A10);
            if (G1()) {
                a(this.f23055j);
            }
            invalidateSelf();
            if (c10 != c11) {
                n0();
            }
        }
    }

    public void D1(boolean z10) {
        if (this.f23054i0 != z10) {
            this.f23054i0 = z10;
            J1();
            onStateChange(getState());
        }
    }

    public float E() {
        return this.f23015E;
    }

    public void E0(int i10) {
        D0(C0991a.b(this.f23023M, i10));
    }

    public boolean E1() {
        return this.f23062m0;
    }

    public ColorStateList F() {
        return this.f23045e;
    }

    public void F0(float f10) {
        if (this.f23059l != f10) {
            float c10 = c();
            this.f23059l = f10;
            float c11 = c();
            invalidateSelf();
            if (c10 != c11) {
                n0();
            }
        }
    }

    public final boolean F1() {
        if (this.f23072z && this.f23011A != null && this.f23038a0) {
            return true;
        }
        return false;
    }

    public float G() {
        return this.f23047f;
    }

    public void G0(int i10) {
        F0(this.f23023M.getResources().getDimension(i10));
    }

    public final boolean G1() {
        if (this.f23053i && this.f23055j != null) {
            return true;
        }
        return false;
    }

    public Drawable H() {
        Drawable drawable = this.f23065o;
        if (drawable != null) {
            return C.a.q(drawable);
        }
        return null;
    }

    public void H0(ColorStateList colorStateList) {
        this.f23061m = true;
        if (this.f23057k != colorStateList) {
            this.f23057k = colorStateList;
            if (G1()) {
                C.a.o(this.f23055j, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final boolean H1() {
        if (this.f23063n && this.f23065o != null) {
            return true;
        }
        return false;
    }

    public CharSequence I() {
        return this.f23070x;
    }

    public void I0(int i10) {
        H0(C0991a.a(this.f23023M, i10));
    }

    public final void I1(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public float J() {
        return this.f23021K;
    }

    public void J0(int i10) {
        K0(this.f23023M.getResources().getBoolean(i10));
    }

    public final void J1() {
        ColorStateList colorStateList;
        if (this.f23054i0) {
            colorStateList = b.d(this.f23049g);
        } else {
            colorStateList = null;
        }
        this.f23056j0 = colorStateList;
    }

    public float K() {
        return this.f23069r;
    }

    public void K0(boolean z10) {
        if (this.f23053i != z10) {
            boolean G12 = G1();
            this.f23053i = z10;
            boolean G13 = G1();
            if (G12 != G13) {
                if (G13) {
                    a(this.f23055j);
                } else {
                    I1(this.f23055j);
                }
                invalidateSelf();
                n0();
            }
        }
    }

    public final void K1() {
        this.f23067p = new RippleDrawable(b.d(V()), this.f23065o, f23010q0);
    }

    public float L() {
        return this.f23020J;
    }

    public void L0(float f10) {
        if (this.f23041c != f10) {
            this.f23041c = f10;
            invalidateSelf();
            n0();
        }
    }

    public int[] M() {
        return this.f23052h0;
    }

    public void M0(int i10) {
        L0(this.f23023M.getResources().getDimension(i10));
    }

    public ColorStateList N() {
        return this.f23068q;
    }

    public void N0(float f10) {
        if (this.f23015E != f10) {
            this.f23015E = f10;
            invalidateSelf();
            n0();
        }
    }

    public void O(RectF rectF) {
        f(getBounds(), rectF);
    }

    public void O0(int i10) {
        N0(this.f23023M.getResources().getDimension(i10));
    }

    public final float P() {
        Drawable drawable;
        if (this.f23038a0) {
            drawable = this.f23011A;
        } else {
            drawable = this.f23055j;
        }
        float f10 = this.f23059l;
        if (f10 <= 0.0f && drawable != null) {
            float ceil = (float) Math.ceil(ViewUtils.dpToPx(this.f23023M, 24));
            if (drawable.getIntrinsicHeight() <= ceil) {
                return drawable.getIntrinsicHeight();
            }
            return ceil;
        }
        return f10;
    }

    public void P0(ColorStateList colorStateList) {
        if (this.f23045e != colorStateList) {
            this.f23045e = colorStateList;
            if (this.f23066o0) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final float Q() {
        Drawable drawable;
        if (this.f23038a0) {
            drawable = this.f23011A;
        } else {
            drawable = this.f23055j;
        }
        float f10 = this.f23059l;
        if (f10 <= 0.0f && drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return f10;
    }

    public void Q0(int i10) {
        P0(C0991a.a(this.f23023M, i10));
    }

    public TextUtils.TruncateAt R() {
        return this.f23060l0;
    }

    public void R0(float f10) {
        if (this.f23047f != f10) {
            this.f23047f = f10;
            this.f23024N.setStrokeWidth(f10);
            if (this.f23066o0) {
                super.setStrokeWidth(f10);
            }
            invalidateSelf();
        }
    }

    public C1008i S() {
        return this.f23014D;
    }

    public void S0(int i10) {
        R0(this.f23023M.getResources().getDimension(i10));
    }

    public float T() {
        return this.f23017G;
    }

    public final void T0(ColorStateList colorStateList) {
        if (this.f23037a != colorStateList) {
            this.f23037a = colorStateList;
            onStateChange(getState());
        }
    }

    public float U() {
        return this.f23016F;
    }

    public void U0(Drawable drawable) {
        Drawable drawable2;
        Drawable H10 = H();
        if (H10 != drawable) {
            float g10 = g();
            if (drawable != null) {
                drawable2 = C.a.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.f23065o = drawable2;
            if (b.f37396a) {
                K1();
            }
            float g11 = g();
            I1(H10);
            if (H1()) {
                a(this.f23065o);
            }
            invalidateSelf();
            if (g10 != g11) {
                n0();
            }
        }
    }

    public ColorStateList V() {
        return this.f23049g;
    }

    public void V0(CharSequence charSequence) {
        if (this.f23070x != charSequence) {
            this.f23070x = H.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public C1008i W() {
        return this.f23013C;
    }

    public void W0(float f10) {
        if (this.f23021K != f10) {
            this.f23021K = f10;
            invalidateSelf();
            if (H1()) {
                n0();
            }
        }
    }

    public CharSequence X() {
        return this.f23051h;
    }

    public void X0(int i10) {
        W0(this.f23023M.getResources().getDimension(i10));
    }

    public C1608d Y() {
        return this.f23030T.getTextAppearance();
    }

    public void Y0(int i10) {
        U0(C0991a.b(this.f23023M, i10));
    }

    public float Z() {
        return this.f23019I;
    }

    public void Z0(float f10) {
        if (this.f23069r != f10) {
            this.f23069r = f10;
            invalidateSelf();
            if (H1()) {
                n0();
            }
        }
    }

    public final void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        C.a.m(drawable, C.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f23065o) {
            if (drawable.isStateful()) {
                drawable.setState(M());
            }
            C.a.o(drawable, this.f23068q);
            return;
        }
        Drawable drawable2 = this.f23055j;
        if (drawable == drawable2 && this.f23061m) {
            C.a.o(drawable2, this.f23057k);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public float a0() {
        return this.f23018H;
    }

    public void a1(int i10) {
        Z0(this.f23023M.getResources().getDimension(i10));
    }

    public final void b(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (G1() || F1()) {
            float f10 = this.f23015E + this.f23016F;
            float Q10 = Q();
            if (C.a.f(this) == 0) {
                float f11 = rect.left + f10;
                rectF.left = f11;
                rectF.right = f11 + Q10;
            } else {
                float f12 = rect.right - f10;
                rectF.right = f12;
                rectF.left = f12 - Q10;
            }
            float P10 = P();
            float exactCenterY = rect.exactCenterY() - (P10 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + P10;
        }
    }

    public final ColorFilter b0() {
        ColorFilter colorFilter = this.f23044d0;
        if (colorFilter == null) {
            return this.f23046e0;
        }
        return colorFilter;
    }

    public void b1(float f10) {
        if (this.f23020J != f10) {
            this.f23020J = f10;
            invalidateSelf();
            if (H1()) {
                n0();
            }
        }
    }

    public float c() {
        if (!G1() && !F1()) {
            return 0.0f;
        }
        return this.f23016F + Q() + this.f23017G;
    }

    public boolean c0() {
        return this.f23054i0;
    }

    public void c1(int i10) {
        b1(this.f23023M.getResources().getDimension(i10));
    }

    public final void d(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (H1()) {
            float f10 = this.f23022L + this.f23021K + this.f23069r + this.f23020J + this.f23019I;
            if (C.a.f(this) == 0) {
                rectF.right = rect.right - f10;
            } else {
                rectF.left = rect.left + f10;
            }
        }
    }

    public boolean d1(int[] iArr) {
        if (!Arrays.equals(this.f23052h0, iArr)) {
            this.f23052h0 = iArr;
            if (H1()) {
                return o0(getState(), iArr);
            }
            return false;
        }
        return false;
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i10;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i11 = this.f23042c0;
            if (i11 < 255) {
                i10 = C1079a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i11);
            } else {
                i10 = 0;
            }
            q(canvas, bounds);
            n(canvas, bounds);
            if (this.f23066o0) {
                super.draw(canvas);
            }
            p(canvas, bounds);
            s(canvas, bounds);
            o(canvas, bounds);
            m(canvas, bounds);
            if (this.f23062m0) {
                u(canvas, bounds);
            }
            r(canvas, bounds);
            t(canvas, bounds);
            if (this.f23042c0 < 255) {
                canvas.restoreToCount(i10);
            }
        }
    }

    public final void e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (H1()) {
            float f10 = this.f23022L + this.f23021K;
            if (C.a.f(this) == 0) {
                float f11 = rect.right - f10;
                rectF.right = f11;
                rectF.left = f11 - this.f23069r;
            } else {
                float f12 = rect.left + f10;
                rectF.left = f12;
                rectF.right = f12 + this.f23069r;
            }
            float exactCenterY = rect.exactCenterY();
            float f13 = this.f23069r;
            float f14 = exactCenterY - (f13 / 2.0f);
            rectF.top = f14;
            rectF.bottom = f14 + f13;
        }
    }

    public boolean e0() {
        return this.f23071y;
    }

    public void e1(ColorStateList colorStateList) {
        if (this.f23068q != colorStateList) {
            this.f23068q = colorStateList;
            if (H1()) {
                C.a.o(this.f23065o, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void f(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (H1()) {
            float f10 = this.f23022L + this.f23021K + this.f23069r + this.f23020J + this.f23019I;
            if (C.a.f(this) == 0) {
                float f11 = rect.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                int i10 = rect.left;
                rectF.left = i10;
                rectF.right = i10 + f10;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean f0() {
        return this.f23072z;
    }

    public void f1(int i10) {
        e1(C0991a.a(this.f23023M, i10));
    }

    public float g() {
        if (H1()) {
            return this.f23020J + this.f23069r + this.f23021K;
        }
        return 0.0f;
    }

    public boolean g0() {
        return this.f23053i;
    }

    public void g1(boolean z10) {
        if (this.f23063n != z10) {
            boolean H12 = H1();
            this.f23063n = z10;
            boolean H13 = H1();
            if (H12 != H13) {
                if (H13) {
                    a(this.f23065o);
                } else {
                    I1(this.f23065o);
                }
                invalidateSelf();
                n0();
            }
        }
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f23042c0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f23044d0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f23041c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f23015E + c() + this.f23018H + this.f23030T.getTextWidth(X().toString()) + this.f23019I + g() + this.f23022L), this.f23064n0);
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f23066o0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.f23043d);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f23043d);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public final void h(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f23051h != null) {
            float c10 = this.f23015E + c() + this.f23018H;
            float g10 = this.f23022L + g() + this.f23019I;
            if (C.a.f(this) == 0) {
                rectF.left = rect.left + c10;
                rectF.right = rect.right - g10;
            } else {
                rectF.left = rect.left + g10;
                rectF.right = rect.right - c10;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean h0() {
        return k0(this.f23065o);
    }

    public void h1(InterfaceC0211a interfaceC0211a) {
        this.f23058k0 = new WeakReference<>(interfaceC0211a);
    }

    public final float i() {
        this.f23030T.getTextPaint().getFontMetrics(this.f23026P);
        Paint.FontMetrics fontMetrics = this.f23026P;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public boolean i0() {
        return this.f23063n;
    }

    public void i1(TextUtils.TruncateAt truncateAt) {
        this.f23060l0 = truncateAt;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (!j0(this.f23037a) && !j0(this.f23039b) && !j0(this.f23045e) && ((!this.f23054i0 || !j0(this.f23056j0)) && !l0(this.f23030T.getTextAppearance()) && !k() && !k0(this.f23055j) && !k0(this.f23011A) && !j0(this.f23048f0))) {
            return false;
        }
        return true;
    }

    public Paint.Align j(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f23051h != null) {
            float c10 = this.f23015E + c() + this.f23018H;
            if (C.a.f(this) == 0) {
                pointF.x = rect.left + c10;
            } else {
                pointF.x = rect.right - c10;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - i();
        }
        return align;
    }

    public void j1(C1008i c1008i) {
        this.f23014D = c1008i;
    }

    public final boolean k() {
        if (this.f23072z && this.f23011A != null && this.f23071y) {
            return true;
        }
        return false;
    }

    public void k1(int i10) {
        j1(C1008i.d(this.f23023M, i10));
    }

    public void l1(float f10) {
        if (this.f23017G != f10) {
            float c10 = c();
            this.f23017G = f10;
            float c11 = c();
            invalidateSelf();
            if (c10 != c11) {
                n0();
            }
        }
    }

    public final void m(Canvas canvas, Rect rect) {
        if (F1()) {
            b(rect, this.f23027Q);
            RectF rectF = this.f23027Q;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f23011A.setBounds(0, 0, (int) this.f23027Q.width(), (int) this.f23027Q.height());
            this.f23011A.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    public final void m0(AttributeSet attributeSet, int i10, int i11) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.f23023M, attributeSet, m.f31528s1, i10, i11, new int[0]);
        this.f23066o0 = obtainStyledAttributes.hasValue(m.f31364d2);
        T0(C1607c.a(this.f23023M, obtainStyledAttributes, m.f31222Q1));
        x0(C1607c.a(this.f23023M, obtainStyledAttributes, m.f31079D1));
        L0(obtainStyledAttributes.getDimension(m.f31167L1, 0.0f));
        int i12 = m.f31090E1;
        if (obtainStyledAttributes.hasValue(i12)) {
            z0(obtainStyledAttributes.getDimension(i12, 0.0f));
        }
        P0(C1607c.a(this.f23023M, obtainStyledAttributes, m.f31200O1));
        R0(obtainStyledAttributes.getDimension(m.f31211P1, 0.0f));
        q1(C1607c.a(this.f23023M, obtainStyledAttributes, m.f31353c2));
        v1(obtainStyledAttributes.getText(m.f31583x1));
        C1608d h10 = C1607c.h(this.f23023M, obtainStyledAttributes, m.f31539t1);
        h10.l(obtainStyledAttributes.getDimension(m.f31550u1, h10.j()));
        w1(h10);
        int i13 = obtainStyledAttributes.getInt(m.f31561v1, 0);
        if (i13 != 1) {
            if (i13 != 2) {
                if (i13 == 3) {
                    i1(TextUtils.TruncateAt.END);
                }
            } else {
                i1(TextUtils.TruncateAt.MIDDLE);
            }
        } else {
            i1(TextUtils.TruncateAt.START);
        }
        K0(obtainStyledAttributes.getBoolean(m.f31156K1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            K0(obtainStyledAttributes.getBoolean(m.f31123H1, false));
        }
        D0(C1607c.e(this.f23023M, obtainStyledAttributes, m.f31112G1));
        int i14 = m.f31145J1;
        if (obtainStyledAttributes.hasValue(i14)) {
            H0(C1607c.a(this.f23023M, obtainStyledAttributes, i14));
        }
        F0(obtainStyledAttributes.getDimension(m.f31134I1, -1.0f));
        g1(obtainStyledAttributes.getBoolean(m.f31299X1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            g1(obtainStyledAttributes.getBoolean(m.f31244S1, false));
        }
        U0(C1607c.e(this.f23023M, obtainStyledAttributes, m.f31233R1));
        e1(C1607c.a(this.f23023M, obtainStyledAttributes, m.f31288W1));
        Z0(obtainStyledAttributes.getDimension(m.f31266U1, 0.0f));
        p0(obtainStyledAttributes.getBoolean(m.f31594y1, false));
        w0(obtainStyledAttributes.getBoolean(m.f31068C1, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            w0(obtainStyledAttributes.getBoolean(m.f31046A1, false));
        }
        r0(C1607c.e(this.f23023M, obtainStyledAttributes, m.f31605z1));
        int i15 = m.f31057B1;
        if (obtainStyledAttributes.hasValue(i15)) {
            t0(C1607c.a(this.f23023M, obtainStyledAttributes, i15));
        }
        t1(C1008i.c(this.f23023M, obtainStyledAttributes, m.f31375e2));
        j1(C1008i.c(this.f23023M, obtainStyledAttributes, m.f31320Z1));
        N0(obtainStyledAttributes.getDimension(m.f31189N1, 0.0f));
        n1(obtainStyledAttributes.getDimension(m.f31342b2, 0.0f));
        l1(obtainStyledAttributes.getDimension(m.f31331a2, 0.0f));
        B1(obtainStyledAttributes.getDimension(m.f31397g2, 0.0f));
        y1(obtainStyledAttributes.getDimension(m.f31386f2, 0.0f));
        b1(obtainStyledAttributes.getDimension(m.f31277V1, 0.0f));
        W0(obtainStyledAttributes.getDimension(m.f31255T1, 0.0f));
        B0(obtainStyledAttributes.getDimension(m.f31101F1, 0.0f));
        p1(obtainStyledAttributes.getDimensionPixelSize(m.f31572w1, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }

    public void m1(int i10) {
        l1(this.f23023M.getResources().getDimension(i10));
    }

    public final void n(Canvas canvas, Rect rect) {
        if (!this.f23066o0) {
            this.f23024N.setColor(this.f23032V);
            this.f23024N.setStyle(Paint.Style.FILL);
            this.f23024N.setColorFilter(b0());
            this.f23027Q.set(rect);
            canvas.drawRoundRect(this.f23027Q, y(), y(), this.f23024N);
        }
    }

    public void n0() {
        InterfaceC0211a interfaceC0211a = this.f23058k0.get();
        if (interfaceC0211a != null) {
            interfaceC0211a.onChipDrawableSizeChange();
        }
    }

    public void n1(float f10) {
        if (this.f23016F != f10) {
            float c10 = c();
            this.f23016F = f10;
            float c11 = c();
            invalidateSelf();
            if (c10 != c11) {
                n0();
            }
        }
    }

    public final void o(Canvas canvas, Rect rect) {
        if (G1()) {
            b(rect, this.f23027Q);
            RectF rectF = this.f23027Q;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f23055j.setBounds(0, 0, (int) this.f23027Q.width(), (int) this.f23027Q.height());
            this.f23055j.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    public final boolean o0(int[] iArr, int[] iArr2) {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        int i12;
        int i13;
        int i14;
        boolean z12;
        boolean z13;
        int i15;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f23037a;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(iArr, this.f23031U);
        } else {
            i10 = 0;
        }
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(i10);
        boolean z14 = true;
        if (this.f23031U != compositeElevationOverlayIfNeeded) {
            this.f23031U = compositeElevationOverlayIfNeeded;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.f23039b;
        if (colorStateList2 != null) {
            i11 = colorStateList2.getColorForState(iArr, this.f23032V);
        } else {
            i11 = 0;
        }
        int compositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(i11);
        if (this.f23032V != compositeElevationOverlayIfNeeded2) {
            this.f23032V = compositeElevationOverlayIfNeeded2;
            onStateChange = true;
        }
        int i16 = C1292a.i(compositeElevationOverlayIfNeeded, compositeElevationOverlayIfNeeded2);
        if (this.f23033W != i16) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getFillColor() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 | z11) {
            this.f23033W = i16;
            setFillColor(ColorStateList.valueOf(i16));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.f23045e;
        if (colorStateList3 != null) {
            i12 = colorStateList3.getColorForState(iArr, this.f23034X);
        } else {
            i12 = 0;
        }
        if (this.f23034X != i12) {
            this.f23034X = i12;
            onStateChange = true;
        }
        if (this.f23056j0 != null && b.e(iArr)) {
            i13 = this.f23056j0.getColorForState(iArr, this.f23035Y);
        } else {
            i13 = 0;
        }
        if (this.f23035Y != i13) {
            this.f23035Y = i13;
            if (this.f23054i0) {
                onStateChange = true;
            }
        }
        if (this.f23030T.getTextAppearance() != null && this.f23030T.getTextAppearance().i() != null) {
            i14 = this.f23030T.getTextAppearance().i().getColorForState(iArr, this.f23036Z);
        } else {
            i14 = 0;
        }
        if (this.f23036Z != i14) {
            this.f23036Z = i14;
            onStateChange = true;
        }
        if (d0(getState(), R.attr.state_checked) && this.f23071y) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (this.f23038a0 != z12 && this.f23011A != null) {
            float c10 = c();
            this.f23038a0 = z12;
            if (c10 != c()) {
                onStateChange = true;
                z13 = true;
            } else {
                z13 = false;
                onStateChange = true;
            }
        } else {
            z13 = false;
        }
        ColorStateList colorStateList4 = this.f23048f0;
        if (colorStateList4 != null) {
            i15 = colorStateList4.getColorForState(iArr, this.f23040b0);
        } else {
            i15 = 0;
        }
        if (this.f23040b0 != i15) {
            this.f23040b0 = i15;
            this.f23046e0 = C1370a.o(this, this.f23048f0, this.f23050g0);
        } else {
            z14 = onStateChange;
        }
        if (k0(this.f23055j)) {
            z14 |= this.f23055j.setState(iArr);
        }
        if (k0(this.f23011A)) {
            z14 |= this.f23011A.setState(iArr);
        }
        if (k0(this.f23065o)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z14 |= this.f23065o.setState(iArr3);
        }
        if (b.f37396a && k0(this.f23067p)) {
            z14 |= this.f23067p.setState(iArr2);
        }
        if (z14) {
            invalidateSelf();
        }
        if (z13) {
            n0();
        }
        return z14;
    }

    public void o1(int i10) {
        n1(this.f23023M.getResources().getDimension(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (G1()) {
            onLayoutDirectionChanged |= C.a.m(this.f23055j, i10);
        }
        if (F1()) {
            onLayoutDirectionChanged |= C.a.m(this.f23011A, i10);
        }
        if (H1()) {
            onLayoutDirectionChanged |= C.a.m(this.f23065o, i10);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        boolean onLevelChange = super.onLevelChange(i10);
        if (G1()) {
            onLevelChange |= this.f23055j.setLevel(i10);
        }
        if (F1()) {
            onLevelChange |= this.f23011A.setLevel(i10);
        }
        if (H1()) {
            onLevelChange |= this.f23065o.setLevel(i10);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // x4.i, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        if (this.f23066o0) {
            super.onStateChange(iArr);
        }
        return o0(iArr, M());
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        n0();
        invalidateSelf();
    }

    public final void p(Canvas canvas, Rect rect) {
        if (this.f23047f > 0.0f && !this.f23066o0) {
            this.f23024N.setColor(this.f23034X);
            this.f23024N.setStyle(Paint.Style.STROKE);
            if (!this.f23066o0) {
                this.f23024N.setColorFilter(b0());
            }
            RectF rectF = this.f23027Q;
            float f10 = rect.left;
            float f11 = this.f23047f;
            rectF.set(f10 + (f11 / 2.0f), rect.top + (f11 / 2.0f), rect.right - (f11 / 2.0f), rect.bottom - (f11 / 2.0f));
            float f12 = this.f23043d - (this.f23047f / 2.0f);
            canvas.drawRoundRect(this.f23027Q, f12, f12, this.f23024N);
        }
    }

    public void p0(boolean z10) {
        if (this.f23071y != z10) {
            this.f23071y = z10;
            float c10 = c();
            if (!z10 && this.f23038a0) {
                this.f23038a0 = false;
            }
            float c11 = c();
            invalidateSelf();
            if (c10 != c11) {
                n0();
            }
        }
    }

    public void p1(int i10) {
        this.f23064n0 = i10;
    }

    public final void q(Canvas canvas, Rect rect) {
        if (!this.f23066o0) {
            this.f23024N.setColor(this.f23031U);
            this.f23024N.setStyle(Paint.Style.FILL);
            this.f23027Q.set(rect);
            canvas.drawRoundRect(this.f23027Q, y(), y(), this.f23024N);
        }
    }

    public void q0(int i10) {
        p0(this.f23023M.getResources().getBoolean(i10));
    }

    public void q1(ColorStateList colorStateList) {
        if (this.f23049g != colorStateList) {
            this.f23049g = colorStateList;
            J1();
            onStateChange(getState());
        }
    }

    public final void r(Canvas canvas, Rect rect) {
        if (H1()) {
            e(rect, this.f23027Q);
            RectF rectF = this.f23027Q;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f23065o.setBounds(0, 0, (int) this.f23027Q.width(), (int) this.f23027Q.height());
            if (b.f37396a) {
                this.f23067p.setBounds(this.f23065o.getBounds());
                this.f23067p.jumpToCurrentState();
                this.f23067p.draw(canvas);
            } else {
                this.f23065o.draw(canvas);
            }
            canvas.translate(-f10, -f11);
        }
    }

    public void r0(Drawable drawable) {
        if (this.f23011A != drawable) {
            float c10 = c();
            this.f23011A = drawable;
            float c11 = c();
            I1(this.f23011A);
            a(this.f23011A);
            invalidateSelf();
            if (c10 != c11) {
                n0();
            }
        }
    }

    public void r1(int i10) {
        q1(C0991a.a(this.f23023M, i10));
    }

    public final void s(Canvas canvas, Rect rect) {
        this.f23024N.setColor(this.f23035Y);
        this.f23024N.setStyle(Paint.Style.FILL);
        this.f23027Q.set(rect);
        if (!this.f23066o0) {
            canvas.drawRoundRect(this.f23027Q, y(), y(), this.f23024N);
        } else {
            calculatePathForSize(new RectF(rect), this.f23029S);
            super.drawShape(canvas, this.f23024N, this.f23029S, getBoundsAsRectF());
        }
    }

    public void s0(int i10) {
        r0(C0991a.b(this.f23023M, i10));
    }

    public void s1(boolean z10) {
        this.f23062m0 = z10;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f23042c0 != i10) {
            this.f23042c0 = i10;
            invalidateSelf();
        }
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f23044d0 != colorFilter) {
            this.f23044d0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f23048f0 != colorStateList) {
            this.f23048f0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // x4.i, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f23050g0 != mode) {
            this.f23050g0 = mode;
            this.f23046e0 = C1370a.o(this, this.f23048f0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (G1()) {
            visible |= this.f23055j.setVisible(z10, z11);
        }
        if (F1()) {
            visible |= this.f23011A.setVisible(z10, z11);
        }
        if (H1()) {
            visible |= this.f23065o.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t(Canvas canvas, Rect rect) {
        Paint paint = this.f23025O;
        if (paint != null) {
            paint.setColor(B.a.w(-16777216, 127));
            canvas.drawRect(rect, this.f23025O);
            if (G1() || F1()) {
                b(rect, this.f23027Q);
                canvas.drawRect(this.f23027Q, this.f23025O);
            }
            if (this.f23051h != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f23025O);
            }
            if (H1()) {
                e(rect, this.f23027Q);
                canvas.drawRect(this.f23027Q, this.f23025O);
            }
            this.f23025O.setColor(B.a.w(-65536, 127));
            d(rect, this.f23027Q);
            canvas.drawRect(this.f23027Q, this.f23025O);
            this.f23025O.setColor(B.a.w(-16711936, 127));
            f(rect, this.f23027Q);
            canvas.drawRect(this.f23027Q, this.f23025O);
        }
    }

    public void t0(ColorStateList colorStateList) {
        if (this.f23012B != colorStateList) {
            this.f23012B = colorStateList;
            if (k()) {
                C.a.o(this.f23011A, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void t1(C1008i c1008i) {
        this.f23013C = c1008i;
    }

    public final void u(Canvas canvas, Rect rect) {
        boolean z10;
        if (this.f23051h != null) {
            Paint.Align j10 = j(rect, this.f23028R);
            h(rect, this.f23027Q);
            if (this.f23030T.getTextAppearance() != null) {
                this.f23030T.getTextPaint().drawableState = getState();
                this.f23030T.updateTextPaintDrawState(this.f23023M);
            }
            this.f23030T.getTextPaint().setTextAlign(j10);
            int i10 = 0;
            if (Math.round(this.f23030T.getTextWidth(X().toString())) > Math.round(this.f23027Q.width())) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i10 = canvas.save();
                canvas.clipRect(this.f23027Q);
            }
            CharSequence charSequence = this.f23051h;
            if (z10 && this.f23060l0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f23030T.getTextPaint(), this.f23027Q.width(), this.f23060l0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f23028R;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f23030T.getTextPaint());
            if (z10) {
                canvas.restoreToCount(i10);
            }
        }
    }

    public void u0(int i10) {
        t0(C0991a.a(this.f23023M, i10));
    }

    public void u1(int i10) {
        t1(C1008i.d(this.f23023M, i10));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public Drawable v() {
        return this.f23011A;
    }

    public void v0(int i10) {
        w0(this.f23023M.getResources().getBoolean(i10));
    }

    public void v1(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.f23051h, charSequence)) {
            this.f23051h = charSequence;
            this.f23030T.setTextWidthDirty(true);
            invalidateSelf();
            n0();
        }
    }

    public ColorStateList w() {
        return this.f23012B;
    }

    public void w0(boolean z10) {
        if (this.f23072z != z10) {
            boolean F12 = F1();
            this.f23072z = z10;
            boolean F13 = F1();
            if (F12 != F13) {
                if (F13) {
                    a(this.f23011A);
                } else {
                    I1(this.f23011A);
                }
                invalidateSelf();
                n0();
            }
        }
    }

    public void w1(C1608d c1608d) {
        this.f23030T.setTextAppearance(c1608d, this.f23023M);
    }

    public ColorStateList x() {
        return this.f23039b;
    }

    public void x0(ColorStateList colorStateList) {
        if (this.f23039b != colorStateList) {
            this.f23039b = colorStateList;
            onStateChange(getState());
        }
    }

    public void x1(int i10) {
        w1(new C1608d(this.f23023M, i10));
    }

    public float y() {
        if (this.f23066o0) {
            return getTopLeftCornerResolvedSize();
        }
        return this.f23043d;
    }

    public void y0(int i10) {
        x0(C0991a.a(this.f23023M, i10));
    }

    public void y1(float f10) {
        if (this.f23019I != f10) {
            this.f23019I = f10;
            invalidateSelf();
            n0();
        }
    }

    public float z() {
        return this.f23022L;
    }

    @Deprecated
    public void z0(float f10) {
        if (this.f23043d != f10) {
            this.f23043d = f10;
            setShapeAppearanceModel(getShapeAppearanceModel().w(f10));
        }
    }

    public void z1(int i10) {
        y1(this.f23023M.getResources().getDimension(i10));
    }
}
