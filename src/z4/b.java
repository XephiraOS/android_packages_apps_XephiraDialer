package Z4;

import S4.d;
import com.heytap.accessory.bean.BtDirectAdvertiseSetting;
import com.heytap.accessory.constant.FastPairConstants;
import java.text.DecimalFormat;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f5950a = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    public static d a(byte[] bArr, int i10) {
        String h10;
        StringBuilder sb = new StringBuilder(144);
        if (i10 != 2 && i10 != 3) {
            if (i10 != 4) {
                if (i10 == 5) {
                    sb.append(e(bArr, 1, 77));
                }
            } else {
                sb.append(e(bArr, 1, 93));
            }
        } else {
            if (i10 == 2) {
                h10 = new DecimalFormat("0000000000".substring(0, g(bArr))).format(f(bArr));
            } else {
                h10 = h(bArr);
            }
            DecimalFormat decimalFormat = new DecimalFormat(FastPairConstants.STATUS_CONNECT_RESULT_SUCCESS);
            String format = decimalFormat.format(c(bArr));
            String format2 = decimalFormat.format(i(bArr));
            sb.append(e(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, h10 + (char) 29 + format + (char) 29 + format2 + (char) 29);
            } else {
                sb.insert(0, h10 + (char) 29 + format + (char) 29 + format2 + (char) 29);
            }
        }
        return new d(bArr, sb.toString(), null, String.valueOf(i10));
    }

    public static int b(int i10, byte[] bArr) {
        int i11 = i10 - 1;
        if (((1 << (5 - (i11 % 6))) & bArr[i11 / 6]) != 0) {
            return 1;
        }
        return 0;
    }

    public static int c(byte[] bArr) {
        return d(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    public static int d(byte[] bArr, byte[] bArr2) {
        if (bArr2.length != 0) {
            int i10 = 0;
            for (int i11 = 0; i11 < bArr2.length; i11++) {
                i10 += b(bArr2[i11], bArr) << ((bArr2.length - i11) - 1);
            }
            return i10;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    public static String e(byte[] bArr, int i10, int i11) {
        StringBuilder sb = new StringBuilder();
        int i12 = i10;
        int i13 = -1;
        int i14 = 0;
        int i15 = 0;
        while (i12 < i10 + i11) {
            char charAt = f5950a[i14].charAt(bArr[i12]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i15 = i14;
                    i14 = charAt - 65520;
                    i13 = 1;
                    break;
                case 65525:
                    i13 = 2;
                    i15 = i14;
                    i14 = 0;
                    break;
                case 65526:
                    i13 = 3;
                    i15 = i14;
                    i14 = 0;
                    break;
                case 65527:
                    i13 = -1;
                    i14 = 0;
                    break;
                case 65528:
                    i13 = -1;
                    i14 = 1;
                    break;
                case 65529:
                    i13 = -1;
                    break;
                case 65530:
                default:
                    sb.append(charAt);
                    break;
                case 65531:
                    int i16 = (bArr[i12 + 1] << 24) + (bArr[i12 + 2] << 18) + (bArr[i12 + 3] << 12) + (bArr[i12 + 4] << 6);
                    i12 += 5;
                    sb.append(new DecimalFormat("000000000").format(i16 + bArr[i12]));
                    break;
            }
            int i17 = i13 - 1;
            if (i13 == 0) {
                i14 = i15;
            }
            i12++;
            i13 = i17;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static int f(byte[] bArr) {
        return d(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, FastPairConstants.GO_INTENT_MAX, BtDirectAdvertiseSetting.FLAG_DEVICE_BATTERY, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    public static int g(byte[] bArr) {
        return d(bArr, new byte[]{39, 40, 41, 42, 31, BtDirectAdvertiseSetting.FLAG_DEVICE_STATE});
    }

    public static String h(byte[] bArr) {
        String[] strArr = f5950a;
        return String.valueOf(new char[]{strArr[0].charAt(d(bArr, new byte[]{39, 40, 41, 42, 31, BtDirectAdvertiseSetting.FLAG_DEVICE_STATE})), strArr[0].charAt(d(bArr, new byte[]{33, 34, 35, 36, 25, 26})), strArr[0].charAt(d(bArr, new byte[]{27, 28, 29, 30, 19, 20})), strArr[0].charAt(d(bArr, new byte[]{21, 22, 23, 24, 13, 14})), strArr[0].charAt(d(bArr, new byte[]{FastPairConstants.GO_INTENT_MAX, BtDirectAdvertiseSetting.FLAG_DEVICE_BATTERY, 17, 18, 7, 8})), strArr[0].charAt(d(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    public static int i(byte[] bArr) {
        return d(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }
}
