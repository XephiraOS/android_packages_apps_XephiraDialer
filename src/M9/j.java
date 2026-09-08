package m9;

/* compiled from: UInt.kt */
/* loaded from: classes4.dex */
public final class j implements Comparable<j> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f35495b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f35496a;

    /* compiled from: UInt.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public /* synthetic */ j(int i10) {
        this.f35496a = i10;
    }

    public static final /* synthetic */ j a(int i10) {
        return new j(i10);
    }

    public static boolean c(int i10, Object obj) {
        if (!(obj instanceof j) || i10 != ((j) obj).f()) {
            return false;
        }
        return true;
    }

    public static int d(int i10) {
        return Integer.hashCode(i10);
    }

    public static String e(int i10) {
        return String.valueOf(i10 & 4294967295L);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(j jVar) {
        return r.a(f(), jVar.f());
    }

    public boolean equals(Object obj) {
        return c(this.f35496a, obj);
    }

    public final /* synthetic */ int f() {
        return this.f35496a;
    }

    public int hashCode() {
        return d(this.f35496a);
    }

    public String toString() {
        return e(this.f35496a);
    }

    public static int b(int i10) {
        return i10;
    }
}
