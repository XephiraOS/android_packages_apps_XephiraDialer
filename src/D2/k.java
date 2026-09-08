package D2;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* compiled from: ReflectionHelper.java */
/* loaded from: classes.dex */
public class k {
    public static Object a(Object obj, String str) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, null);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, null);
        } catch (IllegalAccessException e10) {
            Log.e("ReflectionHelper", "callDeclaredMethod IllegalAccessException caught : " + e10.getMessage());
            return null;
        } catch (IllegalArgumentException e11) {
            Log.e("ReflectionHelper", "callDeclaredMethod IllegalArgumentException caught : " + e11.getMessage());
            return null;
        } catch (NoSuchMethodException e12) {
            Log.e("ReflectionHelper", "callDeclaredMethod NoSuchMethodException caught : " + e12.getMessage());
            return null;
        } catch (Exception e13) {
            Log.e("ReflectionHelper", "callDeclaredMethod exception caught : " + e13.getMessage());
            return null;
        }
    }

    public static Object b(Object obj, String str, String str2, Class[] clsArr, Object[] objArr) {
        Log.d("ReflectionHelper", obj + " callDeclaredMethod : " + str + "." + str2);
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (ClassNotFoundException e10) {
            Log.e("ReflectionHelper", "callDeclaredMethod ClassNotFoundException caught : " + e10.getMessage());
            return null;
        } catch (IllegalAccessException e11) {
            Log.e("ReflectionHelper", "callDeclaredMethod IllegalAccessException caught : " + e11.getMessage());
            return null;
        } catch (IllegalArgumentException e12) {
            Log.e("ReflectionHelper", "callDeclaredMethod IllegalArgumentException caught : " + e12.getMessage());
            return null;
        } catch (NoSuchMethodException e13) {
            Log.e("ReflectionHelper", "callDeclaredMethod NoSuchMethodException caught : " + e13.getMessage());
            return null;
        } catch (Exception e14) {
            Log.e("ReflectionHelper", "callDeclaredMethod exception caught : " + e14.getMessage());
            return null;
        }
    }

    public static Object c(String str, Class[] clsArr, Object[] objArr) {
        Log.d("ReflectionHelper", " newInstanceByConstructor : " + str);
        try {
            Constructor<?> constructor = Class.forName(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (ClassNotFoundException e10) {
            Log.e("ReflectionHelper", "newInstanceByConstructor ClassNotFoundException caught : " + e10.getMessage());
            return null;
        } catch (IllegalAccessException e11) {
            Log.e("ReflectionHelper", "newInstanceByConstructor IllegalAccessException caught : " + e11.getMessage());
            return null;
        } catch (IllegalArgumentException e12) {
            Log.e("ReflectionHelper", "newInstanceByConstructor IllegalArgumentException caught : " + e12.getMessage());
            return null;
        } catch (InstantiationException e13) {
            Log.e("ReflectionHelper", "newInstanceByConstructor InstantiationException caught : " + e13.getMessage());
            return null;
        } catch (NoSuchMethodException e14) {
            Log.e("ReflectionHelper", "newInstanceByConstructor NoSuchMethodException caught : " + e14.getMessage());
            return null;
        } catch (Exception e15) {
            Log.e("ReflectionHelper", "newInstanceByConstructor exception caught : " + e15.getMessage());
            return null;
        }
    }
}
