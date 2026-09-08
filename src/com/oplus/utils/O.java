package com.oplus.utils;

import android.util.Log;

/* compiled from: PhoneNumberCompat.java */
/* loaded from: classes3.dex */
public class O {
    public static String a(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            indexOf = str.indexOf("%40");
        }
        if (indexOf < 0) {
            Log.w("PhoneNumberCompat", "getUsernameFromUriNumber: no delimiter found in SIP addr '" + C0846g.f(str) + "'");
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static boolean b(String str) {
        if (str != null && (str.contains("@") || str.contains("%40"))) {
            return true;
        }
        return false;
    }
}
