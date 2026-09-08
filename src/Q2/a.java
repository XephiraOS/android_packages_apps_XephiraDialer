package Q2;

/* compiled from: Singleton.kt */
/* loaded from: classes.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public T f3121a;

    public abstract T a();

    public T b() {
        T t10;
        synchronized (this) {
            try {
                if (this.f3121a == null) {
                    this.f3121a = a();
                }
                t10 = this.f3121a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return t10;
    }

    public final T c() {
        return this.f3121a;
    }
}
