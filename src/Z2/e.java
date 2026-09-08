package Z2;

import java.security.MessageDigest;
import java.util.Map;
import s3.C1540k;

/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
public class e implements X2.b {

    /* renamed from: b, reason: collision with root package name */
    public final Object f5875b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5876c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5877d;

    /* renamed from: e, reason: collision with root package name */
    public final Class<?> f5878e;

    /* renamed from: f, reason: collision with root package name */
    public final Class<?> f5879f;

    /* renamed from: g, reason: collision with root package name */
    public final X2.b f5880g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<Class<?>, X2.g<?>> f5881h;

    /* renamed from: i, reason: collision with root package name */
    public final X2.d f5882i;

    /* renamed from: j, reason: collision with root package name */
    public int f5883j;

    public e(Object obj, X2.b bVar, int i10, int i11, Map<Class<?>, X2.g<?>> map, Class<?> cls, Class<?> cls2, X2.d dVar) {
        this.f5875b = C1540k.d(obj);
        this.f5880g = (X2.b) C1540k.e(bVar, "Signature must not be null");
        this.f5876c = i10;
        this.f5877d = i11;
        this.f5881h = (Map) C1540k.d(map);
        this.f5878e = (Class) C1540k.e(cls, "Resource class must not be null");
        this.f5879f = (Class) C1540k.e(cls2, "Transcode class must not be null");
        this.f5882i = (X2.d) C1540k.d(dVar);
    }

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f5875b.equals(eVar.f5875b) || !this.f5880g.equals(eVar.f5880g) || this.f5877d != eVar.f5877d || this.f5876c != eVar.f5876c || !this.f5881h.equals(eVar.f5881h) || !this.f5878e.equals(eVar.f5878e) || !this.f5879f.equals(eVar.f5879f) || !this.f5882i.equals(eVar.f5882i)) {
            return false;
        }
        return true;
    }

    @Override // X2.b
    public int hashCode() {
        if (this.f5883j == 0) {
            int hashCode = this.f5875b.hashCode();
            this.f5883j = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.f5880g.hashCode()) * 31) + this.f5876c) * 31) + this.f5877d;
            this.f5883j = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.f5881h.hashCode();
            this.f5883j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f5878e.hashCode();
            this.f5883j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f5879f.hashCode();
            this.f5883j = hashCode5;
            this.f5883j = (hashCode5 * 31) + this.f5882i.hashCode();
        }
        return this.f5883j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f5875b + ", width=" + this.f5876c + ", height=" + this.f5877d + ", resourceClass=" + this.f5878e + ", transcodeClass=" + this.f5879f + ", signature=" + this.f5880g + ", hashCode=" + this.f5883j + ", transformations=" + this.f5881h + ", options=" + this.f5882i + '}';
    }
}
