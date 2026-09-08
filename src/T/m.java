package t;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import t.q;

/* compiled from: MotionConstrainedPoint.java */
/* loaded from: classes.dex */
public class m implements Comparable<m> {

    /* renamed from: H, reason: collision with root package name */
    public static String[] f37031H = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: A, reason: collision with root package name */
    public float f37032A;

    /* renamed from: c, reason: collision with root package name */
    public int f37041c;

    /* renamed from: p, reason: collision with root package name */
    public s.c f37054p;

    /* renamed from: r, reason: collision with root package name */
    public float f37056r;

    /* renamed from: x, reason: collision with root package name */
    public float f37057x;

    /* renamed from: y, reason: collision with root package name */
    public float f37058y;

    /* renamed from: z, reason: collision with root package name */
    public float f37059z;

    /* renamed from: a, reason: collision with root package name */
    public float f37039a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    public int f37040b = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f37042d = false;

    /* renamed from: e, reason: collision with root package name */
    public float f37043e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f37044f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public float f37045g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f37046h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f37047i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f37048j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f37049k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f37050l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f37051m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f37052n = 0.0f;

    /* renamed from: o, reason: collision with root package name */
    public float f37053o = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    public int f37055q = 0;

    /* renamed from: B, reason: collision with root package name */
    public float f37033B = Float.NaN;

    /* renamed from: C, reason: collision with root package name */
    public float f37034C = Float.NaN;

    /* renamed from: D, reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f37035D = new LinkedHashMap<>();

    /* renamed from: E, reason: collision with root package name */
    public int f37036E = 0;

    /* renamed from: F, reason: collision with root package name */
    public double[] f37037F = new double[18];

