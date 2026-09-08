package K9;

import java.io.FilterOutputStream;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Base64OutputStream.java */
/* loaded from: classes4.dex */
public class b extends FilterOutputStream {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1687b;

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1686a = {13, 10};

    /* renamed from: c, reason: collision with root package name */
    public static final Set<Byte> f1688c = new HashSet();

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f1687b = bArr;
        for (byte b10 : bArr) {
            f1688c.add(Byte.valueOf(b10));
        }
        f1688c.add((byte) 61);
    }
}
