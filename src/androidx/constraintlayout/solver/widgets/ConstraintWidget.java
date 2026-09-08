package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import u.C1599a;
import w.C1640c;

/* loaded from: classes.dex */
public class ConstraintWidget {

    /* renamed from: M0, reason: collision with root package name */
    public static float f8307M0 = 0.5f;

    /* renamed from: A0, reason: collision with root package name */
    public boolean f8309A0;

    /* renamed from: B0, reason: collision with root package name */
    public int f8311B0;

    /* renamed from: C0, reason: collision with root package name */
    public int f8313C0;

    /* renamed from: D0, reason: collision with root package name */
    public boolean f8315D0;

    /* renamed from: E0, reason: collision with root package name */
    public boolean f8317E0;

    /* renamed from: F, reason: collision with root package name */
    public boolean f8318F;

    /* renamed from: F0, reason: collision with root package name */
    public float[] f8319F0;

    /* renamed from: G0, reason: collision with root package name */
    public ConstraintWidget[] f8321G0;

    /* renamed from: H0, reason: collision with root package name */
    public ConstraintWidget[] f8323H0;

    /* renamed from: I0, reason: collision with root package name */
    public ConstraintWidget f8325I0;

    /* renamed from: J0, reason: collision with root package name */
    public ConstraintWidget f8327J0;

    /* renamed from: K0, reason: collision with root package name */
    public int f8329K0;

    /* renamed from: L0, reason: collision with root package name */
    public int f8331L0;

    /* renamed from: Q, reason: collision with root package name */
    public ConstraintAnchor f8336Q;

    /* renamed from: R, reason: collision with root package name */
    public ConstraintAnchor[] f8337R;

    /* renamed from: S, reason: collision with root package name */
    public ArrayList<ConstraintAnchor> f8338S;

    /* renamed from: T, reason: collision with root package name */
    public boolean[] f8339T;

    /* renamed from: U, reason: collision with root package name */
    public DimensionBehaviour[] f8340U;

    /* renamed from: V, reason: collision with root package name */
    public ConstraintWidget f8341V;

    /* renamed from: W, reason: collision with root package name */
    public int f8342W;

    /* renamed from: X, reason: collision with root package name */
    public int f8343X;

    /* renamed from: Y, reason: collision with root package name */
    public float f8344Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f8345Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f8347a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f8349b0;

    /* renamed from: c, reason: collision with root package name */
    public C1640c f8350c;

    /* renamed from: c0, reason: collision with root package name */
    public int f8351c0;

    /* renamed from: d, reason: collision with root package name */
    public C1640c f8352d;

    /* renamed from: d0, reason: collision with root package name */
    public int f8353d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f8355e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f8357f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f8359g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f8361h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f8363i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f8365j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f8367k0;

    /* renamed from: l0, reason: collision with root package name */
    public Object f8369l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f8371m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f8373n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f8375o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f8377p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f8379q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f8381r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f8383s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f8385t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f8387u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f8389v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f8391w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f8393x0;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8394y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f8395y0;

    /* renamed from: z, reason: collision with root package name */
    public boolean f8396z;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f8397z0;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8346a = false;

    /* renamed from: b, reason: collision with root package name */
    public WidgetRun[] f8348b = new WidgetRun[2];

    /* renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.analyzer.c f8354e = null;

    /* renamed from: f, reason: collision with root package name */
    public androidx.constraintlayout.solver.widgets.analyzer.d f8356f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean[] f8358g = {true, true};

    /* renamed from: h, reason: collision with root package name */
    public boolean f8360h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8362i = true;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8364j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8366k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8368l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8370m = false;

    /* renamed from: n, reason: collision with root package name */
    public int f8372n = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f8374o = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f8376p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f8378q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int[] f8380r = new int[2];

    /* renamed from: s, reason: collision with root package name */
    public int f8382s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f8384t = 0;

    /* renamed from: u, reason: collision with root package name */
    public float f8386u = 1.0f;

    /* renamed from: v, reason: collision with root package name */
    public int f8388v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f8390w = 0;

    /* renamed from: x, reason: collision with root package name */
    public float f8392x = 1.0f;

    /* renamed from: A, reason: collision with root package name */
    public int f8308A = -1;

    /* renamed from: B, reason: collision with root package name */
    public float f8310B = 1.0f;

    /* renamed from: C, reason: collision with root package name */
    public int[] f8312C = {Integer.MAX_VALUE, Integer.MAX_VALUE};

    /* renamed from: D, reason: collision with root package name */
    public float f8314D = 0.0f;

    /* renamed from: E, reason: collision with root package name */
    public boolean f8316E = false;

    /* renamed from: G, reason: collision with root package name */
    public boolean f8320G = false;

    /* renamed from: H, reason: collision with root package name */
    public int f8322H = 0;

    /* renamed from: I, reason: collision with root package name */
    public int f8324I = 0;

