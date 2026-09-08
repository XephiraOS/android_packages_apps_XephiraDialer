package F4;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JsonTreeReader.java */
/* loaded from: classes3.dex */
public final class f extends K4.a {

    /* renamed from: y, reason: collision with root package name */
    public static final Reader f860y = new a();

    /* renamed from: z, reason: collision with root package name */
    public static final Object f861z = new Object();

    /* renamed from: p, reason: collision with root package name */
    public Object[] f862p;

    /* renamed from: q, reason: collision with root package name */
    public int f863q;

    /* renamed from: r, reason: collision with root package name */
    public String[] f864r;

    /* renamed from: x, reason: collision with root package name */
    public int[] f865x;

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes3.dex */
    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    /* compiled from: JsonTreeReader.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f866a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f866a = iArr;
            try {
                iArr[JsonToken.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f866a[JsonToken.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f866a[JsonToken.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f866a[JsonToken.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private String I() {
        return " at path " + d();
    }

    public final void A0(Object obj) {
        int i10 = this.f863q;
        Object[] objArr = this.f862p;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f862p = Arrays.copyOf(objArr, i11);
            this.f865x = Arrays.copyOf(this.f865x, i11);
            this.f864r = (String[]) Arrays.copyOf(this.f864r, i11);
        }
        Object[] objArr2 = this.f862p;
        int i12 = this.f863q;
        this.f863q = i12 + 1;
        objArr2[i12] = obj;
    }

    @Override // K4.a
    public boolean L() {
        u0(JsonToken.BOOLEAN);
        boolean k10 = ((com.google.gson.n) y0()).k();
        int i10 = this.f863q;
        if (i10 > 0) {
            int[] iArr = this.f865x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return k10;
    }

    @Override // K4.a
    public double O() {
        JsonToken f02 = f0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (f02 != jsonToken && f02 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + f02 + I());
        }
        double l10 = ((com.google.gson.n) x0()).l();
        if (!B() && (Double.isNaN(l10) || Double.isInfinite(l10))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + l10);
        }
        y0();
        int i10 = this.f863q;
        if (i10 > 0) {
            int[] iArr = this.f865x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return l10;
    }

    @Override // K4.a
    public int S() {
        JsonToken f02 = f0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (f02 != jsonToken && f02 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + f02 + I());
        }
        int m10 = ((com.google.gson.n) x0()).m();
        y0();
        int i10 = this.f863q;
        if (i10 > 0) {
            int[] iArr = this.f865x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return m10;
    }

    @Override // K4.a
    public long T() {
        JsonToken f02 = f0();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (f02 != jsonToken && f02 != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + f02 + I());
        }
        long n10 = ((com.google.gson.n) x0()).n();
        y0();
        int i10 = this.f863q;
        if (i10 > 0) {
            int[] iArr = this.f865x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return n10;
    }

    @Override // K4.a
    public String U() {
        return w0(false);
    }

    @Override // K4.a
    public void X() {
        u0(JsonToken.NULL);
        y0();
        int i10 = this.f863q;
        if (i10 > 0) {
            int[] iArr = this.f865x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // K4.a
    public void a() {
        u0(JsonToken.BEGIN_ARRAY);
        A0(((com.google.gson.g) x0()).iterator());
        this.f865x[this.f863q - 1] = 0;
    }

    @Override // K4.a
    public String a0() {
        JsonToken f02 = f0();
        JsonToken jsonToken = JsonToken.STRING;
        if (f02 != jsonToken && f02 != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + f02 + I());
        }
        String p10 = ((com.google.gson.n) y0()).p();
        int i10 = this.f863q;
        if (i10 > 0) {
            int[] iArr = this.f865x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return p10;
    }

    @Override // K4.a
    public void c() {
        u0(JsonToken.BEGIN_OBJECT);
        A0(((com.google.gson.l) x0()).l().iterator());
    }

    @Override // K4.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f862p = new Object[]{f861z};
        this.f863q = 1;
    }

    @Override // K4.a
    public String d() {
        return s(false);
    }

    @Override // K4.a
    public JsonToken f0() {
        if (this.f863q == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object x02 = x0();
        if (x02 instanceof Iterator) {
            boolean z10 = this.f862p[this.f863q - 2] instanceof com.google.gson.l;
            Iterator it = (Iterator) x02;
            if (it.hasNext()) {
                if (z10) {
                    return JsonToken.NAME;
                }
                A0(it.next());
                return f0();
            }
            if (z10) {
                return JsonToken.END_OBJECT;
            }
            return JsonToken.END_ARRAY;
        }
        if (x02 instanceof com.google.gson.l) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (x02 instanceof com.google.gson.g) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (x02 instanceof com.google.gson.n) {
            com.google.gson.n nVar = (com.google.gson.n) x02;
            if (nVar.t()) {
                return JsonToken.STRING;
            }
            if (nVar.q()) {
                return JsonToken.BOOLEAN;
            }
            if (nVar.s()) {
                return JsonToken.NUMBER;
            }
            throw new AssertionError();
        }
        if (x02 instanceof com.google.gson.k) {
            return JsonToken.NULL;
        }
        if (x02 == f861z) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new MalformedJsonException("Custom JsonElement subclass " + x02.getClass().getName() + " is not supported");
    }

    @Override // K4.a
    public void l() {
        u0(JsonToken.END_ARRAY);
        y0();
        y0();
        int i10 = this.f863q;
        if (i10 > 0) {
            int[] iArr = this.f865x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // K4.a
    public void o() {
        u0(JsonToken.END_OBJECT);
        this.f864r[this.f863q - 1] = null;
        y0();
        y0();
        int i10 = this.f863q;
        if (i10 > 0) {
            int[] iArr = this.f865x;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public final String s(boolean z10) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f863q;
            if (i10 < i11) {
                Object[] objArr = this.f862p;
                Object obj = objArr[i10];
                if (obj instanceof com.google.gson.g) {
                    i10++;
                    if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                        int i12 = this.f865x[i10];
                        if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                            i12--;
                        }
                        sb.append('[');
                        sb.append(i12);
                        sb.append(']');
                    }
                } else if ((obj instanceof com.google.gson.l) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                    sb.append('.');
                    String str = this.f864r[i10];
                    if (str != null) {
                        sb.append(str);
                    }
                }
                i10++;
            } else {
                return sb.toString();
            }
        }
    }

    @Override // K4.a
    public void s0() {
        int i10 = b.f866a[f0().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        y0();
                        int i11 = this.f863q;
                        if (i11 > 0) {
                            int[] iArr = this.f865x;
                            int i12 = i11 - 1;
                            iArr[i12] = iArr[i12] + 1;
                            return;
                        }
                        return;
                    }
                    return;
                }
                o();
                return;
            }
            l();
            return;
        }
        w0(true);
    }

    @Override // K4.a
    public String toString() {
        return f.class.getSimpleName() + I();
    }

    @Override // K4.a
    public String u() {
        return s(true);
    }

    public final void u0(JsonToken jsonToken) {
        if (f0() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + f0() + I());
    }

    public com.google.gson.j v0() {
        JsonToken f02 = f0();
        if (f02 != JsonToken.NAME && f02 != JsonToken.END_ARRAY && f02 != JsonToken.END_OBJECT && f02 != JsonToken.END_DOCUMENT) {
            com.google.gson.j jVar = (com.google.gson.j) x0();
            s0();
            return jVar;
        }
        throw new IllegalStateException("Unexpected " + f02 + " when reading a JsonElement.");
    }

    public final String w0(boolean z10) {
        String str;
        u0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) x0()).next();
        String str2 = (String) entry.getKey();
        String[] strArr = this.f864r;
        int i10 = this.f863q - 1;
        if (z10) {
            str = "<skipped>";
        } else {
            str = str2;
        }
        strArr[i10] = str;
        A0(entry.getValue());
        return str2;
    }

    public final Object x0() {
        return this.f862p[this.f863q - 1];
    }

    @Override // K4.a
    public boolean y() {
        JsonToken f02 = f0();
        if (f02 != JsonToken.END_OBJECT && f02 != JsonToken.END_ARRAY && f02 != JsonToken.END_DOCUMENT) {
            return true;
        }
        return false;
    }

    public final Object y0() {
        Object[] objArr = this.f862p;
        int i10 = this.f863q - 1;
        this.f863q = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    public void z0() {
        u0(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) x0()).next();
        A0(entry.getValue());
        A0(new com.google.gson.n((String) entry.getKey()));
    }
}
