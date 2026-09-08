package U9;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: Parser.java */
/* loaded from: classes4.dex */
public class h extends DefaultHandler implements i, XMLReader, LexicalHandler {

    /* renamed from: F, reason: collision with root package name */
    public static boolean f3909F = true;

    /* renamed from: G, reason: collision with root package name */
    public static boolean f3910G = false;

    /* renamed from: H, reason: collision with root package name */
    public static boolean f3911H = false;

    /* renamed from: I, reason: collision with root package name */
    public static boolean f3912I = true;

    /* renamed from: J, reason: collision with root package name */
    public static boolean f3913J = true;

    /* renamed from: K, reason: collision with root package name */
    public static boolean f3914K = false;

    /* renamed from: L, reason: collision with root package name */
    public static boolean f3915L = true;

    /* renamed from: M, reason: collision with root package name */
    public static boolean f3916M = false;

    /* renamed from: N, reason: collision with root package name */
    public static boolean f3917N = true;

    /* renamed from: O, reason: collision with root package name */
    public static char[] f3918O = {'<', '/', '>'};

    /* renamed from: P, reason: collision with root package name */
    public static String f3919P = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-'()+,./:=?;!*#@$_%";

    /* renamed from: A, reason: collision with root package name */
    public c f3920A;

    /* renamed from: B, reason: collision with root package name */
    public c f3921B;

    /* renamed from: C, reason: collision with root package name */
    public int f3922C;

    /* renamed from: D, reason: collision with root package name */
    public boolean f3923D;

    /* renamed from: E, reason: collision with root package name */
    public char[] f3924E;

    /* renamed from: f, reason: collision with root package name */
    public k f3930f;

    /* renamed from: g, reason: collision with root package name */
    public j f3931g;

    /* renamed from: h, reason: collision with root package name */
    public b f3932h;

    /* renamed from: r, reason: collision with root package name */
    public HashMap f3942r;

    /* renamed from: s, reason: collision with root package name */
    public c f3943s;

    /* renamed from: t, reason: collision with root package name */
    public String f3944t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3945u;

    /* renamed from: v, reason: collision with root package name */
    public String f3946v;

    /* renamed from: w, reason: collision with root package name */
    public String f3947w;

    /* renamed from: x, reason: collision with root package name */
    public String f3948x;

    /* renamed from: y, reason: collision with root package name */
    public String f3949y;

    /* renamed from: z, reason: collision with root package name */
    public c f3950z;

    /* renamed from: a, reason: collision with root package name */
    public ContentHandler f3925a = this;

    /* renamed from: b, reason: collision with root package name */
    public LexicalHandler f3926b = this;

    /* renamed from: c, reason: collision with root package name */
    public DTDHandler f3927c = this;

    /* renamed from: d, reason: collision with root package name */
    public ErrorHandler f3928d = this;

    /* renamed from: e, reason: collision with root package name */
    public EntityResolver f3929e = this;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3933i = f3909F;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3934j = f3910G;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3935k = f3911H;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3936l = f3912I;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3937m = f3913J;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3938n = f3914K;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3939o = f3915L;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3940p = f3916M;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3941q = f3917N;

