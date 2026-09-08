package N5;

/* compiled from: ParseUtils.java */
/* loaded from: classes3.dex */
public class f {
    public static byte[] a(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[(bArr.length - i10) - 9];
        h.a(bArr, 1, bArr2, 0, (bArr.length - i10) - 9);
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[4];
        h.a(bArr, (bArr.length - i10) - 8, bArr2, 0, 4);
        return bArr2;
    }

    public static byte[] c(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[i10];
        h.a(bArr, (bArr.length - i10) - 4, bArr2, 0, i10);
        return bArr2;
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        h.a(bArr, bArr.length - 4, bArr2, 0, 4);
        return bArr2;
    }

    public static byte[] e(byte[] bArr) {
        return new byte[]{bArr[0]};
    }
}
