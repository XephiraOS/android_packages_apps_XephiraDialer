package org.opencv.core;

/* loaded from: classes4.dex */
public class Algorithm {
    protected final long nativeObj;

    public Algorithm(long j10) {
        this.nativeObj = j10;
    }

    public static Algorithm __fromPtr__(long j10) {
        return new Algorithm(j10);
    }

    private static native void clear_0(long j10);

    private static native void delete(long j10);

    private static native boolean empty_0(long j10);

    private static native String getDefaultName_0(long j10);

    private static native void save_0(long j10, String str);

    public void clear() {
        clear_0(this.nativeObj);
    }

    public boolean empty() {
        return empty_0(this.nativeObj);
    }

    public void finalize() {
        delete(this.nativeObj);
    }

    public String getDefaultName() {
        return getDefaultName_0(this.nativeObj);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public void save(String str) {
        save_0(this.nativeObj, str);
    }
}
