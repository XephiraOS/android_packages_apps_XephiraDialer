package io.grpc.internal;

import io.grpc.AbstractC1112f;
import io.grpc.C1108b;
import io.grpc.Context;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.P;
import io.grpc.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* compiled from: DelayedClientTransport.java */
/* renamed from: io.grpc.internal.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1135q implements P {

    /* renamed from: c, reason: collision with root package name */
    public final Executor f33314c;

    /* renamed from: d, reason: collision with root package name */
    public final j9.N f33315d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f33316e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f33317f;

    /* renamed from: g, reason: collision with root package name */
    public Runnable f33318g;

    /* renamed from: h, reason: collision with root package name */
    public P.a f33319h;

    /* renamed from: j, reason: collision with root package name */
    public Status f33321j;

    /* renamed from: k, reason: collision with root package name */
    public q.j f33322k;

    /* renamed from: l, reason: collision with root package name */
    public long f33323l;

    /* renamed from: a, reason: collision with root package name */
    public final j9.w f33312a = j9.w.a(C1135q.class, null);

    /* renamed from: b, reason: collision with root package name */
    public final Object f33313b = new Object();

    /* renamed from: i, reason: collision with root package name */
    public Collection<e> f33320i = new LinkedHashSet();

    /* compiled from: DelayedClientTransport.java */
    /* renamed from: io.grpc.internal.q$a */
    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ P.a f33324a;

        public a(P.a aVar) {
            this.f33324a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33324a.d(true);
        }
    }

    /* compiled from: DelayedClientTransport.java */
    /* renamed from: io.grpc.internal.q$b */
    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ P.a f33326a;

        public b(P.a aVar) {
            this.f33326a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33326a.d(false);
        }
    }

    /* compiled from: DelayedClientTransport.java */
    /* renamed from: io.grpc.internal.q$c */
    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ P.a f33328a;

        public c(P.a aVar) {
            this.f33328a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33328a.a();
        }
    }

    /* compiled from: DelayedClientTransport.java */
    /* renamed from: io.grpc.internal.q$d */
    /* loaded from: classes4.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Status f33330a;

        public d(Status status) {
            this.f33330a = status;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1135q.this.f33319h.b(this.f33330a);
        }
    }

    /* compiled from: DelayedClientTransport.java */
    /* renamed from: io.grpc.internal.q$e */
    /* loaded from: classes4.dex */
    public class e extends r {

        /* renamed from: j, reason: collision with root package name */
        public final q.g f33332j;

        /* renamed from: k, reason: collision with root package name */
        public final Context f33333k;

        /* renamed from: l, reason: collision with root package name */
        public final AbstractC1112f[] f33334l;

        public /* synthetic */ e(C1135q c1135q, q.g gVar, AbstractC1112f[] abstractC1112fArr, a aVar) {
            this(gVar, abstractC1112fArr);
        }

        @Override // io.grpc.internal.r, io.grpc.internal.InterfaceC1128j
        public void appendTimeoutInsight(F f10) {
            if (this.f33332j.a().j()) {
                f10.a("wait_for_ready");
            }
            super.appendTimeoutInsight(f10);
        }

        @Override // io.grpc.internal.r, io.grpc.internal.InterfaceC1128j
        public void cancel(Status status) {
            super.cancel(status);
            synchronized (C1135q.this.f33313b) {
                try {
                    if (C1135q.this.f33318g != null) {
                        boolean remove = C1135q.this.f33320i.remove(this);
                        if (!C1135q.this.j() && remove) {
                            C1135q.this.f33315d.b(C1135q.this.f33317f);
                            if (C1135q.this.f33321j != null) {
                                C1135q.this.f33315d.b(C1135q.this.f33318g);
                                C1135q.this.f33318g = null;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            C1135q.this.f33315d.a();
        }

        @Override // io.grpc.internal.r
        public void f(Status status) {
            for (AbstractC1112f abstractC1112f : this.f33334l) {
                abstractC1112f.f(status);
            }
        }

        public final Runnable l(InterfaceC1129k interfaceC1129k) {
            Context c10 = this.f33333k.c();
            try {
                InterfaceC1128j newStream = interfaceC1129k.newStream(this.f33332j.c(), this.f33332j.b(), this.f33332j.a(), this.f33334l);
                this.f33333k.o(c10);
                return h(newStream);
            } catch (Throwable th) {
                this.f33333k.o(c10);
                throw th;
            }
        }

        public e(q.g gVar, AbstractC1112f[] abstractC1112fArr) {
            this.f33333k = Context.l();
            this.f33332j = gVar;
            this.f33334l = abstractC1112fArr;
        }
    }

    public C1135q(Executor executor, j9.N n10) {
        this.f33314c = executor;
        this.f33315d = n10;
    }

    @Override // j9.z
    public j9.w getLogId() {
        return this.f33312a;
    }

    public final int getPendingStreamsCount() {
        int size;
        synchronized (this.f33313b) {
            size = this.f33320i.size();
        }
        return size;
    }

    public final e i(q.g gVar, AbstractC1112f[] abstractC1112fArr) {
        e eVar = new e(this, gVar, abstractC1112fArr, null);
        this.f33320i.add(eVar);
        if (getPendingStreamsCount() == 1) {
            this.f33315d.b(this.f33316e);
        }
        for (AbstractC1112f abstractC1112f : abstractC1112fArr) {
            abstractC1112f.g();
        }
        return eVar;
    }

    public final boolean j() {
        boolean z10;
        synchronized (this.f33313b) {
            z10 = !this.f33320i.isEmpty();
        }
        return z10;
    }

    public final void k(q.j jVar) {
        Runnable runnable;
        synchronized (this.f33313b) {
            this.f33322k = jVar;
            this.f33323l++;
            if (jVar != null && j()) {
                ArrayList arrayList = new ArrayList(this.f33320i);
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    q.f a10 = jVar.a(eVar.f33332j);
                    C1108b a11 = eVar.f33332j.a();
                    InterfaceC1129k j10 = GrpcUtil.j(a10, a11.j());
                    if (j10 != null) {
                        Executor executor = this.f33314c;
                        if (a11.e() != null) {
                            executor = a11.e();
                        }
                        Runnable l10 = eVar.l(j10);
                        if (l10 != null) {
                            executor.execute(l10);
                        }
                        arrayList2.add(eVar);
                    }
                }
                synchronized (this.f33313b) {
                    try {
                        if (!j()) {
                            return;
                        }
                        this.f33320i.removeAll(arrayList2);
                        if (this.f33320i.isEmpty()) {
                            this.f33320i = new LinkedHashSet();
                        }
                        if (!j()) {
                            this.f33315d.b(this.f33317f);
                            if (this.f33321j != null && (runnable = this.f33318g) != null) {
                                this.f33315d.b(runnable);
                                this.f33318g = null;
                            }
                        }
                        this.f33315d.a();
                    } finally {
                    }
                }
            }
        }
    }

    @Override // io.grpc.internal.InterfaceC1129k
    public final InterfaceC1128j newStream(MethodDescriptor<?, ?> methodDescriptor, io.grpc.u uVar, C1108b c1108b, AbstractC1112f[] abstractC1112fArr) {
        InterfaceC1128j c1138u;
        try {
            Y y10 = new Y(methodDescriptor, uVar, c1108b);
            q.j jVar = null;
            long j10 = -1;
            while (true) {
                synchronized (this.f33313b) {
                    if (this.f33321j != null) {
                        c1138u = new C1138u(this.f33321j, abstractC1112fArr);
                        break;
                    }
                    q.j jVar2 = this.f33322k;
                    if (jVar2 == null) {
                        c1138u = i(y10, abstractC1112fArr);
                        break;
                    }
                    if (jVar != null && j10 == this.f33323l) {
                        c1138u = i(y10, abstractC1112fArr);
                        break;
                    }
                    j10 = this.f33323l;
                    InterfaceC1129k j11 = GrpcUtil.j(jVar2.a(y10), c1108b.j());
                    if (j11 != null) {
                        c1138u = j11.newStream(y10.c(), y10.b(), y10.a(), abstractC1112fArr);
                        break;
                    }
                    jVar = jVar2;
                }
            }
            return c1138u;
        } finally {
            this.f33315d.a();
        }
    }

    @Override // io.grpc.internal.P
    public final void shutdown(Status status) {
        Runnable runnable;
        synchronized (this.f33313b) {
            try {
                if (this.f33321j != null) {
                    return;
                }
                this.f33321j = status;
                this.f33315d.b(new d(status));
                if (!j() && (runnable = this.f33318g) != null) {
                    this.f33315d.b(runnable);
                    this.f33318g = null;
                }
                this.f33315d.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.P
    public final void shutdownNow(Status status) {
        Collection<e> collection;
        Runnable runnable;
        shutdown(status);
        synchronized (this.f33313b) {
            try {
                collection = this.f33320i;
                runnable = this.f33318g;
                this.f33318g = null;
                if (!collection.isEmpty()) {
                    this.f33320i = Collections.emptyList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (runnable != null) {
            for (e eVar : collection) {
                Runnable h10 = eVar.h(new C1138u(status, ClientStreamListener.RpcProgress.REFUSED, eVar.f33334l));
                if (h10 != null) {
                    h10.run();
                }
            }
            this.f33315d.execute(runnable);
        }
    }

    @Override // io.grpc.internal.P
    public final Runnable start(P.a aVar) {
        this.f33319h = aVar;
        this.f33316e = new a(aVar);
        this.f33317f = new b(aVar);
        this.f33318g = new c(aVar);
        return null;
    }
}
