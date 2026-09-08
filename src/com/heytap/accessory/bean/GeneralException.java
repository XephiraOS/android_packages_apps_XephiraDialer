package com.heytap.accessory.bean;

/* loaded from: classes3.dex */
public class GeneralException extends Exception {
    private int mErrorCode;

    public GeneralException() {
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public GeneralException(int i10, String str) {
        super(str);
        this.mErrorCode = i10;
    }

    public GeneralException(int i10, String str, Throwable th) {
        super(str, th);
        this.mErrorCode = i10;
    }
}
