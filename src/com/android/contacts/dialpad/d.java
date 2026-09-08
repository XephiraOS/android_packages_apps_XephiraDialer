package com.android.contacts.dialpad;

import R0.d;
import android.net.Uri;
import com.customize.contacts.util.K;

/* compiled from: DialpadOptions.java */
/* loaded from: classes.dex */
public class d {
    public static int a() {
        String a10 = K.a();
        if (H7.a.b()) {
            H7.b.b("DialpadOptions", "languageTag = " + a10);
        }
        if (a10.startsWith("th")) {
            return 4;
        }
        if (a10.startsWith("vi")) {
            return 5;
        }
        if (a10.startsWith("ru")) {
            return 7;
        }
        if (!a10.equalsIgnoreCase("zh-TW") && !a10.equalsIgnoreCase("zh-Hant-TW")) {
            if (a10.startsWith("uk")) {
                return 9;
            }
            return 6;
        }
        return 8;
    }

    public static Uri b(int i10, String str) {
        Uri uri;
        if (i10 == 0) {
            uri = d.a.f3232a;
        } else if (i10 == 1) {
            uri = d.a.f3233b;
        } else if (i10 == 4) {
            uri = d.a.f3237f;
        } else if (i10 == 5) {
            uri = d.a.f3238g;
        } else if (i10 == 6) {
            uri = d.a.f3239h;
        } else if (i10 == 7) {
            uri = d.a.f3240i;
        } else if (i10 == 8) {
            uri = d.a.f3241j;
        } else if (i10 == 9) {
            uri = d.a.f3242k;
        } else {
            uri = d.a.f3232a;
        }
        return Uri.withAppendedPath(uri, Uri.encode(str));
    }

    public static boolean c(int i10) {
        if (i10 == 0 || i10 == 1 || i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7 || i10 == 8 || i10 == 9) {
            return true;
        }
        return false;
    }
}
