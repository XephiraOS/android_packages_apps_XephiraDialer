package U9;

/* compiled from: Element.java */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public d f3879a;

    /* renamed from: b, reason: collision with root package name */
    public a f3880b;

    /* renamed from: c, reason: collision with root package name */
    public c f3881c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3882d;

    public c(d dVar, boolean z10) {
        this.f3879a = dVar;
        if (z10) {
            this.f3880b = new a(dVar.a());
        } else {
            this.f3880b = new a();
        }
        this.f3881c = null;
        this.f3882d = false;
    }

    public void a() {
        for (int length = this.f3880b.getLength() - 1; length >= 0; length--) {
            if (this.f3880b.getType(length).equals("ID") || this.f3880b.getQName(length).equals("name")) {
                this.f3880b.e(length);
            }
        }
    }

    public a b() {
        return this.f3880b;
    }

    public boolean c(c cVar) {
        return this.f3879a.b(cVar.f3879a);
    }

    public void d() {
        for (int length = this.f3880b.getLength() - 1; length >= 0; length--) {
            String localName = this.f3880b.getLocalName(length);
            if (this.f3880b.getValue(length) == null || localName == null || localName.length() == 0) {
                this.f3880b.e(length);
            }
        }
    }

    public int e() {
        return this.f3879a.c();
    }

    public boolean f() {
        return this.f3882d;
    }

    public String g() {
        return this.f3879a.d();
    }

    public int h() {
        return this.f3879a.f();
    }

    public String i() {
        return this.f3879a.g();
    }

    public String j() {
        return this.f3879a.h();
    }

    public c k() {
        return this.f3881c;
    }

    public d l() {
        return this.f3879a.k();
    }

    public void m() {
        this.f3882d = true;
    }

    public void n(String str, String str2, String str3) {
        this.f3879a.l(this.f3880b, str, str2, str3);
    }

    public void o(c cVar) {
        this.f3881c = cVar;
    }
}
