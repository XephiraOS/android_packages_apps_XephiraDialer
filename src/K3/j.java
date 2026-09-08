package k3;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class j implements X2.e<InputStream, c> {

    /* renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f34139a;

    /* renamed from: b, reason: collision with root package name */
    public final X2.e<ByteBuffer, c> f34140b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.b f34141c;

    public j(List<ImageHeaderParser> list, X2.e<ByteBuffer, c> eVar, a3.b bVar) {
        this.f34139a = list;
        this.f34140b = eVar;
        this.f34141c = bVar;
    }

    public static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e10);
                return null;
            }
            return null;
        }
    }

    @Override // X2.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Z2.j<c> b(InputStream inputStream, int i10, int i11, X2.d dVar) {
        byte[] e10 = e(inputStream);
        if (e10 == null) {
            return null;
        }
        return this.f34140b.b(ByteBuffer.wrap(e10), i10, i11, dVar);
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, X2.d dVar) {
        if (!((Boolean) dVar.c(i.f34138b)).booleanValue() && com.bumptech.glide.load.a.f(this.f34139a, inputStream, this.f34141c) == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        return false;
    }
}
