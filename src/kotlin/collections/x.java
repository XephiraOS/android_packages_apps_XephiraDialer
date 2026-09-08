package kotlin.collections;

/* compiled from: IndexedValue.kt */
/* loaded from: classes4.dex */
public final class x<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f34205a;

    /* renamed from: b, reason: collision with root package name */
    public final T f34206b;

    public x(int i10, T t10) {
        this.f34205a = i10;
        this.f34206b = t10;
    }

    public final int a() {
        return this.f34205a;
    }

    public final T b() {
        return this.f34206b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.f34205a == xVar.f34205a && kotlin.jvm.internal.i.b(this.f34206b, xVar.f34206b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Integer.hashCode(this.f34205a) * 31;
        T t10 = this.f34206b;
        if (t10 == null) {
            hashCode = 0;
        } else {
            hashCode = t10.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "IndexedValue(index=" + this.f34205a + ", value=" + this.f34206b + ')';
    }
}
