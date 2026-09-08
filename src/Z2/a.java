package Z2;

import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* loaded from: classes.dex */
public final class a implements X2.b {

    /* renamed from: b, reason: collision with root package name */
    public final X2.b f5865b;

    /* renamed from: c, reason: collision with root package name */
    public final X2.b f5866c;

    public a(X2.b bVar, X2.b bVar2) {
        this.f5865b = bVar;
        this.f5866c = bVar2;
    }

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        this.f5865b.a(messageDigest);
        this.f5866c.a(messageDigest);
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f5865b.equals(aVar.f5865b) || !this.f5866c.equals(aVar.f5866c)) {
            return false;
        }
        return true;
    }

    @Override // X2.b
    public int hashCode() {
        return (this.f5865b.hashCode() * 31) + this.f5866c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f5865b + ", signature=" + this.f5866c + '}';
    }
}
