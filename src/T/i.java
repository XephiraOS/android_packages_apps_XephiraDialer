package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/* compiled from: KeyPosition.java */
/* loaded from: classes.dex */
public class i extends j {

    /* renamed from: h, reason: collision with root package name */
    public String f36978h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f36979i = AbstractC1575c.f36905f;

    /* renamed from: j, reason: collision with root package name */
    public int f36980j = 0;

    /* renamed from: k, reason: collision with root package name */
    public float f36981k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f36982l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f36983m = Float.NaN;

    /* renamed from: n, reason: collision with root package name */
    public float f36984n = Float.NaN;

    /* renamed from: o, reason: collision with root package name */
    public float f36985o = Float.NaN;

    /* renamed from: p, reason: collision with root package name */
    public float f36986p = Float.NaN;

    /* renamed from: q, reason: collision with root package name */
    public int f36987q = 0;

    /* renamed from: r, reason: collision with root package name */
    public float f36988r = Float.NaN;

    /* renamed from: s, reason: collision with root package name */
    public float f36989s = Float.NaN;

    /* compiled from: KeyPosition.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f36990a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f36990a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.e.f9224u4, 1);
            f36990a.append(androidx.constraintlayout.widget.e.f9206s4, 2);
            f36990a.append(androidx.constraintlayout.widget.e.f8806B4, 3);
            f36990a.append(androidx.constraintlayout.widget.e.f9188q4, 4);
            f36990a.append(androidx.constraintlayout.widget.e.f9197r4, 5);
            f36990a.append(androidx.constraintlayout.widget.e.f9260y4, 6);
            f36990a.append(androidx.constraintlayout.widget.e.f9269z4, 7);
            f36990a.append(androidx.constraintlayout.widget.e.f9215t4, 9);
            f36990a.append(androidx.constraintlayout.widget.e.f8797A4, 8);
            f36990a.append(androidx.constraintlayout.widget.e.f9251x4, 11);
            f36990a.append(androidx.constraintlayout.widget.e.f9242w4, 12);
            f36990a.append(androidx.constraintlayout.widget.e.f9233v4, 10);
        }

        public static void b(i iVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f36990a.get(index)) {
                    case 1:
                        if (MotionLayout.f8010v0) {
                            int resourceId = typedArray.getResourceId(index, iVar.f36907b);
                            iVar.f36907b = resourceId;
                            if (resourceId == -1) {
                                iVar.f36908c = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            iVar.f36908c = typedArray.getString(index);
                            break;
                        } else {
                            iVar.f36907b = typedArray.getResourceId(index, iVar.f36907b);
                            break;
                        }
                    case 2:
                        iVar.f36906a = typedArray.getInt(index, iVar.f36906a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type == 3) {
                            iVar.f36978h = typedArray.getString(index);
                            break;
                        } else {
                            iVar.f36978h = s.c.f36582c[typedArray.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        iVar.f36991g = typedArray.getInteger(index, iVar.f36991g);
                        break;
                    case 5:
                        iVar.f36980j = typedArray.getInt(index, iVar.f36980j);
                        break;
                    case 6:
                        iVar.f36983m = typedArray.getFloat(index, iVar.f36983m);
                        break;
                    case 7:
                        iVar.f36984n = typedArray.getFloat(index, iVar.f36984n);
                        break;
                    case 8:
                        float f10 = typedArray.getFloat(index, iVar.f36982l);
                        iVar.f36981k = f10;
                        iVar.f36982l = f10;
                        break;
                    case 9:
                        iVar.f36987q = typedArray.getInt(index, iVar.f36987q);
                        break;
                    case 10:
                        iVar.f36979i = typedArray.getInt(index, iVar.f36979i);
                        break;
                    case 11:
                        iVar.f36981k = typedArray.getFloat(index, iVar.f36981k);
                        break;
                    case 12:
                        iVar.f36982l = typedArray.getFloat(index, iVar.f36982l);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f36990a.get(index));
                        break;
                }
            }
            if (iVar.f36906a == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public i() {
        this.f36909d = 2;
    }

    @Override // t.AbstractC1575c
    public void c(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f9179p4));
    }

    @Override // t.AbstractC1575c
    public void a(HashMap<String, q> hashMap) {
    }
}
