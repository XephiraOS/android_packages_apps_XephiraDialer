package d5;

import com.google.zxing.FormatException;
import com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState;

/* compiled from: GeneralAppIdDecoder.java */
/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final S4.a f30054a;

    /* renamed from: b, reason: collision with root package name */
    public final CurrentParsingState f30055b = new CurrentParsingState();

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f30056c = new StringBuilder();

    public r(S4.a aVar) {
        this.f30054a = aVar;
    }

    public static int g(S4.a aVar, int i10, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (aVar.g(i10 + i13)) {
                i12 |= 1 << ((i11 - i13) - 1);
            }
        }
        return i12;
    }

    public String a(StringBuilder sb, int i10) {
        String str;
        String str2 = null;
        while (true) {
            n c10 = c(i10, str2);
            String a10 = q.a(c10.b());
            if (a10 != null) {
                sb.append(a10);
            }
            if (c10.d()) {
                str = String.valueOf(c10.c());
            } else {
                str = null;
            }
            if (i10 != c10.a()) {
                i10 = c10.a();
                str2 = str;
            } else {
                return sb.toString();
            }
        }
    }

    public final m b(int i10) {
        char c10;
        int f10 = f(i10, 5);
        if (f10 == 15) {
            return new m(i10 + 5, '$');
        }
        if (f10 >= 5 && f10 < 15) {
            return new m(i10 + 5, (char) (f10 + 43));
        }
        int f11 = f(i10, 6);
        if (f11 >= 32 && f11 < 58) {
            return new m(i10 + 6, (char) (f11 + 33));
        }
        switch (f11) {
            case 58:
                c10 = '*';
                break;
            case 59:
                c10 = ',';
                break;
            case 60:
                c10 = '-';
                break;
            case 61:
                c10 = '.';
                break;
            case 62:
                c10 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(f11)));
        }
        return new m(i10 + 6, c10);
    }

    public n c(int i10, String str) {
        this.f30056c.setLength(0);
        if (str != null) {
            this.f30056c.append(str);
        }
        this.f30055b.h(i10);
        n o10 = o();
        if (o10 != null && o10.d()) {
            return new n(this.f30055b.a(), this.f30056c.toString(), o10.c());
        }
        return new n(this.f30055b.a(), this.f30056c.toString());
    }

    public final m d(int i10) {
        int f10 = f(i10, 5);
        if (f10 == 15) {
            return new m(i10 + 5, '$');
        }
        char c10 = '+';
        if (f10 >= 5 && f10 < 15) {
            return new m(i10 + 5, (char) (f10 + 43));
        }
        int f11 = f(i10, 7);
        if (f11 >= 64 && f11 < 90) {
            return new m(i10 + 7, (char) (f11 + 1));
        }
        if (f11 >= 90 && f11 < 116) {
            return new m(i10 + 7, (char) (f11 + 7));
        }
        switch (f(i10, 8)) {
            case 232:
                c10 = '!';
                break;
            case 233:
                c10 = '\"';
                break;
            case 234:
                c10 = '%';
                break;
            case 235:
                c10 = '&';
                break;
            case 236:
                c10 = '\'';
                break;
            case 237:
                c10 = '(';
                break;
            case 238:
                c10 = ')';
                break;
            case 239:
                c10 = '*';
                break;
            case 240:
                break;
            case 241:
                c10 = ',';
                break;
            case 242:
                c10 = '-';
                break;
            case 243:
                c10 = '.';
                break;
            case 244:
                c10 = '/';
                break;
            case 245:
                c10 = ':';
                break;
            case 246:
                c10 = ';';
                break;
            case 247:
                c10 = '<';
                break;
            case 248:
                c10 = '=';
                break;
            case 249:
                c10 = '>';
                break;
            case 250:
                c10 = '?';
                break;
            case 251:
                c10 = '_';
                break;
            case 252:
                c10 = ' ';
                break;
            default:
                throw FormatException.a();
        }
        return new m(i10 + 8, c10);
    }

    public final o e(int i10) {
        int i11 = i10 + 7;
        if (i11 > this.f30054a.k()) {
            int f10 = f(i10, 4);
            if (f10 == 0) {
                return new o(this.f30054a.k(), 10, 10);
            }
            return new o(this.f30054a.k(), f10 - 1, 10);
        }
        int f11 = f(i10, 7) - 8;
        return new o(i11, f11 / 11, f11 % 11);
    }

    public int f(int i10, int i11) {
        return g(this.f30054a, i10, i11);
    }

    public final boolean h(int i10) {
        int i11 = i10 + 3;
        if (i11 > this.f30054a.k()) {
            return false;
        }
        while (i10 < i11) {
            if (this.f30054a.g(i10)) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public final boolean i(int i10) {
        int i11;
        if (i10 + 1 > this.f30054a.k()) {
            return false;
        }
        for (int i12 = 0; i12 < 5 && (i11 = i12 + i10) < this.f30054a.k(); i12++) {
            if (i12 == 2) {
                if (!this.f30054a.g(i10 + 2)) {
                    return false;
                }
            } else if (this.f30054a.g(i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i10) {
        int i11;
        if (i10 + 1 > this.f30054a.k()) {
            return false;
        }
        for (int i12 = 0; i12 < 4 && (i11 = i12 + i10) < this.f30054a.k(); i12++) {
            if (this.f30054a.g(i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i10) {
        int f10;
        if (i10 + 5 > this.f30054a.k()) {
            return false;
        }
        int f11 = f(i10, 5);
        if (f11 >= 5 && f11 < 16) {
            return true;
        }
        if (i10 + 6 > this.f30054a.k() || (f10 = f(i10, 6)) < 16 || f10 >= 63) {
            return false;
        }
        return true;
    }

    public final boolean l(int i10) {
        int f10;
        if (i10 + 5 > this.f30054a.k()) {
            return false;
        }
        int f11 = f(i10, 5);
        if (f11 >= 5 && f11 < 16) {
            return true;
        }
        if (i10 + 7 > this.f30054a.k()) {
            return false;
        }
        int f12 = f(i10, 7);
        if (f12 >= 64 && f12 < 116) {
            return true;
        }
        if (i10 + 8 > this.f30054a.k() || (f10 = f(i10, 8)) < 232 || f10 >= 253) {
            return false;
        }
        return true;
    }

    public final boolean m(int i10) {
        if (i10 + 7 > this.f30054a.k()) {
            if (i10 + 4 <= this.f30054a.k()) {
                return true;
            }
            return false;
        }
        int i11 = i10;
        while (true) {
            int i12 = i10 + 3;
            if (i11 < i12) {
                if (this.f30054a.g(i11)) {
                    return true;
                }
                i11++;
            } else {
                return this.f30054a.g(i12);
            }
        }
    }

    public final l n() {
        while (k(this.f30055b.a())) {
            m b10 = b(this.f30055b.a());
            this.f30055b.h(b10.a());
            if (b10.c()) {
                return new l(new n(this.f30055b.a(), this.f30056c.toString()), true);
            }
            this.f30056c.append(b10.b());
        }
        if (h(this.f30055b.a())) {
            this.f30055b.b(3);
            this.f30055b.g();
        } else if (i(this.f30055b.a())) {
            if (this.f30055b.a() + 5 < this.f30054a.k()) {
                this.f30055b.b(5);
            } else {
                this.f30055b.h(this.f30054a.k());
            }
            this.f30055b.f();
        }
        return new l(false);
    }

    public final n o() {
        l q10;
        boolean b10;
        do {
            int a10 = this.f30055b.a();
            if (this.f30055b.c()) {
                q10 = n();
                b10 = q10.b();
            } else if (this.f30055b.d()) {
                q10 = p();
                b10 = q10.b();
            } else {
                q10 = q();
                b10 = q10.b();
            }
            if (a10 == this.f30055b.a() && !b10) {
                break;
            }
        } while (!b10);
        return q10.a();
    }

    public final l p() {
        while (l(this.f30055b.a())) {
            m d10 = d(this.f30055b.a());
            this.f30055b.h(d10.a());
            if (d10.c()) {
                return new l(new n(this.f30055b.a(), this.f30056c.toString()), true);
            }
            this.f30056c.append(d10.b());
        }
        if (h(this.f30055b.a())) {
            this.f30055b.b(3);
            this.f30055b.g();
        } else if (i(this.f30055b.a())) {
            if (this.f30055b.a() + 5 < this.f30054a.k()) {
                this.f30055b.b(5);
            } else {
                this.f30055b.h(this.f30054a.k());
            }
            this.f30055b.e();
        }
        return new l(false);
    }

    public final l q() {
        n nVar;
        while (m(this.f30055b.a())) {
            o e10 = e(this.f30055b.a());
            this.f30055b.h(e10.a());
            if (e10.d()) {
                if (e10.e()) {
                    nVar = new n(this.f30055b.a(), this.f30056c.toString());
                } else {
                    nVar = new n(this.f30055b.a(), this.f30056c.toString(), e10.c());
                }
                return new l(nVar, true);
            }
            this.f30056c.append(e10.b());
            if (e10.e()) {
                return new l(new n(this.f30055b.a(), this.f30056c.toString()), true);
            }
            this.f30056c.append(e10.c());
        }
        if (j(this.f30055b.a())) {
            this.f30055b.e();
            this.f30055b.b(4);
        }
        return new l(false);
    }
}
