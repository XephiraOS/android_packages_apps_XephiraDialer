package H7;

import M7.b;
import M7.d;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: ContactLogUtil.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1290a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1291b = false;

    public static void a(Context context) {
        f(context);
        f1291b = true;
    }

    public static boolean b() {
        return f1290a;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (!Character.isDigit(charAt) && charAt != '-' && charAt != '+') {
                return false;
            }
        }
        return true;
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 2) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            if (length > 7) {
                sb.append(str.substring(0, 3));
                sb.append("****");
                sb.append(str.substring(length - 4));
                return sb.toString();
            }
            if (length > 2) {
                sb.append(str.substring(0, 1));
                sb.append("****");
                sb.append(str.substring(length - 1));
                return sb.toString();
            }
            sb.append(str.substring(0, 1));
            sb.append("*");
            return sb.toString();
        }
        return str;
    }

    public static String e(Uri uri) {
        if (uri == null) {
            return "";
        }
        String uri2 = uri.toString();
        for (String str : uri.getPathSegments()) {
            if (c(str)) {
                uri2 = uri2.replace(str, d(str));
            }
        }
        return uri2;
    }

    public static void f(Context context) {
        boolean z10;
        try {
            boolean c10 = d.c("persist.sys.assert.panic", false);
            boolean c11 = d.c("persist.sys.alwayson.enable", false);
            boolean z11 = true;
            if (b.C0045b.a(2).f1798b.a(context.getContentResolver(), "contact.log.switch", 0) == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!c10 && !c11 && !z10) {
                z11 = false;
            }
            f1290a = z11;
            b.e("ContactLogUtil", "resetContactsDebug qeLogOpen = " + c10 + ", isAlwaysOn = " + c11 + ", contactDebug = " + z10);
        } catch (Exception e10) {
            f1290a = false;
            b.c("ContactLogUtil", "resetContactsDebug error" + e10);
        }
    }
}
