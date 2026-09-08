package k3;

import W2.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import f3.C0999c;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import s3.C1536g;
import s3.C1541l;

/* compiled from: ByteBufferGifDecoder.java */
/* renamed from: k3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1210a implements X2.e<ByteBuffer, c> {

    /* renamed from: f, reason: collision with root package name */
    public static final C0322a f34090f = new C0322a();

    /* renamed from: g, reason: collision with root package name */
    public static final b f34091g = new b();

    /* renamed from: a, reason: collision with root package name */
    public final Context f34092a;

    /* renamed from: b, reason: collision with root package name */
    public final List<ImageHeaderParser> f34093b;

    /* renamed from: c, reason: collision with root package name */
    public final b f34094c;

    /* renamed from: d, reason: collision with root package name */
    public final C0322a f34095d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.b f34096e;

    /* compiled from: ByteBufferGifDecoder.java */
    /* renamed from: k3.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0322a {
        public W2.a a(a.InterfaceC0079a interfaceC0079a, W2.c cVar, ByteBuffer byteBuffer, int i10) {
            return new W2.e(interfaceC0079a, cVar, byteBuffer, i10);
        }
    }

    /* compiled from: ByteBufferGifDecoder.java */
    /* renamed from: k3.a$b */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Queue<W2.d> f34097a = C1541l.f(0);

        public synchronized W2.d a(ByteBuffer byteBuffer) {
            W2.d poll;
            try {
                poll = this.f34097a.poll();
                if (poll == null) {
                    poll = new W2.d();
                }
            } catch (Throwable th) {
                throw th;
            }
            return poll.p(byteBuffer);
        }

        public synchronized void b(W2.d dVar) {
            dVar.a();
            this.f34097a.offer(dVar);
        }
    }

    public C1210a(Context context, List<ImageHeaderParser> list, a3.d dVar, a3.b bVar) {
        this(context, list, dVar, bVar, f34091g, f34090f);
    }

    public static int e(W2.c cVar, int i10, int i11) {
        int highestOneBit;
        int min = Math.min(cVar.a() / i11, cVar.d() / i10);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        int max = Math.max(1, highestOneBit);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i10 + "x" + i11 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return max;
    }

    public final e c(ByteBuffer byteBuffer, int i10, int i11, W2.d dVar, X2.d dVar2) {
        Bitmap.Config config;
        long b10 = C1536g.b();
        try {
            W2.c c10 = dVar.c();
            if (c10.b() > 0 && c10.c() == 0) {
                if (dVar2.c(i.f34137a) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                W2.a a10 = this.f34095d.a(this.f34096e, c10, byteBuffer, e(c10, i10, i11));
                a10.e(config);
                a10.a();
                Bitmap b11 = a10.b();
                if (b11 == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C1536g.a(b10));
                    }
                    return null;
                }
                e eVar = new e(new c(this.f34092a, a10, C0999c.c(), i10, i11, b11));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C1536g.a(b10));
                }
                return eVar;
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C1536g.a(b10));
            }
        }
    }

    @Override // X2.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e b(ByteBuffer byteBuffer, int i10, int i11, X2.d dVar) {
        W2.d a10 = this.f34094c.a(byteBuffer);
        try {
            return c(byteBuffer, i10, i11, a10, dVar);
        } finally {
            this.f34094c.b(a10);
        }
    }

    @Override // X2.e
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, X2.d dVar) {
        if (!((Boolean) dVar.c(i.f34138b)).booleanValue() && com.bumptech.glide.load.a.g(this.f34093b, byteBuffer) == ImageHeaderParser.ImageType.GIF) {
            return true;
        }
        return false;
    }

    public C1210a(Context context, List<ImageHeaderParser> list, a3.d dVar, a3.b bVar, b bVar2, C0322a c0322a) {
        this.f34092a = context.getApplicationContext();
        this.f34093b = list;
        this.f34095d = c0322a;
        this.f34096e = new k3.b(dVar, bVar);
        this.f34094c = bVar2;
    }
}
