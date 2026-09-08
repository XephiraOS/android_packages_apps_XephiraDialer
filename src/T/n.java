package t;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import t.g;
import t.q;
import t.r;

/* compiled from: MotionController.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: A, reason: collision with root package name */
    public l[] f37060A;

    /* renamed from: a, reason: collision with root package name */
    public View f37062a;

    /* renamed from: b, reason: collision with root package name */
    public int f37063b;

    /* renamed from: c, reason: collision with root package name */
    public String f37064c;

    /* renamed from: i, reason: collision with root package name */
    public s.b[] f37070i;

    /* renamed from: j, reason: collision with root package name */
    public s.b f37071j;

    /* renamed from: n, reason: collision with root package name */
    public int[] f37075n;

    /* renamed from: o, reason: collision with root package name */
    public double[] f37076o;

    /* renamed from: p, reason: collision with root package name */
    public double[] f37077p;

    /* renamed from: q, reason: collision with root package name */
    public String[] f37078q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f37079r;

    /* renamed from: x, reason: collision with root package name */
    public HashMap<String, r> f37085x;

    /* renamed from: y, reason: collision with root package name */
    public HashMap<String, q> f37086y;

    /* renamed from: z, reason: collision with root package name */
    public HashMap<String, g> f37087z;

    /* renamed from: d, reason: collision with root package name */
    public int f37065d = -1;

    /* renamed from: e, reason: collision with root package name */
    public p f37066e = new p();

    /* renamed from: f, reason: collision with root package name */
    public p f37067f = new p();

    /* renamed from: g, reason: collision with root package name */
    public m f37068g = new m();

    /* renamed from: h, reason: collision with root package name */
    public m f37069h = new m();

    /* renamed from: k, reason: collision with root package name */
    public float f37072k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f37073l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f37074m = 1.0f;

    /* renamed from: s, reason: collision with root package name */
    public int f37080s = 4;

    /* renamed from: t, reason: collision with root package name */
    public float[] f37081t = new float[4];

    /* renamed from: u, reason: collision with root package name */
    public ArrayList<p> f37082u = new ArrayList<>();

    /* renamed from: v, reason: collision with root package name */
    public float[] f37083v = new float[1];

    /* renamed from: w, reason: collision with root package name */
    public ArrayList<AbstractC1575c> f37084w = new ArrayList<>();

    /* renamed from: B, reason: collision with root package name */
    public int f37061B = AbstractC1575c.f36905f;

    public n(View view) {
        u(view);
    }

    public void a(AbstractC1575c abstractC1575c) {
        this.f37084w.add(abstractC1575c);
    }

    public void b(ArrayList<AbstractC1575c> arrayList) {
        this.f37084w.addAll(arrayList);
    }

    public int c(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] h10 = this.f37070i[0].h();
        if (iArr != null) {
            Iterator<p> it = this.f37082u.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                iArr[i10] = it.next().f37101m;
                i10++;
            }
        }
        int i11 = 0;
        for (double d10 : h10) {
            this.f37070i[0].d(d10, this.f37076o);
            this.f37066e.f(this.f37075n, this.f37076o, fArr, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    public void d(float[] fArr, int i10) {
        q qVar;
        q qVar2;
        g gVar;
        int i11 = i10;
        float f10 = 1.0f;
        float f11 = 1.0f / (i11 - 1);
        HashMap<String, q> hashMap = this.f37086y;
        g gVar2 = null;
        if (hashMap == null) {
            qVar = null;
        } else {
            qVar = hashMap.get("translationX");
        }
        HashMap<String, q> hashMap2 = this.f37086y;
        if (hashMap2 == null) {
            qVar2 = null;
        } else {
            qVar2 = hashMap2.get("translationY");
        }
        HashMap<String, g> hashMap3 = this.f37087z;
        if (hashMap3 == null) {
            gVar = null;
        } else {
            gVar = hashMap3.get("translationX");
        }
        HashMap<String, g> hashMap4 = this.f37087z;
        if (hashMap4 != null) {
            gVar2 = hashMap4.get("translationY");
        }
        int i12 = 0;
        while (i12 < i11) {
            float f12 = i12 * f11;
            float f13 = this.f37074m;
            if (f13 != f10) {
                float f14 = this.f37073l;
                if (f12 < f14) {
                    f12 = 0.0f;
                }
                if (f12 > f14 && f12 < 1.0d) {
                    f12 = (f12 - f14) * f13;
                }
            }
            double d10 = f12;
            s.c cVar = this.f37066e.f37089a;
            Iterator<p> it = this.f37082u.iterator();
            float f15 = Float.NaN;
            float f16 = 0.0f;
            while (it.hasNext()) {
                p next = it.next();
                s.c cVar2 = next.f37089a;
                if (cVar2 != null) {
                    float f17 = next.f37091c;
                    if (f17 < f12) {
                        f16 = f17;
                        cVar = cVar2;
                    } else if (Float.isNaN(f15)) {
                        f15 = next.f37091c;
                    }
                }
            }
            if (cVar != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                d10 = (((float) cVar.a((f12 - f16) / r17)) * (f15 - f16)) + f16;
            }
            this.f37070i[0].d(d10, this.f37076o);
            s.b bVar = this.f37071j;
            if (bVar != null) {
                double[] dArr = this.f37076o;
                if (dArr.length > 0) {
                    bVar.d(d10, dArr);
                }
            }
            int i13 = i12 * 2;
            this.f37066e.f(this.f37075n, this.f37076o, fArr, i13);
            if (gVar != null) {
                fArr[i13] = fArr[i13] + gVar.a(f12);
            } else if (qVar != null) {
                fArr[i13] = fArr[i13] + qVar.a(f12);
            }
            if (gVar2 != null) {
                int i14 = i13 + 1;
                fArr[i14] = fArr[i14] + gVar2.a(f12);
            } else if (qVar2 != null) {
                int i15 = i13 + 1;
                fArr[i15] = fArr[i15] + qVar2.a(f12);
            }
            i12++;
            i11 = i10;
            f10 = 1.0f;
        }
    }

    public void e(float f10, float[] fArr, int i10) {
        this.f37070i[0].d(f(f10, null), this.f37076o);
        this.f37066e.i(this.f37075n, this.f37076o, fArr, i10);
    }

    public final float f(float f10, float[] fArr) {
        float f11 = 0.0f;
        float f12 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f13 = this.f37074m;
            if (f13 != 1.0d) {
                float f14 = this.f37073l;
                if (f10 < f14) {
                    f10 = 0.0f;
                }
                if (f10 > f14 && f10 < 1.0d) {
                    f10 = (f10 - f14) * f13;
                }
            }
        }
        s.c cVar = this.f37066e.f37089a;
        Iterator<p> it = this.f37082u.iterator();
        float f15 = Float.NaN;
        while (it.hasNext()) {
            p next = it.next();
            s.c cVar2 = next.f37089a;
            if (cVar2 != null) {
                float f16 = next.f37091c;
                if (f16 < f10) {
                    cVar = cVar2;
                    f11 = f16;
                } else if (Float.isNaN(f15)) {
                    f15 = next.f37091c;
                }
            }
        }
        if (cVar != null) {
            if (!Float.isNaN(f15)) {
                f12 = f15;
            }
            float f17 = f12 - f11;
            double d10 = (f10 - f11) / f17;
            float a10 = f11 + (((float) cVar.a(d10)) * f17);
            if (fArr != null) {
                fArr[0] = (float) cVar.b(d10);
            }
            return a10;
        }
        return f10;
    }

    public void g(float f10, float f11, float f12, float[] fArr) {
        double[] dArr;
        float f13 = f(f10, this.f37083v);
        s.b[] bVarArr = this.f37070i;
        int i10 = 0;
        if (bVarArr != null) {
            double d10 = f13;
            bVarArr[0].g(d10, this.f37077p);
            this.f37070i[0].d(d10, this.f37076o);
            float f14 = this.f37083v[0];
            while (true) {
                dArr = this.f37077p;
                if (i10 >= dArr.length) {
                    break;
                }
                dArr[i10] = dArr[i10] * f14;
                i10++;
            }
            s.b bVar = this.f37071j;
            if (bVar != null) {
                double[] dArr2 = this.f37076o;
                if (dArr2.length > 0) {
                    bVar.d(d10, dArr2);
                    this.f37071j.g(d10, this.f37077p);
                    this.f37066e.o(f11, f12, fArr, this.f37075n, this.f37077p, this.f37076o);
                    return;
                }
                return;
            }
            this.f37066e.o(f11, f12, fArr, this.f37075n, dArr, this.f37076o);
            return;
        }
        p pVar = this.f37067f;
        float f15 = pVar.f37093e;
        p pVar2 = this.f37066e;
        float f16 = f15 - pVar2.f37093e;
        float f17 = pVar.f37094f - pVar2.f37094f;
        float f18 = (pVar.f37095g - pVar2.f37095g) + f16;
        float f19 = (pVar.f37096h - pVar2.f37096h) + f17;
        fArr[0] = (f16 * (1.0f - f11)) + (f18 * f11);
        fArr[1] = (f17 * (1.0f - f12)) + (f19 * f12);
    }

    public int h() {
        int i10 = this.f37066e.f37090b;
        Iterator<p> it = this.f37082u.iterator();
        while (it.hasNext()) {
            i10 = Math.max(i10, it.next().f37090b);
        }
        return Math.max(i10, this.f37067f.f37090b);
    }

    public float i() {
        return this.f37067f.f37093e;
    }

    public float j() {
        return this.f37067f.f37094f;
    }

    public p k(int i10) {
        return this.f37082u.get(i10);
    }

    public void l(float f10, int i10, int i11, float f11, float f12, float[] fArr) {
        q qVar;
        q qVar2;
        q qVar3;
        q qVar4;
        q qVar5;
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        float f13 = f(f10, this.f37083v);
        HashMap<String, q> hashMap = this.f37086y;
        g gVar5 = null;
        if (hashMap == null) {
            qVar = null;
        } else {
            qVar = hashMap.get("translationX");
        }
        HashMap<String, q> hashMap2 = this.f37086y;
        if (hashMap2 == null) {
            qVar2 = null;
        } else {
            qVar2 = hashMap2.get("translationY");
        }
        HashMap<String, q> hashMap3 = this.f37086y;
        if (hashMap3 == null) {
            qVar3 = null;
        } else {
            qVar3 = hashMap3.get("rotation");
        }
        HashMap<String, q> hashMap4 = this.f37086y;
        if (hashMap4 == null) {
            qVar4 = null;
        } else {
            qVar4 = hashMap4.get("scaleX");
        }
        HashMap<String, q> hashMap5 = this.f37086y;
        if (hashMap5 == null) {
            qVar5 = null;
        } else {
            qVar5 = hashMap5.get("scaleY");
        }
        HashMap<String, g> hashMap6 = this.f37087z;
        if (hashMap6 == null) {
            gVar = null;
        } else {
            gVar = hashMap6.get("translationX");
        }
        HashMap<String, g> hashMap7 = this.f37087z;
        if (hashMap7 == null) {
            gVar2 = null;
        } else {
            gVar2 = hashMap7.get("translationY");
        }
        HashMap<String, g> hashMap8 = this.f37087z;
        if (hashMap8 == null) {
            gVar3 = null;
        } else {
            gVar3 = hashMap8.get("rotation");
        }
        HashMap<String, g> hashMap9 = this.f37087z;
        if (hashMap9 == null) {
            gVar4 = null;
        } else {
            gVar4 = hashMap9.get("scaleX");
        }
        HashMap<String, g> hashMap10 = this.f37087z;
        if (hashMap10 != null) {
            gVar5 = hashMap10.get("scaleY");
        }
        s.h hVar = new s.h();
        hVar.b();
        hVar.d(qVar3, f13);
        hVar.h(qVar, qVar2, f13);
        hVar.f(qVar4, qVar5, f13);
        hVar.c(gVar3, f13);
        hVar.g(gVar, gVar2, f13);
        hVar.e(gVar4, gVar5, f13);
        s.b bVar = this.f37071j;
        if (bVar != null) {
            double[] dArr = this.f37076o;
            if (dArr.length > 0) {
                double d10 = f13;
                bVar.d(d10, dArr);
                this.f37071j.g(d10, this.f37077p);
                this.f37066e.o(f11, f12, fArr, this.f37075n, this.f37077p, this.f37076o);
            }
            hVar.a(f11, f12, i10, i11, fArr);
            return;
        }
        int i12 = 0;
        if (this.f37070i != null) {
            double f14 = f(f13, this.f37083v);
            this.f37070i[0].g(f14, this.f37077p);
            this.f37070i[0].d(f14, this.f37076o);
            float f15 = this.f37083v[0];
            while (true) {
                double[] dArr2 = this.f37077p;
                if (i12 < dArr2.length) {
                    dArr2[i12] = dArr2[i12] * f15;
                    i12++;
                } else {
                    this.f37066e.o(f11, f12, fArr, this.f37075n, dArr2, this.f37076o);
                    hVar.a(f11, f12, i10, i11, fArr);
                    return;
                }
            }
        } else {
            p pVar = this.f37067f;
            float f16 = pVar.f37093e;
            p pVar2 = this.f37066e;
            float f17 = f16 - pVar2.f37093e;
            g gVar6 = gVar5;
            float f18 = pVar.f37094f - pVar2.f37094f;
            g gVar7 = gVar4;
            float f19 = (pVar.f37095g - pVar2.f37095g) + f17;
            float f20 = (pVar.f37096h - pVar2.f37096h) + f18;
            fArr[0] = (f17 * (1.0f - f11)) + (f19 * f11);
            fArr[1] = (f18 * (1.0f - f12)) + (f20 * f12);
            hVar.b();
            hVar.d(qVar3, f13);
            hVar.h(qVar, qVar2, f13);
            hVar.f(qVar4, qVar5, f13);
            hVar.c(gVar3, f13);
            hVar.g(gVar, gVar2, f13);
            hVar.e(gVar7, gVar6, f13);
            hVar.a(f11, f12, i10, i11, fArr);
        }
    }

    public final float m() {
        float[] fArr = new float[2];
        float f10 = 1.0f / 99;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i10 = 0;
        float f11 = 0.0f;
        while (i10 < 100) {
            float f12 = i10 * f10;
            double d12 = f12;
            s.c cVar = this.f37066e.f37089a;
            Iterator<p> it = this.f37082u.iterator();
            float f13 = Float.NaN;
            float f14 = 0.0f;
            while (it.hasNext()) {
                p next = it.next();
                s.c cVar2 = next.f37089a;
                float f15 = f10;
                if (cVar2 != null) {
                    float f16 = next.f37091c;
                    if (f16 < f12) {
                        f14 = f16;
                        cVar = cVar2;
                    } else if (Float.isNaN(f13)) {
                        f13 = next.f37091c;
                    }
                }
                f10 = f15;
            }
            float f17 = f10;
            if (cVar != null) {
                if (Float.isNaN(f13)) {
                    f13 = 1.0f;
                }
                d12 = (((float) cVar.a((f12 - f14) / r16)) * (f13 - f14)) + f14;
            }
            this.f37070i[0].d(d12, this.f37076o);
            this.f37066e.f(this.f37075n, this.f37076o, fArr, 0);
            if (i10 > 0) {
                f11 = (float) (f11 + Math.hypot(d11 - fArr[1], d10 - fArr[0]));
            }
            d10 = fArr[0];
            d11 = fArr[1];
            i10++;
            f10 = f17;
        }
        return f11;
    }

    public final void n(p pVar) {
        if (Collections.binarySearch(this.f37082u, pVar) == 0) {
            Log.e("MotionController", " KeyPath positon \"" + pVar.f37092d + "\" outside of range");
        }
        this.f37082u.add((-r0) - 1, pVar);
    }

    public boolean o(View view, float f10, long j10, e eVar) {
        r.d dVar;
        boolean z10;
        double d10;
        float f11 = f(f10, null);
        HashMap<String, q> hashMap = this.f37086y;
        if (hashMap != null) {
            Iterator<q> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().f(view, f11);
            }
        }
        HashMap<String, r> hashMap2 = this.f37085x;
        if (hashMap2 != null) {
            dVar = null;
            boolean z11 = false;
            for (r rVar : hashMap2.values()) {
                if (rVar instanceof r.d) {
                    dVar = (r.d) rVar;
                } else {
                    z11 |= rVar.f(view, f11, j10, eVar);
                }
            }
            z10 = z11;
        } else {
            dVar = null;
            z10 = false;
        }
        s.b[] bVarArr = this.f37070i;
        if (bVarArr != null) {
            double d11 = f11;
            bVarArr[0].d(d11, this.f37076o);
            this.f37070i[0].g(d11, this.f37077p);
            s.b bVar = this.f37071j;
            if (bVar != null) {
                double[] dArr = this.f37076o;
                if (dArr.length > 0) {
                    bVar.d(d11, dArr);
                    this.f37071j.g(d11, this.f37077p);
                }
            }
            this.f37066e.p(view, this.f37075n, this.f37076o, this.f37077p, null);
            HashMap<String, q> hashMap3 = this.f37086y;
            if (hashMap3 != null) {
                for (q qVar : hashMap3.values()) {
                    if (qVar instanceof q.d) {
                        double[] dArr2 = this.f37077p;
                        ((q.d) qVar).i(view, f11, dArr2[0], dArr2[1]);
                    }
                }
            }
            if (dVar != null) {
                double[] dArr3 = this.f37077p;
                d10 = d11;
                z10 |= dVar.j(view, eVar, f11, j10, dArr3[0], dArr3[1]);
            } else {
                d10 = d11;
            }
            int i10 = 1;
            while (true) {
                s.b[] bVarArr2 = this.f37070i;
                if (i10 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i10].e(d10, this.f37081t);
                this.f37066e.f37100l.get(this.f37078q[i10 - 1]).i(view, this.f37081t);
                i10++;
            }
            m mVar = this.f37068g;
            if (mVar.f37040b == 0) {
                if (f11 <= 0.0f) {
                    view.setVisibility(mVar.f37041c);
                } else if (f11 >= 1.0f) {
                    view.setVisibility(this.f37069h.f37041c);
                } else if (this.f37069h.f37041c != mVar.f37041c) {
                    view.setVisibility(0);
                }
            }
            if (this.f37060A != null) {
                int i11 = 0;
                while (true) {
                    l[] lVarArr = this.f37060A;
                    if (i11 >= lVarArr.length) {
                        break;
                    }
                    lVarArr[i11].r(f11, view);
                    i11++;
                }
            }
        } else {
            p pVar = this.f37066e;
            float f12 = pVar.f37093e;
            p pVar2 = this.f37067f;
            float f13 = f12 + ((pVar2.f37093e - f12) * f11);
            float f14 = pVar.f37094f;
            float f15 = f14 + ((pVar2.f37094f - f14) * f11);
            float f16 = pVar.f37095g;
            float f17 = pVar2.f37095g;
            float f18 = pVar.f37096h;
            float f19 = pVar2.f37096h;
            float f20 = f13 + 0.5f;
            int i12 = (int) f20;
            float f21 = f15 + 0.5f;
            int i13 = (int) f21;
            int i14 = (int) (f20 + ((f17 - f16) * f11) + f16);
            int i15 = (int) (f21 + ((f19 - f18) * f11) + f18);
            int i16 = i14 - i12;
            int i17 = i15 - i13;
            if (f17 != f16 || f19 != f18) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i16, 1073741824), View.MeasureSpec.makeMeasureSpec(i17, 1073741824));
            }
            view.layout(i12, i13, i14, i15);
        }
        HashMap<String, g> hashMap4 = this.f37087z;
        if (hashMap4 != null) {
            for (g gVar : hashMap4.values()) {
                if (gVar instanceof g.f) {
                    double[] dArr4 = this.f37077p;
                    ((g.f) gVar).j(view, f11, dArr4[0], dArr4[1]);
                } else {
                    gVar.f(view, f11);
                }
            }
        }
        return z10;
    }

    public final void p(p pVar) {
        pVar.n((int) this.f37062a.getX(), (int) this.f37062a.getY(), this.f37062a.getWidth(), this.f37062a.getHeight());
    }

    public void q(ConstraintWidget constraintWidget, androidx.constraintlayout.widget.b bVar) {
        p pVar = this.f37067f;
        pVar.f37091c = 1.0f;
        pVar.f37092d = 1.0f;
        p(pVar);
        this.f37067f.n(constraintWidget.V(), constraintWidget.W(), constraintWidget.U(), constraintWidget.y());
        this.f37067f.a(bVar.s(this.f37063b));
        this.f37069h.i(constraintWidget, bVar, this.f37063b);
    }

    public void r(int i10) {
        this.f37061B = i10;
    }

    public void s(View view) {
        p pVar = this.f37066e;
        pVar.f37091c = 0.0f;
        pVar.f37092d = 0.0f;
        pVar.n(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.f37068g.h(view);
    }

    public void t(ConstraintWidget constraintWidget, androidx.constraintlayout.widget.b bVar) {
        p pVar = this.f37066e;
        pVar.f37091c = 0.0f;
        pVar.f37092d = 0.0f;
        p(pVar);
        this.f37066e.n(constraintWidget.V(), constraintWidget.W(), constraintWidget.U(), constraintWidget.y());
        b.a s10 = bVar.s(this.f37063b);
        this.f37066e.a(s10);
        this.f37072k = s10.f8697c.f8770f;
        this.f37068g.i(constraintWidget, bVar, this.f37063b);
    }

    public String toString() {
        return " start: x: " + this.f37066e.f37093e + " y: " + this.f37066e.f37094f + " end: x: " + this.f37067f.f37093e + " y: " + this.f37067f.f37094f;
    }

    public void u(View view) {
        this.f37062a = view;
        this.f37063b = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.f37064c = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void v(int i10, int i11, float f10, long j10) {
        ArrayList arrayList;
        String[] strArr;
        boolean z10;
        HashSet<String> hashSet;
        int i12;
        r d10;
        ConstraintAttribute constraintAttribute;
        int i13;
        q d11;
        ConstraintAttribute constraintAttribute2;
        new HashSet();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashSet<String> hashSet4 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i14 = this.f37061B;
        if (i14 != AbstractC1575c.f36905f) {
            this.f37066e.f37099k = i14;
        }
        this.f37068g.f(this.f37069h, hashSet3);
        ArrayList<AbstractC1575c> arrayList2 = this.f37084w;
        if (arrayList2 != null) {
            Iterator<AbstractC1575c> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                AbstractC1575c next = it.next();
                if (next instanceof i) {
                    i iVar = (i) next;
                    n(new p(i10, i11, iVar, this.f37066e, this.f37067f));
                    int i15 = iVar.f36991g;
                    if (i15 != AbstractC1575c.f36905f) {
                        this.f37065d = i15;
                    }
                } else if (next instanceof f) {
                    next.b(hashSet4);
                } else if (next instanceof k) {
                    next.b(hashSet2);
                } else if (next instanceof l) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((l) next);
                } else {
                    next.e(hashMap);
                    next.b(hashSet3);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.f37060A = (l[]) arrayList.toArray(new l[0]);
        }
        char c10 = 1;
        if (!hashSet3.isEmpty()) {
            this.f37086y = new HashMap<>();
            Iterator<String> it2 = hashSet3.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[1];
                    Iterator<AbstractC1575c> it3 = this.f37084w.iterator();
                    while (it3.hasNext()) {
                        AbstractC1575c next3 = it3.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next3.f36910e;
                        if (hashMap2 != null && (constraintAttribute2 = hashMap2.get(str)) != null) {
                            sparseArray.append(next3.f36906a, constraintAttribute2);
                        }
                    }
                    d11 = q.c(next2, sparseArray);
                } else {
                    d11 = q.d(next2);
                }
                if (d11 != null) {
                    d11.g(next2);
                    this.f37086y.put(next2, d11);
                }
            }
            ArrayList<AbstractC1575c> arrayList3 = this.f37084w;
            if (arrayList3 != null) {
                Iterator<AbstractC1575c> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    AbstractC1575c next4 = it4.next();
                    if (next4 instanceof C1576d) {
                        next4.a(this.f37086y);
                    }
                }
            }
            this.f37068g.a(this.f37086y, 0);
            this.f37069h.a(this.f37086y, 100);
            for (String str2 : this.f37086y.keySet()) {
                if (hashMap.containsKey(str2)) {
                    i13 = hashMap.get(str2).intValue();
                } else {
                    i13 = 0;
                }
                this.f37086y.get(str2).h(i13);
            }
        }
        if (!hashSet2.isEmpty()) {
            if (this.f37085x == null) {
                this.f37085x = new HashMap<>();
            }
            Iterator<String> it5 = hashSet2.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.f37085x.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[1];
                        Iterator<AbstractC1575c> it6 = this.f37084w.iterator();
                        while (it6.hasNext()) {
                            AbstractC1575c next6 = it6.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next6.f36910e;
                            if (hashMap3 != null && (constraintAttribute = hashMap3.get(str3)) != null) {
                                sparseArray2.append(next6.f36906a, constraintAttribute);
                            }
                        }
                        d10 = r.c(next5, sparseArray2);
                    } else {
                        d10 = r.d(next5, j10);
                    }
                    if (d10 != null) {
                        d10.h(next5);
                        this.f37085x.put(next5, d10);
                    }
                }
            }
            ArrayList<AbstractC1575c> arrayList4 = this.f37084w;
            if (arrayList4 != null) {
                Iterator<AbstractC1575c> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    AbstractC1575c next7 = it7.next();
                    if (next7 instanceof k) {
                        ((k) next7).M(this.f37085x);
                    }
                }
            }
            for (String str4 : this.f37085x.keySet()) {
                if (hashMap.containsKey(str4)) {
                    i12 = hashMap.get(str4).intValue();
                } else {
                    i12 = 0;
                }
                this.f37085x.get(str4).i(i12);
            }
        }
        int size = this.f37082u.size();
        int i16 = size + 2;
        p[] pVarArr = new p[i16];
        pVarArr[0] = this.f37066e;
        pVarArr[size + 1] = this.f37067f;
        if (this.f37082u.size() > 0 && this.f37065d == -1) {
            this.f37065d = 0;
        }
        Iterator<p> it8 = this.f37082u.iterator();
        int i17 = 1;
        while (it8.hasNext()) {
            pVarArr[i17] = it8.next();
            i17++;
        }
        HashSet hashSet5 = new HashSet();
        for (String str5 : this.f37067f.f37100l.keySet()) {
            if (this.f37066e.f37100l.containsKey(str5)) {
                if (!hashSet3.contains("CUSTOM," + str5)) {
                    hashSet5.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet5.toArray(new String[0]);
        this.f37078q = strArr2;
        this.f37079r = new int[strArr2.length];
        int i18 = 0;
        while (true) {
            strArr = this.f37078q;
            if (i18 >= strArr.length) {
                break;
            }
            String str6 = strArr[i18];
            this.f37079r[i18] = 0;
            int i19 = 0;
            while (true) {
                if (i19 >= i16) {
                    break;
                }
                if (pVarArr[i19].f37100l.containsKey(str6)) {
                    int[] iArr = this.f37079r;
                    iArr[i18] = iArr[i18] + pVarArr[i19].f37100l.get(str6).f();
                    break;
                }
                i19++;
            }
            i18++;
        }
        if (pVarArr[0].f37099k != AbstractC1575c.f36905f) {
            z10 = true;
        } else {
            z10 = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i20 = 1; i20 < i16; i20++) {
            pVarArr[i20].d(pVarArr[i20 - 1], zArr, this.f37078q, z10);
        }
        int i21 = 0;
        for (int i22 = 1; i22 < length; i22++) {
            if (zArr[i22]) {
                i21++;
            }
        }
        int[] iArr2 = new int[i21];
        this.f37075n = iArr2;
        this.f37076o = new double[iArr2.length];
        this.f37077p = new double[iArr2.length];
        int i23 = 0;
        for (int i24 = 1; i24 < length; i24++) {
            if (zArr[i24]) {
                this.f37075n[i23] = i24;
                i23++;
            }
        }
        int i25 = 2;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i16, this.f37075n.length);
        double[] dArr2 = new double[i16];
        for (int i26 = 0; i26 < i16; i26++) {
            pVarArr[i26].e(dArr[i26], this.f37075n);
            dArr2[i26] = pVarArr[i26].f37091c;
        }
        int i27 = 0;
        while (true) {
            int[] iArr3 = this.f37075n;
            if (i27 >= iArr3.length) {
                break;
            }
            if (iArr3[i27] < p.f37088p.length) {
                String str7 = p.f37088p[this.f37075n[i27]] + " [";
                for (int i28 = 0; i28 < i16; i28++) {
                    str7 = str7 + dArr[i28][i27];
                }
            }
            i27++;
        }
        this.f37070i = new s.b[this.f37078q.length + 1];
        int i29 = 0;
        while (true) {
            String[] strArr3 = this.f37078q;
            if (i29 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i29];
            int i30 = 0;
            int i31 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i30 < i16) {
                if (pVarArr[i30].j(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i16];
                        int[] iArr4 = new int[i25];
                        iArr4[c10] = pVarArr[i30].h(str8);
                        iArr4[0] = i16;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iArr4);
                    }
                    p pVar = pVarArr[i30];
                    hashSet = hashSet4;
                    dArr3[i31] = pVar.f37091c;
                    pVar.g(str8, dArr4[i31], 0);
                    i31++;
                } else {
                    hashSet = hashSet4;
                }
                i30++;
                hashSet4 = hashSet;
                i25 = 2;
                c10 = 1;
            }
            i29++;
            this.f37070i[i29] = s.b.a(this.f37065d, Arrays.copyOf(dArr3, i31), (double[][]) Arrays.copyOf(dArr4, i31));
            hashSet4 = hashSet4;
            i25 = 2;
            c10 = 1;
        }
        HashSet<String> hashSet6 = hashSet4;
        this.f37070i[0] = s.b.a(this.f37065d, dArr2, dArr);
        if (pVarArr[0].f37099k != AbstractC1575c.f36905f) {
            int[] iArr5 = new int[i16];
            double[] dArr5 = new double[i16];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, i16, 2);
            for (int i32 = 0; i32 < i16; i32++) {
                iArr5[i32] = pVarArr[i32].f37099k;
                dArr5[i32] = r8.f37091c;
                double[] dArr7 = dArr6[i32];
                dArr7[0] = r8.f37093e;
                dArr7[1] = r8.f37094f;
            }
            this.f37071j = s.b.b(iArr5, dArr5, dArr6);
        }
        this.f37087z = new HashMap<>();
        if (this.f37084w != null) {
            Iterator<String> it9 = hashSet6.iterator();
            float f11 = Float.NaN;
            while (it9.hasNext()) {
                String next8 = it9.next();
                g c11 = g.c(next8);
                if (c11 != null) {
                    if (c11.i() && Float.isNaN(f11)) {
                        f11 = m();
                    }
                    c11.g(next8);
                    this.f37087z.put(next8, c11);
                }
            }
            Iterator<AbstractC1575c> it10 = this.f37084w.iterator();
            while (it10.hasNext()) {
                AbstractC1575c next9 = it10.next();
                if (next9 instanceof f) {
                    ((f) next9).O(this.f37087z);
                }
            }
            Iterator<g> it11 = this.f37087z.values().iterator();
            while (it11.hasNext()) {
                it11.next().h(f11);
            }
        }
    }
}
