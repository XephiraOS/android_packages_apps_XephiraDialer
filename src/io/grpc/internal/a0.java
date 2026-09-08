package io.grpc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ReflectionLongAdderCounter.java */
/* loaded from: classes4.dex */
public final class a0 implements L {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f33013b = Logger.getLogger(a0.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final Constructor<?> f33014c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f33015d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f33016e;

    /* renamed from: f, reason: collision with root package name */
    public static final RuntimeException f33017f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object[] f33018g;

    /* renamed from: a, reason: collision with root package name */
    public final Object f33019a;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                method2 = cls.getMethod("sum", null);
                try {
                    Constructor<?>[] constructors = cls.getConstructors();
                    int length = constructors.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length) {
                            constructor = constructors[i10];
                            if (constructor.getParameterTypes().length == 0) {
                                break;
                            } else {
                                i10++;
                            }
                        } else {
                            constructor = null;
                            break;
                        }
                    }
                    th = null;
                } catch (Throwable th) {
                    th = th;
                    f33013b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                    constructor = null;
                    if (th != null) {
                    }
                    f33014c = null;
                    f33015d = null;
                    f33016e = null;
                    f33017f = new RuntimeException(th);
                    f33018g = new Object[]{1L};
                }
            } catch (Throwable th2) {
                th = th2;
                method2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            method = null;
            method2 = null;
        }
        if (th != null && constructor != null) {
            f33014c = constructor;
            f33015d = method;
            f33016e = method2;
            f33017f = null;
        } else {
            f33014c = null;
            f33015d = null;
            f33016e = null;
            f33017f = new RuntimeException(th);
        }
        f33018g = new Object[]{1L};
    }

    public a0() {
        RuntimeException runtimeException = f33017f;
        if (runtimeException == null) {
            try {
                this.f33019a = f33014c.newInstance(null);
                return;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException(e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException(e12);
            }
        }
        throw runtimeException;
    }

    public static boolean b() {
        if (f33017f == null) {
            return true;
        }
        return false;
    }

    @Override // io.grpc.internal.L
    public void a(long j10) {
        Object[] objArr;
        try {
            Method method = f33015d;
            Object obj = this.f33019a;
            if (j10 == 1) {
                objArr = f33018g;
            } else {
                objArr = new Object[]{Long.valueOf(j10)};
            }
            method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
