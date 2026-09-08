package c4;

/* compiled from: SpringConfig.java */
/* loaded from: classes3.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    public static h f12775c = b(40.0d, 7.0d);

    /* renamed from: a, reason: collision with root package name */
    public double f12776a;

    /* renamed from: b, reason: collision with root package name */
    public double f12777b;

    public h(double d10, double d11) {
        this.f12777b = d10;
        this.f12776a = d11;
    }

    public static h a(double d10, double d11) {
        c cVar = new c(d11, d10);
        return b(cVar.f(), cVar.e());
    }

    public static h b(double d10, double d11) {
        return new h(e.d(d10), e.a(d11));
    }
}