    public h() {
        HashMap hashMap = new HashMap();
        this.f3942r = hashMap;
        hashMap.put("http://xml.org/sax/features/namespaces", H(f3909F));
        HashMap hashMap2 = this.f3942r;
        Boolean bool = Boolean.FALSE;
        hashMap2.put("http://xml.org/sax/features/namespace-prefixes", bool);
        this.f3942r.put("http://xml.org/sax/features/external-general-entities", bool);
        this.f3942r.put("http://xml.org/sax/features/external-parameter-entities", bool);
        this.f3942r.put("http://xml.org/sax/features/is-standalone", bool);
        this.f3942r.put("http://xml.org/sax/features/lexical-handler/parameter-entities", bool);
        HashMap hashMap3 = this.f3942r;
        Boolean bool2 = Boolean.TRUE;
        hashMap3.put("http://xml.org/sax/features/resolve-dtd-uris", bool2);
        this.f3942r.put("http://xml.org/sax/features/string-interning", bool2);
        this.f3942r.put("http://xml.org/sax/features/use-attributes2", bool);
        this.f3942r.put("http://xml.org/sax/features/use-locator2", bool);
        this.f3942r.put("http://xml.org/sax/features/use-entity-resolver2", bool);
        this.f3942r.put("http://xml.org/sax/features/validation", bool);
        this.f3942r.put("http://xml.org/sax/features/xmlns-uris", bool);
        this.f3942r.put("http://xml.org/sax/features/xmlns-uris", bool);
        this.f3942r.put("http://xml.org/sax/features/xml-1.1", bool);
        this.f3942r.put("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons", H(f3910G));
        this.f3942r.put("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty", H(f3911H));
        this.f3942r.put("http://www.ccil.org/~cowan/tagsoup/features/root-bogons", H(f3912I));
        this.f3942r.put("http://www.ccil.org/~cowan/tagsoup/features/default-attributes", H(f3913J));
        this.f3942r.put("http://www.ccil.org/~cowan/tagsoup/features/translate-colons", H(f3914K));
        this.f3942r.put("http://www.ccil.org/~cowan/tagsoup/features/restart-elements", H(f3915L));
        this.f3942r.put("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace", H(f3916M));
        this.f3942r.put("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements", H(f3917N));
        this.f3943s = null;
        this.f3944t = null;
        this.f3945u = false;
        this.f3946v = null;
        this.f3947w = null;
        this.f3948x = null;
        this.f3949y = null;
        this.f3950z = null;
        this.f3920A = null;
        this.f3921B = null;
        this.f3922C = 0;
        this.f3923D = true;
        this.f3924E = new char[2000];
    }

