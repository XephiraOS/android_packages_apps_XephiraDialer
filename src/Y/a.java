package Y;

import Y.b;
import android.graphics.Color;
import android.util.TimingLogger;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* compiled from: ColorCutQuantizer.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final Comparator<b> f5470g = new C0084a();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f5471a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f5472b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b.d> f5473c;

    /* renamed from: e, reason: collision with root package name */
    public final b.c[] f5475e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f5476f = new float[3];

    /* renamed from: d, reason: collision with root package name */
    public final TimingLogger f5474d = null;

    /* compiled from: ColorCutQuantizer.java */
    /* renamed from: Y.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0084a implements Comparator<b> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    /* compiled from: ColorCutQuantizer.java */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f5477a;

        /* renamed from: b, reason: collision with root package name */
        public int f5478b;

        /* renamed from: c, reason: collision with root package name */
        public int f5479c;

        /* renamed from: d, reason: collision with root package name */
        public int f5480d;

        /* renamed from: e, reason: collision with root package name */
        public int f5481e;

        /* renamed from: f, reason: collision with root package name */
        public int f5482f;

        /* renamed from: g, reason: collision with root package name */
        public int f5483g;

        /* renamed from: h, reason: collision with root package name */
        public int f5484h;

        /* renamed from: i, reason: collision with root package name */
        public int f5485i;

        public b(int i10, int i11) {
            this.f5477a = i10;
            this.f5478b = i11;
            c();
        }

        public final boolean a() {
            if (e() > 1) {
                return true;
            }
            return false;
        }

        public final int b() {
            int f10 = f();
            a aVar = a.this;
            int[] iArr = aVar.f5471a;
            int[] iArr2 = aVar.f5472b;
            a.e(iArr, f10, this.f5477a, this.f5478b);
            Arrays.sort(iArr, this.f5477a, this.f5478b + 1);
            a.e(iArr, f10, this.f5477a, this.f5478b);
            int i10 = this.f5479c / 2;
            int i11 = this.f5477a;
            int i12 = 0;
            while (true) {
                int i13 = this.f5478b;
                if (i11 <= i13) {
                    i12 += iArr2[iArr[i11]];
                    if (i12 >= i10) {
                        return Math.min(i13 - 1, i11);
                    }
                    i11++;
                } else {
                    return this.f5477a;
                }
            }
        }

        public final void c() {
            a aVar = a.this;
            int[] iArr = aVar.f5471a;
            int[] iArr2 = aVar.f5472b;
            int i10 = Integer.MAX_VALUE;
            int i11 = Integer.MIN_VALUE;
            int i12 = Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE;
            int i14 = 0;
            int i15 = Integer.MAX_VALUE;
            int i16 = Integer.MAX_VALUE;
            for (int i17 = this.f5477a; i17 <= this.f5478b; i17++) {
                int i18 = iArr[i17];
                i14 += iArr2[i18];
                int k10 = a.k(i18);
                int j10 = a.j(i18);
                int i19 = a.i(i18);
                if (k10 > i11) {
                    i11 = k10;
                }
                if (k10 < i10) {
                    i10 = k10;
                }
                if (j10 > i12) {
                    i12 = j10;
                }
                if (j10 < i15) {
                    i15 = j10;
                }
                if (i19 > i13) {
                    i13 = i19;
                }
                if (i19 < i16) {
                    i16 = i19;
                }
            }
            this.f5480d = i10;
            this.f5481e = i11;
            this.f5482f = i15;
            this.f5483g = i12;
            this.f5484h = i16;
            this.f5485i = i13;
            this.f5479c = i14;
        }

        public final b.d d() {
            a aVar = a.this;
            int[] iArr = aVar.f5471a;
            int[] iArr2 = aVar.f5472b;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = this.f5477a; i14 <= this.f5478b; i14++) {
                int i15 = iArr[i14];
                int i16 = iArr2[i15];
                i11 += i16;
                i10 += a.k(i15) * i16;
                i12 += a.j(i15) * i16;
                i13 += i16 * a.i(i15);
            }
            float f10 = i11;
            return new b.d(a.b(Math.round(i10 / f10), Math.round(i12 / f10), Math.round(i13 / f10)), i11);
        }

        public final int e() {
            return (this.f5478b + 1) - this.f5477a;
        }

        public final int f() {
            int i10 = this.f5481e - this.f5480d;
            int i11 = this.f5483g - this.f5482f;
            int i12 = this.f5485i - this.f5484h;
            if (i10 >= i11 && i10 >= i12) {
                return -3;
            }
            if (i11 >= i10 && i11 >= i12) {
                return -2;
            }
            return -1;
        }

        public final int g() {
            return ((this.f5481e - this.f5480d) + 1) * ((this.f5483g - this.f5482f) + 1) * ((this.f5485i - this.f5484h) + 1);
        }

        public final b h() {
            if (a()) {
                int b10 = b();
                b bVar = new b(b10 + 1, this.f5478b);
                this.f5478b = b10;
                c();
                return bVar;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }
    }

    public a(int[] iArr, int i10, b.c[] cVarArr) {
        this.f5475e = cVarArr;
        int[] iArr2 = new int[FastPairConstants.PAIR_TYPE_BLE_IN_PAIR];
        this.f5472b = iArr2;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            int g10 = g(iArr[i11]);
            iArr[i11] = g10;
            iArr2[g10] = iArr2[g10] + 1;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < 32768; i13++) {
            if (iArr2[i13] > 0 && l(i13)) {
                iArr2[i13] = 0;
            }
            if (iArr2[i13] > 0) {
                i12++;
            }
        }
        int[] iArr3 = new int[i12];
        this.f5471a = iArr3;
        int i14 = 0;
        for (int i15 = 0; i15 < 32768; i15++) {
            if (iArr2[i15] > 0) {
                iArr3[i14] = i15;
                i14++;
            }
        }
        if (i12 <= i10) {
            this.f5473c = new ArrayList();
            for (int i16 = 0; i16 < i12; i16++) {
                int i17 = iArr3[i16];
                this.f5473c.add(new b.d(a(i17), iArr2[i17]));
            }
            return;
        }
        this.f5473c = h(i10);
    }

    public static int a(int i10) {
        return b(k(i10), j(i10), i(i10));
    }

    public static int b(int i10, int i11, int i12) {
        return Color.rgb(f(i10, 5, 8), f(i11, 5, 8), f(i12, 5, 8));
    }

    public static void e(int[] iArr, int i10, int i11, int i12) {
        if (i10 != -2) {
            if (i10 == -1) {
                while (i11 <= i12) {
                    int i13 = iArr[i11];
                    iArr[i11] = k(i13) | (i(i13) << 10) | (j(i13) << 5);
                    i11++;
                }
                return;
            }
            return;
        }
        while (i11 <= i12) {
            int i14 = iArr[i11];
            iArr[i11] = i(i14) | (j(i14) << 10) | (k(i14) << 5);
            i11++;
        }
    }

    public static int f(int i10, int i11, int i12) {
        int i13;
        if (i12 > i11) {
            i13 = i10 << (i12 - i11);
        } else {
            i13 = i10 >> (i11 - i12);
        }
        return i13 & ((1 << i12) - 1);
    }

    public static int g(int i10) {
        return f(Color.blue(i10), 8, 5) | (f(Color.red(i10), 8, 5) << 10) | (f(Color.green(i10), 8, 5) << 5);
    }

    public static int i(int i10) {
        return i10 & 31;
    }

    public static int j(int i10) {
        return (i10 >> 5) & 31;
    }

    public static int k(int i10) {
        return (i10 >> 10) & 31;
    }

    public final List<b.d> c(Collection<b> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<b> it = collection.iterator();
        while (it.hasNext()) {
            b.d d10 = it.next().d();
            if (!n(d10)) {
                arrayList.add(d10);
            }
        }
        return arrayList;
    }

    public List<b.d> d() {
        return this.f5473c;
    }

    public final List<b.d> h(int i10) {
        PriorityQueue<b> priorityQueue = new PriorityQueue<>(i10, f5470g);
        priorityQueue.offer(new b(0, this.f5471a.length - 1));
        o(priorityQueue, i10);
        return c(priorityQueue);
    }

    public final boolean l(int i10) {
        int a10 = a(i10);
        B.a.m(a10, this.f5476f);
        return m(a10, this.f5476f);
    }

    public final boolean m(int i10, float[] fArr) {
        b.c[] cVarArr = this.f5475e;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                if (!this.f5475e[i11].a(i10, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean n(b.d dVar) {
        return m(dVar.e(), dVar.c());
    }

    public final void o(PriorityQueue<b> priorityQueue, int i10) {
        b poll;
        while (priorityQueue.size() < i10 && (poll = priorityQueue.poll()) != null && poll.a()) {
            priorityQueue.offer(poll.h());
            priorityQueue.offer(poll);
        }
    }
}
