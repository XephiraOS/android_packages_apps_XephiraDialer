package kotlinx.coroutines.channels;

/* compiled from: Channel.kt */
/* loaded from: classes4.dex */
public final class e<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final b f34409b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final c f34410c = new c();

    /* renamed from: a, reason: collision with root package name */
    public final Object f34411a;

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f34412a;

        public a(Throwable th) {
            this.f34412a = th;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof a) && kotlin.jvm.internal.i.b(this.f34412a, ((a) obj).f34412a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Throwable th = this.f34412a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.e.c
        public String toString() {
            return "Closed(" + this.f34412a + ')';
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static final class b {
        public b() {
        }

        public final <E> Object a(Throwable th) {
            return e.c(new a(th));
        }

        public final <E> Object b() {
            return e.c(e.f34410c);
        }

        public final <E> Object c(E e10) {
            return e.c(e10);
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes4.dex */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public /* synthetic */ e(Object obj) {
        this.f34411a = obj;
    }

    public static final /* synthetic */ e b(Object obj) {
        return new e(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        if (!(obj2 instanceof e) || !kotlin.jvm.internal.i.b(obj, ((e) obj2).j())) {
            return false;
        }
        return true;
    }

    public static final Throwable e(Object obj) {
        a aVar;
        if (obj instanceof a) {
            aVar = (a) obj;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.f34412a;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof a;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof c);
    }

    public static String i(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f34411a, obj);
    }

    public int hashCode() {
        return f(this.f34411a);
    }

    public final /* synthetic */ Object j() {
        return this.f34411a;
    }

    public String toString() {
        return i(this.f34411a);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }
}
