package kotlin.jvm.internal;

/* compiled from: Reflection.java */
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final l f34243a;

    /* renamed from: b, reason: collision with root package name */
    public static final C9.c[] f34244b;

    static {
        l lVar = null;
        try {
            lVar = (l) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (lVar == null) {
            lVar = new l();
        }
        f34243a = lVar;
        f34244b = new C9.c[0];
    }

    public static C9.f a(FunctionReference functionReference) {
        return f34243a.a(functionReference);
    }

    public static C9.c b(Class cls) {
        return f34243a.b(cls);
    }

    public static C9.e c(Class cls) {
        return f34243a.c(cls, "");
    }

    public static C9.g d(MutablePropertyReference1 mutablePropertyReference1) {
        return f34243a.d(mutablePropertyReference1);
    }

    public static C9.h e(PropertyReference0 propertyReference0) {
        return f34243a.e(propertyReference0);
    }

    public static String f(h hVar) {
        return f34243a.f(hVar);
    }

    public static String g(Lambda lambda) {
        return f34243a.g(lambda);
    }
}
