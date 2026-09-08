package com.oplus.foundation.util.io;

import android.database.Cursor;
import android.util.Log;

/* compiled from: CursorExt.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final int a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            return cursor.getCount();
        }
        Log.w("CursorExt", "cursor is null or closed:" + cursor);
        return 0;
    }

    public static final boolean b(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            return false;
        }
        return true;
    }
}
