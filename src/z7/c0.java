package z7;

import java.lang.reflect.Method;

/* compiled from: PinyinHelper.java */
/* loaded from: classes3.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static Object f38340a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f38341b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f38342c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f38343d;

    /* renamed from: e, reason: collision with root package name */
    public static Method f38344e;

    /* renamed from: f, reason: collision with root package name */
    public static String[] f38345f = {"getWholePinyinStr", "getSinglePinyinStr", "getFirstStrokesStr", "getSingleFirstStrokesStr", "isPolyphone", "getPolyPinyinsByChar", "getPolyPinyinsByIndex", "getExtenedBuckets"};

    public static char[] a(String str) {
        Method method;
        try {
            Object obj = f38340a;
            if (obj != null && (method = f38344e) != null) {
                return (char[]) method.invoke(obj, str);
            }
        } catch (Exception unused) {
        }
        return f0.a(str);
    }

    public static String b(String str) {
        Method method;
        try {
            Object obj = f38340a;
            if (obj != null && (method = f38343d) != null) {
                return (String) method.invoke(obj, str);
            }
        } catch (Exception unused) {
        }
        return f0.b(str);
    }

    public static String c(String str) {
        Method method;
        try {
            Object obj = f38340a;
            if (obj != null && (method = f38342c) != null) {
                return (String) method.invoke(obj, str);
            }
        } catch (Exception unused) {
        }
        return f0.c(str);
    }

    public static String d(String str) {
        Method method;
        try {
            Object obj = f38340a;
            if (obj != null && (method = f38341b) != null) {
                return (String) method.invoke(obj, str);
            }
        } catch (Exception unused) {
        }
        return f0.d(str);
    }
}
