package io.grpc.util;

import com.coui.appcompat.calendar.COUIDateMonthView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import io.grpc.AbstractC1112f;
import io.grpc.C1107a;
import io.grpc.C1114h;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.Status;
import io.grpc.internal.p0;
import io.grpc.internal.v0;
import io.grpc.q;
import io.grpc.u;
import j9.C1201k;
import j9.N;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: OutlierDetectionLoadBalancer.java */
/* loaded from: classes4.dex */
public final class g extends q {

    /* renamed from: o, reason: collision with root package name */
    public static final C1107a.c<b> f33555o = C1107a.c.a("addressTrackerKey");

    /* renamed from: g, reason: collision with root package name */
    public final N f33556g;

    /* renamed from: h, reason: collision with root package name */
    public final q.e f33557h;

    /* renamed from: i, reason: collision with root package name */
    public final io.grpc.util.e f33558i;

    /* renamed from: j, reason: collision with root package name */
    public v0 f33559j;

    /* renamed from: k, reason: collision with root package name */
    public final ScheduledExecutorService f33560k;

    /* renamed from: l, reason: collision with root package name */
    public N.d f33561l;

    /* renamed from: m, reason: collision with root package name */
    public Long f33562m;

    /* renamed from: n, reason: collision with root package name */
    public final ChannelLogger f33563n;
    final c trackerMap;

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public C0316g f33564a;

        /* renamed from: b, reason: collision with root package name */
        public volatile a f33565b;

        /* renamed from: c, reason: collision with root package name */
        public a f33566c;

        /* renamed from: d, reason: collision with root package name */
        public Long f33567d;

        /* renamed from: e, reason: collision with root package name */
        public int f33568e;

        /* renamed from: f, reason: collision with root package name */
        public final Set<i> f33569f = new HashSet();

        /* compiled from: OutlierDetectionLoadBalancer.java */
        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public AtomicLong f33570a;

            /* renamed from: b, reason: collision with root package name */
            public AtomicLong f33571b;

            public a() {
                this.f33570a = new AtomicLong();
                this.f33571b = new AtomicLong();
            }

