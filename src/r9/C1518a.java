package r9;

import java.lang.reflect.Method;
import kotlin.collections.C1229j;
import kotlin.jvm.internal.i;
import kotlin.random.Random;

/* compiled from: PlatformImplementations.kt */
/* renamed from: r9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1518a {

    /* compiled from: PlatformImplementations.kt */
    /* renamed from: r9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0350a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0350a f36554a = new C0350a();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f36555b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f36556c;

        static {
            Method method;
            Method method2;
            Object I10;
            Method[] methods = Throwable.class.getMethods();
            i.c(methods);
            int length = methods.length;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                method = null;
                if (i11 < length) {
                    method2 = methods[i11];
                    if (i.b(method2.getName(), "addSuppressed")) {
                        Class<?>[] parameterTypes = method2.getParameterTypes();
                        i.e(parameterTypes, "getParameterTypes(...)");
                        I10 = C1229j.I(parameterTypes);
                        if (i.b(I10, Throwable.class)) {
                            break;
                        }
                    }
                    i11++;
                } else {
                    method2 = null;
                    break;
                }
            }
            f36555b = method2;
            int length2 = methods.length;
            while (true) {
                if (i10 >= length2) {
                    break;
                }
                Method method3 = methods[i10];
                if (i.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i10++;
            }
            f36556c = method;
        }
    }

    public void a(Throwable cause, Throwable exception) {
        i.f(cause, "cause");
        i.f(exception, "exception");
        Method method = C0350a.f36555b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public Random b() {
        return new z9.b();
    }
}
