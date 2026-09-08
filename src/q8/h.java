package q8;

import com.heytap.accessory.constant.FastPairConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* compiled from: SystemUtils.java */
/* loaded from: classes3.dex */
public class h {
    public static void a(Object obj, int i10, Object obj2, int i11, int i12) {
        System.arraycopy(obj, i10, obj2, i11, i12);
    }

    public static int b(byte[] bArr) {
        return ((bArr[3] & FastPairConstants.GO_INTENT_NOT_SET) << 24) | (bArr[0] & FastPairConstants.GO_INTENT_NOT_SET) | ((bArr[1] & FastPairConstants.GO_INTENT_NOT_SET) << 8) | ((bArr[2] & FastPairConstants.GO_INTENT_NOT_SET) << 16);
    }

    public static List<String> c(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    public static byte[] d(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }
}
