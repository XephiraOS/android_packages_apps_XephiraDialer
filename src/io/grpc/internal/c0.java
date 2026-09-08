package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.u0;
import io.grpc.u;
import j9.C1203m;
import j9.InterfaceC1199i;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RetriableStream.java */
/* loaded from: classes4.dex */
public abstract class c0<ReqT> implements InterfaceC1128j {

    /* renamed from: A, reason: collision with root package name */
    public static final Status f33030A;

    /* renamed from: B, reason: collision with root package name */
    public static Random f33031B;
    static final u.g<String> GRPC_PREVIOUS_RPC_ATTEMPTS;
    static final u.g<String> GRPC_RETRY_PUSHBACK_MS;

    /* renamed from: a, reason: collision with root package name */
    public final MethodDescriptor<ReqT, ?> f33032a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f33033b;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f33035d;

    /* renamed from: e, reason: collision with root package name */
    public final io.grpc.u f33036e;

    /* renamed from: f, reason: collision with root package name */
    public final d0 f33037f;

    /* renamed from: g, reason: collision with root package name */
    public final io.grpc.internal.D f33038g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f33039h;

    /* renamed from: j, reason: collision with root package name */
    public final t f33041j;

    /* renamed from: k, reason: collision with root package name */
    public final long f33042k;

    /* renamed from: l, reason: collision with root package name */
    public final long f33043l;

    /* renamed from: m, reason: collision with root package name */
    public final D f33044m;

    /* renamed from: s, reason: collision with root package name */
    public y f33050s;

    /* renamed from: t, reason: collision with root package name */
    public long f33051t;

    /* renamed from: u, reason: collision with root package name */
    public ClientStreamListener f33052u;

    /* renamed from: v, reason: collision with root package name */
    public u f33053v;

    /* renamed from: w, reason: collision with root package name */
    public u f33054w;

    /* renamed from: x, reason: collision with root package name */
    public long f33055x;

    /* renamed from: y, reason: collision with root package name */
    public Status f33056y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f33057z;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f33034c = new j9.N(new C1118a());

    /* renamed from: i, reason: collision with root package name */
    public final Object f33040i = new Object();

    /* renamed from: n, reason: collision with root package name */
    public final F f33045n = new F();

    /* renamed from: o, reason: collision with root package name */
    public volatile A f33046o = new A(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);

    /* renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f33047p = new AtomicBoolean();

    /* renamed from: q, reason: collision with root package name */
    public final AtomicInteger f33048q = new AtomicInteger();

