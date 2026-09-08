package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class RefObject<T> {
    private static final String TAG = "RefObject";
    private Field mField;

    public RefObject(Class<?> cls, Field field) {
        Field declaredField = cls.getDeclaredField(field.getName());
        this.mField = declaredField;
        declaredField.setAccessible(true);
    }

    public T get(Object obj) {
        try {
            return (T) this.mField.get(obj);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return null;
        }
    }

    public T getWithException(Object obj) {
        return (T) this.mField.get(obj);
    }

    public void set(Object obj, T t10) {
        try {
            this.mField.set(obj, t10);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
        }
    }
}
