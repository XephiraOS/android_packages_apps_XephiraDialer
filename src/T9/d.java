package T9;

import com.heytap.accessory.constant.FastPairConstants;

/* compiled from: ContentUtil.java */
/* loaded from: classes4.dex */
public class d {
    public static String a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return b(bVar, 0, bVar.length());
    }

    public static String b(b bVar, int i10, int i11) {
        if (bVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(i11);
        for (int i12 = i10; i12 < i10 + i11; i12++) {
            sb.append((char) (bVar.byteAt(i12) & FastPairConstants.GO_INTENT_NOT_SET));
        }
        return sb.toString();
    }

    public static b c(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a(str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            aVar.a((byte) str.charAt(i10));
        }
        return aVar;
    }
}
