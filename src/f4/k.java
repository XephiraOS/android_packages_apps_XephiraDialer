package F4;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory.java */
/* loaded from: classes3.dex */
public final class k implements s {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.internal.b f887a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.gson.c f888b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.gson.internal.c f889c;

    /* renamed from: d, reason: collision with root package name */
    public final F4.e f890d;

    /* renamed from: e, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f891e;

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes3.dex */
    public class a extends c {

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f892f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Method f893g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f894h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ r f895i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.d f896j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ J4.a f897k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ boolean f898l;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ boolean f899m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Field field, boolean z10, boolean z11, boolean z12, Method method, boolean z13, r rVar, com.google.gson.d dVar, J4.a aVar, boolean z14, boolean z15) {
            super(str, field, z10, z11);
            this.f892f = z12;
            this.f893g = method;
            this.f894h = z13;
            this.f895i = rVar;
            this.f896j = dVar;
            this.f897k = aVar;
            this.f898l = z14;
            this.f899m = z15;
        }

        @Override // F4.k.c
        public void a(K4.a aVar, int i10, Object[] objArr) {
            Object b10 = this.f895i.b(aVar);
            if (b10 == null && this.f898l) {
                throw new JsonParseException("null is not allowed as value for record component '" + this.f904c + "' of primitive type; at path " + aVar.d());
            }
            objArr[i10] = b10;
        }

        @Override // F4.k.c
        public void b(K4.a aVar, Object obj) {
            Object b10 = this.f895i.b(aVar);
            if (b10 != null || !this.f898l) {
                if (this.f892f) {
                    k.c(obj, this.f903b);
                } else if (this.f899m) {
                    throw new JsonIOException("Cannot set value of 'static final' " + H4.a.g(this.f903b, false));
                }
                this.f903b.set(obj, b10);
            }
        }

        @Override // F4.k.c
        public void c(K4.b bVar, Object obj) {
            Object obj2;
            r nVar;
            if (!this.f905d) {
                return;
            }
            if (this.f892f) {
                Method method = this.f893g;
                if (method == null) {
                    k.c(obj, this.f903b);
                } else {
                    k.c(obj, method);
                }
            }
            Method method2 = this.f893g;
            if (method2 != null) {
                try {
                    obj2 = method2.invoke(obj, null);
                } catch (InvocationTargetException e10) {
                    throw new JsonIOException("Accessor " + H4.a.g(this.f893g, false) + " threw exception", e10.getCause());
                }
            } else {
                obj2 = this.f903b.get(obj);
            }
            if (obj2 == obj) {
                return;
            }
            bVar.B(this.f902a);
            if (this.f894h) {
                nVar = this.f895i;
            } else {
                nVar = new n(this.f896j, this.f895i, this.f897k.getType());
            }
            nVar.d(bVar, obj2);
        }
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes3.dex */
    public static abstract class b<T, A> extends r<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, c> f901a;

        public b(Map<String, c> map) {
            this.f901a = map;
        }

