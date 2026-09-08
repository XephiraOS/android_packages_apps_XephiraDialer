package I;

/* compiled from: Pools.kt */
/* loaded from: classes.dex */
public class g<T> extends f<T> {

    /* renamed from: c, reason: collision with root package name */
    public final Object f1299c;

    public g(int i10) {
        super(i10);
        this.f1299c = new Object();
    }

    @Override // I.f, I.e
    public boolean a(T instance) {
        boolean a10;
        kotlin.jvm.internal.i.f(instance, "instance");
        synchronized (this.f1299c) {
            a10 = super.a(instance);
        }
        return a10;
    }

    @Override // I.f, I.e
    public T b() {
        T t10;
        synchronized (this.f1299c) {
            t10 = (T) super.b();
        }
        return t10;
    }
}
