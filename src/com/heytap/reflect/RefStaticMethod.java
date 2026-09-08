package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class RefStaticMethod<T> {
    private static final String TAG = "RefStaticMethod";
    private Method mMethod;

    public RefStaticMethod(Class<?> cls, Field field) {
        Class<?> cls2;
        if (field.isAnnotationPresent(MethodName.class)) {
            setMethod(cls, field, ((MethodName) field.getAnnotation(MethodName.class)).params(), ((MethodName) field.getAnnotation(MethodName.class)).name());
            this.mMethod.setAccessible(true);
        } else {
            int i10 = 0;
            if (field.isAnnotationPresent(MethodSignature.class)) {
                String[] params = ((MethodSignature) field.getAnnotation(MethodSignature.class)).params();
                Class<?>[] clsArr = new Class[params.length];
                Class<?>[] clsArr2 = new Class[params.length];
                boolean z10 = false;
                while (i10 < params.length) {
                    Class<?> protoType = getProtoType(params[i10]);
                    if (protoType == null) {
                        try {
                            protoType = Class.forName(params[i10]);
                        } catch (ClassNotFoundException e10) {
                            Log.e(TAG, e10.toString());
                        }
                    }
                    clsArr[i10] = protoType;
                    if ("java.util.HashSet".equals(params[i10])) {
                        try {
                            cls2 = Class.forName("android.util.ArraySet");
                        } catch (ClassNotFoundException e11) {
                            Log.e(TAG, e11.toString());
                            cls2 = protoType;
                        }
                        if (cls2 != null) {
                            clsArr2[i10] = cls2;
                        } else {
                            clsArr2[i10] = protoType;
                        }
                        z10 = true;
                    } else {
                        clsArr2[i10] = protoType;
                    }
                    i10++;
                }
                try {
                    setMethod(cls, field, clsArr, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                } catch (Exception e12) {
                    Log.e(TAG, e12.toString());
                    if (z10) {
                        setMethod(cls, field, clsArr2, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                    }
                }
                this.mMethod.setAccessible(true);
            } else {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    Method method = declaredMethods[i10];
                    if (method.getName().equals(field.getName())) {
                        this.mMethod = method;
                        method.setAccessible(true);
                        break;
                    }
                    i10++;
                }
            }
        }
        if (this.mMethod != null) {
        } else {
            throw new NoSuchMethodException(field.getName());
        }
    }

    public static Class<?> getProtoType(String str) {
        if (str.equals("int")) {
            return Integer.TYPE;
        }
        if (str.equals("long")) {
            return Long.TYPE;
        }
        if (str.equals("boolean")) {
            return Boolean.TYPE;
        }
        if (str.equals("byte")) {
            return Byte.TYPE;
        }
        if (str.equals("short")) {
            return Short.TYPE;
        }
        if (str.equals("char")) {
            return Character.TYPE;
        }
        if (str.equals("float")) {
            return Float.TYPE;
        }
        if (str.equals("double")) {
            return Double.TYPE;
        }
        if (str.equals("void")) {
            return Void.TYPE;
        }
        return null;
    }

    private void setMethod(Class<?> cls, Field field, Class<?>[] clsArr, String str) {
        if (!str.isEmpty()) {
            this.mMethod = cls.getDeclaredMethod(str, clsArr);
        } else {
            this.mMethod = cls.getDeclaredMethod(field.getName(), clsArr);
        }
    }

    public T call(Object... objArr) {
        try {
            return (T) this.mMethod.invoke(null, objArr);
        } catch (Exception e10) {
            Log.e(TAG, e10.toString());
            return null;
        }
    }

    public T callWithException(Object... objArr) {
        try {
            return (T) this.mMethod.invoke(null, objArr);
        } catch (InvocationTargetException e10) {
            if (e10.getCause() != null) {
                throw e10.getCause();
            }
            throw e10;
        }
    }
}
