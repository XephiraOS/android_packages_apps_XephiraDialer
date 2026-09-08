package kotlin.jvm.internal;

import java.util.Collection;
import v9.InterfaceC1637a;
import v9.o;
import v9.p;
import v9.q;
import v9.r;
import v9.s;
import v9.t;
import v9.u;
import v9.v;
import v9.w;
import w9.InterfaceC1658a;
import w9.InterfaceC1659b;

/* compiled from: TypeIntrinsics.java */
/* loaded from: classes4.dex */
public class n {
    public static Collection a(Object obj) {
        if ((obj instanceof InterfaceC1658a) && !(obj instanceof InterfaceC1659b)) {
            h(obj, "kotlin.collections.MutableCollection");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i10) {
        if (obj != null && !e(obj, i10)) {
            h(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static Collection c(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e10) {
            throw g(e10);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof InterfaceC1637a) {
            return 0;
        }
        if (obj instanceof v9.l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof v9.b) {
            return 10;
        }
        if (obj instanceof v9.c) {
            return 11;
        }
        if (obj instanceof v9.d) {
            return 12;
        }
        if (obj instanceof v9.e) {
            return 13;
        }
        if (obj instanceof v9.f) {
            return 14;
        }
        if (obj instanceof v9.g) {
            return 15;
        }
        if (obj instanceof v9.h) {
            return 16;
        }
        if (obj instanceof v9.i) {
            return 17;
        }
        if (obj instanceof v9.j) {
            return 18;
        }
        if (obj instanceof v9.k) {
            return 19;
        }
        if (obj instanceof v9.m) {
            return 20;
        }
        if (obj instanceof v9.n) {
            return 21;
        }
        if (obj instanceof o) {
            return 22;
        }
        return -1;
    }

    public static boolean e(Object obj, int i10) {
        if ((obj instanceof m9.c) && d(obj) == i10) {
            return true;
        }
        return false;
    }

    public static <T extends Throwable> T f(T t10) {
        return (T) i.k(t10, n.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        String name;
        if (obj == null) {
            name = "null";
        } else {
            name = obj.getClass().getName();
        }
        i(name + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
