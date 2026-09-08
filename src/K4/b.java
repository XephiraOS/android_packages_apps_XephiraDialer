package K4;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* compiled from: JsonWriter.java */
/* loaded from: classes3.dex */
public class b implements Closeable, Flushable {

    /* renamed from: j, reason: collision with root package name */
    public static final Pattern f1644j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f1645k = new String[128];

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f1646l;

    /* renamed from: a, reason: collision with root package name */
    public final Writer f1647a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1648b = new int[32];

    /* renamed from: c, reason: collision with root package name */
    public int f1649c = 0;

    /* renamed from: d, reason: collision with root package name */
    public String f1650d;

    /* renamed from: e, reason: collision with root package name */
    public String f1651e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1652f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1653g;

    /* renamed from: h, reason: collision with root package name */
    public String f1654h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1655i;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f1645k[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f1645k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f1646l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        S(6);
        this.f1651e = ":";
        this.f1655i = true;
        Objects.requireNonNull(writer, "out == null");
        this.f1647a = writer;
    }

    public static boolean y(Class<? extends Number> cls) {
        if (cls != Integer.class && cls != Long.class && cls != Double.class && cls != Float.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            return false;
        }
        return true;
    }

    public b B(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f1654h == null) {
            if (this.f1649c != 0) {
                this.f1654h = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public final void G() {
        if (this.f1650d == null) {
            return;
        }
        this.f1647a.write(10);
        int i10 = this.f1649c;
        for (int i11 = 1; i11 < i10; i11++) {
            this.f1647a.write(this.f1650d);
        }
    }

    public b I() {
        if (this.f1654h != null) {
            if (this.f1655i) {
                l0();
            } else {
                this.f1654h = null;
                return this;
            }
        }
        c();
        this.f1647a.write("null");
        return this;
    }

    public final b L(int i10, char c10) {
        c();
        S(i10);
        this.f1647a.write(c10);
        return this;
    }

    public final int O() {
        int i10 = this.f1649c;
        if (i10 != 0) {
            return this.f1648b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void S(int i10) {
        int i11 = this.f1649c;
        int[] iArr = this.f1648b;
        if (i11 == iArr.length) {
            this.f1648b = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f1648b;
        int i12 = this.f1649c;
        this.f1649c = i12 + 1;
        iArr2[i12] = i10;
    }

    public final void T(int i10) {
        this.f1648b[this.f1649c - 1] = i10;
    }

    public final void U(boolean z10) {
        this.f1653g = z10;
    }

    public final void V(String str) {
        if (str.length() == 0) {
            this.f1650d = null;
            this.f1651e = ":";
        } else {
            this.f1650d = str;
            this.f1651e = ": ";
        }
    }

    public final void X(boolean z10) {
        this.f1652f = z10;
    }

    public final void Z(boolean z10) {
        this.f1655i = z10;
    }

    public final void a() {
        int O10 = O();
        if (O10 == 5) {
            this.f1647a.write(44);
        } else if (O10 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        G();
        T(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f1653g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = K4.b.f1646l
            goto L9
        L7:
            java.lang.String[] r0 = K4.b.f1645k
        L9:
            java.io.Writer r1 = r8.f1647a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f1647a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f1647a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f1647a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r8 = r8.f1647a
            r8.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.b.a0(java.lang.String):void");
    }

    public final void c() {
        int O10 = O();
        if (O10 != 1) {
            if (O10 != 2) {
                if (O10 != 4) {
                    if (O10 != 6) {
                        if (O10 == 7) {
                            if (!this.f1652f) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    T(7);
                    return;
                }
                this.f1647a.append((CharSequence) this.f1651e);
                T(5);
                return;
            }
            this.f1647a.append(',');
            G();
            return;
        }
        T(2);
        G();
    }

    public b c0(double d10) {
        l0();
        if (!this.f1652f && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
        }
        c();
        this.f1647a.append((CharSequence) Double.toString(d10));
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1647a.close();
        int i10 = this.f1649c;
        if (i10 <= 1 && (i10 != 1 || this.f1648b[i10 - 1] == 7)) {
            this.f1649c = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public b e() {
        l0();
        return L(1, '[');
    }

    public b f() {
        l0();
        return L(3, '{');
    }

    public b f0(long j10) {
        l0();
        c();
        this.f1647a.write(Long.toString(j10));
        return this;
    }

    public void flush() {
        if (this.f1649c != 0) {
            this.f1647a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final b g(int i10, int i11, char c10) {
        int O10 = O();
        if (O10 != i11 && O10 != i10) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f1654h == null) {
            this.f1649c--;
            if (O10 == i11) {
                G();
            }
            this.f1647a.write(c10);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f1654h);
    }

    public b g0(Boolean bool) {
        String str;
        if (bool == null) {
            return I();
        }
        l0();
        c();
        Writer writer = this.f1647a;
        if (bool.booleanValue()) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public b h0(Number number) {
        if (number == null) {
            return I();
        }
        l0();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!y(cls) && !f1644j.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.f1652f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
        }
        c();
        this.f1647a.append((CharSequence) obj);
        return this;
    }

    public b i0(String str) {
        if (str == null) {
            return I();
        }
        l0();
        c();
        a0(str);
        return this;
    }

    public b j0(boolean z10) {
        String str;
        l0();
        c();
        Writer writer = this.f1647a;
        if (z10) {
            str = "true";
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public b l() {
        return g(1, 2, ']');
    }

    public final void l0() {
        if (this.f1654h != null) {
            a();
            a0(this.f1654h);
            this.f1654h = null;
        }
    }

    public b o() {
        return g(3, 5, '}');
    }

    public final boolean r() {
        return this.f1655i;
    }

    public final boolean s() {
        return this.f1653g;
    }

    public boolean u() {
        return this.f1652f;
    }
}
