package x4;

/* compiled from: CutCornerTreatment.java */
/* loaded from: classes3.dex */
public class f extends e {

    /* renamed from: a, reason: collision with root package name */
    public float f37891a = -1.0f;

    @Override // x4.e
    public void a(p pVar, float f10, float f11, float f12) {
        pVar.o(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        double d10 = f12;
        double d11 = f11;
        pVar.m((float) (Math.sin(Math.toRadians(f10)) * d10 * d11), (float) (Math.sin(Math.toRadians(90.0f - f10)) * d10 * d11));
    }
}
