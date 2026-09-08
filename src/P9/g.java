package P9;

import java.io.FilterInputStream;
import java.io.InputStream;
import org.apache.james.mime4j.io.MaxLineLimitException;

/* compiled from: LineReaderInputStreamAdaptor.java */
/* loaded from: classes4.dex */
public class g extends f {

    /* renamed from: a, reason: collision with root package name */
    public final f f2985a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2986b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2987c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2988d;

    public g(InputStream inputStream, int i10) {
        super(inputStream);
        this.f2987c = false;
        this.f2988d = false;
        if (inputStream instanceof f) {
            this.f2985a = (f) inputStream;
        } else {
            this.f2985a = null;
        }
        this.f2986b = i10;
    }

    @Override // P9.f
    public int a(T9.a aVar) {
        int e10;
        boolean z10;
        f fVar = this.f2985a;
        if (fVar != null) {
            e10 = fVar.a(aVar);
        } else {
            e10 = e(aVar);
        }
        if (e10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f2988d = z10;
        this.f2987c = true;
        return e10;
    }

    @Override // P9.f
    public boolean c(T9.a aVar) {
        f fVar = this.f2985a;
        if (fVar != null) {
            return fVar.c(aVar);
        }
        return false;
    }

    public final int e(T9.a aVar) {
        int read;
        int i10 = 0;
        do {
            read = ((FilterInputStream) this).in.read();
            if (read == -1) {
                break;
            }
            aVar.a(read);
            i10++;
            if (this.f2986b > 0 && aVar.length() >= this.f2986b) {
                throw new MaxLineLimitException("Maximum line length limit exceeded");
            }
        } while (read != 10);
        if (i10 == 0 && read == -1) {
            return -1;
        }
        return i10;
    }

    public boolean f() {
        return this.f2988d;
    }

    public boolean g() {
        return this.f2987c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = ((FilterInputStream) this).in.read();
        this.f2988d = read == -1;
        this.f2987c = true;
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) {
        int i10;
        int read;
        if (j10 <= 0) {
            return 0L;
        }
        if (j10 > 8192) {
            i10 = 8192;
        } else {
            i10 = (int) j10;
        }
        byte[] bArr = new byte[i10];
        long j11 = 0;
        while (j10 > 0 && (read = read(bArr)) != -1) {
            long j12 = read;
            j11 += j12;
            j10 -= j12;
        }
        return j11;
    }

    public String toString() {
        return "[LineReaderInputStreamAdaptor: " + this.f2985a + "]";
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        this.f2988d = read == -1;
        this.f2987c = true;
        return read;
    }
}
