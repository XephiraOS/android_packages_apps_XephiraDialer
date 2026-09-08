package t;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.b;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* compiled from: MotionPaths.java */
/* loaded from: classes.dex */
public class p implements Comparable<p> {

    /* renamed from: p, reason: collision with root package name */
    public static String[] f37088p = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: a, reason: collision with root package name */
    public s.c f37089a;

    /* renamed from: b, reason: collision with root package name */
    public int f37090b;

    /* renamed from: c, reason: collision with root package name */
    public float f37091c;

    /* renamed from: d, reason: collision with root package name */
    public float f37092d;

    /* renamed from: e, reason: collision with root package name */
    public float f37093e;

    /* renamed from: f, reason: collision with root package name */
    public float f37094f;

    /* renamed from: g, reason: collision with root package name */
    public float f37095g;

    /* renamed from: h, reason: collision with root package name */
    public float f37096h;

    /* renamed from: i, reason: collision with root package name */
    public float f37097i;

    /* renamed from: j, reason: collision with root package name */
    public float f37098j;

    /* renamed from: k, reason: collision with root package name */
    public int f37099k;

    /* renamed from: l, reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f37100l;

    /* renamed from: m, reason: collision with root package name */
    public int f37101m;

    /* renamed from: n, reason: collision with root package name */
    public double[] f37102n;

    /* renamed from: o, reason: collision with root package name */
    public double[] f37103o;

    public p() {
        this.f37090b = 0;
        this.f37097i = Float.NaN;
        this.f37098j = Float.NaN;
        this.f37099k = AbstractC1575c.f36905f;
        this.f37100l = new LinkedHashMap<>();
        this.f37101m = 0;
        this.f37102n = new double[18];
        this.f37103o = new double[18];
    }

    public void a(b.a aVar) {
        this.f37089a = s.c.c(aVar.f8697c.f8767c);
        b.c cVar = aVar.f8697c;
        this.f37099k = cVar.f8768d;
        this.f37097i = cVar.f8771g;
        this.f37090b = cVar.f8769e;
        this.f37098j = aVar.f8696b.f8776e;
        for (String str : aVar.f8700f.keySet()) {
            ConstraintAttribute constraintAttribute = aVar.f8700f.get(str);
            if (constraintAttribute.c() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.f37100l.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        return Float.compare(this.f37092d, pVar.f37092d);
    }

    public final boolean c(float f10, float f11) {
        if (!Float.isNaN(f10) && !Float.isNaN(f11)) {
            if (Math.abs(f10 - f11) <= 1.0E-6f) {
                return false;
            }
            return true;
        }
        if (Float.isNaN(f10) == Float.isNaN(f11)) {
            return false;
        }
        return true;
    }

    public void d(p pVar, boolean[] zArr, String[] strArr, boolean z10) {
        zArr[0] = zArr[0] | c(this.f37092d, pVar.f37092d);
        zArr[1] = zArr[1] | c(this.f37093e, pVar.f37093e) | z10;
        zArr[2] = z10 | c(this.f37094f, pVar.f37094f) | zArr[2];
        zArr[3] = zArr[3] | c(this.f37095g, pVar.f37095g);
        zArr[4] = c(this.f37096h, pVar.f37096h) | zArr[4];
    }

    public void e(double[] dArr, int[] iArr) {
        float[] fArr = {this.f37092d, this.f37093e, this.f37094f, this.f37095g, this.f37096h, this.f37097i};
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 < 6) {
                dArr[i10] = fArr[r1];
                i10++;
            }
        }
    }

