package G9;

import java.io.Closeable;
import java.io.Flushable;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink.kt */
/* loaded from: classes4.dex */
public interface c extends Closeable, Flushable, WritableByteChannel {
    c K(String str);

    c R(String str, int i10, int i11);

    c x(int i10);
}
