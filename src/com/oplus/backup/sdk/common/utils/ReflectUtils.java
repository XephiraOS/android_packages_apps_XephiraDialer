package com.oplus.backup.sdk.common.utils;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static Object invoke(Object obj, Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            BRLog.e(TAG, "invoke, e =" + e10.getMessage());
            return null;
        } catch (IllegalArgumentException e11) {
            BRLog.e(TAG, "invoke, e =" + e11.getMessage());
            return null;
        } catch (NoSuchMethodException e12) {
            BRLog.e(TAG, "invoke, e =" + e12.getMessage());
            return null;
        } catch (InvocationTargetException e13) {
            BRLog.e(TAG, "invoke, e =" + e13.getMessage());
            return null;
        } catch (Exception e14) {
            BRLog.e(TAG, "invoke, e =" + e14.getMessage());
            return null;
        }
    }
}
