package com.oplus.ocs.icdf.grpcchannel.inner;

import java.net.SocketAddress;

/* loaded from: classes3.dex */
public final class g extends SocketAddress {

    /* renamed from: a, reason: collision with root package name */
    private final String f28673a;

    public g(String str) {
        this.f28673a = (String) com.google.common.base.k.p(str, "name");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f28673a.equals(((g) obj).f28673a);
    }

    public int hashCode() {
        return this.f28673a.hashCode();
    }

    public String toString() {
        return this.f28673a;
    }
}
