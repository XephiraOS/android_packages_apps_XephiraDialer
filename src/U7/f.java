package U7;

import android.database.DatabaseUtils;
import android.text.TextUtils;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.n;

/* compiled from: StringUtils.kt */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f3876a = new f();

    public static final String a(String[] phoneNumbers) {
        i.f(phoneNumbers, "phoneNumbers");
        int length = phoneNumbers.length;
        String[] strArr = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = DatabaseUtils.sqlEscapeString(phoneNumbers[i10]);
        }
        String join = TextUtils.join(",", strArr);
        i.e(join, "join(\",\", escapePhoneNumbers)");
        return join;
    }

    public static final boolean b(String str) {
        Regex regex = new Regex("[a-zA-Z]{2,3}");
        if (str == null || !regex.a(str)) {
            return false;
        }
        return true;
    }

    public static final boolean c(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && TextUtils.isGraphic(charSequence)) {
            return true;
        }
        return false;
    }

    public static final String d(String str) {
        String str2;
        String t10;
        String t11;
        String t12;
        String t13;
        String t14;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (str != null && str.length() != 0) {
            t10 = n.t(str, "(", "", false, 4, null);
            t11 = n.t(t10, ")", "", false, 4, null);
            t12 = n.t(t11, "-", "", false, 4, null);
            t13 = n.t(t12, " ", "", false, 4, null);
            t14 = n.t(t13, ".", "", false, 4, null);
            return t14;
        }
        return str2;
    }

    public static final String e(String str) {
        String str2;
        String t10;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (str != null && str.length() != 0) {
            t10 = n.t(str, "-", "", false, 4, null);
            return t10;
        }
        return str2;
    }

    public static final String f(String str) {
        String str2;
        String t10;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (str != null && str.length() != 0) {
            t10 = n.t(str, " ", "", false, 4, null);
            return t10;
        }
        return str2;
    }

    public static final String g(String str) {
        boolean y10;
        String t10;
        if (str != null) {
            y10 = StringsKt__StringsKt.y(str, " ", false, 2, null);
            if (y10) {
                t10 = n.t(str, " ", "", false, 4, null);
                return t10;
            }
            return str;
        }
        return str;
    }
}
