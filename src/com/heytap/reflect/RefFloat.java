package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefFloat {
    private static final String TAG = "RefFloat";
    private Field mField;

    public RefFloat(Class cls, Field field) {
        Field declaredField = cls.getDeclaredField(field.getName());
        this.mField = declaredField;
        declaredField.setAccessible(true);
    }

    public float get(Object obj) {
        try {
            return this.mField.getFloat(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return 0.0f;
        }
    }

    public float getWithException(Object obj) {
        return this.mField.getFloat(obj);
    }

    public void set(Object obj, float f10) {
        try {
            this.mField.setFloat(obj, f10);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
        }
    }
}
