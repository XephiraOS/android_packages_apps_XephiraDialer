package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* compiled from: ContentResolverCompat.java */
/* loaded from: classes.dex */
public final class a {
    @Deprecated
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, F.d dVar) {
        CancellationSignal cancellationSignal;
        if (dVar != null) {
            cancellationSignal = (CancellationSignal) dVar.b();
        } else {
            cancellationSignal = null;
        }
        return b(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal);
    }

    public static Cursor b(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        } catch (Exception e10) {
            if (e10 instanceof OperationCanceledException) {
                throw new androidx.core.os.OperationCanceledException();
            }
            throw e10;
        }
    }
}
