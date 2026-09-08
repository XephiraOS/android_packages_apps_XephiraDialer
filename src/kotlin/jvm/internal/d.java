package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.D;
import kotlin.collections.E;
import kotlin.collections.o;
import kotlin.text.StringsKt__StringsKt;
import u9.C1614a;
import v9.InterfaceC1637a;
import v9.p;
import v9.q;
import v9.r;
import v9.s;
import v9.t;
import v9.u;
import v9.v;
import v9.w;

/* compiled from: ClassReference.kt */
/* loaded from: classes4.dex */
public final class d implements C9.c<Object>, c {

    /* renamed from: b, reason: collision with root package name */
    public static final a f34233b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Class<? extends m9.c<?>>, Integer> f34234c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<String, String> f34235d;

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap<String, String> f34236e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap<String, String> f34237f;

    /* renamed from: g, reason: collision with root package name */
    public static final Map<String, String> f34238g;

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f34239a;

    /* compiled from: ClassReference.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public final String a(Class<?> jClass) {
            String str;
            i.f(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (jClass.isArray()) {
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) d.f34237f.get(componentType.getName())) != null) {
                    str2 = str + "Array";
                }
                if (str2 == null) {
                    return "kotlin.Array";
                }
                return str2;
            }
            String str3 = (String) d.f34237f.get(jClass.getName());
            if (str3 == null) {
                return jClass.getCanonicalName();
            }
            return str3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x003b, code lost:
        
            if (r1 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String b(java.lang.Class<?> r6) {
            /*
                r5 = this;
                java.lang.String r5 = "jClass"
                kotlin.jvm.internal.i.f(r6, r5)
                boolean r5 = r6.isAnonymousClass()
                r0 = 0
                if (r5 == 0) goto Le
                goto Lb3
            Le:
                boolean r5 = r6.isLocalClass()
                if (r5 == 0) goto L6a
                java.lang.String r5 = r6.getSimpleName()
                java.lang.reflect.Method r1 = r6.getEnclosingMethod()
                r2 = 2
                r3 = 36
                if (r1 == 0) goto L41
                kotlin.jvm.internal.i.c(r5)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r1 = r1.getName()
                r4.append(r1)
                r4.append(r3)
                java.lang.String r1 = r4.toString()
                java.lang.String r1 = kotlin.text.f.f0(r5, r1, r0, r2, r0)
                if (r1 != 0) goto L3e
                goto L41
            L3e:
                r0 = r1
                goto Lb3
            L41:
                java.lang.reflect.Constructor r6 = r6.getEnclosingConstructor()
                if (r6 == 0) goto L62
                kotlin.jvm.internal.i.c(r5)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r6 = r6.getName()
                r1.append(r6)
                r1.append(r3)
                java.lang.String r6 = r1.toString()
                java.lang.String r0 = kotlin.text.f.f0(r5, r6, r0, r2, r0)
                goto Lb3
            L62:
                kotlin.jvm.internal.i.c(r5)
                java.lang.String r0 = kotlin.text.f.e0(r5, r3, r0, r2, r0)
                goto Lb3
            L6a:
                boolean r5 = r6.isArray()
                if (r5 == 0) goto L9e
                java.lang.Class r5 = r6.getComponentType()
                boolean r6 = r5.isPrimitive()
                java.lang.String r1 = "Array"
                if (r6 == 0) goto L9b
                java.util.Map r6 = kotlin.jvm.internal.d.h()
                java.lang.String r5 = r5.getName()
                java.lang.Object r5 = r6.get(r5)
                java.lang.String r5 = (java.lang.String) r5
                if (r5 == 0) goto L9b
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r5)
                r6.append(r1)
                java.lang.String r0 = r6.toString()
            L9b:
                if (r0 != 0) goto Lb3
                goto L3e
            L9e:
                java.util.Map r5 = kotlin.jvm.internal.d.h()
                java.lang.String r0 = r6.getName()
                java.lang.Object r5 = r5.get(r0)
                r0 = r5
                java.lang.String r0 = (java.lang.String) r0
                if (r0 != 0) goto Lb3
                java.lang.String r0 = r6.getSimpleName()
            Lb3:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.d.a.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(Object obj, Class<?> jClass) {
            i.f(jClass, "jClass");
            Map map = d.f34234c;
            i.d(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return n.e(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = C1614a.b(C1614a.c(jClass));
            }
            return jClass.isInstance(obj);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List j10;
        int p10;
        Map<Class<? extends m9.c<?>>, Integer> j11;
        int a10;
        String h02;
        String h03;
        j10 = o.j(InterfaceC1637a.class, v9.l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, v9.b.class, v9.c.class, v9.d.class, v9.e.class, v9.f.class, v9.g.class, v9.h.class, v9.i.class, v9.j.class, v9.k.class, v9.m.class, v9.n.class, v9.o.class);
        List list = j10;
        p10 = kotlin.collections.p.p(list, 10);
        ArrayList arrayList = new ArrayList(p10);
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                o.o();
            }
            arrayList.add(m9.g.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        j11 = E.j(arrayList);
        f34234c = j11;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f34235d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f34236e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        i.e(values, "<get-values>(...)");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            i.c(str);
            h03 = StringsKt__StringsKt.h0(str, '.', null, 2, null);
            sb.append(h03);
            sb.append("CompanionObject");
            Pair a11 = m9.g.a(sb.toString(), str + ".Companion");
            hashMap3.put(a11.c(), a11.d());
        }
        for (Map.Entry<Class<? extends m9.c<?>>, Integer> entry : f34234c.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f34237f = hashMap3;
        a10 = D.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            h02 = StringsKt__StringsKt.h0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, h02);
        }
        f34238g = linkedHashMap;
    }

    public d(Class<?> jClass) {
        i.f(jClass, "jClass");
        this.f34239a = jClass;
    }

    @Override // C9.c
    public String b() {
        return f34233b.a(d());
    }

    @Override // C9.c
    public String c() {
        return f34233b.b(d());
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> d() {
        return this.f34239a;
    }

    @Override // C9.c
    public boolean e(Object obj) {
        return f34233b.c(obj, d());
    }

    public boolean equals(Object obj) {
        if ((obj instanceof d) && i.b(C1614a.b(this), C1614a.b((C9.c) obj))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return C1614a.b(this).hashCode();
    }

    public String toString() {
        return d().toString() + " (Kotlin reflection is not available)";
    }
}
