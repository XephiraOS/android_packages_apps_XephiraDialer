package com.oplus.ocs.icdf.grpcchannel;

import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.grpcchannel.inner.k;
import com.oplus.ocs.icdf.grpcchannel.inner.l;
import com.oplus.ocs.icdf.utils.logging.ICDFLog;
import io.grpc.z;
import j9.InterfaceC1192b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private com.oplus.ocs.icdf.grpcchannel.inner.a f28608b;

    /* renamed from: c, reason: collision with root package name */
    private z f28609c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<CommonChannel> f28610d = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private final l f28607a = l.a("icdfchannel").a(new a());

    /* loaded from: classes3.dex */
    public class a implements k {
        public a() {
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.k
        public void a(com.oplus.ocs.icdf.grpcchannel.inner.a aVar) {
            b.this.a(aVar);
        }

        @Override // com.oplus.ocs.icdf.grpcchannel.inner.k
        public void a() {
            synchronized (b.this) {
                b.a(b.this, (com.oplus.ocs.icdf.grpcchannel.inner.a) null);
            }
        }
    }

    public static /* synthetic */ com.oplus.ocs.icdf.grpcchannel.inner.a a(b bVar, com.oplus.ocs.icdf.grpcchannel.inner.a aVar) {
        bVar.f28608b = null;
        return null;
    }

    public void a(InterfaceC1192b interfaceC1192b, a.e eVar) {
        if (this.f28609c == null) {
            z build = this.f28607a.addService(interfaceC1192b).build();
            try {
                build.c();
            } catch (IOException e10) {
                ICDFLog.e("ICDF.GrpcServerAdapter", "start server exception: " + e10);
            }
            this.f28609c = build;
        }
        z zVar = this.f28609c;
        eVar.a(zVar != null ? 0 : 1, zVar, this);
    }

    public synchronized void a(CommonChannel commonChannel) {
        try {
            com.oplus.ocs.icdf.grpcchannel.inner.a aVar = this.f28608b;
            if (aVar != null) {
                aVar.a(commonChannel);
            } else {
                this.f28610d.add(commonChannel);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(com.oplus.ocs.icdf.grpcchannel.inner.a aVar) {
        try {
            this.f28608b = aVar;
            for (int i10 = 0; i10 < this.f28610d.size(); i10++) {
                this.f28608b.a(this.f28610d.get(i10));
            }
            this.f28610d.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public void a() {
        ICDFLog.i("ICDF.GrpcServerAdapter", "close. ");
        z zVar = this.f28609c;
        if (zVar != null) {
            try {
                ICDFLog.d("ICDF.GrpcServerAdapter", "shutdown gRPC server, status " + zVar.b().a(500L, TimeUnit.MILLISECONDS));
                this.f28609c = null;
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
    }
}
