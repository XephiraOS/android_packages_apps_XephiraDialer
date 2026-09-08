package s3;

/* compiled from: GlideSuppliers.java */
/* renamed from: s3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1535f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: GlideSuppliers.java */
    /* renamed from: s3.f$a */
    /* loaded from: classes.dex */
    public class a<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        public volatile T f36762a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f36763b;

        public a(b bVar) {
            this.f36763b = bVar;
        }

        @Override // s3.C1535f.b
        public T get() {
            if (this.f36762a == null) {
                synchronized (this) {
                    try {
                        if (this.f36762a == null) {
                            this.f36762a = (T) C1540k.d(this.f36763b.get());
                        }
                    } finally {
                    }
                }
            }
            return this.f36762a;
        }
    }

    /* compiled from: GlideSuppliers.java */
    /* renamed from: s3.f$b */
    /* loaded from: classes.dex */
    public interface b<T> {
        T get();
    }

    public static <T> b<T> a(b<T> bVar) {
        return new a(bVar);
    }
}
