package com.oplus.phonenoareainquire.utils;

import android.text.TextUtils;
import c8.C0568b;
import java.util.Locale;
import kotlin.jvm.internal.i;
import kotlin.text.n;

/* compiled from: LocaleCompatUtil.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f28894a = new c();

    public static final String a() {
        boolean p10;
        boolean v10;
        boolean v11;
        boolean v12;
        boolean p11;
        boolean p12;
        boolean v13;
        boolean v14;
        String str;
        boolean o10;
        Locale locale = Locale.getDefault();
        String languageTag = locale.toLanguageTag();
        p10 = n.p(languageTag, "zh-CN", true);
        if (!p10) {
            i.c(languageTag);
            v10 = n.v(languageTag, "zh-Hans", false, 2, null);
            if (!v10) {
                v11 = n.v(languageTag, "bo", false, 2, null);
                if (!v11) {
                    v12 = n.v(languageTag, "ug", false, 2, null);
                    if (!v12) {
                        p11 = n.p(languageTag, "zh-TW", true);
                        if (!p11) {
                            p12 = n.p(languageTag, "zh-HK", true);
                            if (!p12) {
                                v13 = n.v(languageTag, "zh-Hant", false, 2, null);
                                if (v13) {
                                    o10 = n.o(languageTag, "TW", false, 2, null);
                                    if (!o10) {
                                        n.o(languageTag, "HK", false, 2, null);
                                    } else {
                                        return "TW";
                                    }
                                } else {
                                    v14 = n.v(languageTag, "en", false, 2, null);
                                    if (v14) {
                                        return "US";
                                    }
                                    if (C0568b.e()) {
                                        str = locale.getCountry();
                                    } else {
                                        str = "";
                                    }
                                    String str2 = str;
                                    i.c(str2);
                                    return str2;
                                }
                            }
                            return "HK";
                        }
                        return "TW";
                    }
                }
            }
        }
        return "CN";
    }

    public static final String b() {
        boolean v10;
        boolean v11;
        boolean o10;
        String languageTag = Locale.getDefault().toLanguageTag();
        i.c(languageTag);
        v10 = n.v(languageTag, "zh-Hans", false, 2, null);
        if (!v10) {
            v11 = n.v(languageTag, "zh-Hant", false, 2, null);
            if (v11) {
                o10 = n.o(languageTag, "TW", false, 2, null);
                if (!o10) {
                    n.o(languageTag, "HK", false, 2, null);
                    return "zh_HK";
                }
                return "zh_TW";
            }
            return languageTag;
        }
        return "zh_CN";
    }

    public static final boolean c(String language) {
        i.f(language, "language");
        return TextUtils.equals(language, "US");
    }
}
