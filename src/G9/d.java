package G9;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import okio.ByteString;

/* compiled from: BufferedSource.kt */
/* loaded from: classes4.dex */
public interface d extends n, ReadableByteChannel {
    long A(ByteString byteString);

    int E(i iVar);

    boolean W(long j10);

    b k();

    InputStream p0();

    d peek();

    byte readByte();

    long v(ByteString byteString);

    b w();
}
