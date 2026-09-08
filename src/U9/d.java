package U9;

/* compiled from: ElementType.java */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f3883a;

    /* renamed from: b, reason: collision with root package name */
    public String f3884b;

    /* renamed from: c, reason: collision with root package name */
    public String f3885c;

    /* renamed from: d, reason: collision with root package name */
    public int f3886d;

    /* renamed from: e, reason: collision with root package name */
    public int f3887e;

    /* renamed from: f, reason: collision with root package name */
    public int f3888f;

    /* renamed from: g, reason: collision with root package name */
    public a f3889g = new a();

    /* renamed from: h, reason: collision with root package name */
    public d f3890h;

    /* renamed from: i, reason: collision with root package name */
    public k f3891i;

    public d(String str, int i10, int i11, int i12, k kVar) {
        this.f3883a = str;
        this.f3886d = i10;
        this.f3887e = i11;
        this.f3888f = i12;
        this.f3891i = kVar;
        this.f3884b = i(str, false);
        this.f3885c = e(str);
    }

    public static String j(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        if (trim.indexOf("  ") == -1) {
            return trim;
        }
        int length = trim.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = trim.charAt(i10);
            if (charAt == ' ') {
                if (!z10) {
                    stringBuffer.append(charAt);
                }
                z10 = true;
            } else {
                stringBuffer.append(charAt);
                z10 = false;
            }
        }
        return stringBuffer.toString();
    }

    public a a() {
        return this.f3889g;
    }

    public boolean b(d dVar) {
        if ((this.f3886d & dVar.f3887e) != 0) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.f3888f;
    }

    public String d() {
        return this.f3885c;
    }

    public String e(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(indexOf + 1).intern();
    }

    public int f() {
        return this.f3886d;
    }

    public String g() {
        return this.f3883a;
    }

    public String h() {
        return this.f3884b;
    }

    public String i(String str, boolean z10) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            if (z10) {
                return "";
            }
            return this.f3891i.g();
        }
        String substring = str.substring(0, indexOf);
        if (substring.equals("xml")) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("urn:x-prefix:");
        stringBuffer.append(substring);
        return stringBuffer.toString().intern();
    }

    public d k() {
        return this.f3890h;
    }

    public void l(a aVar, String str, String str2, String str3) {
        String str4;
        if (!str.equals("xmlns") && !str.startsWith("xmlns:")) {
            String i10 = i(str, true);
            String e10 = e(str);
            int index = aVar.getIndex(str);
            if (index == -1) {
                String intern = str.intern();
                if (str2 == null) {
                    str4 = "CDATA";
                } else {
                    str4 = str2;
                }
                if (!str4.equals("CDATA")) {
                    str3 = j(str3);
                }
                aVar.a(i10, e10, intern, str4, str3);
                return;
            }
            if (str2 == null) {
                str2 = aVar.getType(index);
            }
            String str5 = str2;
            if (!str5.equals("CDATA")) {
                str3 = j(str3);
            }
            aVar.f(index, i10, e10, str, str5, str3);
        }
    }

    public void m(String str, String str2, String str3) {
        l(this.f3889g, str, str2, str3);
    }

    public void n(d dVar) {
        this.f3890h = dVar;
    }
}
