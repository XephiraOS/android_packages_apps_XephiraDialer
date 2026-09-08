package T2;

import com.android.incallui.OplusPhoneUtils;
import com.android.volley.a;
import com.oplus.backup.sdk.common.utils.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: HttpHeaderParser.java */
/* loaded from: classes.dex */
public class e {
    public static List<S2.c> a(List<S2.c> list, a.C0186a c0186a) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<S2.c> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<S2.c> list2 = c0186a.f19232h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (S2.c cVar : c0186a.f19232h) {
                    if (!treeSet.contains(cVar.a())) {
                        arrayList.add(cVar);
                    }
                }
            }
        } else if (!c0186a.f19231g.isEmpty()) {
            for (Map.Entry<String, String> entry : c0186a.f19231g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new S2.c(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static String b(long j10) {
        return d("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j10));
    }

    public static Map<String, String> c(a.C0186a c0186a) {
        if (c0186a == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = c0186a.f19226b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j10 = c0186a.f19228d;
        if (j10 > 0) {
            hashMap.put("If-Modified-Since", b(j10));
        }
        return hashMap;
    }

    public static SimpleDateFormat d(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static a.C0186a e(S2.e eVar) {
        long j10;
        boolean z10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = eVar.f3392c;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        if (str != null) {
            j10 = h(str);
        } else {
            j10 = 0;
        }
        String str2 = map.get("Cache-Control");
        int i10 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z10 = false;
            j11 = 0;
            j12 = 0;
            while (i10 < split.length) {
                String trim = split[i10].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j11 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j12 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z10 = true;
                }
                i10++;
            }
            i10 = 1;
        } else {
            z10 = false;
            j11 = 0;
            j12 = 0;
        }
        String str3 = map.get("Expires");
        if (str3 != null) {
            j13 = h(str3);
        } else {
            j13 = 0;
        }
        String str4 = map.get("Last-Modified");
        if (str4 != null) {
            j14 = h(str4);
        } else {
            j14 = 0;
        }
        String str5 = map.get("ETag");
        if (i10 != 0) {
            j16 = currentTimeMillis + (j11 * 1000);
            if (z10) {
                j17 = j16;
            } else {
                j17 = (j12 * 1000) + j16;
            }
            j15 = j17;
        } else {
            j15 = 0;
            if (j10 > 0 && j13 >= j10) {
                j16 = currentTimeMillis + (j13 - j10);
                j15 = j16;
            } else {
                j16 = 0;
            }
        }
        a.C0186a c0186a = new a.C0186a();
        c0186a.f19225a = eVar.f3391b;
        c0186a.f19226b = str5;
        c0186a.f19230f = j16;
        c0186a.f19229e = j15;
        c0186a.f19227c = j10;
        c0186a.f19228d = j14;
        c0186a.f19231g = map;
        c0186a.f19232h = eVar.f3393d;
        return c0186a;
    }

    public static String f(Map<String, String> map) {
        return g(map, "ISO-8859-1");
    }

    public static String g(Map<String, String> map, String str) {
        if (map == null) {
            return str;
        }
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(Constants.DataMigration.SPLIT_TAG, 0);
            for (int i10 = 1; i10 < split.length; i10++) {
                String[] split2 = split[i10].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static long h(String str) {
        try {
            return d("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e10) {
            if (!OplusPhoneUtils.DeviceState.UNLOCK_DEVICE.equals(str) && !OplusPhoneUtils.DeviceState.INVALID_STATUS.equals(str)) {
                com.android.volley.e.d(e10, "Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            com.android.volley.e.e("Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static List<S2.c> i(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new S2.c(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static Map<String, String> j(List<S2.c> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (S2.c cVar : list) {
            treeMap.put(cVar.a(), cVar.b());
        }
        return treeMap;
    }
}
