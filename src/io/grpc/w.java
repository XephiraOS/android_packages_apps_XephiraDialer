package io.grpc;

import io.grpc.v;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;

/* compiled from: NameResolverProvider.java */
/* loaded from: classes4.dex */
public abstract class w extends v.d {
    public Collection<Class<? extends SocketAddress>> c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    public String d() {
        return a();
    }

    public abstract boolean e();

    public abstract int f();
}
