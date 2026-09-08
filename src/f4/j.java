package F4;

import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ObjectTypeAdapter.java */
/* loaded from: classes3.dex */
public final class j extends r<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final s f882c = f(ToNumberPolicy.DOUBLE);

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.d f883a;

    /* renamed from: b, reason: collision with root package name */
    public final q f884b;

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f885a;

        public a(q qVar) {
            this.f885a = qVar;
        }

        @Override // com.google.gson.s
        public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            a aVar2 = null;
            if (aVar.getRawType() != Object.class) {
                return null;
            }
            return new j(dVar, this.f885a, aVar2);
        }
    }

    /* compiled from: ObjectTypeAdapter.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f886a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f886a = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f886a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f886a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f886a[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f886a[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f886a[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public /* synthetic */ j(com.google.gson.d dVar, q qVar, a aVar) {
        this(dVar, qVar);
    }

    public static s e(q qVar) {
        if (qVar == ToNumberPolicy.DOUBLE) {
            return f882c;
        }
        return f(qVar);
    }

    private static s f(q qVar) {
        return new a(qVar);
    }

    @Override // com.google.gson.r
    public Object b(K4.a aVar) {
        String str;
        boolean z10;
        JsonToken f02 = aVar.f0();
        Object h10 = h(aVar, f02);
        if (h10 == null) {
            return g(aVar, f02);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.y()) {
                if (h10 instanceof Map) {
                    str = aVar.U();
                } else {
                    str = null;
                }
                JsonToken f03 = aVar.f0();
                Object h11 = h(aVar, f03);
                if (h11 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (h11 == null) {
                    h11 = g(aVar, f03);
                }
                if (h10 instanceof List) {
                    ((List) h10).add(h11);
                } else {
                    ((Map) h10).put(str, h11);
                }
                if (z10) {
                    arrayDeque.addLast(h10);
                    h10 = h11;
                }
            } else {
                if (h10 instanceof List) {
                    aVar.l();
                } else {
                    aVar.o();
                }
                if (arrayDeque.isEmpty()) {
                    return h10;
                }
                h10 = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.r
    public void d(K4.b bVar, Object obj) {
        if (obj == null) {
            bVar.I();
            return;
        }
        r m10 = this.f883a.m(obj.getClass());
        if (m10 instanceof j) {
            bVar.f();
            bVar.o();
        } else {
            m10.d(bVar, obj);
        }
    }

    public final Object g(K4.a aVar, JsonToken jsonToken) {
        int i10 = b.f886a[jsonToken.ordinal()];
        if (i10 != 3) {
            if (i10 != 4) {
                if (i10 != 5) {
                    if (i10 == 6) {
                        aVar.X();
                        return null;
                    }
                    throw new IllegalStateException("Unexpected token: " + jsonToken);
                }
                return Boolean.valueOf(aVar.L());
            }
            return this.f884b.a(aVar);
        }
        return aVar.a0();
    }

    public final Object h(K4.a aVar, JsonToken jsonToken) {
        int i10 = b.f886a[jsonToken.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            aVar.c();
            return new LinkedTreeMap();
        }
        aVar.a();
        return new ArrayList();
    }

    public j(com.google.gson.d dVar, q qVar) {
        this.f883a = dVar;
        this.f884b = qVar;
    }
}
