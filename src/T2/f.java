package T2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpResponse.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f3731a;

    /* renamed from: b, reason: collision with root package name */
    public final List<S2.c> f3732b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3733c;

    /* renamed from: d, reason: collision with root package name */
    public final InputStream f3734d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f3735e;

    public f(int i10, List<S2.c> list) {
        this(i10, list, -1, null);
    }

    public final InputStream a() {
        InputStream inputStream = this.f3734d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f3735e != null) {
            return new ByteArrayInputStream(this.f3735e);
        }
        return null;
    }

    public final int b() {
        return this.f3733c;
    }

    public final List<S2.c> c() {
        return Collections.unmodifiableList(this.f3732b);
    }

    public final int d() {
        return this.f3731a;
    }

    public f(int i10, List<S2.c> list, int i11, InputStream inputStream) {
        this.f3731a = i10;
        this.f3732b = list;
        this.f3733c = i11;
        this.f3734d = inputStream;
        this.f3735e = null;
    }
}
