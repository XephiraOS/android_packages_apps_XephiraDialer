package i8;

/* compiled from: UIItem.java */
/* loaded from: classes3.dex */
public class m<K> {

    /* renamed from: a, reason: collision with root package name */
    public float f32255a;

    /* renamed from: b, reason: collision with root package name */
    public float f32256b;

    /* renamed from: c, reason: collision with root package name */
    public K f32257c;

    /* renamed from: d, reason: collision with root package name */
    public final f8.e f32258d;

    /* renamed from: e, reason: collision with root package name */
    public final f8.e f32259e;

    /* renamed from: f, reason: collision with root package name */
    public final f8.e f32260f;

    /* renamed from: g, reason: collision with root package name */
    public final f8.e f32261g;

    /* renamed from: h, reason: collision with root package name */
    public final l f32262h;

    public m() {
        this(null);
    }

    public l a() {
        return this.f32262h;
    }

    public m b(float f10, float f11) {
        this.f32255a = f10;
        this.f32256b = f11;
        return this;
    }

    public m c(float f10, float f11) {
        this.f32259e.d(f10, f11);
        return this;
    }

    public m d(float f10, float f11) {
        this.f32260f.d(f10, f11);
        return this;
    }

    public void e(float f10, float f11) {
        this.f32261g.d(f10, f11);
    }

    public void f(float f10, float f11) {
        l lVar = this.f32262h;
        lVar.f32251a = f10;
        lVar.f32252b = f11;
    }

    public String toString() {
        return "UIItem{mTarget=" + this.f32257c + ", size=( " + this.f32255a + "," + this.f32256b + "), startPos =:" + this.f32259e + ", startVel =:" + this.f32261g + "}@" + hashCode();
    }

    public m(K k10) {
        this.f32255a = 0.0f;
        this.f32256b = 0.0f;
        this.f32258d = new f8.e();
        this.f32259e = new f8.e();
        this.f32260f = new f8.e(1.0f, 1.0f);
        this.f32261g = new f8.e();
        this.f32262h = new l();
        this.f32257c = k10;
    }
}
