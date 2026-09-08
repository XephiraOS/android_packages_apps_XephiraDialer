package org.apache.james.mime4j.field.datetime.parser;

import java.io.IOException;
import java.io.PrintStream;

/* compiled from: DateTimeParserTokenManager.java */
/* loaded from: classes4.dex */
public class c implements b {

    /* renamed from: q, reason: collision with root package name */
    public static int f35812q;

    /* renamed from: r, reason: collision with root package name */
    public static final long[] f35813r = {0, 0, -1, -1};

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f35814s = new int[0];

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f35815t = {"", "\r", "\n", ",", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", ":", null, "UT", "GMT", "EST", "EDT", "CST", "CDT", "MST", "MDT", "PST", "PDT", null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    /* renamed from: u, reason: collision with root package name */
    public static final String[] f35816u = {"DEFAULT", "INCOMMENT", "NESTED_COMMENT"};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f35817v = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: w, reason: collision with root package name */
    public static final long[] f35818w = {70437463654399L};

    /* renamed from: x, reason: collision with root package name */
    public static final long[] f35819x = {343597383680L};

    /* renamed from: y, reason: collision with root package name */
    public static final long[] f35820y = {68719476736L};

    /* renamed from: z, reason: collision with root package name */
    public static final long[] f35821z = {69956427317248L};

    /* renamed from: c, reason: collision with root package name */
    public d f35823c;

    /* renamed from: f, reason: collision with root package name */
    public final StringBuilder f35826f;

    /* renamed from: g, reason: collision with root package name */
    public StringBuilder f35827g;

    /* renamed from: h, reason: collision with root package name */
    public int f35828h;

    /* renamed from: i, reason: collision with root package name */
    public int f35829i;

    /* renamed from: j, reason: collision with root package name */
    public char f35830j;

    /* renamed from: k, reason: collision with root package name */
    public int f35831k;

    /* renamed from: l, reason: collision with root package name */
    public int f35832l;

    /* renamed from: m, reason: collision with root package name */
    public int f35833m;

    /* renamed from: n, reason: collision with root package name */
    public int f35834n;

    /* renamed from: o, reason: collision with root package name */
    public int f35835o;

    /* renamed from: p, reason: collision with root package name */
    public int f35836p;

    /* renamed from: b, reason: collision with root package name */
    public PrintStream f35822b = System.out;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f35824d = new int[4];

    /* renamed from: e, reason: collision with root package name */
    public final int[] f35825e = new int[8];

    public c(d dVar) {
        StringBuilder sb = new StringBuilder();
        this.f35826f = sb;
        this.f35827g = sb;
        this.f35831k = 0;
        this.f35832l = 0;
        this.f35823c = dVar;
    }

    public void a() {
        int i10 = this.f35828h;
        int i11 = this.f35835o + 1;
        this.f35829i = i11;
        int i12 = i10 + i11;
        this.f35828h = i12;
        switch (this.f35836p) {
            case 39:
                this.f35827g.append(this.f35823c.e(i12));
                this.f35828h = 0;
                this.f35827g.deleteCharAt(r5.length() - 2);
                return;
            case 40:
                this.f35827g.append(this.f35823c.e(i12));
                this.f35828h = 0;
                f35812q = 1;
                return;
            case 41:
            default:
                return;
            case 42:
                this.f35827g.append(this.f35823c.e(i12));
                this.f35828h = 0;
                this.f35827g.deleteCharAt(r5.length() - 2);
                return;
            case 43:
                this.f35827g.append(this.f35823c.e(i12));
                this.f35828h = 0;
                f35812q++;
                return;
            case 44:
                this.f35827g.append(this.f35823c.e(i12));
                this.f35828h = 0;
                int i13 = f35812q - 1;
                f35812q = i13;
                if (i13 == 0) {
                    c(1);
                    return;
                }
                return;
        }
    }

    public final void b() {
        this.f35834n = -2147483647;
        int i10 = 4;
        while (true) {
            int i11 = i10 - 1;
            if (i10 > 0) {
                this.f35824d[i11] = Integer.MIN_VALUE;
                i10 = i11;
            } else {
                return;
            }
        }
    }

    public void c(int i10) {
        if (i10 < 3 && i10 >= 0) {
            this.f35831k = i10;
            return;
        }
        throw new TokenMgrError("Error: Ignoring invalid lexical state : " + i10 + ". State unchanged.", 2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:
    
        if ((org.apache.james.mime4j.field.datetime.parser.c.f35820y[r9 >> 6] & (1 << (r9 & 63))) == 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
    
        r6 = f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009d, code lost:
    
        if (r4 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a0, code lost:
    
        r6.specialToken = r4;
        r4.next = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a4, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a5, code lost:
    
        r6 = org.apache.james.mime4j.field.datetime.parser.c.f35817v[r20.f35836p];
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ab, code lost:
    
        if (r6 == (-1)) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ad, code lost:
    
        r20.f35831k = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.apache.james.mime4j.field.datetime.parser.Token d() {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.james.mime4j.field.datetime.parser.c.d():org.apache.james.mime4j.field.datetime.parser.Token");
    }

    public final void e(int i10) {
        int[] iArr = this.f35824d;
        int i11 = iArr[i10];
        int i12 = this.f35834n;
        if (i11 != i12) {
            int[] iArr2 = this.f35825e;
            int i13 = this.f35833m;
            this.f35833m = i13 + 1;
            iArr2[i13] = i10;
            iArr[i10] = i12;
        }
    }

    public Token f() {
        String str = f35815t[this.f35836p];
        if (str == null) {
            str = this.f35823c.d();
        }
        int i10 = this.f35823c.i();
        int h10 = this.f35823c.h();
        int k10 = this.f35823c.k();
        int j10 = this.f35823c.j();
        Token a10 = Token.a(this.f35836p, str);
        a10.beginLine = i10;
        a10.endLine = k10;
        a10.beginColumn = h10;
        a10.endColumn = j10;
        return a10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
    
        if (r6 > 24) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.james.mime4j.field.datetime.parser.c.g(int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.james.mime4j.field.datetime.parser.c.h(int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.james.mime4j.field.datetime.parser.c.i(int, int):int");
    }

    public final int j() {
        char c10 = this.f35830j;
        if (c10 != '\n') {
            if (c10 != '\r') {
                if (c10 != '(') {
                    if (c10 != ',') {
                        if (c10 != ':') {
                            if (c10 != 'A') {
                                if (c10 != 'J') {
                                    if (c10 != 'W') {
                                        switch (c10) {
                                            case 'C':
                                                return m(1610612736L);
                                            case 'D':
                                                return m(4194304L);
                                            case 'E':
                                                return m(402653184L);
                                            case 'F':
                                                return m(4352L);
                                            case 'G':
                                                return m(67108864L);
                                            default:
                                                switch (c10) {
                                                    case 'M':
                                                        return m(6442491920L);
                                                    case 'N':
                                                        return m(2097152L);
                                                    case 'O':
                                                        return m(1048576L);
                                                    case 'P':
                                                        return m(25769803776L);
                                                    default:
                                                        switch (c10) {
                                                            case 'S':
                                                                return m(525824L);
                                                            case 'T':
                                                                return m(160L);
                                                            case 'U':
                                                                return m(33554432L);
                                                            default:
                                                                return g(0, 0);
                                                        }
                                                }
                                        }
                                    }
                                    return m(64L);
                                }
                                return m(198656L);
                            }
                            return m(278528L);
                        }
                        return p(0, 23);
                    }
                    return p(0, 3);
                }
                return p(0, 37);
            }
            return p(0, 1);
        }
        return p(0, 2);
    }

    public final int k() {
        char c10 = this.f35830j;
        if (c10 != '(') {
            if (c10 != ')') {
                return h(0, 0);
            }
            return p(0, 38);
        }
        return p(0, 40);
    }

    public final int l() {
        char c10 = this.f35830j;
        if (c10 != '(') {
            if (c10 != ')') {
                return i(0, 0);
            }
            return p(0, 44);
        }
        return p(0, 43);
    }

    public final int m(long j10) {
        try {
            char l10 = this.f35823c.l();
            this.f35830j = l10;
            if (l10 != 'D') {
                if (l10 != 'M') {
                    if (l10 != 'a') {
                        if (l10 != 'c') {
                            if (l10 != 'e') {
                                if (l10 != 'h') {
                                    if (l10 != 'r') {
                                        if (l10 != 'u') {
                                            if (l10 != 'S') {
                                                if (l10 != 'T') {
                                                    if (l10 != 'o') {
                                                        if (l10 == 'p') {
                                                            return n(j10, 16384L);
                                                        }
                                                    } else {
                                                        return n(j10, 2097168L);
                                                    }
                                                } else if ((33554432 & j10) != 0) {
                                                    return p(1, 25);
                                                }
                                                return o(0, j10);
                                            }
                                            return n(j10, 11408506880L);
                                        }
                                        return n(j10, 459808L);
                                    }
                                    return n(j10, 256L);
                                }
                                return n(j10, 128L);
                            }
                            return n(j10, 4722752L);
                        }
                        return n(j10, 1048576L);
                    }
                    return n(j10, 43520L);
                }
                return n(j10, 67108864L);
            }
            return n(j10, 22817013760L);
        } catch (IOException unused) {
            q(0, j10);
            return 1;
        }
    }

    public final int n(long j10, long j11) {
        long j12 = j11 & j10;
        if (j12 == 0) {
            return o(0, j10);
        }
        try {
            char l10 = this.f35823c.l();
            this.f35830j = l10;
            if (l10 != 'T') {
                if (l10 != 'g') {
                    if (l10 != 'i') {
                        if (l10 != 'l') {
                            if (l10 != 'n') {
                                if (l10 != 'p') {
                                    if (l10 != 'r') {
                                        if (l10 != 'y') {
                                            switch (l10) {
                                                case 'b':
                                                    if ((4096 & j12) != 0) {
                                                        return p(2, 12);
                                                    }
                                                    break;
                                                case 'c':
                                                    if ((4194304 & j12) != 0) {
                                                        return p(2, 22);
                                                    }
                                                    break;
                                                case 'd':
                                                    if ((64 & j12) != 0) {
                                                        return p(2, 6);
                                                    }
                                                    break;
                                                case 'e':
                                                    if ((32 & j12) != 0) {
                                                        return p(2, 5);
                                                    }
                                                    break;
                                                default:
                                                    switch (l10) {
                                                        case 't':
                                                            if ((512 & j12) != 0) {
                                                                return p(2, 9);
                                                            }
                                                            if ((1048576 & j12) != 0) {
                                                                return p(2, 20);
                                                            }
                                                            break;
                                                        case 'u':
                                                            if ((128 & j12) != 0) {
                                                                return p(2, 7);
                                                            }
                                                            break;
                                                        case 'v':
                                                            if ((2097152 & j12) != 0) {
                                                                return p(2, 21);
                                                            }
                                                            break;
                                                    }
                                            }
                                        } else if ((32768 & j12) != 0) {
                                            return p(2, 15);
                                        }
                                    } else {
                                        if ((8192 & j12) != 0) {
                                            return p(2, 13);
                                        }
                                        if ((16384 & j12) != 0) {
                                            return p(2, 14);
                                        }
                                    }
                                } else if ((524288 & j12) != 0) {
                                    return p(2, 19);
                                }
                            } else {
                                if ((16 & j12) != 0) {
                                    return p(2, 4);
                                }
                                if ((1024 & j12) != 0) {
                                    return p(2, 10);
                                }
                                if ((2048 & j12) != 0) {
                                    return p(2, 11);
                                }
                                if ((65536 & j12) != 0) {
                                    return p(2, 16);
                                }
                            }
                        } else if ((131072 & j12) != 0) {
                            return p(2, 17);
                        }
                    } else if ((256 & j12) != 0) {
                        return p(2, 8);
                    }
                } else if ((262144 & j12) != 0) {
                    return p(2, 18);
                }
            } else {
                if ((67108864 & j12) != 0) {
                    return p(2, 26);
                }
                if ((134217728 & j12) != 0) {
                    return p(2, 27);
                }
                if ((268435456 & j12) != 0) {
                    return p(2, 28);
                }
                if ((536870912 & j12) != 0) {
                    return p(2, 29);
                }
                if ((1073741824 & j12) != 0) {
                    return p(2, 30);
                }
                if ((2147483648L & j12) != 0) {
                    return p(2, 31);
                }
                if ((4294967296L & j12) != 0) {
                    return p(2, 32);
                }
                if ((8589934592L & j12) != 0) {
                    return p(2, 33);
                }
                if ((17179869184L & j12) != 0) {
                    return p(2, 34);
                }
            }
            return o(1, j12);
        } catch (IOException unused) {
            q(1, j12);
            return 2;
        }
    }

    public final int o(int i10, long j10) {
        return g(q(i10, j10), i10 + 1);
    }

    public final int p(int i10, int i11) {
        this.f35836p = i11;
        this.f35835o = i10;
        return i10 + 1;
    }

    public final int q(int i10, long j10) {
        if (i10 != 0) {
            if (i10 == 1 && (j10 & 34334373872L) != 0 && this.f35835o == 0) {
                this.f35836p = 35;
                this.f35835o = 0;
            }
            return -1;
        }
        if ((j10 & 34334373872L) != 0) {
            this.f35836p = 35;
        }
        return -1;
    }
}
