package com.oplus.utils.reflect;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class RefClass {
    private static final Class<? extends IBaseRef>[] REF_CLASSES;
    private static final HashMap<Class<? extends IBaseRef>, Constructor<? extends IBaseRef>> REF_TYPES = new HashMap<>();
    private static final String TAG = "RefClass";

    static {
        Class<? extends IBaseRef>[] clsArr = {RefObject.class, RefMethod.class, RefInt.class, RefLong.class, RefFloat.class, RefDouble.class, RefBoolean.class, RefByte.class, RefChar.class, RefShort.class, RefConstructor.class};
        REF_CLASSES = clsArr;
        try {
            for (Class<? extends IBaseRef> cls : clsArr) {
                REF_TYPES.put(cls, cls.getConstructor(Class.class, Field.class));
            }
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }

    private static Class<?> getRealClass(ClassLoader classLoader, String str) {
        if (str != null) {
            try {
                return Class.forName(str, false, classLoader);
            } catch (ClassNotFoundException e10) {
                Log.e(TAG, "Cannot find class : " + e10.getMessage());
                return null;
            }
        }
        return null;
    }

    public static Class<?> load(Class<?> cls, String str) {
        return load(cls, str, (Class<?>) null);
    }

    private static IBaseRef newInstance(Class<?> cls, Field field, Constructor<? extends IBaseRef> constructor) {
        try {
            return constructor.newInstance(cls, field);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            if (cls != null) {
                Log.e(TAG, "targetClass load : " + cls.getName(), e10);
                return null;
            }
            Log.e(TAG, "targetClass load : null");
            return null;
        }
    }

    public static Class<?> load(Class<?> cls, Class<?> cls2) {
        return load(cls, cls2, (Class<?>) null);
    }

    public static Class<?> load(Class<?> cls, String str, Class<?> cls2) {
        Class<?> realClass = getRealClass(cls.getClassLoader(), str);
        load(cls, realClass, cls2, (String) null);
        return realClass;
    }

    public static Class<?> load(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        load(cls, cls2, cls3, (String) null);
        return cls2;
    }

    public static RefConstructor<?> load(Class<?> cls, String str, Class<?> cls2, String str2) {
        return load(cls, getRealClass(cls.getClassLoader(), str), cls2, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.oplus.utils.reflect.RefConstructor<?> load(java.lang.Class<?> r11, java.lang.Class<?> r12, java.lang.Class<?> r13, java.lang.String r14) {
        /*
            if (r11 == 0) goto Ld3
            java.lang.String r0 = "RefClass"
            r1 = 0
            if (r13 == 0) goto L21
            java.lang.Object r2 = r13.newInstance()     // Catch: java.lang.Throwable -> Lc
            goto L22
        Lc:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            java.lang.String r4 = ".newInstance"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r0, r3, r2)
        L21:
            r2 = r1
        L22:
            java.lang.reflect.Field[] r3 = r11.getDeclaredFields()
            int r4 = r3.length
            r5 = 0
            r6 = r1
        L29:
            if (r5 >= r4) goto Ld2
            r7 = r3[r5]
            int r8 = r7.getModifiers()
            boolean r8 = java.lang.reflect.Modifier.isStatic(r8)
            if (r8 == 0) goto Lce
            int r8 = r7.getModifiers()
            boolean r8 = java.lang.reflect.Modifier.isFinal(r8)
            if (r8 == 0) goto L43
            goto Lce
        L43:
            r8 = 1
            r7.setAccessible(r8)     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.Object r8 = r7.get(r1)     // Catch: java.lang.IllegalAccessException -> L62
            if (r8 != 0) goto L9b
            java.util.HashMap<java.lang.Class<? extends com.oplus.utils.reflect.IBaseRef>, java.lang.reflect.Constructor<? extends com.oplus.utils.reflect.IBaseRef>> r8 = com.oplus.utils.reflect.RefClass.REF_TYPES     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.Class r9 = r7.getType()     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.Object r8 = r8.get(r9)     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.reflect.Constructor r8 = (java.lang.reflect.Constructor) r8     // Catch: java.lang.IllegalAccessException -> L62
            if (r8 == 0) goto Lce
            if (r12 == 0) goto L64
            com.oplus.utils.reflect.IBaseRef r9 = newInstance(r12, r7, r8)     // Catch: java.lang.IllegalAccessException -> L62
            goto L65
        L62:
            r7 = move-exception
            goto Lb6
        L64:
            r9 = r1
        L65:
            if (r9 == 0) goto L6d
            boolean r10 = r9.isEmpty()     // Catch: java.lang.IllegalAccessException -> L62
            if (r10 == 0) goto L73
        L6d:
            if (r12 == r13) goto L73
            com.oplus.utils.reflect.IBaseRef r9 = newInstance(r13, r7, r8)     // Catch: java.lang.IllegalAccessException -> L62
        L73:
            if (r9 != 0) goto L79
            com.oplus.utils.reflect.IBaseRef r9 = newInstance(r1, r7, r8)     // Catch: java.lang.IllegalAccessException -> L62
        L79:
            if (r9 == 0) goto L7e
            r9.bindStub(r2)     // Catch: java.lang.IllegalAccessException -> L62
        L7e:
            r7.set(r1, r9)     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.String r8 = r7.getName()     // Catch: java.lang.IllegalAccessException -> L62
            boolean r8 = r8.equals(r14)     // Catch: java.lang.IllegalAccessException -> L62
            if (r8 == 0) goto Lce
            java.lang.Class r7 = r7.getType()     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.Class<com.oplus.utils.reflect.RefConstructor> r8 = com.oplus.utils.reflect.RefConstructor.class
            boolean r7 = r7.equals(r8)     // Catch: java.lang.IllegalAccessException -> L62
            if (r7 == 0) goto Lce
            com.oplus.utils.reflect.RefConstructor r9 = (com.oplus.utils.reflect.RefConstructor) r9     // Catch: java.lang.IllegalAccessException -> L62
            r6 = r9
            goto Lce
        L9b:
            java.lang.UnsupportedOperationException r8 = new java.lang.UnsupportedOperationException     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.IllegalAccessException -> L62
            r9.<init>()     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.String r10 = "Already loaded : "
            r9.append(r10)     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.String r7 = r7.getName()     // Catch: java.lang.IllegalAccessException -> L62
            r9.append(r7)     // Catch: java.lang.IllegalAccessException -> L62
            java.lang.String r7 = r9.toString()     // Catch: java.lang.IllegalAccessException -> L62
            r8.<init>(r7)     // Catch: java.lang.IllegalAccessException -> L62
            throw r8     // Catch: java.lang.IllegalAccessException -> L62
        Lb6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r11.getName()
            r8.append(r9)
            java.lang.String r9 = ".load"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.util.Log.e(r0, r8, r7)
        Lce:
            int r5 = r5 + 1
            goto L29
        Ld2:
            return r6
        Ld3:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "mappingClass is null"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.reflect.RefClass.load(java.lang.Class, java.lang.Class, java.lang.Class, java.lang.String):com.oplus.utils.reflect.RefConstructor");
    }
}
