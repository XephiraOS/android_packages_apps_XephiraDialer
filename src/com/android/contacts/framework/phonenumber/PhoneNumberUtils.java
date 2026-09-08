package com.android.contacts.framework.phonenumber;

import M7.d;
import R0.b;
import android.text.TextUtils;
import android.util.Log;
import com.android.incallui.OplusPhoneUtils;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PhoneNumberUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String[]> f16315a = new HashMap<String, String[]>() { // from class: com.android.contacts.framework.phonenumber.PhoneNumberUtils.1
        {
            put("CN0086", new String[]{"+86", "0086"});
        }
    };

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if ('0' <= charAt && charAt <= '9') {
                sb.append(charAt);
            } else if (charAt == '+' || charAt == ',' || charAt == '*' || charAt == '#') {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        String a10 = a(str);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        if (a10.startsWith("+")) {
            a10 = a10.replaceFirst("\\+", "00");
        }
        int length = a10.length();
        if (length >= 11 && length <= 12 && a10.startsWith(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE) && a10.charAt(1) != '0') {
            a10 = a10.substring(1);
        }
        if (!a10.startsWith("00")) {
            return "0091" + a10;
        }
        return a10;
    }

    public static boolean c(String str) {
        int length;
        if (str == null) {
            length = 0;
        } else {
            length = str.length();
        }
        if (length <= 0) {
            return true;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (!android.telephony.PhoneNumberUtils.isNonSeparator(Character.toUpperCase(str.charAt(i10)))) {
                return false;
            }
        }
        return true;
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int z10 = PhoneNumberUtil.C().z(str2);
            arrayList.add("+" + z10);
            arrayList.add("00" + z10);
            if (str2 != null) {
                if (!str2.equals("RU")) {
                    if (str2.equals("KZ")) {
                    }
                }
                arrayList.add("8");
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (str.startsWith((String) arrayList.get(i10)) && str.length() > ((String) arrayList.get(i10)).length()) {
                    return str.substring(((String) arrayList.get(i10)).length());
                }
            }
        } catch (Throwable th) {
            Log.e("PhoneNumberUtils", "removeCountryPrefix e:" + th);
        }
        return str;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String b10 = d.b(b.a.f3181a, "CN");
        if (TextUtils.equals("CN", b10)) {
            b10 = b10 + "0086";
        }
        String[] strArr = f16315a.get(b10);
        if (strArr != null && strArr.length > 0) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (str.startsWith(strArr[i10]) && str.length() > strArr[i10].length()) {
                    return str.substring(strArr[i10].length());
                }
            }
        }
        return str;
    }

    public static String f(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.startsWith(str2)) {
                return str.substring(str2.length());
            }
        }
        return str;
    }
}
