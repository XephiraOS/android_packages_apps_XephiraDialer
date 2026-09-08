package b5;

import P4.g;
import P4.h;
import a5.k;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.oplus.backup.sdk.common.utils.ModuleType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: RSS14Reader.java */
/* loaded from: classes3.dex */
public final class e extends AbstractC0525a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f12176i = {1, 10, 34, 70, 126};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f12177j = {4, 20, 48, 81};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f12178k = {0, 161, 961, 2015, 2715};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f12179l = {0, ModuleType.TYPE_ACCOUNT, 1036, 1516};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f12180m = {8, 6, 4, 3, 1};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f12181n = {2, 4, 6, 8};

    /* renamed from: o, reason: collision with root package name */
    public static final int[][] f12182o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    /* renamed from: g, reason: collision with root package name */
    public final List<d> f12183g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List<d> f12184h = new ArrayList();

    public static void q(Collection<d> collection, d dVar) {
        if (dVar == null) {
            return;
        }
        for (d dVar2 : collection) {
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    public static boolean s(d dVar, d dVar2) {
        int a10 = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c10 = (dVar.d().c() * 9) + dVar2.d().c();
        if (c10 > 72) {
            c10--;
        }
        if (c10 > 8) {
            c10--;
        }
        if (a10 == c10) {
            return true;
        }
        return false;
    }

    public static P4.f t(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i10 = 0;
        for (int i11 = 0; i11 < 13; i11++) {
            int charAt = sb.charAt(i11) - '0';
            if ((i11 & 1) == 0) {
                charAt *= 3;
            }
            i10 += charAt;
        }
        int i12 = 10 - (i10 % 10);
        if (i12 == 10) {
            i12 = 0;
        }
        sb.append(i12);
        g[] a10 = dVar.d().a();
        g[] a11 = dVar2.d().a();
        return new P4.f(sb.toString(), null, new g[]{a10[0], a10[1], a11[0], a11[1]}, BarcodeFormat.RSS_14);
    }

    @Override // a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        q(this.f12183g, v(aVar, false, i10, map));
        aVar.o();
        q(this.f12184h, v(aVar, true, i10, map));
        aVar.o();
        for (d dVar : this.f12183g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.f12184h) {
                    if (dVar2.c() > 1 && s(dVar, dVar2)) {
                        return t(dVar, dVar2);
                    }
                }
            }
        }
        throw NotFoundException.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0028, code lost:
    
        if (r1 < 4) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x002a, code lost:
    
        r2 = true;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x002d, code lost:
    
        r2 = false;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0044, code lost:
    
        if (r1 < 4) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(boolean r10, int r11) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.e.r(boolean, int):void");
    }

    @Override // a5.k, P4.e
    public void reset() {
        this.f12183g.clear();
        this.f12184h.clear();
    }

    public final C0526b u(S4.a aVar, c cVar, boolean z10) {
        int i10;
        int[] h10 = h();
        for (int i11 = 0; i11 < h10.length; i11++) {
            h10[i11] = 0;
        }
        if (z10) {
            k.f(aVar, cVar.b()[0], h10);
        } else {
            k.e(aVar, cVar.b()[1] + 1, h10);
            int i12 = 0;
            for (int length = h10.length - 1; i12 < length; length--) {
                int i13 = h10[i12];
                h10[i12] = h10[length];
                h10[length] = i13;
                i12++;
            }
        }
        if (z10) {
            i10 = 16;
        } else {
            i10 = 15;
        }
        float d10 = T4.a.d(h10) / i10;
        int[] l10 = l();
        int[] j10 = j();
        float[] m10 = m();
        float[] k10 = k();
        for (int i14 = 0; i14 < h10.length; i14++) {
            float f10 = h10[i14] / d10;
            int i15 = (int) (0.5f + f10);
            if (i15 <= 0) {
                i15 = 1;
            } else if (i15 > 8) {
                i15 = 8;
            }
            int i16 = i14 / 2;
            if ((i14 & 1) == 0) {
                l10[i16] = i15;
                m10[i16] = f10 - i15;
            } else {
                j10[i16] = i15;
                k10[i16] = f10 - i15;
            }
        }
        r(z10, i10);
        int i17 = 0;
        int i18 = 0;
        for (int length2 = l10.length - 1; length2 >= 0; length2--) {
            int i19 = l10[length2];
            i17 = (i17 * 9) + i19;
            i18 += i19;
        }
        int i20 = 0;
        int i21 = 0;
        for (int length3 = j10.length - 1; length3 >= 0; length3--) {
            int i22 = j10[length3];
            i20 = (i20 * 9) + i22;
            i21 += i22;
        }
        int i23 = i17 + (i20 * 3);
        if (z10) {
            if ((i18 & 1) == 0 && i18 <= 12 && i18 >= 4) {
                int i24 = (12 - i18) / 2;
                int i25 = f12180m[i24];
                int i26 = 9 - i25;
                return new C0526b((f.b(l10, i25, false) * f12176i[i24]) + f.b(j10, i26, true) + f12178k[i24], i23);
            }
            throw NotFoundException.a();
        }
        if ((i21 & 1) == 0 && i21 <= 10 && i21 >= 4) {
            int i27 = (10 - i21) / 2;
            int i28 = f12181n[i27];
            return new C0526b((f.b(j10, 9 - i28, false) * f12177j[i27]) + f.b(l10, i28, true) + f12179l[i27], i23);
        }
        throw NotFoundException.a();
    }

    public final d v(S4.a aVar, boolean z10, int i10, Map<DecodeHintType, ?> map) {
        h hVar;
        try {
            c x10 = x(aVar, i10, z10, w(aVar, z10));
            if (map == null) {
                hVar = null;
            } else {
                hVar = (h) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            if (hVar != null) {
                float f10 = (r1[0] + r1[1]) / 2.0f;
                if (z10) {
                    f10 = (aVar.k() - 1) - f10;
                }
                hVar.a(new g(f10, i10));
            }
            C0526b u10 = u(aVar, x10, true);
            C0526b u11 = u(aVar, x10, false);
            return new d((u10.b() * 1597) + u11.b(), u10.a() + (u11.a() * 4), x10);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] w(S4.a aVar, boolean z10) {
        int[] i10 = i();
        i10[0] = 0;
        i10[1] = 0;
        i10[2] = 0;
        i10[3] = 0;
        int k10 = aVar.k();
        int i11 = 0;
        boolean z11 = false;
        while (i11 < k10) {
            z11 = !aVar.g(i11);
            if (z10 == z11) {
                break;
            }
            i11++;
        }
        int i12 = 0;
        int i13 = i11;
        while (i11 < k10) {
            if (aVar.g(i11) != z11) {
                i10[i12] = i10[i12] + 1;
            } else {
                if (i12 == 3) {
                    if (AbstractC0525a.o(i10)) {
                        return new int[]{i13, i11};
                    }
                    i13 += i10[0] + i10[1];
                    i10[0] = i10[2];
                    i10[1] = i10[3];
                    i10[2] = 0;
                    i10[3] = 0;
                    i12--;
                } else {
                    i12++;
                }
                i10[i12] = 1;
                z11 = !z11;
            }
            i11++;
        }
        throw NotFoundException.a();
    }

    public final c x(S4.a aVar, int i10, boolean z10, int[] iArr) {
        int i11;
        int i12;
        boolean g10 = aVar.g(iArr[0]);
        int i13 = iArr[0] - 1;
        while (i13 >= 0 && g10 != aVar.g(i13)) {
            i13--;
        }
        int i14 = i13 + 1;
        int i15 = iArr[0] - i14;
        int[] i16 = i();
        System.arraycopy(i16, 0, i16, 1, i16.length - 1);
        i16[0] = i15;
        int p10 = AbstractC0525a.p(i16, f12182o);
        int i17 = iArr[1];
        if (z10) {
            int k10 = (aVar.k() - 1) - i14;
            i11 = (aVar.k() - 1) - i17;
            i12 = k10;
        } else {
            i11 = i17;
            i12 = i14;
        }
        return new c(p10, new int[]{i14, iArr[1]}, i12, i11, i10);
    }
}
