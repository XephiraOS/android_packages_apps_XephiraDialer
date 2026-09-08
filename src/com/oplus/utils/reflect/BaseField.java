package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
abstract class BaseField<T> extends BaseRef<T> {
    final Field mField;

    public BaseField(Class<?> cls, Field field, String str) {
        super(field);
        this.mField = getField(cls, field, str);
    }

    private Field getField(Class<?> cls, Field field, String str) {
        Field field2 = null;
        try {
            field2 = cls.getDeclaredField(field.getName());
            field2.setAccessible(true);
            return field2;
        } catch (Exception e10) {
            Log.e(str, e10.getMessage());
            return field2;
        }
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public Class<?> getDeclaringClass() {
        if (!isEmpty()) {
            return this.mField.getDeclaringClass();
        }
        return null;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        if (this.mField == null) {
            return true;
        }
        return false;
    }
}