    /* renamed from: J, reason: collision with root package name */
    public ConstraintAnchor f8326J = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);

    /* renamed from: K, reason: collision with root package name */
    public ConstraintAnchor f8328K = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);

    /* renamed from: L, reason: collision with root package name */
    public ConstraintAnchor f8330L = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);

    /* renamed from: M, reason: collision with root package name */
    public ConstraintAnchor f8332M = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);

    /* renamed from: N, reason: collision with root package name */
    public ConstraintAnchor f8333N = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);

    /* renamed from: O, reason: collision with root package name */
    public ConstraintAnchor f8334O = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);

    /* renamed from: P, reason: collision with root package name */
    public ConstraintAnchor f8335P = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8403a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f8404b;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f8404b = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8404b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8404b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8404b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f8403a = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8403a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8403a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8403a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8403a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8403a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8403a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8403a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8403a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.f8336Q = constraintAnchor;
        this.f8337R = new ConstraintAnchor[]{this.f8326J, this.f8330L, this.f8328K, this.f8332M, this.f8333N, constraintAnchor};
        this.f8338S = new ArrayList<>();
        this.f8339T = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.f8340U = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.f8341V = null;
        this.f8342W = 0;
        this.f8343X = 0;
        this.f8344Y = 0.0f;
        this.f8345Z = -1;
        this.f8347a0 = 0;
        this.f8349b0 = 0;
        this.f8351c0 = 0;
        this.f8353d0 = 0;
        this.f8355e0 = 0;
        this.f8357f0 = 0;
        this.f8359g0 = 0;
        float f10 = f8307M0;
        this.f8365j0 = f10;
        this.f8367k0 = f10;
        this.f8371m0 = 0;
        this.f8373n0 = 0;
        this.f8375o0 = null;
        this.f8377p0 = null;
        this.f8309A0 = false;
        this.f8311B0 = 0;
        this.f8313C0 = 0;
        this.f8319F0 = new float[]{-1.0f, -1.0f};
        this.f8321G0 = new ConstraintWidget[]{null, null};
        this.f8323H0 = new ConstraintWidget[]{null, null};
        this.f8325I0 = null;
        this.f8327J0 = null;
        this.f8329K0 = -1;
        this.f8331L0 = -1;
        d();
    }

    public int A() {
        return this.f8311B0;
    }

    public void A0(float f10) {
        this.f8365j0 = f10;
    }

    public DimensionBehaviour B() {
        return this.f8340U[0];
    }

    public void B0(int i10) {
        this.f8311B0 = i10;
    }

    public int C() {
        int i10;
        ConstraintAnchor constraintAnchor = this.f8326J;
        if (constraintAnchor != null) {
            i10 = constraintAnchor.f8293g;
        } else {
            i10 = 0;
        }
        ConstraintAnchor constraintAnchor2 = this.f8330L;
        if (constraintAnchor2 != null) {
            return i10 + constraintAnchor2.f8293g;
        }
        return i10;
    }

    public void C0(int i10, int i11) {
        this.f8347a0 = i10;
        int i12 = i11 - i10;
        this.f8342W = i12;
        int i13 = this.f8361h0;
        if (i12 < i13) {
            this.f8342W = i13;
        }
    }

    public int D() {
        return this.f8322H;
    }

    public void D0(DimensionBehaviour dimensionBehaviour) {
        this.f8340U[0] = dimensionBehaviour;
    }

    public int E() {
        return this.f8324I;
    }

    public void E0(int i10, int i11, int i12, float f10) {
        this.f8376p = i10;
        this.f8382s = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f8384t = i12;
        this.f8386u = f10;
        if (f10 > 0.0f && f10 < 1.0f && i10 == 0) {
            this.f8376p = 2;
        }
    }

    public int F(int i10) {
        if (i10 == 0) {
            return U();
        }
        if (i10 == 1) {
            return y();
        }
        return 0;
    }

    public void F0(float f10) {
        this.f8319F0[0] = f10;
    }

    public int G() {
        return this.f8312C[1];
    }

    public void G0(int i10, boolean z10) {
        this.f8339T[i10] = z10;
    }

    public int H() {
        return this.f8312C[0];
    }

    public void H0(boolean z10) {
        this.f8318F = z10;
    }

    public int I() {
        return this.f8363i0;
    }

    public void I0(boolean z10) {
        this.f8320G = z10;
    }

    public int J() {
        return this.f8361h0;
    }

    public void J0(int i10, int i11) {
        this.f8322H = i10;
        this.f8324I = i11;
        M0(false);
    }

    public ConstraintWidget K(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.f8330L;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f8292f;
            if (constraintAnchor4 != null && constraintAnchor4.f8292f == constraintAnchor3) {
                return constraintAnchor4.f8290d;
            }
            return null;
        }
        if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.f8332M).f8292f) != null && constraintAnchor2.f8292f == constraintAnchor) {
            return constraintAnchor2.f8290d;
        }
        return null;
    }

    public void K0(int i10) {
        this.f8312C[1] = i10;
    }

    public ConstraintWidget L() {
        return this.f8341V;
    }

    public void L0(int i10) {
        this.f8312C[0] = i10;
    }

    public ConstraintWidget M(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i10 == 0) {
            ConstraintAnchor constraintAnchor3 = this.f8326J;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f8292f;
            if (constraintAnchor4 != null && constraintAnchor4.f8292f == constraintAnchor3) {
                return constraintAnchor4.f8290d;
            }
            return null;
        }
        if (i10 == 1 && (constraintAnchor2 = (constraintAnchor = this.f8328K).f8292f) != null && constraintAnchor2.f8292f == constraintAnchor) {
            return constraintAnchor2.f8290d;
        }
        return null;
    }

    public void M0(boolean z10) {
        this.f8362i = z10;
    }

    public int N() {
        return V() + this.f8342W;
    }

    public void N0(int i10) {
        if (i10 < 0) {
            this.f8363i0 = 0;
        } else {
            this.f8363i0 = i10;
        }
    }

    public WidgetRun O(int i10) {
        if (i10 == 0) {
            return this.f8354e;
        }
        if (i10 == 1) {
            return this.f8356f;
        }
        return null;
    }

    public void O0(int i10) {
        if (i10 < 0) {
            this.f8361h0 = 0;
        } else {
            this.f8361h0 = i10;
        }
    }

    public float P() {
        return this.f8367k0;
    }

    public void P0(int i10, int i11) {
        this.f8347a0 = i10;
        this.f8349b0 = i11;
    }

    public int Q() {
        return this.f8313C0;
    }

    public void Q0(ConstraintWidget constraintWidget) {
        this.f8341V = constraintWidget;
    }

    public DimensionBehaviour R() {
        return this.f8340U[1];
    }

    public void R0(float f10) {
        this.f8367k0 = f10;
    }

    public int S() {
        int i10;
        if (this.f8326J != null) {
            i10 = this.f8328K.f8293g;
        } else {
            i10 = 0;
        }
        if (this.f8330L != null) {
            return i10 + this.f8332M.f8293g;
        }
        return i10;
    }

    public void S0(int i10) {
        this.f8313C0 = i10;
    }

    public int T() {
        return this.f8373n0;
    }

    public void T0(int i10, int i11) {
        this.f8349b0 = i10;
        int i12 = i11 - i10;
        this.f8343X = i12;
        int i13 = this.f8363i0;
        if (i12 < i13) {
            this.f8343X = i13;
        }
    }

    public int U() {
        if (this.f8373n0 == 8) {
            return 0;
        }
        return this.f8342W;
    }

    public void U0(DimensionBehaviour dimensionBehaviour) {
        this.f8340U[1] = dimensionBehaviour;
    }

    public int V() {
        ConstraintWidget constraintWidget = this.f8341V;
        if (constraintWidget != null && (constraintWidget instanceof d)) {
            return ((d) constraintWidget).f8479T0 + this.f8347a0;
        }
        return this.f8347a0;
    }

    public void V0(int i10, int i11, int i12, float f10) {
        this.f8378q = i10;
        this.f8388v = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.f8390w = i12;
        this.f8392x = f10;
        if (f10 > 0.0f && f10 < 1.0f && i10 == 0) {
            this.f8378q = 2;
        }
    }

    public int W() {
        ConstraintWidget constraintWidget = this.f8341V;
        if (constraintWidget != null && (constraintWidget instanceof d)) {
            return ((d) constraintWidget).f8480U0 + this.f8349b0;
        }
        return this.f8349b0;
    }

    public void W0(float f10) {
        this.f8319F0[1] = f10;
    }

    public boolean X() {
        return this.f8316E;
    }

    public void X0(int i10) {
        this.f8373n0 = i10;
    }

    public boolean Y(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (i10 == 0) {
            if (this.f8326J.f8292f != null) {
                i14 = 1;
            } else {
                i14 = 0;
            }
            if (this.f8330L.f8292f != null) {
                i15 = 1;
            } else {
                i15 = 0;
            }
            if (i14 + i15 >= 2) {
                return false;
            }
            return true;
        }
        if (this.f8328K.f8292f != null) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        if (this.f8332M.f8292f != null) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        int i16 = i11 + i12;
        if (this.f8333N.f8292f != null) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        if (i16 + i13 >= 2) {
            return false;
        }
        return true;
    }

    public void Y0(int i10) {
        this.f8342W = i10;
        int i11 = this.f8361h0;
        if (i10 < i11) {
            this.f8342W = i11;
        }
    }

    public boolean Z() {
        int size = this.f8338S.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f8338S.get(i10).m()) {
                return true;
            }
        }
        return false;
    }

    public void Z0(int i10) {
        this.f8347a0 = i10;
    }

    public void a0(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        p(type).b(constraintWidget.p(type2), i10, i11, true);
    }

    public void a1(int i10) {
        this.f8349b0 = i10;
    }

    public final boolean b0(int i10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i11 = i10 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.f8337R;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i11];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f8292f;
        if (constraintAnchor4 != null && constraintAnchor4.f8292f != constraintAnchor3 && (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i11 + 1]).f8292f) != null && constraintAnchor2.f8292f == constraintAnchor) {
            return true;
        }
        return false;
    }

    public void b1(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.f8308A == -1) {
            if (z12 && !z13) {
                this.f8308A = 0;
            } else if (!z12 && z13) {
                this.f8308A = 1;
                if (this.f8345Z == -1) {
                    this.f8310B = 1.0f / this.f8310B;
                }
            }
        }
        if (this.f8308A == 0 && (!this.f8328K.o() || !this.f8332M.o())) {
            this.f8308A = 1;
        } else if (this.f8308A == 1 && (!this.f8326J.o() || !this.f8330L.o())) {
            this.f8308A = 0;
        }
        if (this.f8308A == -1 && (!this.f8328K.o() || !this.f8332M.o() || !this.f8326J.o() || !this.f8330L.o())) {
            if (this.f8328K.o() && this.f8332M.o()) {
                this.f8308A = 0;
            } else if (this.f8326J.o() && this.f8330L.o()) {
                this.f8310B = 1.0f / this.f8310B;
                this.f8308A = 1;
            }
        }
        if (this.f8308A == -1) {
            int i10 = this.f8382s;
            if (i10 > 0 && this.f8388v == 0) {
                this.f8308A = 0;
            } else if (i10 == 0 && this.f8388v > 0) {
                this.f8310B = 1.0f / this.f8310B;
                this.f8308A = 1;
            }
        }
    }

    public boolean c0() {
        ConstraintAnchor constraintAnchor = this.f8326J;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f8292f;
        if (constraintAnchor2 == null || constraintAnchor2.f8292f != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.f8330L;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f8292f;
            if (constraintAnchor4 != null && constraintAnchor4.f8292f == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public void c1(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean k10 = z10 & this.f8354e.k();
        boolean k11 = z11 & this.f8356f.k();
        androidx.constraintlayout.solver.widgets.analyzer.c cVar = this.f8354e;
        int i12 = cVar.f8437h.f8415g;
        androidx.constraintlayout.solver.widgets.analyzer.d dVar = this.f8356f;
        int i13 = dVar.f8437h.f8415g;
        int i14 = cVar.f8438i.f8415g;
        int i15 = dVar.f8438i.f8415g;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (k10) {
            this.f8347a0 = i12;
        }
        if (k11) {
            this.f8349b0 = i13;
        }
        if (this.f8373n0 == 8) {
            this.f8342W = 0;
            this.f8343X = 0;
            return;
        }
        if (k10) {
            if (this.f8340U[0] == DimensionBehaviour.FIXED && i17 < (i11 = this.f8342W)) {
                i17 = i11;
            }
            this.f8342W = i17;
            int i19 = this.f8361h0;
            if (i17 < i19) {
                this.f8342W = i19;
            }
        }
        if (k11) {
            if (this.f8340U[1] == DimensionBehaviour.FIXED && i18 < (i10 = this.f8343X)) {
                i18 = i10;
            }
            this.f8343X = i18;
            int i20 = this.f8363i0;
            if (i18 < i20) {
                this.f8343X = i20;
            }
        }
    }

    public final void d() {
        this.f8338S.add(this.f8326J);
        this.f8338S.add(this.f8328K);
        this.f8338S.add(this.f8330L);
        this.f8338S.add(this.f8332M);
        this.f8338S.add(this.f8334O);
        this.f8338S.add(this.f8335P);
        this.f8338S.add(this.f8336Q);
        this.f8338S.add(this.f8333N);
    }

    public boolean d0() {
        return this.f8318F;
    }

    public void d1(androidx.constraintlayout.solver.c cVar, boolean z10) {
        androidx.constraintlayout.solver.widgets.analyzer.d dVar;
        androidx.constraintlayout.solver.widgets.analyzer.c cVar2;
        int y10 = cVar.y(this.f8326J);
        int y11 = cVar.y(this.f8328K);
        int y12 = cVar.y(this.f8330L);
        int y13 = cVar.y(this.f8332M);
        if (z10 && (cVar2 = this.f8354e) != null) {
            DependencyNode dependencyNode = cVar2.f8437h;
            if (dependencyNode.f8418j) {
                DependencyNode dependencyNode2 = cVar2.f8438i;
                if (dependencyNode2.f8418j) {
                    y10 = dependencyNode.f8415g;
                    y12 = dependencyNode2.f8415g;
                }
            }
        }
        if (z10 && (dVar = this.f8356f) != null) {
            DependencyNode dependencyNode3 = dVar.f8437h;
            if (dependencyNode3.f8418j) {
                DependencyNode dependencyNode4 = dVar.f8438i;
                if (dependencyNode4.f8418j) {
                    y11 = dependencyNode3.f8415g;
                    y13 = dependencyNode4.f8415g;
                }
            }
        }
        int i10 = y13 - y11;
        if (y12 - y10 < 0 || i10 < 0 || y10 == Integer.MIN_VALUE || y10 == Integer.MAX_VALUE || y11 == Integer.MIN_VALUE || y11 == Integer.MAX_VALUE || y12 == Integer.MIN_VALUE || y12 == Integer.MAX_VALUE || y13 == Integer.MIN_VALUE || y13 == Integer.MAX_VALUE) {
            y10 = 0;
            y13 = 0;
            y11 = 0;
            y12 = 0;
        }
        x0(y10, y11, y12, y13);
    }

    public void e(d dVar, androidx.constraintlayout.solver.c cVar, HashSet<ConstraintWidget> hashSet, int i10, boolean z10) {
        if (z10) {
            if (!hashSet.contains(this)) {
                return;
            }
            g.a(dVar, cVar, this);
            hashSet.remove(this);
            g(cVar, dVar.H1(64));
        }
        if (i10 == 0) {
            HashSet<ConstraintAnchor> d10 = this.f8326J.d();
            if (d10 != null) {
                Iterator<ConstraintAnchor> it = d10.iterator();
                while (it.hasNext()) {
                    it.next().f8290d.e(dVar, cVar, hashSet, i10, true);
                }
            }
            HashSet<ConstraintAnchor> d11 = this.f8330L.d();
            if (d11 != null) {
                Iterator<ConstraintAnchor> it2 = d11.iterator();
                while (it2.hasNext()) {
                    it2.next().f8290d.e(dVar, cVar, hashSet, i10, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> d12 = this.f8328K.d();
        if (d12 != null) {
            Iterator<ConstraintAnchor> it3 = d12.iterator();
            while (it3.hasNext()) {
                it3.next().f8290d.e(dVar, cVar, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> d13 = this.f8332M.d();
        if (d13 != null) {
            Iterator<ConstraintAnchor> it4 = d13.iterator();
            while (it4.hasNext()) {
                it4.next().f8290d.e(dVar, cVar, hashSet, i10, true);
            }
        }
        HashSet<ConstraintAnchor> d14 = this.f8333N.d();
        if (d14 != null) {
            Iterator<ConstraintAnchor> it5 = d14.iterator();
            while (it5.hasNext()) {
                it5.next().f8290d.e(dVar, cVar, hashSet, i10, true);
            }
        }
    }

    public boolean e0() {
        ConstraintAnchor constraintAnchor = this.f8328K;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f8292f;
        if (constraintAnchor2 == null || constraintAnchor2.f8292f != constraintAnchor) {
            ConstraintAnchor constraintAnchor3 = this.f8332M;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f8292f;
            if (constraintAnchor4 != null && constraintAnchor4.f8292f == constraintAnchor3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean f() {
        if (!(this instanceof h) && !(this instanceof f)) {
            return false;
        }
        return true;
    }

    public boolean f0() {
        return this.f8320G;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x048e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x02b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(androidx.constraintlayout.solver.c r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.g(androidx.constraintlayout.solver.c, boolean):void");
    }

    public boolean g0() {
        if (this.f8362i && this.f8373n0 != 8) {
            return true;
        }
        return false;
    }

    public boolean h() {
        if (this.f8373n0 != 8) {
            return true;
        }
        return false;
    }

    public boolean h0() {
        if (!this.f8368l && (!this.f8326J.n() || !this.f8330L.n())) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x037d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0416 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0492 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x04ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x04b2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(androidx.constraintlayout.solver.c r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.solver.SolverVariable r37, androidx.constraintlayout.solver.SolverVariable r38, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.solver.widgets.ConstraintAnchor r41, androidx.constraintlayout.solver.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            Method dump skipped, instructions count: 1321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.i(androidx.constraintlayout.solver.c, boolean, boolean, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public boolean i0() {
        if (!this.f8370m && (!this.f8328K.n() || !this.f8332M.n())) {
            return false;
        }
        return true;
    }

    public void j(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z10;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type == type5) {
            if (type2 == type5) {
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
                ConstraintAnchor p10 = p(type6);
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor p11 = p(type7);
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor p12 = p(type8);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor p13 = p(type9);
                boolean z11 = true;
                if ((p10 != null && p10.o()) || (p11 != null && p11.o())) {
                    z10 = false;
                } else {
                    j(type6, constraintWidget, type6, 0);
                    j(type7, constraintWidget, type7, 0);
                    z10 = true;
                }
                if ((p12 != null && p12.o()) || (p13 != null && p13.o())) {
                    z11 = false;
                } else {
                    j(type8, constraintWidget, type8, 0);
                    j(type9, constraintWidget, type9, 0);
                }
                if (z10 && z11) {
                    p(type5).a(constraintWidget.p(type5), 0);
                    return;
                }
                if (z10) {
                    ConstraintAnchor.Type type10 = ConstraintAnchor.Type.CENTER_X;
                    p(type10).a(constraintWidget.p(type10), 0);
                    return;
                } else {
                    if (z11) {
                        ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_Y;
                        p(type11).a(constraintWidget.p(type11), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor.Type type12 = ConstraintAnchor.Type.LEFT;
            if (type2 != type12 && type2 != ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor.Type type13 = ConstraintAnchor.Type.TOP;
                if (type2 == type13 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    j(type13, constraintWidget, type2, 0);
                    j(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    p(type5).a(constraintWidget.p(type2), 0);
                    return;
                }
                return;
            }
            j(type12, constraintWidget, type2, 0);
            j(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            p(type5).a(constraintWidget.p(type2), 0);
            return;
        }
        ConstraintAnchor.Type type14 = ConstraintAnchor.Type.CENTER_X;
        if (type == type14 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor p14 = p(type4);
            ConstraintAnchor p15 = constraintWidget.p(type2);
            ConstraintAnchor p16 = p(ConstraintAnchor.Type.RIGHT);
            p14.a(p15, 0);
            p16.a(p15, 0);
            p(type14).a(p15, 0);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type15 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor p17 = constraintWidget.p(type2);
            p(type3).a(p17, 0);
            p(ConstraintAnchor.Type.BOTTOM).a(p17, 0);
            p(type15).a(p17, 0);
            return;
        }
        if (type == type14 && type2 == type14) {
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.LEFT;
            p(type16).a(constraintWidget.p(type16), 0);
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.RIGHT;
            p(type17).a(constraintWidget.p(type17), 0);
            p(type14).a(constraintWidget.p(type2), 0);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.TOP;
            p(type18).a(constraintWidget.p(type18), 0);
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.BOTTOM;
            p(type19).a(constraintWidget.p(type19), 0);
            p(type15).a(constraintWidget.p(type2), 0);
            return;
        }
        ConstraintAnchor p18 = p(type);
        ConstraintAnchor p19 = constraintWidget.p(type2);
        if (p18.p(p19)) {
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BASELINE;
            if (type == type20) {
                ConstraintAnchor p20 = p(ConstraintAnchor.Type.TOP);
                ConstraintAnchor p21 = p(ConstraintAnchor.Type.BOTTOM);
                if (p20 != null) {
                    p20.q();
                }
                if (p21 != null) {
                    p21.q();
                }
                i10 = 0;
            } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor p22 = p(type5);
                    if (p22.j() != p19) {
                        p22.q();
                    }
                    ConstraintAnchor g10 = p(type).g();
                    ConstraintAnchor p23 = p(type14);
                    if (p23.o()) {
                        g10.q();
                        p23.q();
                    }
                }
            } else {
                ConstraintAnchor p24 = p(type20);
                if (p24 != null) {
                    p24.q();
                }
                ConstraintAnchor p25 = p(type5);
                if (p25.j() != p19) {
                    p25.q();
                }
                ConstraintAnchor g11 = p(type).g();
                ConstraintAnchor p26 = p(type15);
                if (p26.o()) {
                    g11.q();
                    p26.q();
                }
            }
            p18.a(p19, i10);
        }
    }

    public boolean j0() {
        DimensionBehaviour[] dimensionBehaviourArr = this.f8340U;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour != dimensionBehaviour2 || dimensionBehaviourArr[1] != dimensionBehaviour2) {
            return false;
        }
        return true;
    }

    public void k(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        if (constraintAnchor.h() == this) {
            j(constraintAnchor.k(), constraintAnchor2.h(), constraintAnchor2.k(), i10);
        }
    }

    public void k0() {
        this.f8326J.q();
        this.f8328K.q();
        this.f8330L.q();
        this.f8332M.q();
        this.f8333N.q();
        this.f8334O.q();
        this.f8335P.q();
        this.f8336Q.q();
        this.f8341V = null;
        this.f8314D = 0.0f;
        this.f8342W = 0;
        this.f8343X = 0;
        this.f8344Y = 0.0f;
        this.f8345Z = -1;
        this.f8347a0 = 0;
        this.f8349b0 = 0;
        this.f8355e0 = 0;
        this.f8357f0 = 0;
        this.f8359g0 = 0;
        this.f8361h0 = 0;
        this.f8363i0 = 0;
        float f10 = f8307M0;
        this.f8365j0 = f10;
        this.f8367k0 = f10;
        DimensionBehaviour[] dimensionBehaviourArr = this.f8340U;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f8369l0 = null;
        this.f8371m0 = 0;
        this.f8373n0 = 0;
        this.f8377p0 = null;
        this.f8395y0 = false;
        this.f8397z0 = false;
        this.f8311B0 = 0;
        this.f8313C0 = 0;
        this.f8315D0 = false;
        this.f8317E0 = false;
        float[] fArr = this.f8319F0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f8372n = -1;
        this.f8374o = -1;
        int[] iArr = this.f8312C;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f8376p = 0;
        this.f8378q = 0;
        this.f8386u = 1.0f;
        this.f8392x = 1.0f;
        this.f8384t = Integer.MAX_VALUE;
        this.f8390w = Integer.MAX_VALUE;
        this.f8382s = 0;
        this.f8388v = 0;
        this.f8360h = false;
        this.f8308A = -1;
        this.f8310B = 1.0f;
        this.f8309A0 = false;
        boolean[] zArr = this.f8358g;
        zArr[0] = true;
        zArr[1] = true;
        this.f8320G = false;
        boolean[] zArr2 = this.f8339T;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f8362i = true;
    }

    public void l(ConstraintWidget constraintWidget, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        a0(type, constraintWidget, type, i10, 0);
        this.f8314D = f10;
    }

    public void l0() {
        ConstraintWidget L10 = L();
        if (L10 != null && (L10 instanceof d) && ((d) L()).z1()) {
            return;
        }
        int size = this.f8338S.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f8338S.get(i10).q();
        }
    }

    public void m(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        this.f8372n = constraintWidget.f8372n;
        this.f8374o = constraintWidget.f8374o;
        this.f8376p = constraintWidget.f8376p;
        this.f8378q = constraintWidget.f8378q;
        int[] iArr = this.f8380r;
        int[] iArr2 = constraintWidget.f8380r;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f8382s = constraintWidget.f8382s;
        this.f8384t = constraintWidget.f8384t;
        this.f8388v = constraintWidget.f8388v;
        this.f8390w = constraintWidget.f8390w;
        this.f8392x = constraintWidget.f8392x;
        this.f8394y = constraintWidget.f8394y;
        this.f8396z = constraintWidget.f8396z;
        this.f8308A = constraintWidget.f8308A;
        this.f8310B = constraintWidget.f8310B;
        int[] iArr3 = constraintWidget.f8312C;
        this.f8312C = Arrays.copyOf(iArr3, iArr3.length);
        this.f8314D = constraintWidget.f8314D;
        this.f8316E = constraintWidget.f8316E;
        this.f8318F = constraintWidget.f8318F;
        this.f8326J.q();
        this.f8328K.q();
        this.f8330L.q();
        this.f8332M.q();
        this.f8333N.q();
        this.f8334O.q();
        this.f8335P.q();
        this.f8336Q.q();
        this.f8340U = (DimensionBehaviour[]) Arrays.copyOf(this.f8340U, 2);
        ConstraintWidget constraintWidget4 = null;
        if (this.f8341V == null) {
            constraintWidget2 = null;
        } else {
            constraintWidget2 = hashMap.get(constraintWidget.f8341V);
        }
        this.f8341V = constraintWidget2;
        this.f8342W = constraintWidget.f8342W;
        this.f8343X = constraintWidget.f8343X;
        this.f8344Y = constraintWidget.f8344Y;
        this.f8345Z = constraintWidget.f8345Z;
        this.f8347a0 = constraintWidget.f8347a0;
        this.f8349b0 = constraintWidget.f8349b0;
        this.f8351c0 = constraintWidget.f8351c0;
        this.f8353d0 = constraintWidget.f8353d0;
        this.f8355e0 = constraintWidget.f8355e0;
        this.f8357f0 = constraintWidget.f8357f0;
        this.f8359g0 = constraintWidget.f8359g0;
        this.f8361h0 = constraintWidget.f8361h0;
        this.f8363i0 = constraintWidget.f8363i0;
        this.f8365j0 = constraintWidget.f8365j0;
        this.f8367k0 = constraintWidget.f8367k0;
        this.f8369l0 = constraintWidget.f8369l0;
        this.f8371m0 = constraintWidget.f8371m0;
        this.f8373n0 = constraintWidget.f8373n0;
        this.f8375o0 = constraintWidget.f8375o0;
        this.f8377p0 = constraintWidget.f8377p0;
        this.f8379q0 = constraintWidget.f8379q0;
        this.f8381r0 = constraintWidget.f8381r0;
        this.f8383s0 = constraintWidget.f8383s0;
        this.f8385t0 = constraintWidget.f8385t0;
        this.f8387u0 = constraintWidget.f8387u0;
        this.f8389v0 = constraintWidget.f8389v0;
        this.f8391w0 = constraintWidget.f8391w0;
        this.f8393x0 = constraintWidget.f8393x0;
        this.f8395y0 = constraintWidget.f8395y0;
        this.f8397z0 = constraintWidget.f8397z0;
        this.f8311B0 = constraintWidget.f8311B0;
        this.f8313C0 = constraintWidget.f8313C0;
        this.f8315D0 = constraintWidget.f8315D0;
        this.f8317E0 = constraintWidget.f8317E0;
        float[] fArr = this.f8319F0;
        float[] fArr2 = constraintWidget.f8319F0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.f8321G0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.f8321G0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.f8323H0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.f8323H0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget5 = constraintWidget.f8325I0;
        if (constraintWidget5 == null) {
            constraintWidget3 = null;
        } else {
            constraintWidget3 = hashMap.get(constraintWidget5);
        }
        this.f8325I0 = constraintWidget3;
        ConstraintWidget constraintWidget6 = constraintWidget.f8327J0;
        if (constraintWidget6 != null) {
            constraintWidget4 = hashMap.get(constraintWidget6);
        }
        this.f8327J0 = constraintWidget4;
    }

    public void m0() {
        this.f8368l = false;
        this.f8370m = false;
        int size = this.f8338S.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f8338S.get(i10).r();
        }
    }

    public void n(androidx.constraintlayout.solver.c cVar) {
        cVar.q(this.f8326J);
        cVar.q(this.f8328K);
        cVar.q(this.f8330L);
        cVar.q(this.f8332M);
        if (this.f8359g0 > 0) {
            cVar.q(this.f8333N);
        }
    }

    public void n0(C1599a c1599a) {
        this.f8326J.s(c1599a);
        this.f8328K.s(c1599a);
        this.f8330L.s(c1599a);
        this.f8332M.s(c1599a);
        this.f8333N.s(c1599a);
        this.f8336Q.s(c1599a);
        this.f8334O.s(c1599a);
        this.f8335P.s(c1599a);
    }

    public void o() {
        if (this.f8354e == null) {
            this.f8354e = new androidx.constraintlayout.solver.widgets.analyzer.c(this);
        }
        if (this.f8356f == null) {
            this.f8356f = new androidx.constraintlayout.solver.widgets.analyzer.d(this);
        }
    }

    public void o0(int i10) {
        boolean z10;
        this.f8359g0 = i10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f8316E = z10;
    }

    public ConstraintAnchor p(ConstraintAnchor.Type type) {
        switch (a.f8403a[type.ordinal()]) {
            case 1:
                return this.f8326J;
            case 2:
                return this.f8328K;
            case 3:
                return this.f8330L;
            case 4:
                return this.f8332M;
            case 5:
                return this.f8333N;
            case 6:
                return this.f8336Q;
            case 7:
                return this.f8334O;
            case 8:
                return this.f8335P;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public void p0(Object obj) {
        this.f8369l0 = obj;
    }

    public int q() {
        return this.f8359g0;
    }

    public void q0(String str) {
        this.f8375o0 = str;
    }

    public float r(int i10) {
        if (i10 == 0) {
            return this.f8365j0;
        }
        if (i10 == 1) {
            return this.f8367k0;
        }
        return -1.0f;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0086 -> B:31:0x0087). Please report as a decompilation issue!!! */
    public void r0(String str) {
        float f10;
        int i10 = 0;
        if (str != null && str.length() != 0) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i11 = 0;
            int i12 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    if (substring.equalsIgnoreCase("H")) {
                        i11 = 1;
                    } else {
                        i11 = -1;
                    }
                }
                i12 = i11;
                i11 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i11, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i12 == 1) {
                            f10 = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f10 = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f10 = i10;
            } else {
                String substring4 = str.substring(i11);
                if (substring4.length() > 0) {
                    f10 = Float.parseFloat(substring4);
                }
                f10 = i10;
            }
            i10 = (f10 > i10 ? 1 : (f10 == i10 ? 0 : -1));
            if (i10 > 0) {
                this.f8344Y = f10;
                this.f8345Z = i12;
                return;
            }
            return;
        }
        this.f8344Y = 0.0f;
    }

    public int s() {
        return W() + this.f8343X;
    }

    public void s0(int i10) {
        if (!this.f8316E) {
            return;
        }
        int i11 = i10 - this.f8359g0;
        int i12 = this.f8343X + i11;
        this.f8349b0 = i11;
        this.f8328K.t(i11);
        this.f8332M.t(i12);
        this.f8333N.t(i10);
        this.f8370m = true;
    }

    public Object t() {
        return this.f8369l0;
    }

    public void t0(int i10, int i11) {
        this.f8326J.t(i10);
        this.f8330L.t(i11);
        this.f8347a0 = i10;
        this.f8342W = i11 - i10;
        this.f8368l = true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f8377p0 == null) {
            str = "";
        } else {
            str = "type: " + this.f8377p0 + " ";
        }
        sb.append(str);
        if (this.f8375o0 != null) {
            str2 = "id: " + this.f8375o0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.f8347a0);
        sb.append(", ");
        sb.append(this.f8349b0);
        sb.append(") - (");
        sb.append(this.f8342W);
        sb.append(" x ");
        sb.append(this.f8343X);
        sb.append(")");
        return sb.toString();
    }

    public String u() {
        return this.f8375o0;
    }

    public void u0(int i10) {
        this.f8326J.t(i10);
        this.f8347a0 = i10;
    }

    public DimensionBehaviour v(int i10) {
        if (i10 == 0) {
            return B();
        }
        if (i10 == 1) {
            return R();
        }
        return null;
    }

    public void v0(int i10) {
        this.f8328K.t(i10);
        this.f8349b0 = i10;
    }

    public float w() {
        return this.f8344Y;
    }

    public void w0(int i10, int i11) {
        this.f8328K.t(i10);
        this.f8332M.t(i11);
        this.f8349b0 = i10;
        this.f8343X = i11 - i10;
        if (this.f8316E) {
            this.f8333N.t(i10 + this.f8359g0);
        }
        this.f8370m = true;
    }

    public int x() {
        return this.f8345Z;
    }

    public void x0(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.f8347a0 = i10;
        this.f8349b0 = i11;
        if (this.f8373n0 == 8) {
            this.f8342W = 0;
            this.f8343X = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.f8340U;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i16 < (i15 = this.f8342W)) {
            i16 = i15;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i17 < (i14 = this.f8343X)) {
            i17 = i14;
        }
        this.f8342W = i16;
        this.f8343X = i17;
        int i18 = this.f8363i0;
        if (i17 < i18) {
            this.f8343X = i18;
        }
        int i19 = this.f8361h0;
        if (i16 < i19) {
            this.f8342W = i19;
        }
    }

    public int y() {
        if (this.f8373n0 == 8) {
            return 0;
        }
        return this.f8343X;
    }

    public void y0(boolean z10) {
        this.f8316E = z10;
    }

    public float z() {
        return this.f8365j0;
    }

    public void z0(int i10) {
        this.f8343X = i10;
        int i11 = this.f8363i0;
        if (i10 < i11) {
            this.f8343X = i11;
        }
    }
}
