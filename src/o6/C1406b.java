package o6;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/* compiled from: NumberAllowAllProcessor.java */
/* renamed from: o6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1406b extends AbstractC1405a {
    @Override // o6.AbstractC1405a
    public boolean d(Context context, String str, String str2) {
        return false;
    }

    @Override // o6.AbstractC1405a
    public boolean e() {
        return false;
    }

    @Override // o6.AbstractC1405a
    public Cursor f(Uri uri, String[] strArr, String str, String[] strArr2, String str2, SQLiteDatabase sQLiteDatabase, Context context, int i10) {
        uri.getLastPathSegment();
        c(uri, "slotId", -1);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"block_reason", "num_area"});
        if (i10 == 603) {
            matrixCursor.addRow(new String[]{String.valueOf(3), null});
        }
        return matrixCursor;
    }
}
