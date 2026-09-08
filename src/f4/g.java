package F4;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: JsonTreeWriter.java */
/* loaded from: classes3.dex */
public final class g extends K4.b {

    /* renamed from: p, reason: collision with root package name */
    public static final Writer f867p = new a();

    /* renamed from: q, reason: collision with root package name */
    public static final com.google.gson.n f868q = new com.google.gson.n("closed");

    /* renamed from: m, reason: collision with root package name */
    public final List<com.google.gson.j> f869m;

    /* renamed from: n, reason: collision with root package name */
    public String f870n;

    /* renamed from: o, reason: collision with root package name */
    public com.google.gson.j f871o;

    /* compiled from: JsonTreeWriter.java */
    /* loaded from: classes3.dex */
    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public g() {
        super(f867p);
        this.f869m = new ArrayList();
        this.f871o = com.google.gson.k.f24815a;
    }

    @Override // K4.b
    public K4.b B(String str) {
        Objects.requireNonNull(str, "name == null");
        if (!this.f869m.isEmpty() && this.f870n == null) {
            if (o0() instanceof com.google.gson.l) {
                this.f870n = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // K4.b
    public K4.b I() {
        q0(com.google.gson.k.f24815a);
        return this;
    }

    @Override // K4.b
    public K4.b c0(double d10) {
        if (!u() && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
        }
        q0(new com.google.gson.n(Double.valueOf(d10)));
        return this;
    }

    @Override // K4.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f869m.isEmpty()) {
            this.f869m.add(f868q);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // K4.b
    public K4.b e() {
        com.google.gson.g gVar = new com.google.gson.g();
        q0(gVar);
        this.f869m.add(gVar);
        return this;
    }

    @Override // K4.b
    public K4.b f() {
        com.google.gson.l lVar = new com.google.gson.l();
        q0(lVar);
        this.f869m.add(lVar);
        return this;
    }

    @Override // K4.b
    public K4.b f0(long j10) {
        q0(new com.google.gson.n(Long.valueOf(j10)));
        return this;
    }

    @Override // K4.b
    public K4.b g0(Boolean bool) {
        if (bool == null) {
            return I();
        }
        q0(new com.google.gson.n(bool));
        return this;
    }

    @Override // K4.b
    public K4.b h0(Number number) {
        if (number == null) {
            return I();
        }
        if (!u()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        q0(new com.google.gson.n(number));
        return this;
    }

    @Override // K4.b
    public K4.b i0(String str) {
        if (str == null) {
            return I();
        }
        q0(new com.google.gson.n(str));
        return this;
    }

    @Override // K4.b
    public K4.b j0(boolean z10) {
        q0(new com.google.gson.n(Boolean.valueOf(z10)));
        return this;
    }

    @Override // K4.b
    public K4.b l() {
        if (!this.f869m.isEmpty() && this.f870n == null) {
            if (o0() instanceof com.google.gson.g) {
                this.f869m.remove(r0.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    public com.google.gson.j m0() {
        if (this.f869m.isEmpty()) {
            return this.f871o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f869m);
    }

    @Override // K4.b
    public K4.b o() {
        if (!this.f869m.isEmpty() && this.f870n == null) {
            if (o0() instanceof com.google.gson.l) {
                this.f869m.remove(r0.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    public final com.google.gson.j o0() {
        return this.f869m.get(r1.size() - 1);
    }

    public final void q0(com.google.gson.j jVar) {
        if (this.f870n != null) {
            if (!jVar.h() || r()) {
                ((com.google.gson.l) o0()).k(this.f870n, jVar);
            }
            this.f870n = null;
            return;
        }
        if (this.f869m.isEmpty()) {
            this.f871o = jVar;
            return;
        }
        com.google.gson.j o02 = o0();
        if (o02 instanceof com.google.gson.g) {
            ((com.google.gson.g) o02).k(jVar);
            return;
        }
        throw new IllegalStateException();
    }

    @Override // K4.b, java.io.Flushable
    public void flush() {
    }
}
