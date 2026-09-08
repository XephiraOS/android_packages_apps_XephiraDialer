package com.bumptech.glide.load.resource.bitmap;

import Z2.j;
import a3.d;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.b;
import g3.C1043e;
import g3.o;
import g3.t;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import s3.C1536g;
import s3.C1540k;
import s3.C1541l;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final X2.c<DecodeFormat> f19662f = X2.c.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f19388c);

    /* renamed from: g, reason: collision with root package name */
    public static final X2.c<PreferredColorSpace> f19663g = X2.c.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public static final X2.c<DownsampleStrategy> f19664h = DownsampleStrategy.f19640h;

    /* renamed from: i, reason: collision with root package name */
    public static final X2.c<Boolean> f19665i;

    /* renamed from: j, reason: collision with root package name */
    public static final X2.c<Boolean> f19666j;

    /* renamed from: k, reason: collision with root package name */
    public static final Set<String> f19667k;

    /* renamed from: l, reason: collision with root package name */
    public static final b f19668l;

    /* renamed from: m, reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f19669m;

    /* renamed from: n, reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f19670n;

    /* renamed from: a, reason: collision with root package name */
    public final d f19671a;

    /* renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f19672b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.b f19673c;

    /* renamed from: d, reason: collision with root package name */
    public final List<ImageHeaderParser> f19674d;

    /* renamed from: e, reason: collision with root package name */
    public final o f19675e = o.b();

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b(d dVar, Bitmap bitmap);
    }

    static {
        Boolean bool = Boolean.FALSE;
        f19665i = X2.c.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f19666j = X2.c.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f19667k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f19668l = new C0193a();
        f19669m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f19670n = C1541l.f(0);
    }

    public a(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, d dVar, a3.b bVar) {
        this.f19674d = list;
        this.f19672b = (DisplayMetrics) C1540k.d(displayMetrics);
        this.f19671a = (d) C1540k.d(dVar);
        this.f19673c = (a3.b) C1540k.d(bVar);
    }

    public static int a(double d10) {
        return x((d10 / (r1 / r0)) * x(l(d10) * d10));
    }

    public static void c(ImageHeaderParser.ImageType imageType, com.bumptech.glide.load.resource.bitmap.b bVar, b bVar2, d dVar, DownsampleStrategy downsampleStrategy, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) {
        int i15;
        int i16;
        int min;
        int floor;
        int floor2;
        if (i11 > 0 && i12 > 0) {
            if (r(i10)) {
                i16 = i11;
                i15 = i12;
            } else {
                i15 = i11;
                i16 = i12;
            }
            float b10 = downsampleStrategy.b(i15, i16, i13, i14);
            if (b10 <= 0.0f) {
                throw new IllegalArgumentException("Cannot scale with factor: " + b10 + " from: " + downsampleStrategy + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
            }
            DownsampleStrategy.SampleSizeRounding a10 = downsampleStrategy.a(i15, i16, i13, i14);
            if (a10 != null) {
                float f10 = i15;
                float f11 = i16;
                int x10 = i15 / x(b10 * f10);
                int x11 = i16 / x(b10 * f11);
                DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                if (a10 == sampleSizeRounding) {
                    min = Math.max(x10, x11);
                } else {
                    min = Math.min(x10, x11);
                }
                int max = Math.max(1, Integer.highestOneBit(min));
                if (a10 == sampleSizeRounding && max < 1.0f / b10) {
                    max <<= 1;
                }
                options.inSampleSize = max;
                if (imageType == ImageHeaderParser.ImageType.JPEG) {
                    float min2 = Math.min(max, 8);
                    floor = (int) Math.ceil(f10 / min2);
                    floor2 = (int) Math.ceil(f11 / min2);
                    int i17 = max / 8;
                    if (i17 > 0) {
                        floor /= i17;
                        floor2 /= i17;
                    }
                } else if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                    if (imageType.isWebp()) {
                        float f12 = max;
                        floor = Math.round(f10 / f12);
                        floor2 = Math.round(f11 / f12);
                    } else if (i15 % max == 0 && i16 % max == 0) {
                        floor = i15 / max;
                        floor2 = i16 / max;
                    } else {
                        int[] m10 = m(bVar, options, bVar2, dVar);
                        floor = m10[0];
                        floor2 = m10[1];
                    }
                } else {
                    float f13 = max;
                    floor = (int) Math.floor(f10 / f13);
                    floor2 = (int) Math.floor(f11 / f13);
                }
                double b11 = downsampleStrategy.b(floor, floor2, i13, i14);
                options.inTargetDensity = a(b11);
                options.inDensity = l(b11);
                if (s(options)) {
                    options.inScaled = true;
                } else {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculate scaling, source: [" + i11 + "x" + i12 + "], degreesToRotate: " + i10 + ", target: [" + i13 + "x" + i14 + "], power of two scaled: [" + floor + "x" + floor2 + "], exact scale factor: " + b10 + ", power of 2 sample size: " + max + ", adjusted scale factor: " + b11 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i13 + "x" + i14 + "]");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap i(com.bumptech.glide.load.resource.bitmap.b r5, android.graphics.BitmapFactory.Options r6, com.bumptech.glide.load.resource.bitmap.a.b r7, a3.d r8) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.a()
            r5.c()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = g3.t.f()
            r4.lock()
            android.graphics.Bitmap r5 = r5.b(r6)     // Catch: java.lang.Throwable -> L25 java.lang.IllegalArgumentException -> L27
            java.util.concurrent.locks.Lock r6 = g3.t.f()
            r6.unlock()
            return r5
        L25:
            r5 = move-exception
            goto L50
        L27:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L25
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L38
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L25
        L38:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L4f
            r8.c(r0)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            r0 = 0
            r6.inBitmap = r0     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L4e
            java.util.concurrent.locks.Lock r6 = g3.t.f()
            r6.unlock()
            return r5
        L4e:
            throw r1     // Catch: java.lang.Throwable -> L25
        L4f:
            throw r1     // Catch: java.lang.Throwable -> L25
        L50:
            java.util.concurrent.locks.Lock r6 = g3.t.f()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.a.i(com.bumptech.glide.load.resource.bitmap.b, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.a$b, a3.d):android.graphics.Bitmap");
    }

    public static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options poll;
        synchronized (a.class) {
            Queue<BitmapFactory.Options> queue = f19670n;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                w(poll);
            }
        }
        return poll;
    }

    public static int l(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    public static int[] m(com.bumptech.glide.load.resource.bitmap.b bVar, BitmapFactory.Options options, b bVar2, d dVar) {
        options.inJustDecodeBounds = true;
        i(bVar, options, bVar2, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    public static boolean r(int i10) {
        if (i10 != 90 && i10 != 270) {
            return false;
        }
        return true;
    }

    public static boolean s(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        if (i11 > 0 && (i10 = options.inDensity) > 0 && i11 != i10) {
            return true;
        }
        return false;
    }

    public static void t(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i10 + "x" + i11 + "] " + str + " with inBitmap " + n(options) + " for [" + i12 + "x" + i13 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + C1536g.a(j10));
    }

    public static IOException u(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    public static void v(BitmapFactory.Options options) {
        w(options);
        Queue<BitmapFactory.Options> queue = f19670n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int x(double d10) {
        return (int) (d10 + 0.5d);
    }

    public static void y(BitmapFactory.Options options, d dVar, int i10, int i11) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config2 = options.outConfig;
        if (config2 != null) {
            config = config2;
        }
        options.inBitmap = dVar.e(i10, i11, config);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.bumptech.glide.load.resource.bitmap.b r7, com.bumptech.glide.load.DecodeFormat r8, boolean r9, boolean r10, android.graphics.BitmapFactory.Options r11, int r12, int r13) {
        /*
            r6 = this;
            g3.o r0 = r6.f19675e
            r1 = r12
            r2 = r13
            r3 = r11
            r4 = r9
            r5 = r10
            boolean r6 = r0.g(r1, r2, r3, r4, r5)
            if (r6 == 0) goto Le
            return
        Le:
            com.bumptech.glide.load.DecodeFormat r6 = com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
            if (r8 == r6) goto L49
            com.bumptech.glide.load.ImageHeaderParser$ImageType r6 = r7.d()     // Catch: java.io.IOException -> L1f
            boolean r6 = r6.hasAlpha()     // Catch: java.io.IOException -> L1f
            if (r6 == 0) goto L3d
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            goto L3f
        L1f:
            r6 = move-exception
            r7 = 3
            java.lang.String r9 = "Downsampler"
            boolean r7 = android.util.Log.isLoggable(r9, r7)
            if (r7 == 0) goto L3d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Cannot determine whether the image has alpha or not from header, format "
            r7.append(r10)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r9, r7, r6)
        L3d:
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565
        L3f:
            r11.inPreferredConfig = r6
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGB_565
            if (r6 != r7) goto L48
            r6 = 1
            r11.inDither = r6
        L48:
            return
        L49:
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
            r11.inPreferredConfig = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.a.b(com.bumptech.glide.load.resource.bitmap.b, com.bumptech.glide.load.DecodeFormat, boolean, boolean, android.graphics.BitmapFactory$Options, int, int):void");
    }

    public j<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, X2.d dVar) {
        return e(new b.c(parcelFileDescriptor, this.f19674d, this.f19673c), i10, i11, dVar, f19668l);
    }

    public final j<Bitmap> e(com.bumptech.glide.load.resource.bitmap.b bVar, int i10, int i11, X2.d dVar, b bVar2) {
        boolean z10;
        byte[] bArr = (byte[]) this.f19673c.e(65536, byte[].class);
        BitmapFactory.Options k10 = k();
        k10.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) dVar.c(f19662f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) dVar.c(f19663g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) dVar.c(DownsampleStrategy.f19640h);
        boolean booleanValue = ((Boolean) dVar.c(f19665i)).booleanValue();
        X2.c<Boolean> cVar = f19666j;
        if (dVar.c(cVar) != null && ((Boolean) dVar.c(cVar)).booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        try {
            return C1043e.f(h(bVar, k10, downsampleStrategy, decodeFormat, preferredColorSpace, z10, i10, i11, booleanValue, bVar2), this.f19671a);
        } finally {
            v(k10);
            this.f19673c.d(bArr);
        }
    }

    public j<Bitmap> f(InputStream inputStream, int i10, int i11, X2.d dVar, b bVar) {
        return e(new b.C0194b(inputStream, this.f19674d, this.f19673c), i10, i11, dVar, bVar);
    }

    public j<Bitmap> g(ByteBuffer byteBuffer, int i10, int i11, X2.d dVar) {
        return e(new b.a(byteBuffer, this.f19674d, this.f19673c), i10, i11, dVar, f19668l);
    }

    public final Bitmap h(com.bumptech.glide.load.resource.bitmap.b bVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z10, int i10, int i11, boolean z11, b bVar2) {
        boolean z12;
        int i12;
        int i13;
        int i14;
        int i15;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        float f10;
        int round;
        int round2;
        long b10 = C1536g.b();
        int[] m10 = m(bVar, options, bVar2, this.f19671a);
        int i16 = m10[0];
        int i17 = m10[1];
        String str = options.outMimeType;
        if (i16 != -1 && i17 != -1) {
            z12 = z10;
        } else {
            z12 = false;
        }
        int a10 = bVar.a();
        int g10 = t.g(a10);
        boolean j10 = t.j(a10);
        if (i10 == Integer.MIN_VALUE) {
            i12 = i11;
            if (r(g10)) {
                i13 = i17;
            } else {
                i13 = i16;
            }
        } else {
            i12 = i11;
            i13 = i10;
        }
        if (i12 == Integer.MIN_VALUE) {
            if (r(g10)) {
                i14 = i16;
            } else {
                i14 = i17;
            }
        } else {
            i14 = i12;
        }
        ImageHeaderParser.ImageType d10 = bVar.d();
        c(d10, bVar, bVar2, this.f19671a, downsampleStrategy, g10, i16, i17, i13, i14, options);
        b(bVar, decodeFormat, z12, j10, options, i13, i14);
        if (z(d10)) {
            if (i16 >= 0 && i17 >= 0 && z11) {
                round = i13;
                round2 = i14;
            } else {
                if (s(options)) {
                    f10 = options.inTargetDensity / options.inDensity;
                } else {
                    f10 = 1.0f;
                }
                int i18 = options.inSampleSize;
                float f11 = i18;
                int ceil = (int) Math.ceil(i16 / f11);
                int ceil2 = (int) Math.ceil(i17 / f11);
                round = Math.round(ceil * f10);
                round2 = Math.round(ceil2 * f10);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculated target [" + round + "x" + round2 + "] for source [" + i16 + "x" + i17 + "], sampleSize: " + i18 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f10);
                }
            }
            if (round > 0 && round2 > 0) {
                y(options, this.f19671a, round, round2);
            }
        }
        if (preferredColorSpace != null) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                named = ColorSpace.Named.DISPLAY_P3;
            } else {
                named = ColorSpace.Named.SRGB;
            }
            options.inPreferredColorSpace = ColorSpace.get(named);
        }
        Bitmap i19 = i(bVar, options, bVar2, this.f19671a);
        bVar2.b(this.f19671a, i19);
        if (Log.isLoggable("Downsampler", 2)) {
            i15 = a10;
            t(i16, i17, str, options, i19, i10, i11, b10);
        } else {
            i15 = a10;
        }
        if (i19 != null) {
            i19.setDensity(this.f19672b.densityDpi);
            Bitmap k10 = t.k(this.f19671a, i19, i15);
            if (!i19.equals(k10)) {
                this.f19671a.c(i19);
                return k10;
            }
            return k10;
        }
        return null;
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    public final boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    /* compiled from: Downsampler.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0193a implements b {
        @Override // com.bumptech.glide.load.resource.bitmap.a.b
        public void a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a.b
        public void b(d dVar, Bitmap bitmap) {
        }
    }
}
