package t1;

/* compiled from: VvmLog.java */
@Deprecated
/* loaded from: classes.dex */
public class k {
    public static void a(String str, String str2) {
        b(str, str2);
    }

    public static void b(String str, String str2) {
        H7.b.b("vvm_" + str, str2);
    }

    public static String c(Object obj) {
        if (obj == null) {
            return String.valueOf(obj);
        }
        return "[PII]";
    }

    public static void d(String str, String str2) {
        b(str, str2);
    }
}
