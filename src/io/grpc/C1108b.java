package io.grpc;

import com.google.common.base.f;
import io.grpc.AbstractC1112f;
import j9.AbstractC1193c;
import j9.C1203m;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: CallOptions.java */
/* renamed from: io.grpc.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1108b {

    /* renamed from: k, reason: collision with root package name */
    public static final C1108b f32416k;

    /* renamed from: a, reason: collision with root package name */
    public final C1203m f32417a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f32418b;

    /* renamed from: c, reason: collision with root package name */
    public final String f32419c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC1193c f32420d;

    /* renamed from: e, reason: collision with root package name */
    public final String f32421e;

    /* renamed from: f, reason: collision with root package name */
    public final Object[][] f32422f;

    /* renamed from: g, reason: collision with root package name */
    public final List<AbstractC1112f.a> f32423g;

    /* renamed from: h, reason: collision with root package name */
    public final Boolean f32424h;

    /* renamed from: i, reason: collision with root package name */
    public final Integer f32425i;

    /* renamed from: j, reason: collision with root package name */
    public final Integer f32426j;

    /* compiled from: CallOptions.java */
    /* renamed from: io.grpc.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0308b {

        /* renamed from: a, reason: collision with root package name */
        public C1203m f32427a;

        /* renamed from: b, reason: collision with root package name */
        public Executor f32428b;

        /* renamed from: c, reason: collision with root package name */
        public String f32429c;

        /* renamed from: d, reason: collision with root package name */
        public AbstractC1193c f32430d;

        /* renamed from: e, reason: collision with root package name */
        public String f32431e;

        /* renamed from: f, reason: collision with root package name */
        public Object[][] f32432f;

        /* renamed from: g, reason: collision with root package name */
        public List<AbstractC1112f.a> f32433g;

        /* renamed from: h, reason: collision with root package name */
        public Boolean f32434h;

        /* renamed from: i, reason: collision with root package name */
        public Integer f32435i;

        /* renamed from: j, reason: collision with root package name */
        public Integer f32436j;

        public final C1108b b() {
            return new C1108b(this);
        }
    }

    /* compiled from: CallOptions.java */
    /* renamed from: io.grpc.b$c */
    /* loaded from: classes4.dex */
    public static final class c<T> {

        /* renamed from: a, reason: collision with root package name */
        public final String f32437a;

        /* renamed from: b, reason: collision with root package name */
        public final T f32438b;

        public c(String str, T t10) {
            this.f32437a = str;
            this.f32438b = t10;
        }

        public static <T> c<T> b(String str) {
            com.google.common.base.k.p(str, "debugString");
            return new c<>(str, null);
        }

        public String toString() {
            return this.f32437a;
        }
    }

    static {
        C0308b c0308b = new C0308b();
        c0308b.f32432f = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        c0308b.f32433g = Collections.emptyList();
        f32416k = c0308b.b();
    }

    public static C0308b k(C1108b c1108b) {
        C0308b c0308b = new C0308b();
        c0308b.f32427a = c1108b.f32417a;
        c0308b.f32428b = c1108b.f32418b;
        c0308b.f32429c = c1108b.f32419c;
        c0308b.f32430d = c1108b.f32420d;
        c0308b.f32431e = c1108b.f32421e;
        c0308b.f32432f = c1108b.f32422f;
        c0308b.f32433g = c1108b.f32423g;
        c0308b.f32434h = c1108b.f32424h;
        c0308b.f32435i = c1108b.f32425i;
        c0308b.f32436j = c1108b.f32426j;
        return c0308b;
    }

    public String a() {
        return this.f32419c;
    }

    public String b() {
        return this.f32421e;
    }

    public AbstractC1193c c() {
        return this.f32420d;
    }

    public C1203m d() {
        return this.f32417a;
    }

    public Executor e() {
        return this.f32418b;
    }

    public Integer f() {
        return this.f32425i;
    }

    public Integer g() {
        return this.f32426j;
    }

    public <T> T h(c<T> cVar) {
        com.google.common.base.k.p(cVar, "key");
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f32422f;
            if (i10 >= objArr.length) {
                return (T) cVar.f32438b;
            }
            if (cVar.equals(objArr[i10][0])) {
                return (T) this.f32422f[i10][1];
            }
            i10++;
        }
    }

    public List<AbstractC1112f.a> i() {
        return this.f32423g;
    }

    public boolean j() {
        return Boolean.TRUE.equals(this.f32424h);
    }

    public C1108b l(AbstractC1193c abstractC1193c) {
        C0308b k10 = k(this);
        k10.f32430d = abstractC1193c;
        return k10.b();
    }

    public C1108b m(String str) {
        C0308b k10 = k(this);
        k10.f32431e = str;
        return k10.b();
    }

    public C1108b n(C1203m c1203m) {
        C0308b k10 = k(this);
        k10.f32427a = c1203m;
        return k10.b();
    }

    public C1108b o(long j10, TimeUnit timeUnit) {
        return n(C1203m.a(j10, timeUnit));
    }

    public C1108b p(Executor executor) {
        C0308b k10 = k(this);
        k10.f32428b = executor;
        return k10.b();
    }

    public C1108b q(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.h(z10, "invalid maxsize %s", i10);
        C0308b k10 = k(this);
        k10.f32435i = Integer.valueOf(i10);
        return k10.b();
    }

    public C1108b r(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.h(z10, "invalid maxsize %s", i10);
        C0308b k10 = k(this);
        k10.f32436j = Integer.valueOf(i10);
        return k10.b();
    }

    public <T> C1108b s(c<T> cVar, T t10) {
        int i10;
        com.google.common.base.k.p(cVar, "key");
        com.google.common.base.k.p(t10, "value");
        C0308b k10 = k(this);
        int i11 = 0;
        while (true) {
            Object[][] objArr = this.f32422f;
            if (i11 < objArr.length) {
                if (cVar.equals(objArr[i11][0])) {
                    break;
                }
                i11++;
            } else {
                i11 = -1;
                break;
            }
        }
        int length = this.f32422f.length;
        if (i11 == -1) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, length + i10, 2);
        k10.f32432f = objArr2;
        Object[][] objArr3 = this.f32422f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i11 == -1) {
            k10.f32432f[this.f32422f.length] = new Object[]{cVar, t10};
        } else {
            k10.f32432f[i11] = new Object[]{cVar, t10};
        }
        return k10.b();
    }

    public C1108b t(AbstractC1112f.a aVar) {
        ArrayList arrayList = new ArrayList(this.f32423g.size() + 1);
        arrayList.addAll(this.f32423g);
        arrayList.add(aVar);
        C0308b k10 = k(this);
        k10.f32433g = Collections.unmodifiableList(arrayList);
        return k10.b();
    }

    public String toString() {
        Class<?> cls;
        f.b d10 = com.google.common.base.f.c(this).d("deadline", this.f32417a).d("authority", this.f32419c).d("callCredentials", this.f32420d);
        Executor executor = this.f32418b;
        if (executor != null) {
            cls = executor.getClass();
        } else {
            cls = null;
        }
        return d10.d("executor", cls).d("compressorName", this.f32421e).d("customOptions", Arrays.deepToString(this.f32422f)).e("waitForReady", j()).d("maxInboundMessageSize", this.f32425i).d("maxOutboundMessageSize", this.f32426j).d("streamTracerFactories", this.f32423g).toString();
    }

    public C1108b u() {
        C0308b k10 = k(this);
        k10.f32434h = Boolean.TRUE;
        return k10.b();
    }

    public C1108b v() {
        C0308b k10 = k(this);
        k10.f32434h = Boolean.FALSE;
        return k10.b();
    }

    public C1108b(C0308b c0308b) {
        this.f32417a = c0308b.f32427a;
        this.f32418b = c0308b.f32428b;
        this.f32419c = c0308b.f32429c;
        this.f32420d = c0308b.f32430d;
        this.f32421e = c0308b.f32431e;
        this.f32422f = c0308b.f32432f;
        this.f32423g = c0308b.f32433g;
        this.f32424h = c0308b.f32434h;
        this.f32425i = c0308b.f32435i;
        this.f32426j = c0308b.f32436j;
    }
}
