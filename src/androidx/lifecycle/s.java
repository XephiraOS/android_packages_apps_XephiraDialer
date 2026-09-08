package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Lifecycling.kt */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f10381a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Integer> f10382b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Class<?>, List<Constructor<? extends InterfaceC0484g>>> f10383c = new HashMap();

    public static final String c(String className) {
        String t10;
        kotlin.jvm.internal.i.f(className, "className");
        StringBuilder sb = new StringBuilder();
        t10 = kotlin.text.n.t(className, ".", "_", false, 4, null);
        sb.append(t10);
        sb.append("_LifecycleAdapter");
        return sb.toString();
    }

    public static final InterfaceC0489l f(Object object) {
        kotlin.jvm.internal.i.f(object, "object");
        boolean z10 = object instanceof InterfaceC0489l;
        boolean z11 = object instanceof InterfaceC0480c;
        if (z10 && z11) {
            return new DefaultLifecycleObserverAdapter((InterfaceC0480c) object, (InterfaceC0489l) object);
        }
        if (z11) {
            return new DefaultLifecycleObserverAdapter((InterfaceC0480c) object, null);
        }
        if (z10) {
            return (InterfaceC0489l) object;
        }
        Class<?> cls = object.getClass();
        s sVar = f10381a;
        if (sVar.d(cls) == 2) {
            List<Constructor<? extends InterfaceC0484g>> list = f10383c.get(cls);
            kotlin.jvm.internal.i.c(list);
            List<Constructor<? extends InterfaceC0484g>> list2 = list;
            if (list2.size() == 1) {
                return new SingleGeneratedAdapterObserver(sVar.a(list2.get(0), object));
            }
            int size = list2.size();
            InterfaceC0484g[] interfaceC0484gArr = new InterfaceC0484g[size];
            for (int i10 = 0; i10 < size; i10++) {
                interfaceC0484gArr[i10] = f10381a.a(list2.get(i10), object);
            }
            return new CompositeGeneratedAdaptersObserver(interfaceC0484gArr);
        }
        return new ReflectiveGenericLifecycleObserver(object);
    }

    public final InterfaceC0484g a(Constructor<? extends InterfaceC0484g> constructor, Object obj) {
        try {
            InterfaceC0484g newInstance = constructor.newInstance(obj);
            kotlin.jvm.internal.i.e(newInstance, "{\n            constructo…tance(`object`)\n        }");
            return newInstance;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InstantiationException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    public final Constructor<? extends InterfaceC0484g> b(Class<?> cls) {
        String fullPackage;
        try {
            Package r32 = cls.getPackage();
            String name = cls.getCanonicalName();
            if (r32 != null) {
                fullPackage = r32.getName();
            } else {
                fullPackage = "";
            }
            kotlin.jvm.internal.i.e(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                kotlin.jvm.internal.i.e(name, "name");
                name = name.substring(fullPackage.length() + 1);
                kotlin.jvm.internal.i.e(name, "this as java.lang.String).substring(startIndex)");
            }
            kotlin.jvm.internal.i.e(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String c10 = c(name);
            if (fullPackage.length() != 0) {
                c10 = fullPackage + '.' + c10;
            }
            Class<?> cls2 = Class.forName(c10);
            kotlin.jvm.internal.i.d(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
                return declaredConstructor;
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final int d(Class<?> cls) {
        Map<Class<?>, Integer> map = f10382b;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g10 = g(cls);
        map.put(cls, Integer.valueOf(g10));
        return g10;
    }

    public final boolean e(Class<?> cls) {
        if (cls != null && InterfaceC0491n.class.isAssignableFrom(cls)) {
            return true;
        }
        return false;
    }

    public final int g(Class<?> cls) {
        ArrayList arrayList;
        List<Constructor<? extends InterfaceC0484g>> b10;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends InterfaceC0484g> b11 = b(cls);
        if (b11 != null) {
            Map<Class<?>, List<Constructor<? extends InterfaceC0484g>>> map = f10383c;
            b10 = kotlin.collections.n.b(b11);
            map.put(cls, b10);
            return 2;
        }
        if (C0478a.f10348c.d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (e(superclass)) {
            kotlin.jvm.internal.i.e(superclass, "superclass");
            if (d(superclass) == 1) {
                return 1;
            }
            List<Constructor<? extends InterfaceC0484g>> list = f10383c.get(superclass);
            kotlin.jvm.internal.i.c(list);
            arrayList = new ArrayList(list);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kotlin.jvm.internal.i.e(interfaces, "klass.interfaces");
        for (Class<?> intrface : interfaces) {
            if (e(intrface)) {
                kotlin.jvm.internal.i.e(intrface, "intrface");
                if (d(intrface) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                List<Constructor<? extends InterfaceC0484g>> list2 = f10383c.get(intrface);
                kotlin.jvm.internal.i.c(list2);
                arrayList.addAll(list2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f10383c.put(cls, arrayList);
        return 2;
    }
}