    /* renamed from: G, reason: collision with root package name */
    public double[] f37038G = new double[18];

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0023. Please report as an issue. */
    public void a(HashMap<String, q> hashMap, int i10) {
        for (String str : hashMap.keySet()) {
            q qVar = hashMap.get(str);
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
                case -760884510:
                    if (str.equals("transformPivotX")) {
                        c10 = '\b';
                        break;
                    }
                    break;
                case -760884509:
                    if (str.equals("transformPivotY")) {
                        c10 = '\t';
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        c10 = '\n';
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        c10 = 11;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals("transitionPathRotate")) {
                        c10 = '\f';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c10 = '\r';
                        break;
                    }
                    break;
            }
            float f10 = 1.0f;
            float f11 = 0.0f;
            switch (c10) {
                case 0:
                    if (!Float.isNaN(this.f37045g)) {
                        f11 = this.f37045g;
                    }
                    qVar.e(i10, f11);
                    break;
                case 1:
                    if (!Float.isNaN(this.f37046h)) {
                        f11 = this.f37046h;
                    }
                    qVar.e(i10, f11);
                    break;
                case 2:
                    if (!Float.isNaN(this.f37051m)) {
                        f11 = this.f37051m;
                    }
                    qVar.e(i10, f11);
                    break;
                case 3:
                    if (!Float.isNaN(this.f37052n)) {
                        f11 = this.f37052n;
                    }
                    qVar.e(i10, f11);
                    break;
                case 4:
                    if (!Float.isNaN(this.f37053o)) {
                        f11 = this.f37053o;
                    }
                    qVar.e(i10, f11);
                    break;
                case 5:
                    if (!Float.isNaN(this.f37034C)) {
                        f11 = this.f37034C;
                    }
                    qVar.e(i10, f11);
                    break;
                case 6:
                    if (!Float.isNaN(this.f37047i)) {
                        f10 = this.f37047i;
                    }
                    qVar.e(i10, f10);
                    break;
                case 7:
                    if (!Float.isNaN(this.f37048j)) {
                        f10 = this.f37048j;
                    }
                    qVar.e(i10, f10);
                    break;
                case '\b':
                    if (!Float.isNaN(this.f37049k)) {
                        f11 = this.f37049k;
                    }
                    qVar.e(i10, f11);
                    break;
                case '\t':
                    if (!Float.isNaN(this.f37050l)) {
                        f11 = this.f37050l;
                    }
                    qVar.e(i10, f11);
                    break;
                case '\n':
                    if (!Float.isNaN(this.f37044f)) {
                        f11 = this.f37044f;
                    }
                    qVar.e(i10, f11);
                    break;
                case 11:
                    if (!Float.isNaN(this.f37043e)) {
                        f11 = this.f37043e;
                    }
                    qVar.e(i10, f11);
                    break;
                case '\f':
                    if (!Float.isNaN(this.f37033B)) {
                        f11 = this.f37033B;
                    }
                    qVar.e(i10, f11);
                    break;
                case '\r':
                    if (!Float.isNaN(this.f37039a)) {
                        f10 = this.f37039a;
                    }
                    qVar.e(i10, f10);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        if (this.f37035D.containsKey(str2)) {
                            ConstraintAttribute constraintAttribute = this.f37035D.get(str2);
                            if (qVar instanceof q.b) {
                                ((q.b) qVar).i(i10, constraintAttribute);
                                break;
                            } else {
                                Log.e("MotionPaths", str + " splineSet not a CustomSet frame = " + i10 + ", value" + constraintAttribute.d() + qVar);
                                break;
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN customName " + str2);
                            break;
                        }
                    } else {
                        Log.e("MotionPaths", "UNKNOWN spline " + str);
                        break;
                    }
            }
        }
    }

    public void b(View view) {
        float alpha;
        this.f37041c = view.getVisibility();
        if (view.getVisibility() != 0) {
            alpha = 0.0f;
        } else {
            alpha = view.getAlpha();
        }
        this.f37039a = alpha;
        this.f37042d = false;
        this.f37043e = view.getElevation();
        this.f37044f = view.getRotation();
        this.f37045g = view.getRotationX();
        this.f37046h = view.getRotationY();
        this.f37047i = view.getScaleX();
        this.f37048j = view.getScaleY();
        this.f37049k = view.getPivotX();
        this.f37050l = view.getPivotY();
        this.f37051m = view.getTranslationX();
        this.f37052n = view.getTranslationY();
        this.f37053o = view.getTranslationZ();
    }

    public void c(b.a aVar) {
        float f10;
        b.d dVar = aVar.f8696b;
        int i10 = dVar.f8774c;
        this.f37040b = i10;
        int i11 = dVar.f8773b;
        this.f37041c = i11;
        if (i11 != 0 && i10 == 0) {
            f10 = 0.0f;
        } else {
            f10 = dVar.f8775d;
        }
        this.f37039a = f10;
        b.e eVar = aVar.f8699e;
        this.f37042d = eVar.f8789l;
        this.f37043e = eVar.f8790m;
        this.f37044f = eVar.f8779b;
        this.f37045g = eVar.f8780c;
        this.f37046h = eVar.f8781d;
        this.f37047i = eVar.f8782e;
        this.f37048j = eVar.f8783f;
        this.f37049k = eVar.f8784g;
        this.f37050l = eVar.f8785h;
        this.f37051m = eVar.f8786i;
        this.f37052n = eVar.f8787j;
        this.f37053o = eVar.f8788k;
        this.f37054p = s.c.c(aVar.f8697c.f8767c);
        b.c cVar = aVar.f8697c;
        this.f37033B = cVar.f8771g;
        this.f37055q = cVar.f8769e;
        this.f37034C = aVar.f8696b.f8776e;
        for (String str : aVar.f8700f.keySet()) {
            ConstraintAttribute constraintAttribute = aVar.f8700f.get(str);
            if (constraintAttribute.c() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.f37035D.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(m mVar) {
        return Float.compare(this.f37056r, mVar.f37056r);
    }

    public final boolean e(float f10, float f11) {
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

    public void f(m mVar, HashSet<String> hashSet) {
        if (e(this.f37039a, mVar.f37039a)) {
            hashSet.add("alpha");
        }
        if (e(this.f37043e, mVar.f37043e)) {
            hashSet.add("elevation");
        }
        int i10 = this.f37041c;
        int i11 = mVar.f37041c;
        if (i10 != i11 && this.f37040b == 0 && (i10 == 0 || i11 == 0)) {
            hashSet.add("alpha");
        }
        if (e(this.f37044f, mVar.f37044f)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f37033B) || !Float.isNaN(mVar.f37033B)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f37034C) || !Float.isNaN(mVar.f37034C)) {
            hashSet.add("progress");
        }
        if (e(this.f37045g, mVar.f37045g)) {
            hashSet.add("rotationX");
        }
        if (e(this.f37046h, mVar.f37046h)) {
            hashSet.add("rotationY");
        }
        if (e(this.f37049k, mVar.f37049k)) {
            hashSet.add("transformPivotX");
        }
        if (e(this.f37050l, mVar.f37050l)) {
            hashSet.add("transformPivotY");
        }
        if (e(this.f37047i, mVar.f37047i)) {
            hashSet.add("scaleX");
        }
        if (e(this.f37048j, mVar.f37048j)) {
            hashSet.add("scaleY");
        }
        if (e(this.f37051m, mVar.f37051m)) {
            hashSet.add("translationX");
        }
        if (e(this.f37052n, mVar.f37052n)) {
            hashSet.add("translationY");
        }
        if (e(this.f37053o, mVar.f37053o)) {
            hashSet.add("translationZ");
        }
    }

    public void g(float f10, float f11, float f12, float f13) {
        this.f37057x = f10;
        this.f37058y = f11;
        this.f37059z = f12;
        this.f37032A = f13;
    }

    public void h(View view) {
        g(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        b(view);
    }

    public void i(ConstraintWidget constraintWidget, androidx.constraintlayout.widget.b bVar, int i10) {
        g(constraintWidget.V(), constraintWidget.W(), constraintWidget.U(), constraintWidget.y());
        c(bVar.s(i10));
    }
}
