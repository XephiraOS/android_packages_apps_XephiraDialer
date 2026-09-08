package io.grpc.internal;

import io.grpc.C1114h;
import io.grpc.ConnectivityState;
import io.grpc.Status;
import io.grpc.q;
import j9.C1201k;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class PickFirstLeafLoadBalancer extends io.grpc.q {

    /* renamed from: l, reason: collision with root package name */
    public static final Logger f32836l = Logger.getLogger(PickFirstLeafLoadBalancer.class.getName());

    /* renamed from: g, reason: collision with root package name */
    public final q.e f32837g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<SocketAddress, g> f32838h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public Index f32839i;

    /* renamed from: j, reason: collision with root package name */
    public ConnectivityState f32840j;

    /* renamed from: k, reason: collision with root package name */
    public ConnectivityState f32841k;

    /* loaded from: classes4.dex */
    public static final class Index {

        /* renamed from: a, reason: collision with root package name */
        public List<C1114h> f32842a;

        /* renamed from: b, reason: collision with root package name */
        public int f32843b;

        /* renamed from: c, reason: collision with root package name */
        public int f32844c;

        public Index(List<C1114h> list) {
            this.f32842a = list;
        }

        public SocketAddress a() {
            return this.f32842a.get(this.f32843b).a().get(this.f32844c);
        }

        public void b() {
            C1114h c1114h = this.f32842a.get(this.f32843b);
            int i10 = this.f32844c + 1;
            this.f32844c = i10;
            if (i10 >= c1114h.a().size()) {
                this.f32843b++;
                this.f32844c = 0;
            }
        }

        public boolean c() {
            if (this.f32843b < this.f32842a.size()) {
                return true;
            }
            return false;
        }

        public void d() {
            this.f32843b = 0;
            this.f32844c = 0;
        }

        public boolean e(SocketAddress socketAddress) {
            for (int i10 = 0; i10 < this.f32842a.size(); i10++) {
                int indexOf = this.f32842a.get(i10).a().indexOf(socketAddress);
                if (indexOf != -1) {
                    this.f32843b = i10;
                    this.f32844c = indexOf;
                    return true;
                }
            }
            return false;
        }

        public void f(List<C1114h> list) {
            this.f32842a = list;
            d();
        }
    }

    /* loaded from: classes4.dex */
    public class a implements q.k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q.i f32845a;

        public a(q.i iVar) {
            this.f32845a = iVar;
        }

        @Override // io.grpc.q.k
        public void a(C1201k c1201k) {
            PickFirstLeafLoadBalancer.this.n(this.f32845a, c1201k);
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32847a;

        static {
            int[] iArr = new int[ConnectivityState.values().length];
            f32847a = iArr;
            try {
                iArr[ConnectivityState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32847a[ConnectivityState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32847a[ConnectivityState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32847a[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final Boolean f32851a;

        /* renamed from: b, reason: collision with root package name */
        public final Long f32852b;
    }

    /* loaded from: classes4.dex */
    public static final class e extends q.j {

        /* renamed from: a, reason: collision with root package name */
        public final q.f f32853a;

        public e(q.f fVar) {
            this.f32853a = (q.f) com.google.common.base.k.p(fVar, "result");
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            return this.f32853a;
        }

        public String toString() {
            return com.google.common.base.f.b(e.class).d("result", this.f32853a).toString();
        }
    }

    /* loaded from: classes4.dex */
    public final class f extends q.j {

        /* renamed from: a, reason: collision with root package name */
        public final PickFirstLeafLoadBalancer f32854a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f32855b = new AtomicBoolean(false);

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f32854a.e();
            }
        }

        public f(PickFirstLeafLoadBalancer pickFirstLeafLoadBalancer) {
            this.f32854a = (PickFirstLeafLoadBalancer) com.google.common.base.k.p(pickFirstLeafLoadBalancer, "pickFirstLeafLoadBalancer");
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            if (this.f32855b.compareAndSet(false, true)) {
                PickFirstLeafLoadBalancer.this.f32837g.d().execute(new a());
            }
            return q.f.g();
        }
    }

    /* loaded from: classes4.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final q.i f32858a;

        /* renamed from: b, reason: collision with root package name */
        public ConnectivityState f32859b;

        /* renamed from: c, reason: collision with root package name */
        public final c f32860c;

        public g(q.i iVar, ConnectivityState connectivityState, c cVar) {
            this.f32858a = iVar;
            this.f32859b = connectivityState;
            this.f32860c = cVar;
        }

        public final ConnectivityState f() {
            return this.f32860c.f32848a.c();
        }

        public ConnectivityState g() {
            return this.f32859b;
        }

        public q.i h() {
            return this.f32858a;
        }

        public final void i(ConnectivityState connectivityState) {
            this.f32859b = connectivityState;
        }
    }

    public PickFirstLeafLoadBalancer(q.e eVar) {
        ConnectivityState connectivityState = ConnectivityState.IDLE;
        this.f32840j = connectivityState;
        this.f32841k = connectivityState;
        this.f32837g = (q.e) com.google.common.base.k.p(eVar, "helper");
    }

    @Override // io.grpc.q
    public Status a(q.h hVar) {
        ConnectivityState connectivityState;
        d dVar;
        Boolean bool;
        Random random;
        List<C1114h> a10 = hVar.a();
        if (a10.isEmpty()) {
            Status r10 = Status.f32383t.r("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(r10);
            return r10;
        }
        Iterator<C1114h> it = a10.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                Status r11 = Status.f32383t.r("NameResolver returned address list with null endpoint. addrs=" + hVar.a() + ", attrs=" + hVar.b());
                c(r11);
                return r11;
            }
        }
        if ((hVar.c() instanceof d) && (bool = (dVar = (d) hVar.c()).f32851a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(a10);
            if (dVar.f32852b != null) {
                random = new Random(dVar.f32852b.longValue());
            } else {
                random = new Random();
            }
            Collections.shuffle(arrayList, random);
            a10 = arrayList;
        }
        List<C1114h> unmodifiableList = Collections.unmodifiableList(new ArrayList(a10));
        Index index = this.f32839i;
        if (index == null) {
            this.f32839i = new Index(unmodifiableList);
        } else if (this.f32840j == ConnectivityState.READY) {
            SocketAddress a11 = index.a();
            this.f32839i.f(unmodifiableList);
            if (this.f32839i.e(a11)) {
                return Status.f32368e;
            }
            this.f32839i.d();
        } else {
            index.f(unmodifiableList);
        }
        HashSet<SocketAddress> hashSet = new HashSet(this.f32838h.keySet());
        HashSet hashSet2 = new HashSet();
        Iterator<C1114h> it2 = unmodifiableList.iterator();
        while (it2.hasNext()) {
            for (SocketAddress socketAddress : it2.next().a()) {
                hashSet2.add(socketAddress);
                if (!this.f32838h.containsKey(socketAddress)) {
                    l(socketAddress);
                }
            }
        }
        for (SocketAddress socketAddress2 : hashSet) {
            if (!hashSet2.contains(socketAddress2)) {
                this.f32838h.get(socketAddress2).h().g();
                this.f32838h.remove(socketAddress2);
            }
        }
        if (hashSet.size() != 0 && (connectivityState = this.f32840j) != ConnectivityState.CONNECTING && connectivityState != ConnectivityState.READY) {
            ConnectivityState connectivityState2 = ConnectivityState.IDLE;
            if (connectivityState == connectivityState2) {
                p(connectivityState2, new f(this));
            } else if (connectivityState == ConnectivityState.TRANSIENT_FAILURE) {
                e();
            }
        } else {
            ConnectivityState connectivityState3 = ConnectivityState.CONNECTING;
            this.f32840j = connectivityState3;
            p(connectivityState3, new e(q.f.g()));
            e();
        }
        return Status.f32368e;
    }

    @Override // io.grpc.q
    public void c(Status status) {
        Iterator<g> it = this.f32838h.values().iterator();
        while (it.hasNext()) {
            it.next().h().g();
        }
        this.f32838h.clear();
        p(ConnectivityState.TRANSIENT_FAILURE, new e(q.f.f(status)));
    }

    @Override // io.grpc.q
    public void e() {
        q.i l10;
        if (this.f32838h.size() != 0 && this.f32839i.c()) {
            if (this.f32838h.containsKey(this.f32839i.a())) {
                l10 = this.f32838h.get(this.f32839i.a()).h();
            } else {
                l10 = l(this.f32839i.a());
            }
            ConnectivityState g10 = this.f32838h.get(this.f32839i.a()).g();
            if (g10 == ConnectivityState.IDLE) {
                l10.f();
            } else if (g10 == ConnectivityState.CONNECTING || g10 == ConnectivityState.TRANSIENT_FAILURE) {
                this.f32839i.b();
                e();
            }
        }
    }

    @Override // io.grpc.q
    public void f() {
        Iterator<g> it = this.f32838h.values().iterator();
        while (it.hasNext()) {
            it.next().h().g();
        }
        this.f32838h.clear();
    }

    public ConnectivityState getConcludedConnectivityState() {
        return this.f32841k;
    }

    public final q.i l(SocketAddress socketAddress) {
        c cVar = new c(this, null);
        q.i a10 = this.f32837g.a(q.b.d().e(com.google.common.collect.n.i(new C1114h(socketAddress))).b(io.grpc.q.f33435c, cVar).c());
        g gVar = new g(a10, ConnectivityState.IDLE, cVar);
        cVar.f32849b = gVar;
        this.f32838h.put(socketAddress, gVar);
        if (a10.c().b(io.grpc.q.f33436d) == null) {
            cVar.f32848a = C1201k.a(ConnectivityState.READY);
        }
        a10.h(new a(a10));
        return a10;
    }

    public final SocketAddress m(q.i iVar) {
        return iVar.a().a().get(0);
    }

    public void n(q.i iVar, C1201k c1201k) {
        ConnectivityState c10 = c1201k.c();
        g gVar = this.f32838h.get(m(iVar));
        if (gVar == null || gVar.h() != iVar || c10 == ConnectivityState.SHUTDOWN) {
            return;
        }
        ConnectivityState connectivityState = ConnectivityState.IDLE;
        if (c10 == connectivityState) {
            this.f32837g.e();
        }
        gVar.i(c10);
        ConnectivityState connectivityState2 = this.f32840j;
        ConnectivityState connectivityState3 = ConnectivityState.TRANSIENT_FAILURE;
        if (connectivityState2 == connectivityState3 || this.f32841k == connectivityState3) {
            if (c10 == ConnectivityState.CONNECTING) {
                return;
            }
            if (c10 == connectivityState) {
                e();
                return;
            }
        }
        int i10 = b.f32847a[c10.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        if (this.f32839i.c() && this.f32838h.get(this.f32839i.a()).h() == iVar) {
                            this.f32839i.b();
                            e();
                            if (!this.f32839i.c()) {
                                this.f32837g.e();
                                this.f32840j = connectivityState3;
                                p(connectivityState3, new e(q.f.f(c1201k.d())));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Unsupported state:" + c10);
                }
                o(gVar);
                this.f32839i.e(m(iVar));
                this.f32840j = ConnectivityState.READY;
                q(gVar);
                return;
            }
            ConnectivityState connectivityState4 = ConnectivityState.CONNECTING;
            this.f32840j = connectivityState4;
            p(connectivityState4, new e(q.f.g()));
            return;
        }
        this.f32839i.d();
        this.f32840j = connectivityState;
        p(connectivityState, new f(this));
    }

    public final void o(g gVar) {
        for (g gVar2 : this.f32838h.values()) {
            if (!gVar2.h().equals(gVar.f32858a)) {
                gVar2.h().g();
            }
        }
        this.f32838h.clear();
        gVar.i(ConnectivityState.READY);
        this.f32838h.put(m(gVar.f32858a), gVar);
    }

    public final void p(ConnectivityState connectivityState, q.j jVar) {
        if (connectivityState == this.f32841k && (connectivityState == ConnectivityState.IDLE || connectivityState == ConnectivityState.CONNECTING)) {
            return;
        }
        this.f32841k = connectivityState;
        this.f32837g.f(connectivityState, jVar);
    }

    public final void q(g gVar) {
        ConnectivityState connectivityState = gVar.f32859b;
        ConnectivityState connectivityState2 = ConnectivityState.READY;
        if (connectivityState != connectivityState2) {
            return;
        }
        if (gVar.f() != connectivityState2) {
            ConnectivityState f10 = gVar.f();
            ConnectivityState connectivityState3 = ConnectivityState.TRANSIENT_FAILURE;
            if (f10 == connectivityState3) {
                p(connectivityState3, new e(q.f.f(gVar.f32860c.f32848a.d())));
                return;
            } else {
                if (this.f32841k != connectivityState3) {
                    p(gVar.f(), new e(q.f.g()));
                    return;
                }
                return;
            }
        }
        p(connectivityState2, new q.d(q.f.h(gVar.f32858a)));
    }

    /* loaded from: classes4.dex */
    public final class c implements q.k {

        /* renamed from: a, reason: collision with root package name */
        public C1201k f32848a;

        /* renamed from: b, reason: collision with root package name */
        public g f32849b;

        public c() {
            this.f32848a = C1201k.a(ConnectivityState.IDLE);
        }

        @Override // io.grpc.q.k
        public void a(C1201k c1201k) {
            PickFirstLeafLoadBalancer.f32836l.log(Level.FINE, "Received health status {0} for subchannel {1}", new Object[]{c1201k, this.f32849b.f32858a});
            this.f32848a = c1201k;
            if (PickFirstLeafLoadBalancer.this.f32839i.c() && ((g) PickFirstLeafLoadBalancer.this.f32838h.get(PickFirstLeafLoadBalancer.this.f32839i.a())).f32860c == this) {
                PickFirstLeafLoadBalancer.this.q(this.f32849b);
            }
        }

        public /* synthetic */ c(PickFirstLeafLoadBalancer pickFirstLeafLoadBalancer, a aVar) {
            this();
        }
    }
}
