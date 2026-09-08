package io.grpc;

import io.grpc.Context;
import java.util.concurrent.TimeUnit;

/* compiled from: Server.java */
/* loaded from: classes4.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final Context.d<z> f33670a = Context.y("io.grpc.Server");

    public abstract boolean a(long j10, TimeUnit timeUnit);

    public abstract z b();

    public abstract z c();
}
