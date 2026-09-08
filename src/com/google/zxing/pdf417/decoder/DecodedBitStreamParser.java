package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import e5.c;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class DecodedBitStreamParser {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f25083a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f25084b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c, reason: collision with root package name */
    public static final BigInteger[] f25085c;

    /* loaded from: classes3.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25093a;

        static {
            int[] iArr = new int[Mode.values().length];
            f25093a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25093a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25093a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25093a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25093a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25093a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f25085c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f25085c;
            if (i10 < bigIntegerArr2.length) {
                bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(valueOf);
                i10++;
            } else {
                return;
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0036. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x0074. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0021 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static S4.d b(int[] r6, java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            e5.c r3 = new e5.c
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = g(r6, r4, r0)
            goto L60
        L28:
            int r2 = d(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.b(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        L49:
            int r2 = f(r6, r4, r0)
            goto L60
        L4e:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = g(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            S4.d r6 = new S4.d
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.m(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.b(int[], java.lang.String):S4.d");
    }

    public static String c(int[] iArr, int i10) {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigInteger = bigInteger.add(f25085c[(i10 - i11) - 1].multiply(BigInteger.valueOf(iArr[i11])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.a();
    }

    public static int d(int[] iArr, int i10, c cVar) {
        int i11;
        if (i10 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i12 = 0;
            while (i12 < 2) {
                iArr2[i12] = iArr[i10];
                i12++;
                i10++;
            }
            cVar.j(Integer.parseInt(c(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int g10 = g(iArr, i10, sb);
            cVar.d(sb.toString());
            if (iArr[g10] == 923) {
                i11 = g10 + 1;
            } else {
                i11 = -1;
            }
            while (g10 < iArr[0]) {
                int i13 = iArr[g10];
                if (i13 != 922) {
                    if (i13 == 923) {
                        switch (iArr[g10 + 1]) {
                            case 0:
                                StringBuilder sb2 = new StringBuilder();
                                g10 = g(iArr, g10 + 2, sb2);
                                cVar.e(sb2.toString());
                                break;
                            case 1:
                                StringBuilder sb3 = new StringBuilder();
                                g10 = f(iArr, g10 + 2, sb3);
                                cVar.i(Integer.parseInt(sb3.toString()));
                                break;
                            case 2:
                                StringBuilder sb4 = new StringBuilder();
                                g10 = f(iArr, g10 + 2, sb4);
                                cVar.l(Long.parseLong(sb4.toString()));
                                break;
                            case 3:
                                StringBuilder sb5 = new StringBuilder();
                                g10 = g(iArr, g10 + 2, sb5);
                                cVar.k(sb5.toString());
                                break;
                            case 4:
                                StringBuilder sb6 = new StringBuilder();
                                g10 = g(iArr, g10 + 2, sb6);
                                cVar.b(sb6.toString());
                                break;
                            case 5:
                                StringBuilder sb7 = new StringBuilder();
                                g10 = f(iArr, g10 + 2, sb7);
                                cVar.f(Long.parseLong(sb7.toString()));
                                break;
                            case 6:
                                StringBuilder sb8 = new StringBuilder();
                                g10 = f(iArr, g10 + 2, sb8);
                                cVar.c(Integer.parseInt(sb8.toString()));
                                break;
                            default:
                                throw FormatException.a();
                        }
                    } else {
                        throw FormatException.a();
                    }
                } else {
                    g10++;
                    cVar.g(true);
                }
            }
            if (i11 != -1) {
                int i14 = g10 - i11;
                if (cVar.a()) {
                    i14--;
                }
                cVar.h(Arrays.copyOfRange(iArr, i11, i14 + i11));
            }
            return g10;
        }
        throw FormatException.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:37:0x0072. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:49:0x0097. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x001b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:59:0x00b7. Please report as an issue. */
    public static void e(int[] iArr, int[] iArr2, int i10, StringBuilder sb) {
        Mode mode;
        int i11;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = iArr[i12];
            char c10 = ' ';
            switch (a.f25093a[mode2.ordinal()]) {
                case 1:
                    if (i13 < 26) {
                        i11 = i13 + 65;
                        c10 = (char) i11;
                        break;
                    } else {
                        if (i13 != 900) {
                            if (i13 != 913) {
                                switch (i13) {
                                    case 27:
                                        mode2 = Mode.LOWER;
                                        break;
                                    case 28:
                                        mode2 = Mode.MIXED;
                                        break;
                                    case 29:
                                        mode = Mode.PUNCT_SHIFT;
                                        c10 = 0;
                                        Mode mode4 = mode;
                                        mode3 = mode2;
                                        mode2 = mode4;
                                        break;
                                }
                            } else {
                                sb.append((char) iArr2[i12]);
                            }
                        } else {
                            mode2 = Mode.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                    break;
                case 2:
                    if (i13 < 26) {
                        i11 = i13 + 97;
                        c10 = (char) i11;
                        break;
                    } else {
                        if (i13 != 900) {
                            if (i13 != 913) {
                                switch (i13) {
                                    case 27:
                                        mode = Mode.ALPHA_SHIFT;
                                        c10 = 0;
                                        Mode mode42 = mode;
                                        mode3 = mode2;
                                        mode2 = mode42;
                                        break;
                                    case 28:
                                        mode2 = Mode.MIXED;
                                        break;
                                    case 29:
                                        mode = Mode.PUNCT_SHIFT;
                                        c10 = 0;
                                        Mode mode422 = mode;
                                        mode3 = mode2;
                                        mode2 = mode422;
                                        break;
                                }
                            } else {
                                sb.append((char) iArr2[i12]);
                            }
                        } else {
                            mode2 = Mode.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                    break;
                case 3:
                    if (i13 < 25) {
                        c10 = f25084b[i13];
                        break;
                    } else {
                        if (i13 != 900) {
                            if (i13 != 913) {
                                switch (i13) {
                                    case 25:
                                        mode2 = Mode.PUNCT;
                                        break;
                                    case 27:
                                        mode2 = Mode.LOWER;
                                        break;
                                    case 29:
                                        mode = Mode.PUNCT_SHIFT;
                                        c10 = 0;
                                        Mode mode4222 = mode;
                                        mode3 = mode2;
                                        mode2 = mode4222;
                                        break;
                                }
                            } else {
                                sb.append((char) iArr2[i12]);
                            }
                            c10 = 0;
                            break;
                        }
                        mode2 = Mode.ALPHA;
                        c10 = 0;
                    }
                    break;
                case 4:
                    if (i13 < 29) {
                        c10 = f25083a[i13];
                        break;
                    } else {
                        if (i13 != 29 && i13 != 900) {
                            if (i13 == 913) {
                                sb.append((char) iArr2[i12]);
                            }
                        } else {
                            mode2 = Mode.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                case 5:
                    if (i13 < 26) {
                        c10 = (char) (i13 + 65);
                    } else if (i13 != 26) {
                        if (i13 != 900) {
                            mode2 = mode3;
                        } else {
                            mode2 = Mode.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i13 < 29) {
                        c10 = f25083a[i13];
                    } else if (i13 != 29 && i13 != 900) {
                        if (i13 == 913) {
                            sb.append((char) iArr2[i12]);
                        }
                        c10 = 0;
                    } else {
                        mode2 = Mode.ALPHA;
                        c10 = 0;
                        break;
                    }
                    mode2 = mode3;
                    break;
                default:
                    c10 = 0;
                    break;
            }
            if (c10 != 0) {
                sb.append(c10);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        r10.append(c(r0, r3));
        r3 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0038 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(int[] r8, int r9, java.lang.StringBuilder r10) {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r8[r1]
            if (r9 >= r4) goto L43
            if (r2 != 0) goto L43
            int r5 = r9 + 1
            r6 = r8[r9]
            r7 = 1
            if (r5 != r4) goto L15
            r2 = r7
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r6 >= r4) goto L1f
            r0[r3] = r6
            int r3 = r3 + 1
        L1d:
            r9 = r5
            goto L2e
        L1f:
            if (r6 == r4) goto L2d
            r4 = 901(0x385, float:1.263E-42)
            if (r6 == r4) goto L2d
            r4 = 928(0x3a0, float:1.3E-42)
            if (r6 == r4) goto L2d
            switch(r6) {
                case 922: goto L2d;
                case 923: goto L2d;
                case 924: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L1d
        L2d:
            r2 = r7
        L2e:
            int r4 = r3 % 15
            if (r4 == 0) goto L38
            r4 = 902(0x386, float:1.264E-42)
            if (r6 == r4) goto L38
            if (r2 == 0) goto L7
        L38:
            if (r3 <= 0) goto L7
            java.lang.String r3 = c(r0, r3)
            r10.append(r3)
            r3 = r1
            goto L7
        L43:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.f(int[], int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0036. Please report as an issue. */
    public static int g(int[] iArr, int i10, StringBuilder sb) {
        int i11 = iArr[0];
        int[] iArr2 = new int[(i11 - i10) << 1];
        int[] iArr3 = new int[(i11 - i10) << 1];
        boolean z10 = false;
        int i12 = 0;
        while (i10 < iArr[0] && !z10) {
            int i13 = i10 + 1;
            int i14 = iArr[i10];
            if (i14 < 900) {
                iArr2[i12] = i14 / 30;
                iArr2[i12 + 1] = i14 % 30;
                i12 += 2;
            } else if (i14 != 913) {
                if (i14 != 928) {
                    switch (i14) {
                        case 900:
                            iArr2[i12] = 900;
                            i12++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i14) {
                            }
                    }
                }
                z10 = true;
            } else {
                iArr2[i12] = 913;
                i10 += 2;
                iArr3[i12] = iArr[i13];
                i12++;
            }
            i10 = i13;
        }
        e(iArr2, iArr3, i12, sb);
        return i10;
    }
}
