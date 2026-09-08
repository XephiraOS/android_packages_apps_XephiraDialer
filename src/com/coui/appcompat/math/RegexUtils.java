package com.coui.appcompat.math;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class RegexUtils {
    public static final String REGEX_CN_BLANK_CARD = "^([1-9]{1})(\\d{14}|\\d{15}|\\d{16}|\\d{17}|\\d{18})$";
    public static final String REGEX_CN_MOBILE_EXACT = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|(147))\\d{8}$";
    public static final String REGEX_MOBILE_SIMPLE = "^[1]\\d{10}$";

    public static boolean isCnBankCardId(CharSequence charSequence) {
        return isMatch(REGEX_CN_BLANK_CARD, charSequence);
    }

    public static boolean isCnMobileExact(CharSequence charSequence) {
        return isMatch(REGEX_CN_MOBILE_EXACT, charSequence);
    }

    public static boolean isMatch(String str, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence)) {
            return true;
        }
        return false;
    }
}
