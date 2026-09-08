package com.coui.appcompat.version;

/* loaded from: classes3.dex */
public class COUICompatUtil {
    private static volatile COUICompatUtil sINSTANCE;
    private static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.'};
    private static final int[] VIEW_NATIVE_INDEX = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 21, 8, 4, 22, 52, 47, 8, 4, 22, 48, 17, 0, 15, 15, 4, 17};
    private static final int[] BUILD_INDEX = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 14, 18, 52, 28, 14, 11, 14, 17, 27, 20, 8, 11, 3};
    private static final int[] OSVERSION_INDEX = {6, 4, 19, 28, 14, 11, 14, 17, 40, 44, 47, 30, 43, 44, 34, 40, 39};
    private static final int[] CONFIGURATION_INDEX = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 2, 14, 13, 19, 4, 13, 19, 52, 17, 4, 18, 52, 28, 14, 13, 5, 8, 6, 20, 17, 0, 19, 8, 14, 13, 48, 17, 0, 15, 15, 4, 17};
    private static final int[] BASE_VIEW_INDEX = {0, 13, 3, 17, 14, 8, 3, 52, 21, 8, 4, 22, 52, 40, 15, 15, 14, 27, 0, 18, 4, 47, 8, 4, 22};
    private static final int[] CLICK_TOP_INDEX = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 2, 11, 8, 2, 10, 19, 14, 15};
    private static final int[] LIST_VIEW_INDEX = {2, 14, 12, 52, 2, 14, 11, 14, 17, 52, 8, 13, 13, 4, 17, 52, 22, 8, 3, 6, 4, 19, 52, 26, 1, 18, 37, 8, 18, 19, 47, 8, 4, 22, 48, 17, 0, 15, 15, 4, 17};
    private static final int[] THEME_VERSION_INDEX = {17, 14, 52, 14, 15, 15, 14, 52, 19, 7, 4, 12, 4, 52, 21, 4, 17, 18, 8, 14, 13};

    private COUICompatUtil() {
    }

    public static COUICompatUtil getInstance() {
        if (sINSTANCE == null) {
            synchronized (COUICompatUtil.class) {
                try {
                    if (sINSTANCE == null) {
                        sINSTANCE = new COUICompatUtil();
                    }
                } finally {
                }
            }
        }
        return sINSTANCE;
    }

    public String getAbsListViewName() {
        int length = LIST_VIEW_INDEX.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = CHARS[LIST_VIEW_INDEX[i10]];
        }
        return String.valueOf(cArr);
    }

    public String getBaseViewName() {
        int length = BASE_VIEW_INDEX.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = CHARS[BASE_VIEW_INDEX[i10]];
        }
        return String.valueOf(cArr);
    }

    public String getClickTopName() {
        int length = CLICK_TOP_INDEX.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = CHARS[CLICK_TOP_INDEX[i10]];
        }
        return String.valueOf(cArr);
    }

    public String getConfigurationName() {
        int length = CONFIGURATION_INDEX.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = CHARS[CONFIGURATION_INDEX[i10]];
        }
        return String.valueOf(cArr);
    }

    public String getOsBuildName() {
        int length = BUILD_INDEX.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = CHARS[BUILD_INDEX[i10]];
        }
        return String.valueOf(cArr);
    }

    public String getOsVersionMethodName() {
        int length = OSVERSION_INDEX.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = CHARS[OSVERSION_INDEX[i10]];
        }
        return String.valueOf(cArr);
    }

    public String getThemeVerisonName() {
        int length = THEME_VERSION_INDEX.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = CHARS[THEME_VERSION_INDEX[i10]];
        }
        return String.valueOf(cArr);
    }

    public String getViewNativeName() {
        int length = VIEW_NATIVE_INDEX.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = CHARS[VIEW_NATIVE_INDEX[i10]];
        }
        return String.valueOf(cArr);
    }
}
