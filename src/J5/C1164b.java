package j5;

import S4.k;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: DecodedBitStreamParser.java */
/* renamed from: j5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1164b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f33874a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* compiled from: DecodedBitStreamParser.java */
    /* renamed from: j5.b$a */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33875a;

        static {
            int[] iArr = new int[Mode.values().length];
            f33875a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33875a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33875a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33875a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33875a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33875a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33875a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33875a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33875a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33875a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0039. Please report as an issue. */
    public static S4.d a(byte[] bArr, f fVar, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) {
        Mode a10;
        Mode mode;
        ArrayList arrayList;
        String obj;
        S4.c cVar = new S4.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList2 = new ArrayList(1);
        int i10 = -1;
        int i11 = -1;
        boolean z10 = false;
        CharacterSetECI characterSetECI = null;
        do {
            try {
                if (cVar.a() < 4) {
                    a10 = Mode.TERMINATOR;
                } else {
                    a10 = Mode.a(cVar.d(4));
                }
                Mode mode2 = a10;
                int[] iArr = a.f33875a;
                switch (iArr[mode2.ordinal()]) {
                    case 5:
                        mode = mode2;
                        break;
                    case 6:
                    case 7:
                        mode = mode2;
                        z10 = true;
                        break;
                    case 8:
                        mode = mode2;
                        if (cVar.a() >= 16) {
                            int d10 = cVar.d(8);
                            i11 = cVar.d(8);
                            i10 = d10;
                            break;
                        } else {
                            throw FormatException.a();
                        }
                    case 9:
                        mode = mode2;
                        characterSetECI = CharacterSetECI.b(g(cVar));
                        if (characterSetECI == null) {
                            throw FormatException.a();
                        }
                        break;
                    case 10:
                        mode = mode2;
                        int d11 = cVar.d(4);
                        int d12 = cVar.d(mode.c(fVar));
                        if (d11 == 1) {
                            d(cVar, sb, d12);
                        }
                        break;
                    default:
                        int d13 = cVar.d(mode2.c(fVar));
                        int i12 = iArr[mode2.ordinal()];
                        if (i12 != 1) {
                            if (i12 != 2) {
                                if (i12 != 3) {
                                    if (i12 == 4) {
                                        e(cVar, sb, d13);
                                        mode = mode2;
                                    } else {
                                        throw FormatException.a();
                                    }
                                } else {
                                    mode = mode2;
                                    c(cVar, sb, d13, characterSetECI, arrayList2, map);
                                }
                            } else {
                                mode = mode2;
                                b(cVar, sb, d13, z10);
                            }
                        } else {
                            mode = mode2;
                            f(cVar, sb, d13);
                        }
                        break;
                }
            } catch (IllegalArgumentException unused) {
                throw FormatException.a();
            }
        } while (mode != Mode.TERMINATOR);
        String sb2 = sb.toString();
        if (arrayList2.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = arrayList2;
        }
        if (errorCorrectionLevel == null) {
            obj = null;
        } else {
            obj = errorCorrectionLevel.toString();
        }
        return new S4.d(bArr, sb2, arrayList, obj, i10, i11);
    }

    public static void b(S4.c cVar, StringBuilder sb, int i10, boolean z10) {
        while (i10 > 1) {
            if (cVar.a() >= 11) {
                int d10 = cVar.d(11);
                sb.append(h(d10 / 45));
                sb.append(h(d10 % 45));
                i10 -= 2;
            } else {
                throw FormatException.a();
            }
        }
        if (i10 == 1) {
            if (cVar.a() >= 6) {
                sb.append(h(cVar.d(6)));
            } else {
                throw FormatException.a();
            }
        }
        if (z10) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i11 = length + 1;
                        if (sb.charAt(i11) == '%') {
                            sb.deleteCharAt(i11);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    public static void c(S4.c cVar, StringBuilder sb, int i10, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) {
        String name;
        if ((i10 << 3) <= cVar.a()) {
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = (byte) cVar.d(8);
            }
            if (characterSetECI == null) {
                name = k.a(bArr, map);
            } else {
                name = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.a();
            }
        }
        throw FormatException.a();
    }

    public static void d(S4.c cVar, StringBuilder sb, int i10) {
        int i11;
        if (i10 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i12 = 0;
            while (i10 > 0) {
                int d10 = cVar.d(13);
                int i13 = (d10 % 96) | ((d10 / 96) << 8);
                if (i13 < 2560) {
                    i11 = 41377;
                } else {
                    i11 = 42657;
                }
                int i14 = i13 + i11;
                bArr[i12] = (byte) (i14 >> 8);
                bArr[i12 + 1] = (byte) i14;
                i12 += 2;
                i10--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.a();
            }
        }
        throw FormatException.a();
    }

    public static void e(S4.c cVar, StringBuilder sb, int i10) {
        int i11;
        if (i10 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i12 = 0;
            while (i10 > 0) {
                int d10 = cVar.d(13);
                int i13 = (d10 % 192) | ((d10 / 192) << 8);
                if (i13 < 7936) {
                    i11 = 33088;
                } else {
                    i11 = 49472;
                }
                int i14 = i13 + i11;
                bArr[i12] = (byte) (i14 >> 8);
                bArr[i12 + 1] = (byte) i14;
                i12 += 2;
                i10--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.a();
            }
        }
        throw FormatException.a();
    }

    public static void f(S4.c cVar, StringBuilder sb, int i10) {
        while (i10 >= 3) {
            if (cVar.a() >= 10) {
                int d10 = cVar.d(10);
                if (d10 < 1000) {
                    sb.append(h(d10 / 100));
                    sb.append(h((d10 / 10) % 10));
                    sb.append(h(d10 % 10));
                    i10 -= 3;
                } else {
                    throw FormatException.a();
                }
            } else {
                throw FormatException.a();
            }
        }
        if (i10 == 2) {
            if (cVar.a() >= 7) {
                int d11 = cVar.d(7);
                if (d11 < 100) {
                    sb.append(h(d11 / 10));
                    sb.append(h(d11 % 10));
                    return;
                }
                throw FormatException.a();
            }
            throw FormatException.a();
        }
        if (i10 == 1) {
            if (cVar.a() >= 4) {
                int d12 = cVar.d(4);
                if (d12 < 10) {
                    sb.append(h(d12));
                    return;
                }
                throw FormatException.a();
            }
            throw FormatException.a();
        }
    }

    public static int g(S4.c cVar) {
        int d10 = cVar.d(8);
        if ((d10 & 128) == 0) {
            return d10 & 127;
        }
        if ((d10 & 192) == 128) {
            return cVar.d(8) | ((d10 & 63) << 8);
        }
        if ((d10 & 224) == 192) {
            return cVar.d(16) | ((d10 & 31) << 16);
        }
        throw FormatException.a();
    }

    public static char h(int i10) {
        char[] cArr = f33874a;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw FormatException.a();
    }
}
