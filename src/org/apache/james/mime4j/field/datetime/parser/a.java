package org.apache.james.mime4j.field.datetime.parser;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DateTimeParser.java */
/* loaded from: classes4.dex */
public class a implements org.apache.james.mime4j.field.datetime.parser.b {

    /* renamed from: l, reason: collision with root package name */
    public static int[] f35792l;

    /* renamed from: m, reason: collision with root package name */
    public static int[] f35793m;

    /* renamed from: b, reason: collision with root package name */
    public c f35794b;

    /* renamed from: c, reason: collision with root package name */
    public d f35795c;

    /* renamed from: e, reason: collision with root package name */
    public Token f35797e;

    /* renamed from: j, reason: collision with root package name */
    public int[] f35802j;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f35800h = new int[7];

    /* renamed from: i, reason: collision with root package name */
    public List<int[]> f35801i = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public int f35803k = -1;

    /* renamed from: d, reason: collision with root package name */
    public Token f35796d = new Token();

    /* renamed from: f, reason: collision with root package name */
    public int f35798f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f35799g = 0;

    /* compiled from: DateTimeParser.java */
    /* renamed from: org.apache.james.mime4j.field.datetime.parser.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0338a {

        /* renamed from: a, reason: collision with root package name */
        public String f35804a;

        /* renamed from: b, reason: collision with root package name */
        public int f35805b;

        /* renamed from: c, reason: collision with root package name */
        public int f35806c;

        public C0338a(String str, int i10, int i11) {
            this.f35804a = str;
            this.f35805b = i10;
            this.f35806c = i11;
        }

        public int a() {
            return this.f35806c;
        }

        public int b() {
            return this.f35805b;
        }

