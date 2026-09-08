package com.oplus.ocs.icdf.model;

import com.oplus.ocs.icdf.BaseAgent;
import com.oplus.ocs.icdf.BaseJobAgent;

/* loaded from: classes3.dex */
public class a extends PeerAgent {

    /* renamed from: a, reason: collision with root package name */
    private com.heytap.accessory.bean.PeerAgent f28766a;

    public a(BaseAgent baseAgent, com.heytap.accessory.bean.PeerAgent peerAgent, int i10) {
        setAppName(peerAgent.getAppName());
        setAppOrn(peerAgent.getAppHash());
        setServiceUrn(peerAgent.getAgentId());
        setServiceType(peerAgent.getAgentId());
        setPeerAccessory(new PeerAccessory(peerAgent.getAccessory()));
        a(peerAgent);
    }

    public void a(com.heytap.accessory.bean.PeerAgent peerAgent) {
        this.f28766a = peerAgent;
    }

    @Override // com.oplus.ocs.icdf.model.PeerAgent
    public String getAgentId() {
        return this.f28766a.getAgentId();
    }

    public com.heytap.accessory.bean.PeerAgent a() {
        return this.f28766a;
    }

    public a(BaseJobAgent baseJobAgent, com.heytap.accessory.bean.PeerAgent peerAgent, int i10) {
        setAppName(peerAgent.getAppName());
        setAppOrn(peerAgent.getAppHash());
        setServiceUrn(peerAgent.getAgentId());
        setServiceType(peerAgent.getAgentId());
        setPeerAccessory(new PeerAccessory(peerAgent.getAccessory()));
        a(peerAgent);
    }
}
