package com.oplus.ocs.icdf.grpcchannel.inner;

import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.grpcchannel.inner.m;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import io.grpc.internal.H;
import io.grpc.internal.U;
import io.grpc.internal.k0;
import j9.J;
import j9.v;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public class j implements H {

    /* renamed from: a, reason: collision with root package name */
    private final String f28682a;

    /* renamed from: b, reason: collision with root package name */
    private final k f28683b;

    /* renamed from: c, reason: collision with root package name */
    private final List<J.a> f28684c;

    /* renamed from: d, reason: collision with root package name */
    private final U<ScheduledExecutorService> f28685d;

    /* renamed from: e, reason: collision with root package name */
    private ScheduledExecutorService f28686e;

    /* renamed from: f, reason: collision with root package name */
    private k0 f28687f;

    /* renamed from: g, reason: collision with root package name */
    private final Set<m> f28688g = new CopyOnWriteArraySet();

    /* renamed from: h, reason: collision with root package name */
    private final m.d f28689h = new a();

    /* loaded from: classes3.dex */
    public class a implements m.d {
        public a() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements com.oplus.ocs.icdf.grpcchannel.inner.a {
        public b() {
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.a
        public void a(CommonChannel commonChannel) {
            ICDFLog.i("ICDF.GrpcServer", "CommonChannel ready, create GrpcServerTransport");
            m mVar = new m(j.this.f28682a, commonChannel, j.this.f28689h, j.this.f28685d, j.this.f28684c);
            mVar.a(j.this.f28687f.b(mVar));
            j.this.f28688g.add(mVar);
        }
    }

    public j(l lVar, List<? extends J.a> list) {
        this.f28684c = Collections.unmodifiableList((List) com.google.common.base.k.p(list, "streamTracerFactories"));
        this.f28682a = lVar.f28693b;
        this.f28683b = lVar.f28694c;
        this.f28685d = lVar.f28695d;
    }

    public SocketAddress getListenSocketAddress() {
        return new g(this.f28682a);
    }

    @Override // io.grpc.internal.H
    public List<? extends SocketAddress> getListenSocketAddresses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new g(this.f28682a));
        return arrayList;
    }

    public v<Object> getListenSocketStats() {
        return null;
    }

    public List<v<Object>> getListenSocketStatsList() {
        return null;
    }

    @Override // io.grpc.internal.H
    public void shutdown() {
        this.f28686e = this.f28685d.b(this.f28686e);
        this.f28687f.a();
        synchronized (this) {
            try {
                k kVar = this.f28683b;
                if (kVar != null) {
                    kVar.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.grpc.internal.H
    public void start(k0 k0Var) {
        ICDFLog.i("ICDF.GrpcServer", "start");
        this.f28687f = k0Var;
        this.f28686e = this.f28685d.a();
        this.f28683b.a(new b());
    }

    public String toString() {
        return com.google.common.base.f.c(this).d("name", this.f28682a).toString();
    }
}
