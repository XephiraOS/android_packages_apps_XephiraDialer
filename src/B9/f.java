package B9;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes4.dex */
public final class f extends d {

    /* renamed from: e, reason: collision with root package name */
    public static final a f304e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final f f305f = new f(1, 0);

    /* compiled from: PrimitiveRanges.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public final f a() {
            return f.f305f;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public f(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // B9.d
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!isEmpty() || !((f) obj).isEmpty()) {
                f fVar = (f) obj;
                if (a() != fVar.a() || c() != fVar.c()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // B9.d
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return c() + (a() * 31);
    }

    public boolean i(int i10) {
        if (a() <= i10 && i10 <= c()) {
            return true;
        }
        return false;
    }

    @Override // B9.d
    public boolean isEmpty() {
        if (a() > c()) {
            return true;
        }
        return false;
    }

    public Integer j() {
        return Integer.valueOf(c());
    }

    public Integer k() {
        return Integer.valueOf(a());
    }

    @Override // B9.d
    public String toString() {
        return a() + ".." + c();
    }
}
