package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
/* loaded from: classes.dex */
public final class G extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final String f10073a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f10074b = new StringBuilder(128);

    public G(String str) {
        this.f10073a = str;
    }

    public final void a() {
        if (this.f10074b.length() > 0) {
            Log.d(this.f10073a, this.f10074b.toString());
            StringBuilder sb = this.f10074b;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                a();
            } else {
                this.f10074b.append(c10);
            }
        }
    }
}
