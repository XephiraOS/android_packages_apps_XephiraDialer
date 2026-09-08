package f8;

/* compiled from: Vector.java */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public float f31799a;

    /* renamed from: b, reason: collision with root package name */
    public float f31800b;

    public e() {
        this(0.0f, 0.0f);
    }

    public final e a(e eVar) {
        this.f31799a += eVar.f31799a;
        this.f31800b += eVar.f31800b;
        return this;
    }

    public final e b(float f10) {
        this.f31799a *= f10;
        this.f31800b *= f10;
        return this;
    }

    public final e c() {
        this.f31799a = -this.f31799a;
        this.f31800b = -this.f31800b;
        return this;
    }

    public final e d(float f10, float f11) {
        this.f31799a = f10;
        this.f31800b = f11;
        return this;
    }

    public final e e(e eVar) {
        this.f31799a = eVar.f31799a;
        this.f31800b = eVar.f31800b;
        return this;
    }

    public final void f() {
        this.f31799a = 0.0f;
        this.f31800b = 0.0f;
    }

    public final e g(e eVar) {
        this.f31799a -= eVar.f31799a;
        this.f31800b -= eVar.f31800b;
        return this;
    }

    public final String toString() {
        return "(" + this.f31799a + "," + this.f31800b + ")";
    }

    public e(float f10, float f11) {
        this.f31799a = f10;
        this.f31800b = f11;
    }
}
