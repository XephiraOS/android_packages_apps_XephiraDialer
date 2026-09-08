package io.grpc;

import com.heytap.accessory.constant.AFConstants;
import io.grpc.AbstractC1112f;
import io.grpc.C1107a;
import j9.C1201k;
import j9.N;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: LoadBalancer.java */
/* loaded from: classes4.dex */
public abstract class q {

    /* renamed from: b, reason: collision with root package name */
    public static final C1107a.c<Map<String, ?>> f33434b = C1107a.c.a("internal:health-checking-config");

    /* renamed from: c, reason: collision with root package name */
    public static final b.C0313b<k> f33435c = b.C0313b.b("internal:health-check-consumer-listener");

    /* renamed from: d, reason: collision with root package name */
    public static final C1107a.c<Boolean> f33436d = C1107a.c.a("internal:has-health-check-producer-listener");

    /* renamed from: e, reason: collision with root package name */
    public static final C1107a.c<Boolean> f33437e = C1107a.c.a("io.grpc.IS_PETIOLE_POLICY");

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final j f33438f = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f33439a;

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public class a extends j {
        @Override // io.grpc.q.j
        public f a(g gVar) {
            return f.g();
        }

        public String toString() {
            return "EMPTY_PICKER";
        }
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final List<C1114h> f33440a;

        /* renamed from: b, reason: collision with root package name */
        public final C1107a f33441b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[][] f33442c;

        /* compiled from: LoadBalancer.java */
        /* loaded from: classes4.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public List<C1114h> f33443a;

            /* renamed from: b, reason: collision with root package name */
            public C1107a f33444b = C1107a.f32411c;

            /* renamed from: c, reason: collision with root package name */
            public Object[][] f33445c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

            public <T> a b(C0313b<T> c0313b, T t10) {
                com.google.common.base.k.p(c0313b, "key");
                com.google.common.base.k.p(t10, "value");
                int i10 = 0;
                while (true) {
                    Object[][] objArr = this.f33445c;
                    if (i10 < objArr.length) {
                        if (c0313b.equals(objArr[i10][0])) {
                            break;
                        }
                        i10++;
                    } else {
                        i10 = -1;
                        break;
                    }
                }
                if (i10 == -1) {
                    Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f33445c.length + 1, 2);
                    Object[][] objArr3 = this.f33445c;
                    System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                    this.f33445c = objArr2;
                    i10 = objArr2.length - 1;
                }
                this.f33445c[i10] = new Object[]{c0313b, t10};
                return this;
            }

            public b c() {
                return new b(this.f33443a, this.f33444b, this.f33445c, null);
            }

            public final a d(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, objArr.length, 2);
                this.f33445c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public a e(List<C1114h> list) {
                com.google.common.base.k.e(!list.isEmpty(), "addrs is empty");
                this.f33443a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a f(C1107a c1107a) {
                this.f33444b = (C1107a) com.google.common.base.k.p(c1107a, "attrs");
                return this;
            }
        }

        /* compiled from: LoadBalancer.java */
        /* renamed from: io.grpc.q$b$b, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0313b<T> {

            /* renamed from: a, reason: collision with root package name */
            public final String f33446a;

            /* renamed from: b, reason: collision with root package name */
            public final T f33447b;

            public C0313b(String str, T t10) {
                this.f33446a = str;
                this.f33447b = t10;
            }

            public static <T> C0313b<T> b(String str) {
                com.google.common.base.k.p(str, "debugString");
                return new C0313b<>(str, null);
            }

