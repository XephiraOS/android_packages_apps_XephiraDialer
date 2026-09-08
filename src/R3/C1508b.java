package r3;

import java.security.MessageDigest;
import s3.C1540k;

/* compiled from: ObjectKey.java */
/* renamed from: r3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1508b implements X2.b {

    /* renamed from: b, reason: collision with root package name */
    public final Object f36282b;

    public C1508b(Object obj) {
        this.f36282b = C1540k.d(obj);
    }

    @Override // X2.b
    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.f36282b.toString().getBytes(X2.b.f4277a));
    }

    @Override // X2.b
    public boolean equals(Object obj) {
        if (obj instanceof C1508b) {
            return this.f36282b.equals(((C1508b) obj).f36282b);
        }
        return false;
    }

    @Override // X2.b
    public int hashCode() {
        return this.f36282b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f36282b + '}';
    }
}
