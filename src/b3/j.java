package b3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import s3.C1537h;
import s3.C1540k;
import s3.C1541l;
import t3.C1589a;

/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final C1537h<X2.b, String> f12133a = new C1537h<>(1000);

    /* renamed from: b, reason: collision with root package name */
    public final I.e<b> f12134b = C1589a.d(10, new a());

    /* compiled from: SafeKeyGenerator.java */
    /* loaded from: classes.dex */
    public class a implements C1589a.d<b> {
        public a() {
        }

        @Override // t3.C1589a.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* compiled from: SafeKeyGenerator.java */
    /* loaded from: classes.dex */
    public static final class b implements C1589a.f {

        /* renamed from: a, reason: collision with root package name */
        public final MessageDigest f12136a;

        /* renamed from: b, reason: collision with root package name */
        public final t3.c f12137b = t3.c.a();

        public b(MessageDigest messageDigest) {
            this.f12136a = messageDigest;
        }

        @Override // t3.C1589a.f
        public t3.c e() {
            return this.f12137b;
        }
    }

    public final String a(X2.b bVar) {
        b bVar2 = (b) C1540k.d(this.f12134b.b());
        try {
            bVar.a(bVar2.f12136a);
            return C1541l.w(bVar2.f12136a.digest());
        } finally {
            this.f12134b.a(bVar2);
        }
    }

    public String b(X2.b bVar) {
        String g10;
        synchronized (this.f12133a) {
            g10 = this.f12133a.g(bVar);
        }
        if (g10 == null) {
            g10 = a(bVar);
        }
        synchronized (this.f12133a) {
            this.f12133a.k(bVar, g10);
        }
        return g10;
    }
}
