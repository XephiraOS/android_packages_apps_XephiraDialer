package h1;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: PhoneNumberUtil.java */
/* renamed from: h1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1075d {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<Character, Character> f32041a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f32042b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f32043c = {"+86"};

    /* renamed from: d, reason: collision with root package name */
    public static final String f32044d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f32045e;

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f32046f;

    static {
        HashMap hashMap = new HashMap(40);
        hashMap.put('A', '2');
        hashMap.put('B', '2');
        hashMap.put('C', '2');
        hashMap.put('D', '3');
        hashMap.put('E', '3');
        hashMap.put('F', '3');
        hashMap.put('G', '4');
        hashMap.put('H', '4');
        hashMap.put('I', '4');
        hashMap.put('J', '5');
        hashMap.put('K', '5');
        hashMap.put('L', '5');
        hashMap.put('M', '6');
        hashMap.put('N', '6');
        hashMap.put('O', '6');
        hashMap.put('P', '7');
        hashMap.put('Q', '7');
        hashMap.put('R', '7');
        hashMap.put('S', '7');
        hashMap.put('T', '8');
        hashMap.put('U', '8');
        hashMap.put('V', '8');
        hashMap.put('W', '9');
        hashMap.put('X', '9');
        hashMap.put('Y', '9');
        hashMap.put('Z', '9');
        Map<Character, Character> unmodifiableMap = Collections.unmodifiableMap(hashMap);
        f32041a = unmodifiableMap;
        String a10 = a(",;xｘ#＃~～");
        f32042b = a10;
        String str = Arrays.toString(unmodifiableMap.keySet().toArray()).replaceAll("[, \\[\\]]", "") + Arrays.toString(unmodifiableMap.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", "");
        f32044d = str;
        String str2 = "\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*" + str + "\\p{Nd}]*";
        f32045e = str2;
        f32046f = Pattern.compile(str2 + "(?:" + a10 + ")?", 66);
    }

    public static String a(String str) {
        return ";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[" + str + "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*(\\p{Nd}{1,7})#?|[- ]+(\\p{Nd}{1,5})#";
    }

    public static String[] b() {
        return f32043c;
    }

    public static String c(Context context) {
        String line1Number = ((TelephonyManager) context.getSystemService("phone")).getLine1Number();
        if (H7.a.b()) {
            H7.b.b("PhoneNumberUtil", "number = " + H7.a.d(line1Number));
        }
        return line1Number;
    }

    public static String d(Context context, int i10) {
        try {
            String b10 = D7.c.b(Integer.valueOf(i10));
            if (H7.a.b()) {
                H7.b.b("PhoneNumberUtil", "number = " + H7.a.d(b10));
            }
            if (!TextUtils.isEmpty(b10)) {
                if (f(b10)) {
                    return "";
                }
            }
            return b10;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() < 2) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Matcher matcher = f32046f.matcher(str);
        try {
            if (matcher.find()) {
                String group = matcher.group();
                int indexOf = str.indexOf(group);
                if (indexOf > 0) {
                    sb.append(str.substring(0, indexOf));
                    sb.append("\u200e" + group);
                } else if (indexOf == 0) {
                    sb.append("\u200e" + group);
                } else {
                    return str;
                }
                if (indexOf >= 0 && group.length() + indexOf < str.length()) {
                    sb.append(str.substring(group.length() + indexOf));
                }
                if (H7.a.b()) {
                    H7.b.b("PhoneNumberUtil", "getViablePhoneNumber number = " + H7.a.d(group) + " ,index = " + indexOf + " ,result = " + H7.a.d(sb.toString()));
                }
                return sb.toString();
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean f(String str) {
        boolean z10;
        List asList = Arrays.asList(b());
        if (asList != null && asList.contains(str)) {
            z10 = true;
        } else {
            z10 = false;
        }
        H7.b.e("PhoneNumberUtil", "isCountryCode:" + z10);
        return z10;
    }
}
