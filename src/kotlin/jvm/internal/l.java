package kotlin.jvm.internal;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes4.dex */
public class l {
    public C9.c b(Class cls) {
        return new d(cls);
    }

    public C9.e c(Class cls, String str) {
        return new j(cls, str);
    }

    public String f(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }

    public String g(Lambda lambda) {
        return f(lambda);
    }

    public C9.f a(FunctionReference functionReference) {
        return functionReference;
    }

    public C9.g d(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public C9.h e(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }
}
