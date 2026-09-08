package com.oplus.utils;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Locale;
import java.util.regex.Pattern;

/* compiled from: ContactsNumberMaskUtil.java */
/* renamed from: com.oplus.utils.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0856q {

    /* renamed from: a, reason: collision with root package name */
    public static Pattern f29180a = Pattern.compile("^[0-9+()\\s,\\-]*");

    /* renamed from: b, reason: collision with root package name */
    public static final String f29181b = F6.e.e();

    /* renamed from: c, reason: collision with root package name */
    public static final String f29182c = F6.e.f();

    /* renamed from: d, reason: collision with root package name */
    public static final int f29183d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static int f29184e = 0;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f29185f = false;

    public static String a(String str) {
        String replaceAll = str.replaceAll("[^0-9]", "");
        String c10 = c(replaceAll);
        if (TextUtils.isEmpty(c10)) {
            return str;
        }
        return str.replace(replaceAll, c10);
    }

    public static String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (h(context)) {
            if (str.matches(f29180a.pattern())) {
                return c(str);
            }
            return e(str);
        }
        return str;
    }

    public static String c(String str) {
        return d(str, f29184e);
    }

    public static String d(String str, int i10) {
        int i11;
        if (str == null) {
            return null;
        }
        String replaceAll = str.replaceAll(" ", "");
        int length = replaceAll.length();
        if (!TextUtils.isEmpty(replaceAll) && length >= 6 && !replaceAll.startsWith("400") && replaceAll.matches(f29180a.pattern())) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return replaceAll;
                }
                i11 = length - f29183d;
            } else {
                int i12 = f29183d;
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

    public static String e(String str) {
        return f(str, "");
    }

    public static String f(String str, String str2) {
        if (str == null) {
            return "";
        }
        if (str.equals(str2)) {
            return c(str2);
        }
        if (!str.startsWith("联系人") && !str.startsWith("Contact")) {
            return str;
        }
        return a(str);
    }

    public static String g(Context context, String str) {
        if (h(context) && !TextUtils.isEmpty(str)) {
            PhoneNumberUtil C10 = PhoneNumberUtil.C();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String simCountryIso = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso();
            if (TextUtils.isEmpty(simCountryIso)) {
                simCountryIso = "cn";
            }
            for (L4.c cVar : C10.o(sb.toString(), simCountryIso.toUpperCase(Locale.US), PhoneNumberUtil.Leniency.POSSIBLE, Long.MAX_VALUE)) {
                sb.replace(cVar.c(), cVar.a(), a(PhoneNumberUtils.normalizeNumber(cVar.b())));
            }
            return sb.toString();
        }
        return str;
    }

    public static boolean h(Context context) {
        if (!G.d(context)) {
            return false;
        }
        f29184e = G.c(context);
        f29185f = G.e(context);
        C0846g.i("ContactsNumberMaskUtil", "supportContactsNumberMask sIsContactNumberMask " + f29185f);
        return f29185f;
    }
}
