package h1;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import com.oplus.foundation.util.OsUtils;

/* compiled from: PhoneNumberCompat.java */
/* renamed from: h1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1072a {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '+') {
                if (!z10) {
                    z10 = true;
                } else {
                    continue;
                }
            }
            if (c(charAt)) {
                sb.append(charAt);
            } else if (e(charAt)) {
                break;
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            indexOf = str.indexOf("%40");
        }
        if (indexOf < 0) {
            H7.b.i("PhoneNumberCompat", "getUsernameFromUriNumber: no delimiter found in SIP addr '" + H7.a.d(str) + "'");
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static final boolean c(char c10) {
        if ((c10 < '0' || c10 > '9') && c10 != '*' && c10 != '#' && c10 != '+' && c10 != 'N') {
            return false;
        }
        return true;
    }

    public static boolean d(Context context, int i10, String str) {
        try {
            if (OsUtils.f28279e) {
                return ((TelephonyManager) context.getSystemService(TelephonyManager.class)).isEmergencyNumber(str);
            }
            return ((Boolean) PhoneNumberUtils.class.getMethod("isLocalEmergencyNumber", Context.class, Integer.TYPE, String.class).invoke(null, context, Integer.valueOf(i10), str)).booleanValue();
        } catch (Throwable th) {
            H7.b.c("PhoneNumberCompat", "isLocalEmergencyNumber  " + th.getMessage());
            return false;
        }
    }

    public static final boolean e(char c10) {
        if (c10 != ',' && c10 != ';') {
            return false;
        }
        return true;
    }

    public static boolean f(String str) {
        if (str != null && (str.contains("@") || str.contains("%40"))) {
            return true;
        }
        return false;
    }
}
