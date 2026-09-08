package F7;

import android.content.Context;
import android.text.TextUtils;
import com.coui.appcompat.calendar.COUIDateMonthView;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: DateUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f1003a = TimeZone.getTimeZone("UTC");

    /* renamed from: b, reason: collision with root package name */
    public static final SimpleDateFormat f1004b;

    /* renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f1005c;

    /* renamed from: d, reason: collision with root package name */
    public static final SimpleDateFormat f1006d;

    /* renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f1007e;

    /* renamed from: f, reason: collision with root package name */
    public static final SimpleDateFormat f1008f;

    /* renamed from: g, reason: collision with root package name */
    public static final SimpleDateFormat f1009g;

    /* renamed from: h, reason: collision with root package name */
    public static final SimpleDateFormat[] f1010h;

    /* renamed from: i, reason: collision with root package name */
    public static final SimpleDateFormat[] f1011i;

    /* renamed from: j, reason: collision with root package name */
    public static final DateFormat f1012j;

    /* renamed from: k, reason: collision with root package name */
    public static final DateFormat f1013k;

    static {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("--MM-dd", locale);
        f1004b = simpleDateFormat;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd", locale);
        f1005c = simpleDateFormat2;
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", locale);
        f1006d = simpleDateFormat3;
        f1007e = new SimpleDateFormat("--MM-dd'T'HH:mm:ss.SSS'Z'", locale);
        f1008f = new SimpleDateFormat("yyyyMMdd", locale);
        f1009g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat[] simpleDateFormatArr = {simpleDateFormat2, simpleDateFormat3, new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", locale), new SimpleDateFormat("yyyyMMdd", locale), new SimpleDateFormat("yyyyMMdd'T'HHmmssSSS'Z'", locale), new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", locale), new SimpleDateFormat("yyyyMMdd'T'HHmm'Z'", locale)};
        f1010h = simpleDateFormatArr;
        f1011i = new SimpleDateFormat[]{simpleDateFormat, new SimpleDateFormat("MM-dd", locale), new SimpleDateFormat("MMdd", locale)};
        f1012j = new SimpleDateFormat("MMMM dd");
        f1013k = new SimpleDateFormat("dd MMMM");
        for (SimpleDateFormat simpleDateFormat4 : simpleDateFormatArr) {
            simpleDateFormat4.setLenient(true);
            simpleDateFormat4.setTimeZone(f1003a);
        }
        for (SimpleDateFormat simpleDateFormat5 : f1011i) {
            simpleDateFormat5.setTimeZone(f1003a);
        }
        SimpleDateFormat simpleDateFormat6 = f1004b;
        TimeZone timeZone = f1003a;
        simpleDateFormat6.setTimeZone(timeZone);
        f1012j.setTimeZone(timeZone);
        f1013k.setTimeZone(timeZone);
    }

    public static String a(long j10, GregorianCalendar gregorianCalendar, DateFormat dateFormat, DateFormat dateFormat2, String str) {
        long timeInMillis = gregorianCalendar.getTimeInMillis() - j10;
        long j11 = (gregorianCalendar.get(11) * 3600000) + (gregorianCalendar.get(12) * 60000) + (gregorianCalendar.get(13) * 1000);
        if (timeInMillis < 0) {
            if ((-timeInMillis) < 86400000 - j11) {
                return dateFormat.format(Long.valueOf(j10));
            }
            return dateFormat2.format(Long.valueOf(j10));
        }
        if (timeInMillis < j11) {
            return dateFormat.format(Long.valueOf(j10));
        }
        if (timeInMillis >= j11 + 86400000) {
            return dateFormat2.format(Long.valueOf(j10));
        }
        return str;
    }

    public static String b(Context context, String str) {
        return c(context, str, true);
    }

    public static String c(Context context, String str, boolean z10) {
        Calendar q10;
        DateFormat f10;
        String format;
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return trim;
        }
        String i10 = i(trim);
        if (i10 != null) {
            q10 = q(i10, false);
        } else {
            q10 = q(trim, true);
        }
        if (q10 == null) {
            return trim;
        }
        if (!p(q10)) {
            f10 = d(context);
        } else {
            f10 = f(context, z10);
        }
        synchronized (f10) {
            f10.setTimeZone(f1003a);
            format = f10.format(q10.getTime());
        }
        return format;
    }

    public static DateFormat d(Context context) {
        String str;
        String str2;
        String pattern = ((SimpleDateFormat) DateFormat.getDateInstance(1)).toPattern();
        if (pattern.contains("de")) {
            str = "[^Mm]*[Yy]+[^Mm]*";
        } else {
            str = "[^DdMm]*[Yy]+[^DdMm]*";
        }
        try {
            return new SimpleDateFormat(pattern.replaceAll(str, ""));
        } catch (IllegalArgumentException unused) {
            if (n(context)) {
                str2 = "MMMM dd";
            } else {
                str2 = "dd MMMM";
            }
            return new SimpleDateFormat(str2);
        }
    }

    public static DateFormat e(Context context) {
        return f(context, true);
    }

    public static DateFormat f(Context context, boolean z10) {
        if (z10) {
            return DateFormat.getDateInstance(3);
        }
        return android.text.format.DateFormat.getDateFormat(context);
    }

    public static final Calendar g(int i10, int i11, int i12) {
        Calendar calendar = Calendar.getInstance(f1003a, Locale.US);
        calendar.clear();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        return calendar;
    }

    public static final Calendar h(Date date, boolean z10) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(f1003a, Locale.US);
        calendar.setTime(date);
        if (z10) {
            calendar.set(1, 0);
        }
        return calendar;
    }

    public static String i(String str) {
        if (str != null && str.startsWith(String.valueOf(COUIDateMonthView.MIN_YEAR)) && str.length() >= 8) {
            return str.substring(4, 8);
        }
        return null;
    }

    public static boolean j(int i10) {
        if (i10 != 3 && i10 != 1000) {
            return false;
        }
        return true;
    }

    public static boolean k(Context context, boolean z10) {
        if (context == null) {
            return true;
        }
        try {
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                if (!country.equalsIgnoreCase("CN") && !country.equalsIgnoreCase("TW")) {
                    if (country.equalsIgnoreCase("HK")) {
                    }
                }
                return true;
            }
            return false;
        } catch (Exception e10) {
            H7.b.b("DateUtils", "getCountry error : " + e10);
            if (z10) {
                return true;
            }
            return false;
        }
    }

    public static boolean l(String str) {
        if (str != null && str.startsWith(String.valueOf(COUIDateMonthView.MIN_YEAR))) {
            return true;
        }
        return false;
    }

    public static boolean m(Date date, int i10) {
        if (date != null && date.getYear() + COUIDateMonthView.MIN_YEAR < i10) {
            return true;
        }
        return false;
    }

    public static boolean n(Context context) {
        char c10;
        char[] dateFormatOrder = android.text.format.DateFormat.getDateFormatOrder(context);
        for (int i10 = 0; i10 < dateFormatOrder.length && (c10 = dateFormatOrder[i10]) != 'd'; i10++) {
            if (c10 == 'M') {
                return true;
            }
        }
        return false;
    }

    public static boolean o(Date date, Date date2) {
        if (date == null || date2 == null || date2.getYear() != date.getYear() || date2.getMonth() != date.getMonth() || date2.getDate() != date.getDate()) {
            return false;
        }
        return true;
    }

    public static boolean p(Calendar calendar) {
        if (calendar.get(1) > 1) {
            return true;
        }
        return false;
    }

    public static Calendar q(String str, boolean z10) {
        ParsePosition parsePosition = new ParsePosition(0);
        if (!z10) {
            if (!"--02-29".equals(str) && !"0229".equals(str)) {
                for (SimpleDateFormat simpleDateFormat : f1011i) {
                    synchronized (simpleDateFormat) {
                        try {
                            parsePosition.setIndex(0);
                            Date parse = simpleDateFormat.parse(str, parsePosition);
                            if (parsePosition.getIndex() == str.length()) {
                                return h(parse, true);
                            }
                        } finally {
                        }
                    }
                }
            } else {
                return g(0, 1, 29);
            }
        }
        int i10 = 0;
        while (true) {
            SimpleDateFormat[] simpleDateFormatArr = f1010h;
            if (i10 < simpleDateFormatArr.length) {
                SimpleDateFormat simpleDateFormat2 = simpleDateFormatArr[i10];
                synchronized (simpleDateFormat2) {
                    try {
                        parsePosition.setIndex(0);
                        Date parse2 = simpleDateFormat2.parse(str, parsePosition);
                        if (parsePosition.getIndex() == str.length()) {
                            return h(parse2, false);
                        }
                    } finally {
                    }
                }
                i10++;
            } else {
                return null;
            }
        }
    }

    public static Date r(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        int i10 = 0;
        while (true) {
            SimpleDateFormat[] simpleDateFormatArr = f1010h;
            if (i10 >= simpleDateFormatArr.length) {
                return null;
            }
            SimpleDateFormat simpleDateFormat = simpleDateFormatArr[i10];
            synchronized (simpleDateFormat) {
                try {
                    parsePosition.setIndex(0);
                    Date parse = simpleDateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() == str.length()) {
                        return parse;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i10++;
        }
    }
}
