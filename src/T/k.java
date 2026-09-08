package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: KeyTimeCycle.java */
/* loaded from: classes.dex */
public class k extends AbstractC1575c {

    /* renamed from: g, reason: collision with root package name */
    public String f36992g;

    /* renamed from: h, reason: collision with root package name */
    public int f36993h = -1;

    /* renamed from: i, reason: collision with root package name */
    public float f36994i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f36995j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f36996k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f36997l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f36998m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f36999n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public float f37000o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f37001p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f37002q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    public float f37003r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f37004s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    public float f37005t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    public int f37006u = 0;

    /* renamed from: v, reason: collision with root package name */
    public float f37007v = Float.NaN;

    /* renamed from: w, reason: collision with root package name */
    public float f37008w = 0.0f;

    /* compiled from: KeyTimeCycle.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f37009a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f37009a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.e.f8824D4, 1);
            f37009a.append(androidx.constraintlayout.widget.e.f8905M4, 2);
            f37009a.append(androidx.constraintlayout.widget.e.f8869I4, 4);
            f37009a.append(androidx.constraintlayout.widget.e.f8878J4, 5);
            f37009a.append(androidx.constraintlayout.widget.e.f8887K4, 6);
            f37009a.append(androidx.constraintlayout.widget.e.f8851G4, 7);
            f37009a.append(androidx.constraintlayout.widget.e.f8959S4, 8);
            f37009a.append(androidx.constraintlayout.widget.e.f8950R4, 9);
            f37009a.append(androidx.constraintlayout.widget.e.f8941Q4, 10);
            f37009a.append(androidx.constraintlayout.widget.e.f8923O4, 12);
            f37009a.append(androidx.constraintlayout.widget.e.f8914N4, 13);
            f37009a.append(androidx.constraintlayout.widget.e.f8860H4, 14);
            f37009a.append(androidx.constraintlayout.widget.e.f8833E4, 15);
            f37009a.append(androidx.constraintlayout.widget.e.f8842F4, 16);
            f37009a.append(androidx.constraintlayout.widget.e.f8896L4, 17);
            f37009a.append(androidx.constraintlayout.widget.e.f8932P4, 18);
            f37009a.append(androidx.constraintlayout.widget.e.f8977U4, 20);
            f37009a.append(androidx.constraintlayout.widget.e.f8968T4, 21);
            f37009a.append(androidx.constraintlayout.widget.e.f8986V4, 19);
        }

        public static void a(k kVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f37009a.get(index)) {
                    case 1:
                        kVar.f36994i = typedArray.getFloat(index, kVar.f36994i);
                        break;
                    case 2:
                        kVar.f36995j = typedArray.getDimension(index, kVar.f36995j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f37009a.get(index));
                        break;
                    case 4:
                        kVar.f36996k = typedArray.getFloat(index, kVar.f36996k);
                        break;
                    case 5:
                        kVar.f36997l = typedArray.getFloat(index, kVar.f36997l);
                        break;
                    case 6:
                        kVar.f36998m = typedArray.getFloat(index, kVar.f36998m);
                        break;
                    case 7:
                        kVar.f37000o = typedArray.getFloat(index, kVar.f37000o);
                        break;
                    case 8:
                        kVar.f36999n = typedArray.getFloat(index, kVar.f36999n);
                        break;
                    case 9:
                        kVar.f36992g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.f8010v0) {
                            int resourceId = typedArray.getResourceId(index, kVar.f36907b);
                            kVar.f36907b = resourceId;
                            if (resourceId == -1) {
                                kVar.f36908c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            kVar.f36908c = typedArray.getString(index);
                            break;
                        } else {
                            kVar.f36907b = typedArray.getResourceId(index, kVar.f36907b);
                            break;
                        }
                    case 12:
                        kVar.f36906a = typedArray.getInt(index, kVar.f36906a);
                        break;
                    case 13:
                        kVar.f36993h = typedArray.getInteger(index, kVar.f36993h);
                        break;
                    case 14:
                        kVar.f37001p = typedArray.getFloat(index, kVar.f37001p);
                        break;
                    case 15:
                        kVar.f37002q = typedArray.getDimension(index, kVar.f37002q);
                        break;
                    case 16:
                        kVar.f37003r = typedArray.getDimension(index, kVar.f37003r);
                        break;
                    case 17:
                        kVar.f37004s = typedArray.getDimension(index, kVar.f37004s);
                        break;
                    case 18:
                        kVar.f37005t = typedArray.getFloat(index, kVar.f37005t);
                        break;
                    case 19:
                        kVar.f37006u = typedArray.getInt(index, kVar.f37006u);
                        break;
                    case 20:
                        kVar.f37007v = typedArray.getFloat(index, kVar.f37007v);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type == 5) {
                            kVar.f37008w = typedArray.getDimension(index, kVar.f37008w);
                            break;
                        } else {
                            kVar.f37008w = typedArray.getFloat(index, kVar.f37008w);
                            break;
                        }
                }
            }
        }
    }

    public k() {
        this.f36909d = 3;
        this.f36910e = new HashMap<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0087, code lost:
    
        if (r1.equals("scaleY") == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M(java.util.HashMap<java.lang.String, t.r> r11) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.k.M(java.util.HashMap):void");
    }

    @Override // t.AbstractC1575c
    public void a(HashMap<String, q> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // t.AbstractC1575c
    public void b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f36994i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f36995j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f36996k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f36997l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f36998m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f37002q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f37003r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f37004s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f36999n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f37000o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f37001p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f37005t)) {
            hashSet.add("progress");
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
        a.a(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f8815C4));
    }

    @Override // t.AbstractC1575c
    public void e(HashMap<String, Integer> hashMap) {
        if (this.f36993h == -1) {
            return;
        }
        if (!Float.isNaN(this.f36994i)) {
            hashMap.put("alpha", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f36995j)) {
            hashMap.put("elevation", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f36996k)) {
            hashMap.put("rotation", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f36997l)) {
            hashMap.put("rotationX", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f36998m)) {
            hashMap.put("rotationY", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f37002q)) {
            hashMap.put("translationX", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f37003r)) {
            hashMap.put("translationY", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f37004s)) {
            hashMap.put("translationZ", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f36999n)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f37000o)) {
            hashMap.put("scaleX", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f37000o)) {
            hashMap.put("scaleY", Integer.valueOf(this.f36993h));
        }
        if (!Float.isNaN(this.f37005t)) {
            hashMap.put("progress", Integer.valueOf(this.f36993h));
        }
        if (this.f36910e.size() > 0) {
            Iterator<String> it = this.f36910e.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.f36993h));
            }
        }
    }
}
