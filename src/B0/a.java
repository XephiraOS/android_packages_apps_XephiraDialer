package B0;

/* compiled from: FormatUtils.java */
/* loaded from: classes.dex */
public class a {
    public static int[] a(CharSequence charSequence, char[] cArr) {
        int[] iArr = {-1, 0};
        if (cArr != null && charSequence != null) {
            int length = charSequence.length();
            int length2 = cArr.length;
            if (length2 != 0 && length >= length2) {
                for (int i10 = 0; i10 < length; i10++) {
                    if (i10 + length2 > length) {
                        iArr[0] = -1;
                        return iArr;
                    }
                    int i11 = 0;
                    while (i11 < length2 && Character.toUpperCase(charSequence.charAt(i10 + i11)) == cArr[i11]) {
                        i11++;
                    }
                    if (i11 == length2) {
                        iArr[0] = i10;
                        return iArr;
                    }
                }
                iArr[0] = -1;
                return iArr;
            }
            iArr[0] = -1;
            return iArr;
        }
        iArr[0] = -1;
        return iArr;
    }

    public static String b(String str) {
        return str.replace("'", "").replace("*", "").replace("-", "").replace("\"", "").replace("_", "");
    }

    public static String c(String str, int i10, int i11, int i12) {
        try {
            return str.substring(str.offsetByCodePoints(i10, i11), str.offsetByCodePoints(i10, i12));
        } catch (Exception unused) {
            return str.substring(i11, i12);
        }
    }
}
