package I;

/* compiled from: Pools.kt */
/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1297a;

    /* renamed from: b, reason: collision with root package name */
    public int f1298b;

    public f(int i10) {
        if (i10 > 0) {
            this.f1297a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0".toString());
    }

    @Override // I.e
    public boolean a(T instance) {
        kotlin.jvm.internal.i.f(instance, "instance");
        if (!c(instance)) {
            int i10 = this.f1298b;
            Object[] objArr = this.f1297a;
            if (i10 < objArr.length) {
                objArr[i10] = instance;
                this.f1298b = i10 + 1;
                return true;
            }
            return false;
        }
        throw new IllegalStateException("Already in the pool!".toString());
    }

    @Override // I.e
    public T b() {
        int i10 = this.f1298b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        T t10 = (T) this.f1297a[i11];
        kotlin.jvm.internal.i.d(t10, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f1297a[i11] = null;
        this.f1298b--;
        return t10;
    }

    public final boolean c(T t10) {
        int i10 = this.f1298b;
        for (int i11 = 0; i11 < i10; i11++) {
            if (this.f1297a[i11] == t10) {
                return true;
            }
        }
        return false;
    }
}
