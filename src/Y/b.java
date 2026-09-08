package Y;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p.C1415a;

/* compiled from: Palette.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final c f5487f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List<d> f5488a;

    /* renamed from: b, reason: collision with root package name */
    public final List<Y.c> f5489b;

    /* renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f5491d = new SparseBooleanArray();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Y.c, d> f5490c = new C1415a();

    /* renamed from: e, reason: collision with root package name */
    public final d f5492e = a();

    /* compiled from: Palette.java */
    /* loaded from: classes.dex */
    public static class a implements c {
        @Override // Y.b.c
        public boolean a(int i10, float[] fArr) {
            if (!d(fArr) && !b(fArr) && !c(fArr)) {
                return true;
            }
            return false;
        }

        public final boolean b(float[] fArr) {
            if (fArr[2] <= 0.05f) {
                return true;
            }
            return false;
        }

        public final boolean c(float[] fArr) {
            float f10 = fArr[0];
            if (f10 < 10.0f || f10 > 37.0f || fArr[1] > 0.82f) {
                return false;
            }
            return true;
        }

        public final boolean d(float[] fArr) {
            if (fArr[2] >= 0.95f) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: Palette.java */
    /* renamed from: Y.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0085b {

        /* renamed from: a, reason: collision with root package name */
        public final List<d> f5493a;

        /* renamed from: b, reason: collision with root package name */
        public final Bitmap f5494b;

        /* renamed from: c, reason: collision with root package name */
        public final List<Y.c> f5495c;

        /* renamed from: d, reason: collision with root package name */
        public int f5496d;

        /* renamed from: e, reason: collision with root package name */
        public int f5497e;

        /* renamed from: f, reason: collision with root package name */
        public int f5498f;

        /* renamed from: g, reason: collision with root package name */
        public final List<c> f5499g;

        /* renamed from: h, reason: collision with root package name */
        public Rect f5500h;

        public C0085b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f5495c = arrayList;
            this.f5496d = 16;
            this.f5497e = 12544;
            this.f5498f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f5499g = arrayList2;
            if (bitmap != null && !bitmap.isRecycled()) {
                arrayList2.add(b.f5487f);
                this.f5494b = bitmap;
                this.f5493a = null;
                arrayList.add(Y.c.f5510e);
                arrayList.add(Y.c.f5511f);
                arrayList.add(Y.c.f5512g);
                arrayList.add(Y.c.f5513h);
                arrayList.add(Y.c.f5514i);
                arrayList.add(Y.c.f5515j);
                return;
            }
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        public b a() {
            List<d> list;
            c[] cVarArr;
            Bitmap bitmap = this.f5494b;
            if (bitmap != null) {
                Bitmap e10 = e(bitmap);
                Rect rect = this.f5500h;
                if (e10 != this.f5494b && rect != null) {
                    double width = e10.getWidth() / this.f5494b.getWidth();
                    rect.left = (int) Math.floor(rect.left * width);
                    rect.top = (int) Math.floor(rect.top * width);
                    rect.right = Math.min((int) Math.ceil(rect.right * width), e10.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(rect.bottom * width), e10.getHeight());
                }
                int[] b10 = b(e10);
                int i10 = this.f5496d;
                if (this.f5499g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List<c> list2 = this.f5499g;
                    cVarArr = (c[]) list2.toArray(new c[list2.size()]);
                }
                Y.a aVar = new Y.a(b10, i10, cVarArr);
                if (e10 != this.f5494b) {
                    e10.recycle();
                }
                list = aVar.d();
            } else {
                list = this.f5493a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            b bVar = new b(list, this.f5495c);
            bVar.c();
            return bVar;
        }

        public final int[] b(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f5500h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f5500h.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i10 = 0; i10 < height2; i10++) {
                Rect rect2 = this.f5500h;
                System.arraycopy(iArr, ((rect2.top + i10) * width) + rect2.left, iArr2, i10 * width2, width2);
            }
            return iArr2;
        }

        public C0085b c(int i10) {
            this.f5496d = i10;
            return this;
        }

        public C0085b d(int i10) {
            this.f5497e = i10;
            this.f5498f = -1;
            return this;
        }

        public final Bitmap e(Bitmap bitmap) {
            int max;
            int i10;
            double d10 = -1.0d;
            if (this.f5497e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i11 = this.f5497e;
                if (width > i11) {
                    d10 = Math.sqrt(i11 / width);
                }
            } else if (this.f5498f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i10 = this.f5498f)) {
                d10 = i10 / max;
            }
            if (d10 <= 0.0d) {
                return bitmap;
            }
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * d10), (int) Math.ceil(bitmap.getHeight() * d10), false);
        }
    }

    /* compiled from: Palette.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a(int i10, float[] fArr);
    }

    /* compiled from: Palette.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f5501a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5502b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5503c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5504d;

        /* renamed from: e, reason: collision with root package name */
        public final int f5505e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f5506f;

        /* renamed from: g, reason: collision with root package name */
        public int f5507g;

        /* renamed from: h, reason: collision with root package name */
        public int f5508h;

        /* renamed from: i, reason: collision with root package name */
        public float[] f5509i;

        public d(int i10, int i11) {
            this.f5501a = Color.red(i10);
            this.f5502b = Color.green(i10);
            this.f5503c = Color.blue(i10);
            this.f5504d = i10;
            this.f5505e = i11;
        }

        public final void a() {
            int w10;
            int w11;
            if (!this.f5506f) {
                int l10 = B.a.l(-1, this.f5504d, 4.5f);
                int l11 = B.a.l(-1, this.f5504d, 3.0f);
                if (l10 != -1 && l11 != -1) {
                    this.f5508h = B.a.w(-1, l10);
                    this.f5507g = B.a.w(-1, l11);
                    this.f5506f = true;
                    return;
                }
                int l12 = B.a.l(-16777216, this.f5504d, 4.5f);
                int l13 = B.a.l(-16777216, this.f5504d, 3.0f);
                if (l12 != -1 && l13 != -1) {
                    this.f5508h = B.a.w(-16777216, l12);
                    this.f5507g = B.a.w(-16777216, l13);
                    this.f5506f = true;
                    return;
                }
                if (l10 != -1) {
                    w10 = B.a.w(-1, l10);
                } else {
                    w10 = B.a.w(-16777216, l12);
                }
                this.f5508h = w10;
                if (l11 != -1) {
                    w11 = B.a.w(-1, l11);
                } else {
                    w11 = B.a.w(-16777216, l13);
                }
                this.f5507g = w11;
                this.f5506f = true;
            }
        }

        public int b() {
            a();
            return this.f5508h;
        }

        public float[] c() {
            if (this.f5509i == null) {
                this.f5509i = new float[3];
            }
            B.a.d(this.f5501a, this.f5502b, this.f5503c, this.f5509i);
            return this.f5509i;
        }

        public int d() {
            return this.f5505e;
        }

        public int e() {
            return this.f5504d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f5505e == dVar.f5505e && this.f5504d == dVar.f5504d) {
                return true;
            }
            return false;
        }

        public int f() {
            a();
            return this.f5507g;
        }

        public int hashCode() {
            return (this.f5504d * 31) + this.f5505e;
        }

        public String toString() {
            return d.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.f5505e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    public b(List<d> list, List<Y.c> list2) {
        this.f5488a = list;
        this.f5489b = list2;
    }

    public static C0085b b(Bitmap bitmap) {
        return new C0085b(bitmap);
    }

    public final d a() {
        int size = this.f5488a.size();
        int i10 = Integer.MIN_VALUE;
        d dVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            d dVar2 = this.f5488a.get(i11);
            if (dVar2.d() > i10) {
                i10 = dVar2.d();
                dVar = dVar2;
            }
        }
        return dVar;
    }

    public void c() {
        int size = this.f5489b.size();
        for (int i10 = 0; i10 < size; i10++) {
            Y.c cVar = this.f5489b.get(i10);
            cVar.k();
            this.f5490c.put(cVar, e(cVar));
        }
        this.f5491d.clear();
    }

    public final float d(d dVar, Y.c cVar) {
        int i10;
        float f10;
        float f11;
        float[] c10 = dVar.c();
        d dVar2 = this.f5492e;
        if (dVar2 != null) {
            i10 = dVar2.d();
        } else {
            i10 = 1;
        }
        float f12 = 0.0f;
        if (cVar.g() > 0.0f) {
            f10 = cVar.g() * (1.0f - Math.abs(c10[1] - cVar.i()));
        } else {
            f10 = 0.0f;
        }
        if (cVar.a() > 0.0f) {
            f11 = cVar.a() * (1.0f - Math.abs(c10[2] - cVar.h()));
        } else {
            f11 = 0.0f;
        }
        if (cVar.f() > 0.0f) {
            f12 = cVar.f() * (dVar.d() / i10);
        }
        return f10 + f11 + f12;
    }

    public final d e(Y.c cVar) {
        d f10 = f(cVar);
        if (f10 != null && cVar.j()) {
            this.f5491d.append(f10.e(), true);
        }
        return f10;
    }

    public final d f(Y.c cVar) {
        int size = this.f5488a.size();
        float f10 = 0.0f;
        d dVar = null;
        for (int i10 = 0; i10 < size; i10++) {
            d dVar2 = this.f5488a.get(i10);
            if (h(dVar2, cVar)) {
                float d10 = d(dVar2, cVar);
                if (dVar == null || d10 > f10) {
                    dVar = dVar2;
                    f10 = d10;
                }
            }
        }
        return dVar;
    }

    public List<d> g() {
        return Collections.unmodifiableList(this.f5488a);
    }

    public final boolean h(d dVar, Y.c cVar) {
        float[] c10 = dVar.c();
        if (c10[1] >= cVar.e() && c10[1] <= cVar.c() && c10[2] >= cVar.d() && c10[2] <= cVar.b() && !this.f5491d.get(dVar.e())) {
            return true;
        }
        return false;
    }
}
