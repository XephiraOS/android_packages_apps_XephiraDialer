package t;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;

/* compiled from: SplineSet.java */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public s.b f37104a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f37105b = new int[10];

    /* renamed from: c, reason: collision with root package name */
    public float[] f37106c = new float[10];

    /* renamed from: d, reason: collision with root package name */
    public int f37107d;

    /* renamed from: e, reason: collision with root package name */
    public String f37108e;

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class a extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setAlpha(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class b extends q {

        /* renamed from: f, reason: collision with root package name */
        public String f37109f;

        /* renamed from: g, reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f37110g;

        /* renamed from: h, reason: collision with root package name */
        public float[] f37111h;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f37109f = str.split(",")[1];
            this.f37110g = sparseArray;
        }

        @Override // t.q
        public void e(int i10, float f10) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // t.q
        public void f(View view, float f10) {
            this.f37104a.e(f10, this.f37111h);
            this.f37110g.valueAt(0).i(view, this.f37111h);
        }

        @Override // t.q
        public void h(int i10) {
            int size = this.f37110g.size();
            int f10 = this.f37110g.valueAt(0).f();
            double[] dArr = new double[size];
            this.f37111h = new float[f10];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, f10);
            for (int i11 = 0; i11 < size; i11++) {
                int keyAt = this.f37110g.keyAt(i11);
                ConstraintAttribute valueAt = this.f37110g.valueAt(i11);
                dArr[i11] = keyAt * 0.01d;
                valueAt.e(this.f37111h);
                int i12 = 0;
                while (true) {
                    if (i12 < this.f37111h.length) {
                        dArr2[i11][i12] = r6[i12];
                        i12++;
                    }
                }
            }
            this.f37104a = s.b.a(i10, dArr, dArr2);
        }

        public void i(int i10, ConstraintAttribute constraintAttribute) {
            this.f37110g.append(i10, constraintAttribute);
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class c extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setElevation(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class e extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setPivotX(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class f extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setPivotY(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class g extends q {

        /* renamed from: f, reason: collision with root package name */
        public boolean f37112f = false;

        @Override // t.q
        public void f(View view, float f10) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f10));
                return;
            }
            if (this.f37112f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f37112f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f10)));
                } catch (IllegalAccessException e10) {
                    Log.e("SplineSet", "unable to setProgress", e10);
                } catch (InvocationTargetException e11) {
                    Log.e("SplineSet", "unable to setProgress", e11);
                }
            }
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class h extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setRotation(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class i extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setRotationX(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class j extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setRotationY(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class k extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setScaleX(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class l extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setScaleY(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class m {
        public static void a(int[] iArr, float[] fArr, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = iArr2[i12 - 1];
                int i14 = i12 - 2;
                int i15 = iArr2[i14];
                if (i13 < i15) {
                    int b10 = b(iArr, fArr, i13, i15);
                    iArr2[i14] = b10 - 1;
                    iArr2[i12 - 1] = i13;
                    int i16 = i12 + 1;
                    iArr2[i12] = i15;
                    i12 += 2;
                    iArr2[i16] = b10 + 1;
                } else {
                    i12 = i14;
                }
            }
        }

        public static int b(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    c(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            c(iArr, fArr, i13, i11);
            return i13;
        }

        public static void c(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class n extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setTranslationX(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class o extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setTranslationY(a(f10));
        }
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class p extends q {
        @Override // t.q
        public void f(View view, float f10) {
            view.setTranslationZ(a(f10));
        }
    }

    public static q c(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    public static q d(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c10 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c10 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c10 = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c10 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c10 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c10 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c10 = 15;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return new i();
            case 1:
                return new j();
            case 2:
                return new n();
            case 3:
                return new o();
            case 4:
                return new p();
            case 5:
                return new g();
            case 6:
                return new k();
            case 7:
                return new l();
            case '\b':
                return new a();
            case '\t':
                return new e();
            case '\n':
                return new f();
            case 11:
                return new h();
            case '\f':
                return new c();
            case '\r':
                return new d();
            case 14:
                return new a();
            case 15:
                return new a();
            default:
                return null;
        }
    }

    public float a(float f10) {
        return (float) this.f37104a.c(f10, 0);
    }

    public float b(float f10) {
        return (float) this.f37104a.f(f10, 0);
    }

    public void e(int i10, float f10) {
        int[] iArr = this.f37105b;
        if (iArr.length < this.f37107d + 1) {
            this.f37105b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f37106c;
            this.f37106c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f37105b;
        int i11 = this.f37107d;
        iArr2[i11] = i10;
        this.f37106c[i11] = f10;
        this.f37107d = i11 + 1;
    }

    public abstract void f(View view, float f10);

    public void g(String str) {
        this.f37108e = str;
    }

    public void h(int i10) {
        int i11 = this.f37107d;
        if (i11 == 0) {
            return;
        }
        m.a(this.f37105b, this.f37106c, 0, i11 - 1);
        int i12 = 1;
        for (int i13 = 1; i13 < this.f37107d; i13++) {
            int[] iArr = this.f37105b;
            if (iArr[i13 - 1] != iArr[i13]) {
                i12++;
            }
        }
        double[] dArr = new double[i12];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i12, 1);
        int i14 = 0;
        for (int i15 = 0; i15 < this.f37107d; i15++) {
            if (i15 > 0) {
                int[] iArr2 = this.f37105b;
                if (iArr2[i15] == iArr2[i15 - 1]) {
                }
            }
            dArr[i14] = this.f37105b[i15] * 0.01d;
            dArr2[i14][0] = this.f37106c[i15];
            i14++;
        }
        this.f37104a = s.b.a(i10, dArr, dArr2);
    }

    public String toString() {
        String str = this.f37108e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f37107d; i10++) {
            str = str + "[" + this.f37105b[i10] + " , " + decimalFormat.format(this.f37106c[i10]) + "] ";
        }
        return str;
    }

    /* compiled from: SplineSet.java */
    /* loaded from: classes.dex */
    public static class d extends q {
        public void i(View view, float f10, double d10, double d11) {
            view.setRotation(a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }

        @Override // t.q
        public void f(View view, float f10) {
        }
    }
}
