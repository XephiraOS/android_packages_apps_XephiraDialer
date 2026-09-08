package w1;

import android.util.Base64DataException;
import android.util.Base64InputStream;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: MimeUtility.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f37601a = Pattern.compile("\r|\n");

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return K9.d.c(str, K9.c.f1689a);
    }

    public static com.android.contacts.voicemail.impl.mail.a b(InputStream inputStream, String str) {
        InputStream d10 = d(inputStream, str);
        C1644a c1644a = new C1644a();
        OutputStream c10 = c1644a.c();
        try {
            I9.a.c(d10, c10);
        } catch (Base64DataException unused) {
        } catch (Throwable th) {
            c10.close();
            throw th;
        }
        c10.close();
        return c1644a;
    }

    public static String c(String str, String str2) {
        if (str == null) {
            return null;
        }
        String[] split = f(str).split(Constants.DataMigration.SPLIT_TAG);
        if (str2 == null) {
            return split[0].trim();
        }
        String lowerCase = str2.toLowerCase();
        for (String str3 : split) {
            if (str3.trim().toLowerCase().startsWith(lowerCase)) {
                String[] split2 = str3.split("=", 2);
                if (split2.length < 2) {
                    return null;
                }
                String trim = split2[1].trim();
                if (trim.startsWith("\"") && trim.endsWith("\"")) {
                    return trim.substring(1, trim.length() - 1);
                }
                return trim;
            }
        }
        return null;
    }

    public static InputStream d(InputStream inputStream, String str) {
        InputStream base64InputStream;
        if (str != null) {
            String c10 = c(str, null);
            if ("quoted-printable".equalsIgnoreCase(c10)) {
                base64InputStream = new K9.e(inputStream);
            } else if ("base64".equalsIgnoreCase(c10)) {
                base64InputStream = new Base64InputStream(inputStream, 0);
            } else {
                return inputStream;
            }
            return base64InputStream;
        }
        return inputStream;
    }

    public static boolean e(String str, String str2) {
        return Pattern.compile(str2.replaceAll("\\*", "\\.\\*"), 2).matcher(str).matches();
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f37601a.matcher(str);
        if (matcher.find()) {
            matcher.reset();
            return matcher.replaceAll("");
        }
        return str;
    }

    public static String g(String str) {
        return a(f(str));
    }
}
