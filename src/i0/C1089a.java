package i0;

/* compiled from: Trace.java */
/* renamed from: i0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1089a {
    public static void a(String str) {
        b.a(d(str));
    }

    public static void b() {
        b.b();
    }

    public static boolean c() {
        return c.a();
    }

    public static String d(String str) {
        if (str.length() <= 127) {
            return str;
        }
        return str.substring(0, 127);
    }
}
