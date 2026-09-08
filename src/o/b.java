package O;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: MetadataList.java */
/* loaded from: classes.dex */
public final class b extends c {
    public static b h(ByteBuffer byteBuffer) {
        return i(byteBuffer, new b());
    }

    public static b i(ByteBuffer byteBuffer, b bVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return bVar.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public b f(int i10, ByteBuffer byteBuffer) {
        g(i10, byteBuffer);
        return this;
    }

    public void g(int i10, ByteBuffer byteBuffer) {
        c(i10, byteBuffer);
    }

    public a j(a aVar, int i10) {
        int b10 = b(6);
        if (b10 != 0) {
            return aVar.f(a(d(b10) + (i10 * 4)), this.f2427b);
        }
        return null;
    }

    public int k() {
        int b10 = b(6);
        if (b10 != 0) {
            return e(b10);
        }
        return 0;
    }

    public int l() {
        int b10 = b(4);
        if (b10 != 0) {
            return this.f2427b.getInt(b10 + this.f2426a);
        }
        return 0;
    }
}
