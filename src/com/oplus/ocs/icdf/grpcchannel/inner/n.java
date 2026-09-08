package com.oplus.ocs.icdf.grpcchannel.inner;

import com.oplus.ocs.icdf.model.PeerAgent;
import java.net.SocketAddress;

/* loaded from: classes3.dex */
public final class n extends SocketAddress {

    /* renamed from: a, reason: collision with root package name */
    private final PeerAgent f28731a;

    public n(PeerAgent peerAgent) {
        this.f28731a = (PeerAgent) com.google.common.base.k.p(peerAgent, "peerAgent");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        return this.f28731a.equals(((n) obj).f28731a);
    }

    public int hashCode() {
        return this.f28731a.hashCode();
    }

    public String toString() {
        return this.f28731a.toString();
    }
}
