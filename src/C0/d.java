package c0;

import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* compiled from: FileUtil.java */
/* loaded from: classes.dex */
public class d {
    public static void a(ReadableByteChannel readableByteChannel, FileChannel fileChannel) {
        try {
            fileChannel.transferFrom(readableByteChannel, 0L, Long.MAX_VALUE);
            fileChannel.force(false);
        } finally {
            readableByteChannel.close();
            fileChannel.close();
        }
    }
}
