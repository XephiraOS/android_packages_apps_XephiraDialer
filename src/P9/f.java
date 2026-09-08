package P9;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: LineReaderInputStream.java */
/* loaded from: classes4.dex */
public abstract class f extends FilterInputStream {
    public f(InputStream inputStream) {
        super(inputStream);
    }

    public abstract int a(T9.a aVar);

    public abstract boolean c(T9.a aVar);
}
