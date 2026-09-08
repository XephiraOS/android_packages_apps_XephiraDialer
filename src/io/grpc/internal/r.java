package io.grpc.internal;

import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.u0;
import j9.C1203m;
import j9.InterfaceC1199i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DelayedStream.java */
/* loaded from: classes4.dex */
public class r implements InterfaceC1128j {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f33347a;

    /* renamed from: b, reason: collision with root package name */
    public ClientStreamListener f33348b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC1128j f33349c;

    /* renamed from: d, reason: collision with root package name */
    public Status f33350d;

    /* renamed from: f, reason: collision with root package name */
    public o f33352f;

    /* renamed from: g, reason: collision with root package name */
    public long f33353g;

    /* renamed from: h, reason: collision with root package name */
    public long f33354h;

    /* renamed from: e, reason: collision with root package name */
    public List<Runnable> f33351e = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public List<Runnable> f33355i = new ArrayList();

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33356a;

        public a(int i10) {
            this.f33356a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.request(this.f33356a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.optimizeForDirectExecutor();
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1199i f33359a;

        public c(InterfaceC1199i interfaceC1199i) {
            this.f33359a = interfaceC1199i;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.setCompressor(this.f33359a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f33361a;

        public d(boolean z10) {
            this.f33361a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.setFullStreamDecompression(this.f33361a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j9.o f33363a;

        public e(j9.o oVar) {
            this.f33363a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.setDecompressorRegistry(this.f33363a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33365a;

        public f(int i10) {
            this.f33365a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.setMaxInboundMessageSize(this.f33365a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33367a;

        public g(int i10) {
            this.f33367a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.setMaxOutboundMessageSize(this.f33367a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1203m f33369a;

        public h(C1203m c1203m) {
            this.f33369a = c1203m;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.setDeadline(this.f33369a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.d();
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f33372a;

        public j(String str) {
            this.f33372a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.setAuthority(this.f33372a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f33374a;

        public k(InputStream inputStream) {
            this.f33374a = inputStream;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.writeMessage(this.f33374a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.flush();
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Status f33377a;

        public m(Status status) {
            this.f33377a = status;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.cancel(this.f33377a);
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f33349c.halfClose();
        }
    }

    /* compiled from: DelayedStream.java */
    /* loaded from: classes4.dex */
    public static class o implements ClientStreamListener {

        /* renamed from: a, reason: collision with root package name */
        public final ClientStreamListener f33380a;

        /* renamed from: b, reason: collision with root package name */
        public volatile boolean f33381b;

        /* renamed from: c, reason: collision with root package name */
        public List<Runnable> f33382c = new ArrayList();

        /* compiled from: DelayedStream.java */
        /* loaded from: classes4.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u0.a f33383a;

            public a(u0.a aVar) {
                this.f33383a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f33380a.c(this.f33383a);
            }
        }

        /* compiled from: DelayedStream.java */
        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f33380a.e();
            }
        }

        /* compiled from: DelayedStream.java */
        /* loaded from: classes4.dex */
        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f33386a;

            public c(io.grpc.u uVar) {
                this.f33386a = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f33380a.d(this.f33386a);
            }
        }

        /* compiled from: DelayedStream.java */
        /* loaded from: classes4.dex */
        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Status f33388a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ClientStreamListener.RpcProgress f33389b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ io.grpc.u f33390c;

            public d(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
                this.f33388a = status;
                this.f33389b = rpcProgress;
                this.f33390c = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                o.this.f33380a.f(this.f33388a, this.f33389b, this.f33390c);
            }
        }

        public o(ClientStreamListener clientStreamListener) {
            this.f33380a = clientStreamListener;
        }

        @Override // io.grpc.internal.u0
        public void c(u0.a aVar) {
            if (this.f33381b) {
                this.f33380a.c(aVar);
            } else {
                h(new a(aVar));
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void d(io.grpc.u uVar) {
            h(new c(uVar));
        }

        @Override // io.grpc.internal.u0
        public void e() {
            if (this.f33381b) {
                this.f33380a.e();
            } else {
                h(new b());
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void f(Status status, ClientStreamListener.RpcProgress rpcProgress, io.grpc.u uVar) {
            h(new d(status, rpcProgress, uVar));
        }

        public final void h(Runnable runnable) {
            synchronized (this) {
                try {
                    if (!this.f33381b) {
                        this.f33382c.add(runnable);
                    } else {
                        runnable.run();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void i() {
            List list;
            List arrayList = new ArrayList();
            while (true) {
                synchronized (this) {
                    try {
                        if (this.f33382c.isEmpty()) {
                            this.f33382c = null;
                            this.f33381b = true;
                            return;
                        } else {
                            list = this.f33382c;
                            this.f33382c = arrayList;
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

    @Override // io.grpc.internal.InterfaceC1128j
    public void appendTimeoutInsight(F f10) {
        synchronized (this) {
            try {
                if (this.f33348b == null) {
                    return;
                }
                if (this.f33349c != null) {
                    f10.b("buffered_nanos", Long.valueOf(this.f33354h - this.f33353g));
                    this.f33349c.appendTimeoutInsight(f10);
                } else {
                    f10.b("buffered_nanos", Long.valueOf(System.nanoTime() - this.f33353g));
                    f10.a("waiting_for_connection");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(Runnable runnable) {
        boolean z10;
        if (this.f33348b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called after start");
        synchronized (this) {
            try {
                if (!this.f33347a) {
                    this.f33351e.add(runnable);
                } else {
                    runnable.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void cancel(Status status) {
        boolean z10;
        boolean z11 = false;
        if (this.f33348b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called after start");
        com.google.common.base.k.p(status, "reason");
        synchronized (this) {
            try {
                if (this.f33349c == null) {
                    g(T.INSTANCE);
                    this.f33350d = status;
                } else {
                    z11 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z11) {
            c(new m(status));
            return;
        }
        d();
        f(status);
        this.f33348b.f(status, ClientStreamListener.RpcProgress.PROCESSED, new io.grpc.u());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.f33351e     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1f
            r0 = 0
            r3.f33351e = r0     // Catch: java.lang.Throwable -> L1d
            r0 = 1
            r3.f33347a = r0     // Catch: java.lang.Throwable -> L1d
            io.grpc.internal.r$o r0 = r3.f33352f     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1c
            r0.i()
        L1c:
            return
        L1d:
            r0 = move-exception
            goto L3d
        L1f:
            java.util.List<java.lang.Runnable> r1 = r3.f33351e     // Catch: java.lang.Throwable -> L1d
            r3.f33351e = r0     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            java.util.Iterator r0 = r1.iterator()
        L28:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L38
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L28
        L38:
            r1.clear()
            r0 = r1
            goto L5
        L3d:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L1d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.r.d():void");
    }

    public final void e(ClientStreamListener clientStreamListener) {
        Iterator<Runnable> it = this.f33355i.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.f33355i = null;
        this.f33349c.start(clientStreamListener);
    }

    @Override // io.grpc.internal.t0
    public void flush() {
        boolean z10;
        if (this.f33348b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called after start");
        if (this.f33347a) {
            this.f33349c.flush();
        } else {
            c(new l());
        }
    }

    public final void g(InterfaceC1128j interfaceC1128j) {
        boolean z10;
        InterfaceC1128j interfaceC1128j2 = this.f33349c;
        if (interfaceC1128j2 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.x(z10, "realStream already set to %s", interfaceC1128j2);
        this.f33349c = interfaceC1128j;
        this.f33354h = System.nanoTime();
    }

    public InterfaceC1128j getRealStream() {
        return this.f33349c;
    }

    public final Runnable h(InterfaceC1128j interfaceC1128j) {
        synchronized (this) {
            try {
                if (this.f33349c != null) {
                    return null;
                }
                g((InterfaceC1128j) com.google.common.base.k.p(interfaceC1128j, "stream"));
                ClientStreamListener clientStreamListener = this.f33348b;
                if (clientStreamListener == null) {
                    this.f33351e = null;
                    this.f33347a = true;
                }
                if (clientStreamListener == null) {
                    return null;
                }
                e(clientStreamListener);
                return new i();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void halfClose() {
        boolean z10;
        if (this.f33348b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called after start");
        c(new n());
    }

    @Override // io.grpc.internal.t0
    public boolean isReady() {
        if (this.f33347a) {
            return this.f33349c.isReady();
        }
        return false;
    }

    @Override // io.grpc.internal.t0
    public void optimizeForDirectExecutor() {
        boolean z10;
        if (this.f33348b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called before start");
        this.f33355i.add(new b());
    }

    @Override // io.grpc.internal.t0
    public void request(int i10) {
        boolean z10;
        if (this.f33348b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called after start");
        if (this.f33347a) {
            this.f33349c.request(i10);
        } else {
            c(new a(i10));
        }
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setAuthority(String str) {
        boolean z10;
        if (this.f33348b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called before start");
        com.google.common.base.k.p(str, "authority");
        this.f33355i.add(new j(str));
    }

    @Override // io.grpc.internal.t0
    public void setCompressor(InterfaceC1199i interfaceC1199i) {
        boolean z10;
        if (this.f33348b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called before start");
        com.google.common.base.k.p(interfaceC1199i, "compressor");
        this.f33355i.add(new c(interfaceC1199i));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setDeadline(C1203m c1203m) {
        boolean z10;
        if (this.f33348b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called before start");
        this.f33355i.add(new h(c1203m));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setDecompressorRegistry(j9.o oVar) {
        boolean z10;
        if (this.f33348b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called before start");
        com.google.common.base.k.p(oVar, "decompressorRegistry");
        this.f33355i.add(new e(oVar));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setFullStreamDecompression(boolean z10) {
        boolean z11;
        if (this.f33348b == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        com.google.common.base.k.v(z11, "May only be called before start");
        this.f33355i.add(new d(z10));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setMaxInboundMessageSize(int i10) {
        boolean z10;
        if (this.f33348b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called before start");
        this.f33355i.add(new f(i10));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void setMaxOutboundMessageSize(int i10) {
        boolean z10;
        if (this.f33348b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called before start");
        this.f33355i.add(new g(i10));
    }

    @Override // io.grpc.internal.InterfaceC1128j
    public void start(ClientStreamListener clientStreamListener) {
        boolean z10;
        Status status;
        boolean z11;
        com.google.common.base.k.p(clientStreamListener, "listener");
        if (this.f33348b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "already started");
        synchronized (this) {
            try {
                status = this.f33350d;
                z11 = this.f33347a;
                if (!z11) {
                    o oVar = new o(clientStreamListener);
                    this.f33352f = oVar;
                    clientStreamListener = oVar;
                }
                this.f33348b = clientStreamListener;
                this.f33353g = System.nanoTime();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (status != null) {
            clientStreamListener.f(status, ClientStreamListener.RpcProgress.PROCESSED, new io.grpc.u());
        } else if (z11) {
            e(clientStreamListener);
        }
    }

    @Override // io.grpc.internal.t0
    public void writeMessage(InputStream inputStream) {
        boolean z10;
        if (this.f33348b != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        com.google.common.base.k.v(z10, "May only be called after start");
        com.google.common.base.k.p(inputStream, "message");
        if (this.f33347a) {
            this.f33349c.writeMessage(inputStream);
        } else {
            c(new k(inputStream));
        }
    }

    public void f(Status status) {
    }
}
