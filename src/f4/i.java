package F4;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;

/* compiled from: NumberTypeAdapter.java */
/* loaded from: classes3.dex */
public final class i extends r<Number> {

    /* renamed from: b, reason: collision with root package name */
    public static final s f878b = f(ToNumberPolicy.LAZILY_PARSED_NUMBER);

    /* renamed from: a, reason: collision with root package name */
    public final q f879a;

    /* compiled from: NumberTypeAdapter.java */
    /* loaded from: classes3.dex */
    public class a implements s {
        public a() {
        }

        @Override // com.google.gson.s
        public <T> r<T> a(com.google.gson.d dVar, J4.a<T> aVar) {
            if (aVar.getRawType() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    /* compiled from: NumberTypeAdapter.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f881a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f881a = iArr;
            try {
                iArr[JsonToken.NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f881a[JsonToken.NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f881a[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public i(q qVar) {
        this.f879a = qVar;
    }

    public static s e(q qVar) {
        if (qVar == ToNumberPolicy.LAZILY_PARSED_NUMBER) {
            return f878b;
        }
        return f(qVar);
    }

    public static s f(q qVar) {
        return new a();
    }

    @Override // com.google.gson.r
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Number b(K4.a aVar) {
        JsonToken f02 = aVar.f0();
        int i10 = b.f881a[f02.ordinal()];
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                throw new JsonSyntaxException("Expecting number, got: " + f02 + "; at path " + aVar.d());
            }
            return this.f879a.a(aVar);
        }
        aVar.X();
        return null;
    }

    @Override // com.google.gson.r
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(K4.b bVar, Number number) {
        bVar.h0(number);
    }
}
