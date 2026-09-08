package com.oplus.ocs.icdf.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class HexUtils {
    private static final int MAC_LENGTH = 6;
    private static final int RADIX_16 = 16;
    private static final int SHOW_LENGTH_ADDRESS = 5;
    private static final int SHOW_LENGTH_DEFAULT = 4;

    public static byte[] base642Byte(String str) {
        return Base64.getDecoder().decode(str);
    }

    public static String byte2Base64(byte[] bArr) {
        return Base64.getEncoder().encodeToString(bArr);
    }

    public static List<String> byteArrayToHexFragmentStr(byte[] bArr, int i10) {
        ArrayList arrayList = new ArrayList();
        if (bArr != null && bArr.length != 0) {
            int i11 = 0;
            while (i11 < bArr.length) {
                arrayList.add(byteArrayToHexStr(bArr, i11, Math.min(i10, bArr.length - i11)));
                i11 += i10;
            }
        }
        return arrayList;
    }

    public static String byteArrayToHexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return byteArrayToHexStr(bArr, 0, bArr.length);
    }

    public static String byteToHexStr(byte b10) {
        return byteArrayToHexStr(new byte[]{b10});
    }

    public static byte[] hexStrToByteArray(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        try {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) Integer.parseInt(str.substring(i11, i11 + 2), 16);
            }
            return bArr;
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String hide(long j10) {
        return hide(String.valueOf(j10), 4);
    }

    public static String hideAddress(String str) {
        return hide(str, 5);
    }

    public static String macByteToStr(byte[] bArr) {
        if (bArr != null && bArr.length == 6) {
            char[] charArray = "0123456789ABCDEF".toCharArray();
            char[] cArr = new char[17];
            for (int i10 = 0; i10 < 6; i10++) {
                byte b10 = bArr[i10];
                int i11 = i10 * 3;
                cArr[i11] = charArray[(b10 & FastPairConstants.GO_INTENT_NOT_SET) >>> 4];
                cArr[i11 + 1] = charArray[b10 & FastPairConstants.GO_INTENT_MAX];
                if (i10 != 5) {
                    cArr[i11 + 2] = ':';
                }
            }
            return new String(cArr);
        }
        return null;
    }

    public static byte[] macStrToByte(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains(":")) {
            return hexStrToByteArray(str.replace(":", ""));
        }
        if (!str.contains(".")) {
            return null;
        }
        return hexStrToByteArray(str.replace(".", ""));
    }

    public static String toString(Bundle bundle) {
        if (bundle == null) {
            return "bundle is null.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bundle value {");
        try {
            for (String str : bundle.keySet()) {
                sb.append(str);
                sb.append(" = ");
                sb.append(bundle.get(str));
                sb.append("; ");
            }
            sb.append("}");
            return sb.toString();
        } catch (Exception unused) {
            return "bundle toString occurred an exception.";
        }
    }

    public static String byteArrayToHexStr(byte[] bArr, int i10, int i11) {
        if (bArr != null && bArr.length != 0) {
            if (i10 + i11 > bArr.length) {
                return "convert byte array, out of index, offset:" + i10 + ", length:" + i11 + ", byteLength:" + bArr.length;
            }
            char[] charArray = "0123456789ABCDEF".toCharArray();
            char[] cArr = new char[i11 * 2];
            for (int i12 = 0; i12 < i11; i12++) {
                byte b10 = bArr[i10 + i12];
                int i13 = i12 * 2;
                cArr[i13] = charArray[(b10 & FastPairConstants.GO_INTENT_NOT_SET) >>> 4];
                cArr[i13 + 1] = charArray[b10 & FastPairConstants.GO_INTENT_MAX];
            }
            return new String(cArr);
        }
        return "";
    }

    public static String hide(List<byte[]> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("List:[");
        Iterator<byte[]> it = list.iterator();
        while (it.hasNext()) {
            sb.append(hide(it.next()));
            sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public static String hide(byte[] bArr) {
        return hide(byteArrayToHexStr(bArr), 4);
    }

    public static String hide(String str) {
        return hide(str, 4);
    }

    public static String hide(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder("***");
        for (int min = Math.min(str.length(), i10); min > 0; min--) {
            sb.append(str.charAt(str.length() - min));
        }
        return sb.toString();
    }
}
