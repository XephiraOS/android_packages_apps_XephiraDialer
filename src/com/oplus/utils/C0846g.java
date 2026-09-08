package com.oplus.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import c7.C0566b;
import java.util.List;
import v6.C1627a;

/* compiled from: BlacklistLogUtil.java */
/* renamed from: com.oplus.utils.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0846g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f29140a = false;

    public static void a(Context context) {
        l(context);
    }

    public static boolean b() {
        try {
            return C0566b.c("persist.sys.alwayson.enable", false);
        } catch (Exception e10) {
            Log.e("BlacklistLogUtil", "isPanicOpen is error, the e is " + e10);
            return false;
        }
    }

    public static boolean c() {
        return f29140a;
    }

    public static boolean d() {
        try {
            return C0566b.c("persist.sys.assert.panic", false);
        } catch (Exception e10) {
            Log.e("BlacklistLogUtil", "isPanicOpen is error, the e is " + e10);
            return false;
        }
    }

    public static boolean e(String str) {
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

    public static String f(String str) {
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

    public static String g(String str) {
        if (str == null) {
            return "";
        }
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 1;
            if (str.charAt(i10) != '\'') {
                i10 = i11;
            } else {
                int i12 = i11;
                while (true) {
                    if (i12 >= str.length()) {
                        break;
                    }
                    if (str.charAt(i12) == '\'') {
                        String substring = str.substring(i11, i12);
                        if (e(substring)) {
                            String f10 = f(substring);
                            str = str.replace(substring, f10);
                            i10 = i12 + 1 + (f10.length() - substring.length());
                        } else {
                            i10 = i12 + 1;
                        }
                    } else {
                        i12++;
                    }
                }
                if (i12 == str.length()) {
                    break;
                }
            }
        }
        return str;
    }

    public static String h(Uri uri) {
        if (uri == null) {
            return "";
        }
        String uri2 = uri.toString();
        List<String> pathSegments = uri.getPathSegments();
        String queryParameter = uri.getQueryParameter("number");
        if (queryParameter != null && e(queryParameter)) {
            uri2 = uri2.replace(queryParameter, f(queryParameter));
        }
        for (String str : pathSegments) {
            if (e(str)) {
                uri2 = uri2.replace(str, f(str));
            }
        }
        return uri2;
    }

    public static void i(String str, String str2) {
        if (c()) {
            Log.d(str, str2);
        }
    }

    public static void j(String str, String str2) {
        Log.e(str, str2);
    }

    public static void k(String str, String str2) {
        Log.i(str, str2);
    }

    public static void l(Context context) {
        boolean z10;
        boolean z11 = true;
        try {
        } catch (Exception e10) {
            Log.e("BlacklistLogUtil", "resetBlacklistDebug error" + e10);
        }
        if (z6.b.c(context, 0, "blacklist.log.switch", 0) == 1) {
            z10 = true;
            boolean d10 = d();
            boolean b10 = b();
            if (!z10 && !d10 && !b10) {
                z11 = false;
            }
            f29140a = z11;
            C1627a.n();
        }
        z10 = false;
        boolean d102 = d();
        boolean b102 = b();
        if (!z10) {
            z11 = false;
        }
        f29140a = z11;
        C1627a.n();
    }
}
