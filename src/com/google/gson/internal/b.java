package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Type, com.google.gson.f<?>> f24766a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f24767b;

    /* renamed from: c, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f24768c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class a<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* renamed from: com.google.gson.internal.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0225b<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class c<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class d<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class e<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class f<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class g<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class h<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class i<T> implements com.google.gson.internal.f<T> {
        @Override // com.google.gson.internal.f
        public T a() {
            return (T) new LinkedTreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class j<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f24769a;

        public j(Class cls) {
            this.f24769a = cls;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            try {
                return (T) com.google.gson.internal.k.f24809a.d(this.f24769a);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + this.f24769a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class k<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.f f24771a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f24772b;

        public k(com.google.gson.f fVar, Type type) {
            this.f24771a = fVar;
            this.f24772b = type;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) this.f24771a.a(this.f24772b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class l<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24774a;

        public l(String str) {
            this.f24774a = str;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f24774a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class m<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.f f24776a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f24777b;

        public m(com.google.gson.f fVar, Type type) {
            this.f24776a = fVar;
            this.f24777b = type;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            return (T) this.f24776a.a(this.f24777b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class n<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24779a;

        public n(String str) {
            this.f24779a = str;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f24779a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class o<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24781a;

        public o(String str) {
            this.f24781a = str;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f24781a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class p<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f24783a;

        public p(Type type) {
            this.f24783a = type;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            Type type = this.f24783a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return (T) EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.f24783a.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f24783a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class q<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f24784a;

        public q(Type type) {
            this.f24784a = type;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            Type type = this.f24784a;
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return (T) new EnumMap((Class) type2);
                }
                throw new JsonIOException("Invalid EnumMap type: " + this.f24784a.toString());
            }
            throw new JsonIOException("Invalid EnumMap type: " + this.f24784a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class r<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24785a;

        public r(String str) {
            this.f24785a = str;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f24785a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class s<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f24786a;

        public s(String str) {
            this.f24786a = str;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            throw new JsonIOException(this.f24786a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: ConstructorConstructor.java */
    /* loaded from: classes3.dex */
    public class t<T> implements com.google.gson.internal.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Constructor f24787a;

        public t(Constructor constructor) {
            this.f24787a = constructor;
        }

        @Override // com.google.gson.internal.f
        public T a() {
            try {
                return (T) this.f24787a.newInstance(null);
            } catch (IllegalAccessException e10) {
                throw H4.a.e(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + H4.a.c(this.f24787a) + "' with no args", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + H4.a.c(this.f24787a) + "' with no args", e12.getCause());
            }
        }
    }

    public b(Map<Type, com.google.gson.f<?>> map, boolean z10, List<ReflectionAccessFilter> list) {
        this.f24766a = map;
        this.f24767b = z10;
        this.f24768c = list;
    }

    public static String a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + cls.getName();
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName();
        }
        return null;
    }

    public static <T> com.google.gson.internal.f<T> c(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        String m10;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
            if (filterResult != filterResult2 && (!com.google.gson.internal.i.a(declaredConstructor, null) || (filterResult == ReflectionAccessFilter.FilterResult.BLOCK_ALL && !Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
            }
            if (filterResult == filterResult2 && (m10 = H4.a.m(declaredConstructor)) != null) {
                return new s(m10);
            }
            return new t(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static <T> com.google.gson.internal.f<T> d(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new a();
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new C0225b();
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new c();
            }
            return new d();
        }
        if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new e();
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new f();
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new g();
            }
            if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(J4.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new h();
            }
            return new i();
        }
        return null;
    }

    public static <T> com.google.gson.internal.f<T> e(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    public <T> com.google.gson.internal.f<T> b(J4.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        com.google.gson.f<?> fVar = this.f24766a.get(type);
        if (fVar != null) {
            return new k(fVar, type);
        }
        com.google.gson.f<?> fVar2 = this.f24766a.get(rawType);
        if (fVar2 != null) {
            return new m(fVar2, type);
        }
        com.google.gson.internal.f<T> e10 = e(type, rawType);
        if (e10 != null) {
            return e10;
        }
        ReflectionAccessFilter.FilterResult b10 = com.google.gson.internal.i.b(this.f24768c, rawType);
        com.google.gson.internal.f<T> c10 = c(rawType, b10);
        if (c10 != null) {
            return c10;
        }
        com.google.gson.internal.f<T> d10 = d(type, rawType);
        if (d10 != null) {
            return d10;
        }
        String a10 = a(rawType);
        if (a10 != null) {
            return new n(a10);
        }
        if (b10 == ReflectionAccessFilter.FilterResult.ALLOW) {
            return f(rawType);
        }
        return new o("Unable to create instance of " + rawType + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public final <T> com.google.gson.internal.f<T> f(Class<? super T> cls) {
        if (this.f24767b) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public String toString() {
        return this.f24766a.toString();
    }
}
