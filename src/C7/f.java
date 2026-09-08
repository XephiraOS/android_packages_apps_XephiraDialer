package C7;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: Utils.java */
/* loaded from: classes3.dex */
public class f {
    public static boolean a() {
        String languageTag = Locale.getDefault().toLanguageTag();
        if (!TextUtils.isEmpty(languageTag) && (languageTag.startsWith("zh-Hans") || languageTag.equalsIgnoreCase("zh-CN"))) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        return "true".equals(M7.d.a("ro.version.softwareconfidential"));
    }

    public static int c(String str, int i10) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Exception e10) {
                H7.b.c("Utils", "parseInt: Exception: " + e10);
            }
        }
        return i10;
    }

    public static long d(String str, long j10) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (Exception e10) {
                H7.b.c("Utils", "parseLong: Exception: " + e10);
            }
        }
        return j10;
    }
}
