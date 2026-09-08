package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: KeyTrigger.java */
/* loaded from: classes.dex */
public class l extends AbstractC1575c {

    /* renamed from: g, reason: collision with root package name */
    public int f37010g = -1;

    /* renamed from: h, reason: collision with root package name */
    public String f37011h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f37012i;

    /* renamed from: j, reason: collision with root package name */
    public String f37013j;

    /* renamed from: k, reason: collision with root package name */
    public String f37014k;

    /* renamed from: l, reason: collision with root package name */
    public int f37015l;

    /* renamed from: m, reason: collision with root package name */
    public int f37016m;

    /* renamed from: n, reason: collision with root package name */
    public View f37017n;

    /* renamed from: o, reason: collision with root package name */
    public float f37018o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f37019p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f37020q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f37021r;

    /* renamed from: s, reason: collision with root package name */
    public float f37022s;

    /* renamed from: t, reason: collision with root package name */
    public Method f37023t;

    /* renamed from: u, reason: collision with root package name */
    public Method f37024u;

    /* renamed from: v, reason: collision with root package name */
    public Method f37025v;

    /* renamed from: w, reason: collision with root package name */
    public float f37026w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f37027x;

    /* renamed from: y, reason: collision with root package name */
    public RectF f37028y;

    /* renamed from: z, reason: collision with root package name */
    public RectF f37029z;

    /* compiled from: KeyTrigger.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static SparseIntArray f37030a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f37030a = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.e.f9004X4, 8);
            f37030a.append(androidx.constraintlayout.widget.e.f9042b5, 4);
            f37030a.append(androidx.constraintlayout.widget.e.f9052c5, 1);
            f37030a.append(androidx.constraintlayout.widget.e.f9062d5, 2);
            f37030a.append(androidx.constraintlayout.widget.e.f9013Y4, 7);
            f37030a.append(androidx.constraintlayout.widget.e.f9072e5, 6);
            f37030a.append(androidx.constraintlayout.widget.e.f9092g5, 5);
            f37030a.append(androidx.constraintlayout.widget.e.f9032a5, 9);
            f37030a.append(androidx.constraintlayout.widget.e.f9022Z4, 10);
            f37030a.append(androidx.constraintlayout.widget.e.f9082f5, 11);
        }

        public static void a(l lVar, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArray.getIndex(i10);
                switch (f37030a.get(index)) {
                    case 1:
                        lVar.f37013j = typedArray.getString(index);
                        continue;
                    case 2:
                        lVar.f37014k = typedArray.getString(index);
                        continue;
                    case 4:
                        lVar.f37011h = typedArray.getString(index);
                        continue;
                    case 5:
                        lVar.f37018o = typedArray.getFloat(index, lVar.f37018o);
                        continue;
                    case 6:
                        lVar.f37015l = typedArray.getResourceId(index, lVar.f37015l);
                        continue;
                    case 7:
                        if (MotionLayout.f8010v0) {
                            int resourceId = typedArray.getResourceId(index, lVar.f36907b);
                            lVar.f36907b = resourceId;
                            if (resourceId == -1) {
                                lVar.f36908c = typedArray.getString(index);
                                break;
                            } else {
                                continue;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            lVar.f36908c = typedArray.getString(index);
                            break;
                        } else {
                            lVar.f36907b = typedArray.getResourceId(index, lVar.f36907b);
                            break;
                        }
                    case 8:
                        int integer = typedArray.getInteger(index, lVar.f36906a);
                        lVar.f36906a = integer;
                        lVar.f37022s = (integer + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        lVar.f37016m = typedArray.getResourceId(index, lVar.f37016m);
                        continue;
                    case 10:
                        lVar.f37027x = typedArray.getBoolean(index, lVar.f37027x);
                        continue;
                    case 11:
                        lVar.f37012i = typedArray.getResourceId(index, lVar.f37012i);
                        break;
                }
                Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f37030a.get(index));
            }
        }
    }

    public l() {
        int i10 = AbstractC1575c.f36905f;
        this.f37012i = i10;
        this.f37013j = null;
        this.f37014k = null;
        this.f37015l = i10;
        this.f37016m = i10;
        this.f37017n = null;
        this.f37018o = 0.1f;
        this.f37019p = true;
        this.f37020q = true;
        this.f37021r = true;
        this.f37022s = Float.NaN;
        this.f37027x = false;
        this.f37028y = new RectF();
        this.f37029z = new RectF();
        this.f36909d = 5;
        this.f36910e = new HashMap<>();
    }

    @Override // t.AbstractC1575c
    public void c(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f8995W4), context);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(float r11, android.view.View r12) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t.l.r(float, android.view.View):void");
    }

    public final void s(RectF rectF, View view, boolean z10) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z10) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // t.AbstractC1575c
    public void a(HashMap<String, q> hashMap) {
    }

    @Override // t.AbstractC1575c
    public void b(HashSet<String> hashSet) {
    }
}
