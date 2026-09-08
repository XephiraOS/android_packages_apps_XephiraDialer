package G9;

import G9.b;
import okio.ByteString;

/* compiled from: Util.kt */
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a f1125a = new b.a();

    /* renamed from: b, reason: collision with root package name */
    public static final int f1126b = -1234567890;

    public static final boolean a(byte[] a10, int i10, byte[] b10, int i11, int i12) {
        kotlin.jvm.internal.i.f(a10, "a");
        kotlin.jvm.internal.i.f(b10, "b");
        for (int i13 = 0; i13 < i12; i13++) {
            if (a10[i13 + i10] != b10[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j10, long j11, long j12) {
        if ((j11 | j12) >= 0 && j11 <= j10 && j10 - j11 >= j12) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
    }

    public static final int c(ByteString byteString, int i10) {
        kotlin.jvm.internal.i.f(byteString, "<this>");
        if (i10 == f1126b) {
            return byteString.o();
        }
        return i10;
    }
}
