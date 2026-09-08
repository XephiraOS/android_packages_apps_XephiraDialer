package G9;

import com.heytap.accessory.constant.FastPairConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import okio.ByteString;

/* compiled from: RealBufferedSource.kt */
/* loaded from: classes4.dex */
public final class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final n f1148a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1149b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1150c;

    public k(n source) {
        kotlin.jvm.internal.i.f(source, "source");
        this.f1148a = source;
        this.f1149b = new b();
    }

    @Override // G9.d
    public long A(ByteString targetBytes) {
        kotlin.jvm.internal.i.f(targetBytes, "targetBytes");
        return c(targetBytes, 0L);
    }

    @Override // G9.d
    public int E(i options) {
        kotlin.jvm.internal.i.f(options, "options");
        if (!(!this.f1150c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int b10 = H9.a.b(this.f1149b, options, true);
            if (b10 != -2) {
                if (b10 != -1) {
                    this.f1149b.V(options.g()[b10].o());
                    return b10;
                }
            } else if (this.f1148a.z(this.f1149b, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // G9.d
    public boolean W(long j10) {
        if (j10 >= 0) {
            if (!(!this.f1150c)) {
                throw new IllegalStateException("closed".toString());
            }
            while (this.f1149b.U() < j10) {
                if (this.f1148a.z(this.f1149b, 8192L) == -1) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
    }

    public long a(ByteString bytes, long j10) {
        kotlin.jvm.internal.i.f(bytes, "bytes");
        if (!(!this.f1150c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long o10 = this.f1149b.o(bytes, j10);
            if (o10 == -1) {
                long U10 = this.f1149b.U();
                if (this.f1148a.z(this.f1149b, 8192L) == -1) {
                    return -1L;
                }
                j10 = Math.max(j10, (U10 - bytes.o()) + 1);
            } else {
                return o10;
            }
        }
    }

    public long c(ByteString targetBytes, long j10) {
        kotlin.jvm.internal.i.f(targetBytes, "targetBytes");
        if (!(!this.f1150c)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long r10 = this.f1149b.r(targetBytes, j10);
            if (r10 == -1) {
                long U10 = this.f1149b.U();
                if (this.f1148a.z(this.f1149b, 8192L) == -1) {
                    return -1L;
                }
                j10 = Math.max(j10, U10);
            } else {
                return r10;
            }
        }
    }

    @Override // G9.n, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        if (!this.f1150c) {
            this.f1150c = true;
            this.f1148a.close();
            this.f1149b.a();
        }
    }

    public void e(long j10) {
        if (W(j10)) {
        } else {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f1150c;
    }

    @Override // G9.d
    public b k() {
        return this.f1149b;
    }

    @Override // G9.d
    public InputStream p0() {
        return new a();
    }

    @Override // G9.d
    public d peek() {
        return f.a(new j(this));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.i.f(sink, "sink");
        if (this.f1149b.U() == 0 && this.f1148a.z(this.f1149b, 8192L) == -1) {
            return -1;
        }
        return this.f1149b.read(sink);
    }

    @Override // G9.d
    public byte readByte() {
        e(1L);
        return this.f1149b.readByte();
    }

    public String toString() {
        return "buffer(" + this.f1148a + ')';
    }

    @Override // G9.d
    public long v(ByteString bytes) {
        kotlin.jvm.internal.i.f(bytes, "bytes");
        return a(bytes, 0L);
    }

    @Override // G9.d
    public b w() {
        return this.f1149b;
    }

    @Override // G9.n
    public long z(b sink, long j10) {
        kotlin.jvm.internal.i.f(sink, "sink");
        if (j10 >= 0) {
            if (!this.f1150c) {
                if (this.f1149b.U() == 0 && this.f1148a.z(this.f1149b, 8192L) == -1) {
                    return -1L;
                }
                return this.f1149b.z(sink, Math.min(j10, this.f1149b.U()));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
    }

    /* compiled from: RealBufferedSource.kt */
    /* loaded from: classes4.dex */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() {
            k kVar = k.this;
            if (!kVar.f1150c) {
                return (int) Math.min(kVar.f1149b.U(), Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            k.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            k kVar = k.this;
            if (!kVar.f1150c) {
                if (kVar.f1149b.U() == 0) {
                    k kVar2 = k.this;
                    if (kVar2.f1148a.z(kVar2.f1149b, 8192L) == -1) {
                        return -1;
                    }
                }
                return k.this.f1149b.readByte() & FastPairConstants.GO_INTENT_NOT_SET;
            }
            throw new IOException("closed");
        }

        public String toString() {
            return k.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int i10, int i11) {
            kotlin.jvm.internal.i.f(data, "data");
            if (!k.this.f1150c) {
                G9.a.b(data.length, i10, i11);
                if (k.this.f1149b.U() == 0) {
                    k kVar = k.this;
                    if (kVar.f1148a.z(kVar.f1149b, 8192L) == -1) {
                        return -1;
                    }
                }
                return k.this.f1149b.s(data, i10, i11);
            }
            throw new IOException("closed");
        }
    }
}
