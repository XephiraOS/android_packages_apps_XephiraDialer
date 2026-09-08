package I;

import java.util.Objects;

/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public class c {
    public static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int b(Object... objArr) {
        return Objects.hash(objArr);
    }

    public static <T> T c(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(str);
    }

    public static String d(Object obj, String str) {
        if (obj != null) {
            return obj.toString();
        }
        return str;
    }
}