        public String c() {
            return this.f35804a;
        }
    }

    /* compiled from: DateTimeParser.java */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f35807a;

        /* renamed from: b, reason: collision with root package name */
        public int f35808b;

        /* renamed from: c, reason: collision with root package name */
        public int f35809c;

        /* renamed from: d, reason: collision with root package name */
        public int f35810d;

        public b(int i10, int i11, int i12, int i13) {
            this.f35807a = i10;
            this.f35808b = i11;
            this.f35809c = i12;
            this.f35810d = i13;
        }

        public int a() {
            return this.f35807a;
        }

        public int b() {
            return this.f35808b;
        }

        public int c() {
            return this.f35809c;
        }

        public int d() {
            return this.f35810d;
        }
    }

    static {
        i();
        j();
    }

    public a(Reader reader) {
        this.f35795c = new d(reader, 1, 1);
        this.f35794b = new c(this.f35795c);
        for (int i10 = 0; i10 < 7; i10++) {
            this.f35800h[i10] = -1;
        }
    }

    public static int f(char c10) {
        return 0;
    }

    public static void i() {
        f35792l = new int[]{2, 2032, 2032, 8386560, 8388608, -16777216, -33554432};
    }

    public static void j() {
        f35793m = new int[]{0, 0, 0, 0, 0, 15, 15};
    }

    public static int p(Token token) {
        return Integer.parseInt(token.image, 10);
    }

    public final C0338a a() {
        int c10 = c();
        return new C0338a(s(), m(), c10);
    }

    public final M9.a b() {
        int i10 = this.f35798f;
        if (i10 == -1) {
            i10 = k();
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                d();
                h(3);
                break;
            default:
                this.f35800h[1] = this.f35799g;
                break;
        }
        C0338a a10 = a();
        b r10 = r();
        return new M9.a(a10.c(), a10.b(), a10.a(), r10.a(), r10.b(), r10.c(), r10.d());
    }

    public final int c() {
        return p(h(46));
    }

    public final String d() {
        int i10 = this.f35798f;
        if (i10 == -1) {
            i10 = k();
        }
        switch (i10) {
            case 4:
                h(4);
                break;
            case 5:
                h(5);
                break;
            case 6:
                h(6);
                break;
            case 7:
                h(7);
                break;
            case 8:
                h(8);
                break;
            case 9:
                h(9);
                break;
            case 10:
                h(10);
                break;
            default:
                this.f35800h[2] = this.f35799g;
                h(-1);
                throw new ParseException();
        }
        return this.f35796d.image;
    }

    public ParseException e() {
        this.f35801i.clear();
        boolean[] zArr = new boolean[49];
        int i10 = this.f35803k;
        if (i10 >= 0) {
            zArr[i10] = true;
            this.f35803k = -1;
        }
        for (int i11 = 0; i11 < 7; i11++) {
            if (this.f35800h[i11] == this.f35799g) {
                for (int i12 = 0; i12 < 32; i12++) {
                    int i13 = 1 << i12;
                    if ((f35792l[i11] & i13) != 0) {
                        zArr[i12] = true;
                    }
                    if ((f35793m[i11] & i13) != 0) {
                        zArr[i12 + 32] = true;
                    }
                }
            }
        }
        for (int i14 = 0; i14 < 49; i14++) {
            if (zArr[i14]) {
                this.f35802j = r5;
                int[] iArr = {i14};
                this.f35801i.add(iArr);
            }
        }
        int[][] iArr2 = new int[this.f35801i.size()];
        for (int i15 = 0; i15 < this.f35801i.size(); i15++) {
            iArr2[i15] = this.f35801i.get(i15);
        }
        return new ParseException(this.f35796d, iArr2, org.apache.james.mime4j.field.datetime.parser.b.f35811a);
    }

    public final int g() {
        return p(h(46));
    }

    public final Token h(int i10) {
        Token token = this.f35796d;
        Token token2 = token.next;
        if (token2 != null) {
            this.f35796d = token2;
        } else {
            Token d10 = this.f35794b.d();
            token.next = d10;
            this.f35796d = d10;
        }
        this.f35798f = -1;
        Token token3 = this.f35796d;
        if (token3.kind == i10) {
            this.f35799g++;
            return token3;
        }
        this.f35796d = token;
        this.f35803k = i10;
        throw e();
    }

    public final int k() {
        Token token = this.f35796d;
        Token token2 = token.next;
        this.f35797e = token2;
        if (token2 == null) {
            Token d10 = this.f35794b.d();
            token.next = d10;
            int i10 = d10.kind;
            this.f35798f = i10;
            return i10;
        }
        int i11 = token2.kind;
        this.f35798f = i11;
        return i11;
    }

    public final int l() {
        return p(h(46));
    }

    public final int m() {
        int i10 = this.f35798f;
        if (i10 == -1) {
            i10 = k();
        }
        switch (i10) {
            case 11:
                h(11);
                return 1;
            case 12:
                h(12);
                return 2;
            case 13:
                h(13);
                return 3;
            case 14:
                h(14);
                return 4;
            case 15:
                h(15);
                return 5;
            case 16:
                h(16);
                return 6;
            case 17:
                h(17);
                return 7;
            case 18:
                h(18);
                return 8;
            case 19:
                h(19);
                return 9;
            case 20:
                h(20);
                return 10;
            case 21:
                h(21);
                return 11;
            case 22:
                h(22);
                return 12;
            default:
                this.f35800h[3] = this.f35799g;
                h(-1);
                throw new ParseException();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x000d. Please report as an issue. */
    public final int n() {
        int i10 = this.f35798f;
        if (i10 == -1) {
            i10 = k();
        }
        int i11 = -5;
        switch (i10) {
            case 25:
                h(25);
                i11 = 0;
                return i11 * 100;
            case 26:
                h(26);
                i11 = 0;
                return i11 * 100;
            case 27:
                h(27);
                return i11 * 100;
            case 28:
                h(28);
                i11 = -4;
                return i11 * 100;
            case 29:
                h(29);
                i11 = -6;
                return i11 * 100;
            case 30:
                h(30);
                return i11 * 100;
            case 31:
                h(31);
                i11 = -7;
                return i11 * 100;
            case 32:
                h(32);
                i11 = -6;
                return i11 * 100;
            case 33:
                h(33);
                i11 = -8;
                return i11 * 100;
            case 34:
                h(34);
                i11 = -7;
                return i11 * 100;
            case 35:
                i11 = f(h(35).image.charAt(0));
                return i11 * 100;
            default:
                this.f35800h[6] = this.f35799g;
                h(-1);
                throw new ParseException();
        }
    }

    public final M9.a o() {
        M9.a b10 = b();
        h(0);
        return b10;
    }

    public final int q() {
        return p(h(46));
    }

    public final b r() {
        int q10;
        int g10 = g();
        h(23);
        int l10 = l();
        int i10 = this.f35798f;
        if (i10 == -1) {
            i10 = k();
        }
        if (i10 != 23) {
            this.f35800h[4] = this.f35799g;
            q10 = 0;
        } else {
            h(23);
            q10 = q();
        }
        return new b(g10, l10, q10, t());
    }

    public final String s() {
        return h(46).image;
    }

    public final int t() {
        int i10 = this.f35798f;
        int i11 = -1;
        if (i10 == -1) {
            i10 = k();
        }
        switch (i10) {
            case 24:
                Token h10 = h(24);
                int p10 = p(h(46));
                if (!h10.image.equals("-")) {
                    i11 = 1;
                }
                return p10 * i11;
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return n();
            default:
                this.f35800h[5] = this.f35799g;
                h(-1);
                throw new ParseException();
        }
    }
}
