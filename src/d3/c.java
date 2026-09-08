package d3;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import s3.C1530a;

/* compiled from: ByteBufferEncoder.java */
/* loaded from: classes.dex */
public class c implements X2.a<ByteBuffer> {
    @Override // X2.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, File file, X2.d dVar) {
        try {
            C1530a.f(byteBuffer, file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e10);
            }
            return false;
        }
    }
}
