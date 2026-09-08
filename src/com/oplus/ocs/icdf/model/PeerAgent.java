package com.oplus.ocs.icdf.model;

import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class PeerAgent {
    protected String appName;
    protected String appOrn;
    protected PeerAccessory peerAccessory;
    protected String serviceType;
    protected String serviceUrn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PeerAgent peerAgent = (PeerAgent) obj;
        if (Objects.equals(this.appOrn, peerAgent.appOrn) && Objects.equals(getPeerAccessory().getDeviceOrn(), peerAgent.getPeerAccessory().getDeviceOrn()) && Objects.equals(getServiceUrn(), peerAgent.getServiceUrn())) {
            return true;
        }
        return false;
    }

    public abstract String getAgentId();

    public String getAppName() {
        return this.appName;
    }

    public String getAppOrn() {
        return this.appOrn;
    }

    public PeerAccessory getPeerAccessory() {
        return this.peerAccessory;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public String getServiceUrn() {
        return this.serviceUrn;
    }

    public int hashCode() {
        return Objects.hash(this.appOrn, getPeerAccessory().getDeviceOrn(), getServiceUrn());
    }

    public boolean isOafPeerAgent() {
        return this instanceof a;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppOrn(String str) {
        this.appOrn = str;
    }

    public void setPeerAccessory(PeerAccessory peerAccessory) {
        this.peerAccessory = peerAccessory;
    }

    public void setServiceType(String str) {
        this.serviceType = str;
    }

    public void setServiceUrn(String str) {
        this.serviceUrn = str;
    }

    public String toString() {
        return "PeerAgent - appName: " + this.appName + ", serviceUrn: " + this.serviceUrn + ", serviceType: " + this.serviceType + ", " + this.peerAccessory.toString();
    }
}
