package K9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DecoderUtil.java */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f1691a = Pattern.compile("(.*?)=\\?(.+?)\\?(\\w)\\?(.+?)\\?=", 32);

    public static String a(String str, String str2, c cVar) {
        return new String(b(str, cVar), str2);
    }

    public static byte[] b(String str, c cVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a aVar = new a(new ByteArrayInputStream(str.getBytes("US-ASCII")), cVar);
            while (true) {
                int read = aVar.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static String c(String str, c cVar) {
        StringBuilder sb = new StringBuilder();
        Matcher matcher = f1691a.matcher(str);
        int i10 = 0;
        boolean z10 = false;
        while (matcher.find()) {
            boolean z11 = true;
            String group = matcher.group(1);
            String i11 = i(matcher.group(2), matcher.group(3), matcher.group(4), cVar);
            if (i11 == null) {
                sb.append(matcher.group(0));
            } else {
                if (!z10 || !T9.c.b(group)) {
                    sb.append(group);
                }
                sb.append(i11);
            }
            int end = matcher.end();
            if (i11 == null) {
                z11 = false;
            }
            z10 = z11;
            i10 = end;
        }
        if (i10 == 0) {
            return str;
        }
        sb.append(str.substring(i10));
        return sb.toString();
    }

    public static String d(String str, String str2, c cVar) {
        return new String(e(h(str), cVar), str2);
    }

    public static byte[] e(String str, c cVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            e eVar = new e(new ByteArrayInputStream(str.getBytes("US-ASCII")), cVar);
            while (true) {
                int read = eVar.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static void f(c cVar, String str, String str2, String str3, String str4, String... strArr) {
        if (cVar.a()) {
            String g10 = g(str, str2, str3);
            StringBuilder sb = new StringBuilder();
            for (String str5 : strArr) {
                sb.append(str5);
            }
            sb.append(" (");
            sb.append(g10);
            sb.append(")");
            if (cVar.b(sb.toString(), str4)) {
                throw new IllegalArgumentException(sb.toString());
            }
        }
    }

    public static String g(String str, String str2, String str3) {
        return "=?" + str + "?" + str2 + "?" + str3 + "?=";
    }

    public static String h(String str) {
        StringBuilder sb = new StringBuilder(128);
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '_') {
                sb.append("=20");
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String i(String str, String str2, String str3, c cVar) {
        Charset c10 = T9.c.c(str);
        if (c10 == null) {
            f(cVar, str, str2, str3, "leaving word encoded", "Mime charser '", str, "' doesn't have a corresponding Java charset");
            return null;
        }
        if (str3.length() == 0) {
            f(cVar, str, str2, str3, "leaving word encoded", "Missing encoded text in encoded word");
            return null;
        }
        try {
            if (str2.equalsIgnoreCase("Q")) {
                return d(str3, c10.name(), cVar);
            }
            if (str2.equalsIgnoreCase("B")) {
                return a(str3, c10.name(), cVar);
            }
            f(cVar, str, str2, str3, "leaving word encoded", "Warning: Unknown encoding in encoded word");
            return null;
        } catch (UnsupportedEncodingException e10) {
            f(cVar, str, str2, str3, "leaving word encoded", "Unsupported encoding (", e10.getMessage(), ") in encoded word");
            return null;
        } catch (RuntimeException e11) {
            f(cVar, str, str2, str3, "leaving word encoded", "Could not decode (", e11.getMessage(), ") encoded word");
            return null;
        }
    }
}
