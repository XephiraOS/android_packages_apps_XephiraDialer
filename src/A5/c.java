package a5;

import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.oplus.backup.sdk.common.utils.ModuleType;
import java.util.Arrays;
import java.util.Map;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/* compiled from: Code39Reader.java */
/* loaded from: classes3.dex */
public final class c extends k {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f6403e = {52, 289, 97, ModuleType.TYPE_LAUNCHER, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, Imgcodecs.IMWRITE_TIFF_COMPRESSION, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, VibrateUtils.STRENGTH_OFFSET, 208, Imgproc.COLOR_RGBA2YUV_YV12, 388, 196, 168, 162, 138, 42};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6404a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6405b;

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f6406c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f6407d;

    public c() {
        this(false);
    }

    public static String g(CharSequence charSequence) {
        int i10;
        char c10;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i11 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                sb.append(charAt);
            } else {
                i11++;
                char charAt2 = charSequence.charAt(i11);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i10 = charAt2 - ' ';
                                } else if (charAt2 == 'Z') {
                                    c10 = ':';
                                    sb.append(c10);
                                } else {
                                    throw FormatException.a();
                                }
                            }
                            c10 = 0;
                            sb.append(c10);
                        } else if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i10 = charAt2 + ' ';
                        } else {
                            throw FormatException.a();
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
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
                            } else {
                                if (charAt2 != 'X' && charAt2 != 'Y' && charAt2 != 'Z') {
                                    throw FormatException.a();
                                }
                                c10 = 127;
                            }
                            sb.append(c10);
                        }
                        c10 = 0;
                        sb.append(c10);
                    }
                } else if (charAt2 >= 'A' && charAt2 <= 'Z') {
                    i10 = charAt2 - '@';
                } else {
                    throw FormatException.a();
                }
                c10 = (char) i10;
                sb.append(c10);
            }
            i11++;
        }
        return sb.toString();
    }

    public static int[] h(S4.a aVar, int[] iArr) {
        int k10 = aVar.k();
        int i10 = aVar.i(0);
        int length = iArr.length;
        boolean z10 = false;
        int i11 = 0;
        int i12 = i10;
        while (i10 < k10) {
            if (aVar.g(i10) != z10) {
                iArr[i11] = iArr[i11] + 1;
            } else {
                if (i11 == length - 1) {
                    if (j(iArr) == 148 && aVar.m(Math.max(0, i12 - ((i10 - i12) / 2)), i12, false)) {
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

    public static char i(int i10) {
        int i11 = 0;
        while (true) {
            int[] iArr = f6403e;
            if (i11 < iArr.length) {
                if (iArr[i11] == i10) {
                    return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i11);
                }
                i11++;
            } else {
                if (i10 == 148) {
                    return '*';
                }
                throw NotFoundException.a();
            }
        }
    }

    public static int j(int[] iArr) {
        int length = iArr.length;
        int i10 = 0;
        while (true) {
            int i11 = Integer.MAX_VALUE;
            for (int i12 : iArr) {
                if (i12 < i11 && i12 > i10) {
                    i11 = i12;
                }
            }
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < length; i16++) {
                int i17 = iArr[i16];
                if (i17 > i11) {
                    i14 |= 1 << ((length - 1) - i16);
                    i13++;
                    i15 += i17;
                }
            }
            if (i13 == 3) {
                for (int i18 = 0; i18 < length && i13 > 0; i18++) {
                    int i19 = iArr[i18];
                    if (i19 > i11) {
                        i13--;
                        if ((i19 << 1) >= i15) {
                            return -1;
                        }
                    }
                }
                return i14;
            }
            if (i13 <= 3) {
                return -1;
            }
            i10 = i11;
        }
    }

    @Override // a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        String sb;
        int[] iArr = this.f6407d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f6406c;
        sb2.setLength(0);
        int i11 = aVar.i(h(aVar, iArr)[1]);
        int k10 = aVar.k();
        while (true) {
            k.e(aVar, i11, iArr);
            int j10 = j(iArr);
            if (j10 >= 0) {
                char i12 = i(j10);
                sb2.append(i12);
                int i13 = i11;
                for (int i14 : iArr) {
                    i13 += i14;
                }
                int i15 = aVar.i(i13);
                if (i12 == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i16 = 0;
                    for (int i17 : iArr) {
                        i16 += i17;
                    }
                    int i18 = (i15 - i11) - i16;
                    if (i15 != k10 && (i18 << 1) < i16) {
                        throw NotFoundException.a();
                    }
                    if (this.f6404a) {
                        int length = sb2.length() - 1;
                        int i19 = 0;
                        for (int i20 = 0; i20 < length; i20++) {
                            i19 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f6406c.charAt(i20));
                        }
                        if (sb2.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i19 % 43)) {
                            sb2.setLength(length);
                        } else {
                            throw ChecksumException.a();
                        }
                    }
                    if (sb2.length() != 0) {
                        if (this.f6405b) {
                            sb = g(sb2);
                        } else {
                            sb = sb2.toString();
                        }
                        float f10 = i10;
                        return new P4.f(sb, null, new P4.g[]{new P4.g((r2[1] + r2[0]) / 2.0f, f10), new P4.g(i11 + (i16 / 2.0f), f10)}, BarcodeFormat.CODE_39);
                    }
                    throw NotFoundException.a();
                }
                i11 = i15;
            } else {
                throw NotFoundException.a();
            }
        }
    }

    public c(boolean z10) {
        this(z10, false);
    }

    public c(boolean z10, boolean z11) {
        this.f6404a = z10;
        this.f6405b = z11;
        this.f6406c = new StringBuilder(20);
        this.f6407d = new int[9];
    }
}
