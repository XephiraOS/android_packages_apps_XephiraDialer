package x4;

/* compiled from: MarkerEdgeTreatment.java */
/* loaded from: classes3.dex */
public final class h extends g {

    /* renamed from: a, reason: collision with root package name */
    public final float f37892a;

    public h(float f10) {
        this.f37892a = f10 - 0.001f;
    }

    @Override // x4.g
    public boolean a() {
        return true;
    }

    @Override // x4.g
    public void b(float f10, float f11, float f12, p pVar) {
        float sqrt = (float) ((this.f37892a * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.f37892a, 2.0d) - Math.pow(sqrt, 2.0d));
        pVar.n(f11 - sqrt, ((float) (-((this.f37892a * Math.sqrt(2.0d)) - this.f37892a))) + sqrt2);
        pVar.m(f11, (float) (-((this.f37892a * Math.sqrt(2.0d)) - this.f37892a)));
        pVar.m(f11 + sqrt, ((float) (-((this.f37892a * Math.sqrt(2.0d)) - this.f37892a))) + sqrt2);
    }
}
