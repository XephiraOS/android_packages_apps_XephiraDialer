package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefStaticInt {
    private static final String TAG = "RefStaticInt";
    private Field mField;

    public RefStaticInt(Class<?> cls, Field field) {
        Field declaredField = cls.getDeclaredField(field.getName());
        this.mField = declaredField;
        declaredField.setAccessible(true);
    }

    public int get() {
        try {
            return this.mField.getInt(null);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return 0;
        }
    }

    public int getWithException() {
        return this.mField.getInt(null);
    }

    public void set(int i10) {
        try {
            this.mField.setInt(null, i10);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
        }
    }
}
