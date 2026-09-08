package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics.java */
/* loaded from: classes4.dex */
public class i {
    public static boolean a(Float f10, float f11) {
        if (f10 != null && f10.floatValue() == f11) {
            return true;
        }
        return false;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static void c(Object obj) {
        if (obj == null) {
            m();
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            n(str);
        }
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) j(new NullPointerException(str + " must not be null")));
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            o(str);
        }
    }

    public static int g(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        if (i10 == i11) {
            return 0;
        }
        return 1;
    }

    public static int h(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        if (j10 == j11) {
            return 0;
        }
        return 1;
    }

    public static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = i.class.getName();
        int i10 = 0;
        while (!stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        while (stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static <T extends Throwable> T j(T t10) {
        return (T) k(t10, i.class.getName());
    }

    public static <T extends Throwable> T k(T t10, String str) {
        StackTraceElement[] stackTrace = t10.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        t10.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
        return t10;
    }

    public static String l(String str, Object obj) {
        return str + obj;
    }

    public static void m() {
        throw ((NullPointerException) j(new NullPointerException()));
    }

    public static void n(String str) {
        throw ((NullPointerException) j(new NullPointerException(str)));
    }

    public static void o(String str) {
        throw ((NullPointerException) j(new NullPointerException(i(str))));
    }

    public static void p(String str) {
        throw ((UninitializedPropertyAccessException) j(new UninitializedPropertyAccessException(str)));
    }

    public static void q(String str) {
        p("lateinit property " + str + " has not been initialized");
    }
}
