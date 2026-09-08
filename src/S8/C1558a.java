package s8;

/* compiled from: OTrackConfig.java */
/* renamed from: s8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1558a {

    /* renamed from: f, reason: collision with root package name */
    public static final C1558a f36870f = new C1558a();

    /* renamed from: a, reason: collision with root package name */
    public int f36871a;

    /* renamed from: b, reason: collision with root package name */
    public int f36872b;

    /* renamed from: c, reason: collision with root package name */
    public String f36873c;

    /* renamed from: d, reason: collision with root package name */
    public String f36874d;

    /* renamed from: e, reason: collision with root package name */
    public String f36875e;

    /* compiled from: OTrackConfig.java */
    /* renamed from: s8.a$b */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f36876a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f36877b;

        /* renamed from: c, reason: collision with root package name */
        public String f36878c;

        /* renamed from: d, reason: collision with root package name */
        public String f36879d;

        /* renamed from: e, reason: collision with root package name */
        public String f36880e;

        public C1558a f() {
            return new C1558a(this);
        }

        public b g(String str) {
            this.f36880e = str;
            return this;
        }

        public b h(String str) {
            this.f36878c = str;
            return this;
        }

        public b i(String str) {
            this.f36879d = str;
            return this;
        }
    }

    public String a() {
        return this.f36875e;
    }

    public int b() {
        return this.f36871a;
    }

    public int c() {
        return this.f36872b;
    }

    public String d() {
        return this.f36873c;
    }

    public String e() {
        return this.f36874d;
    }

    public void f(String str) {
        this.f36875e = str;
    }

    public void g(String str) {
        this.f36873c = str;
    }

    public void h(String str) {
        this.f36874d = str;
    }

    public C1558a() {
        this.f36873c = "";
        this.f36874d = "";
        this.f36875e = "";
    }

    public C1558a(b bVar) {
        this.f36873c = "";
        this.f36874d = "";
        this.f36875e = "";
        this.f36871a = bVar.f36876a;
        this.f36873c = bVar.f36878c;
        this.f36874d = bVar.f36879d;
        this.f36875e = bVar.f36880e;
        this.f36872b = bVar.f36877b;
    }
}
