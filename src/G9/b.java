package G9;

import com.heytap.accessory.constant.FastPairConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.C1228i;
import okio.ByteString;
import okio.SegmentedByteString;

/* compiled from: Buffer.kt */
/* loaded from: classes4.dex */
public final class b implements d, c, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public l f1127a;

    /* renamed from: b, reason: collision with root package name */
    public long f1128b;

    /* compiled from: Buffer.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        public b f1129a;

        /* renamed from: b, reason: collision with root package name */
        public l f1130b;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f1132d;

        /* renamed from: c, reason: collision with root package name */
        public long f1131c = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f1133e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f1134f = -1;

        public final void a(l lVar) {
            this.f1130b = lVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f1129a != null) {
                this.f1129a = null;
                a(null);
                this.f1131c = -1L;
                this.f1132d = null;
                this.f1133e = -1;
                this.f1134f = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    @Override // G9.d
    public long A(ByteString targetBytes) {
        kotlin.jvm.internal.i.f(targetBytes, "targetBytes");
        return r(targetBytes, 0L);
    }

    public ByteString B(long j10) {
        if (j10 >= 0 && j10 <= 2147483647L) {
            if (U() >= j10) {
                if (j10 >= 4096) {
                    ByteString Z9 = Z((int) j10);
                    V(j10);
                    return Z9;
                }
                return new ByteString(u(j10));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j10).toString());
    }

    @Override // G9.d
    public int E(i options) {
        kotlin.jvm.internal.i.f(options, "options");
        int c10 = H9.a.c(this, options, false, 2, null);
        if (c10 == -1) {
            return -1;
        }
        V(options.g()[c10].o());
        return c10;
    }

    public void G(byte[] sink) {
        kotlin.jvm.internal.i.f(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int s10 = s(sink, i10, sink.length - i10);
            if (s10 != -1) {
                i10 += s10;
            } else {
                throw new EOFException();
            }
        }
    }

    public int I() {
        if (U() >= 4) {
            l lVar = this.f1127a;
            kotlin.jvm.internal.i.c(lVar);
            int i10 = lVar.f1154b;
            int i11 = lVar.f1155c;
            if (i11 - i10 < 4) {
                return (readByte() & FastPairConstants.GO_INTENT_NOT_SET) | ((readByte() & FastPairConstants.GO_INTENT_NOT_SET) << 24) | ((readByte() & FastPairConstants.GO_INTENT_NOT_SET) << 16) | ((readByte() & FastPairConstants.GO_INTENT_NOT_SET) << 8);
            }
            byte[] bArr = lVar.f1153a;
            int i12 = i10 + 3;
            int i13 = ((bArr[i10 + 1] & FastPairConstants.GO_INTENT_NOT_SET) << 16) | ((bArr[i10] & FastPairConstants.GO_INTENT_NOT_SET) << 24) | ((bArr[i10 + 2] & FastPairConstants.GO_INTENT_NOT_SET) << 8);
            int i14 = i10 + 4;
            int i15 = (bArr[i12] & FastPairConstants.GO_INTENT_NOT_SET) | i13;
            T(U() - 4);
            if (i14 == i11) {
                this.f1127a = lVar.b();
                m.b(lVar);
            } else {
                lVar.f1154b = i14;
            }
            return i15;
        }
        throw new EOFException();
    }

    public String L(long j10, Charset charset) {
        kotlin.jvm.internal.i.f(charset, "charset");
        if (j10 >= 0 && j10 <= 2147483647L) {
            if (this.f1128b >= j10) {
                if (j10 == 0) {
                    return "";
                }
                l lVar = this.f1127a;
                kotlin.jvm.internal.i.c(lVar);
                int i10 = lVar.f1154b;
                if (i10 + j10 > lVar.f1155c) {
                    return new String(u(j10), charset);
                }
                int i11 = (int) j10;
                String str = new String(lVar.f1153a, i10, i11, charset);
                int i12 = lVar.f1154b + i11;
                lVar.f1154b = i12;
                this.f1128b -= j10;
                if (i12 == lVar.f1155c) {
                    this.f1127a = lVar.b();
                    m.b(lVar);
                }
                return str;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j10).toString());
    }

    public String O() {
        return L(this.f1128b, kotlin.text.d.f34284b);
    }

    public String S(long j10) {
        return L(j10, kotlin.text.d.f34284b);
    }

    public final void T(long j10) {
        this.f1128b = j10;
    }

    public final long U() {
        return this.f1128b;
    }

    public void V(long j10) {
        while (j10 > 0) {
            l lVar = this.f1127a;
            if (lVar != null) {
                int min = (int) Math.min(j10, lVar.f1155c - lVar.f1154b);
                long j11 = min;
                T(U() - j11);
                j10 -= j11;
                int i10 = lVar.f1154b + min;
                lVar.f1154b = i10;
                if (i10 == lVar.f1155c) {
                    this.f1127a = lVar.b();
                    m.b(lVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // G9.d
    public boolean W(long j10) {
        if (this.f1128b >= j10) {
            return true;
        }
        return false;
    }

    public final ByteString X() {
        if (U() <= 2147483647L) {
            return Z((int) U());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + U()).toString());
    }

    public final ByteString Z(int i10) {
        if (i10 == 0) {
            return ByteString.f35787d;
        }
        G9.a.b(U(), 0L, i10);
        l lVar = this.f1127a;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            kotlin.jvm.internal.i.c(lVar);
            int i14 = lVar.f1155c;
            int i15 = lVar.f1154b;
            if (i14 != i15) {
                i12 += i14 - i15;
                i13++;
                lVar = lVar.f1158f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i13];
        int[] iArr = new int[i13 * 2];
        l lVar2 = this.f1127a;
        int i16 = 0;
        while (i11 < i10) {
            kotlin.jvm.internal.i.c(lVar2);
            bArr[i16] = lVar2.f1153a;
            i11 += lVar2.f1155c - lVar2.f1154b;
            iArr[i16] = Math.min(i11, i10);
            iArr[i16 + i13] = lVar2.f1154b;
            lVar2.f1156d = true;
            i16++;
            lVar2 = lVar2.f1158f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public final void a() {
        V(U());
    }

    public final l a0(int i10) {
        if (i10 >= 1 && i10 <= 8192) {
            l lVar = this.f1127a;
            if (lVar == null) {
                l c10 = m.c();
                this.f1127a = c10;
                c10.f1159g = c10;
                c10.f1158f = c10;
                return c10;
            }
            kotlin.jvm.internal.i.c(lVar);
            l lVar2 = lVar.f1159g;
            kotlin.jvm.internal.i.c(lVar2);
            if (lVar2.f1155c + i10 > 8192 || !lVar2.f1157e) {
                lVar2 = lVar2.c(m.c());
            }
            return lVar2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return e();
    }

    public void c0(b source, long j10) {
        l lVar;
        int i10;
        kotlin.jvm.internal.i.f(source, "source");
        if (source != this) {
            G9.a.b(source.U(), 0L, j10);
            while (j10 > 0) {
                l lVar2 = source.f1127a;
                kotlin.jvm.internal.i.c(lVar2);
                int i11 = lVar2.f1155c;
                kotlin.jvm.internal.i.c(source.f1127a);
                if (j10 < i11 - r1.f1154b) {
                    l lVar3 = this.f1127a;
                    if (lVar3 != null) {
                        kotlin.jvm.internal.i.c(lVar3);
                        lVar = lVar3.f1159g;
                    } else {
                        lVar = null;
                    }
                    if (lVar != null && lVar.f1157e) {
                        long j11 = lVar.f1155c + j10;
                        if (lVar.f1156d) {
                            i10 = 0;
                        } else {
                            i10 = lVar.f1154b;
                        }
                        if (j11 - i10 <= 8192) {
                            l lVar4 = source.f1127a;
                            kotlin.jvm.internal.i.c(lVar4);
                            lVar4.f(lVar, (int) j10);
                            source.T(source.U() - j10);
                            T(U() + j10);
                            return;
                        }
                    }
                    l lVar5 = source.f1127a;
                    kotlin.jvm.internal.i.c(lVar5);
                    source.f1127a = lVar5.e((int) j10);
                }
                l lVar6 = source.f1127a;
                kotlin.jvm.internal.i.c(lVar6);
                long j12 = lVar6.f1155c - lVar6.f1154b;
                source.f1127a = lVar6.b();
                l lVar7 = this.f1127a;
                if (lVar7 == null) {
                    this.f1127a = lVar6;
                    lVar6.f1159g = lVar6;
                    lVar6.f1158f = lVar6;
                } else {
                    kotlin.jvm.internal.i.c(lVar7);
                    l lVar8 = lVar7.f1159g;
                    kotlin.jvm.internal.i.c(lVar8);
                    lVar8.c(lVar6).a();
                }
                source.T(source.U() - j12);
                T(U() + j12);
                j10 -= j12;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public final b e() {
        b bVar = new b();
        if (U() != 0) {
            l lVar = this.f1127a;
            kotlin.jvm.internal.i.c(lVar);
            l d10 = lVar.d();
            bVar.f1127a = d10;
            d10.f1159g = d10;
            d10.f1158f = d10;
            for (l lVar2 = lVar.f1158f; lVar2 != lVar; lVar2 = lVar2.f1158f) {
                l lVar3 = d10.f1159g;
                kotlin.jvm.internal.i.c(lVar3);
                kotlin.jvm.internal.i.c(lVar2);
                lVar3.c(lVar2.d());
            }
            bVar.T(U());
        }
        return bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (U() == bVar.U()) {
                if (U() == 0) {
                    return true;
                }
                l lVar = this.f1127a;
                kotlin.jvm.internal.i.c(lVar);
                l lVar2 = bVar.f1127a;
                kotlin.jvm.internal.i.c(lVar2);
                int i10 = lVar.f1154b;
                int i11 = lVar2.f1154b;
                long j10 = 0;
                while (j10 < U()) {
                    long min = Math.min(lVar.f1155c - i10, lVar2.f1155c - i11);
                    long j11 = 0;
                    while (j11 < min) {
                        int i12 = i10 + 1;
                        int i13 = i11 + 1;
                        if (lVar.f1153a[i10] == lVar2.f1153a[i11]) {
                            j11++;
                            i10 = i12;
                            i11 = i13;
                        }
                    }
                    if (i10 == lVar.f1155c) {
                        lVar = lVar.f1158f;
                        kotlin.jvm.internal.i.c(lVar);
                        i10 = lVar.f1154b;
                    }
                    if (i11 == lVar2.f1155c) {
                        lVar2 = lVar2.f1158f;
                        kotlin.jvm.internal.i.c(lVar2);
                        i11 = lVar2.f1154b;
                    }
                    j10 += min;
                }
                return true;
            }
        }
        return false;
    }

    public final b f(b out, long j10, long j11) {
        kotlin.jvm.internal.i.f(out, "out");
        G9.a.b(U(), j10, j11);
        if (j11 != 0) {
            out.T(out.U() + j11);
            l lVar = this.f1127a;
            while (true) {
                kotlin.jvm.internal.i.c(lVar);
                int i10 = lVar.f1155c;
                int i11 = lVar.f1154b;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= i10 - i11;
                lVar = lVar.f1158f;
            }
            while (j11 > 0) {
                kotlin.jvm.internal.i.c(lVar);
                l d10 = lVar.d();
                int i12 = d10.f1154b + ((int) j10);
                d10.f1154b = i12;
                d10.f1155c = Math.min(i12 + ((int) j11), d10.f1155c);
                l lVar2 = out.f1127a;
                if (lVar2 == null) {
                    d10.f1159g = d10;
                    d10.f1158f = d10;
                    out.f1127a = d10;
                } else {
                    kotlin.jvm.internal.i.c(lVar2);
                    l lVar3 = lVar2.f1159g;
                    kotlin.jvm.internal.i.c(lVar3);
                    lVar3.c(d10);
                }
                j11 -= d10.f1155c - d10.f1154b;
                lVar = lVar.f1158f;
                j10 = 0;
            }
        }
        return this;
    }

    public long f0(n source) {
        kotlin.jvm.internal.i.f(source, "source");
        long j10 = 0;
        while (true) {
            long z10 = source.z(this, 8192L);
            if (z10 != -1) {
                j10 += z10;
            } else {
                return j10;
            }
        }
    }

    public boolean g() {
        if (this.f1128b == 0) {
            return true;
        }
        return false;
    }

    @Override // G9.c
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public b x(int i10) {
        l a02 = a0(1);
        byte[] bArr = a02.f1153a;
        int i11 = a02.f1155c;
        a02.f1155c = i11 + 1;
        bArr[i11] = (byte) i10;
        T(U() + 1);
        return this;
    }

    public b h0(int i10) {
        l a02 = a0(4);
        byte[] bArr = a02.f1153a;
        int i11 = a02.f1155c;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        a02.f1155c = i11 + 4;
        T(U() + 4);
        return this;
    }

    public int hashCode() {
        l lVar = this.f1127a;
        if (lVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = lVar.f1155c;
            for (int i12 = lVar.f1154b; i12 < i11; i12++) {
                i10 = (i10 * 31) + lVar.f1153a[i12];
            }
            lVar = lVar.f1158f;
            kotlin.jvm.internal.i.c(lVar);
        } while (lVar != this.f1127a);
        return i10;
    }

    @Override // G9.c
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public b K(String string) {
        kotlin.jvm.internal.i.f(string, "string");
        return R(string, 0, string.length());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // G9.c
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b R(String string, int i10, int i11) {
        char charAt;
        char c10;
        kotlin.jvm.internal.i.f(string, "string");
        if (i10 >= 0) {
            if (i11 >= i10) {
                if (i11 <= string.length()) {
                    while (i10 < i11) {
                        char charAt2 = string.charAt(i10);
                        if (charAt2 < 128) {
                            l a02 = a0(1);
                            byte[] bArr = a02.f1153a;
                            int i12 = a02.f1155c - i10;
                            int min = Math.min(i11, 8192 - i12);
                            int i13 = i10 + 1;
                            bArr[i10 + i12] = (byte) charAt2;
                            while (true) {
                                i10 = i13;
                                if (i10 >= min || (charAt = string.charAt(i10)) >= 128) {
                                    break;
                                }
                                i13 = i10 + 1;
                                bArr[i10 + i12] = (byte) charAt;
                            }
                            int i14 = a02.f1155c;
                            int i15 = (i12 + i10) - i14;
                            a02.f1155c = i14 + i15;
                            T(U() + i15);
                        } else {
                            if (charAt2 < 2048) {
                                l a03 = a0(2);
                                byte[] bArr2 = a03.f1153a;
                                int i16 = a03.f1155c;
                                bArr2[i16] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i16 + 1] = (byte) ((charAt2 & '?') | 128);
                                a03.f1155c = i16 + 2;
                                T(U() + 2);
                            } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                                int i17 = i10 + 1;
                                if (i17 < i11) {
                                    c10 = string.charAt(i17);
                                } else {
                                    c10 = 0;
                                }
                                if (charAt2 <= 56319 && 56320 <= c10 && c10 < 57344) {
                                    int i18 = (((charAt2 & 1023) << 10) | (c10 & 1023)) + 65536;
                                    l a04 = a0(4);
                                    byte[] bArr3 = a04.f1153a;
                                    int i19 = a04.f1155c;
                                    bArr3[i19] = (byte) ((i18 >> 18) | 240);
                                    bArr3[i19 + 1] = (byte) (((i18 >> 12) & 63) | 128);
                                    bArr3[i19 + 2] = (byte) (((i18 >> 6) & 63) | 128);
                                    bArr3[i19 + 3] = (byte) ((i18 & 63) | 128);
                                    a04.f1155c = i19 + 4;
                                    T(U() + 4);
                                    i10 += 2;
                                } else {
                                    x(63);
                                    i10 = i17;
                                }
                            } else {
                                l a05 = a0(3);
                                byte[] bArr4 = a05.f1153a;
                                int i20 = a05.f1155c;
                                bArr4[i20] = (byte) ((charAt2 >> '\f') | 224);
                                bArr4[i20 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr4[i20 + 2] = (byte) ((charAt2 & '?') | 128);
                                a05.f1155c = i20 + 3;
                                T(U() + 3);
                            }
                            i10++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + string.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
    }

    public final byte l(long j10) {
        G9.a.b(U(), j10, 1L);
        l lVar = this.f1127a;
        if (lVar != null) {
            if (U() - j10 < j10) {
                long U10 = U();
                while (U10 > j10) {
                    lVar = lVar.f1159g;
                    kotlin.jvm.internal.i.c(lVar);
                    U10 -= lVar.f1155c - lVar.f1154b;
                }
                kotlin.jvm.internal.i.c(lVar);
                return lVar.f1153a[(int) ((lVar.f1154b + j10) - U10)];
            }
            long j11 = 0;
            while (true) {
                long j12 = (lVar.f1155c - lVar.f1154b) + j11;
                if (j12 <= j10) {
                    lVar = lVar.f1158f;
                    kotlin.jvm.internal.i.c(lVar);
                    j11 = j12;
                } else {
                    kotlin.jvm.internal.i.c(lVar);
                    return lVar.f1153a[(int) ((lVar.f1154b + j10) - j11)];
                }
            }
        } else {
            kotlin.jvm.internal.i.c(null);
            throw null;
        }
    }

    public long o(ByteString bytes, long j10) {
        long j11;
        int i10;
        long j12 = j10;
        kotlin.jvm.internal.i.f(bytes, "bytes");
        if (bytes.o() > 0) {
            long j13 = 0;
            if (j12 >= 0) {
                l lVar = this.f1127a;
                if (lVar != null) {
                    if (U() - j12 < j12) {
                        j11 = U();
                        while (j11 > j12) {
                            lVar = lVar.f1159g;
                            kotlin.jvm.internal.i.c(lVar);
                            j11 -= lVar.f1155c - lVar.f1154b;
                        }
                        byte[] i11 = bytes.i();
                        byte b10 = i11[0];
                        int o10 = bytes.o();
                        long U10 = (U() - o10) + 1;
                        while (j11 < U10) {
                            byte[] bArr = lVar.f1153a;
                            int min = (int) Math.min(lVar.f1155c, (lVar.f1154b + U10) - j11);
                            i10 = (int) ((lVar.f1154b + j12) - j11);
                            while (i10 < min) {
                                if (bArr[i10] == b10 && H9.a.a(lVar, i10 + 1, i11, 1, o10)) {
                                    return (i10 - lVar.f1154b) + j11;
                                }
                                i10++;
                            }
                            j11 += lVar.f1155c - lVar.f1154b;
                            lVar = lVar.f1158f;
                            kotlin.jvm.internal.i.c(lVar);
                            j12 = j11;
                        }
                    } else {
                        while (true) {
                            long j14 = (lVar.f1155c - lVar.f1154b) + j13;
                            if (j14 > j12) {
                                break;
                            }
                            lVar = lVar.f1158f;
                            kotlin.jvm.internal.i.c(lVar);
                            j13 = j14;
                        }
                        byte[] i12 = bytes.i();
                        byte b11 = i12[0];
                        int o11 = bytes.o();
                        long U11 = (U() - o11) + 1;
                        j11 = j13;
                        while (j11 < U11) {
                            byte[] bArr2 = lVar.f1153a;
                            long j15 = U11;
                            int min2 = (int) Math.min(lVar.f1155c, (lVar.f1154b + U11) - j11);
                            i10 = (int) ((lVar.f1154b + j12) - j11);
                            while (i10 < min2) {
                                if (bArr2[i10] == b11 && H9.a.a(lVar, i10 + 1, i12, 1, o11)) {
                                    return (i10 - lVar.f1154b) + j11;
                                }
                                i10++;
                            }
                            j11 += lVar.f1155c - lVar.f1154b;
                            lVar = lVar.f1158f;
                            kotlin.jvm.internal.i.c(lVar);
                            U11 = j15;
                            j12 = j11;
                        }
                    }
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j12).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // G9.d
    public InputStream p0() {
        return new C0022b();
    }

    @Override // G9.d
    public d peek() {
        return f.a(new j(this));
    }

    public long r(ByteString targetBytes, long j10) {
        int i10;
        int i11;
        kotlin.jvm.internal.i.f(targetBytes, "targetBytes");
        long j11 = 0;
        if (j10 >= 0) {
            l lVar = this.f1127a;
            if (lVar == null) {
                return -1L;
            }
            if (U() - j10 < j10) {
                j11 = U();
                while (j11 > j10) {
                    lVar = lVar.f1159g;
                    kotlin.jvm.internal.i.c(lVar);
                    j11 -= lVar.f1155c - lVar.f1154b;
                }
                if (targetBytes.o() == 2) {
                    byte c10 = targetBytes.c(0);
                    byte c11 = targetBytes.c(1);
                    while (j11 < U()) {
                        byte[] bArr = lVar.f1153a;
                        i10 = (int) ((lVar.f1154b + j10) - j11);
                        int i12 = lVar.f1155c;
                        while (i10 < i12) {
                            byte b10 = bArr[i10];
                            if (b10 != c10 && b10 != c11) {
                                i10++;
                            }
                            i11 = lVar.f1154b;
                        }
                        j11 += lVar.f1155c - lVar.f1154b;
                        lVar = lVar.f1158f;
                        kotlin.jvm.internal.i.c(lVar);
                        j10 = j11;
                    }
                    return -1L;
                }
                byte[] i13 = targetBytes.i();
                while (j11 < U()) {
                    byte[] bArr2 = lVar.f1153a;
                    i10 = (int) ((lVar.f1154b + j10) - j11);
                    int i14 = lVar.f1155c;
                    while (i10 < i14) {
                        byte b11 = bArr2[i10];
                        for (byte b12 : i13) {
                            if (b11 == b12) {
                                i11 = lVar.f1154b;
                            }
                        }
                        i10++;
                    }
                    j11 += lVar.f1155c - lVar.f1154b;
                    lVar = lVar.f1158f;
                    kotlin.jvm.internal.i.c(lVar);
                    j10 = j11;
                }
                return -1L;
            }
            while (true) {
                long j12 = (lVar.f1155c - lVar.f1154b) + j11;
                if (j12 > j10) {
                    break;
                }
                lVar = lVar.f1158f;
                kotlin.jvm.internal.i.c(lVar);
                j11 = j12;
            }
            if (targetBytes.o() == 2) {
                byte c12 = targetBytes.c(0);
                byte c13 = targetBytes.c(1);
                while (j11 < U()) {
                    byte[] bArr3 = lVar.f1153a;
                    i10 = (int) ((lVar.f1154b + j10) - j11);
                    int i15 = lVar.f1155c;
                    while (i10 < i15) {
                        byte b13 = bArr3[i10];
                        if (b13 != c12 && b13 != c13) {
                            i10++;
                        }
                        i11 = lVar.f1154b;
                    }
                    j11 += lVar.f1155c - lVar.f1154b;
                    lVar = lVar.f1158f;
                    kotlin.jvm.internal.i.c(lVar);
                    j10 = j11;
                }
                return -1L;
            }
            byte[] i16 = targetBytes.i();
            while (j11 < U()) {
                byte[] bArr4 = lVar.f1153a;
                i10 = (int) ((lVar.f1154b + j10) - j11);
                int i17 = lVar.f1155c;
                while (i10 < i17) {
                    byte b14 = bArr4[i10];
                    for (byte b15 : i16) {
                        if (b14 == b15) {
                            i11 = lVar.f1154b;
                        }
                    }
                    i10++;
                }
                j11 += lVar.f1155c - lVar.f1154b;
                lVar = lVar.f1158f;
                kotlin.jvm.internal.i.c(lVar);
                j10 = j11;
            }
            return -1L;
            return (i10 - i11) + j11;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j10).toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.i.f(sink, "sink");
        l lVar = this.f1127a;
        if (lVar == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), lVar.f1155c - lVar.f1154b);
        sink.put(lVar.f1153a, lVar.f1154b, min);
        int i10 = lVar.f1154b + min;
        lVar.f1154b = i10;
        this.f1128b -= min;
        if (i10 == lVar.f1155c) {
            this.f1127a = lVar.b();
            m.b(lVar);
        }
        return min;
    }

    @Override // G9.d
    public byte readByte() {
        if (U() != 0) {
            l lVar = this.f1127a;
            kotlin.jvm.internal.i.c(lVar);
            int i10 = lVar.f1154b;
            int i11 = lVar.f1155c;
            int i12 = i10 + 1;
            byte b10 = lVar.f1153a[i10];
            T(U() - 1);
            if (i12 == i11) {
                this.f1127a = lVar.b();
                m.b(lVar);
            } else {
                lVar.f1154b = i12;
            }
            return b10;
        }
        throw new EOFException();
    }

    public int s(byte[] sink, int i10, int i11) {
        kotlin.jvm.internal.i.f(sink, "sink");
        G9.a.b(sink.length, i10, i11);
        l lVar = this.f1127a;
        if (lVar == null) {
            return -1;
        }
        int min = Math.min(i11, lVar.f1155c - lVar.f1154b);
        byte[] bArr = lVar.f1153a;
        int i12 = lVar.f1154b;
        C1228i.g(bArr, sink, i10, i12, i12 + min);
        lVar.f1154b += min;
        T(U() - min);
        if (lVar.f1154b == lVar.f1155c) {
            this.f1127a = lVar.b();
            m.b(lVar);
        }
        return min;
    }

    public String toString() {
        return X().toString();
    }

    public byte[] u(long j10) {
        if (j10 >= 0 && j10 <= 2147483647L) {
            if (U() >= j10) {
                byte[] bArr = new byte[(int) j10];
                G(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(("byteCount: " + j10).toString());
    }

    @Override // G9.d
    public long v(ByteString bytes) {
        kotlin.jvm.internal.i.f(bytes, "bytes");
        return o(bytes, 0L);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.i.f(source, "source");
        int remaining = source.remaining();
        int i10 = remaining;
        while (i10 > 0) {
            l a02 = a0(1);
            int min = Math.min(i10, 8192 - a02.f1155c);
            source.get(a02.f1153a, a02.f1155c, min);
            i10 -= min;
            a02.f1155c += min;
        }
        this.f1128b += remaining;
        return remaining;
    }

    public ByteString y() {
        return B(U());
    }

    @Override // G9.n
    public long z(b sink, long j10) {
        kotlin.jvm.internal.i.f(sink, "sink");
        if (j10 >= 0) {
            if (U() == 0) {
                return -1L;
            }
            if (j10 > U()) {
                j10 = U();
            }
            sink.c0(this, j10);
            return j10;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
    }

    /* compiled from: Buffer.kt */
    /* renamed from: G9.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0022b extends InputStream {
        public C0022b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(b.this.U(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream
        public int read() {
            if (b.this.U() > 0) {
                return b.this.readByte() & FastPairConstants.GO_INTENT_NOT_SET;
            }
            return -1;
        }

        public String toString() {
            return b.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int i10, int i11) {
            kotlin.jvm.internal.i.f(sink, "sink");
            return b.this.s(sink, i10, i11);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    @Override // G9.n, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // G9.d
    public b k() {
        return this;
    }

    @Override // G9.d
    public b w() {
        return this;
    }
}
