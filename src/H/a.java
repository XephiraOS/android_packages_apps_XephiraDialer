package H;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: BidiFormatter.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final c f1169d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f1170e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f1171f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f1172g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f1173h;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1174a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1175b;

    /* renamed from: c, reason: collision with root package name */
    public final c f1176c;

    /* compiled from: BidiFormatter.java */
    /* renamed from: H.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0023a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1177a;

        /* renamed from: b, reason: collision with root package name */
        public int f1178b;

        /* renamed from: c, reason: collision with root package name */
        public c f1179c;

        public C0023a() {
            c(a.e(Locale.getDefault()));
        }

        public static a b(boolean z10) {
            if (z10) {
                return a.f1173h;
            }
            return a.f1172g;
        }

        public a a() {
            if (this.f1178b == 2 && this.f1179c == a.f1169d) {
                return b(this.f1177a);
            }
            return new a(this.f1177a, this.f1178b, this.f1179c);
        }

        public final void c(boolean z10) {
            this.f1177a = z10;
            this.f1179c = a.f1169d;
            this.f1178b = 2;
        }
    }

    /* compiled from: BidiFormatter.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: f, reason: collision with root package name */
        public static final byte[] f1180f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f1181a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1182b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1183c;

        /* renamed from: d, reason: collision with root package name */
        public int f1184d;

        /* renamed from: e, reason: collision with root package name */
        public char f1185e;

        static {
            for (int i10 = 0; i10 < 1792; i10++) {
                f1180f[i10] = Character.getDirectionality(i10);
            }
        }

        public b(CharSequence charSequence, boolean z10) {
            this.f1181a = charSequence;
            this.f1182b = z10;
            this.f1183c = charSequence.length();
        }

        public static byte c(char c10) {
            if (c10 < 1792) {
                return f1180f[c10];
            }
            return Character.getDirectionality(c10);
        }

        public byte a() {
            char charAt = this.f1181a.charAt(this.f1184d - 1);
            this.f1185e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f1181a, this.f1184d);
                this.f1184d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f1184d--;
            byte c10 = c(this.f1185e);
            if (this.f1182b) {
                char c11 = this.f1185e;
                if (c11 == '>') {
                    return h();
                }
                if (c11 == ';') {
                    return f();
                }
                return c10;
            }
            return c10;
        }

        public byte b() {
            char charAt = this.f1181a.charAt(this.f1184d);
            this.f1185e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f1181a, this.f1184d);
                this.f1184d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f1184d++;
            byte c10 = c(this.f1185e);
            if (this.f1182b) {
                char c11 = this.f1185e;
                if (c11 == '<') {
                    return i();
                }
                if (c11 == '&') {
                    return g();
                }
                return c10;
            }
            return c10;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0045. Please report as an issue. */
        public int d() {
            this.f1184d = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (this.f1184d < this.f1183c && i10 == 0) {
                byte b10 = b();
                if (b10 != 0) {
                    if (b10 != 1 && b10 != 2) {
                        if (b10 != 9) {
                            switch (b10) {
                                case 14:
                                case 15:
                                    i12++;
                                    i11 = -1;
                                    continue;
                                case 16:
                                case 17:
                                    i12++;
                                    i11 = 1;
                                    continue;
                                case 18:
                                    i12--;
                                    i11 = 0;
                                    continue;
                            }
                        }
                    } else if (i12 == 0) {
                        return 1;
                    }
                } else if (i12 == 0) {
                    return -1;
                }
                i10 = i12;
            }
            if (i10 == 0) {
                return 0;
            }
            if (i11 != 0) {
                return i11;
            }
            while (this.f1184d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i10 == i12) {
                            return -1;
                        }
                        i12--;
                    case 16:
                    case 17:
                        if (i10 == i12) {
                            return 1;
                        }
                        i12--;
                    case 18:
                        i12++;
                }
            }
            return 0;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:33:0x001c. Please report as an issue. */
        public int e() {
            this.f1184d = this.f1183c;
            int i10 = 0;
            while (true) {
                int i11 = i10;
                while (this.f1184d > 0) {
                    byte a10 = a();
                    if (a10 != 0) {
                        if (a10 != 1 && a10 != 2) {
                            if (a10 != 9) {
                                switch (a10) {
                                    case 14:
                                    case 15:
                                        if (i11 == i10) {
                                            return -1;
                                        }
                                        i10--;
                                        break;
                                    case 16:
                                    case 17:
                                        if (i11 == i10) {
                                            return 1;
                                        }
                                        i10--;
                                        break;
                                    case 18:
                                        i10++;
                                        break;
                                    default:
                                        if (i11 != 0) {
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } else {
                                continue;
                            }
                        } else {
                            if (i10 == 0) {
                                return 1;
                            }
                            if (i11 == 0) {
                                break;
                            }
                        }
                    } else {
                        if (i10 == 0) {
                            return -1;
                        }
                        if (i11 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }

        public final byte f() {
            char charAt;
            int i10 = this.f1184d;
            do {
                int i11 = this.f1184d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1181a;
                int i12 = i11 - 1;
                this.f1184d = i12;
                charAt = charSequence.charAt(i12);
                this.f1185e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f1184d = i10;
            this.f1185e = ';';
            return (byte) 13;
        }

        public final byte g() {
            char charAt;
            do {
                int i10 = this.f1184d;
                if (i10 < this.f1183c) {
                    CharSequence charSequence = this.f1181a;
                    this.f1184d = i10 + 1;
                    charAt = charSequence.charAt(i10);
                    this.f1185e = charAt;
                } else {
                    return (byte) 12;
                }
            } while (charAt != ';');
            return (byte) 12;
        }

        public final byte h() {
            char charAt;
            int i10 = this.f1184d;
            while (true) {
                int i11 = this.f1184d;
                if (i11 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1181a;
                int i12 = i11 - 1;
                this.f1184d = i12;
                char charAt2 = charSequence.charAt(i12);
                this.f1185e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i13 = this.f1184d;
                        if (i13 > 0) {
                            CharSequence charSequence2 = this.f1181a;
                            int i14 = i13 - 1;
                            this.f1184d = i14;
                            charAt = charSequence2.charAt(i14);
                            this.f1185e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f1184d = i10;
            this.f1185e = '>';
            return (byte) 13;
        }

        public final byte i() {
            char charAt;
            int i10 = this.f1184d;
            while (true) {
                int i11 = this.f1184d;
                if (i11 < this.f1183c) {
                    CharSequence charSequence = this.f1181a;
                    this.f1184d = i11 + 1;
                    char charAt2 = charSequence.charAt(i11);
                    this.f1185e = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i12 = this.f1184d;
                            if (i12 < this.f1183c) {
                                CharSequence charSequence2 = this.f1181a;
                                this.f1184d = i12 + 1;
                                charAt = charSequence2.charAt(i12);
                                this.f1185e = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f1184d = i10;
                    this.f1185e = '<';
                    return (byte) 13;
                }
            }
        }
    }

    static {
        c cVar = d.f1196c;
        f1169d = cVar;
        f1170e = Character.toString((char) 8206);
        f1171f = Character.toString((char) 8207);
        f1172g = new a(false, 2, cVar);
        f1173h = new a(true, 2, cVar);
    }

    public a(boolean z10, int i10, c cVar) {
        this.f1174a = z10;
        this.f1175b = i10;
        this.f1176c = cVar;
    }

    public static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0023a().a();
    }

    public static boolean e(Locale locale) {
        if (e.a(locale) == 1) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if ((this.f1175b & 2) != 0) {
            return true;
        }
        return false;
    }

    public final String f(CharSequence charSequence, c cVar) {
        boolean a10 = cVar.a(charSequence, 0, charSequence.length());
        if (!this.f1174a && (a10 || b(charSequence) == 1)) {
            return f1170e;
        }
        if (this.f1174a) {
            if (!a10 || b(charSequence) == -1) {
                return f1171f;
            }
            return "";
        }
        return "";
    }

    public final String g(CharSequence charSequence, c cVar) {
        boolean a10 = cVar.a(charSequence, 0, charSequence.length());
        if (!this.f1174a && (a10 || a(charSequence) == 1)) {
            return f1170e;
        }
        if (this.f1174a) {
            if (!a10 || a(charSequence) == -1) {
                return f1171f;
            }
            return "";
        }
        return "";
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f1176c, true);
    }

    public CharSequence i(CharSequence charSequence, c cVar, boolean z10) {
        c cVar2;
        char c10;
        c cVar3;
        if (charSequence == null) {
            return null;
        }
        boolean a10 = cVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            if (a10) {
                cVar3 = d.f1195b;
            } else {
                cVar3 = d.f1194a;
            }
            spannableStringBuilder.append((CharSequence) g(charSequence, cVar3));
        }
        if (a10 != this.f1174a) {
            if (a10) {
                c10 = 8235;
            } else {
                c10 = 8234;
            }
            spannableStringBuilder.append(c10);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            if (a10) {
                cVar2 = d.f1195b;
            } else {
                cVar2 = d.f1194a;
            }
            spannableStringBuilder.append((CharSequence) f(charSequence, cVar2));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f1176c, true);
    }

    public String k(String str, c cVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return i(str, cVar, z10).toString();
    }
}
