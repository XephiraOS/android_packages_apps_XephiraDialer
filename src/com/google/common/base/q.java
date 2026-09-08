package com.google.common.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Throwables.java */
/* loaded from: classes3.dex */
public final class q {
    static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";

    /* renamed from: a, reason: collision with root package name */
    public static final Object f24339a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f24340b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f24341c;

    static {
        Method a10;
        Object b10 = b();
        f24339a = b10;
        Method method = null;
        if (b10 == null) {
            a10 = null;
        } else {
            a10 = a();
        }
        f24340b = a10;
        if (b10 != null) {
            method = d(b10);
        }
        f24341c = method;
    }

    public static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    public static Object b() {
        try {
            return Class.forName(SHARED_SECRETS_CLASSNAME, false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(String str, Class<?>... clsArr) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e10) {
            throw e10;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Object obj) {
        try {
            Method c10 = c("getStackTraceDepth", Throwable.class);
            if (c10 == null) {
                return null;
            }
            c10.invoke(obj, new Throwable());
            return c10;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void f(Throwable th) {
        k.o(th);
        if (!(th instanceof RuntimeException)) {
            if (!(th instanceof Error)) {
                return;
            } else {
                throw ((Error) th);
            }
        }
        throw ((RuntimeException) th);
    }
}
