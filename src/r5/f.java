package r5;

import android.text.TextUtils;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: HexUtils.java */
/* loaded from: classes3.dex */
public class f {
    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return b(bArr, 0, bArr.length);
        }
        return "";
    }

    public static String b(byte[] bArr, int i10, int i11) {
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

    public static byte[] c(String str) {
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

    public static String d(String str) {
        return e(str, 4);
    }

    public static String e(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        if (length == 1) {
            return str;
        }
        if (length <= 8) {
            StringBuilder sb = new StringBuilder();
            int i11 = length - (length / 2);
            for (int i12 = 0; i12 < length; i12++) {
                if (i12 < i11) {
                    sb.append("*");
                } else {
                    sb.append(str.charAt(i12));
                }
            }
            return sb.toString();
        }
        if (i10 > 8) {
            i10 = 8;
        }
        StringBuilder sb2 = new StringBuilder("*(" + (length - i10) + ")");
        for (int i13 = length + (-4); i13 < length; i13++) {
            sb2.append(str.charAt(i13));
        }
        return sb2.toString();
    }

    public static String f(byte[] bArr) {
        return e(a(bArr), 4);
    }

    public static String g(String str) {
        return e(str, 6);
    }

    public static String h(int i10) {
        return "0x" + Integer.toHexString(i10);
    }

    public static ArrayList<byte[]> i(List<String> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        ArrayList<byte[]> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(c(it.next()));
        }
        return arrayList;
    }

    public static ArrayList<String> j(List<byte[]> list) {
        if (list == null) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<byte[]> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }
}
