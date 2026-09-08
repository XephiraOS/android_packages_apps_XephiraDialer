package P9;

import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: EOLConvertingInputStream.java */
/* loaded from: classes4.dex */
public class b extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public PushbackInputStream f2980a;

    /* renamed from: b, reason: collision with root package name */
    public int f2981b;

    /* renamed from: c, reason: collision with root package name */
    public int f2982c;

    public b(InputStream inputStream) {
        this(inputStream, 3);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2980a.close();
    }

    @Override // java.io.InputStream
    public int read() {
        int read = this.f2980a.read();
        if (read == -1) {
            return -1;
        }
        int i10 = this.f2982c;
        if ((i10 & 1) != 0 && read == 13) {
            int read2 = this.f2980a.read();
            if (read2 != -1) {
                this.f2980a.unread(read2);
            }
            if (read2 != 10) {
                this.f2980a.unread(10);
            }
        } else if ((i10 & 2) != 0 && read == 10 && this.f2981b != 13) {
            this.f2980a.unread(10);
            read = 13;
        }
        this.f2981b = read;
        return read;
    }

    public b(InputStream inputStream, int i10) {
        this.f2980a = null;
        this.f2981b = 0;
        this.f2982c = 3;
        this.f2980a = new PushbackInputStream(inputStream, 2);
        this.f2982c = i10;
    }
}