    public static String[] F(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        int length = trim.length();
        int i10 = 0;
        int i11 = 0;
        boolean z10 = false;
        char c10 = 0;
        boolean z11 = false;
        while (i10 < length) {
            char charAt = trim.charAt(i10);
            if (!z10 && charAt == '\'' && c10 != '\\') {
                z11 = !z11;
                if (i11 >= 0) {
                    i10++;
                    c10 = charAt;
                }
                i11 = i10;
                i10++;
                c10 = charAt;
            } else if (!z11 && charAt == '\"' && c10 != '\\') {
                z10 = !z10;
                if (i11 >= 0) {
                    i10++;
                    c10 = charAt;
                }
                i11 = i10;
                i10++;
                c10 = charAt;
            } else {
                if (!z11 && !z10) {
                    if (Character.isWhitespace(charAt)) {
                        if (i11 >= 0) {
                            arrayList.add(trim.substring(i11, i10));
                        }
                        i11 = -1;
                    } else if (i11 < 0) {
                        if (charAt == ' ') {
                        }
                        i11 = i10;
                    }
                }
                i10++;
                c10 = charAt;
            }
        }
        arrayList.add(trim.substring(i11, i10));
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static String G(String str) {
        if (str == null) {
            return str;
        }
        int length = str.length();
        if (length == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if (charAt == str.charAt(length - 1)) {
            if (charAt == '\'' || charAt == '\"') {
                return str.substring(1, str.length() - 1);
            }
            return str;
        }
        return str;
    }

    public static Boolean H(boolean z10) {
        if (z10) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public final void A(c cVar) {
        String i10 = cVar.i();
        String g10 = cVar.g();
        String j10 = cVar.j();
        String z10 = z(i10);
        cVar.d();
        if (!this.f3933i) {
            g10 = "";
            j10 = "";
        }
        if (this.f3923D && g10.equalsIgnoreCase(this.f3948x)) {
            try {
                this.f3929e.resolveEntity(this.f3946v, this.f3947w);
            } catch (IOException unused) {
            }
        }
        if (t(z10, j10)) {
            this.f3925a.startPrefixMapping(z10, j10);
        }
        a b10 = cVar.b();
        int length = b10.getLength();
        for (int i11 = 0; i11 < length; i11++) {
            String uri = b10.getURI(i11);
            String z11 = z(b10.getQName(i11));
            if (t(z11, uri)) {
                this.f3925a.startPrefixMapping(z11, uri);
            }
        }
        this.f3925a.startElement(j10, g10, i10, cVar.b());
        cVar.o(this.f3950z);
        this.f3950z = cVar;
        this.f3923D = false;
        if (this.f3941q && (cVar.e() & 2) != 0) {
            this.f3931g.startCDATA();
        }
    }

    public final void B(c cVar) {
        c cVar2;
        d l10;
        while (true) {
            cVar2 = this.f3950z;
            while (cVar2 != null && !cVar2.c(cVar)) {
                cVar2 = cVar2.k();
            }
            if (cVar2 == null && (l10 = cVar.l()) != null) {
                c cVar3 = new c(l10, this.f3937m);
                cVar3.o(cVar);
                cVar = cVar3;
            }
        }
        if (cVar2 == null) {
            return;
        }
        while (true) {
            c cVar4 = this.f3950z;
            if (cVar4 == cVar2 || cVar4 == null || cVar4.k() == null || this.f3950z.k().k() == null) {
                break;
            } else {
                D();
            }
        }
        while (cVar != null) {
            c k10 = cVar.k();
            if (!cVar.i().equals("<pcdata>")) {
                A(cVar);
            }
            C(k10);
            cVar = k10;
        }
        this.f3943s = null;
    }

    public final void C(c cVar) {
        while (true) {
            c cVar2 = this.f3920A;
            if (cVar2 != null && this.f3950z.c(cVar2)) {
                if (cVar == null || this.f3920A.c(cVar)) {
                    c k10 = this.f3920A.k();
                    A(this.f3920A);
                    this.f3920A = k10;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void D() {
        c cVar = this.f3950z;
        y();
        if (this.f3939o && (cVar.e() & 1) != 0) {
            cVar.a();
            cVar.o(this.f3920A);
            this.f3920A = cVar;
        }
    }

    public final void E() {
        if (this.f3930f == null) {
            this.f3930f = new f();
        }
        if (this.f3931g == null) {
            this.f3931g = new e();
        }
        if (this.f3932h == null) {
            this.f3932h = new g(this);
        }
        this.f3950z = new c(this.f3930f.d("<root>"), this.f3937m);
        this.f3921B = new c(this.f3930f.d("<pcdata>"), this.f3937m);
        this.f3943s = null;
        this.f3944t = null;
        this.f3949y = null;
        this.f3920A = null;
        this.f3922C = 0;
        this.f3923D = true;
        this.f3947w = null;
        this.f3946v = null;
        this.f3948x = null;
    }

    @Override // U9.i
    public void a(char[] cArr, int i10, int i11) {
        if (i11 == 0) {
            return;
        }
        boolean z10 = true;
        for (int i12 = 0; i12 < i11; i12++) {
            if (!Character.isWhitespace(cArr[i10 + i12])) {
                z10 = false;
            }
        }
        if (z10 && !this.f3950z.c(this.f3921B)) {
            if (this.f3940p) {
                this.f3925a.ignorableWhitespace(cArr, i10, i11);
            }
        } else {
            B(this.f3921B);
            this.f3925a.characters(cArr, i10, i11);
        }
    }

    @Override // U9.i
    public void b(char[] cArr, int i10, int i11) {
        if (this.f3943s != null) {
            return;
        }
        this.f3949y = x(cArr, i10, i11).replace(':', '_');
    }

    @Override // U9.i
    public int c() {
        return this.f3922C;
    }

    @Override // U9.i
    public void d(char[] cArr, int i10, int i11) {
        c cVar = this.f3943s;
        if (cVar == null) {
            return;
        }
        B(cVar);
        q(cArr, i10, i11);
    }

    @Override // U9.i
    public void e(char[] cArr, int i10, int i11) {
        this.f3922C = w(cArr, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // U9.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(char[] r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = new java.lang.String
            r0.<init>(r5, r6, r7)
            java.lang.String[] r5 = F(r0)
            int r6 = r5.length
            r7 = 0
            if (r6 <= 0) goto L52
            r6 = 0
            r6 = r5[r6]
            java.lang.String r0 = "DOCTYPE"
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 == 0) goto L52
            boolean r6 = r4.f3945u
            if (r6 == 0) goto L1d
            return
        L1d:
            r6 = 1
            r4.f3945u = r6
            int r0 = r5.length
            if (r0 <= r6) goto L52
            r6 = r5[r6]
            int r0 = r5.length
            r1 = 2
            r2 = 3
            if (r0 <= r2) goto L37
            java.lang.String r0 = "SYSTEM"
            r3 = r5[r1]
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L37
            r5 = r5[r2]
            goto L54
        L37:
            int r0 = r5.length
            if (r0 <= r2) goto L50
            java.lang.String r0 = "PUBLIC"
            r1 = r5[r1]
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L50
            r7 = r5[r2]
            int r0 = r5.length
            r1 = 4
            if (r0 <= r1) goto L4d
            r5 = r5[r1]
            goto L54
        L4d:
            java.lang.String r5 = ""
            goto L54
        L50:
            r5 = r7
            goto L54
        L52:
            r5 = r7
            r6 = r5
        L54:
            java.lang.String r7 = G(r7)
            java.lang.String r5 = G(r5)
            if (r6 == 0) goto L90
            java.lang.String r7 = r4.p(r7)
            org.xml.sax.ext.LexicalHandler r0 = r4.f3926b
            r0.startDTD(r6, r7, r5)
            org.xml.sax.ext.LexicalHandler r0 = r4.f3926b
            r0.endDTD()
            r4.f3948x = r6
            r4.f3946v = r7
            U9.j r6 = r4.f3931g
            boolean r7 = r6 instanceof org.xml.sax.Locator
            if (r7 == 0) goto L90
            org.xml.sax.Locator r6 = (org.xml.sax.Locator) r6
            java.lang.String r6 = r6.getSystemId()
            r4.f3947w = r6
            java.net.URL r6 = new java.net.URL     // Catch: java.lang.Exception -> L90
            java.net.URL r7 = new java.net.URL     // Catch: java.lang.Exception -> L90
            java.lang.String r0 = r4.f3947w     // Catch: java.lang.Exception -> L90
            r7.<init>(r0)     // Catch: java.lang.Exception -> L90
            r6.<init>(r7, r5)     // Catch: java.lang.Exception -> L90
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Exception -> L90
            r4.f3947w = r5     // Catch: java.lang.Exception -> L90
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: U9.h.f(char[], int, int):void");
    }

    @Override // U9.i
    public void g(char[] cArr, int i10, int i11) {
        if (this.f3923D) {
            B(this.f3921B);
        }
        while (this.f3950z.k() != null) {
            y();
        }
        if (!this.f3930f.g().equals("")) {
            this.f3925a.endPrefixMapping(this.f3930f.f());
        }
        this.f3925a.endDocument();
    }

    @Override // org.xml.sax.XMLReader
    public ContentHandler getContentHandler() {
        ContentHandler contentHandler = this.f3925a;
        if (contentHandler == this) {
            return null;
        }
        return contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public DTDHandler getDTDHandler() {
        DTDHandler dTDHandler = this.f3927c;
        if (dTDHandler == this) {
            return null;
        }
        return dTDHandler;
    }

    @Override // org.xml.sax.XMLReader
    public EntityResolver getEntityResolver() {
        EntityResolver entityResolver = this.f3929e;
        if (entityResolver == this) {
            return null;
        }
        return entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public ErrorHandler getErrorHandler() {
        ErrorHandler errorHandler = this.f3928d;
        if (errorHandler == this) {
            return null;
        }
        return errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public boolean getFeature(String str) {
        Boolean bool = (Boolean) this.f3942r.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unknown feature ");
        stringBuffer.append(str);
        throw new SAXNotRecognizedException(stringBuffer.toString());
    }

    @Override // org.xml.sax.XMLReader
    public Object getProperty(String str) {
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            LexicalHandler lexicalHandler = this.f3926b;
            if (lexicalHandler == this) {
                return null;
            }
            return lexicalHandler;
        }
        if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner")) {
            return this.f3931g;
        }
        if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema")) {
            return this.f3930f;
        }
        if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector")) {
            return this.f3932h;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unknown property ");
        stringBuffer.append(str);
        throw new SAXNotRecognizedException(stringBuffer.toString());
    }

    @Override // U9.i
    public void h(char[] cArr, int i10, int i11) {
        String str;
        if (this.f3943s != null || (str = this.f3949y) == null || "xml".equalsIgnoreCase(str)) {
            return;
        }
        if (i11 > 0 && cArr[i11 - 1] == '?') {
            i11--;
        }
        this.f3925a.processingInstruction(this.f3949y, new String(cArr, i10, i11));
        this.f3949y = null;
    }

    @Override // U9.i
    public void i(char[] cArr, int i10, int i11) {
        if (r(cArr, i10, i11)) {
            return;
        }
        q(cArr, i10, i11);
    }

    @Override // U9.i
    public void j(char[] cArr, int i10, int i11) {
        this.f3926b.comment(cArr, i10, i11);
    }

    @Override // U9.i
    public void k(char[] cArr, int i10, int i11) {
        if (this.f3943s == null) {
            return;
        }
        this.f3944t = x(cArr, i10, i11).toLowerCase();
    }

    @Override // U9.i
    public void l(char[] cArr, int i10, int i11) {
        c cVar = this.f3943s;
        if (cVar == null) {
            return;
        }
        B(cVar);
        if (this.f3950z.h() == 0) {
            q(cArr, i10, i11);
        }
    }

    @Override // U9.i
    public void m(char[] cArr, int i10, int i11) {
        String str;
        c cVar = this.f3943s;
        if (cVar != null && (str = this.f3944t) != null) {
            cVar.n(str, null, str);
            this.f3944t = null;
        }
    }

    @Override // U9.i
    public void n(char[] cArr, int i10, int i11) {
        if (this.f3943s != null && this.f3944t != null) {
            this.f3943s.n(this.f3944t, null, s(new String(cArr, i10, i11)));
            this.f3944t = null;
        }
    }

    @Override // U9.i
    public void o(char[] cArr, int i10, int i11) {
        String x10;
        int i12;
        if (this.f3943s != null || (x10 = x(cArr, i10, i11)) == null) {
            return;
        }
        d d10 = this.f3930f.d(x10);
        if (d10 == null) {
            if (this.f3934j) {
                return;
            }
            int i13 = -1;
            if (this.f3935k) {
                i12 = 0;
            } else {
                i12 = -1;
            }
            if (!this.f3936l) {
                i13 = Integer.MAX_VALUE;
            }
            this.f3930f.b(x10, i12, i13, 0);
            if (!this.f3936l) {
                k kVar = this.f3930f;
                kVar.h(x10, kVar.i().g());
            }
            d10 = this.f3930f.d(x10);
        }
        this.f3943s = new c(d10, this.f3937m);
    }

    public final String p(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z10 = true;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (f3919P.indexOf(charAt) != -1) {
                stringBuffer.append(charAt);
                z10 = false;
            } else if (!z10) {
                stringBuffer.append(' ');
                z10 = true;
            }
        }
        return stringBuffer.toString().trim();
    }

    @Override // org.xml.sax.XMLReader
    public void parse(InputSource inputSource) {
        E();
        Reader v10 = v(inputSource);
        this.f3925a.startDocument();
        this.f3931g.b(inputSource.getPublicId(), inputSource.getSystemId());
        j jVar = this.f3931g;
        if (jVar instanceof Locator) {
            this.f3925a.setDocumentLocator((Locator) jVar);
        }
        if (!this.f3930f.g().equals("")) {
            this.f3925a.startPrefixMapping(this.f3930f.f(), this.f3930f.g());
        }
        this.f3931g.a(v10, this);
    }

    public void q(char[] cArr, int i10, int i11) {
        String i12;
        this.f3943s = null;
        if (i11 != 0) {
            d d10 = this.f3930f.d(x(cArr, i10, i11));
            if (d10 == null) {
                return;
            } else {
                i12 = d10.g();
            }
        } else {
            i12 = this.f3950z.i();
        }
        c cVar = this.f3950z;
        boolean z10 = false;
        while (cVar != null && !cVar.i().equals(i12)) {
            if ((cVar.e() & 4) != 0) {
                z10 = true;
            }
            cVar = cVar.k();
        }
        if (cVar != null && cVar.k() != null && cVar.k().k() != null) {
            if (z10) {
                cVar.m();
            } else {
                while (this.f3950z != cVar) {
                    D();
                }
                y();
            }
            while (this.f3950z.f()) {
                y();
            }
            C(null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        r8.f3925a.characters(U9.h.f3918O, 0, 2);
        r8.f3925a.characters(r9, r10, r11);
        r8.f3925a.characters(U9.h.f3918O, 2, 1);
        r8.f3931g.startCDATA();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r1 == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean r(char[] r9, int r10, int r11) {
        /*
            r8 = this;
            U9.c r0 = r8.f3950z
            java.lang.String r0 = r0.i()
            boolean r1 = r8.f3941q
            r2 = 0
            if (r1 == 0) goto L55
            U9.c r1 = r8.f3950z
            int r1 = r1.e()
            r3 = 2
            r1 = r1 & r3
            if (r1 == 0) goto L55
            int r1 = r0.length()
            r4 = 1
            if (r11 != r1) goto L1e
            r1 = r4
            goto L1f
        L1e:
            r1 = r2
        L1f:
            if (r1 == 0) goto L3a
            r5 = r2
        L22:
            if (r5 >= r11) goto L3a
            int r6 = r10 + r5
            char r6 = r9[r6]
            char r6 = java.lang.Character.toLowerCase(r6)
            char r7 = r0.charAt(r5)
            char r7 = java.lang.Character.toLowerCase(r7)
            if (r6 == r7) goto L37
            goto L3c
        L37:
            int r5 = r5 + 1
            goto L22
        L3a:
            if (r1 != 0) goto L55
        L3c:
            org.xml.sax.ContentHandler r0 = r8.f3925a
            char[] r1 = U9.h.f3918O
            r0.characters(r1, r2, r3)
            org.xml.sax.ContentHandler r0 = r8.f3925a
            r0.characters(r9, r10, r11)
            org.xml.sax.ContentHandler r9 = r8.f3925a
            char[] r10 = U9.h.f3918O
            r9.characters(r10, r3, r4)
            U9.j r8 = r8.f3931g
            r8.startCDATA()
            return r4
        L55:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: U9.h.r(char[], int, int):boolean");
    }

    public final String s(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i10 = -1;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            int i13 = i11 + 1;
            cArr[i11] = charAt;
            if (charAt == '&' && i10 == -1) {
                i11 = i13;
                i10 = i11;
            } else {
                if (i10 != -1 && !Character.isLetter(charAt) && !Character.isDigit(charAt) && charAt != '#') {
                    if (charAt == ';') {
                        int w10 = w(cArr, i10, (i13 - i10) - 1);
                        if (w10 > 65535) {
                            int i14 = w10 - 65536;
                            cArr[i10 - 1] = (char) ((i14 >> 10) + 55296);
                            cArr[i10] = (char) ((i14 & 1023) + 56320);
                            i10++;
                        } else if (w10 != 0) {
                            cArr[i10 - 1] = (char) w10;
                        } else {
                            i10 = i13;
                        }
                        i11 = i10;
                        i10 = -1;
                    } else {
                        i10 = -1;
                    }
                }
                i11 = i13;
            }
        }
        return new String(cArr, 0, i11);
    }

    @Override // org.xml.sax.XMLReader
    public void setContentHandler(ContentHandler contentHandler) {
        if (contentHandler == null) {
            contentHandler = this;
        }
        this.f3925a = contentHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setDTDHandler(DTDHandler dTDHandler) {
        if (dTDHandler == null) {
            dTDHandler = this;
        }
        this.f3927c = dTDHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setEntityResolver(EntityResolver entityResolver) {
        if (entityResolver == null) {
            entityResolver = this;
        }
        this.f3929e = entityResolver;
    }

    @Override // org.xml.sax.XMLReader
    public void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            errorHandler = this;
        }
        this.f3928d = errorHandler;
    }

    @Override // org.xml.sax.XMLReader
    public void setFeature(String str, boolean z10) {
        if (((Boolean) this.f3942r.get(str)) != null) {
            if (z10) {
                this.f3942r.put(str, Boolean.TRUE);
            } else {
                this.f3942r.put(str, Boolean.FALSE);
            }
            if (str.equals("http://xml.org/sax/features/namespaces")) {
                this.f3933i = z10;
                return;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/ignore-bogons")) {
                this.f3934j = z10;
                return;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/bogons-empty")) {
                this.f3935k = z10;
                return;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/root-bogons")) {
                this.f3936l = z10;
                return;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/default-attributes")) {
                this.f3937m = z10;
                return;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/translate-colons")) {
                this.f3938n = z10;
                return;
            }
            if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/restart-elements")) {
                this.f3939o = z10;
                return;
            } else if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/ignorable-whitespace")) {
                this.f3940p = z10;
                return;
            } else {
                if (str.equals("http://www.ccil.org/~cowan/tagsoup/features/cdata-elements")) {
                    this.f3941q = z10;
                    return;
                }
                return;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unknown feature ");
        stringBuffer.append(str);
        throw new SAXNotRecognizedException(stringBuffer.toString());
    }

    @Override // org.xml.sax.XMLReader
    public void setProperty(String str, Object obj) {
        if (str.equals("http://xml.org/sax/properties/lexical-handler")) {
            if (obj == null) {
                this.f3926b = this;
                return;
            } else {
                if (obj instanceof LexicalHandler) {
                    this.f3926b = (LexicalHandler) obj;
                    return;
                }
                throw new SAXNotSupportedException("Your lexical handler is not a LexicalHandler");
            }
        }
        if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/scanner")) {
            if (obj instanceof j) {
                this.f3931g = (j) obj;
                return;
            }
            throw new SAXNotSupportedException("Your scanner is not a Scanner");
        }
        if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/schema")) {
            if (obj instanceof k) {
                this.f3930f = (k) obj;
                return;
            }
            throw new SAXNotSupportedException("Your schema is not a Schema");
        }
        if (str.equals("http://www.ccil.org/~cowan/tagsoup/properties/auto-detector")) {
            if (obj instanceof b) {
                this.f3932h = (b) obj;
                return;
            }
            throw new SAXNotSupportedException("Your auto-detector is not an AutoDetector");
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unknown property ");
        stringBuffer.append(str);
        throw new SAXNotRecognizedException(stringBuffer.toString());
    }

    public final boolean t(String str, String str2) {
        if (!str.equals("") && !str2.equals("") && !str2.equals(this.f3930f.g())) {
            return true;
        }
        return false;
    }

    public final InputStream u(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(System.getProperty("user.dir"));
        stringBuffer.append("/.");
        return new URL(new URL("file", "", stringBuffer.toString()), str2).openConnection().getInputStream();
    }

    public final Reader v(InputSource inputSource) {
        Reader characterStream = inputSource.getCharacterStream();
        InputStream byteStream = inputSource.getByteStream();
        String encoding = inputSource.getEncoding();
        String publicId = inputSource.getPublicId();
        String systemId = inputSource.getSystemId();
        if (characterStream == null) {
            if (byteStream == null) {
                byteStream = u(publicId, systemId);
            }
            if (encoding == null) {
                return this.f3932h.a(byteStream);
            }
            try {
                return new InputStreamReader(byteStream, encoding);
            } catch (UnsupportedEncodingException unused) {
                return new InputStreamReader(byteStream);
            }
        }
        return characterStream;
    }

    public final int w(char[] cArr, int i10, int i11) {
        char c10;
        if (i11 < 1) {
            return 0;
        }
        if (cArr[i10] == '#') {
            if (i11 > 1 && ((c10 = cArr[i10 + 1]) == 'x' || c10 == 'X')) {
                try {
                    return Integer.parseInt(new String(cArr, i10 + 2, i11 - 2), 16);
                } catch (NumberFormatException unused) {
                    return 0;
                }
            }
            try {
                return Integer.parseInt(new String(cArr, i10 + 1, i11 - 1), 10);
            } catch (NumberFormatException unused2) {
                return 0;
            }
        }
        return this.f3930f.e(new String(cArr, i10, i11));
    }

    public final String x(char[] cArr, int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer(i11 + 2);
        boolean z10 = false;
        boolean z11 = true;
        while (true) {
            int i12 = i11 - 1;
            char c10 = '_';
            if (i11 <= 0) {
                break;
            }
            char c11 = cArr[i10];
            if (!Character.isLetter(c11) && c11 != '_') {
                if (!Character.isDigit(c11) && c11 != '-' && c11 != '.') {
                    if (c11 == ':' && !z10) {
                        if (z11) {
                            stringBuffer.append('_');
                        }
                        if (!this.f3938n) {
                            c10 = c11;
                        }
                        stringBuffer.append(c10);
                        z11 = true;
                        z10 = true;
                    }
                    i10++;
                    i11 = i12;
                } else {
                    if (z11) {
                        stringBuffer.append('_');
                    }
                    stringBuffer.append(c11);
                }
            } else {
                stringBuffer.append(c11);
            }
            z11 = false;
            i10++;
            i11 = i12;
        }
        int length = stringBuffer.length();
        if (length == 0 || stringBuffer.charAt(length - 1) == ':') {
            stringBuffer.append('_');
        }
        return stringBuffer.toString().intern();
    }

    public final void y() {
        c cVar = this.f3950z;
        if (cVar == null) {
            return;
        }
        String i10 = cVar.i();
        String g10 = this.f3950z.g();
        String j10 = this.f3950z.j();
        String z10 = z(i10);
        if (!this.f3933i) {
            g10 = "";
            j10 = "";
        }
        this.f3925a.endElement(j10, g10, i10);
        if (t(z10, j10)) {
            this.f3925a.endPrefixMapping(z10);
        }
        a b10 = this.f3950z.b();
        for (int length = b10.getLength() - 1; length >= 0; length--) {
            String uri = b10.getURI(length);
            String z11 = z(b10.getQName(length));
            if (t(z11, uri)) {
                this.f3925a.endPrefixMapping(z11);
            }
        }
        this.f3950z = this.f3950z.k();
    }

    public final String z(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        return "";
    }

    @Override // org.xml.sax.XMLReader
    public void parse(String str) {
        parse(new InputSource(str));
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i10, int i11) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) {
    }
}
