package S9;

/* compiled from: MimeConfig.java */
/* loaded from: classes4.dex */
public final class k implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3632a = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3637f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3639h = false;

    /* renamed from: b, reason: collision with root package name */
    public int f3633b = 1000;

    /* renamed from: c, reason: collision with root package name */
    public int f3634c = 1000;

    /* renamed from: d, reason: collision with root package name */
    public int f3635d = 10000;

    /* renamed from: e, reason: collision with root package name */
    public long f3636e = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f3638g = null;

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public k clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public String b() {
        return this.f3638g;
    }

    public long c() {
        return this.f3636e;
    }

    public int d() {
        return this.f3634c;
    }

    public int e() {
        return this.f3635d;
    }

    public int f() {
        return this.f3633b;
    }

    public boolean g() {
        return this.f3637f;
    }

    public boolean h() {
        return this.f3639h;
    }

    public boolean i() {
        return this.f3632a;
    }

    public String toString() {
        return "[strict parsing: " + this.f3632a + ", max line length: " + this.f3633b + ", max header count: " + this.f3634c + ", max content length: " + this.f3636e + ", count line numbers: " + this.f3637f + "]";
    }
}
