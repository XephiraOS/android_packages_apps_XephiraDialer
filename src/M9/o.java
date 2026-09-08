package m9;

/* compiled from: UShort.kt */
/* loaded from: classes4.dex */
public final class o implements Comparable<o> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f35506b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final short f35507a;

    /* compiled from: UShort.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public /* synthetic */ o(short s10) {
        this.f35507a = s10;
    }

    public static final /* synthetic */ o a(short s10) {
        return new o(s10);
    }

    public static boolean c(short s10, Object obj) {
        if (!(obj instanceof o) || s10 != ((o) obj).f()) {
            return false;
        }
        return true;
    }

    public static int d(short s10) {
        return Short.hashCode(s10);
    }

    public static String e(short s10) {
        return String.valueOf(s10 & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(o oVar) {
        return kotlin.jvm.internal.i.g(f() & 65535, oVar.f() & 65535);
    }

    public boolean equals(Object obj) {
        return c(this.f35507a, obj);
    }

    public final /* synthetic */ short f() {
        return this.f35507a;
    }

    public int hashCode() {
        return d(this.f35507a);
    }

    public String toString() {
        return e(this.f35507a);
    }

    public static short b(short s10) {
        return s10;
    }
}
