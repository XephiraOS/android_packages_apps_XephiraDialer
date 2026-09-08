package G7;

import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import com.oplus.foundation.util.io.CloseableUtils;
import java.util.ArrayList;

/* compiled from: SqliteWrapper.java */
/* loaded from: classes3.dex */
public final class c {
    public static ContentProviderResult[] a(ContentResolver contentResolver, String str, ArrayList<ContentProviderOperation> arrayList) {
        try {
            return contentResolver.applyBatch(str, arrayList);
        } catch (Exception e10) {
            H7.b.c("SqliteWrapper", "Catch a Exception when applyBatch: " + e10);
            return null;
        }
    }

    public static ContentProviderResult[] b(ContentResolver contentResolver, String str, ArrayList<ContentProviderOperation> arrayList) {
        ContentProviderClient contentProviderClient;
        ContentProviderClient contentProviderClient2 = null;
        try {
            contentProviderClient = contentResolver.acquireUnstableContentProviderClient(str);
            if (contentProviderClient == null) {
                CloseableUtils.a(contentProviderClient);
                return null;
            }
            try {
                try {
                    ContentProviderResult[] applyBatch = contentProviderClient.applyBatch(str, arrayList);
                    CloseableUtils.a(contentProviderClient);
                    return applyBatch;
                } catch (Exception e10) {
                    e = e10;
                    H7.b.c("SqliteWrapper", "Catch a Exception when applyBatch: " + e);
                    CloseableUtils.a(contentProviderClient);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                contentProviderClient2 = contentProviderClient;
                CloseableUtils.a(contentProviderClient2);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            contentProviderClient = null;
        } catch (Throwable th2) {
            th = th2;
            CloseableUtils.a(contentProviderClient2);
            throw th;
        }
    }

    public static int c(ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        try {
            return contentResolver.delete(uri, str, strArr);
        } catch (Exception e10) {
            H7.b.c("SqliteWrapper", "Catch a Exception when delete: " + e10);
            return -1;
        }
    }

    public static Uri d(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        try {
            return contentResolver.insert(uri, contentValues);
        } catch (Exception e10) {
            H7.b.c("SqliteWrapper", "Catch a Exception when insert: " + e10);
            return null;
        }
    }

    public static Cursor e(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return f(contentResolver, uri, strArr, str, strArr2, str2, null);
    }

    public static Cursor f(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        try {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        } catch (Exception e10) {
            H7.b.c("SqliteWrapper", "Catch a SQLiteException when query: " + e10);
            return null;
        }
    }

    public static int g(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return contentResolver.update(uri, contentValues, str, strArr);
        } catch (Exception e10) {
            H7.b.c("SqliteWrapper", "Catch a Exception when update: " + e10);
            return -1;
        }
    }
}
