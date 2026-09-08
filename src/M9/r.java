package m9;

/* compiled from: UnsignedUtils.kt */
/* loaded from: classes4.dex */
public final class r {
    public static final int a(int i10, int i11) {
        return kotlin.jvm.internal.i.g(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
    }

    public static final int b(long j10, long j11) {
        return kotlin.jvm.internal.i.h(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
    }

    public static final String c(long j10) {
        return d(j10, 10);
    }

    public static final String d(long j10, int i10) {
        int a10;
        int a11;
        int a12;
        if (j10 >= 0) {
            a12 = kotlin.text.b.a(i10);
            String l10 = Long.toString(j10, a12);
            kotlin.jvm.internal.i.e(l10, "toString(...)");
            return l10;
        }
        long j11 = i10;
        long j12 = ((j10 >>> 1) / j11) << 1;
        long j13 = j10 - (j12 * j11);
        if (j13 >= j11) {
            j13 -= j11;
            j12++;
        }
        StringBuilder sb = new StringBuilder();
        a10 = kotlin.text.b.a(i10);
        String l11 = Long.toString(j12, a10);
        kotlin.jvm.internal.i.e(l11, "toString(...)");
        sb.append(l11);
        a11 = kotlin.text.b.a(i10);
        String l12 = Long.toString(j13, a11);
        kotlin.jvm.internal.i.e(l12, "toString(...)");
        sb.append(l12);
        return sb.toString();
    }
}
