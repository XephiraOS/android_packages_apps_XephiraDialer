package androidx.room;

/* compiled from: EntityDeletionOrUpdateAdapter.java */
/* loaded from: classes.dex */
public abstract class o<T> extends B {
    public o(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void g(e0.k kVar, T t10);

    public final int h(T t10) {
        e0.k a10 = a();
        try {
            g(a10, t10);
            return a10.p();
        } finally {
            f(a10);
        }
    }
}
