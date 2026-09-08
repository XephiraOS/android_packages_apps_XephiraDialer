package com.oplus.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
abstract class BaseRef<T> implements IBaseRef {
    static final HashMap<Class<?>, Object> DEFAULT_TYPES;
    private final String mName;
    private final Type mType;
    private Object mStub = null;
    private final T mDefaultValue = initDefaultValue();

    static {
        HashMap<Class<?>, Object> hashMap = new HashMap<>();
        DEFAULT_TYPES = hashMap;
        hashMap.put(Integer.class, 0);
        hashMap.put(Short.class, (short) 0);
        hashMap.put(Long.class, 0L);
        hashMap.put(Float.class, Float.valueOf(0.0f));
        hashMap.put(Double.class, Double.valueOf(0.0d));
        hashMap.put(Boolean.class, Boolean.FALSE);
        hashMap.put(Byte.class, (byte) 0);
        hashMap.put(Character.class, (char) 0);
    }

    public BaseRef(Field field) {
        this.mName = field.getName();
        this.mType = getGenericType(field);
    }

    private Type getGenericType(Field field) {
        Type genericType = field.getGenericType();
        if (genericType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
            if (actualTypeArguments.length > 0) {
                return actualTypeArguments[0];
            }
            return genericType;
        }
        return genericType;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public void bindStub(Object obj) {
        this.mStub = obj;
    }

    public Object checkStub(Object obj) {
        if (obj == null) {
            return obj;
        }
        Class<?> declaringClass = getDeclaringClass();
        if (declaringClass != null) {
            Class<?> cls = obj.getClass();
            if (declaringClass == cls) {
                return obj;
            }
            if (declaringClass.isAssignableFrom(cls)) {
                return obj;
            }
        }
        return this.mStub;
    }

    public T getDefaultValue() {
        return this.mDefaultValue;
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public String getName() {
        return this.mName;
    }

    public T initDefaultValue() {
        for (Map.Entry<Class<?>, Object> entry : DEFAULT_TYPES.entrySet()) {
            if (this.mType.equals(entry.getKey())) {
                return (T) entry.getValue();
            }
        }
        return null;
    }
}
