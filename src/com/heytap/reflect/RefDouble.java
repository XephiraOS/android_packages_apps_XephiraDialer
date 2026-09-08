package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefDouble {
    private static final String TAG = "RefDouble";
    private Field mField;

    public RefDouble(Class cls, Field field) {
        Field declaredField = cls.getDeclaredField(field.getName());
        this.mField = declaredField;
        declaredField.setAccessible(true);
    }

    public double get(Object obj) {
        try {
            return this.mField.getDouble(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return 0.0d;
        }
    }

    public double getWithException(Object obj) {
        return this.mField.getDouble(obj);
    }

    public void set(Object obj, double d10) {
        try {
            this.mField.setDouble(obj, d10);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
        }
    }
}
