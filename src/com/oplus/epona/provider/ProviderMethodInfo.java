package com.oplus.epona.provider;

/* loaded from: classes3.dex */
public class ProviderMethodInfo {
    private String mMethodName;
    private String[] mMethodParams;

    public ProviderMethodInfo(String str, String[] strArr) {
        this.mMethodName = str;
        this.mMethodParams = strArr;
    }

    public String getMethodName() {
        return this.mMethodName;
    }

    public String[] getMethodParams() {
        return this.mMethodParams;
    }
}
