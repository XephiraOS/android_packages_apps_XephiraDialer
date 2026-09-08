package s1;

import android.database.Cursor;

/* compiled from: VoicemailStatusUtils.java */
/* loaded from: classes.dex */
public final class u {
    public static int a(Cursor cursor) {
        int i10 = 0;
        if (cursor == null) {
            return 0;
        }
        try {
            if (!cursor.moveToFirst()) {
                return 0;
            }
            do {
                if (b(cursor)) {
                    i10++;
                }
            } while (cursor.moveToNext());
        } catch (Exception e10) {
            H7.b.c("VoicemailStatusUtils", "getNumberActivityVoicemailSources error " + e10);
        }
        return i10;
    }

    public static boolean b(Cursor cursor) {
        if (cursor.getString(0) == null || cursor.isNull(3) || cursor.getInt(3) == 1) {
            return false;
        }
        return true;
    }
}
