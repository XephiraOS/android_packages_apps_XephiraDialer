package com.oplus.utils;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: UriUtils.java */
/* loaded from: classes3.dex */
public class X {
    public static boolean a(Uri uri, Uri uri2) {
        if (uri == null && uri2 == null) {
            return true;
        }
        if (uri != null && uri2 != null) {
            return uri.equals(uri2);
        }
        return false;
    }

    public static boolean b(Uri uri, String str, boolean z10) {
        String queryParameter = uri.getQueryParameter(str);
        if (TextUtils.isEmpty(queryParameter)) {
            return z10;
        }
        return Boolean.parseBoolean(queryParameter);
    }

    public static Uri c(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    public static String d(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }
}
