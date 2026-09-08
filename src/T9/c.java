package T9;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

/* compiled from: CharsetUtil.java */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f3787a;

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f3788b;

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f3789c;

    /* renamed from: d, reason: collision with root package name */
    public static final Charset f3790d;

    static {
        Charset forName = Charset.forName("US-ASCII");
        f3787a = forName;
        f3788b = Charset.forName("ISO-8859-1");
        f3789c = Charset.forName("UTF-8");
        f3790d = forName;
    }

    public static boolean a(char c10) {
        if (c10 != ' ' && c10 != '\t' && c10 != '\r' && c10 != '\n') {
            return false;
        }
        return true;
    }

    public static boolean b(String str) {
        if (str != null) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                if (!a(str.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("String may not be null");
    }

    public static Charset c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalCharsetNameException | UnsupportedCharsetException unused) {
            return null;
        }
    }
}
