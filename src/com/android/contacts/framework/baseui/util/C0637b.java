package com.android.contacts.framework.baseui.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: ContactsNumberMaskUtil.java */
/* renamed from: com.android.contacts.framework.baseui.util.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0637b {

    /* renamed from: e, reason: collision with root package name */
    public static volatile C0637b f15887e;

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f15883a = Pattern.compile("^[0-9+()\\s,\\-]*");

    /* renamed from: b, reason: collision with root package name */
    public static final String f15884b = com.android.contacts.compat.data.f.a("customize_contacts_numbermask_switch");

    /* renamed from: c, reason: collision with root package name */
    public static final String f15885c = com.android.contacts.compat.data.f.a("customize_contacts_numbermask_masktype");

    /* renamed from: d, reason: collision with root package name */
    public static final int f15886d = 4;

    /* renamed from: f, reason: collision with root package name */
    public static int f15888f = 0;

    public static String a(String str) {
        String replaceAll = str.replaceAll("[^0-9]", "");
        String d10 = d(replaceAll);
        if (TextUtils.isEmpty(d10)) {
            return str;
        }
        return str.replace(replaceAll, d10);
    }

    public static C0637b b() {
        if (f15887e == null) {
            synchronized (C0637b.class) {
                try {
                    if (f15887e == null) {
                        f15887e = new C0637b();
                    }
                } finally {
                }
            }
        }
        return f15887e;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.matches(f15883a.pattern())) {
            return d(str);
        }
        return f(str);
    }

    public static String d(String str) {
        return e(str, f15888f);
    }

    public static String e(String str, int i10) {
        int i11;
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll(" ", "");
        int length = replaceAll.length();
        if (!TextUtils.isEmpty(replaceAll) && length >= 6 && !replaceAll.startsWith("400") && replaceAll.matches(f15883a.pattern())) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return replaceAll;
                }
                i11 = length - f15886d;
            } else {
                int i12 = f15886d;
                int i13 = (length - i12) / 2;
                length = i12 + i13;
                i11 = i13;
            }
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) replaceAll, 0, i11);
            sb.append("****");
            sb.append(replaceAll.substring(length));
            return sb.toString();
        }
        return replaceAll;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("联系人") && !str.startsWith("Contact") && !str.startsWith("contact")) {
            return str;
        }
        return a(str);
    }

    public static boolean h() {
        C0638c c0638c = C0638c.f15889a;
        if (!c0638c.b()) {
            return false;
        }
        f15888f = c0638c.a();
        return c0638c.c();
    }

    public void g() {
        com.android.contacts.framework.api.cloudsync.a.k(h());
    }
}
