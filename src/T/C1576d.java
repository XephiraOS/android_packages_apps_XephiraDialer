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

/* compiled from: KeyAttributes.java */
/* renamed from: t.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1576d extends AbstractC1575c {

    /* renamed from: g, reason: collision with root package name */
    public String f36911g;

    /* renamed from: h, reason: collision with root package name */
    public int f36912h = -1;

    /* renamed from: i, reason: collision with root package name */
    public boolean f36913i = false;

    /* renamed from: j, reason: collision with root package name */
    public float f36914j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f36915k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f36916l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f36917m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f36918n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public float f36919o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f36920p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public float f36921q = Float.NaN;

    /* renamed from: r, reason: collision with root package name */
    public float f36922r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f36923s = Float.NaN;

    /* renamed from: t, reason: collision with root package name */
    public float f36924t = Float.NaN;

    /* renamed from: u, reason: collision with root package name */
    public float f36925u = Float.NaN;

    /* renamed from: v, reason: collision with root package name */
    public float f36926v = Float.NaN;

    /* renamed from: w, reason: collision with root package name */
    public float f36927w = Float.NaN;

    /* compiled from: KeyAttributes.java */
    /* renamed from: t.d$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f36928a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f36928a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.e.f8814C3, 1);
            f36928a.append(androidx.constraintlayout.widget.e.f8913N3, 2);
            f36928a.append(androidx.constraintlayout.widget.e.f8877J3, 4);
            f36928a.append(androidx.constraintlayout.widget.e.f8886K3, 5);
            f36928a.append(androidx.constraintlayout.widget.e.f8895L3, 6);
            f36928a.append(androidx.constraintlayout.widget.e.f8823D3, 19);
            f36928a.append(androidx.constraintlayout.widget.e.f8832E3, 20);
            f36928a.append(androidx.constraintlayout.widget.e.f8859H3, 7);
            f36928a.append(androidx.constraintlayout.widget.e.f8967T3, 8);
            f36928a.append(androidx.constraintlayout.widget.e.f8958S3, 9);
            f36928a.append(androidx.constraintlayout.widget.e.f8949R3, 10);
            f36928a.append(androidx.constraintlayout.widget.e.f8931P3, 12);
            f36928a.append(androidx.constraintlayout.widget.e.f8922O3, 13);
            f36928a.append(androidx.constraintlayout.widget.e.f8868I3, 14);
            f36928a.append(androidx.constraintlayout.widget.e.f8841F3, 15);
            f36928a.append(androidx.constraintlayout.widget.e.f8850G3, 16);
            f36928a.append(androidx.constraintlayout.widget.e.f8904M3, 17);
            f36928a.append(androidx.constraintlayout.widget.e.f8940Q3, 18);
        }

        public static void a(C1576d c1576d, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f36928a.get(index)) {
                    case 1:
                        c1576d.f36914j = typedArray.getFloat(index, c1576d.f36914j);
                        break;
                    case 2:
                        c1576d.f36915k = typedArray.getDimension(index, c1576d.f36915k);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f36928a.get(index));
                        break;
                    case 4:
                        c1576d.f36916l = typedArray.getFloat(index, c1576d.f36916l);
                        break;
                    case 5:
                        c1576d.f36917m = typedArray.getFloat(index, c1576d.f36917m);
                        break;
                    case 6:
                        c1576d.f36918n = typedArray.getFloat(index, c1576d.f36918n);
                        break;
                    case 7:
                        c1576d.f36922r = typedArray.getFloat(index, c1576d.f36922r);
                        break;
                    case 8:
                        c1576d.f36921q = typedArray.getFloat(index, c1576d.f36921q);
                        break;
                    case 9:
                        c1576d.f36911g = typedArray.getString(index);
                        break;
                    case 10:
                        if (MotionLayout.f8010v0) {
                            int resourceId = typedArray.getResourceId(index, c1576d.f36907b);
                            c1576d.f36907b = resourceId;
                            if (resourceId == -1) {
                                c1576d.f36908c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            c1576d.f36908c = typedArray.getString(index);
                            break;
                        } else {
                            c1576d.f36907b = typedArray.getResourceId(index, c1576d.f36907b);
                            break;
                        }
                    case 12:
                        c1576d.f36906a = typedArray.getInt(index, c1576d.f36906a);
                        break;
                    case 13:
                        c1576d.f36912h = typedArray.getInteger(index, c1576d.f36912h);
                        break;
                    case 14:
                        c1576d.f36923s = typedArray.getFloat(index, c1576d.f36923s);
                        break;
                    case 15:
                        c1576d.f36924t = typedArray.getDimension(index, c1576d.f36924t);
                        break;
                    case 16:
                        c1576d.f36925u = typedArray.getDimension(index, c1576d.f36925u);
                        break;
                    case 17:
                        c1576d.f36926v = typedArray.getDimension(index, c1576d.f36926v);
                        break;
                    case 18:
                        c1576d.f36927w = typedArray.getFloat(index, c1576d.f36927w);
                        break;
                    case 19:
                        c1576d.f36919o = typedArray.getDimension(index, c1576d.f36919o);
                        break;
                    case 20:
                        c1576d.f36920p = typedArray.getDimension(index, c1576d.f36920p);
                        break;
                }
            }
        }
    }

    public C1576d() {
        this.f36909d = 1;
        this.f36910e = new HashMap<>();
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x009a, code lost:
    
        if (r1.equals("scaleY") == false) goto L12;
     */
    @Override // t.AbstractC1575c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.util.HashMap<java.lang.String, t.q> r7) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.C1576d.a(java.util.HashMap):void");
    }

    @Override // t.AbstractC1575c
    public void b(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f36914j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f36915k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f36916l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f36917m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f36918n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f36919o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f36920p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f36924t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f36925u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f36926v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f36921q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f36922r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f36923s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f36927w)) {
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
        a.a(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f8805B3));
    }

    @Override // t.AbstractC1575c
    public void e(HashMap<String, Integer> hashMap) {
        if (this.f36912h == -1) {
            return;
        }
        if (!Float.isNaN(this.f36914j)) {
            hashMap.put("alpha", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36915k)) {
            hashMap.put("elevation", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36916l)) {
            hashMap.put("rotation", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36917m)) {
            hashMap.put("rotationX", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36918n)) {
            hashMap.put("rotationY", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36919o)) {
            hashMap.put("transformPivotX", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36920p)) {
            hashMap.put("transformPivotY", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36924t)) {
            hashMap.put("translationX", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36925u)) {
            hashMap.put("translationY", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36926v)) {
            hashMap.put("translationZ", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36921q)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36922r)) {
            hashMap.put("scaleX", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36923s)) {
            hashMap.put("scaleY", Integer.valueOf(this.f36912h));
        }
        if (!Float.isNaN(this.f36927w)) {
            hashMap.put("progress", Integer.valueOf(this.f36912h));
        }
        if (this.f36910e.size() > 0) {
            Iterator<String> it = this.f36910e.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put("CUSTOM," + it.next(), Integer.valueOf(this.f36912h));
            }
        }
    }
}
