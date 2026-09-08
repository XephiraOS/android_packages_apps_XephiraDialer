package g3;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: BitmapEncoder.java */
/* renamed from: g3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1041c implements X2.f<Bitmap> {

    /* renamed from: b, reason: collision with root package name */
    public static final X2.c<Integer> f31843b = X2.c.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c, reason: collision with root package name */
    public static final X2.c<Bitmap.CompressFormat> f31844c = X2.c.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: a, reason: collision with root package name */
    public final a3.b f31845a;

    public C1041c(a3.b bVar) {
        this.f31845a = bVar;
    }

    @Override // X2.f
    public EncodeStrategy a(X2.d dVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #4 {all -> 0x0056, blocks: (B:3:0x0021, B:14:0x0052, B:17:0x0070, B:19:0x0076, B:45:0x00c2, B:43:0x00c5, B:37:0x006b), top: B:2:0x0021 }] */
    @Override // X2.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(Z2.j<android.graphics.Bitmap> r8, java.io.File r9, X2.d r10) {
        /*
            r7 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r8 = r8.get()
            android.graphics.Bitmap r8 = (android.graphics.Bitmap) r8
            android.graphics.Bitmap$CompressFormat r1 = r7.d(r8, r10)
            int r2 = r8.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r8.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            t3.b.d(r4, r2, r3, r1)
            long r2 = s3.C1536g.b()     // Catch: java.lang.Throwable -> L56
            X2.c<java.lang.Integer> r4 = g3.C1041c.f31843b     // Catch: java.lang.Throwable -> L56
            java.lang.Object r4 = r10.c(r4)     // Catch: java.lang.Throwable -> L56
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L56
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L56
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            a3.b r9 = r7.f31845a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            if (r9 == 0) goto L4b
            com.bumptech.glide.load.data.c r9 = new com.bumptech.glide.load.data.c     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            a3.b r7 = r7.f31845a     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r9.<init>(r6, r7)     // Catch: java.lang.Throwable -> L44 java.io.IOException -> L48
            r5 = r9
            goto L4c
        L44:
            r7 = move-exception
            r5 = r6
            goto Lc0
        L48:
            r7 = move-exception
            r5 = r6
            goto L5d
        L4b:
            r5 = r6
        L4c:
            r8.compress(r1, r4, r5)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r5.close()     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5c
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58
            goto L58
        L56:
            r7 = move-exception
            goto Lc6
        L58:
            r7 = 1
            goto L6f
        L5a:
            r7 = move-exception
            goto Lc0
        L5c:
            r7 = move-exception
        L5d:
            r9 = 3
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> L5a
            if (r9 == 0) goto L69
            java.lang.String r9 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r9, r7)     // Catch: java.lang.Throwable -> L5a
        L69:
            if (r5 == 0) goto L6e
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L6e
        L6e:
            r7 = 0
        L6f:
            r9 = 2
            boolean r9 = android.util.Log.isLoggable(r0, r9)     // Catch: java.lang.Throwable -> L56
            if (r9 == 0) goto Lbc
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = "Compressed with type: "
            r9.append(r4)     // Catch: java.lang.Throwable -> L56
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = " of size "
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            int r1 = s3.C1541l.h(r8)     // Catch: java.lang.Throwable -> L56
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = " in "
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            double r1 = s3.C1536g.a(r2)     // Catch: java.lang.Throwable -> L56
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            java.lang.String r1 = ", options format: "
            r9.append(r1)     // Catch: java.lang.Throwable -> L56
            X2.c<android.graphics.Bitmap$CompressFormat> r1 = g3.C1041c.f31844c     // Catch: java.lang.Throwable -> L56
            java.lang.Object r10 = r10.c(r1)     // Catch: java.lang.Throwable -> L56
            r9.append(r10)     // Catch: java.lang.Throwable -> L56
            java.lang.String r10 = ", hasAlpha: "
            r9.append(r10)     // Catch: java.lang.Throwable -> L56
            boolean r8 = r8.hasAlpha()     // Catch: java.lang.Throwable -> L56
            r9.append(r8)     // Catch: java.lang.Throwable -> L56
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> L56
            android.util.Log.v(r0, r8)     // Catch: java.lang.Throwable -> L56
        Lbc:
            t3.b.e()
            return r7
        Lc0:
            if (r5 == 0) goto Lc5
            r5.close()     // Catch: java.lang.Throwable -> L56 java.io.IOException -> Lc5
        Lc5:
            throw r7     // Catch: java.lang.Throwable -> L56
        Lc6:
            t3.b.e()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.C1041c.b(Z2.j, java.io.File, X2.d):boolean");
    }

    public final Bitmap.CompressFormat d(Bitmap bitmap, X2.d dVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) dVar.c(f31844c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }
}
