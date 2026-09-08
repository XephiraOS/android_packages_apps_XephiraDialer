package org.apache.james.mime4j.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes4.dex */
public final class MimeUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Random f35872a = new Random();

    /* renamed from: b, reason: collision with root package name */
    public static int f35873b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadLocal<DateFormat> f35874c = new a();

    /* loaded from: classes4.dex */
    public static final class Rfc822DateFormat extends SimpleDateFormat {
        private static final long serialVersionUID = 1;

        public Rfc822DateFormat() {
            super("EEE, d MMM yyyy HH:mm:ss ", Locale.US);
        }

        @Override // java.text.SimpleDateFormat, java.text.DateFormat
        public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            StringBuffer format = super.format(date, stringBuffer, fieldPosition);
            int i10 = ((((SimpleDateFormat) this).calendar.get(15) + ((SimpleDateFormat) this).calendar.get(16)) / 1000) / 60;
            if (i10 < 0) {
                format.append('-');
                i10 = -i10;
            } else {
                format.append('+');
            }
            format.append(String.format("%02d%02d", Integer.valueOf(i10 / 60), Integer.valueOf(i10 % 60)));
            return format;
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            return new Rfc822DateFormat();
        }
    }

    public static boolean a(String str) {
        return "base64".equalsIgnoreCase(str);
    }

    public static boolean b(String str) {
        if (str != null && str.equalsIgnoreCase("message/rfc822")) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        if (str != null && str.toLowerCase().startsWith("multipart/")) {
            return true;
        }
        return false;
    }

    public static boolean d(String str) {
        return "quoted-printable".equalsIgnoreCase(str);
    }

    public static boolean e(String str, String str2) {
        if (str != null && str2 != null && str.equalsIgnoreCase(str2)) {
            return true;
        }
        return false;
    }

    public static String f(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '\r' || charAt == '\n') {
                return g(str, i10);
            }
        }
        return str;
    }

    public static String g(String str, int i10) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        if (i10 > 0) {
            sb.append(str.substring(0, i10));
        }
        while (true) {
            i10++;
            if (i10 < length) {
                char charAt = str.charAt(i10);
                if (charAt != '\r' && charAt != '\n') {
                    sb.append(charAt);
                }
            } else {
                return sb.toString();
            }
        }
    }
}
