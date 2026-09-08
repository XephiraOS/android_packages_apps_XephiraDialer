package com.heytap.accessory;

/* loaded from: classes3.dex */
public class Config {
    public static final int OAF_LAN_VERSION = 20403;
    public static final int OAF_PAIR_MULTIWAY_VERSION = 30033;
    public static final int SDK_LAN_VERSION = 30005;
    private static final int SDK_VERSION = 30038;
    public static final int SDK_VERSION_20201 = 20201;
    private static final String SDK_VERSION_NAME = "3.0.38";
    private static final String TAG = "Config";

    /* loaded from: classes3.dex */
    public static final class Permission {
        public static final String AWAKENABLE = "com.heytap.accessory.permission.AWAKENABLE";
        public static final String DISCOVERY = "com.heytap.accessory.permission.DISCOVERY";
        public static final String MESSAGE = "com.heytap.accessory.permission.PUSH_MESSAGE";
    }

    private Config() {
    }

    public static int getSdkVersionCode() {
        return SDK_VERSION;
    }

    public static String getSdkVersionName() {
        return SDK_VERSION_NAME;
    }
}
