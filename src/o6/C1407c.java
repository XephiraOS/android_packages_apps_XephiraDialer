package o6;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.oplus.utils.C0846g;
import com.oplus.utils.X;

/* compiled from: NumberCommonBlockPatternProcessor.java */
/* renamed from: o6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1407c extends AbstractC1405a {
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
        String lastPathSegment = uri.getLastPathSegment();
        int c10 = c(uri, "slotId", -1);
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"block_reason", "num_area"});
        if (i10 == 603 && X.b(uri, "need_query_block_area", true) && a(context, sQLiteDatabase, lastPathSegment, c10)) {
            C0846g.i("CommonProcessor", "query for phone black mode,reason = BLOCK_REASON_NUMBER_AREA_TYPE");
            matrixCursor.addRow(new String[]{String.valueOf(2), null});
        }
        return matrixCursor;
    }
}
