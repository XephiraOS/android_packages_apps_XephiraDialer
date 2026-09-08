package o6;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.oplus.utils.C0846g;

/* compiled from: NumberInterceptAllProcessor.java */
/* loaded from: classes3.dex */
public class d extends AbstractC1405a {
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
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"block_reason", "num_area"});
        matrixCursor.addRow(new String[]{String.valueOf(1), null});
        C0846g.i("InterceptAllProcessor", "intercept all");
        return matrixCursor;
    }
}
