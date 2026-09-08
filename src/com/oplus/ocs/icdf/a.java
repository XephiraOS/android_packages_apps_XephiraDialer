package com.oplus.ocs.icdf;

import android.content.Context;
import com.oplus.ocs.icdf.commonchannel.CommonChannel;
import com.oplus.ocs.icdf.grpcchannel.inner.p;
import com.oplus.ocs.icdf.model.PeerAgent;
import io.grpc.z;
import j9.AbstractC1194d;
import j9.InterfaceC1192b;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private com.oplus.ocs.icdf.commonchannel.a f28452a;

    /* renamed from: b, reason: collision with root package name */
    private com.oplus.ocs.icdf.grpcchannel.b f28453b = new com.oplus.ocs.icdf.grpcchannel.b();

    /* renamed from: c, reason: collision with root package name */
    private com.oplus.ocs.icdf.grpcchannel.a f28454c;

    /* renamed from: com.oplus.ocs.icdf.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0265a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i10, CommonChannel commonChannel);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i10, com.oplus.ocs.icdf.commonchannel.b bVar);
    }

    /* loaded from: classes3.dex */
    public interface d extends InterfaceC0265a {
        void a(int i10, AbstractC1194d abstractC1194d);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i10, z zVar, com.oplus.ocs.icdf.grpcchannel.b bVar);
    }

    public a(Context context, BaseAgent baseAgent) {
        this.f28452a = new com.oplus.ocs.icdf.commonchannel.a(context, baseAgent);
        this.f28454c = new com.oplus.ocs.icdf.grpcchannel.a(this.f28452a);
    }

    public void a(String str, p pVar) {
        this.f28454c.a(str, pVar);
    }

    public void b(PeerAgent peerAgent, int i10, b bVar) {
        this.f28452a.b(peerAgent, i10, bVar);
    }

    public void a(InterfaceC1192b interfaceC1192b, e eVar) {
        this.f28453b.a(interfaceC1192b, eVar);
    }

    public void a(PeerAgent peerAgent, int i10, d dVar) {
        this.f28454c.a(peerAgent, i10, dVar);
    }

    public void a(PeerAgent peerAgent) {
        this.f28454c.a(peerAgent);
    }

    public a(Context context, BaseJobAgent baseJobAgent) {
        this.f28452a = new com.oplus.ocs.icdf.commonchannel.a(context, baseJobAgent);
        this.f28454c = new com.oplus.ocs.icdf.grpcchannel.a(this.f28452a);
    }

    public void a(PeerAgent peerAgent, c cVar) {
        this.f28452a.a(cVar);
    }

    public void a(PeerAgent peerAgent, int i10, b bVar) {
        this.f28452a.a(peerAgent, i10, bVar);
    }

    public void a() {
        this.f28452a.a();
        this.f28454c.a();
        this.f28453b.a();
    }
}
