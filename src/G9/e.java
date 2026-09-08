package G9;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: JvmOkio.kt */
/* loaded from: classes4.dex */
public class e implements n {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f1136a;

    /* renamed from: b, reason: collision with root package name */
    public final o f1137b;

    public e(InputStream input, o timeout) {
        kotlin.jvm.internal.i.f(input, "input");
        kotlin.jvm.internal.i.f(timeout, "timeout");
        this.f1136a = input;
        this.f1137b = timeout;
    }

    @Override // G9.n, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.f1136a.close();
    }

    public String toString() {
        return "source(" + this.f1136a + ')';
    }

    @Override // G9.n
    public long z(b sink, long j10) {
        kotlin.jvm.internal.i.f(sink, "sink");
        if (j10 == 0) {
            return 0L;
        }
        if (j10 >= 0) {
            try {
                this.f1137b.a();
                l a02 = sink.a0(1);
                int read = this.f1136a.read(a02.f1153a, a02.f1155c, (int) Math.min(j10, 8192 - a02.f1155c));
                if (read == -1) {
                    if (a02.f1154b == a02.f1155c) {
                        sink.f1127a = a02.b();
                        m.b(a02);
                        return -1L;
                    }
                    return -1L;
                }
                a02.f1155c += read;
                long j11 = read;
                sink.T(sink.U() + j11);
                return j11;
            } catch (AssertionError e10) {
                if (f.b(e10)) {
                    throw new IOException(e10);
                }
                throw e10;
            }
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j10).toString());
    }
}
