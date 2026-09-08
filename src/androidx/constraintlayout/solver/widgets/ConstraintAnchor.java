package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import u.C1599a;
import w.j;

/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: b, reason: collision with root package name */
    public int f8288b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8289c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f8290d;

    /* renamed from: e, reason: collision with root package name */
    public final Type f8291e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f8292f;

    /* renamed from: i, reason: collision with root package name */
    public SolverVariable f8295i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet<ConstraintAnchor> f8287a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f8293g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f8294h = -1;

    /* loaded from: classes.dex */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8306a;

        static {
            int[] iArr = new int[Type.values().length];
            f8306a = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8306a[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8306a[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8306a[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8306a[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8306a[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8306a[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8306a[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8306a[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f8290d = constraintWidget;
        this.f8291e = type;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i10) {
        return b(constraintAnchor, i10, -1, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i10, int i11, boolean z10) {
        if (constraintAnchor == null) {
            q();
            return true;
        }
        if (!z10 && !p(constraintAnchor)) {
            return false;
        }
        this.f8292f = constraintAnchor;
        if (constraintAnchor.f8287a == null) {
            constraintAnchor.f8287a = new HashSet<>();
        }
        HashSet<ConstraintAnchor> hashSet = this.f8292f.f8287a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        if (i10 > 0) {
            this.f8293g = i10;
        } else {
            this.f8293g = 0;
        }
        this.f8294h = i11;
        return true;
    }

    public void c(int i10, ArrayList<j> arrayList, j jVar) {
        HashSet<ConstraintAnchor> hashSet = this.f8287a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                w.g.a(it.next().f8290d, i10, arrayList, jVar);
            }
        }
    }

    public HashSet<ConstraintAnchor> d() {
        return this.f8287a;
    }

    public int e() {
        if (!this.f8289c) {
            return 0;
        }
        return this.f8288b;
    }

    public int f() {
        ConstraintAnchor constraintAnchor;
        if (this.f8290d.T() == 8) {
            return 0;
        }
        if (this.f8294h > -1 && (constraintAnchor = this.f8292f) != null && constraintAnchor.f8290d.T() == 8) {
            return this.f8294h;
        }
        return this.f8293g;
    }

    public final ConstraintAnchor g() {
        switch (a.f8306a[this.f8291e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f8290d.f8330L;
            case 3:
                return this.f8290d.f8326J;
            case 4:
                return this.f8290d.f8332M;
            case 5:
                return this.f8290d.f8328K;
            default:
                throw new AssertionError(this.f8291e.name());
        }
    }

    public ConstraintWidget h() {
        return this.f8290d;
    }

    public SolverVariable i() {
        return this.f8295i;
    }

    public ConstraintAnchor j() {
        return this.f8292f;
    }

    public Type k() {
        return this.f8291e;
    }

    public boolean l() {
        HashSet<ConstraintAnchor> hashSet = this.f8287a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().g().o()) {
                return true;
            }
        }
        return false;
    }

    public boolean m() {
        HashSet<ConstraintAnchor> hashSet = this.f8287a;
        if (hashSet == null || hashSet.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean n() {
        return this.f8289c;
    }

    public boolean o() {
        if (this.f8292f != null) {
            return true;
        }
        return false;
    }

    public boolean p(ConstraintAnchor constraintAnchor) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type k10 = constraintAnchor.k();
        Type type = this.f8291e;
        if (k10 == type) {
            if (type == Type.BASELINE && (!constraintAnchor.h().X() || !h().X())) {
                return false;
            }
            return true;
        }
        switch (a.f8306a[type.ordinal()]) {
            case 1:
                if (k10 == Type.BASELINE || k10 == Type.CENTER_X || k10 == Type.CENTER_Y) {
                    return false;
                }
                return true;
            case 2:
            case 3:
                if (k10 != Type.LEFT && k10 != Type.RIGHT) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (constraintAnchor.h() instanceof f) {
                    if (z10 || k10 == Type.CENTER_X) {
                        z12 = true;
                    }
                    return z12;
                }
                return z10;
            case 4:
            case 5:
                if (k10 != Type.TOP && k10 != Type.BOTTOM) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (constraintAnchor.h() instanceof f) {
                    if (z11 || k10 == Type.CENTER_Y) {
                        z12 = true;
                    }
                    return z12;
                }
                return z11;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f8291e.name());
        }
    }

    public void q() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f8292f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f8287a) != null) {
            hashSet.remove(this);
            if (this.f8292f.f8287a.size() == 0) {
                this.f8292f.f8287a = null;
            }
        }
        this.f8287a = null;
        this.f8292f = null;
        this.f8293g = 0;
        this.f8294h = -1;
        this.f8289c = false;
        this.f8288b = 0;
    }

    public void r() {
        this.f8289c = false;
        this.f8288b = 0;
    }

    public void s(C1599a c1599a) {
        SolverVariable solverVariable = this.f8295i;
        if (solverVariable == null) {
            this.f8295i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.d();
        }
    }

    public void t(int i10) {
        this.f8288b = i10;
        this.f8289c = true;
    }

    public String toString() {
        return this.f8290d.u() + ":" + this.f8291e.toString();
    }

    public void u(int i10) {
        if (o()) {
            this.f8294h = i10;
        }
    }
}
