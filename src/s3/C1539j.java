package s3;

/* compiled from: MultiClassKey.java */
/* renamed from: s3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1539j {

    /* renamed from: a, reason: collision with root package name */
    public Class<?> f36772a;

    /* renamed from: b, reason: collision with root package name */
    public Class<?> f36773b;

    /* renamed from: c, reason: collision with root package name */
    public Class<?> f36774c;

    public C1539j() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f36772a = cls;
        this.f36773b = cls2;
        this.f36774c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1539j c1539j = (C1539j) obj;
        if (this.f36772a.equals(c1539j.f36772a) && this.f36773b.equals(c1539j.f36773b) && C1541l.d(this.f36774c, c1539j.f36774c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int hashCode = ((this.f36772a.hashCode() * 31) + this.f36773b.hashCode()) * 31;
        Class<?> cls = this.f36774c;
        if (cls != null) {
            i10 = cls.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode + i10;
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f36772a + ", second=" + this.f36773b + '}';
    }

    public C1539j(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
