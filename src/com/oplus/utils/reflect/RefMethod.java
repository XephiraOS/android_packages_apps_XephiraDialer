package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class RefMethod<T> extends BaseRef<T> {
    private static final String TAG = "RefMethod";
    private final Method mMethod;

    public RefMethod(Class<?> cls, Field field) {
        super(field);
        this.mMethod = load(cls, field);
    }

    private Method getMethod(Class<?> cls, Field field, Class<?>[] clsArr, String str) {
        if (!str.isEmpty()) {
            return cls.getDeclaredMethod(str, clsArr);
        }
        return cls.getDeclaredMethod(field.getName(), clsArr);
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

    private Method load(Class<?> cls, Field field) {
        Class<?> cls2;
        Method method = null;
        try {
            if (field.isAnnotationPresent(MethodName.class)) {
                Method method2 = getMethod(cls, field, ((MethodName) field.getAnnotation(MethodName.class)).params(), ((MethodName) field.getAnnotation(MethodName.class)).name());
                method2.setAccessible(true);
                return method2;
            }
            int i10 = 0;
            if (field.isAnnotationPresent(MethodSignature.class)) {
                String[] params = ((MethodSignature) field.getAnnotation(MethodSignature.class)).params();
                Class<?>[] clsArr = new Class[params.length];
                Class<?>[] clsArr2 = new Class[params.length];
                boolean z10 = false;
                for (int i11 = 0; i11 < params.length; i11++) {
                    Class<?> protoType = getProtoType(params[i11]);
                    if (protoType == null) {
                        try {
                            protoType = Class.forName(params[i11]);
                        } catch (ClassNotFoundException e10) {
                            Log.e(TAG, e10.getMessage());
                        }
                    }
                    clsArr[i11] = protoType;
                    if ("java.util.HashSet".equals(params[i11])) {
                        try {
                            cls2 = Class.forName("android.util.ArraySet");
                        } catch (ClassNotFoundException e11) {
                            Log.e(TAG, e11.getMessage());
                            cls2 = protoType;
                        }
                        if (cls2 != null) {
                            clsArr2[i11] = cls2;
                        } else {
                            clsArr2[i11] = protoType;
                        }
                        z10 = true;
                    } else {
                        clsArr2[i11] = protoType;
                    }
                }
                try {
                    method = getMethod(cls, field, clsArr, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                } catch (Exception e12) {
                    Log.e(TAG, e12.getMessage());
                    if (z10) {
                        method = getMethod(cls, field, clsArr2, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                    }
                }
                Class<?>[] clsArr3 = new Class[params.length];
                while (i10 < params.length) {
                    Class<?> protoType2 = getProtoType(params[i10]);
                    if (protoType2 == null) {
                        try {
                            protoType2 = Class.forName(params[i10]);
                        } catch (ClassNotFoundException e13) {
                            Log.e(TAG, e13.getMessage());
                        }
                    }
                    clsArr3[i10] = protoType2;
                    i10++;
                }
                Method method3 = getMethod(cls, field, clsArr3, ((MethodSignature) field.getAnnotation(MethodSignature.class)).name());
                method3.setAccessible(true);
                return method3;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            while (i10 < length) {
                Method method4 = declaredMethods[i10];
                if (method4.getName().equals(field.getName())) {
                    try {
                        method4.setAccessible(true);
                        return method4;
                    } catch (Exception e14) {
                        e = e14;
                        method = method4;
                        Log.e(TAG, e.getMessage());
                        return method;
                    }
                }
                i10++;
            }
            return null;
        } catch (Exception e15) {
            e = e15;
            Log.e(TAG, e.getMessage());
            return method;
        }
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    public T call(Object obj, Object... objArr) {
        return callWithDefault(obj, null, objArr);
    }

    public T callWithDefault(Object obj, T t10, Object... objArr) {
        try {
            return callWithException(obj, objArr);
        } catch (Throwable th) {
            Log.e(TAG, th.getMessage());
            if (t10 != null) {
                return t10;
            }
            return this.getDefaultValue();
        }
    }

    public T callWithException(Object obj, Object... objArr) {
        try {
            return (T) this.mMethod.invoke(checkStub(obj), objArr);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause != null) {
                throw cause;
            }
            throw e10;
        }
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public Class<?> getDeclaringClass() {
        if (!isEmpty()) {
            return this.mMethod.getDeclaringClass();
        }
        return null;
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        if (this.mMethod == null) {
            return true;
        }
        return false;
    }
}
