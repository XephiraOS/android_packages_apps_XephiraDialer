package io.grpc;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Metadata.java */
/* loaded from: classes4.dex */
public final class u {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f33497c = Logger.getLogger(u.class.getName());

    /* renamed from: d, reason: collision with root package name */
    public static final e<byte[]> f33498d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static final d<String> f33499e = new b();

    /* renamed from: f, reason: collision with root package name */
    public static final com.google.common.io.a f33500f = com.google.common.io.a.a().f();

    /* renamed from: a, reason: collision with root package name */
    public Object[] f33501a;

    /* renamed from: b, reason: collision with root package name */
    public int f33502b;

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public class a implements e<byte[]> {
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public static class c<T> extends g<T> {

        /* renamed from: f, reason: collision with root package name */
        public final d<T> f33503f;

        public /* synthetic */ c(String str, boolean z10, d dVar, a aVar) {
            this(str, z10, dVar);
        }

        @Override // io.grpc.u.g
        public T f(byte[] bArr) {
            return this.f33503f.b(new String(bArr, com.google.common.base.b.f24304a));
        }

        @Override // io.grpc.u.g
        public byte[] h(T t10) {
            return ((String) com.google.common.base.k.p(this.f33503f.a(t10), "null marshaller.toAsciiString()")).getBytes(com.google.common.base.b.f24304a);
        }

        public c(String str, boolean z10, d<T> dVar) {
            super(str, z10, dVar, null);
            com.google.common.base.k.l(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f33503f = (d) com.google.common.base.k.p(dVar, "marshaller");
        }
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public interface d<T> {
        String a(T t10);

        T b(String str);
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public interface e<T> {
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public interface f<T> {
        InputStream a(T t10);

        T b(InputStream inputStream);
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public static abstract class g<T> {

        /* renamed from: e, reason: collision with root package name */
        public static final BitSet f33504e = a();

        /* renamed from: a, reason: collision with root package name */
        public final String f33505a;

        /* renamed from: b, reason: collision with root package name */
        public final String f33506b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f33507c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f33508d;

        public /* synthetic */ g(String str, boolean z10, Object obj, a aVar) {
            this(str, z10, obj);
        }

        public static BitSet a() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c10 = '0'; c10 <= '9'; c10 = (char) (c10 + 1)) {
                bitSet.set(c10);
            }
            for (char c11 = 'a'; c11 <= 'z'; c11 = (char) (c11 + 1)) {
                bitSet.set(c11);
            }
            return bitSet;
        }

        public static <T> g<T> c(String str, d<T> dVar) {
            return d(str, false, dVar);
        }

        public static <T> g<T> d(String str, boolean z10, d<T> dVar) {
            return new c(str, z10, dVar, null);
        }

        public static <T> g<T> e(String str, boolean z10, j<T> jVar) {
            return new i(str, z10, jVar, null);
        }

        public static String i(String str, boolean z10) {
            com.google.common.base.k.p(str, "name");
            com.google.common.base.k.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                u.f33497c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (!z10 || charAt != ':' || i10 != 0) {
                    com.google.common.base.k.g(f33504e.get(charAt), "Invalid character '%s' in key name '%s'", charAt, str);
                }
            }
            return str;
        }

        public byte[] asciiName() {
            return this.f33507c;
        }

        public final <M> M b(Class<M> cls) {
            if (cls.isInstance(this.f33508d)) {
                return cls.cast(this.f33508d);
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.f33506b.equals(((g) obj).f33506b);
            }
            return false;
        }

        public abstract T f(byte[] bArr);

        public boolean g() {
            return false;
        }

        public abstract byte[] h(T t10);

        public final int hashCode() {
            return this.f33506b.hashCode();
        }

        public String toString() {
            return "Key{name='" + this.f33506b + "'}";
        }

        public g(String str, boolean z10, Object obj) {
            String str2 = (String) com.google.common.base.k.p(str, "name");
            this.f33505a = str2;
            String i10 = i(str2.toLowerCase(Locale.ROOT), z10);
            this.f33506b = i10;
            this.f33507c = i10.getBytes(com.google.common.base.b.f24304a);
            this.f33508d = obj;
        }
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public static final class h<T> {

        /* renamed from: a, reason: collision with root package name */
        public final f<T> f33509a;

        /* renamed from: b, reason: collision with root package name */
        public final T f33510b;

        /* renamed from: c, reason: collision with root package name */
        public volatile byte[] f33511c;

        public h(f<T> fVar, T t10) {
            this.f33509a = fVar;
            this.f33510b = t10;
        }

        public static <T> h<T> a(g<T> gVar, T t10) {
            return new h<>((f) com.google.common.base.k.o(b(gVar)), t10);
        }

        public static <T> f<T> b(g<T> gVar) {
            return (f) gVar.b(f.class);
        }

        public byte[] c() {
            if (this.f33511c == null) {
                synchronized (this) {
                    try {
                        if (this.f33511c == null) {
                            this.f33511c = u.q(e());
                        }
                    } finally {
                    }
                }
            }
            return this.f33511c;
        }

        public <T2> T2 d(g<T2> gVar) {
            f b10;
            if (gVar.g() && (b10 = b(gVar)) != null) {
                return (T2) b10.b(e());
            }
            return gVar.f(c());
        }

        public InputStream e() {
            return (InputStream) com.google.common.base.k.p(this.f33509a.a(this.f33510b), "null marshaller.toStream()");
        }
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public static final class i<T> extends g<T> {

        /* renamed from: f, reason: collision with root package name */
        public final j<T> f33512f;

        public /* synthetic */ i(String str, boolean z10, j jVar, a aVar) {
            this(str, z10, jVar);
        }

        @Override // io.grpc.u.g
        public T f(byte[] bArr) {
            return this.f33512f.b(bArr);
        }

        @Override // io.grpc.u.g
        public byte[] h(T t10) {
            return (byte[]) com.google.common.base.k.p(this.f33512f.a(t10), "null marshaller.toAsciiString()");
        }

        public i(String str, boolean z10, j<T> jVar) {
            super(str, z10, jVar, null);
            com.google.common.base.k.l(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f33512f = (j) com.google.common.base.k.p(jVar, "marshaller");
        }
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public interface j<T> {
        byte[] a(T t10);

        T b(byte[] bArr);
    }

    public u() {
    }

    public static byte[] q(InputStream inputStream) {
        try {
            return com.google.common.io.b.b(inputStream);
        } catch (IOException e10) {
            throw new RuntimeException("failure reading serialized stream", e10);
        }
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public final int d() {
        Object[] objArr = this.f33501a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public boolean e(g<?> gVar) {
        for (int i10 = 0; i10 < this.f33502b; i10++) {
            if (c(gVar.asciiName(), n(i10))) {
                return true;
            }
        }
        return false;
    }

    public <T> void f(g<T> gVar) {
        if (i()) {
            return;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f33502b; i11++) {
            if (!c(gVar.asciiName(), n(i11))) {
                m(i10, n(i11));
                s(i10, r(i11));
                i10++;
            }
        }
        Arrays.fill(this.f33501a, i10 * 2, j(), (Object) null);
        this.f33502b = i10;
    }

    public final void g(int i10) {
        Object[] objArr = new Object[i10];
        if (!i()) {
            System.arraycopy(this.f33501a, 0, objArr, 0, j());
        }
        this.f33501a = objArr;
    }

    public <T> T h(g<T> gVar) {
        for (int i10 = this.f33502b - 1; i10 >= 0; i10--) {
            if (c(gVar.asciiName(), n(i10))) {
                return (T) v(i10, gVar);
            }
        }
        return null;
    }

    public final boolean i() {
        if (this.f33502b == 0) {
            return true;
        }
        return false;
    }

    public final int j() {
        return this.f33502b * 2;
    }

    public final void k() {
        if (j() == 0 || j() == d()) {
            g(Math.max(j() * 2, 8));
        }
    }

    public void l(u uVar) {
        if (uVar.i()) {
            return;
        }
        int d10 = d() - j();
        if (i() || d10 < uVar.j()) {
            g(j() + uVar.j());
        }
        System.arraycopy(uVar.f33501a, 0, this.f33501a, j(), uVar.j());
        this.f33502b += uVar.f33502b;
    }

    public final void m(int i10, byte[] bArr) {
        this.f33501a[i10 * 2] = bArr;
    }

    public final byte[] n(int i10) {
        return (byte[]) this.f33501a[i10 * 2];
    }

    public <T> void o(g<T> gVar, T t10) {
        com.google.common.base.k.p(gVar, "key");
        com.google.common.base.k.p(t10, "value");
        k();
        m(this.f33502b, gVar.asciiName());
        if (gVar.g()) {
            s(this.f33502b, h.a(gVar, t10));
        } else {
            t(this.f33502b, gVar.h(t10));
        }
        this.f33502b++;
    }

    public byte[][] p() {
        byte[][] bArr = new byte[j()];
        Object[] objArr = this.f33501a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, j());
        } else {
            for (int i10 = 0; i10 < this.f33502b; i10++) {
                int i11 = i10 * 2;
                bArr[i11] = n(i10);
                bArr[i11 + 1] = u(i10);
            }
        }
        return bArr;
    }

    public final Object r(int i10) {
        return this.f33501a[(i10 * 2) + 1];
    }

    public final void s(int i10, Object obj) {
        if (this.f33501a instanceof byte[][]) {
            g(d());
        }
        this.f33501a[(i10 * 2) + 1] = obj;
    }

    public final void t(int i10, byte[] bArr) {
        this.f33501a[(i10 * 2) + 1] = bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i10 = 0; i10 < this.f33502b; i10++) {
            if (i10 != 0) {
                sb.append(',');
            }
            byte[] n10 = n(i10);
            Charset charset = com.google.common.base.b.f24304a;
            String str = new String(n10, charset);
            sb.append(str);
            sb.append('=');
            if (str.endsWith("-bin")) {
                sb.append(f33500f.b(u(i10)));
            } else {
                sb.append(new String(u(i10), charset));
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public final byte[] u(int i10) {
        Object r10 = r(i10);
        if (r10 instanceof byte[]) {
            return (byte[]) r10;
        }
        return ((h) r10).c();
    }

    public final <T> T v(int i10, g<T> gVar) {
        Object r10 = r(i10);
        if (r10 instanceof byte[]) {
            return gVar.f((byte[]) r10);
        }
        return (T) ((h) r10).d(gVar);
    }

    public u(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    public u(int i10, byte[]... bArr) {
        this(i10, (Object[]) bArr);
    }

    public u(int i10, Object[] objArr) {
        this.f33502b = i10;
        this.f33501a = objArr;
    }

    /* compiled from: Metadata.java */
    /* loaded from: classes4.dex */
    public class b implements d<String> {
        @Override // io.grpc.u.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String b(String str) {
            return str;
        }

        @Override // io.grpc.u.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a(String str) {
            return str;
        }
    }
}
