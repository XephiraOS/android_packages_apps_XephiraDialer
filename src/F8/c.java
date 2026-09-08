package f8;

/* compiled from: Mat22.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final e f31797a = new e();

    /* renamed from: b, reason: collision with root package name */
    public final e f31798b = new e();

    public static final void b(c cVar, e eVar, e eVar2) {
        e eVar3 = cVar.f31797a;
        float f10 = eVar3.f31799a * eVar.f31799a;
        e eVar4 = cVar.f31798b;
        float f11 = eVar4.f31799a;
        float f12 = eVar.f31800b;
        eVar2.f31799a = f10 + (f11 * f12);
        eVar2.f31800b = (eVar3.f31800b * eVar.f31799a) + (eVar4.f31800b * f12);
    }

    public final c a() {
        e eVar = this.f31797a;
        float f10 = eVar.f31799a;
        e eVar2 = this.f31798b;
        float f11 = eVar2.f31799a;
        float f12 = eVar.f31800b;
        float f13 = eVar2.f31800b;
        float f14 = (f10 * f13) - (f11 * f12);
        if (f14 != 0.0f) {
            f14 = 1.0f / f14;
        }
        eVar.f31799a = f13 * f14;
        float f15 = -f14;
        eVar2.f31799a = f11 * f15;
        eVar.f31800b = f15 * f12;
        eVar2.f31800b = f14 * f10;
        return this;
    }
}