    public void f(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f37093e;
        float f11 = this.f37094f;
        float f12 = this.f37095g;
        float f13 = this.f37096h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        if (i12 == 4) {
                            f13 = f14;
                        }
                    } else {
                        f12 = f14;
                    }
                } else {
                    f11 = f14;
                }
            } else {
                f10 = f14;
            }
        }
        fArr[i10] = f10 + (f12 / 2.0f) + 0.0f;
        fArr[i10 + 1] = f11 + (f13 / 2.0f) + 0.0f;
    }

    public int g(String str, double[] dArr, int i10) {
        ConstraintAttribute constraintAttribute = this.f37100l.get(str);
        if (constraintAttribute.f() == 1) {
            dArr[i10] = constraintAttribute.d();
            return 1;
        }
        int f10 = constraintAttribute.f();
        constraintAttribute.e(new float[f10]);
        int i11 = 0;
        while (i11 < f10) {
            dArr[i10] = r0[i11];
            i11++;
            i10++;
        }
        return f10;
    }

    public int h(String str) {
        return this.f37100l.get(str).f();
    }

    public void i(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f37093e;
        float f11 = this.f37094f;
        float f12 = this.f37095g;
        float f13 = this.f37096h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f14 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        if (i12 == 4) {
                            f13 = f14;
                        }
                    } else {
                        f12 = f14;
                    }
                } else {
                    f11 = f14;
                }
            } else {
                f10 = f14;
            }
        }
        float f15 = f12 + f10;
        float f16 = f13 + f11;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i10] = f10 + 0.0f;
        fArr[i10 + 1] = f11 + 0.0f;
        fArr[i10 + 2] = f15 + 0.0f;
        fArr[i10 + 3] = f11 + 0.0f;
        fArr[i10 + 4] = f15 + 0.0f;
        int i13 = i10 + 6;
        fArr[i10 + 5] = f16 + 0.0f;
        fArr[i13] = f10 + 0.0f;
        fArr[i10 + 7] = f16 + 0.0f;
    }

    public boolean j(String str) {
        return this.f37100l.containsKey(str);
    }

    public void k(i iVar, p pVar, p pVar2) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14 = iVar.f36906a / 100.0f;
        this.f37091c = f14;
        this.f37090b = iVar.f36980j;
        if (Float.isNaN(iVar.f36981k)) {
            f10 = f14;
        } else {
            f10 = iVar.f36981k;
        }
        if (Float.isNaN(iVar.f36982l)) {
            f11 = f14;
        } else {
            f11 = iVar.f36982l;
        }
        float f15 = pVar2.f37095g;
        float f16 = pVar.f37095g;
        float f17 = pVar2.f37096h;
        float f18 = pVar.f37096h;
        this.f37092d = this.f37091c;
        float f19 = pVar.f37093e;
        float f20 = pVar.f37094f;
        float f21 = (pVar2.f37093e + (f15 / 2.0f)) - ((f16 / 2.0f) + f19);
        float f22 = (pVar2.f37094f + (f17 / 2.0f)) - (f20 + (f18 / 2.0f));
        float f23 = ((f15 - f16) * f10) / 2.0f;
        this.f37093e = (int) ((f19 + (f21 * f14)) - f23);
        float f24 = ((f17 - f18) * f11) / 2.0f;
        this.f37094f = (int) ((f20 + (f22 * f14)) - f24);
        this.f37095g = (int) (f16 + r9);
        this.f37096h = (int) (f18 + r12);
        if (Float.isNaN(iVar.f36983m)) {
            f12 = f14;
        } else {
            f12 = iVar.f36983m;
        }
        float f25 = 0.0f;
        if (Float.isNaN(iVar.f36986p)) {
            f13 = 0.0f;
        } else {
            f13 = iVar.f36986p;
        }
        if (!Float.isNaN(iVar.f36984n)) {
            f14 = iVar.f36984n;
        }
        if (!Float.isNaN(iVar.f36985o)) {
            f25 = iVar.f36985o;
        }
        this.f37101m = 2;
        this.f37093e = (int) (((pVar.f37093e + (f12 * f21)) + (f25 * f22)) - f23);
        this.f37094f = (int) (((pVar.f37094f + (f21 * f13)) + (f22 * f14)) - f24);
        this.f37089a = s.c.c(iVar.f36978h);
        this.f37099k = iVar.f36979i;
    }

    public void l(i iVar, p pVar, p pVar2) {
        float f10;
        float f11;
        float f12;
        float f13 = iVar.f36906a / 100.0f;
        this.f37091c = f13;
        this.f37090b = iVar.f36980j;
        if (Float.isNaN(iVar.f36981k)) {
            f10 = f13;
        } else {
            f10 = iVar.f36981k;
        }
        if (Float.isNaN(iVar.f36982l)) {
            f11 = f13;
        } else {
            f11 = iVar.f36982l;
        }
        float f14 = pVar2.f37095g - pVar.f37095g;
        float f15 = pVar2.f37096h - pVar.f37096h;
        this.f37092d = this.f37091c;
        if (!Float.isNaN(iVar.f36983m)) {
            f13 = iVar.f36983m;
        }
        float f16 = pVar.f37093e;
        float f17 = pVar.f37095g;
        float f18 = pVar.f37094f;
        float f19 = pVar.f37096h;
        float f20 = (pVar2.f37093e + (pVar2.f37095g / 2.0f)) - ((f17 / 2.0f) + f16);
        float f21 = (pVar2.f37094f + (pVar2.f37096h / 2.0f)) - ((f19 / 2.0f) + f18);
        float f22 = f20 * f13;
        float f23 = (f14 * f10) / 2.0f;
        this.f37093e = (int) ((f16 + f22) - f23);
        float f24 = f13 * f21;
        float f25 = (f15 * f11) / 2.0f;
        this.f37094f = (int) ((f18 + f24) - f25);
        this.f37095g = (int) (f17 + r7);
        this.f37096h = (int) (f19 + r8);
        if (Float.isNaN(iVar.f36984n)) {
            f12 = 0.0f;
        } else {
            f12 = iVar.f36984n;
        }
        this.f37101m = 1;
        float f26 = (int) ((pVar.f37093e + f22) - f23);
        float f27 = (int) ((pVar.f37094f + f24) - f25);
        this.f37093e = f26 + ((-f21) * f12);
        this.f37094f = f27 + (f20 * f12);
        this.f37089a = s.c.c(iVar.f36978h);
        this.f37099k = iVar.f36979i;
    }

    public void m(int i10, int i11, i iVar, p pVar, p pVar2) {
        float f10;
        float f11;
        float f12 = iVar.f36906a / 100.0f;
        this.f37091c = f12;
        this.f37090b = iVar.f36980j;
        if (Float.isNaN(iVar.f36981k)) {
            f10 = f12;
        } else {
            f10 = iVar.f36981k;
        }
        if (Float.isNaN(iVar.f36982l)) {
            f11 = f12;
        } else {
            f11 = iVar.f36982l;
        }
        float f13 = pVar2.f37095g;
        float f14 = pVar.f37095g;
        float f15 = pVar2.f37096h;
        float f16 = pVar.f37096h;
        this.f37092d = this.f37091c;
        float f17 = pVar.f37093e;
        float f18 = pVar.f37094f;
        float f19 = pVar2.f37093e + (f13 / 2.0f);
        float f20 = pVar2.f37094f + (f15 / 2.0f);
        float f21 = (f13 - f14) * f10;
        this.f37093e = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f12)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f11;
        this.f37094f = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f12)) - (f22 / 2.0f));
        this.f37095g = (int) (f14 + f21);
        this.f37096h = (int) (f16 + f22);
        this.f37101m = 3;
        if (!Float.isNaN(iVar.f36983m)) {
            this.f37093e = (int) (iVar.f36983m * ((int) (i10 - this.f37095g)));
        }
        if (!Float.isNaN(iVar.f36984n)) {
            this.f37094f = (int) (iVar.f36984n * ((int) (i11 - this.f37096h)));
        }
        this.f37089a = s.c.c(iVar.f36978h);
        this.f37099k = iVar.f36979i;
    }

    public void n(float f10, float f11, float f12, float f13) {
        this.f37093e = f10;
        this.f37094f = f11;
        this.f37095g = f12;
        this.f37096h = f13;
    }

    public void o(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 == 4) {
                            f15 = f16;
                        }
                    } else {
                        f13 = f16;
                    }
                } else {
                    f14 = f16;
                }
            } else {
                f12 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + 0.0f;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + 0.0f;
    }

    public void p(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f10;
        float f11;
        float f12 = this.f37093e;
        float f13 = this.f37094f;
        float f14 = this.f37095g;
        float f15 = this.f37096h;
        if (iArr.length != 0 && this.f37102n.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.f37102n = new double[i10];
            this.f37103o = new double[i10];
        }
        Arrays.fill(this.f37102n, Double.NaN);
        int i11 = 0;
        for (int i12 = 0; i12 < iArr.length; i12++) {
            double[] dArr4 = this.f37102n;
            int i13 = iArr[i12];
            dArr4[i13] = dArr[i12];
            this.f37103o[i13] = dArr2[i12];
        }
        float f16 = Float.NaN;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        while (true) {
            double[] dArr5 = this.f37102n;
            if (i11 >= dArr5.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr5[i11]);
            double d10 = 0.0d;
            if (isNaN && (dArr3 == null || dArr3[i11] == 0.0d)) {
                f11 = f16;
            } else {
                if (dArr3 != null) {
                    d10 = dArr3[i11];
                }
                if (!Double.isNaN(this.f37102n[i11])) {
                    d10 = this.f37102n[i11] + d10;
                }
                f11 = f16;
                float f21 = (float) d10;
                float f22 = (float) this.f37103o[i11];
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 != 3) {
                            if (i11 != 4) {
                                if (i11 == 5) {
                                    f16 = f21;
                                }
                            } else {
                                f16 = f11;
                                f15 = f21;
                                f20 = f22;
                            }
                        } else {
                            f16 = f11;
                            f14 = f21;
                            f18 = f22;
                        }
                    } else {
                        f16 = f11;
                        f13 = f21;
                        f19 = f22;
                    }
                } else {
                    f16 = f11;
                    f12 = f21;
                    f17 = f22;
                }
                i11++;
            }
            f16 = f11;
            i11++;
        }
        float f23 = f16;
        if (Float.isNaN(f23)) {
            if (!Float.isNaN(Float.NaN)) {
                view.setRotation(Float.NaN);
            }
        } else {
            if (Float.isNaN(Float.NaN)) {
                f10 = 0.0f;
            } else {
                f10 = Float.NaN;
            }
            view.setRotation((float) (f10 + f23 + Math.toDegrees(Math.atan2(f19 + (f20 / 2.0f), f17 + (f18 / 2.0f)))));
        }
        float f24 = f12 + 0.5f;
        int i14 = (int) f24;
        float f25 = f13 + 0.5f;
        int i15 = (int) f25;
        int i16 = (int) (f24 + f14);
        int i17 = (int) (f25 + f15);
        int i18 = i16 - i14;
        int i19 = i17 - i15;
        if (i18 != view.getMeasuredWidth() || i19 != view.getMeasuredHeight()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
        }
        view.layout(i14, i15, i16, i17);
    }

    public p(int i10, int i11, i iVar, p pVar, p pVar2) {
        this.f37090b = 0;
        this.f37097i = Float.NaN;
        this.f37098j = Float.NaN;
        this.f37099k = AbstractC1575c.f36905f;
        this.f37100l = new LinkedHashMap<>();
        this.f37101m = 0;
        this.f37102n = new double[18];
        this.f37103o = new double[18];
        int i12 = iVar.f36987q;
        if (i12 == 1) {
            l(iVar, pVar, pVar2);
        } else if (i12 != 2) {
            k(iVar, pVar, pVar2);
        } else {
            m(i10, i11, iVar, pVar, pVar2);
        }
    }
}
