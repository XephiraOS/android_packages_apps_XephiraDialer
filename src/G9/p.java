package G9;

/* compiled from: -JvmPlatform.kt */
/* loaded from: classes4.dex */
public final class p {
    public static final byte[] a(String str) {
        kotlin.jvm.internal.i.f(str, "<this>");
        byte[] bytes = str.getBytes(kotlin.text.d.f34284b);
        kotlin.jvm.internal.i.e(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        kotlin.jvm.internal.i.f(bArr, "<this>");
        return new String(bArr, kotlin.text.d.f34284b);
    }
}
