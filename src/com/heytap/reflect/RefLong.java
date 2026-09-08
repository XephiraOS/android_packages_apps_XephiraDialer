package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefLong {
    private static final String TAG = "RefLong";
    private Field mField;

    public RefLong(Class cls, Field field) {
        Field declaredField = cls.getDeclaredField(field.getName());
        this.mField = declaredField;
        declaredField.setAccessible(true);
    }

    public long get(Object obj) {
        try {
            return this.mField.getLong(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return 0L;
        }
    }

    public long getWithException(Object obj) {
        return this.mField.getLong(obj);
    }

    public void set(Object obj, long j10) {
        try {
            this.mField.setLong(obj, j10);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
        }
    }
}
