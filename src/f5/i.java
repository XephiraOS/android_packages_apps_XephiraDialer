package f5;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.pdf417.decoder.DecodedBitStreamParser;
import e5.C0980a;
import g5.C1046a;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: PDF417ScanningDecoder.java */
/* loaded from: classes3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final C1046a f31753a = new C1046a();

    public static c a(g gVar) {
        int[] j10;
        if (gVar == null || (j10 = gVar.j()) == null) {
            return null;
        }
        int p10 = p(j10);
        int i10 = 0;
        int i11 = 0;
        for (int i12 : j10) {
            i11 += p10 - i12;
            if (i12 > 0) {
                break;
            }
        }
        d[] d10 = gVar.d();
        for (int i13 = 0; i11 > 0 && d10[i13] == null; i13++) {
            i11--;
        }
        for (int length = j10.length - 1; length >= 0; length--) {
            int i14 = j10[length];
            i10 += p10 - i14;
            if (i14 > 0) {
                break;
            }
        }
        for (int length2 = d10.length - 1; i10 > 0 && d10[length2] == null; length2--) {
            i10--;
        }
        return gVar.a().a(i11, i10, gVar.k());
    }

    public static void b(e eVar, C1013b[][] c1013bArr) {
        C1013b c1013b = c1013bArr[0][1];
        int[] a10 = c1013b.a();
        int j10 = (eVar.j() * eVar.l()) - r(eVar.k());
        if (a10.length == 0) {
            if (j10 > 0 && j10 <= 928) {
                c1013b.b(j10);
                return;
            }
            throw NotFoundException.a();
        }
        if (a10[0] != j10) {
            c1013b.b(j10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(S4.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.d(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.i.c(S4.b, int, int, boolean, int, int):int");
    }

    public static boolean d(int i10, int i11, int i12) {
        if (i11 - 2 <= i10 && i10 <= i12 + 2) {
            return true;
        }
        return false;
    }

    public static int e(int[] iArr, int[] iArr2, int i10) {
        if ((iArr2 == null || iArr2.length <= (i10 / 2) + 3) && i10 >= 0 && i10 <= 512) {
            return f31753a.a(iArr, i10, iArr2);
        }
        throw ChecksumException.a();
    }

    public static C1013b[][] f(e eVar) {
        int c10;
        C1013b[][] c1013bArr = (C1013b[][]) Array.newInstance((Class<?>) C1013b.class, eVar.l(), eVar.j() + 2);
        for (C1013b[] c1013bArr2 : c1013bArr) {
            int i10 = 0;
            while (true) {
                if (i10 < c1013bArr2.length) {
                    c1013bArr2[i10] = new C1013b();
                    i10++;
                }
            }
        }
        int i11 = 0;
        for (f fVar : eVar.o()) {
            if (fVar != null) {
                for (d dVar : fVar.d()) {
                    if (dVar != null && (c10 = dVar.c()) >= 0 && c10 < c1013bArr.length) {
                        c1013bArr[c10][i11].b(dVar.e());
                    }
                }
            }
            i11++;
        }
        return c1013bArr;
    }

    public static S4.d g(e eVar) {
        C1013b[][] f10 = f(eVar);
        b(eVar, f10);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[eVar.l() * eVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i10 = 0; i10 < eVar.l(); i10++) {
            int i11 = 0;
            while (i11 < eVar.j()) {
                int i12 = i11 + 1;
                int[] a10 = f10[i10][i12].a();
                int j10 = (eVar.j() * i10) + i11;
                if (a10.length == 0) {
                    arrayList.add(Integer.valueOf(j10));
                } else if (a10.length == 1) {
                    iArr[j10] = a10[0];
                } else {
                    arrayList3.add(Integer.valueOf(j10));
                    arrayList2.add(a10);
                }
                i11 = i12;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size];
        for (int i13 = 0; i13 < size; i13++) {
            iArr2[i13] = (int[]) arrayList2.get(i13);
        }
        return h(eVar.k(), iArr, C0980a.b(arrayList), C0980a.b(arrayList3), iArr2);
    }

    public static S4.d h(int i10, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i11 = 100;
        while (true) {
            int i12 = i11 - 1;
            if (i11 > 0) {
                for (int i13 = 0; i13 < length; i13++) {
                    iArr[iArr3[i13]] = iArr4[i13][iArr5[i13]];
                }
                try {
                    return j(iArr, i10, iArr2);
                } catch (ChecksumException unused) {
                    if (length != 0) {
                        int i14 = 0;
                        while (true) {
                            if (i14 >= length) {
                                break;
                            }
                            int i15 = iArr5[i14];
                            if (i15 < iArr4[i14].length - 1) {
                                iArr5[i14] = i15 + 1;
                                break;
                            }
                            iArr5[i14] = 0;
                            if (i14 != length - 1) {
                                i14++;
                            } else {
                                throw ChecksumException.a();
                            }
                        }
                        i11 = i12;
                    } else {
                        throw ChecksumException.a();
                    }
                }
            } else {
                throw ChecksumException.a();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        r2 = r26;
        r6 = r27;
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0072, code lost:
    
        if (r7 > r5) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (r0 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (r3.n(r8) != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
    
        if (r8 == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0082, code lost:
    
        if (r8 != r5) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
    
        r10 = new f5.f(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008a, code lost:
    
        r15 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
    
        r3.q(r8, r15);
        r14 = -1;
        r13 = r9.g();
        r12 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a5, code lost:
    
        if (r13 > r9.e()) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a7, code lost:
    
        r10 = t(r3, r8, r13, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ab, code lost:
    
        if (r10 < 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b1, code lost:
    
        if (r10 <= r9.d()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
    
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bb, code lost:
    
        r19 = r12;
        r22 = r13;
        r20 = r14;
        r1 = r15;
        r10 = k(r21, r9.f(), r9.d(), r0, r18, r22, r2, r6);
        r11 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dd, code lost:
    
        if (r10 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00df, code lost:
    
        r1.f(r11, r10);
        r2 = java.lang.Math.min(r2, r10.f());
        r6 = java.lang.Math.max(r6, r10.f());
        r12 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fd, code lost:
    
        r13 = r11 + 1;
        r15 = r1;
        r14 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00fb, code lost:
    
        r12 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b7, code lost:
    
        if (r12 == r14) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b9, code lost:
    
        r18 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f5, code lost:
    
        r19 = r12;
        r11 = r13;
        r20 = r14;
        r1 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0104, code lost:
    
        r7 = r7 + 1;
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008e, code lost:
    
        if (r8 != 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0090, code lost:
    
        r11 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0093, code lost:
    
        r10 = new f5.g(r9, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0092, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0078, code lost:
    
        r8 = r5 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010d, code lost:
    
        return g(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x006c, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static S4.d i(S4.b r21, P4.g r22, P4.g r23, P4.g r24, P4.g r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.i.i(S4.b, P4.g, P4.g, P4.g, P4.g, int, int):S4.d");
    }

    public static S4.d j(int[] iArr, int i10, int[] iArr2) {
        if (iArr.length != 0) {
            int i11 = 1 << (i10 + 1);
            int e10 = e(iArr, iArr2, i11);
            w(iArr, i11);
            S4.d b10 = DecodedBitStreamParser.b(iArr, String.valueOf(i10));
            b10.k(Integer.valueOf(e10));
            b10.j(Integer.valueOf(iArr2.length));
            return b10;
        }
        throw FormatException.a();
    }

    public static d k(S4.b bVar, int i10, int i11, boolean z10, int i12, int i13, int i14, int i15) {
        int i16;
        int d10;
        int a10;
        int c10 = c(bVar, i10, i11, z10, i12, i13);
        int[] q10 = q(bVar, i10, i11, z10, c10, i13);
        if (q10 == null) {
            return null;
        }
        int d11 = T4.a.d(q10);
        if (z10) {
            i16 = c10 + d11;
        } else {
            for (int i17 = 0; i17 < q10.length / 2; i17++) {
                int i18 = q10[i17];
                q10[i17] = q10[(q10.length - 1) - i17];
                q10[(q10.length - 1) - i17] = i18;
            }
            c10 -= d11;
            i16 = c10;
        }
        if (!d(d11, i14, i15) || (a10 = C0980a.a((d10 = h.d(q10)))) == -1) {
            return null;
        }
        return new d(c10, i16, n(d10), a10);
    }

    public static C1012a l(g gVar, g gVar2) {
        C1012a i10;
        C1012a i11;
        if (gVar != null && (i10 = gVar.i()) != null) {
            if (gVar2 != null && (i11 = gVar2.i()) != null && i10.a() != i11.a() && i10.b() != i11.b() && i10.c() != i11.c()) {
                return null;
            }
            return i10;
        }
        if (gVar2 == null) {
            return null;
        }
        return gVar2.i();
    }

    public static int[] m(int i10) {
        int[] iArr = new int[8];
        int i11 = 0;
        int i12 = 7;
        while (true) {
            int i13 = i10 & 1;
            if (i13 != i11) {
                i12--;
                if (i12 >= 0) {
                    i11 = i13;
                } else {
                    return iArr;
                }
            }
            iArr[i12] = iArr[i12] + 1;
            i10 >>= 1;
        }
    }

    public static int n(int i10) {
        return o(m(i10));
    }

    public static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static int p(int[] iArr) {
        int i10 = -1;
        for (int i11 : iArr) {
            i10 = Math.max(i10, i11);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[EDGE_INSN: B:17:0x0027->B:18:0x0027 BREAK  A[LOOP:0: B:5:0x000c->B:13:0x000c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int[] q(S4.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = r2
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.d(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.i.q(S4.b, int, int, boolean, int, int):int[]");
    }

    public static int r(int i10) {
        return 2 << i10;
    }

    public static g s(S4.b bVar, c cVar, P4.g gVar, boolean z10, int i10, int i11) {
        int i12;
        int b10;
        g gVar2 = new g(cVar, z10);
        for (int i13 = 0; i13 < 2; i13++) {
            if (i13 == 0) {
                i12 = 1;
            } else {
                i12 = -1;
            }
            int i14 = i12;
            int c10 = (int) gVar.c();
            for (int d10 = (int) gVar.d(); d10 <= cVar.e() && d10 >= cVar.g(); d10 += i14) {
                d k10 = k(bVar, 0, bVar.j(), z10, c10, d10, i10, i11);
                if (k10 != null) {
                    gVar2.f(d10, k10);
                    if (z10) {
                        b10 = k10.d();
                    } else {
                        b10 = k10.b();
                    }
                    c10 = b10;
                }
            }
        }
        return gVar2;
    }

    public static int t(e eVar, int i10, int i11, boolean z10) {
        int i12;
        d dVar;
        int d10;
        if (z10) {
            i12 = 1;
        } else {
            i12 = -1;
        }
        int i13 = i10 - i12;
        if (u(eVar, i13)) {
            dVar = eVar.n(i13).b(i11);
        } else {
            dVar = null;
        }
        if (dVar != null) {
            if (z10) {
                return dVar.b();
            }
            return dVar.d();
        }
        d c10 = eVar.n(i10).c(i11);
        if (c10 != null) {
            if (z10) {
                return c10.d();
            }
            return c10.b();
        }
        if (u(eVar, i13)) {
            c10 = eVar.n(i13).c(i11);
        }
        if (c10 != null) {
            if (z10) {
                return c10.b();
            }
            return c10.d();
        }
        int i14 = 0;
        while (true) {
            i10 -= i12;
            if (u(eVar, i10)) {
                for (d dVar2 : eVar.n(i10).d()) {
                    if (dVar2 != null) {
                        if (z10) {
                            d10 = dVar2.b();
                        } else {
                            d10 = dVar2.d();
                        }
                        return d10 + (i12 * i14 * (dVar2.b() - dVar2.d()));
                    }
                }
                i14++;
            } else {
                c m10 = eVar.m();
                if (z10) {
                    return m10.f();
                }
                return m10.d();
            }
        }
    }

    public static boolean u(e eVar, int i10) {
        if (i10 >= 0 && i10 <= eVar.j() + 1) {
            return true;
        }
        return false;
    }

    public static e v(g gVar, g gVar2) {
        C1012a l10;
        if ((gVar == null && gVar2 == null) || (l10 = l(gVar, gVar2)) == null) {
            return null;
        }
        return new e(l10, c.j(a(gVar), a(gVar2)));
    }

    public static void w(int[] iArr, int i10) {
        if (iArr.length >= 4) {
            int i11 = iArr[0];
            if (i11 <= iArr.length) {
                if (i11 == 0) {
                    if (i10 < iArr.length) {
                        iArr[0] = iArr.length - i10;
                        return;
                    }
                    throw FormatException.a();
                }
                return;
            }
            throw FormatException.a();
        }
        throw FormatException.a();
    }
}
