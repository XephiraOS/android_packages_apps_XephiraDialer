package m9;

/* compiled from: ULong.kt */
/* loaded from: classes4.dex */
public final class l implements Comparable<l> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f35500b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f35501a;

    /* compiled from: ULong.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public /* synthetic */ l(long j10) {
        this.f35501a = j10;
    }

    public static final /* synthetic */ l a(long j10) {
        return new l(j10);
    }

    public static boolean c(long j10, Object obj) {
        if (!(obj instanceof l) || j10 != ((l) obj).f()) {
            return false;
        }
        return true;
    }

    public static int d(long j10) {
        return Long.hashCode(j10);
    }

    public static String e(long j10) {
        return r.c(j10);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(l lVar) {
        return r.b(f(), lVar.f());
    }

    public boolean equals(Object obj) {
        return c(this.f35501a, obj);
    }

    public final /* synthetic */ long f() {
        return this.f35501a;
    }

    public int hashCode() {
        return d(this.f35501a);
    }

    public String toString() {
        return e(this.f35501a);
    }

    public static long b(long j10) {
        return j10;
    }
}
