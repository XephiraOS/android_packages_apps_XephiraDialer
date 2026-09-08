package Y2;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    public static final a f5533f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final a f5534a;

    /* renamed from: b, reason: collision with root package name */
    public final d f5535b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.b f5536c;

    /* renamed from: d, reason: collision with root package name */
    public final ContentResolver f5537d;

    /* renamed from: e, reason: collision with root package name */
    public final List<ImageHeaderParser> f5538e;

    public e(List<ImageHeaderParser> list, d dVar, a3.b bVar, ContentResolver contentResolver) {
        this(list, f5533f, dVar, bVar, contentResolver);
    }

    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f5537d.openInputStream(uri);
                int b10 = com.bumptech.glide.load.a.b(this.f5538e, inputStream, this.f5536c);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return b10;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e10) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e10);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            }
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(android.net.Uri r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            Y2.d r5 = r5.f5535b     // Catch: java.lang.Throwable -> L25 java.lang.SecurityException -> L27
            android.database.Cursor r5 = r5.a(r6)     // Catch: java.lang.Throwable -> L25 java.lang.SecurityException -> L27
            if (r5 == 0) goto L1f
            boolean r2 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L1a java.lang.SecurityException -> L1d
            if (r2 == 0) goto L1f
            r2 = 0
            java.lang.String r6 = r5.getString(r2)     // Catch: java.lang.Throwable -> L1a java.lang.SecurityException -> L1d
            r5.close()
            return r6
        L1a:
            r6 = move-exception
            r1 = r5
            goto L4a
        L1d:
            r2 = move-exception
            goto L29
        L1f:
            if (r5 == 0) goto L24
            r5.close()
        L24:
            return r1
        L25:
            r6 = move-exception
            goto L4a
        L27:
            r2 = move-exception
            r5 = r1
        L29:
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch: java.lang.Throwable -> L1a
            if (r3 == 0) goto L44
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a
            r3.<init>()     // Catch: java.lang.Throwable -> L1a
            java.lang.String r4 = "Failed to query for thumbnail for Uri: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L1a
            r3.append(r6)     // Catch: java.lang.Throwable -> L1a
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L1a
            android.util.Log.d(r0, r6, r2)     // Catch: java.lang.Throwable -> L1a
        L44:
            if (r5 == 0) goto L49
            r5.close()
        L49:
            return r1
        L4a:
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: Y2.e.b(android.net.Uri):java.lang.String");
    }

    public final boolean c(File file) {
        if (this.f5534a.a(file) && 0 < this.f5534a.c(file)) {
            return true;
        }
        return false;
    }

    public InputStream d(Uri uri) {
        String b10 = b(uri);
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        File b11 = this.f5534a.b(b10);
        if (!c(b11)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b11);
        try {
            return this.f5537d.openInputStream(fromFile);
        } catch (NullPointerException e10) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e10));
        }
    }

    public e(List<ImageHeaderParser> list, a aVar, d dVar, a3.b bVar, ContentResolver contentResolver) {
        this.f5534a = aVar;
        this.f5535b = dVar;
        this.f5536c = bVar;
        this.f5537d = contentResolver;
        this.f5538e = list;
    }
}
