package com.heytap.accessory.bean;

/* loaded from: classes3.dex */
public class SdkUnsupportedException extends Exception {
    public static final int DEVICE_NOT_SUPPORTED = 1;
    public static final int LIBRARY_NOT_INSTALLED = 2;
    public static final int LIBRARY_UPDATE_IS_RECOMMENDED = 4;
    public static final int LIBRARY_UPDATE_IS_REQUIRED = 3;
    public static final int VENDOR_NOT_SUPPORTED = 0;
    private int mErrorType;

    public SdkUnsupportedException(String str, int i10) {
        super(str);
        this.mErrorType = i10;
    }

    public int getType() {
        return this.mErrorType;
    }
}
