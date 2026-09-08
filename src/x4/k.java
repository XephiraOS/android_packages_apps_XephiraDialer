package x4;

/* compiled from: OffsetEdgeTreatment.java */
/* loaded from: classes3.dex */
public final class k extends g {

    /* renamed from: a, reason: collision with root package name */
    public final g f37918a;

    /* renamed from: b, reason: collision with root package name */
    public final float f37919b;

    public k(g gVar, float f10) {
        this.f37918a = gVar;
        this.f37919b = f10;
    }

    @Override // x4.g
    public boolean a() {
        return this.f37918a.a();
    }

    @Override // x4.g
    public void b(float f10, float f11, float f12, p pVar) {
        this.f37918a.b(f10, f11 - this.f37919b, f12, pVar);
    }
}
