package e0;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import java.io.File;

/* compiled from: SupportSQLiteCompat.java */
/* renamed from: e0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0963b {
    public static boolean a(File file) {
        return SQLiteDatabase.deleteDatabase(file);
    }

    public static boolean b(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public static Cursor c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, CancellationSignal cancellationSignal, SQLiteDatabase.CursorFactory cursorFactory) {
        return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
    }

    public static void d(SQLiteOpenHelper sQLiteOpenHelper, boolean z10) {
        sQLiteOpenHelper.setWriteAheadLoggingEnabled(z10);
    }
}
