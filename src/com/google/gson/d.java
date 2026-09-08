package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: A, reason: collision with root package name */
    public static final com.google.gson.c f24692A = FieldNamingPolicy.IDENTITY;

    /* renamed from: B, reason: collision with root package name */
    public static final q f24693B = ToNumberPolicy.DOUBLE;

    /* renamed from: C, reason: collision with root package name */
    public static final q f24694C = ToNumberPolicy.LAZILY_PARSED_NUMBER;

    /* renamed from: z, reason: collision with root package name */
    public static final String f24695z = null;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal<Map<J4.a<?>, r<?>>> f24696a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<J4.a<?>, r<?>> f24697b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.gson.internal.b f24698c;

    /* renamed from: d, reason: collision with root package name */
    public final F4.e f24699d;

    /* renamed from: e, reason: collision with root package name */
    public final List<s> f24700e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.gson.internal.c f24701f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.gson.c f24702g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<Type, com.google.gson.f<?>> f24703h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f24704i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f24705j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f24706k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f24707l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f24708m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f24709n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f24710o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f24711p;

    /* renamed from: q, reason: collision with root package name */
    public final String f24712q;

    /* renamed from: r, reason: collision with root package name */
    public final int f24713r;

    /* renamed from: s, reason: collision with root package name */
    public final int f24714s;

    /* renamed from: t, reason: collision with root package name */
    public final LongSerializationPolicy f24715t;

    /* renamed from: u, reason: collision with root package name */
    public final List<s> f24716u;

    /* renamed from: v, reason: collision with root package name */
    public final List<s> f24717v;

    /* renamed from: w, reason: collision with root package name */
    public final q f24718w;

    /* renamed from: x, reason: collision with root package name */
    public final q f24719x;

    /* renamed from: y, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f24720y;

    /* compiled from: Gson.java */
    /* loaded from: classes3.dex */
    public class a extends r<Number> {
        public a() {
        }

        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return Double.valueOf(aVar.O());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Number number) {
            if (number == null) {
                bVar.I();
                return;
            }
            double doubleValue = number.doubleValue();
            d.d(doubleValue);
            bVar.c0(doubleValue);
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes3.dex */
    public class b extends r<Number> {
        public b() {
        }

        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return Float.valueOf((float) aVar.O());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Number number) {
            if (number == null) {
                bVar.I();
                return;
            }
            float floatValue = number.floatValue();
            d.d(floatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(floatValue);
            }
            bVar.h0(number);
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes3.dex */
    public class c extends r<Number> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return Long.valueOf(aVar.T());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Number number) {
            if (number == null) {
                bVar.I();
            } else {
                bVar.i0(number.toString());
            }
        }
    }

    /* compiled from: Gson.java */
    /* renamed from: com.google.gson.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0224d extends r<AtomicLong> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f24723a;

        public C0224d(r rVar) {
            this.f24723a = rVar;
        }

        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(K4.a aVar) {
            return new AtomicLong(((Number) this.f24723a.b(aVar)).longValue());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, AtomicLong atomicLong) {
            this.f24723a.d(bVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes3.dex */
    public class e extends r<AtomicLongArray> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f24724a;

        public e(r rVar) {
            this.f24724a = rVar;
        }

        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(K4.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.y()) {
                arrayList.add(Long.valueOf(((Number) this.f24724a.b(aVar)).longValue()));
            }
            aVar.l();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, AtomicLongArray atomicLongArray) {
            bVar.e();
            int length = atomicLongArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                this.f24724a.d(bVar, Long.valueOf(atomicLongArray.get(i10)));
            }
            bVar.l();
        }
    }

    /* compiled from: Gson.java */
    /* loaded from: classes3.dex */
    public static class f<T> extends F4.l<T> {

        /* renamed from: a, reason: collision with root package name */
        public r<T> f24725a = null;

        private r<T> f() {
            r<T> rVar = this.f24725a;
            if (rVar != null) {
                return rVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.r
        public T b(K4.a aVar) {
            return f().b(aVar);
        }

        @Override // com.google.gson.r
        public void d(K4.b bVar, T t10) {
            f().d(bVar, t10);
        }

        @Override // F4.l
        public r<T> e() {
            return f();
        }

        public void g(r<T> rVar) {
            if (this.f24725a == null) {
                this.f24725a = rVar;
                return;
            }
            throw new AssertionError("Delegate is already set");
        }
    }

    public d() {
        this(com.google.gson.internal.c.f24788g, f24692A, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, f24695z, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), f24693B, f24694C, Collections.emptyList());
    }

    public static void a(Object obj, K4.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f0() != JsonToken.END_DOCUMENT) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException(e10);
            } catch (IOException e11) {
                throw new JsonIOException(e11);
            }
        }
    }

    public static r<AtomicLong> b(r<Number> rVar) {
        return new C0224d(rVar).a();
    }

    public static r<AtomicLongArray> c(r<Number> rVar) {
        return new e(rVar).a();
    }

    public static void d(double d10) {
        if (!Double.isNaN(d10) && !Double.isInfinite(d10)) {
            return;
        }
        throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    public static r<Number> o(LongSerializationPolicy longSerializationPolicy) {
        if (longSerializationPolicy == LongSerializationPolicy.DEFAULT) {
            return F4.o.f967t;
        }
        return new c();
    }

    public final r<Number> e(boolean z10) {
        if (z10) {
            return F4.o.f969v;
        }
        return new a();
    }

    public final r<Number> f(boolean z10) {
        if (z10) {
            return F4.o.f968u;
        }
        return new b();
    }

    public <T> T g(K4.a aVar, J4.a<T> aVar2) {
        boolean B10 = aVar.B();
        boolean z10 = true;
        aVar.l0(true);
        try {
            try {
                try {
                    aVar.f0();
                    z10 = false;
                    return l(aVar2).b(aVar);
                } catch (AssertionError e10) {
                    throw new AssertionError("AssertionError (GSON 2.10.1): " + e10.getMessage(), e10);
                } catch (IllegalStateException e11) {
                    throw new JsonSyntaxException(e11);
                }
            } catch (EOFException e12) {
                if (z10) {
                    aVar.l0(B10);
                    return null;
                }
                throw new JsonSyntaxException(e12);
            } catch (IOException e13) {
                throw new JsonSyntaxException(e13);
            }
        } finally {
            aVar.l0(B10);
        }
    }

    public <T> T h(Reader reader, J4.a<T> aVar) {
        K4.a p10 = p(reader);
        T t10 = (T) g(p10, aVar);
        a(t10, p10);
        return t10;
    }

    public <T> T i(String str, J4.a<T> aVar) {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), aVar);
    }

    public <T> T j(String str, Class<T> cls) {
        return (T) com.google.gson.internal.h.b(cls).cast(i(str, J4.a.get((Class) cls)));
    }

    public <T> T k(String str, Type type) {
        return (T) i(str, J4.a.get(type));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        r2.g(r4);
        r0.put(r7, r4);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> com.google.gson.r<T> l(J4.a<T> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap<J4.a<?>, com.google.gson.r<?>> r0 = r6.f24697b
            java.lang.Object r0 = r0.get(r7)
            com.google.gson.r r0 = (com.google.gson.r) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal<java.util.Map<J4.a<?>, com.google.gson.r<?>>> r0 = r6.f24696a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L26
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal<java.util.Map<J4.a<?>, com.google.gson.r<?>>> r1 = r6.f24696a
            r1.set(r0)
            r1 = 1
            goto L30
        L26:
            java.lang.Object r1 = r0.get(r7)
            com.google.gson.r r1 = (com.google.gson.r) r1
            if (r1 == 0) goto L2f
            return r1
        L2f:
            r1 = 0
        L30:
            com.google.gson.d$f r2 = new com.google.gson.d$f     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L58
            java.util.List<com.google.gson.s> r3 = r6.f24700e     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L58
            r4 = 0
        L3f:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L5a
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L58
            com.google.gson.s r4 = (com.google.gson.s) r4     // Catch: java.lang.Throwable -> L58
            com.google.gson.r r4 = r4.a(r6, r7)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L3f
            r2.g(r4)     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r4)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r7 = move-exception
            goto L82
        L5a:
            if (r1 == 0) goto L61
            java.lang.ThreadLocal<java.util.Map<J4.a<?>, com.google.gson.r<?>>> r2 = r6.f24696a
            r2.remove()
        L61:
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L6a
            java.util.concurrent.ConcurrentMap<J4.a<?>, com.google.gson.r<?>> r6 = r6.f24697b
            r6.putAll(r0)
        L6a:
            return r4
        L6b:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "GSON (2.10.1) cannot handle "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.<init>(r7)
            throw r6
        L82:
            if (r1 == 0) goto L89
            java.lang.ThreadLocal<java.util.Map<J4.a<?>, com.google.gson.r<?>>> r6 = r6.f24696a
            r6.remove()
        L89:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.d.l(J4.a):com.google.gson.r");
    }

    public <T> r<T> m(Class<T> cls) {
        return l(J4.a.get((Class) cls));
    }

    public <T> r<T> n(s sVar, J4.a<T> aVar) {
        if (!this.f24700e.contains(sVar)) {
            sVar = this.f24699d;
        }
        boolean z10 = false;
        for (s sVar2 : this.f24700e) {
            if (!z10) {
                if (sVar2 == sVar) {
                    z10 = true;
                }
            } else {
                r<T> a10 = sVar2.a(this, aVar);
                if (a10 != null) {
                    return a10;
                }
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public K4.a p(Reader reader) {
        K4.a aVar = new K4.a(reader);
        aVar.l0(this.f24709n);
        return aVar;
    }

    public K4.b q(Writer writer) {
        if (this.f24706k) {
            writer.write(")]}'\n");
        }
        K4.b bVar = new K4.b(writer);
        if (this.f24708m) {
            bVar.V("  ");
        }
        bVar.U(this.f24707l);
        bVar.X(this.f24709n);
        bVar.Z(this.f24704i);
        return bVar;
    }

    public String r(j jVar) {
        StringWriter stringWriter = new StringWriter();
        v(jVar, stringWriter);
        return stringWriter.toString();
    }

    public String s(Object obj) {
        if (obj == null) {
            return r(k.f24815a);
        }
        return t(obj, obj.getClass());
    }

    public String t(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        x(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String toString() {
        return "{serializeNulls:" + this.f24704i + ",factories:" + this.f24700e + ",instanceCreators:" + this.f24698c + "}";
    }

    public void u(j jVar, K4.b bVar) {
        boolean u10 = bVar.u();
        bVar.X(true);
        boolean s10 = bVar.s();
        bVar.U(this.f24707l);
        boolean r10 = bVar.r();
        bVar.Z(this.f24704i);
        try {
            try {
                com.google.gson.internal.j.b(jVar, bVar);
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } finally {
            bVar.X(u10);
            bVar.U(s10);
            bVar.Z(r10);
        }
    }

    public void v(j jVar, Appendable appendable) {
        try {
            u(jVar, q(com.google.gson.internal.j.c(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public void w(Object obj, Type type, K4.b bVar) {
        r l10 = l(J4.a.get(type));
        boolean u10 = bVar.u();
        bVar.X(true);
        boolean s10 = bVar.s();
        bVar.U(this.f24707l);
        boolean r10 = bVar.r();
        bVar.Z(this.f24704i);
        try {
            try {
                l10.d(bVar, obj);
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e11.getMessage(), e11);
            }
        } finally {
            bVar.X(u10);
            bVar.U(s10);
            bVar.Z(r10);
        }
    }

    public void x(Object obj, Type type, Appendable appendable) {
        try {
            w(obj, type, q(com.google.gson.internal.j.c(appendable)));
        } catch (IOException e10) {
            throw new JsonIOException(e10);
        }
    }

    public d(com.google.gson.internal.c cVar, com.google.gson.c cVar2, Map<Type, com.google.gson.f<?>> map, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, LongSerializationPolicy longSerializationPolicy, String str, int i10, int i11, List<s> list, List<s> list2, List<s> list3, q qVar, q qVar2, List<ReflectionAccessFilter> list4) {
        this.f24696a = new ThreadLocal<>();
        this.f24697b = new ConcurrentHashMap();
        this.f24701f = cVar;
        this.f24702g = cVar2;
        this.f24703h = map;
        com.google.gson.internal.b bVar = new com.google.gson.internal.b(map, z17, list4);
        this.f24698c = bVar;
        this.f24704i = z10;
        this.f24705j = z11;
        this.f24706k = z12;
        this.f24707l = z13;
        this.f24708m = z14;
        this.f24709n = z15;
        this.f24710o = z16;
        this.f24711p = z17;
        this.f24715t = longSerializationPolicy;
        this.f24712q = str;
        this.f24713r = i10;
        this.f24714s = i11;
        this.f24716u = list;
        this.f24717v = list2;
        this.f24718w = qVar;
        this.f24719x = qVar2;
        this.f24720y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(F4.o.f946W);
        arrayList.add(F4.j.e(qVar));
        arrayList.add(cVar);
        arrayList.addAll(list3);
        arrayList.add(F4.o.f926C);
        arrayList.add(F4.o.f960m);
        arrayList.add(F4.o.f954g);
        arrayList.add(F4.o.f956i);
        arrayList.add(F4.o.f958k);
        r<Number> o10 = o(longSerializationPolicy);
        arrayList.add(F4.o.b(Long.TYPE, Long.class, o10));
        arrayList.add(F4.o.b(Double.TYPE, Double.class, e(z16)));
        arrayList.add(F4.o.b(Float.TYPE, Float.class, f(z16)));
        arrayList.add(F4.i.e(qVar2));
        arrayList.add(F4.o.f962o);
        arrayList.add(F4.o.f964q);
        arrayList.add(F4.o.a(AtomicLong.class, b(o10)));
        arrayList.add(F4.o.a(AtomicLongArray.class, c(o10)));
        arrayList.add(F4.o.f966s);
        arrayList.add(F4.o.f971x);
        arrayList.add(F4.o.f928E);
        arrayList.add(F4.o.f930G);
        arrayList.add(F4.o.a(BigDecimal.class, F4.o.f973z));
        arrayList.add(F4.o.a(BigInteger.class, F4.o.f924A));
        arrayList.add(F4.o.a(LazilyParsedNumber.class, F4.o.f925B));
        arrayList.add(F4.o.f932I);
        arrayList.add(F4.o.f934K);
        arrayList.add(F4.o.f938O);
        arrayList.add(F4.o.f940Q);
        arrayList.add(F4.o.f944U);
        arrayList.add(F4.o.f936M);
        arrayList.add(F4.o.f951d);
        arrayList.add(F4.c.f853b);
        arrayList.add(F4.o.f942S);
        if (I4.d.f1340a) {
            arrayList.add(I4.d.f1344e);
            arrayList.add(I4.d.f1343d);
            arrayList.add(I4.d.f1345f);
        }
        arrayList.add(F4.a.f847c);
        arrayList.add(F4.o.f949b);
        arrayList.add(new F4.b(bVar));
        arrayList.add(new F4.h(bVar, z11));
        F4.e eVar = new F4.e(bVar);
        this.f24699d = eVar;
        arrayList.add(eVar);
        arrayList.add(F4.o.f947X);
        arrayList.add(new F4.k(bVar, cVar2, cVar, eVar, list4));
        this.f24700e = Collections.unmodifiableList(arrayList);
    }
}
