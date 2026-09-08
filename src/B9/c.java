package B9;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes4.dex */
public final class c extends B9.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a f294e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final c f295f = new c(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public c(char c10, char c11) {
        super(c10, c11, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || c() != cVar.c()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean g(char c10) {
        if (kotlin.jvm.internal.i.g(a(), c10) <= 0 && kotlin.jvm.internal.i.g(c10, c()) <= 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return c() + (a() * 31);
    }

    public boolean isEmpty() {
        if (kotlin.jvm.internal.i.g(a(), c()) > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return a() + ".." + c();
    }
}