    /* renamed from: r, reason: collision with root package name */
    public final AtomicInteger f33049r = new AtomicInteger();

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public static final class A {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f33058a;

        /* renamed from: b, reason: collision with root package name */
        public final List<r> f33059b;

        /* renamed from: c, reason: collision with root package name */
        public final Collection<C> f33060c;

        /* renamed from: d, reason: collision with root package name */
        public final Collection<C> f33061d;

        /* renamed from: e, reason: collision with root package name */
        public final int f33062e;

        /* renamed from: f, reason: collision with root package name */
        public final C f33063f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f33064g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f33065h;

        public A(List<r> list, Collection<C> collection, Collection<C> collection2, C c10, boolean z10, boolean z11, boolean z12, int i10) {
            boolean z13;
            boolean z14;
            boolean z15;
            this.f33059b = list;
            this.f33060c = (Collection) com.google.common.base.k.p(collection, "drainedSubstreams");
            this.f33063f = c10;
            this.f33061d = collection2;
            this.f33064g = z10;
            this.f33058a = z11;
            this.f33065h = z12;
            this.f33062e = i10;
            if (z11 && list != null) {
                z13 = false;
            } else {
                z13 = true;
            }
            com.google.common.base.k.v(z13, "passThrough should imply buffer is null");
            if (z11 && c10 == null) {
                z14 = false;
            } else {
                z14 = true;
            }
            com.google.common.base.k.v(z14, "passThrough should imply winningSubstream != null");
            if (z11 && ((collection.size() != 1 || !collection.contains(c10)) && (collection.size() != 0 || !c10.f33080b))) {
                z15 = false;
            } else {
                z15 = true;
            }
            com.google.common.base.k.v(z15, "passThrough should imply winningSubstream is drained");
            com.google.common.base.k.v((z10 && c10 == null) ? false : true, "cancelled should imply committed");
        }

        public A a(C c10) {
            boolean z10;
            Collection unmodifiableCollection;
            com.google.common.base.k.v(!this.f33065h, "hedging frozen");
            if (this.f33063f == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "already committed");
            if (this.f33061d == null) {
                unmodifiableCollection = Collections.singleton(c10);
            } else {
                ArrayList arrayList = new ArrayList(this.f33061d);
                arrayList.add(c10);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new A(this.f33059b, this.f33060c, unmodifiableCollection, this.f33063f, this.f33064g, this.f33058a, this.f33065h, this.f33062e + 1);
        }

        public A b() {
            return new A(this.f33059b, this.f33060c, this.f33061d, this.f33063f, true, this.f33058a, this.f33065h, this.f33062e);
        }

        public A c(C c10) {
            boolean z10;
            List<r> list;
            boolean z11;
            Collection emptyList;
            if (this.f33063f == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "Already committed");
            List<r> list2 = this.f33059b;
            if (this.f33060c.contains(c10)) {
                emptyList = Collections.singleton(c10);
                list = null;
                z11 = true;
            } else {
                list = list2;
                z11 = false;
                emptyList = Collections.emptyList();
            }
            return new A(list, emptyList, this.f33061d, c10, this.f33064g, z11, this.f33065h, this.f33062e);
        }

        public A d() {
            if (this.f33065h) {
                return this;
            }
            return new A(this.f33059b, this.f33060c, this.f33061d, this.f33063f, this.f33064g, this.f33058a, true, this.f33062e);
        }

        public A e(C c10) {
            ArrayList arrayList = new ArrayList(this.f33061d);
            arrayList.remove(c10);
            return new A(this.f33059b, this.f33060c, Collections.unmodifiableCollection(arrayList), this.f33063f, this.f33064g, this.f33058a, this.f33065h, this.f33062e);
        }

        public A f(C c10, C c11) {
            ArrayList arrayList = new ArrayList(this.f33061d);
            arrayList.remove(c10);
            arrayList.add(c11);
            return new A(this.f33059b, this.f33060c, Collections.unmodifiableCollection(arrayList), this.f33063f, this.f33064g, this.f33058a, this.f33065h, this.f33062e);
        }

        public A g(C c10) {
            c10.f33080b = true;
            if (this.f33060c.contains(c10)) {
                ArrayList arrayList = new ArrayList(this.f33060c);
                arrayList.remove(c10);
                return new A(this.f33059b, Collections.unmodifiableCollection(arrayList), this.f33061d, this.f33063f, this.f33064g, this.f33058a, this.f33065h, this.f33062e);
            }
            return this;
        }

        public A h(C c10) {
            Collection unmodifiableCollection;
            boolean z10;
            boolean z11 = true;
            com.google.common.base.k.v(!this.f33058a, "Already passThrough");
            if (c10.f33080b) {
                unmodifiableCollection = this.f33060c;
            } else if (this.f33060c.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(c10);
            } else {
                ArrayList arrayList = new ArrayList(this.f33060c);
                arrayList.add(c10);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = unmodifiableCollection;
            C c11 = this.f33063f;
            if (c11 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            List<r> list = this.f33059b;
            if (z10) {
                if (c11 != c10) {
                    z11 = false;
                }
                com.google.common.base.k.v(z11, "Another RPC attempt has already committed");
                list = null;
            }
            return new A(list, collection, this.f33061d, this.f33063f, this.f33064g, z10, this.f33065h, this.f33062e);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public final class B implements ClientStreamListener {

        /* renamed from: a, reason: collision with root package name */
        public final C f33066a;

        /* compiled from: RetriableStream.java */
        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f33068a;

            public a(io.grpc.u uVar) {
                this.f33068a = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.f33052u.d(this.f33068a);
            }
        }

        /* compiled from: RetriableStream.java */
        /* loaded from: classes4.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f33070a;

            /* compiled from: RetriableStream.java */
            /* loaded from: classes4.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    c0.this.K(bVar.f33070a);
                }
            }

            public b(C c10) {
                this.f33070a = c10;
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.f33033b.execute(new a());
            }
        }

        /* compiled from: RetriableStream.java */
        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.f33057z = true;
                c0.this.f33052u.f(c0.this.f33050s.f33135a, c0.this.f33050s.f33136b, c0.this.f33050s.f33137c);
            }
        }

        /* compiled from: RetriableStream.java */
        /* loaded from: classes4.dex */
        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f33074a;

            public d(C c10) {
                this.f33074a = c10;
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.K(this.f33074a);
            }
        }

        /* compiled from: RetriableStream.java */
        /* loaded from: classes4.dex */
        public class e implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u0.a f33076a;

            public e(u0.a aVar) {
                this.f33076a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c0.this.f33052u.c(this.f33076a);
            }
        }

        /* compiled from: RetriableStream.java */
        /* loaded from: classes4.dex */
        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!c0.this.f33057z) {
                    c0.this.f33052u.e();
                }
            }
        }

        public B(C c10) {
            this.f33066a = c10;
        }

        @Override // io.grpc.internal.u0
        public void c(u0.a aVar) {
            boolean z10;
            A a10 = c0.this.f33046o;
            if (a10.f33063f != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "Headers should be received prior to messages.");
            if (a10.f33063f != this.f33066a) {
                GrpcUtil.d(aVar);
            } else {
                c0.this.f33034c.execute(new e(aVar));
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void d(io.grpc.u uVar) {
            if (this.f33066a.f33082d > 0) {
                u.g<String> gVar = c0.GRPC_PREVIOUS_RPC_ATTEMPTS;
                uVar.f(gVar);
                uVar.o(gVar, String.valueOf(this.f33066a.f33082d));
            }
            c0.this.H(this.f33066a);
            if (c0.this.f33046o.f33063f == this.f33066a) {
                if (c0.this.f33044m != null) {
                    c0.this.f33044m.onSuccess();
                }
                c0.this.f33034c.execute(new a(uVar));
            }
        }

        @Override // io.grpc.internal.u0
        public void e() {
            if (!c0.this.isReady()) {
                return;
            }
            c0.this.f33034c.execute(new f());
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void f(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
            u uVar2;
            synchronized (c0.this.f33040i) {
                c0 c0Var = c0.this;
                c0Var.f33046o = c0Var.f33046o.g(this.f33066a);
                c0.this.f33045n.a(status.m());
            }
            if (c0.this.f33049r.decrementAndGet() == Integer.MIN_VALUE) {
                c0.this.f33034c.execute(new c());
                return;
            }
            C c10 = this.f33066a;
            if (c10.f33081c) {
                c0.this.H(c10);
                if (c0.this.f33046o.f33063f == this.f33066a) {
                    c0.this.R(status, rpcProgress, uVar);
                    return;
                }
                return;
            }
            ClientStreamListener.RpcProgress rpcProgress2 = ClientStreamListener.RpcProgress.MISCARRIED;
            if (rpcProgress != rpcProgress2 || c0.this.f33048q.incrementAndGet() <= 1000) {
                if (c0.this.f33046o.f33063f == null) {
                    if (rpcProgress == rpcProgress2 || (rpcProgress == ClientStreamListener.RpcProgress.REFUSED && c0.this.f33047p.compareAndSet(false, true))) {
                        C I10 = c0.this.I(this.f33066a.f33082d, true);
                        if (I10 == null) {
                            return;
                        }
                        if (c0.this.f33039h) {
                            synchronized (c0.this.f33040i) {
                                c0 c0Var2 = c0.this;
                                c0Var2.f33046o = c0Var2.f33046o.f(this.f33066a, I10);
                            }
                        }
                        c0.this.f33033b.execute(new d(I10));
                        return;
                    }
                    if (rpcProgress == ClientStreamListener.RpcProgress.DROPPED) {
                        if (c0.this.f33039h) {
                            c0.this.L();
                        }
                    } else {
                        c0.this.f33047p.set(true);
                        if (c0.this.f33039h) {
                            v h10 = h(status, uVar);
                            if (h10.f33127a) {
                                c0.this.Q(h10.f33128b);
                            }
                            synchronized (c0.this.f33040i) {
                                try {
                                    c0 c0Var3 = c0.this;
                                    c0Var3.f33046o = c0Var3.f33046o.e(this.f33066a);
                                    if (h10.f33127a) {
                                        c0 c0Var4 = c0.this;
                                        if (!c0Var4.M(c0Var4.f33046o)) {
                                            if (!c0.this.f33046o.f33061d.isEmpty()) {
                                            }
                                        }
                                        return;
                                    }
                                } finally {
                                }
                            }
                        } else {
                            x i10 = i(status, uVar);
                            if (i10.f33133a) {
                                C I11 = c0.this.I(this.f33066a.f33082d + 1, false);
                                if (I11 == null) {
                                    return;
                                }
                                synchronized (c0.this.f33040i) {
                                    c0 c0Var5 = c0.this;
                                    uVar2 = new u(c0Var5.f33040i);
                                    c0Var5.f33053v = uVar2;
                                }
                                uVar2.c(c0.this.f33035d.schedule(new b(I11), i10.f33134b, TimeUnit.NANOSECONDS));
                                return;
                            }
                        }
                    }
                }
                c0.this.H(this.f33066a);
                if (c0.this.f33046o.f33063f == this.f33066a) {
                    c0.this.R(status, rpcProgress, uVar);
                    return;
                }
                return;
            }
            c0.this.H(this.f33066a);
            if (c0.this.f33046o.f33063f == this.f33066a) {
                c0.this.R(Status.f32382s.r("Too many transparent retries. Might be a bug in gRPC").q(status.c()), rpcProgress, uVar);
            }
        }

        public final Integer g(io.grpc.u uVar) {
            String str = (String) uVar.h(c0.GRPC_RETRY_PUSHBACK_MS);
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }
            return null;
        }

        public final v h(Status status, io.grpc.u uVar) {
            boolean z10;
            Integer g10 = g(uVar);
            boolean z11 = true;
            boolean z12 = !c0.this.f33038g.f32478c.contains(status.m());
            if (c0.this.f33044m != null && (!z12 || (g10 != null && g10.intValue() < 0))) {
                z10 = !c0.this.f33044m.onQualifiedFailureThenCheckIsAboveThreshold();
            } else {
                z10 = false;
            }
            if (!z12 && !z10 && !status.o() && g10 != null && g10.intValue() > 0) {
                g10 = 0;
            }
            if (z12 || z10) {
                z11 = false;
            }
            return new v(z11, g10);
        }

        public final x i(Status status, io.grpc.u uVar) {
            boolean z10;
            long j10 = 0;
            boolean z11 = false;
            if (c0.this.f33037f == null) {
                return new x(false, 0L);
            }
            boolean contains = c0.this.f33037f.f33145f.contains(status.m());
            Integer g10 = g(uVar);
            if (c0.this.f33044m != null && (contains || (g10 != null && g10.intValue() < 0))) {
                z10 = !c0.this.f33044m.onQualifiedFailureThenCheckIsAboveThreshold();
            } else {
                z10 = false;
            }
            if (c0.this.f33037f.f33140a > this.f33066a.f33082d + 1 && !z10) {
                if (g10 == null) {
                    if (contains) {
                        j10 = (long) (c0.this.f33055x * c0.f33031B.nextDouble());
                        c0.this.f33055x = Math.min((long) (r10.f33055x * c0.this.f33037f.f33143d), c0.this.f33037f.f33142c);
                        z11 = true;
                    }
                } else if (g10.intValue() >= 0) {
                    j10 = TimeUnit.MILLISECONDS.toNanos(g10.intValue());
                    c0 c0Var = c0.this;
                    c0Var.f33055x = c0Var.f33037f.f33141b;
                    z11 = true;
                }
            }
            return new x(z11, j10);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public static final class C {

        /* renamed from: a, reason: collision with root package name */
        public InterfaceC1128j f33079a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f33080b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f33081c;

        /* renamed from: d, reason: collision with root package name */
        public final int f33082d;

        public C(int i10) {
            this.f33082d = i10;
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public static final class D {

        /* renamed from: a, reason: collision with root package name */
        public final int f33083a;

        /* renamed from: b, reason: collision with root package name */
        public final int f33084b;

        /* renamed from: c, reason: collision with root package name */
        public final int f33085c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicInteger f33086d;

        public D(float f10, float f11) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f33086d = atomicInteger;
            this.f33085c = (int) (f11 * 1000.0f);
            int i10 = (int) (f10 * 1000.0f);
            this.f33083a = i10;
            this.f33084b = i10 / 2;
            atomicInteger.set(i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof D)) {
                return false;
            }
            D d10 = (D) obj;
            if (this.f33083a == d10.f33083a && this.f33085c == d10.f33085c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return com.google.common.base.h.b(Integer.valueOf(this.f33083a), Integer.valueOf(this.f33085c));
        }

        public boolean isAboveThreshold() {
            if (this.f33086d.get() > this.f33084b) {
                return true;
            }
            return false;
        }

        public boolean onQualifiedFailureThenCheckIsAboveThreshold() {
            int i10;
            int i11;
            do {
                i10 = this.f33086d.get();
                if (i10 == 0) {
                    return false;
                }
                i11 = i10 - 1000;
            } while (!this.f33086d.compareAndSet(i10, Math.max(i11, 0)));
            if (i11 <= this.f33084b) {
                return false;
            }
            return true;
        }

        public void onSuccess() {
            int i10;
            int i11;
            do {
                i10 = this.f33086d.get();
                i11 = this.f33083a;
                if (i10 != i11) {
                } else {
                    return;
                }
            } while (!this.f33086d.compareAndSet(i10, Math.min(this.f33085c + i10, i11)));
        }
    }

    /* compiled from: RetriableStream.java */
    /* renamed from: io.grpc.internal.c0$a, reason: case insensitive filesystem */
    /* loaded from: classes4.dex */
    public class C1118a implements Thread.UncaughtExceptionHandler {
        public C1118a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw Status.k(th).r("Uncaught exception in the SynchronizationContext. Re-thrown.").c();
        }
    }

    /* compiled from: RetriableStream.java */
    /* renamed from: io.grpc.internal.c0$b, reason: case insensitive filesystem */
    /* loaded from: classes4.dex */
    public class C1119b implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33088a;

        public C1119b(String str) {
            this.f33088a = str;
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.setAuthority(this.f33088a);
        }
    }

    /* compiled from: RetriableStream.java */
    /* renamed from: io.grpc.internal.c0$c, reason: case insensitive filesystem */
    /* loaded from: classes4.dex */
    public class RunnableC1120c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f33090a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C f33091b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Future f33092c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Future f33093d;

        public RunnableC1120c(Collection collection, C c10, Future future, Future future2) {
            this.f33090a = collection;
            this.f33091b = c10;
            this.f33092c = future;
            this.f33093d = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (C c10 : this.f33090a) {
                if (c10 != this.f33091b) {
                    c10.f33079a.cancel(c0.f33030A);
                }
            }
            Future future = this.f33092c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f33093d;
            if (future2 != null) {
                future2.cancel(false);
            }
            c0.this.O();
        }
    }

    /* compiled from: RetriableStream.java */
    /* renamed from: io.grpc.internal.c0$d, reason: case insensitive filesystem */
    /* loaded from: classes4.dex */
    public class C1121d implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1199i f33095a;

        public C1121d(InterfaceC1199i interfaceC1199i) {
            this.f33095a = interfaceC1199i;
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.setCompressor(this.f33095a);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class e implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1203m f33097a;

        public e(C1203m c1203m) {
            this.f33097a = c1203m;
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.setDeadline(this.f33097a);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class f implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j9.o f33099a;

        public f(j9.o oVar) {
            this.f33099a = oVar;
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.setDecompressorRegistry(this.f33099a);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class g implements r {
        public g() {
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.flush();
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class h implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f33102a;

        public h(boolean z10) {
            this.f33102a = z10;
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.setFullStreamDecompression(this.f33102a);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class i implements r {
        public i() {
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.halfClose();
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class j implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33105a;

        public j(int i10) {
            this.f33105a = i10;
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.setMaxInboundMessageSize(this.f33105a);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class k implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33107a;

        public k(int i10) {
            this.f33107a = i10;
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.setMaxOutboundMessageSize(this.f33107a);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class l implements r {
        public l() {
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.optimizeForDirectExecutor();
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class m implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33110a;

        public m(int i10) {
            this.f33110a = i10;
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.request(this.f33110a);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class n implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f33112a;

        public n(Object obj) {
            this.f33112a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.writeMessage(c0.this.f33032a.j(this.f33112a));
            c10.f33079a.flush();
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class o extends AbstractC1112f.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1112f f33114a;

        public o(AbstractC1112f abstractC1112f) {
            this.f33114a = abstractC1112f;
        }

        @Override // io.grpc.AbstractC1112f.a
        public AbstractC1112f a(AbstractC1112f.b bVar, io.grpc.u uVar) {
            return this.f33114a;
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!c0.this.f33057z) {
                c0.this.f33052u.e();
            }
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Status f33117a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ClientStreamListener.RpcProgress f33118b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ io.grpc.u f33119c;

        public q(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
            this.f33117a = status;
            this.f33118b = rpcProgress;
            this.f33119c = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f33057z = true;
            c0.this.f33052u.f(this.f33117a, this.f33118b, this.f33119c);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public interface r {
        void a(C c10);
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class s extends AbstractC1112f {

        /* renamed from: b, reason: collision with root package name */
        public final C f33121b;

        public s(C c10) {
            this.f33121b = c10;
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public static final class t {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicLong f33123a = new AtomicLong();

        public long addAndGet(long j10) {
            return this.f33123a.addAndGet(j10);
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public static final class u {

        /* renamed from: a, reason: collision with root package name */
        public final Object f33124a;

        /* renamed from: b, reason: collision with root package name */
        public Future<?> f33125b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f33126c;

        public u(Object obj) {
            this.f33124a = obj;
        }

        public boolean a() {
            return this.f33126c;
        }

        public Future<?> b() {
            this.f33126c = true;
            return this.f33125b;
        }

        public void c(Future<?> future) {
            synchronized (this.f33124a) {
                try {
                    if (!this.f33126c) {
                        this.f33125b = future;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public static final class v {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f33127a;

        /* renamed from: b, reason: collision with root package name */
        public final Integer f33128b;

        public v(boolean z10, Integer num) {
            this.f33127a = z10;
            this.f33128b = num;
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public final class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final u f33129a;

        /* compiled from: RetriableStream.java */
        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f33131a;

            public a(C c10) {
                this.f33131a = c10;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar;
                boolean z10;
                synchronized (c0.this.f33040i) {
                    try {
                        uVar = null;
                        if (w.this.f33129a.a()) {
                            z10 = true;
                        } else {
                            c0 c0Var = c0.this;
                            c0Var.f33046o = c0Var.f33046o.a(this.f33131a);
                            c0 c0Var2 = c0.this;
                            if (!c0Var2.M(c0Var2.f33046o) || (c0.this.f33044m != null && !c0.this.f33044m.isAboveThreshold())) {
                                c0 c0Var3 = c0.this;
                                c0Var3.f33046o = c0Var3.f33046o.d();
                                c0.this.f33054w = null;
                                z10 = false;
                            }
                            c0 c0Var4 = c0.this;
                            uVar = new u(c0Var4.f33040i);
                            c0Var4.f33054w = uVar;
                            z10 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z10) {
                    this.f33131a.f33079a.start(new B(this.f33131a));
                    this.f33131a.f33079a.cancel(Status.f32369f.r("Unneeded hedging"));
                } else {
                    if (uVar != null) {
                        uVar.c(c0.this.f33035d.schedule(new w(uVar), c0.this.f33038g.f32477b, TimeUnit.NANOSECONDS));
                    }
                    c0.this.K(this.f33131a);
                }
            }
        }

        public w(u uVar) {
            this.f33129a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0 c0Var = c0.this;
            C I10 = c0Var.I(c0Var.f33046o.f33062e, false);
            if (I10 == null) {
                return;
            }
            c0.this.f33033b.execute(new a(I10));
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public static final class x {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f33133a;

        /* renamed from: b, reason: collision with root package name */
        public final long f33134b;

        public x(boolean z10, long j10) {
            this.f33133a = z10;
            this.f33134b = j10;
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public static final class y {

        /* renamed from: a, reason: collision with root package name */
        public final Status f33135a;

        /* renamed from: b, reason: collision with root package name */
        public final ClientStreamListener.RpcProgress f33136b;

        /* renamed from: c, reason: collision with root package name */
        public final io.grpc.u f33137c;

        public y(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
            this.f33135a = status;
            this.f33136b = rpcProgress;
            this.f33137c = uVar;
        }
    }

    /* compiled from: RetriableStream.java */
    /* loaded from: classes4.dex */
    public class z implements r {
        public z() {
        }

        @Override // io.grpc.internal.c0.r
        public void a(C c10) {
            c10.f33079a.start(new B(c10));
        }
    }

    static {
        u.d<String> dVar = io.grpc.u.f33499e;
        GRPC_PREVIOUS_RPC_ATTEMPTS = u.g.c("grpc-previous-rpc-attempts", dVar);
        GRPC_RETRY_PUSHBACK_MS = u.g.c("grpc-retry-pushback-ms", dVar);
        f33030A = Status.f32369f.r("Stream thrown away because RetriableStream committed");
        f33031B = new Random();
    }

    public c0(MethodDescriptor<ReqT, ?> methodDescriptor, io.grpc.u uVar, t tVar, long j10, long j11, Executor executor, ScheduledExecutorService scheduledExecutorService, d0 d0Var, io.grpc.internal.D d10, D d11) {
        this.f33032a = methodDescriptor;
        this.f33041j = tVar;
        this.f33042k = j10;
        this.f33043l = j11;
        this.f33033b = executor;
        this.f33035d = scheduledExecutorService;
        this.f33036e = uVar;
        this.f33037f = d0Var;
        if (d0Var != null) {
            this.f33055x = d0Var.f33141b;
        }
        this.f33038g = d10;
        com.google.common.base.k.e(d0Var == null || d10 == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f33039h = d10 != null;
        this.f33044m = d11;
    }

    public static void setRandom(Random random) {
        f33031B = random;
    }

    public final Runnable G(C c10) {
        Future<?> future;
        Future<?> future2;
        synchronized (this.f33040i) {
            try {
                if (this.f33046o.f33063f != null) {
                    return null;
                }
                Collection<C> collection = this.f33046o.f33060c;
                this.f33046o = this.f33046o.c(c10);
                this.f33041j.addAndGet(-this.f33051t);
                u uVar = this.f33053v;
                if (uVar != null) {
                    Future<?> b10 = uVar.b();
                    this.f33053v = null;
                    future = b10;
                } else {
                    future = null;
                }
                u uVar2 = this.f33054w;
                if (uVar2 != null) {
                    Future<?> b11 = uVar2.b();
                    this.f33054w = null;
                    future2 = b11;
                } else {
                    future2 = null;
                }
                return new RunnableC1120c(collection, c10, future, future2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void H(C c10) {
        Runnable G10 = G(c10);
        if (G10 != null) {
            this.f33033b.execute(G10);
        }
    }

    public final C I(int i10, boolean z10) {
        int i11;
        do {
            i11 = this.f33049r.get();
            if (i11 < 0) {
                return null;
            }
        } while (!this.f33049r.compareAndSet(i11, i11 + 1));
        C c10 = new C(i10);
        c10.f33079a = N(updateHeaders(this.f33036e, i10), new o(new s(c10)), i10, z10);
        return c10;
    }

    public final void J(r rVar) {
        Collection<C> collection;
        synchronized (this.f33040i) {
            try {
                if (!this.f33046o.f33058a) {
                    this.f33046o.f33059b.add(rVar);
                }
                collection = this.f33046o.f33060c;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator<C> it = collection.iterator();
        while (it.hasNext()) {
            rVar.a(it.next());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
    
        r8.f33034c.execute(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        if (r2 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        r9.f33079a.start(new io.grpc.internal.c0.B(r8, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        r0 = r9.f33079a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r8.f33046o.f33063f != r9) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        r8 = r8.f33056y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        r0.cancel(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        r8 = io.grpc.internal.c0.f33030A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
    
        r0 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        if (r0.hasNext() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0092, code lost:
    
        r4 = (io.grpc.internal.c0.r) r0.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009d, code lost:
    
        if ((r4 instanceof io.grpc.internal.c0.z) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a0, code lost:
    
        r4 = r8.f33046o;
        r5 = r4.f33063f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a4, code lost:
    
        if (r5 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a6, code lost:
    
        if (r5 == r9) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ab, code lost:
    
        if (r4.f33064g == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(io.grpc.internal.c0.C r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L4:
            java.lang.Object r4 = r8.f33040i
            monitor-enter(r4)
            io.grpc.internal.c0$A r5 = r8.f33046o     // Catch: java.lang.Throwable -> L11
            io.grpc.internal.c0$C r6 = r5.f33063f     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L14
            if (r6 == r9) goto L14
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L11:
            r8 = move-exception
            goto Lb0
        L14:
            boolean r6 = r5.f33064g     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L1a
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L1a:
            java.util.List<io.grpc.internal.c0$r> r6 = r5.f33059b     // Catch: java.lang.Throwable -> L11
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L11
            if (r0 != r6) goto L5b
            io.grpc.internal.c0$A r0 = r5.h(r9)     // Catch: java.lang.Throwable -> L11
            r8.f33046o = r0     // Catch: java.lang.Throwable -> L11
            boolean r0 = r8.isReady()     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto L30
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L30:
            io.grpc.internal.c0$p r1 = new io.grpc.internal.c0$p     // Catch: java.lang.Throwable -> L11
            r1.<init>()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
        L36:
            if (r1 == 0) goto L3e
            java.util.concurrent.Executor r8 = r8.f33034c
            r8.execute(r1)
            return
        L3e:
            if (r2 != 0) goto L4a
            io.grpc.internal.j r0 = r9.f33079a
            io.grpc.internal.c0$B r1 = new io.grpc.internal.c0$B
            r1.<init>(r9)
            r0.start(r1)
        L4a:
            io.grpc.internal.j r0 = r9.f33079a
            io.grpc.internal.c0$A r1 = r8.f33046o
            io.grpc.internal.c0$C r1 = r1.f33063f
            if (r1 != r9) goto L55
            io.grpc.Status r8 = r8.f33056y
            goto L57
        L55:
            io.grpc.Status r8 = io.grpc.internal.c0.f33030A
        L57:
            r0.cancel(r8)
            return
        L5b:
            boolean r6 = r9.f33080b     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L61
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L61:
            int r6 = r0 + 128
            java.util.List<io.grpc.internal.c0$r> r7 = r5.f33059b     // Catch: java.lang.Throwable -> L11
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L11
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L11
            if (r3 != 0) goto L7b
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L11
            java.util.List<io.grpc.internal.c0$r> r5 = r5.f33059b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L11
            goto L87
        L7b:
            r3.clear()     // Catch: java.lang.Throwable -> L11
            java.util.List<io.grpc.internal.c0$r> r5 = r5.f33059b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L11
        L87:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            java.util.Iterator r0 = r3.iterator()
        L8c:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lad
            java.lang.Object r4 = r0.next()
            io.grpc.internal.c0$r r4 = (io.grpc.internal.c0.r) r4
            r4.a(r9)
            boolean r4 = r4 instanceof io.grpc.internal.c0.z
            if (r4 == 0) goto La0
            r2 = 1
        La0:
            io.grpc.internal.c0$A r4 = r8.f33046o
            io.grpc.internal.c0$C r5 = r4.f33063f
            if (r5 == 0) goto La9
            if (r5 == r9) goto La9
            goto Lad
        La9:
            boolean r4 = r4.f33064g
            if (r4 == 0) goto L8c
        Lad:
            r0 = r6
            goto L4
        Lb0:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.c0.K(io.grpc.internal.c0$C):void");
    }

    public final void L() {
        Future<?> future;
        synchronized (this.f33040i) {
            try {
                u uVar = this.f33054w;
                future = null;
                if (uVar != null) {
                    Future<?> b10 = uVar.b();
                    this.f33054w = null;
                    future = b10;
                }
                this.f33046o = this.f33046o.d();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    public final boolean M(A a10) {
        if (a10.f33063f == null && a10.f33062e < this.f33038g.f32476a && !a10.f33065h) {
            return true;
        }
        return false;
    }

    public abstract InterfaceC1128j N(io.grpc.u uVar, AbstractC1112f.a aVar, int i10, boolean z10);

    public abstract void O();

    public abstract Status P();

    public final void Q(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            L();
            return;
        }
        synchronized (this.f33040i) {
            try {
                u uVar = this.f33054w;
                if (uVar == null) {
                    return;
                }
                Future<?> b10 = uVar.b();
                u uVar2 = new u(this.f33040i);
                this.f33054w = uVar2;
                if (b10 != null) {
                    b10.cancel(false);
                }
                uVar2.c(this.f33035d.schedule(new w(uVar2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void R(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
        this.f33050s = new y(status, rpcProgress, uVar);
        if (this.f33049r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f33034c.execute(new q(status, rpcProgress, uVar));
        }
    }

    public final void S(ReqT reqt) {
        A a10 = this.f33046o;
        if (a10.f33058a) {
            a10.f33063f.f33079a.writeMessage(this.f33032a.j(reqt));
        } else {
            J(new n(reqt));
        }
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void appendTimeoutInsight(F f10) {
        A a10;
        synchronized (this.f33040i) {
            f10.b("closed", this.f33045n);
            a10 = this.f33046o;
        }
        if (a10.f33063f != null) {
            F f11 = new F();
            a10.f33063f.f33079a.appendTimeoutInsight(f11);
            f10.b("committed", f11);
            return;
        }
        F f12 = new F();
        for (C c10 : a10.f33060c) {
            F f13 = new F();
            c10.f33079a.appendTimeoutInsight(f13);
            f12.a(f13);
        }
        f10.b("open", f12);
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void cancel(Status status) {
        C c10;
        C c11 = new C(0);
        c11.f33079a = new T();
        Runnable G10 = G(c11);
        if (G10 != null) {
            synchronized (this.f33040i) {
                this.f33046o = this.f33046o.h(c11);
            }
            G10.run();
            R(status, ClientStreamListener.RpcProgress.PROCESSED, new io.grpc.u());
            return;
        }
        synchronized (this.f33040i) {
            try {
                if (this.f33046o.f33060c.contains(this.f33046o.f33063f)) {
                    c10 = this.f33046o.f33063f;
                } else {
                    this.f33056y = status;
                    c10 = null;
                }
                this.f33046o = this.f33046o.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c10 != null) {
            c10.f33079a.cancel(status);
        }
    }

    @Override // io.grpc.internal.t0
    public final void flush() {
        A a10 = this.f33046o;
        if (a10.f33058a) {
            a10.f33063f.f33079a.flush();
        } else {
            J(new g());
        }
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void halfClose() {
        J(new i());
    }

    @Override // io.grpc.internal.t0
    public final boolean isReady() {
        Iterator<C> it = this.f33046o.f33060c.iterator();
        while (it.hasNext()) {
            if (it.next().f33079a.isReady()) {
                return true;
            }
        }
        return false;
    }

    @Override // io.grpc.internal.t0
    public void optimizeForDirectExecutor() {
        J(new l());
    }

    @Override // io.grpc.internal.t0
    public final void request(int i10) {
        A a10 = this.f33046o;
        if (a10.f33058a) {
            a10.f33063f.f33079a.request(i10);
        } else {
            J(new m(i10));
        }
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void setAuthority(String str) {
        J(new C1119b(str));
    }

    @Override // io.grpc.internal.t0
    public final void setCompressor(InterfaceC1199i interfaceC1199i) {
        J(new C1121d(interfaceC1199i));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void setDeadline(C1203m c1203m) {
        J(new e(c1203m));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void setDecompressorRegistry(j9.o oVar) {
        J(new f(oVar));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void setFullStreamDecompression(boolean z10) {
        J(new h(z10));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void setMaxInboundMessageSize(int i10) {
        J(new j(i10));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void setMaxOutboundMessageSize(int i10) {
        J(new k(i10));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public final void start(ClientStreamListener clientStreamListener) {
        u uVar;
        D d10;
        this.f33052u = clientStreamListener;
        Status P10 = P();
        if (P10 != null) {
            cancel(P10);
            return;
        }
        synchronized (this.f33040i) {
            this.f33046o.f33059b.add(new z());
        }
        C I10 = I(0, false);
        if (I10 == null) {
            return;
        }
        if (this.f33039h) {
            synchronized (this.f33040i) {
                try {
                    this.f33046o = this.f33046o.a(I10);
                    if (!M(this.f33046o) || ((d10 = this.f33044m) != null && !d10.isAboveThreshold())) {
                        uVar = null;
                    }
                    uVar = new u(this.f33040i);
                    this.f33054w = uVar;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (uVar != null) {
                uVar.c(this.f33035d.schedule(new w(uVar), this.f33038g.f32477b, TimeUnit.NANOSECONDS));
            }
        }
        K(I10);
    }

    public final io.grpc.u updateHeaders(io.grpc.u uVar, int i10) {
        io.grpc.u uVar2 = new io.grpc.u();
        uVar2.l(uVar);
        if (i10 > 0) {
            uVar2.o(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(i10));
        }
        return uVar2;
    }

    @Override // io.grpc.internal.t0
    public final void writeMessage(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }
}
