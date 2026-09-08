package D8;

/* compiled from: Constants.java */
/* loaded from: classes3.dex */
public class a {
    public static String a() {
        if (L8.b.a()) {
            return "com.oplus.appplatform";
        }
        String str = (String) b();
        if (str == null) {
            return "";
        }
        return str;
    }

    public static Object b() {
        return b.a();
    }

    public static String c() {
        if (L8.b.a()) {
            return "com.oplus.epona.binder";
        }
        return (String) d();
    }

    public static Object d() {
        return b.b();
    }

    public static String e() {
        if (L8.b.a()) {
            return "com.oplus.epona.ext_binder";
        }
        return (String) f();
    }

    public static Object f() {
        return b.c();
    }
}
