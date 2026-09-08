package U7;

import java.util.Locale;

/* compiled from: FormatUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static String a(int i10, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return String.format(locale, "%02d", Integer.valueOf(i10));
    }

    public static String b(int i10) {
        return String.format(Locale.getDefault(), "%d", Integer.valueOf(i10));
    }

    public static String c(int i10, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return String.format(locale, "%d", Integer.valueOf(i10));
    }

    public static String d(String str) {
        String replace = str.replace("\\+", "");
        String substring = replace.substring(1, replace.length() - 1);
        return replace.replace(substring, b(Integer.parseInt(substring)) + "+");
    }
}
