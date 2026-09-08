package com.heytap.accessory.bean;

/* loaded from: classes3.dex */
public class DiscoveryException extends GeneralException {
    public static final int ERROR_NONE = 0;
    public static final int ERROR_PARAMETER = 3;
    public static final int ERROR_REMOTE = 1;
    public static final int ERROR_UNINITIALIZED = 2;

    private DiscoveryException(int i10, String str) {
        super(i10, str);
    }

    public static DiscoveryException create(int i10, String str) {
        return new DiscoveryException(i10, str);
    }
}
