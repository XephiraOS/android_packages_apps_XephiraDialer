package okio;

import G9.a;
import H9.c;
import kotlin.collections.C1228i;
import kotlin.jvm.internal.i;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes4.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: e, reason: collision with root package name */
    public final transient byte[][] f35790e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int[] f35791f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.f35787d.d());
        i.f(segments, "segments");
        i.f(directory, "directory");
        this.f35790e = segments;
        this.f35791f = directory;
    }

    private final Object writeReplace() {
        ByteString u10 = u();
        i.d(u10, "null cannot be cast to non-null type java.lang.Object");
        return u10;
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.o() == o() && k(0, byteString, 0, o())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public int f() {
        return r()[s().length - 1];
    }

    @Override // okio.ByteString
    public String h() {
        return u().h();
    }

    @Override // okio.ByteString
    public int hashCode() {
        int e10 = e();
        if (e10 == 0) {
            int length = s().length;
            int i10 = 0;
            int i11 = 1;
            int i12 = 0;
            while (i10 < length) {
                int i13 = r()[length + i10];
                int i14 = r()[i10];
                byte[] bArr = s()[i10];
                int i15 = (i14 - i12) + i13;
                while (i13 < i15) {
                    i11 = (i11 * 31) + bArr[i13];
                    i13++;
                }
                i10++;
                i12 = i14;
            }
            m(i11);
            return i11;
        }
        return e10;
    }

    @Override // okio.ByteString
    public byte[] i() {
        return t();
    }

    @Override // okio.ByteString
    public byte j(int i10) {
        int i11;
        a.b(r()[s().length - 1], i10, 1L);
        int b10 = c.b(this, i10);
        if (b10 == 0) {
            i11 = 0;
        } else {
            i11 = r()[b10 - 1];
        }
        return s()[b10][(i10 - i11) + r()[s().length + b10]];
    }

    @Override // okio.ByteString
    public boolean k(int i10, ByteString other, int i11, int i12) {
        int i13;
        i.f(other, "other");
        if (i10 < 0 || i10 > o() - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int b10 = c.b(this, i10);
        while (i10 < i14) {
            if (b10 == 0) {
                i13 = 0;
            } else {
                i13 = r()[b10 - 1];
            }
            int i15 = r()[b10] - i13;
            int i16 = r()[s().length + b10];
            int min = Math.min(i14, i15 + i13) - i10;
            if (!other.l(i11, s()[b10], i16 + (i10 - i13), min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            b10++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean l(int i10, byte[] other, int i11, int i12) {
        int i13;
        i.f(other, "other");
        if (i10 < 0 || i10 > o() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i14 = i12 + i10;
        int b10 = c.b(this, i10);
        while (i10 < i14) {
            if (b10 == 0) {
                i13 = 0;
            } else {
                i13 = r()[b10 - 1];
            }
            int i15 = r()[b10] - i13;
            int i16 = r()[s().length + b10];
            int min = Math.min(i14, i15 + i13) - i10;
            if (!a.a(s()[b10], i16 + (i10 - i13), other, i11, min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            b10++;
        }
        return true;
    }

    public final int[] r() {
        return this.f35791f;
    }

    public final byte[][] s() {
        return this.f35790e;
    }

    public byte[] t() {
        byte[] bArr = new byte[o()];
        int length = s().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = r()[length + i10];
            int i14 = r()[i10];
            int i15 = i14 - i11;
            C1228i.g(s()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return u().toString();
    }

    public final ByteString u() {
        return new ByteString(t());
    }
}
