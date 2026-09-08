package io.grpc.internal;

import io.grpc.v;
import java.net.URI;

/* compiled from: NameResolverFactoryToProviderFacade.java */
/* loaded from: classes4.dex */
public class S extends io.grpc.w {

    /* renamed from: a, reason: collision with root package name */
    public v.d f32880a;

    public S(v.d dVar) {
        this.f32880a = dVar;
    }

    @Override // io.grpc.v.d
    public String a() {
        return this.f32880a.a();
    }

    @Override // io.grpc.v.d
    public io.grpc.v b(URI uri, v.b bVar) {
        return this.f32880a.b(uri, bVar);
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
