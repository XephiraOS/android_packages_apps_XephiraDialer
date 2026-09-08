package androidx.room;

/* compiled from: EntityInsertionAdapter.java */
/* loaded from: classes.dex */
public abstract class p<T> extends B {
    public p(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void g(e0.k kVar, T t10);

    public final void h(T t10) {
        e0.k a10 = a();
        try {
            g(a10, t10);
            a10.n0();
        } finally {
            f(a10);
        }
    }
}
