package X2;

import java.security.MessageDigest;
import p.C1415a;
import s3.C1531b;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: b, reason: collision with root package name */
    public final C1415a<c<?>, Object> f4283b = new C1531b();

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(c<T> cVar, Object obj, MessageDigest messageDigest) {
        cVar.g(obj, messageDigest);
    }

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        for (int i10 = 0; i10 < this.f4283b.size(); i10++) {
            f(this.f4283b.h(i10), this.f4283b.l(i10), messageDigest);
        }
    }

    public <T> T c(c<T> cVar) {
        if (this.f4283b.containsKey(cVar)) {
            return (T) this.f4283b.get(cVar);
        }
        return cVar.c();
    }

    public void d(d dVar) {
        this.f4283b.i(dVar.f4283b);
    }

    public <T> d e(c<T> cVar, T t10) {
        this.f4283b.put(cVar, t10);
        return this;
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f4283b.equals(((d) obj).f4283b);
        }
        return false;
    }

    @Override // X2.b
    public int hashCode() {
        return this.f4283b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f4283b + '}';
    }
}
