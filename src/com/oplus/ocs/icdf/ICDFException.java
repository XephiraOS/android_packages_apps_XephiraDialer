package com.oplus.ocs.icdf;

/* loaded from: classes3.dex */
public class ICDFException extends Exception {
    private int mErrorCode;

    public ICDFException() {
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public ICDFException(int i10, String str) {
        super(str);
        this.mErrorCode = i10;
    }

    public ICDFException(int i10, Throwable th) {
        super(th);
    }

    public ICDFException(int i10, String str, Throwable th) {
        super(str, th);
        this.mErrorCode = i10;
    }
}
