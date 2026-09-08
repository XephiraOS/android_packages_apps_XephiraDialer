package a5;

import com.coui.appcompat.hapticfeedback.COUIHapticFeedbackConstants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.oplus.backup.sdk.common.utils.ModuleType;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code93Reader.java */
/* loaded from: classes3.dex */
public final class d extends k {

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f6408c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f6409d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f6410e;

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f6411a = new StringBuilder(20);

    /* renamed from: b, reason: collision with root package name */
    public final int[] f6412b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, ModuleType.TYPE_ACCOUNT, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE_SYNC, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, COUIHapticFeedbackConstants.GRANULAR_SHORT_VIBRATE, 468, 466, 458, 366, 374, 430, 294, 474, 470, COUIHapticFeedbackConstants.EDGE_SHORT_VIBRATE, 350};
        f6409d = iArr;
        f6410e = iArr[47];
    }

    public static void g(CharSequence charSequence) {
        int length = charSequence.length();
        h(charSequence, length - 2, 20);
        h(charSequence, length - 1, 15);
    }

    public static void h(CharSequence charSequence, int i10, int i11) {
        int i12 = 0;
        int i13 = 1;
        for (int i14 = i10 - 1; i14 >= 0; i14--) {
            i12 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i14)) * i13;
            i13++;
            if (i13 > i11) {
                i13 = 1;
            }
        }
        if (charSequence.charAt(i10) != f6408c[i12 % 47]) {
            throw ChecksumException.a();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0029. Please report as an issue. */
    private static String i(CharSequence charSequence) {
        int i10;
        char c10;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt >= 'a' && charAt <= 'd') {
                if (i11 < length - 1) {
                    i11++;
                    char charAt2 = charSequence.charAt(i11);
                    switch (charAt) {
                        case 'a':
                            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                                i10 = charAt2 - '@';
                                c10 = (char) i10;
                                sb.append(c10);
                                break;
                            } else {
                                throw FormatException.a();
                            }
                            break;
                        case 'b':
                            if (charAt2 >= 'A' && charAt2 <= 'E') {
                                i10 = charAt2 - '&';
                            } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                                i10 = charAt2 - 11;
                            } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                                i10 = charAt2 + 16;
                            } else if (charAt2 >= 'P' && charAt2 <= 'T') {
                                i10 = charAt2 + '+';
                            } else {
                                if (charAt2 != 'U') {
                                    if (charAt2 == 'V') {
                                        c10 = '@';
                                    } else if (charAt2 == 'W') {
                                        c10 = '`';
                                    } else if (charAt2 >= 'X' && charAt2 <= 'Z') {
                                        c10 = 127;
                                    } else {
                                        throw FormatException.a();
                                    }
                                    sb.append(c10);
                                    break;
                                }
                                c10 = 0;
                                sb.append(c10);
                            }
                            c10 = (char) i10;
                            sb.append(c10);
                            break;
                        case 'c':
                            if (charAt2 >= 'A' && charAt2 <= 'O') {
                                i10 = charAt2 - ' ';
                                c10 = (char) i10;
                                sb.append(c10);
                            } else if (charAt2 == 'Z') {
                                c10 = ':';
                                sb.append(c10);
                                break;
                            } else {
                                throw FormatException.a();
                            }
                        case 'd':
                            if (charAt2 >= 'A' && charAt2 <= 'Z') {
                                i10 = charAt2 + ' ';
                                c10 = (char) i10;
                                sb.append(c10);
                                break;
                            } else {
                                throw FormatException.a();
                            }
                            break;
                        default:
                            c10 = 0;
                            sb.append(c10);
                            break;
                    }
                } else {
                    throw FormatException.a();
                }
            } else {
                sb.append(charAt);
            }
            i11++;
        }
        return sb.toString();
    }

    private static char k(int i10) {
        int i11 = 0;
        while (true) {
            int[] iArr = f6409d;
            if (i11 < iArr.length) {
                if (iArr[i11] == i10) {
                    return f6408c[i11];
                }
                i11++;
            } else {
                throw NotFoundException.a();
            }
        }
    }

    public static int l(int[] iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        int length = iArr.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int round = Math.round((iArr[i13] * 9.0f) / i10);
            if (round > 0 && round <= 4) {
                if ((i13 & 1) == 0) {
                    for (int i14 = 0; i14 < round; i14++) {
                        i12 = (i12 << 1) | 1;
                    }
                } else {
                    i12 <<= round;
                }
            } else {
                return -1;
            }
        }
        return i12;
    }

    @Override // a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        int i11 = aVar.i(j(aVar)[1]);
        int k10 = aVar.k();
        int[] iArr = this.f6412b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f6411a;
        sb.setLength(0);
        while (true) {
            k.e(aVar, i11, iArr);
            int l10 = l(iArr);
            if (l10 >= 0) {
                char k11 = k(l10);
                sb.append(k11);
                int i12 = i11;
                for (int i13 : iArr) {
                    i12 += i13;
                }
                int i14 = aVar.i(i12);
                if (k11 == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    int i15 = 0;
                    for (int i16 : iArr) {
                        i15 += i16;
                    }
                    if (i14 != k10 && aVar.g(i14)) {
                        if (sb.length() >= 2) {
                            g(sb);
                            sb.setLength(sb.length() - 2);
                            float f10 = i10;
                            return new P4.f(i(sb), null, new P4.g[]{new P4.g((r13[1] + r13[0]) / 2.0f, f10), new P4.g(i11 + (i15 / 2.0f), f10)}, BarcodeFormat.CODE_93);
                        }
                        throw NotFoundException.a();
                    }
                    throw NotFoundException.a();
                }
                i11 = i14;
            } else {
                throw NotFoundException.a();
            }
        }
    }

    public final int[] j(S4.a aVar) {
        int k10 = aVar.k();
        int i10 = aVar.i(0);
        Arrays.fill(this.f6412b, 0);
        int[] iArr = this.f6412b;
        int length = iArr.length;
        boolean z10 = false;
        int i11 = 0;
        int i12 = i10;
        while (i10 < k10) {
            if (aVar.g(i10) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == length - 1) {
                    if (l(iArr) == f6410e) {
                        return new int[]{i12, i10};
                    }
                    i12 += iArr[0] + iArr[1];
                    int i13 = i11 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i11] = 0;
                    i11--;
                } else {
                    i11++;
                }
                iArr[i11] = 1;
                z10 = !z10;
            }
            i10++;
        }
        throw NotFoundException.a();
    }
}
