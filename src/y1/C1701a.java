package y1;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/* compiled from: Utility.java */
/* renamed from: y1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1701a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f38119a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f38120b = new String[0];

    public static String a(Object[] objArr, char c10) {
        if (objArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < objArr.length; i10++) {
            sb.append(objArr[i10].toString());
            if (i10 < objArr.length - 1) {
                sb.append(c10);
            }
        }
        return sb.toString();
    }

    public static String b(Charset charset, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        CharBuffer decode = charset.decode(ByteBuffer.wrap(bArr));
        return new String(decode.array(), 0, decode.length());
    }

    public static byte[] c(Charset charset, String str) {
        if (str == null) {
            return null;
        }
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        byte[] bArr = new byte[encode.limit()];
        encode.get(bArr);
        return bArr;
    }

    public static String d(byte[] bArr) {
        return b(f38119a, bArr);
    }

    public static ByteArrayInputStream e(String str) {
        return new ByteArrayInputStream(f(str));
    }

    public static byte[] f(String str) {
        return c(f38119a, str);
    }
}
