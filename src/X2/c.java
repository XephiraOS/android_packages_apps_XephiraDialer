package X2;

import java.security.MessageDigest;
import s3.C1540k;

/* compiled from: Option.java */
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final b<Object> f4278e = new a();

    /* renamed from: a, reason: collision with root package name */
    public final T f4279a;

    /* renamed from: b, reason: collision with root package name */
    public final b<T> f4280b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4281c;

    /* renamed from: d, reason: collision with root package name */
    public volatile byte[] f4282d;

    /* compiled from: Option.java */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(byte[] bArr, T t10, MessageDigest messageDigest);
    }

    public c(String str, T t10, b<T> bVar) {
        this.f4281c = C1540k.b(str);
        this.f4279a = t10;
        this.f4280b = (b) C1540k.d(bVar);
    }

    public static <T> c<T> a(String str, T t10, b<T> bVar) {
        return new c<>(str, t10, bVar);
    }

    public static <T> b<T> b() {
        return (b<T>) f4278e;
    }

    public static <T> c<T> e(String str) {
        return new c<>(str, null, b());
    }

    public static <T> c<T> f(String str, T t10) {
        return new c<>(str, t10, b());
    }

    public T c() {
        return this.f4279a;
    }

    public final byte[] d() {
        if (this.f4282d == null) {
            this.f4282d = this.f4281c.getBytes(X2.b.f4277a);
        }
        return this.f4282d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f4281c.equals(((c) obj).f4281c);
        }
        return false;
    }

    public void g(T t10, MessageDigest messageDigest) {
        this.f4280b.a(d(), t10, messageDigest);
    }

    public int hashCode() {
        return this.f4281c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f4281c + "'}";
    }

    /* compiled from: Option.java */
    /* loaded from: classes.dex */
    public class a implements b<Object> {
        @Override // X2.c.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }
}
