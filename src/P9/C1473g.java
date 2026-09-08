package p9;

import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.i;

/* compiled from: DebugMetadata.kt */
/* renamed from: p9.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1473g {

    /* renamed from: a, reason: collision with root package name */
    public static final C1473g f36110a = new C1473g();

    /* renamed from: b, reason: collision with root package name */
    public static final a f36111b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    public static a f36112c;

    /* compiled from: DebugMetadata.kt */
    /* renamed from: p9.g$a */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f36113a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f36114b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f36115c;

        public a(Method method, Method method2, Method method3) {
            this.f36113a = method;
            this.f36114b = method2;
            this.f36115c = method3;
        }
    }

    public final a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f36112c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f36111b;
            f36112c = aVar2;
            return aVar2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Object obj;
        Object obj2;
        Object obj3;
        i.f(continuation, "continuation");
        a aVar = f36112c;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar == f36111b) {
            return null;
        }
        Method method = aVar.f36113a;
        if (method != null) {
            obj = method.invoke(continuation.getClass(), null);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        Method method2 = aVar.f36114b;
        if (method2 != null) {
            obj2 = method2.invoke(obj, null);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        Method method3 = aVar.f36115c;
        if (method3 != null) {
            obj3 = method3.invoke(obj2, null);
        } else {
            obj3 = null;
        }
        if (!(obj3 instanceof String)) {
            return null;
        }
        return (String) obj3;
    }
}