        @Override // com.google.gson.r
        public T b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            A e10 = e();
            try {
                aVar.c();
                while (aVar.y()) {
                    c cVar = this.f901a.get(aVar.U());
                    if (cVar != null && cVar.f906e) {
                        g(e10, aVar, cVar);
                    }
                    aVar.s0();
                }
                aVar.o();
                return f(e10);
            } catch (IllegalAccessException e11) {
                throw H4.a.e(e11);
            } catch (IllegalStateException e12) {
                throw new JsonSyntaxException(e12);
            }
        }

        @Override // com.google.gson.r
        public void d(K4.b bVar, T t10) {
            if (t10 == null) {
                bVar.I();
                return;
            }
            bVar.f();
            try {
                Iterator<c> it = this.f901a.values().iterator();
                while (it.hasNext()) {
                    it.next().c(bVar, t10);
                }
                bVar.o();
            } catch (IllegalAccessException e10) {
                throw H4.a.e(e10);
            }
        }

        public abstract A e();

        public abstract T f(A a10);

        public abstract void g(A a10, K4.a aVar, c cVar);
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes3.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f902a;

        /* renamed from: b, reason: collision with root package name */
        public final Field f903b;

        /* renamed from: c, reason: collision with root package name */
        public final String f904c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f905d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f906e;

        public c(String str, Field field, boolean z10, boolean z11) {
            this.f902a = str;
            this.f903b = field;
            this.f904c = field.getName();
            this.f905d = z10;
            this.f906e = z11;
        }

        public abstract void a(K4.a aVar, int i10, Object[] objArr);

        public abstract void b(K4.a aVar, Object obj);

        public abstract void c(K4.b bVar, Object obj);
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes3.dex */
    public static final class e<T> extends b<T, Object[]> {

        /* renamed from: e, reason: collision with root package name */
        public static final Map<Class<?>, Object> f908e = j();

        /* renamed from: b, reason: collision with root package name */
        public final Constructor<T> f909b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f910c;

        /* renamed from: d, reason: collision with root package name */
        public final Map<String, Integer> f911d;

        public e(Class<T> cls, Map<String, c> map, boolean z10) {
            super(map);
            this.f911d = new HashMap();
            Constructor<T> i10 = H4.a.i(cls);
            this.f909b = i10;
            if (z10) {
                k.c(null, i10);
            } else {
                H4.a.l(i10);
            }
            String[] j10 = H4.a.j(cls);
            for (int i11 = 0; i11 < j10.length; i11++) {
                this.f911d.put(j10[i11], Integer.valueOf(i11));
            }
            Class<?>[] parameterTypes = this.f909b.getParameterTypes();
            this.f910c = new Object[parameterTypes.length];
            for (int i12 = 0; i12 < parameterTypes.length; i12++) {
                this.f910c[i12] = f908e.get(parameterTypes[i12]);
            }
        }

        public static Map<Class<?>, Object> j() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        @Override // F4.k.b
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object[] e() {
            return (Object[]) this.f910c.clone();
        }

        @Override // F4.k.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public T f(Object[] objArr) {
            try {
                return this.f909b.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                throw H4.a.e(e10);
            } catch (IllegalArgumentException | InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + H4.a.c(this.f909b) + "' with args " + Arrays.toString(objArr), e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + H4.a.c(this.f909b) + "' with args " + Arrays.toString(objArr), e12.getCause());
            }
        }

        @Override // F4.k.b
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Object[] objArr, K4.a aVar, c cVar) {
            Integer num = this.f911d.get(cVar.f904c);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + H4.a.c(this.f909b) + "' for field with name '" + cVar.f904c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public k(com.google.gson.internal.b bVar, com.google.gson.c cVar, com.google.gson.internal.c cVar2, F4.e eVar, List<ReflectionAccessFilter> list) {
        this.f887a = bVar;
        this.f888b = cVar;
        this.f889c = cVar2;
        this.f890d = eVar;
        this.f891e = list;
    }

    public static <M extends AccessibleObject & Member> void c(Object obj, M m10) {
        if (Modifier.isStatic(m10.getModifiers())) {
            obj = null;
        }
        if (com.google.gson.internal.i.a(m10, obj)) {
            return;
        }
        throw new JsonIOException(H4.a.g(m10, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    @Override // com.google.gson.s
    public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
        boolean z10;
        Class<? super T> rawType = aVar.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        ReflectionAccessFilter.FilterResult b10 = com.google.gson.internal.i.b(this.f891e, rawType);
        if (b10 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
            if (b10 == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z11 = z10;
            if (H4.a.k(rawType)) {
                return new e(rawType, e(dVar, aVar, rawType, z11, true), z11);
            }
            return new d(this.f887a.b(aVar), e(dVar, aVar, rawType, z11, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    public final c d(com.google.gson.d dVar, Field field, Method method, String str, J4.a<?> aVar, boolean z10, boolean z11, boolean z12) {
        boolean z13;
        r<?> rVar;
        boolean z14;
        boolean a10 = com.google.gson.internal.h.a(aVar.getRawType());
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
            z13 = true;
        } else {
            z13 = false;
        }
        E4.b bVar = (E4.b) field.getAnnotation(E4.b.class);
        if (bVar != null) {
            rVar = this.f890d.b(this.f887a, dVar, aVar, bVar);
        } else {
            rVar = null;
        }
        if (rVar != null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (rVar == null) {
            rVar = dVar.l(aVar);
        }
        return new a(str, field, z10, z11, z12, method, z14, rVar, dVar, aVar, a10, z13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public final Map<String, c> e(com.google.gson.d dVar, J4.a<?> aVar, Class<?> cls, boolean z10, boolean z11) {
        boolean z12;
        Method method;
        int i10;
        int i11;
        boolean z13;
        boolean z14;
        k kVar = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        J4.a<?> aVar2 = aVar;
        boolean z15 = z10;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            boolean z16 = true;
            boolean z17 = false;
            if (cls2 != cls && declaredFields.length > 0) {
                ReflectionAccessFilter.FilterResult b10 = com.google.gson.internal.i.b(kVar.f891e, cls2);
                if (b10 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) {
                    if (b10 == ReflectionAccessFilter.FilterResult.BLOCK_INACCESSIBLE) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                } else {
                    throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + cls2 + " (supertype of " + cls + "). Register a TypeAdapter for this type or adjust the access filter.");
                }
            }
            boolean z18 = z15;
            int length = declaredFields.length;
            int i12 = 0;
            while (i12 < length) {
                Field field = declaredFields[i12];
                boolean g10 = kVar.g(field, z16);
                boolean g11 = kVar.g(field, z17);
                if (!g10 && !g11) {
                    i10 = i12;
                    i11 = length;
                    z13 = z17;
                } else {
                    c cVar = null;
                    if (z11) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            method = null;
                            z12 = z17;
                        } else {
                            Method h10 = H4.a.h(cls2, field);
                            if (!z18) {
                                H4.a.l(h10);
                            }
                            if (h10.getAnnotation(E4.c.class) != null && field.getAnnotation(E4.c.class) == null) {
                                throw new JsonIOException("@SerializedName on " + H4.a.g(h10, z17) + " is not supported");
                            }
                            z12 = g11;
                            method = h10;
                        }
                    } else {
                        z12 = g11;
                        method = null;
                    }
                    if (!z18 && method == null) {
                        H4.a.l(field);
                    }
                    Type o10 = C$Gson$Types.o(aVar2.getType(), cls2, field.getGenericType());
                    List<String> f10 = kVar.f(field);
                    int size = f10.size();
                    ?? r12 = z17;
                    while (r12 < size) {
                        String str = f10.get(r12);
                        if (r12 != 0) {
                            z14 = z17;
                        } else {
                            z14 = g10;
                        }
                        int i13 = r12;
                        c cVar2 = cVar;
                        int i14 = size;
                        List<String> list = f10;
                        Field field2 = field;
                        int i15 = i12;
                        int i16 = length;
                        boolean z19 = z17;
                        c cVar3 = (c) linkedHashMap.put(str, d(dVar, field, method, str, J4.a.get(o10), z14, z12, z18));
                        if (cVar2 == null) {
                            cVar = cVar3;
                        } else {
                            cVar = cVar2;
                        }
                        g10 = z14;
                        i12 = i15;
                        size = i14;
                        f10 = list;
                        field = field2;
                        length = i16;
                        z17 = z19;
                        r12 = i13 + 1;
                    }
                    c cVar4 = cVar;
                    Field field3 = field;
                    i10 = i12;
                    i11 = length;
                    z13 = z17;
                    if (cVar4 != null) {
                        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + cVar4.f902a + "'; conflict is caused by fields " + H4.a.f(cVar4.f903b) + " and " + H4.a.f(field3));
                    }
                }
                i12 = i10 + 1;
                z16 = true;
                kVar = this;
                length = i11;
                z17 = z13;
            }
            aVar2 = J4.a.get(C$Gson$Types.o(aVar2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.getRawType();
            kVar = this;
            z15 = z18;
        }
        return linkedHashMap;
    }

    public final List<String> f(Field field) {
        E4.c cVar = (E4.c) field.getAnnotation(E4.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f888b.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    public final boolean g(Field field, boolean z10) {
        if (!this.f889c.c(field.getType(), z10) && !this.f889c.f(field, z10)) {
            return true;
        }
        return false;
    }

    /* compiled from: ReflectiveTypeAdapterFactory.java */
    /* loaded from: classes3.dex */
    public static final class d<T> extends b<T, T> {

        /* renamed from: b, reason: collision with root package name */
        public final com.google.gson.internal.f<T> f907b;

        public d(com.google.gson.internal.f<T> fVar, Map<String, c> map) {
            super(map);
            this.f907b = fVar;
        }

        @Override // F4.k.b
        public T e() {
            return this.f907b.a();
        }

        @Override // F4.k.b
        public void g(T t10, K4.a aVar, c cVar) {
            cVar.b(aVar, t10);
        }

        @Override // F4.k.b
        public T f(T t10) {
            return t10;
        }
    }
}
