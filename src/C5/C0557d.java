package c5;

import P4.f;
import P4.g;
import a5.k;
import b5.AbstractC0525a;
import b5.C0526b;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import d5.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.opencv.imgproc.Imgproc;

/* compiled from: RSSExpandedReader.java */
/* renamed from: c5.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0557d extends AbstractC0525a {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f12787k = {7, 5, 4, 3, 1};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f12788l = {4, 20, 52, 104, 204};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f12789m = {0, 348, 1388, 2948, 3988};

    /* renamed from: n, reason: collision with root package name */
    public static final int[][] f12790n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    /* renamed from: o, reason: collision with root package name */
    public static final int[][] f12791o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, Imgproc.COLOR_COLORCVT_MAX, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, Imgproc.COLOR_BGR2YUV_YV12}, new int[]{185, Imgproc.COLOR_RGBA2YUV_YV12, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{Imgproc.COLOR_BGRA2YUV_YV12, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, VibrateUtils.TYPE_STEPABLE_EDGE, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, Imgproc.COLOR_RGB2YUV_YV12, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    /* renamed from: p, reason: collision with root package name */
    public static final int[][] f12792p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    /* renamed from: g, reason: collision with root package name */
    public final List<C0555b> f12793g = new ArrayList(11);

    /* renamed from: h, reason: collision with root package name */
    public final List<C0556c> f12794h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final int[] f12795i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    public boolean f12796j;

    public static boolean A(Iterable<C0555b> iterable, Iterable<C0556c> iterable2) {
        for (C0556c c0556c : iterable2) {
            for (C0555b c0555b : iterable) {
                Iterator<C0555b> it = c0556c.a().iterator();
                while (it.hasNext()) {
                    if (c0555b.equals(it.next())) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean B(List<C0555b> list) {
        for (int[] iArr : f12792p) {
            if (list.size() <= iArr.length) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    if (list.get(i10).a().c() != iArr[i10]) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void D(Collection<C0555b> collection, Collection<C0556c> collection2) {
        Iterator<C0556c> it = collection2.iterator();
        while (it.hasNext()) {
            C0556c next = it.next();
            if (next.a().size() != collection.size()) {
                Iterator<C0555b> it2 = next.a().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!collection.contains(it2.next())) {
                            break;
                        }
                    } else {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    public static void F(int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length / 2; i10++) {
            int i11 = iArr[i10];
            int i12 = (length - i10) - 1;
            iArr[i10] = iArr[i12];
            iArr[i12] = i11;
        }
    }

    public static f u(List<C0555b> list) {
        String d10 = j.a(C0554a.a(list)).d();
        g[] a10 = list.get(0).a().a();
        g[] a11 = list.get(list.size() - 1).a().a();
        return new f(d10, null, new g[]{a10[0], a10[1], a11[0], a11[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    public static int y(S4.a aVar, int i10) {
        if (aVar.g(i10)) {
            return aVar.i(aVar.j(i10));
        }
        return aVar.j(aVar.i(i10));
    }

    public static boolean z(b5.c cVar, boolean z10, boolean z11) {
        if (cVar.c() == 0 && z10 && z11) {
            return false;
        }
        return true;
    }

    public final b5.c C(S4.a aVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13;
        if (z10) {
            int i14 = this.f12795i[0] - 1;
            while (i14 >= 0 && !aVar.g(i14)) {
                i14--;
            }
            int i15 = i14 + 1;
            int[] iArr = this.f12795i;
            i13 = iArr[0] - i15;
            i11 = iArr[1];
            i12 = i15;
        } else {
            int[] iArr2 = this.f12795i;
            int i16 = iArr2[0];
            int j10 = aVar.j(iArr2[1] + 1);
            i11 = j10;
            i12 = i16;
            i13 = j10 - this.f12795i[1];
        }
        int[] i17 = i();
        System.arraycopy(i17, 0, i17, 1, i17.length - 1);
        i17[0] = i13;
        try {
            return new b5.c(AbstractC0525a.p(i17, f12790n), new int[]{i12, i11}, i12, i11, i10);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public C0555b E(S4.a aVar, List<C0555b> list, int i10) {
        boolean z10;
        b5.c C10;
        C0526b c0526b;
        if (list.size() % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f12796j) {
            z10 = !z10;
        }
        int i11 = -1;
        boolean z11 = true;
        do {
            x(aVar, list, i11);
            C10 = C(aVar, i10, z10);
            if (C10 == null) {
                i11 = y(aVar, this.f12795i[0]);
            } else {
                z11 = false;
            }
        } while (z11);
        C0526b v10 = v(aVar, C10, z10, true);
        if (!list.isEmpty() && list.get(list.size() - 1).d()) {
            throw NotFoundException.a();
        }
        try {
            c0526b = v(aVar, C10, z10, false);
        } catch (NotFoundException unused) {
            c0526b = null;
        }
        return new C0555b(v10, c0526b, C10);
    }

    public final void G(int i10, boolean z10) {
        int i11 = 0;
        boolean z11 = false;
        while (true) {
            if (i11 >= this.f12794h.size()) {
                break;
            }
            C0556c c0556c = this.f12794h.get(i11);
            if (c0556c.b() > i10) {
                if (c0556c.c(this.f12793g)) {
                    return;
                }
            } else {
                z11 = c0556c.c(this.f12793g);
                i11++;
            }
        }
        if (z11 || A(this.f12793g, this.f12794h)) {
            return;
        }
        this.f12794h.add(i11, new C0556c(this.f12793g, i10, z10));
        D(this.f12793g, this.f12794h);
    }

    @Override // a5.k
    public f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        this.f12793g.clear();
        this.f12796j = false;
        try {
            return u(w(i10, aVar));
        } catch (NotFoundException unused) {
            this.f12793g.clear();
            this.f12796j = true;
            return u(this.w(i10, aVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(int r11) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.C0557d.q(int):void");
    }

    public final boolean r() {
        C0555b c0555b = this.f12793g.get(0);
        C0526b b10 = c0555b.b();
        C0526b c10 = c0555b.c();
        if (c10 == null) {
            return false;
        }
        int a10 = c10.a();
        int i10 = 2;
        for (int i11 = 1; i11 < this.f12793g.size(); i11++) {
            C0555b c0555b2 = this.f12793g.get(i11);
            a10 += c0555b2.b().a();
            int i12 = i10 + 1;
            C0526b c11 = c0555b2.c();
            if (c11 != null) {
                a10 += c11.a();
                i10 += 2;
            } else {
                i10 = i12;
            }
        }
        if (((i10 - 4) * 211) + (a10 % 211) != b10.b()) {
            return false;
        }
        return true;
    }

    @Override // a5.k, P4.e
    public void reset() {
        this.f12793g.clear();
        this.f12794h.clear();
    }

    public final List<C0555b> s(List<C0556c> list, int i10) {
        while (i10 < this.f12794h.size()) {
            C0556c c0556c = this.f12794h.get(i10);
            this.f12793g.clear();
            Iterator<C0556c> it = list.iterator();
            while (it.hasNext()) {
                this.f12793g.addAll(it.next().a());
            }
            this.f12793g.addAll(c0556c.a());
            if (B(this.f12793g)) {
                if (this.r()) {
                    return this.f12793g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(c0556c);
                try {
                    return this.s(arrayList, i10 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i10++;
        }
        throw NotFoundException.a();
    }

    public final List<C0555b> t(boolean z10) {
        List<C0555b> list = null;
        if (this.f12794h.size() > 25) {
            this.f12794h.clear();
            return null;
        }
        this.f12793g.clear();
        if (z10) {
            Collections.reverse(this.f12794h);
        }
        try {
            list = s(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z10) {
            Collections.reverse(this.f12794h);
        }
        return list;
    }

    public C0526b v(S4.a aVar, b5.c cVar, boolean z10, boolean z11) {
        int i10;
        int[] h10 = h();
        for (int i11 = 0; i11 < h10.length; i11++) {
            h10[i11] = 0;
        }
        if (z11) {
            k.f(aVar, cVar.b()[0], h10);
        } else {
            k.e(aVar, cVar.b()[1], h10);
            int i12 = 0;
            for (int length = h10.length - 1; i12 < length; length--) {
                int i13 = h10[i12];
                h10[i12] = h10[length];
                h10[length] = i13;
                i12++;
            }
        }
        float d10 = T4.a.d(h10) / 17.0f;
        float f10 = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d10 - f10) / f10 <= 0.3f) {
            int[] l10 = l();
            int[] j10 = j();
            float[] m10 = m();
            float[] k10 = k();
            for (int i14 = 0; i14 < h10.length; i14++) {
                float f11 = (h10[i14] * 1.0f) / d10;
                int i15 = (int) (0.5f + f11);
                if (i15 <= 0) {
                    if (f11 >= 0.3f) {
                        i15 = 1;
                    } else {
                        throw NotFoundException.a();
                    }
                } else if (i15 > 8) {
                    if (f11 <= 8.7f) {
                        i15 = 8;
                    } else {
                        throw NotFoundException.a();
                    }
                }
                int i16 = i14 / 2;
                if ((i14 & 1) == 0) {
                    l10[i16] = i15;
                    m10[i16] = f11 - i15;
                } else {
                    j10[i16] = i15;
                    k10[i16] = f11 - i15;
                }
            }
            q(17);
            int c10 = cVar.c() * 4;
            if (z10) {
                i10 = 0;
            } else {
                i10 = 2;
            }
            int i17 = ((c10 + i10) + (!z11 ? 1 : 0)) - 1;
            int i18 = 0;
            int i19 = 0;
            for (int length2 = l10.length - 1; length2 >= 0; length2--) {
                if (z(cVar, z10, z11)) {
                    i18 += l10[length2] * f12791o[i17][length2 * 2];
                }
                i19 += l10[length2];
            }
            int i20 = 0;
            for (int length3 = j10.length - 1; length3 >= 0; length3--) {
                if (z(cVar, z10, z11)) {
                    i20 += j10[length3] * f12791o[i17][(length3 * 2) + 1];
                }
            }
            int i21 = i18 + i20;
            if ((i19 & 1) == 0 && i19 <= 13 && i19 >= 4) {
                int i22 = (13 - i19) / 2;
                int i23 = f12787k[i22];
                int i24 = 9 - i23;
                return new C0526b((b5.f.b(l10, i23, true) * f12788l[i22]) + b5.f.b(j10, i24, false) + f12789m[i22], i21);
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public List<C0555b> w(int i10, S4.a aVar) {
        boolean z10 = false;
        while (!z10) {
            try {
                List<C0555b> list = this.f12793g;
                list.add(E(aVar, list, i10));
            } catch (NotFoundException e10) {
                if (!this.f12793g.isEmpty()) {
                    z10 = true;
                } else {
                    throw e10;
                }
            }
        }
        if (r()) {
            return this.f12793g;
        }
        boolean z11 = !this.f12794h.isEmpty();
        G(i10, false);
        if (z11) {
            List<C0555b> t10 = t(false);
            if (t10 != null) {
                return t10;
            }
            List<C0555b> t11 = t(true);
            if (t11 != null) {
                return t11;
            }
        }
        throw NotFoundException.a();
    }

    public final void x(S4.a aVar, List<C0555b> list, int i10) {
        boolean z10;
        int[] i11 = i();
        i11[0] = 0;
        i11[1] = 0;
        i11[2] = 0;
        i11[3] = 0;
        int k10 = aVar.k();
        if (i10 < 0) {
            if (list.isEmpty()) {
                i10 = 0;
            } else {
                i10 = list.get(list.size() - 1).a().b()[1];
            }
        }
        if (list.size() % 2 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f12796j) {
            z10 = !z10;
        }
        boolean z11 = false;
        while (i10 < k10) {
            z11 = !aVar.g(i10);
            if (!z11) {
                break;
            } else {
                i10++;
            }
        }
        int i12 = 0;
        boolean z12 = z11;
        int i13 = i10;
        while (i10 < k10) {
            if (aVar.g(i10) != z12) {
                i11[i12] = i11[i12] + 1;
            } else {
                if (i12 == 3) {
                    if (z10) {
                        F(i11);
                    }
                    if (AbstractC0525a.o(i11)) {
                        int[] iArr = this.f12795i;
                        iArr[0] = i13;
                        iArr[1] = i10;
                        return;
                    }
                    if (z10) {
                        F(i11);
                    }
                    i13 += i11[0] + i11[1];
                    i11[0] = i11[2];
                    i11[1] = i11[3];
                    i11[2] = 0;
                    i11[3] = 0;
                    i12--;
                } else {
                    i12++;
                }
                i11[i12] = 1;
                z12 = !z12;
            }
            i10++;
        }
        throw NotFoundException.a();
    }
}
