package io.grpc.internal;

import io.grpc.AbstractC1109c;
import io.grpc.Context;
import io.grpc.Status;
import j9.C1203m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: DelayedClientCall.java */
/* renamed from: io.grpc.internal.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1134p<ReqT, RespT> extends AbstractC1109c<ReqT, RespT> {

    /* renamed from: j, reason: collision with root package name */
    public static final Logger f33268j = Logger.getLogger(C1134p.class.getName());

    /* renamed from: k, reason: collision with root package name */
    public static final AbstractC1109c<Object, Object> f33269k = new i();

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture<?> f33270a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f33271b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f33272c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f33273d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractC1109c.a<RespT> f33274e;

    /* renamed from: f, reason: collision with root package name */
    public AbstractC1109c<ReqT, RespT> f33275f;

    /* renamed from: g, reason: collision with root package name */
    public Status f33276g;

    /* renamed from: h, reason: collision with root package name */
    public List<Runnable> f33277h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public k<RespT> f33278i;

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$a */
    /* loaded from: classes4.dex */
    public class a extends AbstractRunnableC1133o {
        public a(Context context) {
            super(context);
        }

        @Override // io.grpc.internal.AbstractRunnableC1133o
        public void a() {
            C1134p.this.m();
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$b */
    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f33280a;

        public b(StringBuilder sb) {
            this.f33280a = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1134p.this.k(Status.f32372i.r(this.f33280a.toString()), true);
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$c */
    /* loaded from: classes4.dex */
    public class c extends AbstractRunnableC1133o {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f33282b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(k kVar) {
            super(C1134p.this.f33272c);
            this.f33282b = kVar;
        }

        @Override // io.grpc.internal.AbstractRunnableC1133o
        public void a() {
            this.f33282b.g();
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$d */
    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC1109c.a f33284a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ io.grpc.u f33285b;

        public d(AbstractC1109c.a aVar, io.grpc.u uVar) {
            this.f33284a = aVar;
            this.f33285b = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1134p.this.f33275f.e(this.f33284a, this.f33285b);
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$e */
    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Status f33287a;

        public e(Status status) {
            this.f33287a = status;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1134p.this.f33275f.a(this.f33287a.n(), this.f33287a.l());
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$f */
    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f33289a;

        public f(Object obj) {
            this.f33289a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            C1134p.this.f33275f.d(this.f33289a);
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$g */
    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33291a;

        public g(int i10) {
            this.f33291a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1134p.this.f33275f.c(this.f33291a);
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$h */
    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1134p.this.f33275f.b();
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$j */
    /* loaded from: classes4.dex */
    public final class j extends AbstractRunnableC1133o {

        /* renamed from: b, reason: collision with root package name */
        public final AbstractC1109c.a<RespT> f33294b;

        /* renamed from: c, reason: collision with root package name */
        public final Status f33295c;

        public j(AbstractC1109c.a<RespT> aVar, Status status) {
            super(C1134p.this.f33272c);
            this.f33294b = aVar;
            this.f33295c = status;
        }

        @Override // io.grpc.internal.AbstractRunnableC1133o
        public void a() {
            this.f33294b.a(this.f33295c, new io.grpc.u());
        }
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$k */
    /* loaded from: classes4.dex */
    public static final class k<RespT> extends AbstractC1109c.a<RespT> {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractC1109c.a<RespT> f33297a;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f33298b;

        /* renamed from: c, reason: collision with root package name */
        public List<Runnable> f33299c = new ArrayList();

        /* compiled from: DelayedClientCall.java */
        /* renamed from: io.grpc.internal.p$k$a */
        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f33300a;

            public a(io.grpc.u uVar) {
                this.f33300a = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f33297a.b(this.f33300a);
            }
        }

        /* compiled from: DelayedClientCall.java */
        /* renamed from: io.grpc.internal.p$k$b */
        /* loaded from: classes4.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f33302a;

            public b(Object obj) {
                this.f33302a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f33297a.c(this.f33302a);
            }
        }

        /* compiled from: DelayedClientCall.java */
        /* renamed from: io.grpc.internal.p$k$c */
        /* loaded from: classes4.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Status f33304a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f33305b;

            public c(Status status, io.grpc.u uVar) {
                this.f33304a = status;
                this.f33305b = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f33297a.a(this.f33304a, this.f33305b);
            }
        }

        /* compiled from: DelayedClientCall.java */
        /* renamed from: io.grpc.internal.p$k$d */
        /* loaded from: classes4.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f33297a.d();
            }
        }

        public k(AbstractC1109c.a<RespT> aVar) {
            this.f33297a = aVar;
        }

        @Override // io.grpc.AbstractC1109c.a
        public void a(Status status, io.grpc.u uVar) {
            f(new c(status, uVar));
        }

        @Override // io.grpc.AbstractC1109c.a
        public void b(io.grpc.u uVar) {
            if (this.f33298b) {
                this.f33297a.b(uVar);
            } else {
                f(new a(uVar));
            }
        }

        @Override // io.grpc.AbstractC1109c.a
        public void c(RespT respt) {
            if (this.f33298b) {
                this.f33297a.c(respt);
            } else {
                f(new b(respt));
            }
        }

        @Override // io.grpc.AbstractC1109c.a
        public void d() {
            if (this.f33298b) {
                this.f33297a.d();
            } else {
                f(new d());
            }
        }

        public final void f(Runnable runnable) {
            synchronized (this) {
                try {
                    if (!this.f33298b) {
                        this.f33299c.add(runnable);
                    } else {
                        runnable.run();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    try {
                        if (this.f33299c.isEmpty()) {
                            this.f33299c = null;
                            this.f33298b = true;
                            return;
                        } else {
                            list = this.f33299c;
                            this.f33299c = arrayList;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                list.clear();
                arrayList = list;
            }
        }
    }

    public C1134p(Executor executor, ScheduledExecutorService scheduledExecutorService, C1203m c1203m) {
        this.f33271b = (Executor) com.google.common.base.k.p(executor, "callExecutor");
        com.google.common.base.k.p(scheduledExecutorService, "scheduler");
        this.f33272c = Context.l();
        this.f33270a = o(scheduledExecutorService, c1203m);
    }

    @Override // io.grpc.AbstractC1109c
    public final void a(String str, Throwable th) {
        Status r10;
        Status status = Status.f32369f;
        if (str != null) {
            r10 = status.r(str);
        } else {
            r10 = status.r("Call cancelled without message");
        }
        if (th != null) {
            r10 = r10.q(th);
        }
        k(r10, false);
    }

    @Override // io.grpc.AbstractC1109c
    public final void b() {
        l(new h());
    }

    @Override // io.grpc.AbstractC1109c
    public final void c(int i10) {
        if (this.f33273d) {
            this.f33275f.c(i10);
        } else {
            l(new g(i10));
        }
    }

    @Override // io.grpc.AbstractC1109c
    public final void d(ReqT reqt) {
        if (this.f33273d) {
            this.f33275f.d(reqt);
        } else {
            l(new f(reqt));
        }
    }

    @Override // io.grpc.AbstractC1109c
    public final void e(AbstractC1109c.a<RespT> aVar, io.grpc.u uVar) {
        boolean z10;
        Status status;
        boolean z11;
        if (this.f33274e == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "already started");
        synchronized (this) {
            try {
                this.f33274e = (AbstractC1109c.a) com.google.common.base.k.p(aVar, "listener");
                status = this.f33276g;
                z11 = this.f33273d;
                if (!z11) {
                    k<RespT> kVar = new k<>(aVar);
                    this.f33278i = kVar;
                    aVar = kVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (status != null) {
            this.f33271b.execute(new j(aVar, status));
        } else if (z11) {
            this.f33275f.e(aVar, uVar);
        } else {
            l(new d(aVar, uVar));
        }
    }

    public final AbstractC1109c<ReqT, RespT> getRealCall() {
        return this.f33275f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(Status status, boolean z10) {
        boolean z11;
        AbstractC1109c.a<RespT> aVar;
        synchronized (this) {
            try {
                if (this.f33275f == null) {
                    q(f33269k);
                    aVar = this.f33274e;
                    this.f33276g = status;
                    z11 = false;
                } else {
                    if (z10) {
                        return;
                    }
                    z11 = true;
                    aVar = null;
                }
                if (z11) {
                    l(new e(status));
                } else {
                    if (aVar != null) {
                        this.f33271b.execute(new j(aVar, status));
                    }
                    m();
                }
                j();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(Runnable runnable) {
        synchronized (this) {
            try {
                if (!this.f33273d) {
                    this.f33277h.add(runnable);
                } else {
                    runnable.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.f33277h     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.f33277h = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.f33273d = r0     // Catch: java.lang.Throwable -> L24
            io.grpc.internal.p$k<RespT> r0 = r3.f33278i     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.f33271b
            io.grpc.internal.p$c r2 = new io.grpc.internal.p$c
            r2.<init>(r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List<java.lang.Runnable> r1 = r3.f33277h     // Catch: java.lang.Throwable -> L24
            r3.f33277h = r0     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r0 = r1.iterator()
        L2f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L2f
        L3f:
            r1.clear()
            r0 = r1
            goto L5
        L44:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.C1134p.m():void");
    }

    public final boolean n(C1203m c1203m, C1203m c1203m2) {
        if (c1203m2 == null) {
            return true;
        }
        if (c1203m == null) {
            return false;
        }
        return c1203m.g(c1203m2);
    }

    public final ScheduledFuture<?> o(ScheduledExecutorService scheduledExecutorService, C1203m c1203m) {
        long j10;
        String str;
        C1203m s10 = this.f33272c.s();
        if (c1203m == null && s10 == null) {
            return null;
        }
        if (c1203m != null) {
            j10 = c1203m.k(TimeUnit.NANOSECONDS);
        } else {
            j10 = Long.MAX_VALUE;
        }
        if (s10 != null) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (s10.k(timeUnit) < j10) {
                j10 = s10.k(timeUnit);
                Logger logger = f33268j;
                if (logger.isLoggable(Level.FINE)) {
                    Locale locale = Locale.US;
                    StringBuilder sb = new StringBuilder(String.format(locale, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(j10)));
                    if (c1203m == null) {
                        sb.append(" Explicit call timeout was not set.");
                    } else {
                        sb.append(String.format(locale, " Explicit call timeout was '%d' ns.", Long.valueOf(c1203m.k(timeUnit))));
                    }
                    logger.fine(sb.toString());
                }
            }
        }
        long abs = Math.abs(j10);
        TimeUnit timeUnit2 = TimeUnit.SECONDS;
        long nanos = abs / timeUnit2.toNanos(1L);
        long abs2 = Math.abs(j10) % timeUnit2.toNanos(1L);
        StringBuilder sb2 = new StringBuilder();
        if (n(s10, c1203m)) {
            str = "Context";
        } else {
            str = "CallOptions";
        }
        if (j10 < 0) {
            sb2.append("ClientCall started after ");
            sb2.append(str);
            sb2.append(" deadline was exceeded. Deadline has been exceeded for ");
        } else {
            sb2.append("Deadline ");
            sb2.append(str);
            sb2.append(" will be exceeded in ");
        }
        sb2.append(nanos);
        sb2.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
        sb2.append("s. ");
        return scheduledExecutorService.schedule(new b(sb2), j10, TimeUnit.NANOSECONDS);
    }

    public final Runnable p(AbstractC1109c<ReqT, RespT> abstractC1109c) {
        synchronized (this) {
            try {
                if (this.f33275f != null) {
                    return null;
                }
                q((AbstractC1109c) com.google.common.base.k.p(abstractC1109c, "call"));
                return new a(this.f33272c);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q(AbstractC1109c<ReqT, RespT> abstractC1109c) {
        boolean z10;
        AbstractC1109c<ReqT, RespT> abstractC1109c2 = this.f33275f;
        if (abstractC1109c2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.x(z10, "realCall already set to %s", abstractC1109c2);
        ScheduledFuture<?> scheduledFuture = this.f33270a;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f33275f = abstractC1109c;
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("realCall", this.f33275f).toString();
    }

    /* compiled from: DelayedClientCall.java */
    /* renamed from: io.grpc.internal.p$i */
    /* loaded from: classes4.dex */
    public class i extends AbstractC1109c<Object, Object> {
        @Override // io.grpc.AbstractC1109c
        public void c(int i10) {
        }

        @Override // io.grpc.AbstractC1109c
        public void d(Object obj) {
        }

        @Override // io.grpc.AbstractC1109c
        public void b() {
        }

        @Override // io.grpc.AbstractC1109c
        public void a(String str, Throwable th) {
        }

        @Override // io.grpc.AbstractC1109c
        public void e(AbstractC1109c.a<Object> aVar, io.grpc.u uVar) {
        }
    }

    public void j() {
    }
}
