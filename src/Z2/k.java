package Z2;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import s3.C1537h;
import s3.C1541l;

/* compiled from: ResourceCacheKey.java */
/* loaded from: classes.dex */
public final class k implements X2.b {

    /* renamed from: j, reason: collision with root package name */
    public static final C1537h<Class<?>, byte[]> f5891j = new C1537h<>(50);

    /* renamed from: b, reason: collision with root package name */
    public final a3.b f5892b;

    /* renamed from: c, reason: collision with root package name */
    public final X2.b f5893c;

    /* renamed from: d, reason: collision with root package name */
    public final X2.b f5894d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5895e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5896f;

    /* renamed from: g, reason: collision with root package name */
    public final Class<?> f5897g;

    /* renamed from: h, reason: collision with root package name */
    public final X2.d f5898h;

    /* renamed from: i, reason: collision with root package name */
    public final X2.g<?> f5899i;

    public k(a3.b bVar, X2.b bVar2, X2.b bVar3, int i10, int i11, X2.g<?> gVar, Class<?> cls, X2.d dVar) {
        this.f5892b = bVar;
        this.f5893c = bVar2;
        this.f5894d = bVar3;
        this.f5895e = i10;
        this.f5896f = i11;
        this.f5899i = gVar;
        this.f5897g = cls;
        this.f5898h = dVar;
    }

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f5892b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f5895e).putInt(this.f5896f).array();
        this.f5894d.a(messageDigest);
        this.f5893c.a(messageDigest);
        messageDigest.update(bArr);
        X2.g<?> gVar = this.f5899i;
        if (gVar != null) {
            gVar.a(messageDigest);
        }
        this.f5898h.a(messageDigest);
        messageDigest.update(c());
        this.f5892b.d(bArr);
    }

    public final byte[] c() {
        C1537h<Class<?>, byte[]> c1537h = f5891j;
        byte[] g10 = c1537h.g(this.f5897g);
        if (g10 == null) {
            byte[] bytes = this.f5897g.getName().getBytes(X2.b.f4277a);
            c1537h.k(this.f5897g, bytes);
            return bytes;
        }
        return g10;
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f5896f != kVar.f5896f || this.f5895e != kVar.f5895e || !C1541l.d(this.f5899i, kVar.f5899i) || !this.f5897g.equals(kVar.f5897g) || !this.f5893c.equals(kVar.f5893c) || !this.f5894d.equals(kVar.f5894d) || !this.f5898h.equals(kVar.f5898h)) {
            return false;
        }
        return true;
    }

    @Override // X2.b
    public int hashCode() {
        int hashCode = (((((this.f5893c.hashCode() * 31) + this.f5894d.hashCode()) * 31) + this.f5895e) * 31) + this.f5896f;
        X2.g<?> gVar = this.f5899i;
        if (gVar != null) {
            hashCode = (hashCode * 31) + gVar.hashCode();
        }
        return (((hashCode * 31) + this.f5897g.hashCode()) * 31) + this.f5898h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f5893c + ", signature=" + this.f5894d + ", width=" + this.f5895e + ", height=" + this.f5896f + ", decodedResourceClass=" + this.f5897g + ", transformation='" + this.f5899i + "', options=" + this.f5898h + '}';
    }
}
