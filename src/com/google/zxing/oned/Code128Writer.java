package com.google.zxing.oned;

import S4.b;
import a5.l;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Code128Writer extends l {

    /* loaded from: classes3.dex */
    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static int f(CharSequence charSequence, int i10, int i11) {
        CType g10;
        CType g11;
        char charAt;
        CType g12 = g(charSequence, i10);
        CType cType = CType.ONE_DIGIT;
        if (g12 == cType) {
            if (i11 == 101) {
                return 101;
            }
            return 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (g12 == cType2) {
            if (i10 < charSequence.length() && ((charAt = charSequence.charAt(i10)) < ' ' || (i11 == 101 && (charAt < '`' || (charAt >= 241 && charAt <= 244))))) {
                return 101;
            }
            return 100;
        }
        if (i11 == 101 && g12 == CType.FNC_1) {
            return 101;
        }
        if (i11 == 99) {
            return 99;
        }
        if (i11 == 100) {
            CType cType3 = CType.FNC_1;
            if (g12 == cType3 || (g10 = g(charSequence, i10 + 2)) == cType2 || g10 == cType) {
                return 100;
            }
            if (g10 == cType3) {
                if (g(charSequence, i10 + 3) != CType.TWO_DIGITS) {
                    return 100;
                }
                return 99;
            }
            int i12 = i10 + 4;
            while (true) {
                g11 = g(charSequence, i12);
                if (g11 != CType.TWO_DIGITS) {
                    break;
                }
                i12 += 2;
            }
            if (g11 == CType.ONE_DIGIT) {
                return 100;
            }
            return 99;
        }
        if (g12 == CType.FNC_1) {
            g12 = g(charSequence, i10 + 1);
        }
        if (g12 != CType.TWO_DIGITS) {
            return 100;
        }
        return 99;
    }

    public static CType g(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i10);
        if (charAt == 241) {
            return CType.FNC_1;
        }
        if (charAt >= '0' && charAt <= '9') {
            int i11 = i10 + 1;
            if (i11 >= length) {
                return CType.ONE_DIGIT;
            }
            char charAt2 = charSequence.charAt(i11);
            if (charAt2 >= '0' && charAt2 <= '9') {
                return CType.TWO_DIGITS;
            }
            return CType.ONE_DIGIT;
        }
        return CType.UNCODABLE;
    }

    @Override // a5.l
    public b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.b(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // a5.l
    public boolean[] c(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = str.charAt(i11);
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        if (charAt > 127) {
                            throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                        }
                        break;
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 1;
            while (true) {
                int i16 = 103;
                if (i12 < length) {
                    int f10 = f(str, i12, i14);
                    int i17 = 100;
                    if (f10 == i14) {
                        switch (str.charAt(i12)) {
                            case 241:
                                i17 = 102;
                                break;
                            case 242:
                                i17 = 97;
                                break;
                            case 243:
                                i17 = 96;
                                break;
                            case 244:
                                if (i14 == 101) {
                                    i17 = 101;
                                    break;
                                }
                                break;
                            default:
                                if (i14 == 100) {
                                    i17 = str.charAt(i12) - ' ';
                                    break;
                                } else if (i14 != 101) {
                                    i17 = Integer.parseInt(str.substring(i12, i12 + 2));
                                    i12++;
                                    break;
                                } else {
                                    char charAt2 = str.charAt(i12);
                                    i17 = charAt2 - ' ';
                                    if (i17 < 0) {
                                        i17 = charAt2 + '@';
                                        break;
                                    }
                                }
                                break;
                        }
                        i12++;
                    } else {
                        if (i14 == 0) {
                            if (f10 != 100) {
                                if (f10 != 101) {
                                    i16 = 105;
                                }
                            } else {
                                i16 = 104;
                            }
                        } else {
                            i16 = f10;
                        }
                        i17 = i16;
                        i14 = f10;
                    }
                    arrayList.add(a5.b.f6402a[i17]);
                    i13 += i17 * i15;
                    if (i12 != 0) {
                        i15++;
                    }
                } else {
                    int[][] iArr = a5.b.f6402a;
                    arrayList.add(iArr[i13 % 103]);
                    arrayList.add(iArr[106]);
                    int i18 = 0;
                    for (int[] iArr2 : arrayList) {
                        for (int i19 : iArr2) {
                            i18 += i19;
                        }
                    }
                    boolean[] zArr = new boolean[i18];
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        i10 += l.a(zArr, i10, (int[]) it.next(), true);
                    }
                    return zArr;
                }
            }
        } else {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
    }
}
