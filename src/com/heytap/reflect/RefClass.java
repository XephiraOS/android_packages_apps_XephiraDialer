package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class RefClass {
    private static HashMap<Class<?>, Constructor<?>> REF_TYPES = null;
    private static final String TAG = "RefClass";

    static {
        HashMap<Class<?>, Constructor<?>> hashMap = new HashMap<>();
        REF_TYPES = hashMap;
        try {
            hashMap.put(RefObject.class, RefObject.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefMethod.class, RefMethod.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefInt.class, RefInt.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefLong.class, RefLong.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefFloat.class, RefFloat.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefDouble.class, RefDouble.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefBoolean.class, RefBoolean.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefStaticObject.class, RefStaticObject.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefStaticInt.class, RefStaticInt.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefStaticMethod.class, RefStaticMethod.class.getConstructor(Class.class, Field.class));
            REF_TYPES.put(RefConstructor.class, RefConstructor.class.getConstructor(Class.class, Field.class));
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
        }
    }

    public static Class<?> load(Class<?> cls, String str) {
        try {
            return load(cls, Class.forName(str));
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return null;
        }
    }

    public static Class load(Class cls, Class<?> cls2) {
        Constructor<?> constructor;
        for (Field field : cls.getDeclaredFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && (constructor = REF_TYPES.get(field.getType())) != null) {
                    field.setAccessible(true);
                    field.set(null, constructor.newInstance(cls2, field));
                }
            } catch (Exception e10) {
                Log.e(TAG, e10.toString());
            }
        }
        return cls2;
    }
}
