package e6;

/* compiled from: MutablePair.java */
/* loaded from: classes3.dex */
public class h<T> {

    /* renamed from: a, reason: collision with root package name */
    public T f31651a;

    /* renamed from: b, reason: collision with root package name */
    public T f31652b;

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public void b(T t10, T t11) {
        this.f31651a = t10;
        this.f31652b = t11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof I.d)) {
            return false;
        }
        I.d dVar = (I.d) obj;
        if (!a(dVar.f1295a, this.f31651a) || !a(dVar.f1296b, this.f31652b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        T t10 = this.f31651a;
        int i10 = 0;
        if (t10 == null) {
            hashCode = 0;
        } else {
            hashCode = t10.hashCode();
        }
        T t11 = this.f31652b;
        if (t11 != null) {
            i10 = t11.hashCode();
        }
        return hashCode ^ i10;
    }

    public String toString() {
        return "Pair{" + this.f31651a + " " + this.f31652b + "}";
    }
}
