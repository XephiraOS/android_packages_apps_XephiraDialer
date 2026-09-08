package e0;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: SupportSQLiteCompat.java */
/* loaded from: classes.dex */
public final class c {
    public static Uri a(Cursor cursor) {
        return cursor.getNotificationUri();
    }

    public static boolean b(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
