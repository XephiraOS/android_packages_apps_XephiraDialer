package com.android.contacts.framework.vcard;

import com.android.incallui.OplusPhoneCapabilities;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: VCardConfig.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f16520a = "v21_generic";

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f16521b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<Integer> f16522c;

    static {
        HashMap hashMap = new HashMap();
        f16521b = hashMap;
        hashMap.put(f16520a, -1073741824);
        hashMap.put("v30_generic", -1073741823);
        hashMap.put("v21_europe", -1073741820);
        hashMap.put("v30_europe", -1073741819);
        hashMap.put("v21_japanese_utf8", -1073741816);
        hashMap.put("v30_japanese_utf8", -1073741815);
        hashMap.put("v21_japanese_mobile", 402653192);
        hashMap.put("docomo", 939524104);
        HashSet hashSet = new HashSet();
        f16522c = hashSet;
        hashSet.add(-1073741816);
        hashSet.add(-1073741815);
        hashSet.add(402653192);
        hashSet.add(939524104);
    }

    public static boolean a(int i10) {
        if (!g(i10) && (i10 & 67108864) == 0) {
            return false;
        }
        return true;
    }

    public static int b(int i10) {
        return i10 & 12;
    }

    public static int c(String str) {
        String lowerCase = str.toLowerCase();
        Map<String, Integer> map = f16521b;
        if (map.containsKey(lowerCase)) {
            return map.get(lowerCase).intValue();
        }
        if ("default".equalsIgnoreCase(str)) {
            return -1073741824;
        }
        H7.b.c(h.LOG_TAG, "Unknown vCard type String: \"" + str + "\"");
        return -1073741824;
    }

    public static boolean d(int i10) {
        if ((i10 & OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE) != 0) {
            return true;
        }
        return false;
    }

    public static boolean e(int i10) {
        return f16522c.contains(Integer.valueOf(i10));
    }

    public static boolean f(int i10) {
        if ((i10 & 3) == 0) {
            return true;
        }
        return false;
    }

    public static boolean g(int i10) {
        if ((i10 & 3) == 1) {
            return true;
        }
        return false;
    }

    public static boolean h(int i10) {
        if ((i10 & 3) == 2) {
            return true;
        }
        return false;
    }

    public static boolean i(int i10) {
        if ((i10 & 134217728) != 0) {
            return true;
        }
        return false;
    }

    public static boolean j(int i10) {
        if (i10 == 939524104) {
            return true;
        }
        return false;
    }

    public static boolean k(int i10) {
        if ((i10 & 33554432) != 0) {
            return true;
        }
        return false;
    }

    public static boolean l(int i10) {
        if (m(i10) && (i10 & OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE) == 0) {
            return false;
        }
        return true;
    }

    public static boolean m(int i10) {
        return !g(i10);
    }

    public static boolean n() {
        return false;
    }

    public static boolean o(int i10) {
        if ((i10 & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    public static boolean p(int i10) {
        if ((i10 & 1073741824) != 0) {
            return true;
        }
        return false;
    }
}
