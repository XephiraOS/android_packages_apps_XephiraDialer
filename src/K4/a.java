package K4;

import F4.f;
import com.google.gson.internal.e;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: JsonReader.java */
/* loaded from: classes3.dex */
public class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final Reader f1629a;

    /* renamed from: i, reason: collision with root package name */
    public long f1637i;

    /* renamed from: j, reason: collision with root package name */
    public int f1638j;

    /* renamed from: k, reason: collision with root package name */
    public String f1639k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f1640l;

    /* renamed from: n, reason: collision with root package name */
    public String[] f1642n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f1643o;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1630b = false;

    /* renamed from: c, reason: collision with root package name */
    public final char[] f1631c = new char[1024];

    /* renamed from: d, reason: collision with root package name */
    public int f1632d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f1633e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1634f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f1635g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f1636h = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f1641m = 1;

    /* compiled from: JsonReader.java */
    /* renamed from: K4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0036a extends e {
        @Override // com.google.gson.internal.e
        public void a(a aVar) {
            if (aVar instanceof f) {
                ((f) aVar).z0();
                return;
            }
            int i10 = aVar.f1636h;
            if (i10 == 0) {
                i10 = aVar.g();
            }
            if (i10 == 13) {
                aVar.f1636h = 9;
                return;
            }
            if (i10 == 12) {
                aVar.f1636h = 8;
                return;
            }
            if (i10 == 14) {
                aVar.f1636h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.f0() + aVar.I());
        }
    }

    static {
        e.f24802a = new C0036a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f1640l = iArr;
        iArr[0] = 6;
        this.f1642n = new String[32];
        this.f1643o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f1629a = reader;
    }

    private String s(boolean z10) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f1641m;
            if (i10 < i11) {
                int i12 = this.f1640l[i10];
                if (i12 != 1 && i12 != 2) {
                    if (i12 == 3 || i12 == 4 || i12 == 5) {
                        sb.append('.');
                        String str = this.f1642n[i10];
                        if (str != null) {
                            sb.append(str);
                        }
                    }
                } else {
                    int i13 = this.f1643o[i10];
                    if (z10 && i13 > 0 && i10 == i11 - 1) {
                        i13--;
                    }
                    sb.append('[');
                    sb.append(i13);
                    sb.append(']');
                }
                i10++;
            } else {
                return sb.toString();
            }
        }
    }

    public final boolean B() {
        return this.f1630b;
    }

    public final boolean G(char c10) {
        if (c10 != '\t' && c10 != '\n' && c10 != '\f' && c10 != '\r' && c10 != ' ') {
            if (c10 != '#') {
                if (c10 != ',') {
                    if (c10 != '/' && c10 != '=') {
                        if (c10 != '{' && c10 != '}' && c10 != ':') {
                            if (c10 != ';') {
                                switch (c10) {
                                    case '[':
                                    case ']':
                                        return false;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            e();
            return false;
        }
        return false;
    }

    public String I() {
        return " at line " + (this.f1634f + 1) + " column " + ((this.f1632d - this.f1635g) + 1) + " path " + d();
    }

    public boolean L() {
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 5) {
            this.f1636h = 0;
            int[] iArr = this.f1643o;
            int i11 = this.f1641m - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        }
        if (i10 == 6) {
            this.f1636h = 0;
            int[] iArr2 = this.f1643o;
            int i12 = this.f1641m - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + f0() + I());
    }

    public double O() {
        char c10;
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 15) {
            this.f1636h = 0;
            int[] iArr = this.f1643o;
            int i11 = this.f1641m - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f1637i;
        }
        if (i10 == 16) {
            this.f1639k = new String(this.f1631c, this.f1632d, this.f1638j);
            this.f1632d += this.f1638j;
        } else if (i10 != 8 && i10 != 9) {
            if (i10 == 10) {
                this.f1639k = c0();
            } else if (i10 != 11) {
                throw new IllegalStateException("Expected a double but was " + f0() + I());
            }
        } else {
            if (i10 == 8) {
                c10 = '\'';
            } else {
                c10 = '\"';
            }
            this.f1639k = Z(c10);
        }
        this.f1636h = 11;
        double parseDouble = Double.parseDouble(this.f1639k);
        if (!this.f1630b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + I());
        }
        this.f1639k = null;
        this.f1636h = 0;
        int[] iArr2 = this.f1643o;
        int i12 = this.f1641m - 1;
        iArr2[i12] = iArr2[i12] + 1;
        return parseDouble;
    }

    public int S() {
        char c10;
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 15) {
            long j10 = this.f1637i;
            int i11 = (int) j10;
            if (j10 == i11) {
                this.f1636h = 0;
                int[] iArr = this.f1643o;
                int i12 = this.f1641m - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new NumberFormatException("Expected an int but was " + this.f1637i + I());
        }
        if (i10 == 16) {
            this.f1639k = new String(this.f1631c, this.f1632d, this.f1638j);
            this.f1632d += this.f1638j;
        } else {
            if (i10 != 8 && i10 != 9 && i10 != 10) {
                throw new IllegalStateException("Expected an int but was " + f0() + I());
            }
            if (i10 == 10) {
                this.f1639k = c0();
            } else {
                if (i10 == 8) {
                    c10 = '\'';
                } else {
                    c10 = '\"';
                }
                this.f1639k = Z(c10);
            }
            try {
                int parseInt = Integer.parseInt(this.f1639k);
                this.f1636h = 0;
                int[] iArr2 = this.f1643o;
                int i13 = this.f1641m - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f1636h = 11;
        double parseDouble = Double.parseDouble(this.f1639k);
        int i14 = (int) parseDouble;
        if (i14 == parseDouble) {
            this.f1639k = null;
            this.f1636h = 0;
            int[] iArr3 = this.f1643o;
            int i15 = this.f1641m - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        }
        throw new NumberFormatException("Expected an int but was " + this.f1639k + I());
    }

    public long T() {
        char c10;
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 15) {
            this.f1636h = 0;
            int[] iArr = this.f1643o;
            int i11 = this.f1641m - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f1637i;
        }
        if (i10 == 16) {
            this.f1639k = new String(this.f1631c, this.f1632d, this.f1638j);
            this.f1632d += this.f1638j;
        } else {
            if (i10 != 8 && i10 != 9 && i10 != 10) {
                throw new IllegalStateException("Expected a long but was " + f0() + I());
            }
            if (i10 == 10) {
                this.f1639k = c0();
            } else {
                if (i10 == 8) {
                    c10 = '\'';
                } else {
                    c10 = '\"';
                }
                this.f1639k = Z(c10);
            }
            try {
                long parseLong = Long.parseLong(this.f1639k);
                this.f1636h = 0;
                int[] iArr2 = this.f1643o;
                int i12 = this.f1641m - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f1636h = 11;
        double parseDouble = Double.parseDouble(this.f1639k);
        long j10 = (long) parseDouble;
        if (j10 == parseDouble) {
            this.f1639k = null;
            this.f1636h = 0;
            int[] iArr3 = this.f1643o;
            int i13 = this.f1641m - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return j10;
        }
        throw new NumberFormatException("Expected a long but was " + this.f1639k + I());
    }

    public String U() {
        String Z9;
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 14) {
            Z9 = c0();
        } else if (i10 == 12) {
            Z9 = Z('\'');
        } else if (i10 == 13) {
            Z9 = Z('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + f0() + I());
        }
        this.f1636h = 0;
        this.f1642n[this.f1641m - 1] = Z9;
        return Z9;
    }

    public final int V(boolean z10) {
        char[] cArr = this.f1631c;
        int i10 = this.f1632d;
        int i11 = this.f1633e;
        while (true) {
            if (i10 == i11) {
                this.f1632d = i10;
                if (!r(1)) {
                    if (!z10) {
                        return -1;
                    }
                    throw new EOFException("End of input" + I());
                }
                i10 = this.f1632d;
                i11 = this.f1633e;
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == '\n') {
                this.f1634f++;
                this.f1635g = i12;
            } else if (c10 != ' ' && c10 != '\r' && c10 != '\t') {
                if (c10 == '/') {
                    this.f1632d = i12;
                    if (i12 == i11) {
                        this.f1632d = i10;
                        boolean r10 = r(2);
                        this.f1632d++;
                        if (!r10) {
                            return c10;
                        }
                    }
                    e();
                    int i13 = this.f1632d;
                    char c11 = cArr[i13];
                    if (c11 != '*') {
                        if (c11 != '/') {
                            return c10;
                        }
                        this.f1632d = i13 + 1;
                        q0();
                        i10 = this.f1632d;
                        i11 = this.f1633e;
                    } else {
                        this.f1632d = i13 + 1;
                        if (o0("*/")) {
                            i10 = this.f1632d + 2;
                            i11 = this.f1633e;
                        } else {
                            throw t0("Unterminated comment");
                        }
                    }
                } else if (c10 == '#') {
                    this.f1632d = i12;
                    e();
                    q0();
                    i10 = this.f1632d;
                    i11 = this.f1633e;
                } else {
                    this.f1632d = i12;
                    return c10;
                }
            }
            i10 = i12;
        }
    }

    public void X() {
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 7) {
            this.f1636h = 0;
            int[] iArr = this.f1643o;
            int i11 = this.f1641m - 1;
            iArr[i11] = iArr[i11] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + f0() + I());
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f1632d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Z(char r10) {
        /*
            r9 = this;
            char[] r0 = r9.f1631c
            r1 = 0
        L3:
            int r2 = r9.f1632d
            int r3 = r9.f1633e
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f1632d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r9 = new java.lang.String
            r9.<init>(r0, r3, r7)
            return r9
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r9 = r1.toString()
            return r9
        L28:
            r8 = 92
            if (r2 != r8) goto L4d
            r9.f1632d = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L3e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L3e:
            r1.append(r0, r3, r2)
            char r2 = r9.j0()
            r1.append(r2)
            int r2 = r9.f1632d
            int r3 = r9.f1633e
            goto L7
        L4d:
            r5 = 10
            if (r2 != r5) goto L58
            int r2 = r9.f1634f
            int r2 = r2 + r6
            r9.f1634f = r2
            r9.f1635g = r7
        L58:
            r2 = r7
            goto L9
        L5a:
            if (r1 != 0) goto L6a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f1632d = r2
            boolean r2 = r9.r(r6)
            if (r2 == 0) goto L78
            goto L3
        L78:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r9 = r9.t0(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.a.Z(char):java.lang.String");
    }

    public void a() {
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 3) {
            i0(1);
            this.f1643o[this.f1641m - 1] = 0;
            this.f1636h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f0() + I());
        }
    }

    public String a0() {
        String str;
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 10) {
            str = c0();
        } else if (i10 == 8) {
            str = Z('\'');
        } else if (i10 == 9) {
            str = Z('\"');
        } else if (i10 == 11) {
            str = this.f1639k;
            this.f1639k = null;
        } else if (i10 == 15) {
            str = Long.toString(this.f1637i);
        } else if (i10 == 16) {
            str = new String(this.f1631c, this.f1632d, this.f1638j);
            this.f1632d += this.f1638j;
        } else {
            throw new IllegalStateException("Expected a string but was " + f0() + I());
        }
        this.f1636h = 0;
        int[] iArr = this.f1643o;
        int i11 = this.f1641m - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public void c() {
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 1) {
            i0(3);
            this.f1636h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f0() + I());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        e();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c0() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f1632d
            int r4 = r3 + r2
            int r5 = r6.f1633e
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f1631c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.e()
            goto L5c
        L4e:
            char[] r3 = r6.f1631c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.r(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f1631c
            int r4 = r6.f1632d
            r0.append(r3, r4, r2)
            int r3 = r6.f1632d
            int r3 = r3 + r2
            r6.f1632d = r3
            r2 = 1
            boolean r2 = r6.r(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f1631c
            int r3 = r6.f1632d
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f1631c
            int r3 = r6.f1632d
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f1632d
            int r2 = r2 + r1
            r6.f1632d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.a.c0():java.lang.String");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1636h = 0;
        this.f1640l[0] = 8;
        this.f1641m = 1;
        this.f1629a.close();
    }

    public String d() {
        return s(false);
    }

    public final void e() {
        if (this.f1630b) {
        } else {
            throw t0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    public final void f() {
        V(true);
        int i10 = this.f1632d;
        this.f1632d = i10 - 1;
        if (i10 + 4 > this.f1633e && !r(5)) {
            return;
        }
        int i11 = this.f1632d;
        char[] cArr = this.f1631c;
        if (cArr[i11] == ')' && cArr[i11 + 1] == ']' && cArr[i11 + 2] == '}' && cArr[i11 + 3] == '\'' && cArr[i11 + 4] == '\n') {
            this.f1632d = i11 + 5;
        }
    }

    public JsonToken f0() {
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        switch (i10) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public int g() {
        int V10;
        int[] iArr = this.f1640l;
        int i10 = this.f1641m;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int V11 = V(true);
            if (V11 != 44) {
                if (V11 != 59) {
                    if (V11 == 93) {
                        this.f1636h = 4;
                        return 4;
                    }
                    throw t0("Unterminated array");
                }
                e();
            }
        } else if (i11 != 3 && i11 != 5) {
            if (i11 == 4) {
                iArr[i10 - 1] = 5;
                int V12 = V(true);
                if (V12 != 58) {
                    if (V12 == 61) {
                        e();
                        if (this.f1632d < this.f1633e || r(1)) {
                            char[] cArr = this.f1631c;
                            int i12 = this.f1632d;
                            if (cArr[i12] == '>') {
                                this.f1632d = i12 + 1;
                            }
                        }
                    } else {
                        throw t0("Expected ':'");
                    }
                }
            } else if (i11 == 6) {
                if (this.f1630b) {
                    f();
                }
                this.f1640l[this.f1641m - 1] = 7;
            } else if (i11 == 7) {
                if (V(false) == -1) {
                    this.f1636h = 17;
                    return 17;
                }
                e();
                this.f1632d--;
            } else if (i11 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        } else {
            iArr[i10 - 1] = 4;
            if (i11 == 5 && (V10 = V(true)) != 44) {
                if (V10 != 59) {
                    if (V10 == 125) {
                        this.f1636h = 2;
                        return 2;
                    }
                    throw t0("Unterminated object");
                }
                e();
            }
            int V13 = V(true);
            if (V13 != 34) {
                if (V13 != 39) {
                    if (V13 != 125) {
                        e();
                        this.f1632d--;
                        if (G((char) V13)) {
                            this.f1636h = 14;
                            return 14;
                        }
                        throw t0("Expected name");
                    }
                    if (i11 != 5) {
                        this.f1636h = 2;
                        return 2;
                    }
                    throw t0("Expected name");
                }
                e();
                this.f1636h = 12;
                return 12;
            }
            this.f1636h = 13;
            return 13;
        }
        int V14 = V(true);
        if (V14 != 34) {
            if (V14 != 39) {
                if (V14 != 44 && V14 != 59) {
                    if (V14 != 91) {
                        if (V14 != 93) {
                            if (V14 != 123) {
                                this.f1632d--;
                                int g02 = g0();
                                if (g02 != 0) {
                                    return g02;
                                }
                                int h02 = h0();
                                if (h02 != 0) {
                                    return h02;
                                }
                                if (G(this.f1631c[this.f1632d])) {
                                    e();
                                    this.f1636h = 10;
                                    return 10;
                                }
                                throw t0("Expected value");
                            }
                            this.f1636h = 1;
                            return 1;
                        }
                        if (i11 == 1) {
                            this.f1636h = 4;
                            return 4;
                        }
                    } else {
                        this.f1636h = 3;
                        return 3;
                    }
                }
                if (i11 != 1 && i11 != 2) {
                    throw t0("Unexpected value");
                }
                e();
                this.f1632d--;
                this.f1636h = 7;
                return 7;
            }
            e();
            this.f1636h = 8;
            return 8;
        }
        this.f1636h = 9;
        return 9;
    }

    public final int g0() {
        String str;
        String str2;
        int i10;
        char c10 = this.f1631c[this.f1632d];
        if (c10 != 't' && c10 != 'T') {
            if (c10 != 'f' && c10 != 'F') {
                if (c10 != 'n' && c10 != 'N') {
                    return 0;
                }
                str = "null";
                str2 = "NULL";
                i10 = 7;
            } else {
                str = "false";
                str2 = "FALSE";
                i10 = 6;
            }
        } else {
            str = "true";
            str2 = "TRUE";
            i10 = 5;
        }
        int length = str.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f1632d + i11 >= this.f1633e && !r(i11 + 1)) {
                return 0;
            }
            char c11 = this.f1631c[this.f1632d + i11];
            if (c11 != str.charAt(i11) && c11 != str2.charAt(i11)) {
                return 0;
            }
        }
        if ((this.f1632d + length < this.f1633e || r(length + 1)) && G(this.f1631c[this.f1632d + length])) {
            return 0;
        }
        this.f1632d += length;
        this.f1636h = i10;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ab, code lost:
    
        r18.f1637i = r11;
        r18.f1632d += r8;
        r18.f1636h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
    
        r18.f1638j = r8;
        r18.f1636h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0091, code lost:
    
        if (G(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c9, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h0() {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.a.h0():int");
    }

    public final void i0(int i10) {
        int i11 = this.f1641m;
        int[] iArr = this.f1640l;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f1640l = Arrays.copyOf(iArr, i12);
            this.f1643o = Arrays.copyOf(this.f1643o, i12);
            this.f1642n = (String[]) Arrays.copyOf(this.f1642n, i12);
        }
        int[] iArr2 = this.f1640l;
        int i13 = this.f1641m;
        this.f1641m = i13 + 1;
        iArr2[i13] = i10;
    }

    public final char j0() {
        int i10;
        if (this.f1632d == this.f1633e && !r(1)) {
            throw t0("Unterminated escape sequence");
        }
        char[] cArr = this.f1631c;
        int i11 = this.f1632d;
        int i12 = i11 + 1;
        this.f1632d = i12;
        char c10 = cArr[i11];
        if (c10 != '\n') {
            if (c10 != '\"' && c10 != '\'' && c10 != '/' && c10 != '\\') {
                if (c10 != 'b') {
                    if (c10 != 'f') {
                        if (c10 == 'n') {
                            return '\n';
                        }
                        if (c10 != 'r') {
                            if (c10 != 't') {
                                if (c10 == 'u') {
                                    if (i11 + 5 > this.f1633e && !r(4)) {
                                        throw t0("Unterminated escape sequence");
                                    }
                                    int i13 = this.f1632d;
                                    int i14 = i13 + 4;
                                    char c11 = 0;
                                    while (i13 < i14) {
                                        char c12 = this.f1631c[i13];
                                        char c13 = (char) (c11 << 4);
                                        if (c12 >= '0' && c12 <= '9') {
                                            i10 = c12 - '0';
                                        } else if (c12 >= 'a' && c12 <= 'f') {
                                            i10 = c12 - 'W';
                                        } else if (c12 >= 'A' && c12 <= 'F') {
                                            i10 = c12 - '7';
                                        } else {
                                            throw new NumberFormatException("\\u" + new String(this.f1631c, this.f1632d, 4));
                                        }
                                        c11 = (char) (c13 + i10);
                                        i13++;
                                    }
                                    this.f1632d += 4;
                                    return c11;
                                }
                                throw t0("Invalid escape sequence");
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
        } else {
            this.f1634f++;
            this.f1635g = i12;
        }
        return c10;
    }

    public void l() {
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 4) {
            int i11 = this.f1641m;
            this.f1641m = i11 - 1;
            int[] iArr = this.f1643o;
            int i12 = i11 - 2;
            iArr[i12] = iArr[i12] + 1;
            this.f1636h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + f0() + I());
    }

    public final void l0(boolean z10) {
        this.f1630b = z10;
    }

    public final void m0(char c10) {
        char[] cArr = this.f1631c;
        do {
            int i10 = this.f1632d;
            int i11 = this.f1633e;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f1632d = i12;
                    return;
                }
                if (c11 == '\\') {
                    this.f1632d = i12;
                    j0();
                    i10 = this.f1632d;
                    i11 = this.f1633e;
                } else {
                    if (c11 == '\n') {
                        this.f1634f++;
                        this.f1635g = i12;
                    }
                    i10 = i12;
                }
            }
            this.f1632d = i10;
        } while (r(1));
        throw t0("Unterminated string");
    }

    public void o() {
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 == 2) {
            int i11 = this.f1641m;
            int i12 = i11 - 1;
            this.f1641m = i12;
            this.f1642n[i12] = null;
            int[] iArr = this.f1643o;
            int i13 = i11 - 2;
            iArr[i13] = iArr[i13] + 1;
            this.f1636h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + f0() + I());
    }

    public final boolean o0(String str) {
        int length = str.length();
        while (true) {
            if (this.f1632d + length > this.f1633e && !r(length)) {
                return false;
            }
            char[] cArr = this.f1631c;
            int i10 = this.f1632d;
            if (cArr[i10] == '\n') {
                this.f1634f++;
                this.f1635g = i10 + 1;
            } else {
                for (int i11 = 0; i11 < length; i11++) {
                    if (this.f1631c[this.f1632d + i11] != str.charAt(i11)) {
                        break;
                    }
                }
                return true;
            }
            this.f1632d++;
        }
    }

    public final void q0() {
        char c10;
        do {
            if (this.f1632d < this.f1633e || r(1)) {
                char[] cArr = this.f1631c;
                int i10 = this.f1632d;
                int i11 = i10 + 1;
                this.f1632d = i11;
                c10 = cArr[i10];
                if (c10 == '\n') {
                    this.f1634f++;
                    this.f1635g = i11;
                    return;
                }
            } else {
                return;
            }
        } while (c10 != '\r');
    }

    public final boolean r(int i10) {
        int i11;
        int i12;
        char[] cArr = this.f1631c;
        int i13 = this.f1635g;
        int i14 = this.f1632d;
        this.f1635g = i13 - i14;
        int i15 = this.f1633e;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f1633e = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f1633e = 0;
        }
        this.f1632d = 0;
        do {
            Reader reader = this.f1629a;
            int i17 = this.f1633e;
            int read = reader.read(cArr, i17, cArr.length - i17);
            if (read == -1) {
                return false;
            }
            i11 = this.f1633e + read;
            this.f1633e = i11;
            if (this.f1634f == 0 && (i12 = this.f1635g) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f1632d++;
                this.f1635g = i12 + 1;
                i10++;
            }
        } while (i11 < i10);
        return true;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:411)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:201)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:242)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:135)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final void r0() {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f1632d
            int r2 = r1 + r0
            int r3 = r4.f1633e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f1631c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.e()
        L4b:
            int r1 = r4.f1632d
            int r1 = r1 + r0
            r4.f1632d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f1632d = r1
            r0 = 1
            boolean r0 = r4.r(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: K4.a.r0():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0011. Please report as an issue. */
    public void s0() {
        int i10 = 0;
        do {
            int i11 = this.f1636h;
            if (i11 == 0) {
                i11 = g();
            }
            switch (i11) {
                case 1:
                    i0(3);
                    i10++;
                    this.f1636h = 0;
                    break;
                case 2:
                    if (i10 == 0) {
                        this.f1642n[this.f1641m - 1] = null;
                    }
                    this.f1641m--;
                    i10--;
                    this.f1636h = 0;
                    break;
                case 3:
                    i0(1);
                    i10++;
                    this.f1636h = 0;
                    break;
                case 4:
                    this.f1641m--;
                    i10--;
                    this.f1636h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f1636h = 0;
                    break;
                case 8:
                    m0('\'');
                    this.f1636h = 0;
                    break;
                case 9:
                    m0('\"');
                    this.f1636h = 0;
                    break;
                case 10:
                    r0();
                    this.f1636h = 0;
                    break;
                case 12:
                    m0('\'');
                    if (i10 == 0) {
                        this.f1642n[this.f1641m - 1] = "<skipped>";
                    }
                    this.f1636h = 0;
                    break;
                case 13:
                    m0('\"');
                    if (i10 == 0) {
                        this.f1642n[this.f1641m - 1] = "<skipped>";
                    }
                    this.f1636h = 0;
                    break;
                case 14:
                    r0();
                    if (i10 == 0) {
                        this.f1642n[this.f1641m - 1] = "<skipped>";
                    }
                    this.f1636h = 0;
                    break;
                case 16:
                    this.f1632d += this.f1638j;
                    this.f1636h = 0;
                    break;
                case 17:
                    return;
            }
        } while (i10 > 0);
        int[] iArr = this.f1643o;
        int i12 = this.f1641m - 1;
        iArr[i12] = iArr[i12] + 1;
    }

    public final IOException t0(String str) {
        throw new MalformedJsonException(str + I());
    }

    public String toString() {
        return getClass().getSimpleName() + I();
    }

    public String u() {
        return s(true);
    }

    public boolean y() {
        int i10 = this.f1636h;
        if (i10 == 0) {
            i10 = g();
        }
        if (i10 != 2 && i10 != 4 && i10 != 17) {
            return true;
        }
        return false;
    }
}
