package l5;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.heytap.accessory.constant.FastPairConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Encoder.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f34693a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* compiled from: Encoder.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34694a;

        static {
            int[] iArr = new int[Mode.values().length];
            f34694a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34694a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34694a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34694a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(String str, S4.a aVar, String str2) {
        try {
            for (byte b10 : str.getBytes(str2)) {
                aVar.c(b10, 8);
            }
        } catch (UnsupportedEncodingException e10) {
            throw new WriterException(e10);
        }
    }

    public static void b(CharSequence charSequence, S4.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int p10 = p(charSequence.charAt(i10));
            if (p10 != -1) {
                int i11 = i10 + 1;
                if (i11 < length) {
                    int p11 = p(charSequence.charAt(i11));
                    if (p11 != -1) {
                        aVar.c((p10 * 45) + p11, 11);
                        i10 += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    aVar.c(p10, 6);
                    i10 = i11;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    public static void c(String str, Mode mode, S4.a aVar, String str2) {
        int i10 = a.f34694a[mode.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        e(str, aVar);
                        return;
                    }
                    throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
                }
                a(str, aVar, str2);
                return;
            }
            b(str, aVar);
            return;
        }
        h(str, aVar);
    }

    public static void d(CharacterSetECI characterSetECI, S4.a aVar) {
        aVar.c(Mode.ECI.b(), 4);
        aVar.c(characterSetECI.c(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c A[LOOP:0: B:6:0x000f->B:13:0x003c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.lang.String r6, S4.a r7) {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L5c
            int r0 = r6.length
            int r0 = r0 % 2
            if (r0 != 0) goto L54
            int r0 = r6.length
            int r0 = r0 + (-1)
            r1 = 0
        Lf:
            if (r1 >= r0) goto L53
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L2b
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L2b
        L29:
            int r2 = r2 - r3
            goto L3a
        L2b:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L39
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L39
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L29
        L39:
            r2 = r4
        L3a:
            if (r2 == r4) goto L4b
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto Lf
        L4b:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L53:
            return
        L54:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Kanji byte size not even"
            r6.<init>(r7)
            throw r6
        L5c:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.c.e(java.lang.String, S4.a):void");
    }

    public static void f(int i10, j5.f fVar, Mode mode, S4.a aVar) {
        int c10 = mode.c(fVar);
        int i11 = 1 << c10;
        if (i10 < i11) {
            aVar.c(i10, c10);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    public static void g(Mode mode, S4.a aVar) {
        aVar.c(mode.b(), 4);
    }

    public static void h(CharSequence charSequence, S4.a aVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int charAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    public static int i(Mode mode, S4.a aVar, S4.a aVar2, j5.f fVar) {
        return aVar.k() + mode.c(fVar) + aVar2.k();
    }

    public static int j(C1294b c1294b) {
        return d.a(c1294b) + d.c(c1294b) + d.d(c1294b) + d.e(c1294b);
    }

    public static int k(S4.a aVar, ErrorCorrectionLevel errorCorrectionLevel, j5.f fVar, C1294b c1294b) {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            e.a(aVar, errorCorrectionLevel, fVar, i12, c1294b);
            int j10 = j(c1294b);
            if (j10 < i10) {
                i11 = i12;
                i10 = j10;
            }
        }
        return i11;
    }

    public static Mode l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && s(str)) {
            return Mode.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= '0' && charAt <= '9') {
                z11 = true;
            } else if (p(charAt) != -1) {
                z10 = true;
            } else {
                return Mode.BYTE;
            }
        }
        if (z10) {
            return Mode.ALPHANUMERIC;
        }
        if (z11) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    public static j5.f m(int i10, ErrorCorrectionLevel errorCorrectionLevel) {
        for (int i11 = 1; i11 <= 40; i11++) {
            j5.f i12 = j5.f.i(i11);
            if (v(i10, i12, errorCorrectionLevel)) {
                return i12;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static l5.f n(java.lang.String r6, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map<com.google.zxing.EncodeHintType, ?> r8) {
        /*
            if (r8 == 0) goto Lc
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 == 0) goto L1a
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            goto L1c
        L1a:
            java.lang.String r1 = "ISO-8859-1"
        L1c:
            com.google.zxing.qrcode.decoder.Mode r2 = l(r6, r1)
            S4.a r3 = new S4.a
            r3.<init>()
            com.google.zxing.qrcode.decoder.Mode r4 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r2 != r4) goto L34
            if (r0 == 0) goto L34
            com.google.zxing.common.CharacterSetECI r0 = com.google.zxing.common.CharacterSetECI.a(r1)
            if (r0 == 0) goto L34
            d(r0, r3)
        L34:
            if (r8 == 0) goto L55
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.GS1_FORMAT
            boolean r5 = r8.containsKey(r0)
            if (r5 == 0) goto L55
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L55
            com.google.zxing.qrcode.decoder.Mode r0 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION
            g(r0, r3)
        L55:
            g(r2, r3)
            S4.a r0 = new S4.a
            r0.<init>()
            c(r6, r2, r0, r1)
            if (r8 == 0) goto L8d
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r5 = r8.containsKey(r1)
            if (r5 == 0) goto L8d
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            j5.f r8 = j5.f.i(r8)
            int r1 = i(r2, r3, r0, r8)
            boolean r1 = v(r1, r8, r7)
            if (r1 == 0) goto L85
            goto L91
        L85:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>(r7)
            throw r6
        L8d:
            j5.f r8 = t(r7, r2, r3, r0)
        L91:
            S4.a r1 = new S4.a
            r1.<init>()
            r1.b(r3)
            if (r2 != r4) goto La0
            int r6 = r0.l()
            goto La4
        La0:
            int r6 = r6.length()
        La4:
            f(r6, r8, r2, r1)
            r1.b(r0)
            j5.f$b r6 = r8.f(r7)
            int r0 = r8.h()
            int r3 = r6.d()
            int r0 = r0 - r3
            u(r0, r1)
            int r3 = r8.h()
            int r6 = r6.c()
            S4.a r6 = r(r1, r3, r0, r6)
            l5.f r0 = new l5.f
            r0.<init>()
            r0.c(r7)
            r0.f(r2)
            r0.g(r8)
            int r1 = r8.e()
            l5.b r2 = new l5.b
            r2.<init>(r1, r1)
            int r1 = k(r6, r7, r8, r2)
            r0.d(r1)
            l5.e.a(r6, r7, r8, r1, r2)
            r0.e(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.c.n(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):l5.f");
    }

    public static byte[] o(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & FastPairConstants.GO_INTENT_NOT_SET;
        }
        new U4.d(U4.a.f3856l).b(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    public static int p(int i10) {
        int[] iArr = f34693a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public static void q(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) {
        if (i13 < i12) {
            int i14 = i10 % i12;
            int i15 = i12 - i14;
            int i16 = i10 / i12;
            int i17 = i16 + 1;
            int i18 = i11 / i12;
            int i19 = i18 + 1;
            int i20 = i16 - i18;
            int i21 = i17 - i19;
            if (i20 == i21) {
                if (i12 == i15 + i14) {
                    if (i10 == ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
                        if (i13 < i15) {
                            iArr[0] = i18;
                            iArr2[0] = i20;
                            return;
                        } else {
                            iArr[0] = i19;
                            iArr2[0] = i21;
                            return;
                        }
                    }
                    throw new WriterException("Total bytes mismatch");
                }
                throw new WriterException("RS blocks mismatch");
            }
            throw new WriterException("EC bytes mismatch");
        }
        throw new WriterException("Block ID too large");
    }

    public static S4.a r(S4.a aVar, int i10, int i11, int i12) {
        if (aVar.l() == i11) {
            ArrayList arrayList = new ArrayList(i12);
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                q(i10, i11, i12, i16, iArr, iArr2);
                int i17 = iArr[0];
                byte[] bArr = new byte[i17];
                aVar.r(i13 << 3, bArr, 0, i17);
                byte[] o10 = o(bArr, iArr2[0]);
                arrayList.add(new C1293a(bArr, o10));
                i14 = Math.max(i14, i17);
                i15 = Math.max(i15, o10.length);
                i13 += iArr[0];
            }
            if (i11 == i13) {
                S4.a aVar2 = new S4.a();
                for (int i18 = 0; i18 < i14; i18++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] a10 = ((C1293a) it.next()).a();
                        if (i18 < a10.length) {
                            aVar2.c(a10[i18], 8);
                        }
                    }
                }
                for (int i19 = 0; i19 < i15; i19++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] b10 = ((C1293a) it2.next()).b();
                        if (i19 < b10.length) {
                            aVar2.c(b10[i19], 8);
                        }
                    }
                }
                if (i10 == aVar2.l()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i10 + " and " + aVar2.l() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    public static boolean s(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10 += 2) {
                int i11 = bytes[i10] & FastPairConstants.GO_INTENT_NOT_SET;
                if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public static j5.f t(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, S4.a aVar, S4.a aVar2) {
        return m(i(mode, aVar, aVar2, m(i(mode, aVar, aVar2, j5.f.i(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void u(int i10, S4.a aVar) {
        int i11;
        int i12 = i10 << 3;
        if (aVar.k() <= i12) {
            for (int i13 = 0; i13 < 4 && aVar.k() < i12; i13++) {
                aVar.a(false);
            }
            int k10 = aVar.k() & 7;
            if (k10 > 0) {
                while (k10 < 8) {
                    aVar.a(false);
                    k10++;
                }
            }
            int l10 = i10 - aVar.l();
            for (int i14 = 0; i14 < l10; i14++) {
                if ((i14 & 1) == 0) {
                    i11 = 236;
                } else {
                    i11 = 17;
                }
                aVar.c(i11, 8);
            }
            if (aVar.k() == i12) {
                return;
            } else {
                throw new WriterException("Bits size does not equal capacity");
            }
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.k() + " > " + i12);
    }

    public static boolean v(int i10, j5.f fVar, ErrorCorrectionLevel errorCorrectionLevel) {
        if (fVar.h() - fVar.f(errorCorrectionLevel).d() >= (i10 + 7) / 8) {
            return true;
        }
        return false;
    }
}
