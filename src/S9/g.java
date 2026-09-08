package S9;

/* compiled from: Event.java */
/* loaded from: classes4.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final g f3618b = new g("Body part ended prematurely. Boundary detected in header or EOF reached.");

    /* renamed from: c, reason: collision with root package name */
    public static final g f3619c = new g("Unexpected end of headers detected. Higher level boundary detected or EOF reached.");

    /* renamed from: d, reason: collision with root package name */
    public static final g f3620d = new g("Invalid header encountered");

    /* renamed from: e, reason: collision with root package name */
    public static final g f3621e = new g("Obsolete header encountered");

    /* renamed from: a, reason: collision with root package name */
    public final String f3622a;

    public g(String str) {
        if (str != null) {
            this.f3622a = str;
            return;
        }
        throw new IllegalArgumentException("Code may not be null");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f3622a.equals(((g) obj).f3622a);
    }

    public int hashCode() {
        return this.f3622a.hashCode();
    }

    public String toString() {
        return this.f3622a;
    }
}
