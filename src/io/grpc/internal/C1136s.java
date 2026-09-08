package io.grpc.internal;

import io.grpc.v;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collection;
import java.util.Collections;

/* compiled from: DnsNameResolverProvider.java */
/* renamed from: io.grpc.internal.s, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1136s extends io.grpc.w {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f33393a = io.grpc.o.a(C1136s.class.getClassLoader());

    @Override // io.grpc.v.d
    public String a() {
        return "dns";
    }

    @Override // io.grpc.v.d
    public io.grpc.v b(URI uri, v.b bVar) {
        if ("dns".equals(uri.getScheme())) {
            String str = (String) com.google.common.base.k.p(uri.getPath(), "targetPath");
            com.google.common.base.k.l(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
            return new DnsNameResolver(uri.getAuthority(), str.substring(1), bVar, GrpcUtil.f32539u, com.google.common.base.m.c(), f33393a);
        }
        return null;
    }

    @Override // io.grpc.w
    public Collection<Class<? extends SocketAddress>> c() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // io.grpc.w
    public boolean e() {
        return true;
    }

    @Override // io.grpc.w
    public int f() {
        return 5;
    }
}
