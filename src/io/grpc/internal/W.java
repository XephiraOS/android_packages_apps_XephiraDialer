package io.grpc.internal;

import io.grpc.C1114h;
import io.grpc.ConnectivityState;
import io.grpc.Status;
import io.grpc.q;
import j9.C1201k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PickFirstLoadBalancer.java */
/* loaded from: classes4.dex */
public final class W extends io.grpc.q {

    /* renamed from: g, reason: collision with root package name */
    public final q.e f32990g;

    /* renamed from: h, reason: collision with root package name */
    public q.i f32991h;

    /* renamed from: i, reason: collision with root package name */
    public ConnectivityState f32992i = ConnectivityState.IDLE;

    /* compiled from: PickFirstLoadBalancer.java */
    /* loaded from: classes4.dex */
    public class a implements q.k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q.i f32993a;

        public a(q.i iVar) {
            this.f32993a = iVar;
        }

        @Override // io.grpc.q.k
        public void a(C1201k c1201k) {
            W.this.i(this.f32993a, c1201k);
        }
    }

    /* compiled from: PickFirstLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32995a;

        static {
            int[] iArr = new int[ConnectivityState.values().length];
            f32995a = iArr;
            try {
                iArr[ConnectivityState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32995a[ConnectivityState.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32995a[ConnectivityState.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32995a[ConnectivityState.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: PickFirstLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Boolean f32996a;

        /* renamed from: b, reason: collision with root package name */
        public final Long f32997b;

        public c(Boolean bool) {
            this(bool, null);
        }

        public c(Boolean bool, Long l10) {
            this.f32996a = bool;
            this.f32997b = l10;
        }
    }

    /* compiled from: PickFirstLoadBalancer.java */
    /* loaded from: classes4.dex */
    public static final class d extends q.j {

        /* renamed from: a, reason: collision with root package name */
        public final q.f f32998a;

        public d(q.f fVar) {
            this.f32998a = (q.f) com.google.common.base.k.p(fVar, "result");
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            return this.f32998a;
        }

        public String toString() {
            return com.google.common.base.f.b(d.class).d("result", this.f32998a).toString();
        }
    }

    /* compiled from: PickFirstLoadBalancer.java */
    /* loaded from: classes4.dex */
    public final class e extends q.j {

        /* renamed from: a, reason: collision with root package name */
        public final q.i f32999a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f33000b = new AtomicBoolean(false);

        /* compiled from: PickFirstLoadBalancer.java */
        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f32999a.f();
            }
        }

        public e(q.i iVar) {
            this.f32999a = (q.i) com.google.common.base.k.p(iVar, "subchannel");
        }

        @Override // io.grpc.q.j
        public q.f a(q.g gVar) {
            if (this.f33000b.compareAndSet(false, true)) {
                W.this.f32990g.d().execute(new a());
            }
            return q.f.g();
        }
    }

    public W(q.e eVar) {
        this.f32990g = (q.e) com.google.common.base.k.p(eVar, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(q.i iVar, C1201k c1201k) {
        q.j eVar;
        q.j jVar;
        ConnectivityState c10 = c1201k.c();
        if (c10 == ConnectivityState.SHUTDOWN) {
            return;
        }
        ConnectivityState connectivityState = ConnectivityState.TRANSIENT_FAILURE;
        if (c10 == connectivityState || c10 == ConnectivityState.IDLE) {
            this.f32990g.e();
        }
        if (this.f32992i == connectivityState) {
            if (c10 == ConnectivityState.CONNECTING) {
                return;
            }
            if (c10 == ConnectivityState.IDLE) {
                e();
                return;
            }
        }
        int i10 = b.f32995a[c10.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        jVar = new d(q.f.f(c1201k.d()));
                    } else {
                        throw new IllegalArgumentException("Unsupported state:" + c10);
                    }
                } else {
                    eVar = new d(q.f.h(iVar));
                }
            } else {
                jVar = new d(q.f.g());
            }
            j(c10, jVar);
        }
        eVar = new e(iVar);
        jVar = eVar;
        j(c10, jVar);
    }

    private void j(ConnectivityState connectivityState, q.j jVar) {
        this.f32992i = connectivityState;
        this.f32990g.f(connectivityState, jVar);
    }

    @Override // io.grpc.q
    public Status a(q.h hVar) {
        c cVar;
        Boolean bool;
        Random random;
        List<C1114h> a10 = hVar.a();
        if (a10.isEmpty()) {
            Status r10 = Status.f32383t.r("NameResolver returned no usable address. addrs=" + hVar.a() + ", attrs=" + hVar.b());
            c(r10);
            return r10;
        }
        if ((hVar.c() instanceof c) && (bool = (cVar = (c) hVar.c()).f32996a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(a10);
            if (cVar.f32997b != null) {
                random = new Random(cVar.f32997b.longValue());
            } else {
                random = new Random();
            }
            Collections.shuffle(arrayList, random);
            a10 = arrayList;
        }
        q.i iVar = this.f32991h;
        if (iVar == null) {
            q.i a11 = this.f32990g.a(q.b.d().e(a10).c());
            a11.h(new a(a11));
            this.f32991h = a11;
            j(ConnectivityState.CONNECTING, new d(q.f.h(a11)));
            a11.f();
        } else {
            iVar.i(a10);
        }
        return Status.f32368e;
    }

    @Override // io.grpc.q
    public void c(Status status) {
        q.i iVar = this.f32991h;
        if (iVar != null) {
            iVar.g();
            this.f32991h = null;
        }
        j(ConnectivityState.TRANSIENT_FAILURE, new d(q.f.f(status)));
    }

    @Override // io.grpc.q
    public void e() {
        q.i iVar = this.f32991h;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // io.grpc.q
    public void f() {
        q.i iVar = this.f32991h;
        if (iVar != null) {
            iVar.g();
        }
    }
}
