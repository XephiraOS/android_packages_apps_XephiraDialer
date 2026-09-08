package c0;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.util.Log;
import java.util.Arrays;

/* compiled from: CursorUtil.java */
/* renamed from: c0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0546b {
    public static Cursor a(Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i10 = 0; i10 < cursor.getColumnCount(); i10++) {
                    int type = cursor.getType(i10);
                    if (type != 0) {
                        if (type != 1) {
                            if (type != 2) {
                                if (type != 3) {
                                    if (type == 4) {
                                        objArr[i10] = cursor.getBlob(i10);
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                } else {
                                    objArr[i10] = cursor.getString(i10);
                                }
                            } else {
                                objArr[i10] = Double.valueOf(cursor.getDouble(i10));
                            }
                        } else {
                            objArr[i10] = Long.valueOf(cursor.getLong(i10));
                        }
                    } else {
                        objArr[i10] = null;
                    }
                }
                matrixCursor.addRow(objArr);
            }
            cursor.close();
            return matrixCursor;
        } catch (Throwable th) {
            cursor.close();
            throw th;
        }
    }

    public static int b(Cursor cursor, String str) {
        return -1;
    }

    public static int c(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + "`");
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        return b(cursor, str);
    }

    public static int d(Cursor cursor, String str) {
        String str2;
        int c10 = c(cursor, str);
        if (c10 >= 0) {
            return c10;
        }
        try {
            str2 = Arrays.toString(cursor.getColumnNames());
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            str2 = "";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }
}
