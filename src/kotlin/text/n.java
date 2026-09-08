package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.A;

/* compiled from: StringsJVM.kt */
/* loaded from: classes4.dex */
public class n extends m {
    public static String k(String str) {
        kotlin.jvm.internal.i.f(str, "<this>");
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.i.e(locale, "getDefault(...)");
        return l(str, locale);
    }

    public static final String l(String str, Locale locale) {
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(locale, "locale");
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    kotlin.jvm.internal.i.e(substring, "substring(...)");
                    kotlin.jvm.internal.i.d(substring, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = substring.toUpperCase(locale);
                    kotlin.jvm.internal.i.e(upperCase, "toUpperCase(...)");
                    sb.append(upperCase);
                }
                String substring2 = str.substring(1);
                kotlin.jvm.internal.i.e(substring2, "substring(...)");
                sb.append(substring2);
                String sb2 = sb.toString();
                kotlin.jvm.internal.i.e(sb2, "toString(...)");
                return sb2;
            }
            return str;
        }
        return str;
    }

    public static String m(char[] cArr) {
        kotlin.jvm.internal.i.f(cArr, "<this>");
        return new String(cArr);
    }

    public static final boolean n(String str, String suffix, boolean z10) {
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(suffix, "suffix");
        if (!z10) {
            return str.endsWith(suffix);
        }
        return r(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean o(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return n(str, str2, z10);
    }

    public static boolean p(String str, String str2, boolean z10) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        }
        if (!z10) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean q(CharSequence charSequence) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable C10 = StringsKt__StringsKt.C(charSequence);
            if (!(C10 instanceof Collection) || !((Collection) C10).isEmpty()) {
                Iterator it = C10.iterator();
                while (it.hasNext()) {
                    if (!b.c(charSequence.charAt(((A) it).a()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean r(String str, int i10, String other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(other, "other");
        if (!z10) {
            return str.regionMatches(i10, other, i11, i12);
        }
        return str.regionMatches(z10, i10, other, i11, i12);
    }

    public static final String s(String str, String oldValue, String newValue, boolean z10) {
        int b10;
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(oldValue, "oldValue");
        kotlin.jvm.internal.i.f(newValue, "newValue");
        int i10 = 0;
        int F10 = StringsKt__StringsKt.F(str, oldValue, 0, z10);
        if (F10 < 0) {
            return str;
        }
        int length = oldValue.length();
        b10 = B9.i.b(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i10, F10);
                sb.append(newValue);
                i10 = F10 + length;
                if (F10 >= str.length()) {
                    break;
                }
                F10 = StringsKt__StringsKt.F(str, oldValue, F10 + b10, z10);
            } while (F10 > 0);
            sb.append((CharSequence) str, i10, str.length());
            String sb2 = sb.toString();
            kotlin.jvm.internal.i.e(sb2, "toString(...)");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String t(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return s(str, str2, str3, z10);
    }

    public static final boolean u(String str, String prefix, boolean z10) {
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(prefix, "prefix");
        if (!z10) {
            return str.startsWith(prefix);
        }
        return r(str, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean v(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return u(str, str2, z10);
    }
}
