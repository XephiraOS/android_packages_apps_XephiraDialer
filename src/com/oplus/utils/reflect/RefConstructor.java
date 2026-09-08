package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class RefConstructor<T> extends BaseRef<T> {
    private static final String TAG = "RefConstructor";
    private final Constructor<?> mConstructor;

    public RefConstructor(Class<?> cls, Field field) {
        super(field);
        this.mConstructor = load(cls, field);
    }

    private Constructor<?> load(Class<?> cls, Field field) {
        Constructor<?> declaredConstructor;
        Constructor<?> constructor = null;
        try {
            if (field.isAnnotationPresent(MethodName.class)) {
                declaredConstructor = cls.getDeclaredConstructor(((MethodName) field.getAnnotation(MethodName.class)).params());
            } else if (field.isAnnotationPresent(MethodSignature.class)) {
                String[] params = ((MethodSignature) field.getAnnotation(MethodSignature.class)).params();
                Class<?>[] clsArr = new Class[params.length];
                int i10 = 0;
                while (i10 < params.length) {
                    try {
                        clsArr[i10] = Class.forName(params[i10]);
                        i10++;
                    } catch (Exception e10) {
                        Log.e(TAG, e10.getMessage());
                    }
                }
                declaredConstructor = cls.getDeclaredConstructor(clsArr);
            } else {
                declaredConstructor = cls.getDeclaredConstructor(null);
            }
            constructor = declaredConstructor;
            if (constructor != null && !constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
        } catch (Exception e11) {
            Log.e(TAG, e11.getMessage());
        }
        return constructor;
    }

    private void printCauseMessage(InvocationTargetException invocationTargetException) {
        Throwable cause = invocationTargetException.getCause();
        if (cause != null) {
            Log.e(TAG, cause.getMessage());
        } else {
            Log.e(TAG, invocationTargetException.getMessage());
        }
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ void bindStub(Object obj) {
        super.bindStub(obj);
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public Class<?> getDeclaringClass() {
        if (!isEmpty()) {
            return this.mConstructor.getDeclaringClass();
        }
        return null;
    }

    @Override // com.oplus.utils.reflect.BaseRef, com.oplus.utils.reflect.IBaseRef
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.oplus.utils.reflect.IBaseRef
    public boolean isEmpty() {
        if (this.mConstructor == null) {
            return true;
        }
        return false;
    }

    public T newInstance() {
        try {
            return (T) this.mConstructor.newInstance(null);
        } catch (InvocationTargetException e10) {
            this.printCauseMessage(e10);
            return null;
        } catch (Exception e11) {
            Log.e(TAG, e11.getMessage());
            return null;
        }
    }

    public T newInstance(Object... objArr) {
        try {
            return (T) this.mConstructor.newInstance(objArr);
        } catch (InvocationTargetException e10) {
            this.printCauseMessage(e10);
            return null;
        } catch (Exception e11) {
            Log.e(TAG, e11.getMessage());
            return null;
        }
    }
}
