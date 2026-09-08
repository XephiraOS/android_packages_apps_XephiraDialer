package com.oplus.ocs.icdf.commonchannel;

import android.content.Context;
import com.oplus.ocs.icdf.BaseAgent;
import com.oplus.ocs.icdf.BaseJobAgent;
import com.oplus.ocs.icdf.a;
import com.oplus.ocs.icdf.commonchannel.oaf.f;
import com.oplus.ocs.icdf.model.PeerAgent;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private f f28455a;

    /* renamed from: b, reason: collision with root package name */
    private com.oplus.ocs.icdf.commonchannel.oaf.a f28456b;

    public a(Context context, BaseAgent baseAgent) {
        int serviceChannelId = baseAgent.getServiceChannelId(0);
        this.f28455a = new f(context, baseAgent, serviceChannelId);
        this.f28456b = new com.oplus.ocs.icdf.commonchannel.oaf.a(context, baseAgent, serviceChannelId);
    }

    public void a(a.c cVar) {
        f fVar = this.f28455a;
        if (fVar != null) {
            fVar.c();
            cVar.a(0, fVar);
        } else {
            cVar.a(1, null);
        }
    }

    public void b(PeerAgent peerAgent, int i10, a.b bVar) {
        this.f28456b.a((com.oplus.ocs.icdf.model.a) peerAgent, i10, bVar);
    }

    public a(Context context, BaseJobAgent baseJobAgent) {
        int serviceChannelId = baseJobAgent.getServiceChannelId(0);
        this.f28455a = new f(context, baseJobAgent, serviceChannelId);
        this.f28456b = new com.oplus.ocs.icdf.commonchannel.oaf.a(context, baseJobAgent, serviceChannelId);
    }

    public void a(PeerAgent peerAgent, int i10, int i11, a.b bVar) {
        this.f28456b.a((com.oplus.ocs.icdf.model.a) peerAgent, i10, i11, bVar);
    }

    public void a(PeerAgent peerAgent, int i10, a.b bVar) {
        this.f28456b.a((com.oplus.ocs.icdf.model.a) peerAgent, i10, 3, bVar);
    }

    public void a() {
        this.f28456b.a();
        this.f28455a.b();
    }
}
