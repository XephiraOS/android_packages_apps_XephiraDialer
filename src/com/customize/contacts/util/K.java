package com.customize.contacts.util;

import com.customize.contacts.FeatureOption;
import java.util.Locale;

/* compiled from: LanguageUtils.java */
/* loaded from: classes3.dex */
public class K {
    public static String a() {
        String languageTag = Locale.getDefault().toLanguageTag();
        if (H7.a.b()) {
            H7.b.b("LanguageUtils", "sLanguageTag: " + languageTag);
        }
        return languageTag;
    }

    public static boolean b() {
        return a().startsWith("en");
    }

    public static boolean c() {
        return a().startsWith("ja");
    }

    public static boolean d() {
        String a10 = a();
        if (!a10.startsWith("zh-Hans") && !a10.equalsIgnoreCase("zh-CN")) {
            return false;
        }
        return true;
    }

    public static boolean e() {
        String a10 = a();
        if (!a10.equalsIgnoreCase("zh-CN") && !a10.startsWith("zh-Hans") && (!FeatureOption.i() || (!a10.equalsIgnoreCase("zh-TW") && !a10.equalsIgnoreCase("zh-HK") && !a10.startsWith("zh-Hant")))) {
            return false;
        }
        return true;
    }

    public static boolean f() {
        if (FeatureOption.o() && c()) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        String a10 = a();
        if (!FeatureOption.i() && !a10.equalsIgnoreCase("zh-CN") && !a10.startsWith("zh-Hans") && !a10.startsWith("en")) {
            return false;
        }
        return true;
    }

    public static boolean h() {
        String a10 = a();
        if (FeatureOption.o() && (a10.equalsIgnoreCase("zh-TW") || a10.equalsIgnoreCase("zh-Hant-TW"))) {
            return true;
        }
        return false;
    }
}