            public String toString() {
                return this.f33446a;
            }
        }

        public /* synthetic */ b(List list, C1107a c1107a, Object[][] objArr, a aVar) {
            this(list, c1107a, objArr);
        }

        public static a d() {
            return new a();
        }

        public List<C1114h> a() {
            return this.f33440a;
        }

        public C1107a b() {
            return this.f33441b;
        }

        public <T> T c(C0313b<T> c0313b) {
            com.google.common.base.k.p(c0313b, "key");
            int i10 = 0;
            while (true) {
                Object[][] objArr = this.f33442c;
                if (i10 >= objArr.length) {
                    return (T) c0313b.f33447b;
                }
                if (c0313b.equals(objArr[i10][0])) {
                    return (T) this.f33442c[i10][1];
                }
                i10++;
            }
        }

        public a e() {
            return d().e(this.f33440a).f(this.f33441b).d(this.f33442c);
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("addrs", this.f33440a).d("attrs", this.f33441b).d("customOptions", Arrays.deepToString(this.f33442c)).toString();
        }

        public b(List<C1114h> list, C1107a c1107a, Object[][] objArr) {
            this.f33440a = (List) com.google.common.base.k.p(list, "addresses are not set");
            this.f33441b = (C1107a) com.google.common.base.k.p(c1107a, "attrs");
            this.f33442c = (Object[][]) com.google.common.base.k.p(objArr, "customOptions");
        }
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static abstract class c {
        public abstract q a(e eVar);
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static final class d extends j {

        /* renamed from: a, reason: collision with root package name */
        public final f f33448a;

        public d(f fVar) {
            this.f33448a = (f) com.google.common.base.k.p(fVar, "result");
        }

        @Override // io.grpc.q.j
        public f a(g gVar) {
            return this.f33448a;
        }

        public String toString() {
            return "FixedResultPicker(" + this.f33448a + ")";
        }
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static abstract class e {
        public i a(b bVar) {
            throw new UnsupportedOperationException();
        }

        public ChannelLogger b() {
            throw new UnsupportedOperationException();
        }

        public ScheduledExecutorService c() {
            throw new UnsupportedOperationException();
        }

        public N d() {
            throw new UnsupportedOperationException();
        }

        public void e() {
            throw new UnsupportedOperationException();
        }

        public abstract void f(ConnectivityState connectivityState, j jVar);
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static final class f {

        /* renamed from: e, reason: collision with root package name */
        public static final f f33449e = new f(null, null, Status.f32368e, false);

        /* renamed from: a, reason: collision with root package name */
        public final i f33450a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC1112f.a f33451b;

        /* renamed from: c, reason: collision with root package name */
        public final Status f33452c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f33453d;

        public f(i iVar, AbstractC1112f.a aVar, Status status, boolean z10) {
            this.f33450a = iVar;
            this.f33451b = aVar;
            this.f33452c = (Status) com.google.common.base.k.p(status, AFConstants.EXTRA_STATUS);
            this.f33453d = z10;
        }

        public static f e(Status status) {
            com.google.common.base.k.e(!status.o(), "drop status shouldn't be OK");
            return new f(null, null, status, true);
        }

        public static f f(Status status) {
            com.google.common.base.k.e(!status.o(), "error status shouldn't be OK");
            return new f(null, null, status, false);
        }

        public static f g() {
            return f33449e;
        }

        public static f h(i iVar) {
            return i(iVar, null);
        }

        public static f i(i iVar, AbstractC1112f.a aVar) {
            return new f((i) com.google.common.base.k.p(iVar, "subchannel"), aVar, Status.f32368e, false);
        }

        public Status a() {
            return this.f33452c;
        }

        public AbstractC1112f.a b() {
            return this.f33451b;
        }

        public i c() {
            return this.f33450a;
        }

        public boolean d() {
            return this.f33453d;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (!com.google.common.base.h.a(this.f33450a, fVar.f33450a) || !com.google.common.base.h.a(this.f33452c, fVar.f33452c) || !com.google.common.base.h.a(this.f33451b, fVar.f33451b) || this.f33453d != fVar.f33453d) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f33450a, this.f33452c, this.f33451b, Boolean.valueOf(this.f33453d));
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("subchannel", this.f33450a).d("streamTracerFactory", this.f33451b).d(AFConstants.EXTRA_STATUS, this.f33452c).e("drop", this.f33453d).toString();
        }
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static abstract class g {
        public abstract C1108b a();

        public abstract u b();

        public abstract MethodDescriptor<?, ?> c();
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static final class h {

        /* renamed from: a, reason: collision with root package name */
        public final List<C1114h> f33454a;

        /* renamed from: b, reason: collision with root package name */
        public final C1107a f33455b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f33456c;

        /* compiled from: LoadBalancer.java */
        /* loaded from: classes4.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public List<C1114h> f33457a;

            /* renamed from: b, reason: collision with root package name */
            public C1107a f33458b = C1107a.f32411c;

            /* renamed from: c, reason: collision with root package name */
            public Object f33459c;

            public h a() {
                return new h(this.f33457a, this.f33458b, this.f33459c, null);
            }

            public a b(List<C1114h> list) {
                this.f33457a = list;
                return this;
            }

            public a c(C1107a c1107a) {
                this.f33458b = c1107a;
                return this;
            }

            public a d(Object obj) {
                this.f33459c = obj;
                return this;
            }
        }

        public /* synthetic */ h(List list, C1107a c1107a, Object obj, a aVar) {
            this(list, c1107a, obj);
        }

        public static a d() {
            return new a();
        }

        public List<C1114h> a() {
            return this.f33454a;
        }

        public C1107a b() {
            return this.f33455b;
        }

        public Object c() {
            return this.f33456c;
        }

        public a e() {
            return d().b(this.f33454a).c(this.f33455b).d(this.f33456c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!com.google.common.base.h.a(this.f33454a, hVar.f33454a) || !com.google.common.base.h.a(this.f33455b, hVar.f33455b) || !com.google.common.base.h.a(this.f33456c, hVar.f33456c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f33454a, this.f33455b, this.f33456c);
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("addresses", this.f33454a).d("attributes", this.f33455b).d("loadBalancingPolicyConfig", this.f33456c).toString();
        }

        public h(List<C1114h> list, C1107a c1107a, Object obj) {
            this.f33454a = Collections.unmodifiableList(new ArrayList((Collection) com.google.common.base.k.p(list, "addresses")));
            this.f33455b = (C1107a) com.google.common.base.k.p(c1107a, "attributes");
            this.f33456c = obj;
        }
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static abstract class i {
        public final C1114h a() {
            List<C1114h> b10 = b();
            boolean z10 = true;
            if (b10.size() != 1) {
                z10 = false;
            }
            com.google.common.base.k.x(z10, "%s does not have exactly one group", b10);
            return b10.get(0);
        }

        public List<C1114h> b() {
            throw new UnsupportedOperationException();
        }

        public abstract C1107a c();

        public ChannelLogger d() {
            throw new UnsupportedOperationException();
        }

        public Object e() {
            throw new UnsupportedOperationException();
        }

        public abstract void f();

        public abstract void g();

        public void h(k kVar) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void i(List<C1114h> list) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public static abstract class j {
        public abstract f a(g gVar);
    }

    /* compiled from: LoadBalancer.java */
    /* loaded from: classes4.dex */
    public interface k {
        void a(C1201k c1201k);
    }

    public Status a(h hVar) {
        if (hVar.a().isEmpty() && !b()) {
            Status r10 = Status.f32383t.r("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(r10);
            return r10;
        }
        int i10 = this.f33439a;
        this.f33439a = i10 + 1;
        if (i10 == 0) {
            d(hVar);
        }
        this.f33439a = 0;
        return Status.f32368e;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(Status status);

    public void d(h hVar) {
        int i10 = this.f33439a;
        this.f33439a = i10 + 1;
        if (i10 == 0) {
            a(hVar);
        }
        this.f33439a = 0;
    }

    public abstract void f();

    public void e() {
    }
}
