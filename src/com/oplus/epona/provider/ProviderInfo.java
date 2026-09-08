package com.oplus.epona.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ProviderInfo {
    private String mClassName;
    private Map<String, Method> mMethodCache = new HashMap();
    private Map<String, ProviderMethodInfo> mMethods;
    private String mName;
    private boolean mNeedIPC;
    private boolean mNeedLog;

    public ProviderInfo(String str, String str2, Map<String, ProviderMethodInfo> map, boolean z10, boolean z11) {
        this.mName = str;
        this.mClassName = str2;
        this.mMethods = map;
        this.mNeedIPC = z10;
        this.mNeedLog = z11;
    }

    private Class<?>[] params(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i10 = 0; i10 < length; i10++) {
                clsArr[i10] = Class.forName(strArr[i10]);
            }
            return clsArr;
        }
        return null;
    }

    public boolean containsAction(String str) {
        Map<String, ProviderMethodInfo> map = this.mMethods;
        if (map == null) {
            return false;
        }
        return map.containsKey(str);
    }

    public String getClassName() {
        return this.mClassName;
    }

    public Method getMethod(String str) {
        Method method = this.mMethodCache.get(str);
        if (method != null) {
            return method;
        }
        ProviderMethodInfo providerMethodInfo = this.mMethods.get(str);
        try {
            Method declaredMethod = Class.forName(this.mClassName).getDeclaredMethod(providerMethodInfo.getMethodName(), params(providerMethodInfo.getMethodParams()));
            this.mMethodCache.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    public ProviderMethodInfo getMethodInfo(String str) {
        return this.mMethods.get(str);
    }

    public String getName() {
        return this.mName;
    }

    public boolean needIPC() {
        return this.mNeedIPC;
    }

    public boolean needLog() {
        return this.mNeedLog;
    }
}
