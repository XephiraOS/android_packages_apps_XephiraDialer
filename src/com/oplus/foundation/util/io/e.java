package com.oplus.foundation.util.io;

import android.database.Cursor;
import android.util.Log;

/* compiled from: MoreCloseables.java */
/* loaded from: classes3.dex */
public class e {
    public static void a(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static void b(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e10) {
                Log.e("MoreCloseables", "closeQuietly: e = " + e10);
            }
        }
    }
}
