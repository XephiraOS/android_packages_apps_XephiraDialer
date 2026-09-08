package N4;

import com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: MetadataParser.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f2364b = Logger.getLogger(b.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2365a;

    public b(boolean z10) {
        this.f2365a = z10;
    }

    public static b c() {
        return new b(false);
    }

    public final void a(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e10) {
            f2364b.log(Level.WARNING, "Error closing input stream (ignored)", (Throwable) e10);
        }
    }

    public final List<Phonemetadata$PhoneMetadata> b() {
        if (!this.f2365a) {
            return Collections.emptyList();
        }
        throw new IllegalArgumentException("Source cannot be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Collection<com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata> d(java.io.InputStream r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L7
            java.util.List r5 = r5.b()
            return r5
        L7:
            r0 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L38
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L33 java.io.IOException -> L38
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection r0 = new com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadataCollection     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            r0.<init>()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            r0.readExternal(r1)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            java.util.List r2 = r0.b()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            if (r2 != 0) goto L2b
            java.util.List r6 = r0.b()     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            r5.a(r1)
            return r6
        L27:
            r0 = move-exception
            goto L44
        L29:
            r0 = move-exception
            goto L3c
        L2b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            java.lang.String r2 = "Empty metadata"
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            throw r0     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
        L33:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L44
        L38:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L3c:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = "Unable to parse metadata file"
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L27
            throw r2     // Catch: java.lang.Throwable -> L27
        L44:
            if (r1 == 0) goto L4a
            r5.a(r1)
            goto L4d
        L4a:
            r5.a(r6)
        L4d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: N4.b.d(java.io.InputStream):java.util.Collection");
    }
}
