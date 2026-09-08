package m6;

/* compiled from: ScaleXY.java */
/* renamed from: m6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1338d {

    /* renamed from: a, reason: collision with root package name */
    public float f35170a;

    /* renamed from: b, reason: collision with root package name */
    public float f35171b;

    public C1338d(float f10, float f11) {
        this.f35170a = f10;
        this.f35171b = f11;
    }

    public boolean a(float f10, float f11) {
        if (this.f35170a == f10 && this.f35171b == f11) {
            return true;
        }
        return false;
    }

    public float b() {
        return this.f35170a;
    }

    public float c() {
        return this.f35171b;
    }

    public void d(float f10, float f11) {
        this.f35170a = f10;
        this.f35171b = f11;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public C1338d() {
        this(1.0f, 1.0f);
    }
}
