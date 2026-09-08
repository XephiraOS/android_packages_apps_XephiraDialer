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

/* compiled from: TimeCycleSplineSet.java */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: k, reason: collision with root package name */
    public static float f37113k = 6.2831855f;

    /* renamed from: a, reason: collision with root package name */
    public s.b f37114a;

    /* renamed from: e, reason: collision with root package name */
    public int f37118e;

    /* renamed from: f, reason: collision with root package name */
    public String f37119f;

    /* renamed from: i, reason: collision with root package name */
    public long f37122i;

    /* renamed from: b, reason: collision with root package name */
    public int f37115b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int[] f37116c = new int[10];

    /* renamed from: d, reason: collision with root package name */
    public float[][] f37117d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* renamed from: g, reason: collision with root package name */
    public float[] f37120g = new float[3];

    /* renamed from: h, reason: collision with root package name */
    public boolean f37121h = false;

    /* renamed from: j, reason: collision with root package name */
    public float f37123j = Float.NaN;

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class a extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setAlpha(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class b extends r {

        /* renamed from: l, reason: collision with root package name */
        public String f37124l;

        /* renamed from: m, reason: collision with root package name */
        public SparseArray<ConstraintAttribute> f37125m;

        /* renamed from: n, reason: collision with root package name */
        public SparseArray<float[]> f37126n = new SparseArray<>();

        /* renamed from: o, reason: collision with root package name */
        public float[] f37127o;

        /* renamed from: p, reason: collision with root package name */
        public float[] f37128p;

        public b(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.f37124l = str.split(",")[1];
            this.f37125m = sparseArray;
        }

        @Override // t.r
        public void e(int i10, float f10, float f11, int i11, float f12) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            boolean z10;
            this.f37114a.e(f10, this.f37127o);
            float[] fArr = this.f37127o;
            float f11 = fArr[fArr.length - 2];
            float f12 = fArr[fArr.length - 1];
            long j11 = j10 - this.f37122i;
            if (Float.isNaN(this.f37123j)) {
                float a10 = eVar.a(view, this.f37124l, 0);
                this.f37123j = a10;
                if (Float.isNaN(a10)) {
                    this.f37123j = 0.0f;
                }
            }
            float f13 = (float) ((this.f37123j + ((j11 * 1.0E-9d) * f11)) % 1.0d);
            this.f37123j = f13;
            this.f37122i = j10;
            float a11 = a(f13);
            this.f37121h = false;
            int i10 = 0;
            while (true) {
                float[] fArr2 = this.f37128p;
                if (i10 >= fArr2.length) {
                    break;
                }
                boolean z11 = this.f37121h;
                float f14 = this.f37127o[i10];
                if (f14 != 0.0d) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f37121h = z11 | z10;
                fArr2[i10] = (f14 * a11) + f12;
                i10++;
            }
            this.f37125m.valueAt(0).i(view, this.f37128p);
            if (f11 != 0.0f) {
                this.f37121h = true;
            }
            return this.f37121h;
        }

        @Override // t.r
        public void i(int i10) {
            int size = this.f37125m.size();
            int f10 = this.f37125m.valueAt(0).f();
            double[] dArr = new double[size];
            int i11 = f10 + 2;
            this.f37127o = new float[i11];
            this.f37128p = new float[f10];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i11);
            for (int i12 = 0; i12 < size; i12++) {
                int keyAt = this.f37125m.keyAt(i12);
                ConstraintAttribute valueAt = this.f37125m.valueAt(i12);
                float[] valueAt2 = this.f37126n.valueAt(i12);
                dArr[i12] = keyAt * 0.01d;
                valueAt.e(this.f37127o);
                int i13 = 0;
                while (true) {
                    if (i13 < this.f37127o.length) {
                        dArr2[i12][i13] = r8[i13];
                        i13++;
                    }
                }
                double[] dArr3 = dArr2[i12];
                dArr3[f10] = valueAt2[0];
                dArr3[f10 + 1] = valueAt2[1];
            }
            this.f37114a = s.b.a(i10, dArr, dArr2);
        }

        public void j(int i10, ConstraintAttribute constraintAttribute, float f10, int i11, float f11) {
            this.f37125m.append(i10, constraintAttribute);
            this.f37126n.append(i10, new float[]{f10, f11});
            this.f37115b = Math.max(this.f37115b, i11);
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class c extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setElevation(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class d extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            return this.f37121h;
        }

        public boolean j(View view, t.e eVar, float f10, long j10, double d10, double d11) {
            view.setRotation(b(f10, j10, view, eVar) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class e extends r {

        /* renamed from: l, reason: collision with root package name */
        public boolean f37129l = false;

        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(b(f10, j10, view, eVar));
            } else {
                if (this.f37129l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f37129l = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(b(f10, j10, view, eVar)));
                    } catch (IllegalAccessException e10) {
                        Log.e("SplineSet", "unable to setProgress", e10);
                    } catch (InvocationTargetException e11) {
                        Log.e("SplineSet", "unable to setProgress", e11);
                    }
                }
            }
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class f extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setRotation(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class g extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setRotationX(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class h extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setRotationY(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class i extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setScaleX(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class j extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setScaleY(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class k {
        public static void a(int[] iArr, float[][] fArr, int i10, int i11) {
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

        public static int b(int[] iArr, float[][] fArr, int i10, int i11) {
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

        public static void c(int[] iArr, float[][] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float[] fArr2 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = fArr2;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class l extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setTranslationX(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class m extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setTranslationY(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    /* compiled from: TimeCycleSplineSet.java */
    /* loaded from: classes.dex */
    public static class n extends r {
        @Override // t.r
        public boolean f(View view, float f10, long j10, t.e eVar) {
            view.setTranslationZ(b(f10, j10, view, eVar));
            return this.f37121h;
        }
    }

    public static r c(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new b(str, sparseArray);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:39:0x00a0. Please report as an issue. */
    public static r d(String str, long j10) {
        r gVar;
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
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = 11;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                gVar = new g();
                gVar.g(j10);
                return gVar;
            case 1:
                gVar = new h();
                gVar.g(j10);
                return gVar;
            case 2:
                gVar = new l();
                gVar.g(j10);
                return gVar;
            case 3:
                gVar = new m();
                gVar.g(j10);
                return gVar;
            case 4:
                gVar = new n();
                gVar.g(j10);
                return gVar;
            case 5:
                gVar = new e();
                gVar.g(j10);
                return gVar;
            case 6:
                gVar = new i();
                gVar.g(j10);
                return gVar;
            case 7:
                gVar = new j();
                gVar.g(j10);
                return gVar;
            case '\b':
                gVar = new f();
                gVar.g(j10);
                return gVar;
            case '\t':
                gVar = new c();
                gVar.g(j10);
                return gVar;
            case '\n':
                gVar = new d();
                gVar.g(j10);
                return gVar;
            case 11:
                gVar = new a();
                gVar.g(j10);
                return gVar;
            default:
                return null;
        }
    }

    public float a(float f10) {
        switch (this.f37115b) {
            case 1:
                return Math.signum(f10 * f37113k);
            case 2:
                return 1.0f - Math.abs(f10);
            case 3:
                return (((f10 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((f10 * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(f10 * f37113k);
            case 6:
                float abs = 1.0f - Math.abs(((f10 * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (abs * abs);
            default:
                return (float) Math.sin(f10 * f37113k);
        }
    }

    public float b(float f10, long j10, View view, t.e eVar) {
        boolean z10;
        this.f37114a.e(f10, this.f37120g);
        float[] fArr = this.f37120g;
        float f11 = fArr[1];
        if (f11 == 0.0f) {
            this.f37121h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f37123j)) {
            float a10 = eVar.a(view, this.f37119f, 0);
            this.f37123j = a10;
            if (Float.isNaN(a10)) {
                this.f37123j = 0.0f;
            }
        }
        float f12 = (float) ((this.f37123j + (((j10 - this.f37122i) * 1.0E-9d) * f11)) % 1.0d);
        this.f37123j = f12;
        eVar.b(view, this.f37119f, 0, f12);
        this.f37122i = j10;
        float f13 = this.f37120g[0];
        float a11 = (a(this.f37123j) * f13) + this.f37120g[2];
        if (f13 == 0.0f && f11 == 0.0f) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f37121h = z10;
        return a11;
    }

    public void e(int i10, float f10, float f11, int i11, float f12) {
        int[] iArr = this.f37116c;
        int i12 = this.f37118e;
        iArr[i12] = i10;
        float[] fArr = this.f37117d[i12];
        fArr[0] = f10;
        fArr[1] = f11;
        fArr[2] = f12;
        this.f37115b = Math.max(this.f37115b, i11);
        this.f37118e++;
    }

    public abstract boolean f(View view, float f10, long j10, t.e eVar);

    public void g(long j10) {
        this.f37122i = j10;
    }

    public void h(String str) {
        this.f37119f = str;
    }

    public void i(int i10) {
        int i11 = this.f37118e;
        if (i11 == 0) {
            Log.e("SplineSet", "Error no points added to " + this.f37119f);
            return;
        }
        k.a(this.f37116c, this.f37117d, 0, i11 - 1);
        int i12 = 1;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f37116c;
            if (i12 >= iArr.length) {
                break;
            }
            if (iArr[i12] != iArr[i12 - 1]) {
                i13++;
            }
            i12++;
        }
        if (i13 == 0) {
            i13 = 1;
        }
        double[] dArr = new double[i13];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i13, 3);
        int i14 = 0;
        for (int i15 = 0; i15 < this.f37118e; i15++) {
            if (i15 > 0) {
                int[] iArr2 = this.f37116c;
                if (iArr2[i15] == iArr2[i15 - 1]) {
                }
            }
            dArr[i14] = this.f37116c[i15] * 0.01d;
            double[] dArr3 = dArr2[i14];
            float[] fArr = this.f37117d[i15];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
            i14++;
        }
        this.f37114a = s.b.a(i10, dArr, dArr2);
    }

    public String toString() {
        String str = this.f37119f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f37118e; i10++) {
            str = str + "[" + this.f37116c[i10] + " , " + decimalFormat.format(this.f37117d[i10]) + "] ";
        }
        return str;
    }
}
