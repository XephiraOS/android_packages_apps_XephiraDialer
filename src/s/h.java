package s;

import t.q;

/* compiled from: VelocityMatrix.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public float f36616a;

    /* renamed from: b, reason: collision with root package name */
    public float f36617b;

    /* renamed from: c, reason: collision with root package name */
    public float f36618c;

    /* renamed from: d, reason: collision with root package name */
    public float f36619d;

    /* renamed from: e, reason: collision with root package name */
    public float f36620e;

    /* renamed from: f, reason: collision with root package name */
    public float f36621f;

    public void a(float f10, float f11, int i10, int i11, float[] fArr) {
        float f12 = fArr[0];
        float f13 = fArr[1];
        float f14 = (f11 - 0.5f) * 2.0f;
        float f15 = f12 + this.f36618c;
        float f16 = f13 + this.f36619d;
        float f17 = f15 + (this.f36616a * (f10 - 0.5f) * 2.0f);
        float f18 = f16 + (this.f36617b * f14);
        float radians = (float) Math.toRadians(this.f36621f);
        float radians2 = (float) Math.toRadians(this.f36620e);
        double d10 = radians;
        double d11 = i11 * f14;
        float sin = f17 + (((float) ((((-i10) * r7) * Math.sin(d10)) - (Math.cos(d10) * d11))) * radians2);
        float cos = f18 + (radians2 * ((float) (((i10 * r7) * Math.cos(d10)) - (d11 * Math.sin(d10)))));
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public void b() {
        this.f36620e = 0.0f;
        this.f36619d = 0.0f;
        this.f36618c = 0.0f;
        this.f36617b = 0.0f;
        this.f36616a = 0.0f;
    }

    public void c(t.g gVar, float f10) {
        if (gVar != null) {
            this.f36620e = gVar.b(f10);
        }
    }

    public void d(q qVar, float f10) {
        if (qVar != null) {
            this.f36620e = qVar.b(f10);
            this.f36621f = qVar.a(f10);
        }
    }

    public void e(t.g gVar, t.g gVar2, float f10) {
        if (gVar == null && gVar2 == null) {
            return;
        }
        if (gVar == null) {
            this.f36616a = gVar.b(f10);
        }
        if (gVar2 == null) {
            this.f36617b = gVar2.b(f10);
        }
    }

    public void f(q qVar, q qVar2, float f10) {
        if (qVar != null) {
            this.f36616a = qVar.b(f10);
        }
        if (qVar2 != null) {
            this.f36617b = qVar2.b(f10);
        }
    }

    public void g(t.g gVar, t.g gVar2, float f10) {
        if (gVar != null) {
            this.f36618c = gVar.b(f10);
        }
        if (gVar2 != null) {
            this.f36619d = gVar2.b(f10);
        }
    }

    public void h(q qVar, q qVar2, float f10) {
        if (qVar != null) {
            this.f36618c = qVar.b(f10);
        }
        if (qVar2 != null) {
            this.f36619d = qVar2.b(f10);
        }
    }
}
