package t;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: KeyCycleOscillator.java */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public s.b f36949a;

    /* renamed from: b, reason: collision with root package name */
    public d f36950b;

    /* renamed from: c, reason: collision with root package name */
    public ConstraintAttribute f36951c;

    /* renamed from: d, reason: collision with root package name */
    public String f36952d;

    /* renamed from: e, reason: collision with root package name */
    public int f36953e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f36954f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<p> f36955g = new ArrayList<>();

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<p> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(p pVar, p pVar2) {
            return Integer.compare(pVar.f36972a, pVar2.f36972a);
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class b extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setAlpha(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class c extends g {

        /* renamed from: h, reason: collision with root package name */
        public float[] f36957h = new float[1];

        @Override // t.g
        public void f(View view, float f10) {
            this.f36957h[0] = a(f10);
            this.f36951c.i(view, this.f36957h);
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f36958a;

        /* renamed from: c, reason: collision with root package name */
        public float[] f36960c;

        /* renamed from: d, reason: collision with root package name */
        public double[] f36961d;

        /* renamed from: e, reason: collision with root package name */
        public float[] f36962e;

        /* renamed from: f, reason: collision with root package name */
        public float[] f36963f;

        /* renamed from: g, reason: collision with root package name */
        public float[] f36964g;

        /* renamed from: h, reason: collision with root package name */
        public int f36965h;

        /* renamed from: i, reason: collision with root package name */
        public s.b f36966i;

        /* renamed from: j, reason: collision with root package name */
        public double[] f36967j;

        /* renamed from: k, reason: collision with root package name */
        public double[] f36968k;

        /* renamed from: l, reason: collision with root package name */
        public float f36969l;

        /* renamed from: b, reason: collision with root package name */
        public s.f f36959b = new s.f();

        /* renamed from: m, reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f36970m = new HashMap<>();

        public d(int i10, int i11, int i12) {
            this.f36965h = i10;
            this.f36958a = i11;
            this.f36959b.g(i10);
            this.f36960c = new float[i12];
            this.f36961d = new double[i12];
            this.f36962e = new float[i12];
            this.f36963f = new float[i12];
            this.f36964g = new float[i12];
        }

        public double a(float f10) {
            s.b bVar = this.f36966i;
            if (bVar != null) {
                double d10 = f10;
                bVar.g(d10, this.f36968k);
                this.f36966i.d(d10, this.f36967j);
            } else {
                double[] dArr = this.f36968k;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
            }
            double d11 = f10;
            double e10 = this.f36959b.e(d11);
            double d12 = this.f36959b.d(d11);
            double[] dArr2 = this.f36968k;
            return dArr2[0] + (e10 * dArr2[1]) + (d12 * this.f36967j[1]);
        }

        public double b(float f10) {
            s.b bVar = this.f36966i;
            if (bVar != null) {
                bVar.d(f10, this.f36967j);
            } else {
                double[] dArr = this.f36967j;
                dArr[0] = this.f36963f[0];
                dArr[1] = this.f36960c[0];
            }
            return this.f36967j[0] + (this.f36959b.e(f10) * this.f36967j[1]);
        }

        public void c(int i10, int i11, float f10, float f11, float f12) {
            this.f36961d[i10] = i11 / 100.0d;
            this.f36962e[i10] = f10;
            this.f36963f[i10] = f11;
            this.f36960c[i10] = f12;
        }

        public void d(float f10) {
            this.f36969l = f10;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f36961d.length, 2);
            float[] fArr = this.f36960c;
            this.f36967j = new double[fArr.length + 1];
            this.f36968k = new double[fArr.length + 1];
            if (this.f36961d[0] > 0.0d) {
                this.f36959b.a(0.0d, this.f36962e[0]);
            }
            double[] dArr2 = this.f36961d;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f36959b.a(1.0d, this.f36962e[length]);
            }
            for (int i10 = 0; i10 < dArr.length; i10++) {
                dArr[i10][0] = this.f36963f[i10];
                int i11 = 0;
                while (true) {
                    if (i11 < this.f36960c.length) {
                        dArr[i11][1] = r4[i11];
                        i11++;
                    }
                }
                this.f36959b.a(this.f36961d[i10], this.f36962e[i10]);
            }
            this.f36959b.f();
            double[] dArr3 = this.f36961d;
            if (dArr3.length > 1) {
                this.f36966i = s.b.a(0, dArr3, dArr);
            } else {
                this.f36966i = null;
            }
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class e extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setElevation(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* renamed from: t.g$g, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0361g extends g {

        /* renamed from: h, reason: collision with root package name */
        public boolean f36971h = false;

        @Override // t.g
        public void f(View view, float f10) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f10));
                return;
            }
            if (this.f36971h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f36971h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f10)));
                } catch (IllegalAccessException e10) {
                    Log.e("KeyCycleOscillator", "unable to setProgress", e10);
                } catch (InvocationTargetException e11) {
                    Log.e("KeyCycleOscillator", "unable to setProgress", e11);
                }
            }
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class h extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setRotation(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class i extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setRotationX(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class j extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setRotationY(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class k extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setScaleX(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class l extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setScaleY(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class m extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setTranslationX(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class n extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setTranslationY(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class o extends g {
        @Override // t.g
        public void f(View view, float f10) {
            view.setTranslationZ(a(f10));
        }
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class p {

        /* renamed from: a, reason: collision with root package name */
        public int f36972a;

        /* renamed from: b, reason: collision with root package name */
        public float f36973b;

        /* renamed from: c, reason: collision with root package name */
        public float f36974c;

        /* renamed from: d, reason: collision with root package name */
        public float f36975d;

        public p(int i10, float f10, float f11, float f12) {
            this.f36972a = i10;
            this.f36973b = f12;
            this.f36974c = f11;
            this.f36975d = f10;
        }
    }

    public static g c(String str) {
        if (str.startsWith("CUSTOM")) {
            return new c();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c10 = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c10 = '\n';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c10 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c10 = '\f';
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c10 = '\r';
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
                return new m();
            case 3:
                return new n();
            case 4:
                return new o();
            case 5:
                return new C0361g();
            case 6:
                return new k();
            case 7:
                return new l();
            case '\b':
                return new b();
            case '\t':
                return new h();
            case '\n':
                return new e();
            case 11:
                return new f();
            case '\f':
                return new b();
            case '\r':
                return new b();
            default:
                return null;
        }
    }

    public float a(float f10) {
        return (float) this.f36950b.b(f10);
    }

    public float b(float f10) {
        return (float) this.f36950b.a(f10);
    }

    public void d(int i10, int i11, int i12, float f10, float f11, float f12) {
        this.f36955g.add(new p(i10, f10, f11, f12));
        if (i12 != -1) {
            this.f36954f = i12;
        }
        this.f36953e = i11;
    }

    public void e(int i10, int i11, int i12, float f10, float f11, float f12, ConstraintAttribute constraintAttribute) {
        this.f36955g.add(new p(i10, f10, f11, f12));
        if (i12 != -1) {
            this.f36954f = i12;
        }
        this.f36953e = i11;
        this.f36951c = constraintAttribute;
    }

    public abstract void f(View view, float f10);

    public void g(String str) {
        this.f36952d = str;
    }

    public void h(float f10) {
        int size = this.f36955g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f36955g, new a());
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 2);
        this.f36950b = new d(this.f36953e, this.f36954f, size);
        Iterator<p> it = this.f36955g.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            p next = it.next();
            float f11 = next.f36975d;
            dArr[i10] = f11 * 0.01d;
            double[] dArr3 = dArr2[i10];
            float f12 = next.f36973b;
            dArr3[0] = f12;
            float f13 = next.f36974c;
            dArr3[1] = f13;
            this.f36950b.c(i10, next.f36972a, f11, f13, f12);
            i10++;
        }
        this.f36950b.d(f10);
        this.f36949a = s.b.a(0, dArr, dArr2);
    }

    public boolean i() {
        if (this.f36954f == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str = this.f36952d;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<p> it = this.f36955g.iterator();
        while (it.hasNext()) {
            str = str + "[" + it.next().f36972a + " , " + decimalFormat.format(r2.f36973b) + "] ";
        }
        return str;
    }

    /* compiled from: KeyCycleOscillator.java */
    /* loaded from: classes.dex */
    public static class f extends g {
        public void j(View view, float f10, double d10, double d11) {
            view.setRotation(a(f10) + ((float) Math.toDegrees(Math.atan2(d11, d10))));
        }

        @Override // t.g
        public void f(View view, float f10) {
        }
    }
}
