package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefBoolean {
    private static final String TAG = "RefBoolean";
    private Field mField;

    public RefBoolean(Class<?> cls, Field field) {
        Field declaredField = cls.getDeclaredField(field.getName());
        this.mField = declaredField;
        declaredField.setAccessible(true);
    }

    public boolean get(Object obj) {
        try {
            return this.mField.getBoolean(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return false;
        }
    }

    public boolean getWithException(Object obj) {
        return this.mField.getBoolean(obj);
    }

    public void set(Object obj, boolean z10) {
        try {
            this.mField.setBoolean(obj, z10);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
        }
    }
}
