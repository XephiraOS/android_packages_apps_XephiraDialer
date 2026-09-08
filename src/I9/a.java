package I9;

import J9.b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.function.Consumer;
import org.apache.commons.io.output.StringBuilderWriter;

/* compiled from: IOUtils.java */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f1358a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public static final char f1359b = File.separatorChar;

    /* renamed from: c, reason: collision with root package name */
    public static final String f1360c;

    static {
        StringBuilderWriter stringBuilderWriter = new StringBuilderWriter(4);
        try {
            PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
            try {
                printWriter.println();
                f1360c = stringBuilderWriter.toString();
                printWriter.close();
                stringBuilderWriter.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    stringBuilderWriter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    @Deprecated
    public static void a(Closeable closeable) {
        b(closeable, null);
    }

    public static void b(Closeable closeable, Consumer<IOException> consumer) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                if (consumer != null) {
                    consumer.accept(e10);
                }
            }
        }
    }

    public static int c(InputStream inputStream, OutputStream outputStream) {
        long e10 = e(inputStream, outputStream);
        if (e10 > 2147483647L) {
            return -1;
        }
        return (int) e10;
    }

    public static long d(InputStream inputStream, OutputStream outputStream, int i10) {
        return f(inputStream, outputStream, new byte[i10]);
    }

    public static long e(InputStream inputStream, OutputStream outputStream) {
        return d(inputStream, outputStream, 8192);
    }

    public static long f(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j10 += read;
            } else {
                return j10;
            }
        }
    }

    public static byte[] g(InputStream inputStream) {
        b bVar = new b();
        try {
            c(inputStream, bVar);
            byte[] c10 = bVar.c();
            bVar.close();
            return c10;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bVar.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
