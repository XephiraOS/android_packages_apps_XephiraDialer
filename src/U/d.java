package u;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class d<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f37297a;

    /* renamed from: b, reason: collision with root package name */
    public int f37298b;

    public d(int i10) {
        if (i10 > 0) {
            this.f37297a = new Object[i10];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    @Override // u.c
    public boolean a(T t10) {
        int i10 = this.f37298b;
        Object[] objArr = this.f37297a;
        if (i10 < objArr.length) {
            objArr[i10] = t10;
            this.f37298b = i10 + 1;
            return true;
        }
        return false;
    }

    @Override // u.c
    public T b() {
        int i10 = this.f37298b;
        if (i10 <= 0) {
            return null;
        }
        int i11 = i10 - 1;
        Object[] objArr = this.f37297a;
        T t10 = (T) objArr[i11];
        objArr[i11] = null;
        this.f37298b = i10 - 1;
        return t10;
    }

    @Override // u.c
    public void c(T[] tArr, int i10) {
        if (i10 > tArr.length) {
            i10 = tArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            T t10 = tArr[i11];
            int i12 = this.f37298b;
            Object[] objArr = this.f37297a;
            if (i12 < objArr.length) {
                objArr[i12] = t10;
                this.f37298b = i12 + 1;
            }
        }
    }
}
