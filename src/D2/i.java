package D2;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.heytap.accessory.constant.FastPairConstants;
import com.internal_dependency.InternalSdkDepends;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: OplusMmiCode.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: i, reason: collision with root package name */
    public static Pattern f449i = Pattern.compile("((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)(.*)");

    /* renamed from: a, reason: collision with root package name */
    public String f450a;

    /* renamed from: b, reason: collision with root package name */
    public String f451b;

    /* renamed from: c, reason: collision with root package name */
    public String f452c;

    /* renamed from: d, reason: collision with root package name */
    public String f453d;

    /* renamed from: e, reason: collision with root package name */
    public String f454e;

    /* renamed from: f, reason: collision with root package name */
    public String f455f;

    /* renamed from: g, reason: collision with root package name */
    public String f456g;

    /* renamed from: h, reason: collision with root package name */
    public String f457h;

    public static boolean d(String str) {
        if (str != null) {
            String[] strArr = {"33", "331", "332", "35", "351", "330", "333", "353"};
            for (int i10 = 0; i10 < 8; i10++) {
                if (str.equals(strArr[i10])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(String str) {
        if (str != null && (str.equals("21") || str.equals("67") || str.equals("61") || str.equals("62") || str.equals(FastPairConstants.STATUS_CONNECT_RESULT_CANCEL) || str.equals("004"))) {
            return true;
        }
        return false;
    }

    public static boolean g(String str, Context context) {
        if (str == null || str.length() == 0 || context == null || ((TelephonyManager) context.getSystemService("phone")).isEmergencyNumber(str)) {
            return false;
        }
        return h(str, context);
    }

    public static boolean h(String str, Context context) {
        if (str == null || str.length() > 2 || (str.length() == 2 && str.charAt(0) == '1')) {
            return false;
        }
        return true;
    }

    public static boolean j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        i l10 = l(context, InternalSdkDepends.getSInstance().extractNetworkPortionAlt(PhoneNumberUtils.stripSeparators(str)));
        if (l10 == null || l10.i() || "08".equals(l10.f456g)) {
            return false;
        }
        if (l10.f() || l10.f456g != null) {
            return true;
        }
        String str2 = l10.f451b;
        if ((str2 != null && (str2.equals("30") || l10.f451b.equals("31") || e(l10.f451b) || d(l10.f451b) || l10.f451b.equals("03") || l10.f451b.equals("43") || l10.c())) || l10.f455f == null) {
            return false;
        }
        return true;
    }

    public static String k(String str) {
        if (str != null && str.length() == 0) {
            return null;
        }
        return str;
    }

    public static i l(Context context, String str) {
        Matcher matcher = f449i.matcher(str);
        if (matcher.matches()) {
            i iVar = new i();
            iVar.f455f = k(matcher.group(1));
            iVar.f450a = k(matcher.group(2));
            iVar.f451b = k(matcher.group(3));
            iVar.f452c = k(matcher.group(5));
            iVar.f453d = k(matcher.group(7));
            iVar.f454e = k(matcher.group(9));
            iVar.f457h = k(matcher.group(11));
            String k10 = k(matcher.group(12));
            iVar.f456g = k10;
            if (k10 != null && k10.endsWith("#") && str.endsWith("#")) {
                i iVar2 = new i();
                iVar2.f455f = str;
                return iVar2;
            }
            return iVar;
        }
        if (str.endsWith("#")) {
            i iVar3 = new i();
            iVar3.f455f = str;
            return iVar3;
        }
        if (g(str, context)) {
            i iVar4 = new i();
            iVar4.f456g = str;
            return iVar4;
        }
        return null;
    }

    public boolean a() {
        String str = this.f450a;
        if (str != null && str.equals("*")) {
            return true;
        }
        return false;
    }

    public boolean b() {
        String str = this.f450a;
        if (str != null && str.equals("#")) {
            return true;
        }
        return false;
    }

    public boolean c() {
        String str = this.f451b;
        if (str != null && (str.equals("04") || this.f451b.equals("042") || this.f451b.equals("05") || this.f451b.equals("052"))) {
            return true;
        }
        return false;
    }

    public boolean f() {
        String str;
        if (this.f455f == null && (str = this.f456g) != null && str.length() <= 2) {
            return true;
        }
        return false;
    }

    public boolean i() {
        String str = this.f451b;
        if (str != null && str.equals("31") && this.f456g != null && (a() || b())) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OplusMmiCode {");
        if (this.f450a != null) {
            sb.append(" action=" + this.f450a);
        }
        if (this.f451b != null) {
            sb.append(" sc=" + this.f451b);
        }
        if (this.f452c != null) {
            sb.append(" sia=" + this.f452c);
        }
        if (this.f453d != null) {
            sb.append(" sib=" + this.f453d);
        }
        if (this.f454e != null) {
            sb.append(" sic=" + this.f454e);
        }
        if (this.f455f != null) {
            sb.append(" poundString=" + this.f455f);
        }
        if (this.f456g != null) {
            sb.append(" dialingNumber=" + this.f456g);
        }
        if (this.f457h != null) {
            sb.append(" pwd=" + this.f457h);
        }
        sb.append("}");
        return sb.toString();
    }
}
