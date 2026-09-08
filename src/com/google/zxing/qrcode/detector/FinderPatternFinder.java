package com.google.zxing.qrcode.detector;

import P4.g;
import P4.h;
import S4.b;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k5.d;
import k5.e;

/* loaded from: classes3.dex */
public class FinderPatternFinder {

    /* renamed from: f, reason: collision with root package name */
    public static final EstimatedModuleComparator f25124f = new EstimatedModuleComparator();

    /* renamed from: a, reason: collision with root package name */
    public final b f25125a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f25127c;

    /* renamed from: e, reason: collision with root package name */
    public final h f25129e;

    /* renamed from: b, reason: collision with root package name */
    public final List<d> f25126b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final int[] f25128d = new int[5];

    /* loaded from: classes3.dex */
    public static final class EstimatedModuleComparator implements Serializable, Comparator<d> {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return Float.compare(dVar.i(), dVar2.i());
        }
    }

    public FinderPatternFinder(b bVar, h hVar) {
        this.f25125a = bVar;
        this.f25129e = hVar;
    }

    public static float a(int[] iArr, int i10) {
        return ((i10 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static boolean h(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = f10 / 2.0f;
        if (Math.abs(f10 - iArr[0]) >= f11 || Math.abs(f10 - iArr[1]) >= f11 || Math.abs((f10 * 3.0f) - iArr[2]) >= 3.0f * f11 || Math.abs(f10 - iArr[3]) >= f11 || Math.abs(f10 - iArr[4]) >= f11) {
            return false;
        }
        return true;
    }

    public static boolean i(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = f10 / 1.333f;
        if (Math.abs(f10 - iArr[0]) >= f11 || Math.abs(f10 - iArr[1]) >= f11 || Math.abs((f10 * 3.0f) - iArr[2]) >= 3.0f * f11 || Math.abs(f10 - iArr[3]) >= f11 || Math.abs(f10 - iArr[4]) >= f11) {
            return false;
        }
        return true;
    }

    public static double o(d dVar, d dVar2) {
        double c10 = dVar.c() - dVar2.c();
        double d10 = dVar.d() - dVar2.d();
        return (c10 * c10) + (d10 * d10);
    }

    public final void b(int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr[i10] = 0;
        }
    }

    public final boolean c(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int[] j10 = j();
        int i15 = 0;
        while (i10 >= i15 && i11 >= i15 && this.f25125a.d(i11 - i15, i10 - i15)) {
            j10[2] = j10[2] + 1;
            i15++;
        }
        if (j10[2] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && !this.f25125a.d(i11 - i15, i10 - i15)) {
            j10[1] = j10[1] + 1;
            i15++;
        }
        if (j10[1] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && this.f25125a.d(i11 - i15, i10 - i15)) {
            j10[0] = j10[0] + 1;
            i15++;
        }
        if (j10[0] == 0) {
            return false;
        }
        int g10 = this.f25125a.g();
        int j11 = this.f25125a.j();
        int i16 = 1;
        while (true) {
            int i17 = i10 + i16;
            if (i17 >= g10 || (i14 = i11 + i16) >= j11 || !this.f25125a.d(i14, i17)) {
                break;
            }
            j10[2] = j10[2] + 1;
            i16++;
        }
        while (true) {
            int i18 = i10 + i16;
            if (i18 >= g10 || (i13 = i11 + i16) >= j11 || this.f25125a.d(i13, i18)) {
                break;
            }
            j10[3] = j10[3] + 1;
            i16++;
        }
        if (j10[3] == 0) {
            return false;
        }
        while (true) {
            int i19 = i10 + i16;
            if (i19 >= g10 || (i12 = i11 + i16) >= j11 || !this.f25125a.d(i12, i19)) {
                break;
            }
            j10[4] = j10[4] + 1;
            i16++;
        }
        if (j10[4] == 0) {
            return false;
        }
        return i(j10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
    
        if (r9[3] < r12) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0086, code lost:
    
        if (r10 >= r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008c, code lost:
    
        if (r0.d(r10, r11) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008e, code lost:
    
        r8 = r9[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0090, code lost:
    
        if (r8 >= r12) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        r9[4] = r8 + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0099, code lost:
    
        r11 = r9[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009b, code lost:
    
        if (r11 < r12) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b1, code lost:
    
        if ((java.lang.Math.abs(((((r9[0] + r9[1]) + r9[2]) + r9[3]) + r11) - r13) * 5) < r13) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b3, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b8, code lost:
    
        if (h(r9) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00be, code lost:
    
        return a(r9, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float d(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            S4.b r0 = r9.f25125a
            int r1 = r0.j()
            int[] r9 = r9.j()
            r2 = r10
        Lb:
            r3 = 2
            r4 = 1
            if (r2 < 0) goto L1d
            boolean r5 = r0.d(r2, r11)
            if (r5 == 0) goto L1d
            r5 = r9[r3]
            int r5 = r5 + r4
            r9[r3] = r5
            int r2 = r2 + (-1)
            goto Lb
        L1d:
            r5 = 2143289344(0x7fc00000, float:NaN)
            if (r2 >= 0) goto L22
            return r5
        L22:
            if (r2 < 0) goto L35
            boolean r6 = r0.d(r2, r11)
            if (r6 != 0) goto L35
            r6 = r9[r4]
            if (r6 > r12) goto L35
            int r6 = r6 + 1
            r9[r4] = r6
            int r2 = r2 + (-1)
            goto L22
        L35:
            if (r2 < 0) goto Lbf
            r6 = r9[r4]
            if (r6 <= r12) goto L3d
            goto Lbf
        L3d:
            r6 = 0
            if (r2 < 0) goto L51
            boolean r7 = r0.d(r2, r11)
            if (r7 == 0) goto L51
            r7 = r9[r6]
            if (r7 > r12) goto L51
            int r7 = r7 + 1
            r9[r6] = r7
            int r2 = r2 + (-1)
            goto L3d
        L51:
            r2 = r9[r6]
            if (r2 <= r12) goto L56
            return r5
        L56:
            int r10 = r10 + r4
        L57:
            if (r10 >= r1) goto L67
            boolean r2 = r0.d(r10, r11)
            if (r2 == 0) goto L67
            r2 = r9[r3]
            int r2 = r2 + r4
            r9[r3] = r2
            int r10 = r10 + 1
            goto L57
        L67:
            if (r10 != r1) goto L6a
            return r5
        L6a:
            r2 = 3
            if (r10 >= r1) goto L7e
            boolean r7 = r0.d(r10, r11)
            if (r7 != 0) goto L7e
            r7 = r9[r2]
            if (r7 >= r12) goto L7e
            int r7 = r7 + 1
            r9[r2] = r7
            int r10 = r10 + 1
            goto L6a
        L7e:
            if (r10 == r1) goto Lbf
            r7 = r9[r2]
            if (r7 < r12) goto L85
            goto Lbf
        L85:
            r7 = 4
            if (r10 >= r1) goto L99
            boolean r8 = r0.d(r10, r11)
            if (r8 == 0) goto L99
            r8 = r9[r7]
            if (r8 >= r12) goto L99
            int r8 = r8 + 1
            r9[r7] = r8
            int r10 = r10 + 1
            goto L85
        L99:
            r11 = r9[r7]
            if (r11 < r12) goto L9e
            return r5
        L9e:
            r12 = r9[r6]
            r0 = r9[r4]
            int r12 = r12 + r0
            r0 = r9[r3]
            int r12 = r12 + r0
            r0 = r9[r2]
            int r12 = r12 + r0
            int r12 = r12 + r11
            int r12 = r12 - r13
            int r11 = java.lang.Math.abs(r12)
            int r11 = r11 * 5
            if (r11 < r13) goto Lb4
            return r5
        Lb4:
            boolean r11 = h(r9)
            if (r11 == 0) goto Lbf
            float r9 = a(r9, r10)
            return r9
        Lbf:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.d(int, int, int, int):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0082, code lost:
    
        if (r9[3] < r12) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0086, code lost:
    
        if (r10 >= r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008c, code lost:
    
        if (r0.d(r11, r10) == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x008e, code lost:
    
        r8 = r9[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0090, code lost:
    
        if (r8 >= r12) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0092, code lost:
    
        r9[4] = r8 + 1;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0099, code lost:
    
        r11 = r9[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009b, code lost:
    
        if (r11 < r12) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009d, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b2, code lost:
    
        if ((java.lang.Math.abs(((((r9[0] + r9[1]) + r9[2]) + r9[3]) + r11) - r13) * 5) < (r13 * 2)) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b4, code lost:
    
        return Float.NaN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b9, code lost:
    
        if (h(r9) == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bf, code lost:
    
        return a(r9, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float e(int r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            S4.b r0 = r9.f25125a
            int r1 = r0.g()
            int[] r9 = r9.j()
            r2 = r10
        Lb:
            r3 = 2
            r4 = 1
            if (r2 < 0) goto L1d
            boolean r5 = r0.d(r11, r2)
            if (r5 == 0) goto L1d
            r5 = r9[r3]
            int r5 = r5 + r4
            r9[r3] = r5
            int r2 = r2 + (-1)
            goto Lb
        L1d:
            r5 = 2143289344(0x7fc00000, float:NaN)
            if (r2 >= 0) goto L22
            return r5
        L22:
            if (r2 < 0) goto L35
            boolean r6 = r0.d(r11, r2)
            if (r6 != 0) goto L35
            r6 = r9[r4]
            if (r6 > r12) goto L35
            int r6 = r6 + 1
            r9[r4] = r6
            int r2 = r2 + (-1)
            goto L22
        L35:
            if (r2 < 0) goto Lc0
            r6 = r9[r4]
            if (r6 <= r12) goto L3d
            goto Lc0
        L3d:
            r6 = 0
            if (r2 < 0) goto L51
            boolean r7 = r0.d(r11, r2)
            if (r7 == 0) goto L51
            r7 = r9[r6]
            if (r7 > r12) goto L51
            int r7 = r7 + 1
            r9[r6] = r7
            int r2 = r2 + (-1)
            goto L3d
        L51:
            r2 = r9[r6]
            if (r2 <= r12) goto L56
            return r5
        L56:
            int r10 = r10 + r4
        L57:
            if (r10 >= r1) goto L67
            boolean r2 = r0.d(r11, r10)
            if (r2 == 0) goto L67
            r2 = r9[r3]
            int r2 = r2 + r4
            r9[r3] = r2
            int r10 = r10 + 1
            goto L57
        L67:
            if (r10 != r1) goto L6a
            return r5
        L6a:
            r2 = 3
            if (r10 >= r1) goto L7e
            boolean r7 = r0.d(r11, r10)
            if (r7 != 0) goto L7e
            r7 = r9[r2]
            if (r7 >= r12) goto L7e
            int r7 = r7 + 1
            r9[r2] = r7
            int r10 = r10 + 1
            goto L6a
        L7e:
            if (r10 == r1) goto Lc0
            r7 = r9[r2]
            if (r7 < r12) goto L85
            goto Lc0
        L85:
            r7 = 4
            if (r10 >= r1) goto L99
            boolean r8 = r0.d(r11, r10)
            if (r8 == 0) goto L99
            r8 = r9[r7]
            if (r8 >= r12) goto L99
            int r8 = r8 + 1
            r9[r7] = r8
            int r10 = r10 + 1
            goto L85
        L99:
            r11 = r9[r7]
            if (r11 < r12) goto L9e
            return r5
        L9e:
            r12 = r9[r6]
            r0 = r9[r4]
            int r12 = r12 + r0
            r0 = r9[r3]
            int r12 = r12 + r0
            r0 = r9[r2]
            int r12 = r12 + r0
            int r12 = r12 + r11
            int r12 = r12 - r13
            int r11 = java.lang.Math.abs(r12)
            int r11 = r11 * 5
            int r13 = r13 * r3
            if (r11 < r13) goto Lb5
            return r5
        Lb5:
            boolean r11 = h(r9)
            if (r11 == 0) goto Lc0
            float r9 = a(r9, r10)
            return r9
        Lc0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.e(int, int, int, int):float");
    }

    public final e f(Map<DecodeHintType, ?> map) {
        boolean z10;
        if (map != null && map.containsKey(DecodeHintType.TRY_HARDER)) {
            z10 = true;
        } else {
            z10 = false;
        }
        int g10 = this.f25125a.g();
        int j10 = this.f25125a.j();
        int i10 = (g10 * 3) / 388;
        if (i10 < 3 || z10) {
            i10 = 3;
        }
        int[] iArr = new int[5];
        int i11 = i10 - 1;
        boolean z11 = false;
        while (i11 < g10 && !z11) {
            b(iArr);
            int i12 = 0;
            int i13 = 0;
            while (i12 < j10) {
                if (this.f25125a.d(i12, i11)) {
                    if ((i13 & 1) == 1) {
                        i13++;
                    }
                    iArr[i13] = iArr[i13] + 1;
                } else if ((i13 & 1) == 0) {
                    if (i13 == 4) {
                        if (h(iArr)) {
                            if (k(iArr, i11, i12)) {
                                if (this.f25127c) {
                                    z11 = l();
                                } else {
                                    int g11 = g();
                                    int i14 = iArr[2];
                                    if (g11 > i14) {
                                        i11 += (g11 - i14) - 2;
                                        i12 = j10 - 1;
                                    }
                                }
                                b(iArr);
                                i10 = 2;
                                i13 = 0;
                            } else {
                                n(iArr);
                            }
                        } else {
                            n(iArr);
                        }
                        i13 = 3;
                    } else {
                        i13++;
                        iArr[i13] = iArr[i13] + 1;
                    }
                } else {
                    iArr[i13] = iArr[i13] + 1;
                }
                i12++;
            }
            if (h(iArr) && k(iArr, i11, j10)) {
                i10 = iArr[0];
                if (this.f25127c) {
                    z11 = l();
                }
            }
            i11 += i10;
        }
        d[] m10 = m();
        g.e(m10);
        return new e(m10);
    }

    public final int g() {
        if (this.f25126b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f25126b) {
            if (dVar2.h() >= 2) {
                if (dVar == null) {
                    dVar = dVar2;
                } else {
                    this.f25127c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
            }
        }
        return 0;
    }

    public final int[] j() {
        b(this.f25128d);
        return this.f25128d;
    }

    public final boolean k(int[] iArr, int i10, int i11) {
        int i12 = 0;
        int i13 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a10 = (int) a(iArr, i11);
        float e10 = e(i10, a10, iArr[2], i13);
        if (!Float.isNaN(e10)) {
            int i14 = (int) e10;
            float d10 = d(a10, i14, iArr[2], i13);
            if (!Float.isNaN(d10) && c(i14, (int) d10)) {
                float f10 = i13 / 7.0f;
                while (true) {
                    if (i12 < this.f25126b.size()) {
                        d dVar = this.f25126b.get(i12);
                        if (dVar.f(f10, e10, d10)) {
                            this.f25126b.set(i12, dVar.g(e10, d10, f10));
                            break;
                        }
                        i12++;
                    } else {
                        d dVar2 = new d(d10, e10, f10);
                        this.f25126b.add(dVar2);
                        h hVar = this.f25129e;
                        if (hVar != null) {
                            hVar.a(dVar2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean l() {
        int size = this.f25126b.size();
        float f10 = 0.0f;
        int i10 = 0;
        float f11 = 0.0f;
        for (d dVar : this.f25126b) {
            if (dVar.h() >= 2) {
                i10++;
                f11 += dVar.i();
            }
        }
        if (i10 < 3) {
            return false;
        }
        float f12 = f11 / size;
        Iterator<d> it = this.f25126b.iterator();
        while (it.hasNext()) {
            f10 += Math.abs(it.next().i() - f12);
        }
        if (f10 > f11 * 0.05f) {
            return false;
        }
        return true;
    }

    public final d[] m() {
        int i10;
        int i11 = 2;
        if (this.f25126b.size() >= 3) {
            this.f25126b.sort(f25124f);
            d[] dVarArr = new d[3];
            int i12 = 0;
            double d10 = Double.MAX_VALUE;
            while (i12 < this.f25126b.size() - i11) {
                d dVar = this.f25126b.get(i12);
                float i13 = dVar.i();
                i12++;
                int i14 = i12;
                while (i14 < this.f25126b.size() - 1) {
                    d dVar2 = this.f25126b.get(i14);
                    double o10 = o(dVar, dVar2);
                    i14++;
                    int i15 = i14;
                    while (i15 < this.f25126b.size()) {
                        d dVar3 = this.f25126b.get(i15);
                        if (dVar3.i() <= 1.4f * i13) {
                            i10 = 2;
                            double[] dArr = {o10, o(dVar2, dVar3), o(dVar, dVar3)};
                            Arrays.sort(dArr);
                            double abs = Math.abs(dArr[2] - (dArr[1] * 2.0d)) + Math.abs(dArr[2] - (dArr[0] * 2.0d));
                            if (abs < d10) {
                                dVarArr[0] = dVar;
                                dVarArr[1] = dVar2;
                                dVarArr[2] = dVar3;
                                d10 = abs;
                            }
                        } else {
                            i10 = i11;
                        }
                        i15++;
                        i11 = i10;
                    }
                }
            }
            if (d10 != Double.MAX_VALUE) {
                return dVarArr;
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public final void n(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }
}
