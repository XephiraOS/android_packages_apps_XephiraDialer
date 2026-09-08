package k6;

/* compiled from: JsonScope.java */
/* renamed from: k6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1215a {
    public static String a(int i10, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11];
            if (i12 != 1 && i12 != 2) {
                if (i12 == 3 || i12 == 4 || i12 == 5) {
                    sb.append('.');
                    String str = strArr[i11];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append('[');
                sb.append(iArr2[i11]);
                sb.append(']');
            }
        }
        return sb.toString();
    }
}
