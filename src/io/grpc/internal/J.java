package io.grpc.internal;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: JsonUtil.java */
/* loaded from: classes4.dex */
public class J {

    /* renamed from: a, reason: collision with root package name */
    public static final long f32602a = TimeUnit.SECONDS.toNanos(1);

    /* JADX WARN: Multi-variable type inference failed */
    public static List<Map<String, ?>> a(List<?> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!(list.get(i10) instanceof Map)) {
                throw new ClassCastException(String.format(Locale.US, "value %s for idx %d in %s is not object", list.get(i10), Integer.valueOf(i10), list));
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<String> b(List<?> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!(list.get(i10) instanceof String)) {
                throw new ClassCastException(String.format(Locale.US, "value '%s' for idx %d in '%s' is not string", list.get(i10), Integer.valueOf(i10), list));
            }
        }
        return list;
    }

    public static boolean c(long j10, int i10) {
        if (j10 >= -315576000000L && j10 <= 315576000000L) {
            long j11 = i10;
            if (j11 >= -999999999 && j11 < f32602a) {
                if (j10 < 0 || i10 < 0) {
                    if (j10 <= 0 && i10 <= 0) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static Boolean d(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not Boolean", obj, str, map));
    }

    public static List<?> e(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not List", obj, str, map));
    }

    public static List<Map<String, ?>> f(Map<String, ?> map, String str) {
        List<?> e10 = e(map, str);
        if (e10 == null) {
            return null;
        }
        return a(e10);
    }

    public static List<String> g(Map<String, ?> map, String str) {
        List<?> e10 = e(map, str);
        if (e10 == null) {
            return null;
        }
        return b(e10);
    }

    public static Double h(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not a double", obj, str));
            }
        }
        throw new IllegalArgumentException(String.format("value '%s' for key '%s' in '%s' is not a number", obj, str, map));
    }

    public static Integer i(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Double) {
            Double d10 = (Double) obj;
            int intValue = d10.intValue();
            if (intValue == d10.doubleValue()) {
                return Integer.valueOf(intValue);
            }
            throw new ClassCastException("Number expected to be integer: " + d10);
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf(Integer.parseInt((String) obj));
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
            }
        }
        throw new IllegalArgumentException(String.format("value '%s' for key '%s' is not an integer", obj, str));
    }

    public static Map<String, ?> j(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not object", obj, str, map));
    }

    public static String k(Map<String, ?> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value '%s' for key '%s' in '%s' is not String", obj, str, map));
    }

    public static Long l(Map<String, ?> map, String str) {
        String k10 = k(map, str);
        if (k10 == null) {
            return null;
        }
        try {
            return Long.valueOf(n(k10));
        } catch (ParseException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static long m(long j10, int i10) {
        long j11 = i10;
        long j12 = f32602a;
        if (j11 <= (-j12) || j11 >= j12) {
            j10 = com.google.common.math.b.a(j10, j11 / j12);
            i10 = (int) (j11 % j12);
        }
        if (j10 > 0 && i10 < 0) {
            i10 = (int) (i10 + j12);
            j10--;
        }
        if (j10 < 0 && i10 > 0) {
            i10 = (int) (i10 - j12);
            j10++;
        }
        if (c(j10, i10)) {
            return p(TimeUnit.SECONDS.toNanos(j10), i10);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j10), Integer.valueOf(i10)));
    }

    public static long n(String str) {
        boolean z10;
        String str2;
        int o10;
        if (!str.isEmpty() && str.charAt(str.length() - 1) == 's') {
            if (str.charAt(0) == '-') {
                str = str.substring(1);
                z10 = true;
            } else {
                z10 = false;
            }
            String substring = str.substring(0, str.length() - 1);
            int indexOf = substring.indexOf(46);
            if (indexOf != -1) {
                str2 = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
            } else {
                str2 = "";
            }
            long parseLong = Long.parseLong(substring);
            if (str2.isEmpty()) {
                o10 = 0;
            } else {
                o10 = o(str2);
            }
            if (parseLong >= 0) {
                if (z10) {
                    parseLong = -parseLong;
                    o10 = -o10;
                }
                try {
                    return m(parseLong, o10);
                } catch (IllegalArgumentException unused) {
                    throw new ParseException("Duration value is out of range.", 0);
                }
            }
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        throw new ParseException("Invalid duration string: " + str, 0);
    }

    public static int o(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < 9; i11++) {
            i10 *= 10;
            if (i11 < str.length()) {
                if (str.charAt(i11) >= '0' && str.charAt(i11) <= '9') {
                    i10 += str.charAt(i11) - '0';
                } else {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
            }
        }
        return i10;
    }

    public static long p(long j10, long j11) {
        boolean z10;
        long j12 = j10 + j11;
        boolean z11 = false;
        if ((j11 ^ j10) < 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((j10 ^ j12) >= 0) {
            z11 = true;
        }
        if (z10 | z11) {
            return j12;
        }
        return ((j12 >>> 63) ^ 1) + Long.MAX_VALUE;
    }
}
