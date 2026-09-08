package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ClassesInfoCache.java */
@Deprecated
/* renamed from: androidx.lifecycle.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0478a {

    /* renamed from: c, reason: collision with root package name */
    public static C0478a f10348c = new C0478a();

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, C0128a> f10349a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, Boolean> f10350b = new HashMap();

    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    /* renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0128a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<Lifecycle.Event, List<b>> f10351a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map<b, Lifecycle.Event> f10352b;

        public C0128a(Map<b, Lifecycle.Event> map) {
            this.f10352b = map;
            for (Map.Entry<b, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<b> list = this.f10351a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f10351a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void b(List<b> list, InterfaceC0492o interfaceC0492o, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(interfaceC0492o, event, obj);
                }
            }
        }

        public void a(InterfaceC0492o interfaceC0492o, Lifecycle.Event event, Object obj) {
            b(this.f10351a.get(event), interfaceC0492o, event, obj);
            b(this.f10351a.get(Lifecycle.Event.ON_ANY), interfaceC0492o, event, obj);
        }
    }

    /* compiled from: ClassesInfoCache.java */
    @Deprecated
    /* renamed from: androidx.lifecycle.a$b */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10353a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f10354b;

        public b(int i10, Method method) {
            this.f10353a = i10;
            this.f10354b = method;
            method.setAccessible(true);
        }

        public void a(InterfaceC0492o interfaceC0492o, Lifecycle.Event event, Object obj) {
            try {
                int i10 = this.f10353a;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            this.f10354b.invoke(obj, interfaceC0492o, event);
                            return;
                        }
                        return;
                    }
                    this.f10354b.invoke(obj, interfaceC0492o);
                    return;
                }
                this.f10354b.invoke(obj, null);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f10353a == bVar.f10353a && this.f10354b.getName().equals(bVar.f10354b.getName())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f10353a * 31) + this.f10354b.getName().hashCode();
        }
    }

    public final C0128a a(Class<?> cls, Method[] methodArr) {
        int i10;
        C0128a c10;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c10 = c(superclass)) != null) {
            hashMap.putAll(c10.f10352b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, Lifecycle.Event> entry : c(cls2).f10352b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            x xVar = (x) method.getAnnotation(x.class);
            if (xVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length > 0) {
                    if (InterfaceC0492o.class.isAssignableFrom(parameterTypes[0])) {
                        i10 = 1;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                } else {
                    i10 = 0;
                }
                Lifecycle.Event value = xVar.value();
                if (parameterTypes.length > 1) {
                    if (Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        if (value == Lifecycle.Event.ON_ANY) {
                            i10 = 2;
                        } else {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new b(i10, method), value, cls);
                    z10 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0128a c0128a = new C0128a(hashMap);
        this.f10349a.put(cls, c0128a);
        this.f10350b.put(cls, Boolean.valueOf(z10));
        return c0128a;
    }

    public final Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    public C0128a c(Class<?> cls) {
        C0128a c0128a = this.f10349a.get(cls);
        if (c0128a != null) {
            return c0128a;
        }
        return a(cls, null);
    }

    public boolean d(Class<?> cls) {
        Boolean bool = this.f10350b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b10 = b(cls);
        for (Method method : b10) {
            if (((x) method.getAnnotation(x.class)) != null) {
                a(cls, b10);
                return true;
            }
        }
        this.f10350b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map<b, Lifecycle.Event> map, b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + bVar.f10354b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        }
        if (event2 == null) {
            map.put(bVar, event);
        }
    }
}
