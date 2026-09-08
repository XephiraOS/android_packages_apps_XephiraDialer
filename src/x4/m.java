package x4;

/* compiled from: RoundedCornerTreatment.java */
/* loaded from: classes3.dex */
public class m extends e {

    /* renamed from: a, reason: collision with root package name */
    public float f37921a = -1.0f;

    @Override // x4.e
    public void a(p pVar, float f10, float f11, float f12) {
        pVar.o(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        float f13 = f12 * 2.0f * f11;
        pVar.a(0.0f, 0.0f, f13, f13, 180.0f, f10);
    }
}
