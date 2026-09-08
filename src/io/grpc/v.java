package io.grpc;

import com.heytap.accessory.constant.AFConstants;
import com.oplus.backup.sdk.common.utils.Constants;
import j9.N;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: NameResolver.java */
/* loaded from: classes4.dex */
public abstract class v {

    /* compiled from: NameResolver.java */
    /* loaded from: classes4.dex */
    public class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f33630a;

        public a(f fVar) {
            this.f33630a = fVar;
        }

        @Override // io.grpc.v.e, io.grpc.v.f
        public void a(Status status) {
            this.f33630a.a(status);
        }

        @Override // io.grpc.v.e
        public void c(g gVar) {
            this.f33630a.b(gVar.a(), gVar.b());
        }
    }

    /* compiled from: NameResolver.java */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f33632a;

        /* renamed from: b, reason: collision with root package name */
        public final j9.E f33633b;

        /* renamed from: c, reason: collision with root package name */
        public final N f33634c;

        /* renamed from: d, reason: collision with root package name */
        public final h f33635d;

        /* renamed from: e, reason: collision with root package name */
        public final ScheduledExecutorService f33636e;

        /* renamed from: f, reason: collision with root package name */
        public final ChannelLogger f33637f;

        /* renamed from: g, reason: collision with root package name */
        public final Executor f33638g;

        /* renamed from: h, reason: collision with root package name */
        public final String f33639h;

        /* compiled from: NameResolver.java */
        /* loaded from: classes4.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public Integer f33640a;

            /* renamed from: b, reason: collision with root package name */
            public j9.E f33641b;

            /* renamed from: c, reason: collision with root package name */
            public N f33642c;

            /* renamed from: d, reason: collision with root package name */
            public h f33643d;

            /* renamed from: e, reason: collision with root package name */
            public ScheduledExecutorService f33644e;

            /* renamed from: f, reason: collision with root package name */
            public ChannelLogger f33645f;

            /* renamed from: g, reason: collision with root package name */
            public Executor f33646g;

            /* renamed from: h, reason: collision with root package name */
            public String f33647h;

            public b a() {
                return new b(this.f33640a, this.f33641b, this.f33642c, this.f33643d, this.f33644e, this.f33645f, this.f33646g, this.f33647h, null);
            }

            public a b(ChannelLogger channelLogger) {
                this.f33645f = (ChannelLogger) com.google.common.base.k.o(channelLogger);
                return this;
            }

            public a c(int i10) {
                this.f33640a = Integer.valueOf(i10);
                return this;
            }

            public a d(Executor executor) {
                this.f33646g = executor;
                return this;
            }

            public a e(String str) {
                this.f33647h = str;
                return this;
            }

            public a f(j9.E e10) {
                this.f33641b = (j9.E) com.google.common.base.k.o(e10);
                return this;
            }

            public a g(ScheduledExecutorService scheduledExecutorService) {
                this.f33644e = (ScheduledExecutorService) com.google.common.base.k.o(scheduledExecutorService);
                return this;
            }

            public a h(h hVar) {
                this.f33643d = (h) com.google.common.base.k.o(hVar);
                return this;
            }

            public a i(N n10) {
                this.f33642c = (N) com.google.common.base.k.o(n10);
                return this;
            }
        }

        public /* synthetic */ b(Integer num, j9.E e10, N n10, h hVar, ScheduledExecutorService scheduledExecutorService, ChannelLogger channelLogger, Executor executor, String str, a aVar) {
            this(num, e10, n10, hVar, scheduledExecutorService, channelLogger, executor, str);
        }

        public static a g() {
            return new a();
        }

        public int a() {
            return this.f33632a;
        }

        public Executor b() {
            return this.f33638g;
        }

        public j9.E c() {
            return this.f33633b;
        }

        public ScheduledExecutorService d() {
            ScheduledExecutorService scheduledExecutorService = this.f33636e;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public h e() {
            return this.f33635d;
        }

        public N f() {
            return this.f33634c;
        }

        public String toString() {
            return com.google.common.base.f.c(this).b("defaultPort", this.f33632a).d("proxyDetector", this.f33633b).d("syncContext", this.f33634c).d("serviceConfigParser", this.f33635d).d("scheduledExecutorService", this.f33636e).d("channelLogger", this.f33637f).d("executor", this.f33638g).d("overrideAuthority", this.f33639h).toString();
        }

        public b(Integer num, j9.E e10, N n10, h hVar, ScheduledExecutorService scheduledExecutorService, ChannelLogger channelLogger, Executor executor, String str) {
            this.f33632a = ((Integer) com.google.common.base.k.p(num, "defaultPort not set")).intValue();
            this.f33633b = (j9.E) com.google.common.base.k.p(e10, "proxyDetector not set");
            this.f33634c = (N) com.google.common.base.k.p(n10, "syncContext not set");
            this.f33635d = (h) com.google.common.base.k.p(hVar, "serviceConfigParser not set");
            this.f33636e = scheduledExecutorService;
            this.f33637f = channelLogger;
            this.f33638g = executor;
            this.f33639h = str;
        }
    }

    /* compiled from: NameResolver.java */
    /* loaded from: classes4.dex */
    public static abstract class d {
        public abstract String a();

        public abstract v b(URI uri, b bVar);
    }

    /* compiled from: NameResolver.java */
    /* loaded from: classes4.dex */
    public static abstract class e implements f {
        @Override // io.grpc.v.f
        public abstract void a(Status status);

        @Override // io.grpc.v.f
        @Deprecated
        public final void b(List<C1114h> list, C1107a c1107a) {
            c(g.d().b(list).c(c1107a).a());
        }

        public abstract void c(g gVar);
    }

    /* compiled from: NameResolver.java */
    /* loaded from: classes4.dex */
    public interface f {
        void a(Status status);

        void b(List<C1114h> list, C1107a c1107a);
    }

    /* compiled from: NameResolver.java */
    /* loaded from: classes4.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final List<C1114h> f33650a;

        /* renamed from: b, reason: collision with root package name */
        public final C1107a f33651b;

        /* renamed from: c, reason: collision with root package name */
        public final c f33652c;

        /* compiled from: NameResolver.java */
        /* loaded from: classes4.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public List<C1114h> f33653a = Collections.emptyList();

            /* renamed from: b, reason: collision with root package name */
            public C1107a f33654b = C1107a.f32411c;

            /* renamed from: c, reason: collision with root package name */
            public c f33655c;

            public g a() {
                return new g(this.f33653a, this.f33654b, this.f33655c);
            }

            public a b(List<C1114h> list) {
                this.f33653a = list;
                return this;
            }

            public a c(C1107a c1107a) {
                this.f33654b = c1107a;
                return this;
            }

            public a d(c cVar) {
                this.f33655c = cVar;
                return this;
            }
        }

        public g(List<C1114h> list, C1107a c1107a, c cVar) {
            this.f33650a = Collections.unmodifiableList(new ArrayList(list));
            this.f33651b = (C1107a) com.google.common.base.k.p(c1107a, "attributes");
            this.f33652c = cVar;
        }

        public static a d() {
            return new a();
        }

        public List<C1114h> a() {
            return this.f33650a;
        }

        public C1107a b() {
            return this.f33651b;
        }

        public c c() {
            return this.f33652c;
        }

        public a e() {
            return d().b(this.f33650a).c(this.f33651b).d(this.f33652c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            if (!com.google.common.base.h.a(this.f33650a, gVar.f33650a) || !com.google.common.base.h.a(this.f33651b, gVar.f33651b) || !com.google.common.base.h.a(this.f33652c, gVar.f33652c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f33650a, this.f33651b, this.f33652c);
        }

        public String toString() {
            return com.google.common.base.f.c(this).d("addresses", this.f33650a).d("attributes", this.f33651b).d("serviceConfig", this.f33652c).toString();
        }
    }

    /* compiled from: NameResolver.java */
    /* loaded from: classes4.dex */
    public static abstract class h {
        public abstract c a(Map<String, ?> map);
    }

    public abstract String a();

    public abstract void c();

    public void d(e eVar) {
        e(eVar);
    }

    public void e(f fVar) {
        if (fVar instanceof e) {
            d((e) fVar);
        } else {
            d(new a(fVar));
        }
    }

    /* compiled from: NameResolver.java */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Status f33648a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f33649b;

        public c(Object obj) {
            this.f33649b = com.google.common.base.k.p(obj, Constants.MessagerConstants.CONFIG_KEY);
            this.f33648a = null;
        }

        public static c a(Object obj) {
            return new c(obj);
        }

        public static c b(Status status) {
            return new c(status);
        }

        public Object c() {
            return this.f33649b;
        }

        public Status d() {
            return this.f33648a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (com.google.common.base.h.a(this.f33648a, cVar.f33648a) && com.google.common.base.h.a(this.f33649b, cVar.f33649b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return com.google.common.base.h.b(this.f33648a, this.f33649b);
        }

        public String toString() {
            if (this.f33649b != null) {
                return com.google.common.base.f.c(this).d(Constants.MessagerConstants.CONFIG_KEY, this.f33649b).toString();
            }
            return com.google.common.base.f.c(this).d("error", this.f33648a).toString();
        }

        public c(Status status) {
            this.f33649b = null;
            this.f33648a = (Status) com.google.common.base.k.p(status, AFConstants.EXTRA_STATUS);
            com.google.common.base.k.k(!status.o(), "cannot use OK status: %s", status);
        }
    }

    public void b() {
    }
}
