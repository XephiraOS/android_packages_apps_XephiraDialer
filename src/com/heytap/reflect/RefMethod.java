package com.heytap.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class RefMethod<T> {
    private static final String TAG = "RefMethod";
    private Method mMethod;

    public RefMethod(Class<?> cls, Field field) {
        if (field.isAnnotationPresent(MethodName.class)) {
            setMethod(cls, field, ((MethodName) field.getAnnotation(MethodName.class)).params(), ((MethodName) field.getAnnotation(MethodName.class)).name());
            this.mMethod.setAccessible(true);
        } else {
            int i10 = 0;
            if (field.isAnnotationPresent(MethodSignature.class)) {
                String[] params = ((MethodSignature) field.getAnnotation(MethodSignature.class)).params();
                Class<?>[] clsArr = new Class[params.length];
                while (i10 < params.length) {
                    Class<?> protoType = RefStaticMethod.getProtoType(params[i10]);
                    if (protoType == null) {
                        try {
                            protoType = Class.forName(params[i10]);
                        } catch (ClassNotFoundException e10) {
                            Log.e(TAG, e10.toString());
                        }
                    }
                    clsArr[i10] = protoType;
                    i10++;
                }
                setMethod(cls, field, clsArr, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
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

    private void setMethod(Class<?> cls, Field field, Class<?>[] clsArr, String str) {
        if (!str.isEmpty()) {
            this.mMethod = cls.getDeclaredMethod(str, clsArr);
        } else {
            this.mMethod = cls.getDeclaredMethod(field.getName(), clsArr);
        }
    }

    public T call(Object obj, Object... objArr) {
        try {
            return (T) this.mMethod.invoke(obj, objArr);
        } catch (InvocationTargetException e10) {
            if (e10.getCause() != null) {
                Log.e(TAG, e10.getCause().toString());
                return null;
            }
            Log.e(TAG, e10.toString());
            return null;
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return null;
        }
    }

    public T callWithException(Object obj, Object... objArr) {
        try {
            return (T) this.mMethod.invoke(obj, objArr);
        } catch (InvocationTargetException e10) {
            if (e10.getCause() != null) {
                throw e10.getCause();
            }
            throw e10;
        }
    }

    public Class<?>[] paramList() {
        return this.mMethod.getParameterTypes();
    }
}
