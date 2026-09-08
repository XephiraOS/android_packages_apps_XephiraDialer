package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: KeyCycle.java */
/* loaded from: classes.dex */
public class f extends AbstractC1575c {

    /* renamed from: g, reason: collision with root package name */
    public String f36930g = null;

    /* renamed from: h, reason: collision with root package name */
    public int f36931h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f36932i = -1;

    /* renamed from: j, reason: collision with root package name */
    public float f36933j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f36934k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    public float f36935l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public int f36936m = -1;

    /* renamed from: n, reason: collision with root package name */
    public float f36937n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public float f36938o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f36939p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f36940q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    public float f36941r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f36942s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    public float f36943t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    public float f36944u = Float.NaN;

    /* renamed from: v, reason: collision with root package name */
    public float f36945v = Float.NaN;

    /* renamed from: w, reason: collision with root package name */
    public float f36946w = Float.NaN;

    /* renamed from: x, reason: collision with root package name */
    public float f36947x = Float.NaN;

    /* compiled from: KeyCycle.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f36948a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f36948a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.e.f9111i4, 1);
            f36948a.append(androidx.constraintlayout.widget.e.f9091g4, 2);
            f36948a.append(androidx.constraintlayout.widget.e.f9121j4, 3);
            f36948a.append(androidx.constraintlayout.widget.e.f9081f4, 4);
            f36948a.append(androidx.constraintlayout.widget.e.f9161n4, 5);
            f36948a.append(androidx.constraintlayout.widget.e.f9151m4, 6);
            f36948a.append(androidx.constraintlayout.widget.e.f9141l4, 7);
            f36948a.append(androidx.constraintlayout.widget.e.f9170o4, 8);
            f36948a.append(androidx.constraintlayout.widget.e.f8985V3, 9);
            f36948a.append(androidx.constraintlayout.widget.e.f9071e4, 10);
            f36948a.append(androidx.constraintlayout.widget.e.f9031a4, 11);
            f36948a.append(androidx.constraintlayout.widget.e.f9041b4, 12);
            f36948a.append(androidx.constraintlayout.widget.e.f9051c4, 13);
            f36948a.append(androidx.constraintlayout.widget.e.f9131k4, 14);
            f36948a.append(androidx.constraintlayout.widget.e.f9012Y3, 15);
            f36948a.append(androidx.constraintlayout.widget.e.f9021Z3, 16);
            f36948a.append(androidx.constraintlayout.widget.e.f8994W3, 17);
            f36948a.append(androidx.constraintlayout.widget.e.f9003X3, 18);
            f36948a.append(androidx.constraintlayout.widget.e.f9061d4, 19);
            f36948a.append(androidx.constraintlayout.widget.e.f9101h4, 20);
        }

        public static void b(f fVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f36948a.get(index)) {
                    case 1:
                        if (MotionLayout.f8010v0) {
                            int resourceId = typedArray.getResourceId(index, fVar.f36907b);
                            fVar.f36907b = resourceId;
                            if (resourceId == -1) {
                                fVar.f36908c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            fVar.f36908c = typedArray.getString(index);
                            break;
                        } else {
                            fVar.f36907b = typedArray.getResourceId(index, fVar.f36907b);
                            break;
                        }
                    case 2:
                        fVar.f36906a = typedArray.getInt(index, fVar.f36906a);
                        break;
                    case 3:
                        fVar.f36930g = typedArray.getString(index);
                        break;
                    case 4:
                        fVar.f36931h = typedArray.getInteger(index, fVar.f36931h);
                        break;
                    case 5:
                        fVar.f36932i = typedArray.getInt(index, fVar.f36932i);
                        break;
                    case 6:
                        fVar.f36933j = typedArray.getFloat(index, fVar.f36933j);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            fVar.f36934k = typedArray.getDimension(index, fVar.f36934k);
                            break;
                        } else {
                            fVar.f36934k = typedArray.getFloat(index, fVar.f36934k);
                            break;
                        }
                    case 8:
                        fVar.f36936m = typedArray.getInt(index, fVar.f36936m);
                        break;
                    case 9:
                        fVar.f36937n = typedArray.getFloat(index, fVar.f36937n);
                        break;
                    case 10:
                        fVar.f36938o = typedArray.getDimension(index, fVar.f36938o);
                        break;
                    case 11:
                        fVar.f36939p = typedArray.getFloat(index, fVar.f36939p);
                        break;
                    case 12:
                        fVar.f36941r = typedArray.getFloat(index, fVar.f36941r);
                        break;
                    case 13:
                        fVar.f36942s = typedArray.getFloat(index, fVar.f36942s);
                        break;
                    case 14:
                        fVar.f36940q = typedArray.getFloat(index, fVar.f36940q);
                        break;
                    case 15:
                        fVar.f36943t = typedArray.getFloat(index, fVar.f36943t);
                        break;
                    case 16:
                        fVar.f36944u = typedArray.getFloat(index, fVar.f36944u);
                        break;
                    case 17:
                        fVar.f36945v = typedArray.getDimension(index, fVar.f36945v);
                        break;
                    case 18:
                        fVar.f36946w = typedArray.getDimension(index, fVar.f36946w);
                        break;
                    case 19:
                        fVar.f36947x = typedArray.getDimension(index, fVar.f36947x);
                        break;
                    case 20:
                        fVar.f36935l = typedArray.getFloat(index, fVar.f36935l);
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f36948a.get(index));
                        break;
                }
            }
        }
    }

    public f() {
        this.f36909d = 4;
        this.f36910e = new HashMap<>();
    }

    public void O(HashMap<String, g> hashMap) {
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.f36910e.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.c() == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    hashMap.get(str).e(this.f36906a, this.f36932i, this.f36936m, this.f36933j, this.f36934k, constraintAttribute.d(), constraintAttribute);
                }
            } else {
                float P10 = P(str);
                if (!Float.isNaN(P10)) {
                    hashMap.get(str).d(this.f36906a, this.f36932i, this.f36936m, this.f36933j, this.f36934k, P10);
                }
            }
        }
    }

    public float P(String str) {
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    c10 = '\f';
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return this.f36941r;
            case 1:
                return this.f36942s;
            case 2:
                return this.f36945v;
            case 3:
                return this.f36946w;
            case 4:
                return this.f36947x;
            case 5:
                return this.f36935l;
            case 6:
                return this.f36943t;
            case 7:
                return this.f36944u;
            case '\b':
                return this.f36939p;
            case '\t':
                return this.f36938o;
            case '\n':
                return this.f36940q;
            case 11:
                return this.f36937n;
            case '\f':
                return this.f36934k;
            default:
                Log.v("KeyCycle", "WARNING! KeyCycle UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0042. Please report as an issue. */
    @Override // t.AbstractC1575c
    public void a(HashMap<String, q> hashMap) {
        C1573a.e("KeyCycle", "add " + hashMap.size() + " values", 2);
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
                case 156108012:
                    if (str.equals("waveOffset")) {
                        c10 = '\f';
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    qVar.e(this.f36906a, this.f36941r);
                    break;
                case 1:
                    qVar.e(this.f36906a, this.f36942s);
                    break;
                case 2:
                    qVar.e(this.f36906a, this.f36945v);
                    break;
                case 3:
                    qVar.e(this.f36906a, this.f36946w);
                    break;
                case 4:
                    qVar.e(this.f36906a, this.f36947x);
                    break;
                case 5:
                    qVar.e(this.f36906a, this.f36935l);
                    break;
                case 6:
                    qVar.e(this.f36906a, this.f36943t);
                    break;
                case 7:
                    qVar.e(this.f36906a, this.f36944u);
                    break;
                case '\b':
                    qVar.e(this.f36906a, this.f36939p);
                    break;
                case '\t':
                    qVar.e(this.f36906a, this.f36938o);
                    break;
                case '\n':
                    qVar.e(this.f36906a, this.f36940q);
                    break;
                case 11:
                    qVar.e(this.f36906a, this.f36937n);
                    break;
                case '\f':
                    qVar.e(this.f36906a, this.f36934k);
                    break;
                default:
                    Log.v("KeyCycle", "WARNING KeyCycle UNKNOWN  " + str);
                    break;
            }
        }
    }

    @Override // t.AbstractC1575c
    public void b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f36937n)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f36938o)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f36939p)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f36941r)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f36942s)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f36943t)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f36944u)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f36940q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f36945v)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f36946w)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f36947x)) {
            hashSet.add("translationZ");
        }
        if (this.f36910e.size() > 0) {
            Iterator<String> it = this.f36910e.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // t.AbstractC1575c
    public void c(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f8976U3));
    }
}
