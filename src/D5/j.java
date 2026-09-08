package d5;

/* compiled from: AbstractExpandedDecoder.java */
/* loaded from: classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final S4.a f30038a;

    /* renamed from: b, reason: collision with root package name */
    public final r f30039b;

    public j(S4.a aVar) {
        this.f30038a = aVar;
        this.f30039b = new r(aVar);
    }

    public static j a(S4.a aVar) {
        if (aVar.g(1)) {
            return new g(aVar);
        }
        if (!aVar.g(2)) {
            return new k(aVar);
        }
        int g10 = r.g(aVar, 1, 4);
        if (g10 != 4) {
            if (g10 != 5) {
                int g11 = r.g(aVar, 1, 5);
                if (g11 != 12) {
                    if (g11 != 13) {
                        switch (r.g(aVar, 1, 7)) {
                            case 56:
                                return new e(aVar, "310", "11");
                            case 57:
                                return new e(aVar, "320", "11");
                            case 58:
                                return new e(aVar, "310", "13");
                            case 59:
                                return new e(aVar, "320", "13");
                            case 60:
                                return new e(aVar, "310", "15");
                            case 61:
                                return new e(aVar, "320", "15");
                            case 62:
                                return new e(aVar, "310", "17");
                            case 63:
                                return new e(aVar, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(aVar)));
                        }
                    }
                    return new d(aVar);
                }
                return new c(aVar);
            }
            return new b(aVar);
        }
        return new C0954a(aVar);
    }

    public final r b() {
        return this.f30039b;
    }

    public final S4.a c() {
        return this.f30038a;
    }

    public abstract String d();
}
