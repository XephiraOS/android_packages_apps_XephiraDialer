package com.coui.appcompat.roundcorner;

import com.coui.appcompat.version.COUIVersionUtil;

/* loaded from: classes.dex */
public class RoundCornerUtil {
    private static final int SDK_SUB_VERSION_PATH_SUPPORT_SINGLE_CORNER = 12;
    public static final int SDK_SUB_VERSION_SUPPORT_BLUR = 10;
    public static final int SDK_VERSION = 34;

    public static boolean isPathSupportSingleCorner() {
        int oSVersionCode = COUIVersionUtil.getOSVersionCode();
        if (oSVersionCode > 34) {
            return true;
        }
        if (oSVersionCode == 34 && COUIVersionUtil.getSDKSubVersion() >= 12) {
            return true;
        }
        return false;
    }

    public static boolean isSupportRoundCornerWhenBlur() {
        int oSVersionCode = COUIVersionUtil.getOSVersionCode();
        if (oSVersionCode > 34) {
            return true;
        }
        if (oSVersionCode == 34 && COUIVersionUtil.getSDKSubVersion() >= 10) {
            return true;
        }
        return false;
    }

    public static boolean isVersionSupport() {
        if (COUIVersionUtil.getOSVersionCode() >= 34) {
            return true;
        }
        return false;
    }
}
