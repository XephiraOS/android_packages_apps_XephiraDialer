package t3;

/* compiled from: StateVerifier.java */
/* loaded from: classes.dex */
public abstract class c {

    /* compiled from: StateVerifier.java */
    /* loaded from: classes.dex */
    public static class b extends c {

        /* renamed from: a, reason: collision with root package name */
        public volatile boolean f37181a;

        public b() {
            super();
        }

        @Override // t3.c
        public void b(boolean z10) {
            this.f37181a = z10;
        }

        @Override // t3.c
        public void c() {
            if (!this.f37181a) {
            } else {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public c() {
    }

    public static c a() {
        return new b();
    }

    public abstract void b(boolean z10);

    public abstract void c();
}
