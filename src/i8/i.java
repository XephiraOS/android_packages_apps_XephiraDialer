package i8;

/* compiled from: FloatPropertyHolder.java */
/* loaded from: classes3.dex */
public abstract class i<T> {

    /* renamed from: b, reason: collision with root package name */
    public String f32235b;

    /* renamed from: c, reason: collision with root package name */
    public float f32236c;

    /* renamed from: d, reason: collision with root package name */
    public float f32237d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f32238e = false;

    /* renamed from: a, reason: collision with root package name */
    public int f32234a = 0;

    public i(String str, float f10) {
        this.f32235b = str;
        this.f32236c = f10;
    }

    public abstract float a(T t10);

    public abstract void b(T t10, float f10);

    public i c(float f10) {
        this.f32237d = f10;
        this.f32238e = true;
        return this;
    }

    public void d(T t10, float f10) {
        b(t10, f10 * this.f32236c);
    }

    public void f(T t10) {
        if (!this.f32238e) {
            this.f32237d = a(t10);
        }
    }

    public void e(T t10) {
    }
}
