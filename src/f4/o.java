package F4;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters.java */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: A, reason: collision with root package name */
    public static final com.google.gson.r<BigInteger> f924A;

    /* renamed from: B, reason: collision with root package name */
    public static final com.google.gson.r<LazilyParsedNumber> f925B;

    /* renamed from: C, reason: collision with root package name */
    public static final com.google.gson.s f926C;

    /* renamed from: D, reason: collision with root package name */
    public static final com.google.gson.r<StringBuilder> f927D;

    /* renamed from: E, reason: collision with root package name */
    public static final com.google.gson.s f928E;

    /* renamed from: F, reason: collision with root package name */
    public static final com.google.gson.r<StringBuffer> f929F;

    /* renamed from: G, reason: collision with root package name */
    public static final com.google.gson.s f930G;

    /* renamed from: H, reason: collision with root package name */
    public static final com.google.gson.r<URL> f931H;

    /* renamed from: I, reason: collision with root package name */
    public static final com.google.gson.s f932I;

    /* renamed from: J, reason: collision with root package name */
    public static final com.google.gson.r<URI> f933J;

    /* renamed from: K, reason: collision with root package name */
    public static final com.google.gson.s f934K;

    /* renamed from: L, reason: collision with root package name */
    public static final com.google.gson.r<InetAddress> f935L;

    /* renamed from: M, reason: collision with root package name */
    public static final com.google.gson.s f936M;

    /* renamed from: N, reason: collision with root package name */
    public static final com.google.gson.r<UUID> f937N;

    /* renamed from: O, reason: collision with root package name */
    public static final com.google.gson.s f938O;

    /* renamed from: P, reason: collision with root package name */
    public static final com.google.gson.r<Currency> f939P;

    /* renamed from: Q, reason: collision with root package name */
    public static final com.google.gson.s f940Q;

    /* renamed from: R, reason: collision with root package name */
    public static final com.google.gson.r<Calendar> f941R;

    /* renamed from: S, reason: collision with root package name */
    public static final com.google.gson.s f942S;

    /* renamed from: T, reason: collision with root package name */
    public static final com.google.gson.r<Locale> f943T;

    /* renamed from: U, reason: collision with root package name */
    public static final com.google.gson.s f944U;

    /* renamed from: V, reason: collision with root package name */
    public static final com.google.gson.r<com.google.gson.j> f945V;

    /* renamed from: W, reason: collision with root package name */
    public static final com.google.gson.s f946W;

    /* renamed from: X, reason: collision with root package name */
    public static final com.google.gson.s f947X;

    /* renamed from: a, reason: collision with root package name */
    public static final com.google.gson.r<Class> f948a;

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.gson.s f949b;

    /* renamed from: c, reason: collision with root package name */
    public static final com.google.gson.r<BitSet> f950c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.google.gson.s f951d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.google.gson.r<Boolean> f952e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.gson.r<Boolean> f953f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.google.gson.s f954g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.google.gson.r<Number> f955h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.google.gson.s f956i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.google.gson.r<Number> f957j;

    /* renamed from: k, reason: collision with root package name */
    public static final com.google.gson.s f958k;

    /* renamed from: l, reason: collision with root package name */
    public static final com.google.gson.r<Number> f959l;

    /* renamed from: m, reason: collision with root package name */
    public static final com.google.gson.s f960m;

    /* renamed from: n, reason: collision with root package name */
    public static final com.google.gson.r<AtomicInteger> f961n;

    /* renamed from: o, reason: collision with root package name */
    public static final com.google.gson.s f962o;

    /* renamed from: p, reason: collision with root package name */
    public static final com.google.gson.r<AtomicBoolean> f963p;

    /* renamed from: q, reason: collision with root package name */
    public static final com.google.gson.s f964q;

    /* renamed from: r, reason: collision with root package name */
    public static final com.google.gson.r<AtomicIntegerArray> f965r;

    /* renamed from: s, reason: collision with root package name */
    public static final com.google.gson.s f966s;

    /* renamed from: t, reason: collision with root package name */
    public static final com.google.gson.r<Number> f967t;

    /* renamed from: u, reason: collision with root package name */
    public static final com.google.gson.r<Number> f968u;

    /* renamed from: v, reason: collision with root package name */
    public static final com.google.gson.r<Number> f969v;

    /* renamed from: w, reason: collision with root package name */
    public static final com.google.gson.r<Character> f970w;

    /* renamed from: x, reason: collision with root package name */
    public static final com.google.gson.s f971x;

    /* renamed from: y, reason: collision with root package name */
    public static final com.google.gson.r<String> f972y;

    /* renamed from: z, reason: collision with root package name */
    public static final com.google.gson.r<BigDecimal> f973z;

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class A {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f974a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f974a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f974a[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f974a[JsonToken.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f974a[JsonToken.BEGIN_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f974a[JsonToken.BEGIN_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f974a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class B extends com.google.gson.r<Boolean> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(K4.a aVar) {
            JsonToken f02 = aVar.f0();
            if (f02 == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            if (f02 == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(aVar.a0()));
            }
            return Boolean.valueOf(aVar.L());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Boolean bool) {
            bVar.g0(bool);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class C extends com.google.gson.r<Boolean> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return Boolean.valueOf(aVar.a0());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Boolean bool) {
            String bool2;
            if (bool == null) {
                bool2 = "null";
            } else {
                bool2 = bool.toString();
            }
            bVar.i0(bool2);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class D extends com.google.gson.r<Number> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            try {
                int S10 = aVar.S();
                if (S10 <= 255 && S10 >= -128) {
                    return Byte.valueOf((byte) S10);
                }
                throw new JsonSyntaxException("Lossy conversion from " + S10 + " to byte; at path " + aVar.u());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Number number) {
            if (number == null) {
                bVar.I();
            } else {
                bVar.f0(number.byteValue());
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class E extends com.google.gson.r<Number> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            try {
                int S10 = aVar.S();
                if (S10 <= 65535 && S10 >= -32768) {
                    return Short.valueOf((short) S10);
                }
                throw new JsonSyntaxException("Lossy conversion from " + S10 + " to short; at path " + aVar.u());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Number number) {
            if (number == null) {
                bVar.I();
            } else {
                bVar.f0(number.shortValue());
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class F extends com.google.gson.r<Number> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            try {
                return Integer.valueOf(aVar.S());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Number number) {
            if (number == null) {
                bVar.I();
            } else {
                bVar.f0(number.intValue());
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class G extends com.google.gson.r<AtomicInteger> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicInteger b(K4.a aVar) {
            try {
                return new AtomicInteger(aVar.S());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, AtomicInteger atomicInteger) {
            bVar.f0(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class H extends com.google.gson.r<AtomicBoolean> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean b(K4.a aVar) {
            return new AtomicBoolean(aVar.L());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, AtomicBoolean atomicBoolean) {
            bVar.j0(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public static final class I<T extends Enum<T>> extends com.google.gson.r<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, T> f975a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, T> f976b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final Map<T, String> f977c = new HashMap();

        /* compiled from: TypeAdapters.java */
        /* loaded from: classes3.dex */
        public class a implements PrivilegedAction<Field[]> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f978a;

            public a(Class cls) {
                this.f978a = cls;
            }

            @Override // java.security.PrivilegedAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Field[] run() {
                Field[] declaredFields = this.f978a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public I(Class<T> cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum r42 = (Enum) field.get(null);
                    String name = r42.name();
                    String str = r42.toString();
                    E4.c cVar = (E4.c) field.getAnnotation(E4.c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String str2 : cVar.alternate()) {
                            this.f975a.put(str2, r42);
                        }
                    }
                    this.f975a.put(name, r42);
                    this.f976b.put(str, r42);
                    this.f977c.put(r42, name);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public T b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            String a02 = aVar.a0();
            T t10 = this.f975a.get(a02);
            if (t10 == null) {
                return this.f976b.get(a02);
            }
            return t10;
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, T t10) {
            String str;
            if (t10 == null) {
                str = null;
            } else {
                str = this.f977c.get(t10);
            }
            bVar.i0(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$a, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0386a extends com.google.gson.r<AtomicIntegerArray> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray b(K4.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.y()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.S()));
                } catch (NumberFormatException e10) {
                    throw new JsonSyntaxException(e10);
                }
            }
            aVar.l();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i10 = 0; i10 < size; i10++) {
                atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, AtomicIntegerArray atomicIntegerArray) {
            bVar.e();
            int length = atomicIntegerArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.f0(atomicIntegerArray.get(i10));
            }
            bVar.l();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$b, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0387b extends com.google.gson.r<Number> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            try {
                return Long.valueOf(aVar.T());
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException(e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Number number) {
            if (number == null) {
                bVar.I();
            } else {
                bVar.f0(number.longValue());
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$c, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0388c extends com.google.gson.r<Number> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(K4.a aVar) {
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
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            bVar.h0(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$d, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0389d extends com.google.gson.r<Number> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(K4.a aVar) {
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
            } else {
                bVar.c0(number.doubleValue());
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$e, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0390e extends com.google.gson.r<Character> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Character b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            String a02 = aVar.a0();
            if (a02.length() == 1) {
                return Character.valueOf(a02.charAt(0));
            }
            throw new JsonSyntaxException("Expecting character, got: " + a02 + "; at " + aVar.u());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Character ch) {
            String valueOf;
            if (ch == null) {
                valueOf = null;
            } else {
                valueOf = String.valueOf(ch);
            }
            bVar.i0(valueOf);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$f, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0391f extends com.google.gson.r<String> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public String b(K4.a aVar) {
            JsonToken f02 = aVar.f0();
            if (f02 == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            if (f02 == JsonToken.BOOLEAN) {
                return Boolean.toString(aVar.L());
            }
            return aVar.a0();
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, String str) {
            bVar.i0(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$g, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0392g extends com.google.gson.r<BigDecimal> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigDecimal b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            String a02 = aVar.a0();
            try {
                return new BigDecimal(a02);
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException("Failed parsing '" + a02 + "' as BigDecimal; at path " + aVar.u(), e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, BigDecimal bigDecimal) {
            bVar.h0(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$h, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0393h extends com.google.gson.r<BigInteger> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BigInteger b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            String a02 = aVar.a0();
            try {
                return new BigInteger(a02);
            } catch (NumberFormatException e10) {
                throw new JsonSyntaxException("Failed parsing '" + a02 + "' as BigInteger; at path " + aVar.u(), e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, BigInteger bigInteger) {
            bVar.h0(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$i, reason: case insensitive filesystem */
    /* loaded from: classes3.dex */
    public class C0394i extends com.google.gson.r<LazilyParsedNumber> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public LazilyParsedNumber b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return new LazilyParsedNumber(aVar.a0());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, LazilyParsedNumber lazilyParsedNumber) {
            bVar.h0(lazilyParsedNumber);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class j extends com.google.gson.r<StringBuilder> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuilder b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return new StringBuilder(aVar.a0());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, StringBuilder sb) {
            String sb2;
            if (sb == null) {
                sb2 = null;
            } else {
                sb2 = sb.toString();
            }
            bVar.i0(sb2);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class k extends com.google.gson.r<Class> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Class b(K4.a aVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Class cls) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class l extends com.google.gson.r<StringBuffer> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public StringBuffer b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return new StringBuffer(aVar.a0());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, StringBuffer stringBuffer) {
            String stringBuffer2;
            if (stringBuffer == null) {
                stringBuffer2 = null;
            } else {
                stringBuffer2 = stringBuffer.toString();
            }
            bVar.i0(stringBuffer2);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class m extends com.google.gson.r<URL> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URL b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            String a02 = aVar.a0();
            if ("null".equals(a02)) {
                return null;
            }
            return new URL(a02);
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, URL url) {
            String externalForm;
            if (url == null) {
                externalForm = null;
            } else {
                externalForm = url.toExternalForm();
            }
            bVar.i0(externalForm);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class n extends com.google.gson.r<URI> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public URI b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            try {
                String a02 = aVar.a0();
                if ("null".equals(a02)) {
                    return null;
                }
                return new URI(a02);
            } catch (URISyntaxException e10) {
                throw new JsonIOException(e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, URI uri) {
            String aSCIIString;
            if (uri == null) {
                aSCIIString = null;
            } else {
                aSCIIString = uri.toASCIIString();
            }
            bVar.i0(aSCIIString);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: F4.o$o, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0016o extends com.google.gson.r<InetAddress> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public InetAddress b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            return InetAddress.getByName(aVar.a0());
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, InetAddress inetAddress) {
            String hostAddress;
            if (inetAddress == null) {
                hostAddress = null;
            } else {
                hostAddress = inetAddress.getHostAddress();
            }
            bVar.i0(hostAddress);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class p extends com.google.gson.r<UUID> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public UUID b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            String a02 = aVar.a0();
            try {
                return UUID.fromString(a02);
            } catch (IllegalArgumentException e10) {
                throw new JsonSyntaxException("Failed parsing '" + a02 + "' as UUID; at path " + aVar.u(), e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, UUID uuid) {
            String uuid2;
            if (uuid == null) {
                uuid2 = null;
            } else {
                uuid2 = uuid.toString();
            }
            bVar.i0(uuid2);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class q extends com.google.gson.r<Currency> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Currency b(K4.a aVar) {
            String a02 = aVar.a0();
            try {
                return Currency.getInstance(a02);
            } catch (IllegalArgumentException e10) {
                throw new JsonSyntaxException("Failed parsing '" + a02 + "' as Currency; at path " + aVar.u(), e10);
            }
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Currency currency) {
            bVar.i0(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class r extends com.google.gson.r<Calendar> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Calendar b(K4.a aVar) {
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            aVar.c();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (aVar.f0() != JsonToken.END_OBJECT) {
                String U10 = aVar.U();
                int S10 = aVar.S();
                if ("year".equals(U10)) {
                    i10 = S10;
                } else if ("month".equals(U10)) {
                    i11 = S10;
                } else if ("dayOfMonth".equals(U10)) {
                    i12 = S10;
                } else if ("hourOfDay".equals(U10)) {
                    i13 = S10;
                } else if ("minute".equals(U10)) {
                    i14 = S10;
                } else if ("second".equals(U10)) {
                    i15 = S10;
                }
            }
            aVar.o();
            return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Calendar calendar) {
            if (calendar == null) {
                bVar.I();
                return;
            }
            bVar.f();
            bVar.B("year");
            bVar.f0(calendar.get(1));
            bVar.B("month");
            bVar.f0(calendar.get(2));
            bVar.B("dayOfMonth");
            bVar.f0(calendar.get(5));
            bVar.B("hourOfDay");
            bVar.f0(calendar.get(11));
            bVar.B("minute");
            bVar.f0(calendar.get(12));
            bVar.B("second");
            bVar.f0(calendar.get(13));
            bVar.o();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class s extends com.google.gson.r<Locale> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Locale b(K4.a aVar) {
            String str;
            String str2;
            String str3 = null;
            if (aVar.f0() == JsonToken.NULL) {
                aVar.X();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.a0(), "_");
            if (stringTokenizer.hasMoreElements()) {
                str = stringTokenizer.nextToken();
            } else {
                str = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = null;
            }
            if (stringTokenizer.hasMoreElements()) {
                str3 = stringTokenizer.nextToken();
            }
            if (str2 == null && str3 == null) {
                return new Locale(str);
            }
            if (str3 == null) {
                return new Locale(str, str2);
            }
            return new Locale(str, str2, str3);
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, Locale locale) {
            String locale2;
            if (locale == null) {
                locale2 = null;
            } else {
                locale2 = locale.toString();
            }
            bVar.i0(locale2);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class t extends com.google.gson.r<com.google.gson.j> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public com.google.gson.j b(K4.a aVar) {
            String str;
            boolean z10;
            if (aVar instanceof f) {
                return ((f) aVar).v0();
            }
            JsonToken f02 = aVar.f0();
            com.google.gson.j g10 = g(aVar, f02);
            if (g10 == null) {
                return f(aVar, f02);
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            while (true) {
                if (aVar.y()) {
                    if (g10 instanceof com.google.gson.l) {
                        str = aVar.U();
                    } else {
                        str = null;
                    }
                    JsonToken f03 = aVar.f0();
                    com.google.gson.j g11 = g(aVar, f03);
                    if (g11 != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (g11 == null) {
                        g11 = f(aVar, f03);
                    }
                    if (g10 instanceof com.google.gson.g) {
                        ((com.google.gson.g) g10).k(g11);
                    } else {
                        ((com.google.gson.l) g10).k(str, g11);
                    }
                    if (z10) {
                        arrayDeque.addLast(g10);
                        g10 = g11;
                    }
                } else {
                    if (g10 instanceof com.google.gson.g) {
                        aVar.l();
                    } else {
                        aVar.o();
                    }
                    if (arrayDeque.isEmpty()) {
                        return g10;
                    }
                    g10 = (com.google.gson.j) arrayDeque.removeLast();
                }
            }
        }

        public final com.google.gson.j f(K4.a aVar, JsonToken jsonToken) {
            int i10 = A.f974a[jsonToken.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 == 6) {
                            aVar.X();
                            return com.google.gson.k.f24815a;
                        }
                        throw new IllegalStateException("Unexpected token: " + jsonToken);
                    }
                    return new com.google.gson.n(Boolean.valueOf(aVar.L()));
                }
                return new com.google.gson.n(aVar.a0());
            }
            return new com.google.gson.n(new LazilyParsedNumber(aVar.a0()));
        }

        public final com.google.gson.j g(K4.a aVar, JsonToken jsonToken) {
            int i10 = A.f974a[jsonToken.ordinal()];
            if (i10 != 4) {
                if (i10 != 5) {
                    return null;
                }
                aVar.c();
                return new com.google.gson.l();
            }
            aVar.a();
            return new com.google.gson.g();
        }

        @Override // com.google.gson.r
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, com.google.gson.j jVar) {
            if (jVar != null && !jVar.h()) {
                if (jVar.j()) {
                    com.google.gson.n e10 = jVar.e();
                    if (e10.s()) {
                        bVar.h0(e10.o());
                        return;
                    } else if (e10.q()) {
                        bVar.j0(e10.k());
                        return;
                    } else {
                        bVar.i0(e10.p());
                        return;
                    }
                }
                if (jVar.g()) {
                    bVar.e();
                    Iterator<com.google.gson.j> it = jVar.a().iterator();
                    while (it.hasNext()) {
                        d(bVar, it.next());
                    }
                    bVar.l();
                    return;
                }
                if (jVar.i()) {
                    bVar.f();
                    for (Map.Entry<String, com.google.gson.j> entry : jVar.c().l()) {
                        bVar.B(entry.getKey());
                        d(bVar, entry.getValue());
                    }
                    bVar.o();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + jVar.getClass());
            }
            bVar.I();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class u implements com.google.gson.s {
        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (Enum.class.isAssignableFrom(rawType) && rawType != Enum.class) {
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new I(rawType);
            }
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class v extends com.google.gson.r<BitSet> {
        @Override // com.google.gson.r
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BitSet b(K4.a aVar) {
            BitSet bitSet = new BitSet();
            aVar.a();
            JsonToken f02 = aVar.f0();
            int i10 = 0;
            while (f02 != JsonToken.END_ARRAY) {
                int i11 = A.f974a[f02.ordinal()];
                if (i11 != 1 && i11 != 2) {
                    if (i11 == 3) {
                        if (!aVar.L()) {
                            i10++;
                            f02 = aVar.f0();
                        }
                        bitSet.set(i10);
                        i10++;
                        f02 = aVar.f0();
                    } else {
                        throw new JsonSyntaxException("Invalid bitset value type: " + f02 + "; at path " + aVar.d());
                    }
                } else {
                    int S10 = aVar.S();
                    if (S10 != 0) {
                        if (S10 != 1) {
                            throw new JsonSyntaxException("Invalid bitset value " + S10 + ", expected 0 or 1; at path " + aVar.u());
                        }
                        bitSet.set(i10);
                        i10++;
                        f02 = aVar.f0();
                    } else {
                        continue;
                        i10++;
                        f02 = aVar.f0();
                    }
                }
            }
            aVar.l();
            return bitSet;
        }

        @Override // com.google.gson.r
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(K4.b bVar, BitSet bitSet) {
            bVar.e();
            int length = bitSet.length();
            for (int i10 = 0; i10 < length; i10++) {
                bVar.f0(bitSet.get(i10) ? 1L : 0L);
            }
            bVar.l();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class w implements com.google.gson.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f980a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.r f981b;

        public w(Class cls, com.google.gson.r rVar) {
            this.f980a = cls;
            this.f981b = rVar;
        }

        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            if (aVar.getRawType() == this.f980a) {
                return this.f981b;
            }
            return null;
        }

        public String toString() {
            return "Factory[type=" + this.f980a.getName() + ",adapter=" + this.f981b + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class x implements com.google.gson.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f982a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f983b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.r f984c;

        public x(Class cls, Class cls2, com.google.gson.r rVar) {
            this.f982a = cls;
            this.f983b = cls2;
            this.f984c = rVar;
        }

        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType != this.f982a && rawType != this.f983b) {
                return null;
            }
            return this.f984c;
        }

        public String toString() {
            return "Factory[type=" + this.f983b.getName() + "+" + this.f982a.getName() + ",adapter=" + this.f984c + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class y implements com.google.gson.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f985a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f986b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.r f987c;

        public y(Class cls, Class cls2, com.google.gson.r rVar) {
            this.f985a = cls;
            this.f986b = cls2;
            this.f987c = rVar;
        }

        @Override // com.google.gson.s
        public <T> com.google.gson.r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            Class<? super T> rawType = aVar.getRawType();
            if (rawType != this.f985a && rawType != this.f986b) {
                return null;
            }
            return this.f987c;
        }

        public String toString() {
            return "Factory[type=" + this.f985a.getName() + "+" + this.f986b.getName() + ",adapter=" + this.f987c + "]";
        }
    }

    /* compiled from: TypeAdapters.java */
    /* loaded from: classes3.dex */
    public class z implements com.google.gson.s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f988a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.google.gson.r f989b;

        /* JADX INFO: Add missing generic type declarations: [T1] */
        /* compiled from: TypeAdapters.java */
        /* loaded from: classes3.dex */
        public class a<T1> extends com.google.gson.r<T1> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Class f990a;

            public a(Class cls) {
                this.f990a = cls;
            }

            @Override // com.google.gson.r
            public T1 b(K4.a aVar) {
                T1 t12 = (T1) z.this.f989b.b(aVar);
                if (t12 != null && !this.f990a.isInstance(t12)) {
                    throw new JsonSyntaxException("Expected a " + this.f990a.getName() + " but was " + t12.getClass().getName() + "; at path " + aVar.u());
                }
                return t12;
            }

            @Override // com.google.gson.r
            public void d(K4.b bVar, T1 t12) {
                z.this.f989b.d(bVar, t12);
            }
        }

        public z(Class cls, com.google.gson.r rVar) {
            this.f988a = cls;
            this.f989b = rVar;
        }

        @Override // com.google.gson.s
        public <T2> com.google.gson.r<T2> a(com.google.gson.d dVar, J4.a<T2> aVar) {
            Class<? super T2> rawType = aVar.getRawType();
            if (!this.f988a.isAssignableFrom(rawType)) {
                return null;
            }
            return new a(rawType);
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.f988a.getName() + ",adapter=" + this.f989b + "]";
        }
    }

    static {
        com.google.gson.r<Class> a10 = new k().a();
        f948a = a10;
        f949b = a(Class.class, a10);
        com.google.gson.r<BitSet> a11 = new v().a();
        f950c = a11;
        f951d = a(BitSet.class, a11);
        B b10 = new B();
        f952e = b10;
        f953f = new C();
        f954g = b(Boolean.TYPE, Boolean.class, b10);
        D d10 = new D();
        f955h = d10;
        f956i = b(Byte.TYPE, Byte.class, d10);
        E e10 = new E();
        f957j = e10;
        f958k = b(Short.TYPE, Short.class, e10);
        F f10 = new F();
        f959l = f10;
        f960m = b(Integer.TYPE, Integer.class, f10);
        com.google.gson.r<AtomicInteger> a12 = new G().a();
        f961n = a12;
        f962o = a(AtomicInteger.class, a12);
        com.google.gson.r<AtomicBoolean> a13 = new H().a();
        f963p = a13;
        f964q = a(AtomicBoolean.class, a13);
        com.google.gson.r<AtomicIntegerArray> a14 = new C0386a().a();
        f965r = a14;
        f966s = a(AtomicIntegerArray.class, a14);
        f967t = new C0387b();
        f968u = new C0388c();
        f969v = new C0389d();
        C0390e c0390e = new C0390e();
        f970w = c0390e;
        f971x = b(Character.TYPE, Character.class, c0390e);
        C0391f c0391f = new C0391f();
        f972y = c0391f;
        f973z = new C0392g();
        f924A = new C0393h();
        f925B = new C0394i();
        f926C = a(String.class, c0391f);
        j jVar = new j();
        f927D = jVar;
        f928E = a(StringBuilder.class, jVar);
        l lVar = new l();
        f929F = lVar;
        f930G = a(StringBuffer.class, lVar);
        m mVar = new m();
        f931H = mVar;
        f932I = a(URL.class, mVar);
        n nVar = new n();
        f933J = nVar;
        f934K = a(URI.class, nVar);
        C0016o c0016o = new C0016o();
        f935L = c0016o;
        f936M = d(InetAddress.class, c0016o);
        p pVar = new p();
        f937N = pVar;
        f938O = a(UUID.class, pVar);
        com.google.gson.r<Currency> a15 = new q().a();
        f939P = a15;
        f940Q = a(Currency.class, a15);
        r rVar = new r();
        f941R = rVar;
        f942S = c(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        f943T = sVar;
        f944U = a(Locale.class, sVar);
        t tVar = new t();
        f945V = tVar;
        f946W = d(com.google.gson.j.class, tVar);
        f947X = new u();
    }

    public static <TT> com.google.gson.s a(Class<TT> cls, com.google.gson.r<TT> rVar) {
        return new w(cls, rVar);
    }

    public static <TT> com.google.gson.s b(Class<TT> cls, Class<TT> cls2, com.google.gson.r<? super TT> rVar) {
        return new x(cls, cls2, rVar);
    }

    public static <TT> com.google.gson.s c(Class<TT> cls, Class<? extends TT> cls2, com.google.gson.r<? super TT> rVar) {
        return new y(cls, cls2, rVar);
    }

    public static <T1> com.google.gson.s d(Class<T1> cls, com.google.gson.r<T1> rVar) {
        return new z(cls, rVar);
    }
}
