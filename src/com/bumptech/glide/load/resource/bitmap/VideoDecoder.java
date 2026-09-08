package com.bumptech.glide.load.resource.bitmap;

import X2.c;
import Z2.j;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import g3.C1043e;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class VideoDecoder<T> implements X2.e<T, Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    public static final X2.c<Long> f19651d = X2.c.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e, reason: collision with root package name */
    public static final X2.c<Integer> f19652e = X2.c.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f, reason: collision with root package name */
    public static final f f19653f = new f();

    /* renamed from: g, reason: collision with root package name */
    public static final List<String> f19654g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* renamed from: a, reason: collision with root package name */
    public final e<T> f19655a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.d f19656b;

    /* renamed from: c, reason: collision with root package name */
    public final f f19657c;

    /* loaded from: classes.dex */
    public static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    /* loaded from: classes.dex */
    public class a implements c.b<Long> {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f19658a = ByteBuffer.allocate(8);

        @Override // X2.c.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l10, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f19658a) {
                this.f19658a.position(0);
                messageDigest.update(this.f19658a.putLong(l10.longValue()).array());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.b<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f19659a = ByteBuffer.allocate(4);

        @Override // X2.c.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f19659a) {
                this.f19659a.position(0);
                messageDigest.update(this.f19659a.putInt(num.intValue()).array());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements e<AssetFileDescriptor> {
        public c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface e<T> {
        void a(MediaExtractor mediaExtractor, T t10);

        void b(MediaMetadataRetriever mediaMetadataRetriever, T t10);
    }

    /* loaded from: classes.dex */
    public static class f {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* loaded from: classes.dex */
    public static final class g implements e<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public VideoDecoder(a3.d dVar, e<T> eVar) {
        this(dVar, eVar, f19653f);
    }

    public static X2.e<AssetFileDescriptor, Bitmap> c(a3.d dVar) {
        return new VideoDecoder(dVar, new c(null));
    }

    public static X2.e<ByteBuffer, Bitmap> d(a3.d dVar) {
        return new VideoDecoder(dVar, new d());
    }

    public static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (!j()) {
            return bitmap;
        }
        try {
            if (i(mediaMetadataRetriever)) {
                if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) == 180) {
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            }
        } catch (NumberFormatException unused) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
            }
        }
        return bitmap;
    }

    public static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10) {
        return mediaMetadataRetriever.getFrameAtTime(j10, i10);
    }

    public static Bitmap h(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, DownsampleStrategy downsampleStrategy) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b10 = downsampleStrategy.b(parseInt, parseInt2, i11, i12);
            return mediaMetadataRetriever.getScaledFrameAtTime(j10, i10, Math.round(parseInt * b10), Math.round(b10 * parseInt2));
        } catch (Throwable th) {
            if (Log.isLoggable("VideoDecoder", 3)) {
                Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                return null;
            }
            return null;
        }
    }

    public static boolean i(MediaMetadataRetriever mediaMetadataRetriever) {
        String extractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int parseInt = Integer.parseInt(extractMetadata);
        int parseInt2 = Integer.parseInt(extractMetadata2);
        if ((parseInt == 7 || parseInt == 6) && parseInt2 == 6) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        Build.MODEL.startsWith("Pixel");
        return false;
    }

    public static X2.e<ParcelFileDescriptor, Bitmap> l(a3.d dVar) {
        return new VideoDecoder(dVar, new g());
    }

    @Override // X2.e
    public boolean a(T t10, X2.d dVar) {
        return true;
    }

    @Override // X2.e
    public j<Bitmap> b(T t10, int i10, int i11, X2.d dVar) {
        long longValue = ((Long) dVar.c(f19651d)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) dVar.c(f19652e);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) dVar.c(DownsampleStrategy.f19640h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f19639g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a10 = this.f19657c.a();
        try {
            this.f19655a.b(a10, t10);
            Bitmap f10 = f(t10, a10, longValue, num.intValue(), i10, i11, downsampleStrategy2);
            a10.close();
            return C1043e.f(f10, this.f19656b);
        } catch (Throwable th) {
            a10.close();
            throw th;
        }
    }

    public final Bitmap f(T t10, MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap;
        if (!k(t10, mediaMetadataRetriever)) {
            if (i11 != Integer.MIN_VALUE && i12 != Integer.MIN_VALUE && downsampleStrategy != DownsampleStrategy.f19638f) {
                bitmap = h(mediaMetadataRetriever, j10, i10, i11, i12, downsampleStrategy);
            } else {
                bitmap = null;
            }
            if (bitmap == null) {
                bitmap = g(mediaMetadataRetriever, j10, i10);
            }
            Bitmap e10 = e(mediaMetadataRetriever, bitmap);
            if (e10 != null) {
                return e10;
            }
            throw new VideoDecoderException();
        }
        throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
    }

    public final boolean k(T t10, MediaMetadataRetriever mediaMetadataRetriever) {
        String str = Build.DEVICE;
        if (str == null || !str.matches(".+_cheets|cheets_.+")) {
            return false;
        }
        MediaExtractor mediaExtractor = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (!"video/webm".equals(mediaMetadataRetriever.extractMetadata(12))) {
            return false;
        }
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        try {
            this.f19655a.a(mediaExtractor2, t10);
            int trackCount = mediaExtractor2.getTrackCount();
            for (int i10 = 0; i10 < trackCount; i10++) {
                if ("video/x-vnd.on2.vp8".equals(mediaExtractor2.getTrackFormat(i10).getString("mime"))) {
                    mediaExtractor2.release();
                    return true;
                }
            }
            mediaExtractor2.release();
        } catch (Throwable th2) {
            th = th2;
            mediaExtractor = mediaExtractor2;
            try {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", th);
                }
                return false;
            } finally {
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
            }
        }
        return false;
    }

    public VideoDecoder(a3.d dVar, e<T> eVar, f fVar) {
        this.f19656b = dVar;
        this.f19655a = eVar;
        this.f19657c = fVar;
    }

    /* loaded from: classes.dex */
    public static final class d implements e<ByteBuffer> {
        public final MediaDataSource c(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) {
            mediaExtractor.setDataSource(c(byteBuffer));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.e
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(c(byteBuffer));
        }

        /* loaded from: classes.dex */
        public class a extends MediaDataSource {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f19660a;

            public a(ByteBuffer byteBuffer) {
                this.f19660a = byteBuffer;
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f19660a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j10, byte[] bArr, int i10, int i11) {
                if (j10 >= this.f19660a.limit()) {
                    return -1;
                }
                this.f19660a.position((int) j10);
                int min = Math.min(i11, this.f19660a.remaining());
                this.f19660a.get(bArr, i10, min);
                return min;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }
    }
}
