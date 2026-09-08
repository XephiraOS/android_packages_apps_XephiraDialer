package F7;

/* compiled from: LunarUtils.java */
/* loaded from: classes3.dex */
public class c {
    public static void a(int[] iArr, int[] iArr2) {
        if (iArr != null && iArr.length >= 3 && iArr2 != null && iArr2.length >= 3) {
            int i10 = iArr[0];
            if (i10 == Integer.MIN_VALUE) {
                iArr2[0] = 1900;
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[2];
                return;
            }
            int i11 = iArr[1];
            int e10 = D7.a.e(Integer.valueOf(i10));
            if (e10 > 0 && e10 < 13 && (i11 > e10 || (i11 == e10 && iArr[3] == 0))) {
                i11++;
            }
            int[] b10 = D7.a.b(Integer.valueOf(iArr[0]), Integer.valueOf(i11), Integer.valueOf(iArr[2]));
            iArr2[0] = b10[0];
            iArr2[1] = b10[1];
            iArr2[2] = b10[2];
        }
    }
}