            public void a() {
                this.f33570a.set(0L);
                this.f33571b.set(0L);
            }
        }

        public b(C0316g c0316g) {
            this.f33565b = new a();
            this.f33566c = new a();
            this.f33564a = c0316g;
        }

        public long activeVolume() {
            return this.f33565b.f33570a.get() + this.f33565b.f33571b.get();
        }

        public boolean b(i iVar) {
            if (m() && !iVar.o()) {
                iVar.n();
            } else if (!m() && iVar.o()) {
                iVar.q();
            }
            iVar.p(this);
            return this.f33569f.add(iVar);
        }

        public void c() {
            int i10;
            int i11 = this.f33568e;
            if (i11 == 0) {
                i10 = 0;
            } else {
                i10 = i11 - 1;
            }
            this.f33568e = i10;
        }

        public void d(long j10) {
            this.f33567d = Long.valueOf(j10);
            this.f33568e++;
            Iterator<i> it = this.f33569f.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }

        public double e() {
            return this.f33566c.f33571b.get() / f();
        }

        public long f() {
            return this.f33566c.f33570a.get() + this.f33566c.f33571b.get();
        }

        public void g(boolean z10) {
            C0316g c0316g = this.f33564a;
            if (c0316g.f33584e == null && c0316g.f33585f == null) {
                return;
            }
            if (z10) {
                this.f33565b.f33570a.getAndIncrement();
            } else {
                this.f33565b.f33571b.getAndIncrement();
            }
        }

        public Set<i> getSubchannels() {
            return ImmutableSet.l(this.f33569f);
        }

        public boolean h(long j10) {
            if (j10 > this.f33567d.longValue() + Math.min(this.f33564a.f33581b.longValue() * this.f33568e, Math.max(this.f33564a.f33581b.longValue(), this.f33564a.f33582c.longValue()))) {
                return true;
            }
            return false;
        }

        public boolean i(i iVar) {
            iVar.m();
            return this.f33569f.remove(iVar);
        }

        public void j() {
            this.f33565b.a();
            this.f33566c.a();
        }

        public void k() {
            this.f33568e = 0;
        }

        public void l(C0316g c0316g) {
            this.f33564a = c0316g;
        }

        public boolean m() {
            if (this.f33567d != null) {
                return true;
            }
            return false;
        }

        public double n() {
            return this.f33566c.f33570a.get() / f();
        }

        public void o() {
            this.f33566c.a();
            a aVar = this.f33565b;
            this.f33565b = this.f33566c;
            this.f33566c = aVar;
        }

        public void p() {
            boolean z10;
            if (this.f33567d != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.v(z10, "not currently ejected");
            this.f33567d = null;
            Iterator<i> it = this.f33569f.iterator();
            while (it.hasNext()) {
                it.next().q();
            }
        }

        public String toString() {
            return "AddressTracker{subchannels=" + this.f33569f + '}';
        }
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static class c extends com.google.common.collect.j<SocketAddress, b> {

        /* renamed from: a, reason: collision with root package name */
        public final Map<SocketAddress, b> f33572a = new HashMap();

        @Override // com.google.common.collect.k
        /* renamed from: d */
        public Map<SocketAddress, b> b() {
            return this.f33572a;
        }

        public void f() {
            for (b bVar : this.f33572a.values()) {
                if (bVar.m()) {
                    bVar.p();
                }
                bVar.k();
            }
        }

        public double g() {
            if (this.f33572a.isEmpty()) {
                return 0.0d;
            }
            Iterator<b> it = this.f33572a.values().iterator();
            int i10 = 0;
            int i11 = 0;
            while (it.hasNext()) {
                i11++;
                if (it.next().m()) {
                    i10++;
                }
            }
            return (i10 / i11) * 100.0d;
        }

        public void h(Long l10) {
            for (b bVar : this.f33572a.values()) {
                if (!bVar.m()) {
                    bVar.c();
                }
                if (bVar.m() && bVar.h(l10.longValue())) {
                    bVar.p();
                }
            }
        }

        public void i(C0316g c0316g, Collection<SocketAddress> collection) {
            for (SocketAddress socketAddress : collection) {
                if (!this.f33572a.containsKey(socketAddress)) {
                    this.f33572a.put(socketAddress, new b(c0316g));
                }
            }
        }

        public void j() {
            Iterator<b> it = this.f33572a.values().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
        }

        public void k() {
            Iterator<b> it = this.f33572a.values().iterator();
            while (it.hasNext()) {
                it.next().o();
            }
        }

        public void l(C0316g c0316g) {
            Iterator<b> it = this.f33572a.values().iterator();
            while (it.hasNext()) {
                it.next().l(c0316g);
            }
        }
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class d extends io.grpc.util.c {

        /* renamed from: a, reason: collision with root package name */
        public q.e f33573a;

        public d(q.e eVar) {
            this.f33573a = new HealthProducerHelper(eVar);
        }

        @Override // io.grpc.util.c, io.grpc.q.e
        public q.i a(q.b bVar) {
            i iVar = new i(bVar, this.f33573a);
            List<C1114h> a10 = bVar.a();
            if (g.m(a10) && g.this.trackerMap.containsKey(a10.get(0).a().get(0))) {
                b bVar2 = g.this.trackerMap.get(a10.get(0).a().get(0));
                bVar2.b(iVar);
                if (bVar2.f33567d != null) {
                    iVar.n();
                }
            }
            return iVar;
        }

        @Override // io.grpc.util.c, io.grpc.q.e
        public void f(ConnectivityState connectivityState, q.j jVar) {
            this.f33573a.f(connectivityState, new h(jVar));
        }

        @Override // io.grpc.util.c
        public q.e g() {
            return this.f33573a;
        }
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public C0316g f33575a;

        /* renamed from: b, reason: collision with root package name */
        public ChannelLogger f33576b;

        public e(C0316g c0316g, ChannelLogger channelLogger) {
            this.f33575a = c0316g;
            this.f33576b = channelLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.f33562m = Long.valueOf(gVar.f33559j.a());
            g.this.trackerMap.k();
            for (j jVar : j.b(this.f33575a, this.f33576b)) {
                g gVar2 = g.this;
                jVar.a(gVar2.trackerMap, gVar2.f33562m.longValue());
            }
            g gVar3 = g.this;
            gVar3.trackerMap.h(gVar3.f33562m);
        }
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static class f implements j {

        /* renamed from: a, reason: collision with root package name */
        public final C0316g f33578a;

        /* renamed from: b, reason: collision with root package name */
        public final ChannelLogger f33579b;

        public f(C0316g c0316g, ChannelLogger channelLogger) {
            this.f33578a = c0316g;
            this.f33579b = channelLogger;
        }

        @Override // io.grpc.util.g.j
        public void a(c cVar, long j10) {
            List<b> n10 = g.n(cVar, this.f33578a.f33585f.f33597d.intValue());
            if (n10.size() >= this.f33578a.f33585f.f33596c.intValue() && n10.size() != 0) {
                for (b bVar : n10) {
                    if (cVar.g() >= this.f33578a.f33583d.intValue()) {
                        return;
                    }
                    if (bVar.f() >= this.f33578a.f33585f.f33597d.intValue()) {
                        if (bVar.e() > this.f33578a.f33585f.f33594a.intValue() / 100.0d) {
                            this.f33579b.b(ChannelLogger.ChannelLogLevel.DEBUG, "FailurePercentage algorithm detected outlier: {0}, failureRate={1}", bVar, Double.valueOf(bVar.e()));
                            if (new Random().nextInt(100) < this.f33578a.f33585f.f33595b.intValue()) {
                                bVar.d(j10);
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* renamed from: io.grpc.util.g$g, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0316g {

        /* renamed from: a, reason: collision with root package name */
        public final Long f33580a;

        /* renamed from: b, reason: collision with root package name */
        public final Long f33581b;

        /* renamed from: c, reason: collision with root package name */
        public final Long f33582c;

        /* renamed from: d, reason: collision with root package name */
        public final Integer f33583d;

        /* renamed from: e, reason: collision with root package name */
        public final c f33584e;

        /* renamed from: f, reason: collision with root package name */
        public final b f33585f;

        /* renamed from: g, reason: collision with root package name */
        public final p0.b f33586g;

        /* compiled from: OutlierDetectionLoadBalancer.java */
        /* renamed from: io.grpc.util.g$g$a */
        /* loaded from: classes4.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public Long f33587a = 10000000000L;

            /* renamed from: b, reason: collision with root package name */
            public Long f33588b = 30000000000L;

            /* renamed from: c, reason: collision with root package name */
            public Long f33589c = 300000000000L;

            /* renamed from: d, reason: collision with root package name */
            public Integer f33590d = 10;

            /* renamed from: e, reason: collision with root package name */
            public c f33591e;

            /* renamed from: f, reason: collision with root package name */
            public b f33592f;

            /* renamed from: g, reason: collision with root package name */
            public p0.b f33593g;

            public C0316g a() {
                boolean z10;
                if (this.f33593g != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.u(z10);
                return new C0316g(this.f33587a, this.f33588b, this.f33589c, this.f33590d, this.f33591e, this.f33592f, this.f33593g);
            }

            public a b(Long l10) {
                boolean z10;
                if (l10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.d(z10);
                this.f33588b = l10;
                return this;
            }

            public a c(p0.b bVar) {
                boolean z10;
                if (bVar != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.u(z10);
                this.f33593g = bVar;
                return this;
            }

            public a d(b bVar) {
                this.f33592f = bVar;
                return this;
            }

            public a e(Long l10) {
                boolean z10;
                if (l10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.d(z10);
                this.f33587a = l10;
                return this;
            }

            public a f(Integer num) {
                boolean z10;
                if (num != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.d(z10);
                this.f33590d = num;
                return this;
            }

            public a g(Long l10) {
                boolean z10;
                if (l10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                com.google.common.base.k.d(z10);
                this.f33589c = l10;
                return this;
            }

            public a h(c cVar) {
                this.f33591e = cVar;
                return this;
            }
        }

        /* compiled from: OutlierDetectionLoadBalancer.java */
        /* renamed from: io.grpc.util.g$g$b */
        /* loaded from: classes4.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            public final Integer f33594a;

            /* renamed from: b, reason: collision with root package name */
            public final Integer f33595b;

            /* renamed from: c, reason: collision with root package name */
            public final Integer f33596c;

            /* renamed from: d, reason: collision with root package name */
            public final Integer f33597d;

            /* compiled from: OutlierDetectionLoadBalancer.java */
            /* renamed from: io.grpc.util.g$g$b$a */
            /* loaded from: classes4.dex */
            public static class a {

                /* renamed from: a, reason: collision with root package name */
                public Integer f33598a = 85;

                /* renamed from: b, reason: collision with root package name */
                public Integer f33599b = 100;

                /* renamed from: c, reason: collision with root package name */
                public Integer f33600c = 5;

                /* renamed from: d, reason: collision with root package name */
                public Integer f33601d = 50;

                public b a() {
                    return new b(this.f33598a, this.f33599b, this.f33600c, this.f33601d);
                }

                public a b(Integer num) {
                    boolean z10;
                    boolean z11 = false;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.google.common.base.k.d(z10);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z11 = true;
                    }
                    com.google.common.base.k.d(z11);
                    this.f33599b = num;
                    return this;
                }

                public a c(Integer num) {
                    boolean z10;
                    boolean z11 = false;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.google.common.base.k.d(z10);
                    if (num.intValue() >= 0) {
                        z11 = true;
                    }
                    com.google.common.base.k.d(z11);
                    this.f33600c = num;
                    return this;
                }

                public a d(Integer num) {
                    boolean z10;
                    boolean z11 = false;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.google.common.base.k.d(z10);
                    if (num.intValue() >= 0) {
                        z11 = true;
                    }
                    com.google.common.base.k.d(z11);
                    this.f33601d = num;
                    return this;
                }

                public a e(Integer num) {
                    boolean z10;
                    boolean z11 = false;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.google.common.base.k.d(z10);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z11 = true;
                    }
                    com.google.common.base.k.d(z11);
                    this.f33598a = num;
                    return this;
                }
            }

            public b(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f33594a = num;
                this.f33595b = num2;
                this.f33596c = num3;
                this.f33597d = num4;
            }
        }

        /* compiled from: OutlierDetectionLoadBalancer.java */
        /* renamed from: io.grpc.util.g$g$c */
        /* loaded from: classes4.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public final Integer f33602a;

            /* renamed from: b, reason: collision with root package name */
            public final Integer f33603b;

            /* renamed from: c, reason: collision with root package name */
            public final Integer f33604c;

            /* renamed from: d, reason: collision with root package name */
            public final Integer f33605d;

            /* compiled from: OutlierDetectionLoadBalancer.java */
            /* renamed from: io.grpc.util.g$g$c$a */
            /* loaded from: classes4.dex */
            public static final class a {

                /* renamed from: a, reason: collision with root package name */
                public Integer f33606a = Integer.valueOf(COUIDateMonthView.MIN_YEAR);

                /* renamed from: b, reason: collision with root package name */
                public Integer f33607b = 100;

                /* renamed from: c, reason: collision with root package name */
                public Integer f33608c = 5;

                /* renamed from: d, reason: collision with root package name */
                public Integer f33609d = 100;

                public c a() {
                    return new c(this.f33606a, this.f33607b, this.f33608c, this.f33609d);
                }

                public a b(Integer num) {
                    boolean z10;
                    boolean z11 = false;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.google.common.base.k.d(z10);
                    if (num.intValue() >= 0 && num.intValue() <= 100) {
                        z11 = true;
                    }
                    com.google.common.base.k.d(z11);
                    this.f33607b = num;
                    return this;
                }

                public a c(Integer num) {
                    boolean z10;
                    boolean z11 = false;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.google.common.base.k.d(z10);
                    if (num.intValue() >= 0) {
                        z11 = true;
                    }
                    com.google.common.base.k.d(z11);
                    this.f33608c = num;
                    return this;
                }

                public a d(Integer num) {
                    boolean z10;
                    boolean z11 = false;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.google.common.base.k.d(z10);
                    if (num.intValue() >= 0) {
                        z11 = true;
                    }
                    com.google.common.base.k.d(z11);
                    this.f33609d = num;
                    return this;
                }

                public a e(Integer num) {
                    boolean z10;
                    if (num != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    com.google.common.base.k.d(z10);
                    this.f33606a = num;
                    return this;
                }
            }

            public c(Integer num, Integer num2, Integer num3, Integer num4) {
                this.f33602a = num;
                this.f33603b = num2;
                this.f33604c = num3;
                this.f33605d = num4;
            }
        }

        public boolean a() {
            if (this.f33584e == null && this.f33585f == null) {
                return false;
            }
            return true;
        }

        public C0316g(Long l10, Long l11, Long l12, Integer num, c cVar, b bVar, p0.b bVar2) {
            this.f33580a = l10;
            this.f33581b = l11;
            this.f33582c = l12;
            this.f33583d = num;
            this.f33584e = cVar;
            this.f33585f = bVar;
            this.f33586g = bVar2;
        }
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class h extends q.j {

        /* renamed from: a, reason: collision with root package name */
        public final q.j f33610a;

        /* compiled from: OutlierDetectionLoadBalancer.java */
        /* loaded from: classes4.dex */
        public class a extends AbstractC1112f.a {

            /* renamed from: a, reason: collision with root package name */
            public final b f33612a;

            /* renamed from: b, reason: collision with root package name */
            public final AbstractC1112f.a f33613b;

            /* compiled from: OutlierDetectionLoadBalancer.java */
            /* renamed from: io.grpc.util.g$h$a$a, reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0317a extends io.grpc.util.a {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ AbstractC1112f f33615b;

                public C0317a(AbstractC1112f abstractC1112f) {
                    this.f33615b = abstractC1112f;
                }

                @Override // j9.M
                public void f(Status status) {
                    a.this.f33612a.g(status.o());
                    l().f(status);
                }

                @Override // io.grpc.util.a
                public AbstractC1112f l() {
                    return this.f33615b;
                }
            }

            /* compiled from: OutlierDetectionLoadBalancer.java */
            /* loaded from: classes4.dex */
            public class b extends AbstractC1112f {
                public b() {
                }

                @Override // j9.M
                public void f(Status status) {
                    a.this.f33612a.g(status.o());
                }
            }

            public a(b bVar, AbstractC1112f.a aVar) {
                this.f33612a = bVar;
                this.f33613b = aVar;
            }

            @Override // io.grpc.AbstractC1112f.a
            public AbstractC1112f a(AbstractC1112f.b bVar, u uVar) {
                AbstractC1112f.a aVar = this.f33613b;
                if (aVar != null) {
                    return new C0317a(aVar.a(bVar, uVar));
                }
                return new b();
            }
        }

        public h(q.j jVar) {
            this.f33610a = jVar;
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            q.f a10 = this.f33610a.a(gVar);
            q.i c10 = a10.c();
            if (c10 != null) {
                return q.f.i(c10, new a((b) c10.c().b(g.f33555o), a10.b()));
            }
            return a10;
        }
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class i extends io.grpc.util.d {

        /* renamed from: a, reason: collision with root package name */
        public final q.i f33618a;

        /* renamed from: b, reason: collision with root package name */
        public b f33619b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f33620c;

        /* renamed from: d, reason: collision with root package name */
        public C1201k f33621d;

        /* renamed from: e, reason: collision with root package name */
        public q.k f33622e;

        /* renamed from: f, reason: collision with root package name */
        public final ChannelLogger f33623f;

        /* compiled from: OutlierDetectionLoadBalancer.java */
        /* loaded from: classes4.dex */
        public class a implements q.k {

            /* renamed from: a, reason: collision with root package name */
            public final q.k f33625a;

            public a(q.k kVar) {
                this.f33625a = kVar;
            }

            @Override // io.grpc.q.k
            public void a(C1201k c1201k) {
                i.this.f33621d = c1201k;
                if (!i.this.f33620c) {
                    this.f33625a.a(c1201k);
                }
            }
        }

        public i(q.b bVar, q.e eVar) {
            q.b.C0313b<q.k> c0313b = q.f33435c;
            q.k kVar = (q.k) bVar.c(c0313b);
            if (kVar != null) {
                this.f33622e = kVar;
                this.f33618a = eVar.a(bVar.e().b(c0313b, new a(kVar)).c());
            } else {
                this.f33618a = eVar.a(bVar);
            }
            this.f33623f = this.f33618a.d();
        }

        @Override // io.grpc.util.d, io.grpc.q.i
        public C1107a c() {
            if (this.f33619b != null) {
                return this.f33618a.c().d().d(g.f33555o, this.f33619b).a();
            }
            return this.f33618a.c();
        }

        @Override // io.grpc.util.d, io.grpc.q.i
        public void g() {
            b bVar = this.f33619b;
            if (bVar != null) {
                bVar.i(this);
            }
            super.g();
        }

        @Override // io.grpc.util.d, io.grpc.q.i
        public void h(q.k kVar) {
            if (this.f33622e != null) {
                super.h(kVar);
            } else {
                this.f33622e = kVar;
                super.h(new a(kVar));
            }
        }

        @Override // io.grpc.util.d, io.grpc.q.i
        public void i(List<C1114h> list) {
            if (g.m(b()) && g.m(list)) {
                if (g.this.trackerMap.containsValue(this.f33619b)) {
                    this.f33619b.i(this);
                }
                SocketAddress socketAddress = list.get(0).a().get(0);
                if (g.this.trackerMap.containsKey(socketAddress)) {
                    g.this.trackerMap.get(socketAddress).b(this);
                }
            } else if (g.m(b()) && !g.m(list)) {
                if (g.this.trackerMap.containsKey(a().a().get(0))) {
                    b bVar = g.this.trackerMap.get(a().a().get(0));
                    bVar.i(this);
                    bVar.j();
                }
            } else if (!g.m(b()) && g.m(list)) {
                SocketAddress socketAddress2 = list.get(0).a().get(0);
                if (g.this.trackerMap.containsKey(socketAddress2)) {
                    g.this.trackerMap.get(socketAddress2).b(this);
                }
            }
            this.f33618a.i(list);
        }

        @Override // io.grpc.util.d
        public q.i j() {
            return this.f33618a;
        }

        public void m() {
            this.f33619b = null;
        }

        public void n() {
            this.f33620c = true;
            this.f33622e.a(C1201k.b(Status.f32383t));
            this.f33623f.b(ChannelLogger.ChannelLogLevel.INFO, "Subchannel ejected: {0}", this);
        }

        public boolean o() {
            return this.f33620c;
        }

        public void p(b bVar) {
            this.f33619b = bVar;
        }

        public void q() {
            this.f33620c = false;
            C1201k c1201k = this.f33621d;
            if (c1201k != null) {
                this.f33622e.a(c1201k);
                this.f33623f.b(ChannelLogger.ChannelLogLevel.INFO, "Subchannel unejected: {0}", this);
            }
        }

        @Override // io.grpc.util.d
        public String toString() {
            return "OutlierDetectionSubchannel{addresses=" + this.f33618a.b() + '}';
        }
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public interface j {
        static List<j> b(C0316g c0316g, ChannelLogger channelLogger) {
            ImmutableList.a m10 = ImmutableList.m();
            if (c0316g.f33584e != null) {
                m10.f(new k(c0316g, channelLogger));
            }
            if (c0316g.f33585f != null) {
                m10.f(new f(c0316g, channelLogger));
            }
            return m10.g();
        }

        void a(c cVar, long j10);
    }

    /* compiled from: OutlierDetectionLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static class k implements j {

        /* renamed from: a, reason: collision with root package name */
        public final C0316g f33627a;

        /* renamed from: b, reason: collision with root package name */
        public final ChannelLogger f33628b;

        public k(C0316g c0316g, ChannelLogger channelLogger) {
            boolean z10;
            if (c0316g.f33584e != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.base.k.e(z10, "success rate ejection config is null");
            this.f33627a = c0316g;
            this.f33628b = channelLogger;
        }

        public static double mean(Collection<Double> collection) {
            Iterator<Double> it = collection.iterator();
            double d10 = 0.0d;
            while (it.hasNext()) {
                d10 += it.next().doubleValue();
            }
            return d10 / collection.size();
        }

        public static double standardDeviation(Collection<Double> collection, double d10) {
            Iterator<Double> it = collection.iterator();
            double d11 = 0.0d;
            while (it.hasNext()) {
                double doubleValue = it.next().doubleValue() - d10;
                d11 += doubleValue * doubleValue;
            }
            return Math.sqrt(d11 / collection.size());
        }

        @Override // io.grpc.util.g.j
        public void a(c cVar, long j10) {
            List<b> n10 = g.n(cVar, this.f33627a.f33584e.f33605d.intValue());
            if (n10.size() >= this.f33627a.f33584e.f33604c.intValue() && n10.size() != 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = n10.iterator();
                while (it.hasNext()) {
                    arrayList.add(Double.valueOf(((b) it.next()).n()));
                }
                double mean = mean(arrayList);
                double standardDeviation = standardDeviation(arrayList, mean);
                double intValue = mean - ((this.f33627a.f33584e.f33602a.intValue() / 1000.0f) * standardDeviation);
                for (b bVar : n10) {
                    if (cVar.g() >= this.f33627a.f33583d.intValue()) {
                        return;
                    }
                    if (bVar.n() < intValue) {
                        this.f33628b.b(ChannelLogger.ChannelLogLevel.DEBUG, "SuccessRate algorithm detected outlier: {0}. Parameters: successRate={1}, mean={2}, stdev={3}, requiredSuccessRate={4}", bVar, Double.valueOf(bVar.n()), Double.valueOf(mean), Double.valueOf(standardDeviation), Double.valueOf(intValue));
                        if (new Random().nextInt(100) < this.f33627a.f33584e.f33603b.intValue()) {
                            bVar.d(j10);
                        }
                    }
                }
            }
        }
    }

    public g(q.e eVar, v0 v0Var) {
        ChannelLogger b10 = eVar.b();
        this.f33563n = b10;
        d dVar = new d((q.e) com.google.common.base.k.p(eVar, "helper"));
        this.f33557h = dVar;
        this.f33558i = new io.grpc.util.e(dVar);
        this.trackerMap = new c();
        this.f33556g = (N) com.google.common.base.k.p(eVar.d(), "syncContext");
        this.f33560k = (ScheduledExecutorService) com.google.common.base.k.p(eVar.c(), "timeService");
        this.f33559j = v0Var;
        b10.a(ChannelLogger.ChannelLogLevel.DEBUG, "OutlierDetection lb created.");
    }

    public static boolean m(List<C1114h> list) {
        Iterator<C1114h> it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().a().size();
            if (i10 > 1) {
                return false;
            }
        }
        return true;
    }

    public static List<b> n(c cVar, int i10) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : cVar.values()) {
            if (bVar.f() >= i10) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    @Override // io.grpc.q
    public Status a(q.h hVar) {
        Long valueOf;
        this.f33563n.b(ChannelLogger.ChannelLogLevel.DEBUG, "Received resolution result: {0}", hVar);
        C0316g c0316g = (C0316g) hVar.c();
        ArrayList arrayList = new ArrayList();
        Iterator<C1114h> it = hVar.a().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().a());
        }
        this.trackerMap.keySet().retainAll(arrayList);
        this.trackerMap.l(c0316g);
        this.trackerMap.i(c0316g, arrayList);
        this.f33558i.r(c0316g.f33586g.b());
        if (c0316g.a()) {
            if (this.f33562m == null) {
                valueOf = c0316g.f33580a;
            } else {
                valueOf = Long.valueOf(Math.max(0L, c0316g.f33580a.longValue() - (this.f33559j.a() - this.f33562m.longValue())));
            }
            N.d dVar = this.f33561l;
            if (dVar != null) {
                dVar.a();
                this.trackerMap.j();
            }
            this.f33561l = this.f33556g.d(new e(c0316g, this.f33563n), valueOf.longValue(), c0316g.f33580a.longValue(), TimeUnit.NANOSECONDS, this.f33560k);
        } else {
            N.d dVar2 = this.f33561l;
            if (dVar2 != null) {
                dVar2.a();
                this.f33562m = null;
                this.trackerMap.f();
            }
        }
        this.f33558i.d(hVar.e().d(c0316g.f33586g.a()).a());
        return Status.f32368e;
    }

    @Override // io.grpc.q
    public void c(Status status) {
        this.f33558i.c(status);
    }

    @Override // io.grpc.q
    public void f() {
        this.f33558i.f();
    }
}
